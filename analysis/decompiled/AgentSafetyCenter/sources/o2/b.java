package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {
    public static final long a(int i, int i3, int i10, int i11) {
        if (!((i10 >= 0) & (i3 >= i) & (i11 >= i10) & (i >= 0))) {
            h.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return g(i, i3, i10, i11);
    }

    public static /* synthetic */ long b(int i, int i3, int i10) {
        if ((i10 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i10 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return a(0, i, 0, i3);
    }

    public static final int c(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < 262143 ? 18 : 255;
    }

    public static final long d(long j10, long j11) {
        int i = (int) (j11 >> 32);
        int iK = a.k(j10);
        int i3 = a.i(j10);
        if (i < iK) {
            i = iK;
        }
        if (i <= i3) {
            i3 = i;
        }
        int i10 = (int) (j11 & 4294967295L);
        int iJ = a.j(j10);
        int iH = a.h(j10);
        if (i10 < iJ) {
            i10 = iJ;
        }
        if (i10 <= iH) {
            iH = i10;
        }
        return (i3 << 32) | (iH & 4294967295L);
    }

    public static final int e(int i, long j10) {
        int iJ = a.j(j10);
        int iH = a.h(j10);
        if (i < iJ) {
            i = iJ;
        }
        return i > iH ? iH : i;
    }

    public static final int f(int i, long j10) {
        int iK = a.k(j10);
        int i3 = a.i(j10);
        if (i < iK) {
            i = iK;
        }
        return i > i3 ? i3 : i;
    }

    public static final long g(int i, int i3, int i10, int i11) {
        int i12 = i11 == Integer.MAX_VALUE ? i10 : i11;
        int iC = c(i12);
        int i13 = i3 == Integer.MAX_VALUE ? i : i3;
        int iC2 = c(i13);
        if (iC + iC2 > 31) {
            i(i13, i12);
        }
        int i14 = i3 + 1;
        int i15 = i11 + 1;
        int i16 = iC2 - 13;
        return ((i14 & (~(i14 >> 31))) << 33) | ((i16 >> 1) + (i16 & 1)) | (i << 2) | (i10 << (iC2 + 2)) | ((i15 & (~(i15 >> 31))) << (iC2 + 33));
    }

    public static final long h(long j10, int i, int i3) {
        int iK = a.k(j10) + i;
        if (iK < 0) {
            iK = 0;
        }
        int i10 = a.i(j10);
        if (i10 != Integer.MAX_VALUE && (i10 = i10 + i) < 0) {
            i10 = 0;
        }
        int iJ = a.j(j10) + i3;
        if (iJ < 0) {
            iJ = 0;
        }
        int iH = a.h(j10);
        return a(iK, i10, iJ, (iH == Integer.MAX_VALUE || (iH = iH + i3) >= 0) ? iH : 0);
    }

    public static final void i(int i, int i3) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i3 + " in Constraints");
    }

    public static final Void j(int i) {
        throw new IllegalArgumentException(k0.a.k(i, "Can't represent a size of ", " in Constraints"));
    }
}
