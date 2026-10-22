package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.S;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public class h implements m {

    /* renamed from: a, reason: collision with root package name */
    private StepOSCollapsingToolbarLayout f22051a;

    /* renamed from: b, reason: collision with root package name */
    private m f22052b;

    /* renamed from: c, reason: collision with root package name */
    private int f22053c = 0;

    /* renamed from: d, reason: collision with root package name */
    private v f22054d;

    /* renamed from: e, reason: collision with root package name */
    private int f22055e;

    public h(StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout, m mVar) {
        this.f22051a = stepOSCollapsingToolbarLayout;
        this.f22052b = mVar;
        this.f22055e = mVar.p();
    }

    @Override // stepos.support.v7.widget.m
    public int A() {
        return this.f22052b.A();
    }

    @Override // stepos.support.v7.widget.m
    public void B(boolean z5) {
        this.f22052b.B(z5);
    }

    @Override // stepos.support.v7.widget.m
    public void C(ViewGroup viewGroup) {
        this.f22052b.C(viewGroup);
    }

    @Override // stepos.support.v7.widget.m
    public void D(a.c cVar) {
        this.f22052b.D(cVar);
    }

    @Override // stepos.support.v7.widget.m
    public void E(Menu menu, h.a aVar) {
        this.f22052b.E(menu, aVar);
    }

    @Override // stepos.support.v7.widget.m
    public void F(int i5) {
        this.f22052b.F(i5);
    }

    @Override // stepos.support.v7.widget.m
    public Menu G() {
        return this.f22052b.G();
    }

    @Override // stepos.support.v7.widget.m
    public boolean H() {
        return this.f22052b.H();
    }

    @Override // stepos.support.v7.widget.m
    public boolean I() {
        return this.f22052b.I();
    }

    @Override // stepos.support.v7.widget.m
    public void J(int i5) {
        v vVar;
        int i6 = this.f22053c;
        if (i5 != i6) {
            if (i6 == 1) {
                this.f22052b.J(i5);
            } else if (i6 == 2 && (vVar = this.f22054d) != null) {
                ViewParent parent = vVar.getParent();
                StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f22051a;
                if (parent == stepOSCollapsingToolbarLayout) {
                    stepOSCollapsingToolbarLayout.removeView(this.f22054d);
                }
            }
            this.f22053c = i5;
            if (i5 != 0) {
                if (i5 == 1) {
                    this.f22052b.J(i5);
                    return;
                }
                if (i5 != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i5);
                }
                v vVar2 = this.f22054d;
                if (vVar2 != null) {
                    this.f22051a.setTabLayout(vVar2);
                }
            }
        }
    }

    @Override // stepos.support.v7.widget.m
    public ViewGroup K() {
        return this.f22052b.K();
    }

    @Override // stepos.support.v7.widget.m
    public void L(boolean z5) {
        this.f22052b.L(z5);
    }

    @Override // stepos.support.v7.widget.m
    public w M() {
        return null;
    }

    @Override // stepos.support.v7.widget.m
    public int N() {
        return this.f22052b.N();
    }

    @Override // stepos.support.v7.widget.m
    public void O(View view) {
        this.f22052b.O(view);
    }

    @Override // stepos.support.v7.widget.m
    public void P(v vVar) {
        v vVar2 = this.f22054d;
        if (vVar2 != null) {
            ViewParent parent = vVar2.getParent();
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f22051a;
            if (parent == stepOSCollapsingToolbarLayout) {
                stepOSCollapsingToolbarLayout.removeView(this.f22054d);
            }
        }
        this.f22054d = vVar;
        if (vVar != null) {
            vVar.L(true);
            if (this.f22053c == 2) {
                this.f22051a.setTabLayout(this.f22054d);
            }
        }
    }

    @Override // stepos.support.v7.widget.m
    public boolean a() {
        return this.f22052b.a();
    }

    @Override // stepos.support.v7.widget.m
    public void b() {
        this.f22052b.b();
    }

    @Override // stepos.support.v7.widget.m
    public boolean c() {
        return this.f22052b.c();
    }

    @Override // stepos.support.v7.widget.m
    public void collapseActionView() {
        this.f22052b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.m
    public boolean d() {
        return this.f22052b.d();
    }

    @Override // stepos.support.v7.widget.m
    public boolean e() {
        return this.f22052b.e();
    }

    @Override // stepos.support.v7.widget.m
    public boolean f() {
        return this.f22052b.f();
    }

    @Override // stepos.support.v7.widget.m
    public void g(Drawable drawable) {
        this.f22052b.g(drawable);
    }

    @Override // stepos.support.v7.widget.m
    public Context getContext() {
        return this.f22052b.getContext();
    }

    @Override // stepos.support.v7.widget.m
    public CharSequence getTitle() {
        return this.f22052b.getTitle();
    }

    @Override // stepos.support.v7.widget.m
    public void h() {
        this.f22052b.h();
    }

    @Override // stepos.support.v7.widget.m
    public boolean i() {
        return this.f22052b.i();
    }

    @Override // stepos.support.v7.widget.m
    public void j(int i5) {
        v vVar;
        int i6 = this.f22055e ^ i5;
        this.f22055e = i5;
        if (i6 != 0) {
            if ((i6 & 32) == 0 || (vVar = this.f22054d) == null) {
                this.f22052b.j(i5);
            } else if ((i5 & 32) == 0) {
                this.f22051a.setTabLayout(null);
            } else if (this.f22053c == 2) {
                this.f22051a.setTabLayout(vVar);
            }
            if ((i5 & 8) != 0) {
                this.f22051a.setTitle(this.f22052b.getTitle());
            } else {
                this.f22051a.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.m
    public void k(int i5) {
        this.f22052b.k(i5);
    }

    @Override // stepos.support.v7.widget.m
    public int l() {
        return this.f22053c;
    }

    @Override // stepos.support.v7.widget.m
    public S m(int i5, long j5) {
        return this.f22052b.m(i5, j5);
    }

    @Override // stepos.support.v7.widget.m
    public void n(int i5) {
        this.f22052b.n(i5);
    }

    @Override // stepos.support.v7.widget.m
    public void o(boolean z5) {
        this.f22052b.o(z5);
    }

    @Override // stepos.support.v7.widget.m
    public int p() {
        return this.f22055e;
    }

    @Override // stepos.support.v7.widget.m
    public void q() {
        this.f22052b.q();
    }

    @Override // stepos.support.v7.widget.m
    public void r(Menu menu, h.a aVar) {
        this.f22052b.r(menu, aVar);
    }

    @Override // stepos.support.v7.widget.m
    public void s() {
        this.f22052b.s();
    }

    @Override // stepos.support.v7.widget.m
    public void setIcon(int i5) {
        this.f22052b.setIcon(i5);
    }

    @Override // stepos.support.v7.widget.m
    public void setTitle(CharSequence charSequence) {
        this.f22052b.setTitle(charSequence);
        if ((this.f22055e & 8) != 0) {
            this.f22051a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.m
    public void setWindowCallback(Window.Callback callback) {
        this.f22052b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.m
    public void setWindowTitle(CharSequence charSequence) {
        this.f22052b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.m
    public void t(boolean z5) {
        this.f22052b.t(z5);
    }

    @Override // stepos.support.v7.widget.m
    public void u(boolean z5) {
        this.f22052b.u(z5);
    }

    @Override // stepos.support.v7.widget.m
    public boolean v() {
        return this.f22052b.v();
    }

    @Override // stepos.support.v7.widget.m
    public View w() {
        return this.f22052b.w();
    }

    @Override // stepos.support.v7.widget.m
    public void x(h.a aVar, d.a aVar2) {
        this.f22052b.x(aVar, aVar2);
    }

    @Override // stepos.support.v7.widget.m
    public boolean y() {
        return this.f22052b.y();
    }

    @Override // stepos.support.v7.widget.m
    public void z(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.widget.m
    public void setIcon(Drawable drawable) {
        this.f22052b.setIcon(drawable);
    }
}
