package ya;

import java.util.List;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public abstract class L0 extends S {
    public L0() {
        super(null);
    }

    @Override // ya.S
    public List<B0> F0() {
        return L0().F0();
    }

    @Override // ya.S
    public s0 G0() {
        return L0().G0();
    }

    @Override // ya.S
    public v0 H0() {
        return L0().H0();
    }

    @Override // ya.S
    public boolean I0() {
        return L0().I0();
    }

    @Override // ya.S
    public final K0 K0() {
        S sL0 = L0();
        while (sL0 instanceof L0) {
            sL0 = ((L0) sL0).L0();
        }
        kotlin.jvm.internal.p.g(sL0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (K0) sL0;
    }

    public abstract S L0();

    public boolean M0() {
        return true;
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return L0().m();
    }

    public String toString() {
        return M0() ? L0().toString() : "<Not computed yet>";
    }
}
