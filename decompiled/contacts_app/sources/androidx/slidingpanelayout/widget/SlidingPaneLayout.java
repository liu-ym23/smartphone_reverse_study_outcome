package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.slidingpanelayout.widget.SlidingPaneLayout";
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    FoldingFeature mFoldingFeature;
    private FoldingFeatureObserver mFoldingFeatureObserver;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private int mLockMode;
    private FoldingFeatureObserver.OnFoldingFeatureChangeListener mOnFoldingFeatureChangeListener;
    private PanelSlideListener mPanelSlideListener;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;
        final /* synthetic */ SlidingPaneLayout this$0;

        AccessibilityDelegate(SlidingPaneLayout r1) {
            this.this$0 = r1;
            this.mTmpRect = new Rect();
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfoCompat r5) {
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(r5);
            super.onInitializeAccessibilityNodeInfo(r4, r0);
            copyNodeInfoNoChildren(r5, r0);
            r0.recycle();
            r5.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
            r5.setSource(r4);
            Object r6 = ViewCompat.getParentForAccessibility(r4);
            if ((r6 instanceof View) == false) goto L5;
            r5.setParent((View) r6);
        L5:
            int r7 = this.this$0.getChildCount();
            int r1 = 0;
        L6:
            if (r1 >= r7) goto L13;
            View r2 = this.this$0.getChildAt(r1);
            if (filter(r2) == true) goto L12;
            if (r2.getVisibility() != 0) goto L12;
            ViewCompat.setImportantForAccessibility(r2, 1);
            r5.addChild(r2);
        L12:
            r1 = r1 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            r2.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r2, View r3, AccessibilityEvent r4) {
            if (filter(r3) == false) goto L5;
            return false;
        L5:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
        }

        public boolean filter(View r1) {
            return this.this$0.isDimmed(r1);
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat r1, AccessibilityNodeInfoCompat r2) {
            Rect r0 = this.mTmpRect;
            r2.getBoundsInScreen(r0);
            r1.setBoundsInScreen(r0);
            r1.setVisibleToUser(r2.isVisibleToUser());
            r1.setPackageName(r2.getPackageName());
            r1.setClassName(r2.getClassName());
            r1.setContentDescription(r2.getContentDescription());
            r1.setEnabled(r2.isEnabled());
            r1.setClickable(r2.isClickable());
            r1.setFocusable(r2.isFocusable());
            r1.setFocused(r2.isFocused());
            r1.setAccessibilityFocused(r2.isAccessibilityFocused());
            r1.setSelected(r2.isSelected());
            r1.setLongClickable(r2.isLongClickable());
            r1.addAction(r2.getActions());
            r1.setMovementGranularities(r2.getMovementGranularities());
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;
        final /* synthetic */ SlidingPaneLayout this$0;

        DisableLayerRunnable(SlidingPaneLayout r1, View r2) {
            this.this$0 = r1;
            this.mChildView = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() != this.this$0) goto L5;
            this.mChildView.setLayerType(0, null);
            this.this$0.invalidateChildRegion(this.mChildView);
        L5:
            this.this$0.mPostedRunnables.remove(this);
        }
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        final /* synthetic */ SlidingPaneLayout this$0;

        DragHelperCallback(SlidingPaneLayout r1) {
            this.this$0 = r1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View r1, int r2) {
            if (isDraggable() == true) goto L7;
            return false;
        L7:
            return ((LayoutParams) r1.getLayoutParams()).slideable;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int r2) {
            if (this.this$0.mDragHelper.getViewDragState() == 0) goto L5;
            return;
        L5:
            if (this.this$0.mSlideOffset != 1.0f) goto L7;
            SlidingPaneLayout r3 = this.this$0;
            r3.updateObscuredViewsVisibility(r3.mSlideableView);
            SlidingPaneLayout r4 = this.this$0;
            r4.dispatchOnPanelClosed(r4.mSlideableView);
            this.this$0.mPreservedOpenState = false;
            return;
        L7:
            SlidingPaneLayout r5 = this.this$0;
            r5.dispatchOnPanelOpened(r5.mSlideableView);
            this.this$0.mPreservedOpenState = true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View r1, int r2) {
            this.this$0.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
            this.this$0.onPanelDragged(r2);
            this.this$0.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View r4, float r5, float r6) {
            LayoutParams r7 = (LayoutParams) r4.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L12;
            int r0 = this.this$0.getPaddingRight() + r7.rightMargin;
            if (r5 >= 0.0f) goto L7;
        L10:
            r0 = r0 + this.this$0.mSlideRange;
        L11:
            int r8 = this.this$0.mSlideableView.getWidth();
            int r9 = (this.this$0.getWidth() - r0) - r8;
        L18:
            this.this$0.mDragHelper.settleCapturedViewAt(r9, r4.getTop());
            this.this$0.invalidate();
            return;
        L7:
            if (r5 != 0.0f) goto L11;
            if (this.this$0.mSlideOffset <= 0.5f) goto L11;
        L12:
            int r1 = this.this$0.getPaddingLeft();
            r9 = r7.leftMargin + r1;
            if (r5 > 0.0f) goto L17;
            if (r5 != 0.0f) goto L18;
            if (this.this$0.mSlideOffset <= 0.5f) goto L18;
        L17:
            r9 = r9 + this.this$0.mSlideRange;
            goto L18
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View r1) {
            return this.this$0.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View r2, int r3, int r4) {
            LayoutParams r5 = (LayoutParams) this.this$0.mSlideableView.getLayoutParams();
            if (this.this$0.isLayoutRtlSupport() == false) goto L5;
            int r6 = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + r5.rightMargin) + this.this$0.mSlideableView.getWidth());
            int r1 = r6 - this.this$0.mSlideRange;
            return Math.max(Math.min(r3, r6), r1);
        L5:
            int r7 = this.this$0.getPaddingLeft() + r5.leftMargin;
            int r8 = this.this$0.mSlideRange + r7;
            return Math.min(Math.max(r3, r7), r8);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View r1, int r2, int r3) {
            return r1.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int r1, int r2) {
            if (isDraggable() == true) goto L5;
            return;
        L5:
            this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, r2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int r1, int r2) {
            if (isDraggable() == true) goto L5;
            return;
        L5:
            this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, r2);
        }

        private boolean isDraggable() {
            if (this.this$0.mIsUnableToDrag == false) goto L6;
            return false;
        L6:
            if (this.this$0.getLockMode() != 3) goto L9;
            return false;
        L9:
            if (this.this$0.isOpen() == false) goto L14;
            if (this.this$0.getLockMode() != 1) goto L14;
            return false;
        L14:
            if (this.this$0.isOpen() == false) goto L16;
        L18:
            return true;
        L16:
            if (this.this$0.getLockMode() != 2) goto L18;
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = null;
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        static {
            ATTRS = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.weight = 0.0f;
            this.weight = r2.weight;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.weight = 0.0f;
            TypedArray r5 = r3.obtainStyledAttributes(r4, ATTRS);
            this.weight = r5.getFloat(0, 0.0f);
            r5.recycle();
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(View r1);

        void onPanelOpened(View r1);

        void onPanelSlide(View r1, float r2);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean isOpen;
        int mLockMode;

        SavedState(Parcelable r1) {
            super(r1);
        }

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isOpen = r3;
            this.mLockMode = r1.readInt();
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.isOpen ? 1 : 0);
            r1.writeInt(this.mLockMode);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r1) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r1) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r1, float r2) {
        }

        public SimplePanelSlideListener() {
        }
    }

    private static class TouchBlocker extends FrameLayout {
        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent r1) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent r1) {
            return true;
        }

        TouchBlocker(View r2) {
            super(r2.getContext());
            addView(r2);
        }
    }

    static {
        sEdgeSizeUsingSystemGestureInsets = true;
    }

    public final void setLockMode(int r1) {
        this.mLockMode = r1;
    }

    public final int getLockMode() {
        return this.mLockMode;
    }

    public SlidingPaneLayout(Context r2) {
        this(r2, null);
    }

    public SlidingPaneLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SlidingPaneLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mSliderFadeColor = 0;
        this.mSlideOffset = 1.0f;
        this.mPanelSlideListeners = new CopyOnWriteArrayList();
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        this.mOnFoldingFeatureChangeListener = new AnonymousClass1(this);
        float r0 = r2.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r5 = ViewDragHelper.create(this, 0.5f, new DragHelperCallback(this));
        this.mDragHelper = r5;
        r5.setMinVelocity(r0 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(WindowInfoTracker.getOrCreate(r2), ContextCompat.getMainExecutor(r2)));
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver r1) {
        this.mFoldingFeatureObserver = r1;
        r1.setOnFoldingFeatureChangeListener(this.mOnFoldingFeatureChangeListener);
    }

    public void setParallaxDistance(int r1) {
        this.mParallaxBy = r1;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @Deprecated
    public void setSliderFadeColor(int r1) {
        this.mSliderFadeColor = r1;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    @Deprecated
    public void setCoveredFadeColor(int r1) {
        this.mCoveredFadeColor = r1;
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @Deprecated
    public void setPanelSlideListener(PanelSlideListener r2) {
        PanelSlideListener r0 = this.mPanelSlideListener;
        if (r0 == null) goto L5;
        removePanelSlideListener(r0);
    L5:
        if (r2 == null) goto L7;
        addPanelSlideListener(r2);
    L7:
        this.mPanelSlideListener = r2;
    }

    public void addPanelSlideListener(PanelSlideListener r1) {
        this.mPanelSlideListeners.add(r1);
    }

    public void removePanelSlideListener(PanelSlideListener r1) {
        this.mPanelSlideListeners.remove(r1);
    }

    void dispatchOnPanelSlide(View r4) {
        Iterator<PanelSlideListener> r0 = this.mPanelSlideListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPanelSlide(r4, this.mSlideOffset);
        goto L4
    }

    void dispatchOnPanelOpened(View r3) {
        Iterator<PanelSlideListener> r0 = this.mPanelSlideListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPanelOpened(r3);
        goto L4
    L6:
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelClosed(View r3) {
        Iterator<PanelSlideListener> r0 = this.mPanelSlideListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPanelClosed(r3);
        goto L4
    L6:
        sendAccessibilityEvent(32);
    }

    void updateObscuredViewsVisibility(View r18) {
        View r0 = r18;
        boolean r1 = isLayoutRtlSupport();
        if (r1 == false) goto L5;
        int r2 = getWidth() - getPaddingRight();
    L6:
        if (r1 == false) goto L8;
        int r3 = getPaddingLeft();
    L9:
        int r4 = getPaddingTop();
        int r5 = getHeight() - getPaddingBottom();
        if (r0 != null) goto L12;
    L14:
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L15:
        int r11 = getChildCount();
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L39;
        View r14 = getChildAt(r12);
        if (r14 == r0) goto L44;
        if (r14.getVisibility() == 8) goto L38;
        if (r1 == false) goto L25;
        int r6 = r3;
    L26:
        int r13 = Math.max(r6, r14.getLeft());
        int r15 = Math.max(r4, r14.getTop());
        if (r1 == false) goto L29;
        int r16 = r2;
    L30:
        int r17 = Math.min(r16, r14.getRight());
        int r19 = Math.min(r5, r14.getBottom());
        if (r13 < r7) goto L36;
        if (r15 < r9) goto L36;
        if (r17 > r8) goto L36;
        if (r19 > r10) goto L36;
        int r20 = 4;
    L37:
        r14.setVisibility(r20);
    L36:
        r20 = 0;
        goto L37
    L29:
        r16 = r3;
        goto L30
    L25:
        r6 = r2;
    L38:
        r12 = r12 + 1;
        r0 = r18;
        r1 = r1;
        goto L16
    L44:
        return;
    L39:
        return;
    L12:
        if (viewIsOpaque(r18) == false) goto L14;
        r7 = r18.getLeft();
        r8 = r18.getRight();
        r9 = r18.getTop();
        r10 = r18.getBottom();
        goto L15
    L8:
        r3 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r2 = getPaddingLeft();
        goto L6
    }

    void setAllChildrenVisible() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 4) goto L7;
        r3.setVisibility(0);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private static boolean viewIsOpaque(View r0) {
        if (r0.isOpaque() == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
        if (getChildCount() != 1) goto L6;
        super.addView(new TouchBlocker(r3), r4, r5);
        return;
    L6:
        super.addView(r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r2) {
        if ((r2.getParent() instanceof TouchBlocker) == false) goto L6;
        super.removeView((View) r2.getParent());
        return;
    L6:
        super.removeView(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        if (this.mFoldingFeatureObserver == null) goto L8;
        Activity r0 = getActivityOrNull(getContext());
        if (r0 == null) goto L9;
        this.mFoldingFeatureObserver.registerLayoutStateChangeCallback(r0);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        FoldingFeatureObserver r0 = this.mFoldingFeatureObserver;
        if (r0 == null) goto L5;
        r0.unregisterLayoutStateChangeCallback();
    L5:
        int r1 = this.mPostedRunnables.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        this.mPostedRunnables.get(r2).run();
        r2 = r2 + 1;
        goto L6
    L8:
        this.mPostedRunnables.clear();
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    protected void onMeasure(int r21, int r22) {
        int r2 = View.MeasureSpec.getMode(r21);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r22);
        int r5 = View.MeasureSpec.getSize(r22);
        ?? r8 = 0;
        if (r4 == Integer.MIN_VALUE) goto L8;
        if (r4 == 1073741824) goto L7;
        int r6 = 0;
    L6:
        int r9 = r6;
    L9:
        int r10 = Math.max((r3 - getPaddingLeft()) - getPaddingRight(), 0);
        int r11 = getChildCount();
        if (r11 <= 2) goto L12;
        Log.e(TAG, "onMeasure: More than two child views are not supported.");
    L12:
        this.mSlideableView = null;
        int r13 = 0;
        boolean r14 = false;
        int r16 = r10;
        float r15 = 0.0f;
    L13:
        int r7 = 8;
        if (r13 >= r11) goto L50;
        View r12 = getChildAt(r13);
        LayoutParams r17 = (LayoutParams) r12.getLayoutParams();
        int r18 = r3;
        if (r12.getVisibility() != 8) goto L19;
        r17.dimWhenOffset = r8;
    L49:
        r13 = r13 + 1;
        r3 = r18;
        r8 = 0;
        goto L13
    L19:
        if (r17.weight <= 0.0f) goto L23;
        r15 = r15 + r17.weight;
        if (r17.width == 0) goto L49;
    L23:
        int r19 = Math.max(r10 - (r17.leftMargin + r17.rightMargin), r8);
        if (r17.width != (-2)) goto L30;
        if (r2 != 0) goto L27;
        int r20 = r2;
    L28:
        int r23 = View.MeasureSpec.makeMeasureSpec(r19, r20);
    L33:
        r12.measure(r23, getChildMeasureSpec(r22, getPaddingTop() + getPaddingBottom(), r17.height));
        int r24 = r12.getMeasuredWidth();
        int r25 = r12.getMeasuredHeight();
        if (r25 > r6) goto L36;
    L40:
        r16 = r16 - r24;
        if (r13 == 0) goto L49;
        if (r16 >= 0) goto L45;
        boolean r26 = true;
    L46:
        r17.slideable = r26;
        r14 = r14 | r26;
        if (r17.slideable == false) goto L49;
        this.mSlideableView = r12;
        goto L49
    L45:
        r26 = false;
        goto L46
    L36:
        if (r4 != Integer.MIN_VALUE) goto L38;
        r6 = Math.min(r25, r9);
        goto L40
    L38:
        if (r4 != 0) goto L40;
        r6 = r25;
        goto L40
    L27:
        r20 = Integer.MIN_VALUE;
        goto L28
    L30:
        if (r17.width != (-1)) goto L32;
        r23 = View.MeasureSpec.makeMeasureSpec(r19, r2);
        goto L33
    L32:
        r23 = View.MeasureSpec.makeMeasureSpec(r17.width, 1073741824);
        goto L33
    L50:
        int r110 = r3;
        int r27 = r16;
        if (r14 == false) goto L53;
    L54:
        int r28 = 0;
    L55:
        if (r28 >= r11) goto L85;
        View r29 = getChildAt(r28);
        if (r29.getVisibility() == r7) goto L84;
        LayoutParams r30 = (LayoutParams) r29.getLayoutParams();
        if (r30.width == 0) goto L62;
    L64:
        boolean r111 = false;
    L65:
        if (r111 == false) goto L67;
        int r112 = 0;
    L68:
        if (r14 == false) goto L71;
        int r31 = r10 - (r30.leftMargin + r30.rightMargin);
        int r32 = View.MeasureSpec.makeMeasureSpec(r31, 1073741824);
    L74:
        int r113 = measureChildHeight(r29, r22, getPaddingTop() + getPaddingBottom());
        if (r112 == r31) goto L84;
        r29.measure(r32, r113);
        int r33 = r29.getMeasuredHeight();
        if (r33 <= r6) goto L84;
        if (r4 != Integer.MIN_VALUE) goto L82;
        r33 = Math.min(r33, r9);
    L81:
        r6 = r33;
        goto L84
    L82:
        if (r4 != 0) goto L84;
    L71:
        if (r30.weight <= 0.0f) goto L73;
        r31 = r112 + ((int) ((r30.weight * Math.max(0, r27)) / r15));
        r32 = View.MeasureSpec.makeMeasureSpec(r31, 1073741824);
        goto L74
    L73:
        r31 = r112;
        r32 = 0;
        goto L74
    L67:
        r112 = r29.getMeasuredWidth();
        goto L68
    L62:
        if (r30.weight <= 0.0f) goto L64;
        r111 = true;
    L84:
        r28 = r28 + 1;
        r7 = 8;
    L85:
        ArrayList<Rect> r1 = splitViewPositions();
        if (r1 == null) goto L106;
        if (r14 == true) goto L106;
        int r34 = 0;
    L89:
        if (r34 >= r11) goto L106;
        View r35 = getChildAt(r34);
        if (r35.getVisibility() == 8) goto L105;
        Rect r36 = r1.get(r34);
        LayoutParams r37 = (LayoutParams) r35.getLayoutParams();
        int r38 = r37.leftMargin + r37.rightMargin;
        int r39 = View.MeasureSpec.makeMeasureSpec(r35.getMeasuredHeight(), 1073741824);
        r35.measure(View.MeasureSpec.makeMeasureSpec(r36.width(), Integer.MIN_VALUE), r39);
        if ((r35.getMeasuredWidthAndState() & 16777216) != 1) goto L96;
    L101:
        r35.measure(View.MeasureSpec.makeMeasureSpec(r10 - r38, 1073741824), r39);
        if (r34 == 0) goto L105;
        r37.slideable = true;
        this.mSlideableView = r35;
        r14 = true;
        goto L105
    L96:
        if (getMinimumWidth(r35) != 0) goto L98;
    L100:
        r35.measure(View.MeasureSpec.makeMeasureSpec(r36.width(), 1073741824), r39);
        goto L105
    L98:
        if (r36.width() >= getMinimumWidth(r35)) goto L100;
    L105:
        r34 = r34 + 1;
    L106:
        setMeasuredDimension(r110, (r6 + getPaddingTop()) + getPaddingBottom());
        this.mCanSlide = r14;
        if (this.mDragHelper.getViewDragState() == 0) goto L126;
        if (r14 == true) goto L127;
        this.mDragHelper.abort();
        return;
    L127:
        return;
    L126:
        return;
    L53:
        if (r15 <= 0.0f) goto L85;
    L7:
        r6 = (r5 - getPaddingTop()) - getPaddingBottom();
        goto L6
    L8:
        r9 = (r5 - getPaddingTop()) - getPaddingBottom();
        r6 = 0;
        goto L9
    }

    private static int getMinimumWidth(View r1) {
        if ((r1 instanceof TouchBlocker) == false) goto L7;
        return ViewCompat.getMinimumWidth(((TouchBlocker) r1).getChildAt(0));
    L7:
        return ViewCompat.getMinimumWidth(r1);
    }

    private static int measureChildHeight(View r3, int r4, int r5) {
        LayoutParams r0 = (LayoutParams) r3.getLayoutParams();
        if (r0.width == 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return getChildMeasureSpec(r4, r5, r0.height);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r3.getMeasuredHeight(), 1073741824);
    L5:
        if (r0.weight <= 0.0f) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        boolean r1 = isLayoutRtlSupport();
        int r2 = r22 - r20;
        if (r1 == false) goto L5;
        int r3 = getPaddingRight();
    L6:
        if (r1 == false) goto L8;
        int r4 = getPaddingLeft();
    L9:
        int r5 = getPaddingTop();
        int r6 = getChildCount();
        if (this.mFirstLayout == true) goto L12;
    L18:
        int r9 = r3;
        int r10 = 0;
    L19:
        if (r10 >= r6) goto L54;
        View r11 = getChildAt(r10);
        if (r11.getVisibility() != 8) goto L23;
        int r8 = r9;
    L52:
        r10 = r10 + 1;
        r9 = r8;
        goto L19
    L23:
        LayoutParams r12 = (LayoutParams) r11.getLayoutParams();
        int r13 = r11.getMeasuredWidth();
        if (r12.slideable == false) goto L35;
        int r15 = r2 - r4;
        int r14 = (Math.min(r3, r15) - r9) - (r12.leftMargin + r12.rightMargin);
        this.mSlideRange = r14;
        if (r1 == false) goto L28;
        int r7 = r12.rightMargin;
    L30:
        if ((((r9 + r7) + r14) + (r13 / 2)) <= r15) goto L32;
        boolean r16 = true;
    L33:
        r12.dimWhenOffset = r16;
        int r17 = (int) (r14 * this.mSlideOffset);
        this.mSlideOffset = r17 / this.mSlideRange;
        r8 = r9 + (r7 + r17);
        int r18 = 0;
    L40:
        if (r1 == false) goto L42;
        int r110 = (r2 - r8) + r18;
        int r24 = r110 - r13;
    L43:
        r11.layout(r24, r5, r110, r11.getMeasuredHeight() + r5);
        FoldingFeature r25 = this.mFoldingFeature;
        if (r25 != null) goto L46;
    L50:
        int r26 = 0;
    L51:
        r3 = r3 + (r11.getWidth() + Math.abs(r26));
        goto L52
    L46:
        if (r25.getOrientation() != FoldingFeature.Orientation.VERTICAL) goto L50;
        if (this.mFoldingFeature.isSeparating() == false) goto L50;
        r26 = this.mFoldingFeature.getBounds().width();
        goto L51
    L42:
        r24 = r8 - r18;
        r110 = r24 + r13;
        goto L43
    L32:
        r16 = false;
        goto L33
    L28:
        r7 = r12.leftMargin;
        goto L30
    L35:
        if (this.mCanSlide == false) goto L39;
        int r27 = this.mParallaxBy;
        if (r27 == 0) goto L39;
        r18 = (int) ((1.0f - this.mSlideOffset) * r27);
        r8 = r3;
    L39:
        r8 = r3;
        r18 = 0;
        goto L40
    L54:
        if (this.mFirstLayout == true) goto L56;
    L61:
        this.mFirstLayout = false;
        return;
    L56:
        if (this.mCanSlide == true) goto L58;
    L60:
        updateObscuredViewsVisibility(this.mSlideableView);
        goto L61
    L58:
        if (this.mParallaxBy == 0) goto L60;
        parallaxOtherViews(this.mSlideOffset);
        goto L60
    L12:
        if (this.mCanSlide == true) goto L14;
    L16:
        float r28 = 1.0f;
    L17:
        this.mSlideOffset = r28;
        goto L18
    L14:
        if (this.mPreservedOpenState == false) goto L16;
        r28 = 0.0f;
        goto L17
    L8:
        r4 = getPaddingRight();
        goto L9
    L5:
        r3 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        this.mFirstLayout = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r1, View r2) {
        super.requestChildFocus(r1, r2);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.mCanSlide == false) goto L7;
        return;
    L7:
        if (r1 != this.mSlideableView) goto L9;
        boolean r3 = true;
    L10:
        this.mPreservedOpenState = r3;
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        int r0 = r7.getActionMasked();
        if (this.mCanSlide == true) goto L11;
        if (r0 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r1 = getChildAt(1);
        if (r1 == null) goto L11;
        this.mPreservedOpenState = this.mDragHelper.isViewUnder(r1, (int) r7.getX(), (int) r7.getY());
    L11:
        if (this.mCanSlide == true) goto L13;
    L44:
        this.mDragHelper.cancel();
        return super.onInterceptTouchEvent(r7);
    L13:
        if (this.mIsUnableToDrag == false) goto L17;
        if (r0 != 0) goto L44;
    L17:
        if (r0 == 3) goto L42;
        if (r0 == 1) goto L42;
        if (r0 != 0) goto L22;
        this.mIsUnableToDrag = false;
        float r2 = r7.getX();
        float r3 = r7.getY();
        this.mInitialMotionX = r2;
        this.mInitialMotionY = r3;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r2, (int) r3) == true) goto L33;
    L35:
        boolean r4 = false;
    L37:
        if (this.mDragHelper.shouldInterceptTouchEvent(r7) == true) goto L46;
        if (r4 == false) goto L41;
        return true;
    L41:
        return false;
    L46:
        return true;
    L33:
        if (isDimmed(this.mSlideableView) == false) goto L35;
        r4 = true;
        goto L37
    L22:
        if (r0 != 2) goto L35;
        float r5 = r7.getX();
        float r6 = r7.getY();
        float r8 = Math.abs(r5 - this.mInitialMotionX);
        float r9 = Math.abs(r6 - this.mInitialMotionY);
        if (r8 <= this.mDragHelper.getTouchSlop()) goto L35;
        if (r9 <= r8) goto L35;
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
    L42:
        this.mDragHelper.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (this.mCanSlide == false) goto L5;
        this.mDragHelper.processTouchEvent(r6);
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L11;
    L18:
        return true;
    L11:
        if (isDimmed(this.mSlideableView) == false) goto L18;
        float r1 = r6.getX();
        float r7 = r6.getY();
        float r2 = r1 - this.mInitialMotionX;
        float r3 = r7 - this.mInitialMotionY;
        int r4 = this.mDragHelper.getTouchSlop();
        if (((r2 * r2) + (r3 * r3)) >= (r4 * r4)) goto L18;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) r1, (int) r7) == false) goto L18;
        closePane(0);
        goto L18
    L17:
        float r5 = r6.getX();
        float r8 = r6.getY();
        this.mInitialMotionX = r5;
        this.mInitialMotionY = r8;
        goto L18
    L5:
        return super.onTouchEvent(r6);
    }

    private boolean closePane(int r3) {
        if (this.mCanSlide == true) goto L6;
        this.mPreservedOpenState = false;
    L6:
        if (this.mFirstLayout == false) goto L8;
    L11:
        this.mPreservedOpenState = false;
        return true;
    L8:
        if (smoothSlideTo(1.0f, r3) == true) goto L11;
        return false;
    }

    private boolean openPane(int r3) {
        if (this.mCanSlide == true) goto L6;
        this.mPreservedOpenState = true;
    L6:
        if (this.mFirstLayout == false) goto L8;
    L12:
        this.mPreservedOpenState = true;
        return true;
    L8:
        if (smoothSlideTo(0.0f, r3) == true) goto L12;
        return false;
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openPane();
    }

    public boolean openPane() {
        return openPane(0);
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closePane();
    }

    public boolean closePane() {
        return closePane(0);
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        if (this.mCanSlide == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mSlideOffset == 0.0f) goto L8;
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    void onPanelDragged(int r5) {
        if (this.mSlideableView != null) goto L6;
        this.mSlideOffset = 0.0f;
        return;
    L6:
        boolean r0 = isLayoutRtlSupport();
        LayoutParams r1 = (LayoutParams) this.mSlideableView.getLayoutParams();
        int r2 = this.mSlideableView.getWidth();
        if (r0 == false) goto L9;
        r5 = (getWidth() - r5) - r2;
    L9:
        if (r0 == false) goto L11;
        int r3 = getPaddingRight();
    L12:
        if (r0 == false) goto L14;
        int r4 = r1.rightMargin;
    L15:
        float r6 = (r5 - (r3 + r4)) / this.mSlideRange;
        this.mSlideOffset = r6;
        if (this.mParallaxBy == 0) goto L18;
        parallaxOtherViews(r6);
    L18:
        dispatchOnPanelSlide(this.mSlideableView);
        return;
    L14:
        r4 = r1.leftMargin;
        goto L15
    L11:
        r3 = getPaddingLeft();
        goto L12
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r5, View r6, long r7) {
        if ((isLayoutRtlSupport() ^ isOpen()) == false) goto L7;
        this.mDragHelper.setEdgeTrackingEnabled(1);
        Insets r0 = getSystemGestureInsets();
        if (r0 == null) goto L10;
        ViewDragHelper r1 = this.mDragHelper;
        r1.setEdgeSize(Math.max(r1.getDefaultEdgeSize(), r0.left));
    L10:
        LayoutParams r2 = (LayoutParams) r6.getLayoutParams();
        int r3 = r5.save();
        if (this.mCanSlide == true) goto L13;
    L21:
        boolean r4 = super.drawChild(r5, r6, r7);
        r5.restoreToCount(r3);
        return r4;
    L13:
        if (r2.slideable == true) goto L21;
        if (this.mSlideableView == null) goto L21;
        r5.getClipBounds(this.mTmpRect);
        if (isLayoutRtlSupport() == false) goto L19;
        Rect r8 = this.mTmpRect;
        r8.left = Math.max(r8.left, this.mSlideableView.getRight());
    L20:
        r5.clipRect(this.mTmpRect);
        goto L21
    L19:
        Rect r9 = this.mTmpRect;
        r9.right = Math.min(r9.right, this.mSlideableView.getLeft());
        goto L20
    L7:
        this.mDragHelper.setEdgeTrackingEnabled(2);
        Insets r10 = getSystemGestureInsets();
        if (r10 == null) goto L10;
        ViewDragHelper r11 = this.mDragHelper;
        r11.setEdgeSize(Math.max(r11.getDefaultEdgeSize(), r10.right));
        goto L10
    }

    private Insets getSystemGestureInsets() {
        if (sEdgeSizeUsingSystemGestureInsets == false) goto L7;
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(this);
        if (r1 == null) goto L7;
        return r1.getSystemGestureInsets();
    L7:
        return null;
    }

    void invalidateChildRegion(View r1) {
        ViewCompat.setLayerPaint(r1, ((LayoutParams) r1.getLayoutParams()).dimPaint);
    }

    boolean smoothSlideTo(float r5, int r6) {
        if (this.mCanSlide == true) goto L5;
        return false;
    L5:
        boolean r7 = isLayoutRtlSupport();
        LayoutParams r1 = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (r7 == false) goto L8;
        int r8 = getPaddingRight() + r1.rightMargin;
        int r9 = (int) (getWidth() - ((r8 + (r5 * this.mSlideRange)) + this.mSlideableView.getWidth()));
    L9:
        ViewDragHelper r10 = this.mDragHelper;
        View r2 = this.mSlideableView;
        if (r10.smoothSlideViewTo(r2, r9, r2.getTop()) == false) goto L13;
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    L13:
        return false;
    L8:
        r9 = (int) ((getPaddingLeft() + r1.leftMargin) + (r5 * this.mSlideRange));
        goto L9
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true) == true) goto L5;
        return;
    L5:
        if (this.mCanSlide == true) goto L8;
        this.mDragHelper.abort();
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Deprecated
    public void setShadowDrawable(Drawable r1) {
        setShadowDrawableLeft(r1);
    }

    public void setShadowDrawableLeft(Drawable r1) {
        this.mShadowDrawableLeft = r1;
    }

    public void setShadowDrawableRight(Drawable r1) {
        this.mShadowDrawableRight = r1;
    }

    @Deprecated
    public void setShadowResource(int r2) {
        setShadowDrawableLeft(getResources().getDrawable(r2));
    }

    public void setShadowResourceLeft(int r2) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), r2));
    }

    public void setShadowResourceRight(int r2) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), r2));
    }

    @Override // android.view.View
    public void draw(Canvas r6) {
        super.draw(r6);
        if (isLayoutRtlSupport() == false) goto L5;
        Drawable r0 = this.mShadowDrawableRight;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r1 = getChildAt(1);
    L10:
        if (r1 == null) goto L19;
        if (r0 == null) goto L20;
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        int r4 = r0.getIntrinsicWidth();
        if (isLayoutRtlSupport() == false) goto L16;
        int r5 = r1.getRight();
        int r7 = r4 + r5;
    L17:
        r0.setBounds(r5, r2, r7, r3);
        r0.draw(r6);
        return;
    L16:
        int r8 = r1.getLeft();
        int r9 = r8 - r4;
        r7 = r8;
        r5 = r9;
        goto L17
    L20:
        return;
    L19:
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = this.mShadowDrawableLeft;
        goto L7
    }

    private void parallaxOtherViews(float r9) {
        boolean r0 = isLayoutRtlSupport();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        View r3 = getChildAt(r2);
        if (r3 == this.mSlideableView) goto L11;
        float r4 = 1.0f - this.mParallaxOffset;
        int r6 = this.mParallaxBy;
        this.mParallaxOffset = r9;
        int r5 = ((int) (r4 * r6)) - ((int) ((1.0f - r9) * r6));
        if (r0 == false) goto L10;
        r5 = -r5;
    L10:
        r3.offsetLeftAndRight(r5);
    L11:
        r2 = r2 + 1;
        goto L3
    }

    protected boolean canScroll(View r13, boolean r14, int r15, int r16, int r17) {
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) r13;
        int r3 = r13.getScrollX();
        int r4 = r13.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r16 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r17 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (canScroll(r7, true, r15, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r14 == true) goto L20;
    L26:
        return false;
    L20:
        if (isLayoutRtlSupport() == false) goto L22;
        int r2 = r15;
    L24:
        if (r13.canScrollHorizontally(r2) == false) goto L26;
        return true;
    L22:
        r2 = -r15;
        goto L24
    }

    boolean isDimmed(View r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        if (this.mCanSlide == true) goto L8;
        return false;
    L8:
        if (r4.dimWhenOffset == true) goto L10;
        return false;
    L10:
        if (this.mSlideOffset <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L6:
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        if (isSlideable() == false) goto L5;
        boolean r0 = isOpen();
    L6:
        r1.isOpen = r0;
        r1.mLockMode = this.mLockMode;
        return r1;
    L5:
        r0 = this.mPreservedOpenState;
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        if (r3.isOpen == false) goto L9;
        openPane();
    L10:
        this.mPreservedOpenState = r3.isOpen;
        setLockMode(r3.mLockMode);
        return;
    L9:
        closePane();
        goto L10
    }

    boolean isLayoutRtlSupport() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private ArrayList<Rect> splitViewPositions() {
        FoldingFeature r0 = this.mFoldingFeature;
        if (r0 != null) goto L5;
    L17:
        return null;
    L5:
        if (r0.isSeparating() == false) goto L17;
        if (this.mFoldingFeature.getBounds().left != 0) goto L11;
        return null;
    L11:
        if (this.mFoldingFeature.getBounds().top != 0) goto L17;
        Rect r1 = getFoldBoundsInView(this.mFoldingFeature, this);
        if (r1 != null) goto L15;
        return null;
    L15:
        Rect r2 = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), r1.left), getHeight() - getPaddingBottom());
        int r3 = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(new Rect[]{r2, new Rect(Math.min(r3, r1.right), getPaddingTop(), r3, getHeight() - getPaddingBottom())}));
    }

    private static Rect getFoldBoundsInView(FoldingFeature r8, View r9) {
        int[] r0 = new int[2];
        r9.getLocationInWindow(r0);
        int r3 = r0[0];
        Rect r1 = new Rect(r3, r0[1], r9.getWidth() + r3, r0[1] + r9.getWidth());
        Rect r10 = new Rect(r8.getBounds());
        boolean r11 = r10.intersect(r1);
        if (r10.width() == 0) goto L5;
    L6:
        if (r11 == false) goto L11;
        r10.offset(-r0[0], -r0[1]);
        return r10;
    L11:
        return null;
    L5:
        if (r10.height() != 0) goto L6;
        return null;
    }

    private static Activity getActivityOrNull(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L9:
        return null;
    }
}
