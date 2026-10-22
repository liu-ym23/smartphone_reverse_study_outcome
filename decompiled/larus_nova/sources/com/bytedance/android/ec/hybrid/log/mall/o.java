package com.bytedance.android.ec.hybrid.log.mall;

/* JADX INFO: loaded from: classes44.dex */
public abstract class o implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47509a;

    public static final class a extends o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f47510b = null;

        static {
            f47510b = new a();
        }

        public a() {
            super("|App|");
        }
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f47511b = null;

        static {
            f47511b = new b();
        }

        public b() {
            super("|Mall|");
        }
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.p
    public final String scene() {
        return "[LIFECYCLE]" + this.f47509a;
    }

    public o(String r100) {
        this.f47509a = r100;
    }
}
