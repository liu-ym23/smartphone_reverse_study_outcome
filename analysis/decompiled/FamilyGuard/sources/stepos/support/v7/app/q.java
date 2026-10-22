package stepos.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.fragment.app.ActivityC0516k;
import androidx.fragment.app.G;
import b5.b;
import g.C0728a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public class q extends stepos.support.v7.app.a {

    /* renamed from: a0, reason: collision with root package name */
    private static final boolean f20973a0 = true;

    /* renamed from: C, reason: collision with root package name */
    private boolean f20976C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f20977D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f20978E;

    /* renamed from: G, reason: collision with root package name */
    private androidx.appcompat.view.h f20980G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f20981H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f20982I;

    /* renamed from: J, reason: collision with root package name */
    private int f20983J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f20984K;

    /* renamed from: M, reason: collision with root package name */
    private boolean f20986M;

    /* renamed from: N, reason: collision with root package name */
    private FrameLayout f20987N;

    /* renamed from: O, reason: collision with root package name */
    private FrameLayout f20988O;

    /* renamed from: f, reason: collision with root package name */
    private Context f21000f;

    /* renamed from: g, reason: collision with root package name */
    private Context f21001g;

    /* renamed from: h, reason: collision with root package name */
    private Activity f21002h;

    /* renamed from: i, reason: collision with root package name */
    private ActionBarCoordinatorLayout f21003i;

    /* renamed from: j, reason: collision with root package name */
    private stepos.support.v7.widget.m f21004j;

    /* renamed from: k, reason: collision with root package name */
    private StepOSAppBarLayout f21005k;

    /* renamed from: l, reason: collision with root package name */
    private StepOSCollapsingToolbarLayout f21006l;

    /* renamed from: m, reason: collision with root package name */
    private ActionBarContextView f21007m;

    /* renamed from: n, reason: collision with root package name */
    private ActionBarContainer f21008n;

    /* renamed from: o, reason: collision with root package name */
    private View f21009o;

    /* renamed from: p, reason: collision with root package name */
    private stepos.support.v7.widget.v f21010p;

    /* renamed from: r, reason: collision with root package name */
    private h f21012r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21014t;

    /* renamed from: u, reason: collision with root package name */
    g f21015u;

    /* renamed from: v, reason: collision with root package name */
    b5.b f21016v;

    /* renamed from: w, reason: collision with root package name */
    b.InterfaceC0154b f21017w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f21018x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f21020z;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<h> f21011q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private int f21013s = -1;

    /* renamed from: y, reason: collision with root package name */
    private ArrayList<a.f> f21019y = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    private int f20974A = 0;

    /* renamed from: B, reason: collision with root package name */
    private boolean f20975B = true;

    /* renamed from: F, reason: collision with root package name */
    private boolean f20979F = true;

    /* renamed from: L, reason: collision with root package name */
    private boolean f20985L = true;

    /* renamed from: P, reason: collision with root package name */
    final T f20989P = new a();

    /* renamed from: Q, reason: collision with root package name */
    final T f20990Q = new b();

    /* renamed from: R, reason: collision with root package name */
    final T f20991R = new c();

    /* renamed from: S, reason: collision with root package name */
    final T f20992S = new d();

    /* renamed from: T, reason: collision with root package name */
    final V f20993T = new e();

    /* renamed from: U, reason: collision with root package name */
    private int f20994U = 288;

    /* renamed from: V, reason: collision with root package name */
    private boolean f20995V = false;

    /* renamed from: W, reason: collision with root package name */
    private boolean f20996W = false;

    /* renamed from: X, reason: collision with root package name */
    private int f20997X = -1;

    /* renamed from: Y, reason: collision with root package name */
    private int f20998Y = -1;

    /* renamed from: Z, reason: collision with root package name */
    private int f20999Z = -1;

    class a extends U {
        a() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (q.this.f21008n != null) {
                q.this.f21008n.setVisibility(8);
            }
            q.this.f20986M = false;
            q.this.f20980G = null;
        }
    }

    class b extends U {
        b() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (q.this.f21008n != null) {
                H.F0(q.this.f21008n, 0.0f);
                q.this.f20986M = true;
            }
            q.this.f20980G = null;
        }
    }

    class c extends U {
        c() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (q.this.f20975B && q.this.f21009o != null) {
                H.F0(q.this.f21009o, 0.0f);
                H.F0(q.this.f21006l, 0.0f);
            }
            if (q.this.f21008n != null) {
                q.this.f21008n.setVisibility(8);
            }
            q.this.f21005k.setVisibility(8);
            q.this.f21005k.setTransitioning(false);
            q.this.f20980G = null;
            q.this.f20986M = false;
            q.this.o0();
            if (q.this.f21003i != null) {
                H.g0(q.this.f21003i);
            }
        }
    }

    class d extends U {
        d() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            q.this.f20980G = null;
            q.this.f20986M = true;
            H.F0(q.this.f21005k, 0.0f);
            if (q.this.f21008n != null) {
                H.F0(q.this.f21008n, 0.0f);
            }
            q.this.f21005k.requestLayout();
        }
    }

    class e implements V {
        e() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            ((View) q.this.f21006l.getParent()).invalidate();
        }
    }

    class f implements a.c {
        f() {
        }

        @Override // stepos.support.v7.app.a.c
        public void a(int i5, a.InterfaceC0240a interfaceC0240a) {
            q.this.A(i5, interfaceC0240a);
        }
    }

    public class g extends b5.b implements d.a {

        /* renamed from: e, reason: collision with root package name */
        private final Context f21027e;

        /* renamed from: f, reason: collision with root package name */
        private final stepos.support.v7.view.menu.d f21028f;

        /* renamed from: g, reason: collision with root package name */
        private b.InterfaceC0154b f21029g;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<View> f21030h;

        /* renamed from: j, reason: collision with root package name */
        private boolean f21032j;

        /* renamed from: i, reason: collision with root package name */
        private b.a f21031i = new a();

        /* renamed from: k, reason: collision with root package name */
        private boolean f21033k = true;

        class a implements b.a {
            a() {
            }

            @Override // b5.b.a
            public boolean a() {
                return true;
            }
        }

        public g(Context context, b.InterfaceC0154b interfaceC0154b) {
            this.f21027e = context;
            this.f21029g = interfaceC0154b;
            stepos.support.v7.view.menu.d dVarR = new stepos.support.v7.view.menu.d(context).R(1);
            this.f21028f = dVarR;
            dVarR.Q(this);
            o(this.f21031i);
        }

        @Override // b5.b
        public void a() {
            q qVar = q.this;
            if (qVar.f21015u != this) {
                return;
            }
            if (q.n0(qVar.f20976C, q.this.f20977D, false) || !x()) {
                this.f21029g.c(this);
            } else {
                q qVar2 = q.this;
                qVar2.f21016v = this;
                qVar2.f21017w = this.f21029g;
            }
            this.f21029g = null;
            q.this.l0(false);
            q.this.f21007m.m();
            q.this.f21006l.s();
            q.this.f21004j.K().sendAccessibilityEvent(32);
            q.this.f21015u = null;
        }

        @Override // stepos.support.v7.view.menu.d.a
        public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
            b.InterfaceC0154b interfaceC0154b = this.f21029g;
            if (interfaceC0154b != null) {
                return interfaceC0154b.a(this, menuItem);
            }
            return false;
        }

        @Override // stepos.support.v7.view.menu.d.a
        public void d(stepos.support.v7.view.menu.d dVar) {
            if (this.f21029g == null) {
                return;
            }
            l();
            q.this.f21007m.u();
        }

        @Override // b5.b
        public View e() {
            WeakReference<View> weakReference = this.f21030h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // b5.b
        public Menu f() {
            return this.f21028f;
        }

        @Override // b5.b
        public MenuInflater g() {
            return new b5.k(this.f21027e);
        }

        @Override // b5.b
        public CharSequence h() {
            return q.this.f21007m.getSubtitle();
        }

        @Override // b5.b
        public CharSequence j() {
            return q.this.f21007m.getTitle();
        }

        @Override // b5.b
        public void l() {
            if (q.this.f21015u != this) {
                return;
            }
            this.f21028f.b0();
            try {
                this.f21029g.b(this, this.f21028f);
            } finally {
                this.f21028f.a0();
            }
        }

        @Override // b5.b
        public boolean n() {
            return q.this.f21007m.r();
        }

        @Override // b5.b
        public void p(View view) {
            q.this.f21007m.setCustomView(view);
            this.f21030h = new WeakReference<>(view);
        }

        @Override // b5.b
        public void q(int i5) {
            r(q.this.f21000f.getResources().getString(i5));
        }

        @Override // b5.b
        public void r(CharSequence charSequence) {
            q.this.f21007m.setSubtitle(charSequence);
        }

        @Override // b5.b
        public void t(int i5) {
            u(q.this.f21000f.getResources().getString(i5));
        }

        @Override // b5.b
        public void u(CharSequence charSequence) {
            q.this.f21007m.setTitle(charSequence);
        }

        @Override // b5.b
        public void v(boolean z5) {
            super.v(z5);
            q.this.f21007m.setTitleOptional(z5);
        }

        public boolean w() {
            this.f21028f.b0();
            try {
                return this.f21029g.d(this, this.f21028f);
            } finally {
                this.f21028f.a0();
            }
        }

        public boolean x() {
            return this.f21033k;
        }

        public void y(boolean z5) {
            this.f21032j = z5;
        }
    }

    public class h extends a.i {

        /* renamed from: a, reason: collision with root package name */
        private a.j f21036a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f21037b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f21038c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f21039d;

        /* renamed from: e, reason: collision with root package name */
        private ColorStateList f21040e;

        /* renamed from: f, reason: collision with root package name */
        private ColorStateList f21041f;

        /* renamed from: h, reason: collision with root package name */
        private View f21043h;

        /* renamed from: g, reason: collision with root package name */
        private int f21042g = -1;

        /* renamed from: i, reason: collision with root package name */
        private boolean f21044i = true;

        /* renamed from: j, reason: collision with root package name */
        private int f21045j = -1;

        /* renamed from: k, reason: collision with root package name */
        private int f21046k = -1;

        /* renamed from: l, reason: collision with root package name */
        private int f21047l = -1;

        public h() {
        }

        @Override // stepos.support.v7.app.a.i
        public ColorStateList a() {
            ColorStateList colorStateList = this.f21041f;
            if (colorStateList != null) {
                return colorStateList;
            }
            return null;
        }

        @Override // stepos.support.v7.app.a.i
        public CharSequence b() {
            return this.f21039d;
        }

        @Override // stepos.support.v7.app.a.i
        public View c() {
            return this.f21043h;
        }

        @Override // stepos.support.v7.app.a.i
        public Drawable d() {
            return this.f21037b;
        }

        @Override // stepos.support.v7.app.a.i
        public int e() {
            return this.f21047l;
        }

        @Override // stepos.support.v7.app.a.i
        public int f() {
            return this.f21046k;
        }

        @Override // stepos.support.v7.app.a.i
        public int g() {
            return this.f21045j;
        }

        @Override // stepos.support.v7.app.a.i
        public int h() {
            return this.f21042g;
        }

        @Override // stepos.support.v7.app.a.i
        public CharSequence i() {
            return this.f21038c;
        }

        @Override // stepos.support.v7.app.a.i
        public ColorStateList j() {
            ColorStateList colorStateList = this.f21040e;
            if (colorStateList != null) {
                return colorStateList;
            }
            return null;
        }

        @Override // stepos.support.v7.app.a.i
        public boolean k() {
            return this.f21044i;
        }

        @Override // stepos.support.v7.app.a.i
        public void l() {
            m(false);
        }

        @Override // stepos.support.v7.app.a.i
        public void m(boolean z5) {
            q.this.z0(this, z5);
        }

        @Override // stepos.support.v7.app.a.i
        public a.i n(ColorStateList colorStateList) {
            this.f21041f = colorStateList;
            if (this.f21042g >= 0) {
                q.this.f21010p.M(this.f21042g);
            }
            return this;
        }

        @Override // stepos.support.v7.app.a.i
        public void o(int i5) {
            if (this.f21047l != i5) {
                this.f21047l = i5;
                if (this.f21042g >= 0) {
                    q.this.f21010p.M(this.f21042g);
                }
            }
        }

        @Override // stepos.support.v7.app.a.i
        public void p(int i5, int i6) {
            if (this.f21045j == i5 && this.f21046k == i6) {
                return;
            }
            this.f21045j = i5;
            this.f21046k = i6;
            if (this.f21042g >= 0) {
                q.this.f21010p.M(this.f21042g);
            }
        }

        @Override // stepos.support.v7.app.a.i
        public a.i q(a.j jVar) {
            this.f21036a = jVar;
            return this;
        }

        @Override // stepos.support.v7.app.a.i
        public a.i r(int i5) {
            return w(q.this.f21000f.getResources().getText(i5));
        }

        @Override // stepos.support.v7.app.a.i
        public a.i s(ColorStateList colorStateList) {
            this.f21040e = colorStateList;
            if (this.f21042g >= 0) {
                q.this.f21010p.M(this.f21042g);
            }
            return this;
        }

        public a.j t() {
            return this.f21036a;
        }

        public a.k u() {
            return null;
        }

        public void v(int i5) {
            this.f21042g = i5;
        }

        public a.i w(CharSequence charSequence) {
            this.f21038c = charSequence;
            if (this.f21042g >= 0) {
                q.this.f21010p.M(this.f21042g);
            }
            return this;
        }
    }

    public q(Activity activity) {
        this.f21002h = activity;
        y0(activity.getWindow().getDecorView());
    }

    private void C0(boolean z5) {
        this.f21020z = z5;
        if (z5) {
            this.f21004j.P(this.f21010p);
        } else {
            this.f21004j.P(null);
        }
        boolean z6 = v0() == 2;
        stepos.support.v7.widget.v vVar = this.f21010p;
        if (vVar != null) {
            if (z6) {
                vVar.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
                if (actionBarCoordinatorLayout != null) {
                    H.g0(actionBarCoordinatorLayout);
                }
            } else {
                vVar.setVisibility(8);
            }
        }
        this.f21004j.t(!this.f21020z && z6);
    }

    private void E0(a.i iVar) {
        iVar.o(this.f20999Z);
        iVar.p(this.f20997X, this.f20998Y);
    }

    private void F0() {
        if (this.f20978E) {
            return;
        }
        this.f20978E = true;
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
        if (actionBarCoordinatorLayout != null) {
            actionBarCoordinatorLayout.setShowingForActionMode(true);
        }
        G0(false);
    }

    private void G0(boolean z5) {
        if (n0(this.f20976C, this.f20977D, this.f20978E)) {
            if (this.f20979F) {
                return;
            }
            this.f20979F = true;
            r0(z5);
            return;
        }
        if (this.f20979F) {
            this.f20979F = false;
            q0(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n0(boolean z5, boolean z6, boolean z7) {
        if (z7) {
            return true;
        }
        return (z5 || z6) ? false : true;
    }

    private void p0(a.i iVar, int i5) {
        h hVar = (h) iVar;
        a.j jVarT = hVar.t();
        hVar.u();
        if (jVarT == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        hVar.v(i5);
        this.f21011q.add(i5, hVar);
        int size = this.f21011q.size();
        while (true) {
            i5++;
            if (i5 >= size) {
                return;
            } else {
                this.f21011q.get(i5).v(i5);
            }
        }
    }

    private void s0() {
        if (this.f21010p != null) {
            return;
        }
        stepos.support.v7.widget.v vVar = new stepos.support.v7.widget.v(this.f21000f);
        vVar.setId(X4.f.f5967O);
        vVar.setVisibility(0);
        this.f21004j.P(vVar);
        this.f21010p = vVar;
        vVar.setVisibility(0);
        if (v0() == 2) {
            vVar.setVisibility(0);
        } else {
            vVar.setVisibility(8);
        }
        if (this.f20984K) {
            vVar.setTabsGravity(this.f20983J);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private stepos.support.v7.widget.m t0(View view) {
        if (view instanceof stepos.support.v7.widget.m) {
            return (stepos.support.v7.widget.m) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void x0() {
        if (this.f20978E) {
            this.f20978E = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
            if (actionBarCoordinatorLayout != null) {
                actionBarCoordinatorLayout.setShowingForActionMode(false);
            }
            G0(false);
        }
    }

    private void y0(View view) {
        this.f21003i = (ActionBarCoordinatorLayout) view.findViewById(X4.f.f6021v);
        this.f21007m = (ActionBarContextView) view.findViewById(X4.f.f5991g);
        this.f21006l = (StepOSCollapsingToolbarLayout) view.findViewById(X4.f.f5981b);
        this.f21005k = (StepOSAppBarLayout) view.findViewById(X4.f.f6003m);
        this.f20987N = (FrameLayout) view.findViewById(X4.f.f5983c);
        this.f20988O = (FrameLayout) view.findViewById(X4.f.f5985d);
        this.f21008n = (ActionBarContainer) view.findViewById(X4.f.f5966N);
        stepos.support.v7.widget.h hVarT = this.f21006l.t(t0(view.findViewById(X4.f.f5979a)));
        this.f21004j = hVarT;
        if (hVarT == null || this.f21007m == null || this.f21006l == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        hVarT.D(new f());
        this.f21000f = this.f21004j.getContext();
        int iP = this.f21004j.p();
        boolean z5 = (iP & 4) != 0;
        if (z5) {
            this.f21014t = true;
        }
        K(b5.a.b(this.f21000f).a() || z5);
        boolean z6 = (iP & 32) != 0;
        this.f20982I = z6;
        if ((iP & 8) != 0 && z6) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        C0(z6);
        TypedArray typedArrayObtainStyledAttributes = this.f21000f.obtainStyledAttributes(null, g.j.f17094a, N1.a.c() ? X4.a.f5832h : C0728a.f16826c, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17134i, 0);
        if (dimensionPixelSize != 0) {
            B0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f20986M = s();
    }

    public void A0(int i5, int i6) {
        int iP = this.f21004j.p();
        if ((i6 & 4) != 0) {
            this.f21014t = true;
        }
        this.f21004j.j((i5 & i6) | ((~i6) & iP));
    }

    @Override // stepos.support.v7.app.a
    public void B(View view) {
        this.f21004j.O(view);
    }

    public void B0(float f5) {
        H.r0(this.f21005k, f5);
        ActionBarContainer actionBarContainer = this.f21008n;
        if (actionBarContainer != null) {
            H.r0(actionBarContainer, f5);
        }
    }

    @Override // stepos.support.v7.app.a
    public void C(View view, a.e eVar) {
        view.setLayoutParams(eVar);
        this.f21004j.O(view);
    }

    @Override // stepos.support.v7.app.a
    public void D(boolean z5) {
        if (this.f21014t) {
            return;
        }
        E(z5);
    }

    public void D0(int i5) {
        int iL = this.f21004j.l();
        if (iL == 1) {
            this.f21004j.F(i5);
        } else {
            if (iL != 2) {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            x(this.f21011q.get(i5));
        }
    }

    @Override // stepos.support.v7.app.a
    public void E(boolean z5) {
        A0(z5 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public void F(boolean z5) {
        A0(z5 ? 64 : 0, 64);
        if (z5) {
            return;
        }
        g();
    }

    @Override // stepos.support.v7.app.a
    public void G(boolean z5) {
        A0(z5 ? 16 : 0, 16);
    }

    @Override // stepos.support.v7.app.a
    public void H(boolean z5) {
        A0(z5 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void I(boolean z5) {
        if ((this.f21004j.p() & 8) != 0 && z5) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        this.f20982I = z5;
        C0(z5);
    }

    @Override // stepos.support.v7.app.a
    public void J(boolean z5) {
        if (this.f20982I && z5) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        A0(z5 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void K(boolean z5) {
        this.f21004j.o(z5);
    }

    @Override // stepos.support.v7.app.a
    public void L(int i5) {
        ActionBarCoordinatorLayout actionBarCoordinatorLayout;
        int iL = this.f21004j.l();
        if (iL == 2) {
            this.f21013s = w0();
            x(null);
            this.f21010p.setVisibility(8);
        }
        if (iL != i5 && !this.f21020z && (actionBarCoordinatorLayout = this.f21003i) != null) {
            H.g0(actionBarCoordinatorLayout);
        }
        this.f21004j.J(i5);
        boolean z5 = false;
        if (i5 == 2) {
            s0();
            this.f21010p.setVisibility(0);
            int i6 = this.f21013s;
            if (i6 != -1) {
                D0(i6);
                this.f21013s = -1;
            }
        }
        stepos.support.v7.widget.m mVar = this.f21004j;
        if (i5 == 2 && !this.f21020z) {
            z5 = true;
        }
        mVar.t(z5);
    }

    @Override // stepos.support.v7.app.a
    public void M(boolean z5) {
        androidx.appcompat.view.h hVar;
        this.f20981H = z5;
        if (z5 || (hVar = this.f20980G) == null) {
            return;
        }
        hVar.a();
    }

    @Override // stepos.support.v7.app.a
    public void N(Drawable drawable) {
        this.f21005k.setStackedBackground(drawable);
    }

    @Override // stepos.support.v7.app.a
    public void O(int i5, float f5, int i6) {
        stepos.support.v7.widget.v vVar = this.f21010p;
        if (vVar != null) {
            vVar.J(i5, f5, true);
        }
    }

    @Override // stepos.support.v7.app.a
    public void P(int i5) {
        Q(this.f21000f.getString(i5));
    }

    @Override // stepos.support.v7.app.a
    public void Q(CharSequence charSequence) {
        this.f21004j.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void R(int i5) {
        this.f21003i.setUiOptions(i5);
    }

    @Override // stepos.support.v7.app.a
    public void S(CharSequence charSequence) {
        this.f21004j.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public b5.b T(b.InterfaceC0154b interfaceC0154b) {
        g gVar = this.f21015u;
        if (gVar != null) {
            gVar.a();
        }
        this.f21007m.s();
        g gVar2 = new g(this.f21007m.getContext(), interfaceC0154b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f21007m.n(gVar2);
        l0(true);
        ActionBarContainer actionBarContainer = this.f21008n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f21008n.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
            if (actionBarCoordinatorLayout != null) {
                H.g0(actionBarCoordinatorLayout);
            }
        }
        this.f21007m.sendAccessibilityEvent(32);
        this.f21015u = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.app.a
    public b5.b U(b.InterfaceC0154b interfaceC0154b) {
        g gVar = this.f21015u;
        if (gVar != null) {
            gVar.a();
        }
        this.f21007m.s();
        g gVar2 = new g(this.f21007m.getContext(), interfaceC0154b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f21007m.setSplitView(this.f21008n);
        this.f21007m.o(gVar2);
        this.f21006l.u();
        m0(true, gVar2);
        ActionBarContainer actionBarContainer = this.f21008n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f21008n.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
            if (actionBarCoordinatorLayout != null) {
                H.g0(actionBarCoordinatorLayout);
            }
        }
        this.f21007m.sendAccessibilityEvent(32);
        gVar2.y(true);
        this.f21015u = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.app.a
    public void f(a.i iVar) {
        k0(iVar, this.f21011q.isEmpty());
    }

    @Override // stepos.support.v7.app.a
    public boolean h() {
        stepos.support.v7.widget.m mVar = this.f21004j;
        if (mVar == null || !mVar.i()) {
            return false;
        }
        this.f21004j.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public void k(boolean z5) {
        if (z5 == this.f21018x) {
            return;
        }
        this.f21018x = z5;
        int size = this.f21019y.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f21019y.get(i5).a(z5);
        }
    }

    public void k0(a.i iVar, boolean z5) {
        s0();
        E0(iVar);
        this.f21010p.v(iVar, z5);
        p0(iVar, this.f21011q.size());
        if (z5) {
            x(iVar);
        }
    }

    @Override // stepos.support.v7.app.a
    public View l() {
        return this.f21004j.w();
    }

    public void l0(boolean z5) {
        m0(z5, null);
    }

    @Override // stepos.support.v7.app.a
    public int m() {
        return this.f21004j.p();
    }

    public void m0(boolean z5, g gVar) {
        if (gVar != null ? gVar.x() : z5) {
            F0();
        } else {
            x0();
        }
        (z5 ? this.f21004j.m(4, 100L) : this.f21004j.m(0, 200L)).n();
        this.f21007m.k(z5, gVar);
    }

    @Override // stepos.support.v7.app.a
    public a.i n(int i5) {
        return this.f21011q.get(i5);
    }

    @Override // stepos.support.v7.app.a
    public Context o() {
        if (this.f21001g == null) {
            TypedValue typedValue = new TypedValue();
            this.f21000f.getTheme().resolveAttribute(C0728a.f16831h, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f21001g = new ContextThemeWrapper(this.f21000f, i5);
            } else {
                this.f21001g = this.f21000f;
            }
        }
        return this.f21001g;
    }

    void o0() {
        b.InterfaceC0154b interfaceC0154b = this.f21017w;
        if (interfaceC0154b != null) {
            interfaceC0154b.c(this.f21016v);
            this.f21016v = null;
            this.f21017w = null;
        }
    }

    @Override // stepos.support.v7.app.a
    public stepos.support.v7.widget.m p() {
        return this.f21004j;
    }

    @Override // stepos.support.v7.app.a
    public void q() {
        if (this.f20976C) {
            return;
        }
        this.f20976C = true;
        G0(false);
    }

    public void q0(boolean z5) {
        View view;
        androidx.appcompat.view.h hVar = this.f20980G;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f20974A != 0 || !f20973a0 || (!this.f20981H && !z5)) {
            this.f20991R.d(null);
            return;
        }
        H.n0(this.f21005k, 1.0f);
        this.f21005k.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f5 = -this.f21005k.getHeight();
        if (z5) {
            this.f21005k.getLocationInWindow(new int[]{0, 0});
            f5 -= r6[1];
        }
        S sP = H.d(this.f21005k).p(f5);
        sP.m(this.f20993T);
        hVar2.c(sP);
        if (this.f20975B && (view = this.f21009o) != null) {
            hVar2.c(H.d(view).p(f5));
        }
        ActionBarContainer actionBarContainer = this.f21008n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.f20986M) {
            H.n0(this.f21008n, 1.0f);
            hVar2.c(H.d(this.f21008n).p(this.f21008n.getHeight()));
        }
        hVar2.f(androidx.core.view.animation.a.a(0.29f, 0.5f, 0.16f, 1.0f));
        hVar2.e(this.f20994U);
        hVar2.g(this.f20991R);
        this.f20980G = hVar2;
        hVar2.h();
    }

    public void r0(boolean z5) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f20980G;
        if (hVar != null) {
            hVar.a();
        }
        this.f21005k.setVisibility(0);
        if (this.f20974A == 0 && f20973a0 && (this.f20981H || z5)) {
            H.F0(this.f21005k, 0.0f);
            float f5 = -this.f21005k.getHeight();
            if (z5) {
                this.f21005k.getLocationInWindow(new int[]{0, 0});
                f5 -= r7[1];
            }
            H.F0(this.f21005k, f5);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            S sP = H.d(this.f21005k).p(0.0f);
            sP.m(this.f20993T);
            hVar2.c(sP);
            if (this.f20975B && (view2 = this.f21009o) != null) {
                H.F0(view2, f5);
                hVar2.c(H.d(this.f21009o).p(0.0f));
            }
            ActionBarContainer actionBarContainer = this.f21008n;
            if (actionBarContainer != null && !this.f20986M) {
                actionBarContainer.setVisibility(0);
                H.F0(this.f21008n, r0.getMeasuredHeight());
                hVar2.c(H.d(this.f21008n).p(0.0f));
            }
            hVar2.f(androidx.core.view.animation.a.a(0.2f, 0.5f, 0.05f, 1.0f));
            hVar2.e(this.f20994U);
            hVar2.g(this.f20992S);
            this.f20980G = hVar2;
            hVar2.h();
        } else {
            H.n0(this.f21005k, 1.0f);
            H.F0(this.f21005k, 0.0f);
            if (this.f20975B && (view = this.f21009o) != null) {
                H.F0(view, 0.0f);
            }
            ActionBarContainer actionBarContainer2 = this.f21008n;
            if (actionBarContainer2 != null) {
                H.n0(actionBarContainer2, 1.0f);
                H.F0(this.f21008n, 0.0f);
                this.f21008n.setVisibility(0);
            }
            this.f20992S.d(null);
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f21003i;
        if (actionBarCoordinatorLayout != null) {
            H.g0(actionBarCoordinatorLayout);
        }
    }

    @Override // stepos.support.v7.app.a
    public boolean s() {
        return this.f20979F && u0() == 0;
    }

    @Override // stepos.support.v7.app.a
    public a.i t() {
        return new h();
    }

    @Override // stepos.support.v7.app.a
    public void u(Configuration configuration) {
        C0(this.f20982I);
    }

    public int u0() {
        return this.f21006l.getHeight();
    }

    public int v0() {
        return this.f21004j.l();
    }

    public int w0() {
        h hVar;
        int iL = this.f21004j.l();
        if (iL == 1) {
            return this.f21004j.N();
        }
        if (iL == 2 && (hVar = this.f21012r) != null) {
            return hVar.h();
        }
        return -1;
    }

    @Override // stepos.support.v7.app.a
    public void x(a.i iVar) {
        z0(iVar, false);
    }

    @Override // stepos.support.v7.app.a
    public void y(Drawable drawable) {
        this.f21005k.setPrimaryBackground(drawable);
    }

    public void z0(a.i iVar, boolean z5) {
        if (v0() != 2) {
            this.f21013s = iVar != null ? iVar.h() : -1;
            return;
        }
        G gN = (!(this.f21002h instanceof ActivityC0516k) || this.f21004j.K().isInEditMode()) ? null : ((ActivityC0516k) this.f21002h).getSupportFragmentManager().m().n();
        if (!this.f21004j.K().isInEditMode()) {
            this.f21002h.getFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        h hVar = this.f21012r;
        if (hVar != iVar) {
            this.f21010p.K(iVar != null ? iVar.h() : -1, z5);
            h hVar2 = this.f21012r;
            if (hVar2 != null) {
                if (hVar2.t() != null) {
                    this.f21012r.t().l(this.f21012r, gN);
                } else {
                    this.f21012r.u();
                }
            }
            h hVar3 = (h) iVar;
            this.f21012r = hVar3;
            if (hVar3 != null) {
                if (hVar3.t() != null) {
                    this.f21012r.t().d(this.f21012r, gN);
                } else {
                    this.f21012r.u();
                }
            }
        } else if (hVar != null) {
            if (hVar.t() != null) {
                this.f21012r.t().c(this.f21012r, gN);
            } else {
                this.f21012r.u();
            }
            if (z5) {
                this.f21010p.w(iVar.h());
            }
        }
        if (gN == null || gN.q()) {
            return;
        }
        gN.i();
    }
}
