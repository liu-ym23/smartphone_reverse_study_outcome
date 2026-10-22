package com.amap.api.mapcore.util;

import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class x3 {
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
        int r101 = 4 - (r100 % 4);
        int r102 = ((r100 / 4) + 1) * 4;
        byte[] r103 = new byte[r102];
        int r104 = 0;
        System.arraycopy(r110, 0, r103, 0, r110.length);
    L6:
        if (r100 >= r102) goto L8;
        r103[r100] = (byte) r101;
        r100 = r100 + 1;
        goto L6
    L8:
        int[] r112 = a(r103);
        int[] r113 = a(r111);
        int r105 = r112.length - 1;
        if (r105 >= 1) goto L12;
    L21:
        int r114 = r112.length << 2;
        byte[] r106 = new byte[r114];
    L22:
        if (r104 >= r114) goto L24;
        r106[r104] = (byte) ((r112[r104 >>> 2] >>> ((r104 & 3) << 3)) & 255);
        r104 = r104 + 1;
        goto L22
    L24:
        return r106;
    L12:
        if (r113.length >= 4) goto L14;
        int[] r107 = new int[4];
        System.arraycopy(r113, 0, r107, 0, r113.length);
        r113 = r107;
    L14:
        int r108 = r112[r105];
        int r109 = r112[0];
        int r115 = (52 / (r105 + 1)) + 6;
        int r116 = 0;
    L15:
        int r117 = r115 - 1;
        if (r115 <= 0) goto L21;
        r116 = r116 - 1640531527;
        int r118 = (r116 >>> 2) & 3;
        int r119 = 0;
    L18:
        if (r119 >= r105) goto L20;
        int r120 = r119 + 1;
        int r121 = r112[r120];
        r108 = ((((r108 >>> 5) ^ (r121 << 2)) + ((r121 >>> 3) ^ (r108 << 4))) ^ ((r121 ^ r116) + (r108 ^ r113[(r119 & 3) ^ r118]))) + r112[r119];
        r112[r119] = r108;
        r119 = r120;
        goto L18
    L20:
        int r122 = r112[0];
        r108 = ((((r108 >>> 5) ^ (r122 << 2)) + ((r122 >>> 3) ^ (r108 << 4))) ^ ((r122 ^ r116) + (r108 ^ r113[r118 ^ (r119 & 3)]))) + r112[r105];
        r112[r105] = r108;
        r115 = r117;
        goto L15
    }
}
