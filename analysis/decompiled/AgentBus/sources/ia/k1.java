package ia;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class k1 extends na.k implements p0, c1 {

    /* renamed from: i, reason: collision with root package name */
    public o1 f4966i;

    @Override // ia.p0
    public final void a() {
        o1 o1VarJ = j();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o1.f4991f;
            Object obj = atomicReferenceFieldUpdater.get(o1VarJ);
            if (obj instanceof k1) {
                if (obj != this) {
                    return;
                }
                r0 r0Var = d0.f4944j;
                while (!atomicReferenceFieldUpdater.compareAndSet(o1VarJ, obj, r0Var)) {
                    if (atomicReferenceFieldUpdater.get(o1VarJ) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof c1) || ((c1) obj).d() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = na.k.f6911f;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof na.p) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                q7.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                na.k kVar = (na.k) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = na.k.f6913h;
                na.p pVar = (na.p) atomicReferenceFieldUpdater3.get(kVar);
                if (pVar == null) {
                    pVar = new na.p(kVar);
                    atomicReferenceFieldUpdater3.set(kVar, pVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, pVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                kVar.f();
                return;
            }
        }
    }

    @Override // ia.c1
    public final boolean b() {
        return true;
    }

    @Override // ia.c1
    public final q1 d() {
        return null;
    }

    public g1 getParent() {
        return j();
    }

    public final o1 j() {
        o1 o1Var = this.f4966i;
        if (o1Var != null) {
            return o1Var;
        }
        q7.k.j("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    @Override // na.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + d0.k(this) + "[job@" + d0.k(j()) + ']';
    }
}
