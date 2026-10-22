package org.bouncycastle.crypto.modes.kgcm;

import x.e;

/* loaded from: classes.dex */
public class KGCMUtil_128 {
    public static final int SIZE = 2;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[1] ^ jArr[1]) | (jArr[0] ^ jArr2[0])) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i8 = 0;
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr2[0];
        long j10 = jArr2[1];
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        while (i8 < 64) {
            long j14 = j4;
            int i9 = i8;
            long j15 = -(j14 & 1);
            j11 ^= j9 & j15;
            long j16 = (j15 & j10) ^ j13;
            long j17 = -(j8 & 1);
            j8 >>>= 1;
            long j18 = j16 ^ (j9 & j17);
            j12 ^= j17 & j10;
            long j19 = j10 >> 63;
            j10 = (j10 << 1) | (j9 >>> 63);
            j9 = (j9 << 1) ^ (j19 & 135);
            j13 = j18;
            i8 = i9 + 1;
            j4 = j14 >>> 1;
        }
        jArr3[0] = ((((j12 << 1) ^ j12) ^ (j12 << 2)) ^ (j12 << 7)) ^ j11;
        jArr3[1] = (((j12 >>> 63) ^ (j12 >>> 62)) ^ (j12 >>> 57)) ^ j13;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        jArr2[0] = ((j8 >> 63) & 135) ^ (j4 << 1);
        jArr2[1] = (j4 >>> 63) | (j8 << 1);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 >>> 56;
        jArr2[0] = (j9 << 7) ^ ((((j4 << 8) ^ j9) ^ (j9 << 1)) ^ (j9 << 2));
        jArr2[1] = (j4 >>> 56) | (j8 << 8);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        e.C(0, jArr[0], jArr3);
        e.C(2, jArr[1], jArr3);
        long j4 = jArr3[0];
        long j8 = jArr3[1];
        long j9 = jArr3[2];
        long j10 = jArr3[3];
        long j11 = j9 ^ ((j10 >>> 57) ^ ((j10 >>> 63) ^ (j10 >>> 62)));
        jArr2[0] = j4 ^ ((((j11 << 1) ^ j11) ^ (j11 << 2)) ^ (j11 << 7));
        jArr2[1] = (j8 ^ ((((j10 << 1) ^ j10) ^ (j10 << 2)) ^ (j10 << 7))) ^ ((j11 >>> 57) ^ ((j11 >>> 63) ^ (j11 >>> 62)));
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
    }
}
