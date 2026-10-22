package r7;

import x.e;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5224a = {-1, -1, 0, -1, -1, -1, -1, -2};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5225b = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.c(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= Integer.MAX_VALUE && e.P(iArr3, f5224a))) {
            b(iArr3);
        }
    }

    public static void b(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j4;
        long j8 = j4 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j9;
            j8 = j9 >> 32;
        }
        long j10 = ((iArr[2] & 4294967295L) - 1) + j8;
        iArr[2] = (int) j10;
        long j11 = (iArr[3] & 4294967295L) + 1 + (j10 >> 32);
        iArr[3] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j13;
            long j14 = (j13 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j14;
            long j15 = (j14 >> 32) + (iArr[6] & 4294967295L);
            iArr[6] = (int) j15;
            j12 = j15 >> 32;
        }
        iArr[7] = (int) ((4294967295L & iArr[7]) + 1 + j12);
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        e.c0(iArr, iArr2, iArr4);
        d(iArr4, iArr3);
    }

    public static void d(int[] iArr, int[] iArr2) {
        long j4 = iArr[8] & 4294967295L;
        long j8 = iArr[9] & 4294967295L;
        long j9 = iArr[10] & 4294967295L;
        long j10 = iArr[11] & 4294967295L;
        long j11 = iArr[12] & 4294967295L;
        long j12 = iArr[13] & 4294967295L;
        long j13 = iArr[14] & 4294967295L;
        long j14 = iArr[15] & 4294967295L;
        long j15 = j9 + j10;
        long j16 = j12 + j13;
        long j17 = j16 + (j14 << 1);
        long j18 = j4 + j8 + j16;
        long j19 = j15 + j11 + j14 + j18;
        long j20 = (iArr[0] & 4294967295L) + j19 + j12 + j13 + j14;
        iArr2[0] = (int) j20;
        long j21 = (((iArr[1] & 4294967295L) + j19) - j4) + j13 + j14 + (j20 >> 32);
        iArr2[1] = (int) j21;
        long j22 = ((iArr[2] & 4294967295L) - j18) + (j21 >> 32);
        iArr2[2] = (int) j22;
        long j23 = ((((iArr[3] & 4294967295L) + j19) - j8) - j9) + j12 + (j22 >> 32);
        iArr2[3] = (int) j23;
        long j24 = ((((iArr[4] & 4294967295L) + j19) - j15) - j4) + j13 + (j23 >> 32);
        iArr2[4] = (int) j24;
        long j25 = (iArr[5] & 4294967295L) + j17 + j9 + (j24 >> 32);
        iArr2[5] = (int) j25;
        long j26 = (iArr[6] & 4294967295L) + j10 + j13 + j14 + (j25 >> 32);
        iArr2[6] = (int) j26;
        long j27 = (iArr[7] & 4294967295L) + j19 + j17 + j11 + (j26 >> 32);
        iArr2[7] = (int) j27;
        e((int) (j27 >> 32), iArr2);
    }

    public static void e(int i8, int[] iArr) {
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
            long j12 = ((iArr[2] & 4294967295L) - j8) + j10;
            iArr[2] = (int) j12;
            long j13 = (iArr[3] & 4294967295L) + j8 + (j12 >> 32);
            iArr[3] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (iArr[4] & 4294967295L);
                iArr[4] = (int) j15;
                long j16 = (j15 >> 32) + (iArr[5] & 4294967295L);
                iArr[5] = (int) j16;
                long j17 = (j16 >> 32) + (iArr[6] & 4294967295L);
                iArr[6] = (int) j17;
                j14 = j17 >> 32;
            }
            long j18 = (4294967295L & iArr[7]) + j8 + j14;
            iArr[7] = (int) j18;
            j4 = j18 >> 32;
        } else {
            j4 = 0;
        }
        if (j4 != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && e.P(iArr, f5224a))) {
            b(iArr);
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        e.j0(iArr, iArr3);
        d(iArr3, iArr2);
    }

    public static void g(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        e.j0(iArr, iArr3);
        while (true) {
            d(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                e.j0(iArr2, iArr3);
            }
        }
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.p0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 1;
            iArr3[0] = (int) j4;
            long j8 = j4 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr3[1] & 4294967295L);
                iArr3[1] = (int) j9;
                j8 = j9 >> 32;
            }
            long j10 = (iArr3[2] & 4294967295L) + 1 + j8;
            iArr3[2] = (int) j10;
            long j11 = ((iArr3[3] & 4294967295L) - 1) + (j10 >> 32);
            iArr3[3] = (int) j11;
            long j12 = j11 >> 32;
            if (j12 != 0) {
                long j13 = j12 + (iArr3[4] & 4294967295L);
                iArr3[4] = (int) j13;
                long j14 = (j13 >> 32) + (iArr3[5] & 4294967295L);
                iArr3[5] = (int) j14;
                long j15 = (j14 >> 32) + (iArr3[6] & 4294967295L);
                iArr3[6] = (int) j15;
                j12 = j15 >> 32;
            }
            iArr3[7] = (int) (((4294967295L & iArr3[7]) - 1) + j12);
        }
    }
}
