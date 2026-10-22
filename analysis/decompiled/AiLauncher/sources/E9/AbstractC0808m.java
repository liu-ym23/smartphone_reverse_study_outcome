package E9;

/* renamed from: E9.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0808m extends AbstractC0811p {

    /* renamed from: a, reason: collision with root package name */
    public final m0 f2466a;

    public AbstractC0808m(m0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.f2466a = delegate;
    }

    @Override // E9.AbstractC0811p
    public m0 b() {
        return this.f2466a;
    }

    @Override // E9.AbstractC0811p
    public String c() {
        return b().b();
    }

    @Override // E9.AbstractC0811p
    public AbstractC0811p f() {
        AbstractC0811p abstractC0811pJ = C0810o.j(b().d());
        kotlin.jvm.internal.p.h(abstractC0811pJ, "toDescriptorVisibility(...)");
        return abstractC0811pJ;
    }
}
