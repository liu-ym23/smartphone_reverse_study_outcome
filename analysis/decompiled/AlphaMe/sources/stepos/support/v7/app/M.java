package stepos.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import j.C0622a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C0905z;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes2.dex */
public final class M extends AbstractC0860e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14300a;

    /* renamed from: b, reason: collision with root package name */
    public Context f14301b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionBarCoordinatorLayout f14302c;

    /* renamed from: d, reason: collision with root package name */
    public final C0905z f14303d;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSAppBarLayout f14304e;

    /* renamed from: f, reason: collision with root package name */
    public final StepOSCollapsingToolbarLayout f14305f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionBarContextView f14306g;

    /* renamed from: h, reason: collision with root package name */
    public final ActionBarContainer f14307h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14308i;

    /* renamed from: j, reason: collision with root package name */
    public L f14309j;

    /* renamed from: k, reason: collision with root package name */
    public L f14310k;

    /* renamed from: l, reason: collision with root package name */
    public K3.b f14311l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14312m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f14313n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f14314o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14315p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14316q;

    /* renamed from: r, reason: collision with root package name */
    public j.m f14317r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14318s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f14319t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14320u;

    /* renamed from: v, reason: collision with root package name */
    public final FrameLayout f14321v;

    /* renamed from: w, reason: collision with root package name */
    public final FrameLayout f14322w;

    /* renamed from: x, reason: collision with root package name */
    public final J f14323x;

    /* renamed from: y, reason: collision with root package name */
    public final K f14324y;

    /* renamed from: z, reason: collision with root package name */
    public final int f14325z;

    public M(Activity activity) {
        stepos.support.v7.widget.D wrapper;
        new ArrayList();
        this.f14313n = new ArrayList();
        this.f14314o = true;
        this.f14316q = true;
        this.f14323x = new J(this, 3);
        this.f14324y = new K(this);
        this.f14325z = 288;
        View decorView = activity.getWindow().getDecorView();
        this.f14302c = (ActionBarCoordinatorLayout) decorView.findViewById(R.id.decor_content_parent);
        this.f14306g = (ActionBarContextView) decorView.findViewById(R.id.action_context_bar);
        this.f14305f = (StepOSCollapsingToolbarLayout) decorView.findViewById(R.id.action_bar_container);
        this.f14304e = (StepOSAppBarLayout) decorView.findViewById(R.id.app_bar_layout);
        this.f14321v = (FrameLayout) decorView.findViewById(R.id.action_bar_spring_layout_middle);
        this.f14322w = (FrameLayout) decorView.findViewById(R.id.action_bar_spring_layout_quick);
        this.f14307h = (ActionBarContainer) decorView.findViewById(R.id.split_action_bar);
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f14305f;
        Object objFindViewById = decorView.findViewById(R.id.action_bar);
        if (objFindViewById instanceof stepos.support.v7.widget.D) {
            wrapper = (stepos.support.v7.widget.D) objFindViewById;
        } else {
            if (!(objFindViewById instanceof Toolbar)) {
                StringBuilder sb = new StringBuilder("Can't make a decor toolbar out of ");
                sb.append(objFindViewById);
                throw new IllegalStateException(sb.toString() != null ? objFindViewById.getClass().getSimpleName() : "null");
            }
            wrapper = ((Toolbar) objFindViewById).getWrapper();
        }
        if (stepOSCollapsingToolbarLayout.f14907x == null) {
            C0905z c0905z = new C0905z();
            c0905z.f15254a = stepOSCollapsingToolbarLayout;
            c0905z.f15255b = wrapper;
            c0905z.f15256c = wrapper.w();
            stepOSCollapsingToolbarLayout.f14907x = c0905z;
        }
        C0905z c0905z2 = stepOSCollapsingToolbarLayout.f14907x;
        this.f14303d = c0905z2;
        if (c0905z2 == null || this.f14306g == null || this.f14305f == null) {
            throw new IllegalStateException(M.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        c0905z2.s(new K(this));
        Context context = this.f14303d.f15255b.getContext();
        this.f14300a = context;
        int i4 = this.f14303d.f15256c;
        boolean z4 = (i4 & 4) != 0;
        if (z4) {
            this.f14308i = true;
        }
        o(C0622a.c(context).b() || z4);
        boolean z5 = (i4 & 32) != 0;
        this.f14319t = z5;
        if ((i4 & 8) != 0 && z5) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        x(z5);
        TypedArray typedArrayObtainStyledAttributes = this.f14300a.obtainStyledAttributes(null, AbstractC0560a.f12588a, R.attr.steposActionBarStyleFullScreen, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            float f4 = dimensionPixelSize;
            StepOSAppBarLayout stepOSAppBarLayout = this.f14304e;
            WeakHashMap weakHashMap = K.S.f939a;
            K.J.s(stepOSAppBarLayout, f4);
            ActionBarContainer actionBarContainer = this.f14307h;
            if (actionBarContainer != null) {
                K.J.s(actionBarContainer, f4);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f14320u = this.f14316q && this.f14305f.getHeight() == 0;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final boolean a() {
        C0905z c0905z = this.f14303d;
        if (c0905z == null || !c0905z.f15255b.r()) {
            return false;
        }
        this.f14303d.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void b(boolean z4) {
        if (z4 == this.f14312m) {
            return;
        }
        this.f14312m = z4;
        ArrayList arrayList = this.f14313n;
        if (arrayList.size() <= 0) {
            return;
        }
        B0.g.y(arrayList.get(0));
        throw null;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final int c() {
        return this.f14303d.f15256c;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final Context d() {
        if (this.f14301b == null) {
            TypedValue typedValue = new TypedValue();
            this.f14300a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                this.f14301b = new ContextThemeWrapper(this.f14300a, i4);
            } else {
                this.f14301b = this.f14300a;
            }
        }
        return this.f14301b;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final stepos.support.v7.widget.D e() {
        return this.f14303d;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void g() {
        x(this.f14319t);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void j(Drawable drawable) {
        this.f14304e.setPrimaryBackground(drawable);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void k(boolean z4) {
        if (this.f14308i) {
            return;
        }
        l(z4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void l(boolean z4) {
        int i4 = z4 ? 4 : 0;
        C0905z c0905z = this.f14303d;
        int i5 = c0905z.f15256c;
        this.f14308i = true;
        c0905z.t((i4 & 4) | (i5 & (-5)));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void m() {
        C0905z c0905z = this.f14303d;
        c0905z.t(c0905z.f15256c & (-3));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void n() {
        this.f14303d.m();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void o(boolean z4) {
        this.f14303d.o(z4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void p(boolean z4) {
        j.m mVar;
        this.f14318s = z4;
        if (z4 || (mVar = this.f14317r) == null) {
            return;
        }
        mVar.a();
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void q(int i4) {
        r(this.f14300a.getString(i4));
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void r(CharSequence charSequence) {
        this.f14303d.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void s(int i4) {
        this.f14302c.setUiOptions(i4);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final void t(CharSequence charSequence) {
        this.f14303d.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final K3.c u(B0.e eVar) {
        L l4 = this.f14309j;
        if (l4 != null) {
            l4.a();
        }
        this.f14306g.j();
        L l5 = new L(this, this.f14306g.getContext(), eVar);
        if (!l5.q()) {
            return null;
        }
        l5.i();
        this.f14306g.g(l5);
        w(true, null);
        ActionBarContainer actionBarContainer = this.f14307h;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f14307h.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f14302c;
            if (actionBarCoordinatorLayout != null) {
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(actionBarCoordinatorLayout);
            }
        }
        this.f14306g.sendAccessibilityEvent(32);
        this.f14309j = l5;
        return l5;
    }

    @Override // stepos.support.v7.app.AbstractC0860e
    public final K3.c v(B0.e eVar) {
        L l4 = this.f14309j;
        if (l4 != null) {
            l4.a();
        }
        this.f14306g.j();
        L l5 = new L(this, this.f14306g.getContext(), eVar);
        if (!l5.q()) {
            return null;
        }
        l5.i();
        this.f14306g.setSplitView(this.f14307h);
        this.f14306g.h(l5);
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f14305f;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout.f14902A;
        if (actionBarContextView != null) {
            View customView = actionBarContextView.getCustomView();
            if (customView instanceof stepos.support.v7.widget.A) {
                stepos.support.v7.widget.A a4 = (stepos.support.v7.widget.A) customView;
                stepOSCollapsingToolbarLayout.f14904C = a4;
                stepOSCollapsingToolbarLayout.f14903B = a4.getTitleView();
                stepos.support.v7.widget.A a5 = stepOSCollapsingToolbarLayout.f14904C;
                if (a5.f14703y == null) {
                    a5.f14703y = new ArrayList();
                }
                a5.f14703y.add(stepOSCollapsingToolbarLayout.f14906E);
            }
            stepOSCollapsingToolbarLayout.g(stepOSCollapsingToolbarLayout.f14905D);
        }
        w(true, l5);
        ActionBarContainer actionBarContainer = this.f14307h;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
            this.f14307h.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f14302c;
            if (actionBarCoordinatorLayout != null) {
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(actionBarCoordinatorLayout);
            }
        }
        this.f14306g.sendAccessibilityEvent(32);
        this.f14309j = l5;
        return l5;
    }

    public final void w(boolean z4, L l4) {
        boolean z5;
        if (l4 != null) {
            switch (l4.f14292d) {
                case 0:
                    z5 = l4.f14298j;
                    break;
                default:
                    z5 = l4.f14298j;
                    break;
            }
        } else {
            z5 = z4;
        }
        if (z5) {
            if (!this.f14315p) {
                this.f14315p = true;
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f14302c;
                if (actionBarCoordinatorLayout != null) {
                    actionBarCoordinatorLayout.setShowingForActionMode(true);
                }
                y();
            }
        } else if (this.f14315p) {
            this.f14315p = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout2 = this.f14302c;
            if (actionBarCoordinatorLayout2 != null) {
                actionBarCoordinatorLayout2.setShowingForActionMode(false);
            }
            y();
        }
        (z4 ? this.f14303d.f15255b.z(4, 100L) : this.f14303d.f15255b.z(0, 200L)).g();
        this.f14306g.f(z4);
    }

    public final void x(boolean z4) {
        if (z4) {
            this.f14303d.getClass();
        } else {
            this.f14303d.getClass();
        }
        this.f14303d.getClass();
        this.f14303d.F(false);
    }

    public final void y() {
        int i4 = this.f14325z;
        if (this.f14316q) {
            return;
        }
        this.f14316q = true;
        j.m mVar = this.f14317r;
        if (mVar != null) {
            mVar.a();
        }
        this.f14304e.setVisibility(0);
        boolean z4 = this.f14318s;
        J j4 = this.f14323x;
        if (z4) {
            StepOSAppBarLayout stepOSAppBarLayout = this.f14304e;
            WeakHashMap weakHashMap = K.S.f939a;
            stepOSAppBarLayout.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            this.f14304e.setTranslationY(-this.f14304e.getHeight());
            j.m mVar2 = new j.m();
            K.e0 e0VarA = K.S.a(this.f14304e);
            e0VarA.h(Property.DEFAULT_FLOAT_VALUE);
            e0VarA.f(this.f14324y);
            mVar2.b(e0VarA);
            ActionBarContainer actionBarContainer = this.f14307h;
            if (actionBarContainer != null && !this.f14320u) {
                actionBarContainer.setVisibility(0);
                this.f14307h.setTranslationY(r2.getMeasuredHeight());
                K.e0 e0VarA2 = K.S.a(this.f14307h);
                e0VarA2.h(Property.DEFAULT_FLOAT_VALUE);
                mVar2.b(e0VarA2);
            }
            mVar2.d(M.a.b(0.2f, 0.5f, 0.05f, 1.0f));
            mVar2.c(i4);
            mVar2.e(j4);
            this.f14317r = mVar2;
            mVar2.f();
        } else {
            StepOSAppBarLayout stepOSAppBarLayout2 = this.f14304e;
            WeakHashMap weakHashMap2 = K.S.f939a;
            stepOSAppBarLayout2.setAlpha(1.0f);
            this.f14304e.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
            ActionBarContainer actionBarContainer2 = this.f14307h;
            if (actionBarContainer2 != null) {
                actionBarContainer2.setAlpha(1.0f);
                this.f14307h.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                this.f14307h.setVisibility(0);
            }
            j4.c(null);
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f14302c;
        if (actionBarCoordinatorLayout != null) {
            K.H.c(actionBarCoordinatorLayout);
        }
    }
}
