package stepos.support.v7.app;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a0 extends c {

    /* renamed from: a, reason: collision with root package name */
    public Context f12266a;

    /* renamed from: b, reason: collision with root package name */
    public Context f12267b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarCoordinatorLayout f12268c;

    /* renamed from: d, reason: collision with root package name */
    public stepos.support.v7.widget.z f12269d;

    /* renamed from: e, reason: collision with root package name */
    public StepOSAppBarLayout f12270e;

    /* renamed from: f, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f12271f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContextView f12272g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContainer f12273h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public z f12274j;

    /* renamed from: k, reason: collision with root package name */
    public z f12275k;

    /* renamed from: l, reason: collision with root package name */
    public p5.c f12276l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12277m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12278n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12279o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12280p;

    /* renamed from: q, reason: collision with root package name */
    public k.k f12281q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12282r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12283s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12284t;

    /* renamed from: u, reason: collision with root package name */
    public y f12285u;

    /* renamed from: v, reason: collision with root package name */
    public sa.c f12286v;

    /* renamed from: w, reason: collision with root package name */
    public int f12287w;

    @Override // stepos.support.v7.app.c
    public final boolean a() {
        stepos.support.v7.widget.z zVar = this.f12269d;
        if (zVar == null || !zVar.f12929b.o()) {
            return false;
        }
        this.f12269d.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.c
    public final void b(boolean z10) {
        ArrayList arrayList = this.f12278n;
        if (z10 == this.f12277m) {
            return;
        }
        this.f12277m = z10;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        od.f.j();
    }

    @Override // stepos.support.v7.app.c
    public final int c() {
        return this.f12269d.f12930c;
    }

    @Override // stepos.support.v7.app.c
    public final Context d() {
        if (this.f12267b == null) {
            TypedValue typedValue = new TypedValue();
            this.f12266a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f12267b = new ContextThemeWrapper(this.f12266a, i);
            } else {
                this.f12267b = this.f12266a;
            }
        }
        return this.f12267b;
    }

    @Override // stepos.support.v7.app.c
    public final void f() {
        v(this.f12283s);
    }

    @Override // stepos.support.v7.app.c
    public final void i(boolean z10) {
        if (this.i) {
            return;
        }
        j(z10);
    }

    @Override // stepos.support.v7.app.c
    public final void j(boolean z10) {
        u(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.c
    public final void k() {
        u(0, 2);
    }

    @Override // stepos.support.v7.app.c
    public final void l() {
        if (this.f12283s) {
            od.f.e("nested scroll actionbar can't display title and tabs in the same time");
        } else {
            u(8, 8);
        }
    }

    @Override // stepos.support.v7.app.c
    public final void m(boolean z10) {
        this.f12269d.x(z10);
    }

    @Override // stepos.support.v7.app.c
    public final void n(boolean z10) {
        k.k kVar;
        this.f12282r = z10;
        if (z10 || (kVar = this.f12281q) == null) {
            return;
        }
        kVar.a();
    }

    @Override // stepos.support.v7.app.c
    public final void o(CharSequence charSequence) {
        this.f12269d.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.c
    public final void p(int i) {
        this.f12268c.setUiOptions(i);
    }

    @Override // stepos.support.v7.app.c
    public final void q(CharSequence charSequence) {
        this.f12269d.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.c
    public final se.b r(p5.c cVar) {
        z zVar = this.f12274j;
        if (zVar != null) {
            zVar.a();
        }
        this.f12272g.j();
        z zVar2 = new z(this, this.f12272g.getContext(), cVar);
        te.l lVar = zVar2.f12522j;
        lVar.v();
        try {
            boolean zC = ((se.a) zVar2.f12523k.f9717f).c(zVar2, lVar);
            lVar.u();
            if (!zC) {
                return null;
            }
            zVar2.i();
            this.f12272g.g(zVar2);
            t(true, null);
            ActionBarContainer actionBarContainer = this.f12273h;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12273h.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12268c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarCoordinatorLayout.requestApplyInsets();
                }
            }
            this.f12272g.sendAccessibilityEvent(32);
            this.f12274j = zVar2;
            return zVar2;
        } catch (Throwable th) {
            lVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.c
    public final se.b s(p5.c cVar) {
        z zVar = this.f12274j;
        if (zVar != null) {
            zVar.a();
        }
        this.f12272g.j();
        z zVar2 = new z(this, this.f12272g.getContext(), cVar);
        te.l lVar = zVar2.f12522j;
        lVar.v();
        try {
            if (!((se.a) zVar2.f12523k.f9717f).c(zVar2, lVar)) {
                return null;
            }
            zVar2.i();
            this.f12272g.setSplitView(this.f12273h);
            this.f12272g.h(zVar2);
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12271f;
            ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout.E;
            if (actionBarContextView != null) {
                View customView = actionBarContextView.getCustomView();
                if (customView instanceof stepos.support.v7.widget.a0) {
                    stepos.support.v7.widget.a0 a0Var = (stepos.support.v7.widget.a0) customView;
                    stepOSCollapsingToolbarLayout.G = a0Var;
                    stepOSCollapsingToolbarLayout.F = a0Var.getTitleView();
                    stepos.support.v7.widget.a0 a0Var2 = stepOSCollapsingToolbarLayout.G;
                    stepos.support.v7.widget.t0 t0Var = stepOSCollapsingToolbarLayout.I;
                    if (a0Var2.C == null) {
                        a0Var2.C = new ArrayList();
                    }
                    a0Var2.C.add(t0Var);
                }
                stepOSCollapsingToolbarLayout.g(stepOSCollapsingToolbarLayout.H);
            }
            t(true, zVar2);
            ActionBarContainer actionBarContainer = this.f12273h;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12273h.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12268c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarCoordinatorLayout.requestApplyInsets();
                }
            }
            this.f12272g.sendAccessibilityEvent(32);
            this.f12274j = zVar2;
            return zVar2;
        } finally {
            lVar.u();
        }
    }

    public final void t(boolean z10, z zVar) {
        boolean z11 = zVar != null ? true : z10;
        boolean z12 = this.f12279o;
        if (z11) {
            if (!z12) {
                this.f12279o = true;
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12268c;
                if (actionBarCoordinatorLayout != null) {
                    actionBarCoordinatorLayout.setShowingForActionMode(true);
                }
                w();
            }
        } else if (z12) {
            this.f12279o = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout2 = this.f12268c;
            if (actionBarCoordinatorLayout2 != null) {
                actionBarCoordinatorLayout2.setShowingForActionMode(false);
            }
            w();
        }
        stepos.support.v7.widget.z zVar2 = this.f12269d;
        (z10 ? zVar2.f12929b.u(4, 100L) : zVar2.f12929b.u(0, 200L)).g();
        this.f12272g.f(z10);
    }

    public final void u(int i, int i3) {
        stepos.support.v7.widget.z zVar = this.f12269d;
        int i10 = zVar.f12930c;
        if ((i3 & 4) != 0) {
            this.i = true;
        }
        zVar.q((i & i3) | ((~i3) & i10));
    }

    public final void v(boolean z10) {
        stepos.support.v7.widget.z zVar = this.f12269d;
        if (z10) {
            zVar.getClass();
        } else {
            zVar.getClass();
        }
        this.f12269d.getClass();
        this.f12269d.D(false);
    }

    public final void w() {
        int i = this.f12287w;
        sa.c cVar = this.f12286v;
        if (this.f12280p) {
            return;
        }
        this.f12280p = true;
        y yVar = this.f12285u;
        k.k kVar = this.f12281q;
        if (kVar != null) {
            kVar.a();
        }
        this.f12270e.setVisibility(0);
        boolean z10 = this.f12282r;
        StepOSAppBarLayout stepOSAppBarLayout = this.f12270e;
        if (z10) {
            WeakHashMap weakHashMap = n3.k0.f8724a;
            stepOSAppBarLayout.setTranslationY(0.0f);
            this.f12270e.setTranslationY(-this.f12270e.getHeight());
            k.k kVar2 = new k.k();
            n3.o0 o0VarA = n3.k0.a(this.f12270e);
            o0VarA.h(0.0f);
            o0VarA.f(cVar);
            kVar2.b(o0VarA);
            ActionBarContainer actionBarContainer = this.f12273h;
            if (actionBarContainer != null && !this.f12284t) {
                actionBarContainer.setVisibility(0);
                this.f12273h.setTranslationY(r1.getMeasuredHeight());
                n3.o0 o0VarA2 = n3.k0.a(this.f12273h);
                o0VarA2.h(0.0f);
                kVar2.b(o0VarA2);
            }
            kVar2.d(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
            kVar2.c(i);
            kVar2.e(yVar);
            this.f12281q = kVar2;
            kVar2.f();
        } else {
            WeakHashMap weakHashMap2 = n3.k0.f8724a;
            stepOSAppBarLayout.setAlpha(1.0f);
            this.f12270e.setTranslationY(0.0f);
            ActionBarContainer actionBarContainer2 = this.f12273h;
            if (actionBarContainer2 != null) {
                actionBarContainer2.setAlpha(1.0f);
                this.f12273h.setTranslationY(0.0f);
                this.f12273h.setVisibility(0);
            }
            yVar.d();
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12268c;
        if (actionBarCoordinatorLayout != null) {
            actionBarCoordinatorLayout.requestApplyInsets();
        }
    }
}
