package com.bytedance.android.livesdk.arch.task;

/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f103897e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f103898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f103899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f103900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.comp.b f103901d;

    public static final class a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f103902a;

        public static final class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f103903b = null;

            static {
                f103903b = new a();
            }

            public a() {
                super("销毁");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.arch.task.l$b$b, reason: collision with other inner class name */
        public static final class C1573b extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1573b f103904b = null;

            static {
                f103904b = new C1573b();
            }

            public C1573b() {
                super("展示");
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f103905b = null;

            static {
                f103905b = new c();
            }

            public c() {
                super("挂起");
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f103906b = null;

            static {
                f103906b = new d();
            }

            public d() {
                super("更新");
            }
        }

        public b(String r100) {
            this.f103902a = r100;
        }
    }

    static {
    }

    public final b getType() {
        return this.f103900c;
    }

    public l(b r100, com.bytedance.android.livesdk.arch.comp.b r101) {
        this.f103900c = r100;
        this.f103901d = r101;
    }
}
