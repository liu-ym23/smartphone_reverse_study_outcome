package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47462a;

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47463b = null;

        static {
            f47463b = new a();
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[CONFIG]" + this.f47462a;
    }

    public c() {
        this.f47462a = "|Libra|";
    }
}
