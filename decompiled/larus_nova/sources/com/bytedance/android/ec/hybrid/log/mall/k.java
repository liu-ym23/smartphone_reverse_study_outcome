package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class k implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47500a;

    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47501b = null;

        static {
            f47501b = new a();
        }

        public a() {
            super("|Base|");
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47502b = null;

        static {
            f47502b = new b();
        }

        public b() {
            super("|PageCard|");
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47503b = null;

        static {
            f47503b = new c();
        }

        public c() {
            super("|Pendant|");
        }
    }

    public static final class d extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f47504b = null;

        static {
            f47504b = new d();
        }

        public d() {
            super("|Performance|");
        }
    }

    public static final class e extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f47505b = null;

        static {
            f47505b = new e();
        }

        public e() {
            super("|Popup|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[FRAME]" + this.f47500a;
    }

    public k(String r100) {
        this.f47500a = r100;
    }
}
