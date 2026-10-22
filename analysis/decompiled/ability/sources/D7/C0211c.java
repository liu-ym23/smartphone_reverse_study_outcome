package D7;

/* renamed from: D7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0211c {
    public static void a(int i, int i6, int i10) {
        if (i < 0 || i6 > i10) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "startIndex: ", i6, ", endIndex: ", ", size: ");
            sbS.append(i10);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i > i6) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(i, i6, "startIndex: ", " > endIndex: "));
        }
    }

    public static void b(int i, int i6) {
        if (i < 0 || i >= i6) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.n(i, i6, "index: ", ", size: "));
        }
    }

    public static void c(int i, int i6) {
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.n(i, i6, "index: ", ", size: "));
        }
    }

    public static void d(int i, int i6, int i10) {
        if (i < 0 || i6 > i10) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "fromIndex: ", i6, ", toIndex: ", ", size: ");
            sbS.append(i10);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i > i6) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(i, i6, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int e(int i, int i6) {
        int i10 = i + (i >> 1);
        if (i10 - i6 < 0) {
            i10 = i6;
        }
        return i10 - 2147483639 > 0 ? i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i10;
    }
}
