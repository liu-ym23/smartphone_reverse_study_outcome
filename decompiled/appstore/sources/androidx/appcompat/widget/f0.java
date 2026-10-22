package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
public class f0 implements DecorToolbar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f1004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spinner f1007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f1008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f1011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f1014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f1015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Window.Callback f1016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionMenuPresenter f1018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f1021r;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.a f1022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f1023b;

        public a(f0 r10) {
            this.f1023b = r10;
            this.f1022a = new androidx.appcompat.view.menu.a(r10.f1004a.getContext(), 0, R.id.home, 0, 0, r10.f1013j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            f0 r11 = this.f1023b;
            Window.Callback r12 = r11.f1016m;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11.f1017n == false) goto L9;
            r12.onMenuItemSelected(0, this.f1022a);
            return;
        }
    }

    public class b extends androidx.core.view.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f0 f1026c;

        public b(f0 r10, int r11) {
            this.f1026c = r10;
            this.f1025b = r11;
            this.f1024a = false;
        }

        @Override // androidx.core.view.s, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r10) {
            this.f1024a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            if (this.f1024a == true) goto L6;
            this.f1026c.f1004a.setVisibility(this.f1025b);
            return;
        }

        @Override // androidx.core.view.s, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r10) {
            this.f1026c.f1004a.setVisibility(0);
        }
    }

    public f0(Toolbar r10, boolean r11) {
        this(r10, r11, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public final int a() {
        if (this.f1004a.getNavigationIcon() == null) goto L5;
        this.f1021r = this.f1004a.getNavigationIcon();
        return 15;
    L5:
        return 11;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r10) {
        androidx.core.view.r r11 = setupAnimatorToVisibility(r10, 200);
        if (r11 == null) goto L6;
        r11.l();
        return;
    }

    public final void b() {
        if (this.f1007d != null) goto L6;
        this.f1007d = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        Toolbar.LayoutParams r10 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.f1007d.setLayoutParams(r10);
        return;
    }

    public final void c(CharSequence r10) {
        this.f1013j = r10;
        if ((this.f1005b & 8) == 0) goto L8;
        this.f1004a.setTitle(r10);
        if (this.f1012i == false) goto L9;
        ViewCompat.s0(this.f1004a.getRootView(), r10);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f1004a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f1004a.collapseActionView();
    }

    public final void d() {
        if ((this.f1005b & 4) != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f1015l) == false) goto L7;
        this.f1004a.setNavigationContentDescription(this.f1020q);
        return;
    L7:
        this.f1004a.setNavigationContentDescription(this.f1015l);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.f1004a.dismissPopupMenus();
    }

    public final void e() {
        if ((this.f1005b & 4) == 0) goto L9;
        Toolbar r10 = this.f1004a;
        Drawable r11 = this.f1011h;
        if (r11 != null) goto L8;
        r11 = this.f1021r;
    L8:
        r10.setNavigationIcon(r11);
        return;
    L9:
        this.f1004a.setNavigationIcon(null);
    }

    public final void f() {
        int r10 = this.f1005b;
        if ((r10 & 2) != 0) goto L5;
        Drawable r11 = null;
    L12:
        this.f1004a.setLogo(r11);
        return;
    L5:
        if ((r10 & 1) == 0) goto L10;
        r11 = this.f1010g;
        if (r11 != null) goto L12;
        r11 = this.f1009f;
        goto L12
    L10:
        r11 = this.f1009f;
        goto L12
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f1004a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.f1008e;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.f1005b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner r10 = this.f1007d;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r10 = this.f1007d;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.f1004a.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.f1004a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.f1019p;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.f1004a.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f1004a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.f1004a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.f1004a.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        if (this.f1006c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.f1004a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        if (this.f1009f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        if (this.f1010g == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f1004a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f1004a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f1004a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.f1004a.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray r10) {
        this.f1004a.restoreHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray r10) {
        this.f1004a.saveHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r10) {
        ViewCompat.t0(this.f1004a, r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r10) {
        this.f1004a.setCollapsible(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r10) {
        View r11 = this.f1008e;
        if (r11 != null) goto L5;
    L7:
        this.f1008e = r10;
        if (r10 != null) goto L10;
        return;
    L10:
        if ((this.f1005b & 16) == 0) goto L14;
        this.f1004a.addView(r10);
        return;
    L14:
        return;
    L5:
        if ((this.f1005b & 16) == 0) goto L7;
        this.f1004a.removeView(r11);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r10) {
        if (r10 != this.f1020q) goto L5;
        return;
    L5:
        this.f1020q = r10;
        if (TextUtils.isEmpty(this.f1004a.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.f1020q);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r10) {
        if (this.f1021r == r10) goto L6;
        this.f1021r = r10;
        e();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r10) {
        int r11 = this.f1005b ^ r10;
        this.f1005b = r10;
        if (r11 != 0) goto L5;
        return;
    L5:
        if ((r11 & 4) == 0) goto L11;
        if ((r10 & 4) == 0) goto L9;
        d();
    L9:
        e();
    L11:
        if ((r11 & 3) == 0) goto L14;
        f();
    L14:
        if ((r11 & 8) == 0) goto L20;
        if ((r10 & 8) == 0) goto L18;
        this.f1004a.setTitle(this.f1013j);
        this.f1004a.setSubtitle(this.f1014k);
        goto L20
    L18:
        this.f1004a.setTitle(null);
        this.f1004a.setSubtitle(null);
    L20:
        if ((r11 & 16) == 0) goto L29;
        View r12 = this.f1008e;
        if (r12 != null) goto L24;
        return;
    L24:
        if ((r10 & 16) == 0) goto L26;
        this.f1004a.addView(r12);
        return;
    L26:
        this.f1004a.removeView(r12);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r10, AdapterView.OnItemSelectedListener r11) {
        b();
        this.f1007d.setAdapter(r10);
        this.f1007d.setOnItemSelectedListener(r11);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r10) {
        Spinner r11 = this.f1007d;
        if (r11 == null) goto L7;
        r11.setSelection(r10);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r10) {
        View r11 = this.f1006c;
        if (r11 == null) goto L7;
        ViewParent r12 = r11.getParent();
        Toolbar r13 = this.f1004a;
        if (r12 != r13) goto L7;
        r13.removeView(this.f1006c);
    L7:
        this.f1006c = r10;
        if (r10 != null) goto L10;
        return;
    L10:
        if (this.f1019p != 2) goto L14;
        this.f1004a.addView(r10, 0);
        Toolbar.LayoutParams r14 = (Toolbar.LayoutParams) this.f1006c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r14).width = -2;
        ((ViewGroup.MarginLayoutParams) r14).height = -2;
        r14.f211a = BadgeDrawable.BOTTOM_START;
        r10.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r10) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setLogo(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r10, MenuPresenter.Callback r11) {
        if (this.f1018o != null) goto L5;
        ActionMenuPresenter r12 = new ActionMenuPresenter(this.f1004a.getContext());
        this.f1018o = r12;
        r12.g(R$id.action_menu_presenter);
    L5:
        this.f1018o.setCallback(r11);
        this.f1004a.setMenu((MenuBuilder) r10, this.f1018o);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.f1004a.setMenuCallbacks(r10, r11);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.f1017n = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r10) {
        this.f1015l = r10;
        d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r10) {
        this.f1011h = r10;
        e();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r10) {
        int r11 = this.f1019p;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L18;
        View r12 = this.f1006c;
        if (r12 == null) goto L18;
        ViewParent r13 = r12.getParent();
        Toolbar r14 = this.f1004a;
        if (r13 != r14) goto L18;
        r14.removeView(this.f1006c);
    L18:
        this.f1019p = r10;
        if (r10 != 0) goto L21;
        return;
    L21:
        if (r10 == 1) goto L28;
        if (r10 != 2) goto L27;
        View r15 = this.f1006c;
        if (r15 == null) goto L32;
        this.f1004a.addView(r15, 0);
        Toolbar.LayoutParams r16 = (Toolbar.LayoutParams) this.f1006c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r16).width = -2;
        ((ViewGroup.MarginLayoutParams) r16).height = -2;
        r16.f211a = BadgeDrawable.BOTTOM_START;
        return;
    L32:
        return;
    L27:
        throw new IllegalArgumentException("Invalid navigation mode " + r10);
    L28:
        b();
        this.f1004a.addView(this.f1007d, 0);
        return;
    L13:
        Spinner r17 = this.f1007d;
        if (r17 == null) goto L18;
        ViewParent r18 = r17.getParent();
        Toolbar r19 = this.f1004a;
        if (r18 != r19) goto L18;
        r19.removeView(this.f1007d);
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r10) {
        this.f1014k = r10;
        if ((this.f1005b & 8) == 0) goto L6;
        this.f1004a.setSubtitle(r10);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r10) {
        this.f1012i = true;
        c(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r10) {
        this.f1004a.setVisibility(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r10) {
        this.f1016m = r10;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r10) {
        if (this.f1012i == true) goto L6;
        c(r10);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public androidx.core.view.r setupAnimatorToVisibility(int r10, long r11) {
        androidx.core.view.r r12 = ViewCompat.e(this.f1004a);
        if (r10 != 0) goto L5;
        float r13 = 1.0f;
    L7:
        return r12.b(r13).f(r11).h(new b(this, r10));
    L5:
        r13 = 0.0f;
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f1004a.showOverflowMenu();
    }

    public f0(Toolbar r10, boolean r11, int r12, int r13) {
        this.f1019p = 0;
        this.f1020q = 0;
        this.f1004a = r10;
        this.f1013j = r10.getTitle();
        this.f1014k = r10.getSubtitle();
        if (this.f1013j == null) goto L5;
        boolean r14 = true;
    L6:
        this.f1012i = r14;
        this.f1011h = r10.getNavigationIcon();
        b0 r15 = b0.v(r10.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f1021r = r15.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (r11 == false) goto L44;
        CharSequence r16 = r15.p(R$styleable.ActionBar_title);
        if (TextUtils.isEmpty(r16) == true) goto L11;
        setTitle(r16);
    L11:
        CharSequence r17 = r15.p(R$styleable.ActionBar_subtitle);
        if (TextUtils.isEmpty(r17) == true) goto L14;
        setSubtitle(r17);
    L14:
        Drawable r18 = r15.g(R$styleable.ActionBar_logo);
        if (r18 == null) goto L17;
        setLogo(r18);
    L17:
        Drawable r19 = r15.g(R$styleable.ActionBar_icon);
        if (r19 == null) goto L21;
        setIcon(r19);
    L21:
        if (this.f1011h != null) goto L25;
        Drawable r20 = this.f1021r;
        if (r20 == null) goto L25;
        setNavigationIcon(r20);
    L25:
        setDisplayOptions(r15.k(R$styleable.ActionBar_displayOptions, 0));
        int r21 = r15.n(R$styleable.ActionBar_customNavigationLayout, 0);
        if (r21 == 0) goto L28;
        setCustomView(LayoutInflater.from(this.f1004a.getContext()).inflate(r21, this.f1004a, false));
        setDisplayOptions(this.f1005b | 16);
    L28:
        int r22 = r15.m(R$styleable.ActionBar_height, 0);
        if (r22 <= 0) goto L31;
        ViewGroup.LayoutParams r23 = this.f1004a.getLayoutParams();
        r23.height = r22;
        this.f1004a.setLayoutParams(r23);
    L31:
        int r24 = r15.e(R$styleable.ActionBar_contentInsetStart, -1);
        int r25 = r15.e(R$styleable.ActionBar_contentInsetEnd, -1);
        if (r24 >= 0) goto L34;
        if (r25 >= 0) goto L34;
    L35:
        int r26 = r15.n(R$styleable.ActionBar_titleTextStyle, 0);
        if (r26 == 0) goto L38;
        Toolbar r27 = this.f1004a;
        r27.setTitleTextAppearance(r27.getContext(), r26);
    L38:
        int r28 = r15.n(R$styleable.ActionBar_subtitleTextStyle, 0);
        if (r28 == 0) goto L41;
        Toolbar r29 = this.f1004a;
        r29.setSubtitleTextAppearance(r29.getContext(), r28);
    L41:
        int r30 = r15.n(R$styleable.ActionBar_popupTheme, 0);
        if (r30 == 0) goto L45;
        this.f1004a.setPopupTheme(r30);
    L45:
        r15.w();
        setDefaultNavigationContentDescription(r12);
        this.f1015l = this.f1004a.getNavigationContentDescription();
        this.f1004a.setNavigationOnClickListener(new a(this));
        return;
    L34:
        this.f1004a.setContentInsetsRelative(Math.max(r24, 0), Math.max(r25, 0));
        goto L35
    L44:
        this.f1005b = a();
        goto L45
    L5:
        r14 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r10) {
        this.f1009f = r10;
        f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r10) {
        this.f1010g = r10;
        f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r10) {
        if (r10 != 0) goto L4;
        String r11 = null;
    L5:
        setNavigationContentDescription(r11);
        return;
    L4:
        r11 = getContext().getString(r10);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = c.a.b(getContext(), r10);
    L5:
        setNavigationIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
