package com.amap.api.col.jmsl;

/* renamed from: com.amap.api.col.jmsl.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1610u0 {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i10 = 4 - (length % 4);
        int i11 = ((length / 4) + 1) * 4;
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i11) {
            bArr3[length] = (byte) i10;
            length++;
        }
        int[] iArrB = b(bArr3);
        int[] iArrB2 = b(bArr2);
        int length2 = iArrB.length;
        int i12 = length2 - 1;
        if (i12 > 0) {
            if (iArrB2.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(iArrB2, 0, iArr, 0, iArrB2.length);
                iArrB2 = iArr;
            }
            int i13 = iArrB[i12];
            int i14 = (52 / length2) + 6;
            int i15 = 0;
            while (true) {
                int i16 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                i15 -= 1640531527;
                int i17 = (i15 >>> 2) & 3;
                int i18 = 0;
                while (i18 < i12) {
                    int i19 = i18 + 1;
                    int i20 = iArrB[i19];
                    i13 = ((((i13 >>> 5) ^ (i20 << 2)) + ((i20 >>> 3) ^ (i13 << 4))) ^ ((i20 ^ i15) + (i13 ^ iArrB2[(i18 & 3) ^ i17]))) + iArrB[i18];
                    iArrB[i18] = i13;
                    i18 = i19;
                }
                int i21 = iArrB[0];
                i13 = ((((i13 >>> 5) ^ (i21 << 2)) + ((i21 >>> 3) ^ (i13 << 4))) ^ ((i21 ^ i15) + (i13 ^ iArrB2[i17 ^ (i18 & 3)]))) + iArrB[i12];
                iArrB[i12] = i13;
                i14 = i16;
            }
        }
        int length3 = iArrB.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i22 = 0; i22 < length3; i22++) {
            bArr4[i22] = (byte) ((iArrB[i22 >>> 2] >>> ((i22 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    public static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 >>> 2;
            iArr[i11] = iArr[i11] | ((bArr[i10] & 255) << ((i10 & 3) << 3));
        }
        return iArr;
    }
}
