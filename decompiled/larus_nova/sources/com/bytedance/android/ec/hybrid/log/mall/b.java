package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47454a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47455b = null;

        static {
            f47455b = new a();
        }

        public a() {
            super("|cardAnimationX|");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.log.mall.b$b, reason: collision with other inner class name */
    public static final class C0831b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0831b f47456b = null;

        static {
            f47456b = new C0831b();
        }

        public C0831b() {
            super("|Common|");
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47457b = null;

        static {
            f47457b = new c();
        }

        public c() {
            super("|List|");
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f47458b = null;

        static {
            f47458b = new d();
        }

        public d() {
            super("|LynxCard|");
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f47459b = null;

        static {
            f47459b = new e();
        }

        public e() {
            super("|MitaCard|");
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f47460b = null;

        static {
            f47460b = new f();
        }

        public f() {
            super("|NativeCard|");
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f47461b = null;

        static {
            f47461b = new g();
        }

        public g() {
            super("|xElement|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[CARD]" + this.f47454a;
    }

    public b(String r100) {
        this.f47454a = r100;
    }
}
