package X8;

/* renamed from: X8.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0283n extends AbstractC0282m {
    public final A b;

    public AbstractC0283n(A a3) {
        this.b = a3;
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        return z10 == W() ? this : this.b.f0(z10).m0(M());
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return newAttributes != M() ? new C(this, newAttributes) : this;
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        return this.b;
    }
}
