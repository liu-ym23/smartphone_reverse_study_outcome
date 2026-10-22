package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47468a;

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47469b = null;

        static {
            f47469b = new a();
        }

        public a() {
            super("|DataParse|");
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47470b = null;

        static {
            f47470b = new b();
        }

        public b() {
            super("|Request|");
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47471b = null;

        static {
            f47471b = new c();
        }

        public c() {
            super("|Reuse|");
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f47472b = null;

        static {
            f47472b = new d();
        }

        public d() {
            super("|Update|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[DATA]" + this.f47468a;
    }

    public e(String r100) {
        this.f47468a = r100;
    }
}
