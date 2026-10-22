package e2;

import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class t implements g2.b<r> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f32288a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f32289b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<j2.e> f32290c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<k2.i> f32291d;

    /* renamed from: e, reason: collision with root package name */
    public final X8.a<k2.m> f32292e;

    public t(X8.a<InterfaceC4936a> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<j2.e> aVar3, X8.a<k2.i> aVar4, X8.a<k2.m> aVar5) {
        this.f32288a = aVar;
        this.f32289b = aVar2;
        this.f32290c = aVar3;
        this.f32291d = aVar4;
        this.f32292e = aVar5;
    }

    public static t a(X8.a<InterfaceC4936a> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<j2.e> aVar3, X8.a<k2.i> aVar4, X8.a<k2.m> aVar5) {
        return new t(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static r c(InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, j2.e eVar, k2.i iVar, k2.m mVar) {
        return new r(interfaceC4936a, interfaceC4936a2, eVar, iVar, mVar);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c(this.f32288a.get(), this.f32289b.get(), this.f32290c.get(), this.f32291d.get(), this.f32292e.get());
    }
}
