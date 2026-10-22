package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
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
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.R$attr;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.ArrayList;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
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
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowBottom;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
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
    private final androidx.core.view.i mParentHelper;
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

    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView r10, int r11, int r12, int r13, int r14);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.scrollPosition);
        }

        public SavedState(Parcel r10) {
            super(r10);
            this.scrollPosition = r10.readInt();
        }
    }

    public static class a extends androidx.core.view.a {
        public a() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            NestedScrollView r12 = (NestedScrollView) r10;
            r11.setClassName(ScrollView.class.getName());
            if (r12.getScrollRange() <= 0) goto L5;
            boolean r13 = true;
        L6:
            r11.setScrollable(r13);
            r11.setScrollX(r12.getScrollX());
            r11.setScrollY(r12.getScrollY());
            r.c.a(r11, r12.getScrollX());
            r.c.b(r11, r12.getScrollRange());
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            NestedScrollView r12 = (NestedScrollView) r10;
            r11.V(ScrollView.class.getName());
            if (r12.isEnabled() == false) goto L13;
            int r13 = r12.getScrollRange();
            if (r13 <= 0) goto L14;
            r11.r0(true);
            if (r12.getScrollY() <= 0) goto L10;
            r11.b(AccessibilityNodeInfoCompat.a.f2751r);
            r11.b(AccessibilityNodeInfoCompat.a.C);
        L10:
            if (r12.getScrollY() >= r13) goto L15;
            r11.b(AccessibilityNodeInfoCompat.a.f2750q);
            r11.b(AccessibilityNodeInfoCompat.a.E);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L5;
            return true;
        L5:
            NestedScrollView r13 = (NestedScrollView) r10;
            if (r13.isEnabled() == true) goto L8;
            return false;
        L8:
            int r14 = r13.getHeight();
            Rect r15 = new Rect();
            if (r13.getMatrix().isIdentity() == false) goto L14;
            if (r13.getGlobalVisibleRect(r15) == false) goto L14;
            r14 = r15.height();
        L14:
            if (r11 != 4096) goto L16;
        L27:
            int r16 = (r14 - r13.getPaddingBottom()) - r13.getPaddingTop();
            int r17 = Math.min(r13.getScrollY() + r16, r13.getScrollRange());
            if (r17 == r13.getScrollY()) goto L31;
            r13.smoothScrollTo(0, r17, true);
            return true;
        L31:
            return false;
        L16:
            if (r11 != 8192) goto L18;
        L22:
            int r18 = (r14 - r13.getPaddingBottom()) - r13.getPaddingTop();
            int r19 = Math.max(r13.getScrollY() - r18, 0);
            if (r19 == r13.getScrollY()) goto L26;
            r13.smoothScrollTo(0, r19, true);
            return true;
        L26:
            return false;
        L18:
            if (r11 == 16908344) goto L22;
            if (r11 == 16908346) goto L27;
            return false;
        }
    }

    public static class b {
        @DoNotInline
        public static boolean a(ViewGroup r10) {
            return r10.getClipToPadding();
        }
    }

    static {
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        ACCESSIBILITY_DELEGATE = new a();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(@NonNull Context r10) {
        this(r10, null);
    }

    private static int d(int r10, int r11, int r12) {
        if (r11 >= r12) goto L10;
        if (r10 >= 0) goto L6;
        return 0;
    L6:
        if ((r11 + r10) > r12) goto L8;
        return r10;
    L8:
        return r12 - r11;
    L10:
        return 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r10 = new TypedValue();
        Context r11 = getContext();
        if (r11.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r10, true) == false) goto L8;
        this.mVerticalScrollFactor = r10.getDimension(r11.getResources().getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    private void m() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    public static boolean o(View r10, View r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        Object r12 = r10.getParent();
        if ((r12 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (o((View) r12, r11) == false) goto L10;
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mActivePointerId) goto L11;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mLastMotionY = (int) r10.getY(r12);
        this.mActivePointerId = r10.getPointerId(r12);
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 == null) goto L12;
        r13.clear();
        return;
    L12:
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private void r() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    public final void a() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r10) {
        View r11 = findFocus();
        if (r11 != this) goto L5;
        r11 = null;
    L5:
        View r12 = FocusFinder.getInstance().findNextFocus(this, r11, r10);
        int r13 = getMaxScrollAmount();
        if (r12 == null) goto L11;
        if (p(r12, r13, getHeight()) == false) goto L11;
        r12.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r12, this.mTempRect);
        e(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        r12.requestFocus(r10);
    L25:
        if (r11 != null) goto L27;
        return true;
    L27:
        if (r11.isFocused() == true) goto L29;
        return true;
    L29:
        if (n(r11) == false) goto L35;
        int r14 = getDescendantFocusability();
        setDescendantFocusability(UiType.FLAG_PHONE_CARD);
        requestFocus();
        setDescendantFocusability(r14);
        return true;
    L35:
        return true;
    L11:
        if (r10 == 33) goto L13;
    L15:
        if (r10 == 130) goto L17;
    L19:
        if (r13 != 0) goto L21;
        return false;
    L21:
        if (r10 == 130) goto L24;
        r13 = -r13;
    L24:
        e(r13);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r15 = getChildAt(0);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        r13 = Math.min((r15.getBottom() + r16.bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), r13);
        goto L19
    L13:
        if (getScrollY() >= r13) goto L15;
        r13 = getScrollY();
        goto L19
    }

    public final boolean b() {
        int r10 = getOverScrollMode();
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L6;
    L8:
        return false;
    L6:
        if (getScrollRange() <= 0) goto L8;
        return true;
    L10:
        return true;
    }

    public final boolean c() {
        if (getChildCount() <= 0) goto L8;
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        if (((r10.getHeight() + r11.topMargin) + r11.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r10 = this.mScroller.getCurrY();
        int r11 = consumeFlingInVerticalStretch(r10 - this.mLastScrollerY);
        this.mLastScrollerY = r10;
        int[] r12 = this.mScrollConsumed;
        r12[1] = 0;
        dispatchNestedPreScroll(0, r11, r12, null, 1);
        int r13 = r11 - this.mScrollConsumed[1];
        int r14 = getScrollRange();
        if (r13 == 0) goto L8;
        int r15 = getScrollY();
        overScrollByCompat(0, r13, getScrollX(), r15, 0, r14, 0, 0, false);
        int r16 = getScrollY() - r15;
        int r17 = r13 - r16;
        int[] r18 = this.mScrollConsumed;
        r18[1] = 0;
        dispatchNestedScroll(0, r16, 0, r17, this.mScrollOffset, 1, r18);
        r13 = r17 - this.mScrollConsumed[1];
    L8:
        if (r13 == 0) goto L22;
        int r19 = getOverScrollMode();
        if (r19 == 0) goto L13;
        if (r19 != 1) goto L20;
        if (r14 > 0) goto L13;
    L20:
        a();
    L13:
        if (r13 >= 0) goto L18;
        if (this.mEdgeGlowTop.isFinished() == false) goto L20;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L20
    L18:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L20;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L22:
        if (this.mScroller.isFinished() == true) goto L24;
        ViewCompat.g0(this);
        return;
    L24:
        stopNestedScroll(1);
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r10 = getHeight();
        int r12 = getScrollY();
        int r13 = r12 + r10;
        int r14 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r12 = r12 + r14;
    L8:
        View r15 = getChildAt(0);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        if (r11.bottom >= ((r15.getHeight() + r16.topMargin) + r16.bottomMargin)) goto L11;
        int r17 = r13 - r14;
    L12:
        int r18 = r11.bottom;
        if (r18 <= r17) goto L22;
        if (r11.top <= r12) goto L22;
        if (r11.height() <= r10) goto L19;
        int r19 = r11.top - r12;
    L30:
        return Math.min(r19, (r15.getBottom() + r16.bottomMargin) - r13);
    L19:
        r19 = r11.bottom - r17;
    L22:
        if (r11.top >= r12) goto L31;
        if (r18 < r17) goto L25;
        return 0;
    L25:
        if (r11.height() <= r10) goto L27;
        int r20 = 0 - (r17 - r11.bottom);
    L29:
        return Math.max(r20, -getScrollY());
    L27:
        r20 = 0 - (r12 - r11.top);
        goto L29
    L31:
        return 0;
    L11:
        r17 = r13;
        goto L12
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int r10 = getChildCount();
        int r11 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r10 != 0) goto L5;
        return r11;
    L5:
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getBottom() + r13.bottomMargin;
        int r15 = getScrollY();
        int r16 = Math.max(0, r14 - r11);
        if (r15 < 0) goto L11;
        if (r15 > r16) goto L10;
        return r14;
    L10:
        return r14 + (r15 - r16);
    L11:
        return r14 - r15;
    }

    public int consumeFlingInVerticalStretch(int r10) {
        int r11 = getHeight();
        if (r10 > 0) goto L5;
    L11:
        if (r10 < 0) goto L13;
        return r10;
    L13:
        if (f.b(this.mEdgeGlowBottom) == 0.0f) goto L20;
        float r12 = r11;
        int r13 = Math.round((r12 / FLING_DESTRETCH_FACTOR) * f.d(this.mEdgeGlowBottom, (r10 * FLING_DESTRETCH_FACTOR) / r12, MAX_SCROLL_FACTOR));
        if (r13 == r10) goto L18;
        this.mEdgeGlowBottom.finish();
    L18:
        return r10 - r13;
    L20:
        return r10;
    L5:
        if (f.b(this.mEdgeGlowTop) == 0.0f) goto L11;
        int r14 = Math.round(((-r11) / FLING_DESTRETCH_FACTOR) * f.d(this.mEdgeGlowTop, ((-r10) * FLING_DESTRETCH_FACTOR) / r11, MAX_SCROLL_FACTOR));
        if (r14 == r10) goto L10;
        this.mEdgeGlowTop.finish();
    L10:
        return r10 - r14;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r10) {
        if (super.dispatchKeyEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return this.mChildHelper.a(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return this.mChildHelper.b(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13, int r14) {
        return this.mChildHelper.d(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15, @NonNull int[] r16) {
        this.mChildHelper.e(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        int r11 = getScrollY();
        int r12 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L16;
        int r13 = r10.save();
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = Math.min(0, r11);
        if (b.a(this) == false) goto L7;
        r14 = r14 - (getPaddingLeft() + getPaddingRight());
        int r17 = getPaddingLeft();
    L9:
        if (b.a(this) == false) goto L11;
        r15 = r15 - (getPaddingTop() + getPaddingBottom());
        r16 = r16 + getPaddingTop();
    L11:
        r10.translate(r17, r16);
        this.mEdgeGlowTop.setSize(r14, r15);
        if (this.mEdgeGlowTop.draw(r10) == false) goto L14;
        ViewCompat.g0(this);
    L14:
        r10.restoreToCount(r13);
        goto L16
    L7:
        r17 = 0;
    L16:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L28;
        int r18 = r10.save();
        int r19 = getWidth();
        int r20 = getHeight();
        int r21 = Math.max(getScrollRange(), r11) + r20;
        if (b.a(this) == false) goto L21;
        r19 = r19 - (getPaddingLeft() + getPaddingRight());
        r12 = getPaddingLeft();
    L21:
        if (b.a(this) == false) goto L23;
        r20 = r20 - (getPaddingTop() + getPaddingBottom());
        r21 = r21 - getPaddingBottom();
    L23:
        r10.translate(r12 - r19, r21);
        r10.rotate(180.0f, r19, 0.0f);
        this.mEdgeGlowBottom.setSize(r19, r20);
        if (this.mEdgeGlowBottom.draw(r10) == false) goto L26;
        ViewCompat.g0(this);
    L26:
        r10.restoreToCount(r18);
        return;
    }

    public final void e(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r10);
        return;
    L6:
        scrollBy(0, r10);
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r10) {
        this.mTempRect.setEmpty();
        int r11 = 130;
        if (c() == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r10.getKeyCode() == 4) goto L41;
        View r12 = findFocus();
        if (r12 != this) goto L11;
        r12 = null;
    L11:
        View r13 = FocusFinder.getInstance().findNextFocus(this, r12, 130);
        if (r13 == null) goto L42;
        if (r13 != this) goto L15;
        return false;
    L15:
        if (r13.requestFocus(130) == false) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L41:
        return false;
    L19:
        if (r10.getAction() != 0) goto L45;
        int r14 = r10.getKeyCode();
        if (r14 == 19) goto L36;
        if (r14 == 20) goto L32;
        if (r14 == 62) goto L28;
        return false;
    L28:
        if (r10.isShiftPressed() == false) goto L30;
        r11 = 33;
    L30:
        pageScroll(r11);
        return false;
    L32:
        if (r10.isAltPressed() == true) goto L48;
        return arrowScroll(130);
    L48:
        return fullScroll(130);
    L36:
        if (r10.isAltPressed() == true) goto L39;
        return arrowScroll(33);
    L39:
        return fullScroll(33);
    L45:
        return false;
    }

    public final boolean f(int r10) {
        if (f.b(this.mEdgeGlowTop) == 0.0f) goto L9;
        if (x(this.mEdgeGlowTop, r10) == false) goto L7;
        this.mEdgeGlowTop.onAbsorb(r10);
    L14:
        return true;
    L7:
        fling(-r10);
        goto L14
    L9:
        if (f.b(this.mEdgeGlowBottom) == 0.0f) goto L15;
        int r11 = -r10;
        if (x(this.mEdgeGlowBottom, r11) == false) goto L13;
        this.mEdgeGlowBottom.onAbsorb(r11);
        goto L14
    L13:
        fling(r11);
        goto L14
    L15:
        return false;
    }

    public void fling(int r13) {
        if (getChildCount() <= 0) goto L6;
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Channel.UNLIMITED, 0, 0);
        t(true);
        return;
    }

    public boolean fullScroll(int r10) {
        if (r10 != 130) goto L5;
        boolean r11 = true;
    L6:
        int r12 = getHeight();
        Rect r13 = this.mTempRect;
        r13.top = 0;
        r13.bottom = r12;
        if (r11 == false) goto L11;
        int r14 = getChildCount();
        if (r14 <= 0) goto L11;
        View r15 = getChildAt(r14 - 1);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        this.mTempRect.bottom = (r15.getBottom() + r16.bottomMargin) + getPaddingBottom();
        Rect r17 = this.mTempRect;
        r17.top = r17.bottom - r12;
    L11:
        Rect r18 = this.mTempRect;
        return u(r10, r18.top, r18.bottom);
    L5:
        r11 = false;
        goto L6
    }

    public final void g() {
        this.mIsBeingDragged = false;
        r();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        int r12 = getVerticalFadingEdgeLength();
        int r13 = ((r10.getBottom() + r11.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r13 < r12) goto L9;
        return 1.0f;
    L9:
        return r13 / r12;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * MAX_SCROLL_FACTOR);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        return Math.max(0, ((r10.getHeight() + r11.topMargin) + r11.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r10 = getVerticalFadingEdgeLength();
        int r11 = getScrollY();
        if (r11 < r10) goto L9;
        return 1.0f;
    L9:
        return r11 / r10;
    }

    public final View h(boolean r12, int r13, int r14) {
        ArrayList r11 = getFocusables(2);
        int r10 = r11.size();
        View r15 = null;
        int r16 = 0;
        boolean r17 = false;
    L3:
        if (r16 >= r10) goto L31;
        View r18 = (View) r11.get(r16);
        int r19 = r18.getTop();
        int r20 = r18.getBottom();
        if (r13 >= r20) goto L30;
        if (r19 >= r14) goto L30;
        if (r13 >= r19) goto L11;
        if (r20 >= r14) goto L11;
        boolean r21 = true;
    L12:
        if (r15 != null) goto L14;
        r15 = r18;
        r17 = r21;
        goto L30
    L14:
        if (r12 == true) goto L16;
    L17:
        if (r12 == false) goto L19;
    L21:
        boolean r22 = false;
    L22:
        if (r17 == false) goto L26;
        if (r21 == false) goto L30;
        if (r22 == false) goto L30;
    L29:
        r15 = r18;
        goto L30
    L26:
        if (r21 == false) goto L28;
        r15 = r18;
        r17 = true;
        goto L30
    L28:
        if (r22 == false) goto L30;
    L19:
        if (r20 <= r15.getBottom()) goto L21;
    L20:
        r22 = true;
        goto L22
    L16:
        if (r19 < r15.getTop()) goto L20;
    L11:
        r21 = false;
    L30:
        r16 = r16 + 1;
        goto L3
    L31:
        return r15;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r10) {
        return this.mChildHelper.l(r10);
    }

    public final float i(int r10) {
        double r11 = Math.log((Math.abs(r10) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float r12 = DECELERATION_RATE;
        return (float) ((this.mPhysicalCoeff * SCROLL_FRICTION) * Math.exp((r12 / (((double) r12) - 1.0d)) * r11));
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.m();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public final boolean j(int r10, int r11) {
        if (getChildCount() <= 0) goto L14;
        int r12 = getScrollY();
        View r13 = getChildAt(0);
        if (r11 >= (r13.getTop() - r12)) goto L7;
        return false;
    L7:
        if (r11 < (r13.getBottom() - r12)) goto L9;
        return false;
    L9:
        if (r10 >= r13.getLeft()) goto L11;
        return false;
    L11:
        if (r10 >= r13.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public final void k() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r10.clear();
    }

    public final void l() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
        setWillNotDraw(false);
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r10.getScaledTouchSlop();
        this.mMinimumVelocity = r10.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r10.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void measureChild(@NonNull View r10, int r11, int r12) {
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        r10.measure(FrameLayout.getChildMeasureSpec(r11, getPaddingLeft() + getPaddingRight(), r13.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        r10.measure(FrameLayout.getChildMeasureSpec(r11, (((getPaddingLeft() + getPaddingRight()) + r15.leftMargin) + r15.rightMargin) + r12, r15.width), View.MeasureSpec.makeMeasureSpec(r15.topMargin + r15.bottomMargin, 0));
    }

    public final boolean n(View r10) {
        return !p(r10, 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent r10) {
        int r11 = 0;
        if (r10.getAction() == 8) goto L5;
    L35:
        return false;
    L5:
        if (this.mIsBeingDragged == true) goto L35;
        if (androidx.core.view.h.a(r10, 2) == false) goto L10;
        float r12 = r10.getAxisValue(9);
    L14:
        if (r12 == 0.0f) goto L35;
        int r13 = (int) (r12 * getVerticalScrollFactorCompat());
        int r14 = getScrollRange();
        int r15 = getScrollY();
        int r16 = r15 - r13;
        if (r16 < 0) goto L18;
        if (r16 > r14) goto L25;
        boolean r17 = 0;
        r11 = r16;
    L31:
        if (r11 == r15) goto L34;
        super.scrollTo(getScrollX(), r11);
        return true;
    L34:
        return r17;
    L25:
        if (b() == true) goto L27;
    L29:
        r17 = r11;
        r11 = r14;
        goto L31
    L27:
        if (androidx.core.view.h.a(r10, 8194) == true) goto L29;
        f.d(this.mEdgeGlowBottom, (r16 - r14) / getHeight(), MAX_SCROLL_FACTOR);
        this.mEdgeGlowBottom.onRelease();
        invalidate();
        r11 = 1;
        goto L29
    L18:
        if (b() == true) goto L20;
    L22:
        r17 = 0;
        goto L31
    L20:
        if (androidx.core.view.h.a(r10, 8194) == true) goto L22;
        f.d(this.mEdgeGlowTop, (-r16) / getHeight(), MAX_SCROLL_FACTOR);
        this.mEdgeGlowTop.onRelease();
        invalidate();
        r17 = 1;
        goto L31
    L10:
        if (androidx.core.view.h.a(r10, UiType.FLAG_NO_FEEDBACK) == false) goto L12;
        r12 = r10.getAxisValue(26);
        goto L14
    L12:
        r12 = 0.0f;
        goto L14
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent r12) {
        int r10 = r12.getAction();
        boolean r11 = true;
        if (r10 == 2) goto L5;
    L7:
        int r13 = r10 & PrivateKeyType.INVALID;
        if (r13 != 0) goto L10;
        int r14 = (int) r12.getY();
        if (j((int) r12.getX(), r14) == false) goto L38;
        this.mLastMotionY = r14;
        this.mActivePointerId = r12.getPointerId(0);
        k();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        if (z(r12) == false) goto L47;
    L50:
        this.mIsBeingDragged = r11;
        startNestedScroll(2, 0);
    L52:
        return this.mIsBeingDragged;
    L47:
        if (this.mScroller.isFinished() == false) goto L50;
        r11 = false;
        goto L50
    L38:
        if (z(r12) == false) goto L40;
    L43:
        this.mIsBeingDragged = r11;
        r();
        goto L52
    L40:
        if (this.mScroller.isFinished() == false) goto L43;
        r11 = false;
        goto L43
    L10:
        if (r13 == 1) goto L31;
        if (r13 != 2) goto L13;
        int r15 = this.mActivePointerId;
        if (r15 == (-1)) goto L52;
        int r16 = r12.findPointerIndex(r15);
        if (r16 != (-1)) goto L24;
        Log.e(TAG, "Invalid pointerId=" + r15 + " in onInterceptTouchEvent");
        goto L52
    L24:
        int r17 = (int) r12.getY(r16);
        if (Math.abs(r17 - this.mLastMotionY) <= this.mTouchSlop) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r17;
        m();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r18 = getParent();
        if (r18 == null) goto L52;
        r18.requestDisallowInterceptTouchEvent(true);
        goto L52
    L13:
        if (r13 == 3) goto L31;
        if (r13 != 6) goto L52;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        r();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.g0(this);
    L34:
        stopNestedScroll(0);
        goto L52
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = 0;
        this.mIsLayoutDirty = false;
        View r16 = this.mChildToScrollTo;
        if (r16 != null) goto L5;
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
        View r17 = getChildAt(0);
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17.getLayoutParams();
        r15 = (r17.getMeasuredHeight() + r18.topMargin) + r18.bottomMargin;
    L15:
        int r19 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        int r20 = getScrollY();
        int r21 = d(r20, r19, r15);
        if (r21 == r20) goto L18;
        scrollTo(getScrollX(), r21);
        goto L18
    L5:
        if (o(r16, this) == false) goto L7;
        v(this.mChildToScrollTo);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r11) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getMeasuredHeight();
        int r15 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r13.topMargin) - r13.bottomMargin;
        if (r14 >= r15) goto L15;
        r12.measure(FrameLayout.getChildMeasureSpec(r10, ((getPaddingLeft() + getPaddingRight()) + r13.leftMargin) + r13.rightMargin, r13.width), View.MeasureSpec.makeMeasureSpec(r15, Ints.MAX_POWER_OF_TWO));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View r10, float r11, float r12, boolean r13) {
        if (r13 == true) goto L5;
        dispatchNestedFling(0.0f, r12, true);
        fling((int) r12);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View r10, float r11, float r12) {
        return dispatchNestedPreFling(r11, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13, int r14) {
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15, @NonNull int[] r16) {
        q(r14, r15, r16);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        this.mParentHelper.c(r10, r11, r12, r13);
        startNestedScroll(2, r13);
    }

    @Override // android.view.View
    public void onOverScrolled(int r10, int r11, boolean r12, boolean r13) {
        super.scrollTo(r10, r11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r10, Rect r11) {
        if (r10 != 2) goto L6;
        r10 = 130;
    L8:
        if (r11 != null) goto L10;
        View r12 = FocusFinder.getInstance().findNextFocus(this, null, r10);
    L12:
        if (r12 != null) goto L15;
        return false;
    L15:
        if (n(r12) == false) goto L18;
        return false;
    L18:
        return r12.requestFocus(r10, r11);
    L10:
        r12 = FocusFinder.getInstance().findNextFocusFromRect(this, r11, r10);
        goto L12
    L6:
        if (r10 != 1) goto L8;
        r10 = 33;
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.mSavedState = r11;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.scrollPosition = getScrollY();
        return r10;
    }

    @Override // android.view.View
    public void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        OnScrollChangeListener r14 = this.mOnScrollChangeListener;
        if (r14 == null) goto L6;
        r14.onScrollChange(this, r10, r11, r12, r13);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        View r14 = findFocus();
        if (r14 == null) goto L10;
        if (this != r14) goto L7;
        return;
    L7:
        if (p(r14, 0, r13) == false) goto L11;
        r14.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r14, this.mTempRect);
        e(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        if ((r12 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View r10, int r11) {
        this.mParentHelper.e(r10, r11);
        stopNestedScroll(r11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r24) {
        m();
        int r10 = r24.getActionMasked();
        boolean r12 = false;
        if (r10 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r13 = MotionEvent.obtain(r24);
        r13.offsetLocation(0.0f, this.mNestedYOffset);
        if (r10 == 0) goto L92;
        if (r10 == 1) goto L80;
        if (r10 != 2) goto L11;
        int r15 = r24.findPointerIndex(this.mActivePointerId);
        if (r15 != (-1)) goto L30;
        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
    L103:
        VelocityTracker r11 = this.mVelocityTracker;
        if (r11 == null) goto L106;
        r11.addMovement(r13);
    L106:
        r13.recycle();
        return true;
    L30:
        int r14 = (int) r24.getY(r15);
        int r16 = this.mLastMotionY - r14;
        int r17 = r16 - s(r16, r24.getX(r15));
        if (this.mIsBeingDragged == false) goto L33;
    L40:
        int r18 = r17;
        if (this.mIsBeingDragged == false) goto L103;
        if (dispatchNestedPreScroll(0, r18, this.mScrollConsumed, this.mScrollOffset, 0) == false) goto L47;
        r18 = r18 - this.mScrollConsumed[1];
        this.mNestedYOffset += this.mScrollOffset[1];
    L47:
        int r19 = r18;
        this.mLastMotionY = r14 - this.mScrollOffset[1];
        int r110 = getScrollY();
        int r20 = getScrollRange();
        int r21 = getOverScrollMode();
        if (r21 == 0) goto L53;
        if (r21 != 1) goto L52;
        if (r20 > 0) goto L53;
    L52:
        boolean r111 = false;
    L55:
        if (overScrollByCompat(0, r19, 0, getScrollY(), 0, r20, 0, 0, true) == true) goto L57;
    L59:
        boolean r22 = false;
    L60:
        int r23 = getScrollY() - r110;
        int[] r25 = this.mScrollConsumed;
        r25[1] = 0;
        dispatchNestedScroll(0, r23, 0, r19 - r23, this.mScrollOffset, 0, r25);
        int r26 = this.mLastMotionY;
        int r27 = this.mScrollOffset[1];
        this.mLastMotionY = r26 - r27;
        this.mNestedYOffset += r27;
        if (r111 == false) goto L77;
        int r28 = r19 - this.mScrollConsumed[1];
        int r29 = r110 + r28;
        if (r29 >= 0) goto L68;
        f.d(this.mEdgeGlowTop, (-r28) / getHeight(), r24.getX(r15) / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L73;
        this.mEdgeGlowBottom.onRelease();
    L73:
        if (this.mEdgeGlowTop.isFinished() == true) goto L75;
    L76:
        ViewCompat.g0(this);
    L78:
        if (r12 == false) goto L103;
        this.mVelocityTracker.clear();
        goto L103
    L75:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L77;
    L68:
        if (r29 <= r20) goto L73;
        f.d(this.mEdgeGlowBottom, r28 / getHeight(), 1.0f - (r24.getX(r15) / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L73;
        this.mEdgeGlowTop.onRelease();
    L77:
        r12 = r22;
        goto L78
    L57:
        if (hasNestedScrollingParent(0) == true) goto L59;
        r22 = true;
    L53:
        r111 = true;
        goto L55
    L33:
        if (Math.abs(r17) <= this.mTouchSlop) goto L40;
        ViewParent r30 = getParent();
        if (r30 == null) goto L37;
        r30.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        if (r17 <= 0) goto L41;
        r17 = r17 - this.mTouchSlop;
        goto L40
    L41:
        r17 = r17 + this.mTouchSlop;
        goto L40
    L11:
        if (r10 == 3) goto L20;
        if (r10 != 5) goto L15;
        int r31 = r24.getActionIndex();
        this.mLastMotionY = (int) r24.getY(r31);
        this.mActivePointerId = r24.getPointerId(r31);
        goto L103
    L15:
        if (r10 != 6) goto L103;
        onSecondaryPointerUp(r24);
        this.mLastMotionY = (int) r24.getY(r24.findPointerIndex(this.mActivePointerId));
        goto L103
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L26:
        this.mActivePointerId = -1;
        g();
        goto L103
    L22:
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
        ViewCompat.g0(this);
        goto L26
    L80:
        VelocityTracker r32 = this.mVelocityTracker;
        r32.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r33 = (int) r32.getYVelocity(this.mActivePointerId);
        if (Math.abs(r33) < this.mMinimumVelocity) goto L88;
        if (f(r33) == true) goto L90;
        int r34 = -r33;
        float r35 = r34;
        if (dispatchNestedPreFling(0.0f, r35) == true) goto L90;
        dispatchNestedFling(0.0f, r35, true);
        fling(r34);
    L90:
        this.mActivePointerId = -1;
        g();
        goto L103
    L88:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L90;
        ViewCompat.g0(this);
        goto L90
    L92:
        if (getChildCount() != 0) goto L95;
        return false;
    L95:
        if (this.mIsBeingDragged == false) goto L100;
        ViewParent r36 = getParent();
        if (r36 == null) goto L100;
        r36.requestDisallowInterceptTouchEvent(true);
    L100:
        if (this.mScroller.isFinished() == true) goto L102;
        a();
    L102:
        this.mLastMotionY = (int) r24.getY();
        this.mActivePointerId = r24.getPointerId(0);
        startNestedScroll(2, 0);
        goto L103
    }

    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r10 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r11 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r12 = true;
    L10:
        if (r10 == 0) goto L15;
        if (r10 != 1) goto L14;
        if (r11 == true) goto L15;
    L14:
        boolean r22 = false;
    L16:
        if (r10 == 0) goto L21;
        if (r10 != 1) goto L20;
        if (r12 == true) goto L21;
    L20:
        boolean r23 = false;
    L22:
        int r24 = r15 + r13;
        if (r22 == true) goto L25;
        int r25 = 0;
    L26:
        int r26 = r16 + r14;
        if (r23 == true) goto L29;
        int r27 = 0;
    L30:
        int r28 = -r25;
        int r29 = r25 + r17;
        int r30 = -r27;
        int r31 = r27 + r18;
        if (r24 <= r29) goto L33;
        r24 = r29;
        boolean r32 = true;
    L36:
        if (r26 <= r31) goto L38;
        r26 = r31;
        boolean r33 = true;
    L41:
        if (r33 == true) goto L43;
    L45:
        onOverScrolled(r24, r26, r32, r33);
        if (r32 == true) goto L49;
        if (r33 == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (hasNestedScrollingParent(1) == true) goto L45;
        this.mScroller.springBack(r24, r26, 0, 0, 0, getScrollRange());
        goto L45
    L38:
        if (r26 >= r30) goto L40;
        r33 = true;
        r26 = r30;
        goto L41
    L40:
        r33 = false;
        goto L41
    L33:
        if (r24 >= r28) goto L35;
        r32 = true;
        r24 = r28;
        goto L36
    L35:
        r32 = false;
        goto L36
    L29:
        r27 = r20;
        goto L30
    L25:
        r25 = r19;
    L21:
        r23 = true;
    L15:
        r22 = true;
        goto L16
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public final boolean p(View r10, int r11, int r12) {
        r10.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        if ((this.mTempRect.bottom + r11) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r11) > (getScrollY() + r12)) goto L7;
        return true;
    }

    public boolean pageScroll(int r10) {
        if (r10 != 130) goto L5;
        boolean r11 = true;
    L6:
        int r12 = getHeight();
        if (r11 == false) goto L13;
        this.mTempRect.top = getScrollY() + r12;
        int r13 = getChildCount();
        if (r13 <= 0) goto L16;
        View r14 = getChildAt(r13 - 1);
        int r15 = (r14.getBottom() + ((FrameLayout.LayoutParams) r14.getLayoutParams()).bottomMargin) + getPaddingBottom();
        Rect r16 = this.mTempRect;
        if ((r16.top + r12) <= r15) goto L16;
        r16.top = r15 - r12;
    L16:
        Rect r17 = this.mTempRect;
        int r18 = r17.top;
        int r19 = r12 + r18;
        r17.bottom = r19;
        return u(r10, r18, r19);
    L13:
        this.mTempRect.top = getScrollY() - r12;
        Rect r20 = this.mTempRect;
        if (r20.top >= 0) goto L16;
        r20.top = 0;
        goto L16
    L5:
        r11 = false;
        goto L6
    }

    public final void q(int r11, int r12, int[] r13) {
        int r10 = getScrollY();
        scrollBy(0, r11);
        int r14 = getScrollY() - r10;
        if (r13 == null) goto L5;
        r13[1] = r13[1] + r14;
    L5:
        NestedScrollingChildHelper r15 = this.mChildHelper;
        r15.e(0, r14, 0, r11 - r14, null, r12, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        if (this.mIsLayoutDirty == true) goto L5;
        v(r11);
    L6:
        super.requestChildFocus(r10, r11);
        return;
    L5:
        this.mChildToScrollTo = r11;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View r10, Rect r11, boolean r12) {
        r11.offset(r10.getLeft() - r10.getScrollX(), r10.getTop() - r10.getScrollY());
        return w(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        if (r10 == false) goto L4;
        r();
    L4:
        super.requestDisallowInterceptTouchEvent(r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public final int s(int r10, float r11) {
        float r12 = r11 / getWidth();
        float r13 = r10 / getHeight();
        float r14 = 0.0f;
        if (f.b(this.mEdgeGlowTop) == 0.0f) goto L9;
        float r15 = -f.d(this.mEdgeGlowTop, -r13, r12);
        if (f.b(this.mEdgeGlowTop) != 0.0f) goto L7;
        this.mEdgeGlowTop.onRelease();
    L7:
        r14 = r15;
    L13:
        int r16 = Math.round(r14 * getHeight());
        if (r16 == 0) goto L16;
        invalidate();
    L16:
        return r16;
    L9:
        if (f.b(this.mEdgeGlowBottom) == 0.0f) goto L13;
        r15 = f.d(this.mEdgeGlowBottom, r13, 1.0f - r12);
        if (f.b(this.mEdgeGlowBottom) != 0.0f) goto L7;
        this.mEdgeGlowBottom.onRelease();
        goto L7
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        if (getChildCount() <= 0) goto L10;
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r15 = (r12.getWidth() + r13.leftMargin) + r13.rightMargin;
        int r16 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r17 = (r12.getHeight() + r13.topMargin) + r13.bottomMargin;
        int r18 = d(r10, r14, r15);
        int r19 = d(r11, r16, r17);
        if (r18 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r18, r19);
        return;
    L7:
        if (r19 != getScrollY()) goto L8;
        return;
    }

    public void setFillViewport(boolean r10) {
        if (r10 == this.mFillViewport) goto L6;
        this.mFillViewport = r10;
        requestLayout();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        this.mChildHelper.n(r10);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener r10) {
        this.mOnScrollChangeListener = r10;
    }

    public void setSmoothScrollingEnabled(boolean r10) {
        this.mSmoothScrollingEnabled = r10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int r10, int r11) {
        y(r10, r11, 250, false);
    }

    public final void smoothScrollTo(int r10, int r11) {
        smoothScrollTo(r10, r11, 250, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r10, int r11) {
        return this.mChildHelper.q(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r10) {
        this.mChildHelper.s(r10);
    }

    public final void t(boolean r10) {
        if (r10 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.g0(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    public final boolean u(int r10, int r11, int r12) {
        int r13 = getHeight();
        int r14 = getScrollY();
        int r15 = r13 + r14;
        boolean r16 = false;
        if (r10 != 33) goto L5;
        boolean r17 = true;
    L6:
        View r18 = h(r17, r11, r12);
        if (r18 != null) goto L9;
        r18 = this;
    L9:
        if (r11 < r14) goto L12;
        if (r12 > r15) goto L12;
    L17:
        if (r18 == findFocus()) goto L19;
        r18.requestFocus(r10);
    L19:
        return r16;
    L12:
        if (r17 == false) goto L14;
        int r19 = r11 - r14;
    L15:
        e(r19);
        r16 = true;
        goto L17
    L14:
        r19 = r12 - r15;
        goto L15
    L5:
        r17 = false;
        goto L6
    }

    public final void v(View r10) {
        r10.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        int r11 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r11 == 0) goto L6;
        scrollBy(0, r11);
        return;
    }

    public final boolean w(Rect r10, boolean r11) {
        int r12 = computeScrollDeltaToGetChildRectOnScreen(r10);
        if (r12 == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        if (r11 == false) goto L9;
        scrollBy(0, r12);
        goto L10
    L9:
        smoothScrollBy(0, r12);
    L10:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    public final boolean x(EdgeEffect r10, int r11) {
        if (r11 <= 0) goto L6;
        return true;
    L6:
        if (i(-r11) < (f.b(r10) * getHeight())) goto L10;
        return false;
    L10:
        return true;
    }

    public final void y(int r10, int r11, int r12, boolean r13) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r14 = getChildAt(0);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        int r16 = (r14.getHeight() + r15.topMargin) + r15.bottomMargin;
        int r17 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r18 = getScrollY();
        int r19 = r11 + r18;
        int r20 = Math.max(0, Math.min(r19, Math.max(0, r16 - r17))) - r18;
        this.mScroller.startScroll(getScrollX(), r18, 0, r20, r12);
        t(r13);
    L12:
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        return;
    L9:
        if (this.mScroller.isFinished() == true) goto L11;
        a();
    L11:
        scrollBy(r10, r11);
        goto L12
    }

    public final boolean z(MotionEvent r10) {
        if (f.b(this.mEdgeGlowTop) == 0.0f) goto L5;
        f.d(this.mEdgeGlowTop, 0.0f, r10.getX() / getWidth());
        boolean r11 = true;
    L7:
        if (f.b(this.mEdgeGlowBottom) == 0.0f) goto L10;
        f.d(this.mEdgeGlowBottom, 0.0f, 1.0f - (r10.getX() / getWidth()));
        return true;
    L10:
        return r11;
    L5:
        r11 = false;
        goto L7
    }

    public NestedScrollView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.nestedScrollViewStyle);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15) {
        return this.mChildHelper.g(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15) {
        q(r14, r15, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12) {
        return onStartNestedScroll(r10, r11, r12, 0);
    }

    public final void smoothScrollBy(int r10, int r11, int r12) {
        y(r10, r11, r12, false);
    }

    public final void smoothScrollTo(int r10, int r11, int r12) {
        smoothScrollTo(r10, r11, r12, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return startNestedScroll(r10, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mEdgeGlowTop = f.a(r10, r11);
        this.mEdgeGlowBottom = f.a(r10, r11);
        this.mPhysicalCoeff = ((r10.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        l();
        TypedArray r13 = r10.obtainStyledAttributes(r11, SCROLLVIEW_STYLEABLE, r12, 0);
        setFillViewport(r13.getBoolean(0, false));
        r13.recycle();
        this.mParentHelper = new androidx.core.view.i(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.p0(this, ACCESSIBILITY_DELEGATE);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14) {
        return this.mChildHelper.f(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14) {
        q(r14, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12) {
        onNestedScrollAccepted(r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View r10) {
        onStopNestedScroll(r10, 0);
    }

    public void smoothScrollTo(int r10, int r11, boolean r12) {
        smoothScrollTo(r10, r11, 250, r12);
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void smoothScrollTo(int r10, int r11, int r12, boolean r13) {
        y(r10 - getScrollX(), r11 - getScrollY(), r12, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
