package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47464a;

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47465b = null;

        static {
            f47465b = new a();
        }

        public a() {
            super("|Event|");
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47466b = null;

        static {
            f47466b = new b();
        }

        public b() {
            super("|JSB|");
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f47467b = null;

        static {
            f47467b = new c();
        }

        public c() {
            super("|WhiteBoard|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[CROSS]" + this.f47464a;
    }

    public d(String r100) {
        this.f47464a = r100;
    }
}
