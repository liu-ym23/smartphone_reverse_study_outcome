package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        void onLayout(View r1) {
        }

        public abstract void onSlide(View r1, float r2);

        public abstract void onStateChanged(View r1, int r2);

        public BottomSheetCallback() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            this.state = r3.readInt();
            this.peekHeight = r3.readInt();
            boolean r0 = false;
            if (r3.readInt() != 1) goto L5;
            boolean r5 = true;
        L6:
            this.fitToContents = r5;
            if (r3.readInt() != 1) goto L9;
            boolean r6 = true;
        L10:
            this.hideable = r6;
            if (r3.readInt() != 1) goto L13;
            r0 = true;
        L13:
            this.skipCollapsed = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r1, BottomSheetBehavior<?> r2) {
            super(r1);
            this.state = r2.state;
            this.peekHeight = BottomSheetBehavior.access$1900(r2);
            this.fitToContents = BottomSheetBehavior.access$1400(r2);
            this.hideable = r2.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$2000(r2);
        }

        @Deprecated
        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.state = r2;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
            r1.writeInt(this.peekHeight);
            r1.writeInt(this.fitToContents ? 1 : 0);
            r1.writeInt(this.hideable ? 1 : 0);
            r1.writeInt(this.skipCollapsed ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;

        private StateSettlingTracker(BottomSheetBehavior r1) {
            this.this$0 = r1;
            this.continueSettlingRunnable = new AnonymousClass1(this);
        }

        /* synthetic */ StateSettlingTracker(BottomSheetBehavior r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean access$1702(StateSettlingTracker r0, boolean r1) {
            r0.isContinueSettlingRunnablePosted = r1;
            return r1;
        }

        static /* synthetic */ int access$1800(StateSettlingTracker r0) {
            return r0.targetState;
        }

        void continueSettlingToState(int r2) {
            if (this.this$0.viewRef != null) goto L5;
            return;
        L5:
            if (this.this$0.viewRef.get() == null) goto L13;
            this.targetState = r2;
            if (this.isContinueSettlingRunnablePosted == true) goto L12;
            ViewCompat.postOnAnimation(this.this$0.viewRef.get(), this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
            return;
        L12:
            return;
        }
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
    }

    public boolean shouldExpandOnUpwardDrag(long r1, float r3) {
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    static /* synthetic */ void access$100(BottomSheetBehavior r0, View r1, int r2, boolean r3) {
        r0.startSettling(r1, r2, r3);
    }

    static /* synthetic */ boolean access$1000(BottomSheetBehavior r0) {
        return r0.marginTopSystemWindowInsets;
    }

    static /* synthetic */ int access$1102(BottomSheetBehavior r0, int r1) {
        r0.gestureInsetBottom = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(BottomSheetBehavior r0, boolean r1) {
        r0.updatePeekHeight(r1);
    }

    static /* synthetic */ boolean access$1300(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    static /* synthetic */ boolean access$1400(BottomSheetBehavior r0) {
        return r0.fitToContents;
    }

    static /* synthetic */ int access$1500(BottomSheetBehavior r0) {
        return r0.significantVelocityThreshold;
    }

    static /* synthetic */ boolean access$1600(BottomSheetBehavior r0) {
        return r0.canBeHiddenByDragging();
    }

    static /* synthetic */ int access$1900(BottomSheetBehavior r0) {
        return r0.peekHeight;
    }

    static /* synthetic */ MaterialShapeDrawable access$200(BottomSheetBehavior r0) {
        return r0.materialShapeDrawable;
    }

    static /* synthetic */ boolean access$2000(BottomSheetBehavior r0) {
        return r0.skipCollapsed;
    }

    static /* synthetic */ int access$302(BottomSheetBehavior r0, int r1) {
        r0.insetTop = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(BottomSheetBehavior r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$500(BottomSheetBehavior r0) {
        return r0.insetBottom;
    }

    static /* synthetic */ int access$502(BottomSheetBehavior r0, int r1) {
        r0.insetBottom = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600(BottomSheetBehavior r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$700(BottomSheetBehavior r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ boolean access$800(BottomSheetBehavior r0) {
        return r0.marginLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$900(BottomSheetBehavior r0) {
        return r0.marginRightSystemWindowInsets;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new AnonymousClass4(this);
    }

    public BottomSheetBehavior(Context r9, AttributeSet r10) {
        super(r9, r10);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new AnonymousClass4(this);
        this.peekHeightGestureInsetBuffer = r9.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray r5 = r9.obtainStyledAttributes(r10, R.styleable.BottomSheetBehavior_Layout);
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint) == false) goto L6;
        this.backgroundTint = MaterialResources.getColorStateList(r9, r5, R.styleable.BottomSheetBehavior_Layout_backgroundTint);
    L6:
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance) == false) goto L8;
        this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(r9, r10, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
    L8:
        createMaterialShapeDrawableIfNeeded(r9);
        createShapeValueAnimator();
        this.elevation = r5.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth) == false) goto L12;
        setMaxWidth(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
    L12:
        if (r5.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxHeight) == false) goto L14;
        setMaxHeight(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
    L14:
        TypedValue r11 = r5.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r11 != null) goto L17;
    L19:
        setPeekHeight(r5.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    L20:
        setHideable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r5.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r5.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue r12 = r5.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (r12 != null) goto L23;
    L25:
        setExpandedOffset(r5.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
    L26:
        setSignificantVelocityThreshold(r5.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        r5.recycle();
        this.maximumVelocity = ViewConfiguration.get(r9).getScaledMaximumFlingVelocity();
        return;
    L23:
        if (r12.type != 16) goto L25;
        setExpandedOffset(r12.data);
        goto L26
    L17:
        if (r11.data != (-1)) goto L19;
        setPeekHeight(r11.data);
        goto L20
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        restoreOptionalState(r5);
        if (r5.state != 1) goto L5;
    L8:
        this.state = 4;
        this.lastStableState = 4;
        return;
    L5:
        if (r5.state == 2) goto L8;
        int r6 = r5.state;
        this.state = r6;
        this.lastStableState = r6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
        super.onAttachedToLayoutParams(r1);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout r4, V r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        r5.measure(getChildMeasureSpec(r6, (((r4.getPaddingLeft() + r4.getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r7, this.maxWidth, r0.width), getChildMeasureSpec(r8, (((r4.getPaddingTop() + r4.getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r9, this.maxHeight, r0.height));
        return true;
    }

    private int getChildMeasureSpec(int r1, int r2, int r3, int r4) {
        int r0 = ViewGroup.getChildMeasureSpec(r1, r2, r4);
        if (r3 != (-1)) goto L5;
        return r0;
    L5:
        int r5 = View.MeasureSpec.getMode(r0);
        int r6 = View.MeasureSpec.getSize(r0);
        if (r5 == 1073741824) goto L13;
        if (r6 == 0) goto L11;
        r3 = Math.min(r6, r3);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r6, r3), 1073741824);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r5, V r6, int r7) {
        if (ViewCompat.getFitsSystemWindows(r5) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r6) == true) goto L8;
        r6.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L22;
        this.peekHeightMin = r5.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        setWindowInsetsListener(r6);
        ViewCompat.setWindowInsetsAnimationCallback(r6, new InsetsAnimationCallback(r6));
        this.viewRef = new WeakReference(r6);
        MaterialShapeDrawable r0 = this.materialShapeDrawable;
        if (r0 == null) goto L15;
        ViewCompat.setBackground(r6, r0);
        MaterialShapeDrawable r1 = this.materialShapeDrawable;
        float r2 = this.elevation;
        if (r2 != (-1.0f)) goto L14;
        r2 = ViewCompat.getElevation(r6);
    L14:
        r1.setElevation(r2);
    L18:
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r6) != 0) goto L22;
        ViewCompat.setImportantForAccessibility(r6, 1);
        goto L22
    L15:
        ColorStateList r3 = this.backgroundTint;
        if (r3 == null) goto L18;
        ViewCompat.setBackgroundTintList(r6, r3);
    L22:
        if (this.viewDragHelper != null) goto L24;
        this.viewDragHelper = ViewDragHelper.create(r5, this.dragCallback);
    L24:
        int r4 = r6.getTop();
        r5.onLayoutChild(r6, r7);
        this.parentWidth = r5.getWidth();
        this.parentHeight = r5.getHeight();
        int r8 = r6.getHeight();
        this.childHeight = r8;
        int r9 = this.parentHeight;
        int r10 = r9 - r8;
        int r11 = this.insetTop;
        if (r10 < r11) goto L27;
    L30:
        int r12 = r9 - this.childHeight;
        int r13 = 0;
        this.fitToContentsOffset = Math.max(0, r12);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r14 = this.state;
        if (r14 != 3) goto L34;
        ViewCompat.offsetTopAndBottom(r6, getExpandedOffset());
    L48:
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r6));
    L50:
        if (r13 >= this.callbacks.size()) goto L52;
        this.callbacks.get(r13).onLayout(r6);
        r13 = r13 + 1;
        goto L50
    L52:
        return true;
    L34:
        if (r14 != 6) goto L37;
        ViewCompat.offsetTopAndBottom(r6, this.halfExpandedOffset);
        goto L48
    L37:
        if (this.hideable == false) goto L42;
        if (r14 != 5) goto L42;
        ViewCompat.offsetTopAndBottom(r6, this.parentHeight);
    L42:
        if (r14 != 4) goto L44;
        ViewCompat.offsetTopAndBottom(r6, this.collapsedOffset);
        goto L48
    L44:
        if (r14 != 1) goto L46;
    L47:
        ViewCompat.offsetTopAndBottom(r6, r4 - r6.getTop());
        goto L48
    L46:
        if (r14 != 2) goto L48;
    L27:
        if (this.paddingTopSystemWindowInsets == false) goto L29;
        this.childHeight = r9;
        goto L30
    L29:
        this.childHeight = r9 - r11;
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r0 = r12.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r3 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        ViewDragHelper r13 = this.viewDragHelper;
        if (r13 == null) goto L47;
        if (r13.shouldInterceptTouchEvent(r12) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r14 = this.nestedScrollingChildRef;
        if (r14 == null) goto L50;
        r3 = r14.get();
    L50:
        if (r0 != 2) goto L66;
        if (r3 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r10.isPointInChildBounds(r3, (int) r12.getX(), (int) r12.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r12.getY()) > this.viewDragHelper.getTouchSlop()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r6 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 == null) goto L28;
        View r8 = r7.get();
    L29:
        if (r8 == null) goto L34;
        if (r10.isPointInChildBounds(r8, r6, this.initialY) == false) goto L34;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r8 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r15 = false;
    L39:
        this.ignoreEvents = r15;
        goto L41
    L36:
        if (r10.isPointInChildBounds(r11, r6, this.initialY) == true) goto L38;
        r15 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r3, V r4, MotionEvent r5) {
        if (r4.isShown() == true) goto L6;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (this.state != 1) goto L11;
        if (r6 != 0) goto L11;
        return true;
    L11:
        if (shouldHandleDraggingWithHelper() == false) goto L13;
        this.viewDragHelper.processTouchEvent(r5);
    L13:
        if (r6 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r5);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r6 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r5.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r4, r5.getPointerId(r5.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r9 = this.nestedScrollingChildRef;
        if (r9 == null) goto L8;
        View r10 = r9.get();
    L10:
        if (isNestedScrollingCheckEnabled() == false) goto L13;
        if (r4 == r10) goto L13;
        return;
    L13:
        int r11 = r3.getTop();
        int r12 = r11 - r6;
        if (r6 > 0) goto L16;
        if (r6 < 0) goto L24;
    L35:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L24:
        if (r4.canScrollVertically(-1) == true) goto L35;
        if (r12 <= this.collapsedOffset) goto L32;
        if (canBeHiddenByDragging() == true) goto L32;
        int r13 = r11 - this.collapsedOffset;
        r7[1] = r13;
        ViewCompat.offsetTopAndBottom(r3, -r13);
        setStateInternal(4);
    L32:
        if (this.draggable == true) goto L34;
        return;
    L34:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L35
    L16:
        if (r12 >= getExpandedOffset()) goto L19;
        int r14 = r11 - getExpandedOffset();
        r7[1] = r14;
        ViewCompat.offsetTopAndBottom(r3, -r14);
        setStateInternal(3);
        goto L35
    L19:
        if (this.draggable == true) goto L21;
        return;
    L21:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L35
    L8:
        r10 = null;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r3, V r4, View r5, int r6) {
        int r0 = 3;
        if (r4.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (isNestedScrollingCheckEnabled() == false) goto L16;
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r5 == r7.get()) goto L13;
        return;
    L13:
        if (this.nestedScrolled == true) goto L16;
        return;
    L16:
        if (this.lastNestedScrollDy <= 0) goto L24;
        if (this.fitToContents == false) goto L21;
    L52:
        startSettling(r4, r0, false);
        this.nestedScrolled = false;
        return;
    L21:
        if (r4.getTop() <= this.halfExpandedOffset) goto L52;
    L51:
        r0 = 6;
        goto L52
    L24:
        if (this.hideable == false) goto L29;
        if (shouldHide(r4, getYVelocity()) == false) goto L29;
        r0 = 5;
    L29:
        if (this.lastNestedScrollDy != 0) goto L47;
        int r8 = r4.getTop();
        if (this.fitToContents == true) goto L33;
        int r1 = this.halfExpandedOffset;
        if (r8 >= r1) goto L44;
        if (r8 < Math.abs(r8 - this.collapsedOffset)) goto L52;
        if (shouldSkipHalfExpandedStateWhenDragging() == false) goto L51;
    L48:
        r0 = 4;
        goto L52
    L44:
        if (Math.abs(r8 - r1) >= Math.abs(r8 - this.collapsedOffset)) goto L48;
    L33:
        if (Math.abs(r8 - this.fitToContentsOffset) >= Math.abs(r8 - this.collapsedOffset)) goto L48;
    L47:
        if (this.fitToContents == true) goto L48;
        int r9 = r4.getTop();
        if (Math.abs(r9 - this.halfExpandedOffset) >= Math.abs(r9 - this.collapsedOffset)) goto L48;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r4, V r5, View r6, float r7, float r8) {
        if (isNestedScrollingCheckEnabled() == false) goto L14;
        WeakReference<View> r0 = this.nestedScrollingChildRef;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r6 == r0.get()) goto L9;
        return false;
    L9:
        if (this.state == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.onNestedPreFling(r4, r5, r6, r7, r8) == true) goto L12;
        return false;
    L14:
        return false;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean r2) {
        if (this.fitToContents != r2) goto L5;
        return;
    L5:
        this.fitToContents = r2;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r3 = this.state;
    L14:
        setStateInternal(r3);
        updateDrawableForTargetState(this.state, true);
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void setMaxWidth(int r1) {
        this.maxWidth = r1;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxHeight(int r1) {
        this.maxHeight = r1;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setPeekHeight(int r2) {
        setPeekHeight(r2, false);
    }

    public final void setPeekHeight(int r4, boolean r5) {
        boolean r1 = true;
        if (r4 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r1 == false) goto L17;
        updatePeekHeight(r5);
        return;
    L17:
        return;
    L12:
        r1 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r4);
        goto L14
    L10:
        if (this.peekHeight == r4) goto L12;
        goto L12
    }

    private void updatePeekHeight(boolean r3) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r0 = this.viewRef.get();
        if (r0 == null) goto L14;
        if (r3 == false) goto L10;
        setState(4);
        return;
    L10:
        r0.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    public void setHalfExpandedRatio(float r2) {
        if (r2 <= 0.0f) goto L11;
        if (r2 >= 1.0f) goto L11;
        this.halfExpandedRatio = r2;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int r2) {
        if (r2 < 0) goto L6;
        this.expandedOffset = r2;
        updateDrawableForTargetState(this.state, true);
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r0 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r2 = 0;
    L10:
        return Math.max(r0, r2);
    L8:
        r2 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    public float calculateSlideOffset() {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return -1.0f;
    L5:
        if (r0.get() != null) goto L8;
        return -1.0f;
    L8:
        return calculateSlideOffsetWithTop(this.viewRef.get().getTop());
    }

    public void setHideable(boolean r2) {
        if (this.hideable == r2) goto L11;
        this.hideable = r2;
        if (r2 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean r1) {
        this.skipCollapsed = r1;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setSignificantVelocityThreshold(int r1) {
        this.significantVelocityThreshold = r1;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public void setSaveFlags(int r1) {
        this.saveFlags = r1;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public void setHideFriction(float r1) {
        this.hideFriction = r1;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback r3) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r3 == null) goto L6;
        this.callbacks.add(r3);
        return;
    }

    public void addBottomSheetCallback(BottomSheetCallback r2) {
        if (this.callbacks.contains(r2) == true) goto L6;
        this.callbacks.add(r2);
        return;
    }

    public void removeBottomSheetCallback(BottomSheetCallback r1) {
        this.callbacks.remove(r1);
    }

    public void setState(int r4) {
        if (r4 != 1) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder("STATE_");
        if (r4 != 1) goto L32;
        String r5 = "DRAGGING";
    L34:
        throw new IllegalArgumentException(r1.append(r5).append(" should not be set externally.").toString());
    L32:
        r5 = "SETTLING";
        goto L34
    L5:
        if (r4 == 2) goto L29;
        if (this.hideable == true) goto L14;
        if (r4 != 5) goto L14;
        Log.w(TAG, "Cannot set state: " + r4);
        return;
    L14:
        if (r4 == 6) goto L16;
    L20:
        final int r0 = r4;
    L21:
        WeakReference<V> r2 = this.viewRef;
        if (r2 != null) goto L24;
    L27:
        setStateInternal(r4);
        return;
    L24:
        if (r2.get() == null) goto L27;
        final V r6 = this.viewRef.get();
        runAfterLayout(r6, new AnonymousClass1(this, r6, r0));
        return;
    L16:
        if (this.fitToContents == false) goto L20;
        if (getTopOffsetForState(r4) > this.fitToContentsOffset) goto L20;
        r0 = 3;
        goto L21
    }

    private void runAfterLayout(V r1, Runnable r2) {
        if (isLayouting(r1) == false) goto L5;
        r1.post(r2);
        return;
    L5:
        r2.run();
    }

    private boolean isLayouting(V r1) {
        ViewParent r0 = r1.getParent();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L9;
        return true;
    }

    public void setGestureInsetBottomIgnored(boolean r1) {
        this.gestureInsetBottomIgnored = r1;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public int getState() {
        return this.state;
    }

    void setStateInternal(int r8) {
        if (this.state != r8) goto L5;
        return;
    L5:
        this.state = r8;
        if (r8 == 4) goto L12;
        if (r8 == 3) goto L12;
        if (r8 == 6) goto L12;
        if (this.hideable == false) goto L13;
        if (r8 == 5) goto L12;
    L13:
        WeakReference<V> r4 = this.viewRef;
        if (r4 != null) goto L16;
        return;
    L16:
        V r5 = r4.get();
        if (r5 != null) goto L19;
        return;
    L19:
        int r6 = 0;
        if (r8 != 3) goto L22;
        updateImportantForAccessibility(true);
    L26:
        updateDrawableForTargetState(r8, true);
    L28:
        if (r6 >= this.callbacks.size()) goto L30;
        this.callbacks.get(r6).onStateChanged(r5, r8);
        r6 = r6 + 1;
        goto L28
    L30:
        updateAccessibilityActions();
        return;
    L22:
        if (r8 == 6) goto L25;
        if (r8 == 5) goto L25;
        if (r8 != 4) goto L26;
    L25:
        updateImportantForAccessibility(false);
    L12:
        this.lastStableState = r8;
        goto L13
    }

    private void updateDrawableForTargetState(int r4, boolean r5) {
        if (r4 != 2) goto L5;
        return;
    L5:
        boolean r6 = isExpandedAndShouldRemoveCorners();
        if (this.expandedCornersRemoved != r6) goto L8;
        return;
    L8:
        if (this.materialShapeDrawable == null) goto L35;
        this.expandedCornersRemoved = r6;
        float r1 = 0.0f;
        if (r5 == false) goto L21;
        ValueAnimator r7 = this.interpolatorAnimator;
        if (r7 == null) goto L21;
        if (r7.isRunning() == false) goto L17;
        this.interpolatorAnimator.reverse();
        return;
    L17:
        if (r6 == true) goto L20;
        r1 = 1.0f;
    L20:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r1, r1});
        this.interpolatorAnimator.start();
        return;
    L21:
        ValueAnimator r8 = this.interpolatorAnimator;
        if (r8 != null) goto L24;
    L26:
        MaterialShapeDrawable r9 = this.materialShapeDrawable;
        if (this.expandedCornersRemoved == true) goto L30;
        r1 = 1.0f;
    L30:
        r9.setInterpolation(r1);
        return;
    L24:
        if (r8.isRunning() == false) goto L26;
        this.interpolatorAnimator.cancel();
        goto L26
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state == 3) goto L5;
    L9:
        return false;
    L5:
        if (this.shouldRemoveExpandedCorners == false) goto L7;
    L8:
        return true;
    L7:
        if (getExpandedOffset() != 0) goto L9;
        goto L8
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r0 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
        int r3 = this.insetBottom;
    L6:
        return r0 + r3;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r0 = this.peekHeight;
        r3 = this.insetBottom;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r1 = this.gestureInsetBottom;
        if (r1 <= 0) goto L15;
        return Math.max(this.peekHeight, r1 + this.peekHeightGestureInsetBuffer);
    }

    private void calculateCollapsedOffset() {
        int r0 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r0, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r0;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private float calculateSlideOffsetWithTop(int r3) {
        int r0 = this.collapsedOffset;
        if (r3 <= r0) goto L5;
    L8:
        int r1 = this.collapsedOffset;
        float r4 = r1 - r3;
        float r2 = this.parentHeight - r1;
    L10:
        return r4 / r2;
    L5:
        if (r0 == getExpandedOffset()) goto L8;
        int r5 = this.collapsedOffset;
        r4 = r5 - r3;
        r2 = r5 - getExpandedOffset();
        goto L10
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(SavedState r4) {
        int r0 = this.saveFlags;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != (-1)) goto L8;
    L9:
        this.peekHeight = r4.peekHeight;
    L10:
        int r1 = this.saveFlags;
        if (r1 != (-1)) goto L13;
    L14:
        this.fitToContents = r4.fitToContents;
    L15:
        int r2 = this.saveFlags;
        if (r2 != (-1)) goto L18;
    L19:
        this.hideable = r4.hideable;
    L20:
        int r3 = this.saveFlags;
        if (r3 != (-1)) goto L23;
    L24:
        this.skipCollapsed = r4.skipCollapsed;
        return;
    L23:
        if ((r3 & 8) == 8) goto L24;
        return;
    L18:
        if ((r2 & 4) != 4) goto L20;
    L13:
        if ((r1 & 2) != 2) goto L15;
    L8:
        if ((r0 & 1) != 1) goto L10;
        goto L9
    }

    boolean shouldHide(View r5, float r6) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (isHideableWhenDragging() == true) goto L9;
        return false;
    L9:
        if (r5.getTop() >= this.collapsedOffset) goto L12;
        return false;
    L12:
        if ((Math.abs((r5.getTop() + (r6 * this.hideFriction)) - this.collapsedOffset) / calculatePeekHeight()) <= 0.5f) goto L15;
        return true;
    L15:
        return false;
    }

    View findScrollingChild(View r5) {
        if (r5.getVisibility() == 0) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r6 = (ViewGroup) r5;
        int r0 = r6.getChildCount();
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L16;
        View r3 = findScrollingChild(r6.getChildAt(r2));
        if (r3 != null) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    L16:
        return null;
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) goto L5;
    L9:
        return false;
    L5:
        if (this.draggable == false) goto L7;
        return true;
    L7:
        if (this.state != 1) goto L9;
        return true;
    }

    private void createMaterialShapeDrawableIfNeeded(Context r4) {
        if (this.shapeAppearanceModelDefault != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = r0;
        r0.initializeElevationOverlay(r4);
        ColorStateList r1 = this.backgroundTint;
        if (r1 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r1);
        return;
    L8:
        TypedValue r2 = new TypedValue();
        r4.getTheme().resolveAttribute(android.R.attr.colorBackground, r2, true);
        this.materialShapeDrawable.setTint(r2.data);
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    private void createShapeValueAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r0;
        r0.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass2(this));
    }

    private void setWindowInsetsListener(View r3) {
        if (isGestureInsetBottomIgnored() == false) goto L5;
    L7:
        final boolean r0 = false;
    L9:
        if (this.paddingBottomSystemWindowInsets == false) goto L11;
    L22:
        ViewUtils.doOnApplyWindowInsets(r3, new AnonymousClass3(this, r0));
        return;
    L11:
        if (this.paddingLeftSystemWindowInsets == true) goto L22;
        if (this.paddingRightSystemWindowInsets == true) goto L22;
        if (this.marginLeftSystemWindowInsets == true) goto L22;
        if (this.marginRightSystemWindowInsets == true) goto L22;
        if (this.marginTopSystemWindowInsets == true) goto L22;
        if (r0 == true) goto L22;
        return;
    L5:
        if (this.peekHeightAuto == true) goto L7;
        r0 = true;
        goto L9
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void startSettling(View r4, int r5, boolean r6) {
        int r0 = getTopOffsetForState(r5);
        ViewDragHelper r1 = this.viewDragHelper;
        if (r1 == null) goto L11;
        if (r6 == false) goto L9;
        if (r1.settleCapturedViewAt(r4.getLeft(), r0) == false) goto L11;
    L10:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        setStateInternal(2);
        updateDrawableForTargetState(r5, true);
        this.stateSettlingTracker.continueSettlingToState(r5);
        return;
    L14:
        setStateInternal(r5);
        return;
    L9:
        if (r1.smoothSlideViewTo(r4, r4.getLeft(), r0) == true) goto L10;
    L11:
        r7 = false;
        goto L12
    }

    private int getTopOffsetForState(int r3) {
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L17;
        if (r3 == 5) goto L15;
        if (r3 != 6) goto L13;
        return this.halfExpandedOffset;
    L13:
        throw new IllegalArgumentException("Invalid state to get top offset: " + r3);
    L15:
        return this.parentHeight;
    L17:
        return this.collapsedOffset;
    L19:
        return getExpandedOffset();
    }

    void dispatchOnSlide(int r4) {
        V r0 = this.viewRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L12;
        float r5 = calculateSlideOffsetWithTop(r4);
        int r1 = 0;
    L8:
        if (r1 >= this.callbacks.size()) goto L13;
        this.callbacks.get(r1).onSlide(r0, r5);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    private boolean canBeHiddenByDragging() {
        if (isHideable() == true) goto L5;
    L7:
        return false;
    L5:
        if (isHideableWhenDragging() == false) goto L7;
        return true;
    }

    public void setHideableInternal(boolean r1) {
        this.hideable = r1;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) r2).getBehavior();
        if ((r3 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r3;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r1) {
        this.updateImportantForAccessibilityOnSiblings = r1;
    }

    private void updateImportantForAccessibility(boolean r7) {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.get().getParent();
        if ((r1 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r2 = (CoordinatorLayout) r1;
        int r3 = r2.getChildCount();
        if (r7 == true) goto L11;
    L14:
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L31;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.viewRef.get()) goto L30;
        if (r7 == false) goto L24;
        this.importantForAccessibilityMap.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        ViewCompat.setImportantForAccessibility(r5, 4);
        goto L30
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        Map<View, Integer> r6 = this.importantForAccessibilityMap;
        if (r6 == null) goto L30;
        if (r6.containsKey(r5) == false) goto L30;
        ViewCompat.setImportantForAccessibility(r5, this.importantForAccessibilityMap.get(r5).intValue());
    L30:
        r4 = r4 + 1;
        goto L15
    L31:
        if (r7 == true) goto L34;
        this.importantForAccessibilityMap = null;
        return;
    L34:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L46;
        this.viewRef.get().sendAccessibilityEvent(8);
        return;
    L46:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r3);
        goto L14
    }

    void setAccessibilityDelegateView(View r3) {
        if (r3 != null) goto L8;
        WeakReference<View> r1 = this.accessibilityDelegateViewRef;
        if (r1 == null) goto L8;
        clearAccessibilityAction(r1.get(), 1);
        this.accessibilityDelegateViewRef = null;
        return;
    L8:
        this.accessibilityDelegateViewRef = new WeakReference(r3);
        updateAccessibilityActions(r3, 1);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r0 = this.viewRef;
        if (r0 == null) goto L5;
        updateAccessibilityActions(r0.get(), 0);
    L5:
        WeakReference<View> r1 = this.accessibilityDelegateViewRef;
        if (r1 == null) goto L9;
        updateAccessibilityActions(r1.get(), 1);
        return;
    }

    private void updateAccessibilityActions(View r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        clearAccessibilityAction(r4, r5);
        int r1 = 6;
        if (this.fitToContents == true) goto L10;
        if (this.state == 6) goto L10;
        this.expandHalfwayActionIds.put(r5, addAccessibilityActionForState(r4, R.string.bottomsheet_action_expand_halfway, 6));
    L10:
        if (this.hideable == true) goto L12;
    L16:
        int r6 = this.state;
        if (r6 == 3) goto L27;
        if (r6 == 4) goto L23;
        if (r6 != 6) goto L33;
        replaceAccessibilityActionForState(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        replaceAccessibilityActionForState(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L33:
        return;
    L23:
        if (this.fitToContents == false) goto L25;
        r1 = 3;
    L25:
        replaceAccessibilityActionForState(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, r1);
        return;
    L27:
        if (this.fitToContents == false) goto L29;
        r1 = 4;
    L29:
        replaceAccessibilityActionForState(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, r1);
        return;
    L12:
        if (isHideableWhenDragging() == false) goto L16;
        if (this.state == 5) goto L16;
        replaceAccessibilityActionForState(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L16
    }

    private void clearAccessibilityAction(View r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewCompat.removeAccessibilityAction(r3, 524288);
        ViewCompat.removeAccessibilityAction(r3, 262144);
        ViewCompat.removeAccessibilityAction(r3, 1048576);
        int r0 = this.expandHalfwayActionIds.get(r4, -1);
        if (r0 == (-1)) goto L8;
        ViewCompat.removeAccessibilityAction(r3, r0);
        this.expandHalfwayActionIds.delete(r4);
        return;
    }

    private void replaceAccessibilityActionForState(View r2, AccessibilityNodeInfoCompat.AccessibilityActionCompat r3, int r4) {
        ViewCompat.replaceAccessibilityAction(r2, r3, null, createAccessibilityViewCommandForState(r4));
    }

    private int addAccessibilityActionForState(View r2, int r3, int r4) {
        return ViewCompat.addAccessibilityAction(r2, r2.getResources().getString(r3), createAccessibilityViewCommandForState(r4));
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r2) {
        return new AnonymousClass5(this, r2);
    }
}
