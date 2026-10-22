package com.baidu.mshield.x6.f;

import java.util.Random;

/* JADX INFO: loaded from: classes39.dex */
public class h {
    public static String a(int r100) {
        Random r101 = new Random();
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r102.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(r101.nextInt(62)));
        r103 = r103 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        byte[] r102 = null;
        if (r101 != null) goto L18;
    L17:
        return r102;
    L18:
    L15:
        th = move-exception;
        f.b(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = com.baidu.mshield.b.f.a.a(r100, r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        return r102;
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        byte[] r102 = null;
        if (r101 != null) goto L18;
    L17:
        return r102;
    L18:
    L15:
        th = move-exception;
        f.b(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = com.baidu.mshield.b.f.a.b(r100, r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        return r102;
    }

    public static byte[] c(byte[] r100, byte[] r101) {
        byte[] r102 = null;
        if (r101 != null) goto L18;
    L17:
        return r102;
    L18:
    L15:
        th = move-exception;
        f.b(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = com.baidu.mshield.b.f.f.a(r100, r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        return r102;
    }

    public static byte[] d(byte[] r100, byte[] r101) {
        byte[] r102 = null;
        if (r101 != null) goto L18;
    L17:
        return r102;
    L18:
    L15:
        th = move-exception;
        f.b(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = com.baidu.mshield.b.f.f.b(r100, r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        return r102;
    }
}
