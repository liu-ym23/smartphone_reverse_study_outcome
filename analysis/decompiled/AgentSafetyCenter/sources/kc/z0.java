package kc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class z0 extends e1 {

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7504g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(x0 x0Var) {
        super(true);
        boolean z10 = true;
        K(x0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e1.f7432f;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        k kVar = jVar instanceof k ? (k) jVar : null;
        if (kVar == null) {
            z10 = false;
            break;
        }
        e1 e1VarJ = kVar.j();
        while (!e1VarJ.E()) {
            j jVar2 = (j) atomicReferenceFieldUpdater.get(e1VarJ);
            k kVar2 = jVar2 instanceof k ? (k) jVar2 : null;
            if (kVar2 == null) {
                z10 = false;
                break;
            }
            e1VarJ = kVar2.j();
        }
        this.f7504g = z10;
    }

    @Override // kc.e1
    public final boolean E() {
        return this.f7504g;
    }

    @Override // kc.e1
    public final boolean F() {
        return true;
    }
}
