package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47512a;

    public static final class a extends q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47513b = null;

        static {
            f47513b = new a();
        }

        public a() {
            super("|Message|");
        }
    }

    public static final class b extends q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f47514b = 0;

        static {
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[PITAYA_PREFETCH]" + this.f47512a;
    }

    public q(String r100) {
        this.f47512a = r100;
    }
}
