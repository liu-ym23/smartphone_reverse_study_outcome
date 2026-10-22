package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import fa.C1449a;
import java.util.ArrayList;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.InterfaceC1996k;
import stepos.support.v7.widget.Toolbar;
import v0.C2054a;

/* loaded from: classes4.dex */
public final class e0 extends AbstractC1955d implements InterfaceC1996k {
    public static final boolean E;

    /* renamed from: A, reason: collision with root package name */
    public final d0 f6298A;

    /* renamed from: B, reason: collision with root package name */
    public final d0 f6299B;

    /* renamed from: C, reason: collision with root package name */
    public final C2054a f6300C;

    /* renamed from: D, reason: collision with root package name */
    public final int f6301D;

    /* renamed from: a, reason: collision with root package name */
    public Context f6302a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public stepos.support.v7.widget.I e;
    public ActionBarContextView f;
    public ActionBarContainer g;
    public final FitsWindowsContentLayout h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public K f6303j;
    public K k;
    public C1449a l;
    public boolean m;
    public final ArrayList n;
    public boolean o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6304q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6305r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6306s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6307t;
    public ViewPropertyAnimatorCompatSet u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6308v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6309w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6310x;
    public final boolean y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6311z;

    static {
        new AccelerateInterpolator();
        new DecelerateInterpolator();
        E = true;
    }

