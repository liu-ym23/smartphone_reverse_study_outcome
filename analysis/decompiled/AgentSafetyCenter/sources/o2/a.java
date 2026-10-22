package o2;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f9108a;

    public static final /* synthetic */ a a(long j10) {
        a aVar = new a();
        aVar.f9108a = j10;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public static long b(long j10, int i, int i3, int i10, int i11, int i12) {
        if ((i12 & 1) != 0) {
            i = k(j10);
        }
        if ((i12 & 2) != 0) {
            i3 = i(j10);
        }
        if ((i12 & 4) != 0) {
            i10 = j(j10);
        }
        if ((i12 & 8) != 0) {
            i11 = h(j10);
        }
        if (i3 < i || i11 < i10 || i < 0 || i10 < 0) {
            h.a("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return b.g(i, i3, i10, i11);
    }

    public static final boolean c(long j10, long j11) {
        return j10 == j11;
    }

    public static final boolean d(long j10) {
        int i = (int) (3 & j10);
        int i3 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return (((int) (j10 >> (i3 + 46))) & ((1 << (18 - i3)) - 1)) != 0;
    }

    public static final boolean e(long j10) {
        int i = (int) (3 & j10);
        return (((int) (j10 >> 33)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1)) != 0;
    }

    public static final boolean f(long j10) {
        int i = (int) (3 & j10);
        int i3 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i10 = (1 << (18 - i3)) - 1;
        int i11 = ((int) (j10 >> (i3 + 15))) & i10;
        int i12 = ((int) (j10 >> (i3 + 46))) & i10;
        return i11 == (i12 == 0 ? Reader.READ_DONE : i12 - 1);
    }

    public static final boolean g(long j10) {
        int i = (int) (3 & j10);
        int i3 = (1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1;
        int i10 = ((int) (j10 >> 2)) & i3;
        int i11 = ((int) (j10 >> 33)) & i3;
        return i10 == (i11 == 0 ? Reader.READ_DONE : i11 - 1);
    }

    public static final int h(long j10) {
        int i = (int) (3 & j10);
        int i3 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        int i10 = ((int) (j10 >> (i3 + 46))) & ((1 << (18 - i3)) - 1);
        return i10 == 0 ? Reader.READ_DONE : i10 - 1;
    }

    public static final int i(long j10) {
        int i = (int) (3 & j10);
        int i3 = ((int) (j10 >> 33)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
        return i3 == 0 ? Reader.READ_DONE : i3 - 1;
    }

    public static final int j(long j10) {
        int i = (int) (3 & j10);
        int i3 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((int) (j10 >> (i3 + 15))) & ((1 << (18 - i3)) - 1);
    }

    public static final int k(long j10) {
        int i = (int) (3 & j10);
        return ((int) (j10 >> 2)) & ((1 << (((((i & 2) >> 1) * 3) + ((i & 1) << 1)) + 13)) - 1);
    }

    public static final boolean l(long j10) {
        int i = (int) (3 & j10);
        int i3 = (((i & 2) >> 1) * 3) + ((i & 1) << 1);
        return ((((int) (j10 >> 33)) & ((1 << (i3 + 13)) - 1)) - 1 == 0) | ((((int) (j10 >> (i3 + 46))) & ((1 << (18 - i3)) - 1)) - 1 == 0);
    }

    public static String m(long j10) {
        int i = i(j10);
        String strValueOf = i == Integer.MAX_VALUE ? "Infinity" : String.valueOf(i);
        int iH = h(j10);
        String strValueOf2 = iH != Integer.MAX_VALUE ? String.valueOf(iH) : "Infinity";
        StringBuilder sb2 = new StringBuilder("Constraints(minWidth = ");
        sb2.append(k(j10));
        sb2.append(", maxWidth = ");
        sb2.append(strValueOf);
        sb2.append(", minHeight = ");
        sb2.append(j(j10));
        sb2.append(", maxHeight = ");
        return k0.a.s(sb2, strValueOf2, ')');
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f9108a == ((a) obj).f9108a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9108a);
    }

    public final String toString() {
        return m(this.f9108a);
    }
}
