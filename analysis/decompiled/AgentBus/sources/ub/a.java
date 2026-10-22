package ub;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10220a = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            iArr3[i2] = iArr[i2] + iArr2[i2];
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i2 = 0; i2 < 10; i2++) {
            int i10 = iArr[i2];
            int i11 = iArr2[i2];
            iArr3[i2] = i10 + i11;
            iArr4[i2] = i10 - i11;
        }
    }

    public static void c(int i2, int i10, int[] iArr, int[] iArr2) {
        for (int i11 = 0; i11 < 10; i11++) {
            int i12 = iArr2[i11];
            iArr2[i11] = i12 ^ ((iArr[i10 + i11] ^ i12) & i2);
        }
    }

    public static void d(int i2, int[] iArr) {
        int i10 = 0 - i2;
        for (int i11 = 0; i11 < 10; i11++) {
            iArr[i11] = (iArr[i11] ^ i10) - i10;
        }
    }

    public static void e(int i2, int i10, int[] iArr, int[] iArr2) {
        for (int i11 = 0; i11 < 10; i11++) {
            iArr2[i10 + i11] = iArr[i2 + i11];
        }
    }

    public static void f(int i2, int i10, int[] iArr, int[] iArr2) {
        int i11 = iArr[i2];
        int i12 = iArr[i2 + 1];
        int i13 = iArr[i2 + 2];
        int i14 = iArr[i2 + 3];
        iArr2[i10] = i11 & 67108863;
        iArr2[i10 + 1] = ((i11 >>> 26) | (i12 << 6)) & 67108863;
        iArr2[i10 + 2] = ((i12 >>> 20) | (i13 << 12)) & 33554431;
        iArr2[i10 + 3] = 67108863 & ((i14 << 19) | (i13 >>> 13));
        iArr2[i10 + 4] = i14 >>> 7;
    }

    public static void g(int i2, int i10, int[] iArr, int[] iArr2) {
        int i11 = iArr[i2];
        int i12 = iArr[i2 + 1];
        int i13 = iArr[i2 + 2];
        int i14 = iArr[i2 + 3];
        int i15 = iArr[i2 + 4];
        iArr2[i10] = (i12 << 26) | i11;
        iArr2[i10 + 1] = (i12 >>> 6) | (i13 << 20);
        iArr2[i10 + 2] = (i13 >>> 12) | (i14 << 13);
        iArr2[i10 + 3] = (i15 << 7) | (i14 >>> 19);
    }

    public static void h(int[] iArr, int i2, byte[] bArr, int i10) {
        int i11 = iArr[i2];
        int i12 = iArr[i2 + 1];
        int i13 = iArr[i2 + 2];
        int i14 = iArr[i2 + 3];
        int i15 = iArr[i2 + 4];
        i(bArr, (i12 << 26) | i11, i10);
        i(bArr, (i12 >>> 6) | (i13 << 20), i10 + 4);
        i(bArr, (i13 >>> 12) | (i14 << 13), i10 + 8);
        i(bArr, (i15 << 7) | (i14 >>> 19), i10 + 12);
    }

    public static void i(byte[] bArr, int i2, int i10) {
        bArr[i10] = (byte) i2;
        bArr[i10 + 1] = (byte) (i2 >>> 8);
        bArr[i10 + 2] = (byte) (i2 >>> 16);
        bArr[i10 + 3] = (byte) (i2 >>> 24);
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = iArr[0];
        int i10 = iArr2[0];
        int i11 = iArr[1];
        int i12 = iArr2[1];
        int i13 = iArr[2];
        int i14 = iArr2[2];
        int i15 = iArr[3];
        int i16 = iArr2[3];
        int i17 = iArr[4];
        int i18 = iArr2[4];
        int i19 = iArr[5];
        int i20 = iArr2[5];
        int i21 = iArr[6];
        int i22 = iArr2[6];
        int i23 = iArr[7];
        int i24 = iArr2[7];
        int i25 = iArr[8];
        int i26 = iArr2[8];
        int i27 = iArr[9];
        int i28 = iArr2[9];
        long j2 = i2;
        long j4 = i10;
        long j10 = j2 * j4;
        long j11 = i12;
        long j12 = j2 * j11;
        long j13 = i11;
        long j14 = (j13 * j4) + j12;
        long j15 = i14;
        long j16 = (j13 * j11) + (j2 * j15);
        long j17 = i13;
        long j18 = (j17 * j4) + j16;
        long j19 = ((j17 * j11) + (j13 * j15)) << 1;
        long j20 = i16;
        long j21 = j2 * j20;
        long j22 = i15;
        long j23 = (j22 * j4) + j21 + j19;
        long j24 = (j17 * j15) << 1;
        long j25 = i18;
        long j26 = i17;
        long j27 = (j4 * j26) + (j22 * j11) + (j13 * j20) + (j2 * j25) + j24;
        long j28 = ((j26 * j11) + ((j22 * j15) + ((j17 * j20) + (j13 * j25)))) << 1;
        long j29 = (j22 * j20) + (((j26 * j15) + (j17 * j25)) << 1);
        long j30 = (j26 * j20) + (j22 * j25);
        long j31 = (j26 * j25) << 1;
        long j32 = i19;
        long j33 = i20;
        long j34 = j32 * j33;
        long j35 = i22;
        long j36 = j32 * j35;
        long j37 = i21;
        long j38 = (j37 * j33) + j36;
        long j39 = i24;
        long j40 = (j37 * j35) + (j32 * j39);
        long j41 = i23;
        long j42 = i26;
        long j43 = j32 * j42;
        long j44 = i25;
        long j45 = (j44 * j33) + j43;
        long j46 = i28;
        long j47 = (j44 * j35) + (j37 * j42) + (j32 * j46);
        long j48 = i27;
        long j49 = (j33 * j48) + j47 + ((j41 * j39) << 1);
        long j50 = j10 - (((j48 * j35) + ((j44 * j39) + ((j41 * j42) + (j37 * j46)))) * 76);
        long j51 = j14 - (((j44 * j42) + (((j48 * j39) + (j41 * j46)) << 1)) * 38);
        long j52 = j18 - (((j48 * j42) + (j44 * j46)) * 38);
        long j53 = j23 - ((j48 * j46) * 76);
        long j54 = j28 - j34;
        long j55 = j29 - j38;
        long j56 = j30 - ((j41 * j33) + j40);
        long j57 = j31 - (j45 + (((j41 * j35) + (j37 * j39)) << 1));
        int i29 = i10 + i20;
        int i30 = i11 + i21;
        long j58 = i2 + i19;
        long j59 = i29;
        long j60 = j58 * j59;
        long j61 = i12 + i22;
        long j62 = j58 * j61;
        long j63 = i30;
        long j64 = (j63 * j59) + j62;
        long j65 = i14 + i24;
        long j66 = i13 + i23;
        long j67 = (j66 * j59) + (j63 * j61) + (j58 * j65);
        long j68 = ((j66 * j61) + (j63 * j65)) << 1;
        long j69 = i16 + i26;
        long j70 = i15 + i25;
        long j71 = (j70 * j59) + (j58 * j69) + j68;
        long j72 = i18 + i28;
        long j73 = i17 + i27;
        long j74 = j59 * j73;
        long j75 = j74 + (j70 * j61) + (j63 * j69) + (j58 * j72) + ((j66 * j65) << 1);
        long j76 = ((j73 * j61) + ((j70 * j65) + ((j66 * j69) + (j63 * j72)))) << 1;
        long j77 = (j70 * j69) + (((j65 * j73) + (j66 * j72)) << 1);
        long j78 = (j73 * j69) + (j70 * j72);
        long j79 = (j71 - j53) + j57;
        int i31 = ((int) j79) & 67108863;
        long j80 = ((j75 - j27) - j49) + (j79 >> 26);
        int i32 = ((int) j80) & 33554431;
        long j81 = ((((j80 >> 25) + j76) - j54) * 38) + j50;
        iArr3[0] = ((int) j81) & 67108863;
        long j82 = ((j77 - j55) * 38) + j51 + (j81 >> 26);
        iArr3[1] = ((int) j82) & 67108863;
        long j83 = ((j78 - j56) * 38) + j52 + (j82 >> 26);
        iArr3[2] = ((int) j83) & 33554431;
        long j84 = ((((j73 * j72) << 1) - j57) * 38) + j53 + (j83 >> 25);
        iArr3[3] = ((int) j84) & 67108863;
        long j85 = (j49 * 38) + j27 + (j84 >> 26);
        iArr3[4] = ((int) j85) & 33554431;
        long j86 = (j60 - j50) + j54 + (j85 >> 25);
        iArr3[5] = ((int) j86) & 67108863;
        long j87 = (j64 - j51) + j55 + (j86 >> 26);
        iArr3[6] = ((int) j87) & 67108863;
        long j88 = (j67 - j52) + j56 + (j87 >> 26);
        iArr3[7] = ((int) j88) & 33554431;
        long j89 = (j88 >> 25) + i31;
        iArr3[8] = ((int) j89) & 67108863;
        iArr3[9] = i32 + ((int) (j89 >> 26));
    }

    public static void k(int[] iArr) {
        int i2 = (iArr[9] >>> 23) & 1;
        m(i2, iArr);
        m(-i2, iArr);
    }

    public static void l(int[] iArr) {
        iArr[0] = 1;
        for (int i2 = 1; i2 < 10; i2++) {
            iArr[i2] = 0;
        }
    }

    public static void m(int i2, int[] iArr) {
        int i10 = iArr[9];
        long j2 = (((i10 >> 24) + i2) * 19) + iArr[0];
        iArr[0] = ((int) j2) & 67108863;
        long j4 = (j2 >> 26) + iArr[1];
        iArr[1] = ((int) j4) & 67108863;
        long j10 = (j4 >> 26) + iArr[2];
        iArr[2] = ((int) j10) & 33554431;
        long j11 = (j10 >> 25) + iArr[3];
        iArr[3] = ((int) j11) & 67108863;
        long j12 = (j11 >> 26) + iArr[4];
        iArr[4] = ((int) j12) & 33554431;
        long j13 = (j12 >> 25) + iArr[5];
        iArr[5] = ((int) j13) & 67108863;
        long j14 = (j13 >> 26) + iArr[6];
        iArr[6] = ((int) j14) & 67108863;
        long j15 = (j14 >> 26) + iArr[7];
        iArr[7] = 33554431 & ((int) j15);
        long j16 = (j15 >> 25) + iArr[8];
        iArr[8] = 67108863 & ((int) j16);
        iArr[9] = (16777215 & i10) + ((int) (j16 >> 26));
    }

    public static void n(int[] iArr, int[] iArr2) {
        int i2 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        int i13 = iArr[4];
        int i14 = iArr[5];
        int i15 = iArr[6];
        int i16 = iArr[7];
        int i17 = iArr[8];
        int i18 = iArr[9];
        long j2 = i2;
        long j4 = j2 * j2;
        long j10 = i10 * 2;
        long j11 = j2 * j10;
        long j12 = i11 * 2;
        long j13 = j2 * j12;
        long j14 = i10;
        long j15 = (j14 * j14) + j13;
        long j16 = i12 * 2;
        long j17 = (j2 * j16) + (j10 * j12);
        long j18 = i13 * 2;
        long j19 = (j14 * j16) + (j2 * j18) + (i11 * j12);
        long j20 = (j12 * j16) + (j10 * j18);
        long j21 = j12 * j18;
        long j22 = i12;
        long j23 = (j22 * j22) + j21;
        long j24 = j22 * j18;
        long j25 = i14;
        long j26 = j25 * j25;
        long j27 = i15 * 2;
        long j28 = j25 * j27;
        long j29 = i16 * 2;
        long j30 = j25 * j29;
        long j31 = i15;
        long j32 = (j31 * j31) + j30;
        long j33 = j27 * j29;
        long j34 = i17 * 2;
        long j35 = i18 * 2;
        long j36 = (j31 * j34) + (j25 * j35) + (i16 * j29);
        long j37 = (j29 * j34) + (j27 * j35);
        long j38 = j29 * j35;
        long j39 = i17;
        long j40 = j4 - (j37 * 38);
        long j41 = j11 - (((j39 * j39) + j38) * 38);
        long j42 = j15 - ((j39 * j35) * 38);
        long j43 = j17 - ((i18 * j35) * 38);
        long j44 = j20 - j26;
        long j45 = j23 - j28;
        long j46 = j24 - j32;
        long j47 = (i13 * j18) - ((j25 * j34) + j33);
        int i19 = i10 + i15;
        int i20 = i11 + i16;
        int i21 = i12 + i17;
        int i22 = i13 + i18;
        long j48 = i2 + i14;
        long j49 = i19 * 2;
        long j50 = j48 * j49;
        long j51 = i20 * 2;
        long j52 = i19;
        long j53 = (j52 * j52) + (j48 * j51);
        long j54 = i21 * 2;
        long j55 = i22 * 2;
        long j56 = i21;
        long j57 = i22 * j55;
        long j58 = (((j48 * j54) + (j49 * j51)) - j43) + j47;
        int i23 = ((int) j58) & 67108863;
        long j59 = ((((j52 * j54) + ((j48 * j55) + (i20 * j51))) - j19) - j36) + (j58 >> 26);
        int i24 = ((int) j59) & 33554431;
        long j60 = ((((j59 >> 25) + ((j54 * j51) + (j49 * j55))) - j44) * 38) + j40;
        iArr2[0] = ((int) j60) & 67108863;
        long j61 = ((((j56 * j56) + (j51 * j55)) - j45) * 38) + j41 + (j60 >> 26);
        iArr2[1] = ((int) j61) & 67108863;
        long j62 = (((j56 * j55) - j46) * 38) + j42 + (j61 >> 26);
        iArr2[2] = ((int) j62) & 33554431;
        long j63 = ((j57 - j47) * 38) + j43 + (j62 >> 25);
        iArr2[3] = ((int) j63) & 67108863;
        long j64 = (j36 * 38) + j19 + (j63 >> 26);
        iArr2[4] = ((int) j64) & 33554431;
        long j65 = ((j48 * j48) - j40) + j44 + (j64 >> 25);
        iArr2[5] = ((int) j65) & 67108863;
        long j66 = (j50 - j41) + j45 + (j65 >> 26);
        iArr2[6] = ((int) j66) & 67108863;
        long j67 = (j53 - j42) + j46 + (j66 >> 26);
        iArr2[7] = ((int) j67) & 33554431;
        long j68 = (j67 >> 25) + i23;
        iArr2[8] = ((int) j68) & 67108863;
        iArr2[9] = i24 + ((int) (j68 >> 26));
    }
}
