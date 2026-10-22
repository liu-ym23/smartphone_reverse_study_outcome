package X8;

/* loaded from: classes4.dex */
public final class C extends AbstractC0283n {
    public final H c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(A a3, H attributes) {
        super(a3);
        kotlin.jvm.internal.k.f(attributes, "attributes");
        this.c = attributes;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        return new C(a3, this.c);
    }

    @Override // X8.AbstractC0282m, X8.w
    public final H M() {
        return this.c;
    }
}
