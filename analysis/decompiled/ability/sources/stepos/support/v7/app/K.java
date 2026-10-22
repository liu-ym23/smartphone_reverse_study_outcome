package stepos.support.v7.app;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import fa.C1449a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.C1980b0;
import stepos.support.v7.widget.C2005u;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;

/* loaded from: classes4.dex */
public final class K extends Ua.c implements Va.l {
    public final /* synthetic */ int d = 0;
    public final Context e;
    public final Va.n f;
    public C1449a g;
    public WeakReference h;
    public final /* synthetic */ AbstractC1955d i;

    public K(L l, Context context, C1449a c1449a) {
        this.i = l;
        C1973w c1973w = new C1973w(3);
        this.e = context;
        this.g = c1449a;
        Va.n nVar = new Va.n(context);
        nVar.k = 1;
        this.f = nVar;
        nVar.d = this;
        this.c = c1973w;
    }

    @Override // Ua.c
    public final void a() {
        switch (this.d) {
            case 0:
                L l = (L) this.i;
                if (l.f6222j == this) {
                    this.g.d((Ua.c) this);
                    this.g = null;
                    l.v(false, null);
                    ActionBarContextView actionBarContextView = l.g;
                    if (actionBarContextView.n == null && !actionBarContextView.f6412x) {
                        actionBarContextView.j();
                    }
                    StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = l.f;
                    stepos.support.v7.widget.A a3 = stepOSCollapsingToolbarLayout.k;
                    a3.n(stepOSCollapsingToolbarLayout.getTitle());
                    a3.f6383D.setAlpha((int) 255.0f);
                    stepos.support.v7.widget.F f = stepOSCollapsingToolbarLayout.f6507C;
                    if (f != null) {
                        C1980b0 c1980b0 = stepOSCollapsingToolbarLayout.E;
                        ArrayList arrayList = f.f6458j;
                        if (arrayList != null) {
                            arrayList.remove(c1980b0);
                        }
                    }
                    stepOSCollapsingToolbarLayout.f6507C = null;
                    stepOSCollapsingToolbarLayout.f6506B = null;
                    l.d.b.getViewGroup().sendAccessibilityEvent(32);
                    l.f6222j = null;
                    break;
                }
                break;
            default:
                e0 e0Var = (e0) this.i;
                if (e0Var.f6303j == this) {
                    if (e0Var.f6305r) {
                        e0Var.k = this;
                        e0Var.l = this.g;
                    } else {
                        this.g.d((Ua.c) this);
                    }
                    this.g = null;
                    e0Var.v(false, null);
                    ActionBarContextView actionBarContextView2 = e0Var.f;
                    if (actionBarContextView2.n == null && !actionBarContextView2.f6412x) {
                        actionBarContextView2.j();
                    }
                    e0Var.e.getViewGroup().sendAccessibilityEvent(32);
                    e0Var.c.setHideOnContentScrollEnabled(e0Var.f6309w);
                    e0Var.f6303j = null;
                    break;
                }
                break;
        }
    }

    @Override // Ua.c
    public final View b() {
        switch (this.d) {
            case 0:
                WeakReference weakReference = this.h;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
                return null;
            default:
                WeakReference weakReference2 = this.h;
                if (weakReference2 != null) {
                    return (View) weakReference2.get();
                }
                return null;
        }
    }

    @Override // Ua.c
    public final Va.n c() {
        switch (this.d) {
        }
        return this.f;
    }

    @Override // Ua.c
    public final Ua.k d() {
        switch (this.d) {
        }
        return new Ua.k(this.e);
    }

    @Override // Va.l
    public final boolean e(Va.n nVar, MenuItem menuItem) {
        switch (this.d) {
            case 0:
                C1449a c1449a = this.g;
                if (c1449a != null) {
                    return ((Ua.b) c1449a.b).f(this, menuItem);
                }
                return false;
            default:
                C1449a c1449a2 = this.g;
                if (c1449a2 != null) {
                    return ((Ua.b) c1449a2.b).f(this, menuItem);
                }
                return false;
        }
    }

