package b0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1437a implements InterfaceC1439c {
    @Override // b0.InterfaceC1439c
    public void a(InterfaceC1438b interfaceC1438b, ColorStateList colorStateList) {
        o(interfaceC1438b).f(colorStateList);
    }

    @Override // b0.InterfaceC1439c
    public void b(InterfaceC1438b interfaceC1438b, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        interfaceC1438b.b(new C1440d(colorStateList, f10));
        View viewF = interfaceC1438b.f();
        viewF.setClipToOutline(true);
        viewF.setElevation(f11);
        n(interfaceC1438b, f12);
    }

    @Override // b0.InterfaceC1439c
    public void c(InterfaceC1438b interfaceC1438b) {
        n(interfaceC1438b, g(interfaceC1438b));
    }

    @Override // b0.InterfaceC1439c
    public void d(InterfaceC1438b interfaceC1438b, float f10) {
        o(interfaceC1438b).h(f10);
    }

    @Override // b0.InterfaceC1439c
    public float e(InterfaceC1438b interfaceC1438b) {
        return i(interfaceC1438b) * 2.0f;
    }

    @Override // b0.InterfaceC1439c
    public void f(InterfaceC1438b interfaceC1438b, float f10) {
        interfaceC1438b.f().setElevation(f10);
    }

    @Override // b0.InterfaceC1439c
    public float g(InterfaceC1438b interfaceC1438b) {
        return o(interfaceC1438b).c();
    }

    @Override // b0.InterfaceC1439c
    public ColorStateList h(InterfaceC1438b interfaceC1438b) {
        return o(interfaceC1438b).b();
    }

    @Override // b0.InterfaceC1439c
    public float i(InterfaceC1438b interfaceC1438b) {
        return o(interfaceC1438b).d();
    }

    @Override // b0.InterfaceC1439c
    public float j(InterfaceC1438b interfaceC1438b) {
        return interfaceC1438b.f().getElevation();
    }

    @Override // b0.InterfaceC1439c
    public void k(InterfaceC1438b interfaceC1438b) {
        n(interfaceC1438b, g(interfaceC1438b));
    }

    @Override // b0.InterfaceC1439c
    public void l() {
    }

    @Override // b0.InterfaceC1439c
    public float m(InterfaceC1438b interfaceC1438b) {
        return i(interfaceC1438b) * 2.0f;
    }

    @Override // b0.InterfaceC1439c
    public void n(InterfaceC1438b interfaceC1438b, float f10) {
        o(interfaceC1438b).g(f10, interfaceC1438b.c(), interfaceC1438b.e());
        p(interfaceC1438b);
    }

    public final C1440d o(InterfaceC1438b interfaceC1438b) {
        return (C1440d) interfaceC1438b.d();
    }

    public void p(InterfaceC1438b interfaceC1438b) {
        if (!interfaceC1438b.c()) {
            interfaceC1438b.a(0, 0, 0, 0);
            return;
        }
        float fG = g(interfaceC1438b);
        float fI = i(interfaceC1438b);
        int iCeil = (int) Math.ceil(C1441e.a(fG, fI, interfaceC1438b.e()));
        int iCeil2 = (int) Math.ceil(C1441e.b(fG, fI, interfaceC1438b.e()));
        interfaceC1438b.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
