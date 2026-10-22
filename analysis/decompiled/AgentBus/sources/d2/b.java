package d2;

/* loaded from: classes.dex */
public abstract class b {
    public static final long a(int i2, int i10, int i11, int i12) {
        if (!((i11 >= 0) & (i10 >= i2) & (i12 >= i11) & (i2 >= 0))) {
            h.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return g(i2, i10, i11, i12);
    }

    public static /* synthetic */ long b(int i2, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return a(0, i2, 0, i10);
    }

    public static final int c(int i2) {
        if (i2 < 8191) {
            return 13;
        }
        if (i2 < 32767) {
            return 15;
        }
        if (i2 < 65535) {
            return 16;
        }
        return i2 < 262143 ? 18 : 255;
    }

    public static final long d(long j2, long j4) {
        int i2 = (int) (j4 >> 32);
        int iJ = a.j(j2);
        int iH = a.h(j2);
        if (i2 < iJ) {
            i2 = iJ;
        }
        if (i2 <= iH) {
            iH = i2;
        }
        int i10 = (int) (j4 & 4294967295L);
        int i11 = a.i(j2);
        int iG = a.g(j2);
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 <= iG) {
            iG = i10;
        }
        return (iH << 32) | (iG & 4294967295L);
    }

    public static final int e(int i2, long j2) {
        int i10 = a.i(j2);
        int iG = a.g(j2);
        if (i2 < i10) {
            i2 = i10;
        }
        return i2 > iG ? iG : i2;
    }

    public static final int f(int i2, long j2) {
        int iJ = a.j(j2);
        int iH = a.h(j2);
        if (i2 < iJ) {
            i2 = iJ;
        }
        return i2 > iH ? iH : i2;
    }

    public static final long g(int i2, int i10, int i11, int i12) {
        int i13 = i12 == Integer.MAX_VALUE ? i11 : i12;
        int iC = c(i13);
        int i14 = i10 == Integer.MAX_VALUE ? i2 : i10;
        int iC2 = c(i14);
        if (iC + iC2 > 31) {
            i(i14, i13);
        }
        int i15 = i10 + 1;
        int i16 = i12 + 1;
        int i17 = iC2 - 13;
        return ((i15 & (~(i15 >> 31))) << 33) | ((i17 >> 1) + (i17 & 1)) | (i2 << 2) | (i11 << (iC2 + 2)) | ((i16 & (~(i16 >> 31))) << (iC2 + 33));
    }

    public static final long h(long j2, int i2, int i10) {
        int iJ = a.j(j2) + i2;
        if (iJ < 0) {
            iJ = 0;
        }
        int iH = a.h(j2);
        if (iH != Integer.MAX_VALUE && (iH = iH + i2) < 0) {
            iH = 0;
        }
        int i11 = a.i(j2) + i10;
        if (i11 < 0) {
            i11 = 0;
        }
        int iG = a.g(j2);
        return a(iJ, iH, i11, (iG == Integer.MAX_VALUE || (iG = iG + i10) >= 0) ? iG : 0);
    }

    public static final void i(int i2, int i10) {
        throw new IllegalArgumentException("Can't represent a width of " + i2 + " and height of " + i10 + " in Constraints");
    }

    public static final Void j(int i2) {
        throw new IllegalArgumentException(a1.a.f(i2, "Can't represent a size of ", " in Constraints"));
    }
}
