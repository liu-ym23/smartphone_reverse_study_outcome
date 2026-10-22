package O3;

import java.util.concurrent.ThreadFactory;
import x3.p;

/* loaded from: classes.dex */
public final class g extends x3.p {

    /* renamed from: c, reason: collision with root package name */
    private static final j f4410c = new j("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f4411b;

    public g() {
        this(f4410c);
    }

    @Override // x3.p
    public p.c a() {
        return new h(this.f4411b);
    }

    public g(ThreadFactory threadFactory) {
        this.f4411b = threadFactory;
    }
}
