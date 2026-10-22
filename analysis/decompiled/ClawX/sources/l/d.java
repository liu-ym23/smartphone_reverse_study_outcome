package l;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends v {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3713a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3714b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3715c;
    public final AtomicReferenceFieldUpdater d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3716e;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f3713a = atomicReferenceFieldUpdater;
        this.f3714b = atomicReferenceFieldUpdater2;
        this.f3715c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.f3716e = atomicReferenceFieldUpdater5;
    }

    @Override // k4.v
    public final void d0(f fVar, f fVar2) {
        this.f3714b.lazySet(fVar, fVar2);
    }

    @Override // k4.v
    public final void e0(f fVar, Thread thread) {
        this.f3713a.lazySet(fVar, thread);
    }

    @Override // k4.v
    public final boolean h(g gVar, c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.d;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, cVar, c.f3711b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == cVar);
        return false;
    }

    @Override // k4.v
    public final boolean i(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3716e;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // k4.v
    public final boolean j(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3715c;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }
}
