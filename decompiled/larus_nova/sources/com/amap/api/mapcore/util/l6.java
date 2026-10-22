package com.amap.api.mapcore.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f27525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f27526b;

    static {
        f27526b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    }

    private static String a(int[] r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= r110.length) goto L22;
        int r102 = r110[r101];
        int r103 = 0;
        int r104 = 1;
    L7:
        if (r103 >= 15) goto L9;
        r104 = (r104 << 2) | 1;
        r103 = r103 + 1;
        goto L7
    L9:
        int r105 = ((r102 & r104) << 1) | (((r104 << 1) & r102) >>> 1);
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r106 >= r101) goto L13;
        r107 = (r107 >> 1) | Integer.MIN_VALUE;
        r106 = r106 + 1;
        goto L11
    L13:
        int r108 = (r105 << r101) | ((r105 & r107) >>> (32 - r101));
        char[] r109 = new char[4];
        int r111 = 0;
    L14:
        if (r111 >= 4) goto L20;
        char r112 = (char) ((r108 >>> (r111 * 8)) & 255);
        r109[(4 - r111) - 1] = r112;
        String r113 = " ";
        int r114 = 0;
    L17:
        if (r114 >= 32) goto L19;
        r113 = r113 + (((Integer.MIN_VALUE >>> r114) & r112) >>> (31 - r114));
        r114 = r114 + 1;
        goto L17
    L19:
        r111 = r111 + 1;
        goto L14
    L20:
        r100.append(new String(r109));
        r101 = r101 + 1;
        goto L4
    L22:
        return r100.toString();
    }

    public static String b(String r100) {
        return h6.a(a(r100.getBytes("UTF-8")));
    L4:
        return null;
    }

    private static byte[] a(byte[] r100) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f27525a != null) goto L5;
        f27525a = x5.b("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L11
    L5:
        IvParameterSpec r101 = new IvParameterSpec(f27525a);     // Catch: Exception -> L11
        int[] r102 = new int[8];     // Catch: Exception -> L11
        int r103 = 0;
    L6:
        String[] r104 = f27526b;     // Catch: Exception -> L11
        if (r103 >= r104.length) goto L9;
        byte[] r105 = q5.a(r104[r103]);     // Catch: Exception -> L11
        int r106 = ((r105[3] & UByte.MAX_VALUE) | ((r105[2] & UByte.MAX_VALUE) << 8)) | ((r105[1] & UByte.MAX_VALUE) << 16);     // Catch: Exception -> L11
        r102[r103] = ((r105[0] & UByte.MAX_VALUE) << 24) | r106;     // Catch: Exception -> L11
        r103 = r103 + 1;     // Catch: Exception -> L11
        goto L6
    L9:
        SecretKeySpec r107 = new SecretKeySpec(a(r102).getBytes("UTF-8"), x5.b("EQUVT"));     // Catch: Exception -> L11
        Cipher r108 = Cipher.getInstance(x5.b("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L11
        r108.init(1, r107, r101);     // Catch: Exception -> L11
        return r108.doFinal(r100);
    }

    public static String a(String r100) {
        return t5.c(r100);
    }
}
