package com.baidu.mshield.b.f;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static byte[] a(byte[] r100, byte[] r101) {
        byte[] r102 = null;
        if (r101 != null) goto L18;
    L17:
        return r102;
    L18:
    L15:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = a.c(r101, r100);     // Catch: Throwable -> L15
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
        com.baidu.mshield.b.c.a.a(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = a.d(r101, r100);     // Catch: Throwable -> L15
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
        com.baidu.mshield.b.c.a.a(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = f.a(r100, r101);     // Catch: Throwable -> L15
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
        com.baidu.mshield.b.c.a.a(th);
        goto L17
    L5:
        if (r101.length <= 0) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        r102 = f.b(r100, r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        return r102;
    }
}
