package com.baidu.bbalbscesium.m;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f30399a = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30400b = "AES";

    private a() {
    }

    public static byte[] a(String r100, String r101, byte[] r102) throws Exception {
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes(), "AES");
        Cipher r104 = Cipher.getInstance(f30399a);
        r104.init(2, r103, new IvParameterSpec(r100.getBytes()));
        return r104.doFinal(r102);
    }

    public static byte[] b(String r100, String r101, byte[] r102) throws Exception {
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes(), "AES");
        Cipher r104 = Cipher.getInstance(f30399a);
        r104.init(1, r103, new IvParameterSpec(r100.getBytes()));
        return r104.doFinal(r102);
    }
}
