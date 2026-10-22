package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class z implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f12928a;

    /* renamed from: b, reason: collision with root package name */
    public c0 f12929b;

    /* renamed from: c, reason: collision with root package name */
    public int f12930c;

    @Override // stepos.support.v7.widget.c0
    public final int A() {
        return this.f12930c;
    }

    @Override // stepos.support.v7.widget.c0
    public final void B() {
        this.f12929b.B();
    }

    @Override // stepos.support.v7.widget.c0
    public final void C() {
        this.f12929b.C();
    }

    @Override // stepos.support.v7.widget.c0
    public final void D(boolean z10) {
        this.f12929b.D(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean a() {
        return this.f12929b.a();
    }

    @Override // stepos.support.v7.widget.c0
    public final void b() {
        this.f12929b.b();
    }

    @Override // stepos.support.v7.widget.c0
    public final void c(Menu menu, te.u uVar) {
        this.f12929b.c(menu, uVar);
    }

    @Override // stepos.support.v7.widget.c0
    public final void collapseActionView() {
        this.f12929b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean d() {
        return this.f12929b.d();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean e() {
        return this.f12929b.e();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean f() {
        return this.f12929b.f();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean g() {
        return this.f12929b.g();
    }

    @Override // stepos.support.v7.widget.c0
    public final Context getContext() {
        return this.f12929b.getContext();
    }

    @Override // stepos.support.v7.widget.c0
    public final CharSequence getTitle() {
        return this.f12929b.getTitle();
    }

    @Override // stepos.support.v7.widget.c0
    public final void h(Menu menu, te.u uVar) {
        this.f12929b.h(menu, uVar);
    }

    @Override // stepos.support.v7.widget.c0
    public final void i() {
        this.f12929b.i();
    }

    @Override // stepos.support.v7.widget.c0
    public final void j(boolean z10) {
        this.f12929b.j(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean k() {
        return this.f12929b.k();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean l() {
        return this.f12929b.l();
    }

    @Override // stepos.support.v7.widget.c0
    public final void n(boolean z10) {
        this.f12929b.n(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean o() {
        return this.f12929b.o();
    }

    @Override // stepos.support.v7.widget.c0
    public final void p(ViewGroup viewGroup) {
        this.f12929b.p(viewGroup);
    }

    @Override // stepos.support.v7.widget.c0
    public final void q(int i) {
        c0 c0Var = this.f12929b;
        int i3 = this.f12930c ^ i;
        this.f12930c = i;
        if (i3 != 0) {
            c0Var.q(i);
            int i10 = i & 8;
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12928a;
            if (i10 != 0) {
                stepOSCollapsingToolbarLayout.setTitle(c0Var.getTitle());
            } else {
                stepOSCollapsingToolbarLayout.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final void s(int i) {
        this.f12929b.s(i);
    }

    @Override // stepos.support.v7.widget.c0
    public final void setIcon(int i) {
        this.f12929b.setIcon(i);
    }

    @Override // stepos.support.v7.widget.c0
    public final void setTitle(CharSequence charSequence) {
        this.f12929b.setTitle(charSequence);
        if ((this.f12930c & 8) != 0) {
            this.f12928a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final void setWindowCallback(Window.Callback callback) {
        this.f12929b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.c0
    public final void setWindowTitle(CharSequence charSequence) {
        this.f12929b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean t() {
        return this.f12929b.t();
    }

    @Override // stepos.support.v7.widget.c0
    public final n3.o0 u(int i, long j10) {
        return this.f12929b.u(i, j10);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean v() {
        return this.f12929b.v();
    }

    @Override // stepos.support.v7.widget.c0
    public final ViewGroup w() {
        return this.f12929b.w();
    }

    @Override // stepos.support.v7.widget.c0
    public final void x(boolean z10) {
        this.f12929b.x(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final void y(boolean z10) {
        this.f12929b.y(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final void z(r2.i iVar) {
        this.f12929b.z(iVar);
    }

    @Override // stepos.support.v7.widget.c0
    public final void setIcon(Drawable drawable) {
        this.f12929b.setIcon(drawable);
    }

    @Override // stepos.support.v7.widget.c0
    public final void m(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.widget.c0
    public final void r() {
    }
}
