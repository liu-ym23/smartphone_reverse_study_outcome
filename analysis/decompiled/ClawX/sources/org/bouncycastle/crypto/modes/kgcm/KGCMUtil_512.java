package org.bouncycastle.crypto.modes.kgcm;

import x.e;

/* loaded from: classes.dex */
public class KGCMUtil_512 {
    public static final int SIZE = 8;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
        jArr2[7] = jArr[7];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[7] ^ jArr[7]) | (((((((jArr[0] ^ jArr2[0]) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2])) | (jArr[3] ^ jArr2[3])) | (jArr[4] ^ jArr2[4])) | (jArr[5] ^ jArr2[5])) | (jArr[6] ^ jArr2[6]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i8 = 0;
        long j4 = jArr2[0];
        boolean z = true;
        long j8 = jArr2[1];
        char c3 = 2;
        long j9 = jArr2[2];
        char c8 = 3;
        long j10 = jArr2[3];
        long j11 = jArr2[4];
        long j12 = jArr2[5];
        long j13 = jArr2[6];
        long j14 = jArr2[7];
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j20 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        while (true) {
            boolean z2 = z;
            if (i8 >= 8) {
                char c9 = c3;
                jArr3[0] = j15 ^ (((j16 ^ (j16 << c9)) ^ (j16 << 5)) ^ (j16 << 8));
                jArr3[z2 ? 1 : 0] = j17 ^ (((j16 >>> 62) ^ (j16 >>> 59)) ^ (j16 >>> 56));
                jArr3[c9] = j18;
                jArr3[c8] = j19;
                jArr3[4] = j20;
                jArr3[5] = j21;
                jArr3[6] = j22;
                jArr3[7] = j23;
                return;
            }
            long j24 = jArr[i8];
            long j25 = jArr[i8 + 1];
            long j26 = j9;
            long j27 = j8;
            long j28 = j13;
            j13 = j12;
            j12 = j11;
            j11 = j10;
            long j29 = j26;
            char c10 = c3;
            int i9 = 0;
            while (i9 < 64) {
                char c11 = c8;
                long j30 = j29;
                long j31 = -(j24 & 1);
                j24 >>>= z2 ? 1L : 0L;
                j15 ^= j4 & j31;
                long j32 = j27;
                long j33 = -(j25 & 1);
                j25 >>>= z2 ? 1L : 0L;
                j17 = (j17 ^ (j27 & j31)) ^ (j4 & j33);
                j18 = (j18 ^ (j30 & j31)) ^ (j32 & j33);
                j19 = (j19 ^ (j11 & j31)) ^ (j30 & j33);
                j20 = (j20 ^ (j12 & j31)) ^ (j11 & j33);
                j21 = (j21 ^ (j13 & j31)) ^ (j12 & j33);
                j22 = (j22 ^ (j28 & j31)) ^ (j13 & j33);
                j23 = (j23 ^ (j14 & j31)) ^ (j28 & j33);
                j16 ^= j14 & j33;
                long j34 = j14 >> 63;
                j14 = (j14 << (z2 ? 1L : 0L)) | (j28 >>> 63);
                j28 = (j28 << (z2 ? 1L : 0L)) | (j13 >>> 63);
                j13 = (j13 << (z2 ? 1L : 0L)) | (j12 >>> 63);
                j12 = (j12 << (z2 ? 1L : 0L)) | (j11 >>> 63);
                j11 = (j11 << (z2 ? 1L : 0L)) | (j30 >>> 63);
                long j35 = (j30 << (z2 ? 1L : 0L)) | (j32 >>> 63);
                long j36 = (j32 << (z2 ? 1L : 0L)) | (j4 >>> 63);
                j4 = (j4 << (z2 ? 1L : 0L)) ^ (j34 & 293);
                i9++;
                c8 = c11;
                j29 = j35;
                j27 = j36;
            }
            long j37 = ((j4 ^ (j14 >>> 62)) ^ (j14 >>> 59)) ^ (j14 >>> 56);
            long j38 = ((j14 ^ (j14 << c10)) ^ (j14 << 5)) ^ (j14 << 8);
            i8 += 2;
            j14 = j28;
            c8 = c8;
            z = z2 ? 1 : 0;
            j10 = j29;
            j8 = j37;
            j4 = j38;
            c3 = c10;
            j9 = j27;
        }
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        jArr2[0] = (j4 << 1) ^ ((j14 >> 63) & 293);
        jArr2[1] = (j8 << 1) | (j4 >>> 63);
        jArr2[2] = (j9 << 1) | (j8 >>> 63);
        jArr2[3] = (j10 << 1) | (j9 >>> 63);
        jArr2[4] = (j11 << 1) | (j10 >>> 63);
        jArr2[5] = (j12 << 1) | (j11 >>> 63);
        jArr2[6] = (j13 << 1) | (j12 >>> 63);
        jArr2[7] = (j14 << 1) | (j13 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = j14 >>> 56;
        jArr2[0] = ((((j4 << 8) ^ j15) ^ (j15 << 2)) ^ (j15 << 5)) ^ (j15 << 8);
        jArr2[1] = (j8 << 8) | (j4 >>> 56);
        jArr2[2] = (j9 << 8) | (j8 >>> 56);
        jArr2[3] = (j10 << 8) | (j9 >>> 56);
        jArr2[4] = (j11 << 8) | (j10 >>> 56);
        jArr2[5] = (j12 << 8) | (j11 >>> 56);
        jArr2[6] = (j13 << 8) | (j12 >>> 56);
        jArr2[7] = (j14 << 8) | (j13 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i8 = 16;
        long[] jArr3 = new long[16];
        for (int i9 = 0; i9 < 8; i9++) {
            e.C(i9 << 1, jArr[i9], jArr3);
        }
        while (true) {
            int i10 = i8 - 1;
            if (i10 < 8) {
                copy(jArr3, jArr2);
                return;
            }
            long j4 = jArr3[i10];
            int i11 = i8 - 9;
            jArr3[i11] = jArr3[i11] ^ ((((j4 << 2) ^ j4) ^ (j4 << 5)) ^ (j4 << 8));
            int i12 = i8 - 8;
            jArr3[i12] = ((j4 >>> 56) ^ ((j4 >>> 62) ^ (j4 >>> 59))) ^ jArr3[i12];
            i8 = i10;
        }
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }
}
