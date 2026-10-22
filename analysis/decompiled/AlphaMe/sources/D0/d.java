package D0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t0.J;

/* loaded from: classes.dex */
public final class d extends J {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f376b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f377c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f378d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f379e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f380f;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f376b = atomicReferenceFieldUpdater;
        this.f377c = atomicReferenceFieldUpdater2;
        this.f378d = atomicReferenceFieldUpdater3;
        this.f379e = atomicReferenceFieldUpdater4;
        this.f380f = atomicReferenceFieldUpdater5;
    }

    @Override // t0.J
    public final void F(g gVar, g gVar2) {
        this.f377c.lazySet(gVar, gVar2);
    }

    @Override // t0.J
    public final void G(g gVar, Thread thread) {
        this.f376b.lazySet(gVar, thread);
    }

    @Override // t0.J
    public final boolean g(h hVar, c cVar, c cVar2) {
        return this.f379e.compareAndSet(hVar, cVar, cVar2);
    }

    @Override // t0.J
    public final boolean h(h hVar, Object obj, Object obj2) {
        return this.f380f.compareAndSet(hVar, obj, obj2);
    }

    @Override // t0.J
    public final boolean i(h hVar, g gVar, g gVar2) {
        return this.f378d.compareAndSet(hVar, gVar, gVar2);
    }
}
