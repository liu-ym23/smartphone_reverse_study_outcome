package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.core.view.r;
import androidx.core.view.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class n extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final Interpolator E = null;
    public static final Interpolator F = null;
    public boolean A;
    public final ViewPropertyAnimatorListener B;
    public final ViewPropertyAnimatorListener C;
    public final ViewPropertyAnimatorUpdateListener D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarOverlayLayout f399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionBarContainer f400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DecorToolbar f401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionBarContextView f402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScrollingTabContainerView f404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActionMode f409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionMode.Callback f410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f414s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f416u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g.d f420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f421z;

    public class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f422a;

        public a(n r10) {
            this.f422a = r10;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            n r11 = this.f422a;
            if (r11.f415t == false) goto L7;
            View r12 = r11.f403h;
            if (r12 == null) goto L7;
            r12.setTranslationY(0.0f);
            this.f422a.f400e.setTranslationY(0.0f);
        L7:
            this.f422a.f400e.setVisibility(8);
            this.f422a.f400e.setTransitioning(false);
            n r13 = this.f422a;
            r13.f420y = null;
            r13.t();
            ActionBarOverlayLayout r14 = this.f422a.f399d;
            if (r14 == null) goto L11;
            ViewCompat.m0(r14);
            return;
        }
    }

    public class b extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f423a;

        public b(n r10) {
            this.f423a = r10;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            n r11 = this.f423a;
            r11.f420y = null;
            r11.f400e.requestLayout();
        }
    }

    public class c implements ViewPropertyAnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f424a;

        public c(n r10) {
            this.f424a = r10;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View r10) {
            ((View) this.f424a.f400e.getParent()).invalidate();
        }
    }

    public class d extends ActionMode implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MenuBuilder f426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ActionMode.Callback f427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WeakReference f428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ n f429g;

        public d(n r10, Context r11, ActionMode.Callback r12) {
            this.f429g = r10;
            this.f425c = r11;
            this.f427e = r12;
            MenuBuilder r13 = new MenuBuilder(r11).setDefaultShowAsAction(1);
            this.f426d = r13;
            r13.setCallback(this);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void a() {
            n r10 = this.f429g;
            if (r10.f408m == this) goto L6;
            return;
        L6:
            if (n.s(r10.f416u, r10.f417v, false) == true) goto L8;
            n r11 = this.f429g;
            r11.f409n = this;
            r11.f410o = this.f427e;
        L9:
            this.f427e = null;
            this.f429g.r(false);
            this.f429g.f402g.g();
            n r12 = this.f429g;
            r12.f399d.setHideOnContentScrollEnabled(r12.A);
            this.f429g.f408m = null;
            return;
        L8:
            this.f427e.onDestroyActionMode(this);
            goto L9
        }

        @Override // androidx.appcompat.view.ActionMode
        public View b() {
            WeakReference r10 = this.f428f;
            if (r10 != null) goto L7;
            return null;
        L7:
            return (View) r10.get();
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu c() {
            return this.f426d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater d() {
            return new g.c(this.f425c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence e() {
            return this.f429g.f402g.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence g() {
            return this.f429g.f402g.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void i() {
            if (this.f429g.f408m == this) goto L5;
            return;
        L5:
            this.f426d.stopDispatchingItemsChanged();
            this.f427e.onPrepareActionMode(this, this.f426d);     // Catch: Throwable -> L9
            this.f426d.startDispatchingItemsChanged();
            return;
        L9:
            th = move-exception;
            this.f426d.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean j() {
            return this.f429g.f402g.j();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void k(View r10) {
            this.f429g.f402g.setCustomView(r10);
            this.f428f = new WeakReference(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void l(int r10) {
            m(this.f429g.f396a.getResources().getString(r10));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void m(CharSequence r10) {
            this.f429g.f402g.setSubtitle(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void o(int r10) {
            p(this.f429g.f396a.getResources().getString(r10));
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r10, MenuItem r11) {
            ActionMode.Callback r12 = this.f427e;
            if (r12 != null) goto L5;
            return false;
        L5:
            return r12.onActionItemClicked(this, r11);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r10) {
            if (this.f427e != null) goto L5;
            return;
        L5:
            i();
            this.f429g.f402g.l();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void p(CharSequence r10) {
            this.f429g.f402g.setTitle(r10);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void q(boolean r10) {
            super.q(r10);
            this.f429g.f402g.setTitleOptional(r10);
        }

        public boolean r() {
            this.f426d.stopDispatchingItemsChanged();
            boolean r10 = this.f427e.onCreateActionMode(this, this.f426d);     // Catch: Throwable -> L6
            this.f426d.startDispatchingItemsChanged();
            return r10;
        L6:
            th = move-exception;
            this.f426d.startDispatchingItemsChanged();
            throw th;
        }
    }

    static {
        E = new AccelerateInterpolator();
        F = new DecelerateInterpolator();
    }

    public n(Activity r10, boolean r11) {
        this.f405j = new ArrayList();
        this.f406k = -1;
        this.f412q = new ArrayList();
        this.f414s = 0;
        this.f415t = true;
        this.f419x = true;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        this.f398c = r10;
        View r12 = r10.getWindow().getDecorView();
        z(r12);
        if (r11 == true) goto L6;
        this.f403h = r12.findViewById(R.id.content);
        return;
    }

    public static boolean s(boolean r10, boolean r11, boolean r12) {
        if (r12 == false) goto L5;
        return true;
    L5:
        if (r10 == true) goto L9;
        if (r11 == true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    public void A(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 4;
    L6:
        B(r11, 4);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    public void B(int r10, int r11) {
        int r12 = this.f401f.getDisplayOptions();
        if ((r11 & 4) == 0) goto L5;
        this.f407l = true;
    L5:
        this.f401f.setDisplayOptions((r10 & r11) | ((~r11) & r12));
    }

    public void C(float r10) {
        ViewCompat.x0(this.f400e, r10);
    }

    public final void D(boolean r10) {
        this.f413r = r10;
        if (r10 == true) goto L5;
        this.f401f.setEmbeddedTabView(null);
        this.f400e.setTabContainer(this.f404i);
    L6:
        boolean r11 = true;
        if (x() != 2) goto L9;
        boolean r12 = true;
    L10:
        ScrollingTabContainerView r13 = this.f404i;
        if (r13 == null) goto L17;
        if (r12 == false) goto L16;
        r13.setVisibility(0);
        ActionBarOverlayLayout r14 = this.f399d;
        if (r14 == null) goto L17;
        ViewCompat.m0(r14);
        goto L17
    L16:
        r13.setVisibility(8);
    L17:
        DecorToolbar r15 = this.f401f;
        if (this.f413r == true) goto L21;
        if (r12 == false) goto L21;
        boolean r16 = true;
    L22:
        r15.setCollapsible(r16);
        ActionBarOverlayLayout r17 = this.f399d;
        if (this.f413r == true) goto L26;
        if (r12 == false) goto L26;
    L27:
        r17.setHasNonEmbeddedTabs(r11);
        return;
    L26:
        r11 = false;
    L21:
        r16 = false;
        goto L22
    L9:
        r12 = false;
        goto L10
    L5:
        this.f400e.setTabContainer(null);
        this.f401f.setEmbeddedTabView(this.f404i);
        goto L6
    }

    public void E(boolean r10) {
        if (r10 == true) goto L4;
    L8:
        this.A = r10;
        this.f399d.setHideOnContentScrollEnabled(r10);
        return;
    L4:
        if (this.f399d.h() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void F(boolean r10) {
        this.f401f.setHomeButtonEnabled(r10);
    }

    public final boolean G() {
        return ViewCompat.T(this.f400e);
    }

    public final void H() {
        if (this.f418w == true) goto L9;
        this.f418w = true;
        ActionBarOverlayLayout r10 = this.f399d;
        if (r10 == null) goto L7;
        r10.setShowingForActionMode(true);
    L7:
        I(false);
        return;
    }

    public final void I(boolean r10) {
        if (s(this.f416u, this.f417v, this.f418w) == false) goto L8;
        if (this.f419x == true) goto L11;
        this.f419x = true;
        v(r10);
        return;
    L11:
        return;
    L8:
        if (this.f419x == false) goto L13;
        this.f419x = false;
        u(r10);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.f412q.add(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean b() {
        DecorToolbar r10 = this.f401f;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.hasExpandedActionView() == false) goto L10;
        this.f401f.collapseActionView();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean r10) {
        if (r10 != this.f411p) goto L5;
        return;
    L5:
        this.f411p = r10;
        int r11 = this.f412q.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        ((ActionBar.OnMenuVisibilityListener) this.f412q.get(r12)).onMenuVisibilityChanged(r10);
        r12 = r12 + 1;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public int d() {
        return this.f401f.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context e() {
        if (this.f397b != null) goto L9;
        TypedValue r10 = new TypedValue();
        this.f396a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, r10, true);
        int r11 = r10.resourceId;
        if (r11 == 0) goto L7;
        this.f397b = new ContextThemeWrapper(this.f396a, r11);
        goto L9
    L7:
        this.f397b = this.f396a;
    L9:
        return this.f397b;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean r10) {
        this.f415t = r10;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void g(Configuration r10) {
        D(g.a.b(this.f396a).g());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (this.f417v == true) goto L6;
        this.f417v = true;
        I(true);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean i(int r10, KeyEvent r11) {
        d r12 = this.f408m;
        if (r12 != null) goto L5;
        return false;
    L5:
        Menu r13 = r12.c();
        if (r13 == null) goto L16;
        if (r11 == null) goto L9;
        int r14 = r11.getDeviceId();
    L10:
        boolean r15 = true;
        if (KeyCharacterMap.load(r14).getKeyboardType() != 1) goto L14;
        r15 = false;
    L14:
        r13.setQwertyMode(r15);
        return r13.performShortcut(r10, r11, 0);
    L9:
        r14 = -1;
        goto L10
    L16:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void l(boolean r10) {
        if (this.f407l == true) goto L6;
        A(r10);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(int r10) {
        this.f401f.setNavigationContentDescription(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n(Drawable r10) {
        this.f401f.setNavigationIcon(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void o(boolean r10) {
        this.f421z = r10;
        if (r10 == true) goto L8;
        g.d r11 = this.f420y;
        if (r11 == null) goto L9;
        r11.a();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        g.d r10 = this.f420y;
        if (r10 == null) goto L6;
        r10.a();
        this.f420y = null;
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int r10) {
        this.f414s = r10;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void p(CharSequence r10) {
        this.f401f.setWindowTitle(r10);
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode q(ActionMode.Callback r10) {
        d r11 = this.f408m;
        if (r11 == null) goto L5;
        r11.a();
    L5:
        this.f399d.setHideOnContentScrollEnabled(false);
        this.f402g.k();
        d r12 = new d(this, this.f402g.getContext(), r10);
        if (r12.r() == false) goto L9;
        this.f408m = r12;
        r12.i();
        this.f402g.h(r12);
        r(true);
        return r12;
    L9:
        return null;
    }

    public void r(boolean r10) {
        if (r10 == false) goto L4;
        H();
    L6:
        if (G() == true) goto L8;
        if (r10 == false) goto L14;
        this.f401f.setVisibility(4);
        this.f402g.setVisibility(0);
        return;
    L14:
        this.f401f.setVisibility(0);
        this.f402g.setVisibility(8);
        return;
    L8:
        if (r10 == false) goto L10;
        r r11 = this.f401f.setupAnimatorToVisibility(4, 100);
        r r12 = this.f402g.f(0, 200);
    L11:
        g.d r13 = new g.d();
        r13.d(r11, r12);
        r13.h();
        return;
    L10:
        r r14 = this.f401f.setupAnimatorToVisibility(0, 200);
        r11 = this.f402g.f(8, 100);
        r12 = r14;
        goto L11
    L4:
        y();
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r10) {
        this.f412q.remove(r10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.f417v == false) goto L6;
        this.f417v = false;
        I(true);
        return;
    }

    public void t() {
        ActionMode.Callback r10 = this.f410o;
        if (r10 == null) goto L6;
        r10.onDestroyActionMode(this.f409n);
        this.f409n = null;
        this.f410o = null;
        return;
    }

    public void u(boolean r10) {
        g.d r11 = this.f420y;
        if (r11 == null) goto L6;
        r11.a();
    L6:
        if (this.f414s == 0) goto L8;
    L19:
        this.B.onAnimationEnd(null);
        return;
    L8:
        if (this.f421z == true) goto L10;
        if (r10 == false) goto L19;
    L10:
        this.f400e.setAlpha(1.0f);
        this.f400e.setTransitioning(true);
        g.d r12 = new g.d();
        float r13 = -this.f400e.getHeight();
        if (r10 == false) goto L13;
        int[] r14 = {0, 0};
        this.f400e.getLocationInWindow(r14);
        r13 = r13 - r14[1];
    L13:
        r r15 = ViewCompat.e(this.f400e).m(r13);
        r15.k(this.D);
        r12.c(r15);
        if (this.f415t == false) goto L18;
        View r16 = this.f403h;
        if (r16 == null) goto L18;
        r12.c(ViewCompat.e(r16).m(r13));
    L18:
        r12.f(E);
        r12.e(250);
        r12.g(this.B);
        this.f420y = r12;
        r12.h();
    }

    public void v(boolean r10) {
        g.d r11 = this.f420y;
        if (r11 == null) goto L5;
        r11.a();
    L5:
        this.f400e.setVisibility(0);
        if (this.f414s == 0) goto L8;
    L19:
        this.f400e.setAlpha(1.0f);
        this.f400e.setTranslationY(0.0f);
        if (this.f415t == false) goto L24;
        View r12 = this.f403h;
        if (r12 == null) goto L24;
        r12.setTranslationY(0.0f);
    L24:
        this.C.onAnimationEnd(null);
    L25:
        ActionBarOverlayLayout r13 = this.f399d;
        if (r13 == null) goto L29;
        ViewCompat.m0(r13);
        return;
    L29:
        return;
    L8:
        if (this.f421z == true) goto L10;
        if (r10 == false) goto L19;
    L10:
        this.f400e.setTranslationY(0.0f);
        float r14 = -this.f400e.getHeight();
        if (r10 == false) goto L13;
        int[] r15 = {0, 0};
        this.f400e.getLocationInWindow(r15);
        r14 = r14 - r15[1];
    L13:
        this.f400e.setTranslationY(r14);
        g.d r16 = new g.d();
        r r17 = ViewCompat.e(this.f400e).m(0.0f);
        r17.k(this.D);
        r16.c(r17);
        if (this.f415t == false) goto L18;
        View r18 = this.f403h;
        if (r18 == null) goto L18;
        r18.setTranslationY(r14);
        r16.c(ViewCompat.e(this.f403h).m(0.0f));
    L18:
        r16.f(F);
        r16.e(250);
        r16.g(this.C);
        this.f420y = r16;
        r16.h();
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DecorToolbar w(View r10) {
        if ((r10 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r10;
    L7:
        if ((r10 instanceof Toolbar) == true) goto L9;
        StringBuilder r11 = new StringBuilder();
        r11.append("Can't make a decor toolbar out of ");
        if (r10 == 0) goto L13;
        String r12 = r10.getClass().getSimpleName();
    L14:
        r11.append(r12);
        throw new IllegalStateException(r11.toString());
    L13:
        r12 = "null";
        goto L14
    L9:
        return ((Toolbar) r10).getWrapper();
    }

    public int x() {
        return this.f401f.getNavigationMode();
    }

    public final void y() {
        if (this.f418w == false) goto L9;
        this.f418w = false;
        ActionBarOverlayLayout r10 = this.f399d;
        if (r10 == null) goto L7;
        r10.setShowingForActionMode(false);
    L7:
        I(false);
        return;
    }

    public final void z(View r10) {
        ActionBarOverlayLayout r11 = (ActionBarOverlayLayout) r10.findViewById(R$id.decor_content_parent);
        this.f399d = r11;
        if (r11 == null) goto L5;
        r11.setActionBarVisibilityCallback(this);
    L5:
        this.f401f = w(r10.findViewById(R$id.action_bar));
        this.f402g = (ActionBarContextView) r10.findViewById(R$id.action_context_bar);
        ActionBarContainer r12 = (ActionBarContainer) r10.findViewById(R$id.action_bar_container);
        this.f400e = r12;
        DecorToolbar r13 = this.f401f;
        if (r13 == null) goto L31;
        if (this.f402g == null) goto L31;
        if (r12 == null) goto L31;
        this.f396a = r13.getContext();
        if ((this.f401f.getDisplayOptions() & 4) == 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        this.f407l = true;
    L16:
        g.a r15 = g.a.b(this.f396a);
        if (r15.a() == true) goto L21;
        if (r14 == true) goto L21;
        boolean r16 = false;
    L22:
        F(r16);
        D(r15.g());
        TypedArray r17 = this.f396a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (r17.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false) == false) goto L25;
        E(true);
    L25:
        int r18 = r17.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (r18 == 0) goto L28;
        C(r18);
    L28:
        r17.recycle();
        return;
    L21:
        r16 = true;
        goto L22
    L13:
        r14 = false;
    L31:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    public n(Dialog r10) {
        this.f405j = new ArrayList();
        this.f406k = -1;
        this.f412q = new ArrayList();
        this.f414s = 0;
        this.f415t = true;
        this.f419x = true;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        z(r10.getWindow().getDecorView());
    }
}
