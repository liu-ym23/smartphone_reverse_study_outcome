package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f38809a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f38810c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f38811b;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f38812a;

        public a(Throwable r1) {
            this.f38812a = r1;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (d.h.b.o.a(this.f38812a, ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin")).f38812a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Throwable r0 = this.f38812a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @Override // kotlinx.coroutines.a.h.c
        public String toString() {
            return "Closed(" + this.f38812a + ')';
        }
    }

    /* JADX INFO: compiled from: Channel.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final <E> Object a(E r1) {
            return h.h(r1);
        }

        public final <E> Object a() {
            return h.h(h.b());
        }

        public final <E> Object a(Throwable r1) {
            return h.h(new a(r1));
        }
    }

    /* JADX INFO: compiled from: Channel.kt */
    public static class c {
        public String toString() {
            return "Failed";
        }

        public c() {
        }
    }

    public static boolean a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, h.class) == true) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r3, ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static int g(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static <T> Object h(Object r0) {
        return r0;
    }

    public static final /* synthetic */ h i(Object r1) {
        return new h(r1);
    }

    public final /* synthetic */ Object a() {
        return this.f38811b;
    }

    public boolean equals(Object r1) {
        return a(this.f38811b, r1);
    }

    public int hashCode() {
        return g(this.f38811b);
    }

    public static final /* synthetic */ c b() {
        return f38810c;
    }

    private /* synthetic */ h(Object r1) {
        this.f38811b = r1;
    }

    public static final boolean a(Object r1) {
        return !ZeusTransformUtils.instanceOf(r1, c.class);
    }

    public static final boolean b(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    public static final boolean c(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T d(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        return null;
    L7:
        return r1;
    }

    public static final Throwable e(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L5;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.f38812a;
    L5:
        r4 = null;
        goto L6
    }

    static {
        f38809a = new b(null);
        f38810c = new c();
    }

    public String toString() {
        return f(this.f38811b);
    }

    public static String f(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L6;
        return ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).toString();
    L6:
        return "Value(" + r2 + ')';
    }
}
