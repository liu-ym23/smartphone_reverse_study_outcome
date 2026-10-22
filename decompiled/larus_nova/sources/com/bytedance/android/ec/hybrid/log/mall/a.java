package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47446a;

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.log.mall.a$a, reason: collision with other inner class name */
    public static final class C0830a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0830a f47447b = null;

        static {
            f47447b = new C0830a();
        }

        public C0830a() {
            super("|AutoPlay|");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47448b = null;

        static {
            f47448b = new b();
        }

        public b() {
            super("|FeedBack|");
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47449b = null;

        static {
            f47449b = new c();
        }

        public c() {
            super("|Jump|");
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f47450b = null;

        static {
            f47450b = new d();
        }

        public d() {
            super("|LoadMore|");
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f47451b = null;

        static {
            f47451b = new e();
        }

        public e() {
            super("|Refresh|");
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f47452b = null;

        static {
            f47452b = new f();
        }

        public f() {
            super("Report");
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f47453b = null;

        static {
            f47453b = new g();
        }

        public g() {
            super("|Scroll|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[ACTION]" + this.f47446a;
    }

    public a(String r100) {
        this.f47446a = r100;
    }
}
