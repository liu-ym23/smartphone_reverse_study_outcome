package kotlin.random;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends kotlin.random.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21204a;

    public static final class a extends ThreadLocal {
        public a() {
        }

        public java.util.Random a() {
            return new java.util.Random();
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ Object initialValue() {
            return a();
        }
    }

    public b() {
        this.f21204a = new a();
    }

    @Override // kotlin.random.a
    public java.util.Random getImpl() {
        Object r10 = this.f21204a.get();
        q.f(r10, "get(...)");
        return (java.util.Random) r10;
    }
}
