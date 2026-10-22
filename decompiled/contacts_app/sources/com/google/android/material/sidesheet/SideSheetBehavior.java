package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
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
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = 0;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    private ColorStateList backgroundTint;
    private final Set<SideSheetCallback> callbacks;
    private int childWidth;
    private int coplanarSiblingViewId;
    private WeakReference<View> coplanarSiblingViewRef;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    private float elevation;
    private float hideFriction;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    private SheetDelegate sheetDelegate;
    private int state;
    private final SideSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    private VelocityTracker velocityTracker;
    private ViewDragHelper viewDragHelper;
    private WeakReference<V> viewRef;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.state = r1.readInt();
        }

        public SavedState(Parcelable r1, SideSheetBehavior<?> r2) {
            super(r1);
            this.state = SideSheetBehavior.access$000(r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;
        final /* synthetic */ SideSheetBehavior this$0;

        StateSettlingTracker(SideSheetBehavior r1) {
            this.this$0 = r1;
            this.continueSettlingRunnable = new SideSheetBehavior$StateSettlingTracker$$ExternalSyntheticLambda0(this);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-sidesheet-SideSheetBehavior$StateSettlingTracker, reason: not valid java name */
        /* synthetic */ void m269xe5f914a3() {
            this.isContinueSettlingRunnablePosted = false;
            if (SideSheetBehavior.access$700(this.this$0) == null) goto L8;
            if (SideSheetBehavior.access$700(this.this$0).continueSettling(true) == false) goto L8;
            continueSettlingToState(this.targetState);
            return;
        L8:
            if (SideSheetBehavior.access$000(this.this$0) != 2) goto L12;
            this.this$0.setStateInternal(this.targetState);
            return;
        }

        void continueSettlingToState(int r2) {
            if (SideSheetBehavior.access$100(this.this$0) != null) goto L5;
            return;
        L5:
            if (SideSheetBehavior.access$100(this.this$0).get() == null) goto L13;
            this.targetState = r2;
            if (this.isContinueSettlingRunnablePosted == true) goto L12;
            ViewCompat.postOnAnimation((View) SideSheetBehavior.access$100(this.this$0).get(), this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
            return;
        L12:
            return;
        }
    }

    private int getDefaultSheetEdge() {
        return 0;
    }

    float getHideThreshold() {
        return 0.5f;
    }

    int getSignificantVelocityThreshold() {
        return 500;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    static /* synthetic */ int access$000(SideSheetBehavior r0) {
        return r0.state;
    }

    static /* synthetic */ WeakReference access$100(SideSheetBehavior r0) {
        return r0.viewRef;
    }

    static /* synthetic */ SheetDelegate access$200(SideSheetBehavior r0) {
        return r0.sheetDelegate;
    }

    static /* synthetic */ void access$300(SideSheetBehavior r0, View r1, int r2) {
        r0.dispatchOnSlide(r1, r2);
    }

    static /* synthetic */ boolean access$400(SideSheetBehavior r0) {
        return r0.draggable;
    }

    static /* synthetic */ void access$500(SideSheetBehavior r0, View r1, int r2, boolean r3) {
        r0.startSettling(r1, r2, r3);
    }

    static /* synthetic */ int access$600(SideSheetBehavior r0) {
        return r0.parentWidth;
    }

    static /* synthetic */ ViewDragHelper access$700(SideSheetBehavior r0) {
        return r0.viewDragHelper;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void addCallback(SheetCallback r1) {
        addCallback((SideSheetCallback) r1);
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void removeCallback(SheetCallback r1) {
        removeCallback((SideSheetCallback) r1);
    }

    static {
        DEFAULT_ACCESSIBILITY_PANE_TITLE = R.string.side_sheet_accessibility_pane_title;
        DEF_STYLE_RES = R.style.Widget_Material3_SideSheet;
    }

    public SideSheetBehavior() {
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this);
    }

    public SideSheetBehavior(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this);
        TypedArray r2 = r6.obtainStyledAttributes(r7, R.styleable.SideSheetBehavior_Layout);
        if (r2.hasValue(R.styleable.SideSheetBehavior_Layout_backgroundTint) == false) goto L6;
        this.backgroundTint = MaterialResources.getColorStateList(r6, r2, R.styleable.SideSheetBehavior_Layout_backgroundTint);
    L6:
        if (r2.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance) == false) goto L9;
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r6, r7, 0, DEF_STYLE_RES).build();
    L9:
        if (r2.hasValue(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId) == false) goto L11;
        setCoplanarSiblingViewId(r2.getResourceId(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1));
    L11:
        createMaterialShapeDrawableIfNeeded(r6);
        this.elevation = r2.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(r2.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        r2.recycle();
        setSheetEdge(getDefaultSheetEdge());
        this.maximumVelocity = ViewConfiguration.get(r6).getScaledMaximumFlingVelocity();
    }

    private void setSheetEdge(int r3) {
        SheetDelegate r0 = this.sheetDelegate;
        if (r0 != null) goto L5;
    L8:
        if (r3 != 0) goto L12;
        this.sheetDelegate = new RightSheetDelegate(this);
        return;
    L12:
        throw new IllegalArgumentException("Invalid sheet edge position value: " + r3 + ". Must be 0");
    L5:
        if (r0.getSheetEdge() != r3) goto L8;
    }

    public void expand() {
        setState(3);
    }

    public void hide() {
        setState(5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        if (r5.getSuperState() == null) goto L6;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
    L6:
        if (r5.state != 1) goto L8;
    L11:
        int r6 = 5;
    L12:
        this.state = r6;
        this.lastStableState = r6;
        return;
    L8:
        if (r5.state == 2) goto L11;
        r6 = r5.state;
        goto L12
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
        r5.measure(getChildMeasureSpec(r6, (((r4.getPaddingLeft() + r4.getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r7, -1, r0.width), getChildMeasureSpec(r8, (((r4.getPaddingTop() + r4.getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r9, -1, r0.height));
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
        if (this.viewRef != null) goto L23;
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
        updateSheetVisibility(r6);
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r6) != 0) goto L21;
        ViewCompat.setImportantForAccessibility(r6, 1);
    L21:
        ensureAccessibilityPaneTitleIsSet(r6);
        goto L23
    L15:
        ColorStateList r3 = this.backgroundTint;
        if (r3 == null) goto L18;
        ViewCompat.setBackgroundTintList(r6, r3);
    L23:
        if (this.viewDragHelper != null) goto L25;
        this.viewDragHelper = ViewDragHelper.create(r5, this.dragCallback);
    L25:
        int r4 = this.sheetDelegate.getOuterEdge(r6);
        r5.onLayoutChild(r6, r7);
        this.parentWidth = r5.getWidth();
        this.childWidth = r6.getWidth();
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r6.getLayoutParams();
        if (r8 == null) goto L28;
        int r9 = this.sheetDelegate.calculateInnerMargin(r8);
    L29:
        this.innerMargin = r9;
        ViewCompat.offsetLeftAndRight(r6, calculateCurrentOffset(r4, r6));
        maybeAssignCoplanarSiblingViewBasedId(r5);
        Iterator<SideSheetCallback> r10 = this.callbacks.iterator();
    L31:
        if (r10.hasNext() == false) goto L35;
        SideSheetCallback r11 = r10.next();
        if ((r11 instanceof SideSheetCallback) == false) goto L31;
        r11.onLayout(r6);
        goto L31
    L35:
        return true;
    L28:
        r9 = 0;
        goto L29
    }

    private void updateSheetVisibility(View r2) {
        if (this.state != 5) goto L5;
        int r1 = 4;
    L7:
        if (r2.getVisibility() == r1) goto L10;
        r2.setVisibility(r1);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    private void ensureAccessibilityPaneTitleIsSet(View r2) {
        if (ViewCompat.getAccessibilityPaneTitle(r2) != null) goto L6;
        ViewCompat.setAccessibilityPaneTitle(r2, r2.getResources().getString(DEFAULT_ACCESSIBILITY_PANE_TITLE));
        return;
    }

    private void maybeAssignCoplanarSiblingViewBasedId(CoordinatorLayout r3) {
        if (this.coplanarSiblingViewRef != null) goto L10;
        int r0 = this.coplanarSiblingViewId;
        if (r0 == (-1)) goto L11;
        View r4 = r3.findViewById(r0);
        if (r4 == null) goto L12;
        this.coplanarSiblingViewRef = new WeakReference(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    int getChildWidth() {
        return this.childWidth;
    }

    int getParentWidth() {
        return this.parentWidth;
    }

    int getInnerMargin() {
        return this.innerMargin;
    }

    private int calculateCurrentOffset(int r3, V r4) {
        int r0 = this.state;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L9;
        return 0;
    L9:
        if (r0 != 5) goto L12;
        return this.sheetDelegate.getHiddenOffset();
    L12:
        throw new IllegalStateException("Unexpected value: " + this.state);
    L15:
        return r3 - this.sheetDelegate.getOuterEdge(r4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r3, V r4, MotionEvent r5) {
        if (shouldInterceptTouchEvent(r4) == true) goto L6;
        this.ignoreEvents = true;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (r6 != 0) goto L10;
        resetVelocity();
    L10:
        if (this.velocityTracker != null) goto L12;
        this.velocityTracker = VelocityTracker.obtain();
    L12:
        this.velocityTracker.addMovement(r5);
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L19;
        if (r6 == 3) goto L19;
    L24:
        if (this.ignoreEvents == true) goto L31;
        ViewDragHelper r2 = this.viewDragHelper;
        if (r2 == null) goto L31;
        if (r2.shouldInterceptTouchEvent(r5) == false) goto L31;
        return true;
    L31:
        return false;
    L19:
        if (this.ignoreEvents == false) goto L24;
        this.ignoreEvents = false;
        return false;
    L22:
        this.initialX = (int) r5.getX();
        goto L24
    }

    private boolean shouldInterceptTouchEvent(V r2) {
        if (r2.isShown() == true) goto L7;
        if (ViewCompat.getAccessibilityPaneTitle(r2) != null) goto L7;
    L9:
        return false;
    L7:
        if (this.draggable == false) goto L9;
        return true;
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
        resetVelocity();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r5);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r6 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (isDraggedFarEnough(r5) == false) goto L28;
        this.viewDragHelper.captureChildView(r4, r5.getPointerId(r5.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    private boolean isDraggedFarEnough(MotionEvent r3) {
        if (shouldHandleDraggingWithHelper() == true) goto L6;
        return false;
    L6:
        if (calculateDragDistance(this.initialX, r3.getX()) <= this.viewDragHelper.getTouchSlop()) goto L9;
        return true;
    L9:
        return false;
    }

    private float calculateDragDistance(float r1, float r2) {
        return Math.abs(r1 - r2);
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setHideFriction(float r1) {
        this.hideFriction = r1;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public void addCallback(SideSheetCallback r1) {
        this.callbacks.add(r1);
    }

    public void removeCallback(SideSheetCallback r1) {
        this.callbacks.remove(r1);
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void setState(final int r4) {
        if (r4 != 1) goto L5;
    L15:
        StringBuilder r1 = new StringBuilder("STATE_");
        if (r4 != 1) goto L18;
        String r5 = "DRAGGING";
    L20:
        throw new IllegalArgumentException(r1.append(r5).append(" should not be set externally.").toString());
    L18:
        r5 = "SETTLING";
        goto L20
    L5:
        if (r4 == 2) goto L15;
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L10;
    L13:
        setStateInternal(r4);
        return;
    L10:
        if (r0.get() == null) goto L13;
        runAfterLayout(this.viewRef.get(), new SideSheetBehavior$$ExternalSyntheticLambda0(this, r4));
    }

    /* JADX INFO: renamed from: lambda$setState$0$com-google-android-material-sidesheet-SideSheetBehavior, reason: not valid java name */
    /* synthetic */ void m268xc0f1d0a9(int r3) {
        V r0 = this.viewRef.get();
        if (r0 == null) goto L6;
        startSettling(r0, r3, false);
        return;
    }

    private void runAfterLayout(V r1, Runnable r2) {
        if (isLayingOut(r1) == false) goto L5;
        r1.post(r2);
        return;
    L5:
        r2.run();
    }

    private boolean isLayingOut(V r1) {
        ViewParent r0 = r1.getParent();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isLayoutRequested() == false) goto L9;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L9;
        return true;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public int getState() {
        return this.state;
    }

    void setStateInternal(int r4) {
        if (this.state != r4) goto L5;
        return;
    L5:
        this.state = r4;
        if (r4 != 3) goto L8;
    L9:
        this.lastStableState = r4;
    L10:
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L13;
        return;
    L13:
        V r1 = r0.get();
        if (r1 != null) goto L16;
        return;
    L16:
        updateSheetVisibility(r1);
        Iterator<SideSheetCallback> r2 = this.callbacks.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        r2.next().onStateChanged(r1, r4);
        goto L18
    L20:
        updateAccessibilityActions();
        return;
    L8:
        if (r4 != 5) goto L10;
        goto L9
    }

    private void resetVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    boolean shouldHide(View r1, float r2) {
        return this.sheetDelegate.shouldHide(r1, r2);
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
        if (this.shapeAppearanceModel != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.shapeAppearanceModel);
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

    float getXVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    private void startSettling(View r2, int r3, boolean r4) {
        if (this.sheetDelegate.isSettling(r2, r3, r4) == false) goto L5;
        setStateInternal(2);
        this.stateSettlingTracker.continueSettlingToState(r3);
        return;
    L5:
        setStateInternal(r3);
    }

    int getOuterEdgeOffsetForState(int r3) {
        if (r3 == 3) goto L11;
        if (r3 != 5) goto L9;
        return this.sheetDelegate.getHiddenOffset();
    L9:
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + r3);
    L11:
        return getExpandedOffset();
    }

    ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    private void dispatchOnSlide(View r2, int r3) {
        if (this.callbacks.isEmpty() == true) goto L8;
        float r4 = this.sheetDelegate.calculateSlideOffset(r3);
        Iterator<SideSheetCallback> r1 = this.callbacks.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().onSlide(r2, r4);
        goto L6
    L10:
        return;
    }

    public void setCoplanarSiblingViewId(int r2) {
        this.coplanarSiblingViewId = r2;
        clearCoplanarSiblingView();
        WeakReference<V> r1 = this.viewRef;
        if (r1 == null) goto L10;
        V r3 = r1.get();
        if (r2 != (-1)) goto L7;
        return;
    L7:
        if (ViewCompat.isLaidOut(r3) == false) goto L12;
        r3.requestLayout();
        return;
    L12:
        return;
    }

    public void setCoplanarSiblingView(View r2) {
        this.coplanarSiblingViewId = -1;
        if (r2 != null) goto L5;
        clearCoplanarSiblingView();
        return;
    L5:
        this.coplanarSiblingViewRef = new WeakReference(r2);
        WeakReference<V> r1 = this.viewRef;
        if (r1 == null) goto L12;
        V r3 = r1.get();
        if (ViewCompat.isLaidOut(r3) == false) goto L13;
        r3.requestLayout();
        return;
    L13:
        return;
    }

    public View getCoplanarSiblingView() {
        WeakReference<View> r0 = this.coplanarSiblingViewRef;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    private void clearCoplanarSiblingView() {
        WeakReference<View> r0 = this.coplanarSiblingViewRef;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.coplanarSiblingViewRef = null;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    public static <V extends View> SideSheetBehavior<V> from(V r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) r2).getBehavior();
        if ((r3 instanceof SideSheetBehavior) == false) goto L9;
        return (SideSheetBehavior) r3;
    L9:
        throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        V r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        ViewCompat.removeAccessibilityAction(r1, 262144);
        ViewCompat.removeAccessibilityAction(r1, 1048576);
        if (this.state == 5) goto L12;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
    L12:
        if (this.state == 3) goto L15;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    }

    private void replaceAccessibilityActionForState(V r2, AccessibilityNodeInfoCompat.AccessibilityActionCompat r3, int r4) {
        ViewCompat.replaceAccessibilityAction(r2, r3, null, createAccessibilityViewCommandForState(r4));
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r2) {
        return new SideSheetBehavior$$ExternalSyntheticLambda1(this, r2);
    }

    /* JADX INFO: renamed from: lambda$createAccessibilityViewCommandForState$1$com-google-android-material-sidesheet-SideSheetBehavior, reason: not valid java name */
    /* synthetic */ boolean m267x30b69a97(int r1, View r2, AccessibilityViewCommand.CommandArguments r3) {
        setState(r1);
        return true;
    }
}
