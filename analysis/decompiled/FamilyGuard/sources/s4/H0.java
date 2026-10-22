package s4;

import x4.C1294F;
import x4.C1299K;

/* loaded from: classes.dex */
public final class H0 {

    /* renamed from: a, reason: collision with root package name */
    public static final H0 f20303a = new H0();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<AbstractC1061a0> f20304b = C1299K.a(new C1294F("ThreadLocalEventLoop"));

    private H0() {
    }

    public final AbstractC1061a0 a() {
        return f20304b.get();
    }

    public final AbstractC1061a0 b() {
        ThreadLocal<AbstractC1061a0> threadLocal = f20304b;
        AbstractC1061a0 abstractC1061a0 = threadLocal.get();
        if (abstractC1061a0 != null) {
            return abstractC1061a0;
        }
        AbstractC1061a0 abstractC1061a0A = C1067d0.a();
        threadLocal.set(abstractC1061a0A);
        return abstractC1061a0A;
    }

    public final void c() {
        f20304b.set(null);
    }

    public final void d(AbstractC1061a0 abstractC1061a0) {
        f20304b.set(abstractC1061a0);
    }
}
