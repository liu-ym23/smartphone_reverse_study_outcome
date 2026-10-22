package stepos.support.v7.app;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class t0 extends c implements stepos.support.v7.widget.i {
    public static final boolean E;
    public s0 A;
    public s0 B;
    public sa.c C;
    public int D;

    /* renamed from: a, reason: collision with root package name */
    public Context f12479a;

    /* renamed from: b, reason: collision with root package name */
    public Context f12480b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f12481c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f12482d;

    /* renamed from: e, reason: collision with root package name */
    public stepos.support.v7.widget.c0 f12483e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f12484f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContainer f12485g;

    /* renamed from: h, reason: collision with root package name */
    public FitsWindowsContentLayout f12486h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public z f12487j;

    /* renamed from: k, reason: collision with root package name */
    public z f12488k;

    /* renamed from: l, reason: collision with root package name */
    public p5.c f12489l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12490m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f12491n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12492o;

    /* renamed from: p, reason: collision with root package name */
    public int f12493p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12494q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12495r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12496s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12497t;

    /* renamed from: u, reason: collision with root package name */
    public k.k f12498u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12499v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12500w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12501x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12502y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f12503z;

    static {
        new AccelerateInterpolator();
        new DecelerateInterpolator();
        E = true;
    }

    @Override // stepos.support.v7.app.c
    public final boolean a() {
        stepos.support.v7.widget.c0 c0Var = this.f12483e;
        if (c0Var == null || !c0Var.o()) {
            return false;
        }
        this.f12483e.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.c
    public final void b(boolean z10) {
        ArrayList arrayList = this.f12491n;
        if (z10 == this.f12490m) {
            return;
        }
        this.f12490m = z10;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        od.f.j();
    }

    @Override // stepos.support.v7.app.c
    public final int c() {
        return this.f12483e.A();
    }

    @Override // stepos.support.v7.app.c
    public final Context d() {
        if (this.f12480b == null) {
            TypedValue typedValue = new TypedValue();
            this.f12479a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f12480b = new ContextThemeWrapper(this.f12479a, i);
            } else {
                this.f12480b = this.f12479a;
            }
        }
        return this.f12480b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @Override // stepos.support.v7.app.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r3 = this;
            boolean r0 = r3.f12502y
            if (r0 == 0) goto L2e
            android.content.Context r0 = r3.f12479a
            a4.n r0 = a4.n.c(r0)
            android.content.Context r0 = r0.f190a
            android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            r2 = 16
            if (r1 < r2) goto L21
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131034112(0x7f050000, float:1.7678732E38)
            boolean r0 = r0.getBoolean(r1)
            goto L2c
        L21:
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131034113(0x7f050001, float:1.7678734E38)
            boolean r0 = r0.getBoolean(r1)
        L2c:
            if (r0 != 0) goto L32
        L2e:
            boolean r0 = r3.f12501x
            if (r0 == 0) goto L34
        L32:
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r3.w(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.t0.f():void");
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
        v(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.c
    public final void k() {
        v(0, 2);
    }

    @Override // stepos.support.v7.app.c
    public final void l() {
        v(8, 8);
    }

    @Override // stepos.support.v7.app.c
    public final void m(boolean z10) {
        this.f12483e.x(z10);
    }

    @Override // stepos.support.v7.app.c
    public final void n(boolean z10) {
        k.k kVar;
        this.f12499v = z10;
        if (z10 || (kVar = this.f12498u) == null) {
            return;
        }
        kVar.a();
    }

    @Override // stepos.support.v7.app.c
    public final void o(CharSequence charSequence) {
        this.f12483e.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.c
    public final void p(int i) {
        this.f12481c.setUiOptions(i);
    }

    @Override // stepos.support.v7.app.c
    public final void q(CharSequence charSequence) {
        this.f12483e.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.c
    public final se.b r(p5.c cVar) {
        z zVar = this.f12487j;
        if (zVar != null) {
            zVar.a();
        }
        this.f12481c.setHideOnContentScrollEnabled(false);
        this.f12484f.j();
        z zVar2 = new z(this, this.f12484f.getContext(), cVar);
        te.l lVar = zVar2.f12522j;
        lVar.v();
        try {
            boolean zC = ((se.a) zVar2.f12523k.f9717f).c(zVar2, lVar);
            lVar.u();
            if (!zC) {
                return null;
            }
            zVar2.i();
            this.f12484f.g(zVar2);
            t(true, null);
            ActionBarContainer actionBarContainer = this.f12485g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12485g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12481c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
            }
            this.f12484f.sendAccessibilityEvent(32);
            this.f12487j = zVar2;
            return zVar2;
        } catch (Throwable th) {
            lVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.c
    public final se.b s(p5.c cVar) {
        z zVar = this.f12487j;
        if (zVar != null) {
            zVar.a();
        }
        this.f12481c.setHideOnContentScrollEnabled(false);
        this.f12484f.j();
        z zVar2 = new z(this, this.f12484f.getContext(), cVar);
        te.l lVar = zVar2.f12522j;
        lVar.v();
        try {
            if (!((se.a) zVar2.f12523k.f9717f).c(zVar2, lVar)) {
                return null;
            }
            zVar2.i();
            this.f12484f.setSplitView(this.f12485g);
            this.f12484f.h(zVar2);
            t(true, zVar2);
            ActionBarContainer actionBarContainer = this.f12485g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12485g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12481c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
            }
            this.f12484f.sendAccessibilityEvent(32);
            this.f12487j = zVar2;
            return zVar2;
        } finally {
            lVar.u();
        }
    }

    public final void t(boolean z10, z zVar) {
        boolean z11 = zVar != null ? true : z10;
        boolean z12 = this.f12496s;
        if (z11) {
            if (!z12) {
                this.f12496s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12481c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                x(false);
            }
        } else if (z12) {
            this.f12496s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f12481c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            x(false);
        }
        stepos.support.v7.widget.c0 c0Var = this.f12483e;
        (z10 ? c0Var.u(4, 100L) : c0Var.u(0, 200L)).g();
        this.f12484f.f(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.t0.u(android.view.View):void");
    }

    public final void v(int i, int i3) {
        int iA = this.f12483e.A();
        if ((i3 & 4) != 0) {
            this.i = true;
        }
        this.f12483e.q((i & i3) | ((~i3) & iA));
    }

    public final void w(boolean z10) {
        this.f12492o = z10;
        if (z10) {
            this.f12482d.setTabContainer(null);
            this.f12483e.r();
        } else {
            this.f12483e.r();
            this.f12482d.setTabContainer(null);
        }
        this.f12483e.getClass();
        if (this.f12492o) {
            this.f12483e.getClass();
        } else {
            this.f12482d.getTabContainer();
        }
        this.f12483e.D(false);
        this.f12481c.setHasNonEmbeddedTabs(false);
    }

    public final void x(boolean z10) {
        int i = this.D;
        sa.c cVar = this.C;
        FitsWindowsContentLayout fitsWindowsContentLayout = this.f12486h;
        boolean z11 = this.f12496s || !this.f12495r;
        boolean z12 = this.f12497t;
        boolean z13 = E;
        if (!z11) {
            if (z12) {
                this.f12497t = false;
                s0 s0Var = this.A;
                k.k kVar = this.f12498u;
                if (kVar != null) {
                    kVar.a();
                }
                if (this.f12493p != 0 || !z13 || (!this.f12499v && !z10)) {
                    s0Var.d();
                    return;
                }
                ActionBarContainer actionBarContainer = this.f12482d;
                WeakHashMap weakHashMap = n3.k0.f8724a;
                actionBarContainer.setAlpha(1.0f);
                this.f12482d.setTransitioning(true);
                k.k kVar2 = new k.k();
                float f5 = -this.f12482d.getHeight();
                if (z10) {
                    this.f12482d.getLocationInWindow(new int[]{0, 0});
                    f5 -= r12[1];
                }
                n3.o0 o0VarA = n3.k0.a(this.f12482d);
                o0VarA.h(f5);
                o0VarA.f(cVar);
                kVar2.b(o0VarA);
                if (this.f12494q && fitsWindowsContentLayout != null) {
                    n3.o0 o0VarA2 = n3.k0.a(fitsWindowsContentLayout);
                    o0VarA2.h(f5);
                    kVar2.b(o0VarA2);
                }
                ActionBarContainer actionBarContainer2 = this.f12485g;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() == 0 && this.f12503z) {
                    this.f12485g.setAlpha(1.0f);
                    n3.o0 o0VarA3 = n3.k0.a(this.f12485g);
                    o0VarA3.h(this.f12485g.getHeight());
                    kVar2.b(o0VarA3);
                }
                kVar2.d(new PathInterpolator(0.29f, 0.5f, 0.16f, 1.0f));
                kVar2.c(i);
                kVar2.e(s0Var);
                this.f12498u = kVar2;
                kVar2.f();
                return;
            }
            return;
        }
        if (z12) {
            return;
        }
        this.f12497t = true;
        s0 s0Var2 = this.B;
        k.k kVar3 = this.f12498u;
        if (kVar3 != null) {
            kVar3.a();
        }
        this.f12482d.setVisibility(0);
        if (this.f12493p == 0 && z13 && (this.f12499v || z10)) {
            ActionBarContainer actionBarContainer3 = this.f12482d;
            WeakHashMap weakHashMap2 = n3.k0.f8724a;
            actionBarContainer3.setTranslationY(0.0f);
            float f10 = -this.f12482d.getHeight();
            if (z10) {
                this.f12482d.getLocationInWindow(new int[]{0, 0});
                f10 -= r12[1];
            }
            this.f12482d.setTranslationY(f10);
            k.k kVar4 = new k.k();
            n3.o0 o0VarA4 = n3.k0.a(this.f12482d);
            o0VarA4.h(0.0f);
            o0VarA4.f(cVar);
            kVar4.b(o0VarA4);
            if (this.f12494q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(f10);
                n3.o0 o0VarA5 = n3.k0.a(fitsWindowsContentLayout);
                o0VarA5.h(0.0f);
                kVar4.b(o0VarA5);
            }
            ActionBarContainer actionBarContainer4 = this.f12485g;
            if (actionBarContainer4 != null && !this.f12503z) {
                actionBarContainer4.setVisibility(0);
                this.f12485g.setTranslationY(r1.getMeasuredHeight());
                n3.o0 o0VarA6 = n3.k0.a(this.f12485g);
                o0VarA6.h(0.0f);
                kVar4.b(o0VarA6);
            }
            kVar4.d(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
            kVar4.c(i);
            kVar4.e(s0Var2);
            this.f12498u = kVar4;
            kVar4.f();
        } else {
            ActionBarContainer actionBarContainer5 = this.f12482d;
            WeakHashMap weakHashMap3 = n3.k0.f8724a;
            actionBarContainer5.setAlpha(1.0f);
            this.f12482d.setTranslationY(0.0f);
            if (this.f12494q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(0.0f);
            }
            ActionBarContainer actionBarContainer6 = this.f12485g;
            if (actionBarContainer6 != null) {
                actionBarContainer6.setAlpha(1.0f);
                this.f12485g.setTranslationY(0.0f);
                this.f12485g.setVisibility(0);
            }
            s0Var2.d();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f12481c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.requestApplyInsets();
        }
    }
}
