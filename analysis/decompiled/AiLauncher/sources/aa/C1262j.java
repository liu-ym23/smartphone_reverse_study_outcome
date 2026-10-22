package aa;

import kotlin.NoWhenBranchMatchedException;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.AbstractC6019z;
import ya.H0;
import ya.InterfaceC5984a0;
import ya.J0;
import ya.K0;
import ya.s0;

/* renamed from: aa.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1262j extends AbstractC6019z implements InterfaceC5984a0 {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f8149b;

    public C1262j(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.f8149b = delegate;
    }

    @Override // ya.AbstractC6019z, ya.S
    public boolean I0() {
        return false;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        return z10 ? Q0().L0(true) : this;
    }

    @Override // ya.AbstractC6019z
    public AbstractC5990d0 Q0() {
        return this.f8149b;
    }

    @Override // ya.InterfaceC6015v
    public ya.S T(ya.S replacement) {
        kotlin.jvm.internal.p.i(replacement, "replacement");
        K0 K02 = replacement.K0();
        if (!Da.d.y(K02) && !H0.l(K02)) {
            return K02;
        }
        if (K02 instanceof AbstractC5990d0) {
            return T0((AbstractC5990d0) K02);
        }
        if (!(K02 instanceof AbstractC5974I)) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC5974I abstractC5974I = (AbstractC5974I) K02;
        return J0.d(ya.V.e(T0(abstractC5974I.P0()), T0(abstractC5974I.Q0())), J0.a(K02));
    }

    public final AbstractC5990d0 T0(AbstractC5990d0 abstractC5990d0) {
        AbstractC5990d0 abstractC5990d0L0 = abstractC5990d0.L0(false);
        return !Da.d.y(abstractC5990d0) ? abstractC5990d0L0 : new C1262j(abstractC5990d0L0);
    }

    @Override // ya.AbstractC5990d0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C1262j N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return new C1262j(Q0().N0(newAttributes));
    }

    @Override // ya.AbstractC6019z
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public C1262j S0(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        return new C1262j(delegate);
    }

    @Override // ya.InterfaceC6015v
    public boolean y0() {
        return true;
    }
}
