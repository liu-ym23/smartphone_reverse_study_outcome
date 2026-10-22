package Z2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes2.dex */
public class r0 extends x0 implements InterfaceC0142p {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2239c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(o0 o0Var) {
        x0 x0VarI;
        super(true);
        boolean z4 = true;
        J(o0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = x0.f2259b;
        InterfaceC0134k interfaceC0134k = (InterfaceC0134k) atomicReferenceFieldUpdater.get(this);
        C0136l c0136l = interfaceC0134k instanceof C0136l ? (C0136l) interfaceC0134k : null;
        if (c0136l == null || (x0VarI = c0136l.i()) == null) {
            z4 = false;
            break;
        }
        while (!x0VarI.D()) {
            InterfaceC0134k interfaceC0134k2 = (InterfaceC0134k) atomicReferenceFieldUpdater.get(x0VarI);
            C0136l c0136l2 = interfaceC0134k2 instanceof C0136l ? (C0136l) interfaceC0134k2 : null;
            if (c0136l2 == null || (x0VarI = c0136l2.i()) == null) {
                z4 = false;
                break;
            }
        }
        this.f2239c = z4;
    }

    @Override // Z2.x0
    public final boolean D() {
        return this.f2239c;
    }

    @Override // Z2.x0
    public final boolean E() {
        return true;
    }
}
