package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21195b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f21196a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21195b = new a(null);
    }

    public /* synthetic */ l(short r10) {
        this.f21196a = r10;
    }

    public static final /* synthetic */ l a(short r10) {
        return new l(r10);
    }

    public static short b(short r10) {
        return r10;
    }

    public static boolean c(short r10, Object r11) {
        if ((r11 instanceof l) == true) goto L6;
        return false;
    L6:
        if (r10 == ((l) r11).f()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int d(short r10) {
        return Short.hashCode(r10);
    }

    public static String e(short r10) {
        return String.valueOf(r10 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        short r11 = ((l) r10).f();
        return q.i(f() & 65535, r11 & 65535);
    }

    public boolean equals(Object r10) {
        return c(this.f21196a, r10);
    }

    public final /* synthetic */ short f() {
        return this.f21196a;
    }

    public int hashCode() {
        return d(this.f21196a);
    }

    public String toString() {
        return e(this.f21196a);
    }
}
