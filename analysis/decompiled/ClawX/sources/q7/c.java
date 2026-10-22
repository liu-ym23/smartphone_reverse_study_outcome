package q7;

import x.e;
import x.f;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4898a = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f4899b = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        e.c0(iArr, iArr2, iArr4);
        b(iArr4, iArr3);
    }

    public static void b(int[] iArr, int[] iArr2) {
        int i8 = iArr[7];
        int i9 = i8;
        int i10 = 0;
        while (i10 < 8) {
            int i11 = iArr[8 + i10];
            iArr2[i10] = (i9 >>> 31) | (i11 << 1);
            i10++;
            i9 = i11;
        }
        long j4 = 19 & 4294967295L;
        long j8 = ((iArr2[0] & 4294967295L) * j4) + (iArr[0] & 4294967295L);
        iArr2[0] = (int) j8;
        long j9 = ((iArr2[1] & 4294967295L) * j4) + (iArr[1] & 4294967295L) + (j8 >>> 32);
        iArr2[1] = (int) j9;
        long j10 = ((iArr2[2] & 4294967295L) * j4) + (iArr[2] & 4294967295L) + (j9 >>> 32);
        iArr2[2] = (int) j10;
        long j11 = ((iArr2[3] & 4294967295L) * j4) + (iArr[3] & 4294967295L) + (j10 >>> 32);
        iArr2[3] = (int) j11;
        long j12 = ((iArr2[4] & 4294967295L) * j4) + (iArr[4] & 4294967295L) + (j11 >>> 32);
        iArr2[4] = (int) j12;
        long j13 = ((iArr2[5] & 4294967295L) * j4) + (iArr[5] & 4294967295L) + (j12 >>> 32);
        iArr2[5] = (int) j13;
        long j14 = ((iArr2[6] & 4294967295L) * j4) + (iArr[6] & 4294967295L) + (j13 >>> 32);
        iArr2[6] = (int) j14;
        long j15 = (j4 * (iArr2[7] & 4294967295L)) + (4294967295L & iArr[7]) + (j14 >>> 32);
        int i12 = (int) j15;
        iArr2[7] = i12;
        iArr2[7] = f.n(7, (((i12 >>> 31) - (i8 >>> 31)) + (((int) (j15 >>> 32)) << 1)) * 19, iArr2) + (Integer.MAX_VALUE & i12);
        if (e.P(iArr2, f4898a)) {
            f(iArr2);
        }
    }

    public static void c(int i8, int[] iArr) {
        int i9 = iArr[7];
        iArr[7] = f.n(7, ((i8 << 1) | (i9 >>> 31)) * 19, iArr) + (i9 & Integer.MAX_VALUE);
        if (e.P(iArr, f4898a)) {
            f(iArr);
        }
    }

    public static void d(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        e.j0(iArr, iArr3);
        b(iArr3, iArr2);
    }

    public static void e(int i8, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        e.j0(iArr, iArr3);
        while (true) {
            b(iArr3, iArr2);
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                e.j0(iArr2, iArr3);
            }
        }
    }

    public static void f(int[] iArr) {
        long j4 = (iArr[0] & 4294967295L) + 19;
        iArr[0] = (int) j4;
        long jD0 = j4 >> 32;
        if (jD0 != 0) {
            jD0 = f.d0(7, 1, iArr);
        }
        iArr[7] = (int) (((iArr[7] & 4294967295L) - 2147483648L) + jD0);
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (e.p0(iArr, iArr2, iArr3) != 0) {
            long j4 = (iArr3[0] & 4294967295L) - 19;
            iArr3[0] = (int) j4;
            long jB = j4 >> 32;
            if (jB != 0) {
                jB = f.B(7, 1, iArr3);
            }
            iArr3[7] = (int) ((4294967295L & iArr3[7]) + 2147483648L + jB);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        f.x0(8, 0, iArr, iArr2);
        if (e.P(iArr2, f4898a)) {
            f(iArr2);
        }
    }
}
