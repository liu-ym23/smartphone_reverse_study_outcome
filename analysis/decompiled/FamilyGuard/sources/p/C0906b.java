package p;

import android.content.res.ColorStateList;

/* renamed from: p.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0906b implements InterfaceC0908d {
    C0906b() {
    }

    private C0909e n(InterfaceC0907c interfaceC0907c) {
        return (C0909e) interfaceC0907c.d();
    }

    @Override // p.InterfaceC0908d
    public void a(InterfaceC0907c interfaceC0907c, ColorStateList colorStateList) {
        n(interfaceC0907c).f(colorStateList);
    }

    @Override // p.InterfaceC0908d
    public ColorStateList b(InterfaceC0907c interfaceC0907c) {
        return n(interfaceC0907c).b();
    }

    @Override // p.InterfaceC0908d
    public float c(InterfaceC0907c interfaceC0907c) {
        return h(interfaceC0907c) * 2.0f;
    }

    @Override // p.InterfaceC0908d
    public float d(InterfaceC0907c interfaceC0907c) {
        return interfaceC0907c.e().getElevation();
    }

    @Override // p.InterfaceC0908d
    public float e(InterfaceC0907c interfaceC0907c) {
        return n(interfaceC0907c).c();
    }

    @Override // p.InterfaceC0908d
    public void f(InterfaceC0907c interfaceC0907c, float f5) {
        interfaceC0907c.e().setElevation(f5);
    }

    @Override // p.InterfaceC0908d
    public void g(InterfaceC0907c interfaceC0907c) {
        l(interfaceC0907c, e(interfaceC0907c));
    }

    @Override // p.InterfaceC0908d
    public float h(InterfaceC0907c interfaceC0907c) {
        return n(interfaceC0907c).d();
    }

    @Override // p.InterfaceC0908d
    public void i(InterfaceC0907c interfaceC0907c) {
        l(interfaceC0907c, e(interfaceC0907c));
    }

    @Override // p.InterfaceC0908d
    public void j() {
    }

    @Override // p.InterfaceC0908d
    public float k(InterfaceC0907c interfaceC0907c) {
        return h(interfaceC0907c) * 2.0f;
    }

    @Override // p.InterfaceC0908d
    public void l(InterfaceC0907c interfaceC0907c, float f5) {
        n(interfaceC0907c).g(f5, interfaceC0907c.c(), interfaceC0907c.b());
        o(interfaceC0907c);
    }

    @Override // p.InterfaceC0908d
    public void m(InterfaceC0907c interfaceC0907c, float f5) {
        n(interfaceC0907c).h(f5);
    }

    public void o(InterfaceC0907c interfaceC0907c) {
        if (!interfaceC0907c.c()) {
            interfaceC0907c.a(0, 0, 0, 0);
            return;
        }
        float fE = e(interfaceC0907c);
        float fH = h(interfaceC0907c);
        int iCeil = (int) Math.ceil(C0910f.a(fE, fH, interfaceC0907c.b()));
        int iCeil2 = (int) Math.ceil(C0910f.b(fE, fH, interfaceC0907c.b()));
        interfaceC0907c.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
