package A3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class d extends t3.f implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final TimeUnit f82b = TimeUnit.SECONDS;

    /* renamed from: c, reason: collision with root package name */
    public static final c f83c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f84d;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f85a;

    static {
        c cVar = new c(B3.h.f228b);
        f83c = cVar;
        cVar.c();
        a aVar = new a(null, 0L, null);
        f84d = aVar;
        aVar.a();
    }

    public d(ThreadFactory threadFactory) {
        a aVar = f84d;
        AtomicReference atomicReference = new AtomicReference(aVar);
        this.f85a = atomicReference;
        a aVar2 = new a(threadFactory, 60L, f82b);
        if (atomicReference.compareAndSet(aVar, aVar2)) {
            return;
        }
        aVar2.a();
    }

    @Override // A3.q
    public final void a() {
        AtomicReference atomicReference;
        a aVar;
        a aVar2;
        do {
            atomicReference = this.f85a;
            aVar = (a) atomicReference.get();
            aVar2 = f84d;
            if (aVar == aVar2) {
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, aVar2));
        aVar.a();
    }

    @Override // t3.f
    public final t3.e b() {
        return new b((a) this.f85a.get());
    }
}
