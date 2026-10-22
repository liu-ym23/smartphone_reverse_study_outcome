package com.google.crypto.tink.subtle;

import com.google.crypto.tink.annotations.Alpha;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
final class Field25519 {
    static final int FIELD_LEN = 32;
    static final int LIMB_CNT = 10;
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;
    private static final int[] EXPAND_START = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] EXPAND_SHIFT = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] MASK = {67108863, 33554431};
    private static final int[] SHIFT = {26, 25};

    private Field25519() {
    }

    public static byte[] contract(long[] jArr) {
        int i;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                break;
            }
            int i10 = 0;
            while (i10 < 9) {
                long j10 = jArrCopyOf[i10];
                int i11 = -((int) (((j10 >> 31) & j10) >> SHIFT[i10 & 1]));
                jArrCopyOf[i10] = j10 + (i11 << r11);
                i10++;
                jArrCopyOf[i10] = jArrCopyOf[i10] - i11;
            }
            long j11 = jArrCopyOf[9];
            int i12 = -((int) (((j11 >> 31) & j11) >> 25));
            jArrCopyOf[9] = j11 + (i12 << 25);
            jArrCopyOf[0] = jArrCopyOf[0] - (i12 * 19);
            i3++;
        }
        long j12 = jArrCopyOf[0];
        jArrCopyOf[0] = j12 + (r2 << 26);
        jArrCopyOf[1] = jArrCopyOf[1] - (-((int) (((j12 >> 31) & j12) >> 26)));
        for (int i13 = 0; i13 < 2; i13++) {
            int i14 = 0;
            while (i14 < 9) {
                long j13 = jArrCopyOf[i14];
                int i15 = (int) (j13 >> SHIFT[i14 & 1]);
                jArrCopyOf[i14] = j13 & MASK[r11];
                i14++;
                jArrCopyOf[i14] = jArrCopyOf[i14] + i15;
            }
        }
        jArrCopyOf[9] = jArrCopyOf[9] & 33554431;
        long j14 = jArrCopyOf[0] + (((int) (r7 >> 25)) * 19);
        jArrCopyOf[0] = j14;
        int iGte = gte((int) j14, 67108845);
        for (int i16 = 1; i16 < 10; i16++) {
            iGte &= eq((int) jArrCopyOf[i16], MASK[i16 & 1]);
        }
        jArrCopyOf[0] = jArrCopyOf[0] - (67108845 & iGte);
        long j15 = 33554431 & iGte;
        jArrCopyOf[1] = jArrCopyOf[1] - j15;
        for (i = 2; i < 10; i += 2) {
            jArrCopyOf[i] = jArrCopyOf[i] - (67108863 & iGte);
            int i17 = i + 1;
            jArrCopyOf[i17] = jArrCopyOf[i17] - j15;
        }
        for (int i18 = 0; i18 < 10; i18++) {
            jArrCopyOf[i18] = jArrCopyOf[i18] << EXPAND_SHIFT[i18];
        }
        byte[] bArr = new byte[32];
        for (int i19 = 0; i19 < 10; i19++) {
            int i20 = EXPAND_START[i19];
            long j16 = bArr[i20];
            long j17 = jArrCopyOf[i19];
            bArr[i20] = (byte) (j16 | (j17 & 255));
            bArr[i20 + 1] = (byte) (bArr[r4] | ((j17 >> 8) & 255));
            bArr[i20 + 2] = (byte) (bArr[r4] | ((j17 >> 16) & 255));
            bArr[i20 + 3] = (byte) (bArr[r3] | ((j17 >> 24) & 255));
        }
        return bArr;
    }

    private static int eq(int i, int i3) {
        int i10 = ~(i ^ i3);
        int i11 = i10 & (i10 << 16);
        int i12 = i11 & (i11 << 8);
        int i13 = i12 & (i12 << 4);
        int i14 = i13 & (i13 << 2);
        return (i14 & (i14 << 1)) >> 31;
    }

    public static long[] expand(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i3 = EXPAND_START[i];
            jArr[i] = (((((bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8)) | ((bArr[i3 + 2] & 255) << 16)) | ((bArr[i3 + 3] & 255) << 24)) >> EXPAND_SHIFT[i]) & MASK[i & 1];
        }
        return jArr;
    }

    private static int gte(int i, int i3) {
        return ~((i - i3) >> 31);
    }

    public static void inverse(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        square(jArr3, jArr2);
        square(jArr12, jArr3);
        square(jArr11, jArr12);
        mult(jArr4, jArr11, jArr2);
        mult(jArr5, jArr4, jArr3);
        square(jArr11, jArr5);
        mult(jArr6, jArr11, jArr4);
        square(jArr11, jArr6);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        mult(jArr7, jArr11, jArr6);
        square(jArr11, jArr7);
        square(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr8, jArr12, jArr7);
        square(jArr11, jArr8);
        square(jArr12, jArr11);
        for (int i3 = 2; i3 < 20; i3 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr8);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        for (int i10 = 2; i10 < 10; i10 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr9, jArr11, jArr7);
        square(jArr11, jArr9);
        square(jArr12, jArr11);
        for (int i11 = 2; i11 < 50; i11 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr10, jArr12, jArr9);
        square(jArr12, jArr10);
        square(jArr11, jArr12);
        for (int i12 = 2; i12 < 100; i12 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr12, jArr11, jArr10);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        for (int i13 = 2; i13 < 50; i13 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr9);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        mult(jArr, jArr12, jArr5);
    }

    public static void mult(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        product(jArr4, jArr2, jArr3);
        reduce(jArr4, jArr);
    }

    public static void product(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j10 = jArr2[0];
        long j11 = jArr3[1] * j10;
        long j12 = jArr2[1];
        long j13 = jArr3[0];
        jArr[1] = (j12 * j13) + j11;
        long j14 = jArr2[1];
        long j15 = jArr3[1];
        jArr[2] = (jArr2[2] * j13) + (jArr3[2] * j10) + (j14 * 2 * j15);
        long j16 = jArr3[2];
        long j17 = jArr2[2];
        jArr[3] = (jArr2[3] * j13) + (jArr3[3] * j10) + (j17 * j15) + (j14 * j16);
        long j18 = jArr3[3];
        long j19 = jArr2[3];
        jArr[4] = (jArr2[4] * j13) + (jArr3[4] * j10) + (((j19 * j15) + (j14 * j18)) * 2) + (j17 * j16);
        long j20 = jArr3[4];
        long j21 = (j14 * j20) + (j19 * j16) + (j17 * j18);
        long j22 = jArr2[4];
        jArr[5] = (jArr2[5] * j13) + (jArr3[5] * j10) + (j22 * j15) + j21;
        long j23 = jArr3[5];
        long j24 = jArr2[5];
        jArr[6] = (jArr2[6] * j13) + (jArr3[6] * j10) + (j22 * j16) + (j17 * j20) + (((j24 * j15) + (j14 * j23) + (j19 * j18)) * 2);
        long j25 = (j24 * j16) + (j17 * j23) + (j22 * j18) + (j19 * j20);
        long j26 = jArr3[6];
        long j27 = (j14 * j26) + j25;
        long j28 = jArr2[6];
        jArr[7] = (jArr2[7] * j13) + (jArr3[7] * j10) + (j28 * j15) + j27;
        long j29 = jArr3[7];
        long j30 = (j14 * j29) + (j24 * j18) + (j19 * j23);
        long j31 = jArr2[7];
        long j32 = (((j31 * j15) + j30) * 2) + (j22 * j20);
        jArr[8] = (jArr2[8] * j13) + (jArr3[8] * j10) + (j28 * j16) + (j17 * j26) + j32;
        long j33 = (j31 * j16) + (j17 * j29) + (j28 * j18) + (j19 * j26) + (j24 * j20) + (j22 * j23);
        long j34 = jArr3[8];
        long j35 = (j14 * j34) + j33;
        long j36 = jArr2[8];
        jArr[9] = (jArr2[9] * j13) + (j10 * jArr3[9]) + (j36 * j15) + j35;
        long j37 = (j31 * j18) + (j19 * j29) + (j24 * j23);
        long j38 = jArr3[9];
        long j39 = jArr2[9];
        long j40 = j22 * j26;
        jArr[10] = (j36 * j16) + (j17 * j34) + (j28 * j20) + j40 + (((j15 * j39) + (j14 * j38) + j37) * 2);
        long j41 = j17 * j38;
        long j42 = j16 * j39;
        jArr[11] = j42 + j41 + (j36 * j18) + (j19 * j34) + (j31 * j20) + (j22 * j29) + (j28 * j23) + (j24 * j26);
        long j43 = j19 * j38;
        long j44 = j18 * j39;
        long j45 = j36 * j20;
        jArr[12] = j45 + (j22 * j34) + ((j44 + j43 + (j31 * j23) + (j24 * j29)) * 2) + (j28 * j26);
        long j46 = j22 * j38;
        long j47 = j20 * j39;
        jArr[13] = j47 + j46 + (j36 * j23) + (j24 * j34) + (j31 * j26) + (j28 * j29);
        long j48 = j23 * j39;
        long j49 = j36 * j26;
        jArr[14] = j49 + (j28 * j34) + ((j48 + (j24 * j38) + (j31 * j29)) * 2);
        long j50 = j28 * j38;
        long j51 = j26 * j39;
        jArr[15] = j51 + j50 + (j36 * j29) + (j31 * j34);
        jArr[16] = (((j29 * j39) + (j31 * j38)) * 2) + (j36 * j34);
        jArr[17] = (j34 * j39) + (j36 * j38);
        jArr[18] = j39 * 2 * j38;
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        reduceSizeByModularReduction(jArr);
        reduceCoefficients(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void reduceCoefficients(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j10 = jArr[i];
            long j11 = j10 / TWO_TO_26;
            jArr[i] = j10 - (j11 << 26);
            int i3 = i + 1;
            long j12 = jArr[i3] + j11;
            jArr[i3] = j12;
            long j13 = j12 / TWO_TO_25;
            jArr[i3] = j12 - (j13 << 25);
            i += 2;
            jArr[i] = jArr[i] + j13;
        }
        long j14 = jArr[0];
        long j15 = jArr[10];
        long j16 = j14 + (j15 << 4);
        jArr[0] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[0] = j17;
        long j18 = j17 + j15;
        jArr[0] = j18;
        jArr[10] = 0;
        long j19 = j18 / TWO_TO_26;
        jArr[0] = j18 - (j19 << 26);
        jArr[1] = jArr[1] + j19;
    }

    public static void reduceSizeByModularReduction(long[] jArr) {
        long j10 = jArr[8];
        long j11 = jArr[18];
        long j12 = j10 + (j11 << 4);
        jArr[8] = j12;
        long j13 = j12 + (j11 << 1);
        jArr[8] = j13;
        jArr[8] = j13 + j11;
        long j14 = jArr[7];
        long j15 = jArr[17];
        long j16 = j14 + (j15 << 4);
        jArr[7] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[7] = j17;
        jArr[7] = j17 + j15;
        long j18 = jArr[6];
        long j19 = jArr[16];
        long j20 = j18 + (j19 << 4);
        jArr[6] = j20;
        long j21 = j20 + (j19 << 1);
        jArr[6] = j21;
        jArr[6] = j21 + j19;
        long j22 = jArr[5];
        long j23 = jArr[15];
        long j24 = j22 + (j23 << 4);
        jArr[5] = j24;
        long j25 = j24 + (j23 << 1);
        jArr[5] = j25;
        jArr[5] = j25 + j23;
        long j26 = jArr[4];
        long j27 = jArr[14];
        long j28 = j26 + (j27 << 4);
        jArr[4] = j28;
        long j29 = j28 + (j27 << 1);
        jArr[4] = j29;
        jArr[4] = j29 + j27;
        long j30 = jArr[3];
        long j31 = jArr[13];
        long j32 = j30 + (j31 << 4);
        jArr[3] = j32;
        long j33 = j32 + (j31 << 1);
        jArr[3] = j33;
        jArr[3] = j33 + j31;
        long j34 = jArr[2];
        long j35 = jArr[12];
        long j36 = j34 + (j35 << 4);
        jArr[2] = j36;
        long j37 = j36 + (j35 << 1);
        jArr[2] = j37;
        jArr[2] = j37 + j35;
        long j38 = jArr[1];
        long j39 = jArr[11];
        long j40 = j38 + (j39 << 4);
        jArr[1] = j40;
        long j41 = j40 + (j39 << 1);
        jArr[1] = j41;
        jArr[1] = j41 + j39;
        long j42 = jArr[0];
        long j43 = jArr[10];
        long j44 = j42 + (j43 << 4);
        jArr[0] = j44;
        long j45 = j44 + (j43 << 1);
        jArr[0] = j45;
        jArr[0] = j45 + j43;
    }

    public static void scalarProduct(long[] jArr, long[] jArr2, long j10) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j10;
        }
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        squareInner(jArr3, jArr2);
        reduce(jArr3, jArr);
    }

    private static void squareInner(long[] jArr, long[] jArr2) {
        long j10 = jArr2[0];
        jArr[0] = j10 * j10;
        long j11 = jArr2[0];
        jArr[1] = j11 * 2 * jArr2[1];
        long j12 = jArr2[1];
        jArr[2] = ((jArr2[2] * j11) + (j12 * j12)) * 2;
        long j13 = jArr2[2];
        jArr[3] = ((jArr2[3] * j11) + (j12 * j13)) * 2;
        long j14 = jArr2[3];
        jArr[4] = (j11 * 2 * jArr2[4]) + (j12 * 4 * j14) + (j13 * j13);
        long j15 = jArr2[4];
        long j16 = jArr2[5] * j11;
        jArr[5] = (j16 + (j12 * j15) + (j13 * j14)) * 2;
        long j17 = jArr2[6] * j11;
        long j18 = jArr2[5];
        jArr[6] = ((j12 * 2 * j18) + j17 + (j13 * j15) + (j14 * j14)) * 2;
        long j19 = jArr2[6];
        jArr[7] = ((jArr2[7] * j11) + (j12 * j19) + (j13 * j18) + (j14 * j15)) * 2;
        long j20 = (jArr2[8] * j11) + (j13 * j19);
        long j21 = jArr2[7];
        jArr[8] = (((((j14 * j18) + (j12 * j21)) * 2) + j20) * 2) + (j15 * j15);
        long j22 = jArr2[8];
        long j23 = j12 * j22;
        jArr[9] = ((j11 * jArr2[9]) + j23 + (j13 * j21) + (j14 * j19) + (j15 * j18)) * 2;
        long j24 = jArr2[9];
        jArr[10] = ((((j12 * j24) + (j14 * j21)) * 2) + (j13 * j22) + (j15 * j19) + (j18 * j18)) * 2;
        long j25 = j13 * j24;
        jArr[11] = (j25 + (j14 * j22) + (j15 * j21) + (j18 * j19)) * 2;
        jArr[12] = (((((j14 * j24) + (j18 * j21)) * 2) + (j15 * j22)) * 2) + (j19 * j19);
        long j26 = j15 * j24;
        jArr[13] = (j26 + (j18 * j22) + (j19 * j21)) * 2;
        long j27 = j18 * 2 * j24;
        jArr[14] = (j27 + (j19 * j22) + (j21 * j21)) * 2;
        jArr[15] = ((j19 * j24) + (j21 * j22)) * 2;
        jArr[16] = (j21 * 4 * j24) + (j22 * j22);
        jArr[17] = j22 * 2 * j24;
        jArr[18] = 2 * j24 * j24;
    }

    public static void sub(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    public static void sum(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static void sub(long[] jArr, long[] jArr2) {
        sub(jArr, jArr2, jArr);
    }

    public static void sum(long[] jArr, long[] jArr2) {
        sum(jArr, jArr, jArr2);
    }
}
