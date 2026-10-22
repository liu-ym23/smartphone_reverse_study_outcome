package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.U;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;

/* loaded from: classes5.dex */
public class g implements k {

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f41620a;

    /* renamed from: b, reason: collision with root package name */
    public k f41621b;

    /* renamed from: c, reason: collision with root package name */
    public int f41622c = 0;

    /* renamed from: d, reason: collision with root package name */
    public r f41623d;

    /* renamed from: e, reason: collision with root package name */
    public int f41624e;

    public g(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout, k kVar) {
        this.f41620a = stepOSCollapsingToolbarLayout;
        this.f41621b = kVar;
        this.f41624e = kVar.s();
    }

    @Override // stepos.support.v7.widget.k
    public void A(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.widget.k
    public void B(ViewGroup viewGroup) {
        this.f41621b.B(viewGroup);
    }

    @Override // stepos.support.v7.widget.k
    public void C(Menu menu, g.a aVar) {
        this.f41621b.C(menu, aVar);
    }

    @Override // stepos.support.v7.widget.k
    public boolean D() {
        return this.f41621b.D();
    }

    @Override // stepos.support.v7.widget.k
    public boolean E() {
        return this.f41621b.E();
    }

    @Override // stepos.support.v7.widget.k
    public void F(boolean z10) {
        this.f41621b.F(z10);
    }

    @Override // stepos.support.v7.widget.k
    public s G() {
        return null;
    }

    @Override // stepos.support.v7.widget.k
    public void H(r rVar) {
        r rVar2 = this.f41623d;
        if (rVar2 != null) {
            ViewParent parent = rVar2.getParent();
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f41620a;
            if (parent == stepOSCollapsingToolbarLayout) {
                stepOSCollapsingToolbarLayout.removeView(this.f41623d);
            }
        }
        this.f41623d = rVar;
        if (rVar != null) {
            rVar.i(true);
            if (this.f41622c == 2) {
                this.f41620a.setTabLayout(this.f41623d);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public boolean a() {
        return this.f41621b.a();
    }

    @Override // stepos.support.v7.widget.k
    public boolean b() {
        return this.f41621b.b();
    }

    @Override // stepos.support.v7.widget.k
    public boolean c() {
        return this.f41621b.c();
    }

    @Override // stepos.support.v7.widget.k
    public void collapseActionView() {
        this.f41621b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.k
    public boolean d() {
        return this.f41621b.d();
    }

    @Override // stepos.support.v7.widget.k
    public void e() {
        this.f41621b.e();
    }

    @Override // stepos.support.v7.widget.k
    public boolean f() {
        return this.f41621b.f();
    }

    @Override // stepos.support.v7.widget.k
    public boolean g() {
        return this.f41621b.g();
    }

    @Override // stepos.support.v7.widget.k
    public Context getContext() {
        return this.f41621b.getContext();
    }

    @Override // stepos.support.v7.widget.k
    public CharSequence getTitle() {
        return this.f41621b.getTitle();
    }

    @Override // stepos.support.v7.widget.k
    public void h(int i10) {
        r rVar;
        int i11 = this.f41624e ^ i10;
        this.f41624e = i10;
        if (i11 != 0) {
            if ((i11 & 32) == 0 || (rVar = this.f41623d) == null) {
                this.f41621b.h(i10);
            } else if ((i10 & 32) == 0) {
                this.f41620a.setTabLayout(null);
            } else if (this.f41622c == 2) {
                this.f41620a.setTabLayout(rVar);
            }
            if ((i10 & 8) != 0) {
                this.f41620a.setTitle(this.f41621b.getTitle());
            } else {
                this.f41620a.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public Menu i() {
        return this.f41621b.i();
    }

    @Override // stepos.support.v7.widget.k
    public int j() {
        return this.f41622c;
    }

    @Override // stepos.support.v7.widget.k
    public U k(int i10, long j10) {
        return this.f41621b.k(i10, j10);
    }

    @Override // stepos.support.v7.widget.k
    public ViewGroup l() {
        return this.f41621b.l();
    }

    @Override // stepos.support.v7.widget.k
    public void m(boolean z10) {
        this.f41621b.m(z10);
    }

    @Override // stepos.support.v7.widget.k
    public void n() {
        this.f41621b.n();
    }

    @Override // stepos.support.v7.widget.k
    public void o(boolean z10) {
        this.f41621b.o(z10);
    }

    @Override // stepos.support.v7.widget.k
    public void p() {
        this.f41621b.p();
    }

    @Override // stepos.support.v7.widget.k
    public void q(Menu menu, g.a aVar) {
        this.f41621b.q(menu, aVar);
    }

    @Override // stepos.support.v7.widget.k
    public void r(int i10) {
        this.f41621b.r(i10);
    }

    @Override // stepos.support.v7.widget.k
    public int s() {
        return this.f41624e;
    }

    @Override // stepos.support.v7.widget.k
    public void setIcon(int i10) {
        this.f41621b.setIcon(i10);
    }

    @Override // stepos.support.v7.widget.k
    public void setTitle(CharSequence charSequence) {
        this.f41621b.setTitle(charSequence);
        if ((this.f41624e & 8) != 0) {
            this.f41620a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.k
    public void setWindowCallback(Window.Callback callback) {
        this.f41621b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.k
    public void setWindowTitle(CharSequence charSequence) {
        this.f41621b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.k
    public void t() {
        this.f41621b.t();
    }

    @Override // stepos.support.v7.widget.k
    public void u(g.a aVar, c.a aVar2) {
        this.f41621b.u(aVar, aVar2);
    }

    @Override // stepos.support.v7.widget.k
    public boolean v() {
        return this.f41621b.v();
    }

    @Override // stepos.support.v7.widget.k
    public void w(boolean z10) {
        this.f41621b.w(z10);
    }

    @Override // stepos.support.v7.widget.k
    public void x(a.b bVar) {
        this.f41621b.x(bVar);
    }

    @Override // stepos.support.v7.widget.k
    public void y(boolean z10) {
        this.f41621b.y(z10);
    }

    @Override // stepos.support.v7.widget.k
    public boolean z() {
        return this.f41621b.z();
    }

    @Override // stepos.support.v7.widget.k
    public void setIcon(Drawable drawable) {
        this.f41621b.setIcon(drawable);
    }
}
