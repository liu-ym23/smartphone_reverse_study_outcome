package com.alibaba.fastjson.util;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i4 = 0; i4 < length; i4++) {
            IA[CA[i4]] = i4;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        int i9 = i4;
        while (i9 < i8 && IA[cArr[i9]] < 0) {
            i9++;
        }
        while (i8 > 0 && IA[cArr[i8]] < 0) {
            i8--;
        }
        int i10 = cArr[i8] == '=' ? cArr[i8 + (-1)] == '=' ? 2 : 1 : 0;
        int i11 = (i8 - i9) + 1;
        if (i5 > 76) {
            i6 = (cArr[76] == '\r' ? i11 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i12 = (((i11 - i6) * 6) >> 3) - i10;
        byte[] bArr = new byte[i12];
        int i13 = (i12 / 3) * 3;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i13) {
            int[] iArr = IA;
            int i16 = i9 + 4;
            int i17 = iArr[cArr[i9 + 3]] | (iArr[cArr[i9 + 1]] << 12) | (iArr[cArr[i9]] << 18) | (iArr[cArr[i9 + 2]] << 6);
            bArr[i14] = (byte) (i17 >> 16);
            int i18 = i14 + 2;
            bArr[i14 + 1] = (byte) (i17 >> 8);
            i14 += 3;
            bArr[i18] = (byte) i17;
            if (i6 <= 0 || (i15 = i15 + 1) != 19) {
                i9 = i16;
            } else {
                i9 += 6;
                i15 = 0;
            }
        }
        if (i14 < i12) {
            int i19 = 0;
            while (i9 <= i8 - i10) {
                i7 |= IA[cArr[i9]] << (18 - (i19 * 6));
                i19++;
                i9++;
            }
            int i20 = 16;
            while (i14 < i12) {
                bArr[i14] = (byte) (i7 >> i20);
                i20 -= 8;
                i14++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i4, int i5) {
        int i6;
        if (i5 == 0) {
            return new byte[0];
        }
        int i7 = (i4 + i5) - 1;
        int i8 = i4;
        while (i8 < i7 && IA[str.charAt(i8)] < 0) {
            i8++;
        }
        while (i7 > 0 && IA[str.charAt(i7)] < 0) {
            i7--;
        }
        int i9 = str.charAt(i7) == '=' ? str.charAt(i7 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i7 - i8) + 1;
        if (i5 > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i8 + 4;
            int i16 = iArr[str.charAt(i8 + 3)] | (iArr[str.charAt(i8 + 1)] << 12) | (iArr[str.charAt(i8)] << 18) | (iArr[str.charAt(i8 + 2)] << 6);
            bArr[i13] = (byte) (i16 >> 16);
            int i17 = i13 + 2;
            bArr[i13 + 1] = (byte) (i16 >> 8);
            i13 += 3;
            bArr[i17] = (byte) i16;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i8 = i15;
            } else {
                i8 += 6;
                i14 = 0;
            }
        }
        if (i13 < i11) {
            int i18 = 0;
            int i19 = 0;
            while (i8 <= i7 - i9) {
                i18 |= IA[str.charAt(i8)] << (18 - (i19 * 6));
                i19++;
                i8++;
            }
            int i20 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i18 >> i20);
                i20 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i4;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i5 = length - 1;
        int i6 = 0;
        while (i6 < i5 && IA[str.charAt(i6) & 255] < 0) {
            i6++;
        }
        while (i5 > 0 && IA[str.charAt(i5) & 255] < 0) {
            i5--;
        }
        int i7 = str.charAt(i5) == '=' ? str.charAt(i5 + (-1)) == '=' ? 2 : 1 : 0;
        int i8 = (i5 - i6) + 1;
        if (length > 76) {
            i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr = IA;
            int i13 = i6 + 4;
            int i14 = iArr[str.charAt(i6 + 3)] | (iArr[str.charAt(i6 + 1)] << 12) | (iArr[str.charAt(i6)] << 18) | (iArr[str.charAt(i6 + 2)] << 6);
            bArr[i11] = (byte) (i14 >> 16);
            int i15 = i11 + 2;
            bArr[i11 + 1] = (byte) (i14 >> 8);
            i11 += 3;
            bArr[i15] = (byte) i14;
            if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                i6 = i13;
            } else {
                i6 += 6;
                i12 = 0;
            }
        }
        if (i11 < i9) {
            int i16 = 0;
            int i17 = 0;
            while (i6 <= i5 - i7) {
                i16 |= IA[str.charAt(i6)] << (18 - (i17 * 6));
                i17++;
                i6++;
            }
            int i18 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i16 >> i18);
                i18 -= 8;
                i11++;
            }
        }
        return bArr;
    }
}
