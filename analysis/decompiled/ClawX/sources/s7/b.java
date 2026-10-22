package s7;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5260a = {-1, -1, -1, -3};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5261b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5262c = {-1, -1, -1, -5, 1, 0, -4, 3};
    public static final int[] d = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f5263e = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f5264f = {-1, -1073741826, -1, -1, -1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f5265g = {-21389, -2, -1, -1, -1};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f5266h = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5267i = {-457489321, -42779, -2, -1, -1, 42777, 2};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f5268j = {-4553, -2, -1, -1, -1, -1};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f5269k = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f5270l = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f5271m = {-1, -1, -2, -1, -1, -1};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f5272n = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f5273o = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f5274p = {-6803, -2, -1, -1, -1, -1, -1};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f5275q = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f5276r = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f5277s = {1, 0, 0, -1, -1, -1, -1};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f5278t = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f5279u = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f5280v = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f5281w = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f5282x = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};
    public static final int[] y = {-1, -1, -1, 0, 0, 0, 1, -1};
    public static final int[] z = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};
    public static final int[] A = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] B = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] C = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};
    public static final int[] D = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};
    public static final long[] E = {2791191049453778211L, 2791191049453778402L, 6};
    public static final long[] F = {-5270498306774157648L, 5270498306774195053L, 19634136210L};
    public static final long[] G = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};
    public static final long[] H = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void A(long[] jArr, long[] jArr2, long[] jArr3) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = (j8 >>> 46) ^ (jArr[2] << 18);
        long j10 = ((j8 << 9) ^ (j4 >>> 55)) & 36028797018963967L;
        long j11 = j4 & 36028797018963967L;
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = (j13 >>> 46) ^ (jArr2[2] << 18);
        long j15 = ((j12 >>> 55) ^ (j13 << 9)) & 36028797018963967L;
        long j16 = j12 & 36028797018963967L;
        long[] jArr4 = new long[10];
        K(jArr3, j11, j16, jArr4, 0);
        K(jArr3, j9, j14, jArr4, 2);
        long j17 = (j11 ^ j10) ^ j9;
        long j18 = (j16 ^ j15) ^ j14;
        K(jArr3, j17, j18, jArr4, 4);
        long j19 = (j10 << 1) ^ (j9 << 2);
        long j20 = (j15 << 1) ^ (j14 << 2);
        K(jArr3, j11 ^ j19, j16 ^ j20, jArr4, 6);
        K(jArr3, j17 ^ j19, j18 ^ j20, jArr4, 8);
        long j21 = jArr4[6];
        long j22 = jArr4[8] ^ j21;
        long j23 = jArr4[7];
        long j24 = j23 ^ jArr4[9];
        long j25 = (j22 << 1) ^ j21;
        long j26 = (j22 ^ (j24 << 1)) ^ j23;
        long j27 = jArr4[0];
        long j28 = jArr4[1];
        long j29 = (j28 ^ j27) ^ jArr4[4];
        long j30 = j28 ^ jArr4[5];
        long j31 = jArr4[2];
        long j32 = ((j25 ^ j27) ^ (j31 << 4)) ^ (j31 << 1);
        long j33 = jArr4[3];
        long j34 = (((j29 ^ j26) ^ (j33 << 4)) ^ (j33 << 1)) ^ (j32 >>> 55);
        long j35 = (j30 ^ j24) ^ (j34 >>> 55);
        long j36 = ((j32 & 36028797018963967L) >>> 1) ^ ((j34 & 1) << 54);
        long j37 = j36 ^ (j36 << 1);
        long j38 = j37 ^ (j37 << 2);
        long j39 = j38 ^ (j38 << 4);
        long j40 = j39 ^ (j39 << 8);
        long j41 = j40 ^ (j40 << 16);
        long j42 = (j41 ^ (j41 << 32)) & 36028797018963967L;
        long j43 = (((j34 & 36028797018963967L) >>> 1) ^ ((j35 & 1) << 54)) ^ (j42 >>> 54);
        long j44 = j43 ^ (j43 << 1);
        long j45 = j44 ^ (j44 << 2);
        long j46 = j45 ^ (j45 << 4);
        long j47 = j46 ^ (j46 << 8);
        long j48 = j47 ^ (j47 << 16);
        long j49 = 36028797018963967L & (j48 ^ (j48 << 32));
        long j50 = (j35 >>> 1) ^ (j49 >>> 54);
        long j51 = j50 ^ (j50 << 1);
        long j52 = j51 ^ (j51 << 2);
        long j53 = j52 ^ (j52 << 4);
        long j54 = j53 ^ (j53 << 8);
        long j55 = j54 ^ (j54 << 16);
        long j56 = j55 ^ (j55 << 32);
        jArr3[0] = j27;
        long j57 = (j29 ^ j42) ^ j31;
        jArr3[1] = j57;
        long j58 = ((j30 ^ j49) ^ j42) ^ j33;
        jArr3[2] = j58;
        long j59 = j49 ^ j56;
        jArr3[3] = j59;
        long j60 = j56 ^ jArr4[2];
        jArr3[4] = j60;
        long j61 = jArr4[3];
        jArr3[5] = j61;
        jArr3[0] = j27 ^ (j57 << 55);
        jArr3[1] = (j57 >>> 9) ^ (j58 << 46);
        jArr3[2] = (j58 >>> 18) ^ (j59 << 37);
        jArr3[3] = (j59 >>> 27) ^ (j60 << 28);
        jArr3[4] = (j60 >>> 36) ^ (j61 << 19);
        jArr3[5] = j61 >>> 45;
    }

    public static void A0(int[] iArr, int[] iArr2) {
        int i8 = iArr[32];
        int i9 = i8;
        int i10 = 16;
        while (true) {
            int i11 = i10 - 1;
            if (i11 < 0) {
                break;
            }
            int i12 = iArr[i10 + 15];
            iArr2[i11] = (i9 << (-9)) | (i12 >>> 9);
            i9 = i12;
            i10 = i11;
        }
        int iK = x.f.k(16, iArr, iArr2) + ((i9 << (-9)) >>> 23) + (i8 >>> 9);
        if (iK > 511 || (iK == 511 && x.f.I(16, iArr2, D))) {
            iK = (x.f.c0(iArr2) + iK) & 511;
        }
        iArr2[16] = iK;
    }

    public static void A1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        W(jArr, jArr3);
        while (true) {
            I0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                W(jArr2, jArr3);
            }
        }
    }

    public static void B(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        t(jArr, jArr4);
        t(jArr2, jArr5);
        long[] jArr6 = new long[26];
        L(jArr3, jArr4[0], jArr5[0], jArr6, 0);
        L(jArr3, jArr4[1], jArr5[1], jArr6, 2);
        L(jArr3, jArr4[2], jArr5[2], jArr6, 4);
        L(jArr3, jArr4[3], jArr5[3], jArr6, 6);
        L(jArr3, jArr4[4], jArr5[4], jArr6, 8);
        long j4 = jArr4[0];
        long j8 = j4 ^ jArr4[1];
        long j9 = jArr5[0];
        long j10 = j9 ^ jArr5[1];
        long j11 = jArr4[2];
        long j12 = j4 ^ j11;
        long j13 = jArr5[2];
        long j14 = j9 ^ j13;
        long j15 = jArr4[4];
        long j16 = j11 ^ j15;
        long j17 = jArr5[4];
        long j18 = j13 ^ j17;
        long j19 = jArr4[3];
        long j20 = j19 ^ j15;
        long j21 = jArr5[3];
        long j22 = j21 ^ j17;
        L(jArr3, j12 ^ j19, j14 ^ j21, jArr6, 18);
        L(jArr3, j16 ^ jArr4[1], j18 ^ jArr5[1], jArr6, 20);
        long j23 = j8 ^ j20;
        long j24 = j10 ^ j22;
        long j25 = j23 ^ jArr4[2];
        long j26 = jArr5[2] ^ j24;
        L(jArr3, j23, j24, jArr6, 22);
        L(jArr3, j25, j26, jArr6, 24);
        L(jArr3, j8, j10, jArr6, 10);
        L(jArr3, j12, j14, jArr6, 12);
        L(jArr3, j16, j18, jArr6, 14);
        L(jArr3, j20, j22, jArr6, 16);
        long j27 = jArr6[0];
        jArr3[0] = j27;
        long j28 = jArr6[9];
        jArr3[9] = j28;
        long j29 = jArr6[0];
        long j30 = jArr6[1] ^ j29;
        long j31 = j30 ^ jArr6[2];
        long j32 = j31 ^ jArr6[10];
        jArr3[1] = j32;
        long j33 = jArr6[3] ^ jArr6[4];
        long j34 = j31 ^ (j33 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j34;
        long j35 = j30 ^ j33;
        long j36 = jArr6[5] ^ jArr6[6];
        long j37 = jArr6[8];
        long j38 = (j35 ^ j36) ^ j37;
        long j39 = jArr6[13] ^ jArr6[14];
        long j40 = jArr6[18];
        long j41 = jArr6[22];
        long j42 = jArr6[24];
        long j43 = (j38 ^ j39) ^ ((j40 ^ j41) ^ j42);
        jArr3[3] = j43;
        long j44 = jArr6[7] ^ j37;
        long j45 = jArr6[9];
        long j46 = j44 ^ j45;
        long j47 = j46 ^ jArr6[17];
        jArr3[8] = j47;
        long j48 = (j46 ^ j36) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j48;
        long j49 = jArr6[19] ^ jArr6[20];
        long j50 = jArr6[25];
        long j51 = jArr6[23];
        long j52 = j49 ^ (j50 ^ j42);
        long j53 = (j52 ^ (j40 ^ j51)) ^ (j48 ^ j32);
        jArr3[4] = j53;
        long j54 = jArr6[21];
        long j55 = (j52 ^ (j34 ^ j47)) ^ (j54 ^ j41);
        jArr3[5] = j55;
        long j56 = (((((j29 ^ j38) ^ j45) ^ j39) ^ j54) ^ j51) ^ j50;
        jArr3[6] = j56;
        jArr3[0] = j27 ^ (j32 << 57);
        jArr3[1] = (j32 >>> 7) ^ (j34 << 50);
        jArr3[2] = (j34 >>> 14) ^ (j43 << 43);
        jArr3[3] = (j43 >>> 21) ^ (j53 << 36);
        jArr3[4] = (j53 >>> 28) ^ (j55 << 29);
        jArr3[5] = (j55 >>> 35) ^ (j56 << 22);
        jArr3[6] = (j56 >>> 42) ^ (j48 << 15);
        jArr3[7] = (j48 >>> 49) ^ (j47 << 8);
        jArr3[8] = (j47 >>> 56) ^ (j28 << 1);
        jArr3[9] = j28 >>> 63;
    }

    public static void B0(int[] iArr, int[] iArr2) {
        long j4 = 21389 & 4294967295L;
        long j8 = iArr[5] & 4294967295L;
        long j9 = (j4 * j8) + (iArr[0] & 4294967295L);
        int i8 = (int) j9;
        iArr2[0] = i8;
        long j10 = iArr[6] & 4294967295L;
        long j11 = (j4 * j10) + j8 + (iArr[1] & 4294967295L) + (j9 >>> 32);
        int i9 = (int) j11;
        iArr2[1] = i9;
        long j12 = iArr[7] & 4294967295L;
        long j13 = (j4 * j12) + j10 + (iArr[2] & 4294967295L) + (j11 >>> 32);
        int i10 = (int) j13;
        iArr2[2] = i10;
        long j14 = iArr[8] & 4294967295L;
        long j15 = (j4 * j14) + j12 + (iArr[3] & 4294967295L) + (j13 >>> 32);
        int i11 = (int) j15;
        iArr2[3] = i11;
        long j16 = iArr[9] & 4294967295L;
        long j17 = (j4 * j16) + j14 + (iArr[4] & 4294967295L) + (j15 >>> 32);
        iArr2[4] = (int) j17;
        long j18 = (j17 >>> 32) + j16;
        long j19 = j18 & 4294967295L;
        long j20 = (j4 * j19) + (i8 & 4294967295L);
        iArr2[0] = (int) j20;
        long j21 = j18 >>> 32;
        long j22 = (j4 * j21) + j19 + (i9 & 4294967295L) + (j20 >>> 32);
        iArr2[1] = (int) j22;
        long j23 = j21 + (i10 & 4294967295L) + (j22 >>> 32);
        iArr2[2] = (int) j23;
        long j24 = (j23 >>> 32) + (i11 & 4294967295L);
        iArr2[3] = (int) j24;
        if (((j24 >>> 32) == 0 ? 0 : x.f.e0(5, 4, iArr2)) != 0 || (iArr2[4] == -1 && x.f.Y(iArr2, f5265g))) {
            x.f.e(5, 21389, iArr2);
        }
    }

    public static void B1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        x.e.D(4, jArr, jArr3);
        while (true) {
            K0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.D(4, jArr2, jArr3);
            }
        }
    }

    public static void C(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[16];
        for (int i8 = 0; i8 < 9; i8++) {
            N(jArr4, jArr[i8], jArr2[i8], jArr3, i8 << 1);
        }
        long j4 = jArr3[0];
        long j8 = jArr3[1];
        long j9 = jArr3[2] ^ j4;
        long j10 = j9 ^ j8;
        jArr3[1] = j10;
        long j11 = j8 ^ jArr3[3];
        long j12 = j9 ^ jArr3[4];
        long j13 = j12 ^ j11;
        jArr3[2] = j13;
        long j14 = j11 ^ jArr3[5];
        long j15 = j12 ^ jArr3[6];
        long j16 = j15 ^ j14;
        jArr3[3] = j16;
        long j17 = j14 ^ jArr3[7];
        long j18 = j15 ^ jArr3[8];
        long j19 = j18 ^ j17;
        jArr3[4] = j19;
        long j20 = j17 ^ jArr3[9];
        long j21 = j18 ^ jArr3[10];
        long j22 = j21 ^ j20;
        jArr3[5] = j22;
        long j23 = j20 ^ jArr3[11];
        long j24 = j21 ^ jArr3[12];
        long j25 = j24 ^ j23;
        jArr3[6] = j25;
        long j26 = j23 ^ jArr3[13];
        long j27 = j24 ^ jArr3[14];
        long j28 = j27 ^ j26;
        jArr3[7] = j28;
        long j29 = j26 ^ jArr3[15];
        long j30 = j27 ^ jArr3[16];
        long j31 = j30 ^ j29;
        jArr3[8] = j31;
        long j32 = (j29 ^ jArr3[17]) ^ j30;
        jArr3[9] = j4 ^ j32;
        jArr3[10] = j10 ^ j32;
        jArr3[11] = j13 ^ j32;
        jArr3[12] = j16 ^ j32;
        jArr3[13] = j19 ^ j32;
        jArr3[14] = j22 ^ j32;
        jArr3[15] = j25 ^ j32;
        jArr3[16] = j28 ^ j32;
        jArr3[17] = j31 ^ j32;
        N(jArr4, jArr[0] ^ jArr[1], jArr2[0] ^ jArr2[1], jArr3, 1);
        N(jArr4, jArr[0] ^ jArr[2], jArr2[0] ^ jArr2[2], jArr3, 2);
        N(jArr4, jArr[0] ^ jArr[3], jArr2[0] ^ jArr2[3], jArr3, 3);
        N(jArr4, jArr[1] ^ jArr[2], jArr2[1] ^ jArr2[2], jArr3, 3);
        N(jArr4, jArr[0] ^ jArr[4], jArr2[0] ^ jArr2[4], jArr3, 4);
        N(jArr4, jArr[1] ^ jArr[3], jArr2[1] ^ jArr2[3], jArr3, 4);
        N(jArr4, jArr[0] ^ jArr[5], jArr2[0] ^ jArr2[5], jArr3, 5);
        N(jArr4, jArr[1] ^ jArr[4], jArr2[1] ^ jArr2[4], jArr3, 5);
        N(jArr4, jArr[2] ^ jArr[3], jArr2[2] ^ jArr2[3], jArr3, 5);
        N(jArr4, jArr[0] ^ jArr[6], jArr2[0] ^ jArr2[6], jArr3, 6);
        N(jArr4, jArr[1] ^ jArr[5], jArr2[1] ^ jArr2[5], jArr3, 6);
        N(jArr4, jArr[2] ^ jArr[4], jArr2[2] ^ jArr2[4], jArr3, 6);
        N(jArr4, jArr[0] ^ jArr[7], jArr2[0] ^ jArr2[7], jArr3, 7);
        N(jArr4, jArr[1] ^ jArr[6], jArr2[1] ^ jArr2[6], jArr3, 7);
        N(jArr4, jArr[2] ^ jArr[5], jArr2[2] ^ jArr2[5], jArr3, 7);
        N(jArr4, jArr[3] ^ jArr[4], jArr2[3] ^ jArr2[4], jArr3, 7);
        N(jArr4, jArr[0] ^ jArr[8], jArr2[0] ^ jArr2[8], jArr3, 8);
        N(jArr4, jArr[1] ^ jArr[7], jArr2[1] ^ jArr2[7], jArr3, 8);
        N(jArr4, jArr[2] ^ jArr[6], jArr2[2] ^ jArr2[6], jArr3, 8);
        N(jArr4, jArr[3] ^ jArr[5], jArr2[3] ^ jArr2[5], jArr3, 8);
        N(jArr4, jArr[1] ^ jArr[8], jArr2[1] ^ jArr2[8], jArr3, 9);
        N(jArr4, jArr[2] ^ jArr[7], jArr2[2] ^ jArr2[7], jArr3, 9);
        N(jArr4, jArr[3] ^ jArr[6], jArr2[3] ^ jArr2[6], jArr3, 9);
        N(jArr4, jArr[4] ^ jArr[5], jArr2[4] ^ jArr2[5], jArr3, 9);
        N(jArr4, jArr[2] ^ jArr[8], jArr2[2] ^ jArr2[8], jArr3, 10);
        N(jArr4, jArr[3] ^ jArr[7], jArr2[3] ^ jArr2[7], jArr3, 10);
        N(jArr4, jArr[4] ^ jArr[6], jArr2[4] ^ jArr2[6], jArr3, 10);
        N(jArr4, jArr[3] ^ jArr[8], jArr2[3] ^ jArr2[8], jArr3, 11);
        N(jArr4, jArr[4] ^ jArr[7], jArr2[4] ^ jArr2[7], jArr3, 11);
        N(jArr4, jArr[5] ^ jArr[6], jArr2[5] ^ jArr2[6], jArr3, 11);
        N(jArr4, jArr[4] ^ jArr[8], jArr2[4] ^ jArr2[8], jArr3, 12);
        N(jArr4, jArr[5] ^ jArr[7], jArr2[5] ^ jArr2[7], jArr3, 12);
        N(jArr4, jArr[5] ^ jArr[8], jArr2[5] ^ jArr2[8], jArr3, 13);
        N(jArr4, jArr[6] ^ jArr[7], jArr2[6] ^ jArr2[7], jArr3, 13);
        N(jArr4, jArr[6] ^ jArr[8], jArr2[6] ^ jArr2[8], jArr3, 14);
        N(jArr4, jArr[7] ^ jArr[8], jArr2[7] ^ jArr2[8], jArr3, 15);
    }

    public static void C0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = jArr[8];
        long j16 = j11 ^ ((((j15 >>> 27) ^ (j15 >>> 22)) ^ (j15 >>> 20)) ^ (j15 >>> 15));
        long j17 = j4 ^ ((((j12 << 37) ^ (j12 << 42)) ^ (j12 << 44)) ^ (j12 << 49));
        long j18 = (j8 ^ ((((j13 << 37) ^ (j13 << 42)) ^ (j13 << 44)) ^ (j13 << 49))) ^ ((((j12 >>> 27) ^ (j12 >>> 22)) ^ (j12 >>> 20)) ^ (j12 >>> 15));
        long j19 = j16 >>> 27;
        jArr2[0] = (((j17 ^ j19) ^ (j19 << 5)) ^ (j19 << 7)) ^ (j19 << 12);
        jArr2[1] = j18;
        jArr2[2] = (j9 ^ ((((j14 << 37) ^ (j14 << 42)) ^ (j14 << 44)) ^ (j14 << 49))) ^ ((((j13 >>> 27) ^ (j13 >>> 22)) ^ (j13 >>> 20)) ^ (j13 >>> 15));
        jArr2[3] = (j10 ^ ((((j15 << 37) ^ (j15 << 42)) ^ (j15 << 44)) ^ (j15 << 49))) ^ ((((j14 >>> 27) ^ (j14 >>> 22)) ^ (j14 >>> 20)) ^ (j14 >>> 15));
        jArr2[4] = 134217727 & j16;
    }

    public static void C1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        x.e.D(4, jArr, jArr3);
        while (true) {
            M0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.D(4, jArr2, jArr3);
            }
        }
    }

    public static void D(long[] jArr, long[] jArr2, long[] jArr3) {
        long j4 = jArr[0];
        long j8 = ((jArr[1] << 7) ^ (j4 >>> 57)) & 144115188075855871L;
        long j9 = j4 & 144115188075855871L;
        long j10 = jArr2[0];
        long j11 = ((j10 >>> 57) ^ (jArr2[1] << 7)) & 144115188075855871L;
        long j12 = j10 & 144115188075855871L;
        long[] jArr4 = new long[6];
        M(jArr3, j9, j12, jArr4, 0);
        M(jArr3, j8, j11, jArr4, 2);
        M(jArr3, j9 ^ j8, j12 ^ j11, jArr4, 4);
        long j13 = jArr4[1] ^ jArr4[2];
        long j14 = jArr4[0];
        long j15 = jArr4[3];
        long j16 = (jArr4[4] ^ j14) ^ j13;
        long j17 = j13 ^ (jArr4[5] ^ j15);
        jArr3[0] = j14 ^ (j16 << 57);
        jArr3[1] = (j16 >>> 7) ^ (j17 << 50);
        jArr3[2] = (j17 >>> 14) ^ (j15 << 43);
        jArr3[3] = j15 >>> 21;
    }

    public static void D0(int[] iArr, int[] iArr2) {
        long j4 = 4553 & 4294967295L;
        long j8 = iArr[6] & 4294967295L;
        long j9 = (j4 * j8) + (iArr[0] & 4294967295L);
        int i8 = (int) j9;
        iArr2[0] = i8;
        long j10 = iArr[7] & 4294967295L;
        long j11 = (j4 * j10) + j8 + (iArr[1] & 4294967295L) + (j9 >>> 32);
        int i9 = (int) j11;
        iArr2[1] = i9;
        long j12 = iArr[8] & 4294967295L;
        long j13 = (j4 * j12) + j10 + (iArr[2] & 4294967295L) + (j11 >>> 32);
        int i10 = (int) j13;
        iArr2[2] = i10;
        long j14 = iArr[9] & 4294967295L;
        long j15 = (j4 * j14) + j12 + (iArr[3] & 4294967295L) + (j13 >>> 32);
        int i11 = (int) j15;
        iArr2[3] = i11;
        long j16 = iArr[10] & 4294967295L;
        long j17 = (j4 * j16) + j14 + (iArr[4] & 4294967295L) + (j15 >>> 32);
        iArr2[4] = (int) j17;
        long j18 = iArr[11] & 4294967295L;
        long j19 = (j4 * j18) + j16 + (iArr[5] & 4294967295L) + (j17 >>> 32);
        iArr2[5] = (int) j19;
        long j20 = (j19 >>> 32) + j18;
        long j21 = j20 & 4294967295L;
        long j22 = (j4 * j21) + (i8 & 4294967295L);
        iArr2[0] = (int) j22;
        long j23 = j20 >>> 32;
        long j24 = (j4 * j23) + j21 + (i9 & 4294967295L) + (j22 >>> 32);
        iArr2[1] = (int) j24;
        long j25 = j23 + (i10 & 4294967295L) + (j24 >>> 32);
        iArr2[2] = (int) j25;
        long j26 = (j25 >>> 32) + (i11 & 4294967295L);
        iArr2[3] = (int) j26;
        if (((j26 >>> 32) == 0 ? 0 : x.f.e0(6, 4, iArr2)) != 0 || (iArr2[5] == -1 && x.e.O(iArr2, f5268j))) {
            x.f.e(6, 4553, iArr2);
        }
    }

    public static void D1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[13];
        X(jArr, jArr3);
        while (true) {
            O0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                X(jArr2, jArr3);
            }
        }
    }

    public static void E(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        u(jArr, jArr4);
        u(jArr2, jArr5);
        long[] jArr6 = new long[8];
        O(jArr6, jArr4[0], jArr5[0], jArr3, 0);
        O(jArr6, jArr4[1], jArr5[1], jArr3, 1);
        O(jArr6, jArr4[2], jArr5[2], jArr3, 2);
        O(jArr6, jArr4[3], jArr5[3], jArr3, 3);
        for (int i8 = 5; i8 > 0; i8--) {
            jArr3[i8] = jArr3[i8] ^ jArr3[i8 - 1];
        }
        O(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        O(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i9 = 7; i9 > 1; i9--) {
            jArr3[i9] = jArr3[i9] ^ jArr3[i9 - 2];
        }
        long j4 = jArr4[0] ^ jArr4[2];
        long j8 = jArr4[1] ^ jArr4[3];
        long j9 = jArr5[0] ^ jArr5[2];
        long j10 = jArr5[3] ^ jArr5[1];
        O(jArr6, j4 ^ j8, j9 ^ j10, jArr3, 3);
        long[] jArr7 = new long[3];
        O(jArr6, j4, j9, jArr7, 0);
        O(jArr6, j8, j10, jArr7, 1);
        long j11 = jArr7[0];
        long j12 = jArr7[1];
        long j13 = jArr7[2];
        long j14 = jArr3[2] ^ j11;
        jArr3[2] = j14;
        long j15 = jArr3[3] ^ (j11 ^ j12);
        jArr3[3] = j15;
        long j16 = jArr3[4] ^ (j12 ^ j13);
        jArr3[4] = j16;
        long j17 = jArr3[5] ^ j13;
        jArr3[5] = j17;
        long j18 = jArr3[0];
        long j19 = jArr3[1];
        long j20 = jArr3[6];
        long j21 = jArr3[7];
        jArr3[0] = j18 ^ (j19 << 49);
        jArr3[1] = (j19 >>> 15) ^ (j14 << 34);
        jArr3[2] = (j14 >>> 30) ^ (j15 << 19);
        jArr3[3] = ((j15 >>> 45) ^ (j16 << 4)) ^ (j17 << 53);
        jArr3[4] = ((j16 >>> 60) ^ (j20 << 38)) ^ (j17 >>> 11);
        jArr3[5] = (j20 >>> 26) ^ (j21 << 23);
        jArr3[6] = j21 >>> 41;
        jArr3[7] = 0;
    }

    public static void E0(long[] jArr, long[] jArr2) {
        long j4 = jArr[9];
        long j8 = jArr[17];
        long j9 = (((j4 ^ (j8 >>> 59)) ^ (j8 >>> 57)) ^ (j8 >>> 54)) ^ (j8 >>> 49);
        long j10 = (j8 << 15) ^ (((jArr[8] ^ (j8 << 5)) ^ (j8 << 7)) ^ (j8 << 10));
        for (int i8 = 16; i8 >= 10; i8--) {
            long j11 = jArr[i8];
            jArr2[i8 - 8] = (((j10 ^ (j11 >>> 59)) ^ (j11 >>> 57)) ^ (j11 >>> 54)) ^ (j11 >>> 49);
            j10 = (((jArr[i8 - 9] ^ (j11 << 5)) ^ (j11 << 7)) ^ (j11 << 10)) ^ (j11 << 15);
        }
        jArr2[1] = (((j10 ^ (j9 >>> 59)) ^ (j9 >>> 57)) ^ (j9 >>> 54)) ^ (j9 >>> 49);
        long j12 = (j9 << 15) ^ (((jArr[0] ^ (j9 << 5)) ^ (j9 << 7)) ^ (j9 << 10));
        long j13 = jArr2[8];
        long j14 = j13 >>> 59;
        jArr2[0] = (((j12 ^ j14) ^ (j14 << 2)) ^ (j14 << 5)) ^ (j14 << 10);
        jArr2[8] = 576460752303423487L & j13;
    }

    public static void E1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.e.l0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 1;
            iArr3[0] = (int) j4;
            long j8 = j4 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr3[1] & 4294967295L);
                iArr3[1] = (int) j9;
                long j10 = (j9 >> 32) + (iArr3[2] & 4294967295L);
                iArr3[2] = (int) j10;
                j8 = j10 >> 32;
            }
            iArr3[3] = (int) (((4294967295L & iArr3[3]) - 2) + j8);
        }
    }

    public static void F(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        v(jArr, jArr4);
        v(jArr2, jArr5);
        long[] jArr6 = new long[8];
        P(jArr6, jArr4[0], jArr5[0], jArr3, 0);
        P(jArr6, jArr4[1], jArr5[1], jArr3, 1);
        P(jArr6, jArr4[2], jArr5[2], jArr3, 2);
        P(jArr6, jArr4[3], jArr5[3], jArr3, 3);
        for (int i8 = 5; i8 > 0; i8--) {
            jArr3[i8] = jArr3[i8] ^ jArr3[i8 - 1];
        }
        P(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        P(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i9 = 7; i9 > 1; i9--) {
            jArr3[i9] = jArr3[i9] ^ jArr3[i9 - 2];
        }
        long j4 = jArr4[0] ^ jArr4[2];
        long j8 = jArr4[1] ^ jArr4[3];
        long j9 = jArr5[0] ^ jArr5[2];
        long j10 = jArr5[3] ^ jArr5[1];
        P(jArr6, j4 ^ j8, j9 ^ j10, jArr3, 3);
        long[] jArr7 = new long[3];
        P(jArr6, j4, j9, jArr7, 0);
        P(jArr6, j8, j10, jArr7, 1);
        long j11 = jArr7[0];
        long j12 = jArr7[1];
        long j13 = jArr7[2];
        long j14 = jArr3[2] ^ j11;
        jArr3[2] = j14;
        long j15 = jArr3[3] ^ (j11 ^ j12);
        jArr3[3] = j15;
        long j16 = jArr3[4] ^ (j12 ^ j13);
        jArr3[4] = j16;
        long j17 = jArr3[5] ^ j13;
        jArr3[5] = j17;
        long j18 = jArr3[0];
        long j19 = jArr3[1];
        long j20 = jArr3[6];
        long j21 = jArr3[7];
        jArr3[0] = j18 ^ (j19 << 59);
        jArr3[1] = (j19 >>> 5) ^ (j14 << 54);
        jArr3[2] = (j14 >>> 10) ^ (j15 << 49);
        jArr3[3] = (j15 >>> 15) ^ (j16 << 44);
        jArr3[4] = (j16 >>> 20) ^ (j17 << 39);
        jArr3[5] = (j17 >>> 25) ^ (j20 << 34);
        jArr3[6] = (j20 >>> 30) ^ (j21 << 29);
        jArr3[7] = j21 >>> 35;
    }

    public static void F0(int[] iArr, int[] iArr2) {
        long j4 = iArr[6] & 4294967295L;
        long j8 = iArr[7] & 4294967295L;
        long j9 = (iArr[10] & 4294967295L) + j4;
        long j10 = (iArr[11] & 4294967295L) + j8;
        long j11 = (iArr[0] & 4294967295L) + j9;
        int i8 = (int) j11;
        long j12 = (iArr[1] & 4294967295L) + j10 + (j11 >> 32);
        int i9 = (int) j12;
        iArr2[1] = i9;
        long j13 = j9 + (iArr[8] & 4294967295L);
        long j14 = j10 + (iArr[9] & 4294967295L);
        long j15 = (iArr[2] & 4294967295L) + j13 + (j12 >> 32);
        long j16 = j15 & 4294967295L;
        long j17 = (iArr[3] & 4294967295L) + j14 + (j15 >> 32);
        iArr2[3] = (int) j17;
        long j18 = (iArr[4] & 4294967295L) + (j13 - j4) + (j17 >> 32);
        iArr2[4] = (int) j18;
        long j19 = (iArr[5] & 4294967295L) + (j14 - j8) + (j18 >> 32);
        iArr2[5] = (int) j19;
        long j20 = j19 >> 32;
        long j21 = j16 + j20;
        long j22 = j20 + (i8 & 4294967295L);
        iArr2[0] = (int) j22;
        long j23 = j22 >> 32;
        if (j23 != 0) {
            long j24 = j23 + (i9 & 4294967295L);
            iArr2[1] = (int) j24;
            j21 += j24 >> 32;
        }
        iArr2[2] = (int) j21;
        if (((j21 >> 32) == 0 || x.f.d0(6, 3, iArr2) == 0) && !(iArr2[5] == -1 && x.e.O(iArr2, f5271m))) {
            return;
        }
        p(iArr2);
    }

    public static void F1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.D0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - (4294967295L & (-2147483647));
            iArr3[0] = (int) j4;
            if ((j4 >> 32) == 0) {
                return;
            }
            x.f.B(5, 1, iArr3);
        }
    }

    public static void G(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        w(jArr, jArr4);
        w(jArr2, jArr5);
        long[] jArr6 = new long[8];
        Q(jArr6, jArr4[0], jArr5[0], jArr3, 0);
        Q(jArr6, jArr4[1], jArr5[1], jArr3, 1);
        Q(jArr6, jArr4[2], jArr5[2], jArr3, 2);
        Q(jArr6, jArr4[3], jArr5[3], jArr3, 3);
        for (int i8 = 5; i8 > 0; i8--) {
            jArr3[i8] = jArr3[i8] ^ jArr3[i8 - 1];
        }
        Q(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        Q(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i9 = 7; i9 > 1; i9--) {
            jArr3[i9] = jArr3[i9] ^ jArr3[i9 - 2];
        }
        long j4 = jArr4[0] ^ jArr4[2];
        long j8 = jArr4[1] ^ jArr4[3];
        long j9 = jArr5[0] ^ jArr5[2];
        long j10 = jArr5[3] ^ jArr5[1];
        Q(jArr6, j4 ^ j8, j9 ^ j10, jArr3, 3);
        long[] jArr7 = new long[3];
        Q(jArr6, j4, j9, jArr7, 0);
        Q(jArr6, j8, j10, jArr7, 1);
        long j11 = jArr7[0];
        long j12 = jArr7[1];
        long j13 = jArr7[2];
        long j14 = jArr3[2] ^ j11;
        jArr3[2] = j14;
        long j15 = jArr3[3] ^ (j11 ^ j12);
        jArr3[3] = j15;
        long j16 = jArr3[4] ^ (j12 ^ j13);
        jArr3[4] = j16;
        long j17 = jArr3[5] ^ j13;
        jArr3[5] = j17;
        long j18 = jArr3[0];
        long j19 = jArr3[1];
        long j20 = jArr3[6];
        long j21 = jArr3[7];
        jArr3[0] = j18 ^ (j19 << 60);
        jArr3[1] = (j19 >>> 4) ^ (j14 << 56);
        jArr3[2] = (j14 >>> 8) ^ (j15 << 52);
        jArr3[3] = (j15 >>> 12) ^ (j16 << 48);
        jArr3[4] = (j16 >>> 16) ^ (j17 << 44);
        jArr3[5] = (j17 >>> 20) ^ (j20 << 40);
        jArr3[6] = (j20 >>> 24) ^ (j21 << 36);
        jArr3[7] = j21 >>> 28;
    }

    public static void G0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = j9 ^ ((j10 >>> 40) ^ (j10 >>> 49));
        long j12 = j4 ^ ((j11 << 15) ^ (j11 << 24));
        long j13 = (j8 ^ ((j10 << 15) ^ (j10 << 24))) ^ ((j11 >>> 40) ^ (j11 >>> 49));
        long j14 = j13 >>> 49;
        jArr2[0] = (j12 ^ j14) ^ (j14 << 9);
        jArr2[1] = 562949953421311L & j13;
    }

    public static void G1(int[] iArr, int[] iArr2, int[] iArr3) {
        int iC0 = (x.f.C0(iArr, iArr2, 16, iArr3) + iArr[16]) - iArr2[16];
        if (iC0 < 0) {
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= 16) {
                    i8 = -1;
                    break;
                }
                int i10 = iArr3[i9] - 1;
                iArr3[i9] = i10;
                if (i10 != -1) {
                    break;
                } else {
                    i9++;
                }
            }
            iC0 = (iC0 + i8) & 511;
        }
        iArr3[16] = iC0;
    }

    public static void H(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        x(jArr, jArr4);
        x(jArr2, jArr5);
        long[] jArr6 = new long[8];
        for (int i8 = 0; i8 < 7; i8++) {
            R(jArr6, jArr4[i8], jArr5[i8], jArr3, i8 << 1);
        }
        long j4 = jArr3[0];
        long j8 = jArr3[1];
        long j9 = jArr3[2] ^ j4;
        long j10 = j9 ^ j8;
        jArr3[1] = j10;
        long j11 = j8 ^ jArr3[3];
        long j12 = j9 ^ jArr3[4];
        long j13 = j12 ^ j11;
        jArr3[2] = j13;
        long j14 = j11 ^ jArr3[5];
        long j15 = j12 ^ jArr3[6];
        long j16 = j15 ^ j14;
        jArr3[3] = j16;
        long j17 = j14 ^ jArr3[7];
        long j18 = j15 ^ jArr3[8];
        long j19 = j18 ^ j17;
        jArr3[4] = j19;
        long j20 = j17 ^ jArr3[9];
        long j21 = j18 ^ jArr3[10];
        long j22 = j21 ^ j20;
        jArr3[5] = j22;
        long j23 = j20 ^ jArr3[11];
        long j24 = j21 ^ jArr3[12];
        long j25 = j24 ^ j23;
        jArr3[6] = j25;
        long j26 = (j23 ^ jArr3[13]) ^ j24;
        jArr3[7] = j4 ^ j26;
        jArr3[8] = j10 ^ j26;
        jArr3[9] = j13 ^ j26;
        jArr3[10] = j16 ^ j26;
        jArr3[11] = j19 ^ j26;
        jArr3[12] = j22 ^ j26;
        jArr3[13] = j25 ^ j26;
        R(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        R(jArr6, jArr4[0] ^ jArr4[2], jArr5[0] ^ jArr5[2], jArr3, 2);
        R(jArr6, jArr4[0] ^ jArr4[3], jArr5[0] ^ jArr5[3], jArr3, 3);
        R(jArr6, jArr4[1] ^ jArr4[2], jArr5[1] ^ jArr5[2], jArr3, 3);
        R(jArr6, jArr4[0] ^ jArr4[4], jArr5[0] ^ jArr5[4], jArr3, 4);
        R(jArr6, jArr4[1] ^ jArr4[3], jArr5[1] ^ jArr5[3], jArr3, 4);
        R(jArr6, jArr4[0] ^ jArr4[5], jArr5[0] ^ jArr5[5], jArr3, 5);
        R(jArr6, jArr4[1] ^ jArr4[4], jArr5[1] ^ jArr5[4], jArr3, 5);
        R(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 5);
        R(jArr6, jArr4[0] ^ jArr4[6], jArr5[0] ^ jArr5[6], jArr3, 6);
        R(jArr6, jArr4[1] ^ jArr4[5], jArr5[1] ^ jArr5[5], jArr3, 6);
        R(jArr6, jArr4[2] ^ jArr4[4], jArr5[2] ^ jArr5[4], jArr3, 6);
        R(jArr6, jArr4[1] ^ jArr4[6], jArr5[1] ^ jArr5[6], jArr3, 7);
        R(jArr6, jArr4[2] ^ jArr4[5], jArr5[2] ^ jArr5[5], jArr3, 7);
        R(jArr6, jArr4[3] ^ jArr4[4], jArr5[3] ^ jArr5[4], jArr3, 7);
        R(jArr6, jArr4[2] ^ jArr4[6], jArr5[2] ^ jArr5[6], jArr3, 8);
        R(jArr6, jArr4[3] ^ jArr4[5], jArr5[3] ^ jArr5[5], jArr3, 8);
        R(jArr6, jArr4[3] ^ jArr4[6], jArr5[3] ^ jArr5[6], jArr3, 9);
        R(jArr6, jArr4[4] ^ jArr4[5], jArr5[4] ^ jArr5[5], jArr3, 9);
        R(jArr6, jArr4[4] ^ jArr4[6], jArr5[4] ^ jArr5[6], jArr3, 10);
        R(jArr6, jArr4[5] ^ jArr4[6], jArr5[5] ^ jArr5[6], jArr3, 11);
        long j27 = jArr3[0];
        long j28 = jArr3[1];
        long j29 = jArr3[2];
        long j30 = jArr3[3];
        long j31 = jArr3[4];
        long j32 = jArr3[5];
        long j33 = jArr3[6];
        long j34 = jArr3[7];
        long j35 = jArr3[8];
        long j36 = jArr3[9];
        long j37 = jArr3[10];
        long j38 = jArr3[11];
        long j39 = jArr3[12];
        long j40 = jArr3[13];
        jArr3[0] = j27 ^ (j28 << 59);
        jArr3[1] = (j28 >>> 5) ^ (j29 << 54);
        jArr3[2] = (j29 >>> 10) ^ (j30 << 49);
        jArr3[3] = (j30 >>> 15) ^ (j31 << 44);
        jArr3[4] = (j31 >>> 20) ^ (j32 << 39);
        jArr3[5] = (j32 >>> 25) ^ (j33 << 34);
        jArr3[6] = (j33 >>> 30) ^ (j34 << 29);
        jArr3[7] = (j34 >>> 35) ^ (j35 << 24);
        jArr3[8] = (j35 >>> 40) ^ (j36 << 19);
        jArr3[9] = (j36 >>> 45) ^ (j37 << 14);
        jArr3[10] = (j37 >>> 50) ^ (j38 << 9);
        jArr3[11] = ((j38 >>> 55) ^ (j39 << 4)) ^ (j40 << 63);
        jArr3[12] = j40 >>> 1;
    }

    public static void H0(int[] iArr, int[] iArr2) {
        long j4 = 6803 & 4294967295L;
        long j8 = iArr[7] & 4294967295L;
        long j9 = (j4 * j8) + (iArr[0] & 4294967295L);
        int i8 = (int) j9;
        iArr2[0] = i8;
        long j10 = iArr[8] & 4294967295L;
        long j11 = (j4 * j10) + j8 + (iArr[1] & 4294967295L) + (j9 >>> 32);
        int i9 = (int) j11;
        iArr2[1] = i9;
        long j12 = iArr[9] & 4294967295L;
        long j13 = (j4 * j12) + j10 + (iArr[2] & 4294967295L) + (j11 >>> 32);
        int i10 = (int) j13;
        iArr2[2] = i10;
        long j14 = iArr[10] & 4294967295L;
        long j15 = (j4 * j14) + j12 + (iArr[3] & 4294967295L) + (j13 >>> 32);
        int i11 = (int) j15;
        iArr2[3] = i11;
        long j16 = iArr[11] & 4294967295L;
        long j17 = (j4 * j16) + j14 + (iArr[4] & 4294967295L) + (j15 >>> 32);
        iArr2[4] = (int) j17;
        long j18 = iArr[12] & 4294967295L;
        long j19 = (j4 * j18) + j16 + (iArr[5] & 4294967295L) + (j17 >>> 32);
        iArr2[5] = (int) j19;
        long j20 = iArr[13] & 4294967295L;
        long j21 = (j4 * j20) + j18 + (iArr[6] & 4294967295L) + (j19 >>> 32);
        iArr2[6] = (int) j21;
        long j22 = (j21 >>> 32) + j20;
        long j23 = j22 & 4294967295L;
        long j24 = (j4 * j23) + (i8 & 4294967295L);
        iArr2[0] = (int) j24;
        long j25 = j22 >>> 32;
        long j26 = (j4 * j25) + j23 + (i9 & 4294967295L) + (j24 >>> 32);
        iArr2[1] = (int) j26;
        long j27 = j25 + (i10 & 4294967295L) + (j26 >>> 32);
        iArr2[2] = (int) j27;
        long j28 = (j27 >>> 32) + (i11 & 4294967295L);
        iArr2[3] = (int) j28;
        if (((j28 >>> 32) == 0 ? 0 : x.f.e0(7, 4, iArr2)) != 0 || (iArr2[6] == -1 && x.f.Z(iArr2, f5274p))) {
            x.f.e(7, 6803, iArr2);
        }
    }

    public static void H1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.D0(iArr, iArr2, iArr3) != 0) {
            x.f.G0(5, 21389, iArr3);
        }
    }

    public static void I(long[] jArr, long[] jArr2, long[] jArr3) {
        int i8 = 56;
        while (true) {
            long j4 = 0;
            int i9 = 0;
            if (i8 < 0) {
                break;
            }
            for (int i10 = 1; i10 < 9; i10 += 2) {
                int i11 = (int) (jArr[i10] >>> i8);
                e(jArr2, (i11 & 15) * 9, jArr2, (((i11 >>> 4) & 15) + 16) * 9, jArr3, i10 - 1);
            }
            while (i9 < 16) {
                long j8 = jArr3[i9];
                jArr3[i9] = (j4 >>> (-8)) | (j8 << 8);
                i9++;
                j4 = j8;
            }
            i8 -= 8;
        }
        for (int i12 = 56; i12 >= 0; i12 -= 8) {
            int i13 = 0;
            while (i13 < 9) {
                int i14 = (int) (jArr[i13] >>> i12);
                int i15 = i13;
                e(jArr2, (i14 & 15) * 9, jArr2, (((i14 >>> 4) & 15) + 16) * 9, jArr3, i15);
                i13 = i15 + 2;
            }
            if (i12 > 0) {
                long j9 = 0;
                int i16 = 0;
                while (i16 < 18) {
                    long j10 = jArr3[i16];
                    jArr3[i16] = (j9 >>> (-8)) | (j10 << 8);
                    i16++;
                    j9 = j10;
                }
            }
        }
    }

    public static void I0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = j11 ^ (j13 >>> 50);
        long j15 = (j10 ^ ((j13 >>> 1) ^ (j13 << 14))) ^ (j12 >>> 50);
        long j16 = j4 ^ (j14 << 63);
        long j17 = (j8 ^ (j12 << 63)) ^ ((j14 >>> 1) ^ (j14 << 14));
        long j18 = ((j9 ^ (j13 << 63)) ^ ((j12 >>> 1) ^ (j12 << 14))) ^ (j14 >>> 50);
        long j19 = j15 >>> 1;
        jArr2[0] = (j16 ^ j19) ^ (j19 << 15);
        jArr2[1] = (j15 >>> 50) ^ j17;
        jArr2[2] = j18;
        jArr2[3] = 1 & j15;
    }

    public static void I1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.e.n0(iArr, iArr2, iArr3) != 0) {
            x.f.G0(6, 4553, iArr3);
        }
    }

    public static void J(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        int i9 = (int) j4;
        long j13 = (((jArr[i9 & 7] ^ (jArr[(i9 >>> 3) & 7] << 3)) ^ (jArr[(i9 >>> 6) & 7] << 6)) ^ (jArr[(i9 >>> 9) & 7] << 9)) ^ (jArr[(i9 >>> 12) & 7] << 12);
        long j14 = 0;
        int i10 = 30;
        do {
            int i11 = (int) (j4 >>> i10);
            long j15 = (((jArr[i11 & 7] ^ (jArr[(i11 >>> 3) & 7] << 3)) ^ (jArr[(i11 >>> 6) & 7] << 6)) ^ (jArr[(i11 >>> 9) & 7] << 9)) ^ (jArr[(i11 >>> 12) & 7] << 12);
            j13 ^= j15 << i10;
            j14 ^= j15 >>> (-i10);
            i10 -= 15;
        } while (i10 > 0);
        jArr2[i8] = 17592186044415L & j13;
        jArr2[i8 + 1] = (j13 >>> 44) ^ (j14 << 20);
    }

    public static void J0(int[] iArr, int[] iArr2) {
        long j4 = iArr[10] & 4294967295L;
        long j8 = iArr[11] & 4294967295L;
        long j9 = iArr[12] & 4294967295L;
        long j10 = iArr[13] & 4294967295L;
        long j11 = ((iArr[7] & 4294967295L) + j8) - 1;
        long j12 = (iArr[8] & 4294967295L) + j9;
        long j13 = (iArr[9] & 4294967295L) + j10;
        long j14 = (iArr[0] & 4294967295L) - j11;
        long j15 = j14 & 4294967295L;
        long j16 = ((iArr[1] & 4294967295L) - j12) + (j14 >> 32);
        int i8 = (int) j16;
        iArr2[1] = i8;
        long j17 = ((iArr[2] & 4294967295L) - j13) + (j16 >> 32);
        int i9 = (int) j17;
        iArr2[2] = i9;
        long j18 = (((iArr[3] & 4294967295L) + j11) - j4) + (j17 >> 32);
        long j19 = j18 & 4294967295L;
        long j20 = (((iArr[4] & 4294967295L) + j12) - j8) + (j18 >> 32);
        iArr2[4] = (int) j20;
        long j21 = (((iArr[5] & 4294967295L) + j13) - j9) + (j20 >> 32);
        iArr2[5] = (int) j21;
        long j22 = (((iArr[6] & 4294967295L) + j4) - j10) + (j21 >> 32);
        iArr2[6] = (int) j22;
        long j23 = (j22 >> 32) + 1;
        long j24 = j19 + j23;
        long j25 = j15 - j23;
        iArr2[0] = (int) j25;
        long j26 = j25 >> 32;
        if (j26 != 0) {
            long j27 = j26 + (i8 & 4294967295L);
            iArr2[1] = (int) j27;
            long j28 = (j27 >> 32) + (i9 & 4294967295L);
            iArr2[2] = (int) j28;
            j24 += j28 >> 32;
        }
        iArr2[3] = (int) j24;
        if (((j24 >> 32) == 0 || x.f.d0(7, 4, iArr2) == 0) && !(iArr2[6] == -1 && x.f.Z(iArr2, f5277s))) {
            return;
        }
        q(iArr2);
    }

    public static void J1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.e.n0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 1;
            iArr3[0] = (int) j4;
            long j8 = j4 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr3[1] & 4294967295L);
                iArr3[1] = (int) j9;
                j8 = j9 >> 32;
            }
            long j10 = ((4294967295L & iArr3[2]) - 1) + j8;
            iArr3[2] = (int) j10;
            if ((j10 >> 32) != 0) {
                x.f.B(6, 3, iArr3);
            }
        }
    }

    public static void K(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        long j13 = jArr[((int) j4) & 3];
        long j14 = 0;
        int i9 = 47;
        do {
            int i10 = (int) (j4 >>> i9);
            long j15 = (jArr[i10 & 7] ^ (jArr[(i10 >>> 3) & 7] << 3)) ^ (jArr[(i10 >>> 6) & 7] << 6);
            j13 ^= j15 << i9;
            j14 ^= j15 >>> (-i9);
            i9 -= 9;
        } while (i9 > 0);
        jArr2[i8] = 36028797018963967L & j13;
        jArr2[i8 + 1] = (j13 >>> 55) ^ (j14 << 9);
    }

    public static void K0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = j12 ^ (j14 >>> 31);
        long j16 = (j11 ^ ((j14 >>> 41) ^ (j14 << 33))) ^ (j13 >>> 31);
        long j17 = ((j10 ^ (j14 << 23)) ^ ((j13 >>> 41) ^ (j13 << 33))) ^ (j15 >>> 31);
        long j18 = j4 ^ (j16 << 23);
        long j19 = (j8 ^ (j15 << 23)) ^ ((j16 >>> 41) ^ (j16 << 33));
        long j20 = ((j9 ^ (j13 << 23)) ^ ((j15 >>> 41) ^ (j15 << 33))) ^ (j16 >>> 31);
        long j21 = j17 >>> 41;
        jArr2[0] = j18 ^ j21;
        jArr2[1] = (j21 << 10) ^ j19;
        jArr2[2] = j20;
        jArr2[3] = 2199023255551L & j17;
    }

    public static void K1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.F0(iArr, iArr2, iArr3) != 0) {
            x.f.G0(7, 6803, iArr3);
        }
    }

    public static void L(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        long j13 = jArr[((int) j4) & 7];
        long j14 = 0;
        int i9 = 48;
        do {
            int i10 = (int) (j4 >>> i9);
            long j15 = (jArr[i10 & 7] ^ (jArr[(i10 >>> 3) & 7] << 3)) ^ (jArr[(i10 >>> 6) & 7] << 6);
            j13 ^= j15 << i9;
            j14 ^= j15 >>> (-i9);
            i9 -= 9;
        } while (i9 > 0);
        jArr2[i8] = 144115188075855871L & j13;
        jArr2[i8 + 1] = (((((j4 & 72198606942111744L) & ((j8 << 7) >> 63)) >>> 8) ^ j14) << 7) ^ (j13 >>> 57);
    }

    public static void L0(int[] iArr, int[] iArr2) {
        long j4 = 977 & 4294967295L;
        long j8 = iArr[8] & 4294967295L;
        long j9 = (j4 * j8) + (iArr[0] & 4294967295L);
        int i8 = (int) j9;
        iArr2[0] = i8;
        long j10 = iArr[9] & 4294967295L;
        long j11 = (j4 * j10) + j8 + (iArr[1] & 4294967295L) + (j9 >>> 32);
        int i9 = (int) j11;
        iArr2[1] = i9;
        long j12 = iArr[10] & 4294967295L;
        long j13 = (j4 * j12) + j10 + (iArr[2] & 4294967295L) + (j11 >>> 32);
        int i10 = (int) j13;
        iArr2[2] = i10;
        long j14 = iArr[11] & 4294967295L;
        long j15 = (j4 * j14) + j12 + (iArr[3] & 4294967295L) + (j13 >>> 32);
        int i11 = (int) j15;
        iArr2[3] = i11;
        long j16 = iArr[12] & 4294967295L;
        long j17 = (j4 * j16) + j14 + (iArr[4] & 4294967295L) + (j15 >>> 32);
        iArr2[4] = (int) j17;
        long j18 = iArr[13] & 4294967295L;
        long j19 = (j4 * j18) + j16 + (iArr[5] & 4294967295L) + (j17 >>> 32);
        iArr2[5] = (int) j19;
        long j20 = iArr[14] & 4294967295L;
        long j21 = (j4 * j20) + j18 + (iArr[6] & 4294967295L) + (j19 >>> 32);
        iArr2[6] = (int) j21;
        long j22 = iArr[15] & 4294967295L;
        long j23 = (j4 * j22) + j20 + (iArr[7] & 4294967295L) + (j21 >>> 32);
        iArr2[7] = (int) j23;
        long j24 = (j23 >>> 32) + j22;
        long j25 = j24 & 4294967295L;
        long j26 = (j4 * j25) + (i8 & 4294967295L);
        iArr2[0] = (int) j26;
        long j27 = j24 >>> 32;
        long j28 = (j4 * j27) + j25 + (i9 & 4294967295L) + (j26 >>> 32);
        iArr2[1] = (int) j28;
        long j29 = j27 + (i10 & 4294967295L) + (j28 >>> 32);
        iArr2[2] = (int) j29;
        long j30 = (j29 >>> 32) + (i11 & 4294967295L);
        iArr2[3] = (int) j30;
        if (((j30 >>> 32) == 0 ? 0 : x.f.e0(8, 4, iArr2)) != 0 || (iArr2[7] == -1 && x.e.P(iArr2, f5280v))) {
            x.f.e(8, 977, iArr2);
        }
    }

    public static void L1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.F0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) + 1;
            iArr3[0] = (int) j4;
            long j8 = j4 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr3[1] & 4294967295L);
                iArr3[1] = (int) j9;
                long j10 = (j9 >> 32) + (iArr3[2] & 4294967295L);
                iArr3[2] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = ((4294967295L & iArr3[3]) - 1) + j8;
            iArr3[3] = (int) j11;
            if ((j11 >> 32) != 0) {
                x.f.B(7, 4, iArr3);
            }
        }
    }

    public static void M(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        long j13 = jArr[((int) j4) & 7];
        long j14 = 0;
        int i9 = 48;
        do {
            int i10 = (int) (j4 >>> i9);
            long j15 = (jArr[i10 & 7] ^ (jArr[(i10 >>> 3) & 7] << 3)) ^ (jArr[(i10 >>> 6) & 7] << 6);
            j13 ^= j15 << i9;
            j14 ^= j15 >>> (-i9);
            i9 -= 9;
        } while (i9 > 0);
        jArr2[i8] = 144115188075855871L & j13;
        jArr2[i8 + 1] = (((((j4 & 72198606942111744L) & ((j8 << 7) >> 63)) >>> 8) ^ j14) << 7) ^ (j13 >>> 57);
    }

    public static void M0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = j13 ^ (j14 >>> 17);
        long j16 = (j12 ^ (j14 << 47)) ^ (j15 >>> 17);
        long j17 = ((j11 ^ (j14 >>> 47)) ^ (j15 << 47)) ^ (j16 >>> 17);
        long j18 = j4 ^ (j17 << 17);
        long j19 = (j8 ^ (j16 << 17)) ^ (j17 >>> 47);
        long j20 = ((j9 ^ (j15 << 17)) ^ (j16 >>> 47)) ^ (j17 << 47);
        long j21 = (((j10 ^ (j14 << 17)) ^ (j15 >>> 47)) ^ (j16 << 47)) ^ (j17 >>> 17);
        long j22 = j21 >>> 47;
        jArr2[0] = j18 ^ j22;
        jArr2[1] = j19;
        jArr2[2] = (j22 << 30) ^ j20;
        jArr2[3] = 140737488355327L & j21;
    }

    public static void M1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.e.p0(iArr, iArr2, iArr3) != 0) {
            x.f.G0(8, 977, iArr3);
        }
    }

    public static void N(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        long j9 = j4;
        jArr[1] = j8;
        for (int i9 = 2; i9 < 16; i9 += 2) {
            long j10 = jArr[i9 >>> 1] << 1;
            jArr[i9] = j10;
            jArr[i9 + 1] = j10 ^ j8;
        }
        int i10 = (int) j9;
        long j11 = jArr[i10 & 15] ^ (jArr[(i10 >>> 4) & 15] << 4);
        long j12 = 0;
        int i11 = 56;
        do {
            int i12 = (int) (j9 >>> i11);
            long j13 = jArr[i12 & 15] ^ (jArr[(i12 >>> 4) & 15] << 4);
            j11 ^= j13 << i11;
            j12 ^= j13 >>> (-i11);
            i11 -= 8;
        } while (i11 > 0);
        for (int i13 = 0; i13 < 7; i13++) {
            j9 = (j9 & (-72340172838076674L)) >>> 1;
            j12 ^= ((j8 << i13) >> 63) & j9;
        }
        jArr2[i8] = jArr2[i8] ^ j11;
        int i14 = i8 + 1;
        jArr2[i14] = jArr2[i14] ^ j12;
    }

    public static void N0(int[] iArr, int[] iArr2) {
        long j4 = iArr[9] & 4294967295L;
        long j8 = iArr[10] & 4294967295L;
        long j9 = iArr[11] & 4294967295L;
        long j10 = iArr[12] & 4294967295L;
        long j11 = iArr[13] & 4294967295L;
        long j12 = iArr[14] & 4294967295L;
        long j13 = iArr[15] & 4294967295L;
        long j14 = (iArr[8] & 4294967295L) - 6;
        long j15 = j14 + j4;
        long j16 = j4 + j8;
        long j17 = (j8 + j9) - j13;
        long j18 = j9 + j10;
        long j19 = j10 + j11;
        long j20 = j11 + j12;
        long j21 = j12 + j13;
        long j22 = j20 - j15;
        long j23 = ((iArr[0] & 4294967295L) - j18) - j22;
        iArr2[0] = (int) j23;
        long j24 = ((((iArr[1] & 4294967295L) + j16) - j19) - j21) + (j23 >> 32);
        iArr2[1] = (int) j24;
        long j25 = (((iArr[2] & 4294967295L) + j17) - j20) + (j24 >> 32);
        iArr2[2] = (int) j25;
        long j26 = ((((iArr[3] & 4294967295L) + (j18 << 1)) + j22) - j21) + (j25 >> 32);
        iArr2[3] = (int) j26;
        long j27 = ((((iArr[4] & 4294967295L) + (j19 << 1)) + j12) - j16) + (j26 >> 32);
        iArr2[4] = (int) j27;
        long j28 = (((iArr[5] & 4294967295L) + (j20 << 1)) - j17) + (j27 >> 32);
        iArr2[5] = (int) j28;
        long j29 = (iArr[6] & 4294967295L) + (j21 << 1) + j22 + (j28 >> 32);
        iArr2[6] = (int) j29;
        long j30 = (((((iArr[7] & 4294967295L) + (j13 << 1)) + j14) - j17) - j19) + (j29 >> 32);
        iArr2[7] = (int) j30;
        Z0((int) ((j30 >> 32) + 6), iArr2);
    }

    public static void N1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.e.p0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 1;
            iArr3[0] = (int) j4;
            long j8 = j4 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr3[1] & 4294967295L);
                iArr3[1] = (int) j9;
                long j10 = (j9 >> 32) + (iArr3[2] & 4294967295L);
                iArr3[2] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = (iArr3[3] & 4294967295L) + 1 + j8;
            iArr3[3] = (int) j11;
            long j12 = j11 >> 32;
            if (j12 != 0) {
                long j13 = j12 + (iArr3[4] & 4294967295L);
                iArr3[4] = (int) j13;
                long j14 = (j13 >> 32) + (iArr3[5] & 4294967295L);
                iArr3[5] = (int) j14;
                j12 = j14 >> 32;
            }
            long j15 = (iArr3[6] & 4294967295L) + 1 + j12;
            iArr3[6] = (int) j15;
            iArr3[7] = (int) (((iArr3[7] & 4294967295L) - 1) + (j15 >> 32));
        }
    }

    public static void O(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        int i9 = (int) j4;
        long j13 = (jArr[(i9 >>> 3) & 7] << 3) ^ jArr[i9 & 7];
        long j14 = 0;
        int i10 = 36;
        do {
            int i11 = (int) (j4 >>> i10);
            long j15 = (((jArr[i11 & 7] ^ (jArr[(i11 >>> 3) & 7] << 3)) ^ (jArr[(i11 >>> 6) & 7] << 6)) ^ (jArr[(i11 >>> 9) & 7] << 9)) ^ (jArr[(i11 >>> 12) & 7] << 12);
            j13 ^= j15 << i10;
            j14 ^= j15 >>> (-i10);
            i10 -= 15;
        } while (i10 > 0);
        jArr2[i8] = jArr2[i8] ^ (562949953421311L & j13);
        int i12 = i8 + 1;
        jArr2[i12] = jArr2[i12] ^ ((j13 >>> 49) ^ (j14 << 15));
    }

    public static void O0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = jArr[12];
        long j16 = j12 ^ (j15 << 39);
        long j17 = j13 ^ ((j15 >>> 25) ^ (j15 << 62));
        long j18 = j14 ^ (j15 >>> 2);
        long j19 = jArr[11];
        long j20 = j11 ^ (j19 << 39);
        long j21 = j16 ^ ((j19 >>> 25) ^ (j19 << 62));
        long j22 = j17 ^ (j19 >>> 2);
        long j23 = jArr[10];
        long j24 = j10 ^ (j23 << 39);
        long j25 = j20 ^ ((j23 >>> 25) ^ (j23 << 62));
        long j26 = j21 ^ (j23 >>> 2);
        long j27 = jArr[9];
        long j28 = j9 ^ (j27 << 39);
        long j29 = j24 ^ ((j27 >>> 25) ^ (j27 << 62));
        long j30 = j25 ^ (j27 >>> 2);
        long j31 = jArr[8];
        long j32 = j4 ^ (j18 << 39);
        long j33 = (j8 ^ (j31 << 39)) ^ ((j18 >>> 25) ^ (j18 << 62));
        long j34 = (j28 ^ ((j31 >>> 25) ^ (j31 << 62))) ^ (j18 >>> 2);
        long j35 = j22 >>> 25;
        jArr2[0] = j32 ^ j35;
        jArr2[1] = (j35 << 23) ^ j33;
        jArr2[2] = j34;
        jArr2[3] = j29 ^ (j31 >>> 2);
        jArr2[4] = j30;
        jArr2[5] = j26;
        jArr2[6] = j22 & 33554431;
    }

    public static void O1(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.C0(iArr, iArr2, 12, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 1;
            iArr3[0] = (int) j4;
            long j8 = (iArr3[1] & 4294967295L) + 1 + (j4 >> 32);
            iArr3[1] = (int) j8;
            long j9 = j8 >> 32;
            if (j9 != 0) {
                long j10 = j9 + (iArr3[2] & 4294967295L);
                iArr3[2] = (int) j10;
                j9 = j10 >> 32;
            }
            long j11 = ((iArr3[3] & 4294967295L) - 1) + j9;
            iArr3[3] = (int) j11;
            long j12 = ((4294967295L & iArr3[4]) - 1) + (j11 >> 32);
            iArr3[4] = (int) j12;
            if ((j12 >> 32) != 0) {
                x.f.B(12, 5, iArr3);
            }
        }
    }

    public static void P(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        int i9 = (int) j4;
        long j13 = (jArr[(i9 >>> 3) & 7] << 3) ^ jArr[i9 & 7];
        long j14 = 0;
        int i10 = 54;
        do {
            int i11 = (int) (j4 >>> i10);
            long j15 = jArr[i11 & 7] ^ (jArr[(i11 >>> 3) & 7] << 3);
            j13 ^= j15 << i10;
            j14 ^= j15 >>> (-i10);
            i10 -= 6;
        } while (i10 > 0);
        jArr2[i8] = jArr2[i8] ^ (576460752303423487L & j13);
        int i12 = i8 + 1;
        jArr2[i12] = jArr2[i12] ^ ((j13 >>> 59) ^ (j14 << 5));
    }

    public static void P0(int[] iArr, int[] iArr2) {
        long j4 = iArr[16] & 4294967295L;
        long j8 = iArr[17] & 4294967295L;
        long j9 = iArr[18] & 4294967295L;
        long j10 = iArr[19] & 4294967295L;
        long j11 = iArr[20] & 4294967295L;
        long j12 = iArr[21] & 4294967295L;
        long j13 = iArr[22] & 4294967295L;
        long j14 = iArr[23] & 4294967295L;
        long j15 = ((iArr[12] & 4294967295L) + j11) - 1;
        long j16 = (iArr[13] & 4294967295L) + j13;
        long j17 = (iArr[14] & 4294967295L) + j13 + j14;
        long j18 = (iArr[15] & 4294967295L) + j14;
        long j19 = j8 + j12;
        long j20 = j12 - j14;
        long j21 = j13 - j14;
        long j22 = j15 + j20;
        long j23 = (iArr[0] & 4294967295L) + j22;
        iArr2[0] = (int) j23;
        long j24 = (((iArr[1] & 4294967295L) + j14) - j15) + j16 + (j23 >> 32);
        iArr2[1] = (int) j24;
        long j25 = (((iArr[2] & 4294967295L) - j12) - j16) + j17 + (j24 >> 32);
        iArr2[2] = (int) j25;
        long j26 = ((iArr[3] & 4294967295L) - j17) + j18 + j22 + (j25 >> 32);
        iArr2[3] = (int) j26;
        long j27 = (((((iArr[4] & 4294967295L) + j4) + j12) + j16) - j18) + j22 + (j26 >> 32);
        iArr2[4] = (int) j27;
        long j28 = ((iArr[5] & 4294967295L) - j4) + j16 + j17 + j19 + (j27 >> 32);
        iArr2[5] = (int) j28;
        long j29 = (((iArr[6] & 4294967295L) + j9) - j8) + j17 + j18 + (j28 >> 32);
        iArr2[6] = (int) j29;
        long j30 = ((((iArr[7] & 4294967295L) + j4) + j10) - j9) + j18 + (j29 >> 32);
        iArr2[7] = (int) j30;
        long j31 = (((((iArr[8] & 4294967295L) + j4) + j8) + j11) - j10) + (j30 >> 32);
        iArr2[8] = (int) j31;
        long j32 = (((iArr[9] & 4294967295L) + j9) - j11) + j19 + (j31 >> 32);
        iArr2[9] = (int) j32;
        long j33 = ((((iArr[10] & 4294967295L) + j9) + j10) - j20) + j21 + (j32 >> 32);
        iArr2[10] = (int) j33;
        long j34 = ((((iArr[11] & 4294967295L) + j10) + j11) - j21) + (j33 >> 32);
        iArr2[11] = (int) j34;
        a1((int) ((j34 >> 32) + 1), iArr2);
    }

    public static void P1(int[] iArr, int[] iArr2) {
        if (x.f.x0(5, 0, iArr, iArr2) != 0 || (iArr2[4] == -1 && x.f.Y(iArr2, f5265g))) {
            x.f.e(5, 21389, iArr2);
        }
    }

    public static void Q(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        int i9 = (int) j4;
        long j13 = (jArr[(i9 >>> 3) & 7] << 3) ^ jArr[i9 & 7];
        long j14 = 0;
        int i10 = 54;
        do {
            int i11 = (int) (j4 >>> i10);
            long j15 = jArr[i11 & 7] ^ (jArr[(i11 >>> 3) & 7] << 3);
            j13 ^= j15 << i10;
            j14 ^= j15 >>> (-i10);
            i10 -= 6;
        } while (i10 > 0);
        jArr2[i8] = jArr2[i8] ^ (1152921504606846975L & j13);
        int i12 = i8 + 1;
        jArr2[i12] = ((((((j4 & 585610922974906400L) & ((j8 << 4) >> 63)) >>> 5) ^ j14) << 4) ^ (j13 >>> 60)) ^ jArr2[i12];
    }

    public static void Q0(int[] iArr) {
        int i8 = iArr[16];
        int iN = x.f.n(16, i8 >>> 9, iArr) + (i8 & 511);
        if (iN > 511 || (iN == 511 && x.f.I(16, iArr, D))) {
            iN = (x.f.c0(iArr) + iN) & 511;
        }
        iArr[16] = iN;
    }

    public static void Q1(int[] iArr, int[] iArr2) {
        if (x.f.x0(7, 0, iArr, iArr2) != 0 || (iArr2[6] == -1 && x.f.Z(iArr2, f5277s))) {
            q(iArr2);
        }
    }

    public static void R(long[] jArr, long j4, long j8, long[] jArr2, int i8) {
        jArr[1] = j8;
        long j9 = j8 << 1;
        jArr[2] = j9;
        long j10 = j9 ^ j8;
        jArr[3] = j10;
        long j11 = j8 << 2;
        jArr[4] = j11;
        jArr[5] = j11 ^ j8;
        long j12 = j10 << 1;
        jArr[6] = j12;
        jArr[7] = j12 ^ j8;
        int i9 = (int) j4;
        long j13 = (jArr[(i9 >>> 3) & 7] << 3) ^ jArr[i9 & 7];
        long j14 = 0;
        int i10 = 54;
        do {
            int i11 = (int) (j4 >>> i10);
            long j15 = jArr[i11 & 7] ^ (jArr[(i11 >>> 3) & 7] << 3);
            j13 ^= j15 << i10;
            j14 ^= j15 >>> (-i10);
            i10 -= 6;
        } while (i10 > 0);
        jArr2[i8] = jArr2[i8] ^ (576460752303423487L & j13);
        int i12 = i8 + 1;
        jArr2[i12] = jArr2[i12] ^ ((j13 >>> 59) ^ (j14 << 5));
    }

    public static void R0(int i8, int[] iArr) {
        while (i8 != 0) {
            long j4 = i8 & 4294967295L;
            long j8 = (iArr[0] & 4294967295L) + j4;
            iArr[0] = (int) j8;
            long j9 = j8 >> 32;
            if (j9 != 0) {
                long j10 = j9 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j10;
                long j11 = (j10 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j11;
                j9 = j11 >> 32;
            }
            long j12 = (4294967295L & iArr[3]) + (j4 << 1) + j9;
            iArr[3] = (int) j12;
            i8 = (int) (j12 >> 32);
        }
        if ((iArr[3] >>> 1) < 2147483646 || !x.e.N(iArr, f5260a)) {
            return;
        }
        o(iArr);
    }

    public static void S(int[] iArr, int[] iArr2) {
        x.e.j0(iArr, iArr2);
        long j4 = 4294967295L;
        long j8 = iArr[8] & 4294967295L;
        int i8 = 7;
        int i9 = 16;
        int i10 = 0;
        while (true) {
            int i11 = i8 - 1;
            long j9 = iArr[i8 + 8] & j4;
            long j10 = j9 * j9;
            long j11 = j4;
            iArr2[i9 + 15] = ((int) (j10 >>> 33)) | (i10 << 31);
            int i12 = i9 - 2;
            iArr2[i9 + 14] = (int) (j10 >>> 1);
            i10 = (int) j10;
            if (i11 <= 0) {
                long j12 = j8 * j8;
                iArr2[16] = (int) j12;
                long j13 = iArr[9] & j11;
                long j14 = (j13 * j8) + (((i10 << 31) & j11) | (j12 >>> 33));
                int i13 = (int) j14;
                iArr2[17] = (i13 << 1) | (((int) (j12 >>> 32)) & 1);
                long j15 = (iArr2[18] & j11) + (j14 >>> 32);
                long j16 = iArr[10] & j11;
                long j17 = (j16 * j8) + j15;
                int i14 = (int) j17;
                iArr2[18] = (i13 >>> 31) | (i14 << 1);
                long jH = a8.b.h(j16, j13, j17 >>> 32, iArr2[19] & j11);
                long j18 = (iArr2[20] & j11) + (jH >>> 32);
                long j19 = iArr[11] & j11;
                long j20 = (iArr2[21] & j11) + (j18 >>> 32);
                long j21 = j18 & j11;
                long j22 = (iArr2[22] & j11) + (j20 >>> 32);
                long j23 = j20 & j11;
                long j24 = (j19 * j8) + (jH & j11);
                int i15 = (int) j24;
                iArr2[19] = (i15 << 1) | (i14 >>> 31);
                long jH2 = a8.b.h(j19, j13, j24 >>> 32, j21);
                long jH3 = a8.b.h(j19, j16, jH2 >>> 32, j23);
                long j25 = j22 + (jH3 >>> 32);
                long j26 = jH3 & j11;
                long j27 = iArr[12] & j11;
                long j28 = (iArr2[23] & j11) + (j25 >>> 32);
                long j29 = (j27 * j8) + (jH2 & j11);
                int i16 = (int) j29;
                iArr2[20] = (i15 >>> 31) | (i16 << 1);
                int i17 = i16 >>> 31;
                long jH4 = a8.b.h(j27, j13, j29 >>> 32, j26);
                long jH5 = a8.b.h(j27, j16, jH4 >>> 32, j25 & j11);
                long jH6 = a8.b.h(j27, j19, jH5 >>> 32, j28 & j11);
                long j30 = (iArr2[24] & j11) + (j28 >>> 32) + (jH6 >>> 32);
                long j31 = iArr[13] & j11;
                long j32 = (iArr2[25] & j11) + (j30 >>> 32);
                long j33 = (j31 * j8) + (jH4 & j11);
                int i18 = (int) j33;
                iArr2[21] = (i18 << 1) | i17;
                long jH7 = a8.b.h(j31, j13, j33 >>> 32, jH5 & j11);
                long jH8 = a8.b.h(j31, j16, jH7 >>> 32, jH6 & j11);
                long jH9 = a8.b.h(j31, j19, jH8 >>> 32, j30 & j11);
                long j34 = jH8 & j11;
                long jH10 = a8.b.h(j31, j27, jH9 >>> 32, j32 & j11);
                long j35 = (iArr2[26] & j11) + (j32 >>> 32) + (jH10 >>> 32);
                long j36 = jH10 & j11;
                long j37 = iArr[14] & j11;
                long j38 = (iArr2[27] & j11) + (j35 >>> 32);
                long j39 = j35 & j11;
                long j40 = (iArr2[28] & j11) + (j38 >>> 32);
                long j41 = j38 & j11;
                long j42 = (j37 * j8) + (jH7 & j11);
                int i19 = (int) j42;
                iArr2[22] = (i19 << 1) | (i18 >>> 31);
                long jH11 = a8.b.h(j37, j13, j42 >>> 32, j34);
                long jH12 = a8.b.h(j37, j16, jH11 >>> 32, jH9 & j11);
                long jH13 = a8.b.h(j37, j19, jH12 >>> 32, j36);
                long j43 = jH12 & j11;
                long jH14 = a8.b.h(j37, j27, jH13 >>> 32, j39);
                long j44 = jH13 & j11;
                long jH15 = a8.b.h(j37, j31, jH14 >>> 32, j41);
                long j45 = j40 + (jH15 >>> 32);
                long j46 = iArr[15] & j11;
                long j47 = (iArr2[29] & j11) + (j45 >>> 32);
                long j48 = j45 & j11;
                long j49 = (iArr2[30] & j11) + (j47 >>> 32);
                long j50 = j47 & j11;
                long j51 = (j8 * j46) + (jH11 & j11);
                int i20 = (int) j51;
                iArr2[23] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                long jH16 = a8.b.h(j46, j13, j51 >>> 32, j43);
                long jH17 = a8.b.h(j46, j16, jH16 >>> 32, j44);
                long jH18 = a8.b.h(j46, j19, jH17 >>> 32, jH14 & j11);
                long jH19 = a8.b.h(j46, j27, jH18 >>> 32, jH15 & j11);
                long jH20 = a8.b.h(j46, j31, jH19 >>> 32, j48);
                long jH21 = a8.b.h(j46, j37, jH20 >>> 32, j50);
                long j52 = j49 + (jH21 >>> 32);
                int i22 = (int) jH16;
                iArr2[24] = (i22 << 1) | i21;
                int i23 = (int) jH17;
                iArr2[25] = (i22 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) jH18;
                iArr2[26] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) jH19;
                iArr2[27] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) jH20;
                iArr2[28] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) jH21;
                iArr2[29] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) j52;
                iArr2[30] = i32 | (i33 << 1);
                iArr2[31] = (i33 >>> 31) | ((iArr2[31] + ((int) (j52 >>> 32))) << 1);
                int iJ = x.e.j(iArr2, iArr2);
                int iH = x.e.h(24, iArr2, 16, iArr2, x.e.h(0, iArr2, 8, iArr2, 0) + iJ) + iJ;
                int[] iArr3 = new int[8];
                x.e.w(iArr, iArr, iArr3);
                int[] iArr4 = new int[16];
                x.e.j0(iArr3, iArr4);
                x.f.m(iArr2, 32, x.f.H0(16, 8, iArr4, iArr2) + iH, 24);
                int i34 = iArr[16];
                iArr2[32] = (i34 * i34) + x.f.v0(16, iArr, i34 << 1, iArr2, 16);
                return;
            }
            i9 = i12;
            i8 = i11;
            j4 = j11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void S0(int r10, int[] r11) {
        /*
            r0 = 5
            r1 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r10 == 0) goto L35
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r10
            long r6 = r6 & r4
            long r6 = r6 * r2
            r10 = 0
            r2 = r11[r10]
            long r2 = (long) r2
            long r2 = r2 & r4
            long r6 = r6 + r2
            int r2 = (int) r6
            r11[r10] = r2
            r2 = 32
            long r6 = r6 >>> r2
            r3 = 1
            r8 = r11[r3]
            long r8 = (long) r8
            long r4 = r4 & r8
            long r6 = r6 + r4
            int r4 = (int) r6
            r11[r3] = r4
            long r2 = r6 >>> r2
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L2e
            goto L33
        L2e:
            r10 = 2
            int r10 = x.f.e0(r0, r10, r11)
        L33:
            if (r10 != 0) goto L43
        L35:
            r10 = 4
            r10 = r11[r10]
            r2 = -1
            if (r10 != r2) goto L46
            int[] r10 = s7.b.d
            boolean r10 = x.f.Y(r11, r10)
            if (r10 == 0) goto L46
        L43:
            x.f.n(r0, r1, r11)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.S0(int, int[]):void");
    }

    public static void T(long[] jArr, long[] jArr2) {
        x.e.D(2, jArr, jArr2);
        int i8 = ((int) jArr[2]) & 255;
        int i9 = (i8 | (i8 << 4)) & 3855;
        int i10 = (i9 | (i9 << 2)) & 13107;
        jArr2[4] = (i10 | (i10 << 1)) & 21845 & 4294967295L;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void T0(int r12, int[] r13) {
        /*
            r0 = 5
            r1 = 21389(0x538d, float:2.9972E-41)
            if (r12 == 0) goto L3f
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r12
            long r6 = r6 & r4
            long r2 = r2 * r6
            r12 = 0
            r8 = r13[r12]
            long r8 = (long) r8
            long r8 = r8 & r4
            long r2 = r2 + r8
            int r8 = (int) r2
            r13[r12] = r8
            r8 = 32
            long r2 = r2 >>> r8
            r9 = 1
            r10 = r13[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r6 = r6 + r10
            long r6 = r6 + r2
            int r2 = (int) r6
            r13[r9] = r2
            long r2 = r6 >>> r8
            r6 = 2
            r7 = r13[r6]
            long r9 = (long) r7
            long r4 = r4 & r9
            long r2 = r2 + r4
            int r4 = (int) r2
            r13[r6] = r4
            long r2 = r2 >>> r8
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L38
            goto L3d
        L38:
            r12 = 3
            int r12 = x.f.e0(r0, r12, r13)
        L3d:
            if (r12 != 0) goto L4d
        L3f:
            r12 = 4
            r12 = r13[r12]
            r2 = -1
            if (r12 != r2) goto L50
            int[] r12 = s7.b.f5265g
            boolean r12 = x.f.Y(r13, r12)
            if (r12 == 0) goto L50
        L4d:
            x.f.e(r0, r1, r13)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.T0(int, int[]):void");
    }

    public static void U(long[] jArr, long[] jArr2) {
        x.e.D(4, jArr, jArr2);
        jArr2[8] = x.e.B((int) jArr[4]);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void U0(int r12, int[] r13) {
        /*
            r0 = 6
            r1 = 4553(0x11c9, float:6.38E-42)
            if (r12 == 0) goto L3f
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r12
            long r6 = r6 & r4
            long r2 = r2 * r6
            r12 = 0
            r8 = r13[r12]
            long r8 = (long) r8
            long r8 = r8 & r4
            long r2 = r2 + r8
            int r8 = (int) r2
            r13[r12] = r8
            r8 = 32
            long r2 = r2 >>> r8
            r9 = 1
            r10 = r13[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r6 = r6 + r10
            long r6 = r6 + r2
            int r2 = (int) r6
            r13[r9] = r2
            long r2 = r6 >>> r8
            r6 = 2
            r7 = r13[r6]
            long r9 = (long) r7
            long r4 = r4 & r9
            long r2 = r2 + r4
            int r4 = (int) r2
            r13[r6] = r4
            long r2 = r2 >>> r8
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L38
            goto L3d
        L38:
            r12 = 3
            int r12 = x.f.e0(r0, r12, r13)
        L3d:
            if (r12 != 0) goto L4d
        L3f:
            r12 = 5
            r12 = r13[r12]
            r2 = -1
            if (r12 != r2) goto L50
            int[] r12 = s7.b.f5268j
            boolean r12 = x.e.O(r13, r12)
            if (r12 == 0) goto L50
        L4d:
            x.f.e(r0, r1, r13)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.U0(int, int[]):void");
    }

    public static void V(long[] jArr, long[] jArr2) {
        x.e.D(9, jArr, jArr2);
    }

    public static void V0(int i8, int[] iArr) {
        long j4;
        if (i8 != 0) {
            long j8 = i8 & 4294967295L;
            long j9 = (iArr[0] & 4294967295L) + j8;
            iArr[0] = (int) j9;
            long j10 = j9 >> 32;
            if (j10 != 0) {
                long j11 = j10 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j11;
                j10 = j11 >> 32;
            }
            long j12 = (4294967295L & iArr[2]) + j8 + j10;
            iArr[2] = (int) j12;
            j4 = j12 >> 32;
        } else {
            j4 = 0;
        }
        if ((j4 == 0 || x.f.d0(6, 3, iArr) == 0) && !(iArr[5] == -1 && x.e.O(iArr, f5271m))) {
            return;
        }
        p(iArr);
    }

    public static void W(long[] jArr, long[] jArr2) {
        x.e.D(3, jArr, jArr2);
        jArr2[6] = jArr[3] & 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void W0(int r12, int[] r13) {
        /*
            r0 = 7
            r1 = 6803(0x1a93, float:9.533E-42)
            if (r12 == 0) goto L3f
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r12
            long r6 = r6 & r4
            long r2 = r2 * r6
            r12 = 0
            r8 = r13[r12]
            long r8 = (long) r8
            long r8 = r8 & r4
            long r2 = r2 + r8
            int r8 = (int) r2
            r13[r12] = r8
            r8 = 32
            long r2 = r2 >>> r8
            r9 = 1
            r10 = r13[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r6 = r6 + r10
            long r6 = r6 + r2
            int r2 = (int) r6
            r13[r9] = r2
            long r2 = r6 >>> r8
            r6 = 2
            r7 = r13[r6]
            long r9 = (long) r7
            long r4 = r4 & r9
            long r2 = r2 + r4
            int r4 = (int) r2
            r13[r6] = r4
            long r2 = r2 >>> r8
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L38
            goto L3d
        L38:
            r12 = 3
            int r12 = x.f.e0(r0, r12, r13)
        L3d:
            if (r12 != 0) goto L4d
        L3f:
            r12 = 6
            r12 = r13[r12]
            r2 = -1
            if (r12 != r2) goto L50
            int[] r12 = s7.b.f5274p
            boolean r12 = x.f.Z(r13, r12)
            if (r12 == 0) goto L50
        L4d:
            x.f.e(r0, r1, r13)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.W0(int, int[]):void");
    }

    public static void X(long[] jArr, long[] jArr2) {
        x.e.D(6, jArr, jArr2);
        jArr2[12] = x.e.B((int) jArr[6]);
    }

    public static void X0(int i8, int[] iArr) {
        long j4;
        if (i8 != 0) {
            long j8 = i8 & 4294967295L;
            long j9 = (iArr[0] & 4294967295L) - j8;
            iArr[0] = (int) j9;
            long j10 = j9 >> 32;
            if (j10 != 0) {
                long j11 = j10 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j11;
                long j12 = (j11 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j12;
                j10 = j12 >> 32;
            }
            long j13 = (4294967295L & iArr[3]) + j8 + j10;
            iArr[3] = (int) j13;
            j4 = j13 >> 32;
        } else {
            j4 = 0;
        }
        if ((j4 == 0 || x.f.d0(7, 4, iArr) == 0) && !(iArr[6] == -1 && x.f.Z(iArr, f5277s))) {
            return;
        }
        q(iArr);
    }

    public static void Y(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[8];
        x.e.a0(iArr, iArr2, iArr4);
        w0(iArr4, iArr3);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Y0(int r12, int[] r13) {
        /*
            r0 = 8
            r1 = 977(0x3d1, float:1.369E-42)
            if (r12 == 0) goto L40
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r12
            long r6 = r6 & r4
            long r2 = r2 * r6
            r12 = 0
            r8 = r13[r12]
            long r8 = (long) r8
            long r8 = r8 & r4
            long r2 = r2 + r8
            int r8 = (int) r2
            r13[r12] = r8
            r8 = 32
            long r2 = r2 >>> r8
            r9 = 1
            r10 = r13[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r6 = r6 + r10
            long r6 = r6 + r2
            int r2 = (int) r6
            r13[r9] = r2
            long r2 = r6 >>> r8
            r6 = 2
            r7 = r13[r6]
            long r9 = (long) r7
            long r4 = r4 & r9
            long r2 = r2 + r4
            int r4 = (int) r2
            r13[r6] = r4
            long r2 = r2 >>> r8
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L39
            goto L3e
        L39:
            r12 = 3
            int r12 = x.f.e0(r0, r12, r13)
        L3e:
            if (r12 != 0) goto L4e
        L40:
            r12 = 7
            r12 = r13[r12]
            r2 = -1
            if (r12 != r2) goto L51
            int[] r12 = s7.b.f5280v
            boolean r12 = x.e.P(r13, r12)
            if (r12 == 0) goto L51
        L4e:
            x.f.e(r0, r1, r13)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.b.Y0(int, int[]):void");
    }

    public static void Z(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        x.e.c0(iArr, iArr2, iArr4);
        L0(iArr4, iArr3);
    }

    public static void Z0(int i8, int[] iArr) {
        long j4;
        if (i8 != 0) {
            long j8 = i8 & 4294967295L;
            long j9 = (iArr[0] & 4294967295L) + j8;
            iArr[0] = (int) j9;
            long j10 = j9 >> 32;
            if (j10 != 0) {
                long j11 = j10 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j11;
                long j12 = (j11 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j12;
                j10 = j12 >> 32;
            }
            long j13 = ((iArr[3] & 4294967295L) - j8) + j10;
            iArr[3] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (iArr[4] & 4294967295L);
                iArr[4] = (int) j15;
                long j16 = (j15 >> 32) + (iArr[5] & 4294967295L);
                iArr[5] = (int) j16;
                j14 = j16 >> 32;
            }
            long j17 = ((iArr[6] & 4294967295L) - j8) + j14;
            iArr[6] = (int) j17;
            long j18 = (4294967295L & iArr[7]) + j8 + (j17 >> 32);
            iArr[7] = (int) j18;
            j4 = j18 >> 32;
        } else {
            j4 = 0;
        }
        if (j4 != 0 || (iArr[7] == -1 && x.e.P(iArr, y))) {
            r(iArr);
        }
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j4 = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L);
        iArr3[0] = (int) j4;
        long j8 = (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (j4 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (j9 >>> 32);
        int i8 = (int) j10;
        iArr3[3] = i8;
        if (((int) (j10 >>> 32)) != 0 || ((i8 >>> 1) >= 2147483646 && x.e.N(iArr3, f5260a))) {
            o(iArr3);
        }
    }

    public static void a0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        z(jArr, jArr2, jArr4);
        x0(jArr4, jArr3);
    }

    public static void a1(int i8, int[] iArr) {
        long j4;
        if (i8 != 0) {
            long j8 = i8 & 4294967295L;
            long j9 = (iArr[0] & 4294967295L) + j8;
            iArr[0] = (int) j9;
            long j10 = ((iArr[1] & 4294967295L) - j8) + (j9 >> 32);
            iArr[1] = (int) j10;
            long j11 = j10 >> 32;
            if (j11 != 0) {
                long j12 = j11 + (iArr[2] & 4294967295L);
                iArr[2] = (int) j12;
                j11 = j12 >> 32;
            }
            long j13 = (iArr[3] & 4294967295L) + j8 + j11;
            iArr[3] = (int) j13;
            long j14 = (4294967295L & iArr[4]) + j8 + (j13 >> 32);
            iArr[4] = (int) j14;
            j4 = j14 >> 32;
        } else {
            j4 = 0;
        }
        if ((j4 == 0 || x.f.d0(12, 5, iArr) == 0) && !(iArr[11] == -1 && x.f.X(12, iArr, A))) {
            return;
        }
        s(iArr);
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i8 = 0; i8 < 9; i8++) {
            jArr3[i8] = jArr[i8] ^ jArr2[i8];
        }
    }

    public static void b0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        x.f.r0(iArr, iArr2, iArr4);
        y0(iArr4, iArr3);
    }

    public static void b1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        x.e.h0(iArr, iArr3);
        w0(iArr3, iArr2);
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        if (x.f.c(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && x.f.Z(iArr3, f5277s))) {
            q(iArr3);
        }
    }

    public static void c0(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        x.e.c0(iArr, iArr2, iArr4);
        N0(iArr4, iArr3);
    }

    public static void c1(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        U(jArr, jArr3);
        C0(jArr3, jArr2);
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int iA = x.f.a(iArr, iArr2, 16, iArr3) + iArr[16] + iArr2[16];
        if (iA > 511 || (iA == 511 && x.f.I(16, iArr3, D))) {
            iA = (x.f.c0(iArr3) + iA) & 511;
        }
        iArr3[16] = iA;
    }

    public static void d0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        A(jArr, jArr2, jArr4);
        z0(jArr4, jArr3);
    }

    public static void d1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        x.f.A0(iArr, iArr3);
        y0(iArr3, iArr2);
    }

    public static void e(long[] jArr, int i8, long[] jArr2, int i9, long[] jArr3, int i10) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = i10 + i11;
            jArr3[i12] = jArr3[i12] ^ (jArr[i8 + i11] ^ jArr2[i9 + i11]);
        }
    }

    public static void e0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        x.f.r0(iArr, iArr2, iArr4);
        B0(iArr4, iArr3);
    }

    public static void e1(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[18];
        V(jArr, jArr3);
        E0(jArr3, jArr2);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i8 = 0; i8 < 9; i8++) {
            jArr3[i8] = jArr3[i8] ^ (jArr[i8] ^ jArr2[i8]);
        }
    }

    public static void f0(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        x.e.d0(iArr, iArr2, iArr4);
        P0(iArr4, iArr3);
    }

    public static void f1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        x.f.A0(iArr, iArr3);
        B0(iArr3, iArr2);
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void g0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        B(jArr, jArr2, jArr4);
        C0(jArr4, jArr3);
    }

    public static void g1(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        x.e.D(4, jArr, jArr3);
        K0(jArr3, jArr2);
    }

    public static void h(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void h0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        x.e.b0(iArr, iArr2, iArr4);
        D0(iArr4, iArr3);
    }

    public static void h1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        x.e.i0(iArr, iArr3);
        D0(iArr3, iArr2);
    }

    public static void i(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void i0(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        y(iArr, iArr2, iArr4);
        A0(iArr4, iArr3);
    }

    public static void i1(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        x.e.D(4, jArr, jArr3);
        M0(jArr3, jArr2);
    }

    public static void j(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i8 = 0; i8 < 18; i8++) {
            jArr3[i8] = jArr[i8] ^ jArr2[i8];
        }
    }

    public static void j0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        C(jArr, jArr2, jArr4);
        E0(jArr4, jArr3);
    }

    public static void j1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        x.e.i0(iArr, iArr3);
        F0(iArr3, iArr2);
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void k0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        x.e.b0(iArr, iArr2, iArr4);
        F0(iArr4, iArr3);
    }

    public static void k1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        x.f.B0(iArr, iArr3);
        H0(iArr3, iArr2);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void l0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        D(jArr, jArr2, jArr4);
        G0(jArr4, jArr3);
    }

    public static void l1(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        x.f.B0(iArr, iArr3);
        J0(iArr3, iArr2);
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void m0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[14];
        x.f.s0(iArr, iArr2, iArr4);
        H0(iArr4, iArr3);
    }

    public static void m1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        x.e.h0(iArr, iArr3);
        while (true) {
            w0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.h0(iArr2, iArr3);
            }
        }
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void n0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        E(jArr, jArr2, jArr4);
        I0(jArr4, jArr3);
    }

    public static void n1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[5];
        T(jArr, jArr3);
        while (true) {
            x0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                T(jArr2, jArr3);
            }
        }
    }

    public static void o(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j4;
        long j8 = j4 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j9;
            long j10 = (j9 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j10;
            j8 = j10 >> 32;
        }
        iArr[3] = (int) ((4294967295L & iArr[3]) + 2 + j8);
    }

    public static void o0(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[14];
        x.f.s0(iArr, iArr2, iArr4);
        J0(iArr4, iArr3);
    }

    public static void o1(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        x.e.j0(iArr, iArr3);
        while (true) {
            L0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.j0(iArr2, iArr3);
            }
        }
    }

    public static void p(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j4;
        long j8 = j4 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j9;
            j8 = j9 >> 32;
        }
        long j10 = (4294967295L & iArr[2]) + 1 + j8;
        iArr[2] = (int) j10;
        if ((j10 >> 32) != 0) {
            x.f.d0(6, 3, iArr);
        }
    }

    public static void p0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        F(jArr, jArr2, jArr4);
        K0(jArr4, jArr3);
    }

    public static void p1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        x.f.A0(iArr, iArr3);
        while (true) {
            y0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.f.A0(iArr2, iArr3);
            }
        }
    }

    public static void q(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j4;
        long j8 = j4 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j9;
            long j10 = (j9 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j10;
            j8 = j10 >> 32;
        }
        long j11 = (4294967295L & iArr[3]) + 1 + j8;
        iArr[3] = (int) j11;
        if ((j11 >> 32) != 0) {
            x.f.d0(7, 4, iArr);
        }
    }

    public static void q0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        G(jArr, jArr2, jArr4);
        M0(jArr4, jArr3);
    }

    public static void q1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[6];
        x.e.D(3, jArr, jArr3);
        while (true) {
            z0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.D(3, jArr2, jArr3);
            }
        }
    }

    public static void r(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j4;
        long j8 = j4 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j9;
            long j10 = (j9 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j10;
            j8 = j10 >> 32;
        }
        long j11 = ((iArr[3] & 4294967295L) - 1) + j8;
        iArr[3] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j13;
            long j14 = (j13 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j14;
            j12 = j14 >> 32;
        }
        long j15 = ((iArr[6] & 4294967295L) - 1) + j12;
        iArr[6] = (int) j15;
        iArr[7] = (int) ((4294967295L & iArr[7]) + 1 + (j15 >> 32));
    }

    public static void r0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        H(jArr, jArr2, jArr4);
        O0(jArr4, jArr3);
    }

    public static void r1(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        x.e.j0(iArr, iArr3);
        while (true) {
            N0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.j0(iArr2, iArr3);
            }
        }
    }

    public static void s(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j4;
        long j8 = ((iArr[1] & 4294967295L) - 1) + (j4 >> 32);
        iArr[1] = (int) j8;
        long j9 = j8 >> 32;
        if (j9 != 0) {
            long j10 = j9 + (iArr[2] & 4294967295L);
            iArr[2] = (int) j10;
            j9 = j10 >> 32;
        }
        long j11 = (iArr[3] & 4294967295L) + 1 + j9;
        iArr[3] = (int) j11;
        long j12 = (4294967295L & iArr[4]) + 1 + (j11 >> 32);
        iArr[4] = (int) j12;
        if ((j12 >> 32) != 0) {
            x.f.d0(12, 5, iArr);
        }
    }

    public static void s0(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((x.f.t0(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && x.f.X(10, iArr3, f5266h))) && x.f.k(7, f5267i, iArr3) != 0) {
            x.f.d0(10, 7, iArr3);
        }
    }

    public static void s1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        x.f.A0(iArr, iArr3);
        while (true) {
            B0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.f.A0(iArr2, iArr3);
            }
        }
    }

    public static void t(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        jArr2[0] = j4 & 144115188075855871L;
        jArr2[1] = ((j4 >>> 57) ^ (j8 << 7)) & 144115188075855871L;
        jArr2[2] = ((j8 >>> 50) ^ (j9 << 14)) & 144115188075855871L;
        jArr2[3] = ((j9 >>> 43) ^ (j10 << 21)) & 144115188075855871L;
        jArr2[4] = (j10 >>> 36) ^ (j11 << 28);
    }

    public static void t0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        C(jArr, jArr2, jArr4);
        j(jArr3, jArr4, jArr3);
    }

    public static void t1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        U(jArr, jArr3);
        while (true) {
            C0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                U(jArr2, jArr3);
            }
        }
    }

    public static void u(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        jArr2[0] = j4 & 562949953421311L;
        jArr2[1] = ((j4 >>> 49) ^ (j8 << 15)) & 562949953421311L;
        jArr2[2] = ((j8 >>> 34) ^ (j9 << 30)) & 562949953421311L;
        jArr2[3] = (j9 >>> 19) ^ (j10 << 45);
    }

    public static void u0(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        I(jArr, jArr2, jArr4);
        E0(jArr4, jArr3);
    }

    public static void u1(int[] iArr, int[] iArr2, int i8, int[] iArr3) {
        x.e.k0(iArr, iArr3);
        while (true) {
            P0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.k0(iArr2, iArr3);
            }
        }
    }

    public static void v(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        jArr2[0] = j4 & 576460752303423487L;
        jArr2[1] = ((j4 >>> 59) ^ (j8 << 5)) & 576460752303423487L;
        jArr2[2] = ((j8 >>> 54) ^ (j9 << 10)) & 576460752303423487L;
        jArr2[3] = (j9 >>> 49) ^ (j10 << 15);
    }

    public static long[] v0(long[] jArr) {
        long j4;
        long[] jArr2 = new long[288];
        int i8 = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i9 = 7;
        int i10 = 0;
        while (true) {
            j4 = 0;
            if (i9 <= 0) {
                break;
            }
            int i11 = i10 + 18;
            int i12 = i11 >>> 1;
            int i13 = 0;
            while (i13 < 9) {
                long j8 = jArr2[i12 + i13];
                jArr2[i11 + i13] = (j4 >>> 63) | (j8 << 1);
                i13++;
                j4 = j8;
            }
            int i14 = i10 + 26;
            long j9 = jArr2[i14];
            long j10 = j9 >>> 59;
            jArr2[i11] = ((j10 << 10) ^ (((j10 << 2) ^ j10) ^ (j10 << 5))) ^ jArr2[i11];
            jArr2[i14] = j9 & 576460752303423487L;
            int i15 = i10 + 27;
            for (int i16 = 0; i16 < 9; i16++) {
                jArr2[i15 + i16] = jArr2[9 + i16] ^ jArr2[i11 + i16];
            }
            i9--;
            i10 = i11;
        }
        while (i8 < 144) {
            long j11 = jArr2[i8];
            jArr2[144 + i8] = (j4 >>> (-4)) | (j11 << 4);
            i8++;
            j4 = j11;
        }
        return jArr2;
    }

    public static void v1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        x.e.i0(iArr, iArr3);
        while (true) {
            D0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.i0(iArr2, iArr3);
            }
        }
    }

    public static void w(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        jArr2[0] = j4 & 1152921504606846975L;
        jArr2[1] = ((j4 >>> 60) ^ (j8 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j8 >>> 56) ^ (j9 << 8)) & 1152921504606846975L;
        jArr2[3] = (j9 >>> 52) ^ (j10 << 12);
    }

    public static void w0(int[] iArr, int[] iArr2) {
        long j4 = iArr[7] & 4294967295L;
        long j8 = (iArr[3] & 4294967295L) + j4;
        long j9 = (iArr[6] & 4294967295L) + (j4 << 1);
        long j10 = (iArr[5] & 4294967295L) + (j9 << 1);
        long j11 = (iArr[1] & 4294967295L) + j10;
        long j12 = (iArr[4] & 4294967295L) + (j10 << 1);
        long j13 = (iArr[0] & 4294967295L) + j12;
        iArr2[0] = (int) j13;
        long j14 = j11 + (j13 >>> 32);
        iArr2[1] = (int) j14;
        long j15 = (iArr[2] & 4294967295L) + j9 + (j14 >>> 32);
        iArr2[2] = (int) j15;
        long j16 = j8 + (j12 << 1) + (j15 >>> 32);
        iArr2[3] = (int) j16;
        R0((int) (j16 >>> 32), iArr2);
    }

    public static void w1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[18];
        V(jArr, jArr3);
        while (true) {
            E0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                V(jArr2, jArr3);
            }
        }
    }

    public static void x(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        jArr2[0] = j4 & 576460752303423487L;
        jArr2[1] = ((j4 >>> 59) ^ (j8 << 5)) & 576460752303423487L;
        jArr2[2] = ((j8 >>> 54) ^ (j9 << 10)) & 576460752303423487L;
        jArr2[3] = ((j9 >>> 49) ^ (j10 << 15)) & 576460752303423487L;
        jArr2[4] = ((j10 >>> 44) ^ (j11 << 20)) & 576460752303423487L;
        jArr2[5] = ((j11 >>> 39) ^ (j12 << 25)) & 576460752303423487L;
        jArr2[6] = (j12 >>> 34) ^ (j13 << 30);
    }

    public static void x0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = j10 ^ (j11 >>> 59);
        long j13 = j4 ^ ((j12 << 61) ^ (j12 << 63));
        long j14 = (j8 ^ ((j11 << 61) ^ (j11 << 63))) ^ ((((j12 >>> 3) ^ (j12 >>> 1)) ^ j12) ^ (j12 << 5));
        long j15 = (j9 ^ ((((j11 >>> 3) ^ (j11 >>> 1)) ^ j11) ^ (j11 << 5))) ^ (j12 >>> 59);
        long j16 = j15 >>> 3;
        jArr2[0] = (((j13 ^ j16) ^ (j16 << 2)) ^ (j16 << 3)) ^ (j16 << 8);
        jArr2[1] = (j15 >>> 59) ^ j14;
        jArr2[2] = 7 & j15;
    }

    public static void x1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        x.e.i0(iArr, iArr3);
        while (true) {
            F0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.i0(iArr2, iArr3);
            }
        }
    }

    public static void y(int[] iArr, int[] iArr2, int[] iArr3) {
        x.e.c0(iArr, iArr2, iArr3);
        long j4 = iArr2[8] & 4294967295L;
        long j8 = iArr2[9] & 4294967295L;
        long j9 = iArr2[10] & 4294967295L;
        long j10 = iArr2[11] & 4294967295L;
        long j11 = iArr2[12] & 4294967295L;
        long j12 = iArr2[13] & 4294967295L;
        long j13 = iArr2[14] & 4294967295L;
        long j14 = iArr2[15] & 4294967295L;
        long j15 = iArr[8] & 4294967295L;
        long j16 = j15 * j4;
        iArr3[16] = (int) j16;
        int i8 = 32;
        long j17 = (j15 * j8) + (j16 >>> 32);
        iArr3[17] = (int) j17;
        long j18 = (j15 * j9) + (j17 >>> 32);
        iArr3[18] = (int) j18;
        long j19 = (j15 * j10) + (j18 >>> 32);
        iArr3[19] = (int) j19;
        long j20 = (j15 * j11) + (j19 >>> 32);
        iArr3[20] = (int) j20;
        long j21 = (j15 * j12) + (j20 >>> 32);
        iArr3[21] = (int) j21;
        long j22 = (j15 * j13) + (j21 >>> 32);
        iArr3[22] = (int) j22;
        long j23 = (j15 * j14) + (j22 >>> 32);
        iArr3[23] = (int) j23;
        iArr3[24] = (int) (j23 >>> 32);
        int i9 = 16;
        int i10 = 1;
        while (i10 < 8) {
            int i11 = i9 + 1;
            int i12 = i10;
            long j24 = j11;
            int i13 = i8;
            long j25 = iArr[8 + i10] & 4294967295L;
            long j26 = j12;
            long j27 = (j25 * j4) + (iArr3[i11] & 4294967295L);
            iArr3[i11] = (int) j27;
            long j28 = (j25 * j8) + (iArr3[r15] & 4294967295L) + (j27 >>> i13);
            iArr3[i9 + 2] = (int) j28;
            long j29 = (j25 * j9) + (iArr3[r8] & 4294967295L) + (j28 >>> i13);
            iArr3[i9 + 3] = (int) j29;
            long j30 = (j25 * j10) + (iArr3[r8] & 4294967295L) + (j29 >>> i13);
            iArr3[i9 + 4] = (int) j30;
            long j31 = (j25 * j24) + (iArr3[r8] & 4294967295L) + (j30 >>> i13);
            iArr3[i9 + 5] = (int) j31;
            long j32 = (j25 * j26) + (iArr3[r8] & 4294967295L) + (j31 >>> i13);
            iArr3[i9 + 6] = (int) j32;
            long j33 = (j25 * j13) + (iArr3[r8] & 4294967295L) + (j32 >>> i13);
            iArr3[i9 + 7] = (int) j33;
            long j34 = (j25 * j14) + (iArr3[r8] & 4294967295L) + (j33 >>> i13);
            iArr3[i9 + 8] = (int) j34;
            iArr3[i9 + 9] = (int) (j34 >>> i13);
            i10 = i12 + 1;
            i9 = i11;
            i8 = i13;
            j11 = j24;
            j9 = j9;
            j12 = j26;
        }
        int i14 = i8;
        int iJ = x.e.j(iArr3, iArr3);
        int i15 = 0;
        int iH = x.e.h(24, iArr3, 16, iArr3, x.e.h(0, iArr3, 8, iArr3, 0) + iJ) + iJ;
        int[] iArr4 = new int[8];
        int[] iArr5 = new int[8];
        boolean z2 = x.e.w(iArr, iArr, iArr4) != x.e.w(iArr2, iArr2, iArr5);
        int[] iArr6 = new int[16];
        x.e.c0(iArr4, iArr5, iArr6);
        x.f.m(iArr3, i14, iH + (z2 ? x.f.i(16, 8, iArr6, iArr3) : x.f.H0(16, 8, iArr6, iArr3)), 24);
        int i16 = iArr[16];
        int i17 = iArr2[16];
        long j35 = i16 & 4294967295L;
        long j36 = i17 & 4294967295L;
        long j37 = 0;
        while (true) {
            long j38 = j35;
            long j39 = ((iArr[i15] & 4294967295L) * j36) + (j38 * (iArr2[i15] & 4294967295L)) + (iArr3[r8] & 4294967295L) + j37;
            iArr3[16 + i15] = (int) j39;
            long j40 = j39 >>> 32;
            i15++;
            if (i15 >= 16) {
                iArr3[32] = (i16 * i17) + ((int) j40);
                return;
            } else {
                j37 = j40;
                j35 = j38;
            }
        }
    }

    public static void y0(int[] iArr, int[] iArr2) {
        long j4 = iArr[5] & 4294967295L;
        long j8 = iArr[6] & 4294967295L;
        long j9 = iArr[7] & 4294967295L;
        long j10 = iArr[8] & 4294967295L;
        long j11 = iArr[9] & 4294967295L;
        long j12 = (iArr[0] & 4294967295L) + j4 + (j4 << 31);
        iArr2[0] = (int) j12;
        long j13 = (iArr[1] & 4294967295L) + j8 + (j8 << 31) + (j12 >>> 32);
        iArr2[1] = (int) j13;
        long j14 = (iArr[2] & 4294967295L) + j9 + (j9 << 31) + (j13 >>> 32);
        iArr2[2] = (int) j14;
        long j15 = (iArr[3] & 4294967295L) + j10 + (j10 << 31) + (j14 >>> 32);
        iArr2[3] = (int) j15;
        long j16 = (4294967295L & iArr[4]) + j11 + (j11 << 31) + (j15 >>> 32);
        iArr2[4] = (int) j16;
        S0((int) (j16 >>> 32), iArr2);
    }

    public static void y1(int i8, long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        x.e.D(2, jArr, jArr3);
        while (true) {
            G0(jArr3, jArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.e.D(2, jArr2, jArr3);
            }
        }
    }

    public static void z(long[] jArr, long[] jArr2, long[] jArr3) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = ((jArr[2] << 40) ^ (j8 >>> 24)) & 17592186044415L;
        long j10 = ((j4 >>> 44) ^ (j8 << 20)) & 17592186044415L;
        long j11 = j4 & 17592186044415L;
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = ((j13 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j15 = ((j12 >>> 44) ^ (j13 << 20)) & 17592186044415L;
        long j16 = j12 & 17592186044415L;
        long[] jArr4 = new long[10];
        J(jArr3, j11, j16, jArr4, 0);
        J(jArr3, j9, j14, jArr4, 2);
        long j17 = (j11 ^ j10) ^ j9;
        long j18 = (j16 ^ j15) ^ j14;
        J(jArr3, j17, j18, jArr4, 4);
        long j19 = (j10 << 1) ^ (j9 << 2);
        long j20 = (j15 << 1) ^ (j14 << 2);
        J(jArr3, j11 ^ j19, j16 ^ j20, jArr4, 6);
        J(jArr3, j17 ^ j19, j18 ^ j20, jArr4, 8);
        long j21 = jArr4[6];
        long j22 = jArr4[8] ^ j21;
        long j23 = jArr4[7];
        long j24 = j23 ^ jArr4[9];
        long j25 = (j22 << 1) ^ j21;
        long j26 = (j22 ^ (j24 << 1)) ^ j23;
        long j27 = jArr4[0];
        long j28 = jArr4[1];
        long j29 = (j28 ^ j27) ^ jArr4[4];
        long j30 = j28 ^ jArr4[5];
        long j31 = jArr4[2];
        long j32 = ((j25 ^ j27) ^ (j31 << 4)) ^ (j31 << 1);
        long j33 = jArr4[3];
        long j34 = (((j29 ^ j26) ^ (j33 << 4)) ^ (j33 << 1)) ^ (j32 >>> 44);
        long j35 = (j30 ^ j24) ^ (j34 >>> 44);
        long j36 = ((j32 & 17592186044415L) >>> 1) ^ ((j34 & 1) << 43);
        long j37 = j36 ^ (j36 << 1);
        long j38 = j37 ^ (j37 << 2);
        long j39 = j38 ^ (j38 << 4);
        long j40 = j39 ^ (j39 << 8);
        long j41 = j40 ^ (j40 << 16);
        long j42 = (j41 ^ (j41 << 32)) & 17592186044415L;
        long j43 = (((j34 & 17592186044415L) >>> 1) ^ ((j35 & 1) << 43)) ^ (j42 >>> 43);
        long j44 = j43 ^ (j43 << 1);
        long j45 = j44 ^ (j44 << 2);
        long j46 = j45 ^ (j45 << 4);
        long j47 = j46 ^ (j46 << 8);
        long j48 = j47 ^ (j47 << 16);
        long j49 = 17592186044415L & (j48 ^ (j48 << 32));
        long j50 = (j35 >>> 1) ^ (j49 >>> 43);
        long j51 = j50 ^ (j50 << 1);
        long j52 = j51 ^ (j51 << 2);
        long j53 = j52 ^ (j52 << 4);
        long j54 = j53 ^ (j53 << 8);
        long j55 = j54 ^ (j54 << 16);
        long j56 = j55 ^ (j55 << 32);
        jArr3[0] = j27;
        long j57 = (j29 ^ j42) ^ j31;
        jArr3[1] = j57;
        long j58 = ((j30 ^ j49) ^ j42) ^ j33;
        jArr3[2] = j58;
        long j59 = j49 ^ j56;
        jArr3[3] = j59;
        long j60 = j56 ^ jArr4[2];
        jArr3[4] = j60;
        long j61 = jArr4[3];
        jArr3[5] = j61;
        jArr3[0] = j27 ^ (j57 << 44);
        jArr3[1] = (j57 >>> 20) ^ (j58 << 24);
        jArr3[2] = ((j58 >>> 40) ^ (j59 << 4)) ^ (j60 << 48);
        jArr3[3] = ((j59 >>> 60) ^ (j61 << 28)) ^ (j60 >>> 16);
        jArr3[4] = j61 >>> 36;
        jArr3[5] = 0;
    }

    public static void z0(long[] jArr, long[] jArr2) {
        long j4 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = j10 ^ ((((j12 >>> 35) ^ (j12 >>> 32)) ^ (j12 >>> 29)) ^ (j12 >>> 28));
        long j14 = (j9 ^ ((((j12 << 29) ^ (j12 << 32)) ^ (j12 << 35)) ^ (j12 << 36))) ^ ((j11 >>> 28) ^ (((j11 >>> 35) ^ (j11 >>> 32)) ^ (j11 >>> 29)));
        long j15 = j4 ^ ((((j13 << 29) ^ (j13 << 32)) ^ (j13 << 35)) ^ (j13 << 36));
        long j16 = (j8 ^ ((((j11 << 29) ^ (j11 << 32)) ^ (j11 << 35)) ^ (j11 << 36))) ^ ((j13 >>> 28) ^ (((j13 >>> 35) ^ (j13 >>> 32)) ^ (j13 >>> 29)));
        long j17 = j14 >>> 35;
        jArr2[0] = (((j15 ^ j17) ^ (j17 << 3)) ^ (j17 << 6)) ^ (j17 << 7);
        jArr2[1] = j16;
        jArr2[2] = 34359738367L & j14;
    }

    public static void z1(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        x.f.B0(iArr, iArr3);
        while (true) {
            H0(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                x.f.B0(iArr2, iArr3);
            }
        }
    }
}
