package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21130b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21131a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21130b = new a(null);
    }

    public /* synthetic */ i(long r10) {
        this.f21131a = r10;
    }

    public static final /* synthetic */ i a(long r10) {
        return new i(r10);
    }

    public static long b(long r10) {
        return r10;
    }

    public static boolean c(long r10, Object r11) {
        if ((r11 instanceof i) == true) goto L6;
        return false;
    L6:
        if (r10 == ((i) r11).f()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int d(long r10) {
        return Long.hashCode(r10);
    }

    public static String e(long r10) {
        return n.c(r10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        long r11 = ((i) r10).f();
        return n.b(f(), r11);
    }

    public boolean equals(Object r10) {
        return c(this.f21131a, r10);
    }

    public final /* synthetic */ long f() {
        return this.f21131a;
    }

    public int hashCode() {
        return d(this.f21131a);
    }

    public String toString() {
        return e(this.f21131a);
    }
}
