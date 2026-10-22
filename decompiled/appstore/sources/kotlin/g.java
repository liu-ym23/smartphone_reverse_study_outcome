package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21126b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21127a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21126b = new a(null);
    }

    public /* synthetic */ g(int r10) {
        this.f21127a = r10;
    }

    public static final /* synthetic */ g a(int r10) {
        return new g(r10);
    }

    public static int b(int r10) {
        return r10;
    }

    public static boolean c(int r10, Object r11) {
        if ((r11 instanceof g) == true) goto L6;
        return false;
    L6:
        if (r10 == ((g) r11).f()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int d(int r10) {
        return Integer.hashCode(r10);
    }

    public static String e(int r10) {
        return String.valueOf(((long) r10) & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        int r11 = ((g) r10).f();
        return n.a(f(), r11);
    }

    public boolean equals(Object r10) {
        return c(this.f21127a, r10);
    }

    public final /* synthetic */ int f() {
        return this.f21127a;
    }

    public int hashCode() {
        return d(this.f21127a);
    }

    public String toString() {
        return e(this.f21127a);
    }
}
