package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes39.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static KeyPair f30484a;

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return null;
    L5:
        if (f30484a == null) goto L11;
        Cipher r101 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L9
        r101.init(1, f30484a.getPrivate());     // Catch: Exception -> L9
        return c.a(r101.doFinal(r100.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8.name());
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static KeyPair a() {
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a);     // Catch: Exception -> L7
        r100.initialize(2048, new SecureRandom());     // Catch: Exception -> L7
        if (f30484a != null) goto L5;
        f30484a = r100.generateKeyPair();     // Catch: Exception -> L7
    L5:
        return f30484a;
    L7:
        return null;
    }

    public static String b() {
        KeyPair r100 = f30484a;
        if (r100 != null) goto L5;
        return null;
    L5:
        PublicKey r101 = r100.getPublic();
        if (r101 != null) goto L11;
        return null;
    L11:
        return c.a(r101.getEncoded(), StandardCharsets.UTF_8.name());
    L10:
        return null;
    }

    public static byte[] b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return null;
    L5:
        if (f30484a == null) goto L11;
        byte[] r101 = c.a(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L9
        Cipher r102 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L9
        r102.init(2, f30484a.getPrivate());     // Catch: Exception -> L9
        return r102.doFinal(r101);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
