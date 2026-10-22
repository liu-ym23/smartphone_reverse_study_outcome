package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
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
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.w;

/* loaded from: classes.dex */
public class v extends stepos.support.v7.app.a implements ActionBarOverlayLayout.f {

    /* renamed from: a0, reason: collision with root package name */
    private static final Interpolator f21115a0 = new AccelerateInterpolator();

    /* renamed from: b0, reason: collision with root package name */
    private static final Interpolator f21116b0 = new DecelerateInterpolator();

    /* renamed from: c0, reason: collision with root package name */
    private static final boolean f21117c0 = true;

    /* renamed from: C, reason: collision with root package name */
    private boolean f21120C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f21121D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f21122E;

    /* renamed from: G, reason: collision with root package name */
    private androidx.appcompat.view.h f21124G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f21125H;

    /* renamed from: I, reason: collision with root package name */
    boolean f21126I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f21127J;

    /* renamed from: K, reason: collision with root package name */
    private int f21128K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f21129L;

    /* renamed from: N, reason: collision with root package name */
    private boolean f21131N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f21132O;

    /* renamed from: f, reason: collision with root package name */
    private Context f21144f;

    /* renamed from: g, reason: collision with root package name */
    private Context f21145g;

    /* renamed from: h, reason: collision with root package name */
    private Activity f21146h;

    /* renamed from: i, reason: collision with root package name */
    private Dialog f21147i;

    /* renamed from: j, reason: collision with root package name */
    private ActionBarOverlayLayout f21148j;

    /* renamed from: k, reason: collision with root package name */
    private ActionBarContainer f21149k;

    /* renamed from: l, reason: collision with root package name */
    private stepos.support.v7.widget.m f21150l;

    /* renamed from: m, reason: collision with root package name */
    private ActionBarContextView f21151m;

    /* renamed from: n, reason: collision with root package name */
    private ActionBarContainer f21152n;

    /* renamed from: o, reason: collision with root package name */
    private FitsWindowsContentLayout f21153o;

    /* renamed from: p, reason: collision with root package name */
    private stepos.support.v7.widget.v f21154p;

    /* renamed from: r, reason: collision with root package name */
    private h f21156r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21158t;

    /* renamed from: u, reason: collision with root package name */
    g f21159u;

    /* renamed from: v, reason: collision with root package name */
    b5.b f21160v;

    /* renamed from: w, reason: collision with root package name */
    b.InterfaceC0154b f21161w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f21162x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f21164z;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<h> f21155q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private int f21157s = -1;

    /* renamed from: y, reason: collision with root package name */
    private ArrayList<a.f> f21163y = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    private int f21118A = 0;

    /* renamed from: B, reason: collision with root package name */
    private boolean f21119B = true;

    /* renamed from: F, reason: collision with root package name */
    private boolean f21123F = true;

    /* renamed from: M, reason: collision with root package name */
    private boolean f21130M = true;

    /* renamed from: P, reason: collision with root package name */
    final T f21133P = new a();

    /* renamed from: Q, reason: collision with root package name */
    final T f21134Q = new b();

    /* renamed from: R, reason: collision with root package name */
    final T f21135R = new c();

    /* renamed from: S, reason: collision with root package name */
    final T f21136S = new d();

    /* renamed from: T, reason: collision with root package name */
    final V f21137T = new e();

    /* renamed from: U, reason: collision with root package name */
    private int f21138U = 288;

    /* renamed from: V, reason: collision with root package name */
    private boolean f21139V = false;

    /* renamed from: W, reason: collision with root package name */
    private boolean f21140W = false;

    /* renamed from: X, reason: collision with root package name */
    private int f21141X = -1;

    /* renamed from: Y, reason: collision with root package name */
    private int f21142Y = -1;

    /* renamed from: Z, reason: collision with root package name */
    private int f21143Z = -1;

