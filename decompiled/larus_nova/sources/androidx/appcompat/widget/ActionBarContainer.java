package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r100, ActionMode.Callback r101) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.mBackground;
        if (r100 != null) goto L5;
    L7:
        Drawable r101 = this.mStackedBackground;
        if (r101 != null) goto L10;
    L12:
        Drawable r102 = this.mSplitBackground;
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.isStateful() == false) goto L19;
        this.mSplitBackground.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r101.isStateful() == false) goto L12;
        this.mStackedBackground.setState(getDrawableState());
        goto L12
    L5:
        if (r100.isStateful() == false) goto L7;
        this.mBackground.setState(getDrawableState());
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.mBackground;
        if (r100 == null) goto L5;
        r100.jumpToCurrentState();
    L5:
        Drawable r101 = this.mStackedBackground;
        if (r101 == null) goto L8;
        r101.jumpToCurrentState();
    L8:
        Drawable r102 = this.mSplitBackground;
        if (r102 == null) goto L12;
        r102.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public ActionBarContainer(Context r100) {
        this(r100, null);
    }

    private int getMeasuredHeightWithMargins(View r100) {
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        return (r100.getMeasuredHeight() + r101.topMargin) + r101.bottomMargin;
    }

    private boolean isCollapsed(View r100) {
        if (r100 != null) goto L4;
    L9:
        return true;
    L4:
        if (r100.getVisibility() == 8) goto L9;
        if (r100.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        super.onHoverEvent(r100);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.mIsTransitioning == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r100) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        super.onTouchEvent(r100);
        return true;
    }

    public void setPrimaryBackground(Drawable r100) {
        Drawable r101 = this.mBackground;
        if (r101 == null) goto L5;
        r101.setCallback(null);
        unscheduleDrawable(this.mBackground);
    L5:
        this.mBackground = r100;
        if (r100 == null) goto L10;
        r100.setCallback(this);
        View r102 = this.mActionBarView;
        if (r102 == null) goto L10;
        this.mBackground.setBounds(r102.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L10:
        boolean r103 = true;
        if (this.mIsSplit == false) goto L16;
        if (this.mSplitBackground == null) goto L21;
    L20:
        r103 = false;
    L21:
        setWillNotDraw(r103);
        invalidate();
        invalidateOutline();
        return;
    L16:
        if (this.mBackground != null) goto L20;
        if (this.mStackedBackground != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r100) {
        Drawable r101 = this.mSplitBackground;
        if (r101 == null) goto L5;
        r101.setCallback(null);
        unscheduleDrawable(this.mSplitBackground);
    L5:
        this.mSplitBackground = r100;
        boolean r102 = false;
        if (r100 == null) goto L13;
        r100.setCallback(this);
        if (this.mIsSplit == false) goto L13;
        Drawable r103 = this.mSplitBackground;
        if (r103 == null) goto L13;
        r103.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r102 = true;
    L22:
        setWillNotDraw(r102);
        invalidate();
        invalidateOutline();
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r100) {
        Drawable r101 = this.mStackedBackground;
        if (r101 == null) goto L5;
        r101.setCallback(null);
        unscheduleDrawable(this.mStackedBackground);
    L5:
        this.mStackedBackground = r100;
        if (r100 == null) goto L12;
        r100.setCallback(this);
        if (this.mIsStacked == false) goto L12;
        Drawable r102 = this.mStackedBackground;
        if (r102 == null) goto L12;
        r102.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    L12:
        boolean r103 = true;
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground == null) goto L23;
    L22:
        r103 = false;
    L23:
        setWillNotDraw(r103);
        invalidate();
        invalidateOutline();
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setTabContainer(ScrollingTabContainerView r100) {
        View r101 = this.mTabContainer;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.mTabContainer = r100;
        if (r100 == null) goto L9;
        addView(r100);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.width = -1;
        r102.height = -2;
        r100.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r100) {
        this.mIsTransitioning = r100;
        if (r100 == false) goto L5;
        int r101 = 393216;
    L6:
        setDescendantFocusability(r101);
        return;
    L5:
        r101 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        Drawable r102 = this.mBackground;
        if (r102 == null) goto L9;
        r102.setVisible(r101, false);
    L9:
        Drawable r103 = this.mStackedBackground;
        if (r103 == null) goto L12;
        r103.setVisible(r101, false);
    L12:
        Drawable r104 = this.mSplitBackground;
        if (r104 == null) goto L16;
        r104.setVisible(r101, false);
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (r100 != this.mBackground) goto L7;
        if (this.mIsSplit == true) goto L7;
    L16:
        return true;
    L7:
        if (r100 != this.mStackedBackground) goto L11;
        if (this.mIsStacked == true) goto L16;
    L11:
        if (r100 != this.mSplitBackground) goto L15;
        if (this.mIsSplit == true) goto L16;
    L15:
        if (super.verifyDrawable(r100) == true) goto L16;
        return false;
    }

    public ActionBarContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle});
        boolean r103 = false;
        this.mBackground = r102.getDrawable(0);
        this.mStackedBackground = r102.getDrawable(2);
        this.mHeight = r102.getDimensionPixelSize(13, -1);
        if (getId() != R.id.split_action_bar) goto L5;
        this.mIsSplit = true;
        this.mSplitBackground = r102.getDrawable(1);
    L5:
        r102.recycle();
        if (this.mIsSplit == false) goto L11;
        if (this.mSplitBackground != null) goto L15;
    L9:
        r103 = true;
    L15:
        setWillNotDraw(r103);
        return;
    L11:
        if (this.mBackground != null) goto L15;
        if (this.mStackedBackground != null) goto L15;
        goto L15
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mActionBarView == null) goto L5;
    L9:
        super.onMeasure(r100, r101);
        if (this.mActionBarView != null) goto L12;
        return;
    L12:
        int r102 = View.MeasureSpec.getMode(r101);
        View r103 = this.mTabContainer;
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r102 != 1073741824) goto L19;
        return;
    L19:
        if (isCollapsed(this.mActionBarView) == true) goto L22;
        int r104 = getMeasuredHeightWithMargins(this.mActionBarView);
    L25:
        if (r102 != Integer.MIN_VALUE) goto L27;
        int r105 = View.MeasureSpec.getSize(r101);
    L28:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r104 + getMeasuredHeightWithMargins(this.mTabContainer), r105));
        return;
    L27:
        r105 = Integer.MAX_VALUE;
        goto L28
    L22:
        if (isCollapsed(this.mContextView) == true) goto L24;
        r104 = getMeasuredHeightWithMargins(this.mContextView);
        goto L25
    L24:
        r104 = 0;
        goto L25
    L5:
        if (View.MeasureSpec.getMode(r101) != Integer.MIN_VALUE) goto L9;
        int r106 = this.mHeight;
        if (r106 < 0) goto L9;
        r101 = View.MeasureSpec.makeMeasureSpec(Math.min(r106, View.MeasureSpec.getSize(r101)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r100, ActionMode.Callback r101, int r102) {
        if (r102 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r100, r101, r102);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        View r105 = this.mTabContainer;
        boolean r106 = true;
        boolean r107 = false;
        if (r105 != null) goto L5;
    L7:
        boolean r108 = false;
    L8:
        if (r105 == null) goto L13;
        if (r105.getVisibility() == 8) goto L13;
        int r109 = getMeasuredHeight();
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        int r111 = r109 - r105.getMeasuredHeight();
        int r112 = r110.bottomMargin;
        r105.layout(r101, r111 - r112, r103, r109 - r112);
    L13:
        if (this.mIsSplit == false) goto L19;
        Drawable r113 = this.mSplitBackground;
        if (r113 == null) goto L17;
        r113.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L36:
        if (r106 == false) goto L39;
        invalidate();
        return;
    L39:
        return;
    L17:
        r106 = false;
        goto L36
    L19:
        if (this.mBackground != null) goto L21;
    L30:
        this.mIsStacked = r108;
        if (r108 == false) goto L35;
        Drawable r114 = this.mStackedBackground;
        if (r114 == null) goto L35;
        r114.setBounds(r105.getLeft(), r105.getTop(), r105.getRight(), r105.getBottom());
    L35:
        r106 = r107;
        goto L36
    L21:
        if (this.mActionBarView.getVisibility() != 0) goto L23;
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L29:
        r107 = true;
        goto L30
    L23:
        View r115 = this.mContextView;
        if (r115 != null) goto L26;
    L28:
        this.mBackground.setBounds(0, 0, 0, 0);
        goto L29
    L26:
        if (r115.getVisibility() != 0) goto L28;
        this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
        goto L29
    L5:
        if (r105.getVisibility() == 8) goto L7;
        r108 = true;
        goto L8
    }
}
