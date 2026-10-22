package X8;

/* loaded from: classes4.dex */
public final class D extends AbstractC0282m implements T {
    public final A b;
    public final w c;

    public D(A delegate, w enhancement) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        kotlin.jvm.internal.k.f(enhancement, "enhancement");
        this.b = delegate;
        this.c = enhancement;
    }

    @Override // X8.T
    public final w A() {
        return this.c;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        return new D(a3, this.c);
    }

    @Override // X8.AbstractC0282m, X8.U
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public final D j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        kotlin.jvm.internal.k.f(type, "type");
        w type2 = this.c;
        kotlin.jvm.internal.k.f(type2, "type");
        return new D(type, type2);
    }

    @Override // X8.T
    public final U G() {
        return this.b;
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        U uG = AbstractC0272c.G(this.b.f0(z10), this.c.Z().f0(z10));
        kotlin.jvm.internal.k.d(uG, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (A) uG;
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        U uG = AbstractC0272c.G(this.b.m0(newAttributes), this.c);
        kotlin.jvm.internal.k.d(uG, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (A) uG;
    }

    @Override // X8.A
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.c + ")] " + this.b;
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        return this.b;
    }
}
