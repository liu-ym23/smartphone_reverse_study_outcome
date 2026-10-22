package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor;

/* JADX INFO: loaded from: classes10.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f150933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f150934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f150935c;

    public static final class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f150936d = null;

        static {
            f150936d = new a();
        }

        public a() {
            super("resp_has_no_promotion_not_top", 400);
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f150937d = null;

        static {
            f150937d = new b();
        }

        public b() {
            super("resp_has_no_promotion_with_loading", 400);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.c$c, reason: collision with other inner class name */
    public static final class C2323c extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C2323c f150938d = null;

        static {
            f150938d = new C2323c();
        }

        public C2323c() {
            super("req_first_page_error", 400);
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f150939d = null;

        static {
            f150939d = new d();
        }

        public d() {
            super("req_all_data_but_not_have_all", 300);
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f150940d = null;

        static {
            f150940d = new e();
        }

        public e() {
            super("req_error", 400);
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f150941d = null;

        static {
            f150941d = new f();
        }

        public f() {
            super("resp_code_not_zero", 400);
        }
    }

    public c(String r100, int r101) {
        this.f150933a = "ListRefresh";
        this.f150934b = r100;
        this.f150935c = r101;
    }
}
