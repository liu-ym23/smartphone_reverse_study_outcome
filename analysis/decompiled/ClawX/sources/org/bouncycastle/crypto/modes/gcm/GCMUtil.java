package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;
import x.e;

/* loaded from: classes.dex */
public abstract class GCMUtil {
    private static final int E1 = -520093696;
    private static final long E1L = -2233785415175766016L;
    public static final int SIZE_BYTES = 16;
    public static final int SIZE_INTS = 4;
    public static final int SIZE_LONGS = 2;

    public static byte areEqual(byte[] bArr, byte[] bArr2) {
        int i8 = 0;
        for (int i9 = 0; i9 < 16; i9++) {
            i8 |= bArr[i9] ^ bArr2[i9];
        }
        return (byte) ((((i8 >>> 1) | (i8 & 1)) - 1) >> 31);
    }

    public static void asBytes(int[] iArr, byte[] bArr) {
        Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
    }

    public static void asInts(byte[] bArr, int[] iArr) {
        Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
    }

    public static void asLongs(byte[] bArr, long[] jArr) {
        Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
    }

    public static void copy(byte[] bArr, byte[] bArr2) {
        for (int i8 = 0; i8 < 16; i8++) {
            bArr2[i8] = bArr[i8];
        }
    }

    public static void divideP(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j4 >> 63;
        jArr2[0] = ((j4 ^ (E1L & j9)) << 1) | (j8 >>> 63);
        jArr2[1] = (j8 << 1) | (-j9);
    }

    private static long implMul64(long j4, long j8) {
        long j9 = j4 & 1229782938247303441L;
        long j10 = j4 & 2459565876494606882L;
        long j11 = j4 & 4919131752989213764L;
        long j12 = j4 & (-8608480567731124088L);
        long j13 = j8 & 1229782938247303441L;
        long j14 = j8 & 2459565876494606882L;
        long j15 = j8 & 4919131752989213764L;
        long j16 = j8 & (-8608480567731124088L);
        long j17 = (((j9 * j13) ^ (j10 * j16)) ^ (j11 * j15)) ^ (j12 * j14);
        long j18 = (((j9 * j14) ^ (j10 * j13)) ^ (j11 * j16)) ^ (j12 * j15);
        long j19 = (((j9 * j15) ^ (j10 * j14)) ^ (j11 * j13)) ^ (j12 * j16);
        return (j17 & 1229782938247303441L) | (j18 & 2459565876494606882L) | (j19 & 4919131752989213764L) | (((((j9 * j16) ^ (j10 * j15)) ^ (j11 * j14)) ^ (j12 * j13)) & (-8608480567731124088L));
    }

    public static void multiply(byte[] bArr, byte[] bArr2) {
        long[] jArrAsLongs = asLongs(bArr);
        multiply(jArrAsLongs, asLongs(bArr2));
        asBytes(jArrAsLongs, bArr);
    }

    public static void multiplyP(int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        iArr[0] = (((i11 << 31) >> 31) & E1) ^ (i8 >>> 1);
        iArr[1] = (i9 >>> 1) | (i8 << 31);
        iArr[2] = (i10 >>> 1) | (i9 << 31);
        iArr[3] = (i11 >>> 1) | (i10 << 31);
    }

