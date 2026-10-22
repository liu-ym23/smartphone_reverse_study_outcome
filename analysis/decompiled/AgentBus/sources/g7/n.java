package g7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n implements d, i7.d {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3867g = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "result");

    /* renamed from: f, reason: collision with root package name */
    public final d f3868f;
    private volatile Object result;

    public n(d dVar) {
        h7.a aVar = h7.a.f4212f;
        this.f3868f = dVar;
        this.result = aVar;
    }

    @Override // i7.d
    public final i7.d getCallerFrame() {
        d dVar = this.f3868f;
        if (dVar instanceof i7.d) {
            return (i7.d) dVar;
        }
        return null;
    }

    @Override // g7.d
    public final l getContext() {
        return this.f3868f.getContext();
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            h7.a aVar = h7.a.f4213g;
            if (obj2 == aVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3867g;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != aVar) {
                        break;
                    }
                }
                return;
            }
            h7.a aVar2 = h7.a.f4212f;
            if (obj2 != aVar2) {
                throw new IllegalStateException("Already resumed");
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3867g;
            h7.a aVar3 = h7.a.f4214h;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, aVar2, aVar3)) {
                if (atomicReferenceFieldUpdater2.get(this) != aVar2) {
                    break;
                }
            }
            this.f3868f.resumeWith(obj);
            return;
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.f3868f;
    }
}
