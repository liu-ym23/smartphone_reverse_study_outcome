package a6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class j1 extends p1 implements t {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f184c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(h1 h1Var) {
        super(true);
        boolean z = true;
        O(h1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p1.f207b;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        q qVar = pVar instanceof q ? (q) pVar : null;
        if (qVar == null) {
            z = false;
            break;
        }
        p1 p1VarJ = qVar.j();
        while (!p1VarJ.J()) {
            p pVar2 = (p) atomicReferenceFieldUpdater.get(p1VarJ);
            q qVar2 = pVar2 instanceof q ? (q) pVar2 : null;
            if (qVar2 == null) {
                z = false;
                break;
            }
            p1VarJ = qVar2.j();
        }
        this.f184c = z;
    }

    @Override // a6.p1
    public final boolean J() {
        return this.f184c;
    }

    @Override // a6.p1
    public final boolean K() {
        return true;
    }

    public final boolean f0() {
        return S(b5.a0.f883a);
    }
}
