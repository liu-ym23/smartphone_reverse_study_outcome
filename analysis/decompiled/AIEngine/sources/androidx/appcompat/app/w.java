package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import mb.y;
import v0.e0;
import v0.h0;
import v0.j0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    /* renamed from: y, reason: collision with root package name */
    public static final AccelerateInterpolator f372y = new AccelerateInterpolator();
    public static final DecelerateInterpolator z = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Context f373a;

    /* renamed from: b, reason: collision with root package name */
    public Context f374b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f375c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f376d;

    /* renamed from: e, reason: collision with root package name */
    public e0 f377e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f378f;

    /* renamed from: g, reason: collision with root package name */
    public final View f379g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public d f380i;

    /* renamed from: j, reason: collision with root package name */
    public d f381j;

    /* renamed from: k, reason: collision with root package name */
    public AppCompatDelegateImpl.c f382k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f383l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<a.b> f384m;

    /* renamed from: n, reason: collision with root package name */
    public int f385n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f386o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f387p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f388q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public k.g f389s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f390t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f391u;

    /* renamed from: v, reason: collision with root package name */
    public final a f392v;

    /* renamed from: w, reason: collision with root package name */
    public final b f393w;

    /* renamed from: x, reason: collision with root package name */
    public final c f394x;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            View view2;
            w wVar = w.this;
            if (wVar.f386o && (view2 = wVar.f379g) != null) {
                view2.setTranslationY(0.0f);
                wVar.f376d.setTranslationY(0.0f);
            }
            wVar.f376d.setVisibility(8);
            wVar.f376d.setTransitioning(false);
            wVar.f389s = null;
            AppCompatDelegateImpl.c cVar = wVar.f382k;
            if (cVar != null) {
                cVar.a(wVar.f381j);
                wVar.f381j = null;
                wVar.f382k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = wVar.f375c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                e0.c.b(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends y {
        public b() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            w wVar = w.this;
            wVar.f389s = null;
            wVar.f376d.requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements j0 {
        public c() {
        }

        @Override // v0.j0
        public final void a() {
            ((View) w.this.f376d.getParent()).invalidate();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends k.a implements f.a {

        /* renamed from: c, reason: collision with root package name */
        public final Context f398c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.f f399d;

        /* renamed from: e, reason: collision with root package name */
        public AppCompatDelegateImpl.c f400e;
        public WeakReference<View> h;

        public d(Context context, AppCompatDelegateImpl.c cVar) {
            this.f398c = context;
            this.f400e = cVar;
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            fVar.f488o = 1;
            this.f399d = fVar;
            fVar.f482e = this;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            AppCompatDelegateImpl.c cVar = this.f400e;
            if (cVar != null) {
                return cVar.f299a.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            if (this.f400e == null) {
                return;
            }
            i();
            ActionMenuPresenter actionMenuPresenter = w.this.f378f.f740d;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.l();
            }
        }

        @Override // k.a
        public final void c() {
            w wVar = w.this;
            if (wVar.f380i != this) {
                return;
            }
            if (wVar.f387p) {
                wVar.f381j = this;
                wVar.f382k = this.f400e;
            } else {
                this.f400e.a(this);
            }
            this.f400e = null;
            wVar.a(false);
            ActionBarContextView actionBarContextView = wVar.f378f;
            if (actionBarContextView.f563n == null) {
                actionBarContextView.h();
            }
            wVar.f375c.setHideOnContentScrollEnabled(wVar.f391u);
            wVar.f380i = null;
        }

        @Override // k.a
        public final View d() {
            WeakReference<View> weakReference = this.h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // k.a
        public final androidx.appcompat.view.menu.f e() {
            return this.f399d;
        }

        @Override // k.a
        public final MenuInflater f() {
            return new k.f(this.f398c);
        }

        @Override // k.a
        public final CharSequence g() {
            return w.this.f378f.getSubtitle();
        }

        @Override // k.a
        public final CharSequence h() {
            return w.this.f378f.getTitle();
        }

        @Override // k.a
        public final void i() {
            if (w.this.f380i != this) {
                return;
            }
            androidx.appcompat.view.menu.f fVar = this.f399d;
            fVar.w();
            try {
                this.f400e.b(this, fVar);
            } finally {
                fVar.v();
            }
        }

        @Override // k.a
        public final boolean j() {
            return w.this.f378f.f570v;
        }

        @Override // k.a
        public final void k(View view) {
            w.this.f378f.setCustomView(view);
            this.h = new WeakReference<>(view);
        }

        @Override // k.a
        public final void l(int i10) {
            m(w.this.f373a.getResources().getString(i10));
        }

        @Override // k.a
        public final void m(CharSequence charSequence) {
            w.this.f378f.setSubtitle(charSequence);
        }

        @Override // k.a
        public final void n(int i10) {
            o(w.this.f373a.getResources().getString(i10));
        }

        @Override // k.a
        public final void o(CharSequence charSequence) {
            w.this.f378f.setTitle(charSequence);
        }

        @Override // k.a
        public final void p(boolean z) {
            this.f9772b = z;
            w.this.f378f.setTitleOptional(z);
        }
    }

    public w(Activity activity, boolean z3) {
        new ArrayList();
        this.f384m = new ArrayList<>();
        this.f385n = 0;
        this.f386o = true;
        this.r = true;
        this.f392v = new a();
        this.f393w = new b();
        this.f394x = new c();
        View decorView = activity.getWindow().getDecorView();
        d(decorView);
        if (z3) {
            return;
        }
        this.f379g = decorView.findViewById(R.id.content);
    }

    public final void a(boolean z3) {
        h0 h0VarE;
        h0 h0VarE2;
        if (z3) {
            if (!this.f388q) {
                this.f388q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f375c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                g(false);
            }
        } else if (this.f388q) {
            this.f388q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f375c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            g(false);
        }
        if (!this.f376d.isLaidOut()) {
            if (z3) {
                this.f377e.r(4);
                this.f378f.setVisibility(0);
                return;
            } else {
                this.f377e.r(0);
                this.f378f.setVisibility(8);
                return;
            }
        }
        if (z3) {
            h0VarE = this.f377e.i(4, 100L);
            h0VarE2 = this.f378f.e(0, 200L);
        } else {
            h0 h0VarI = this.f377e.i(0, 200L);
            h0VarE = this.f378f.e(8, 100L);
            h0VarE2 = h0VarI;
        }
        k.g gVar = new k.g();
        ArrayList<h0> arrayList = gVar.f9822a;
        arrayList.add(h0VarE);
        View view = h0VarE.f13288a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = h0VarE2.f13288a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(h0VarE2);
        gVar.f();
    }

    public final void b(boolean z3) {
        if (z3 == this.f383l) {
            return;
        }
        this.f383l = z3;
        ArrayList<a.b> arrayList = this.f384m;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).a();
        }
    }

    public final Context c() {
        if (this.f374b == null) {
            TypedValue typedValue = new TypedValue();
            this.f373a.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f374b = new ContextThemeWrapper(this.f373a, i10);
            } else {
                this.f374b = this.f373a;
            }
        }
        return this.f374b;
    }

    public final void d(View view) {
        androidx.appcompat.widget.e0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.stepos.aiengine.R.id.decor_content_parent);
        this.f375c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.stepos.aiengine.R.id.action_bar);
        if (callbackFindViewById instanceof androidx.appcompat.widget.e0) {
            wrapper = (androidx.appcompat.widget.e0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f377e = wrapper;
        this.f378f = (ActionBarContextView) view.findViewById(com.stepos.aiengine.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.stepos.aiengine.R.id.action_bar_container);
        this.f376d = actionBarContainer;
        androidx.appcompat.widget.e0 e0Var = this.f377e;
        if (e0Var == null || this.f378f == null || actionBarContainer == null) {
            throw new IllegalStateException(w.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        this.f373a = e0Var.getContext();
        if ((this.f377e.p() & 4) != 0) {
            this.h = true;
        }
        Context context = this.f373a;
        int i10 = context.getApplicationInfo().targetSdkVersion;
        this.f377e.getClass();
        f(context.getResources().getBoolean(com.stepos.aiengine.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f373a.obtainStyledAttributes(null, g.a.f8921a, com.stepos.aiengine.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f375c;
            if (!actionBarOverlayLayout2.f578j) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f391u = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f376d;
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            e0.d.j(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void e(boolean z3) {
        if (this.h) {
            return;
        }
        int i10 = z3 ? 4 : 0;
        int iP = this.f377e.p();
        this.h = true;
        this.f377e.h((i10 & 4) | (iP & (-5)));
    }

    public final void f(boolean z3) {
        if (z3) {
            this.f376d.setTabContainer(null);
            this.f377e.n();
        } else {
            this.f377e.n();
            this.f376d.setTabContainer(null);
        }
        this.f377e.getClass();
        this.f377e.k(false);
        this.f375c.setHasNonEmbeddedTabs(false);
    }

    public final void g(boolean z3) {
        boolean z10 = this.f387p;
        boolean z11 = this.f388q;
        c cVar = this.f394x;
        View view = this.f379g;
        if (!z11 && z10) {
            if (this.r) {
                this.r = false;
                k.g gVar = this.f389s;
                if (gVar != null) {
                    gVar.a();
                }
                int i10 = this.f385n;
                a aVar = this.f392v;
                if (i10 != 0 || (!this.f390t && !z3)) {
                    aVar.d(null);
                    return;
                }
                this.f376d.setAlpha(1.0f);
                this.f376d.setTransitioning(true);
                k.g gVar2 = new k.g();
                float f8 = -this.f376d.getHeight();
                if (z3) {
                    this.f376d.getLocationInWindow(new int[]{0, 0});
                    f8 -= r12[1];
                }
                h0 h0VarA = v0.e0.a(this.f376d);
                h0VarA.h(f8);
                h0VarA.f(cVar);
                gVar2.b(h0VarA);
                if (this.f386o && view != null) {
                    h0 h0VarA2 = v0.e0.a(view);
                    h0VarA2.h(f8);
                    gVar2.b(h0VarA2);
                }
                gVar2.d(f372y);
                gVar2.c(250L);
                gVar2.e(aVar);
                this.f389s = gVar2;
                gVar2.f();
                return;
            }
            return;
        }
        if (this.r) {
            return;
        }
        this.r = true;
        k.g gVar3 = this.f389s;
        if (gVar3 != null) {
            gVar3.a();
        }
        this.f376d.setVisibility(0);
        int i11 = this.f385n;
        b bVar = this.f393w;
        if (i11 == 0 && (this.f390t || z3)) {
            this.f376d.setTranslationY(0.0f);
            float f9 = -this.f376d.getHeight();
            if (z3) {
                this.f376d.getLocationInWindow(new int[]{0, 0});
                f9 -= r12[1];
            }
            this.f376d.setTranslationY(f9);
            k.g gVar4 = new k.g();
            h0 h0VarA3 = v0.e0.a(this.f376d);
            h0VarA3.h(0.0f);
            h0VarA3.f(cVar);
            gVar4.b(h0VarA3);
            if (this.f386o && view != null) {
                view.setTranslationY(f9);
                h0 h0VarA4 = v0.e0.a(view);
                h0VarA4.h(0.0f);
                gVar4.b(h0VarA4);
            }
            gVar4.d(z);
            gVar4.c(250L);
            gVar4.e(bVar);
            this.f389s = gVar4;
            gVar4.f();
        } else {
            this.f376d.setAlpha(1.0f);
            this.f376d.setTranslationY(0.0f);
            if (this.f386o && view != null) {
                view.setTranslationY(0.0f);
            }
            bVar.d(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f375c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            e0.c.b(actionBarOverlayLayout);
        }
    }

    public w(Dialog dialog) {
        new ArrayList();
        this.f384m = new ArrayList<>();
        this.f385n = 0;
        this.f386o = true;
        this.r = true;
        this.f392v = new a();
        this.f393w = new b();
        this.f394x = new c();
        d(dialog.getWindow().getDecorView());
    }
}
