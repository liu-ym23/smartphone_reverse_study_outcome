package stepos.support.v7.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.stepos.aiengine.R;
import fe.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.app.AppCompatDelegateImplV7;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.ActionMenuPresenter;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.h;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class x extends stepos.support.v7.app.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12271a;

    /* renamed from: b, reason: collision with root package name */
    public Context f12272b;

    /* renamed from: c, reason: collision with root package name */
    public final ActionBarCoordinatorLayout f12273c;

    /* renamed from: d, reason: collision with root package name */
    public final stepos.support.v7.widget.g f12274d;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSAppBarLayout f12275e;

    /* renamed from: f, reason: collision with root package name */
    public final StepOSCollapsingToolbarLayout f12276f;

    /* renamed from: g, reason: collision with root package name */
    public final ActionBarContextView f12277g;
    public final ActionBarContainer h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12278i;

    /* renamed from: j, reason: collision with root package name */
    public d f12279j;

    /* renamed from: k, reason: collision with root package name */
    public d f12280k;

    /* renamed from: l, reason: collision with root package name */
    public AppCompatDelegateImplV7.e f12281l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12282m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<a.d> f12283n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12284o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12285p;

    /* renamed from: q, reason: collision with root package name */
    public k.g f12286q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f12287s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12288t;

    /* renamed from: u, reason: collision with root package name */
    public final b f12289u;

    /* renamed from: v, reason: collision with root package name */
    public final c f12290v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12291w;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends mb.y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            x xVar = x.this;
            ActionBarContainer actionBarContainer = xVar.h;
            if (actionBarContainer != null) {
                actionBarContainer.setVisibility(8);
            }
            xVar.f12275e.setVisibility(8);
            xVar.f12275e.setTransitioning(false);
            xVar.f12286q = null;
            xVar.f12288t = false;
            AppCompatDelegateImplV7.e eVar = xVar.f12281l;
            if (eVar != null) {
                eVar.b(xVar.f12280k);
                xVar.f12280k = null;
                xVar.f12281l = null;
            }
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = xVar.f12273c;
            if (actionBarCoordinatorLayout != null) {
                WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                e0.c.b(actionBarCoordinatorLayout);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends mb.y {
        public b() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            x xVar = x.this;
            xVar.f12286q = null;
            xVar.f12288t = true;
            StepOSAppBarLayout stepOSAppBarLayout = xVar.f12275e;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            stepOSAppBarLayout.setTranslationY(0.0f);
            ActionBarContainer actionBarContainer = xVar.h;
            if (actionBarContainer != null) {
                actionBarContainer.setTranslationY(0.0f);
            }
            xVar.f12275e.requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements v0.j0 {
        public c() {
        }

        @Override // v0.j0
        public final void a() {
            ((View) x.this.f12276f.getParent()).invalidate();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends fe.b implements c.a {

        /* renamed from: d, reason: collision with root package name */
        public final Context f12295d;

        /* renamed from: e, reason: collision with root package name */
        public final stepos.support.v7.view.menu.c f12296e;

        /* renamed from: f, reason: collision with root package name */
        public AppCompatDelegateImplV7.e f12297f;

        /* renamed from: g, reason: collision with root package name */
        public WeakReference<View> f12298g;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements b.a {
        }

        public d(Context context, AppCompatDelegateImplV7.e eVar) {
            a aVar = new a();
            this.f12295d = context;
            this.f12297f = eVar;
            stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(context);
            cVar.f12383n = 1;
            this.f12296e = cVar;
            cVar.f12377d = this;
            this.f8853c = aVar;
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final void a(stepos.support.v7.view.menu.c cVar) {
            if (this.f12297f == null) {
                return;
            }
            i();
            ActionMenuPresenter actionMenuPresenter = x.this.f12277g.f12689d;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.o();
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            AppCompatDelegateImplV7.e eVar = this.f12297f;
            if (eVar != null) {
                return eVar.f12018a.a(this, menuItem);
            }
            return false;
        }

        @Override // fe.b
        public final void c() {
            x xVar = x.this;
            if (xVar.f12279j != this) {
                return;
            }
            this.f12297f.b(this);
            this.f12297f = null;
            xVar.t(false, null);
            ActionBarContextView actionBarContextView = xVar.f12277g;
            if (actionBarContextView.f12449q == null && !actionBarContextView.A) {
                actionBarContextView.j();
            }
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = xVar.f12276f;
            stepos.support.v7.widget.d dVar = stepOSCollapsingToolbarLayout.f12742n;
            stepos.support.v7.widget.s sVar = stepOSCollapsingToolbarLayout.E;
            if (sVar != null) {
                sVar.setVisibility(0);
            }
            dVar.n(stepOSCollapsingToolbarLayout.getTitle());
            dVar.G.setAlpha((int) 255.0f);
            stepos.support.v7.widget.h hVar = stepOSCollapsingToolbarLayout.G;
            if (hVar != null) {
                StepOSCollapsingToolbarLayout.a aVar = stepOSCollapsingToolbarLayout.I;
                ArrayList<h.a> arrayList = hVar.B;
                if (arrayList != null) {
                    arrayList.remove(aVar);
                }
            }
            stepOSCollapsingToolbarLayout.G = null;
            stepOSCollapsingToolbarLayout.F = null;
            xVar.f12274d.f12794b.u().sendAccessibilityEvent(32);
            xVar.f12279j = null;
        }

        @Override // fe.b
        public final View d() {
            WeakReference<View> weakReference = this.f12298g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // fe.b
        public final stepos.support.v7.view.menu.c e() {
            return this.f12296e;
        }

        @Override // fe.b
        public final fe.i f() {
            return new fe.i(this.f12295d);
        }

        @Override // fe.b
        public final CharSequence g() {
            return x.this.f12277g.getSubtitle();
        }

        @Override // fe.b
        public final CharSequence h() {
            return x.this.f12277g.getTitle();
        }

        @Override // fe.b
        public final void i() {
            if (x.this.f12279j != this) {
                return;
            }
            stepos.support.v7.view.menu.c cVar = this.f12296e;
            cVar.v();
            try {
                this.f12297f.c(this, cVar);
            } finally {
                cVar.u();
            }
        }

        @Override // fe.b
        public final boolean j() {
            return x.this.f12277g.f12455x;
        }

        @Override // fe.b
        public final void k(View view) {
            x.this.f12277g.setCustomView(view);
            this.f12298g = new WeakReference<>(view);
        }

        @Override // fe.b
        public final void l(int i10) {
            m(x.this.f12271a.getResources().getString(i10));
        }

        @Override // fe.b
        public final void m(CharSequence charSequence) {
            x.this.f12277g.setSubtitle(charSequence);
        }

        @Override // fe.b
        public final void n(int i10) {
            o(x.this.f12271a.getResources().getString(i10));
        }

        @Override // fe.b
        public final void o(CharSequence charSequence) {
            x.this.f12277g.setTitle(charSequence);
        }

        @Override // fe.b
        public final void p(boolean z) {
            this.f8852b = z;
            x.this.f12277g.setTitleOptional(z);
        }
    }

    public x(Activity activity) {
        stepos.support.v7.widget.k wrapper;
        new ArrayList();
        this.f12283n = new ArrayList<>();
        this.f12285p = true;
        new a();
        this.f12289u = new b();
        this.f12290v = new c();
        this.f12291w = 288;
        View decorView = activity.getWindow().getDecorView();
        this.f12273c = (ActionBarCoordinatorLayout) decorView.findViewById(R.id.decor_content_parent);
        this.f12277g = (ActionBarContextView) decorView.findViewById(R.id.action_context_bar);
        this.f12276f = (StepOSCollapsingToolbarLayout) decorView.findViewById(R.id.action_bar_container);
        this.f12275e = (StepOSAppBarLayout) decorView.findViewById(R.id.app_bar_layout);
        this.h = (ActionBarContainer) decorView.findViewById(R.id.split_action_bar);
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12276f;
        Object objFindViewById = decorView.findViewById(R.id.action_bar);
        if (objFindViewById instanceof stepos.support.v7.widget.k) {
            wrapper = (stepos.support.v7.widget.k) objFindViewById;
        } else {
            if (!(objFindViewById instanceof Toolbar)) {
                StringBuilder sb2 = new StringBuilder("Can't make a decor toolbar out of ");
                sb2.append(objFindViewById);
                throw new IllegalStateException(sb2.toString() != null ? objFindViewById.getClass().getSimpleName() : "null");
            }
            wrapper = ((Toolbar) objFindViewById).getWrapper();
        }
        if (stepOSCollapsingToolbarLayout.A == null) {
            stepos.support.v7.widget.g gVar = new stepos.support.v7.widget.g();
            gVar.f12793a = stepOSCollapsingToolbarLayout;
            gVar.f12794b = wrapper;
            gVar.f12795c = wrapper.p();
            stepOSCollapsingToolbarLayout.A = gVar;
        }
        stepos.support.v7.widget.g gVar2 = stepOSCollapsingToolbarLayout.A;
        this.f12274d = gVar2;
        if (gVar2 == null || this.f12277g == null || this.f12276f == null) {
            throw new IllegalStateException(x.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        gVar2.t(new y());
        Context context = this.f12274d.f12794b.getContext();
        this.f12271a = context;
        int i10 = this.f12274d.f12795c;
        boolean z = (i10 & 4) != 0;
        if (z) {
            this.f12278i = true;
        }
        m(fe.a.a(context).f8850a.getApplicationInfo().targetSdkVersion < 14 || z);
        boolean z3 = (i10 & 32) != 0;
        this.f12287s = z3;
        if ((i10 & 8) != 0 && z3) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        v(z3);
        TypedArray typedArrayObtainStyledAttributes = this.f12271a.obtainStyledAttributes(null, g.a.f8921a, R.attr.steposActionBarStyleFullScreen, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            float f8 = dimensionPixelSize;
            StepOSAppBarLayout stepOSAppBarLayout = this.f12275e;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.d.j(stepOSAppBarLayout, f8);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null) {
                e0.d.j(actionBarContainer, f8);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f12288t = this.f12285p && this.f12276f.getHeight() == 0;
    }

    @Override // stepos.support.v7.app.a
    public final boolean a() {
        stepos.support.v7.widget.g gVar = this.f12274d;
        if (gVar == null || !gVar.f12794b.g()) {
            return false;
        }
        this.f12274d.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public final void b(boolean z) {
        if (z == this.f12282m) {
            return;
        }
        this.f12282m = z;
        ArrayList<a.d> arrayList = this.f12283n;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).a();
        }
    }

    @Override // stepos.support.v7.app.a
    public final int c() {
        return this.f12274d.f12795c;
    }

    @Override // stepos.support.v7.app.a
    public final Context d() {
        if (this.f12272b == null) {
            TypedValue typedValue = new TypedValue();
            this.f12271a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f12272b = new ContextThemeWrapper(this.f12271a, i10);
            } else {
                this.f12272b = this.f12271a;
            }
        }
        return this.f12272b;
    }

    @Override // stepos.support.v7.app.a
    public final void f() {
        v(this.f12287s);
    }

    @Override // stepos.support.v7.app.a
    public final void i(boolean z) {
        if (this.f12278i) {
            return;
        }
        j(z);
    }

    @Override // stepos.support.v7.app.a
    public final void j(boolean z) {
        u(z ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public final void k() {
        u(0, 2);
    }

    @Override // stepos.support.v7.app.a
    public final void l() {
        if (this.f12287s) {
            throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
        }
        u(8, 8);
    }

    @Override // stepos.support.v7.app.a
    public final void m(boolean z) {
        this.f12274d.v(z);
    }

    @Override // stepos.support.v7.app.a
    public final void n(boolean z) {
        k.g gVar;
        this.r = z;
        if (z || (gVar = this.f12286q) == null) {
            return;
        }
        gVar.a();
    }

    @Override // stepos.support.v7.app.a
    public final void o(CharSequence charSequence) {
        this.f12274d.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final void p(int i10) {
        this.f12273c.setUiOptions(i10);
    }

    @Override // stepos.support.v7.app.a
    public final void q(CharSequence charSequence) {
        this.f12274d.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final fe.b r(AppCompatDelegateImplV7.e eVar) {
        d dVar = this.f12279j;
        if (dVar != null) {
            dVar.c();
        }
        ActionBarContextView actionBarContextView = this.f12277g;
        actionBarContextView.j();
        d dVar2 = new d(actionBarContextView.getContext(), eVar);
        stepos.support.v7.view.menu.c cVar = dVar2.f12296e;
        cVar.v();
        try {
            boolean zD = dVar2.f12297f.f12018a.d(dVar2, cVar);
            cVar.u();
            if (!zD) {
                return null;
            }
            dVar2.i();
            actionBarContextView.g(dVar2);
            t(true, null);
            ActionBarContainer actionBarContainer = this.h;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                actionBarContainer.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12273c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                    e0.c.b(actionBarCoordinatorLayout);
                }
            }
            actionBarContextView.sendAccessibilityEvent(32);
            this.f12279j = dVar2;
            return dVar2;
        } catch (Throwable th) {
            cVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.a
    public final fe.b s(AppCompatDelegateImplV7.e eVar) {
        d dVar = this.f12279j;
        if (dVar != null) {
            dVar.c();
        }
        ActionBarContextView actionBarContextView = this.f12277g;
        actionBarContextView.j();
        d dVar2 = new d(actionBarContextView.getContext(), eVar);
        stepos.support.v7.view.menu.c cVar = dVar2.f12296e;
        cVar.v();
        try {
            if (!dVar2.f12297f.f12018a.d(dVar2, cVar)) {
                return null;
            }
            dVar2.i();
            ActionBarContainer actionBarContainer = this.h;
            actionBarContextView.setSplitView(actionBarContainer);
            actionBarContextView.h(dVar2);
            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f12276f;
            ActionBarContextView actionBarContextView2 = stepOSCollapsingToolbarLayout.D;
            if (actionBarContextView2 != null) {
                View customView = actionBarContextView2.getCustomView();
                if (customView instanceof stepos.support.v7.widget.h) {
                    stepos.support.v7.widget.h hVar = (stepos.support.v7.widget.h) customView;
                    stepOSCollapsingToolbarLayout.G = hVar;
                    stepOSCollapsingToolbarLayout.F = hVar.getTitleView();
                    stepos.support.v7.widget.h hVar2 = stepOSCollapsingToolbarLayout.G;
                    StepOSCollapsingToolbarLayout.a aVar = stepOSCollapsingToolbarLayout.I;
                    if (hVar2.B == null) {
                        hVar2.B = new ArrayList<>();
                    }
                    hVar2.B.add(aVar);
                }
                stepos.support.v7.widget.s sVar = stepOSCollapsingToolbarLayout.E;
                if (sVar != null) {
                    sVar.setVisibility(8);
                }
                stepOSCollapsingToolbarLayout.h(stepOSCollapsingToolbarLayout.H);
            }
            t(true, dVar2);
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                actionBarContainer.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12273c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                    e0.c.b(actionBarCoordinatorLayout);
                }
            }
            actionBarContextView.sendAccessibilityEvent(32);
            this.f12279j = dVar2;
            return dVar2;
        } finally {
            cVar.u();
        }
    }

    public final void t(boolean z, d dVar) {
        if (dVar != null ? true : z) {
            if (!this.f12284o) {
                this.f12284o = true;
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12273c;
                if (actionBarCoordinatorLayout != null) {
                    actionBarCoordinatorLayout.setShowingForActionMode(true);
                }
                w();
            }
        } else if (this.f12284o) {
            this.f12284o = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout2 = this.f12273c;
            if (actionBarCoordinatorLayout2 != null) {
                actionBarCoordinatorLayout2.setShowingForActionMode(false);
            }
            w();
        }
        (z ? this.f12274d.f12794b.i(4, 100L) : this.f12274d.f12794b.i(0, 200L)).g();
        this.f12277g.f(z);
    }

    public final void u(int i10, int i11) {
        stepos.support.v7.widget.g gVar = this.f12274d;
        int i12 = gVar.f12795c;
        if ((i11 & 4) != 0) {
            this.f12278i = true;
        }
        gVar.h((i10 & i11) | ((~i11) & i12));
    }

    public final void v(boolean z) {
        if (z) {
            this.f12274d.getClass();
        } else {
            this.f12274d.getClass();
        }
        this.f12274d.getClass();
        this.f12274d.k(false);
    }

    public final void w() {
        if (this.f12285p) {
            return;
        }
        this.f12285p = true;
        k.g gVar = this.f12286q;
        if (gVar != null) {
            gVar.a();
        }
        StepOSAppBarLayout stepOSAppBarLayout = this.f12275e;
        stepOSAppBarLayout.setVisibility(0);
        boolean z = this.r;
        ActionBarContainer actionBarContainer = this.h;
        b bVar = this.f12289u;
        if (z) {
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            stepOSAppBarLayout.setTranslationY(0.0f);
            stepOSAppBarLayout.setTranslationY(-stepOSAppBarLayout.getHeight());
            k.g gVar2 = new k.g();
            v0.h0 h0VarA = v0.e0.a(stepOSAppBarLayout);
            h0VarA.h(0.0f);
            h0VarA.f(this.f12290v);
            gVar2.b(h0VarA);
            if (actionBarContainer != null && !this.f12288t) {
                actionBarContainer.setVisibility(0);
                actionBarContainer.setTranslationY(actionBarContainer.getMeasuredHeight());
                v0.h0 h0VarA2 = v0.e0.a(actionBarContainer);
                h0VarA2.h(0.0f);
                gVar2.b(h0VarA2);
            }
            gVar2.d(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
            gVar2.c(this.f12291w);
            gVar2.e(bVar);
            this.f12286q = gVar2;
            gVar2.f();
        } else {
            WeakHashMap<View, v0.h0> weakHashMap2 = v0.e0.f13274a;
            stepOSAppBarLayout.setAlpha(1.0f);
            stepOSAppBarLayout.setTranslationY(0.0f);
            if (actionBarContainer != null) {
                actionBarContainer.setAlpha(1.0f);
                actionBarContainer.setTranslationY(0.0f);
                actionBarContainer.setVisibility(0);
            }
            bVar.d(null);
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.f12273c;
        if (actionBarCoordinatorLayout != null) {
            e0.c.b(actionBarCoordinatorLayout);
        }
    }
}
