package k2;

import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements InterfaceC4893a.InterfaceC0472a {

    /* renamed from: a, reason: collision with root package name */
    public final i f34607a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f34608b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34609c;

    public h(i iVar, e2.m mVar, int i10) {
        this.f34607a = iVar;
        this.f34608b = mVar;
        this.f34609c = i10;
    }

    public static InterfaceC4893a.InterfaceC0472a a(i iVar, e2.m mVar, int i10) {
        return new h(iVar, mVar, i10);
    }

    @Override // m2.InterfaceC4893a.InterfaceC0472a
    public Object execute() {
        return i.d(this.f34607a, this.f34608b, this.f34609c);
    }
}
