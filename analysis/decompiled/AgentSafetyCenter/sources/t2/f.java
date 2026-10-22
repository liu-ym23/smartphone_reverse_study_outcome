package t2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: a, reason: collision with root package name */
    public AtomicReferenceFieldUpdater f13145a;

    /* renamed from: b, reason: collision with root package name */
    public AtomicReferenceFieldUpdater f13146b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicReferenceFieldUpdater f13147c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicReferenceFieldUpdater f13148d;

    /* renamed from: e, reason: collision with root package name */
    public AtomicReferenceFieldUpdater f13149e;

    @Override // t2.a
    public final boolean e(i iVar, e eVar, e eVar2) {
        return this.f13148d.compareAndSet(iVar, eVar, eVar2);
    }

    @Override // t2.a
    public final boolean f(i iVar, Object obj, Object obj2) {
        return this.f13149e.compareAndSet(iVar, obj, obj2);
    }

    @Override // t2.a
    public final boolean g(i iVar, h hVar, h hVar2) {
        return this.f13147c.compareAndSet(iVar, hVar, hVar2);
    }

    @Override // t2.a
    public final void m(h hVar, h hVar2) {
        this.f13146b.lazySet(hVar, hVar2);
    }

    @Override // t2.a
    public final void n(h hVar, Thread thread) {
        this.f13145a.lazySet(hVar, thread);
    }
}
