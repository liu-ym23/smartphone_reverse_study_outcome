package com.amap.api.col.s;

import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f26053a = 4;

    private static int[] a(byte[] r100) {
        int[] r101 = new int[r100.length >>> 2];
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r103 >>> 2;
        r101[r104] = r101[r104] | ((r100[r103] & UByte.MAX_VALUE) << ((r103 & 3) << 3));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static byte[] a(byte[] r110, byte[] r111) {
        if (r110.length != 0) goto L5;
        return r110;
    L5:
        int r100 = r110.length;
        int r101 = f26053a;
        int r102 = r101 - (r100 % r101);
        int r103 = ((r100 / r101) + 1) * r101;
        byte[] r104 = new byte[r103];
        int r105 = 0;
        System.arraycopy(r110, 0, r104, 0, r110.length);
    L6:
        if (r100 >= r103) goto L8;
        r104[r100] = (byte) r102;
        r100 = r100 + 1;
        goto L6
    L8:
        int[] r112 = a(r104);
        int[] r113 = a(r111);
        int r106 = r112.length - 1;
        if (r106 > 0) goto L11;
    L20:
        int r114 = r112.length << 2;
        byte[] r107 = new byte[r114];
    L21:
        if (r105 >= r114) goto L23;
        r107[r105] = (byte) ((r112[r105 >>> 2] >>> ((r105 & 3) << 3)) & 255);
        r105 = r105 + 1;
        goto L21
    L23:
        return r107;
    L11:
        if (r113.length >= 4) goto L13;
        int[] r108 = new int[4];
        System.arraycopy(r113, 0, r108, 0, r113.length);
        r113 = r108;
    L13:
        int r109 = r112[r106];
        int r115 = (52 / (r106 + 1)) + 6;
        int r116 = 0;
    L14:
        int r117 = r115 - 1;
        if (r115 <= 0) goto L20;
        r116 = r116 - 1640531527;
        int r118 = (r116 >>> 2) & 3;
        int r119 = 0;
    L17:
        if (r119 >= r106) goto L19;
        int r120 = r119 + 1;
        int r121 = r112[r120];
        r109 = ((((r109 >>> 5) ^ (r121 << 2)) + ((r121 >>> 3) ^ (r109 << 4))) ^ ((r121 ^ r116) + (r109 ^ r113[(r119 & 3) ^ r118]))) + r112[r119];
        r112[r119] = r109;
        r119 = r120;
        goto L17
    L19:
        int r122 = r112[0];
        r109 = ((((r109 >>> 5) ^ (r122 << 2)) + ((r122 >>> 3) ^ (r109 << 4))) ^ ((r122 ^ r116) + (r109 ^ r113[r118 ^ (r119 & 3)]))) + r112[r106];
        r112[r106] = r109;
        r115 = r117;
        goto L14
    }
}
