package com.baidu.lbsapi.auth;

import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f30444a = null;

    static {
        f30444a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    public static String a(byte[] r110, String r111) throws UnsupportedEncodingException {
        int r100 = (r110.length * 4) / 3;
        byte[] r101 = new byte[r100 + ((r100 / 76) + 3)];
        int r102 = r110.length - (r110.length % 3);
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r102) goto L6;
        int r105 = r104 + 1;
        byte[] r106 = f30444a;
        r101[r104] = r106[(r110[r103] & UByte.MAX_VALUE) >> 2];
        int r107 = r105 + 1;
        int r108 = r103 + 1;
        r101[r105] = r106[((r110[r103] & 3) << 4) | ((r110[r108] & UByte.MAX_VALUE) >> 4)];
        int r109 = r107 + 1;
        int r112 = (r110[r108] & 15) << 2;
        int r113 = r103 + 2;
        r101[r107] = r106[r112 | ((r110[r113] & UByte.MAX_VALUE) >> 6)];
        r104 = r109 + 1;
        r101[r109] = r106[r110[r113] & 63];
        r103 = r103 + 3;
        goto L4
    L6:
        int r114 = r110.length % 3;
        if (r114 == 1) goto L11;
        if (r114 != 2) goto L13;
        int r115 = r104 + 1;
        byte[] r116 = f30444a;
        r101[r104] = r116[(r110[r102] & UByte.MAX_VALUE) >> 2];
        int r117 = r115 + 1;
        int r118 = (r110[r102] & 3) << 4;
        int r119 = r102 + 1;
        r101[r115] = r116[((r110[r119] & UByte.MAX_VALUE) >> 4) | r118];
        int r120 = r117 + 1;
        r101[r117] = r116[(r110[r119] & 15) << 2];
        r104 = r120 + 1;
        r101[r120] = Base64.padSymbol;
    L13:
        return new String(r101, 0, r104, r111);
    L11:
        int r121 = r104 + 1;
        byte[] r122 = f30444a;
        r101[r104] = r122[(r110[r102] & UByte.MAX_VALUE) >> 2];
        int r123 = r121 + 1;
        r101[r121] = r122[(r110[r102] & 3) << 4];
        int r124 = r123 + 1;
        r101[r123] = Base64.padSymbol;
        r104 = r124 + 1;
        r101[r124] = Base64.padSymbol;
        goto L13
    }

    public static byte[] a(byte[] r100) {
        return a(r100, r100.length);
    }

    public static byte[] a(byte[] r110, int r111) {
        int r100 = (r111 / 4) * 3;
        if (r100 == 0) goto L5;
        byte[] r101 = new byte[r100];
        int r102 = r111;
        int r103 = 0;
    L7:
        byte r104 = r110[r102 - 1];
        byte r105 = 10;
        if (r104 == 10) goto L63;
        if (r104 == 13) goto L63;
        if (r104 == 32) goto L63;
        if (r104 == 9) goto L63;
        if (r104 != 61) goto L19;
        r103 = r103 + 1;
        goto L63
    L19:
        int r106 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L21:
        if (r106 >= r102) goto L56;
        byte r115 = r110[r106];
        if (r115 == r105) goto L55;
        if (r115 == 13) goto L55;
        if (r115 == 32) goto L55;
        if (r115 == 9) goto L55;
        if (r115 < 65) goto L34;
        if (r115 > 90) goto L34;
        int r116 = r115 - 65;
    L49:
        r112 = ((byte) r116) | (r112 << 6);
        if ((r114 % 4) != 3) goto L52;
        int r107 = r113 + 1;
        r101[r113] = (byte) ((16711680 & r112) >> 16);
        int r117 = r107 + 1;
        r101[r107] = (byte) ((65280 & r112) >> 8);
        r101[r117] = (byte) (r112 & 255);
        r113 = r117 + 1;
    L52:
        r114 = r114 + 1;
    L34:
        if (r115 < 97) goto L39;
        if (r115 > 122) goto L39;
        r116 = r115 - 71;
    L39:
        if (r115 < 48) goto L44;
        if (r115 > 57) goto L44;
        r116 = r115 + 4;
    L44:
        if (r115 != 43) goto L47;
        r116 = 62;
        goto L49
    L47:
        if (r115 != 47) goto L53;
        r116 = 63;
        goto L49
    L53:
        return null;
    L55:
        r106 = r106 + 1;
        r105 = 10;
        goto L21
    L56:
        if (r103 <= 0) goto L61;
        int r108 = r112 << (r103 * 6);
        int r109 = r113 + 1;
        r101[r113] = (byte) ((r108 & 16711680) >> 16);
        if (r103 != 1) goto L60;
        r113 = r109 + 1;
        r101[r109] = (byte) ((r108 & 65280) >> 8);
        goto L61
    L60:
        r113 = r109;
    L61:
        byte[] r118 = new byte[r113];
        System.arraycopy(r101, 0, r118, 0, r113);
        return r118;
    L63:
        r102 = r102 - 1;
        goto L7
    L5:
        return new byte[0];
    }
}
