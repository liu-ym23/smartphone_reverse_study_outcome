package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f21360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f21361c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21362a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f21363a;

        public a(Throwable r10) {
            this.f21363a = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (q.b(this.f21363a, ((a) r10).f21363a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Throwable r10 = this.f21363a;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        @Override // kotlinx.coroutines.channels.f.c
        public String toString() {
            return "Closed(" + this.f21363a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final Object a(Throwable r10) {
            return f.c(new a(r10));
        }

        public final Object b() {
            return f.c(f.a());
        }

        public final Object c(Object r10) {
            return f.c(r10);
        }

        public b() {
        }
    }

    public static class c {
        public c() {
        }

        public String toString() {
            return "Failed";
        }
    }

    static {
        f21360b = new b(null);
        f21361c = new c();
    }

    public /* synthetic */ f(Object r10) {
        this.f21362a = r10;
    }

    public static final /* synthetic */ c a() {
        return f21361c;
    }

    public static final /* synthetic */ f b(Object r10) {
        return new f(r10);
    }

    public static Object c(Object r10) {
        return r10;
    }

    public static boolean d(Object r10, Object r11) {
        if ((r11 instanceof f) == true) goto L6;
        return false;
    L6:
        if (q.b(r10, ((f) r11).l()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static final Throwable e(Object r10) {
        if ((r10 instanceof a) == false) goto L5;
        a r11 = (a) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.f21363a;
    L5:
        r11 = null;
        goto L6
    }

    public static final Object f(Object r10) {
        if ((r10 instanceof c) == false) goto L7;
        return null;
    L7:
        return r10;
    }

    public static final Object g(Object r10) {
        if ((r10 instanceof c) == true) goto L6;
        return r10;
    L6:
        if ((r10 instanceof a) == false) goto L11;
        Throwable r11 = ((a) r10).f21363a;
        if (r11 == null) goto L11;
        throw r11;
    L11:
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + r10).toString());
    }

    public static int h(Object r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.hashCode();
    }

    public static final boolean i(Object r10) {
        return r10 instanceof a;
    }

    public static final boolean j(Object r10) {
        return !(r10 instanceof c);
    }

    public static String k(Object r10) {
        if ((r10 instanceof a) == false) goto L6;
        return ((a) r10).toString();
    L6:
        return "Value(" + r10 + ')';
    }

    public boolean equals(Object r10) {
        return d(this.f21362a, r10);
    }

    public int hashCode() {
        return h(this.f21362a);
    }

    public final /* synthetic */ Object l() {
        return this.f21362a;
    }

    public String toString() {
        return k(this.f21362a);
    }
}
