package com.baidu.mshield.b.f;

import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class f {
    public static byte[] a(byte[] r100) {
        byte[] r101 = new byte[256];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= 256) goto L5;
        r101[r103] = (byte) r103;
        r103 = r103 + 1;
        goto L3
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.length == 0) goto L17;
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r102 >= 256) goto L12;
        int r106 = r100[r104] & UByte.MAX_VALUE;
        byte r107 = r101[r102];
        r105 = ((r106 + (r107 & UByte.MAX_VALUE)) + r105) & 255;
        r101[r102] = r101[r105];
        r101[r105] = r107;
        r104 = (r104 + 1) % r100.length;
        r102 = r102 + 1;
        goto L10
    L12:
        return r101;
    L17:
        return null;
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return c(r100, r101);
    L7:
        return null;
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return c(r100, r101);
    L7:
        return null;
    }

    public static byte[] c(byte[] r100, byte[] r101) {
        byte[] r102 = a(r101);
        byte[] r103 = new byte[r100.length];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r104 >= r100.length) goto L6;
        r105 = (r105 + 1) & 255;
        byte r107 = r102[r105];
        r106 = ((r107 & UByte.MAX_VALUE) + r106) & 255;
        r102[r105] = r102[r106];
        r102[r106] = r107;
        int r108 = ((r102[r105] & UByte.MAX_VALUE) + (r107 & UByte.MAX_VALUE)) & 255;
        byte r109 = r100[r104];
        byte r110 = (byte) (r102[r108] ^ r109);
        r103[r104] = r110;
        r103[r104] = (byte) (r110 ^ 42);
        r104 = r104 + 1;
        goto L4
    L6:
        return r103;
    }
}