    public static void multiplyP16(long[] jArr) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 48;
        jArr[0] = (j9 >>> 7) ^ ((((j4 >>> 16) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr[1] = (j4 << 48) | (j8 >>> 16);
    }

    public static void multiplyP3(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 61;
        jArr2[0] = (j9 >>> 7) ^ ((((j4 >>> 3) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr2[1] = (j4 << 61) | (j8 >>> 3);
    }

    public static void multiplyP4(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 60;
        jArr2[0] = (j9 >>> 7) ^ ((((j4 >>> 4) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr2[1] = (j4 << 60) | (j8 >>> 4);
    }

    public static void multiplyP7(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 57;
        jArr2[0] = (j9 >>> 7) ^ ((((j4 >>> 7) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr2[1] = (j4 << 57) | (j8 >>> 7);
    }

    public static void multiplyP8(int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = i11 << 24;
        iArr[0] = (i12 >>> 7) ^ ((((i8 >>> 8) ^ i12) ^ (i12 >>> 1)) ^ (i12 >>> 2));
        iArr[1] = (i9 >>> 8) | (i8 << 24);
        iArr[2] = (i10 >>> 8) | (i9 << 24);
        iArr[3] = (i11 >>> 8) | (i10 << 24);
    }

    public static byte[] oneAsBytes() {
        byte[] bArr = new byte[16];
        bArr[0] = -128;
        return bArr;
    }

    public static int[] oneAsInts() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static long[] oneAsLongs() {
        return new long[]{Long.MIN_VALUE, 0};
    }

    public static long[] pAsLongs() {
        return new long[]{4611686018427387904L, 0};
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        e.E(0, jArr[0], jArr3);
        e.E(2, jArr[1], jArr3);
        long j4 = jArr3[0];
        long j8 = jArr3[1];
        long j9 = jArr3[2];
        long j10 = jArr3[3];
        long j11 = j9 ^ ((j10 << 57) ^ ((j10 << 63) ^ (j10 << 62)));
        jArr2[0] = j4 ^ ((((j11 >>> 1) ^ j11) ^ (j11 >>> 2)) ^ (j11 >>> 7));
        jArr2[1] = (j8 ^ ((((j10 >>> 1) ^ j10) ^ (j10 >>> 2)) ^ (j10 >>> 7))) ^ ((j11 << 57) ^ ((j11 << 63) ^ (j11 << 62)));
    }

    public static void xor(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return;
            }
            int i11 = i8 + i10;
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i9 + i10]);
        }
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i8 = (iArr[3] ^ iArr2[3]) | (iArr2[0] ^ iArr[0]) | (iArr[1] ^ iArr2[1]) | (iArr2[2] ^ iArr[2]);
        return (((i8 & 1) | (i8 >>> 1)) - 1) >> 31;
    }

    public static void asBytes(long[] jArr, byte[] bArr) {
        Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
    }

    public static int[] asInts(byte[] bArr) {
        int[] iArr = new int[4];
        Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
        return iArr;
    }

    public static long[] asLongs(byte[] bArr) {
        long[] jArr = new long[2];
        Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
        return jArr;
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void multiply(byte[] bArr, long[] jArr) {
        long jBigEndianToLong = Pack.bigEndianToLong(bArr, 0);
        long jBigEndianToLong2 = Pack.bigEndianToLong(bArr, 8);
        long j4 = jArr[0];
        long j8 = jArr[1];
        long jReverse = Longs.reverse(jBigEndianToLong);
        long jReverse2 = Longs.reverse(jBigEndianToLong2);
        long jReverse3 = Longs.reverse(j4);
        long jReverse4 = Longs.reverse(j8);
        long jReverse5 = Longs.reverse(implMul64(jReverse, jReverse3));
        long jImplMul64 = implMul64(jBigEndianToLong, j4) << 1;
        long jReverse6 = Longs.reverse(implMul64(jReverse2, jReverse4));
        long jImplMul642 = implMul64(jBigEndianToLong2, j8);
        long j9 = jImplMul642 << 1;
        long jReverse7 = Longs.reverse(implMul64(jReverse ^ jReverse2, jReverse3 ^ jReverse4));
        long jImplMul643 = ((implMul64(jBigEndianToLong ^ jBigEndianToLong2, j4 ^ j8) << 1) ^ ((jReverse6 ^ jImplMul64) ^ j9)) ^ ((jImplMul642 << 63) ^ (jImplMul642 << 58));
        Pack.longToBigEndian(jReverse5 ^ (((jImplMul643 >>> 2) ^ ((jImplMul643 >>> 1) ^ jImplMul643)) ^ (jImplMul643 >>> 7)), bArr, 0);
        Pack.longToBigEndian(((jImplMul643 << 57) ^ ((jImplMul643 << 63) ^ (jImplMul643 << 62))) ^ ((jReverse7 ^ ((jImplMul64 ^ jReverse5) ^ jReverse6)) ^ (((j9 ^ (j9 >>> 1)) ^ (j9 >>> 2)) ^ (j9 >>> 7))), bArr, 8);
    }

    public static void multiplyP(int[] iArr, int[] iArr2) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        iArr2[0] = (((i11 << 31) >> 31) & E1) ^ (i8 >>> 1);
        iArr2[1] = (i9 >>> 1) | (i8 << 31);
        iArr2[2] = (i10 >>> 1) | (i9 << 31);
        iArr2[3] = (i11 >>> 1) | (i10 << 31);
    }

    public static void multiplyP8(int[] iArr, int[] iArr2) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = i11 << 24;
        iArr2[0] = (i12 >>> 7) ^ ((((i8 >>> 8) ^ i12) ^ (i12 >>> 1)) ^ (i12 >>> 2));
        iArr2[1] = (i9 >>> 8) | (i8 << 24);
        iArr2[2] = (i10 >>> 8) | (i9 << 24);
        iArr2[3] = (i11 >>> 8) | (i10 << 24);
    }

    public static void xor(byte[] bArr, int i8, byte[] bArr2, int i9, byte[] bArr3, int i10) {
        int i11 = 0;
        do {
            bArr3[i10 + i11] = (byte) (bArr[i8 + i11] ^ bArr2[i9 + i11]);
            int i12 = i11 + 1;
            bArr3[i10 + i12] = (byte) (bArr2[i12 + i9] ^ bArr[i8 + i12]);
            int i13 = i11 + 2;
            bArr3[i10 + i13] = (byte) (bArr2[i13 + i9] ^ bArr[i8 + i13]);
            int i14 = i11 + 3;
            bArr3[i10 + i14] = (byte) (bArr2[i14 + i9] ^ bArr[i8 + i14]);
            i11 += 4;
        } while (i11 < 16);
    }

    public static long areEqual(long[] jArr, long[] jArr2) {
        long j4 = (jArr2[1] ^ jArr[1]) | (jArr[0] ^ jArr2[0]);
        return (((j4 & 1) | (j4 >>> 1)) - 1) >> 63;
    }

    public static byte[] asBytes(int[] iArr) {
        byte[] bArr = new byte[16];
        Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
        return bArr;
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static void multiply(int[] iArr, int[] iArr2) {
        int i8 = iArr2[0];
        int i9 = iArr2[1];
        int i10 = iArr2[2];
        int i11 = iArr2[3];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = iArr[i16];
            for (int i18 = 0; i18 < 32; i18++) {
                int i19 = i17 >> 31;
                i17 <<= 1;
                i12 ^= i8 & i19;
                i13 ^= i9 & i19;
                i14 ^= i10 & i19;
                i15 ^= i19 & i11;
                int i20 = (i11 << 31) >> 8;
                i11 = (i11 >>> 1) | (i10 << 31);
                i10 = (i10 >>> 1) | (i9 << 31);
                i9 = (i9 >>> 1) | (i8 << 31);
                i8 = (i8 >>> 1) ^ (i20 & E1);
            }
        }
        iArr[0] = i12;
        iArr[1] = i13;
        iArr[2] = i14;
        iArr[3] = i15;
    }

    public static void multiplyP(long[] jArr) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        jArr[0] = (((j8 << 63) >> 63) & E1L) ^ (j4 >>> 1);
        jArr[1] = (j4 << 63) | (j8 >>> 1);
    }

    public static void multiplyP8(long[] jArr) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 56;
        jArr[0] = (j9 >>> 7) ^ ((((j4 >>> 8) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr[1] = (j4 << 56) | (j8 >>> 8);
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        int i8 = 0;
        do {
            bArr[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
            int i9 = i8 + 1;
            bArr[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
            int i10 = i8 + 2;
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            int i11 = i8 + 3;
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            i8 += 4;
        } while (i8 < 16);
    }

    public static byte[] asBytes(long[] jArr) {
        byte[] bArr = new byte[16];
        Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
        return bArr;
    }

    public static void multiply(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr2[0];
        long j10 = jArr2[1];
        long jReverse = Longs.reverse(j4);
        long jReverse2 = Longs.reverse(j8);
        long jReverse3 = Longs.reverse(j9);
        long jReverse4 = Longs.reverse(j10);
        long jReverse5 = Longs.reverse(implMul64(jReverse, jReverse3));
        long jImplMul64 = implMul64(j4, j9) << 1;
        long jReverse6 = Longs.reverse(implMul64(jReverse2, jReverse4));
        long jImplMul642 = implMul64(j8, j10);
        long j11 = jImplMul642 << 1;
        long jReverse7 = Longs.reverse(implMul64(jReverse ^ jReverse2, jReverse3 ^ jReverse4));
        long jImplMul643 = ((implMul64(j4 ^ j8, j9 ^ j10) << 1) ^ ((jReverse6 ^ jImplMul64) ^ j11)) ^ ((jImplMul642 << 63) ^ (jImplMul642 << 58));
        jArr[0] = jReverse5 ^ ((jImplMul643 >>> 7) ^ (((jImplMul643 >>> 1) ^ jImplMul643) ^ (jImplMul643 >>> 2)));
        jArr[1] = ((jImplMul643 << 57) ^ ((jImplMul643 << 63) ^ (jImplMul643 << 62))) ^ ((jReverse7 ^ ((jImplMul64 ^ jReverse5) ^ jReverse6)) ^ (((j11 ^ (j11 >>> 1)) ^ (j11 >>> 2)) ^ (j11 >>> 7)));
    }

    public static void multiplyP(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        jArr2[0] = (((j8 << 63) >> 63) & E1L) ^ (j4 >>> 1);
        jArr2[1] = (j4 << 63) | (j8 >>> 1);
    }

    public static void multiplyP8(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = j8 << 56;
        jArr2[0] = (j9 >>> 7) ^ ((((j4 >>> 8) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2));
        jArr2[1] = (j4 << 56) | (j8 >>> 8);
    }

    public static void xor(byte[] bArr, byte[] bArr2, int i8) {
        int i9 = 0;
        do {
            bArr[i9] = (byte) (bArr[i9] ^ bArr2[i8 + i9]);
            int i10 = i9 + 1;
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i8 + i10]);
            int i11 = i9 + 2;
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i8 + i11]);
            int i12 = i9 + 3;
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i8 + i12]);
            i9 += 4;
        } while (i9 < 16);
    }

    public static void xor(byte[] bArr, byte[] bArr2, int i8, int i9) {
        while (true) {
            i9--;
            if (i9 < 0) {
                return;
            } else {
                bArr[i9] = (byte) (bArr[i9] ^ bArr2[i8 + i9]);
            }
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i8 = 0;
        do {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
            int i9 = i8 + 1;
            bArr3[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
            int i10 = i8 + 2;
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            int i11 = i8 + 3;
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            i8 += 4;
        } while (i8 < 16);
    }

    public static void xor(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] ^ iArr2[0];
        iArr[1] = iArr[1] ^ iArr2[1];
        iArr[2] = iArr[2] ^ iArr2[2];
        iArr[3] = iArr2[3] ^ iArr[3];
    }

    public static void xor(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }

    public static void xor(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] ^ jArr2[0];
        jArr[1] = jArr[1] ^ jArr2[1];
    }

    public static void xor(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }
}
