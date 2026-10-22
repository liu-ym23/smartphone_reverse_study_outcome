package com.baidu.mapauto.auth.util;

import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* loaded from: classes.dex */
public final class Base64Util {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64Util() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length / 76) + 3 + length];
        int length2 = bArr.length - (bArr.length % 3);
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length2; i6 += 3) {
            byte[] bArr3 = MAP;
            bArr2[i4] = bArr3[(bArr[i6] & UByte.MAX_VALUE) >> 2];
            int i7 = i6 + 1;
            bArr2[i4 + 1] = bArr3[((bArr[i6] & 3) << 4) | ((bArr[i7] & UByte.MAX_VALUE) >> 4)];
            int i8 = i6 + 2;
            bArr2[i4 + 2] = bArr3[((bArr[i7] & 15) << 2) | ((bArr[i8] & UByte.MAX_VALUE) >> 6)];
            int i9 = i4 + 4;
            bArr2[i4 + 3] = bArr3[bArr[i8] & 63];
            if ((i9 - i5) % 76 != 0 || i9 == 0) {
                i4 = i9;
            } else {
                i4 += 5;
                bArr2[i9] = 10;
                i5++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            byte[] bArr4 = MAP;
            bArr2[i4] = bArr4[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            bArr2[i4 + 1] = bArr4[(bArr[length2] & 3) << 4];
            int i10 = i4 + 3;
            bArr2[i4 + 2] = Base64.padSymbol;
            i4 += 4;
            bArr2[i10] = Base64.padSymbol;
        } else if (length3 == 2) {
            byte[] bArr5 = MAP;
            bArr2[i4] = bArr5[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            int i11 = (bArr[length2] & 3) << 4;
            int i12 = length2 + 1;
            bArr2[i4 + 1] = bArr5[((bArr[i12] & UByte.MAX_VALUE) >> 4) | i11];
            int i13 = i4 + 3;
            bArr2[i4 + 2] = bArr5[(bArr[i12] & 15) << 2];
            i4 += 4;
            bArr2[i13] = Base64.padSymbol;
        }
        return new String(bArr2, 0, i4, str);
    }

    public static String encodeWithoutLineFeed(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length / 76) + 3 + length];
        int length2 = bArr.length - (bArr.length % 3);
        int i4 = 0;
        for (int i5 = 0; i5 < length2; i5 += 3) {
            byte[] bArr3 = MAP;
            bArr2[i4] = bArr3[(bArr[i5] & UByte.MAX_VALUE) >> 2];
            int i6 = i5 + 1;
            bArr2[i4 + 1] = bArr3[((bArr[i5] & 3) << 4) | ((bArr[i6] & UByte.MAX_VALUE) >> 4)];
            int i7 = i4 + 3;
            int i8 = i5 + 2;
            bArr2[i4 + 2] = bArr3[((bArr[i6] & 15) << 2) | ((bArr[i8] & UByte.MAX_VALUE) >> 6)];
            i4 += 4;
            bArr2[i7] = bArr3[bArr[i8] & 63];
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            byte[] bArr4 = MAP;
            bArr2[i4] = bArr4[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            bArr2[i4 + 1] = bArr4[(bArr[length2] & 3) << 4];
            int i9 = i4 + 3;
            bArr2[i4 + 2] = Base64.padSymbol;
            i4 += 4;
            bArr2[i9] = Base64.padSymbol;
        } else if (length3 == 2) {
            byte[] bArr5 = MAP;
            bArr2[i4] = bArr5[(bArr[length2] & UByte.MAX_VALUE) >> 2];
            int i10 = (bArr[length2] & 3) << 4;
            int i11 = length2 + 1;
            bArr2[i4 + 1] = bArr5[((bArr[i11] & UByte.MAX_VALUE) >> 4) | i10];
            int i12 = i4 + 3;
            bArr2[i4 + 2] = bArr5[(bArr[i11] & 15) << 2];
            i4 += 4;
            bArr2[i12] = Base64.padSymbol;
        }
        return new String(bArr2, 0, i4, str);
    }

    public static byte[] decode(byte[] bArr, int i4) {
        byte b4;
        int i5;
        int i6 = (i4 / 4) * 3;
        if (i6 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i6];
        int i7 = i4;
        int i8 = 0;
        while (true) {
            byte b5 = bArr[i7 - 1];
            b4 = 10;
            if (b5 != 10 && b5 != 13 && b5 != 32 && b5 != 9) {
                if (b5 != 61) {
                    break;
                }
                i8++;
            }
            i7--;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i7) {
            byte b6 = bArr[i9];
            if (b6 != b4 && b6 != 13 && b6 != 32 && b6 != 9) {
                if (b6 >= 65 && b6 <= 90) {
                    i5 = b6 - 65;
                } else if (b6 >= 97 && b6 <= 122) {
                    i5 = b6 - 71;
                } else if (b6 >= 48 && b6 <= 57) {
                    i5 = b6 + 4;
                } else if (b6 == 43) {
                    i5 = 62;
                } else {
                    if (b6 != 47) {
                        return null;
                    }
                    i5 = 63;
                }
                i11 = ((byte) i5) | (i11 << 6);
                if (i12 % 4 == 3) {
                    bArr2[i10] = (byte) ((16711680 & i11) >> 16);
                    int i13 = i10 + 2;
                    bArr2[i10 + 1] = (byte) ((65280 & i11) >> 8);
                    i10 += 3;
                    bArr2[i13] = (byte) (i11 & 255);
                }
                i12++;
            }
            i9++;
            b4 = 10;
        }
        if (i8 > 0) {
            int i14 = i11 << (i8 * 6);
            int i15 = i10 + 1;
            bArr2[i10] = (byte) ((i14 & 16711680) >> 16);
            if (i8 == 1) {
                i10 += 2;
                bArr2[i15] = (byte) ((i14 & 65280) >> 8);
            } else {
                i10 = i15;
            }
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(bArr2, 0, bArr3, 0, i10);
        return bArr3;
    }
}
