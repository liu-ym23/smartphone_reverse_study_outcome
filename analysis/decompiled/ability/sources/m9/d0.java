package m9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
public class d0 extends kotlinx.coroutines.c implements InterfaceC1725r {
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(c0 c0Var) {
        super(true);
        boolean z10 = true;
        R(c0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.c.b;
        InterfaceC1721n interfaceC1721n = (InterfaceC1721n) atomicReferenceFieldUpdater.get(this);
        C1722o c1722o = interfaceC1721n instanceof C1722o ? (C1722o) interfaceC1721n : null;
        if (c1722o == null) {
            z10 = false;
            break;
        }
        kotlinx.coroutines.c cVarH = c1722o.h();
        while (!cVarH.L()) {
            InterfaceC1721n interfaceC1721n2 = (InterfaceC1721n) atomicReferenceFieldUpdater.get(cVarH);
            C1722o c1722o2 = interfaceC1721n2 instanceof C1722o ? (C1722o) interfaceC1721n2 : null;
            if (c1722o2 == null) {
                z10 = false;
                break;
            }
            cVarH = c1722o2.h();
        }
        this.c = z10;
    }

    @Override // kotlinx.coroutines.c
    public final boolean L() {
        return this.c;
    }

    @Override // kotlinx.coroutines.c
    public final boolean N() {
        return true;
    }
}
