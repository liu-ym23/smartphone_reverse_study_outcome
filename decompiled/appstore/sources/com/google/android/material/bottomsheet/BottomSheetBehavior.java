package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.b;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.obric.capabilitykit.common.UiType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_WIDTH = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;

    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final b.c dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;

    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @Nullable
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
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    b viewDragHelper;

    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public abstract void onSlide(@NonNull View r10, float r11);

        public abstract void onStateChanged(@NonNull View r10, int r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r10) {
            this(r10, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.state);
            r10.writeInt(this.peekHeight);
            r10.writeInt(this.fitToContents ? 1 : 0);
            r10.writeInt(this.hideable ? 1 : 0);
            r10.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.state = r10.readInt();
            this.peekHeight = r10.readInt();
            boolean r12 = false;
            if (r10.readInt() != 1) goto L5;
            boolean r13 = true;
        L6:
            this.fitToContents = r13;
            if (r10.readInt() != 1) goto L9;
            boolean r14 = true;
        L10:
            this.hideable = r14;
            if (r10.readInt() != 1) goto L13;
            r12 = true;
        L13:
            this.skipCollapsed = r12;
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        public SavedState(Parcelable r10, @NonNull BottomSheetBehavior<?> r11) {
            super(r10);
            this.state = r11.state;
            this.peekHeight = BottomSheetBehavior.access$1100(r11);
            this.fitToContents = BottomSheetBehavior.access$1000(r11);
            this.hideable = r11.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$1200(r11);
        }

        @Deprecated
        public SavedState(Parcelable r10, int r11) {
            super(r10);
            this.state = r11;
        }
    }

    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        public SettleRunnable(BottomSheetBehavior r10, View r11, int r12) {
            this.this$0 = r10;
            this.view = r11;
            this.targetState = r12;
        }

        public static /* synthetic */ boolean access$800(SettleRunnable r10) {
            return r10.isPosted;
        }

        public static /* synthetic */ boolean access$802(SettleRunnable r10, boolean r11) {
            r10.isPosted = r11;
            return r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = this.this$0.viewDragHelper;
            if (r10 != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
        L8:
            this.isPosted = false;
            return;
        L5:
            if (r10.n(true) == false) goto L7;
            ViewCompat.h0(this.view, this);
            goto L8
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass5(this);
    }

    public static /* synthetic */ MaterialShapeDrawable access$000(BottomSheetBehavior r10) {
        return r10.materialShapeDrawable;
    }

    public static /* synthetic */ boolean access$1000(BottomSheetBehavior r10) {
        return r10.fitToContents;
    }

    public static /* synthetic */ int access$102(BottomSheetBehavior r10, int r11) {
        r10.insetTop = r11;
        return r11;
    }

    public static /* synthetic */ int access$1100(BottomSheetBehavior r10) {
        return r10.peekHeight;
    }

    public static /* synthetic */ boolean access$1200(BottomSheetBehavior r10) {
        return r10.skipCollapsed;
    }

    public static /* synthetic */ boolean access$200(BottomSheetBehavior r10) {
        return r10.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$300(BottomSheetBehavior r10) {
        return r10.insetBottom;
    }

    public static /* synthetic */ int access$302(BottomSheetBehavior r10, int r11) {
        r10.insetBottom = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$400(BottomSheetBehavior r10) {
        return r10.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ boolean access$500(BottomSheetBehavior r10) {
        return r10.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ int access$602(BottomSheetBehavior r10, int r11) {
        r10.gestureInsetBottom = r11;
        return r11;
    }

    public static /* synthetic */ void access$700(BottomSheetBehavior r10, boolean r11) {
        r10.updatePeekHeight(r11);
    }

    public static /* synthetic */ boolean access$900(BottomSheetBehavior r10) {
        return r10.draggable;
    }

    private int addAccessibilityActionForState(V r10, @StringRes int r11, int r12) {
        return ViewCompat.c(r10, r10.getResources().getString(r11), createAccessibilityViewCommandForState(r12));
    }

    private void calculateCollapsedOffset() {
        int r10 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r10, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r10;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r10 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
        int r11 = this.insetBottom;
    L6:
        return r10 + r11;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r10 = this.peekHeight;
        r11 = this.insetBottom;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r12 = this.gestureInsetBottom;
        if (r12 <= 0) goto L15;
        return Math.max(this.peekHeight, r12 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r10) {
        return new AnonymousClass6(this, r10);
    }

    private void createMaterialShapeDrawable(@NonNull Context r10, AttributeSet r11, boolean r12) {
        createMaterialShapeDrawable(r10, r11, r12, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r10;
        r10.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass3(this));
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.c) == false) goto L11;
        CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.c) r11).f();
        if ((r12 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r12;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        VelocityTracker r10 = this.velocityTracker;
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        r10.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V r10, AccessibilityNodeInfoCompat.a r11, int r12) {
        ViewCompat.l0(r10, r11, null, createAccessibilityViewCommandForState(r12));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r10 = this.velocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(@NonNull SavedState r10) {
        int r11 = this.saveFlags;
        if (r11 != 0) goto L6;
        return;
    L6:
        if (r11 != (-1)) goto L8;
    L9:
        this.peekHeight = r10.peekHeight;
    L10:
        if (r11 != (-1)) goto L12;
    L13:
        this.fitToContents = r10.fitToContents;
    L14:
        if (r11 != (-1)) goto L16;
    L17:
        this.hideable = r10.hideable;
    L18:
        if (r11 != (-1)) goto L20;
    L21:
        this.skipCollapsed = r10.skipCollapsed;
        return;
    L20:
        if ((r11 & 8) == 8) goto L21;
        return;
    L16:
        if ((r11 & 4) != 4) goto L18;
    L12:
        if ((r11 & 2) != 2) goto L14;
    L8:
        if ((r11 & 1) != 1) goto L10;
        goto L9
    }

    private void setWindowInsetsListener(@NonNull View r10) {
        if (isGestureInsetBottomIgnored() == false) goto L5;
    L7:
        final boolean r11 = false;
    L9:
        if (this.paddingBottomSystemWindowInsets == false) goto L11;
    L16:
        ViewUtils.doOnApplyWindowInsets(r10, new AnonymousClass4(this, r11));
        return;
    L11:
        if (this.paddingLeftSystemWindowInsets == true) goto L16;
        if (this.paddingRightSystemWindowInsets == true) goto L16;
        if (r11 == true) goto L16;
        return;
    L5:
        if (this.peekHeightAuto == true) goto L7;
        r11 = true;
        goto L9
    }

    private void settleToStatePendingLayout(final int r10) {
        final V r11 = this.viewRef.get();
        if (r11 != null) goto L5;
        return;
    L5:
        ViewParent r12 = r11.getParent();
        if (r12 != null) goto L8;
    L12:
        settleToState(r11, r10);
        return;
    L8:
        if (r12.isLayoutRequested() == false) goto L12;
        if (ViewCompat.S(r11) == false) goto L12;
        r11.post(new AnonymousClass2(this, r11, r10));
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r10 = this.viewRef;
        if (r10 != null) goto L5;
        return;
    L5:
        V r11 = r10.get();
        if (r11 != null) goto L8;
        return;
    L8:
        ViewCompat.j0(r11, UiType.FLAG_WIFI_QRCODE_CARD);
        ViewCompat.j0(r11, UiType.FLAG_TIMER_CARD);
        ViewCompat.j0(r11, UiType.FLAG_APP_CHOOSER_CARD);
        int r12 = this.expandHalfwayActionId;
        if (r12 == (-1)) goto L11;
        ViewCompat.j0(r11, r12);
    L11:
        int r13 = 6;
        if (this.fitToContents == true) goto L17;
        if (this.state == 6) goto L17;
        this.expandHalfwayActionId = addAccessibilityActionForState(r11, R.string.bottomsheet_action_expand_halfway, 6);
    L17:
        if (this.hideable == true) goto L19;
    L21:
        int r14 = this.state;
        if (r14 == 3) goto L32;
        if (r14 == 4) goto L28;
        if (r14 != 6) goto L38;
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.a.f2757x, 4);
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.a.f2756w, 3);
        return;
    L38:
        return;
    L28:
        if (this.fitToContents == false) goto L30;
        r13 = 3;
    L30:
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.a.f2756w, r13);
        return;
    L32:
        if (this.fitToContents == false) goto L34;
        r13 = 4;
    L34:
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.a.f2757x, r13);
        return;
    L19:
        if (this.state == 5) goto L21;
        replaceAccessibilityActionForState(r11, AccessibilityNodeInfoCompat.a.f2758y, 5);
        goto L21
    }

    private void updateDrawableForTargetState(int r10) {
        if (r10 != 2) goto L6;
        return;
    L6:
        if (r10 != 3) goto L8;
        boolean r11 = true;
    L10:
        if (this.isShapeExpanded == r11) goto L24;
        this.isShapeExpanded = r11;
        if (this.materialShapeDrawable == null) goto L25;
        ValueAnimator r12 = this.interpolatorAnimator;
        if (r12 != null) goto L16;
        return;
    L16:
        if (r12.isRunning() == false) goto L19;
        this.interpolatorAnimator.reverse();
        return;
    L19:
        if (r11 == false) goto L21;
        float r13 = 0.0f;
    L22:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r13, r13});
        this.interpolatorAnimator.start();
        return;
    L21:
        r13 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r11 = false;
        goto L10
    }

    private void updateImportantForAccessibility(boolean r10) {
        WeakReference<V> r11 = this.viewRef;
        if (r11 != null) goto L5;
        return;
    L5:
        ViewParent r12 = r11.get().getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (r10 == true) goto L11;
    L14:
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L31;
        View r16 = r13.getChildAt(r15);
        if (r16 == this.viewRef.get()) goto L30;
        if (r10 == false) goto L24;
        this.importantForAccessibilityMap.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        ViewCompat.A0(r16, 4);
        goto L30
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        Map<View, Integer> r17 = this.importantForAccessibilityMap;
        if (r17 == null) goto L30;
        if (r17.containsKey(r16) == false) goto L30;
        ViewCompat.A0(r16, this.importantForAccessibilityMap.get(r16).intValue());
    L30:
        r15 = r15 + 1;
        goto L15
    L31:
        if (r10 == true) goto L34;
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
        this.importantForAccessibilityMap = new HashMap(r14);
        goto L14
    }

    private void updatePeekHeight(boolean r10) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r11 = this.viewRef.get();
        if (r11 == null) goto L14;
        if (r10 == false) goto L10;
        settleToStatePendingLayout(this.state);
        return;
    L10:
        r11.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback r10) {
        if (this.callbacks.contains(r10) == true) goto L6;
        this.callbacks.add(r10);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int r10) {
        V r11 = this.viewRef.get();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L20;
        int r12 = this.collapsedOffset;
        if (r10 <= r12) goto L9;
    L13:
        int r13 = this.collapsedOffset;
        float r14 = r13 - r10;
        float r15 = this.parentHeight - r13;
    L12:
        float r16 = r14 / r15;
        int r17 = 0;
    L16:
        if (r17 >= this.callbacks.size()) goto L21;
        this.callbacks.get(r17).onSlide(r11, r16);
        r17 = r17 + 1;
        goto L16
    L21:
        return;
    L9:
        if (r12 == getExpandedOffset()) goto L13;
        int r18 = this.collapsedOffset;
        r14 = r18 - r10;
        r15 = r18 - getExpandedOffset();
        goto L12
    }

    @Nullable
    @VisibleForTesting
    public View findScrollingChild(View r10) {
        if (ViewCompat.U(r10) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L17;
        View r14 = findScrollingChild(r11.getChildAt(r13));
        if (r14 != null) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return r14;
    L17:
        return null;
    L13:
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r10 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r11 = 0;
    L10:
        return Math.max(r10, r11);
    L8:
        r11 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.c r10) {
        super.onAttachedToLayoutParams(r10);
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
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r13 = r12.getActionMasked();
        if (r13 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r14 = null;
        if (r13 == 0) goto L23;
        if (r13 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        b r15 = this.viewDragHelper;
        if (r15 == null) goto L47;
        if (r15.P(r12) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r16 = this.nestedScrollingChildRef;
        if (r16 == null) goto L50;
        r14 = r16.get();
    L50:
        if (r13 != 2) goto L66;
        if (r14 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r12.getY()) > this.viewDragHelper.B()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r13 == 3) goto L19;
    L23:
        int r17 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r18 = this.nestedScrollingChildRef;
        if (r18 == null) goto L28;
        View r19 = r18.get();
    L29:
        if (r19 == null) goto L34;
        if (r10.isPointInChildBounds(r19, r17, this.initialY) == false) goto L34;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r19 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r110 = false;
    L39:
        this.ignoreEvents = r110;
        goto L41
    L36:
        if (r10.isPointInChildBounds(r11, r17, this.initialY) == true) goto L38;
        r110 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull final V r11, int r12) {
        if (ViewCompat.x(r10) == false) goto L8;
        if (ViewCompat.x(r11) == true) goto L8;
        r11.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L37;
        this.peekHeightMin = r10.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        setWindowInsetsListener(r11);
        this.viewRef = new WeakReference(r11);
        if (this.shapeThemingEnabled == false) goto L14;
        MaterialShapeDrawable r13 = this.materialShapeDrawable;
        if (r13 == null) goto L14;
        ViewCompat.t0(r11, r13);
    L14:
        MaterialShapeDrawable r14 = this.materialShapeDrawable;
        if (r14 == null) goto L28;
        float r15 = this.elevation;
        if (r15 != (-1.0f)) goto L19;
        r15 = ViewCompat.v(r11);
    L19:
        r14.setElevation(r15);
        if (this.state != 3) goto L22;
        boolean r16 = true;
    L23:
        this.isShapeExpanded = r16;
        MaterialShapeDrawable r17 = this.materialShapeDrawable;
        if (r16 == false) goto L26;
        float r18 = 0.0f;
    L27:
        r17.setInterpolation(r18);
        goto L28
    L26:
        r18 = 1.0f;
        goto L27
    L22:
        r16 = false;
    L28:
        updateAccessibilityActions();
        if (ViewCompat.y(r11) != 0) goto L31;
        ViewCompat.A0(r11, 1);
    L31:
        int r19 = r11.getMeasuredWidth();
        int r20 = this.maxWidth;
        if (r19 <= r20) goto L37;
        if (r20 == (-1)) goto L37;
        final ViewGroup.LayoutParams r21 = r11.getLayoutParams();
        r21.width = this.maxWidth;
        r11.post(new AnonymousClass1(this, r11, r21));
    L37:
        if (this.viewDragHelper != null) goto L39;
        this.viewDragHelper = b.p(r10, this.dragCallback);
    L39:
        int r22 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.parentWidth = r10.getWidth();
        this.parentHeight = r10.getHeight();
        int r23 = r11.getHeight();
        this.childHeight = r23;
        int r24 = this.parentHeight;
        int r25 = r24 - r23;
        int r26 = this.insetTop;
        if (r25 < r26) goto L42;
    L45:
        this.fitToContentsOffset = Math.max(0, r24 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r27 = this.state;
        if (r27 != 3) goto L49;
        ViewCompat.a0(r11, getExpandedOffset());
    L63:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r11));
        return true;
    L49:
        if (r27 != 6) goto L52;
        ViewCompat.a0(r11, this.halfExpandedOffset);
        goto L63
    L52:
        if (this.hideable == false) goto L57;
        if (r27 != 5) goto L57;
        ViewCompat.a0(r11, this.parentHeight);
    L57:
        if (r27 != 4) goto L59;
        ViewCompat.a0(r11, this.collapsedOffset);
        goto L63
    L59:
        if (r27 != 1) goto L61;
    L62:
        ViewCompat.a0(r11, r22 - r11.getTop());
        goto L63
    L61:
        if (r27 != 2) goto L63;
    L42:
        if (this.paddingTopSystemWindowInsets == false) goto L44;
        this.childHeight = r24;
        goto L45
    L44:
        this.childHeight = r24 - r26;
        goto L45
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14) {
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 != null) goto L5;
        return false;
    L5:
        if (r12 == r15.get()) goto L7;
        return false;
    L7:
        if (this.state == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == true) goto L10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15, int r16) {
        if (r16 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r17 = this.nestedScrollingChildRef;
        if (r17 == null) goto L8;
        View r18 = r17.get();
    L9:
        if (r12 == r18) goto L11;
        return;
    L11:
        int r19 = r11.getTop();
        int r20 = r19 - r14;
        if (r14 > 0) goto L14;
        if (r14 < 0) goto L22;
    L33:
        dispatchOnSlide(r11.getTop());
        this.lastNestedScrollDy = r14;
        this.nestedScrolled = true;
        return;
    L22:
        if (r12.canScrollVertically(-1) == true) goto L33;
        int r21 = this.collapsedOffset;
        if (r20 <= r21) goto L30;
        if (this.hideable == true) goto L30;
        int r22 = r19 - r21;
        r15[1] = r22;
        ViewCompat.a0(r11, -r22);
        setStateInternal(4);
    L30:
        if (this.draggable == true) goto L32;
        return;
    L32:
        r15[1] = r14;
        ViewCompat.a0(r11, -r14);
        setStateInternal(1);
        goto L33
    L14:
        if (r20 >= getExpandedOffset()) goto L17;
        int r23 = r19 - getExpandedOffset();
        r15[1] = r23;
        ViewCompat.a0(r11, -r23);
        setStateInternal(3);
        goto L33
    L17:
        if (this.draggable == true) goto L19;
        return;
    L19:
        r15[1] = r14;
        ViewCompat.a0(r11, -r14);
        setStateInternal(1);
        goto L33
    L8:
        r18 = null;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17, @NonNull int[] r18) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Parcelable r12) {
        SavedState r13 = (SavedState) r12;
        super.onRestoreInstanceState(r10, r11, r13.getSuperState());
        restoreOptionalState(r13);
        int r14 = r13.state;
        if (r14 != 1) goto L5;
    L8:
        this.state = 4;
        return;
    L5:
        if (r14 == 2) goto L8;
        this.state = r14;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11) {
        return new SavedState(super.onSaveInstanceState(r10, r11), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r14 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13) {
        int r14 = 3;
        if (r11.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r15 = this.nestedScrollingChildRef;
        if (r15 != null) goto L9;
        return;
    L9:
        if (r12 == r15.get()) goto L11;
        return;
    L11:
        if (this.nestedScrolled == true) goto L14;
        return;
    L14:
        if (this.lastNestedScrollDy <= 0) goto L23;
        if (this.fitToContents == false) goto L18;
        int r16 = this.fitToContentsOffset;
    L54:
        startSettlingAnimation(r11, r14, r16, false);
        this.nestedScrolled = false;
        return;
    L18:
        int r17 = r11.getTop();
        int r18 = this.halfExpandedOffset;
        if (r17 <= r18) goto L21;
        r14 = 6;
        r16 = r18;
        goto L54
    L21:
        r16 = getExpandedOffset();
        goto L54
    L23:
        if (this.hideable == false) goto L28;
        if (shouldHide(r11, getYVelocity()) == false) goto L28;
        r16 = this.parentHeight;
        r14 = 5;
    L28:
        if (this.lastNestedScrollDy != 0) goto L46;
        int r19 = r11.getTop();
        if (this.fitToContents == true) goto L32;
        int r20 = this.halfExpandedOffset;
        if (r19 >= r20) goto L42;
        if (r19 >= Math.abs(r19 - this.collapsedOffset)) goto L40;
        r16 = getExpandedOffset();
        goto L54
    L40:
        r16 = this.halfExpandedOffset;
    L52:
        r14 = 6;
        goto L54
    L42:
        if (Math.abs(r19 - r20) >= Math.abs(r19 - this.collapsedOffset)) goto L44;
        r16 = this.halfExpandedOffset;
        goto L52
    L44:
        r16 = this.collapsedOffset;
    L48:
        r14 = 4;
        goto L54
    L32:
        if (Math.abs(r19 - this.fitToContentsOffset) >= Math.abs(r19 - this.collapsedOffset)) goto L34;
        r16 = this.fitToContentsOffset;
        goto L54
    L34:
        r16 = this.collapsedOffset;
        goto L48
    L46:
        if (this.fitToContents == false) goto L49;
        r16 = this.collapsedOffset;
        goto L48
    L49:
        int r21 = r11.getTop();
        if (Math.abs(r21 - this.halfExpandedOffset) >= Math.abs(r21 - this.collapsedOffset)) goto L53;
        r16 = this.halfExpandedOffset;
        goto L52
    L53:
        r16 = this.collapsedOffset;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L6;
        return false;
    L6:
        int r13 = r12.getActionMasked();
        if (this.state != 1) goto L10;
        if (r13 != 0) goto L10;
        return true;
    L10:
        b r14 = this.viewDragHelper;
        if (r14 == null) goto L13;
        r14.processTouchEvent(r12);
    L13:
        if (r13 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r12);
        if (this.viewDragHelper == null) goto L28;
        if (r13 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r12.getY()) <= this.viewDragHelper.B()) goto L28;
        this.viewDragHelper.c(r11, r12.getPointerId(r12.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback r10) {
        this.callbacks.remove(r10);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback r10) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r10 == null) goto L6;
        this.callbacks.add(r10);
        return;
    }

    public void setDraggable(boolean r10) {
        this.draggable = r10;
    }

    public void setExpandedOffset(int r10) {
        if (r10 < 0) goto L6;
        this.expandedOffset = r10;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean r10) {
        if (this.fitToContents != r10) goto L5;
        return;
    L5:
        this.fitToContents = r10;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r11 = this.state;
    L14:
        setStateInternal(r11);
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r11 = 3;
        goto L14
    }

    public void setGestureInsetBottomIgnored(boolean r10) {
        this.gestureInsetBottomIgnored = r10;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (r10 <= 0.0f) goto L11;
        if (r10 >= 1.0f) goto L11;
        this.halfExpandedRatio = r10;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean r10) {
        if (this.hideable == r10) goto L11;
        this.hideable = r10;
        if (r10 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    public void setMaxWidth(@Px int r10) {
        this.maxWidth = r10;
    }

    public void setPeekHeight(int r10) {
        setPeekHeight(r10, false);
    }

    public void setSaveFlags(int r10) {
        this.saveFlags = r10;
    }

    public void setSkipCollapsed(boolean r10) {
        this.skipCollapsed = r10;
    }

    public void setState(int r10) {
        if (r10 != this.state) goto L6;
        return;
    L6:
        if (this.viewRef == null) goto L8;
        settleToStatePendingLayout(r10);
        return;
    L8:
        if (r10 != 4) goto L10;
    L17:
        this.state = r10;
        return;
    L10:
        if (r10 == 3) goto L17;
        if (r10 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r10 == 5) goto L17;
    }

    public void setStateInternal(int r10) {
        if (this.state != r10) goto L5;
        return;
    L5:
        this.state = r10;
        WeakReference<V> r11 = this.viewRef;
        if (r11 != null) goto L8;
        return;
    L8:
        V r12 = r11.get();
        if (r12 != null) goto L11;
        return;
    L11:
        int r13 = 0;
        if (r10 != 3) goto L15;
        updateImportantForAccessibility(true);
    L21:
        updateDrawableForTargetState(r10);
    L23:
        if (r13 >= this.callbacks.size()) goto L25;
        this.callbacks.get(r13).onStateChanged(r12, r10);
        r13 = r13 + 1;
        goto L23
    L25:
        updateAccessibilityActions();
        return;
    L15:
        if (r10 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L21
    L17:
        if (r10 == 5) goto L20;
        if (r10 != 4) goto L21;
        goto L20
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r10) {
        this.updateImportantForAccessibilityOnSiblings = r10;
    }

    public void settleToState(@NonNull View r10, int r11) {
        if (r11 != 4) goto L6;
        int r12 = this.collapsedOffset;
    L19:
        startSettlingAnimation(r10, r11, r12, false);
        return;
    L6:
        if (r11 != 6) goto L12;
        r12 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L19;
        int r13 = this.fitToContentsOffset;
        if (r12 > r13) goto L19;
        r11 = 3;
        r12 = r13;
        goto L19
    L12:
        if (r11 != 3) goto L15;
        r12 = getExpandedOffset();
        goto L19
    L15:
        if (this.hideable == false) goto L22;
        if (r11 != 5) goto L22;
        r12 = this.parentHeight;
    L22:
        throw new IllegalArgumentException("Illegal state argument: " + r11);
    }

    public boolean shouldHide(@NonNull View r10, float r11) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r10.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r10.getTop() + (r11 * HIDE_FRICTION)) - this.collapsedOffset) / calculatePeekHeight()) <= HIDE_THRESHOLD) goto L12;
        return true;
    L12:
        return false;
    }

    public void startSettlingAnimation(View r10, int r11, int r12, boolean r13) {
        b r14 = this.viewDragHelper;
        if (r14 == null) goto L17;
        if (r13 == false) goto L9;
        if (r14.O(r10.getLeft(), r12) == false) goto L17;
    L10:
        setStateInternal(2);
        updateDrawableForTargetState(r11);
        if (this.settleRunnable != null) goto L14;
        this.settleRunnable = new SettleRunnable(this, r10, r11);
    L14:
        if (SettleRunnable.access$800(this.settleRunnable) == true) goto L16;
        BottomSheetBehavior<V>.SettleRunnable r15 = this.settleRunnable;
        r15.targetState = r11;
        ViewCompat.h0(r10, r15);
        SettleRunnable.access$802(this.settleRunnable, true);
        return;
    L16:
        this.settleRunnable.targetState = r11;
        return;
    L9:
        if (r14.Q(r10, r10.getLeft(), r12) == true) goto L10;
    L17:
        setStateInternal(r11);
    }

    private void createMaterialShapeDrawable(@NonNull Context r10, AttributeSet r11, boolean r12, @Nullable ColorStateList r13) {
        if (this.shapeThemingEnabled == false) goto L10;
        this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(r10, r11, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = r14;
        r14.initializeElevationOverlay(r10);
        if (r12 == false) goto L8;
        if (r13 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r13);
        return;
    L8:
        TypedValue r15 = new TypedValue();
        r10.getTheme().resolveAttribute(android.R.attr.colorBackground, r15, true);
        this.materialShapeDrawable.setTint(r15.data);
        return;
    }

    public final void setPeekHeight(int r10, boolean r11) {
        if (r10 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L14;
        this.peekHeightAuto = true;
    L12:
        updatePeekHeight(r11);
        return;
    L14:
        return;
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L11:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r10);
        goto L12
    L10:
        if (this.peekHeight != r10) goto L11;
    }

    public BottomSheetBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass5(this);
        this.peekHeightGestureInsetBuffer = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = r12.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int r13 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean r14 = r12.hasValue(r13);
        if (r14 == false) goto L5;
        createMaterialShapeDrawable(r10, r11, r14, MaterialResources.getColorStateList(r10, r12, r13));
    L6:
        createShapeValueAnimator();
        this.elevation = r12.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int r15 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (r12.hasValue(r15) == false) goto L9;
        setMaxWidth(r12.getDimensionPixelSize(r15, -1));
    L9:
        int r16 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r17 = r12.peekValue(r16);
        if (r17 == null) goto L14;
        int r18 = r17.data;
        if (r18 != (-1)) goto L14;
        setPeekHeight(r18);
    L15:
        setHideable(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r12.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r12.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, HIDE_THRESHOLD));
        int r19 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue r20 = r12.peekValue(r19);
        if (r20 != null) goto L18;
    L20:
        setExpandedOffset(r12.getDimensionPixelOffset(r19, 0));
    L21:
        this.paddingBottomSystemWindowInsets = r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        r12.recycle();
        this.maximumVelocity = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L18:
        if (r20.type != 16) goto L20;
        setExpandedOffset(r20.data);
    L14:
        setPeekHeight(r12.getDimensionPixelSize(r16, -1));
        goto L15
    L5:
        createMaterialShapeDrawable(r10, r11, r14);
        goto L6
    }
}
