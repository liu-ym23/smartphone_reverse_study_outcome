package stepos.support.v7.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import fe.b;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.WeakHashMap;
import stepos.support.v7.app.AppCompatDelegateImplV7;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.ActionMenuPresenter;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.e0;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class o0 extends stepos.support.v7.app.a implements ActionBarOverlayLayout.e {
    public static final boolean E;
    public final a A;
    public final b B;
    public final c C;
    public final int D;

    /* renamed from: a, reason: collision with root package name */
    public Context f12173a;

    /* renamed from: b, reason: collision with root package name */
    public Context f12174b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f12175c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f12176d;

    /* renamed from: e, reason: collision with root package name */
    public stepos.support.v7.widget.k f12177e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f12178f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContainer f12179g;
    public final FitsWindowsContentLayout h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12180i;

    /* renamed from: j, reason: collision with root package name */
    public e f12181j;

    /* renamed from: k, reason: collision with root package name */
    public e f12182k;

    /* renamed from: l, reason: collision with root package name */
    public AppCompatDelegateImplV7.e f12183l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12184m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<a.d> f12185n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12186o;

    /* renamed from: p, reason: collision with root package name */
    public int f12187p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12188q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12189s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12190t;

    /* renamed from: u, reason: collision with root package name */
    public k.g f12191u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12192v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12193w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12194x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f12195y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends mb.y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            FitsWindowsContentLayout fitsWindowsContentLayout;
            o0 o0Var = o0.this;
            if (o0Var.f12188q && (fitsWindowsContentLayout = o0Var.h) != null) {
                WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                fitsWindowsContentLayout.setTranslationY(0.0f);
                o0Var.f12176d.setTranslationY(0.0f);
            }
            ActionBarContainer actionBarContainer = o0Var.f12179g;
            if (actionBarContainer != null) {
                actionBarContainer.setVisibility(8);
            }
            o0Var.f12176d.setVisibility(8);
            o0Var.f12176d.setTransitioning(false);
            o0Var.f12191u = null;
            o0Var.z = false;
            AppCompatDelegateImplV7.e eVar = o0Var.f12183l;
            if (eVar != null) {
                eVar.b(o0Var.f12182k);
                o0Var.f12182k = null;
                o0Var.f12183l = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = o0Var.f12175c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, v0.h0> weakHashMap2 = v0.e0.f13274a;
                e0.c.b(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends mb.y {
        public b() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            o0 o0Var = o0.this;
            o0Var.f12191u = null;
            o0Var.z = true;
            ActionBarContainer actionBarContainer = o0Var.f12176d;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            actionBarContainer.setTranslationY(0.0f);
            ActionBarContainer actionBarContainer2 = o0Var.f12179g;
            if (actionBarContainer2 != null) {
                actionBarContainer2.setTranslationY(0.0f);
            }
            o0Var.f12176d.requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements v0.j0 {
        public c() {
        }

        @Override // v0.j0
        public final void a() {
            ((View) o0.this.f12176d.getParent()).invalidate();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements a.InterfaceC0141a {
        @Override // stepos.support.v7.app.a.InterfaceC0141a
        public final void a(int i10, e0.d dVar) {
            if (i10 != 0 && i10 != 1) {
                throw new InvalidParameterException();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends fe.b implements c.a {

        /* renamed from: d, reason: collision with root package name */
        public final Context f12199d;

        /* renamed from: e, reason: collision with root package name */
        public final stepos.support.v7.view.menu.c f12200e;

        /* renamed from: f, reason: collision with root package name */
        public AppCompatDelegateImplV7.e f12201f;

        /* renamed from: g, reason: collision with root package name */
        public WeakReference<View> f12202g;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements b.a {
        }

        public e(Context context, AppCompatDelegateImplV7.e eVar) {
            a aVar = new a();
            this.f12199d = context;
            this.f12201f = eVar;
            stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(context);
            cVar.f12383n = 1;
            this.f12200e = cVar;
            cVar.f12377d = this;
            this.f8853c = aVar;
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final void a(stepos.support.v7.view.menu.c cVar) {
            if (this.f12201f == null) {
                return;
            }
            i();
            ActionMenuPresenter actionMenuPresenter = o0.this.f12178f.f12689d;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.o();
            }
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            AppCompatDelegateImplV7.e eVar = this.f12201f;
            if (eVar != null) {
                return eVar.f12018a.a(this, menuItem);
            }
            return false;
        }

        @Override // fe.b
        public final void c() {
            o0 o0Var = o0.this;
            if (o0Var.f12181j != this) {
                return;
            }
            if (o0Var.r) {
                o0Var.f12182k = this;
                o0Var.f12183l = this.f12201f;
            } else {
                this.f12201f.b(this);
            }
            this.f12201f = null;
            o0Var.t(false, null);
            ActionBarContextView actionBarContextView = o0Var.f12178f;
            if (actionBarContextView.f12449q == null && !actionBarContextView.A) {
                actionBarContextView.j();
            }
            o0Var.f12177e.u().sendAccessibilityEvent(32);
            o0Var.f12175c.setHideOnContentScrollEnabled(o0Var.f12193w);
            o0Var.f12181j = null;
        }

        @Override // fe.b
        public final View d() {
            WeakReference<View> weakReference = this.f12202g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // fe.b
        public final stepos.support.v7.view.menu.c e() {
            return this.f12200e;
        }

        @Override // fe.b
        public final fe.i f() {
            return new fe.i(this.f12199d);
        }

        @Override // fe.b
        public final CharSequence g() {
            return o0.this.f12178f.getSubtitle();
        }

        @Override // fe.b
        public final CharSequence h() {
            return o0.this.f12178f.getTitle();
        }

        @Override // fe.b
        public final void i() {
            if (o0.this.f12181j != this) {
                return;
            }
            stepos.support.v7.view.menu.c cVar = this.f12200e;
            cVar.v();
            try {
                this.f12201f.c(this, cVar);
            } finally {
                cVar.u();
            }
        }

        @Override // fe.b
        public final boolean j() {
            return o0.this.f12178f.f12455x;
        }

        @Override // fe.b
        public final void k(View view) {
            o0.this.f12178f.setCustomView(view);
            this.f12202g = new WeakReference<>(view);
        }

        @Override // fe.b
        public final void l(int i10) {
            m(o0.this.f12173a.getResources().getString(i10));
        }

        @Override // fe.b
        public final void m(CharSequence charSequence) {
            o0.this.f12178f.setSubtitle(charSequence);
        }

        @Override // fe.b
        public final void n(int i10) {
            o(o0.this.f12173a.getResources().getString(i10));
        }

        @Override // fe.b
        public final void o(CharSequence charSequence) {
            o0.this.f12178f.setTitle(charSequence);
        }

        @Override // fe.b
        public final void p(boolean z) {
            this.f8852b = z;
            o0.this.f12178f.setTitleOptional(z);
        }
    }

    static {
        new AccelerateInterpolator();
        new DecelerateInterpolator();
        E = true;
    }

    public o0(Activity activity, boolean z) throws Resources.NotFoundException {
        new ArrayList();
        this.f12185n = new ArrayList<>();
        this.f12187p = 0;
        this.f12188q = true;
        this.f12190t = true;
        this.f12195y = true;
        this.A = new a();
        this.B = new b();
        this.C = new c();
        this.D = 288;
        View decorView = activity.getWindow().getDecorView();
        u(decorView);
        if (z) {
            return;
        }
        this.h = (FitsWindowsContentLayout) decorView.findViewById(R.id.content);
    }

    @Override // stepos.support.v7.app.a
    public final boolean a() {
        stepos.support.v7.widget.k kVar = this.f12177e;
        if (kVar == null || !kVar.g()) {
            return false;
        }
        this.f12177e.collapseActionView();
        return true;
    }

    @Override // stepos.support.v7.app.a
    public final void b(boolean z) {
        if (z == this.f12184m) {
            return;
        }
        this.f12184m = z;
        ArrayList<a.d> arrayList = this.f12185n;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).a();
        }
    }

    @Override // stepos.support.v7.app.a
    public final int c() {
        return this.f12177e.p();
    }

    @Override // stepos.support.v7.app.a
    public final Context d() {
        if (this.f12174b == null) {
            TypedValue typedValue = new TypedValue();
            this.f12173a.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f12174b = new ContextThemeWrapper(this.f12173a, i10);
            } else {
                this.f12174b = this.f12173a;
            }
        }
        return this.f12174b;
    }

    @Override // stepos.support.v7.app.a
    public final void f() throws Resources.NotFoundException {
        w((this.f12195y && fe.a.a(this.f12173a).c()) || this.f12194x);
    }

    @Override // stepos.support.v7.app.a
    public final void i(boolean z) {
        if (this.f12180i) {
            return;
        }
        j(z);
    }

    @Override // stepos.support.v7.app.a
    public final void j(boolean z) {
        v(z ? 4 : 0, 4);
    }

    @Override // stepos.support.v7.app.a
    public final void k() {
        v(0, 2);
    }

    @Override // stepos.support.v7.app.a
    public final void l() {
        v(8, 8);
    }

    @Override // stepos.support.v7.app.a
    public final void m(boolean z) {
        this.f12177e.v(z);
    }

    @Override // stepos.support.v7.app.a
    public final void n(boolean z) {
        k.g gVar;
        this.f12192v = z;
        if (z || (gVar = this.f12191u) == null) {
            return;
        }
        gVar.a();
    }

    @Override // stepos.support.v7.app.a
    public final void o(CharSequence charSequence) {
        this.f12177e.setTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final void p(int i10) {
        this.f12175c.setUiOptions(i10);
    }

    @Override // stepos.support.v7.app.a
    public final void q(CharSequence charSequence) {
        this.f12177e.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.app.a
    public final fe.b r(AppCompatDelegateImplV7.e eVar) {
        e eVar2 = this.f12181j;
        if (eVar2 != null) {
            eVar2.c();
        }
        this.f12175c.setHideOnContentScrollEnabled(false);
        this.f12178f.j();
        e eVar3 = new e(this.f12178f.getContext(), eVar);
        stepos.support.v7.view.menu.c cVar = eVar3.f12200e;
        cVar.v();
        try {
            boolean zD = eVar3.f12201f.f12018a.d(eVar3, cVar);
            cVar.u();
            if (!zD) {
                return null;
            }
            eVar3.i();
            this.f12178f.g(eVar3);
            t(true, null);
            ActionBarContainer actionBarContainer = this.f12179g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12179g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12175c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                    e0.c.b(actionBarOverlayLayout);
                }
            }
            this.f12178f.sendAccessibilityEvent(32);
            this.f12181j = eVar3;
            return eVar3;
        } catch (Throwable th) {
            cVar.u();
            throw th;
        }
    }

    @Override // stepos.support.v7.app.a
    public final fe.b s(AppCompatDelegateImplV7.e eVar) {
        e eVar2 = this.f12181j;
        if (eVar2 != null) {
            eVar2.c();
        }
        this.f12175c.setHideOnContentScrollEnabled(false);
        this.f12178f.j();
        e eVar3 = new e(this.f12178f.getContext(), eVar);
        stepos.support.v7.view.menu.c cVar = eVar3.f12200e;
        cVar.v();
        try {
            if (!eVar3.f12201f.f12018a.d(eVar3, cVar)) {
                return null;
            }
            eVar3.i();
            this.f12178f.setSplitView(this.f12179g);
            this.f12178f.h(eVar3);
            t(true, eVar3);
            ActionBarContainer actionBarContainer = this.f12179g;
            if (actionBarContainer != null && actionBarContainer.getVisibility() != 0) {
                this.f12179g.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12175c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                    e0.c.b(actionBarOverlayLayout);
                }
            }
            this.f12178f.sendAccessibilityEvent(32);
            this.f12181j = eVar3;
            return eVar3;
        } finally {
            cVar.u();
        }
    }

    public final void t(boolean z, e eVar) {
        if (eVar != null ? true : z) {
            if (!this.f12189s) {
                this.f12189s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12175c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                x(false);
            }
        } else if (this.f12189s) {
            this.f12189s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f12175c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            x(false);
        }
        (z ? this.f12177e.i(4, 100L) : this.f12177e.i(0, 200L)).g();
        this.f12178f.f(z);
    }

    public final void u(View view) throws Resources.NotFoundException {
        stepos.support.v7.widget.k wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.stepos.aiengine.R.id.decor_content_parent);
        this.f12175c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        Object objFindViewById = view.findViewById(com.stepos.aiengine.R.id.action_bar);
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
        this.f12177e = wrapper;
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.stepos.aiengine.R.id.action_bar_container);
        this.f12176d = actionBarContainer;
        this.f12178f = (ActionBarContextView) actionBarContainer.findViewById(com.stepos.aiengine.R.id.action_context_bar);
        this.f12179g = (ActionBarContainer) view.findViewById(com.stepos.aiengine.R.id.split_action_bar);
        stepos.support.v7.widget.k kVar = this.f12177e;
        if (kVar == null || this.f12178f == null || this.f12176d == null) {
            throw new IllegalStateException(o0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        kVar.t(new d());
        this.f12173a = this.f12177e.getContext();
        int iP = this.f12177e.p();
        boolean z = true;
        boolean z3 = (iP & 4) != 0;
        if (z3) {
            this.f12180i = true;
        }
        fe.a aVarA = fe.a.a(this.f12173a);
        m(aVarA.f8850a.getApplicationInfo().targetSdkVersion < 14 || z3);
        this.f12194x = (iP & 32) != 0;
        w((this.f12195y && aVarA.c()) || this.f12194x);
        TypedArray typedArrayObtainStyledAttributes = this.f12173a.obtainStyledAttributes(null, g.a.f8921a, com.stepos.aiengine.R.attr.steposActionBarStyleFullScreen, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f12175c;
            if (!actionBarOverlayLayout2.f12483m) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f12193w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            float f8 = dimensionPixelSize;
            ActionBarContainer actionBarContainer2 = this.f12176d;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.d.j(actionBarContainer2, f8);
            ActionBarContainer actionBarContainer3 = this.f12179g;
            if (actionBarContainer3 != null) {
                e0.d.j(actionBarContainer3, f8);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        int height = this.f12176d.getHeight();
        if (!this.f12190t || (height != 0 && this.f12175c.getActionBarHideOffset() >= height)) {
            z = false;
        }
        this.z = z;
    }

    public final void v(int i10, int i11) {
        int iP = this.f12177e.p();
        if ((i11 & 4) != 0) {
            this.f12180i = true;
        }
        this.f12177e.h((i10 & i11) | ((~i11) & iP));
    }

    public final void w(boolean z) throws Resources.NotFoundException {
        this.f12186o = z;
        if (z) {
            this.f12176d.setTabContainer(null);
            this.f12177e.n();
        } else {
            this.f12177e.n();
            this.f12176d.setTabContainer(null);
        }
        this.f12177e.getClass();
        stepos.support.v7.widget.t tabContainer = !this.f12186o ? this.f12176d.getTabContainer() : this.f12177e.E();
        if (tabContainer != null) {
            tabContainer.setVisibility(8);
        }
        this.f12177e.k(false);
        this.f12175c.setHasNonEmbeddedTabs(false);
    }

    public final void x(boolean z) {
        boolean z3 = this.r;
        boolean z10 = this.f12189s;
        int i10 = this.D;
        c cVar = this.C;
        boolean z11 = E;
        FitsWindowsContentLayout fitsWindowsContentLayout = this.h;
        if (!z10 && z3) {
            if (this.f12190t) {
                this.f12190t = false;
                k.g gVar = this.f12191u;
                if (gVar != null) {
                    gVar.a();
                }
                int i11 = this.f12187p;
                a aVar = this.A;
                if (i11 != 0 || !z11 || (!this.f12192v && !z)) {
                    aVar.d(null);
                    return;
                }
                ActionBarContainer actionBarContainer = this.f12176d;
                WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                actionBarContainer.setAlpha(1.0f);
                this.f12176d.setTransitioning(true);
                k.g gVar2 = new k.g();
                float f8 = -this.f12176d.getHeight();
                if (z) {
                    this.f12176d.getLocationInWindow(new int[]{0, 0});
                    f8 -= r13[1];
                }
                v0.h0 h0VarA = v0.e0.a(this.f12176d);
                h0VarA.h(f8);
                h0VarA.f(cVar);
                gVar2.b(h0VarA);
                if (this.f12188q && fitsWindowsContentLayout != null) {
                    v0.h0 h0VarA2 = v0.e0.a(fitsWindowsContentLayout);
                    h0VarA2.h(f8);
                    gVar2.b(h0VarA2);
                }
                ActionBarContainer actionBarContainer2 = this.f12179g;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() == 0 && this.z) {
                    this.f12179g.setAlpha(1.0f);
                    v0.h0 h0VarA3 = v0.e0.a(this.f12179g);
                    h0VarA3.h(this.f12179g.getHeight());
                    gVar2.b(h0VarA3);
                }
                gVar2.d(new PathInterpolator(0.29f, 0.5f, 0.16f, 1.0f));
                gVar2.c(i10);
                gVar2.e(aVar);
                this.f12191u = gVar2;
                gVar2.f();
                return;
            }
            return;
        }
        if (this.f12190t) {
            return;
        }
        this.f12190t = true;
        k.g gVar3 = this.f12191u;
        if (gVar3 != null) {
            gVar3.a();
        }
        this.f12176d.setVisibility(0);
        int i12 = this.f12187p;
        b bVar = this.B;
        if (i12 == 0 && z11 && (this.f12192v || z)) {
            ActionBarContainer actionBarContainer3 = this.f12176d;
            WeakHashMap<View, v0.h0> weakHashMap2 = v0.e0.f13274a;
            actionBarContainer3.setTranslationY(0.0f);
            float f9 = -this.f12176d.getHeight();
            if (z) {
                this.f12176d.getLocationInWindow(new int[]{0, 0});
                f9 -= r13[1];
            }
            this.f12176d.setTranslationY(f9);
            k.g gVar4 = new k.g();
            v0.h0 h0VarA4 = v0.e0.a(this.f12176d);
            h0VarA4.h(0.0f);
            h0VarA4.f(cVar);
            gVar4.b(h0VarA4);
            if (this.f12188q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(f9);
                v0.h0 h0VarA5 = v0.e0.a(fitsWindowsContentLayout);
                h0VarA5.h(0.0f);
                gVar4.b(h0VarA5);
            }
            ActionBarContainer actionBarContainer4 = this.f12179g;
            if (actionBarContainer4 != null && !this.z) {
                actionBarContainer4.setVisibility(0);
                this.f12179g.setTranslationY(r0.getMeasuredHeight());
                v0.h0 h0VarA6 = v0.e0.a(this.f12179g);
                h0VarA6.h(0.0f);
                gVar4.b(h0VarA6);
            }
            gVar4.d(new PathInterpolator(0.2f, 0.5f, 0.05f, 1.0f));
            gVar4.c(i10);
            gVar4.e(bVar);
            this.f12191u = gVar4;
            gVar4.f();
        } else {
            ActionBarContainer actionBarContainer5 = this.f12176d;
            WeakHashMap<View, v0.h0> weakHashMap3 = v0.e0.f13274a;
            actionBarContainer5.setAlpha(1.0f);
            this.f12176d.setTranslationY(0.0f);
            if (this.f12188q && fitsWindowsContentLayout != null) {
                fitsWindowsContentLayout.setTranslationY(0.0f);
            }
            ActionBarContainer actionBarContainer6 = this.f12179g;
            if (actionBarContainer6 != null) {
                actionBarContainer6.setAlpha(1.0f);
                this.f12179g.setTranslationY(0.0f);
                this.f12179g.setVisibility(0);
            }
            bVar.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f12175c;
        if (actionBarOverlayLayout != null) {
            e0.c.b(actionBarOverlayLayout);
        }
    }

    public o0(Dialog dialog) throws Resources.NotFoundException {
        new ArrayList();
        this.f12185n = new ArrayList<>();
        this.f12187p = 0;
        this.f12188q = true;
        this.f12190t = true;
        this.f12195y = true;
        this.A = new a();
        this.B = new b();
        this.C = new c();
        this.D = 288;
        u(dialog.getWindow().getDecorView());
    }
}
