package com.baidu.b.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f4870a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i4) {
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
