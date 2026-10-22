package org.bouncycastle.crypto.modes.kgcm;

import x.e;

/* loaded from: classes.dex */
public class KGCMUtil_256 {
    public static final int SIZE = 4;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[3] ^ jArr[3]) | (((jArr[0] ^ jArr2[0]) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        boolean z;
        char c3;
        long j4;
        int i8 = 0;
        long j8 = jArr[0];
        boolean z2 = true;
        long j9 = jArr[1];
        char c8 = 2;
        long j10 = jArr[2];
        char c9 = 3;
        long j11 = jArr[3];
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = jArr2[2];
        long j15 = jArr2[3];
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j20 = 0;
        while (true) {
            z = z2;
            c3 = c8;
            j4 = j10;
            if (i8 >= 64) {
                break;
            }
            long j21 = -(j8 & 1);
            j8 >>>= z ? 1L : 0L;
            j16 ^= j12 & j21;
            char c10 = c9;
            long j22 = -(j9 & 1);
            j9 >>>= z ? 1L : 0L;
            j17 = (j17 ^ (j13 & j21)) ^ (j12 & j22);
            j18 = (j18 ^ (j14 & j21)) ^ (j13 & j22);
            j19 = (j19 ^ (j15 & j21)) ^ (j14 & j22);
            j20 ^= j15 & j22;
            long j23 = j15 >> 63;
            j15 = (j15 << (z ? 1L : 0L)) | (j14 >>> 63);
            j14 = (j14 << (z ? 1L : 0L)) | (j13 >>> 63);
            j13 = (j12 >>> 63) | (j13 << (z ? 1L : 0L));
            j12 = (j12 << (z ? 1L : 0L)) ^ (j23 & 1061);
            i8++;
            c9 = c10;
            z2 = z ? 1 : 0;
            c8 = c3;
            j10 = j4;
            j11 = j11;
        }
        char c11 = c9;
        long j24 = j11;
        char c12 = '>';
        long j25 = (((j15 >>> 62) ^ j12) ^ (j15 >>> 59)) ^ (j15 >>> 54);
        long j26 = ((j15 ^ (j15 << c3)) ^ (j15 << 5)) ^ (j15 << 10);
        int i9 = 0;
        while (i9 < 64) {
            long j27 = -(j4 & 1);
            j4 >>>= z ? 1L : 0L;
            j16 ^= j26 & j27;
            char c13 = c12;
            long j28 = j25;
            long j29 = -(j24 & 1);
            j24 >>>= z ? 1L : 0L;
            long j30 = (j17 ^ (j25 & j27)) ^ (j26 & j29);
            j18 = (j18 ^ (j13 & j27)) ^ (j28 & j29);
            j19 = (j19 ^ (j14 & j27)) ^ (j13 & j29);
            j20 ^= j14 & j29;
            long j31 = j14 >> 63;
            j14 = (j14 << (z ? 1L : 0L)) | (j13 >>> 63);
            j13 = (j28 >>> 63) | (j13 << (z ? 1L : 0L));
            long j32 = (j28 << (z ? 1L : 0L)) | (j26 >>> 63);
            j26 = (j26 << (z ? 1L : 0L)) ^ (j31 & 1061);
            i9++;
            c12 = c13;
            j25 = j32;
            j17 = j30;
        }
        jArr3[0] = j16 ^ (((j20 ^ (j20 << c3)) ^ (j20 << 5)) ^ (j20 << 10));
        jArr3[z ? 1 : 0] = j17 ^ (((j20 >>> c12) ^ (j20 >>> 59)) ^ (j20 >>> 54));
        jArr3[c3] = j18;
        jArr3[c11] = j19;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        jArr2[0] = ((j10 >> 63) & 1061) ^ (j4 << 1);
        jArr2[1] = (j4 >>> 63) | (j8 << 1);
        jArr2[2] = (j9 << 1) | (j8 >>> 63);
        jArr2[3] = (j10 << 1) | (j9 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = j10 >>> 56;
        jArr2[0] = ((((j4 << 8) ^ j11) ^ (j11 << 2)) ^ (j11 << 5)) ^ (j11 << 10);
        jArr2[1] = (j4 >>> 56) | (j8 << 8);
        jArr2[2] = (j9 << 8) | (j8 >>> 56);
        jArr2[3] = (j10 << 8) | (j9 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i8 = 8;
        long[] jArr3 = new long[8];
        for (int i9 = 0; i9 < 4; i9++) {
            e.C(i9 << 1, jArr[i9], jArr3);
        }
        while (true) {
            int i10 = i8 - 1;
            if (i10 < 4) {
                copy(jArr3, jArr2);
                return;
            }
            long j4 = jArr3[i10];
            int i11 = i8 - 5;
            jArr3[i11] = jArr3[i11] ^ ((((j4 << 2) ^ j4) ^ (j4 << 5)) ^ (j4 << 10));
            int i12 = i8 - 4;
            jArr3[i12] = ((j4 >>> 54) ^ ((j4 >>> 62) ^ (j4 >>> 59))) ^ jArr3[i12];
            i8 = i10;
        }
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }
}
