package kc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a1 extends pc.j implements g0, t0 {

    /* renamed from: h, reason: collision with root package name */
    public e1 f7415h;

    @Override // kc.t0
    public final boolean d() {
        return true;
    }

    @Override // kc.g0
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        Object obj2;
        pc.j jVar;
        pc.o oVar;
        e1 e1VarJ = j();
        do {
            atomicReferenceFieldUpdater = e1.f7431c;
            obj = atomicReferenceFieldUpdater.get(e1VarJ);
            if (!(obj instanceof a1)) {
                if (!(obj instanceof t0) || ((t0) obj).e() == null) {
                    return;
                }
                do {
                    atomicReferenceFieldUpdater2 = pc.j.f9966c;
                    obj2 = atomicReferenceFieldUpdater2.get(this);
                    if (obj2 instanceof pc.o) {
                        return;
                    }
                    if (obj2 == this) {
                        return;
                    }
                    obj2.getClass();
                    jVar = (pc.j) obj2;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = pc.j.f9968g;
                    oVar = (pc.o) atomicReferenceFieldUpdater3.get(jVar);
                    if (oVar == null) {
                        oVar = new pc.o();
                        oVar.f9979a = jVar;
                        VarHandle.storeStoreFence();
                        atomicReferenceFieldUpdater3.set(jVar, oVar);
                    }
                } while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, oVar));
                jVar.f();
                return;
            }
            if (obj != this) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(e1VarJ, obj, w.f7497j));
    }

    @Override // kc.t0
    public final g1 e() {
        return null;
    }

    public x0 getParent() {
        return j();
    }

    public final e1 j() {
        e1 e1Var = this.f7415h;
        if (e1Var != null) {
            return e1Var;
        }
        yb.k.f("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    @Override // pc.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + w.m(this) + "[job@" + w.m(j()) + ']';
    }
}
