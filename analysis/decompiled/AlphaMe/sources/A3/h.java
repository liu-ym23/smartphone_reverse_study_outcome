package A3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class h extends t3.f implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final int f92b;

    /* renamed from: c, reason: collision with root package name */
    public static final g f93c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f94d;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f95a;

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        f92b = iIntValue;
        g gVar = new g(B3.h.f228b);
        f93c = gVar;
        gVar.c();
        f94d = new f(null, 0);
    }

    public h(B3.h hVar) {
        f fVar = f94d;
        AtomicReference atomicReference = new AtomicReference(fVar);
        this.f95a = atomicReference;
        f fVar2 = new f(hVar, f92b);
        if (atomicReference.compareAndSet(fVar, fVar2)) {
            return;
        }
        for (g gVar : fVar2.f90b) {
            gVar.c();
        }
    }

    @Override // A3.q
    public final void a() {
        AtomicReference atomicReference;
        f fVar;
        f fVar2;
        do {
            atomicReference = this.f95a;
            fVar = (f) atomicReference.get();
            fVar2 = f94d;
            if (fVar == fVar2) {
                return;
            }
        } while (!atomicReference.compareAndSet(fVar, fVar2));
        g[] gVarArr = fVar.f90b;
        for (g gVar : gVarArr) {
            gVar.c();
        }
    }

    @Override // t3.f
    public final t3.e b() {
        g gVar;
        f fVar = (f) this.f95a.get();
        int i4 = fVar.f89a;
        if (i4 == 0) {
            gVar = f93c;
        } else {
            long j4 = fVar.f91c;
            fVar.f91c = 1 + j4;
            gVar = fVar.f90b[(int) (j4 % i4)];
        }
        return new b(gVar);
    }
}
