package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ae;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class z implements p {
    private static final String TAG = "ToolbarWidgetWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CharSequence f501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Window.Callback f502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f504e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    @Override // androidx.appcompat.widget.p
    public void b(boolean r1) {
    }

    public z(Toolbar r5, boolean r6) {
        this(r5, r6, ZeusTransformUtils.mapRes(R.string.abc_action_bar_up_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_action_bar_up_description"), ZeusTransformUtils.mapRes(R.drawable.abc_ic_ab_back_material, "drawable", "abc_ic_ab_back_material"));
    }

    public z(Toolbar r7, boolean r8, int r9, int r10) {
        this.o = 0;
        this.p = 0;
        this.f500a = r7;
        this.f501b = r7.getTitle();
        this.l = r7.getSubtitle();
        if (this.f501b == null) goto L5;
        boolean r0 = true;
    L6:
        this.k = r0;
        this.j = r7.getNavigationIcon();
        y r11 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, R.styleable.ActionBar, ZeusTransformUtils.mapRes(R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        this.q = r11.a(ZeusTransformUtils.mapRes(R.styleable.ActionBar_homeAsUpIndicator, "styleable", "ActionBar_homeAsUpIndicator"));
        if (r8 == false) goto L44;
        CharSequence r12 = r11.c(ZeusTransformUtils.mapRes(R.styleable.ActionBar_title, "styleable", "ActionBar_title"));
        if (TextUtils.isEmpty(r12) == true) goto L11;
        b(r12);
    L11:
        CharSequence r13 = r11.c(ZeusTransformUtils.mapRes(R.styleable.ActionBar_subtitle, "styleable", "ActionBar_subtitle"));
        if (TextUtils.isEmpty(r13) == true) goto L14;
        c(r13);
    L14:
        Drawable r14 = r11.a(ZeusTransformUtils.mapRes(R.styleable.ActionBar_logo, "styleable", "ActionBar_logo"));
        if (r14 == null) goto L17;
        b(r14);
    L17:
        Drawable r15 = r11.a(ZeusTransformUtils.mapRes(R.styleable.ActionBar_icon, "styleable", "ActionBar_icon"));
        if (r15 == null) goto L21;
        a(r15);
    L21:
        if (this.j != null) goto L25;
        Drawable r16 = this.q;
        if (r16 == null) goto L25;
        c(r16);
    L25:
        c(r11.a(ZeusTransformUtils.mapRes(R.styleable.ActionBar_displayOptions, "styleable", "ActionBar_displayOptions"), 0));
        int r17 = r11.g(ZeusTransformUtils.mapRes(R.styleable.ActionBar_customNavigationLayout, "styleable", "ActionBar_customNavigationLayout"), 0);
        if (r17 == 0) goto L28;
        a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f500a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r17, this.f500a, false, "com.obric.aiagent.plugin"));
        c(this.f504e | 16);
    L28:
        int r18 = r11.f(ZeusTransformUtils.mapRes(R.styleable.ActionBar_height, "styleable", "ActionBar_height"), 0);
        if (r18 <= 0) goto L31;
        ViewGroup.LayoutParams r1 = this.f500a.getLayoutParams();
        r1.height = r18;
        this.f500a.setLayoutParams(r1);
    L31:
        int r19 = r11.d(ZeusTransformUtils.mapRes(R.styleable.ActionBar_contentInsetStart, "styleable", "ActionBar_contentInsetStart"), -1);
        int r2 = r11.d(ZeusTransformUtils.mapRes(R.styleable.ActionBar_contentInsetEnd, "styleable", "ActionBar_contentInsetEnd"), -1);
        if (r19 >= 0) goto L34;
        if (r2 >= 0) goto L34;
    L35:
        int r20 = r11.g(ZeusTransformUtils.mapRes(R.styleable.ActionBar_titleTextStyle, "styleable", "ActionBar_titleTextStyle"), 0);
        if (r20 == 0) goto L38;
        Toolbar r3 = this.f500a;
        r3.setTitleTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r20);
    L38:
        int r21 = r11.g(ZeusTransformUtils.mapRes(R.styleable.ActionBar_subtitleTextStyle, "styleable", "ActionBar_subtitleTextStyle"), 0);
        if (r21 == 0) goto L41;
        Toolbar r4 = this.f500a;
        r4.setSubtitleTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r21);
    L41:
        int r22 = r11.g(ZeusTransformUtils.mapRes(R.styleable.ActionBar_popupTheme, "styleable", "ActionBar_popupTheme"), 0);
        if (r22 == 0) goto L45;
        this.f500a.setPopupTheme(r22);
    L45:
        r11.b();
        f(r9);
        this.m = this.f500a.getNavigationContentDescription();
        this.f500a.setNavigationOnClickListener(new ToolbarWidgetWrapper$1(this));
        return;
    L34:
        this.f500a.setContentInsetsRelative(Math.max(r19, 0), Math.max(r2, 0));
        goto L35
    L44:
        this.f504e = s();
        goto L45
    L5:
        r0 = false;
        goto L6
    }

    public void f(int r2) {
        if (r2 != this.p) goto L5;
        return;
    L5:
        this.p = r2;
        if (TextUtils.isEmpty(this.f500a.getNavigationContentDescription()) == false) goto L9;
        d(this.p);
        return;
    }

    private int s() {
        if (this.f500a.getNavigationIcon() == null) goto L5;
        this.q = this.f500a.getNavigationIcon();
        return 15;
    L5:
        return 11;
    }

    @Override // androidx.appcompat.widget.p
    public ViewGroup a() {
        return this.f500a;
    }

    @Override // androidx.appcompat.widget.p
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f500a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.widget.p
    public boolean b() {
        return this.f500a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.p
    public void c() {
        this.f500a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.p
    public void a(Window.Callback r3) {
        this.f502c = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.widget.p
    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (this.k == true) goto L6;
        e(r4);
        return;
    }

    @Override // androidx.appcompat.widget.p
    public CharSequence d() {
        return this.f500a.getTitle();
    }

    public void b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.k = true;
        e(r4);
    }

    private void e(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f501b = r4;
        if ((this.f504e & 8) == 0) goto L8;
        this.f500a.setTitle(r4);
        if (this.k == false) goto L9;
        ViewCompat.b(this.f500a.getRootView(), r4);
        return;
    L9:
        return;
    }

    public void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.l = r4;
        if ((this.f504e & 8) == 0) goto L6;
        this.f500a.setSubtitle(r4);
        return;
    }

    @Override // androidx.appcompat.widget.p
    public void e() {
        a(TAG, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.p
    public void f() {
        a(TAG, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.p
    public boolean g() {
        if (this.h == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.p
    public boolean h() {
        if (this.i == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.p
    public void a(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    L5:
        a(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.p
    public void a(Drawable r1) {
        this.h = r1;
        t();
    }

    @Override // androidx.appcompat.widget.p
    public void b(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    L5:
        b(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void b(Drawable r1) {
        this.i = r1;
        t();
    }

    private void t() {
        int r0 = this.f504e;
        if ((r0 & 2) != 0) goto L5;
        Drawable r1 = null;
    L12:
        this.f500a.setLogo(r1);
        return;
    L5:
        if ((r0 & 1) == 0) goto L10;
        r1 = this.i;
        if (r1 != null) goto L12;
        r1 = this.h;
        goto L12
    L10:
        r1 = this.h;
        goto L12
    }

    @Override // androidx.appcompat.widget.p
    public boolean i() {
        return this.f500a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.p
    public boolean j() {
        return this.f500a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.p
    public boolean k() {
        return this.f500a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.p
    public boolean l() {
        return this.f500a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.p
    public boolean m() {
        return this.f500a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.p
    public void n() {
        this.f503d = true;
    }

    @Override // androidx.appcompat.widget.p
    public void a(Menu r6, androidx.appcompat.view.menu.d.a r7) {
        Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r6, Menu.class, "com.obric.aiagent.plugin");
        androidx.appcompat.view.menu.d.a r9 = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r7, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
        if (this.n != null) goto L5;
        ActionMenuPresenter r0 = new ActionMenuPresenter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f500a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.n = r0;
        r0.a(ZeusTransformUtils.mapRes(R.id.action_menu_presenter, DbHelper.COL_ID, "action_menu_presenter"));
    L5:
        this.n.setCallback(r9);
        this.f500a.setMenu((MenuBuilder) ZeusTransformUtils.preCheckCast(r8, MenuBuilder.class, "com.obric.aiagent.plugin"), this.n);
    }

    @Override // androidx.appcompat.widget.p
    public void o() {
        this.f500a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.p
    public int p() {
        return this.f504e;
    }

    @Override // androidx.appcompat.widget.p
    public void c(int r4) {
        int r0 = this.f504e ^ r4;
        this.f504e = r4;
        if (r0 != 0) goto L5;
        return;
    L5:
        if ((r0 & 4) == 0) goto L11;
        if ((r4 & 4) == 0) goto L9;
        v();
    L9:
        u();
    L11:
        if ((r0 & 3) == 0) goto L14;
        t();
    L14:
        if ((r0 & 8) == 0) goto L20;
        if ((r4 & 8) == 0) goto L18;
        this.f500a.setTitle(this.f501b);
        this.f500a.setSubtitle(this.l);
        goto L20
    L18:
        this.f500a.setTitle(null);
        this.f500a.setSubtitle(null);
    L20:
        if ((r0 & 16) == 0) goto L29;
        View r1 = this.g;
        if (r1 != null) goto L24;
        return;
    L24:
        if ((r4 & 16) == 0) goto L26;
        this.f500a.addView(r1);
        return;
    L26:
        this.f500a.removeView(r1);
        return;
    }

    @Override // androidx.appcompat.widget.p
    public void a(ScrollingTabContainerView r3) {
        View r0 = this.f;
        if (r0 == null) goto L7;
        ViewParent r1 = r0.getParent();
        Toolbar r2 = this.f500a;
        if (r1 != r2) goto L7;
        r2.removeView(this.f);
    L7:
        this.f = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.o != 2) goto L14;
        this.f500a.addView(r3, 0);
        Toolbar.LayoutParams r4 = (Toolbar.LayoutParams) ZeusTransformUtils.preCheckCast(this.f.getLayoutParams(), Toolbar.LayoutParams.class, "com.obric.aiagent.plugin");
        r4.width = -2;
        r4.height = -2;
        r4.gravity = 8388691;
        r3.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.p
    public void a(boolean r1) {
        this.f500a.setCollapsible(r1);
    }

    @Override // androidx.appcompat.widget.p
    public int q() {
        return this.o;
    }

    public void a(View r3) {
        View r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        this.g = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if ((this.f504e & 16) == 0) goto L14;
        this.f500a.addView(r3);
        return;
    L14:
        return;
    L5:
        if ((this.f504e & 16) == 0) goto L7;
        this.f500a.removeView(r0);
        goto L7
    }

    @Override // androidx.appcompat.widget.p
    public ae a(final int r3, long r4) {
        ae r0 = ViewCompat.p(this.f500a);
        if (r3 != 0) goto L5;
        float r1 = 1.0f;
    L7:
        return r0.a(r1).a(r4).a(new AnonymousClass1(this, r3));
    L5:
        r1 = 0.0f;
        goto L7
    }

    public void c(Drawable r1) {
        this.j = r1;
        u();
    }

    private void u() {
        if ((this.f504e & 4) == 0) goto L9;
        Toolbar r0 = this.f500a;
        Drawable r1 = this.j;
        if (r1 != null) goto L8;
        r1 = this.q;
    L8:
        r0.setNavigationIcon(r1);
        return;
    L9:
        this.f500a.setNavigationIcon(null);
    }

    public void d(CharSequence r3) {
        this.m = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        v();
    }

    @Override // androidx.appcompat.widget.p
    public void d(int r4) {
        if (r4 != 0) goto L4;
        String r5 = null;
    L5:
        d(r5);
        return;
    L4:
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r4);
        goto L5
    }

    private void v() {
        if ((this.f504e & 4) != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.m) == false) goto L7;
        this.f500a.setNavigationContentDescription(this.p);
        return;
    L7:
        this.f500a.setNavigationContentDescription(this.m);
    }

    @Override // androidx.appcompat.widget.p
    public void a(SparseArray<Parcelable> r1) {
        this.f500a.saveHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.p
    public void b(SparseArray<Parcelable> r1) {
        this.f500a.restoreHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.p
    public void e(int r1) {
        this.f500a.setVisibility(r1);
    }

    @Override // androidx.appcompat.widget.p
    public void a(androidx.appcompat.view.menu.d.a r3, MenuBuilder.a r4) {
        androidx.appcompat.view.menu.d.a r5 = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
        MenuBuilder.a r6 = (MenuBuilder.a) ZeusTransformUtils.wrapperContextForParams(r4, MenuBuilder.a.class, "com.obric.aiagent.plugin");
        this.f500a.setMenuCallbacks(r5, r6);
    }

    @Override // androidx.appcompat.widget.p
    public Menu r() {
        return this.f500a.getMenu();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
