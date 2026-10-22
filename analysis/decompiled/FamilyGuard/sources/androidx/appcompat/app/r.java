package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.H;
import androidx.appcompat.widget.T;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.S;
import androidx.core.view.U;
import androidx.core.view.V;
import g.C0728a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class r extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    /* renamed from: E, reason: collision with root package name */
    private static final Interpolator f7666E = new AccelerateInterpolator();

    /* renamed from: F, reason: collision with root package name */
    private static final Interpolator f7667F = new DecelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    boolean f7668A;

    /* renamed from: a, reason: collision with root package name */
    Context f7672a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7673b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f7674c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f7675d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f7676e;

    /* renamed from: f, reason: collision with root package name */
    H f7677f;

    /* renamed from: g, reason: collision with root package name */
    ActionBarContextView f7678g;

    /* renamed from: h, reason: collision with root package name */
    View f7679h;

    /* renamed from: i, reason: collision with root package name */
    T f7680i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7683l;

    /* renamed from: m, reason: collision with root package name */
    d f7684m;

    /* renamed from: n, reason: collision with root package name */
    androidx.appcompat.view.b f7685n;

    /* renamed from: o, reason: collision with root package name */
    b.a f7686o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7687p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7689r;

    /* renamed from: u, reason: collision with root package name */
    boolean f7692u;

    /* renamed from: v, reason: collision with root package name */
    boolean f7693v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7694w;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.h f7696y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7697z;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<Object> f7681j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private int f7682k = -1;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<a.b> f7688q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private int f7690s = 0;

    /* renamed from: t, reason: collision with root package name */
    boolean f7691t = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7695x = true;

    /* renamed from: B, reason: collision with root package name */
    final androidx.core.view.T f7669B = new a();

    /* renamed from: C, reason: collision with root package name */
    final androidx.core.view.T f7670C = new b();

    /* renamed from: D, reason: collision with root package name */
    final V f7671D = new c();

    class a extends U {
        a() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            View view2;
            r rVar = r.this;
            if (rVar.f7691t && (view2 = rVar.f7679h) != null) {
                view2.setTranslationY(0.0f);
                r.this.f7676e.setTranslationY(0.0f);
            }
            r.this.f7676e.setVisibility(8);
            r.this.f7676e.setTransitioning(false);
            r rVar2 = r.this;
            rVar2.f7696y = null;
            rVar2.w();
            ActionBarOverlayLayout actionBarOverlayLayout = r.this.f7675d;
            if (actionBarOverlayLayout != null) {
                androidx.core.view.H.g0(actionBarOverlayLayout);
            }
        }
    }

    class b extends U {
        b() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            r rVar = r.this;
            rVar.f7696y = null;
            rVar.f7676e.requestLayout();
        }
    }

    class c implements V {
        c() {
        }

        @Override // androidx.core.view.V
        public void a(View view) {
            ((View) r.this.f7676e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements e.a {

        /* renamed from: c, reason: collision with root package name */
        private final Context f7701c;

        /* renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.e f7702d;

        /* renamed from: e, reason: collision with root package name */
        private b.a f7703e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<View> f7704f;

        public d(Context context, b.a aVar) {
            this.f7701c = context;
            this.f7703e = aVar;
            androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(context).T(1);
            this.f7702d = eVarT;
            eVarT.S(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.f7703e;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f7703e == null) {
                return;
            }
            k();
            r.this.f7678g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            r rVar = r.this;
            if (rVar.f7684m != this) {
                return;
            }
            if (r.v(rVar.f7692u, rVar.f7693v, false)) {
                this.f7703e.a(this);
            } else {
                r rVar2 = r.this;
                rVar2.f7685n = this;
                rVar2.f7686o = this.f7703e;
            }
            this.f7703e = null;
            r.this.u(false);
            r.this.f7678g.g();
            r rVar3 = r.this;
            rVar3.f7675d.setHideOnContentScrollEnabled(rVar3.f7668A);
            r.this.f7684m = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference<View> weakReference = this.f7704f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f7702d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f7701c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return r.this.f7678g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return r.this.f7678g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (r.this.f7684m != this) {
                return;
            }
            this.f7702d.e0();
            try {
                this.f7703e.c(this, this.f7702d);
            } finally {
                this.f7702d.d0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return r.this.f7678g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            r.this.f7678g.setCustomView(view);
            this.f7704f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i5) {
            o(r.this.f7672a.getResources().getString(i5));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            r.this.f7678g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i5) {
            r(r.this.f7672a.getResources().getString(i5));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            r.this.f7678g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z5) {
            super.s(z5);
            r.this.f7678g.setTitleOptional(z5);
        }

        public boolean t() {
            this.f7702d.e0();
            try {
                return this.f7703e.b(this, this.f7702d);
            } finally {
                this.f7702d.d0();
            }
        }
    }

    public r(Activity activity, boolean z5) {
        this.f7674c = activity;
        View decorView = activity.getWindow().getDecorView();
        C(decorView);
        if (z5) {
            return;
        }
        this.f7679h = decorView.findViewById(R.id.content);
    }

    private void B() {
        if (this.f7694w) {
            this.f7694w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f7675d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            L(false);
        }
    }

    private void C(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(g.f.f16934p);
        this.f7675d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f7677f = z(view.findViewById(g.f.f16919a));
        this.f7678g = (ActionBarContextView) view.findViewById(g.f.f16924f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(g.f.f16921c);
        this.f7676e = actionBarContainer;
        H h5 = this.f7677f;
        if (h5 == null || this.f7678g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f7672a = h5.getContext();
        boolean z5 = (this.f7677f.p() & 4) != 0;
        if (z5) {
            this.f7683l = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f7672a);
        I(aVarB.a() || z5);
        G(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f7672a.obtainStyledAttributes(null, g.j.f17094a, C0728a.f16826c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.f17144k, false)) {
            H(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17134i, 0);
        if (dimensionPixelSize != 0) {
            F(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void G(boolean z5) {
        this.f7689r = z5;
        if (z5) {
            this.f7676e.setTabContainer(null);
            this.f7677f.u(this.f7680i);
        } else {
            this.f7677f.u(null);
            this.f7676e.setTabContainer(this.f7680i);
        }
        boolean z6 = A() == 2;
        T t5 = this.f7680i;
        if (t5 != null) {
            if (z6) {
                t5.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f7675d;
                if (actionBarOverlayLayout != null) {
                    androidx.core.view.H.g0(actionBarOverlayLayout);
                }
            } else {
                t5.setVisibility(8);
            }
        }
        this.f7677f.t(!this.f7689r && z6);
        this.f7675d.setHasNonEmbeddedTabs(!this.f7689r && z6);
    }

    private boolean J() {
        return this.f7676e.isLaidOut();
    }

    private void K() {
        if (this.f7694w) {
            return;
        }
        this.f7694w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f7675d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        L(false);
    }

    private void L(boolean z5) {
        if (v(this.f7692u, this.f7693v, this.f7694w)) {
            if (this.f7695x) {
                return;
            }
            this.f7695x = true;
            y(z5);
            return;
        }
        if (this.f7695x) {
            this.f7695x = false;
            x(z5);
        }
    }

    static boolean v(boolean z5, boolean z6, boolean z7) {
        if (z7) {
            return true;
        }
        return (z5 || z6) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private H z(View view) {
        if (view instanceof H) {
            return (H) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public int A() {
        return this.f7677f.l();
    }

    public void D(boolean z5) {
        E(z5 ? 4 : 0, 4);
    }

    public void E(int i5, int i6) {
        int iP = this.f7677f.p();
        if ((i6 & 4) != 0) {
            this.f7683l = true;
        }
        this.f7677f.j((i5 & i6) | ((~i6) & iP));
    }

    public void F(float f5) {
        androidx.core.view.H.r0(this.f7676e, f5);
    }

    public void H(boolean z5) {
        if (z5 && !this.f7675d.x()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f7668A = z5;
        this.f7675d.setHideOnContentScrollEnabled(z5);
    }

    public void I(boolean z5) {
        this.f7677f.o(z5);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f7693v) {
            this.f7693v = false;
            L(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z5) {
        this.f7691t = z5;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.f7693v) {
            return;
        }
        this.f7693v = true;
        L(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        androidx.appcompat.view.h hVar = this.f7696y;
        if (hVar != null) {
            hVar.a();
            this.f7696y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        H h5 = this.f7677f;
        if (h5 == null || !h5.i()) {
            return false;
        }
        this.f7677f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z5) {
        if (z5 == this.f7687p) {
            return;
        }
        this.f7687p = z5;
        int size = this.f7688q.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f7688q.get(i5).a(z5);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f7677f.p();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        if (this.f7673b == null) {
            TypedValue typedValue = new TypedValue();
            this.f7672a.getTheme().resolveAttribute(C0728a.f16831h, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f7673b = new ContextThemeWrapper(this.f7672a, i5);
            } else {
                this.f7673b = this.f7672a;
            }
        }
        return this.f7673b;
    }

    @Override // androidx.appcompat.app.a
    public void l(Configuration configuration) {
        G(androidx.appcompat.view.a.b(this.f7672a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean n(int i5, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f7684m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i5, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void onWindowVisibilityChanged(int i5) {
        this.f7690s = i5;
    }

    @Override // androidx.appcompat.app.a
    public void q(boolean z5) {
        if (this.f7683l) {
            return;
        }
        D(z5);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z5) {
        androidx.appcompat.view.h hVar;
        this.f7697z = z5;
        if (z5 || (hVar = this.f7696y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void s(CharSequence charSequence) {
        this.f7677f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b t(b.a aVar) {
        d dVar = this.f7684m;
        if (dVar != null) {
            dVar.c();
        }
        this.f7675d.setHideOnContentScrollEnabled(false);
        this.f7678g.k();
        d dVar2 = new d(this.f7678g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f7684m = dVar2;
        dVar2.k();
        this.f7678g.h(dVar2);
        u(true);
        return dVar2;
    }

    public void u(boolean z5) {
        S sF;
        S sF2;
        if (z5) {
            K();
        } else {
            B();
        }
        if (!J()) {
            if (z5) {
                this.f7677f.n(4);
                this.f7678g.setVisibility(0);
                return;
            } else {
                this.f7677f.n(0);
                this.f7678g.setVisibility(8);
                return;
            }
        }
        if (z5) {
            sF = this.f7677f.m(4, 100L);
            sF2 = this.f7678g.f(0, 200L);
        } else {
            S sM = this.f7677f.m(0, 200L);
            sF = this.f7678g.f(8, 100L);
            sF2 = sM;
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(sF, sF2);
        hVar.h();
    }

    void w() {
        b.a aVar = this.f7686o;
        if (aVar != null) {
            aVar.a(this.f7685n);
            this.f7685n = null;
            this.f7686o = null;
        }
    }

    public void x(boolean z5) {
        View view;
        androidx.appcompat.view.h hVar = this.f7696y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f7690s != 0 || (!this.f7697z && !z5)) {
            this.f7669B.d(null);
            return;
        }
        this.f7676e.setAlpha(1.0f);
        this.f7676e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f5 = -this.f7676e.getHeight();
        if (z5) {
            this.f7676e.getLocationInWindow(new int[]{0, 0});
            f5 -= r5[1];
        }
        S sP = androidx.core.view.H.d(this.f7676e).p(f5);
        sP.m(this.f7671D);
        hVar2.c(sP);
        if (this.f7691t && (view = this.f7679h) != null) {
            hVar2.c(androidx.core.view.H.d(view).p(f5));
        }
        hVar2.f(f7666E);
        hVar2.e(250L);
        hVar2.g(this.f7669B);
        this.f7696y = hVar2;
        hVar2.h();
    }

    public void y(boolean z5) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f7696y;
        if (hVar != null) {
            hVar.a();
        }
        this.f7676e.setVisibility(0);
        if (this.f7690s == 0 && (this.f7697z || z5)) {
            this.f7676e.setTranslationY(0.0f);
            float f5 = -this.f7676e.getHeight();
            if (z5) {
                this.f7676e.getLocationInWindow(new int[]{0, 0});
                f5 -= r5[1];
            }
            this.f7676e.setTranslationY(f5);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            S sP = androidx.core.view.H.d(this.f7676e).p(0.0f);
            sP.m(this.f7671D);
            hVar2.c(sP);
            if (this.f7691t && (view2 = this.f7679h) != null) {
                view2.setTranslationY(f5);
                hVar2.c(androidx.core.view.H.d(this.f7679h).p(0.0f));
            }
            hVar2.f(f7667F);
            hVar2.e(250L);
            hVar2.g(this.f7670C);
            this.f7696y = hVar2;
            hVar2.h();
        } else {
            this.f7676e.setAlpha(1.0f);
            this.f7676e.setTranslationY(0.0f);
            if (this.f7691t && (view = this.f7679h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f7670C.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f7675d;
        if (actionBarOverlayLayout != null) {
            androidx.core.view.H.g0(actionBarOverlayLayout);
        }
    }

    public r(Dialog dialog) {
        C(dialog.getWindow().getDecorView());
    }
}
