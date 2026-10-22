package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static KeyPair f4964a;

    public static String a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (!TextUtils.isEmpty(str) && f4964a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f4964a.getPrivate());
                Charset charset = StandardCharsets.UTF_8;
                return c.a(cipher.doFinal(str.getBytes(charset)), charset.name());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static String b() {
        PublicKey publicKey;
        KeyPair keyPair = f4964a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return c.a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    public static KeyPair a() throws NoSuchAlgorithmException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (f4964a == null) {
                f4964a = keyPairGenerator.generateKeyPair();
            }
            return f4964a;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (!TextUtils.isEmpty(str) && f4964a != null) {
            try {
                byte[] bArrA = c.a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, f4964a.getPrivate());
                return cipher.doFinal(bArrA);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }
}
