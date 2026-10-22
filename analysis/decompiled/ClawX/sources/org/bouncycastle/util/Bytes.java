package org.bouncycastle.util;

/* loaded from: classes.dex */
public class Bytes {
    public static final int BYTES = 1;
    public static final int SIZE = 8;

    public static void xor(int i8, byte[] bArr, int i9, byte[] bArr2, int i10, byte[] bArr3, int i11) {
        for (int i12 = 0; i12 < i8; i12++) {
            bArr3[i11 + i12] = (byte) (bArr[i9 + i12] ^ bArr2[i10 + i12]);
        }
    }

    public static void xorTo(int i8, byte[] bArr, int i9, byte[] bArr2) {
        int i10 = 0;
        while (i10 < i8) {
            bArr2[i10] = (byte) (bArr[i9] ^ bArr2[i10]);
            i10++;
            i9++;
        }
    }

    public static void xor(int i8, byte[] bArr, int i9, byte[] bArr2, byte[] bArr3, int i10) {
        int i11 = 0;
        while (i11 < i8) {
            bArr3[i10] = (byte) (bArr[i9] ^ bArr2[i11]);
            i11++;
            i10++;
            i9++;
        }
    }

    public static void xorTo(int i8, byte[] bArr, int i9, byte[] bArr2, int i10) {
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = i10 + i11;
            bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i9 + i11]);
        }
    }

    public static void xor(int i8, byte[] bArr, byte[] bArr2, int i9, byte[] bArr3, int i10) {
        int i11 = 0;
        while (i11 < i8) {
            bArr3[i10] = (byte) (bArr2[i9] ^ bArr[i11]);
            i11++;
            i10++;
            i9++;
        }
    }

    public static void xorTo(int i8, byte[] bArr, byte[] bArr2) {
        for (int i9 = 0; i9 < i8; i9++) {
            bArr2[i9] = (byte) (bArr2[i9] ^ bArr[i9]);
        }
    }

    public static void xor(int i8, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i9 = 0; i9 < i8; i9++) {
            bArr3[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
        }
    }

    public static void xor(int i8, byte[] bArr, byte[] bArr2, byte[] bArr3, int i9) {
        int i10 = 0;
        while (i10 < i8) {
            bArr3[i9] = (byte) (bArr[i10] ^ bArr2[i10]);
            i10++;
            i9++;
        }
    }
}
