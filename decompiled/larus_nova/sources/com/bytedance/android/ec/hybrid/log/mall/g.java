package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class g implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47479a;

    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47480b = null;

        static {
            f47480b = new a();
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[MALL_DELIVERY]" + this.f47479a;
    }

    public g() {
        this.f47479a = "|Monitor|";
    }
}
