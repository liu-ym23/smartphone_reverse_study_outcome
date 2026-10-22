package com.autonavi.aps.protocol.aps.common.e;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class a {
    static {
        Charset.forName("UTF-8");
    }

    public static byte a(byte b10, byte b11, byte b12) {
        return (byte) ((b10 << 2) | (b11 << 1) | b12);
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static long c(String str) {
        if (a(str)) {
            return -1L;
        }
        long j10 = 0;
        int i10 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long jCharAt = str.charAt(length);
            long j11 = 48;
            if (jCharAt < 48 || jCharAt > 57) {
                if (jCharAt >= 97 && jCharAt <= 102) {
                    j11 = 87;
                } else if (jCharAt >= 65 && jCharAt <= 70) {
                    j11 = 55;
                } else if (jCharAt != 58 && jCharAt != 124) {
                    return -1L;
                }
                j10 += (jCharAt - j11) << i10;
                i10 += 4;
            } else {
                j10 += (jCharAt - j11) << i10;
                i10 += 4;
            }
        }
        if (i10 != 48) {
            return -1L;
        }
        return j10;
    }

    public static byte a(byte b10, byte b11, short s10) {
        return (byte) ((b10 << 1) | (s10 << 4) | b11);
    }

    public static boolean b(byte[] bArr) {
        return !a(bArr);
    }

    public static long a(byte b10, byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17) {
        return ((b11 & 255) << 48) | (b10 << 56) | ((b12 & 255) << 40) | ((b13 & 255) << 32) | ((b14 & 255) << 24) | ((b15 & 255) << 16) | ((b16 & 255) << 8) | (b17 & 255);
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static long c(byte[] bArr) {
        return a((byte) 0, (byte) 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5]);
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }
}
