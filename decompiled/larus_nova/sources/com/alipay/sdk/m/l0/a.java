package com.alipay.sdk.m.l0;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes28.dex */
public class a {
    public static byte[] a() throws Exception {
        return e.a(new byte[]{33, 83, -50, -89, -84, -114, 80, 99, 10, 63, 22, -65, -11, 30, 101, -118});
    }

    public static byte[] b() {
        byte[] r100 = b.a("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);     // Catch: Exception -> L8
        if (r100 == null) goto L7;
        return e.a(r100);
    L7:
        return new byte[16];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m8016a(String r100) {
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = r103 * 2;
        r102[r103] = CastIntegerProtector.valueOf(r100.substring(r104, r104 + 2), 16).byteValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static String b(String r100) {
        return new String(b(a(), m8016a(r100)));
    L4:
        return null;
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuffer r101 = new StringBuffer(r100.length * 2);
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L10;
        a(r101, r100[r102]);
        r102 = r102 + 1;
        goto L7
    L10:
        return r101.toString();
    }

    public static String a(String r100) {
        byte[] r101 = a(a(), r100.getBytes());     // Catch: Exception -> L5
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return a(r101);
    L5:
        r101 = null;
        goto L6
    }

    public static byte[] a(byte[] r100, byte[] r101) throws Exception {
        SecretKeySpec r102 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r103.init(1, r102, new IvParameterSpec(b()));
        return r103.doFinal(r101);
    }

    public static byte[] b(byte[] r100, byte[] r101) throws Exception {
        SecretKeySpec r102 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r103.init(2, r102, new IvParameterSpec(b()));
        return r103.doFinal(r101);
    }

    public static void a(StringBuffer r100, byte r101) {
        r100.append("0123456789ABCDEF".charAt((r101 >> 4) & 15));
        r100.append("0123456789ABCDEF".charAt(r101 & 15));
    }
}
