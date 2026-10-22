package com.alipay.sdk.m.n;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes28.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25616a = "DESede/CBC/PKCS5Padding";

    public e() {
    }

    public static byte[] a(String r100, byte[] r101, String r102) {
        SecretKeySpec r103 = new SecretKeySpec(r100.getBytes(), "DESede");     // Catch: Exception -> L4
        Cipher r104 = Cipher.getInstance(f25616a);     // Catch: Exception -> L4
        r104.init(2, r103, new IvParameterSpec(c.a(r104, r102)));     // Catch: Exception -> L4
        return r104.doFinal(r101);
    L4:
        return null;
    }

    public static byte[] b(String r100, byte[] r101, String r102) {
        SecretKeySpec r103 = new SecretKeySpec(r100.getBytes(), "DESede");     // Catch: Exception -> L4
        Cipher r104 = Cipher.getInstance(f25616a);     // Catch: Exception -> L4
        r104.init(1, r103, new IvParameterSpec(c.a(r104, r102)));     // Catch: Exception -> L4
        return r104.doFinal(r101);
    L4:
        return null;
    }

    public static String a(String r100, String r101, String r102) {
        return new String(a(r100, a.a(r101), r102));
    L4:
        return null;
    }

    public static String b(String r100, String r101, String r102) {
        return a.a(b(r100, r101.getBytes(), r102));
    L4:
        return null;
    }
}
