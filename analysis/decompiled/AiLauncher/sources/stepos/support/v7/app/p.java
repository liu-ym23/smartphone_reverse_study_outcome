package stepos.support.v7.app;

import Ic.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
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
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class p extends stepos.support.v7.app.a {

    /* renamed from: V, reason: collision with root package name */
    public static final boolean f40566V = true;

    /* renamed from: A, reason: collision with root package name */
    public boolean f40567A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f40568B;

    /* renamed from: D, reason: collision with root package name */
    public i.h f40570D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f40571E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f40572F;

    /* renamed from: H, reason: collision with root package name */
    public boolean f40574H;

    /* renamed from: I, reason: collision with root package name */
    public FrameLayout f40575I;

    /* renamed from: J, reason: collision with root package name */
    public FrameLayout f40576J;

    /* renamed from: d, reason: collision with root package name */
    public Context f40588d;

    /* renamed from: e, reason: collision with root package name */
    public Context f40589e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f40590f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarCoordinatorLayout f40591g;

    /* renamed from: h, reason: collision with root package name */
    public stepos.support.v7.widget.k f40592h;

    /* renamed from: i, reason: collision with root package name */
    public StepOSAppBarLayout f40593i;

    /* renamed from: j, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f40594j;

    /* renamed from: k, reason: collision with root package name */
    public ActionBarContextView f40595k;

    /* renamed from: l, reason: collision with root package name */
    public ActionBarContainer f40596l;

    /* renamed from: m, reason: collision with root package name */
    public View f40597m;

    /* renamed from: n, reason: collision with root package name */
    public stepos.support.v7.widget.r f40598n;

    /* renamed from: q, reason: collision with root package name */
    public boolean f40601q;

    /* renamed from: r, reason: collision with root package name */
    public g f40602r;

    /* renamed from: s, reason: collision with root package name */
    public Ic.b f40603s;

    /* renamed from: t, reason: collision with root package name */
    public b.InterfaceC0060b f40604t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f40605u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f40607w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f40610z;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<Object> f40599o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public int f40600p = -1;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<a.e> f40606v = new ArrayList<>();

    /* renamed from: x, reason: collision with root package name */
    public int f40608x = 0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f40609y = true;

    /* renamed from: C, reason: collision with root package name */
    public boolean f40569C = true;

    /* renamed from: G, reason: collision with root package name */
    public boolean f40573G = true;

    /* renamed from: K, reason: collision with root package name */
    public final V f40577K = new a();

    /* renamed from: L, reason: collision with root package name */
    public final V f40578L = new b();

    /* renamed from: M, reason: collision with root package name */
    public final V f40579M = new c();

    /* renamed from: N, reason: collision with root package name */
    public final V f40580N = new d();

    /* renamed from: O, reason: collision with root package name */
    public final X f40581O = new e();

    /* renamed from: P, reason: collision with root package name */
    public int f40582P = 288;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f40583Q = false;

    /* renamed from: R, reason: collision with root package name */
    public boolean f40584R = false;

    /* renamed from: S, reason: collision with root package name */
    public int f40585S = -1;

    /* renamed from: T, reason: collision with root package name */
    public int f40586T = -1;

    /* renamed from: U, reason: collision with root package name */
    public int f40587U = -1;

    public class a extends W {
        public a() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (p.this.f40596l != null) {
                p.this.f40596l.setVisibility(8);
            }
            p.this.f40574H = false;
            p.this.f40570D = null;
        }
    }

    public class b extends W {
        public b() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (p.this.f40596l != null) {
                N.C0(p.this.f40596l, 0.0f);
                p.this.f40574H = true;
            }
            p.this.f40570D = null;
        }
    }

    public class c extends W {
        public c() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (p.this.f40609y && p.this.f40597m != null) {
                N.C0(p.this.f40597m, 0.0f);
                N.C0(p.this.f40594j, 0.0f);
            }
            if (p.this.f40596l != null) {
                p.this.f40596l.setVisibility(8);
            }
            p.this.f40593i.setVisibility(8);
            p.this.f40593i.setTransitioning(false);
            p.this.f40570D = null;
            p.this.f40574H = false;
            p.this.Q();
            if (p.this.f40591g != null) {
                N.e0(p.this.f40591g);
            }
        }
    }

    public class d extends W {
        public d() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            p.this.f40570D = null;
            p.this.f40574H = true;
            N.C0(p.this.f40593i, 0.0f);
            if (p.this.f40596l != null) {
                N.C0(p.this.f40596l, 0.0f);
            }
            p.this.f40593i.requestLayout();
        }
    }

    public class e implements X {
        public e() {
        }

        @Override // androidx.core.view.X
        public void a(View view) {
            ((View) p.this.f40594j.getParent()).invalidate();
        }
    }

    public class f implements a.b {
        public f() {
        }

        @Override // stepos.support.v7.app.a.b
        public void a(int i10, a.InterfaceC0522a interfaceC0522a) {
            p.this.n(i10, interfaceC0522a);
        }
    }

    public class g extends Ic.b implements c.a {

        /* renamed from: e, reason: collision with root package name */
        public final Context f40617e;

        /* renamed from: f, reason: collision with root package name */
        public final stepos.support.v7.view.menu.c f40618f;

        /* renamed from: g, reason: collision with root package name */
        public b.InterfaceC0060b f40619g;

        /* renamed from: h, reason: collision with root package name */
        public WeakReference<View> f40620h;

        /* renamed from: j, reason: collision with root package name */
        public boolean f40622j;

        /* renamed from: i, reason: collision with root package name */
        public b.a f40621i = new a();

        /* renamed from: k, reason: collision with root package name */
        public boolean f40623k = true;

        public class a implements b.a {
            public a() {
            }

            @Override // Ic.b.a
            public boolean onBackPressed() {
                return true;
            }
        }

        public g(Context context, b.InterfaceC0060b interfaceC0060b) {
            this.f40617e = context;
            this.f40619g = interfaceC0060b;
            stepos.support.v7.view.menu.c cVarR = new stepos.support.v7.view.menu.c(context).R(1);
            this.f40618f = cVarR;
            cVarR.Q(this);
            o(this.f40621i);
        }

        @Override // stepos.support.v7.view.menu.c.a
        public void a(stepos.support.v7.view.menu.c cVar) {
            if (this.f40619g == null) {
                return;
            }
            l();
            p.this.f40595k.u();
        }

        @Override // stepos.support.v7.view.menu.c.a
        public boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            b.InterfaceC0060b interfaceC0060b = this.f40619g;
            if (interfaceC0060b != null) {
                return interfaceC0060b.c(this, menuItem);
            }
            return false;
        }

        @Override // Ic.b
        public void c() {
            p pVar = p.this;
            if (pVar.f40602r != this) {
                return;
            }
            if (p.P(pVar.f40610z, p.this.f40567A, false) || !x()) {
                this.f40619g.a(this);
            } else {
                p pVar2 = p.this;
                pVar2.f40603s = this;
                pVar2.f40604t = this.f40619g;
            }
            this.f40619g = null;
            p.this.N(false);
            p.this.f40595k.m();
            p.this.f40594j.s();
            p.this.f40592h.l().sendAccessibilityEvent(32);
            p.this.f40602r = null;
        }

        @Override // Ic.b
        public View e() {
            WeakReference<View> weakReference = this.f40620h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // Ic.b
        public Menu f() {
            return this.f40618f;
        }

        @Override // Ic.b
        public MenuInflater g() {
            return new Ic.k(this.f40617e);
        }

        @Override // Ic.b
        public CharSequence h() {
            return p.this.f40595k.getSubtitle();
        }

        @Override // Ic.b
        public CharSequence j() {
            return p.this.f40595k.getTitle();
        }

        @Override // Ic.b
        public void l() {
            if (p.this.f40602r != this) {
                return;
            }
            this.f40618f.b0();
            try {
                this.f40619g.b(this, this.f40618f);
            } finally {
                this.f40618f.a0();
            }
        }

        @Override // Ic.b
        public boolean n() {
            return p.this.f40595k.r();
        }

        @Override // Ic.b
        public void p(View view) {
            p.this.f40595k.setCustomView(view);
            this.f40620h = new WeakReference<>(view);
        }

        @Override // Ic.b
        public void q(int i10) {
            r(p.this.f40588d.getResources().getString(i10));
        }

        @Override // Ic.b
        public void r(CharSequence charSequence) {
            p.this.f40595k.setSubtitle(charSequence);
        }

        @Override // Ic.b
        public void t(int i10) {
            u(p.this.f40588d.getResources().getString(i10));
        }

        @Override // Ic.b
        public void u(CharSequence charSequence) {
            p.this.f40595k.setTitle(charSequence);
        }

        @Override // Ic.b
        public void v(boolean z10) {
            super.v(z10);
            p.this.f40595k.setTitleOptional(z10);
        }

        public boolean w() {
            this.f40618f.b0();
            try {
                return this.f40619g.d(this, this.f40618f);
            } finally {
                this.f40618f.a0();
            }
        }

        public boolean x() {
            return this.f40623k;
        }

        public void y(boolean z10) {
            this.f40622j = z10;
        }
    }

    public p(Activity activity) {
        this.f40590f = activity;
        X(activity.getWindow().getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private stepos.support.v7.widget.k T(View view) {
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

    private void W() {
        if (this.f40568B) {
            this.f40568B = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
            if (actionBarCoordinatorLayout != null) {
                actionBarCoordinatorLayout.setShowingForActionMode(false);
            }
            d0(false);
        }
    }

    private void X(View view) {
        this.f40591g = (ActionBarCoordinatorLayout) view.findViewById(R$id.decor_content_parent);
        this.f40595k = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        this.f40594j = (StepOSCollapsingToolbarLayout) view.findViewById(R$id.action_bar_container);
        this.f40593i = (StepOSAppBarLayout) view.findViewById(R$id.app_bar_layout);
        this.f40575I = (FrameLayout) view.findViewById(R$id.action_bar_spring_layout_middle);
        this.f40576J = (FrameLayout) view.findViewById(R$id.action_bar_spring_layout_quick);
        this.f40596l = (ActionBarContainer) view.findViewById(R$id.split_action_bar);
        stepos.support.v7.widget.g gVarT = this.f40594j.t(T(view.findViewById(R$id.action_bar)));
        this.f40592h = gVarT;
        if (gVarT == null || this.f40595k == null || this.f40594j == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        gVarT.x(new f());
        this.f40588d = this.f40592h.getContext();
        int iS = this.f40592h.s();
        boolean z10 = (iS & 4) != 0;
        if (z10) {
            this.f40601q = true;
        }
        s(Ic.a.b(this.f40588d).a() || z10);
        boolean z11 = (iS & 32) != 0;
        this.f40572F = z11;
        if ((iS & 8) != 0 && z11) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        b0(z11);
        TypedArray typedArrayObtainStyledAttributes = this.f40588d.obtainStyledAttributes(null, R$styleable.ActionBar, O6.c.c() ? R$attr.steposActionBarStyleFullScreen : androidx.appcompat.R$attr.actionBarStyle, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f40574H = Y();
    }

    private void b0(boolean z10) {
        this.f40607w = z10;
        if (z10) {
            this.f40592h.H(this.f40598n);
        } else {
            this.f40592h.H(null);
        }
        boolean z11 = V() == 2;
        stepos.support.v7.widget.r rVar = this.f40598n;
        if (rVar != null) {
            if (z11) {
                rVar.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
                if (actionBarCoordinatorLayout != null) {
                    N.e0(actionBarCoordinatorLayout);
                }
            } else {
                rVar.setVisibility(8);
            }
        }
        this.f40592h.o(!this.f40607w && z11);
    }

    private void c0() {
        if (this.f40568B) {
            return;
        }
        this.f40568B = true;
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
        if (actionBarCoordinatorLayout != null) {
            actionBarCoordinatorLayout.setShowingForActionMode(true);
        }
        d0(false);
    }

    private void d0(boolean z10) {
        if (P(this.f40610z, this.f40567A, this.f40568B)) {
            if (this.f40569C) {
                return;
            }
            this.f40569C = true;
            S(z10);
            return;
        }
        if (this.f40569C) {
            this.f40569C = false;
            R(z10);
        }
    }

    public void N(boolean z10) {
        O(z10, null);
    }

    public void O(boolean z10, g gVar) {
        if (gVar != null ? gVar.x() : z10) {
            c0();
        } else {
            W();
        }
        (z10 ? this.f40592h.k(4, 100L) : this.f40592h.k(0, 200L)).l();
        this.f40595k.k(z10, gVar);
    }

    public void Q() {
        b.InterfaceC0060b interfaceC0060b = this.f40604t;
        if (interfaceC0060b != null) {
            interfaceC0060b.a(this.f40603s);
            this.f40603s = null;
            this.f40604t = null;
        }
    }

    public void R(boolean z10) {
        View view;
        i.h hVar = this.f40570D;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f40608x != 0 || !f40566V || (!this.f40571E && !z10)) {
            this.f40579M.d(null);
            return;
        }
        N.l0(this.f40593i, 1.0f);
        this.f40593i.setTransitioning(true);
        i.h hVar2 = new i.h();
        float f10 = -this.f40593i.getHeight();
        if (z10) {
            this.f40593i.getLocationInWindow(new int[]{0, 0});
            f10 -= r6[1];
        }
        U uM = N.d(this.f40593i).m(f10);
        uM.k(this.f40581O);
        hVar2.c(uM);
        if (this.f40609y && (view = this.f40597m) != null) {
            hVar2.c(N.d(view).m(f10));
        }
        ActionBarContainer actionBarContainer = this.f40596l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.f40574H) {
            N.l0(this.f40596l, 1.0f);
            hVar2.c(N.d(this.f40596l).m(this.f40596l.getHeight()));
        }
        hVar2.f(D0.a.a(0.29f, 0.5f, 0.16f, 1.0f));
        hVar2.e(this.f40582P);
        hVar2.g(this.f40579M);
        this.f40570D = hVar2;
        hVar2.h();
    }

    public void S(boolean z10) {
        View view;
        View view2;
        i.h hVar = this.f40570D;
        if (hVar != null) {
            hVar.a();
        }
        this.f40593i.setVisibility(0);
        if (this.f40608x == 0 && f40566V && (this.f40571E || z10)) {
            N.C0(this.f40593i, 0.0f);
            float f10 = -this.f40593i.getHeight();
            if (z10) {
                this.f40593i.getLocationInWindow(new int[]{0, 0});
                f10 -= r7[1];
            }
            N.C0(this.f40593i, f10);
            i.h hVar2 = new i.h();
            U uM = N.d(this.f40593i).m(0.0f);
            uM.k(this.f40581O);
            hVar2.c(uM);
            if (this.f40609y && (view2 = this.f40597m) != null) {
                N.C0(view2, f10);
                hVar2.c(N.d(this.f40597m).m(0.0f));
            }
            ActionBarContainer actionBarContainer = this.f40596l;
            if (actionBarContainer != null && !this.f40574H) {
                actionBarContainer.setVisibility(0);
                N.C0(this.f40596l, r0.getMeasuredHeight());
                hVar2.c(N.d(this.f40596l).m(0.0f));
            }
            hVar2.f(D0.a.a(0.2f, 0.5f, 0.05f, 1.0f));
            hVar2.e(this.f40582P);
            hVar2.g(this.f40580N);
            this.f40570D = hVar2;
            hVar2.h();
        } else {
            N.l0(this.f40593i, 1.0f);
            N.C0(this.f40593i, 0.0f);
            if (this.f40609y && (view = this.f40597m) != null) {
                N.C0(view, 0.0f);
            }
            ActionBarContainer actionBarContainer2 = this.f40596l;
            if (actionBarContainer2 != null) {
                N.l0(actionBarContainer2, 1.0f);
                N.C0(this.f40596l, 0.0f);
                this.f40596l.setVisibility(0);
            }
            this.f40580N.d(null);
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
        if (actionBarCoordinatorLayout != null) {
            N.e0(actionBarCoordinatorLayout);
        }
    }

    public int U() {
        return this.f40594j.getHeight();
    }

    public int V() {
        return this.f40592h.j();
    }

    public boolean Y() {
        return this.f40569C && U() == 0;
    }

    public void Z(int i10, int i11) {
        int iS = this.f40592h.s();
        if ((i11 & 4) != 0) {
            this.f40601q = true;
        }
        this.f40592h.h((i10 & i11) | ((~i11) & iS));
    }

    public void a0(float f10) {
        N.p0(this.f40593i, f10);
        ActionBarContainer actionBarContainer = this.f40596l;
        if (actionBarContainer != null) {
            N.p0(actionBarContainer, f10);
        }
    }

    @Override // stepos.support.v7.app.a
    public boolean f() {
        stepos.support.v7.widget.k kVar = this.f40592h;
        if (kVar == null || !kVar.g()) {
            return false;
        }
        this.f40592h.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void g(boolean z10) {
        if (z10 == this.f40605u) {
            return;
        }
        this.f40605u = z10;
        int size = this.f40606v.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f40606v.get(i10).a(z10);
        }
    }

    @Override // stepos.support.v7.app.a
    public int h() {
        return this.f40592h.s();
    }

    @Override // stepos.support.v7.app.a
    public Context i() {
        if (this.f40589e == null) {
            TypedValue typedValue = new TypedValue();
            this.f40588d.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f40589e = new ContextThemeWrapper(this.f40588d, i10);
            } else {
                this.f40589e = this.f40588d;
            }
        }
        return this.f40589e;
    }

    @Override // stepos.support.v7.app.a
    public void k(Configuration configuration) {
        b0(this.f40572F);
    }

    @Override // stepos.support.v7.app.a
    public void o(boolean z10) {
        if (this.f40601q) {
            return;
        }
        p(z10);
    }

    @Override // stepos.support.v7.app.a
    public void p(boolean z10) {
        Z(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public void q(boolean z10) {
        Z(z10 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void r(boolean z10) {
        if (this.f40572F && z10) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        Z(z10 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void s(boolean z10) {
        this.f40592h.m(z10);
    }

    @Override // stepos.support.v7.app.a
    public void t(boolean z10) {
        i.h hVar;
        this.f40571E = z10;
        if (z10 || (hVar = this.f40570D) == null) {
            return;
        }
        hVar.a();
    }

    @Override // stepos.support.v7.app.a
    public void u(CharSequence charSequence) {
        this.f40592h.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void v(int i10) {
        this.f40591g.setUiOptions(i10);
    }

    @Override // stepos.support.v7.app.a
    public void w(CharSequence charSequence) {
        this.f40592h.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public Ic.b x(b.InterfaceC0060b interfaceC0060b) {
        g gVar = this.f40602r;
        if (gVar != null) {
            gVar.c();
        }
        this.f40595k.s();
        g gVar2 = new g(this.f40595k.getContext(), interfaceC0060b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f40595k.n(gVar2);
        N(true);
        ActionBarContainer actionBarContainer = this.f40596l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f40596l.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
            if (actionBarCoordinatorLayout != null) {
                N.e0(actionBarCoordinatorLayout);
            }
        }
        this.f40595k.sendAccessibilityEvent(32);
        this.f40602r = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.app.a
    public Ic.b y(b.InterfaceC0060b interfaceC0060b) {
        g gVar = this.f40602r;
        if (gVar != null) {
            gVar.c();
        }
        this.f40595k.s();
        g gVar2 = new g(this.f40595k.getContext(), interfaceC0060b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f40595k.setSplitView(this.f40596l);
        this.f40595k.o(gVar2);
        this.f40594j.u();
        O(true, gVar2);
        ActionBarContainer actionBarContainer = this.f40596l;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f40596l.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f40591g;
            if (actionBarCoordinatorLayout != null) {
                N.e0(actionBarCoordinatorLayout);
            }
        }
        this.f40595k.sendAccessibilityEvent(32);
        gVar2.y(true);
        this.f40602r = gVar2;
        return gVar2;
    }
}
