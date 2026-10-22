package m9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
public abstract class e0 extends kotlinx.coroutines.internal.a implements InterfaceC1693K, InterfaceC1706Y {
    public kotlinx.coroutines.c d;

    @Override // m9.InterfaceC1706Y
    public final l0 b() {
        return null;
    }

    @Override // m9.InterfaceC1693K
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        Object obj2;
        kotlinx.coroutines.internal.a aVar;
        s9.m mVar;
        kotlinx.coroutines.c cVarH = h();
        do {
            atomicReferenceFieldUpdater = kotlinx.coroutines.c.f5183a;
            obj = atomicReferenceFieldUpdater.get(cVarH);
            if (!(obj instanceof e0)) {
                if (!(obj instanceof InterfaceC1706Y) || ((InterfaceC1706Y) obj).b() == null) {
                    return;
                }
                do {
                    atomicReferenceFieldUpdater2 = kotlinx.coroutines.internal.a.f5251a;
                    obj2 = atomicReferenceFieldUpdater2.get(this);
                    if (obj2 instanceof s9.m) {
                        kotlinx.coroutines.internal.a aVar2 = ((s9.m) obj2).f6005a;
                        return;
                    }
                    if (obj2 == this) {
                        return;
                    }
                    kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                    aVar = (kotlinx.coroutines.internal.a) obj2;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = kotlinx.coroutines.internal.a.c;
                    mVar = (s9.m) atomicReferenceFieldUpdater3.get(aVar);
                    if (mVar == null) {
                        mVar = new s9.m(aVar);
                        atomicReferenceFieldUpdater3.set(aVar, mVar);
                    }
                } while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, mVar));
                aVar.d();
                return;
            }
            if (obj != this) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(cVarH, obj, AbstractC1683A.f5312j));
    }

    public c0 getParent() {
        return h();
    }

    public final kotlinx.coroutines.c h() {
        kotlinx.coroutines.c cVar = this.d;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.k.n("job");
        throw null;
    }

    public abstract boolean i();

    @Override // m9.InterfaceC1706Y
    public final boolean isActive() {
        return true;
    }

    public abstract void j(Throwable th);

    @Override // kotlinx.coroutines.internal.a
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC1683A.i(this) + "[job@" + AbstractC1683A.i(h()) + ']';
    }
}
