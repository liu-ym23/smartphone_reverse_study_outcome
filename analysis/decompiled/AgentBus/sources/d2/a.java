package d2;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f2778a;

    public /* synthetic */ a(long j2) {
        this.f2778a = j2;
    }

    public static long a(long j2, int i2, int i10, int i11) {
        int iJ = (i11 & 1) != 0 ? j(j2) : 0;
        if ((i11 & 2) != 0) {
            i2 = h(j2);
        }
        int i12 = (i11 & 4) != 0 ? i(j2) : 0;
        if ((i11 & 8) != 0) {
            i10 = g(j2);
        }
        if (i2 < iJ || i10 < i12 || iJ < 0 || i12 < 0) {
            h.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return b.g(iJ, i2, i12, i10);
    }

    public static final boolean b(long j2, long j4) {
        return j2 == j4;
    }

    public static final boolean c(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1);
        return (((int) (j2 >> (i10 + 46))) & ((1 << (18 - i10)) - 1)) != 0;
    }

    public static final boolean d(long j2) {
        int i2 = (int) (3 & j2);
        return (((int) (j2 >> 33)) & ((1 << (((((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1)) + 13)) - 1)) != 0;
    }

    public static final boolean e(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1);
        int i11 = (1 << (18 - i10)) - 1;
        int i12 = ((int) (j2 >> (i10 + 15))) & i11;
        int i13 = ((int) (j2 >> (i10 + 46))) & i11;
        return i12 == (i13 == 0 ? Integer.MAX_VALUE : i13 - 1);
    }

    public static final boolean f(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (1 << (((((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1)) + 13)) - 1;
        int i11 = ((int) (j2 >> 2)) & i10;
        int i12 = ((int) (j2 >> 33)) & i10;
        return i11 == (i12 == 0 ? Integer.MAX_VALUE : i12 - 1);
    }

    public static final int g(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1);
        int i11 = ((int) (j2 >> (i10 + 46))) & ((1 << (18 - i10)) - 1);
        if (i11 == 0) {
            return Integer.MAX_VALUE;
        }
        return i11 - 1;
    }

    public static final int h(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (int) (j2 >> 33);
        int i11 = i10 & ((1 << (((((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1)) + 13)) - 1);
        if (i11 == 0) {
            return Integer.MAX_VALUE;
        }
        return i11 - 1;
    }

    public static final int i(long j2) {
        int i2 = (int) (3 & j2);
        int i10 = (((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1);
        return ((int) (j2 >> (i10 + 15))) & ((1 << (18 - i10)) - 1);
    }

    public static final int j(long j2) {
        int i2 = (int) (3 & j2);
        return ((int) (j2 >> 2)) & ((1 << (((((i2 & 2) >> 1) * 3) + ((i2 & 1) << 1)) + 13)) - 1);
    }

    public static String k(long j2) {
        int iH = h(j2);
        String strValueOf = iH == Integer.MAX_VALUE ? "Infinity" : String.valueOf(iH);
        int iG = g(j2);
        String strValueOf2 = iG != Integer.MAX_VALUE ? String.valueOf(iG) : "Infinity";
        StringBuilder sb2 = new StringBuilder("Constraints(minWidth = ");
        sb2.append(j(j2));
        sb2.append(", maxWidth = ");
        sb2.append(strValueOf);
        sb2.append(", minHeight = ");
        sb2.append(i(j2));
        sb2.append(", maxHeight = ");
        return a1.a.l(sb2, strValueOf2, ')');
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f2778a == ((a) obj).f2778a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2778a);
    }

    public final String toString() {
        return k(this.f2778a);
    }
}
