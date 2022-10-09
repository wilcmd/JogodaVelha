
package dominio;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author wilqu
 */
public class JanelaJogar extends javax.swing.JFrame {

    private boolean matrixdeSelecao[][] = new boolean[3][3];  //matriz que verifivar qual item selecionado
    private int matrizGanhador[][] = new int[3][3]; // matriz que erificaro o ganhador 
    private String userselecionado = "usuario1";
    private String usuario1, usuario2;
     private int qtdoUsuario1, qtdoUsuario2, qtdoEmpate;
    

    public JanelaJogar(String usuario1, String usuario2) {
        this.usuario1 =  usuario1;
        this.usuario2 =  usuario2;
        
        initComponents();
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MatrizSelecionada();
        MatrizGanhador();
    }

    private void MatrizSelecionada() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                matrixdeSelecao[i][j] = true;
            }

        }

    }
    private void MatrizGanhador(){
    for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

               matrizGanhador[i][j] = 0;
            }

        }
    }

    private void ValidandoGanhador() {

        boolean ganhador1 = false;
        boolean ganhador2 = false;
        int empate = 0;

        ganhador1 = PosicaoParaGanhar(1);
        ganhador2 = PosicaoParaGanhar(2);

        if (ganhador1 == true) {
            qtdoUsuario1++;
            JanelaVencedor JV =new JanelaVencedor(this,true, usuario1); // Chamando a janela do Vencdor
            JV.setVisible(true);
            Reiniciar();

        } else if (ganhador2 == true) {
          qtdoUsuario2++; 

            JanelaVencedor JV =new JanelaVencedor(this, true,usuario2); // Chamando a janela do Vencdor
            JV.setVisible(true);
            Reiniciar();

        } else {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (matrizGanhador[i][j] != 0) {
                        empate++;
                    }
                }

            }
            if (empate == 9) {
                qtdoEmpate++;
                JanelaEmpate JE = new JanelaEmpate(this,true); // Chamando a janela do Empate
                JE.setVisible(true);                
                Reiniciar();
                
            } else {

                empate = 0;
                
            }

        }

    }

    private boolean PosicaoParaGanhar(int num) {

        boolean ganhador = false;

        if (matrizGanhador[0][0] == num && matrizGanhador[0][1] == num && matrizGanhador[0][2] == num) {
            ganhador = true;
        } else if (matrizGanhador[1][0] == num && matrizGanhador[1][1] == num && matrizGanhador[1][2] == num) {
            ganhador = true;
        } else if (matrizGanhador[2][0] == num && matrizGanhador[2][1] == num && matrizGanhador[2][2] == num) {
            ganhador = true;
        } else if (matrizGanhador[0][0] == num && matrizGanhador[1][0] == num && matrizGanhador[2][0] == num) {
            ganhador = true;
        } else if (matrizGanhador[0][1] == num && matrizGanhador[1][1] == num && matrizGanhador[2][1] == num) {
            ganhador = true;
        } else if (matrizGanhador[0][2] == num && matrizGanhador[1][2] == num && matrizGanhador[2][2] == num) {
            ganhador = true;
        } else if (matrizGanhador[0][0] == num && matrizGanhador[1][1] == num && matrizGanhador[2][2] == num) {
            ganhador = true;
        } else if (matrizGanhador[0][2] == num && matrizGanhador[1][1] == num && matrizGanhador[2][0] == num) {
            ganhador = true;
        }

        return ganhador;

    }
    
    private void Reiniciar(){
       MatrizSelecionada();
       MatrizGanhador();
        
        posicao00.setIcon(null);
        posicao01.setIcon(null);
        posicao02.setIcon(null);
        posicao10.setIcon(null);
        posicao11.setIcon(null);
        posicao12.setIcon(null);
        posicao20.setIcon(null);
        posicao21.setIcon(null);
        posicao22.setIcon(null);
        
        QuemjogaPrimeio();
        
    //
    }
    
    
    private void QuemjogaPrimeio(){
        JanelaQuemJogaPrimeiro jp = new JanelaQuemJogaPrimeiro(this, true, usuario1, usuario2);
        jp.setVisible(true);
        userselecionado = jp.getUserselecionado();
        
    }
    

    // método que colocar image 
    private void Bola(JButton bola) {

        bola.setIcon(new ImageIcon(getClass().getResource("/imagem/o.png")));
    }

    private void Letra(JButton letra) {

        letra.setIcon(new ImageIcon(getClass().getResource("/imagem/x.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        posicao00 = new javax.swing.JButton();
        posicao01 = new javax.swing.JButton();
        posicao02 = new javax.swing.JButton();
        posicao10 = new javax.swing.JButton();
        posicao11 = new javax.swing.JButton();
        posicao12 = new javax.swing.JButton();
        posicao20 = new javax.swing.JButton();
        posicao21 = new javax.swing.JButton();
        posicao22 = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        menuJogar = new javax.swing.JMenu();
        comecarJogar = new javax.swing.JMenuItem();
        placar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        sair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");

        painel.setLayout(new java.awt.GridLayout(3, 3));

        posicao00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao00ActionPerformed(evt);
            }
        });
        painel.add(posicao00);

        posicao01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao01ActionPerformed(evt);
            }
        });
        painel.add(posicao01);

        posicao02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao02ActionPerformed(evt);
            }
        });
        painel.add(posicao02);

        posicao10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao10ActionPerformed(evt);
            }
        });
        painel.add(posicao10);

        posicao11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao11ActionPerformed(evt);
            }
        });
        painel.add(posicao11);

        posicao12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao12ActionPerformed(evt);
            }
        });
        painel.add(posicao12);

        posicao20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao20ActionPerformed(evt);
            }
        });
        painel.add(posicao20);

        posicao21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao21ActionPerformed(evt);
            }
        });
        painel.add(posicao21);

        posicao22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicao22ActionPerformed(evt);
            }
        });
        painel.add(posicao22);

        menuJogar.setText("Jogar");
        menuJogar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        comecarJogar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        comecarJogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/play.png"))); // NOI18N
        comecarJogar.setText("ComecarJogo");
        comecarJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comecarJogarActionPerformed(evt);
            }
        });
        menuJogar.add(comecarJogar);

        placar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        placar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/bancoDados.png"))); // NOI18N
        placar.setText("Placar");
        placar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placarActionPerformed(evt);
            }
        });
        menuJogar.add(placar);
        menuJogar.add(jSeparator1);

        sair.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/sair.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        menuJogar.add(sair);

        BarraMenu.add(menuJogar);

        menuAjuda.setText("Ajuda");
        menuAjuda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        menuAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAjudaMouseClicked(evt);
            }
        });
        BarraMenu.add(menuAjuda);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void placarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placarActionPerformed
        JanelaPlacar jp = new JanelaPlacar(this, true, usuario1, usuario2, qtdoUsuario1, qtdoUsuario2, qtdoEmpate);
        jp.setVisible(true);
        
    }//GEN-LAST:event_placarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void posicao00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao00ActionPerformed
        if (matrixdeSelecao[0][0] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao00);
                matrizGanhador[0][0] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao00);
                matrizGanhador[0][0] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[0][0] = false;
        ValidandoGanhador();

    }//GEN-LAST:event_posicao00ActionPerformed

    private void posicao01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao01ActionPerformed

        if (matrixdeSelecao[0][1] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao01);
                matrizGanhador[0][1] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao01);
                matrizGanhador[0][1] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[0][1] = false;
        ValidandoGanhador();


    }//GEN-LAST:event_posicao01ActionPerformed

    private void posicao02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao02ActionPerformed
        if (matrixdeSelecao[0][2] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao02);
                matrizGanhador[0][2] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao02);
                matrizGanhador[0][2] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[0][2] = false;
        ValidandoGanhador();

    }//GEN-LAST:event_posicao02ActionPerformed

    private void posicao10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao10ActionPerformed
        if (matrixdeSelecao[1][0] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao10);
                matrizGanhador[1][0] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao10);
                matrizGanhador[1][0] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[1][0] = false;
        ValidandoGanhador();
    }//GEN-LAST:event_posicao10ActionPerformed

    private void posicao11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao11ActionPerformed
        if (matrixdeSelecao[1][1] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao11);
                matrizGanhador[1][1] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao11);
                matrizGanhador[1][1] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[1][1] = false;
        ValidandoGanhador();
    }//GEN-LAST:event_posicao11ActionPerformed

    private void posicao12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao12ActionPerformed
        if (matrixdeSelecao[1][2] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao12);
                matrizGanhador[1][2] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao12);
                matrizGanhador[1][2] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[1][2] = false;
        ValidandoGanhador();

    }//GEN-LAST:event_posicao12ActionPerformed

    private void posicao20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao20ActionPerformed
        if (matrixdeSelecao[2][0] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao20);
                matrizGanhador[2][0] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao20);
                matrizGanhador[2][0] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[2][0] = false;
        ValidandoGanhador();

    }//GEN-LAST:event_posicao20ActionPerformed

    private void posicao21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao21ActionPerformed
        if (matrixdeSelecao[2][1] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao21);
                matrizGanhador[2][1] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao21);
                matrizGanhador[2][1] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[2][1] = false;
        ValidandoGanhador();
    }//GEN-LAST:event_posicao21ActionPerformed

    private void posicao22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicao22ActionPerformed
        if (matrixdeSelecao[2][2] == true) {

            if (userselecionado.equals("usuario1")) {
                Bola(posicao22);
                matrizGanhador[2][2] = 1;
                userselecionado ="usuario2";

            } else {

                Letra(posicao22);
                matrizGanhador[2][2] = 2;
                userselecionado ="usuario1";

            }
        }
        matrixdeSelecao[2][2] = false;
        ValidandoGanhador();
    }//GEN-LAST:event_posicao22ActionPerformed

    private void comecarJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comecarJogarActionPerformed
        qtdoUsuario1=0; qtdoUsuario2 =0; qtdoEmpate = 0;
        Reiniciar();
       
        
    }//GEN-LAST:event_comecarJogarActionPerformed

    private void menuAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAjudaMouseClicked
        try {
            Desktop.getDesktop().browse(new URI ("https://docs.oracle.com/javase/7/docs/api/"));
        } catch (URISyntaxException ex) {
           // Logger.getLogger(JanelaJogar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
         //   Logger.getLogger(JanelaJogar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuAjudaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaJogar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaJogar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaJogar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaJogar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaJogar(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenuItem comecarJogar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuJogar;
    private javax.swing.JPanel painel;
    private javax.swing.JMenuItem placar;
    private javax.swing.JButton posicao00;
    private javax.swing.JButton posicao01;
    private javax.swing.JButton posicao02;
    private javax.swing.JButton posicao10;
    private javax.swing.JButton posicao11;
    private javax.swing.JButton posicao12;
    private javax.swing.JButton posicao20;
    private javax.swing.JButton posicao21;
    private javax.swing.JButton posicao22;
    private javax.swing.JMenuItem sair;
    // End of variables declaration//GEN-END:variables
}
