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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import androidx.core.view.X;
import i.AbstractC4156b;
import i.C4155a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class s extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    /* renamed from: E, reason: collision with root package name */
    public static final Interpolator f8478E = new AccelerateInterpolator();

    /* renamed from: F, reason: collision with root package name */
    public static final Interpolator f8479F = new DecelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public boolean f8480A;

    /* renamed from: a, reason: collision with root package name */
    public Context f8484a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8485b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f8486c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f8487d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContainer f8488e;

    /* renamed from: f, reason: collision with root package name */
    public A f8489f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContextView f8490g;

    /* renamed from: h, reason: collision with root package name */
    public View f8491h;

    /* renamed from: i, reason: collision with root package name */
    public M f8492i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8495l;

    /* renamed from: m, reason: collision with root package name */
    public d f8496m;

    /* renamed from: n, reason: collision with root package name */
    public AbstractC4156b f8497n;

    /* renamed from: o, reason: collision with root package name */
    public AbstractC4156b.a f8498o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8499p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8501r;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8504u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8505v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8506w;

    /* renamed from: y, reason: collision with root package name */
    public i.h f8508y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8509z;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<Object> f8493j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public int f8494k = -1;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<a.b> f8500q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    public int f8502s = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8503t = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8507x = true;

    /* renamed from: B, reason: collision with root package name */
    public final V f8481B = new a();

    /* renamed from: C, reason: collision with root package name */
    public final V f8482C = new b();

    /* renamed from: D, reason: collision with root package name */
    public final X f8483D = new c();

    public class a extends W {
        public a() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            View view2;
            s sVar = s.this;
            if (sVar.f8503t && (view2 = sVar.f8491h) != null) {
                view2.setTranslationY(0.0f);
                s.this.f8488e.setTranslationY(0.0f);
            }
            s.this.f8488e.setVisibility(8);
            s.this.f8488e.setTransitioning(false);
            s sVar2 = s.this;
            sVar2.f8508y = null;
            sVar2.z();
            ActionBarOverlayLayout actionBarOverlayLayout = s.this.f8487d;
            if (actionBarOverlayLayout != null) {
                N.e0(actionBarOverlayLayout);
            }
        }
    }

    public class b extends W {
        public b() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            s sVar = s.this;
            sVar.f8508y = null;
            sVar.f8488e.requestLayout();
        }
    }

    public class c implements X {
        public c() {
        }

        @Override // androidx.core.view.X
        public void a(View view) {
            ((View) s.this.f8488e.getParent()).invalidate();
        }
    }

    public class d extends AbstractC4156b implements e.a {

        /* renamed from: c, reason: collision with root package name */
        public final Context f8513c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f8514d;

        /* renamed from: e, reason: collision with root package name */
        public AbstractC4156b.a f8515e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<View> f8516f;

        public d(Context context, AbstractC4156b.a aVar) {
            this.f8513c = context;
            this.f8515e = aVar;
            androidx.appcompat.view.menu.e eVarX = new androidx.appcompat.view.menu.e(context).X(1);
            this.f8514d = eVarX;
            eVarX.W(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            AbstractC4156b.a aVar = this.f8515e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.f8515e == null) {
                return;
            }
            k();
            s.this.f8490g.l();
        }

        @Override // i.AbstractC4156b
        public void c() {
            s sVar = s.this;
            if (sVar.f8496m != this) {
                return;
            }
            if (s.y(sVar.f8504u, sVar.f8505v, false)) {
                this.f8515e.b(this);
            } else {
                s sVar2 = s.this;
                sVar2.f8497n = this;
                sVar2.f8498o = this.f8515e;
            }
            this.f8515e = null;
            s.this.x(false);
            s.this.f8490g.g();
            s sVar3 = s.this;
            sVar3.f8487d.setHideOnContentScrollEnabled(sVar3.f8480A);
            s.this.f8496m = null;
        }

        @Override // i.AbstractC4156b
        public View d() {
            WeakReference<View> weakReference = this.f8516f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // i.AbstractC4156b
        public Menu e() {
            return this.f8514d;
        }

        @Override // i.AbstractC4156b
        public MenuInflater f() {
            return new i.g(this.f8513c);
        }

        @Override // i.AbstractC4156b
        public CharSequence g() {
            return s.this.f8490g.getSubtitle();
        }

        @Override // i.AbstractC4156b
        public CharSequence i() {
            return s.this.f8490g.getTitle();
        }

        @Override // i.AbstractC4156b
        public void k() {
            if (s.this.f8496m != this) {
                return;
            }
            this.f8514d.i0();
            try {
                this.f8515e.c(this, this.f8514d);
            } finally {
                this.f8514d.h0();
            }
        }

        @Override // i.AbstractC4156b
        public boolean l() {
            return s.this.f8490g.j();
        }

        @Override // i.AbstractC4156b
        public void m(View view) {
            s.this.f8490g.setCustomView(view);
            this.f8516f = new WeakReference<>(view);
        }

        @Override // i.AbstractC4156b
        public void n(int i10) {
            o(s.this.f8484a.getResources().getString(i10));
        }

        @Override // i.AbstractC4156b
        public void o(CharSequence charSequence) {
            s.this.f8490g.setSubtitle(charSequence);
        }

        @Override // i.AbstractC4156b
        public void q(int i10) {
            r(s.this.f8484a.getResources().getString(i10));
        }

        @Override // i.AbstractC4156b
        public void r(CharSequence charSequence) {
            s.this.f8490g.setTitle(charSequence);
        }

        @Override // i.AbstractC4156b
        public void s(boolean z10) {
            super.s(z10);
            s.this.f8490g.setTitleOptional(z10);
        }

        public boolean t() {
            this.f8514d.i0();
            try {
                return this.f8515e.d(this, this.f8514d);
            } finally {
                this.f8514d.h0();
            }
        }
    }

    public s(Activity activity, boolean z10) {
        this.f8486c = activity;
        View decorView = activity.getWindow().getDecorView();
        F(decorView);
        if (z10) {
            return;
        }
        this.f8491h = decorView.findViewById(R.id.content);
    }

    public static boolean y(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public void A(boolean z10) {
        View view;
        i.h hVar = this.f8508y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f8502s != 0 || (!this.f8509z && !z10)) {
            this.f8481B.d(null);
            return;
        }
        this.f8488e.setAlpha(1.0f);
        this.f8488e.setTransitioning(true);
        i.h hVar2 = new i.h();
        float f10 = -this.f8488e.getHeight();
        if (z10) {
            this.f8488e.getLocationInWindow(new int[]{0, 0});
            f10 -= r5[1];
        }
        U uM = N.d(this.f8488e).m(f10);
        uM.k(this.f8483D);
        hVar2.c(uM);
        if (this.f8503t && (view = this.f8491h) != null) {
            hVar2.c(N.d(view).m(f10));
        }
        hVar2.f(f8478E);
        hVar2.e(250L);
        hVar2.g(this.f8481B);
        this.f8508y = hVar2;
        hVar2.h();
    }

    public void B(boolean z10) {
        View view;
        View view2;
        i.h hVar = this.f8508y;
        if (hVar != null) {
            hVar.a();
        }
        this.f8488e.setVisibility(0);
        if (this.f8502s == 0 && (this.f8509z || z10)) {
            this.f8488e.setTranslationY(0.0f);
            float f10 = -this.f8488e.getHeight();
            if (z10) {
                this.f8488e.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f8488e.setTranslationY(f10);
            i.h hVar2 = new i.h();
            U uM = N.d(this.f8488e).m(0.0f);
            uM.k(this.f8483D);
            hVar2.c(uM);
            if (this.f8503t && (view2 = this.f8491h) != null) {
                view2.setTranslationY(f10);
                hVar2.c(N.d(this.f8491h).m(0.0f));
            }
            hVar2.f(f8479F);
            hVar2.e(250L);
            hVar2.g(this.f8482C);
            this.f8508y = hVar2;
            hVar2.h();
        } else {
            this.f8488e.setAlpha(1.0f);
            this.f8488e.setTranslationY(0.0f);
            if (this.f8503t && (view = this.f8491h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f8482C.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f8487d;
        if (actionBarOverlayLayout != null) {
            N.e0(actionBarOverlayLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final A C(View view) {
        if (view instanceof A) {
            return (A) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    public int D() {
        return this.f8489f.j();
    }

    public final void E() {
        if (this.f8506w) {
            this.f8506w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f8487d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    public final void F(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f8487d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f8489f = C(view.findViewById(R$id.action_bar));
        this.f8490g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f8488e = actionBarContainer;
        A a10 = this.f8489f;
        if (a10 == null || this.f8490g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f8484a = a10.getContext();
        boolean z10 = (this.f8489f.s() & 4) != 0;
        if (z10) {
            this.f8495l = true;
        }
        C4155a c4155aB = C4155a.b(this.f8484a);
        K(c4155aB.a() || z10);
        I(c4155aB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f8484a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            J(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void G(int i10, int i11) {
        int iS = this.f8489f.s();
        if ((i11 & 4) != 0) {
            this.f8495l = true;
        }
        this.f8489f.h((i10 & i11) | ((~i11) & iS));
    }

    public void H(float f10) {
        N.p0(this.f8488e, f10);
    }

    public final void I(boolean z10) {
        this.f8501r = z10;
        if (z10) {
            this.f8488e.setTabContainer(null);
            this.f8489f.u(this.f8492i);
        } else {
            this.f8489f.u(null);
            this.f8488e.setTabContainer(this.f8492i);
        }
        boolean z11 = D() == 2;
        M m10 = this.f8492i;
        if (m10 != null) {
            if (z11) {
                m10.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f8487d;
                if (actionBarOverlayLayout != null) {
                    N.e0(actionBarOverlayLayout);
                }
            } else {
                m10.setVisibility(8);
            }
        }
        this.f8489f.o(!this.f8501r && z11);
        this.f8487d.setHasNonEmbeddedTabs(!this.f8501r && z11);
    }

    public void J(boolean z10) {
        if (z10 && !this.f8487d.p()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f8480A = z10;
        this.f8487d.setHideOnContentScrollEnabled(z10);
    }

    public void K(boolean z10) {
        this.f8489f.m(z10);
    }

    public final boolean L() {
        return this.f8488e.isLaidOut();
    }

    public final void M() {
        if (this.f8506w) {
            return;
        }
        this.f8506w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f8487d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        N(false);
    }

    public final void N(boolean z10) {
        if (y(this.f8504u, this.f8505v, this.f8506w)) {
            if (this.f8507x) {
                return;
            }
            this.f8507x = true;
            B(z10);
            return;
        }
        if (this.f8507x) {
            this.f8507x = false;
            A(z10);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f8505v) {
            this.f8505v = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z10) {
        this.f8503t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.f8505v) {
            return;
        }
        this.f8505v = true;
        N(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        i.h hVar = this.f8508y;
        if (hVar != null) {
            hVar.a();
            this.f8508y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        A a10 = this.f8489f;
        if (a10 == null || !a10.g()) {
            return false;
        }
        this.f8489f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z10) {
        if (z10 == this.f8499p) {
            return;
        }
        this.f8499p = z10;
        int size = this.f8500q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8500q.get(i10).a(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f8489f.s();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        if (this.f8485b == null) {
            TypedValue typedValue = new TypedValue();
            this.f8484a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f8485b = new ContextThemeWrapper(this.f8484a, i10);
            } else {
                this.f8485b = this.f8484a;
            }
        }
        return this.f8485b;
    }

    @Override // androidx.appcompat.app.a
    public void k() {
        if (this.f8504u) {
            return;
        }
        this.f8504u = true;
        N(false);
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        I(C4155a.b(this.f8484a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f8496m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void onWindowVisibilityChanged(int i10) {
        this.f8502s = i10;
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
        if (this.f8495l) {
            return;
        }
        s(z10);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        G(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        G(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        i.h hVar;
        this.f8509z = z10;
        if (z10 || (hVar = this.f8508y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f8489f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public AbstractC4156b w(AbstractC4156b.a aVar) {
        d dVar = this.f8496m;
        if (dVar != null) {
            dVar.c();
        }
        this.f8487d.setHideOnContentScrollEnabled(false);
        this.f8490g.k();
        d dVar2 = new d(this.f8490g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f8496m = dVar2;
        dVar2.k();
        this.f8490g.h(dVar2);
        x(true);
        return dVar2;
    }

    public void x(boolean z10) {
        U uF;
        U uF2;
        if (z10) {
            M();
        } else {
            E();
        }
        if (!L()) {
            if (z10) {
                this.f8489f.w(4);
                this.f8490g.setVisibility(0);
                return;
            } else {
                this.f8489f.w(0);
                this.f8490g.setVisibility(8);
                return;
            }
        }
        if (z10) {
            uF = this.f8489f.k(4, 100L);
            uF2 = this.f8490g.f(0, 200L);
        } else {
            U uK = this.f8489f.k(0, 200L);
            uF = this.f8490g.f(8, 100L);
            uF2 = uK;
        }
        i.h hVar = new i.h();
        hVar.d(uF, uF2);
        hVar.h();
    }

    public void z() {
        AbstractC4156b.a aVar = this.f8498o;
        if (aVar != null) {
            aVar.b(this.f8497n);
            this.f8497n = null;
            this.f8498o = null;
        }
    }

    public s(Dialog dialog) {
        F(dialog.getWindow().getDecorView());
    }
}
