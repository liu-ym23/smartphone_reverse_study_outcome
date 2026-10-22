package cc6;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23295b;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23296c = null;

        static {
            f23296c = new a();
        }

        public a() {
            super(111, "api_api_failed");
        }
    }

    /* JADX INFO: renamed from: cc6.b$b, reason: collision with other inner class name */
    public static final class C0430b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0430b f23297c = null;

        static {
            f23297c = new C0430b();
        }

        public C0430b() {
            super(110, "check_link_failed");
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f23298c = null;

        static {
            f23298c = new c();
        }

        public c() {
            super(113, "join_channel_api_failed");
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f23299c = null;

        static {
            f23299c = new d();
        }

        public d() {
            super(115, "live_client_init_failed");
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f23300c = null;

        static {
            f23300c = new e();
        }

        public e() {
            super(112, "reply_api_failed");
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f23301c = null;

        static {
            f23301c = new f();
        }

        public f() {
            super(114, "rtc_client_init_failed");
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f23302c = null;

        static {
            f23302c = new g();
        }

        public g() {
            super(116, "rtc_start_failed");
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f23303c = null;

        static {
            f23303c = new h();
        }

        public h() {
            super(118, "rtc_stop_failed");
        }
    }

    public final String toString() {
        return "errorCode " + this.f23294a + ", errorMsg " + this.f23295b;
    }

    public b(long r100, String r101) {
        this.f23294a = r100;
        this.f23295b = r101;
    }
}
