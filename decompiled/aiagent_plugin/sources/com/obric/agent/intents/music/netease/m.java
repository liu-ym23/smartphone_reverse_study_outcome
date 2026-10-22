package com.obric.agent.intents.music.netease;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: RSAUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static String a(byte[] r2, String r3) {
        PKCS8EncodedKeySpec r1 = new PKCS8EncodedKeySpec(Base64.decode(r3, 0));
        PrivateKey r4 = KeyFactory.getInstance("RSA").generatePrivate(r1);
        Signature r5 = Signature.getInstance("SHA256withRSA");
        r5.initSign(r4);
        r5.update(r2);
        return Base64.encodeToString(r5.sign(), 0);
    }

    public static byte[] b(byte[] r8, String r9) {
        PublicKey r10 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(r9, 0)));
        Cipher r1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r1.init(1, r10);
        int r11 = r8.length;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        int r4 = 0;
        int r5 = 0;
    L3:
        int r6 = r11 - r4;
        if (r6 <= 0) goto L10;
        if (r6 <= 245) goto L8;
        byte[] r7 = r1.doFinal(r8, r4, 245);
    L9:
        r3.write(r7, 0, r7.length);
        r5 = r5 + 1;
        r4 = r5 * 245;
        goto L3
    L8:
        r7 = r1.doFinal(r8, r4, r6);
        goto L9
    L10:
        byte[] r12 = r3.toByteArray();
        r3.close();
        return r12;
    }

    public static byte[] c(byte[] r7, String r8) {
        PrivateKey r9 = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(r8, 0)));
        Cipher r1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r1.init(2, r9);
        int r10 = r7.length;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        int r3 = 0;
        int r4 = 0;
    L3:
        int r5 = r10 - r3;
        if (r5 <= 0) goto L10;
        if (r5 <= 256) goto L8;
        byte[] r6 = r1.doFinal(r7, r3, 256);
    L9:
        r2.write(r6, 0, r6.length);
        r4 = r4 + 1;
        r3 = r4 * 256;
        goto L3
    L8:
        r6 = r1.doFinal(r7, r3, r5);
        goto L9
    L10:
        byte[] r11 = r2.toByteArray();
        r2.close();
        return r11;
    }

    public static boolean a(byte[] r2, String r3, String r4) {
        X509EncodedKeySpec r1 = new X509EncodedKeySpec(Base64.decode(r3, 0));
        PublicKey r5 = KeyFactory.getInstance("RSA").generatePublic(r1);
        Signature r6 = Signature.getInstance("SHA256withRSA");
        r6.initVerify(r5);
        r6.update(r2);
        return r6.verify(Base64.decode(r4, 0));
    }
}
