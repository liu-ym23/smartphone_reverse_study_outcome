package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;
        final /* synthetic */ AbsActionBarView this$0;

        public VisibilityAnimListener(AbsActionBarView r100) {
            this.this$0 = r100;
            this.mCanceled = false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r100) {
            this.mCanceled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r100) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            AbsActionBarView r101 = this.this$0;
            r101.mVisibilityAnim = null;
            AbsActionBarView.access$101(r101, this.mFinalVisibility);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r100) {
            AbsActionBarView.access$001(this.this$0, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat r100, int r101) {
            this.this$0.mVisibilityAnim = r100;
            this.mFinalVisibility = r101;
            return this;
        }
    }

    public static int next(int r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        return r100 - r101;
    L5:
        return r100 + r101;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 == null) goto L6;
        r100.dismissPopupMenus();
        return;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) goto L7;
        return this.mVisAnimListener.mFinalVisibility;
    L7:
        return getVisibility();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOverflowReserved() == false) goto L7;
        return true;
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.showOverflowMenu();
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public AbsActionBarView(Context r100) {
        this(r100, null);
    }

    public void animateToVisibility(int r100) {
        setupAnimatorToVisibility(r100, 200).start();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        TypedArray r101 = getContext().obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        setContentHeight(r101.getLayoutDimension(13, 0));
        r101.recycle();
        ActionMenuPresenter r102 = this.mActionMenuPresenter;
        if (r102 == null) goto L6;
        r102.onConfigurationChanged(r100);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r102 = super.onHoverEvent(r100);
        if (r101 != 9) goto L12;
        if (r102 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r101 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r101 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r102 = super.onTouchEvent(r100);
        if (r101 != 0) goto L11;
        if (r102 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r101 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r101 != 3) goto L15;
        goto L14
    }

    public void setContentHeight(int r100) {
        this.mContentHeight = r100;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (r100 == getVisibility()) goto L9;
        ViewPropertyAnimatorCompat r101 = this.mVisibilityAnim;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        super.setVisibility(r100);
        return;
    }

    public AbsActionBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void access$001(AbsActionBarView r100, int r101) {
        super.setVisibility(r101);
    }

    public static /* synthetic */ void access$101(AbsActionBarView r100, int r101) {
        super.setVisibility(r101);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r100, long r101) {
        ViewPropertyAnimatorCompat r102 = this.mVisibilityAnim;
        if (r102 == null) goto L6;
        r102.cancel();
    L6:
        if (r100 == 0) goto L8;
        ViewPropertyAnimatorCompat r103 = ViewCompat.animate(this).alpha(0.0f);
        r103.setDuration(r101);
        r103.setListener(this.mVisAnimListener.withFinalVisibility(r103, r100));
        return r103;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ViewPropertyAnimatorCompat r104 = ViewCompat.animate(this).alpha(1.0f);
        r104.setDuration(r101);
        r104.setListener(this.mVisAnimListener.withFinalVisibility(r104, r100));
        return r104;
    }

    public AbsActionBarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue r103 = new TypedValue();
        if (r100.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, r103, true) == true) goto L5;
    L7:
        this.mPopupContext = r100;
        return;
    L5:
        if (r103.resourceId == 0) goto L7;
        this.mPopupContext = new ContextThemeWrapper(r100, r103.resourceId);
    }

    public int measureChildView(View r100, int r101, int r102, int r103) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE), r102);
        return Math.max(0, (r101 - r100.getMeasuredWidth()) - r103);
    }

    public int positionChild(View r100, int r101, int r102, int r103, boolean r104) {
        int r105 = r100.getMeasuredWidth();
        int r106 = r100.getMeasuredHeight();
        int r107 = r102 + ((r103 - r106) / 2);
        if (r104 == false) goto L5;
        r100.layout(r101 - r105, r107, r101, r106 + r107);
    L6:
        if (r104 == true) goto L8;
        return r105;
    L8:
        return -r105;
    L5:
        r100.layout(r101, r107, r101 + r105, r106 + r107);
        goto L6
    }
}
