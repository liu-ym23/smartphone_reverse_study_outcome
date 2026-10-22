package ya;

import java.util.List;
import ra.InterfaceC5238k;

/* renamed from: ya.z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6019z extends AbstractC5990d0 {
    @Override // ya.S
    public List<B0> F0() {
        return Q0().F0();
    }

    @Override // ya.S
    public s0 G0() {
        return Q0().G0();
    }

    @Override // ya.S
    public v0 H0() {
        return Q0().H0();
    }

    @Override // ya.S
    public boolean I0() {
        return Q0().I0();
    }

    public abstract AbstractC5990d0 Q0();

    @Override // ya.K0
    public AbstractC5990d0 R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(Q0());
        kotlin.jvm.internal.p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return S0((AbstractC5990d0) sA);
    }

    public abstract AbstractC6019z S0(AbstractC5990d0 abstractC5990d0);

    @Override // ya.S
    public InterfaceC5238k m() {
        return Q0().m();
    }
}
