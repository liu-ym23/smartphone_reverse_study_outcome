package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.Window;
import stepos.support.v7.app.C0877w;
import stepos.support.v7.app.InterfaceC0856a;

/* renamed from: stepos.support.v7.widget.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0905z implements D {

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f15254a;

    /* renamed from: b, reason: collision with root package name */
    public D f15255b;

    /* renamed from: c, reason: collision with root package name */
    public int f15256c;

    @Override // stepos.support.v7.widget.D
    public final void A(ActionBarContainer actionBarContainer) {
        this.f15255b.A(actionBarContainer);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean B() {
        return this.f15255b.B();
    }

    @Override // stepos.support.v7.widget.D
    public final void C() {
        this.f15255b.C();
    }

    @Override // stepos.support.v7.widget.D
    public final void D(ActionBarContainer actionBarContainer) {
    }

    @Override // stepos.support.v7.widget.D
    public final void E() {
        this.f15255b.E();
    }

    @Override // stepos.support.v7.widget.D
    public final void F(boolean z4) {
        this.f15255b.F(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final void a(L3.k kVar, C0877w c0877w) {
        this.f15255b.a(kVar, c0877w);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean b() {
        return this.f15255b.b();
    }

    @Override // stepos.support.v7.widget.D
    public final void c() {
        this.f15255b.c();
    }

    @Override // stepos.support.v7.widget.D
    public final void collapseActionView() {
        this.f15255b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.D
    public final void d(Drawable drawable) {
        this.f15255b.d(drawable);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean e() {
        return this.f15255b.e();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean f() {
        return this.f15255b.f();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean g() {
        return this.f15255b.g();
    }

    @Override // stepos.support.v7.widget.D
    public final Context getContext() {
        return this.f15255b.getContext();
    }

    @Override // stepos.support.v7.widget.D
    public final CharSequence getTitle() {
        return this.f15255b.getTitle();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean h() {
        return this.f15255b.h();
    }

    @Override // stepos.support.v7.widget.D
    public final void i() {
        this.f15255b.i();
    }

    @Override // stepos.support.v7.widget.D
    public final void j(boolean z4) {
        this.f15255b.j(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean k() {
        return this.f15255b.k();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean l() {
        return this.f15255b.l();
    }

    @Override // stepos.support.v7.widget.D
    public final void m() {
        this.f15255b.m();
    }

    @Override // stepos.support.v7.widget.D
    public final ViewGroup n() {
        return this.f15255b.n();
    }

    @Override // stepos.support.v7.widget.D
    public final void o(boolean z4) {
        this.f15255b.o(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final void p(boolean z4) {
        this.f15255b.p(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final void q(boolean z4) {
        this.f15255b.q(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean r() {
        return this.f15255b.r();
    }

    @Override // stepos.support.v7.widget.D
    public final void s(InterfaceC0856a interfaceC0856a) {
        this.f15255b.s(interfaceC0856a);
    }

    @Override // stepos.support.v7.widget.D
    public final void setIcon(int i4) {
        this.f15255b.setIcon(i4);
    }

    @Override // stepos.support.v7.widget.D
    public final void setTitle(CharSequence charSequence) {
        this.f15255b.setTitle(charSequence);
        if ((this.f15256c & 8) != 0) {
            this.f15254a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void setWindowCallback(Window.Callback callback) {
        this.f15255b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.D
    public final void setWindowTitle(CharSequence charSequence) {
        this.f15255b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.D
    public final void t(int i4) {
        int i5 = this.f15256c ^ i4;
        this.f15256c = i4;
        if (i5 != 0) {
            D d4 = this.f15255b;
            d4.t(i4);
            int i6 = i4 & 8;
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f15254a;
            if (i6 != 0) {
                stepOSCollapsingToolbarLayout.setTitle(d4.getTitle());
            } else {
                stepOSCollapsingToolbarLayout.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void u(L3.k kVar, C0877w c0877w) {
        this.f15255b.u(kVar, c0877w);
    }

    @Override // stepos.support.v7.widget.D
    public final void v() {
    }

    @Override // stepos.support.v7.widget.D
    public final int w() {
        return this.f15256c;
    }

    @Override // stepos.support.v7.widget.D
    public final void x(int i4) {
        this.f15255b.x(i4);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean y() {
        return this.f15255b.y();
    }

    @Override // stepos.support.v7.widget.D
    public final K.e0 z(int i4, long j4) {
        return this.f15255b.z(i4, j4);
    }

    @Override // stepos.support.v7.widget.D
    public final void setIcon(Drawable drawable) {
        this.f15255b.setIcon(drawable);
    }
}
