package l2;

import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class C implements g2.b<B> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f36884a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f36885b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<AbstractC4864d> f36886c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<H> f36887d;

    public C(X8.a<InterfaceC4936a> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<AbstractC4864d> aVar3, X8.a<H> aVar4) {
        this.f36884a = aVar;
        this.f36885b = aVar2;
        this.f36886c = aVar3;
        this.f36887d = aVar4;
    }

    public static C a(X8.a<InterfaceC4936a> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<AbstractC4864d> aVar3, X8.a<H> aVar4) {
        return new C(aVar, aVar2, aVar3, aVar4);
    }

    public static B c(InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, Object obj, Object obj2) {
        return new B(interfaceC4936a, interfaceC4936a2, (AbstractC4864d) obj, (H) obj2);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public B get() {
        return c(this.f36884a.get(), this.f36885b.get(), this.f36886c.get(), this.f36887d.get());
    }
}
