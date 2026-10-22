package aa6;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2347a;

    /* JADX INFO: renamed from: aa6.a$a, reason: collision with other inner class name */
    public static final class C0038a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0038a f2348b = null;

        static {
            f2348b = new C0038a();
        }

        public C0038a() {
            super("adjust");
        }
    }

    public static abstract class b extends a {

        /* JADX INFO: renamed from: aa6.a$b$a, reason: collision with other inner class name */
        public static final class C0039a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0039a f2349b = null;

            static {
                f2349b = new C0039a();
            }

            public C0039a() {
                super("query");
            }
        }

        /* JADX INFO: renamed from: aa6.a$b$b, reason: collision with other inner class name */
        public static final class C0040b extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0040b f2350b = null;

            static {
                f2350b = new C0040b();
            }

            public C0040b() {
                super("uplink");
            }
        }

        public b(String r100) {
            super(r100);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f2351b = null;

        static {
            f2351b = new c();
        }

        public c() {
            super("patch");
        }
    }

    public a(String r100) {
        this.f2347a = r100;
    }
}
