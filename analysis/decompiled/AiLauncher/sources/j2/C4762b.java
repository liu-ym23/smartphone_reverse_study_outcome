package j2;

import e2.AbstractC3981h;
import e2.m;
import m2.InterfaceC4893a;

/* renamed from: j2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C4762b implements InterfaceC4893a.InterfaceC0472a {

    /* renamed from: a, reason: collision with root package name */
    public final c f34496a;

    /* renamed from: b, reason: collision with root package name */
    public final m f34497b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC3981h f34498c;

    public C4762b(c cVar, m mVar, AbstractC3981h abstractC3981h) {
        this.f34496a = cVar;
        this.f34497b = mVar;
        this.f34498c = abstractC3981h;
    }

    public static InterfaceC4893a.InterfaceC0472a a(c cVar, m mVar, AbstractC3981h abstractC3981h) {
        return new C4762b(cVar, mVar, abstractC3981h);
    }

    @Override // m2.InterfaceC4893a.InterfaceC0472a
    public Object execute() {
        return c.b(this.f34496a, this.f34497b, this.f34498c);
    }
}