    @Override // Ua.c
    public final CharSequence f() {
        switch (this.d) {
            case 0:
                return ((L) this.i).g.getSubtitle();
            default:
                return ((e0) this.i).f.getSubtitle();
        }
    }

    @Override // Ua.c
    public final CharSequence g() {
        switch (this.d) {
            case 0:
                return ((L) this.i).g.getTitle();
            default:
                return ((e0) this.i).f.getTitle();
        }
    }

    @Override // Ua.c
    public final void h() {
        Va.n nVar;
        switch (this.d) {
            case 0:
                if (((L) this.i).f6222j != this) {
                    return;
                }
                nVar = this.f;
                nVar.v();
                try {
                    this.g.b(this, nVar);
                    return;
                } finally {
                }
            default:
                if (((e0) this.i).f6303j != this) {
                    return;
                }
                nVar = this.f;
                nVar.v();
                try {
                    this.g.b(this, nVar);
                    return;
                } finally {
                }
        }
    }

    @Override // Ua.c
    public final boolean i() {
        switch (this.d) {
            case 0:
                return ((L) this.i).g.u;
            default:
                return ((e0) this.i).f.u;
        }
    }

    @Override // Ua.c
    public final void j(View view) {
        switch (this.d) {
            case 0:
                ((L) this.i).g.setCustomView(view);
                this.h = new WeakReference(view);
                break;
            default:
                ((e0) this.i).f.setCustomView(view);
                this.h = new WeakReference(view);
                break;
        }
    }

    @Override // Va.l
    public final void k(Va.n nVar) {
        switch (this.d) {
            case 0:
                if (this.g != null) {
                    h();
                    C2005u c2005u = ((L) this.i).g.d;
                    if (c2005u != null) {
                        c2005u.m();
                        break;
                    }
                }
                break;
            default:
                if (this.g != null) {
                    h();
                    C2005u c2005u2 = ((e0) this.i).f.d;
                    if (c2005u2 != null) {
                        c2005u2.m();
                        break;
                    }
                }
                break;
        }
    }

    @Override // Ua.c
    public final void l(int i) {
        switch (this.d) {
            case 0:
                m(((L) this.i).f6221a.getResources().getString(i));
                break;
            default:
                m(((e0) this.i).f6302a.getResources().getString(i));
                break;
        }
    }

    @Override // Ua.c
    public final void m(CharSequence charSequence) {
        switch (this.d) {
            case 0:
                ((L) this.i).g.setSubtitle(charSequence);
                break;
            default:
                ((e0) this.i).f.setSubtitle(charSequence);
                break;
        }
    }

    @Override // Ua.c
    public final void n(int i) {
        switch (this.d) {
            case 0:
                o(((L) this.i).f6221a.getResources().getString(i));
                break;
            default:
                o(((e0) this.i).f6302a.getResources().getString(i));
                break;
        }
    }

    @Override // Ua.c
    public final void o(CharSequence charSequence) {
        switch (this.d) {
            case 0:
                ((L) this.i).g.setTitle(charSequence);
                break;
            default:
                ((e0) this.i).f.setTitle(charSequence);
                break;
        }
    }

    @Override // Ua.c
    public final void p(boolean z10) {
        switch (this.d) {
            case 0:
                this.b = z10;
                ((L) this.i).g.setTitleOptional(z10);
                break;
            default:
                this.b = z10;
                ((e0) this.i).f.setTitleOptional(z10);
                break;
        }
    }

    public K(e0 e0Var, Context context, C1449a c1449a) {
        this.i = e0Var;
        C1973w c1973w = new C1973w(7);
        this.e = context;
        this.g = c1449a;
        Va.n nVar = new Va.n(context);
        nVar.k = 1;
        this.f = nVar;
        nVar.d = this;
        this.c = c1973w;
    }
}
