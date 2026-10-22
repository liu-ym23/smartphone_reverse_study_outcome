package a6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l1 extends f6.i implements s0, e1 {
    public p1 d;

    @Override // a6.e1
    public final boolean a() {
        return true;
    }

    @Override // a6.s0
    public final void b() {
        p1 p1VarJ = j();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p1.f206a;
            Object obj = atomicReferenceFieldUpdater.get(p1VarJ);
            if (obj instanceof l1) {
                if (obj != this) {
                    return;
                }
                u0 u0Var = i0.f180j;
                while (!atomicReferenceFieldUpdater.compareAndSet(p1VarJ, obj, u0Var)) {
                    if (atomicReferenceFieldUpdater.get(p1VarJ) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof e1) || ((e1) obj).d() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6.i.f2646a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof f6.n) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                kotlin.jvm.internal.p.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                f6.i iVar = (f6.i) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f6.i.f2648c;
                f6.n nVar = (f6.n) atomicReferenceFieldUpdater3.get(iVar);
                if (nVar == null) {
                    nVar = new f6.n(iVar);
                    atomicReferenceFieldUpdater3.set(iVar, nVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, nVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                iVar.f();
                return;
            }
        }
    }

    @Override // a6.e1
    public final q1 d() {
        return null;
    }

    public h1 getParent() {
        return j();
    }

    public final p1 j() {
        p1 p1Var = this.d;
        if (p1Var != null) {
            return p1Var;
        }
        kotlin.jvm.internal.p.l("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    @Override // f6.i
    public final String toString() {
        return getClass().getSimpleName() + '@' + i0.k(this) + "[job@" + i0.k(j()) + AbstractJsonLexerKt.END_LIST;
    }
}
