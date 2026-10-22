package com.amap.api.col.jmsl;

/* renamed from: com.amap.api.col.jmsl.s1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1603s1 {
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
        if (i12 >= 1) {
            if (iArrB2.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(iArrB2, 0, iArr, 0, iArrB2.length);
                iArrB2 = iArr;
            }
            int i13 = iArrB[i12];
            int i14 = iArrB[0];
            int i15 = (52 / length2) + 6;
            int i16 = 0;
            while (true) {
                int i17 = i15 - 1;
                if (i15 <= 0) {
                    break;
                }
                i16 -= 1640531527;
                int i18 = (i16 >>> 2) & 3;
                int i19 = 0;
                while (i19 < i12) {
                    int i20 = i19 + 1;
                    int i21 = iArrB[i20];
                    i13 = ((((i13 >>> 5) ^ (i21 << 2)) + ((i21 >>> 3) ^ (i13 << 4))) ^ ((i21 ^ i16) + (i13 ^ iArrB2[(i19 & 3) ^ i18]))) + iArrB[i19];
                    iArrB[i19] = i13;
                    i19 = i20;
                }
                int i22 = iArrB[0];
                i13 = ((((i13 >>> 5) ^ (i22 << 2)) + ((i22 >>> 3) ^ (i13 << 4))) ^ ((i22 ^ i16) + (i13 ^ iArrB2[i18 ^ (i19 & 3)]))) + iArrB[i12];
                iArrB[i12] = i13;
                i15 = i17;
            }
        }
        int length3 = iArrB.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i23 = 0; i23 < length3; i23++) {
            bArr4[i23] = (byte) ((iArrB[i23 >>> 2] >>> ((i23 & 3) << 3)) & 255);
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
