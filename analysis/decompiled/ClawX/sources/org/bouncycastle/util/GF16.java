package org.bouncycastle.util;

/* loaded from: classes.dex */
public class GF16 {
    private static final byte[] F_STAR = {1, 2, 4, 8, 3, 6, 12, 11, 5, 10, 7, 14, 15, 13, 9};
    private static final byte[] MT4B = new byte[256];
    private static final byte[] INV4B = new byte[16];

    static {
        for (int i8 = 0; i8 < 15; i8++) {
            for (int i9 = 0; i9 < 15; i9++) {
                byte[] bArr = MT4B;
                byte[] bArr2 = F_STAR;
                bArr[(bArr2[i8] << 4) ^ bArr2[i9]] = bArr2[(i8 + i9) % 15];
            }
        }
        byte[] bArr3 = F_STAR;
        byte bMt = 1;
        byte b9 = bArr3[1];
        byte b10 = bArr3[14];
        INV4B[1] = 1;
        byte bMt2 = 1;
        for (int i10 = 0; i10 < 14; i10++) {
            bMt = mt(bMt, b9);
            bMt2 = mt(bMt2, b10);
            INV4B[bMt] = bMt2;
        }
    }

    public static void decode(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        int i11 = i10 >> 1;
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i9 + 1;
            bArr2[i9] = (byte) (bArr[i8] & 15);
            i9 += 2;
            bArr2[i13] = (byte) ((bArr[i8] >>> 4) & 15);
            i12++;
            i8++;
        }
        if ((i10 & 1) == 1) {
            bArr2[i9] = (byte) (bArr[i8] & 15);
        }
    }

    public static void encode(byte[] bArr, byte[] bArr2, int i8) {
        int i9 = i8 >> 1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i11 + 1;
            int i13 = bArr[i11] & 15;
            i11 += 2;
            bArr2[i10] = (byte) (((bArr[i12] & 15) << 4) | i13);
            i10++;
        }
        if ((i8 & 1) == 1) {
            bArr2[i10] = (byte) (bArr[i11] & 15);
        }
    }

    public static byte innerProduct(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        int i11 = 0;
        byte bMul = 0;
        while (i11 < i10) {
            bMul = (byte) (mul(bArr[i8], bArr2[i9]) ^ bMul);
            i11++;
            i9 += i10;
            i8++;
        }
        return bMul;
    }

    public static byte inv(byte b9) {
        return INV4B[b9 & 15];
    }

    public static byte mt(int i8, int i9) {
        return MT4B[(i8 << 4) ^ i9];
    }

    public static byte mul(byte b9, byte b10) {
        return MT4B[(b9 << 4) | b10];
    }

    public static void decode(byte[] bArr, byte[] bArr2, int i8) {
        int i9 = i8 >> 1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i11 + 1;
            bArr2[i11] = (byte) (bArr[i10] & 15);
            i11 += 2;
            bArr2[i12] = (byte) ((bArr[i10] >>> 4) & 15);
            i10++;
        }
        if ((i8 & 1) == 1) {
            bArr2[i11] = (byte) (bArr[i10] & 15);
        }
    }

    public static void encode(byte[] bArr, byte[] bArr2, int i8, int i9) {
        int i10 = i9 >> 1;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i12 + 1;
            int i14 = bArr[i12] & 15;
            i12 += 2;
            bArr2[i8] = (byte) (((bArr[i13] & 15) << 4) | i14);
            i11++;
            i8++;
        }
        if ((i9 & 1) == 1) {
            bArr2[i8] = (byte) (bArr[i12] & 15);
        }
    }

    public static int mul(int i8, int i9) {
        return MT4B[(i8 << 4) | i9];
    }
}
