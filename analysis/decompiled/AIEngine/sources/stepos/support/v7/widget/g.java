package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.g;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f12793a;

    /* renamed from: b, reason: collision with root package name */
    public k f12794b;

    /* renamed from: c, reason: collision with root package name */
    public int f12795c;

    @Override // stepos.support.v7.widget.k
    public final void A(Menu menu, g.a aVar) {
        this.f12794b.A(menu, aVar);
    }

    @Override // stepos.support.v7.widget.k
    public final boolean B() {
        return this.f12794b.B();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean C() {
        return this.f12794b.C();
    }

    @Override // stepos.support.v7.widget.k
    public final void D(boolean z) {
        this.f12794b.D(z);
    }

    @Override // stepos.support.v7.widget.k
    public final t E() {
        return null;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean a() {
        return this.f12794b.a();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean b() {
        return this.f12794b.b();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean c() {
        return this.f12794b.c();
    }

    @Override // stepos.support.v7.widget.k
    public final void collapseActionView() {
        this.f12794b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean d() {
        return this.f12794b.d();
    }

    @Override // stepos.support.v7.widget.k
    public final void e() {
        this.f12794b.e();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean f() {
        return this.f12794b.f();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean g() {
        return this.f12794b.g();
    }

    @Override // stepos.support.v7.widget.k
    public final Context getContext() {
        return this.f12794b.getContext();
    }

    @Override // stepos.support.v7.widget.k
    public final CharSequence getTitle() {
        return this.f12794b.getTitle();
    }

    @Override // stepos.support.v7.widget.k
    public final void h(int i10) {
        k kVar = this.f12794b;
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12793a;
        int i11 = this.f12795c ^ i10;
        this.f12795c = i10;
        if (i11 != 0) {
            kVar.h(i10);
            if ((i10 & 8) != 0) {
                stepOSCollapsingToolbarLayout.setTitle(kVar.getTitle());
            } else {
                stepOSCollapsingToolbarLayout.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public final h0 i(int i10, long j10) {
        return this.f12794b.i(i10, j10);
    }

    @Override // stepos.support.v7.widget.k
    public final void j() {
        this.f12794b.j();
    }

    @Override // stepos.support.v7.widget.k
    public final void k(boolean z) {
        this.f12794b.k(z);
    }

    @Override // stepos.support.v7.widget.k
    public final void l() {
        this.f12794b.l();
    }

    @Override // stepos.support.v7.widget.k
    public final void m(Menu menu, g.a aVar) {
        this.f12794b.m(menu, aVar);
    }

    @Override // stepos.support.v7.widget.k
    public final void o(int i10) {
        this.f12794b.o(i10);
    }

    @Override // stepos.support.v7.widget.k
    public final int p() {
        return this.f12795c;
    }

    @Override // stepos.support.v7.widget.k
    public final void q() {
        this.f12794b.q();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean r() {
        return this.f12794b.r();
    }

    @Override // stepos.support.v7.widget.k
    public final void s(boolean z) {
        this.f12794b.s(z);
    }

    @Override // stepos.support.v7.widget.k
    public final void setIcon(int i10) {
        this.f12794b.setIcon(i10);
    }

    @Override // stepos.support.v7.widget.k
    public final void setTitle(CharSequence charSequence) {
        this.f12794b.setTitle(charSequence);
        if ((this.f12795c & 8) != 0) {
            this.f12793a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void setWindowCallback(Window.Callback callback) {
        this.f12794b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.k
    public final void setWindowTitle(CharSequence charSequence) {
        this.f12794b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.k
    public final void t(a.InterfaceC0141a interfaceC0141a) {
        this.f12794b.t(interfaceC0141a);
    }

    @Override // stepos.support.v7.widget.k
    public final ViewGroup u() {
        return this.f12794b.u();
    }

    @Override // stepos.support.v7.widget.k
    public final void v(boolean z) {
        this.f12794b.v(z);
    }

    @Override // stepos.support.v7.widget.k
    public final void w(boolean z) {
        this.f12794b.w(z);
    }

    @Override // stepos.support.v7.widget.k
    public final boolean x() {
        return this.f12794b.x();
    }

    @Override // stepos.support.v7.widget.k
    public final void z(ViewGroup viewGroup) {
        this.f12794b.z(viewGroup);
    }

    @Override // stepos.support.v7.widget.k
    public final void setIcon(Drawable drawable) {
        this.f12794b.setIcon(drawable);
    }

    @Override // stepos.support.v7.widget.k
    public final void n() {
    }

    @Override // stepos.support.v7.widget.k
    public final void y(ViewGroup viewGroup) {
    }
}
