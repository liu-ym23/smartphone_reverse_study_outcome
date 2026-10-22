package nb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements c, pb.d {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8812f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");

    /* renamed from: c, reason: collision with root package name */
    public final c f8813c;
    private volatile Object result;

    public i(c cVar, ob.a aVar) {
        this.f8813c = cVar;
        this.result = aVar;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        ob.a aVar = ob.a.f9352f;
        if (obj == aVar) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8812f;
            ob.a aVar2 = ob.a.f9351c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, aVar, aVar2)) {
                return aVar2;
            }
            obj = this.result;
        }
        if (obj == ob.a.f9353g) {
            return ob.a.f9351c;
        }
        if (obj instanceof jb.h) {
            throw ((jb.h) obj).f6761c;
        }
        return obj;
    }

    @Override // pb.d
    public final pb.d getCallerFrame() {
        c cVar = this.f8813c;
        if (cVar instanceof pb.d) {
            return (pb.d) cVar;
        }
        return null;
    }

    @Override // nb.c
    public final g getContext() {
        return this.f8813c.getContext();
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            ob.a aVar = ob.a.f9352f;
            if (obj2 != aVar) {
                ob.a aVar2 = ob.a.f9351c;
                if (obj2 != aVar2) {
                    od.f.e("Already resumed");
                    return;
                } else if (f8812f.compareAndSet(this, aVar2, ob.a.f9353g)) {
                    this.f8813c.resumeWith(obj);
                    return;
                }
            } else if (f8812f.compareAndSet(this, aVar, obj)) {
                return;
            }
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.f8813c;
    }
}
