package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class r implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47515a;

    public static final class a extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47516b = null;

        static {
            f47516b = new a();
        }

        public a() {
            super("|common_preload|");
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47517b = null;

        static {
            f47517b = new b();
        }

        public b() {
            super("|gul_prefetch|");
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47518b = null;

        static {
            f47518b = new c();
        }

        public c() {
            super("|pre_decode|");
        }
    }

    public static final class d extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f47519b = null;

        static {
            f47519b = new d();
        }

        public d() {
            super("|pre_decode_component|");
        }
    }

    public static final class e extends r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f47520b = 0;

        public e() {
            super("|preload_lynx_view|");
        }

        static {
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[preload]" + this.f47515a;
    }

    public r(String r100) {
        this.f47515a = r100;
    }
}
