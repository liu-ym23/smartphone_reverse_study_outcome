package stepos.support.v7.app;

import Ic.b;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$styleable;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import androidx.core.view.X;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.Toolbar;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class t extends stepos.support.v7.app.a implements ActionBarOverlayLayout.f {

    /* renamed from: U, reason: collision with root package name */
    public static final Interpolator f40771U = new AccelerateInterpolator();

    /* renamed from: V, reason: collision with root package name */
    public static final Interpolator f40772V = new DecelerateInterpolator();

    /* renamed from: W, reason: collision with root package name */
    public static final boolean f40773W = true;

    /* renamed from: A, reason: collision with root package name */
    public boolean f40774A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f40775B;

    /* renamed from: D, reason: collision with root package name */
    public i.h f40777D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f40778E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f40779F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f40780G;

    /* renamed from: I, reason: collision with root package name */
    public boolean f40782I;

    /* renamed from: d, reason: collision with root package name */
    public Context f40794d;

    /* renamed from: e, reason: collision with root package name */
    public Context f40795e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f40796f;

    /* renamed from: g, reason: collision with root package name */
    public Dialog f40797g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarOverlayLayout f40798h;

    /* renamed from: i, reason: collision with root package name */
    public ActionBarContainer f40799i;

    /* renamed from: j, reason: collision with root package name */
    public stepos.support.v7.widget.k f40800j;

    /* renamed from: k, reason: collision with root package name */
    public ActionBarContextView f40801k;

    /* renamed from: l, reason: collision with root package name */
    public ActionBarContainer f40802l;

    /* renamed from: m, reason: collision with root package name */
    public FitsWindowsContentLayout f40803m;

    /* renamed from: n, reason: collision with root package name */
    public stepos.support.v7.widget.r f40804n;

    /* renamed from: q, reason: collision with root package name */
    public boolean f40807q;

    /* renamed from: r, reason: collision with root package name */
    public g f40808r;

    /* renamed from: s, reason: collision with root package name */
    public Ic.b f40809s;

    /* renamed from: t, reason: collision with root package name */
    public b.InterfaceC0060b f40810t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f40811u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f40813w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f40816z;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<Object> f40805o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public int f40806p = -1;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<a.e> f40812v = new ArrayList<>();

    /* renamed from: x, reason: collision with root package name */
    public int f40814x = 0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f40815y = true;

    /* renamed from: C, reason: collision with root package name */
    public boolean f40776C = true;

    /* renamed from: H, reason: collision with root package name */
    public boolean f40781H = true;

    /* renamed from: J, reason: collision with root package name */
    public final V f40783J = new a();

    /* renamed from: K, reason: collision with root package name */
    public final V f40784K = new b();

    /* renamed from: L, reason: collision with root package name */
    public final V f40785L = new c();

    /* renamed from: M, reason: collision with root package name */
    public final V f40786M = new d();

    /* renamed from: N, reason: collision with root package name */
    public final X f40787N = new e();

    /* renamed from: O, reason: collision with root package name */
    public int f40788O = 288;

    /* renamed from: P, reason: collision with root package name */
    public boolean f40789P = false;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f40790Q = false;

    /* renamed from: R, reason: collision with root package name */
    public int f40791R = -1;

    /* renamed from: S, reason: collision with root package name */
    public int f40792S = -1;

    /* renamed from: T, reason: collision with root package name */
    public int f40793T = -1;

    public class a extends W {
        public a() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (t.this.f40802l != null) {
                t.this.f40802l.setVisibility(8);
            }
            t.this.f40782I = false;
            t.this.f40777D = null;
        }
    }

    public class b extends W {
        public b() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (t.this.f40802l != null) {
                N.C0(t.this.f40802l, 0.0f);
                t.this.f40782I = true;
            }
            t.this.f40777D = null;
        }
    }

    public class c extends W {
        public c() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (t.this.f40815y && t.this.f40803m != null) {
                N.C0(t.this.f40803m, 0.0f);
                N.C0(t.this.f40799i, 0.0f);
            }
            if (t.this.f40802l != null) {
                t.this.f40802l.setVisibility(8);
            }
            t.this.f40799i.setVisibility(8);
            t.this.f40799i.setTransitioning(false);
            t.this.f40777D = null;
            t.this.f40782I = false;
            t.this.P();
            if (t.this.f40798h != null) {
                N.e0(t.this.f40798h);
            }
        }
    }

    public class d extends W {
        public d() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            t.this.f40777D = null;
            t.this.f40782I = true;
            N.C0(t.this.f40799i, 0.0f);
            if (t.this.f40802l != null) {
                N.C0(t.this.f40802l, 0.0f);
            }
            t.this.f40799i.requestLayout();
        }
    }

    public class e implements X {
        public e() {
        }

        @Override // androidx.core.view.X
        public void a(View view) {
            ((View) t.this.f40799i.getParent()).invalidate();
        }
    }

    public class f implements a.b {
        public f() {
        }

        @Override // stepos.support.v7.app.a.b
        public void a(int i10, a.InterfaceC0522a interfaceC0522a) {
            t.this.n(i10, interfaceC0522a);
        }
    }

    public class g extends Ic.b implements c.a {

        /* renamed from: e, reason: collision with root package name */
        public final Context f40823e;

        /* renamed from: f, reason: collision with root package name */
        public final stepos.support.v7.view.menu.c f40824f;

        /* renamed from: g, reason: collision with root package name */
        public b.InterfaceC0060b f40825g;

        /* renamed from: h, reason: collision with root package name */
        public WeakReference<View> f40826h;

        /* renamed from: j, reason: collision with root package name */
        public boolean f40828j;

        /* renamed from: i, reason: collision with root package name */
        public b.a f40827i = new a();

        /* renamed from: k, reason: collision with root package name */
        public boolean f40829k = true;

        public class a implements b.a {
            public a() {
            }

            @Override // Ic.b.a
            public boolean onBackPressed() {
                return true;
            }
        }

        public g(Context context, b.InterfaceC0060b interfaceC0060b) {
            this.f40823e = context;
            this.f40825g = interfaceC0060b;
            stepos.support.v7.view.menu.c cVarR = new stepos.support.v7.view.menu.c(context).R(1);
            this.f40824f = cVarR;
            cVarR.Q(this);
            o(this.f40827i);
        }

        @Override // stepos.support.v7.view.menu.c.a
        public void a(stepos.support.v7.view.menu.c cVar) {
            if (this.f40825g == null) {
                return;
            }
            l();
            t.this.f40801k.u();
        }

        @Override // stepos.support.v7.view.menu.c.a
        public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            b.InterfaceC0060b interfaceC0060b = this.f40825g;
            if (interfaceC0060b != null) {
                return interfaceC0060b.c(this, menuItem);
            }
            return false;
        }

        @Override // Ic.b
        public void c() {
            t tVar = t.this;
            if (tVar.f40808r != this) {
                return;
            }
            if (t.O(tVar.f40816z, t.this.f40774A, false) || !x()) {
                this.f40825g.a(this);
            } else {
                t tVar2 = t.this;
                tVar2.f40809s = this;
                tVar2.f40810t = this.f40825g;
            }
            this.f40825g = null;
            t.this.M(false);
            t.this.f40801k.m();
            t.this.f40800j.l().sendAccessibilityEvent(32);
            t.this.f40798h.setHideOnContentScrollEnabled(t.this.f40779F);
            t.this.f40808r = null;
        }

        @Override // Ic.b
        public View e() {
            WeakReference<View> weakReference = this.f40826h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // Ic.b
        public Menu f() {
            return this.f40824f;
        }

        @Override // Ic.b
        public MenuInflater g() {
            return new Ic.k(this.f40823e);
        }

        @Override // Ic.b
        public CharSequence h() {
            return t.this.f40801k.getSubtitle();
        }

        @Override // Ic.b
        public CharSequence j() {
            return t.this.f40801k.getTitle();
        }

        @Override // Ic.b
        public void l() {
            if (t.this.f40808r != this) {
                return;
            }
            this.f40824f.b0();
            try {
                this.f40825g.b(this, this.f40824f);
            } finally {
                this.f40824f.a0();
            }
        }

        @Override // Ic.b
        public boolean n() {
            return t.this.f40801k.r();
        }

        @Override // Ic.b
        public void p(View view) {
            t.this.f40801k.setCustomView(view);
            this.f40826h = new WeakReference<>(view);
        }

        @Override // Ic.b
        public void q(int i10) {
            r(t.this.f40794d.getResources().getString(i10));
        }

        @Override // Ic.b
        public void r(CharSequence charSequence) {
            t.this.f40801k.setSubtitle(charSequence);
        }

        @Override // Ic.b
        public void t(int i10) {
            u(t.this.f40794d.getResources().getString(i10));
        }

        @Override // Ic.b
        public void u(CharSequence charSequence) {
            t.this.f40801k.setTitle(charSequence);
        }

        @Override // Ic.b
        public void v(boolean z10) {
            super.v(z10);
            t.this.f40801k.setTitleOptional(z10);
        }

        public boolean w() {
            this.f40824f.b0();
            try {
                return this.f40825g.d(this, this.f40824f);
            } finally {
                this.f40824f.a0();
            }
        }

        public boolean x() {
            return this.f40829k;
        }

        public void y(boolean z10) {
            this.f40828j = z10;
        }
    }

    public t(Activity activity, boolean z10) {
        this.f40796f = activity;
        View decorView = activity.getWindow().getDecorView();
        Y(decorView);
        if (z10) {
            return;
        }
        this.f40803m = (FitsWindowsContentLayout) decorView.findViewById(R.id.content);
    }

    public static boolean O(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public void M(boolean z10) {
        N(z10, null);
    }

    public void N(boolean z10, g gVar) {
        if (gVar != null ? gVar.x() : z10) {
            e0();
        } else {
            X();
        }
        (z10 ? this.f40800j.k(4, 100L) : this.f40800j.k(0, 200L)).l();
        this.f40801k.k(z10, gVar);
    }

    public void P() {
        b.InterfaceC0060b interfaceC0060b = this.f40810t;
        if (interfaceC0060b != null) {
            interfaceC0060b.a(this.f40809s);
            this.f40809s = null;
            this.f40810t = null;
        }
    }

    public void Q(boolean z10) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        i.h hVar = this.f40777D;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f40814x != 0 || !f40773W || (!this.f40778E && !z10)) {
            this.f40785L.d(null);
            return;
        }
        N.l0(this.f40799i, 1.0f);
        this.f40799i.setTransitioning(true);
        i.h hVar2 = new i.h();
        float f10 = -this.f40799i.getHeight();
        if (z10) {
            this.f40799i.getLocationInWindow(new int[]{0, 0});
            f10 -= r6[1];
        }
        U uM = N.d(this.f40799i).m(f10);
        uM.k(this.f40787N);
        hVar2.c(uM);
        if (this.f40815y && (fitsWindowsContentLayout = this.f40803m) != null) {
            hVar2.c(N.d(fitsWindowsContentLayout).m(f10));
        }
        ActionBarContainer actionBarContainer = this.f40802l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.f40782I) {
            N.l0(this.f40802l, 1.0f);
            hVar2.c(N.d(this.f40802l).m(this.f40802l.getHeight()));
        }
        hVar2.f(D0.a.a(0.29f, 0.5f, 0.16f, 1.0f));
        hVar2.e(this.f40788O);
        hVar2.g(this.f40785L);
        this.f40777D = hVar2;
        hVar2.h();
    }

    public void R(boolean z10) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        FitsWindowsContentLayout fitsWindowsContentLayout2;
        i.h hVar = this.f40777D;
        if (hVar != null) {
            hVar.a();
        }
        this.f40799i.setVisibility(0);
        if (this.f40814x == 0 && f40773W && (this.f40778E || z10)) {
            N.C0(this.f40799i, 0.0f);
            float f10 = -this.f40799i.getHeight();
            if (z10) {
                this.f40799i.getLocationInWindow(new int[]{0, 0});
                f10 -= r7[1];
            }
            N.C0(this.f40799i, f10);
            i.h hVar2 = new i.h();
            U uM = N.d(this.f40799i).m(0.0f);
            uM.k(this.f40787N);
            hVar2.c(uM);
            if (this.f40815y && (fitsWindowsContentLayout2 = this.f40803m) != null) {
                N.C0(fitsWindowsContentLayout2, f10);
                hVar2.c(N.d(this.f40803m).m(0.0f));
            }
            ActionBarContainer actionBarContainer = this.f40802l;
            if (actionBarContainer != null && !this.f40782I) {
                actionBarContainer.setVisibility(0);
                N.C0(this.f40802l, r0.getMeasuredHeight());
                hVar2.c(N.d(this.f40802l).m(0.0f));
            }
            hVar2.f(D0.a.a(0.2f, 0.5f, 0.05f, 1.0f));
            hVar2.e(this.f40788O);
            hVar2.g(this.f40786M);
            this.f40777D = hVar2;
            hVar2.h();
        } else {
            N.l0(this.f40799i, 1.0f);
            N.C0(this.f40799i, 0.0f);
            if (this.f40815y && (fitsWindowsContentLayout = this.f40803m) != null) {
                N.C0(fitsWindowsContentLayout, 0.0f);
            }
            ActionBarContainer actionBarContainer2 = this.f40802l;
            if (actionBarContainer2 != null) {
                N.l0(actionBarContainer2, 1.0f);
                N.C0(this.f40802l, 0.0f);
                this.f40802l.setVisibility(0);
            }
            this.f40786M.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
        if (actionBarOverlayLayout != null) {
            N.e0(actionBarOverlayLayout);
        }
    }

    public stepos.support.v7.widget.s S() {
        return !this.f40813w ? this.f40799i.getTabContainer() : this.f40800j.G();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final stepos.support.v7.widget.k T(View view) {
        if (view instanceof stepos.support.v7.widget.k) {
            return (stepos.support.v7.widget.k) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view);
        throw new IllegalStateException(sb2.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public int U() {
        return this.f40799i.getHeight();
    }

    public int V() {
        return this.f40798h.getActionBarHideOffset();
    }

    public int W() {
        return this.f40800j.j();
    }

    public final void X() {
        if (this.f40775B) {
            this.f40775B = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            f0(false);
        }
    }

    public final void Y(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f40798h = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f40800j = T(view.findViewById(R$id.action_bar));
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f40799i = actionBarContainer;
        this.f40801k = (ActionBarContextView) actionBarContainer.findViewById(R$id.action_context_bar);
        this.f40802l = (ActionBarContainer) view.findViewById(R$id.split_action_bar);
        stepos.support.v7.widget.k kVar = this.f40800j;
        if (kVar == null || this.f40801k == null || this.f40799i == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        kVar.x(new f());
        this.f40794d = this.f40800j.getContext();
        int iS = this.f40800j.s();
        boolean z10 = (iS & 4) != 0;
        if (z10) {
            this.f40807q = true;
        }
        Ic.a aVarB = Ic.a.b(this.f40794d);
        s(aVarB.a() || z10);
        this.f40780G = (iS & 32) != 0;
        c0((this.f40781H && aVarB.i()) || this.f40780G);
        TypedArray typedArrayObtainStyledAttributes = this.f40794d.obtainStyledAttributes(null, R$styleable.ActionBar, O6.c.c() ? R$attr.steposActionBarStyleFullScreen : androidx.appcompat.R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            d0(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            b0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f40782I = Z();
    }

    public boolean Z() {
        int iU = U();
        if (this.f40776C) {
            return iU == 0 || V() < iU;
        }
        return false;
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void a() {
        if (this.f40774A) {
            this.f40774A = false;
            f0(true);
        }
    }

    public void a0(int i10, int i11) {
        int iS = this.f40800j.s();
        if ((i11 & 4) != 0) {
            this.f40807q = true;
        }
        this.f40800j.h((i10 & i11) | ((~i11) & iS));
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void b() {
    }

    public void b0(float f10) {
        N.p0(this.f40799i, f10);
        ActionBarContainer actionBarContainer = this.f40802l;
        if (actionBarContainer != null) {
            N.p0(actionBarContainer, f10);
        }
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void c(boolean z10) {
        this.f40815y = z10;
    }

    public final void c0(boolean z10) {
        this.f40813w = z10;
        if (z10) {
            this.f40799i.setTabContainer(null);
            this.f40800j.H(this.f40804n);
        } else {
            this.f40800j.H(null);
            this.f40799i.setTabContainer(this.f40804n);
        }
        boolean z11 = W() == 2;
        stepos.support.v7.widget.s sVarS = S();
        if (sVarS != null) {
            if (z11) {
                sVarS.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
                if (actionBarOverlayLayout != null) {
                    N.e0(actionBarOverlayLayout);
                }
            } else {
                sVarS.setVisibility(8);
            }
        }
        this.f40800j.o(!this.f40813w && z11);
        this.f40798h.setHasNonEmbeddedTabs(!this.f40813w && z11);
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void d() {
        if (this.f40774A) {
            return;
        }
        this.f40774A = true;
        f0(true);
    }

    public void d0(boolean z10) {
        if (z10 && !this.f40798h.C()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f40779F = z10;
        this.f40798h.setHideOnContentScrollEnabled(z10);
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void e() {
        i.h hVar = this.f40777D;
        if (hVar != null) {
            hVar.a();
            this.f40777D = null;
        }
    }

    public final void e0() {
        if (this.f40775B) {
            return;
        }
        this.f40775B = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        f0(false);
    }

    @Override // stepos.support.v7.app.a
    public boolean f() {
        stepos.support.v7.widget.k kVar = this.f40800j;
        if (kVar == null || !kVar.g()) {
            return false;
        }
        this.f40800j.collapseActionView();
        return true;
    }

    public final void f0(boolean z10) {
        if (O(this.f40816z, this.f40774A, this.f40775B)) {
            if (this.f40776C) {
                return;
            }
            this.f40776C = true;
            R(z10);
            return;
        }
        if (this.f40776C) {
            this.f40776C = false;
            Q(z10);
        }
    }

    @Override // stepos.support.v7.app.a
    public void g(boolean z10) {
        if (z10 == this.f40811u) {
            return;
        }
        this.f40811u = z10;
        int size = this.f40812v.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f40812v.get(i10).a(z10);
        }
    }

    @Override // stepos.support.v7.app.a
    public int h() {
        return this.f40800j.s();
    }

    @Override // stepos.support.v7.app.a
    public Context i() {
        if (this.f40795e == null) {
            TypedValue typedValue = new TypedValue();
            this.f40794d.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f40795e = new ContextThemeWrapper(this.f40794d, i10);
            } else {
                this.f40795e = this.f40794d;
            }
        }
        return this.f40795e;
    }

    @Override // stepos.support.v7.app.a
    public void k(Configuration configuration) {
        c0((this.f40781H && Ic.a.b(this.f40794d).i()) || this.f40780G);
    }

    @Override // stepos.support.v7.app.a
    public void o(boolean z10) {
        if (this.f40807q) {
            return;
        }
        p(z10);
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void onWindowVisibilityChanged(int i10) {
        this.f40814x = i10;
    }

    @Override // stepos.support.v7.app.a
    public void p(boolean z10) {
        a0(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public void q(boolean z10) {
        a0(z10 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void r(boolean z10) {
        a0(z10 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void s(boolean z10) {
        this.f40800j.m(z10);
    }

    @Override // stepos.support.v7.app.a
    public void t(boolean z10) {
        i.h hVar;
        this.f40778E = z10;
        if (z10 || (hVar = this.f40777D) == null) {
            return;
        }
        hVar.a();
    }

    @Override // stepos.support.v7.app.a
    public void u(CharSequence charSequence) {
        this.f40800j.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void v(int i10) {
        this.f40798h.setUiOptions(i10);
    }

    @Override // stepos.support.v7.app.a
    public void w(CharSequence charSequence) {
        this.f40800j.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public Ic.b x(b.InterfaceC0060b interfaceC0060b) {
        g gVar = this.f40808r;
        if (gVar != null) {
            gVar.c();
        }
        this.f40798h.setHideOnContentScrollEnabled(false);
        this.f40801k.s();
        g gVar2 = new g(this.f40801k.getContext(), interfaceC0060b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f40801k.n(gVar2);
        M(true);
        ActionBarContainer actionBarContainer = this.f40802l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f40802l.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
            if (actionBarOverlayLayout != null) {
                N.e0(actionBarOverlayLayout);
            }
        }
        this.f40801k.sendAccessibilityEvent(32);
        this.f40808r = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.app.a
    public Ic.b y(b.InterfaceC0060b interfaceC0060b) {
        g gVar = this.f40808r;
        if (gVar != null) {
            gVar.c();
        }
        this.f40798h.setHideOnContentScrollEnabled(false);
        this.f40801k.s();
        g gVar2 = new g(this.f40801k.getContext(), interfaceC0060b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f40801k.setSplitView(this.f40802l);
        this.f40801k.o(gVar2);
        N(true, gVar2);
        ActionBarContainer actionBarContainer = this.f40802l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f40802l.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f40798h;
            if (actionBarOverlayLayout != null) {
                N.e0(actionBarOverlayLayout);
            }
        }
        this.f40801k.sendAccessibilityEvent(32);
        gVar2.y(true);
        this.f40808r = gVar2;
        return gVar2;
    }

    public t(Dialog dialog) {
        this.f40797g = dialog;
        Y(dialog.getWindow().getDecorView());
    }
}
