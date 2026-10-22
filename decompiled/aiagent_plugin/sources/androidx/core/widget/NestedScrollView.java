package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.n;
import androidx.core.view.o;
import androidx.core.view.r;
import androidx.core.view.s;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements n, r {
    private static final a ACCESSIBILITY_DELEGATE = null;
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
    private final o mChildHelper;
    private View mChildToScrollTo;
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
    private c mOnScrollChangeListener;
    private final s mParentHelper;
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

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        SavedState(Parcel r1) {
            super(r1);
            this.scrollPosition = r1.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.scrollPosition);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(View r4, int r5, Bundle r6) {
            if (super.a(r4, r5, r6) == false) goto L5;
            return true;
        L5:
            NestedScrollView r3 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r4, NestedScrollView.class, "com.obric.aiagent.plugin");
            if (r3.isEnabled() == true) goto L8;
            return false;
        L8:
            int r7 = r3.getHeight();
            Rect r1 = new Rect();
            if (r3.getMatrix().isIdentity() == false) goto L14;
            if (r3.getGlobalVisibleRect(r1) == false) goto L14;
            r7 = r1.height();
        L14:
            if (r5 != 4096) goto L16;
        L27:
            int r8 = (r7 - r3.getPaddingBottom()) - r3.getPaddingTop();
            int r9 = Math.min(r3.getScrollY() + r8, r3.getScrollRange());
            if (r9 == r3.getScrollY()) goto L31;
            r3.smoothScrollTo(0, r9, true);
            return true;
        L31:
            return false;
        L16:
            if (r5 != 8192) goto L18;
        L22:
            int r10 = (r7 - r3.getPaddingBottom()) - r3.getPaddingTop();
            int r11 = Math.max(r3.getScrollY() - r10, 0);
            if (r11 == r3.getScrollY()) goto L26;
            r3.smoothScrollTo(0, r11, true);
            return true;
        L26:
            return false;
        L18:
            if (r5 == 16908344) goto L22;
            if (r5 == 16908346) goto L27;
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void a(View r2, androidx.core.view.accessibility.b r3) {
            super.a(r2, r3);
            NestedScrollView r1 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r2, NestedScrollView.class, "com.obric.aiagent.plugin");
            r3.b(ScrollView.class.getName());
            if (r1.isEnabled() == false) goto L13;
            int r4 = r1.getScrollRange();
            if (r4 <= 0) goto L14;
            r3.k(true);
            if (r1.getScrollY() <= 0) goto L10;
            r3.a(androidx.core.view.accessibility.b.a.n);
            r3.a(androidx.core.view.accessibility.b.a.y);
        L10:
            if (r1.getScrollY() >= r4) goto L15;
            r3.a(androidx.core.view.accessibility.b.a.m);
            r3.a(androidx.core.view.accessibility.b.a.A);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void d(View r2, AccessibilityEvent r3) {
            super.d(r2, r3);
            NestedScrollView r1 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r2, NestedScrollView.class, "com.obric.aiagent.plugin");
            r3.setClassName(ScrollView.class.getName());
            if (r1.getScrollRange() <= 0) goto L5;
            boolean r4 = true;
        L6:
            r3.setScrollable(r4);
            r3.setScrollX(r1.getScrollX());
            r3.setScrollY(r1.getScrollY());
            androidx.core.view.accessibility.c.a(r3, r1.getScrollX());
            androidx.core.view.accessibility.c.b(r3, r1.getScrollRange());
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    static class b {
        static boolean a(ViewGroup r0) {
            return r0.getClipToPadding();
        }
    }

    public interface c {
        void a(NestedScrollView r1, int r2, int r3, int r4, int r5);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private static int clamp(int r1, int r2, int r3) {
        if (r2 >= r3) goto L10;
        if (r1 >= 0) goto L6;
        return 0;
    L6:
        if ((r2 + r1) > r3) goto L8;
        return r1;
    L8:
        return r3 - r2;
    L10:
        return 0;
    }

    @Override // androidx.core.view.q
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    static {
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        ACCESSIBILITY_DELEGATE = new a();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public NestedScrollView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.nestedScrollViewStyle, "attr", "nestedScrollViewStyle"));
    }

    public NestedScrollView(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r9, r10, r8);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mEdgeGlowTop = androidx.core.widget.c.a(r9, r10);
        this.mEdgeGlowBottom = androidx.core.widget.c.a(r9, r10);
        this.mPhysicalCoeff = ((ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        initScrollView();
        TypedArray r11 = r9.obtainStyledAttributes(r10, SCROLLVIEW_STYLEABLE, r8, 0);
        setFillViewport(r11.getBoolean(0, false));
        r11.recycle();
        this.mParentHelper = new s(this);
        this.mChildHelper = new o(this);
        setNestedScrollingEnabled(true);
        ViewCompat.a(this, ACCESSIBILITY_DELEGATE);
    }

    public void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        this.mChildHelper.a(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean startNestedScroll(int r1, int r2) {
        return this.mChildHelper.a(r1, r2);
    }

    public void stopNestedScroll(int r1) {
        this.mChildHelper.c(r1);
    }

    public boolean hasNestedScrollingParent(int r1) {
        return this.mChildHelper.a(r1);
    }

    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.mChildHelper.a(r8, r9, r10, r11, r12, r13);
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.mChildHelper.a(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r1) {
        this.mChildHelper.a(r1);
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.mChildHelper.a(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return this.mChildHelper.a(r1, r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return this.mChildHelper.a(r1, r2);
    }

    @Override // androidx.core.view.r
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        onNestedScrollInternal(r5, r6, r7);
    }

    private void onNestedScrollInternal(int r11, int r12, int[] r13) {
        int r0 = getScrollY();
        scrollBy(0, r11);
        int r4 = getScrollY() - r0;
        if (r13 == null) goto L5;
        r13[1] = r13[1] + r4;
    L5:
        o r2 = this.mChildHelper;
        r2.a(0, r4, 0, r11 - r4, null, r12, r13);
    }

    @Override // androidx.core.view.q
    public void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        this.mParentHelper.a(r2, r3, r4, r5);
        startNestedScroll(2, r5);
    }

    @Override // androidx.core.view.q
    public void onStopNestedScroll(View r2, int r3) {
        this.mParentHelper.a(r2, r3);
        stopNestedScroll(r3);
    }

    @Override // androidx.core.view.q
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        onNestedScrollInternal(r5, r6, null);
    }

    @Override // androidx.core.view.q
    public void onNestedPreScroll(View r7, int r8, int r9, int[] r10, int r11) {
        dispatchNestedPreScroll(r8, r9, r10, null, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5) {
        onNestedScrollInternal(r5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        if (r4 == true) goto L5;
        dispatchNestedFling(0.0f, r3, true);
        fling((int) r3);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.a();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r0 = getVerticalFadingEdgeLength();
        int r1 = getScrollY();
        if (r1 < r0) goto L9;
        return 1.0f;
    L9:
        return r1 / r0;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r2 = getVerticalFadingEdgeLength();
        int r3 = ((r0.getBottom() + r1.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r3 < r2) goto L9;
        return 1.0f;
    L9:
        return r3 / r2;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * MAX_SCROLL_FACTOR);
    }

    private void initScrollView() {
        this.mScroller = new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r0 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mTouchSlop = r0.getScaledTouchSlop();
        this.mMinimumVelocity = r0.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r0.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(View r2) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r2, ViewGroup.LayoutParams r3) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(c r3) {
        this.mOnScrollChangeListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) goto L8;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (((r0.getHeight() + r2.topMargin) + r2.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public void setFillViewport(boolean r2) {
        if (r2 == this.mFillViewport) goto L6;
        this.mFillViewport = r2;
        requestLayout();
        return;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public void setSmoothScrollingEnabled(boolean r1) {
        this.mSmoothScrollingEnabled = r1;
    }

    @Override // android.view.View
    public void onScrollChanged(int r7, int r8, int r9, int r10) {
        super.onScrollChanged(r7, r8, r9, r10);
        c r0 = this.mOnScrollChangeListener;
        if (r0 == null) goto L6;
        r0.a(this, r7, r8, r9, r10);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r6) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r7 = getChildAt(0);
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = r7.getMeasuredHeight();
        int r2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r0.topMargin) - r0.bottomMargin;
        if (r1 >= r2) goto L15;
        r7.measure(getChildMeasureSpec(r5, ((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin, r0.width), View.MeasureSpec.makeMeasureSpec(r2, 1073741824));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (super.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r2) == true) goto L8;
        return false;
    }

    public boolean executeKeyEvent(KeyEvent r6) {
        this.mTempRect.setEmpty();
        boolean r0 = canScroll();
        int r2 = ApWakeEvent.ACCELERATING_START;
        if (r0 == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r6.getKeyCode() == 4) goto L53;
        View r7 = findFocus();
        if (r7 != this) goto L11;
        r7 = null;
    L11:
        View r8 = FocusFinder.getInstance().findNextFocus(this, r7, ApWakeEvent.ACCELERATING_START);
        if (r8 == null) goto L54;
        if (r8 != this) goto L15;
        return false;
    L15:
        if (r8.requestFocus(ApWakeEvent.ACCELERATING_START) == false) goto L56;
        return true;
    L56:
        return false;
    L54:
        return false;
    L53:
        return false;
    L19:
        if (r6.getAction() != 0) goto L57;
        int r1 = r6.getKeyCode();
        if (r1 == 19) goto L48;
        if (r1 == 20) goto L44;
        if (r1 == 62) goto L40;
        if (r1 == 92) goto L61;
        if (r1 == 93) goto L60;
        if (r1 != 122) goto L33;
        pageScroll(33);
        return false;
    L33:
        if (r1 != 123) goto L66;
        pageScroll(ApWakeEvent.ACCELERATING_START);
        return false;
    L66:
        return false;
    L60:
        return fullScroll(ApWakeEvent.ACCELERATING_START);
    L61:
        return fullScroll(33);
    L40:
        if (r6.isShiftPressed() == false) goto L42;
        r2 = 33;
    L42:
        pageScroll(r2);
        return false;
    L44:
        if (r6.isAltPressed() == false) goto L64;
        return fullScroll(ApWakeEvent.ACCELERATING_START);
    L64:
        return arrowScroll(ApWakeEvent.ACCELERATING_START);
    L48:
        if (r6.isAltPressed() == false) goto L51;
        return fullScroll(33);
    L51:
        return arrowScroll(33);
    L57:
        return false;
    }

    private boolean inChild(int r4, int r5) {
        if (getChildCount() <= 0) goto L14;
        int r0 = getScrollY();
        View r3 = getChildAt(0);
        if (r5 >= (r3.getTop() - r0)) goto L7;
        return false;
    L7:
        if (r5 < (r3.getBottom() - r0)) goto L9;
        return false;
    L9:
        if (r4 >= r3.getLeft()) goto L11;
        return false;
    L11:
        if (r4 >= r3.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void recycleVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        if (r1 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r12) {
        int r0 = r12.getAction();
        boolean r2 = true;
        if (r0 == 2) goto L5;
    L7:
        int r1 = r0 & 255;
        if (r1 != 0) goto L10;
        int r3 = (int) r12.getY();
        if (inChild((int) r12.getX(), r3) == false) goto L38;
        this.mLastMotionY = r3;
        this.mActivePointerId = r12.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        if (stopGlowAnimations(r12) == false) goto L47;
    L50:
        this.mIsBeingDragged = r2;
        startNestedScroll(2, 0);
    L52:
        return this.mIsBeingDragged;
    L47:
        if (this.mScroller.isFinished() == false) goto L50;
        r2 = false;
        goto L50
    L38:
        if (stopGlowAnimations(r12) == false) goto L40;
    L43:
        this.mIsBeingDragged = r2;
        recycleVelocityTracker();
        goto L52
    L40:
        if (this.mScroller.isFinished() == false) goto L43;
        r2 = false;
        goto L43
    L10:
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L13;
        int r4 = this.mActivePointerId;
        if (r4 == (-1)) goto L52;
        int r5 = r12.findPointerIndex(r4);
        if (r5 != (-1)) goto L24;
        INVOKESTATIC_androidx_core_widget_NestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Invalid pointerId=" + r4 + " in onInterceptTouchEvent");
        goto L52
    L24:
        int r6 = (int) r12.getY(r5);
        if (Math.abs(r6 - this.mLastMotionY) <= this.mTouchSlop) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r6;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r13 = getParent();
        if (r13 == null) goto L52;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L52
    L13:
        if (r1 == 3) goto L31;
        if (r1 != 6) goto L52;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.f(this);
    L34:
        stopNestedScroll(0);
        goto L52
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r13) {
        initVelocityTrackerIfNotExists();
        int r0 = r13.getActionMasked();
        if (r0 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r2 = MotionEvent.obtain(r13);
        r2.offsetLocation(0.0f, this.mNestedYOffset);
        if (r0 == 0) goto L56;
        if (r0 != 1) goto L9;
        VelocityTracker r14 = this.mVelocityTracker;
        r14.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r15 = (int) r14.getYVelocity(this.mActivePointerId);
        if (Math.abs(r15) < this.mMinimumVelocity) goto L52;
        if (edgeEffectFling(r15) == true) goto L54;
        int r16 = -r15;
        float r1 = r16;
        if (dispatchNestedPreFling(0.0f, r1) == true) goto L54;
        dispatchNestedFling(0.0f, r1, true);
        fling(r16);
    L54:
        endTouchDrag();
    L67:
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L70;
        r12.addMovement(r2);
    L70:
        r2.recycle();
        return true;
    L52:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L54;
        ViewCompat.f(this);
        goto L54
    L9:
        if (r0 != 2) goto L11;
        int r3 = r13.findPointerIndex(this.mActivePointerId);
        if (r3 != (-1)) goto L30;
        INVOKESTATIC_androidx_core_widget_NestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        goto L67
    L30:
        int r4 = (int) r13.getY(r3);
        int r5 = this.mLastMotionY - r4;
        int r6 = r5 - releaseVerticalGlow(r5, r13.getX(r3));
        if (this.mIsBeingDragged == true) goto L42;
        if (Math.abs(r6) <= this.mTouchSlop) goto L42;
        ViewParent r7 = getParent();
        if (r7 == null) goto L37;
        r7.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        if (r6 <= 0) goto L40;
        r6 = r6 - this.mTouchSlop;
        goto L42
    L40:
        r6 = r6 + this.mTouchSlop;
    L42:
        if (this.mIsBeingDragged == false) goto L67;
        int r17 = scrollBy(r6, (int) r13.getX(r3), 0, false);
        this.mLastMotionY = r4 - r17;
        this.mNestedYOffset += r17;
        goto L67
    L11:
        if (r0 == 3) goto L20;
        if (r0 != 5) goto L15;
        int r8 = r13.getActionIndex();
        this.mLastMotionY = (int) r13.getY(r8);
        this.mActivePointerId = r13.getPointerId(r8);
        goto L67
    L15:
        if (r0 != 6) goto L67;
        onSecondaryPointerUp(r13);
        this.mLastMotionY = (int) r13.getY(r13.findPointerIndex(this.mActivePointerId));
        goto L67
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L26:
        endTouchDrag();
        goto L67
    L22:
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
        ViewCompat.f(this);
        goto L26
    L56:
        if (getChildCount() != 0) goto L59;
        return false;
    L59:
        if (this.mIsBeingDragged == false) goto L64;
        ViewParent r9 = getParent();
        if (r9 == null) goto L64;
        r9.requestDisallowInterceptTouchEvent(true);
    L64:
        if (this.mScroller.isFinished() == true) goto L66;
        abortAnimatedScroll();
    L66:
        initializeTouchDrag((int) r13.getY(), r13.getPointerId(0));
        goto L67
    }

    private void initializeTouchDrag(int r1, int r2) {
        this.mLastMotionY = r1;
        this.mActivePointerId = r2;
        startNestedScroll(2, 0);
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private int scrollBy(int r22, int r23, int r24, boolean r25) {
        if (r24 != 1) goto L5;
        startNestedScroll(2, r24);
    L5:
        boolean r14 = false;
        if (dispatchNestedPreScroll(0, r22, this.mScrollConsumed, this.mScrollOffset, r24) == false) goto L8;
        int r15 = r22 - this.mScrollConsumed[1];
        int r16 = this.mScrollOffset[1] + 0;
    L9:
        int r17 = getScrollY();
        int r9 = getScrollRange();
        if (canOverScroll() == false) goto L13;
        if (r25 == true) goto L13;
        boolean r18 = true;
    L15:
        if (overScrollByCompat(0, r15, 0, r17, 0, r9, 0, 0, true) == true) goto L17;
    L19:
        boolean r8 = false;
    L20:
        int r2 = getScrollY() - r17;
        int[] r7 = this.mScrollConsumed;
        r7[1] = 0;
        dispatchNestedScroll(0, r2, 0, r15 - r2, this.mScrollOffset, r24, r7);
        int r19 = r16 + this.mScrollOffset[1];
        int r110 = r15 - this.mScrollConsumed[1];
        int r0 = r17 + r110;
        if (r0 >= 0) goto L27;
        if (r18 == false) goto L33;
        androidx.core.widget.c.b(this.mEdgeGlowTop, (-r110) / getHeight(), r23 / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L33;
        this.mEdgeGlowBottom.onRelease();
    L33:
        if (this.mEdgeGlowTop.isFinished() == true) goto L35;
    L38:
        ViewCompat.f(this);
    L39:
        if (r14 == false) goto L42;
        if (r24 != 0) goto L42;
        this.mVelocityTracker.clear();
    L42:
        if (r24 != 1) goto L44;
        stopNestedScroll(r24);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    L44:
        return r19;
    L35:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L38;
        r14 = r8;
        goto L39
    L27:
        if (r0 <= r9) goto L33;
        if (r18 == false) goto L33;
        androidx.core.widget.c.b(this.mEdgeGlowBottom, r110 / getHeight(), 1.0f - (r23 / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L33;
        this.mEdgeGlowTop.onRelease();
        goto L33
    L17:
        if (hasNestedScrollingParent(r24) == true) goto L19;
        r8 = true;
    L13:
        r18 = false;
        goto L15
    L8:
        r15 = r22;
        r16 = 0;
        goto L9
    }

    private boolean shouldAbsorb(EdgeEffect r3, int r4) {
        if (r4 <= 0) goto L6;
        return true;
    L6:
        if (getSplineFlingDistance(-r4) < (androidx.core.widget.c.a(r3) * getHeight())) goto L10;
        return false;
    L10:
        return true;
    }

    int consumeFlingInVerticalStretch(int r6) {
        int r0 = getHeight();
        if (r6 > 0) goto L5;
    L11:
        if (r6 < 0) goto L13;
        return r6;
    L13:
        if (androidx.core.widget.c.a(this.mEdgeGlowBottom) == 0.0f) goto L20;
        float r1 = r0;
        int r2 = Math.round((r1 / FLING_DESTRETCH_FACTOR) * androidx.core.widget.c.b(this.mEdgeGlowBottom, (r6 * FLING_DESTRETCH_FACTOR) / r1, MAX_SCROLL_FACTOR));
        if (r2 == r6) goto L18;
        this.mEdgeGlowBottom.finish();
    L18:
        return r6 - r2;
    L20:
        return r6;
    L5:
        if (androidx.core.widget.c.a(this.mEdgeGlowTop) == 0.0f) goto L11;
        int r3 = Math.round(((-r0) / FLING_DESTRETCH_FACTOR) * androidx.core.widget.c.b(this.mEdgeGlowTop, ((-r6) * FLING_DESTRETCH_FACTOR) / r0, MAX_SCROLL_FACTOR));
        if (r3 == r6) goto L10;
        this.mEdgeGlowTop.finish();
    L10:
        return r6 - r3;
    }

    private float getSplineFlingDistance(int r9) {
        double r2 = Math.log((Math.abs(r9) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float r10 = DECELERATION_RATE;
        return (float) ((this.mPhysicalCoeff * SCROLL_FRICTION) * Math.exp((r10 / (((double) r10) - 1.0d)) * r2));
    }

    private boolean edgeEffectFling(int r3) {
        if (androidx.core.widget.c.a(this.mEdgeGlowTop) == 0.0f) goto L9;
        if (shouldAbsorb(this.mEdgeGlowTop, r3) == false) goto L7;
        this.mEdgeGlowTop.onAbsorb(r3);
    L14:
        return true;
    L7:
        fling(-r3);
        goto L14
    L9:
        if (androidx.core.widget.c.a(this.mEdgeGlowBottom) == 0.0f) goto L15;
        int r4 = -r3;
        if (shouldAbsorb(this.mEdgeGlowBottom, r4) == false) goto L13;
        this.mEdgeGlowBottom.onAbsorb(r4);
        goto L14
    L13:
        fling(r4);
        goto L14
    L15:
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent r6) {
        if (androidx.core.widget.c.a(this.mEdgeGlowTop) == 0.0f) goto L5;
        androidx.core.widget.c.b(this.mEdgeGlowTop, 0.0f, r6.getX() / getWidth());
        boolean r0 = true;
    L7:
        if (androidx.core.widget.c.a(this.mEdgeGlowBottom) == 0.0f) goto L10;
        androidx.core.widget.c.b(this.mEdgeGlowBottom, 0.0f, 1.0f - (r6.getX() / getWidth()));
        return true;
    L10:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionY = (int) r4.getY(r1);
        this.mActivePointerId = r4.getPointerId(r1);
        VelocityTracker r3 = this.mVelocityTracker;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r7) {
        if (r7.getAction() == 8) goto L5;
        return false;
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return false;
    L7:
        if (androidx.core.view.k.a(r7, 2) == false) goto L10;
        float r0 = r7.getAxisValue(9);
        int r2 = (int) r7.getX();
    L14:
        if (r0 == 0.0f) goto L19;
        scrollBy(-((int) (r0 * getVerticalScrollFactorCompat())), r2, 1, androidx.core.view.k.a(r7, 8194));
        return true;
    L19:
        return false;
    L10:
        if (androidx.core.view.k.a(r7, UiType.FLAG_NO_FEEDBACK) == false) goto L12;
        float r3 = r7.getAxisValue(26);
        r2 = getWidth() / 2;
        r0 = r3;
        goto L14
    L12:
        r2 = 0;
        r0 = 0.0f;
        goto L14
    }

    private boolean canOverScroll() {
        int r0 = getOverScrollMode();
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L6;
    L8:
        return false;
    L6:
        if (getScrollRange() <= 0) goto L8;
        return true;
    L10:
        return true;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r0 = new TypedValue();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r1.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r0, true) == false) goto L8;
        this.mVerticalScrollFactor = r0.getDimension(ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    @Override // android.view.View
    public void onOverScrolled(int r1, int r2, boolean r3, boolean r4) {
        super.scrollTo(r1, r2);
    }

    boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r1 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r2 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r3 = true;
    L10:
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        if (r2 == true) goto L15;
    L14:
        boolean r4 = false;
    L16:
        if (r1 == 0) goto L21;
        if (r1 != 1) goto L20;
        if (r3 == true) goto L21;
    L20:
        boolean r5 = false;
    L22:
        int r6 = r15 + r13;
        if (r4 == true) goto L25;
        int r7 = 0;
    L26:
        int r8 = r16 + r14;
        if (r5 == true) goto L29;
        int r9 = 0;
    L30:
        int r10 = -r7;
        int r11 = r7 + r17;
        int r12 = -r9;
        int r22 = r9 + r18;
        if (r6 <= r11) goto L33;
        r6 = r11;
        boolean r23 = true;
    L36:
        if (r8 <= r22) goto L38;
        r8 = r22;
        boolean r24 = true;
    L41:
        if (r24 == true) goto L43;
    L45:
        onOverScrolled(r6, r8, r23, r24);
        if (r23 == true) goto L49;
        if (r24 == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (hasNestedScrollingParent(1) == true) goto L45;
        this.mScroller.springBack(r6, r8, 0, 0, 0, getScrollRange());
        goto L45
    L38:
        if (r8 >= r12) goto L40;
        r24 = true;
        r8 = r12;
        goto L41
    L40:
        r24 = false;
        goto L41
    L33:
        if (r6 >= r10) goto L35;
        r23 = true;
        r6 = r10;
        goto L36
    L35:
        r23 = false;
        goto L36
    L29:
        r9 = r20;
        goto L30
    L25:
        r7 = r19;
    L21:
        r5 = true;
    L15:
        r4 = true;
        goto L16
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        return Math.max(0, ((r0.getHeight() + r2.topMargin) + r2.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    private View findFocusableViewInBounds(boolean r12, int r13, int r14) {
        ArrayList r11 = getFocusables(2);
        int r0 = r11.size();
        View r2 = null;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r0) goto L30;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r11.get(r3), View.class, "com.obric.aiagent.plugin");
        int r6 = r5.getTop();
        int r7 = r5.getBottom();
        if (r13 >= r7) goto L29;
        if (r6 >= r14) goto L29;
        if (r13 >= r6) goto L10;
        if (r7 >= r14) goto L10;
        boolean r9 = true;
    L11:
        if (r2 != null) goto L13;
        r2 = r5;
        r4 = r9;
        goto L29
    L13:
        if (r12 == true) goto L15;
    L16:
        if (r12 == false) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r4 == false) goto L25;
        if (r9 == false) goto L29;
        if (r8 == false) goto L29;
    L28:
        r2 = r5;
        goto L29
    L25:
        if (r9 == false) goto L27;
        r2 = r5;
        r4 = true;
        goto L29
    L27:
        if (r8 == false) goto L29;
    L18:
        if (r7 <= r2.getBottom()) goto L20;
    L19:
        r8 = true;
        goto L21
    L15:
        if (r6 < r2.getTop()) goto L19;
    L10:
        r9 = false;
    L29:
        r3 = r3 + 1;
        goto L3
    L30:
        return r2;
    }

    public boolean pageScroll(int r6) {
        if (r6 != 130) goto L5;
        boolean r2 = true;
    L6:
        int r3 = getHeight();
        if (r2 == false) goto L13;
        this.mTempRect.top = getScrollY() + r3;
        int r1 = getChildCount();
        if (r1 <= 0) goto L16;
        View r0 = getChildAt(r1 - 1);
        int r4 = (r0.getBottom() + ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin) + getPaddingBottom();
        if ((this.mTempRect.top + r3) <= r4) goto L16;
        this.mTempRect.top = r4 - r3;
    L16:
        Rect r5 = this.mTempRect;
        r5.bottom = r5.top + r3;
        return scrollAndFocus(r6, this.mTempRect.top, this.mTempRect.bottom);
    L13:
        this.mTempRect.top = getScrollY() - r3;
        if (this.mTempRect.top >= 0) goto L16;
        this.mTempRect.top = 0;
        goto L16
    L5:
        r2 = false;
        goto L6
    }

    public boolean fullScroll(int r6) {
        if (r6 != 130) goto L5;
        boolean r2 = true;
    L6:
        int r3 = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = r3;
        if (r2 == false) goto L12;
        int r1 = getChildCount();
        if (r1 <= 0) goto L12;
        View r0 = getChildAt(r1 - 1);
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        this.mTempRect.bottom = (r0.getBottom() + r4.bottomMargin) + getPaddingBottom();
        Rect r5 = this.mTempRect;
        r5.top = r5.bottom - r3;
    L12:
        return scrollAndFocus(r6, this.mTempRect.top, this.mTempRect.bottom);
    L5:
        r2 = false;
        goto L6
    }

    private boolean scrollAndFocus(int r7, int r8, int r9) {
        int r0 = getHeight();
        int r1 = getScrollY();
        int r2 = r0 + r1;
        boolean r3 = false;
        if (r7 != 33) goto L5;
        boolean r4 = true;
    L6:
        View r5 = findFocusableViewInBounds(r4, r8, r9);
        if (r5 != null) goto L9;
        r5 = this;
    L9:
        if (r8 < r1) goto L12;
        if (r9 > r2) goto L12;
    L17:
        if (r5 == findFocus()) goto L19;
        r5.requestFocus(r7);
    L19:
        return r3;
    L12:
        if (r4 == false) goto L14;
        int r10 = r8 - r1;
    L15:
        scrollBy(r10, 0, 1, true);
        r3 = true;
        goto L17
    L14:
        r10 = r9 - r2;
        goto L15
    L5:
        r4 = false;
        goto L6
    }

    public boolean arrowScroll(int r10) {
        View r0 = findFocus();
        if (r0 != this) goto L5;
        r0 = null;
    L5:
        View r1 = FocusFinder.getInstance().findNextFocus(this, r0, r10);
        int r2 = getMaxScrollAmount();
        if (r1 == null) goto L11;
        if (isWithinDeltaOfScreen(r1, r2, getHeight()) == false) goto L11;
        r1.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r1, this.mTempRect);
        scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
        r1.requestFocus(r10);
    L25:
        if (r0 != null) goto L27;
    L31:
        return true;
    L27:
        if (r0.isFocused() == false) goto L31;
        if (isOffScreen(r0) == false) goto L31;
        int r11 = getDescendantFocusability();
        setDescendantFocusability(UiType.FLAG_PHONE_CARD);
        requestFocus();
        setDescendantFocusability(r11);
    L11:
        if (r10 == 33) goto L13;
    L15:
        if (r10 == 130) goto L17;
    L19:
        if (r2 != 0) goto L21;
        return false;
    L21:
        if (r10 == 130) goto L24;
        r2 = -r2;
    L24:
        scrollBy(r2, 0, 1, true);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r3 = getChildAt(0);
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2 = Math.min((r3.getBottom() + r6.bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), r2);
        goto L19
    L13:
        if (getScrollY() >= r2) goto L15;
        r2 = getScrollY();
        goto L19
    }

    private boolean isOffScreen(View r3) {
        return !isWithinDeltaOfScreen(r3, 0, getHeight());
    }

    private boolean isWithinDeltaOfScreen(View r2, int r3, int r4) {
        r2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r2, this.mTempRect);
        if ((this.mTempRect.bottom + r3) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r3) > (getScrollY() + r4)) goto L7;
        return true;
    }

    private void doScrollY(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r3);
        return;
    L6:
        scrollBy(0, r3);
    }

    public final void smoothScrollBy(int r3, int r4) {
        smoothScrollBy(r3, r4, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollBy(int r2, int r3, int r4) {
        smoothScrollBy(r2, r3, r4, false);
    }

    private void smoothScrollBy(int r9, int r10, int r11, boolean r12) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r2 = (r0.getHeight() + r1.topMargin) + r1.bottomMargin;
        int r3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r4 = getScrollY();
        int r13 = r10 + r4;
        int r6 = Math.max(0, Math.min(r13, Math.max(0, r2 - r3))) - r4;
        this.mScroller.startScroll(getScrollX(), r4, 0, r6, r11);
        runAnimatedScroll(r12);
    L12:
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        return;
    L9:
        if (this.mScroller.isFinished() == true) goto L11;
        abortAnimatedScroll();
    L11:
        scrollBy(r9, r10);
        goto L12
    }

    public final void smoothScrollTo(int r3, int r4) {
        smoothScrollTo(r3, r4, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int r2, int r3, int r4) {
        smoothScrollTo(r2, r3, r4, false);
    }

    void smoothScrollTo(int r2, int r3, boolean r4) {
        smoothScrollTo(r2, r3, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, r4);
    }

    void smoothScrollTo(int r2, int r3, int r4, boolean r5) {
        smoothScrollBy(r2 - getScrollX(), r3 - getScrollY(), r4, r5);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int r0 = getChildCount();
        int r1 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r0 != 0) goto L5;
        return r1;
    L5:
        View r2 = getChildAt(0);
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getBottom() + r3.bottomMargin;
        int r6 = getScrollY();
        int r5 = Math.max(0, r4 - r1);
        if (r6 < 0) goto L11;
        if (r6 > r5) goto L10;
        return r4;
    L10:
        return r4 + (r6 - r5);
    L11:
        return r4 - r6;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    public void measureChild(View r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        r2.measure(getChildMeasureSpec(r3, getPaddingLeft() + getPaddingRight(), r5.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View r2, int r3, int r4, int r5, int r6) {
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.measure(getChildMeasureSpec(r3, (((getPaddingLeft() + getPaddingRight()) + r7.leftMargin) + r7.rightMargin) + r4, r7.width), View.MeasureSpec.makeMeasureSpec(r7.topMargin + r7.bottomMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r0 = this.mScroller.getCurrY();
        int r6 = consumeFlingInVerticalStretch(r0 - this.mLastScrollerY);
        this.mLastScrollerY = r0;
        int[] r3 = this.mScrollConsumed;
        boolean r12 = false;
        r3[1] = 0;
        dispatchNestedPreScroll(0, r6, r3, null, 1);
        int r13 = r6 - this.mScrollConsumed[1];
        int r14 = getScrollRange();
        if (r13 == 0) goto L8;
        int r15 = getScrollY();
        overScrollByCompat(0, r13, getScrollX(), r15, 0, r14, 0, 0, false);
        int r2 = getScrollY() - r15;
        int r16 = r13 - r2;
        int[] r7 = this.mScrollConsumed;
        r7[1] = 0;
        dispatchNestedScroll(0, r2, 0, r16, this.mScrollOffset, 1, r7);
        r13 = r16 - this.mScrollConsumed[1];
    L8:
        if (r13 == 0) goto L24;
        int r1 = getOverScrollMode();
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L14;
        if (r14 > 0) goto L13;
    L14:
        if (r12 == false) goto L22;
        if (r13 >= 0) goto L20;
        if (this.mEdgeGlowTop.isFinished() == false) goto L22;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L22
    L20:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L22;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L22:
        abortAnimatedScroll();
    L13:
        r12 = true;
    L24:
        if (this.mScroller.isFinished() == true) goto L26;
        ViewCompat.f(this);
        return;
    L26:
        stopNestedScroll(1);
    }

    private int releaseVerticalGlow(int r4, float r5) {
        float r6 = r5 / getWidth();
        float r7 = r4 / getHeight();
        float r1 = 0.0f;
        if (androidx.core.widget.c.a(this.mEdgeGlowTop) == 0.0f) goto L9;
        float r8 = -androidx.core.widget.c.b(this.mEdgeGlowTop, -r7, r6);
        if (androidx.core.widget.c.a(this.mEdgeGlowTop) != 0.0f) goto L7;
        this.mEdgeGlowTop.onRelease();
    L7:
        r1 = r8;
    L13:
        int r9 = Math.round(r1 * getHeight());
        if (r9 == 0) goto L16;
        invalidate();
    L16:
        return r9;
    L9:
        if (androidx.core.widget.c.a(this.mEdgeGlowBottom) == 0.0f) goto L13;
        r8 = androidx.core.widget.c.b(this.mEdgeGlowBottom, r7, 1.0f - r6);
        if (androidx.core.widget.c.a(this.mEdgeGlowBottom) != 0.0f) goto L7;
        this.mEdgeGlowBottom.onRelease();
        goto L7
    }

    private void runAnimatedScroll(boolean r2) {
        if (r2 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.f(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private void scrollToChild(View r2) {
        r2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r2, this.mTempRect);
        int r3 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r3 == 0) goto L6;
        scrollBy(0, r3);
        return;
    }

    private boolean scrollToChildRect(Rect r3, boolean r4) {
        int r5 = computeScrollDeltaToGetChildRectOnScreen(r3);
        if (r5 == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r4 == false) goto L9;
        scrollBy(0, r5);
        goto L10
    L9:
        smoothScrollBy(0, r5);
    L10:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r0 = getHeight();
        int r2 = getScrollY();
        int r3 = r2 + r0;
        int r4 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r2 = r2 + r4;
    L8:
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r11.bottom >= ((r5.getHeight() + r6.topMargin) + r6.bottomMargin)) goto L11;
        int r7 = r3 - r4;
    L13:
        if (r11.bottom <= r7) goto L22;
        if (r11.top <= r2) goto L22;
        if (r11.height() <= r0) goto L19;
        int r10 = r11.top - r2;
    L31:
        return Math.min(r10 + 0, (r5.getBottom() + r6.bottomMargin) - r3);
    L19:
        r10 = r11.bottom - r7;
    L22:
        if (r11.top < r2) goto L24;
        return 0;
    L24:
        if (r11.bottom < r7) goto L26;
        return 0;
    L26:
        if (r11.height() <= r0) goto L28;
        int r1 = 0 - (r7 - r11.bottom);
    L30:
        return Math.max(r1, -getScrollY());
    L28:
        r1 = 0 - (r2 - r11.top);
        goto L30
    L11:
        r7 = r3;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r2, View r3) {
        if (this.mIsLayoutDirty == true) goto L5;
        scrollToChild(r3);
    L6:
        super.requestChildFocus(r2, r3);
        return;
    L5:
        this.mChildToScrollTo = r3;
        goto L6
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r3, Rect r4) {
        if (r3 != 2) goto L6;
        r3 = ApWakeEvent.ACCELERATING_START;
    L8:
        if (r4 != null) goto L10;
        View r0 = FocusFinder.getInstance().findNextFocus(this, null, r3);
    L12:
        if (r0 != null) goto L15;
        return false;
    L15:
        if (isOffScreen(r0) == false) goto L18;
        return false;
    L18:
        return r0.requestFocus(r3, r4);
    L10:
        r0 = FocusFinder.getInstance().findNextFocusFromRect(this, r4, r3);
        goto L12
    L6:
        if (r3 != 1) goto L8;
        r3 = 33;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r3, Rect r4, boolean r5) {
        r4.offset(r3.getLeft() - r3.getScrollX(), r3.getTop() - r3.getScrollY());
        return scrollToChildRect(r4, r5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = 0;
        this.mIsLayoutDirty = false;
        View r8 = this.mChildToScrollTo;
        if (r8 != null) goto L5;
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
        View r9 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r7 = (r9.getMeasuredHeight() + r10.topMargin) + r10.bottomMargin;
    L15:
        int r11 = ((r6 - r4) - getPaddingTop()) - getPaddingBottom();
        int r12 = getScrollY();
        int r13 = clamp(r12, r11, r7);
        if (r13 == r12) goto L18;
        scrollTo(getScrollX(), r13);
        goto L18
    L5:
        if (isViewDescendantOf(r8, this) == false) goto L7;
        scrollToChild(this.mChildToScrollTo);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        View r5 = findFocus();
        if (r5 == null) goto L10;
        if (this != r5) goto L7;
        return;
    L7:
        if (isWithinDeltaOfScreen(r5, 0, r4) == false) goto L11;
        r5.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r5, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    private static boolean isViewDescendantOf(View r3, View r4) {
        if (r3 != r4) goto L5;
        return true;
    L5:
        ViewParent r5 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (isViewDescendantOf((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), r4) == false) goto L10;
        return true;
    }

    public void fling(int r13) {
        if (getChildCount() <= 0) goto L6;
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
        return;
    }

    @Override // android.view.View
    public void scrollTo(int r7, int r8) {
        if (getChildCount() <= 0) goto L10;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r3 = (r0.getWidth() + r1.leftMargin) + r1.rightMargin;
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = (r0.getHeight() + r1.topMargin) + r1.bottomMargin;
        int r9 = clamp(r7, r2, r3);
        int r10 = clamp(r8, r4, r5);
        if (r9 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r9, r10);
        return;
    L7:
        if (r10 != getScrollY()) goto L8;
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        super.draw(r11);
        int r0 = getScrollY();
        int r2 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L21;
        int r1 = r11.save();
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = Math.min(0, r0);
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L10:
        r4 = r4 - (getPaddingLeft() + getPaddingRight());
        int r7 = getPaddingLeft() + 0;
    L12:
        if (Build.VERSION.SDK_INT >= 21) goto L14;
    L16:
        r11.translate(r7, r6);
        this.mEdgeGlowTop.setSize(r4, r5);
        if (this.mEdgeGlowTop.draw(r11) == false) goto L19;
        ViewCompat.f(this);
    L19:
        r11.restoreToCount(r1);
        goto L21
    L14:
        if (b.a(this) == false) goto L16;
        r5 = r5 - (getPaddingTop() + getPaddingBottom());
        r6 = r6 + getPaddingTop();
        goto L16
    L7:
        if (b.a(this) == true) goto L10;
        r7 = 0;
    L21:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L37;
        int r3 = r11.save();
        int r8 = getWidth();
        int r9 = getHeight();
        int r10 = Math.max(getScrollRange(), r0) + r9;
        if (Build.VERSION.SDK_INT >= 21) goto L25;
    L26:
        r8 = r8 - (getPaddingLeft() + getPaddingRight());
        r2 = 0 + getPaddingLeft();
    L28:
        if (Build.VERSION.SDK_INT >= 21) goto L30;
    L32:
        r11.translate(r2 - r8, r10);
        r11.rotate(180.0f, r8, 0.0f);
        this.mEdgeGlowBottom.setSize(r8, r9);
        if (this.mEdgeGlowBottom.draw(r11) == false) goto L35;
        ViewCompat.f(this);
    L35:
        r11.restoreToCount(r3);
        return;
    L30:
        if (b.a(this) == false) goto L32;
        r9 = r9 - (getPaddingTop() + getPaddingBottom());
        r10 = r10 - getPaddingBottom();
        goto L32
    L25:
        if (b.a(this) == false) goto L28;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.mSavedState = r5;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.scrollPosition = getScrollY();
        return r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_core_widget_NestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
