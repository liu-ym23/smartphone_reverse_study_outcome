package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47506a;

    public static final class a extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47507b = null;

        static {
            f47507b = new a();
        }

        public a() {
            super("|InitState|");
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47508b = null;

        static {
            f47508b = new b();
        }

        public b() {
            super("|Resource|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[INIT]" + this.f47506a;
    }

    public m(String r100) {
        this.f47506a = r100;
    }
}
