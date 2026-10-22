package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    static final int[] ATTRS = null;
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean r100);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r100);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    static {
        ATTRS = new int[]{R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r100, float r101, float r102) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
    }

    public void setShowingForActionMode(boolean r100) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r100) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r100 = this.mActionBarTop;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return -((int) r100.getTranslationY());
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator r100 = this.mCurrentActionBarTopAnimator;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public void pullChildren() {
        if (this.mContent != null) goto L6;
        this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
        this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
        this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
        return;
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private void postAddActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    private void removeActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public ActionBarOverlayLayout(Context r100) {
        this(r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r100) {
        if ((r100 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r100;
    L7:
        if ((r100 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r100).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r100.getClass().getSimpleName()));
    }

    private void init(Context r100) {
        TypedArray r101 = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean r102 = false;
        this.mActionBarHeight = r101.getDimensionPixelSize(0, 0);
        Drawable r103 = r101.getDrawable(1);
        this.mWindowContentOverlay = r103;
        if (r103 != null) goto L5;
        boolean r104 = true;
    L6:
        setWillNotDraw(r104);
        r101.recycle();
        if (r100.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r102 = true;
    L9:
        this.mIgnoreWindowContentOverlay = r102;
        this.mFlingEstimator = new OverScroller(r100);
        return;
    L5:
        r104 = false;
        goto L6
    }

    private boolean shouldHideActionBarOnFling(float r110) {
        this.mFlingEstimator.fling(0, 0, 0, (int) r110, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() <= this.mActionBarTop.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        if (this.mWindowContentOverlay != null) goto L5;
        return;
    L5:
        if (this.mIgnoreWindowContentOverlay == false) goto L7;
        return;
    L7:
        if (this.mActionBarTop.getVisibility() != 0) goto L9;
        int r101 = (int) ((this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY()) + 0.5f);
    L10:
        this.mWindowContentOverlay.setBounds(0, r101, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r101);
        this.mWindowContentOverlay.draw(r100);
        return;
    L9:
        r101 = 0;
        goto L10
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r100) {
        return super.fitSystemWindows(r100);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int r100) {
        pullChildren();
        if (r100 != 2) goto L5;
        this.mDecorToolbar.initProgress();
        return;
    L5:
        if (r100 != 5) goto L7;
        this.mDecorToolbar.initIndeterminateProgress();
        return;
    L7:
        if (r100 != 109) goto L15;
        setOverlayMode(true);
        return;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r100) {
        pullChildren();
        WindowInsetsCompat r101 = WindowInsetsCompat.toWindowInsetsCompat(r100, this);
        Rect r102 = new Rect(r101.getSystemWindowInsetLeft(), r101.getSystemWindowInsetTop(), r101.getSystemWindowInsetRight(), r101.getSystemWindowInsetBottom());
        boolean r103 = applyInsets(this.mActionBarTop, r102, true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, r101, this.mBaseContentInsets);
        Rect r104 = this.mBaseContentInsets;
        WindowInsetsCompat r105 = r101.inset(r104.left, r104.top, r104.right, r104.bottom);
        this.mBaseInnerInsets = r105;
        boolean r106 = true;
        if (this.mLastBaseInnerInsets.equals(r105) == true) goto L6;
        this.mLastBaseInnerInsets = this.mBaseInnerInsets;
        r103 = true;
    L6:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L8;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
    L9:
        if (r106 == false) goto L12;
        requestLayout();
    L12:
        return r101.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    L8:
        r106 = r103;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r100) {
        if (this.mHideOnContentScroll == true) goto L5;
    L10:
        ActionBarVisibilityCallback r101 = this.mActionBarVisibilityCallback;
        if (r101 == null) goto L14;
        r101.onContentScrollStopped();
        return;
    L14:
        return;
    L5:
        if (this.mAnimatingForFling == true) goto L10;
        if (this.mHideOnContentScrollReference > this.mActionBarTop.getHeight()) goto L9;
        postRemoveActionBarHideOffset();
        goto L10
    L9:
        postAddActionBarHideOffset();
        goto L10
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int r100) {
        super.onWindowSystemUiVisibilityChanged(r100);
        pullChildren();
        int r101 = this.mLastSystemUiVisibility ^ r100;
        this.mLastSystemUiVisibility = r100;
        boolean r102 = false;
        if ((r100 & 4) != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r100 & 256) == 0) goto L9;
        r102 = true;
    L9:
        ActionBarVisibilityCallback r104 = this.mActionBarVisibilityCallback;
        if (r104 == null) goto L18;
        r104.enableContentAnimations(!r102);
        if (r103 == true) goto L16;
        if (r102 == false) goto L16;
        this.mActionBarVisibilityCallback.hideForSystem();
    L16:
        this.mActionBarVisibilityCallback.showForSystem();
    L18:
        if ((r101 & 256) != 0) goto L20;
        return;
    L20:
        if (this.mActionBarVisibilityCallback == null) goto L24;
        ViewCompat.requestApplyInsets(this);
        return;
    L24:
        return;
    L5:
        r103 = false;
        goto L7
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        this.mWindowVisibility = r100;
        ActionBarVisibilityCallback r101 = this.mActionBarVisibilityCallback;
        if (r101 == null) goto L6;
        r101.onWindowVisibilityChanged(r100);
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> r100) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(r100);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> r100) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(r100);
    }

    public void setActionBarHideOffset(int r100) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r100, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r100) {
        this.mActionBarVisibilityCallback = r100;
        if (getWindowToken() == null) goto L8;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int r101 = this.mLastSystemUiVisibility;
        if (r101 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r101);
        ViewCompat.requestApplyInsets(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r100) {
        this.mHasNonEmbeddedTabs = r100;
    }

    public void setHideOnContentScrollEnabled(boolean r100) {
        if (r100 == this.mHideOnContentScroll) goto L8;
        this.mHideOnContentScroll = r100;
        if (r100 == true) goto L9;
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r100) {
        pullChildren();
        this.mDecorToolbar.setIcon(r100);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r100) {
        pullChildren();
        this.mDecorToolbar.setLogo(r100);
    }

    public void setOverlayMode(boolean r100) {
        this.mOverlayMode = r100;
        if (r100 == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.mIgnoreWindowContentOverlay = r101;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r100) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(r100);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r100) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r100) {
        pullChildren();
        this.mDecorToolbar.setIcon(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public ActionBarOverlayLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat r102 = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = r102;
        this.mLastBaseInnerInsets = r102;
        this.mInnerInsets = r102;
        this.mLastInnerInsets = r102;
        this.mTopAnimatorListener = new AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this);
        this.mAddActionBarHideOffset = new AnonymousClass3(this);
        init(r100);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r110, 0, r111, 0);
        LayoutParams r100 = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int r101 = Math.max(0, (this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r100).leftMargin) + ((ViewGroup.MarginLayoutParams) r100).rightMargin);
        int r102 = Math.max(0, (this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r100).topMargin) + ((ViewGroup.MarginLayoutParams) r100).bottomMargin);
        int r103 = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) == 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L13;
        int r105 = this.mActionBarHeight;
        if (this.mHasNonEmbeddedTabs == true) goto L10;
    L16:
        this.mContentInsets.set(this.mBaseContentInsets);
        WindowInsetsCompat r106 = this.mBaseInnerInsets;
        this.mInnerInsets = r106;
        if (this.mOverlayMode == true) goto L20;
        if (r104 == true) goto L20;
        Rect r107 = this.mContentInsets;
        r107.top += r105;
        r107.bottom += 0;
        this.mInnerInsets = r106.inset(0, r105, 0, 0);
    L21:
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (this.mLastInnerInsets.equals(this.mInnerInsets) == true) goto L24;
        WindowInsetsCompat r108 = this.mInnerInsets;
        this.mLastInnerInsets = r108;
        ViewCompat.dispatchApplyWindowInsets(this.mContent, r108);
    L24:
        measureChildWithMargins(this.mContent, r110, 0, r111, 0);
        LayoutParams r109 = (LayoutParams) this.mContent.getLayoutParams();
        int r112 = Math.max(r101, (this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r109).leftMargin) + ((ViewGroup.MarginLayoutParams) r109).rightMargin);
        int r113 = Math.max(r102, (this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r109).topMargin) + ((ViewGroup.MarginLayoutParams) r109).bottomMargin);
        int r114 = View.combineMeasuredStates(r103, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r112 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r110, r114), View.resolveSizeAndState(Math.max(r113 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r111, r114 << 16));
        return;
    L20:
        this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(r106.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + r105, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0)).build();
        goto L21
    L10:
        if (this.mActionBarTop.getTabContainer() == null) goto L16;
        r105 = r105 + this.mActionBarHeight;
        goto L16
    L13:
        if (this.mActionBarTop.getVisibility() == 8) goto L15;
        r105 = this.mActionBarTop.getMeasuredHeight();
        goto L16
    L15:
        r105 = 0;
        goto L16
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        if (r101 != 0) goto L5;
        onStopNestedScroll(r100);
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r100, MenuPresenter.Callback r101) {
        pullChildren();
        this.mDecorToolbar.setMenu(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.mParentHelper.onNestedScrollAccepted(r100, r101, r102);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback r103 = this.mActionBarVisibilityCallback;
        if (r103 == null) goto L6;
        r103.onContentScrollStarted();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r100, View r101, int r102) {
        if ((r102 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.mActionBarTop.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        if (this.mHideOnContentScroll == false) goto L12;
        if (r103 == true) goto L7;
        return false;
    L7:
        if (shouldHideActionBarOnFling(r102) == false) goto L9;
        addActionBarHideOffset();
    L10:
        this.mAnimatingForFling = true;
        return true;
    L9:
        removeActionBarHideOffset();
        goto L10
    L12:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        if (r103 != 0) goto L5;
        onNestedScrollAccepted(r100, r101, r102);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if (r103 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r100, r101, r102) == false) goto L6;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = getPaddingLeft();
        int r107 = getPaddingTop();
        int r108 = 0;
    L3:
        if (r108 >= r105) goto L8;
        View r109 = getChildAt(r108);
        if (r109.getVisibility() == 8) goto L7;
        LayoutParams r110 = (LayoutParams) r109.getLayoutParams();
        int r111 = r109.getMeasuredWidth();
        int r112 = r109.getMeasuredHeight();
        int r113 = ((ViewGroup.MarginLayoutParams) r110).leftMargin + r106;
        int r114 = ((ViewGroup.MarginLayoutParams) r110).topMargin + r107;
        r109.layout(r113, r114, r111 + r113, r112 + r114);
    L7:
        r108 = r108 + 1;
        goto L3
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        if (r104 != 0) goto L5;
        onNestedPreScroll(r100, r101, r102, r103);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104) {
        int r105 = this.mHideOnContentScrollReference + r102;
        this.mHideOnContentScrollReference = r105;
        setActionBarHideOffset(r105);
    }

    private boolean applyInsets(View r100, Rect r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        LayoutParams r106 = (LayoutParams) r100.getLayoutParams();
        if (r102 == false) goto L7;
        int r107 = ((ViewGroup.MarginLayoutParams) r106).leftMargin;
        int r108 = r101.left;
        if (r107 == r108) goto L7;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = r108;
        boolean r109 = true;
    L8:
        if (r103 == false) goto L12;
        int r110 = ((ViewGroup.MarginLayoutParams) r106).topMargin;
        int r111 = r101.top;
        if (r110 == r111) goto L12;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = r111;
        r109 = true;
    L12:
        if (r105 == false) goto L16;
        int r112 = ((ViewGroup.MarginLayoutParams) r106).rightMargin;
        int r113 = r101.right;
        if (r112 == r113) goto L16;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = r113;
        r109 = true;
    L16:
        if (r104 == false) goto L21;
        int r114 = ((ViewGroup.MarginLayoutParams) r106).bottomMargin;
        int r115 = r101.bottom;
        if (r114 == r115) goto L21;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = r115;
        return true;
    L21:
        return r109;
    L7:
        r109 = false;
        goto L8
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        if (r105 != 0) goto L5;
        onNestedScroll(r100, r101, r102, r103, r104);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        onNestedScroll(r100, r101, r102, r103, r104, r105);
    }
}
