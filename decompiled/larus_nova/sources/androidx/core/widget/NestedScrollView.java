package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.os.BuildCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DECELERATION_RATE = 0.0f;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            NestedScrollView r102 = (NestedScrollView) r100;
            r101.setClassName(ScrollView.class.getName());
            if (r102.getScrollRange() <= 0) goto L5;
            boolean r103 = true;
        L6:
            r101.setScrollable(r103);
            r101.setScrollX(r102.getScrollX());
            r101.setScrollY(r102.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(r101, r102.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(r101, r102.getScrollRange());
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            NestedScrollView r102 = (NestedScrollView) r100;
            r101.setClassName(ScrollView.class.getName());
            if (r102.isEnabled() == false) goto L13;
            int r103 = r102.getScrollRange();
            if (r103 <= 0) goto L14;
            r101.setScrollable(true);
            if (r102.getScrollY() <= 0) goto L10;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        L10:
            if (r102.getScrollY() >= r103) goto L15;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L5;
            return true;
        L5:
            NestedScrollView r103 = (NestedScrollView) r100;
            if (r103.isEnabled() == true) goto L8;
            return false;
        L8:
            int r104 = r103.getHeight();
            Rect r105 = new Rect();
            if (r103.getMatrix().isIdentity() == false) goto L14;
            if (r103.getGlobalVisibleRect(r105) == false) goto L14;
            r104 = r105.height();
        L14:
            if (r101 != 4096) goto L16;
        L27:
            int r106 = (r104 - r103.getPaddingBottom()) - r103.getPaddingTop();
            int r107 = Math.min(r103.getScrollY() + r106, r103.getScrollRange());
            if (r107 == r103.getScrollY()) goto L31;
            r103.smoothScrollTo(0, r107, true);
            return true;
        L31:
            return false;
        L16:
            if (r101 != 8192) goto L18;
        L22:
            int r108 = (r104 - r103.getPaddingBottom()) - r103.getPaddingTop();
            int r109 = Math.max(r103.getScrollY() - r108, 0);
            if (r109 == r103.getScrollY()) goto L26;
            r103.smoothScrollTo(0, r109, true);
            return true;
        L26:
            return false;
        L18:
            if (r101 == 16908344) goto L22;
            if (r101 == 16908346) goto L27;
            return false;
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean getClipToPadding(ViewGroup r100) {
            return r100.getClipToPadding();
        }
    }

    public static final class Api35Impl {
        private Api35Impl() {
        }

        public static void setFrameContentVelocity(View r100, float r101) {
            r100.setFrameContentVelocity(r101);     // Catch: LinkageError -> L4
            return;
        }
    }

    public class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        final /* synthetic */ NestedScrollView this$0;

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -this.this$0.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.access$000(this.this$0).abortAnimation();
        }

        public DifferentialMotionFlingTargetImpl(NestedScrollView r100) {
            this.this$0 = r100;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float r100) {
            if (r100 != 0.0f) goto L6;
            return false;
        L6:
            stopDifferentialMotionFling();
            this.this$0.fling((int) r100);
            return true;
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView r100, int r101, int r102, int r103, int r104);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + i.f25855d;
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.scrollPosition = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.scrollPosition);
        }
    }

    private static int clamp(int r100, int r101, int r102) {
        if (r101 >= r102) goto L10;
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        if ((r101 + r100) > r102) goto L8;
        return r100;
    L8:
        return r102 - r101;
    L10:
        return 0;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r100.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r100 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r100.getScaledTouchSlop();
        this.mMinimumVelocity = r100.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r100.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void recycleVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.mVelocityTracker = null;
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r100 = this.mScroller.getCurrY();
        int r101 = consumeFlingInVerticalStretch(r100 - this.mLastScrollerY);
        this.mLastScrollerY = r100;
        int[] r102 = this.mScrollConsumed;
        boolean r110 = false;
        r102[1] = 0;
        dispatchNestedPreScroll(0, r101, r102, null, 1);
        int r111 = r101 - this.mScrollConsumed[1];
        int r112 = getScrollRange();
        if (BuildCompat.isAtLeastV() == false) goto L8;
        Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
    L8:
        if (r111 == 0) goto L10;
        int r113 = getScrollY();
        overScrollByCompat(0, r111, getScrollX(), r113, 0, r112, 0, 0, false);
        int r103 = getScrollY() - r113;
        int r114 = r111 - r103;
        int[] r104 = this.mScrollConsumed;
        r104[1] = 0;
        dispatchNestedScroll(0, r103, 0, r114, this.mScrollOffset, 1, r104);
        r111 = r114 - this.mScrollConsumed[1];
    L10:
        if (r111 == 0) goto L26;
        int r105 = getOverScrollMode();
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L16;
        if (r112 > 0) goto L15;
    L16:
        if (r110 == false) goto L24;
        if (r111 >= 0) goto L22;
        if (this.mEdgeGlowTop.isFinished() == false) goto L24;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L24
    L22:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L24;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L24:
        abortAnimatedScroll();
    L15:
        r110 = true;
    L26:
        if (this.mScroller.isFinished() == true) goto L28;
        postInvalidateOnAnimation();
        return;
    L28:
        stopNestedScroll(1);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r100 = new TypedValue();
        Context r101 = getContext();
        if (r101.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r100, true) == false) goto L8;
        this.mVerticalScrollFactor = r100.getDimension(INVOKEVIRTUAL_androidx_core_widget_NestedScrollView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()));
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    private boolean canOverScroll() {
        int r100 = getOverScrollMode();
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L6;
    L8:
        return false;
    L6:
        if (getScrollRange() <= 0) goto L8;
        return true;
    L10:
        return true;
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) goto L8;
        View r100 = getChildAt(0);
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        if (((r100.getHeight() + r101.topMargin) + r101.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        int r100 = getChildCount();
        int r101 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r100 != 0) goto L5;
        return r101;
    L5:
        View r102 = getChildAt(0);
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102.getLayoutParams();
        int r104 = r102.getBottom() + r103.bottomMargin;
        int r105 = getScrollY();
        int r106 = Math.max(0, r104 - r101);
        if (r105 < 0) goto L11;
        if (r105 > r106) goto L10;
        return r104;
    L10:
        return r104 + (r105 - r106);
    L11:
        return r104 - r105;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r100 = getChildAt(0);
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        int r102 = getVerticalFadingEdgeLength();
        int r103 = ((r100.getBottom() + r101.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r103 < r102) goto L9;
        return 1.0f;
    L9:
        return r103 / r102;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r100 = getChildAt(0);
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        return Math.max(0, ((r100.getHeight() + r101.topMargin) + r101.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r100 = getVerticalFadingEdgeLength();
        int r101 = getScrollY();
        if (r101 < r100) goto L9;
        return 1.0f;
    L9:
        return r101 / r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.scrollPosition = getScrollY();
        return r100;
    }

    static {
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public NestedScrollView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_widget_NestedScrollView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ OverScroller access$000(NestedScrollView r100) {
        return r100.mScroller;
    }

    private void doScrollY(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r100);
        return;
    L6:
        scrollBy(0, r100);
    }

    private boolean edgeEffectFling(int r100) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L9;
        if (shouldAbsorb(this.mEdgeGlowTop, r100) == false) goto L7;
        this.mEdgeGlowTop.onAbsorb(r100);
    L14:
        return true;
    L7:
        fling(-r100);
        goto L14
    L9:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L15;
        int r101 = -r100;
        if (shouldAbsorb(this.mEdgeGlowBottom, r101) == false) goto L13;
        this.mEdgeGlowBottom.onAbsorb(r101);
        goto L14
    L13:
        fling(r101);
        goto L14
    L15:
        return false;
    }

    private float getSplineFlingDistance(int r100) {
        double r101 = Math.log((Math.abs(r100) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float r102 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoeff * SCROLL_FRICTION)) * Math.exp((r102 / (((double) r102) - 1.0d)) * r101));
    }

    private boolean isOffScreen(View r100) {
        return !isWithinDeltaOfScreen(r100, 0, getHeight());
    }

    private void onSecondaryPointerUp(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.mActivePointerId) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.mLastMotionY = (int) r100.getY(r102);
        this.mActivePointerId = r100.getPointerId(r102);
        VelocityTracker r103 = this.mVelocityTracker;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    private void runAnimatedScroll(boolean r100) {
        if (r100 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    private void scrollToChild(View r100) {
        r100.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r100, this.mTempRect);
        int r101 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r101 == 0) goto L6;
        scrollBy(0, r101);
        return;
    }

    private boolean stopGlowAnimations(MotionEvent r100) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L5;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, r100.getX() / getWidth());
        boolean r101 = true;
    L7:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L10;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (r100.getX() / getWidth()));
        return true;
    L10:
        return r101;
    L5:
        r101 = false;
        goto L7
    }

    @Override // android.view.ViewGroup
    public void addView(View r100) {
        if (getChildCount() > 0) goto L7;
        super.addView(r100);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r100) {
        View r101 = findFocus();
        if (r101 != this) goto L5;
        r101 = null;
    L5:
        View r102 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        int r103 = getMaxScrollAmount();
        if (r102 == null) goto L11;
        if (isWithinDeltaOfScreen(r102, r103, getHeight()) == false) goto L11;
        r102.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r102, this.mTempRect);
        scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
        r102.requestFocus(r100);
    L25:
        if (r101 != null) goto L27;
    L31:
        return true;
    L27:
        if (r101.isFocused() == false) goto L31;
        if (isOffScreen(r101) == false) goto L31;
        int r104 = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(r104);
    L11:
        if (r100 == 33) goto L13;
    L15:
        if (r100 == 130) goto L17;
    L19:
        if (r103 != 0) goto L21;
        return false;
    L21:
        if (r100 == 130) goto L24;
        r103 = -r103;
    L24:
        scrollBy(r103, 0, 1, true);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r105 = getChildAt(0);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        r103 = Math.min((r105.getBottom() + r106.bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), r103);
        goto L19
    L13:
        if (getScrollY() >= r103) goto L15;
        r103 = getScrollY();
        goto L19
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect r110) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r100 = getHeight();
        int r101 = getScrollY();
        int r102 = r101 + r100;
        int r103 = getVerticalFadingEdgeLength();
        if (r110.top <= 0) goto L8;
        r101 = r101 + r103;
    L8:
        View r104 = getChildAt(0);
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104.getLayoutParams();
        if (r110.bottom >= ((r104.getHeight() + r105.topMargin) + r105.bottomMargin)) goto L11;
        int r106 = r102 - r103;
    L12:
        int r107 = r110.bottom;
        if (r107 <= r106) goto L22;
        if (r110.top <= r101) goto L22;
        if (r110.height() <= r100) goto L19;
        int r111 = r110.top - r101;
    L30:
        return Math.min(r111 + 0, (r104.getBottom() + r105.bottomMargin) - r102);
    L19:
        r111 = r110.bottom - r106;
    L22:
        if (r110.top >= r101) goto L31;
        if (r107 < r106) goto L25;
        return 0;
    L25:
        if (r110.height() <= r100) goto L27;
        int r108 = 0 - (r106 - r110.bottom);
    L29:
        return Math.max(r108, -getScrollY());
    L27:
        r108 = 0 - (r101 - r110.top);
        goto L29
    L31:
        return 0;
    L11:
        r106 = r102;
        goto L12
    }

    int consumeFlingInVerticalStretch(int r100) {
        int r101 = getHeight();
        if (r100 > 0) goto L5;
    L11:
        if (r100 < 0) goto L13;
        return r100;
    L13:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L20;
        float r102 = r101;
        int r103 = Math.round((r102 / 4.0f) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (r100 * 4.0f) / r102, 0.5f));
        if (r103 == r100) goto L18;
        this.mEdgeGlowBottom.finish();
    L18:
        return r100 - r103;
    L20:
        return r100;
    L5:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L11;
        int r104 = Math.round(((-r101) / 4.0f) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-r100) * 4.0f) / r101, 0.5f));
        if (r104 == r100) goto L10;
        this.mEdgeGlowTop.finish();
    L10:
        return r100 - r104;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r100) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        super.draw(r110);
        int r100 = getScrollY();
        int r101 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L16;
        int r102 = r110.save();
        int r103 = getWidth();
        int r104 = getHeight();
        int r105 = Math.min(0, r100);
        if (Api21Impl.getClipToPadding(this) == false) goto L7;
        r103 = r103 - (getPaddingLeft() + getPaddingRight());
        int r106 = getPaddingLeft() + 0;
    L9:
        if (Api21Impl.getClipToPadding(this) == false) goto L11;
        r104 = r104 - (getPaddingTop() + getPaddingBottom());
        r105 = r105 + getPaddingTop();
    L11:
        r110.translate(r106, r105);
        this.mEdgeGlowTop.setSize(r103, r104);
        if (this.mEdgeGlowTop.draw(r110) == false) goto L14;
        postInvalidateOnAnimation();
    L14:
        r110.restoreToCount(r102);
        goto L16
    L7:
        r106 = 0;
    L16:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L28;
        int r107 = r110.save();
        int r108 = getWidth();
        int r109 = getHeight();
        int r111 = Math.max(getScrollRange(), r100) + r109;
        if (Api21Impl.getClipToPadding(this) == false) goto L21;
        r108 = r108 - (getPaddingLeft() + getPaddingRight());
        r101 = 0 + getPaddingLeft();
    L21:
        if (Api21Impl.getClipToPadding(this) == false) goto L23;
        r109 = r109 - (getPaddingTop() + getPaddingBottom());
        r111 = r111 - getPaddingBottom();
    L23:
        r110.translate(r101 - r108, r111);
        r110.rotate(180.0f, r108, 0.0f);
        this.mEdgeGlowBottom.setSize(r108, r109);
        if (this.mEdgeGlowBottom.draw(r110) == false) goto L26;
        postInvalidateOnAnimation();
    L26:
        r110.restoreToCount(r107);
        return;
    }

    public boolean executeKeyEvent(KeyEvent r100) {
        this.mTempRect.setEmpty();
        int r101 = 130;
        if (canScroll() == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r100.getKeyCode() == 4) goto L53;
        View r102 = findFocus();
        if (r102 != this) goto L11;
        r102 = null;
    L11:
        View r103 = FocusFinder.getInstance().findNextFocus(this, r102, 130);
        if (r103 == null) goto L54;
        if (r103 != this) goto L15;
        return false;
    L15:
        if (r103.requestFocus(130) == false) goto L56;
        return true;
    L56:
        return false;
    L54:
        return false;
    L53:
        return false;
    L19:
        if (r100.getAction() != 0) goto L57;
        int r104 = r100.getKeyCode();
        if (r104 == 19) goto L48;
        if (r104 == 20) goto L44;
        if (r104 == 62) goto L40;
        if (r104 == 92) goto L61;
        if (r104 == 93) goto L60;
        if (r104 != 122) goto L33;
        pageScroll(33);
        return false;
    L33:
        if (r104 != 123) goto L66;
        pageScroll(130);
        return false;
    L66:
        return false;
    L60:
        return fullScroll(130);
    L61:
        return fullScroll(33);
    L40:
        if (r100.isShiftPressed() == false) goto L42;
        r101 = 33;
    L42:
        pageScroll(r101);
        return false;
    L44:
        if (r100.isAltPressed() == false) goto L64;
        return fullScroll(130);
    L64:
        return arrowScroll(130);
    L48:
        if (r100.isAltPressed() == false) goto L51;
        return fullScroll(33);
    L51:
        return arrowScroll(33);
    L57:
        return false;
    }

    public void fling(int r110) {
        if (getChildCount() <= 0) goto L8;
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
        if (BuildCompat.isAtLeastV() == false) goto L9;
        Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
        return;
    L9:
        return;
    }

    public boolean fullScroll(int r100) {
        if (r100 != 130) goto L5;
        boolean r101 = true;
    L6:
        int r102 = getHeight();
        Rect r103 = this.mTempRect;
        r103.top = 0;
        r103.bottom = r102;
        if (r101 == false) goto L11;
        int r104 = getChildCount();
        if (r104 <= 0) goto L11;
        View r105 = getChildAt(r104 - 1);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        Rect r107 = this.mTempRect;
        r107.bottom = (r105.getBottom() + r106.bottomMargin) + getPaddingBottom();
        Rect r108 = this.mTempRect;
        r108.top = r108.bottom - r102;
    L11:
        Rect r109 = this.mTempRect;
        return scrollAndFocus(r100, r109.top, r109.bottom);
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r100) {
        return this.mChildHelper.hasNestedScrollingParent(r100);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r100) {
        if (r100.getAction() == 8) goto L5;
    L19:
        return false;
    L5:
        if (this.mIsBeingDragged == true) goto L19;
        if (MotionEventCompat.isFromSource(r100, 2) == false) goto L10;
        int r101 = 9;
        float r102 = r100.getAxisValue(9);
        int r103 = (int) r100.getX();
    L14:
        if (r102 == 0.0f) goto L19;
        int r104 = (int) (r102 * getVerticalScrollFactorCompat());
        int r105 = -r104;
        scrollBy(r105, r103, 1, MotionEventCompat.isFromSource(r100, 8194));
        if (r101 == 0) goto L18;
        this.mDifferentialMotionFlingController.onMotionEvent(r100, r101);
    L18:
        return true;
    L10:
        if (MotionEventCompat.isFromSource(r100, 4194304) == false) goto L12;
        float r106 = r100.getAxisValue(26);
        r102 = r106;
        r103 = getWidth() / 2;
        r101 = 26;
        goto L14
    L12:
        r101 = 0;
        r102 = 0.0f;
        r103 = 0;
        goto L14
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        boolean r101 = true;
        if (r100 == 2) goto L5;
    L7:
        int r102 = r100 & 255;
        if (r102 != 0) goto L10;
        int r103 = (int) r110.getY();
        if (inChild((int) r110.getX(), r103) == false) goto L38;
        this.mLastMotionY = r103;
        this.mActivePointerId = r110.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r110);
        this.mScroller.computeScrollOffset();
        if (stopGlowAnimations(r110) == false) goto L47;
    L50:
        this.mIsBeingDragged = r101;
        startNestedScroll(2, 0);
    L52:
        return this.mIsBeingDragged;
    L47:
        if (this.mScroller.isFinished() == false) goto L50;
        r101 = false;
        goto L50
    L38:
        if (stopGlowAnimations(r110) == false) goto L40;
    L43:
        this.mIsBeingDragged = r101;
        recycleVelocityTracker();
        goto L52
    L40:
        if (this.mScroller.isFinished() == false) goto L43;
        r101 = false;
        goto L43
    L10:
        if (r102 == 1) goto L31;
        if (r102 != 2) goto L13;
        int r104 = this.mActivePointerId;
        if (r104 == (-1)) goto L52;
        int r105 = r110.findPointerIndex(r104);
        if (r105 == (-1)) goto L52;
        int r106 = (int) r110.getY(r105);
        if (Math.abs(r106 - this.mLastMotionY) <= this.mTouchSlop) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r106;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r110);
        this.mNestedYOffset = 0;
        ViewParent r111 = getParent();
        if (r111 == null) goto L52;
        r111.requestDisallowInterceptTouchEvent(true);
        goto L52
    L13:
        if (r102 == 3) goto L31;
        if (r102 != 6) goto L52;
        onSecondaryPointerUp(r110);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        postInvalidateOnAnimation();
    L34:
        stopNestedScroll(0);
        goto L52
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.mSavedState = r101;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        initVelocityTrackerIfNotExists();
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r101 = MotionEvent.obtain(r110);
        r101.offsetLocation(0.0f, this.mNestedYOffset);
        if (r100 == 0) goto L56;
        if (r100 != 1) goto L9;
        VelocityTracker r111 = this.mVelocityTracker;
        r111.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r112 = (int) r111.getYVelocity(this.mActivePointerId);
        if (Math.abs(r112) < this.mMinimumVelocity) goto L52;
        if (edgeEffectFling(r112) == true) goto L54;
        int r113 = -r112;
        float r102 = r113;
        if (dispatchNestedPreFling(0.0f, r102) == true) goto L54;
        dispatchNestedFling(0.0f, r102, true);
        fling(r113);
    L54:
        endTouchDrag();
    L67:
        VelocityTracker r114 = this.mVelocityTracker;
        if (r114 == null) goto L70;
        r114.addMovement(r101);
    L70:
        r101.recycle();
        return true;
    L52:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L54;
        postInvalidateOnAnimation();
        goto L54
    L9:
        if (r100 != 2) goto L11;
        int r103 = r110.findPointerIndex(this.mActivePointerId);
        if (r103 == (-1)) goto L67;
        int r104 = (int) r110.getY(r103);
        int r105 = this.mLastMotionY - r104;
        int r106 = r105 - releaseVerticalGlow(r105, r110.getX(r103));
        if (this.mIsBeingDragged == true) goto L42;
        if (Math.abs(r106) <= this.mTouchSlop) goto L42;
        ViewParent r107 = getParent();
        if (r107 == null) goto L37;
        r107.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        if (r106 <= 0) goto L40;
        r106 = r106 - this.mTouchSlop;
        goto L42
    L40:
        r106 = r106 + this.mTouchSlop;
    L42:
        if (this.mIsBeingDragged == false) goto L67;
        int r115 = scrollBy(r106, (int) r110.getX(r103), 0, false);
        this.mLastMotionY = r104 - r115;
        this.mNestedYOffset += r115;
        goto L67
    L11:
        if (r100 == 3) goto L20;
        if (r100 != 5) goto L15;
        int r108 = r110.getActionIndex();
        this.mLastMotionY = (int) r110.getY(r108);
        this.mActivePointerId = r110.getPointerId(r108);
        goto L67
    L15:
        if (r100 != 6) goto L67;
        onSecondaryPointerUp(r110);
        this.mLastMotionY = (int) r110.getY(r110.findPointerIndex(this.mActivePointerId));
        goto L67
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L26:
        endTouchDrag();
        goto L67
    L22:
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
        postInvalidateOnAnimation();
        goto L26
    L56:
        if (getChildCount() != 0) goto L59;
        return false;
    L59:
        if (this.mIsBeingDragged == false) goto L64;
        ViewParent r109 = getParent();
        if (r109 == null) goto L64;
        r109.requestDisallowInterceptTouchEvent(true);
    L64:
        if (this.mScroller.isFinished() == true) goto L66;
        abortAnimatedScroll();
    L66:
        initializeTouchDrag((int) r110.getY(), r110.getPointerId(0));
        goto L67
    }

    public boolean pageScroll(int r100) {
        if (r100 != 130) goto L5;
        boolean r101 = true;
    L6:
        int r102 = getHeight();
        if (r101 == false) goto L13;
        Rect r103 = this.mTempRect;
        r103.top = getScrollY() + r102;
        int r104 = getChildCount();
        if (r104 <= 0) goto L16;
        View r105 = getChildAt(r104 - 1);
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105.getLayoutParams();
        int r107 = (r105.getBottom() + r106.bottomMargin) + getPaddingBottom();
        Rect r108 = this.mTempRect;
        if ((r108.top + r102) <= r107) goto L16;
        r108.top = r107 - r102;
    L16:
        Rect r109 = this.mTempRect;
        int r110 = r109.top;
        int r111 = r102 + r110;
        r109.bottom = r111;
        return scrollAndFocus(r100, r110, r111);
    L13:
        Rect r112 = this.mTempRect;
        r112.top = getScrollY() - r102;
        Rect r113 = this.mTempRect;
        if (r113.top >= 0) goto L16;
        r113.top = 0;
        goto L16
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        if (r100 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setFillViewport(boolean r100) {
        if (r100 == this.mFillViewport) goto L6;
        this.mFillViewport = r100;
        requestLayout();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.mChildHelper.setNestedScrollingEnabled(r100);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener r100) {
        this.mOnScrollChangeListener = r100;
    }

    public void setSmoothScrollingEnabled(boolean r100) {
        this.mSmoothScrollingEnabled = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r100) {
        this.mChildHelper.stopNestedScroll(r100);
    }

    public NestedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.nestedScrollViewStyle);
    }

    private boolean inChild(int r100, int r101) {
        if (getChildCount() <= 0) goto L14;
        int r102 = getScrollY();
        View r103 = getChildAt(0);
        if (r101 >= (r103.getTop() - r102)) goto L7;
        return false;
    L7:
        if (r101 < (r103.getBottom() - r102)) goto L9;
        return false;
    L9:
        if (r100 >= r103.getLeft()) goto L11;
        return false;
    L11:
        if (r100 >= r103.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    private void initializeTouchDrag(int r100, int r101) {
        this.mLastMotionY = r100;
        this.mActivePointerId = r101;
        startNestedScroll(2, 0);
    }

    private static boolean isViewDescendantOf(View r100, View r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        Object r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (isViewDescendantOf((View) r102, r101) == false) goto L10;
        return true;
    }

    private int releaseVerticalGlow(int r100, float r101) {
        float r102 = r101 / getWidth();
        float r103 = r100 / getHeight();
        float r104 = 0.0f;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L9;
        float r105 = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -r103, r102);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) goto L7;
        this.mEdgeGlowTop.onRelease();
    L7:
        r104 = r105;
    L13:
        int r106 = Math.round(r104 * getHeight());
        if (r106 == 0) goto L16;
        invalidate();
    L16:
        return r106;
    L9:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L13;
        r105 = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r103, 1.0f - r102);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) goto L7;
        this.mEdgeGlowBottom.onRelease();
        goto L7
    }

    private boolean scrollToChildRect(Rect r100, boolean r101) {
        int r102 = computeScrollDeltaToGetChildRectOnScreen(r100);
        if (r102 == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        if (r101 == false) goto L9;
        scrollBy(0, r102);
        goto L10
    L9:
        smoothScrollBy(0, r102);
    L10:
        return r103;
    L5:
        r103 = false;
        goto L6
    }

    private boolean shouldAbsorb(EdgeEffect r100, int r101) {
        if (r101 <= 0) goto L6;
        return true;
    L6:
        if (getSplineFlingDistance(-r101) < (EdgeEffectCompat.getDistance(r100) * getHeight())) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101) {
        if (getChildCount() > 0) goto L7;
        super.addView(r100, r101);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.mChildHelper.dispatchNestedPreFling(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r101) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r102 = getChildAt(0);
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102.getLayoutParams();
        int r104 = r102.getMeasuredHeight();
        int r105 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r103.topMargin) - r103.bottomMargin;
        if (r104 >= r105) goto L15;
        r102.measure(FrameLayout.getChildMeasureSpec(r100, ((getPaddingLeft() + getPaddingRight()) + r103.leftMargin) + r103.rightMargin, r103.width), View.MeasureSpec.makeMeasureSpec(r105, 1073741824));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r100, Rect r101) {
        if (r100 != 2) goto L6;
        r100 = 130;
    L8:
        if (r101 != null) goto L10;
        View r102 = FocusFinder.getInstance().findNextFocus(this, null, r100);
    L12:
        if (r102 != null) goto L15;
        return false;
    L15:
        if (isOffScreen(r102) == false) goto L18;
        return false;
    L18:
        return r102.requestFocus(r100, r101);
    L10:
        r102 = FocusFinder.getInstance().findNextFocusFromRect(this, r101, r100);
        goto L12
    L6:
        if (r100 != 1) goto L8;
        r100 = 33;
        goto L8
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r100, int r101) {
        this.mParentHelper.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r100, View r101) {
        if (this.mIsLayoutDirty == true) goto L5;
        scrollToChild(r101);
    L6:
        super.requestChildFocus(r100, r101);
        return;
    L5:
        this.mChildToScrollTo = r101;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r100, int r101) {
        if (getChildCount() <= 0) goto L10;
        View r102 = getChildAt(0);
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102.getLayoutParams();
        int r104 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r105 = (r102.getWidth() + r103.leftMargin) + r103.rightMargin;
        int r106 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r107 = (r102.getHeight() + r103.topMargin) + r103.bottomMargin;
        int r108 = clamp(r100, r104, r105);
        int r109 = clamp(r101, r106, r107);
        if (r108 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r108, r109);
        return;
    L7:
        if (r109 != getScrollY()) goto L8;
        return;
    }

    public final void smoothScrollBy(int r100, int r101) {
        smoothScrollBy(r100, r101, 250, false);
    }

    public final void smoothScrollTo(int r100, int r101) {
        smoothScrollTo(r100, r101, 250, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r100, int r101) {
        return this.mChildHelper.startNestedScroll(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r100, ViewGroup.LayoutParams r101) {
        if (getChildCount() > 0) goto L7;
        super.addView(r100, r101);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public NestedScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl r103 = new DifferentialMotionFlingTargetImpl(this);
        this.mDifferentialMotionFlingTarget = r103;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), r103);
        this.mEdgeGlowTop = EdgeEffectCompat.create(r100, r101);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(r100, r101);
        this.mPhysicalCoeff = ((INVOKEVIRTUAL_androidx_core_widget_NestedScrollView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density * 160.0f) * 386.0878f) * 0.84f;
        initScrollView();
        TypedArray r104 = r100.obtainStyledAttributes(r101, SCROLLVIEW_STYLEABLE, r102, 0);
        setFillViewport(r104.getBoolean(0, false));
        r104.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private View findFocusableViewInBounds(boolean r110, int r111, int r112) {
        ArrayList r100 = getFocusables(2);
        int r101 = r100.size();
        View r102 = null;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r101) goto L31;
        View r105 = (View) ListProtector.get(r100, r103);
        int r106 = r105.getTop();
        int r107 = r105.getBottom();
        if (r111 >= r107) goto L30;
        if (r106 >= r112) goto L30;
        if (r111 >= r106) goto L11;
        if (r107 >= r112) goto L11;
        boolean r113 = true;
    L12:
        if (r102 != null) goto L14;
        r102 = r105;
        r104 = r113;
        goto L30
    L14:
        if (r110 == true) goto L16;
    L17:
        if (r110 == false) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r104 == false) goto L26;
        if (r113 == false) goto L30;
        if (r108 == false) goto L30;
    L29:
        r102 = r105;
        goto L30
    L26:
        if (r113 == false) goto L28;
        r102 = r105;
        r104 = true;
        goto L30
    L28:
        if (r108 == false) goto L30;
    L19:
        if (r107 <= r102.getBottom()) goto L21;
    L20:
        r108 = true;
        goto L22
    L16:
        if (r106 < r102.getTop()) goto L20;
    L11:
        r113 = false;
    L30:
        r103 = r103 + 1;
        goto L3
    L31:
        return r102;
    }

    private boolean isWithinDeltaOfScreen(View r100, int r101, int r102) {
        r100.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r100, this.mTempRect);
        if ((this.mTempRect.bottom + r101) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r101) > (getScrollY() + r102)) goto L7;
        return true;
    }

    private void onNestedScrollInternal(int r110, int r111, int[] r112) {
        int r100 = getScrollY();
        scrollBy(0, r110);
        int r101 = getScrollY() - r100;
        if (r112 == null) goto L5;
        r112[1] = r112[1] + r101;
    L5:
        NestedScrollingChildHelper r102 = this.mChildHelper;
        r102.dispatchNestedScroll(0, r101, 0, r110 - r101, null, r111, r112);
    }

    private boolean scrollAndFocus(int r100, int r101, int r102) {
        int r103 = getHeight();
        int r104 = getScrollY();
        int r105 = r103 + r104;
        boolean r106 = false;
        if (r100 != 33) goto L5;
        boolean r107 = true;
    L6:
        View r108 = findFocusableViewInBounds(r107, r101, r102);
        if (r108 != null) goto L9;
        r108 = this;
    L9:
        if (r101 < r104) goto L12;
        if (r102 > r105) goto L12;
    L17:
        if (r108 == findFocus()) goto L19;
        r108.requestFocus(r100);
    L19:
        return r106;
    L12:
        if (r107 == false) goto L14;
        int r109 = r101 - r104;
    L15:
        scrollBy(r109, 0, 1, true);
        r106 = true;
        goto L17
    L14:
        r109 = r102 - r105;
        goto L15
    L5:
        r107 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (getChildCount() > 0) goto L7;
        super.addView(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.mChildHelper.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public void measureChild(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r100.measure(FrameLayout.getChildMeasureSpec(r101, getPaddingLeft() + getPaddingRight(), r103.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r100, View r101, int r102) {
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
        r101.offset(r100.getLeft() - r100.getScrollX(), r100.getTop() - r100.getScrollY());
        return scrollToChildRect(r101, r102);
    }

    public final void smoothScrollBy(int r100, int r101, int r102) {
        smoothScrollBy(r100, r101, r102, false);
    }

    public void smoothScrollTo(int r100, int r101, boolean r102) {
        smoothScrollTo(r100, r101, 250, r102);
    }

    public final void smoothScrollTo(int r100, int r101, int r102) {
        smoothScrollTo(r100, r101, r102, false);
    }

    private int scrollBy(int r210, int r211, int r212, boolean r213) {
        if (r212 != 1) goto L5;
        startNestedScroll(2, r212);
    L5:
        boolean r110 = false;
        if (dispatchNestedPreScroll(0, r210, this.mScrollConsumed, this.mScrollOffset, r212) == false) goto L8;
        int r111 = r210 - this.mScrollConsumed[1];
        int r112 = this.mScrollOffset[1] + 0;
    L9:
        int r113 = getScrollY();
        int r100 = getScrollRange();
        if (canOverScroll() == false) goto L13;
        if (r213 == true) goto L13;
        boolean r114 = true;
    L15:
        if (overScrollByCompat(0, r111, 0, r113, 0, r100, 0, 0, true) == true) goto L17;
    L19:
        boolean r101 = false;
    L20:
        int r102 = getScrollY() - r113;
        int[] r103 = this.mScrollConsumed;
        r103[1] = 0;
        dispatchNestedScroll(0, r102, 0, r111 - r102, this.mScrollOffset, r212, r103);
        int r115 = r112 + this.mScrollOffset[1];
        int r116 = r111 - this.mScrollConsumed[1];
        int r104 = r113 + r116;
        if (r104 >= 0) goto L27;
        if (r114 == false) goto L33;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-r116) / getHeight(), r211 / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L33;
        this.mEdgeGlowBottom.onRelease();
    L33:
        if (this.mEdgeGlowTop.isFinished() == true) goto L35;
    L38:
        postInvalidateOnAnimation();
    L39:
        if (r110 == false) goto L44;
        if (r212 != 0) goto L44;
        VelocityTracker r105 = this.mVelocityTracker;
        if (r105 == null) goto L44;
        r105.clear();
    L44:
        if (r212 != 1) goto L46;
        stopNestedScroll(r212);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    L46:
        return r115;
    L35:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L38;
        r110 = r101;
        goto L39
    L27:
        if (r104 <= r100) goto L33;
        if (r114 == false) goto L33;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r116 / getHeight(), 1.0f - (r211 / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L33;
        this.mEdgeGlowTop.onRelease();
        goto L33
    L17:
        if (hasNestedScrollingParent(r212) == true) goto L19;
        r101 = true;
    L13:
        r114 = false;
        goto L15
    L8:
        r111 = r210;
        r112 = 0;
        goto L9
    }

    private void smoothScrollBy(int r100, int r110, int r111, boolean r112) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r101 = getChildAt(0);
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101.getLayoutParams();
        int r103 = (r101.getHeight() + r102.topMargin) + r102.bottomMargin;
        int r104 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r105 = getScrollY();
        int r113 = r110 + r105;
        int r106 = Math.max(0, Math.min(r113, Math.max(0, r103 - r104))) - r105;
        this.mScroller.startScroll(getScrollX(), r105, 0, r106, r111);
        runAnimatedScroll(r112);
    L12:
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        return;
    L9:
        if (this.mScroller.isFinished() == true) goto L11;
        abortAnimatedScroll();
    L11:
        scrollBy(r100, r110);
        goto L12
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        if (r103 == true) goto L5;
        dispatchNestedFling(0.0f, r102, true);
        fling((int) r102);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        onNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        this.mParentHelper.onNestedScrollAccepted(r100, r101, r102, r103);
        startNestedScroll(2, r103);
    }

    @Override // android.view.View
    public void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        super.scrollTo(r100, r101);
    }

    @Override // android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r110) {
        super.onScrollChanged(r100, r101, r102, r110);
        OnScrollChangeListener r103 = this.mOnScrollChangeListener;
        if (r103 == null) goto L6;
        r103.onScrollChange(this, r100, r101, r102, r110);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        View r104 = findFocus();
        if (r104 == null) goto L10;
        if (this != r104) goto L7;
        return;
    L7:
        if (isWithinDeltaOfScreen(r104, 0, r103) == false) goto L11;
        r104.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r104, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    public void smoothScrollTo(int r100, int r101, int r102, boolean r103) {
        smoothScrollBy(r100 - getScrollX(), r101 - getScrollY(), r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.mChildHelper.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.mChildHelper.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        r100.measure(FrameLayout.getChildMeasureSpec(r101, (((getPaddingLeft() + getPaddingRight()) + r105.leftMargin) + r105.rightMargin) + r102, r105.width), View.MeasureSpec.makeMeasureSpec(r105.topMargin + r105.bottomMargin, 0));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        this.mIsLayoutDirty = false;
        View r106 = this.mChildToScrollTo;
        if (r106 != null) goto L5;
    L7:
        this.mChildToScrollTo = null;
        if (this.mIsLaidOut == false) goto L10;
    L18:
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
        return;
    L10:
        if (this.mSavedState == null) goto L13;
        scrollTo(getScrollX(), this.mSavedState.scrollPosition);
        this.mSavedState = null;
    L13:
        if (getChildCount() <= 0) goto L15;
        View r107 = getChildAt(0);
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107.getLayoutParams();
        r105 = (r107.getMeasuredHeight() + r108.topMargin) + r108.bottomMargin;
    L15:
        int r109 = ((r104 - r102) - getPaddingTop()) - getPaddingBottom();
        int r110 = getScrollY();
        int r111 = clamp(r110, r109, r105);
        if (r111 == r110) goto L18;
        scrollTo(getScrollX(), r111);
        goto L18
    L5:
        if (isViewDescendantOf(r106, this) == false) goto L7;
        scrollToChild(this.mChildToScrollTo);
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r110, int r111) {
        dispatchNestedPreScroll(r101, r102, r110, null, r111);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104) {
        onNestedScrollInternal(r104, 0, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.mChildHelper.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        onNestedScrollInternal(r104, r105, null);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113, int r114, int[] r115) {
        this.mChildHelper.dispatchNestedScroll(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        onNestedScrollInternal(r104, r105, r106);
    }

    boolean overScrollByCompat(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, boolean r211) {
        int r100 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r101 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r102 = true;
    L10:
        if (r100 == 0) goto L15;
        if (r100 != 1) goto L14;
        if (r101 == true) goto L15;
    L14:
        boolean r103 = false;
    L16:
        if (r100 == 0) goto L21;
        if (r100 != 1) goto L20;
        if (r102 == true) goto L21;
    L20:
        boolean r104 = false;
    L22:
        int r105 = r112 + r110;
        if (r103 == true) goto L25;
        int r106 = 0;
    L26:
        int r107 = r113 + r111;
        if (r104 == true) goto L29;
        int r108 = 0;
    L30:
        int r109 = -r106;
        int r117 = r106 + r114;
        int r118 = -r108;
        int r119 = r108 + r115;
        if (r105 <= r117) goto L34;
        r105 = r117;
    L33:
        boolean r120 = true;
    L37:
        if (r107 <= r119) goto L40;
        r107 = r119;
    L39:
        boolean r121 = true;
    L43:
        if (r121 == true) goto L45;
    L47:
        onOverScrolled(r105, r107, r120, r121);
        if (r120 == true) goto L50;
        if (r121 == true) goto L50;
        return false;
    L50:
        return true;
    L45:
        if (hasNestedScrollingParent(1) == true) goto L47;
        int r122 = r105;
        int r123 = r107;
        this.mScroller.springBack(r122, r123, 0, 0, 0, getScrollRange());
        goto L47
    L40:
        if (r107 >= r118) goto L42;
        r107 = r118;
        goto L39
    L42:
        r121 = false;
        goto L43
    L34:
        if (r105 >= r109) goto L36;
        r105 = r109;
        goto L33
    L36:
        r120 = false;
        goto L37
    L29:
        r108 = r210;
        goto L30
    L25:
        r106 = r116;
    L21:
        r104 = true;
    L15:
        r103 = true;
        goto L16
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
