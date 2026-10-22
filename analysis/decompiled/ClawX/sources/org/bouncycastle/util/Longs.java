package org.bouncycastle.util;

/* loaded from: classes.dex */
public class Longs {
    public static final int BYTES = 8;
    public static final int SIZE = 64;

    public static long highestOneBit(long j4) {
        return Long.highestOneBit(j4);
    }

    public static long lowestOneBit(long j4) {
        return Long.lowestOneBit(j4);
    }

    public static int numberOfLeadingZeros(long j4) {
        return Long.numberOfLeadingZeros(j4);
    }

    public static int numberOfTrailingZeros(long j4) {
        return Long.numberOfTrailingZeros(j4);
    }

    public static long reverse(long j4) {
        return Long.reverse(j4);
    }

    public static long reverseBytes(long j4) {
        return Long.reverseBytes(j4);
    }

    public static long rotateLeft(long j4, int i8) {
        return Long.rotateLeft(j4, i8);
    }

    public static long rotateRight(long j4, int i8) {
        return Long.rotateRight(j4, i8);
    }

    public static Long valueOf(long j4) {
        return Long.valueOf(j4);
    }

    public static void xorTo(int i8, long[] jArr, int i9, long[] jArr2, int i10) {
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = i10 + i11;
            jArr2[i12] = jArr2[i12] ^ jArr[i9 + i11];
        }
    }
}
