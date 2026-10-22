package ia;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class i1 extends o1 implements t {

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4963h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(g1 g1Var) {
        super(true);
        boolean z4 = true;
        T(g1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o1.f4992g;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        q qVar = pVar instanceof q ? (q) pVar : null;
        if (qVar == null) {
            z4 = false;
            break;
        }
        o1 o1VarJ = qVar.j();
        while (!o1VarJ.N()) {
            p pVar2 = (p) atomicReferenceFieldUpdater.get(o1VarJ);
            q qVar2 = pVar2 instanceof q ? (q) pVar2 : null;
            if (qVar2 == null) {
                z4 = false;
                break;
            }
            o1VarJ = qVar2.j();
        }
        this.f4963h = z4;
    }

    @Override // ia.o1
    public final boolean N() {
        return this.f4963h;
    }

    @Override // ia.o1
    public final boolean O() {
        return true;
    }
}
