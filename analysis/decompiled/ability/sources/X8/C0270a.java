package X8;

/* renamed from: X8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0270a extends AbstractC0282m {
    public final A b;
    public final A c;

    public C0270a(A delegate, A abbreviation) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        kotlin.jvm.internal.k.f(abbreviation, "abbreviation");
        this.b = delegate;
        this.c = abbreviation;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        return new C0270a(a3, this.c);
    }

    @Override // X8.A
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public final C0270a f0(boolean z10) {
        return new C0270a(this.b.f0(z10), this.c.f0(z10));
    }

    @Override // X8.AbstractC0282m, X8.U
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public final C0270a j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        kotlin.jvm.internal.k.f(type, "type");
        A type2 = this.c;
        kotlin.jvm.internal.k.f(type2, "type");
        return new C0270a(type, type2);
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return new C0270a(this.b.m0(newAttributes), this.c);
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        return this.b;
    }
}
