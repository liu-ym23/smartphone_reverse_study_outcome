package u4;

/* renamed from: u4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1168f<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f22963b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final c f22964c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Object f22965a;

    /* renamed from: u4.f$a */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f22966a;

        public a(Throwable th) {
            this.f22966a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && j4.k.b(this.f22966a, ((a) obj).f22966a);
        }

        public int hashCode() {
            Throwable th = this.f22966a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // u4.C1168f.c
        public String toString() {
            return "Closed(" + this.f22966a + ')';
        }
    }

    /* renamed from: u4.f$b */
    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return C1168f.c(new a(th));
        }

        public final <E> Object b() {
            return C1168f.c(C1168f.f22964c);
        }

        public final <E> Object c(E e6) {
            return C1168f.c(e6);
        }

        private b() {
        }
    }

    /* renamed from: u4.f$c */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ C1168f(Object obj) {
        this.f22965a = obj;
    }

    public static final /* synthetic */ C1168f b(Object obj) {
        return new C1168f(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof C1168f) && j4.k.b(obj, ((C1168f) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f22966a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f22965a, obj);
    }

    public int hashCode() {
        return g(this.f22965a);
    }

    public final /* synthetic */ Object k() {
        return this.f22965a;
    }

    public String toString() {
        return j(this.f22965a);
    }
}
