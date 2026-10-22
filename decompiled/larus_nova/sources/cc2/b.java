package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23140a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23141b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23142c = null;

        static {
            f23142c = new a();
            f23141b = "ClearScreen";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23141b;
        }
    }

    /* JADX INFO: renamed from: cc2.b$b, reason: collision with other inner class name */
    public static final class C0428b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23143b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0428b f23144c = null;

        static {
            f23144c = new C0428b();
            f23143b = "MultiAnchor";
        }

        public C0428b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23143b;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23145b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f23146c = null;

        static {
            f23146c = new c();
            f23145b = "PK";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return f23145b;
        }
    }

    public b() {
        this.f23140a = "AudienceShadowView";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23140a;
    }
}