    class a extends U {
        a() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (v.this.f21152n != null) {
                v.this.f21152n.setVisibility(8);
            }
            v.this.f21131N = false;
            v.this.f21124G = null;
        }
    }

    class b extends U {
        b() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (v.this.f21152n != null) {
                H.F0(v.this.f21152n, 0.0f);
                v.this.f21131N = true;
            }
            v.this.f21124G = null;
        }
    }

    class c extends U {
        c() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (v.this.f21119B && v.this.f21153o != null) {
                H.F0(v.this.f21153o, 0.0f);
                H.F0(v.this.f21149k, 0.0f);
            }
            if (v.this.f21152n != null) {
                v.this.f21152n.setVisibility(8);
            }
            v.this.f21149k.setVisibility(8);
            v.this.f21149k.setTransitioning(false);
            v.this.f21124G = null;
            v.this.f21131N = false;
            v.this.n0();
            if (v.this.f21148j != null) {
                H.g0(v.this.f21148j);
            }
        }
    }

    class d extends U {
        d() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            v.this.f21124G = null;
            v.this.f21131N = true;
            H.F0(v.this.f21149k, 0.0f);
            if (v.this.f21152n != null) {
                H.F0(v.this.f21152n, 0.0f);
            }
            v.this.f21149k.requestLayout();
        }
    }

    class e implements V {
        e() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            ((View) v.this.f21149k.getParent()).invalidate();
        }
    }

    class f implements a.c {
        f() {
        }

        @Override // stepos.support.v7.app.a.c
        public void a(int i5, a.InterfaceC0240a interfaceC0240a) {
            v.this.A(i5, interfaceC0240a);
        }
    }

    public class g extends b5.b implements d.a {

        /* renamed from: e, reason: collision with root package name */
        private final Context f21171e;

        /* renamed from: f, reason: collision with root package name */
        private final stepos.support.v7.view.menu.d f21172f;

        /* renamed from: g, reason: collision with root package name */
        private b.InterfaceC0154b f21173g;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<View> f21174h;

        /* renamed from: j, reason: collision with root package name */
        private boolean f21176j;

        /* renamed from: i, reason: collision with root package name */
        private b.a f21175i = new a();

        /* renamed from: k, reason: collision with root package name */
        private boolean f21177k = true;

        class a implements b.a {
            a() {
            }

            @Override // b5.b.a
            public boolean a() {
                return true;
            }
        }

        public g(Context context, b.InterfaceC0154b interfaceC0154b) {
            this.f21171e = context;
            this.f21173g = interfaceC0154b;
            stepos.support.v7.view.menu.d dVarR = new stepos.support.v7.view.menu.d(context).R(1);
            this.f21172f = dVarR;
            dVarR.Q(this);
            o(this.f21175i);
        }

        @Override // b5.b
        public void a() {
            v vVar = v.this;
            if (vVar.f21159u != this) {
                return;
            }
            if (v.m0(vVar.f21120C, v.this.f21121D, false) || !x()) {
                this.f21173g.c(this);
            } else {
                v vVar2 = v.this;
                vVar2.f21160v = this;
                vVar2.f21161w = this.f21173g;
            }
            this.f21173g = null;
            v.this.k0(false);
            v.this.f21151m.m();
            v.this.f21150l.K().sendAccessibilityEvent(32);
            v.this.f21148j.setHideOnContentScrollEnabled(v.this.f21126I);
            v.this.f21159u = null;
        }

        @Override // stepos.support.v7.view.menu.d.a
        public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
            b.InterfaceC0154b interfaceC0154b = this.f21173g;
            if (interfaceC0154b != null) {
                return interfaceC0154b.a(this, menuItem);
            }
            return false;
        }

        @Override // stepos.support.v7.view.menu.d.a
        public void d(stepos.support.v7.view.menu.d dVar) {
            if (this.f21173g == null) {
                return;
            }
            l();
            v.this.f21151m.u();
        }

        @Override // b5.b
        public View e() {
            WeakReference<View> weakReference = this.f21174h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // b5.b
        public Menu f() {
            return this.f21172f;
        }

        @Override // b5.b
        public MenuInflater g() {
            return new b5.k(this.f21171e);
        }

        @Override // b5.b
        public CharSequence h() {
            return v.this.f21151m.getSubtitle();
        }

        @Override // b5.b
        public CharSequence j() {
            return v.this.f21151m.getTitle();
        }

        @Override // b5.b
        public void l() {
            if (v.this.f21159u != this) {
                return;
            }
            this.f21172f.b0();
            try {
                this.f21173g.b(this, this.f21172f);
            } finally {
                this.f21172f.a0();
            }
        }

        @Override // b5.b
        public boolean n() {
            return v.this.f21151m.r();
        }

        @Override // b5.b
        public void p(View view) {
            v.this.f21151m.setCustomView(view);
            this.f21174h = new WeakReference<>(view);
        }

        @Override // b5.b
        public void q(int i5) {
            r(v.this.f21144f.getResources().getString(i5));
        }

        @Override // b5.b
        public void r(CharSequence charSequence) {
            v.this.f21151m.setSubtitle(charSequence);
        }

        @Override // b5.b
        public void t(int i5) {
            u(v.this.f21144f.getResources().getString(i5));
        }

        @Override // b5.b
        public void u(CharSequence charSequence) {
            v.this.f21151m.setTitle(charSequence);
        }

        @Override // b5.b
        public void v(boolean z5) {
            super.v(z5);
            v.this.f21151m.setTitleOptional(z5);
        }

        public boolean w() {
            this.f21172f.b0();
            try {
                return this.f21173g.d(this, this.f21172f);
            } finally {
                this.f21172f.a0();
            }
        }

        public boolean x() {
            return this.f21177k;
        }

        public void y(boolean z5) {
            this.f21176j = z5;
        }
    }

    public class h extends a.i {

        /* renamed from: a, reason: collision with root package name */
        private a.j f21180a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f21181b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f21182c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f21183d;

        /* renamed from: e, reason: collision with root package name */
        private ColorStateList f21184e;

        /* renamed from: f, reason: collision with root package name */
        private ColorStateList f21185f;

        /* renamed from: h, reason: collision with root package name */
        private View f21187h;

        /* renamed from: g, reason: collision with root package name */
        private int f21186g = -1;

        /* renamed from: i, reason: collision with root package name */
        private boolean f21188i = true;

        /* renamed from: j, reason: collision with root package name */
        private int f21189j = -1;

        /* renamed from: k, reason: collision with root package name */
        private int f21190k = -1;

        /* renamed from: l, reason: collision with root package name */
        private int f21191l = -1;

        public h() {
        }

        @Override // stepos.support.v7.app.a.i
        public ColorStateList a() {
            ColorStateList colorStateList = this.f21185f;
            if (colorStateList != null) {
                return colorStateList;
            }
            return null;
        }

        @Override // stepos.support.v7.app.a.i
        public CharSequence b() {
            return this.f21183d;
        }

        @Override // stepos.support.v7.app.a.i
        public View c() {
            return this.f21187h;
        }

        @Override // stepos.support.v7.app.a.i
        public Drawable d() {
            return this.f21181b;
        }

        @Override // stepos.support.v7.app.a.i
        public int e() {
            return this.f21191l;
        }

        @Override // stepos.support.v7.app.a.i
        public int f() {
            return this.f21190k;
        }

        @Override // stepos.support.v7.app.a.i
        public int g() {
            return this.f21189j;
        }

        @Override // stepos.support.v7.app.a.i
        public int h() {
            return this.f21186g;
        }

        @Override // stepos.support.v7.app.a.i
        public CharSequence i() {
            return this.f21182c;
        }

        @Override // stepos.support.v7.app.a.i
        public ColorStateList j() {
            ColorStateList colorStateList = this.f21184e;
            if (colorStateList != null) {
                return colorStateList;
            }
            return null;
        }

        @Override // stepos.support.v7.app.a.i
        public boolean k() {
            return this.f21188i;
        }

        @Override // stepos.support.v7.app.a.i
        public void l() {
            m(false);
        }

        @Override // stepos.support.v7.app.a.i
        public void m(boolean z5) {
            v.this.A0(this, z5);
        }

        @Override // stepos.support.v7.app.a.i
        public a.i n(ColorStateList colorStateList) {
            this.f21185f = colorStateList;
            if (this.f21186g >= 0) {
                v.this.f21154p.M(this.f21186g);
            }
            return this;
        }

        @Override // stepos.support.v7.app.a.i
        public void o(int i5) {
            if (this.f21191l != i5) {
                this.f21191l = i5;
                if (this.f21186g >= 0) {
                    v.this.f21154p.M(this.f21186g);
                }
            }
        }

        @Override // stepos.support.v7.app.a.i
        public void p(int i5, int i6) {
            if (this.f21189j == i5 && this.f21190k == i6) {
                return;
            }
            this.f21189j = i5;
            this.f21190k = i6;
            if (this.f21186g >= 0) {
                v.this.f21154p.M(this.f21186g);
            }
        }

        @Override // stepos.support.v7.app.a.i
        public a.i q(a.j jVar) {
            this.f21180a = jVar;
            return this;
        }

        @Override // stepos.support.v7.app.a.i
        public a.i r(int i5) {
            return w(v.this.f21144f.getResources().getText(i5));
        }

        @Override // stepos.support.v7.app.a.i
        public a.i s(ColorStateList colorStateList) {
            this.f21184e = colorStateList;
            if (this.f21186g >= 0) {
                v.this.f21154p.M(this.f21186g);
            }
            return this;
        }

        public a.j t() {
            return this.f21180a;
        }

        public a.k u() {
            return null;
        }

        public void v(int i5) {
            this.f21186g = i5;
        }

        public a.i w(CharSequence charSequence) {
            this.f21182c = charSequence;
            if (this.f21186g >= 0) {
                v.this.f21154p.M(this.f21186g);
            }
            return this;
        }
    }

    public v(Activity activity, boolean z5) {
        this.f21146h = activity;
        View decorView = activity.getWindow().getDecorView();
        z0(decorView);
        if (z5) {
            return;
        }
        this.f21153o = (FitsWindowsContentLayout) decorView.findViewById(R.id.content);
    }

    private void D0(boolean z5) {
        this.f21164z = z5;
        if (z5) {
            this.f21149k.setTabContainer(null);
            this.f21150l.P(this.f21154p);
        } else {
            this.f21150l.P(null);
            this.f21149k.setTabContainer(this.f21154p);
        }
        boolean z6 = w0() == 2;
        w wVarS0 = s0();
        if (wVarS0 != null) {
            if (z6) {
                wVarS0.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
                if (actionBarOverlayLayout != null) {
                    H.g0(actionBarOverlayLayout);
                }
            } else {
                wVarS0.setVisibility(8);
            }
        }
        this.f21150l.t(!this.f21164z && z6);
        this.f21148j.setHasNonEmbeddedTabs(!this.f21164z && z6);
    }

    private void G0(a.i iVar) {
        iVar.o(this.f21143Z);
        iVar.p(this.f21141X, this.f21142Y);
    }

    private void H0() {
        if (this.f21122E) {
            return;
        }
        this.f21122E = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        I0(false);
    }

    private void I0(boolean z5) {
        if (m0(this.f21120C, this.f21121D, this.f21122E)) {
            if (this.f21123F) {
                return;
            }
            this.f21123F = true;
            q0(z5);
            return;
        }
        if (this.f21123F) {
            this.f21123F = false;
            p0(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m0(boolean z5, boolean z6, boolean z7) {
        if (z7) {
            return true;
        }
        return (z5 || z6) ? false : true;
    }

    private void o0(a.i iVar, int i5) {
        h hVar = (h) iVar;
        a.j jVarT = hVar.t();
        hVar.u();
        if (jVarT == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        hVar.v(i5);
        this.f21155q.add(i5, hVar);
        int size = this.f21155q.size();
        while (true) {
            i5++;
            if (i5 >= size) {
                return;
            } else {
                this.f21155q.get(i5).v(i5);
            }
        }
    }

    private void r0() throws Resources.NotFoundException {
        if (this.f21154p != null) {
            return;
        }
        stepos.support.v7.widget.v vVar = new stepos.support.v7.widget.v(this.f21144f);
        vVar.setId(X4.f.f5967O);
        if (this.f21164z) {
            vVar.setVisibility(0);
            this.f21150l.P(vVar);
        } else {
            if (w0() == 2) {
                vVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
                if (actionBarOverlayLayout != null) {
                    H.g0(actionBarOverlayLayout);
                }
            } else {
                vVar.setVisibility(8);
            }
            this.f21149k.setCapsuleStyleEnable(this.f21132O);
            this.f21149k.setTabContainer(vVar);
        }
        this.f21154p = vVar;
        vVar.setVisibility(0);
        w wVarS0 = s0();
        if (wVarS0 != null) {
            if (w0() == 2) {
                wVarS0.setVisibility(0);
            } else {
                wVarS0.setVisibility(8);
            }
            if (this.f21129L) {
                wVarS0.setTabsGravity(this.f21128K);
            }
        }
        this.f21149k.setCapsuleStyleEnable(this.f21132O);
        this.f21154p.setCapsuleStyleEnable(this.f21132O);
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

    private void y0() {
        if (this.f21122E) {
            this.f21122E = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            I0(false);
        }
    }

    private void z0(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(X4.f.f6021v);
        this.f21148j = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f21150l = t0(view.findViewById(X4.f.f5979a));
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(X4.f.f5981b);
        this.f21149k = actionBarContainer;
        this.f21151m = (ActionBarContextView) actionBarContainer.findViewById(X4.f.f5991g);
        this.f21152n = (ActionBarContainer) view.findViewById(X4.f.f5966N);
        stepos.support.v7.widget.m mVar = this.f21150l;
        if (mVar == null || this.f21151m == null || this.f21149k == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        mVar.D(new f());
        this.f21144f = this.f21150l.getContext();
        int iP = this.f21150l.p();
        boolean z5 = (iP & 4) != 0;
        if (z5) {
            this.f21158t = true;
        }
        b5.a aVarB = b5.a.b(this.f21144f);
        K(aVarB.a() || z5);
        this.f21127J = (iP & 32) != 0;
        D0((this.f21130M && aVarB.i()) || this.f21127J);
        TypedArray typedArrayObtainStyledAttributes = this.f21144f.obtainStyledAttributes(null, g.j.f17094a, N1.a.c() ? X4.a.f5832h : C0728a.f16826c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17144k, false)) {
            E0(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17134i, 0);
        if (dimensionPixelSize != 0) {
            C0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f21131N = s();
    }

    public void A0(a.i iVar, boolean z5) {
        if (w0() != 2) {
            this.f21157s = iVar != null ? iVar.h() : -1;
            return;
        }
        G gN = (!(this.f21146h instanceof ActivityC0516k) || this.f21150l.K().isInEditMode()) ? null : ((ActivityC0516k) this.f21146h).getSupportFragmentManager().m().n();
        if (!this.f21150l.K().isInEditMode()) {
            this.f21146h.getFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        h hVar = this.f21156r;
        if (hVar != iVar) {
            this.f21154p.K(iVar != null ? iVar.h() : -1, z5);
            h hVar2 = this.f21156r;
            if (hVar2 != null) {
                if (hVar2.t() != null) {
                    this.f21156r.t().l(this.f21156r, gN);
                } else {
                    this.f21156r.u();
                }
            }
            h hVar3 = (h) iVar;
            this.f21156r = hVar3;
            if (hVar3 != null) {
                if (hVar3.t() != null) {
                    this.f21156r.t().d(this.f21156r, gN);
                } else {
                    this.f21156r.u();
                }
            }
        } else if (hVar != null) {
            if (hVar.t() != null) {
                this.f21156r.t().c(this.f21156r, gN);
            } else {
                this.f21156r.u();
            }
            if (z5) {
                this.f21154p.w(iVar.h());
            }
        }
        if (gN == null || gN.q()) {
            return;
        }
        gN.i();
    }

    @Override // stepos.support.v7.app.a
    public void B(View view) {
        this.f21150l.O(view);
    }

    public void B0(int i5, int i6) {
        int iP = this.f21150l.p();
        if ((i6 & 4) != 0) {
            this.f21158t = true;
        }
        this.f21150l.j((i5 & i6) | ((~i6) & iP));
    }

    @Override // stepos.support.v7.app.a
    public void C(View view, a.e eVar) {
        view.setLayoutParams(eVar);
        this.f21150l.O(view);
    }

    public void C0(float f5) {
        H.r0(this.f21149k, f5);
        ActionBarContainer actionBarContainer = this.f21152n;
        if (actionBarContainer != null) {
            H.r0(actionBarContainer, f5);
        }
    }

    @Override // stepos.support.v7.app.a
    public void D(boolean z5) {
        if (this.f21158t) {
            return;
        }
        E(z5);
    }

    @Override // stepos.support.v7.app.a
    public void E(boolean z5) {
        B0(z5 ? 4 : 0, 4);
    }

    public void E0(boolean z5) {
        if (z5 && !this.f21148j.C()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f21126I = z5;
        this.f21148j.setHideOnContentScrollEnabled(z5);
    }

    @Override // stepos.support.v7.app.a
    public void F(boolean z5) {
        B0(z5 ? 64 : 0, 64);
        if (z5) {
            return;
        }
        g();
    }

    public void F0(int i5) {
        int iL = this.f21150l.l();
        if (iL == 1) {
            this.f21150l.F(i5);
        } else {
            if (iL != 2) {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            x(this.f21155q.get(i5));
        }
    }

    @Override // stepos.support.v7.app.a
    public void G(boolean z5) {
        B0(z5 ? 16 : 0, 16);
    }

    @Override // stepos.support.v7.app.a
    public void H(boolean z5) {
        B0(z5 ? 2 : 0, 2);
    }

    @Override // stepos.support.v7.app.a
    public void I(boolean z5) {
        this.f21127J = z5;
        D0(z5);
    }

    @Override // stepos.support.v7.app.a
    public void J(boolean z5) {
        B0(z5 ? 8 : 0, 8);
    }

    @Override // stepos.support.v7.app.a
    public void K(boolean z5) {
        this.f21150l.o(z5);
    }

    @Override // stepos.support.v7.app.a
    public void L(int i5) throws Resources.NotFoundException {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int iL = this.f21150l.l();
        if (iL == 2) {
            this.f21157s = x0();
            x(null);
            s0().setVisibility(8);
        }
        if (iL != i5 && !this.f21164z && (actionBarOverlayLayout = this.f21148j) != null) {
            H.g0(actionBarOverlayLayout);
        }
        this.f21150l.J(i5);
        boolean z5 = false;
        if (i5 == 2) {
            r0();
            s0().setVisibility(0);
            int i6 = this.f21157s;
            if (i6 != -1) {
                F0(i6);
                this.f21157s = -1;
            }
        }
        this.f21150l.t(i5 == 2 && !this.f21164z);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f21148j;
        if (i5 == 2 && !this.f21164z) {
            z5 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z5);
    }

    @Override // stepos.support.v7.app.a
    public void M(boolean z5) {
        androidx.appcompat.view.h hVar;
        this.f21125H = z5;
        if (z5 || (hVar = this.f21124G) == null) {
            return;
        }
        hVar.a();
    }

    @Override // stepos.support.v7.app.a
    public void N(Drawable drawable) {
        this.f21149k.setStackedBackground(drawable);
    }

    @Override // stepos.support.v7.app.a
    public void O(int i5, float f5, int i6) {
        stepos.support.v7.widget.v vVar = this.f21154p;
        if (vVar != null) {
            vVar.J(i5, f5, true);
        }
    }

    @Override // stepos.support.v7.app.a
    public void P(int i5) {
        Q(this.f21144f.getString(i5));
    }

    @Override // stepos.support.v7.app.a
    public void Q(CharSequence charSequence) {
        this.f21150l.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public void R(int i5) {
        this.f21148j.setUiOptions(i5);
    }

    @Override // stepos.support.v7.app.a
    public void S(CharSequence charSequence) {
        this.f21150l.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public b5.b T(b.InterfaceC0154b interfaceC0154b) {
        g gVar = this.f21159u;
        if (gVar != null) {
            gVar.a();
        }
        this.f21148j.setHideOnContentScrollEnabled(false);
        this.f21151m.s();
        g gVar2 = new g(this.f21151m.getContext(), interfaceC0154b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f21151m.n(gVar2);
        k0(true);
        ActionBarContainer actionBarContainer = this.f21152n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f21152n.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
            if (actionBarOverlayLayout != null) {
                H.g0(actionBarOverlayLayout);
            }
        }
        this.f21151m.sendAccessibilityEvent(32);
        this.f21159u = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.app.a
    public b5.b U(b.InterfaceC0154b interfaceC0154b) {
        g gVar = this.f21159u;
        if (gVar != null) {
            gVar.a();
        }
        this.f21148j.setHideOnContentScrollEnabled(false);
        this.f21151m.s();
        g gVar2 = new g(this.f21151m.getContext(), interfaceC0154b);
        if (!gVar2.w()) {
            return null;
        }
        gVar2.l();
        this.f21151m.setSplitView(this.f21152n);
        this.f21151m.o(gVar2);
        l0(true, gVar2);
        ActionBarContainer actionBarContainer = this.f21152n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f21152n.setVisibility(0);
            ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
            if (actionBarOverlayLayout != null) {
                H.g0(actionBarOverlayLayout);
            }
        }
        this.f21151m.sendAccessibilityEvent(32);
        gVar2.y(true);
        this.f21159u = gVar2;
        return gVar2;
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void a() {
        if (this.f21121D) {
            this.f21121D = false;
            I0(true);
        }
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void b() {
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void c(boolean z5) {
        this.f21119B = z5;
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void d() {
        if (this.f21121D) {
            return;
        }
        this.f21121D = true;
        I0(true);
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void e() {
        androidx.appcompat.view.h hVar = this.f21124G;
        if (hVar != null) {
            hVar.a();
            this.f21124G = null;
        }
    }

    @Override // stepos.support.v7.app.a
    public void f(a.i iVar) throws Resources.NotFoundException {
        j0(iVar, this.f21155q.isEmpty());
    }

    @Override // stepos.support.v7.app.a
    public boolean h() {
        stepos.support.v7.widget.m mVar = this.f21150l;
        if (mVar == null || !mVar.i()) {
            return false;
        }
        this.f21150l.collapseActionView();
        return true;
    }

    public void j0(a.i iVar, boolean z5) throws Resources.NotFoundException {
        r0();
        G0(iVar);
        this.f21154p.v(iVar, z5);
        o0(iVar, this.f21155q.size());
        if (z5) {
            x(iVar);
        }
    }

    @Override // stepos.support.v7.app.a
    public void k(boolean z5) {
        if (z5 == this.f21162x) {
            return;
        }
        this.f21162x = z5;
        int size = this.f21163y.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f21163y.get(i5).a(z5);
        }
    }

    public void k0(boolean z5) {
        l0(z5, null);
    }

    @Override // stepos.support.v7.app.a
    public View l() {
        return this.f21150l.w();
    }

    public void l0(boolean z5, g gVar) {
        if (gVar != null ? gVar.x() : z5) {
            H0();
        } else {
            y0();
        }
        (z5 ? this.f21150l.m(4, 100L) : this.f21150l.m(0, 200L)).n();
        this.f21151m.k(z5, gVar);
    }

    @Override // stepos.support.v7.app.a
    public int m() {
        return this.f21150l.p();
    }

    @Override // stepos.support.v7.app.a
    public a.i n(int i5) {
        return this.f21155q.get(i5);
    }

    void n0() {
        b.InterfaceC0154b interfaceC0154b = this.f21161w;
        if (interfaceC0154b != null) {
            interfaceC0154b.c(this.f21160v);
            this.f21160v = null;
            this.f21161w = null;
        }
    }

    @Override // stepos.support.v7.app.a
    public Context o() {
        if (this.f21145g == null) {
            TypedValue typedValue = new TypedValue();
            this.f21144f.getTheme().resolveAttribute(C0728a.f16831h, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f21145g = new ContextThemeWrapper(this.f21144f, i5);
            } else {
                this.f21145g = this.f21144f;
            }
        }
        return this.f21145g;
    }

    @Override // stepos.support.v7.widget.ActionBarOverlayLayout.f
    public void onWindowVisibilityChanged(int i5) {
        this.f21118A = i5;
    }

    @Override // stepos.support.v7.app.a
    public stepos.support.v7.widget.m p() {
        return this.f21150l;
    }

    public void p0(boolean z5) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        androidx.appcompat.view.h hVar = this.f21124G;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f21118A != 0 || !f21117c0 || (!this.f21125H && !z5)) {
            this.f21135R.d(null);
            return;
        }
        H.n0(this.f21149k, 1.0f);
        this.f21149k.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f5 = -this.f21149k.getHeight();
        if (z5) {
            this.f21149k.getLocationInWindow(new int[]{0, 0});
            f5 -= r6[1];
        }
        S sP = H.d(this.f21149k).p(f5);
        sP.m(this.f21137T);
        hVar2.c(sP);
        if (this.f21119B && (fitsWindowsContentLayout = this.f21153o) != null) {
            hVar2.c(H.d(fitsWindowsContentLayout).p(f5));
        }
        ActionBarContainer actionBarContainer = this.f21152n;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.f21131N) {
            H.n0(this.f21152n, 1.0f);
            hVar2.c(H.d(this.f21152n).p(this.f21152n.getHeight()));
        }
        hVar2.f(androidx.core.view.animation.a.a(0.29f, 0.5f, 0.16f, 1.0f));
        hVar2.e(this.f21138U);
        hVar2.g(this.f21135R);
        this.f21124G = hVar2;
        hVar2.h();
    }

    @Override // stepos.support.v7.app.a
    public void q() {
        if (this.f21120C) {
            return;
        }
        this.f21120C = true;
        I0(false);
    }

    public void q0(boolean z5) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        FitsWindowsContentLayout fitsWindowsContentLayout2;
        androidx.appcompat.view.h hVar = this.f21124G;
        if (hVar != null) {
            hVar.a();
        }
        this.f21149k.setVisibility(0);
        if (this.f21118A == 0 && f21117c0 && (this.f21125H || z5)) {
            H.F0(this.f21149k, 0.0f);
            float f5 = -this.f21149k.getHeight();
            if (z5) {
                this.f21149k.getLocationInWindow(new int[]{0, 0});
                f5 -= r7[1];
            }
            H.F0(this.f21149k, f5);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            S sP = H.d(this.f21149k).p(0.0f);
            sP.m(this.f21137T);
            hVar2.c(sP);
            if (this.f21119B && (fitsWindowsContentLayout2 = this.f21153o) != null) {
                H.F0(fitsWindowsContentLayout2, f5);
                hVar2.c(H.d(this.f21153o).p(0.0f));
            }
            ActionBarContainer actionBarContainer = this.f21152n;
            if (actionBarContainer != null && !this.f21131N) {
                actionBarContainer.setVisibility(0);
                H.F0(this.f21152n, r0.getMeasuredHeight());
                hVar2.c(H.d(this.f21152n).p(0.0f));
            }
            hVar2.f(androidx.core.view.animation.a.a(0.2f, 0.5f, 0.05f, 1.0f));
            hVar2.e(this.f21138U);
            hVar2.g(this.f21136S);
            this.f21124G = hVar2;
            hVar2.h();
        } else {
            H.n0(this.f21149k, 1.0f);
            H.F0(this.f21149k, 0.0f);
            if (this.f21119B && (fitsWindowsContentLayout = this.f21153o) != null) {
                H.F0(fitsWindowsContentLayout, 0.0f);
            }
            ActionBarContainer actionBarContainer2 = this.f21152n;
            if (actionBarContainer2 != null) {
                H.n0(actionBarContainer2, 1.0f);
                H.F0(this.f21152n, 0.0f);
                this.f21152n.setVisibility(0);
            }
            this.f21136S.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f21148j;
        if (actionBarOverlayLayout != null) {
            H.g0(actionBarOverlayLayout);
        }
    }

    @Override // stepos.support.v7.app.a
    public boolean s() {
        int iU0 = u0();
        if (this.f21123F) {
            return iU0 == 0 || v0() < iU0;
        }
        return false;
    }

    public w s0() {
        return !this.f21164z ? this.f21149k.getTabContainer() : this.f21150l.M();
    }

    @Override // stepos.support.v7.app.a
    public a.i t() {
        return new h();
    }

    @Override // stepos.support.v7.app.a
    public void u(Configuration configuration) {
        D0((this.f21130M && b5.a.b(this.f21144f).i()) || this.f21127J);
    }

    public int u0() {
        return this.f21149k.getHeight();
    }

    public int v0() {
        return this.f21148j.getActionBarHideOffset();
    }

    public int w0() {
        return this.f21150l.l();
    }

    @Override // stepos.support.v7.app.a
    public void x(a.i iVar) {
        A0(iVar, false);
    }

    public int x0() {
        h hVar;
        int iL = this.f21150l.l();
        if (iL == 1) {
            return this.f21150l.N();
        }
        if (iL == 2 && (hVar = this.f21156r) != null) {
            return hVar.h();
        }
        return -1;
    }

    @Override // stepos.support.v7.app.a
    public void y(Drawable drawable) {
        this.f21149k.setPrimaryBackground(drawable);
    }

    @Override // stepos.support.v7.app.a
    public void z(boolean z5) {
        this.f21132O = z5;
    }

    public v(Dialog dialog) {
        this.f21147i = dialog;
        z0(dialog.getWindow().getDecorView());
    }
}