    public e0(Activity activity, boolean z10) {
        new ArrayList();
        this.n = new ArrayList();
        this.p = 0;
        this.f6304q = true;
        this.f6307t = true;
        this.y = true;
        new d0(this, 0);
        new d0(this, 1);
        this.f6298A = new d0(this, 2);
        this.f6299B = new d0(this, 3);
        this.f6300C = new C2054a(this);
        this.f6301D = 288;
        View decorView = activity.getWindow().getDecorView();
        w(decorView);
        if (z10) {
            return;
        }
        this.h = (FitsWindowsContentLayout) decorView.findViewById(R.id.content);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final boolean a() {
        stepos.support.v7.widget.I i = this.e;
        if (i == null || !i.hasExpandedActionView()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void b(boolean z10) {
        if (z10 == this.m) {
            return;
        }
        this.m = z10;
        ArrayList arrayList = this.n;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final int c() {
        return this.e.getDisplayOptions();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Context d() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.f6302a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.f6302a, i);
            } else {
                this.b = this.f6302a;
            }
        }
        return this.b;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void f() {
        y((this.y && Ua.a.a(this.f6302a).c()) || this.f6310x);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void i(boolean z10) {
        if (this.i) {
            return;
        }
        j(z10);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void j(boolean z10) {
        x(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void k() {
        x(0, 2);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void l() {
        x(8, 8);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void m(int i) {
        this.e.setNavigationContentDescription(i);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void n(Drawable drawable) {
        this.e.setNavigationIcon(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void o(boolean z10) {
        this.e.setHomeButtonEnabled(z10);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void p(boolean z10) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f6308v = z10;
        if (z10 || (viewPropertyAnimatorCompatSet = this.u) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void q(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void r(int i) {
        this.c.setUiOptions(i);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void s(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Ua.c t(C1449a c1449a) {
        K k = this.f6303j;
        if (k != null) {
            k.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.j();
        K k5 = new K(this, this.f.getContext(), c1449a);
        Va.n nVar = k5.f;
        nVar.v();
        try {
            boolean zA = ((Ua.b) k5.g.b).a(k5, nVar);
            nVar.u();
            if (!zA) {
                return null;
            }
            k5.h();
            this.f.g(k5);
            v(true, null);
            ActionBarContainer actionBarContainer = this.g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            }
            this.f.sendAccessibilityEvent(32);
            this.f6303j = k5;
            return k5;
        } catch (Throwable th) {
            nVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Ua.c u(C1449a c1449a) {
        K k = this.f6303j;
        if (k != null) {
            k.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.j();
        K k5 = new K(this, this.f.getContext(), c1449a);
        Va.n nVar = k5.f;
        nVar.v();
        try {
            if (!((Ua.b) k5.g.b).a(k5, nVar)) {
                return null;
            }
            k5.h();
            this.f.setSplitView(this.g);
            this.f.h(k5);
            v(true, k5);
            ActionBarContainer actionBarContainer = this.g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            }
            this.f.sendAccessibilityEvent(32);
            this.f6303j = k5;
            return k5;
        } finally {
            nVar.u();
        }
    }

    public final void v(boolean z10, K k) {
        if (k != null ? true : z10) {
            if (!this.f6306s) {
                this.f6306s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                z(false);
            }
        } else if (this.f6306s) {
            this.f6306s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            z(false);
        }
        (z10 ? this.e.setupAnimatorToVisibility(4, 100L) : this.e.setupAnimatorToVisibility(0, 200L)).start();
        this.f.f(z10);
    }

    public final void w(View view) {
        stepos.support.v7.widget.I wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.stepos.ability.R.id.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        Object objFindViewById = view.findViewById(com.stepos.ability.R.id.action_bar);
        if (objFindViewById instanceof stepos.support.v7.widget.I) {
            wrapper = (stepos.support.v7.widget.I) objFindViewById;
        } else {
            if (!(objFindViewById instanceof Toolbar)) {
                StringBuilder sb = new StringBuilder("Can't make a decor toolbar out of ");
                sb.append(objFindViewById);
                throw new IllegalStateException(sb.toString() != null ? objFindViewById.getClass().getSimpleName() : "null");
            }
            wrapper = ((Toolbar) objFindViewById).getWrapper();
        }
        this.e = wrapper;
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.stepos.ability.R.id.action_bar_container);
        this.d = actionBarContainer;
        this.f = (ActionBarContextView) actionBarContainer.findViewById(com.stepos.ability.R.id.action_context_bar);
        this.g = (ActionBarContainer) view.findViewById(com.stepos.ability.R.id.split_action_bar);
        stepos.support.v7.widget.I i = this.e;
        if (i == null || this.f == null || this.d == null) {
            throw new IllegalStateException(e0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        i.k(new C1973w(this, 6));
        this.f6302a = this.e.getContext();
        int displayOptions = this.e.getDisplayOptions();
        boolean z10 = true;
        boolean z11 = (displayOptions & 4) != 0;
        if (z11) {
            this.i = true;
        }
        Ua.a aVarA = Ua.a.a(this.f6302a);
        o(aVarA.f1279a.getApplicationInfo().targetSdkVersion < 14 || z11);
        this.f6310x = (displayOptions & 32) != 0;
        y((this.y && aVarA.c()) || this.f6310x);
        TypedArray typedArrayObtainStyledAttributes = this.f6302a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, com.stepos.ability.R.attr.steposActionBarStyleFullScreen, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (!actionBarOverlayLayout2.f6434j) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f6309w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            float f = dimensionPixelSize;
            ViewCompat.setElevation(this.d, f);
            ActionBarContainer actionBarContainer2 = this.g;
            if (actionBarContainer2 != null) {
                ViewCompat.setElevation(actionBarContainer2, f);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        int height = this.d.getHeight();
        if (!this.f6307t || (height != 0 && this.c.getActionBarHideOffset() >= height)) {
            z10 = false;
        }
        this.f6311z = z10;
    }

    public final void x(int i, int i6) {
        int displayOptions = this.e.getDisplayOptions();
        if ((i6 & 4) != 0) {
            this.i = true;
        }
        this.e.setDisplayOptions((i & i6) | ((~i6) & displayOptions));
    }

    public final void y(boolean z10) {
        this.o = z10;
        if (z10) {
            this.d.setTabContainer(null);
            this.e.i();
        } else {
            this.e.i();
            this.d.setTabContainer(null);
        }
        this.e.getClass();
        if (this.o) {
            this.e.getClass();
        } else {
            this.d.getTabContainer();
        }
        this.e.setCollapsible(false);
        this.c.setHasNonEmbeddedTabs(false);
    }

    public final void z(boolean z10) {
        boolean z11 = this.f6305r;
        boolean z12 = this.f6306s;
        int i = this.f6301D;
        C2054a c2054a = this.f6300C;
        boolean z13 = E;
        FitsWindowsContentLayout fitsWindowsContentLayout = this.h;
        if (!z12 && z11) {
            if (this.f6307t) {
                this.f6307t = false;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.u;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.cancel();
                }
                int i6 = this.p;
                d0 d0Var = this.f6298A;
                if (i6 != 0 || !z13 || (!this.f6308v && !z10)) {
                    d0Var.onAnimationEnd(null);
                    return;
                }
                ViewCompat.setAlpha(this.d, 1.0f);
                this.d.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                float f = -this.d.getHeight();
                if (z10) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f -= r13[1];
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.d).translationY(f);
                viewPropertyAnimatorCompatTranslationY.setUpdateListener(c2054a);
                viewPropertyAnimatorCompatSet2.play(viewPropertyAnimatorCompatTranslationY);
                if (this.f6304q && fitsWindowsContentLayout != null) {
                    viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(fitsWindowsContentLayout).translationY(f));
                }
                ActionBarContainer actionBarContainer = this.g;
                if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.f6311z) {
                    ViewCompat.setAlpha(this.g, 1.0f);
                    viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.g).translationY(this.g.getHeight()));
                }
                viewPropertyAnimatorCompatSet2.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.5f, 0.16f, 1.0f));
                viewPropertyAnimatorCompatSet2.setDuration(i);
                viewPropertyAnimatorCompatSet2.setListener(d0Var);
                this.u = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.start();
                return;
            }
            return;
        }
        if (this.f6307t) {
            return;
        }
        this.f6307t = true;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.u;
        if (viewPropertyAnimatorCompatSet3 != null) {
            viewPropertyAnimatorCompatSet3.cancel();
        }
        this.d.setVisibility(0);
        int i10 = this.p;
        d0 d0Var2 = this.f6299B;
        if (i10 == 0 && z13 && (this.f6308v || z10)) {
            ViewCompat.setTranslationY(this.d, 0.0f);
            float f7 = -this.d.getHeight();
            if (z10) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f7 -= r13[1];
            }
            ViewCompat.setTranslationY(this.d, f7);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY2 = ViewCompat.animate(this.d).translationY(0.0f);
            viewPropertyAnimatorCompatTranslationY2.setUpdateListener(c2054a);
            viewPropertyAnimatorCompatSet4.play(viewPropertyAnimatorCompatTranslationY2);
            if (this.f6304q && fitsWindowsContentLayout != null) {
                ViewCompat.setTranslationY(fitsWindowsContentLayout, f7);
                viewPropertyAnimatorCompatSet4.play(ViewCompat.animate(fitsWindowsContentLayout).translationY(0.0f));
            }
            ActionBarContainer actionBarContainer2 = this.g;
            if (actionBarContainer2 != null && !this.f6311z) {
                actionBarContainer2.setVisibility(0);
                ViewCompat.setTranslationY(this.g, r0.getMeasuredHeight());
                viewPropertyAnimatorCompatSet4.play(ViewCompat.animate(this.g).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet4.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.5f, 0.05f, 1.0f));
            viewPropertyAnimatorCompatSet4.setDuration(i);
            viewPropertyAnimatorCompatSet4.setListener(d0Var2);
            this.u = viewPropertyAnimatorCompatSet4;
            viewPropertyAnimatorCompatSet4.start();
        } else {
            ViewCompat.setAlpha(this.d, 1.0f);
            ViewCompat.setTranslationY(this.d, 0.0f);
            if (this.f6304q && fitsWindowsContentLayout != null) {
                ViewCompat.setTranslationY(fitsWindowsContentLayout, 0.0f);
            }
            ActionBarContainer actionBarContainer3 = this.g;
            if (actionBarContainer3 != null) {
                ViewCompat.setAlpha(actionBarContainer3, 1.0f);
                ViewCompat.setTranslationY(this.g, 0.0f);
                this.g.setVisibility(0);
            }
            d0Var2.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public e0(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList();
        this.p = 0;
        this.f6304q = true;
        this.f6307t = true;
        this.y = true;
        new d0(this, 0);
        new d0(this, 1);
        this.f6298A = new d0(this, 2);
        this.f6299B = new d0(this, 3);
        this.f6300C = new C2054a(this);
        this.f6301D = 288;
        w(dialog.getWindow().getDecorView());
    }
}
