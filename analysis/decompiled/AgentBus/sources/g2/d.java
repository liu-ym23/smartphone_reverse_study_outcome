package g2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class d extends ib.c {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3781a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3782b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3783c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3784d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3785e;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f3781a = atomicReferenceFieldUpdater;
        this.f3782b = atomicReferenceFieldUpdater2;
        this.f3783c = atomicReferenceFieldUpdater3;
        this.f3784d = atomicReferenceFieldUpdater4;
        this.f3785e = atomicReferenceFieldUpdater5;
    }

    @Override // ib.c
    public final void H(f fVar, f fVar2) {
        this.f3782b.lazySet(fVar, fVar2);
    }

    @Override // ib.c
    public final void I(f fVar, Thread thread) {
        this.f3781a.lazySet(fVar, thread);
    }

    @Override // ib.c
    public final boolean k(g gVar, c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3784d;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, cVar, c.f3779b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == cVar);
        return false;
    }

    @Override // ib.c
    public final boolean l(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3785e;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // ib.c
    public final boolean m(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3783c;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }
}
