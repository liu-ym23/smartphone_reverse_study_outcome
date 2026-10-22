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
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.p;
import androidx.core.view.ViewCompat;
import androidx.core.view.ae;
import androidx.core.view.af;
import androidx.core.view.ah;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends ActionBar implements ActionBarOverlayLayout.a {
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator s = null;
    private static final Interpolator t = null;
    private ArrayList<ActionBar.a> A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ActionBarOverlayLayout f274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ActionBarContainer f275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContextView f277e;
    View f;
    ScrollingTabContainerView g;
    a h;
    androidx.appcompat.view.b i;
    androidx.appcompat.view.b.a j;
    boolean k;
    boolean l;
    boolean m;
    androidx.appcompat.view.e n;
    boolean o;
    final af p;
    final af q;
    final ah r;
    private Context u;
    private Activity v;
    private ArrayList<Object> w;
    private int x;
    private boolean y;
    private boolean z;

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class a extends androidx.appcompat.view.b implements MenuBuilder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MenuBuilder f283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.appcompat.view.b.a f284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private WeakReference<View> f285e;

        public a(k r3, Context r4, androidx.appcompat.view.b.a r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            androidx.appcompat.view.b.a r7 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
            this.f281a = r3;
            this.f282b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f284d = r7;
            MenuBuilder r8 = new MenuBuilder(r6).setDefaultShowAsAction(1);
            this.f283c = r8;
            r8.setCallback(this);
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater a() {
            return new SupportMenuInflater(this.f282b);
        }

        @Override // androidx.appcompat.view.b
        public Menu b() {
            return this.f283c;
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            if (this.f281a.h == this) goto L6;
            return;
        L6:
            if (k.a(this.f281a.l, this.f281a.m, false) == true) goto L8;
            this.f281a.i = this;
            k r0 = this.f281a;
            r0.j = this.f284d;
        L9:
            this.f284d = null;
            this.f281a.j(false);
            this.f281a.f277e.closeMode();
            this.f281a.f274b.setHideOnContentScrollEnabled(this.f281a.o);
            this.f281a.h = null;
            return;
        L8:
            this.f284d.a(this);
            goto L9
        }

        @Override // androidx.appcompat.view.b
        public void d() {
            if (this.f281a.h == this) goto L5;
            return;
        L5:
            this.f283c.stopDispatchingItemsChanged();
            this.f284d.b(this, this.f283c);     // Catch: Throwable -> L9
            this.f283c.startDispatchingItemsChanged();
            return;
        L9:
            th = move-exception;
            this.f283c.startDispatchingItemsChanged();
            throw th;
        }

        public boolean e() {
            this.f283c.stopDispatchingItemsChanged();
            boolean r0 = this.f284d.a(this, this.f283c);     // Catch: Throwable -> L6
            this.f283c.startDispatchingItemsChanged();
            return r0;
        L6:
            th = move-exception;
            this.f283c.startDispatchingItemsChanged();
            throw th;
        }

        @Override // androidx.appcompat.view.b
        public void a(View r2) {
            this.f281a.f277e.setCustomView(r2);
            this.f285e = new WeakReference(r2);
        }

        @Override // androidx.appcompat.view.b
        public void a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.f281a.f277e.setSubtitle(r4);
        }

        @Override // androidx.appcompat.view.b
        public void b(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.f281a.f277e.setTitle(r4);
        }

        @Override // androidx.appcompat.view.b
        public void a(int r3) {
            b(ZeusTransformUtils.getResources(this.f281a.f273a, "com.obric.aiagent.plugin").getString(r3));
        }

        @Override // androidx.appcompat.view.b
        public void b(int r3) {
            a(ZeusTransformUtils.getResources(this.f281a.f273a, "com.obric.aiagent.plugin").getString(r3));
        }

        @Override // androidx.appcompat.view.b
        public CharSequence f() {
            return this.f281a.f277e.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return this.f281a.f277e.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public void a(boolean r1) {
            super.a(r1);
            this.f281a.f277e.setTitleOptional(r1);
        }

        @Override // androidx.appcompat.view.b
        public boolean h() {
            return this.f281a.f277e.isTitleOptional();
        }

        @Override // androidx.appcompat.view.b
        public View i() {
            WeakReference<View> r2 = this.f285e;
            if (r2 != null) goto L7;
            return null;
        L7:
            return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public boolean onMenuItemSelected(MenuBuilder r2, MenuItem r3) {
            MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
            androidx.appcompat.view.b.a r5 = this.f284d;
            if (r5 != null) goto L5;
            return false;
        L5:
            return r5.a(this, r4);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public void onMenuModeChange(MenuBuilder r1) {
            if (this.f284d != null) goto L5;
            return;
        L5:
            d();
            this.f281a.f277e.showOverflowMenu();
        }
    }

    static boolean a(boolean r1, boolean r2, boolean r3) {
        if (r3 == false) goto L5;
        return true;
    L5:
        if (r1 == true) goto L9;
        if (r2 == true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void m() {
    }

    static {
        s = new AccelerateInterpolator();
        t = new DecelerateInterpolator();
    }

    public k(Activity r3, boolean r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.w = new ArrayList();
        this.x = -1;
        this.A = new ArrayList();
        this.C = 0;
        this.k = true;
        this.E = true;
        this.p = new AnonymousClass1(this);
        this.q = new AnonymousClass2(this);
        this.r = new AnonymousClass3(this);
        this.v = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.aiagent.plugin");
        View r6 = ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin").getDecorView();
        a(r6);
        if (r4 == true) goto L6;
        this.f = r6.findViewById(R.id.content);
        return;
    }

    public k(Dialog r2) {
        this.w = new ArrayList();
        this.x = -1;
        this.A = new ArrayList();
        this.C = 0;
        this.k = true;
        this.E = true;
        this.p = new AnonymousClass1(this);
        this.q = new AnonymousClass2(this);
        this.r = new AnonymousClass3(this);
        a(r2.getWindow().getDecorView());
    }

    private void a(View r8) {
        ActionBarOverlayLayout r0 = (ActionBarOverlayLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.decor_content_parent, DbHelper.COL_ID, "decor_content_parent")), ActionBarOverlayLayout.class, "com.obric.aiagent.plugin");
        this.f274b = r0;
        if (r0 == null) goto L5;
        r0.setActionBarVisibilityCallback(this);
    L5:
        this.f276d = b(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.action_bar, DbHelper.COL_ID, "action_bar")));
        this.f277e = (ActionBarContextView) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.action_context_bar, DbHelper.COL_ID, "action_context_bar")), ActionBarContextView.class, "com.obric.aiagent.plugin");
        ActionBarContainer r9 = (ActionBarContainer) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.action_bar_container, DbHelper.COL_ID, "action_bar_container")), ActionBarContainer.class, "com.obric.aiagent.plugin");
        this.f275c = r9;
        p r1 = this.f276d;
        if (r1 == null) goto L31;
        if (this.f277e == null) goto L31;
        if (r9 == null) goto L31;
        this.f273a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if ((this.f276d.p() & 4) == 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        this.y = true;
    L16:
        androidx.appcompat.view.a r2 = androidx.appcompat.view.a.a(this.f273a);
        if (r2.f() == true) goto L21;
        if (r10 == true) goto L21;
        boolean r11 = false;
    L22:
        a(r11);
        k(r2.d());
        TypedArray r12 = this.f273a.obtainStyledAttributes(null, com.obric.aiagent.plugin.R.styleable.ActionBar, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        if (r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.ActionBar_hideOnContentScroll, "styleable", "ActionBar_hideOnContentScroll"), false) == false) goto L25;
        b(true);
    L25:
        int r3 = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.ActionBar_elevation, "styleable", "ActionBar_elevation"), 0);
        if (r3 == 0) goto L28;
        a(r3);
    L28:
        r12.recycle();
        return;
    L21:
        r11 = true;
        goto L22
    L13:
        r10 = false;
    L31:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private p b(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L7;
        return (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Toolbar.class) == true) goto L9;
        StringBuilder r0 = new StringBuilder().append("Can't make a decor toolbar out of ");
        if (r3 == null) goto L13;
        String r4 = r3.getClass().getSimpleName();
    L15:
        throw new IllegalStateException(r0.append(r4).toString());
    L13:
        r4 = "null";
        goto L15
    L9:
        return ((Toolbar) ZeusTransformUtils.preCheckCast(r3, Toolbar.class, "com.obric.aiagent.plugin")).getWrapper();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(float r1) {
        ViewCompat.a(this.f275c, r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration r1) {
        k(androidx.appcompat.view.a.a(this.f273a).d());
    }

    private void k(boolean r5) {
        this.B = r5;
        if (r5 == true) goto L5;
        this.f276d.a(null);
        this.f275c.setTabContainer(this.g);
    L6:
        boolean r1 = true;
        if (i() != 2) goto L9;
        boolean r6 = true;
    L10:
        ScrollingTabContainerView r0 = this.g;
        if (r0 == null) goto L17;
        if (r6 == false) goto L16;
        r0.setVisibility(0);
        ActionBarOverlayLayout r2 = this.f274b;
        if (r2 == null) goto L17;
        ViewCompat.u(r2);
        goto L17
    L16:
        r0.setVisibility(8);
    L17:
        p r3 = this.f276d;
        if (this.B == true) goto L21;
        if (r6 == false) goto L21;
        boolean r4 = true;
    L22:
        r3.a(r4);
        ActionBarOverlayLayout r7 = this.f274b;
        if (this.B == true) goto L26;
        if (r6 == false) goto L26;
    L27:
        r7.setHasNonEmbeddedTabs(r1);
        return;
    L26:
        r1 = false;
    L21:
        r4 = false;
        goto L22
    L9:
        r6 = false;
        goto L10
    L5:
        this.f275c.setTabContainer(null);
        this.f276d.a(this.g);
        goto L6
    }

    void h() {
        androidx.appcompat.view.b.a r0 = this.j;
        if (r0 == null) goto L6;
        r0.a(this.i);
        this.i = null;
        this.j = null;
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void b(int r1) {
        this.C = r1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d(boolean r1) {
        this.F = r1;
        if (r1 == true) goto L8;
        androidx.appcompat.view.e r0 = this.n;
        if (r0 == null) goto L9;
        r0.c();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e(boolean r6) {
        if (r6 != this.z) goto L5;
        return;
    L5:
        this.z = r6;
        int r0 = this.A.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        ((ActionBar.a) ZeusTransformUtils.preCheckCast(this.A.get(r1), ActionBar.a.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L6
    }

    public void f(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        a(r3, 4);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(boolean r1) {
        this.f276d.b(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f276d.a(r4);
    }

    public void a(int r3, int r4) {
        int r0 = this.f276d.p();
        if ((r4 & 4) == 0) goto L5;
        this.y = true;
    L5:
        this.f276d.c((r3 & r4) | ((~r4) & r0));
    }

    public int i() {
        return this.f276d.q();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int a() {
        return this.f276d.p();
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.view.b a(androidx.appcompat.view.b.a r5) {
        androidx.appcompat.view.b.a r6 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        a r0 = this.h;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.f274b.setHideOnContentScrollEnabled(false);
        this.f277e.killMode();
        a r1 = new a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f277e.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        if (r1.e() == false) goto L9;
        this.h = r1;
        r1.d();
        this.f277e.initForMode(r1);
        j(true);
        return r1;
    L9:
        return null;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void g(boolean r1) {
        this.k = r1;
    }

    private void n() {
        if (this.D == true) goto L9;
        this.D = true;
        ActionBarOverlayLayout r1 = this.f274b;
        if (r1 == null) goto L7;
        r1.setShowingForActionMode(true);
    L7:
        l(false);
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m == false) goto L6;
        this.m = false;
        l(true);
        return;
    }

    private void o() {
        if (this.D == false) goto L9;
        this.D = false;
        ActionBarOverlayLayout r1 = this.f274b;
        if (r1 == null) goto L7;
        r1.setShowingForActionMode(false);
    L7:
        l(false);
        return;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m == true) goto L6;
        this.m = true;
        l(true);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean r2) {
        if (r2 == true) goto L4;
    L8:
        this.o = r2;
        this.f274b.setHideOnContentScrollEnabled(r2);
        return;
    L4:
        if (this.f274b.isInOverlayMode() == true) goto L8;
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private void l(boolean r4) {
        if (a(this.l, this.m, this.D) == false) goto L8;
        if (this.E == true) goto L11;
        this.E = true;
        h(r4);
        return;
    L11:
        return;
    L8:
        if (this.E == false) goto L13;
        this.E = false;
        i(r4);
        return;
    }

    public void h(boolean r5) {
        androidx.appcompat.view.e r0 = this.n;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.f275c.setVisibility(0);
        if (this.C == 0) goto L8;
    L19:
        this.f275c.setAlpha(1.0f);
        this.f275c.setTranslationY(0.0f);
        if (this.k == false) goto L24;
        View r6 = this.f;
        if (r6 == null) goto L24;
        r6.setTranslationY(0.0f);
    L24:
        this.q.b(null);
    L25:
        ActionBarOverlayLayout r4 = this.f274b;
        if (r4 == null) goto L29;
        ViewCompat.u(r4);
        return;
    L29:
        return;
    L8:
        if (this.F == true) goto L10;
        if (r5 == false) goto L19;
    L10:
        this.f275c.setTranslationY(0.0f);
        float r1 = -this.f275c.getHeight();
        if (r5 == false) goto L13;
        int[] r7 = {0, 0};
        this.f275c.getLocationInWindow(r7);
        r1 = r1 - r7[1];
    L13:
        this.f275c.setTranslationY(r1);
        androidx.appcompat.view.e r8 = new androidx.appcompat.view.e();
        ae r2 = ViewCompat.p(this.f275c).b(0.0f);
        r2.a(this.r);
        r8.a(r2);
        if (this.k == false) goto L18;
        View r3 = this.f;
        if (r3 == null) goto L18;
        r3.setTranslationY(r1);
        r8.a(ViewCompat.p(this.f).b(0.0f));
    L18:
        r8.a(t);
        r8.a(250);
        r8.a(this.q);
        this.n = r8;
        r8.a();
        goto L25
    }

    public void i(boolean r5) {
        androidx.appcompat.view.e r0 = this.n;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        if (this.C == 0) goto L8;
    L19:
        this.p.b(null);
        return;
    L8:
        if (this.F == true) goto L10;
        if (r5 == false) goto L19;
    L10:
        this.f275c.setAlpha(1.0f);
        this.f275c.setTransitioning(true);
        androidx.appcompat.view.e r1 = new androidx.appcompat.view.e();
        float r2 = -this.f275c.getHeight();
        if (r5 == false) goto L13;
        int[] r6 = {0, 0};
        this.f275c.getLocationInWindow(r6);
        r2 = r2 - r6[1];
    L13:
        ae r7 = ViewCompat.p(this.f275c).b(r2);
        r7.a(this.r);
        r1.a(r7);
        if (this.k == false) goto L18;
        View r8 = this.f;
        if (r8 == null) goto L18;
        r1.a(ViewCompat.p(r8).b(r2));
    L18:
        r1.a(s);
        r1.a(250);
        r1.a(this.p);
        this.n = r1;
        r1.a();
    }

    public void j(boolean r10) {
        if (r10 == false) goto L4;
        n();
    L6:
        if (p() == true) goto L8;
        if (r10 == false) goto L14;
        this.f276d.e(4);
        this.f277e.setVisibility(0);
        return;
    L14:
        this.f276d.e(0);
        this.f277e.setVisibility(8);
        return;
    L8:
        if (r10 == false) goto L10;
        ae r11 = this.f276d.a(4, 100);
        ae r9 = this.f277e.setupAnimatorToVisibility(0, 200);
    L11:
        androidx.appcompat.view.e r0 = new androidx.appcompat.view.e();
        r0.a(r11, r9);
        r0.a();
        return;
    L10:
        ae r12 = this.f276d.a(0, 200);
        r11 = this.f277e.setupAnimatorToVisibility(8, 100);
        r9 = r12;
        goto L11
    L4:
        o();
        goto L6
    }

    private boolean p() {
        return ViewCompat.F(this.f275c);
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context b() {
        if (this.u != null) goto L9;
        TypedValue r0 = new TypedValue();
        this.f273a.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r0, true);
        int r1 = r0.resourceId;
        if (r1 == 0) goto L7;
        this.u = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper(this.f273a, r1), "com.obric.aiagent.plugin");
        goto L9
    L7:
        this.u = ZeusTransformUtils.wrapperContext(this.f273a, "com.obric.aiagent.plugin");
    L9:
        return this.u;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(int r1) {
        this.f276d.d(r1);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void l() {
        androidx.appcompat.view.e r0 = this.n;
        if (r0 == null) goto L6;
        r0.c();
        this.n = null;
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        p r0 = this.f276d;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.b() == false) goto L10;
        this.f276d.c();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean r2) {
        if (this.y == true) goto L6;
        f(r2);
        return;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int r4, KeyEvent r5) {
        a r3 = this.h;
        if (r3 != null) goto L5;
        return false;
    L5:
        Menu r6 = r3.b();
        if (r6 == null) goto L16;
        if (r5 == null) goto L9;
        int r1 = r5.getDeviceId();
    L10:
        boolean r2 = true;
        if (KeyCharacterMap.load(r1).getKeyboardType() != 1) goto L14;
        r2 = false;
    L14:
        r6.setQwertyMode(r2);
        return r6.performShortcut(r4, r5, 0);
    L9:
        r1 = -1;
        goto L10
    L16:
        return false;
    }
}
