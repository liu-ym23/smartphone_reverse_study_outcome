package s;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: s.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0836f extends B0.f {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14133b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14134c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14135d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14136e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14137f;

    public C0836f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f14133b = atomicReferenceFieldUpdater;
        this.f14134c = atomicReferenceFieldUpdater2;
        this.f14135d = atomicReferenceFieldUpdater3;
        this.f14136e = atomicReferenceFieldUpdater4;
        this.f14137f = atomicReferenceFieldUpdater5;
    }

    @Override // B0.f
    public final boolean f(AbstractC0840j abstractC0840j, C0835e c0835e, C0835e c0835e2) {
        return this.f14136e.compareAndSet(abstractC0840j, c0835e, c0835e2);
    }

    @Override // B0.f
    public final boolean g(AbstractC0840j abstractC0840j, Object obj, Object obj2) {
        return this.f14137f.compareAndSet(abstractC0840j, obj, obj2);
    }

    @Override // B0.f
    public final void g0(C0839i c0839i, C0839i c0839i2) {
        this.f14134c.lazySet(c0839i, c0839i2);
    }

    @Override // B0.f
    public final boolean h(AbstractC0840j abstractC0840j, C0839i c0839i, C0839i c0839i2) {
        return this.f14135d.compareAndSet(abstractC0840j, c0839i, c0839i2);
    }

    @Override // B0.f
    public final void h0(C0839i c0839i, Thread thread) {
        this.f14133b.lazySet(c0839i, thread);
    }
}
