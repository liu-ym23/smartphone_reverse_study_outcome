package stepos.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.stepos.ability.R;
import fa.C1449a;
import java.util.ArrayList;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C1980b0;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes4.dex */
public final class L extends AbstractC1955d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6221a;
    public Context b;
    public final ActionBarCoordinatorLayout c;
    public final stepos.support.v7.widget.E d;
    public final StepOSAppBarLayout e;
    public final StepOSCollapsingToolbarLayout f;
    public final ActionBarContextView g;
    public final ActionBarContainer h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public K f6222j;
    public K k;
    public C1449a l;
    public boolean m;
    public final ArrayList n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public ViewPropertyAnimatorCompatSet f6223q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6224r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f6225s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6226t;
    public final J u;

    /* renamed from: v, reason: collision with root package name */
    public final A8.d f6227v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6228w;

    public L(Activity activity) {
        stepos.support.v7.widget.I wrapper;
        new ArrayList();
        this.n = new ArrayList();
        this.p = true;
        new J(this, 0);
        new J(this, 1);
        new J(this, 2);
        this.u = new J(this, 3);
        this.f6227v = new A8.d(this, 7);
        this.f6228w = 288;
        View decorView = activity.getWindow().getDecorView();
        this.c = (ActionBarCoordinatorLayout) decorView.findViewById(R.id.decor_content_parent);
        this.g = (ActionBarContextView) decorView.findViewById(R.id.action_context_bar);
        this.f = (StepOSCollapsingToolbarLayout) decorView.findViewById(R.id.action_bar_container);
        this.e = (StepOSAppBarLayout) decorView.findViewById(R.id.app_bar_layout);
        this.h = (ActionBarContainer) decorView.findViewById(R.id.split_action_bar);
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f;
        Object objFindViewById = decorView.findViewById(R.id.action_bar);
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
        if (stepOSCollapsingToolbarLayout.f6509x == null) {
            stepos.support.v7.widget.E e = new stepos.support.v7.widget.E();
            e.f6455a = stepOSCollapsingToolbarLayout;
            e.b = wrapper;
            e.c = wrapper.getDisplayOptions();
            stepOSCollapsingToolbarLayout.f6509x = e;
        }
        stepos.support.v7.widget.E e6 = stepOSCollapsingToolbarLayout.f6509x;
        this.d = e6;
        if (e6 == null || this.g == null || this.f == null) {
            throw new IllegalStateException(L.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        e6.k(new C1973w(this, 2));
        Context context = this.d.b.getContext();
        this.f6221a = context;
        int i = this.d.c;
        boolean z10 = (i & 4) != 0;
        if (z10) {
            this.i = true;
        }
        o(Ua.a.a(context).f1279a.getApplicationInfo().targetSdkVersion < 14 || z10);
        boolean z11 = (i & 32) != 0;
        this.f6225s = z11;
        if ((i & 8) != 0 && z11) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        x(z11);
        TypedArray typedArrayObtainStyledAttributes = this.f6221a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, R.attr.steposActionBarStyleFullScreen, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            float f = dimensionPixelSize;
            ViewCompat.setElevation(this.e, f);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null) {
                ViewCompat.setElevation(actionBarContainer, f);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f6226t = this.p && this.f.getHeight() == 0;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final boolean a() {
        stepos.support.v7.widget.E e = this.d;
        if (e == null || !e.b.hasExpandedActionView()) {
            return false;
        }
        this.d.collapseActionView();
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
        return this.d.c;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Context d() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.f6221a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.f6221a, i);
            } else {
                this.b = this.f6221a;
            }
        }
        return this.b;
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void f() {
        x(this.f6225s);
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
        w(z10 ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void k() {
        w(0, 2);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void l() {
        if (this.f6225s) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        w(8, 8);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void m(int i) {
        this.d.setNavigationContentDescription(i);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void n(Drawable drawable) {
        this.d.setNavigationIcon(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void o(boolean z10) {
        this.d.setHomeButtonEnabled(z10);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void p(boolean z10) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f6224r = z10;
        if (z10 || (viewPropertyAnimatorCompatSet = this.f6223q) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void q(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void r(int i) {
        this.c.setUiOptions(i);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final void s(CharSequence charSequence) {
        this.d.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Ua.c t(C1449a c1449a) {
        K k = this.f6222j;
        if (k != null) {
            k.a();
        }
        this.g.j();
        K k5 = new K(this, this.g.getContext(), c1449a);
        Va.n nVar = k5.f;
        nVar.v();
        try {
            boolean zA = ((Ua.b) k5.g.b).a(k5, nVar);
            nVar.u();
            if (!zA) {
                return null;
            }
            k5.h();
            this.g.g(k5);
            v(true, null);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.h.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.c;
                if (actionBarCoordinatorLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarCoordinatorLayout);
                }
            }
            this.g.sendAccessibilityEvent(32);
            this.f6222j = k5;
            return k5;
        } catch (Throwable th) {
            nVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.AbstractC1955d
    public final Ua.c u(C1449a c1449a) {
        K k = this.f6222j;
        if (k != null) {
            k.a();
        }
        this.g.j();
        K k5 = new K(this, this.g.getContext(), c1449a);
        Va.n nVar = k5.f;
        nVar.v();
        try {
            if (!((Ua.b) k5.g.b).a(k5, nVar)) {
                return null;
            }
            k5.h();
            this.g.setSplitView(this.h);
            this.g.h(k5);
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f;
            ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout.f6505A;
            if (actionBarContextView != null) {
                View customView = actionBarContextView.getCustomView();
                if (customView instanceof stepos.support.v7.widget.F) {
                    stepos.support.v7.widget.F f = (stepos.support.v7.widget.F) customView;
                    stepOSCollapsingToolbarLayout.f6507C = f;
                    stepOSCollapsingToolbarLayout.f6506B = f.getTitleView();
                    stepos.support.v7.widget.F f7 = stepOSCollapsingToolbarLayout.f6507C;
                    C1980b0 c1980b0 = stepOSCollapsingToolbarLayout.E;
                    if (f7.f6458j == null) {
                        f7.f6458j = new ArrayList();
                    }
                    f7.f6458j.add(c1980b0);
                }
                stepOSCollapsingToolbarLayout.g(stepOSCollapsingToolbarLayout.f6508D);
            }
            v(true, k5);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.h.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.c;
                if (actionBarCoordinatorLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarCoordinatorLayout);
                }
            }
            this.g.sendAccessibilityEvent(32);
            this.f6222j = k5;
            return k5;
        } finally {
            nVar.u();
        }
    }

    public final void v(boolean z10, K k) {
        if (k != null ? true : z10) {
            if (!this.o) {
                this.o = true;
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.c;
                if (actionBarCoordinatorLayout != null) {
                    actionBarCoordinatorLayout.setShowingForActionMode(true);
                }
                y();
            }
        } else if (this.o) {
            this.o = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout2 = this.c;
            if (actionBarCoordinatorLayout2 != null) {
                actionBarCoordinatorLayout2.setShowingForActionMode(false);
            }
            y();
        }
        (z10 ? this.d.b.setupAnimatorToVisibility(4, 100L) : this.d.b.setupAnimatorToVisibility(0, 200L)).start();
        this.g.f(z10);
    }

    public final void w(int i, int i6) {
        stepos.support.v7.widget.E e = this.d;
        int i10 = e.c;
        if ((i6 & 4) != 0) {
            this.i = true;
        }
        e.setDisplayOptions((i & i6) | ((~i6) & i10));
    }

    public final void x(boolean z10) {
        if (z10) {
            this.d.getClass();
        } else {
            this.d.getClass();
        }
        this.d.getClass();
        this.d.setCollapsible(false);
    }

    public final void y() {
        if (this.p) {
            return;
        }
        this.p = true;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f6223q;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.e.setVisibility(0);
        boolean z10 = this.f6224r;
        J j5 = this.u;
        if (z10) {
            ViewCompat.setTranslationY(this.e, 0.0f);
            ViewCompat.setTranslationY(this.e, -this.e.getHeight());
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(this.e).translationY(0.0f);
            viewPropertyAnimatorCompatTranslationY.setUpdateListener(this.f6227v);
            viewPropertyAnimatorCompatSet2.play(viewPropertyAnimatorCompatTranslationY);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null && !this.f6226t) {
                actionBarContainer.setVisibility(0);
                ViewCompat.setTranslationY(this.h, r1.getMeasuredHeight());
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.h).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.5f, 0.05f, 1.0f));
            viewPropertyAnimatorCompatSet2.setDuration(this.f6228w);
            viewPropertyAnimatorCompatSet2.setListener(j5);
            this.f6223q = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        } else {
            ViewCompat.setAlpha(this.e, 1.0f);
            ViewCompat.setTranslationY(this.e, 0.0f);
            ActionBarContainer actionBarContainer2 = this.h;
            if (actionBarContainer2 != null) {
                ViewCompat.setAlpha(actionBarContainer2, 1.0f);
                ViewCompat.setTranslationY(this.h, 0.0f);
                this.h.setVisibility(0);
            }
            j5.onAnimationEnd(null);
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.c;
        if (actionBarCoordinatorLayout != null) {
            ViewCompat.requestApplyInsets(actionBarCoordinatorLayout);
        }
    }
}
