package com.amap.api.col.s;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f26367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f26368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int[] f26369c;

    private static int a(int r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r103 = (r103 >> 1) | Integer.MIN_VALUE;
        r102 = r102 + 1;
        goto L3
    L5:
        int r104 = (r100 & r103) >>> (32 - r101);
        return (r100 << r101) | r104;
    }

    private static int b(int r100) {
        int r101 = 0;
        int r102 = 1;
    L4:
        if (r101 >= 15) goto L6;
        r102 = (r102 << 2) | 1;
        r101 = r101 + 1;
        goto L4
    L6:
        int r103 = ((r102 << 1) & r100) >>> 1;
        return ((r100 & r102) << 1) | r103;
    }

    static {
        f26368b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
        f26369c = null;
    }

    public static String a() {
        SecureRandom r100 = new SecureRandom();
        KeyGenerator r101 = KeyGenerator.getInstance(bs.c("EQUVT"));     // Catch: Throwable -> L5
        r101.init(128, r100);     // Catch: Throwable -> L5
        return bv.a(r101.generateKey().getEncoded());
    L5:
        return null;
    }

    private static int[] b() {
        int[] r100 = f26369c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        int[] r101 = new int[8];
        int r102 = 0;
    L6:
        String[] r103 = f26368b;
        if (r102 >= r103.length) goto L9;
        byte[] r104 = bn.b(r103[r102]);
        int r105 = ((r104[3] & UByte.MAX_VALUE) | ((r104[2] & UByte.MAX_VALUE) << 8)) | ((r104[1] & UByte.MAX_VALUE) << 16);
        r101[r102] = ((r104[0] & UByte.MAX_VALUE) << 24) | r105;
        r102 = r102 + 1;
        goto L6
    L9:
        return r101;
    }

    private static byte[] a(byte[] r100) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f26367a != null) goto L5;
        f26367a = bs.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L7
    L5:
        IvParameterSpec r101 = new IvParameterSpec(f26367a);     // Catch: Exception -> L7
        SecretKeySpec r102 = new SecretKeySpec(a(b()).getBytes("UTF-8"), bs.c("EQUVT"));     // Catch: Exception -> L7
        Cipher r103 = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L7
        r103.init(1, r102, r101);     // Catch: Exception -> L7
        return r103.doFinal(r100);
    }

    public static String b(String r100) {
        return bv.a(a(r100.getBytes("UTF-8")));
    L4:
        return null;
    }

    private static String a(int r100) {
        char[] r101 = new char[4];
        int r102 = 0;
    L3:
        if (r102 >= 4) goto L10;
        char r103 = (char) ((r100 >>> (r102 * 8)) & 255);
        r101[(4 - r102) - 1] = r103;
        String r104 = " ";
        int r105 = 0;
    L6:
        if (r105 >= 32) goto L8;
        r104 = r104 + (((Integer.MIN_VALUE >>> r105) & r103) >>> (31 - r105));
        r105 = r105 + 1;
        goto L6
    L8:
        r102 = r102 + 1;
        goto L3
    L10:
        return new String(r101);
    }

    private static String a(int[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L9;
        r101.append(a(a(b(r100[r102]), r102)));
        r102 = r102 + 1;
    L9:
        return r101.toString();
    }

    public static String a(String r100) {
        return bq.a(r100);
    }
}
