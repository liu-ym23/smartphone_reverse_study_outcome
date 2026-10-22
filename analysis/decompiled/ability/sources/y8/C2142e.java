package y8;

import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0282m;
import X8.AbstractC0285p;
import X8.H;
import X8.InterfaceC0279j;
import X8.S;
import X8.U;
import X8.w;

/* renamed from: y8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2142e extends AbstractC0282m implements InterfaceC0279j {
    public final A b;

    public C2142e(A delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.b = delegate;
    }

    @Override // X8.InterfaceC0279j
    public final boolean C() {
        return true;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        return new C2142e(a3);
    }

    @Override // X8.AbstractC0282m, X8.w
    public final boolean W() {
        return false;
    }

    @Override // X8.InterfaceC0279j
    public final U k(w replacement) {
        kotlin.jvm.internal.k.f(replacement, "replacement");
        U uZ = replacement.Z();
        if (!S.f(uZ) && !S.e(uZ)) {
            return uZ;
        }
        if (uZ instanceof A) {
            A a3 = (A) uZ;
            A aF0 = a3.f0(false);
            return !S.f(a3) ? aF0 : new C2142e(aF0);
        }
        if (!(uZ instanceof AbstractC0285p)) {
            throw new IllegalStateException(("Incorrect type: " + uZ).toString());
        }
        AbstractC0285p abstractC0285p = (AbstractC0285p) uZ;
        A a4 = abstractC0285p.b;
        A aF02 = a4.f0(false);
        if (S.f(a4)) {
            aF02 = new C2142e(aF02);
        }
        A a8 = abstractC0285p.c;
        A aF03 = a8.f0(false);
        if (S.f(a8)) {
            aF03 = new C2142e(aF03);
        }
        return AbstractC0272c.G(AbstractC0272c.f(aF02, aF03), AbstractC0272c.g(uZ));
    }

    @Override // X8.A, X8.U
    public final U m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return new C2142e(this.b.m0(newAttributes));
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        return z10 ? this.b.f0(true) : this;
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return new C2142e(this.b.m0(newAttributes));
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        return this.b;
    }
}
