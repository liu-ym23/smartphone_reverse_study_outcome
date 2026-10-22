package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] F = null;
    public ViewPropertyAnimator A;
    public final AnimatorListenerAdapter B;
    public final Runnable C;
    public final Runnable D;
    public final androidx.core.view.i E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DecorToolbar f672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f687t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WindowInsetsCompat f688u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WindowInsetsCompat f689v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WindowInsetsCompat f690w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WindowInsetsCompat f691x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ActionBarVisibilityCallback f692y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OverScroller f693z;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean r10);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r10);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f694a;

        public a(ActionBarOverlayLayout r10) {
            this.f694a = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            ActionBarOverlayLayout r11 = this.f694a;
            r11.A = null;
            r11.f678k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            ActionBarOverlayLayout r11 = this.f694a;
            r11.A = null;
            r11.f678k = false;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f695a;

        public b(ActionBarOverlayLayout r10) {
            this.f695a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f695a.f();
            ActionBarOverlayLayout r10 = this.f695a;
            r10.A = r10.f671d.animate().translationY(0.0f).setListener(this.f695a.B);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionBarOverlayLayout f696a;

        public c(ActionBarOverlayLayout r10) {
            this.f696a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f696a.f();
            ActionBarOverlayLayout r10 = this.f696a;
            r10.A = r10.f671d.animate().translationY(-this.f696a.f671d.getHeight()).setListener(this.f696a.B);
        }
    }

    static {
        F = new int[]{R$attr.actionBarSize, R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(@NonNull Context r10) {
        this(r10, null);
    }

    private void g(Context r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(F);
        boolean r12 = false;
        this.f668a = r11.getDimensionPixelSize(0, 0);
        Drawable r13 = r11.getDrawable(1);
        this.f673f = r13;
        if (r13 != null) goto L5;
        boolean r14 = true;
    L6:
        setWillNotDraw(r14);
        r11.recycle();
        if (r10.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r12 = true;
    L9:
        this.f674g = r12;
        this.f693z = new OverScroller(r10);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public final void a() {
        f();
        this.D.run();
    }

    public final boolean b(View r10, Rect r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        LayoutParams r16 = (LayoutParams) r10.getLayoutParams();
        if (r12 == false) goto L7;
        int r17 = ((ViewGroup.MarginLayoutParams) r16).leftMargin;
        int r18 = r11.left;
        if (r17 == r18) goto L7;
        ((ViewGroup.MarginLayoutParams) r16).leftMargin = r18;
        boolean r19 = true;
    L8:
        if (r13 == false) goto L12;
        int r20 = ((ViewGroup.MarginLayoutParams) r16).topMargin;
        int r21 = r11.top;
        if (r20 == r21) goto L12;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = r21;
        r19 = true;
    L12:
        if (r15 == false) goto L16;
        int r22 = ((ViewGroup.MarginLayoutParams) r16).rightMargin;
        int r23 = r11.right;
        if (r22 == r23) goto L16;
        ((ViewGroup.MarginLayoutParams) r16).rightMargin = r23;
        r19 = true;
    L16:
        if (r14 == false) goto L21;
        int r24 = ((ViewGroup.MarginLayoutParams) r16).bottomMargin;
        int r25 = r11.bottom;
        if (r24 == r25) goto L21;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = r25;
        return true;
    L21:
        return r19;
    L7:
        r19 = false;
        goto L8
    }

    public LayoutParams c() {
        return new LayoutParams(-1, -1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        k();
        return this.f672e.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public LayoutParams d(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        k();
        this.f672e.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (this.f673f != null) goto L5;
        return;
    L5:
        if (this.f674g == false) goto L7;
        return;
    L7:
        if (this.f671d.getVisibility() != 0) goto L9;
        int r11 = (int) ((this.f671d.getBottom() + this.f671d.getTranslationY()) + 0.5f);
    L10:
        this.f673f.setBounds(0, r11, getWidth(), this.f673f.getIntrinsicHeight() + r11);
        this.f673f.draw(r10);
        return;
    L9:
        r11 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DecorToolbar e(View r10) {
        if ((r10 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r10;
    L7:
        if ((r10 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r10).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of " + r10.getClass().getSimpleName());
    }

    public void f() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator r10 = this.A;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r10) {
        return super.fitSystemWindows(r10);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return c();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return d(r10);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r10 = this.f671d;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return -((int) r10.getTranslationY());
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        k();
        return this.f672e.getTitle();
    }

    public boolean h() {
        return this.f675h;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        k();
        return this.f672e.hasIcon();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        k();
        return this.f672e.hasLogo();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        k();
        return this.f672e.hideOverflowMenu();
    }

    public final void i() {
        f();
        postDelayed(this.D, 600);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int r10) {
        k();
        if (r10 != 2) goto L5;
        this.f672e.initProgress();
        return;
    L5:
        if (r10 != 5) goto L7;
        this.f672e.initIndeterminateProgress();
        return;
    L7:
        if (r10 != 109) goto L15;
        setOverlayMode(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        k();
        return this.f672e.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        k();
        return this.f672e.isOverflowMenuShowing();
    }

    public final void j() {
        f();
        postDelayed(this.C, 600);
    }

    public void k() {
        if (this.f670c != null) goto L6;
        this.f670c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
        this.f671d = (ActionBarContainer) findViewById(R$id.action_bar_container);
        this.f672e = e(findViewById(R$id.action_bar));
        return;
    }

    public final void l() {
        f();
        this.C.run();
    }

    public final boolean m(float r10) {
        this.f693z.fling(0, 0, 0, (int) r10, 0, 0, Integer.MIN_VALUE, Channel.UNLIMITED);
        if (this.f693z.getFinalY() <= this.f671d.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r10) {
        k();
        WindowInsetsCompat r11 = WindowInsetsCompat.z(r10, this);
        boolean r12 = b(this.f671d, new Rect(r11.k(), r11.m(), r11.l(), r11.j()), true, true, false, true);
        ViewCompat.g(this, r11, this.f681n);
        Rect r13 = this.f681n;
        WindowInsetsCompat r14 = r11.p(r13.left, r13.top, r13.right, r13.bottom);
        this.f688u = r14;
        boolean r15 = true;
        if (this.f689v.equals(r14) == true) goto L6;
        this.f689v = this.f688u;
        r12 = true;
    L6:
        if (this.f682o.equals(this.f681n) == true) goto L8;
        this.f682o.set(this.f681n);
    L9:
        if (r15 == false) goto L12;
        requestLayout();
    L12:
        return r11.a().c().b().x();
    L8:
        r15 = r12;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        g(getContext());
        ViewCompat.m0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = getPaddingTop();
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L8;
        View r19 = getChildAt(r18);
        if (r19.getVisibility() == 8) goto L7;
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        int r21 = r19.getMeasuredWidth();
        int r22 = r19.getMeasuredHeight();
        int r23 = ((ViewGroup.MarginLayoutParams) r20).leftMargin + r16;
        int r24 = ((ViewGroup.MarginLayoutParams) r20).topMargin + r17;
        r19.layout(r23, r24, r21 + r23, r22 + r24);
    L7:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        k();
        measureChildWithMargins(this.f671d, r12, 0, r13, 0);
        LayoutParams r10 = (LayoutParams) this.f671d.getLayoutParams();
        int r11 = Math.max(0, (this.f671d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r10).leftMargin) + ((ViewGroup.MarginLayoutParams) r10).rightMargin);
        int r14 = Math.max(0, (this.f671d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r10).topMargin) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin);
        int r15 = View.combineMeasuredStates(0, this.f671d.getMeasuredState());
        if ((ViewCompat.L(this) & 256) == 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L13;
        int r17 = this.f668a;
        if (this.f676i == true) goto L10;
    L16:
        this.f683p.set(this.f681n);
        WindowInsetsCompat r18 = this.f688u;
        this.f690w = r18;
        if (this.f675h == true) goto L20;
        if (r16 == true) goto L20;
        Rect r19 = this.f683p;
        r19.top += r17;
        r19.bottom = r19.bottom;
        this.f690w = r18.p(0, r17, 0, 0);
    L21:
        b(this.f670c, this.f683p, true, true, true, true);
        if (this.f691x.equals(this.f690w) == true) goto L24;
        WindowInsetsCompat r20 = this.f690w;
        this.f691x = r20;
        ViewCompat.h(this.f670c, r20);
    L24:
        measureChildWithMargins(this.f670c, r12, 0, r13, 0);
        LayoutParams r21 = (LayoutParams) this.f670c.getLayoutParams();
        int r22 = Math.max(r11, (this.f670c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r21).leftMargin) + ((ViewGroup.MarginLayoutParams) r21).rightMargin);
        int r23 = Math.max(r14, (this.f670c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r21).topMargin) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin);
        int r24 = View.combineMeasuredStates(r15, this.f670c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r22 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r12, r24), View.resolveSizeAndState(Math.max(r23 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r13, r24 << 16));
        return;
    L20:
        this.f690w = new WindowInsetsCompat.b(this.f690w).c(androidx.core.graphics.e.b(r18.k(), this.f690w.m() + r17, this.f690w.l(), this.f690w.j())).a();
        goto L21
    L10:
        if (this.f671d.getTabContainer() == null) goto L16;
        r17 = r17 + this.f668a;
        goto L16
    L13:
        if (this.f671d.getVisibility() == 8) goto L15;
        r17 = this.f671d.getMeasuredHeight();
        goto L16
    L15:
        r17 = 0;
        goto L16
    L5:
        r16 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        if (this.f677j == false) goto L12;
        if (r13 == true) goto L7;
        return false;
    L7:
        if (m(r12) == false) goto L9;
        a();
    L10:
        this.f678k = true;
        return true;
    L9:
        l();
        goto L10
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        onNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        if (r13 != 0) goto L5;
        onNestedScrollAccepted(r10, r11, r12);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r10, View r11, int r12, int r13) {
        if (r13 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r10, r11, r12) == false) goto L6;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        if (r11 != 0) goto L5;
        onStopNestedScroll(r10);
        return;
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int r10) {
        super.onWindowSystemUiVisibilityChanged(r10);
        k();
        int r11 = this.f680m ^ r10;
        this.f680m = r10;
        boolean r12 = false;
        if ((r10 & 4) != 0) goto L5;
        boolean r13 = true;
    L7:
        if ((r10 & 256) == 0) goto L9;
        r12 = true;
    L9:
        ActionBarVisibilityCallback r14 = this.f692y;
        if (r14 == null) goto L18;
        r14.enableContentAnimations(!r12);
        if (r13 == true) goto L16;
        if (r12 == false) goto L16;
        this.f692y.hideForSystem();
    L16:
        this.f692y.showForSystem();
    L18:
        if ((r11 & 256) != 0) goto L20;
        return;
    L20:
        if (this.f692y == null) goto L24;
        ViewCompat.m0(this);
        return;
    L24:
        return;
    L5:
        r13 = false;
        goto L7
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        this.f669b = r10;
        ActionBarVisibilityCallback r11 = this.f692y;
        if (r11 == null) goto L6;
        r11.onWindowVisibilityChanged(r10);
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray r10) {
        k();
        this.f672e.restoreHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray r10) {
        k();
        this.f672e.saveHierarchyState(r10);
    }

    public void setActionBarHideOffset(int r10) {
        f();
        this.f671d.setTranslationY(-Math.max(0, Math.min(r10, this.f671d.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r10) {
        this.f692y = r10;
        if (getWindowToken() == null) goto L8;
        this.f692y.onWindowVisibilityChanged(this.f669b);
        int r11 = this.f680m;
        if (r11 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r11);
        ViewCompat.m0(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r10) {
        this.f676i = r10;
    }

    public void setHideOnContentScrollEnabled(boolean r10) {
        if (r10 == this.f677j) goto L8;
        this.f677j = r10;
        if (r10 == true) goto L9;
        f();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r10) {
        k();
        this.f672e.setIcon(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r10) {
        k();
        this.f672e.setLogo(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r10, MenuPresenter.Callback r11) {
        k();
        this.f672e.setMenu(r10, r11);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        k();
        this.f672e.setMenuPrepared();
    }

    public void setOverlayMode(boolean r10) {
        this.f675h = r10;
        if (r10 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.f674g = r11;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r11 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r10) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r10) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r10) {
        k();
        this.f672e.setWindowCallback(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r10) {
        k();
        this.f672e.setWindowTitle(r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        k();
        return this.f672e.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f669b = 0;
        this.f681n = new Rect();
        this.f682o = new Rect();
        this.f683p = new Rect();
        this.f684q = new Rect();
        this.f685r = new Rect();
        this.f686s = new Rect();
        this.f687t = new Rect();
        WindowInsetsCompat r12 = WindowInsetsCompat.f2706b;
        this.f688u = r12;
        this.f689v = r12;
        this.f690w = r12;
        this.f691x = r12;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        g(r10);
        this.E = new androidx.core.view.i(this);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        if (r14 != 0) goto L5;
        onNestedPreScroll(r10, r11, r12, r13);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        if (r15 != 0) goto L5;
        onNestedScroll(r10, r11, r12, r13, r14);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        this.E.b(r10, r11, r12);
        this.f679l = getActionBarHideOffset();
        f();
        ActionBarVisibilityCallback r13 = this.f692y;
        if (r13 == null) goto L6;
        r13.onContentScrollStarted();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        if ((r12 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.f671d.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.f677j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        if (this.f677j == true) goto L5;
    L10:
        ActionBarVisibilityCallback r11 = this.f692y;
        if (r11 == null) goto L14;
        r11.onContentScrollStopped();
        return;
    L14:
        return;
    L5:
        if (this.f678k == true) goto L10;
        if (this.f679l > this.f671d.getHeight()) goto L9;
        j();
        goto L10
    L9:
        i();
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        int r15 = this.f679l + r12;
        this.f679l = r15;
        setActionBarHideOffset(r15);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r10) {
        k();
        this.f672e.setIcon(r10);
    }
}
