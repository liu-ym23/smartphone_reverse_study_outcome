package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private final float appBarElevation;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private final ColorStateList liftOnScrollColor;
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;
    private ValueAnimator.AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List<LiftOnScrollListener> liftOnScrollListeners;
    private WeakReference<View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final double EXPAND_BY_KEY_EVENT_THRESHOLD_PERCENTAGE = 0.1d;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private boolean coordinatorLayoutA11yScrollable;
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(T r1);

            public BaseDragCallback() {
            }
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public SavedState(Parcel r3, ClassLoader r4) {
                super(r3, r4);
                boolean r0 = true;
                if (r3.readByte() == 0) goto L5;
                boolean r5 = true;
            L6:
                this.fullyScrolled = r5;
                if (r3.readByte() == 0) goto L9;
                boolean r6 = true;
            L10:
                this.fullyExpanded = r6;
                this.firstVisibleChildIndex = r3.readInt();
                this.firstVisibleChildPercentageShown = r3.readFloat();
                if (r3.readByte() != 0) goto L14;
                r0 = false;
            L14:
                this.firstVisibleChildAtMinimumHeight = r0;
                return;
            L9:
                r6 = false;
                goto L10
            L5:
                r5 = false;
                goto L6
            }

            public SavedState(Parcelable r1) {
                super(r1);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel r1, int r2) {
                super.writeToParcel(r1, r2);
                r1.writeByte(this.fullyScrolled ? 1 : 0);
                r1.writeByte(this.fullyExpanded ? 1 : 0);
                r1.writeInt(this.firstVisibleChildIndex);
                r1.writeFloat(this.firstVisibleChildPercentageShown);
                r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }

            static {
                CREATOR = new AnonymousClass1();
            }
        }

        private static boolean checkFlag(int r0, int r1) {
            if ((r0 & r1) != r1) goto L5;
            return true;
        L5:
            return false;
        }

        static /* synthetic */ boolean access$000(BaseBehavior r0) {
            return r0.coordinatorLayoutA11yScrollable;
        }

        static /* synthetic */ int access$100(BaseBehavior r0) {
            return r0.offsetDelta;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return canDragView((AppBarLayout) r1);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getMaxDragOffset(View r1) {
            return getMaxDragOffset((AppBarLayout) r1);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r1) {
            return getScrollRangeForDragFling((AppBarLayout) r1);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r1, View r2) {
            onFlingFinished(r1, (AppBarLayout) r2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return onLayoutChild(r1, (AppBarLayout) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
            return onMeasureChild(r1, (AppBarLayout) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
            onNestedPreScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
            onNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7, r8, r9);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, View r2, Parcelable r3) {
            onRestoreInstanceState(r1, (AppBarLayout) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, View r2) {
            return onSaveInstanceState(r1, (AppBarLayout) r2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
            return onStartNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
            onStopNestedScroll(r1, (AppBarLayout) r2, r3, r4);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
            return setHeaderTopBottomOffset(r1, (AppBarLayout) r2, r3, r4, r5);
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r1, T r2, View r3, View r4, int r5, int r6) {
            if ((r5 & 2) != 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.offsetAnimator;
            if (r8 == null) goto L14;
            r8.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r6;
            return r7;
        L5:
            if (r2.isLiftOnScroll() == false) goto L7;
        L8:
            r7 = true;
            goto L10
        L7:
            if (canScrollChildren(r1, r2, r3) == false) goto L9;
            goto L8
        }

        private boolean canScrollChildren(CoordinatorLayout r1, T r2, View r3) {
            if (r2.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
            return true;
        }

        public void onNestedPreScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int[] r12, int r13) {
            if (r11 == 0) goto L10;
            if (r11 >= 0) goto L5;
            int r14 = -r8.getTotalScrollRange();
            int r15 = r8.getDownNestedPreScrollRange() + r14;
        L6:
            int r4 = r14;
            int r5 = r15;
            if (r4 == r5) goto L10;
            r12[1] = scroll(r7, r8, r11, r4, r5);
            goto L10
        L5:
            r14 = -r8.getUpNestedPreScrollRange();
            r15 = 0;
        L10:
            if (r8.isLiftOnScroll() == false) goto L13;
            r8.setLiftedState(r8.shouldLift(r9));
            return;
        }

        public void onNestedScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
            if (r13 >= 0) goto L4;
            r15[1] = scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
        L4:
            if (r13 != 0) goto L7;
            updateAccessibilityActions(r7, r8);
            return;
        }

        public void onStopNestedScroll(CoordinatorLayout r2, T r3, View r4, int r5) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r2, r3);
            if (r3.isLiftOnScroll() == false) goto L9;
            r3.setLiftedState(r3.shouldLift(r4));
        L9:
            this.lastNestedScrollingChildRef = new WeakReference(r4);
            return;
        L5:
            if (r5 != 1) goto L9;
            goto L6
        }

        public void setDragCallback(BaseDragCallback r1) {
            this.onDragCallback = r1;
        }

        private void animateOffsetTo(CoordinatorLayout r3, T r4, int r5, float r6) {
            int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0.0f) goto L5;
            int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r3, r4, r5, r8);
            return;
        L5:
            r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(final CoordinatorLayout r4, final T r5, int r6, int r7) {
            int r0 = getTopBottomOffsetForScrollingSibling();
            if (r0 != r6) goto L10;
            ValueAnimator r8 = this.offsetAnimator;
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r1 = this.offsetAnimator;
            if (r1 != null) goto L13;
            ValueAnimator r2 = new ValueAnimator();
            this.offsetAnimator = r2;
            r2.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r4, r5));
        L14:
            this.offsetAnimator.setDuration(Math.min(r7, 600));
            this.offsetAnimator.setIntValues(new int[]{r0, r6});
            this.offsetAnimator.start();
            return;
        L13:
            r1.cancel();
            goto L14
        }

        private int getChildIndexOnOffset(T r7, int r8) {
            int r6 = r7.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L12;
            View r1 = r7.getChildAt(r0);
            int r2 = r1.getTop();
            int r3 = r1.getBottom();
            LayoutParams r4 = (LayoutParams) r1.getLayoutParams();
            if (checkFlag(r4.getScrollFlags(), 32) == false) goto L7;
            r2 = r2 - r4.topMargin;
            r3 = r3 + r4.bottomMargin;
        L7:
            int r5 = -r8;
            if (r2 > r5) goto L11;
            if (r3 < r5) goto L11;
            return r0;
        L11:
            r0 = r0 + 1;
            goto L3
        L12:
            return -1;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r9, T r10) {
            int r0 = r10.getTopInset() + r10.getPaddingTop();
            int r1 = getTopBottomOffsetForScrollingSibling() - r0;
            int r2 = getChildIndexOnOffset(r10, r1);
            if (r2 < 0) goto L27;
            View r3 = r10.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
            int r5 = r4.getScrollFlags();
            if ((r5 & 17) != 17) goto L28;
            int r6 = -r3.getTop();
            int r7 = -r3.getBottom();
            if (r2 != 0) goto L14;
            if (ViewCompat.getFitsSystemWindows(r10) == false) goto L14;
            if (ViewCompat.getFitsSystemWindows(r3) == false) goto L14;
            r6 = r6 - r10.getTopInset();
        L14:
            if (checkFlag(r5, 2) == false) goto L17;
            r7 = r7 + ViewCompat.getMinimumHeight(r3);
        L23:
            if (checkFlag(r5, 32) == false) goto L25;
            r6 = r6 + r4.topMargin;
            r7 = r7 - r4.bottomMargin;
        L25:
            animateOffsetTo(r9, r10, MathUtils.clamp(calculateSnapOffset(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
            return;
        L17:
            if (checkFlag(r5, 5) == false) goto L23;
            int r8 = ViewCompat.getMinimumHeight(r3) + r7;
            if (r1 >= r8) goto L21;
            r6 = r8;
            goto L23
        L21:
            r7 = r8;
            goto L23
        L28:
            return;
        }

        private int calculateSnapOffset(int r1, int r2, int r3) {
            if (r1 >= ((r2 + r3) / 2)) goto L6;
            return r2;
        L6:
            return r3;
        }

        public boolean onMeasureChild(CoordinatorLayout r7, T r8, int r9, int r10, int r11, int r12) {
            if (((CoordinatorLayout.LayoutParams) r8.getLayoutParams()).height != (-2)) goto L7;
            r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
            return true;
        L7:
            return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
        }

        public boolean onLayoutChild(CoordinatorLayout r8, final T r9, int r10) {
            boolean r11 = super.onLayoutChild(r8, r9, r10);
            int r0 = r9.getPendingAction();
            SavedState r1 = this.savedState;
            if (r1 != null) goto L5;
        L17:
            if (r0 != 0) goto L19;
        L33:
            r9.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r8, r9, getTopAndBottomOffset(), 0, true);
            r9.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(r8, r9);
            final View r12 = findFirstScrollingChild(r8);
            if (r12 == null) goto L36;
            r12.addOnUnhandledKeyEventListener(new AppBarLayout$BaseBehavior$$ExternalSyntheticLambda0(this, r12, r9));
        L36:
            return r11;
        L19:
            if ((r0 & 4) == 0) goto L21;
            boolean r2 = true;
        L23:
            if ((r0 & 2) == 0) goto L29;
            int r3 = -r9.getUpNestedPreScrollRange();
            if (r2 == false) goto L27;
            animateOffsetTo(r8, r9, r3, 0.0f);
            goto L33
        L27:
            setHeaderTopBottomOffset(r8, r9, r3);
            goto L33
        L29:
            if ((r0 & 1) == 0) goto L33;
            if (r2 == false) goto L32;
            animateOffsetTo(r8, r9, 0, 0.0f);
            goto L33
        L32:
            setHeaderTopBottomOffset(r8, r9, 0);
            goto L33
        L21:
            r2 = false;
            goto L23
        L5:
            if ((r0 & 8) != 0) goto L17;
            if (r1.fullyScrolled == false) goto L10;
            setHeaderTopBottomOffset(r8, r9, -r9.getTotalScrollRange());
            goto L33
        L10:
            if (this.savedState.fullyExpanded == false) goto L12;
            setHeaderTopBottomOffset(r8, r9, 0);
            goto L33
        L12:
            View r4 = r9.getChildAt(this.savedState.firstVisibleChildIndex);
            int r5 = -r4.getBottom();
            if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L15;
            int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
        L16:
            setHeaderTopBottomOffset(r8, r9, r5 + r6);
            goto L33
        L15:
            r6 = Math.round(r4.getHeight() * this.savedState.firstVisibleChildPercentageShown);
            goto L16
        }

        /* JADX INFO: renamed from: lambda$onLayoutChild$0$com-google-android-material-appbar-AppBarLayout$BaseBehavior, reason: not valid java name */
        /* synthetic */ boolean m240x27898e32(View r1, AppBarLayout r2, View r3, KeyEvent r4) {
            controlExpansionOnKeyPress(r4, r1, r2);
            return false;
        }

        /* JADX INFO: renamed from: lambda$onLayoutChild$1$com-google-android-material-appbar-AppBarLayout$BaseBehavior, reason: not valid java name */
        /* synthetic */ boolean m241xbbc7fdd1(View r1, AppBarLayout r2, View r3, int r4, KeyEvent r5) {
            controlExpansionOnKeyPress(r5, r1, r2);
            return false;
        }

        private void controlExpansionOnKeyPress(KeyEvent r6, View r7, AppBarLayout r8) {
            if (r6.getAction() != 0) goto L5;
        L6:
            int r5 = r6.getKeyCode();
            if (r5 == 19) goto L23;
            if (r5 == 280) goto L23;
            if (r5 == 92) goto L23;
            if (r5 == 20) goto L20;
            if (r5 == 281) goto L20;
            if (r5 == 93) goto L20;
            return;
        L20:
            if (r7.getScrollY() <= 0) goto L28;
            r8.setExpanded(false);
            return;
        L28:
            return;
        L23:
            if (r7.getScrollY() >= (((double) r7.getMeasuredHeight()) * 0.1d)) goto L30;
            r8.setExpanded(true);
            return;
        L30:
            return;
        L5:
            if (r6.getAction() == 1) goto L6;
        }

        private void updateAccessibilityActions(CoordinatorLayout r3, T r4) {
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            if (r4.getTotalScrollRange() != 0) goto L5;
            return;
        L5:
            View r0 = getChildWithScrollingBehavior(r3);
            if (r0 != null) goto L9;
            return;
        L9:
            if (childrenHaveScrollFlags(r4) == true) goto L12;
            return;
        L12:
            if (ViewCompat.hasAccessibilityDelegate(r3) == true) goto L14;
            ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass2(this));
        L14:
            this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(r3, r4, r0);
        }

        private View getChildWithScrollingBehavior(CoordinatorLayout r4) {
            int r3 = r4.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L8;
            View r1 = r4.getChildAt(r0);
            if ((((CoordinatorLayout.LayoutParams) r1.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L8:
            return null;
        }

        private boolean childrenHaveScrollFlags(AppBarLayout r4) {
            int r3 = r4.getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r3) goto L9;
            if (((LayoutParams) r4.getChildAt(r1).getLayoutParams()).scrollFlags != 0) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean addAccessibilityScrollActions(final CoordinatorLayout r11, final T r12, final View r13) {
            boolean r3 = false;
            if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
            addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            r3 = true;
        L6:
            if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
            if (r13.canScrollVertically(-1) == false) goto L12;
            final int r9 = -r12.getDownNestedPreScrollRange();
            if (r9 == 0) goto L14;
            ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r11, r12, r13, r9));
            return true;
        L12:
            addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            return true;
        L14:
            return r3;
        }

        private void addActionToExpand(CoordinatorLayout r2, final T r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, final boolean r5) {
            ViewCompat.replaceAccessibilityAction(r2, r4, null, new AnonymousClass4(this, r3, r5));
        }

        boolean canDragView(T r2) {
            BaseDragCallback r0 = this.onDragCallback;
            if (r0 != null) goto L5;
            WeakReference<View> r1 = this.lastNestedScrollingChildRef;
            if (r1 == null) goto L17;
            View r3 = r1.get();
            if (r3 != null) goto L11;
        L15:
            return false;
        L11:
            if (r3.isShown() == false) goto L15;
            if (r3.canScrollVertically(-1) == true) goto L15;
            return true;
        L17:
            return true;
        L5:
            return r0.canDrag(r2);
        }

        void onFlingFinished(CoordinatorLayout r2, T r3) {
            snapToChildIfNeeded(r2, r3);
            if (r3.isLiftOnScroll() == false) goto L6;
            r3.setLiftedState(r3.shouldLift(findFirstScrollingChild(r2)));
            return;
        }

        int getMaxDragOffset(T r1) {
            return -r1.getDownNestedScrollRange();
        }

        int getScrollRangeForDragFling(T r1) {
            return r1.getTotalScrollRange();
        }

        int setHeaderTopBottomOffset(CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
            int r0 = getTopBottomOffsetForScrollingSibling();
            int r1 = 0;
            if (r12 == 0) goto L30;
            if (r0 < r12) goto L30;
            if (r0 > r13) goto L30;
            int r5 = MathUtils.clamp(r11, r12, r13);
            if (r0 != r5) goto L9;
        L31:
            updateAccessibilityActions(r9, r10);
            return r1;
        L9:
            if (r10.hasChildWithInterpolator() == false) goto L11;
            int r14 = interpolateOffset(r10, r5);
        L12:
            boolean r15 = setTopAndBottomOffset(r14);
            int r16 = r0 - r5;
            this.offsetDelta = r5 - r14;
            int r17 = 1;
            if (r15 == true) goto L15;
        L22:
            if (r15 == false) goto L24;
        L26:
            r10.onOffsetChanged(getTopAndBottomOffset());
            if (r5 >= r0) goto L29;
            r17 = -1;
        L29:
            updateAppBarLayoutDrawableState(r9, r10, r5, r17, false);
            r1 = r16;
            goto L31
        L24:
            if (r10.hasChildWithInterpolator() == false) goto L26;
            r9.dispatchDependentViewsChanged(r10);
        L15:
            if (r1 >= r10.getChildCount()) goto L22;
            LayoutParams r2 = (LayoutParams) r10.getChildAt(r1).getLayoutParams();
            ChildScrollEffect r3 = r2.getScrollEffect();
            if (r3 == null) goto L21;
            if ((r2.getScrollFlags() & 1) == 0) goto L21;
            r3.onOffsetChanged(r10, r10.getChildAt(r1), getTopAndBottomOffset());
        L21:
            r1 = r1 + 1;
            goto L15
        L11:
            r14 = r5;
        L30:
            this.offsetDelta = 0;
            goto L31
        }

        boolean isOffsetAnimatorRunning() {
            ValueAnimator r0 = this.offsetAnimator;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isRunning() == false) goto L7;
            return true;
        }

        private int interpolateOffset(T r8, int r9) {
            int r7 = Math.abs(r9);
            int r0 = r8.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L21;
            View r3 = r8.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
            Interpolator r5 = r4.getScrollInterpolator();
            if (r7 < r3.getTop()) goto L20;
            if (r7 > r3.getBottom()) goto L20;
            if (r5 == null) goto L21;
            int r6 = r4.getScrollFlags();
            if ((r6 & 1) == 0) goto L15;
            r1 = 0 + ((r3.getHeight() + r4.topMargin) + r4.bottomMargin);
            if ((r6 & 2) == 0) goto L15;
            r1 = r1 - ViewCompat.getMinimumHeight(r3);
        L15:
            if (ViewCompat.getFitsSystemWindows(r3) == false) goto L17;
            r1 = r1 - r8.getTopInset();
        L17:
            if (r1 <= 0) goto L21;
            float r10 = r1;
            return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
        L20:
            r2 = r2 + 1;
        L21:
            return r9;
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            View r0 = getAppBarChildOnOffset(r7, r8);
            boolean r1 = false;
            if (r0 == null) goto L19;
            int r2 = ((LayoutParams) r0.getLayoutParams()).getScrollFlags();
            if ((r2 & 1) == 0) goto L19;
            int r3 = ViewCompat.getMinimumHeight(r0);
            if (r9 <= 0) goto L14;
            if ((r2 & 12) == 0) goto L14;
            if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
        L12:
            r1 = true;
        L14:
            if ((r2 & 2) == 0) goto L19;
            if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
        L19:
            if (r7.isLiftOnScroll() == false) goto L21;
            r1 = r7.shouldLift(findFirstScrollingChild(r6));
        L21:
            boolean r11 = r7.setLiftedState(r1);
            if (r10 == true) goto L26;
            if (r11 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r6, r7) == true) goto L26;
            return;
        L26:
            r7.jumpDrawablesToCurrentState();
        }

        private boolean shouldJumpElevationState(CoordinatorLayout r4, T r5) {
            List<View> r3 = r4.getDependents(r5);
            int r6 = r3.size();
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L11;
            CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r3.get(r0).getLayoutParams()).getBehavior();
            if ((r1 instanceof ScrollingViewBehavior) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) r1).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private static View getAppBarChildOnOffset(AppBarLayout r4, int r5) {
            int r6 = Math.abs(r5);
            int r0 = r4.getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            View r2 = r4.getChildAt(r1);
            if (r6 < r2.getTop()) goto L9;
            if (r6 > r2.getBottom()) goto L9;
            return r2;
        L9:
            r1 = r1 + 1;
            goto L3
        L10:
            return null;
        }

        private View findFirstScrollingChild(CoordinatorLayout r4) {
            int r3 = r4.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L13;
            View r1 = r4.getChildAt(r0);
            if ((r1 instanceof NestedScrollingChild) == true) goto L12;
            if ((r1 instanceof AbsListView) == true) goto L12;
            if ((r1 instanceof ScrollView) == true) goto L12;
            r0 = r0 + 1;
        L12:
            return r1;
        L13:
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout r1, T r2) {
            Parcelable r3 = super.onSaveInstanceState(r1, r2);
            SavedState r0 = saveScrollState(r3, r2);
            if (r0 != null) goto L6;
            return r3;
        L6:
            return r0;
        }

        public void onRestoreInstanceState(CoordinatorLayout r2, T r3, Parcelable r4) {
            if ((r4 instanceof SavedState) == false) goto L5;
            restoreScrollState((SavedState) r4, true);
            super.onRestoreInstanceState(r2, r3, this.savedState.getSuperState());
            return;
        L5:
            super.onRestoreInstanceState(r2, r3, r4);
            this.savedState = null;
        }

        SavedState saveScrollState(Parcelable r7, T r8) {
            int r6 = getTopAndBottomOffset();
            int r0 = r8.getChildCount();
            boolean r1 = false;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L26;
            View r3 = r8.getChildAt(r2);
            int r4 = r3.getBottom() + r6;
            if ((r3.getTop() + r6) > 0) goto L25;
            if (r4 < 0) goto L25;
            if (r7 != null) goto L10;
            r7 = AbsSavedState.EMPTY_STATE;
        L10:
            SavedState r5 = new SavedState(r7);
            if (r6 != 0) goto L13;
            boolean r9 = true;
        L14:
            r5.fullyExpanded = r9;
            if (r5.fullyExpanded == false) goto L17;
        L19:
            boolean r10 = false;
        L20:
            r5.fullyScrolled = r10;
            r5.firstVisibleChildIndex = r2;
            if (r4 != (ViewCompat.getMinimumHeight(r3) + r8.getTopInset())) goto L23;
            r1 = true;
        L23:
            r5.firstVisibleChildAtMinimumHeight = r1;
            r5.firstVisibleChildPercentageShown = r4 / r3.getHeight();
            return r5;
        L17:
            if ((-r6) < r8.getTotalScrollRange()) goto L19;
            r10 = true;
            goto L20
        L13:
            r9 = false;
        L25:
            r2 = r2 + 1;
            goto L3
        L26:
            return null;
        }

        void restoreScrollState(SavedState r2, boolean r3) {
            if (this.savedState == null) goto L5;
            if (r3 == true) goto L5;
            return;
        L5:
            this.savedState = r2;
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T r1, int r2);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public DragCallback() {
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
            return super.onInterceptTouchEvent(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, AppBarLayout r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, AppBarLayout r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4, int r5, int[] r6, int r7) {
            super.onNestedPreScroll(r1, r2, r3, r4, r5, r6, r7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
            super.onNestedScroll(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, AppBarLayout r2, Parcelable r3) {
            super.onRestoreInstanceState(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, AppBarLayout r2) {
            return super.onSaveInstanceState(r1, r2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, View r4, int r5, int r6) {
            return super.onStartNestedScroll(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, AppBarLayout r2, View r3, int r4) {
            super.onStopNestedScroll(r1, r2, r3, r4);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
            return super.onTouchEvent(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.BaseDragCallback r1) {
            super.setDragCallback(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(AppBarLayout r1, View r2, float r3);

        public ChildScrollEffect() {
        }
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect;
        private final Rect relativeRect;

        public CompressChildScrollEffect() {
            this.relativeRect = new Rect();
            this.ghostRect = new Rect();
        }

        private static void updateRelativeRect(Rect r0, AppBarLayout r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(AppBarLayout r3, View r4, float r5) {
            updateRelativeRect(this.relativeRect, r3, r4);
            float r6 = this.relativeRect.top - Math.abs(r5);
            if (r6 > 0.0f) goto L5;
            float r7 = 1.0f - MathUtils.clamp(Math.abs(r6 / this.relativeRect.height()), 0.0f, 1.0f);
            float r8 = (-r6) - ((this.relativeRect.height() * 0.3f) * (1.0f - (r7 * r7)));
            r4.setTranslationY(r8);
            r4.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-r8));
            ViewCompat.setClipBounds(r4, this.ghostRect);
            return;
        L5:
            ViewCompat.setClipBounds(r4, null);
            r4.setTranslationY(0.0f);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.scrollFlags = 1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r5.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(r5.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if (r5.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator) == false) goto L5;
            this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(r3, r5.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        L5:
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.scrollFlags = 1;
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.scrollFlags = 1;
            this.scrollFlags = r2.scrollFlags;
            this.scrollEffect = r2.scrollEffect;
            this.scrollInterpolator = r2.scrollInterpolator;
        }

        public void setScrollFlags(int r1) {
            this.scrollFlags = r1;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        private ChildScrollEffect createScrollEffectFromInt(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public void setScrollEffect(ChildScrollEffect r1) {
            this.scrollEffect = r1;
        }

        public void setScrollEffect(int r1) {
            this.scrollEffect = createScrollEffectFromInt(r1);
        }

        public void setScrollInterpolator(Interpolator r1) {
            this.scrollInterpolator = r1;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int r2 = this.scrollFlags;
            if ((r2 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r2 & 10) == 0) goto L7;
            return true;
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(float r1, int r2);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout r1, int r2);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View findFirstDependency(List r1) {
            return findFirstDependency(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context r2, AttributeSet r3) {
            super(r2, r3);
            TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(r4.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            r4.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
            return r3 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
            offsetChildAsNeeded(r2, r3);
            updateLiftedStateIfNeeded(r2, r3);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
            if ((r3 instanceof AppBarLayout) == false) goto L6;
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            ViewCompat.setAccessibilityDelegate(r1, null);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r4, View r5, Rect r6, boolean r7) {
            AppBarLayout r0 = findFirstDependency(r4.getDependencies(r5));
            if (r0 == null) goto L8;
            Rect r2 = new Rect(r6);
            r2.offset(r5.getLeft(), r5.getTop());
            Rect r3 = this.tempRect1;
            r3.set(0, 0, r4.getWidth(), r4.getHeight());
            if (r3.contains(r2) == true) goto L8;
            r0.setExpanded(false, !r7);
            return true;
        L8:
            return false;
        }

        private void offsetChildAsNeeded(View r4, View r5) {
            CoordinatorLayout.Behavior r0 = ((CoordinatorLayout.LayoutParams) r5.getLayoutParams()).getBehavior();
            if ((r0 instanceof BaseBehavior) == false) goto L6;
            ViewCompat.offsetTopAndBottom(r4, (((r5.getBottom() - r4.getTop()) + BaseBehavior.access$100((BaseBehavior) r0)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r5));
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View r4) {
            if ((r4 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r5 = (AppBarLayout) r4;
            int r3 = r5.getTotalScrollRange();
            int r1 = r5.getDownNestedPreScrollRange();
            int r6 = getAppBarLayoutOffset(r5);
            if (r1 != 0) goto L7;
        L9:
            int r7 = r3 - r1;
            if (r7 == 0) goto L13;
            return (r6 / r7) + 1.0f;
        L7:
            if ((r3 + r6) > r1) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(AppBarLayout r1) {
            CoordinatorLayout.Behavior r2 = ((CoordinatorLayout.LayoutParams) r1.getLayoutParams()).getBehavior();
            if ((r2 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r2).getTopBottomOffsetForScrollingSibling();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        AppBarLayout findFirstDependency(List<View> r4) {
            int r3 = r4.size();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            View r1 = r4.get(r0);
            if ((r1 instanceof AppBarLayout) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return (AppBarLayout) r1;
        L9:
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View r2) {
            if ((r2 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r2).getTotalScrollRange();
        L7:
            return super.getScrollRange(r2);
        }

        private void updateLiftedStateIfNeeded(View r1, View r2) {
            if ((r2 instanceof AppBarLayout) == false) goto L8;
            AppBarLayout r3 = (AppBarLayout) r2;
            if (r3.isLiftOnScroll() == false) goto L9;
            r3.setLiftedState(r3.shouldLift(r1));
            return;
        L9:
            return;
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(Context r2) {
        this(r2, null);
    }

    public AppBarLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.appBarLayoutStyle);
    }

    public AppBarLayout(Context r9, AttributeSet r10, int r11) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r9, r10, r11, r4), r10, r11);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context r7 = getContext();
        setOrientation(1);
        if (getOutlineProvider() != ViewOutlineProvider.BACKGROUND) goto L5;
        ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
    L5:
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, r10, r11, r4);
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r7, r10, R.styleable.AppBarLayout, r11, r4, new int[0]);
        ViewCompat.setBackground(this, r12.getDrawable(R.styleable.AppBarLayout_android_background));
        ColorStateList r13 = MaterialResources.getColorStateList(r7, r12, R.styleable.AppBarLayout_liftOnScrollColor);
        this.liftOnScrollColor = r13;
        if ((getBackground() instanceof ColorDrawable) == false) goto L12;
        ColorDrawable r0 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r1.setFillColor(ColorStateList.valueOf(r0.getColor()));
        if (r13 == null) goto L10;
        initializeLiftOnScrollWithColor(r1);
    L11:
        ViewCompat.setBackground(this, r1);
        goto L12
    L10:
        initializeLiftOnScrollWithElevation(r7, r1);
    L12:
        this.liftOnScrollColorDuration = MotionUtils.resolveThemeDuration(r7, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.liftOnScrollColorInterpolator = MotionUtils.resolveThemeInterpolator(r7, R.attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        if (r12.hasValue(R.styleable.AppBarLayout_expanded) == false) goto L16;
        setExpanded(r12.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
    L16:
        if (r12.hasValue(R.styleable.AppBarLayout_elevation) == false) goto L19;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r12.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
    L19:
        if (r12.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster) == false) goto L22;
        setKeyboardNavigationCluster(r12.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
    L22:
        if (r12.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus) == false) goto L24;
        setTouchscreenBlocksFocus(r12.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
    L24:
        this.appBarElevation = getResources().getDimension(R.dimen.design_appbar_elevation);
        this.liftOnScroll = r12.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = r12.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(r12.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        r12.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    private void initializeLiftOnScrollWithColor(final MaterialShapeDrawable r2) {
        if (this.lifted == false) goto L5;
        int r0 = 255;
    L6:
        r2.setAlpha(r0);
        r2.setFillColor(this.liftOnScrollColor);
        this.liftOnScrollColorUpdateListener = new AppBarLayout$$ExternalSyntheticLambda0(this, r2);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$initializeLiftOnScrollWithColor$0$com-google-android-material-appbar-AppBarLayout, reason: not valid java name */
    /* synthetic */ void m238x91f594d8(MaterialShapeDrawable r4, ValueAnimator r5) {
        int r6 = (int) ((Float) r5.getAnimatedValue()).floatValue();
        r4.setAlpha(r6);
        Iterator<LiftOnScrollListener> r3 = this.liftOnScrollListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        LiftOnScrollListener r0 = r3.next();
        if (r4.getFillColor() == null) goto L4;
        r0.onUpdate(0.0f, r4.getFillColor().withAlpha(r6).getDefaultColor());
        goto L4
    }

    private void initializeLiftOnScrollWithElevation(Context r1, final MaterialShapeDrawable r2) {
        r2.initializeElevationOverlay(r1);
        this.liftOnScrollColorUpdateListener = new AppBarLayout$$ExternalSyntheticLambda1(this, r2);
    }

    /* JADX INFO: renamed from: lambda$initializeLiftOnScrollWithElevation$1$com-google-android-material-appbar-AppBarLayout, reason: not valid java name */
    /* synthetic */ void m239x84b6053(MaterialShapeDrawable r3, ValueAnimator r4) {
        float r5 = ((Float) r4.getAnimatedValue()).floatValue();
        r3.setElevation(r5);
        Drawable r0 = this.statusBarForeground;
        if ((r0 instanceof MaterialShapeDrawable) == false) goto L5;
        ((MaterialShapeDrawable) r0).setElevation(r5);
    L5:
        Iterator<LiftOnScrollListener> r2 = this.liftOnScrollListeners.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().onUpdate(r5, r3.getResolvedTintColor());
        goto L7
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener r2) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r2) == true) goto L11;
        this.listeners.add(r2);
        return;
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener r1) {
        addOnOffsetChangedListener(r1);
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener r1) {
        List<BaseOnOffsetChangedListener> r0 = this.listeners;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.remove(r1);
        return;
    L8:
        return;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener r1) {
        removeOnOffsetChangedListener(r1);
    }

    public void addLiftOnScrollListener(LiftOnScrollListener r1) {
        this.liftOnScrollListeners.add(r1);
    }

    public boolean removeLiftOnScrollListener(LiftOnScrollListener r1) {
        return this.liftOnScrollListeners.remove(r1);
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    public void setStatusBarForeground(Drawable r3) {
        Drawable r0 = this.statusBarForeground;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.statusBarForeground = r1;
        if (r1 != null) goto L12;
    L19:
        updateWillNotDraw();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.statusBarForeground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.statusBarForeground;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.statusBarForeground.setCallback(this);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarForegroundColor(int r2) {
        setStatusBarForeground(new ColorDrawable(r2));
    }

    public void setStatusBarForegroundResource(int r2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), r2));
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Override // android.view.View
    public void draw(Canvas r4) {
        super.draw(r4);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r0 = r4.save();
        r4.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r4);
        r4.restoreToCount(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarForeground;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStateful() == true) goto L7;
        return;
    L7:
        if (r1.setState(r0) == false) goto L12;
        invalidateDrawable(r1);
        return;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.statusBarForeground) goto L8;
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        Drawable r1 = this.statusBarForeground;
        if (r1 == null) goto L10;
        r1.setVisible(r3, false);
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getMode(r4);
        if (r5 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r0 = getMeasuredHeight();
        if (r5 == Integer.MIN_VALUE) goto L13;
        if (r5 != 0) goto L14;
        r0 = r0 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r0);
        goto L15
    L13:
        r0 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(r4));
        goto L14
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        boolean r6 = true;
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r7 = getChildCount();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L15;
        if (((LayoutParams) getChildAt(r8).getLayoutParams()).getScrollInterpolator() != null) goto L13;
        r8 = r8 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r9 = this.statusBarForeground;
        if (r9 == null) goto L19;
        r9.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r6);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r6 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r10 = getTopInset();
        int r11 = getChildCount() - 1;
    L7:
        if (r11 < 0) goto L9;
        ViewCompat.offsetTopAndBottom(getChildAt(r11), r10);
        r11 = r11 - 1;
        goto L7
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    private boolean shouldDrawStatusBarForeground() {
        if (this.statusBarForeground != null) goto L5;
    L7:
        return false;
    L5:
        if (getTopInset() <= 0) goto L7;
        return true;
    }

    private boolean hasCollapsibleChild() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((LayoutParams) getChildAt(r2).getLayoutParams()).isCollapsible() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void invalidateScrollRanges() {
        Behavior r0 = this.behavior;
        if (r0 != null) goto L5;
    L10:
        BaseBehavior.SavedState r1 = null;
    L11:
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (r1 == null) goto L15;
        this.behavior.restoreScrollState(r1, false);
        return;
    L15:
        return;
    L5:
        if (this.totalScrollRange == (-1)) goto L10;
        if (this.pendingAction != 0) goto L10;
        r1 = r0.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        goto L11
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 != 1) goto L7;
        super.setOrientation(r2);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior r0 = new Behavior();
        this.behavior = r0;
        return r0;
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setExpanded(boolean r2) {
        setExpanded(r2, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean r2, boolean r3) {
        setExpanded(r2, r3, true);
    }

    private void setExpanded(boolean r2, boolean r3, boolean r4) {
        if (r2 == false) goto L4;
        int r5 = 1;
    L5:
        int r0 = 0;
        if (r3 == false) goto L8;
        int r6 = 4;
    L9:
        int r7 = r5 | r6;
        if (r4 == false) goto L12;
        r0 = 8;
    L12:
        this.pendingAction = r7 | r0;
        requestLayout();
        return;
    L8:
        r6 = 0;
        goto L9
    L4:
        r5 = 2;
        goto L5
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return new LayoutParams((LinearLayout.LayoutParams) r1);
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L11:
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public final int getTotalScrollRange() {
        int r0 = this.totalScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L21;
        View r4 = getChildAt(r2);
        if (r4.getVisibility() == 8) goto L20;
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        int r6 = r4.getMeasuredHeight();
        int r7 = r5.scrollFlags;
        if ((r7 & 1) == 0) goto L21;
        r3 = r3 + ((r6 + r5.topMargin) + r5.bottomMargin);
        if (r2 != 0) goto L18;
        if (ViewCompat.getFitsSystemWindows(r4) == false) goto L18;
        r3 = r3 - getTopInset();
    L18:
        if ((r7 & 2) == 0) goto L20;
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L20:
        r2 = r2 + 1;
    L21:
        int r8 = Math.max(0, r3);
        this.totalScrollRange = r8;
        return r8;
    }

    boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int r0 = this.downPreScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount() - 1;
        int r2 = 0;
    L6:
        if (r1 < 0) goto L28;
        View r3 = getChildAt(r1);
        if (r3.getVisibility() == 8) goto L27;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        int r5 = r3.getMeasuredHeight();
        int r6 = r4.scrollFlags;
        if ((r6 & 5) != 5) goto L25;
        int r7 = r4.topMargin + r4.bottomMargin;
        if ((r6 & 8) == 0) goto L17;
        int r8 = ViewCompat.getMinimumHeight(r3);
    L15:
        int r9 = r7 + r8;
    L20:
        if (r1 == 0) goto L22;
    L24:
        r2 = r2 + r9;
        goto L27
    L22:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L24;
        r9 = Math.min(r9, r5 - getTopInset());
        goto L24
    L17:
        if ((r6 & 2) == 0) goto L19;
        r8 = r5 - ViewCompat.getMinimumHeight(r3);
        goto L15
    L19:
        r9 = r7 + r5;
        goto L20
    L25:
        if (r2 > 0) goto L28;
    L27:
        r1 = r1 - 1;
    L28:
        int r10 = Math.max(0, r2);
        this.downPreScrollRange = r10;
        return r10;
    }

    int getDownNestedScrollRange() {
        int r0 = this.downScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L16;
        View r4 = getChildAt(r2);
        if (r4.getVisibility() == 8) goto L15;
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        int r6 = r4.getMeasuredHeight() + (r5.topMargin + r5.bottomMargin);
        int r7 = r5.scrollFlags;
        if ((r7 & 1) == 0) goto L16;
        r3 = r3 + r6;
        if ((r7 & 2) == 0) goto L15;
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L15:
        r2 = r2 + 1;
    L16:
        int r8 = Math.max(0, r3);
        this.downScrollRange = r8;
        return r8;
    }

    void onOffsetChanged(int r4) {
        this.currentOffset = r4;
        if (willNotDraw() == true) goto L5;
        ViewCompat.postInvalidateOnAnimation(this);
    L5:
        List<BaseOnOffsetChangedListener> r0 = this.listeners;
        if (r0 == null) goto L13;
        int r1 = r0.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        BaseOnOffsetChangedListener r3 = this.listeners.get(r2);
        if (r3 == null) goto L12;
        r3.onOffsetChanged(this, r4);
    L12:
        r2 = r2 + 1;
        goto L8
    L17:
        return;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r0 = getTopInset();
        int r1 = ViewCompat.getMinimumHeight(this);
        if (r1 != 0) goto L5;
        int r2 = getChildCount();
        if (r2 < 1) goto L9;
        r1 = ViewCompat.getMinimumHeight(getChildAt(r2 - 1));
    L10:
        if (r1 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r1 = 0;
    L5:
        return (r1 * 2) + r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r4) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r0 = this.tmpStatesArray;
        int[] r5 = super.onCreateDrawableState(r4 + r0.length);
        if (this.liftable == false) goto L8;
        int r1 = R.attr.state_liftable;
    L9:
        r0[0] = r1;
        if (this.liftable == true) goto L12;
    L14:
        int r2 = -R.attr.state_lifted;
    L15:
        r0[1] = r2;
        if (this.liftable == false) goto L18;
        int r3 = R.attr.state_collapsible;
    L19:
        r0[2] = r3;
        if (this.liftable == true) goto L22;
    L24:
        int r6 = -R.attr.state_collapsed;
    L25:
        r0[3] = r6;
        return mergeDrawableStates(r5, r0);
    L22:
        if (this.lifted == false) goto L24;
        r6 = R.attr.state_collapsed;
        goto L25
    L18:
        r3 = -R.attr.state_collapsible;
        goto L19
    L12:
        if (this.lifted == false) goto L14;
        r2 = R.attr.state_lifted;
        goto L15
    L8:
        r1 = -R.attr.state_liftable;
        goto L9
    }

    public boolean setLiftable(boolean r2) {
        this.liftableOverride = true;
        return setLiftableState(r2);
    }

    public void setLiftableOverrideEnabled(boolean r1) {
        this.liftableOverride = r1;
    }

    private boolean setLiftableState(boolean r2) {
        if (this.liftable == r2) goto L6;
        this.liftable = r2;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    public boolean setLifted(boolean r2) {
        return setLiftedState(r2, true);
    }

    public boolean isLifted() {
        return this.lifted;
    }

    boolean setLiftedState(boolean r2) {
        return setLiftedState(r2, !this.liftableOverride);
    }

    boolean setLiftedState(boolean r3, boolean r4) {
        if (r4 == true) goto L4;
        return false;
    L4:
        if (this.lifted == r3) goto L31;
        this.lifted = r3;
        refreshDrawableState();
        if (this.liftOnScroll == true) goto L8;
        return true;
    L8:
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L29;
        float r0 = 0.0f;
        if (this.liftOnScrollColor != null) goto L12;
        if (r3 == false) goto L20;
        float r5 = 0.0f;
    L21:
        if (r3 == false) goto L23;
        r0 = this.appBarElevation;
    L23:
        startLiftOnScrollColorAnimation(r5, r0);
        return true;
    L20:
        r5 = this.appBarElevation;
        goto L21
    L12:
        if (r3 == false) goto L14;
        float r1 = 0.0f;
    L15:
        if (r3 == false) goto L17;
        r0 = 255.0f;
    L17:
        startLiftOnScrollColorAnimation(r1, r0);
        return true;
    L14:
        r1 = 255.0f;
        goto L15
    L29:
        return true;
    L31:
        return false;
    }

    private void startLiftOnScrollColorAnimation(float r3, float r4) {
        ValueAnimator r0 = this.liftOnScrollColorAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{r3, r4});
        this.liftOnScrollColorAnimator = r5;
        r5.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator.AnimatorUpdateListener r6 = this.liftOnScrollColorUpdateListener;
        if (r6 == null) goto L8;
        this.liftOnScrollColorAnimator.addUpdateListener(r6);
    L8:
        this.liftOnScrollColorAnimator.start();
    }

    public void setLiftOnScroll(boolean r1) {
        this.liftOnScroll = r1;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public void setLiftOnScrollTargetView(View r2) {
        this.liftOnScrollTargetViewId = -1;
        if (r2 != null) goto L5;
        clearLiftOnScrollTargetView();
        return;
    L5:
        this.liftOnScrollTargetView = new WeakReference(r2);
    }

    public void setLiftOnScrollTargetViewId(int r1) {
        this.liftOnScrollTargetViewId = r1;
        clearLiftOnScrollTargetView();
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    boolean shouldLift(View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    private View findLiftOnScrollTargetView(View r4) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L15;
        if (r4 == null) goto L8;
        View r5 = r4.findViewById(r0);
    L9:
        if (r5 == null) goto L11;
    L13:
        if (r5 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r5);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r5 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r5 = null;
    L15:
        WeakReference<View> r3 = this.liftOnScrollTargetView;
        if (r3 != null) goto L18;
        return null;
    L18:
        return r3.get();
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r0 = this.liftOnScrollTargetView;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    @Deprecated
    public void setTargetElevation(float r1) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r1);
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    final int getTopInset() {
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSystemWindowInsetTop();
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) goto L10;
        View r3 = getChildAt(0);
        if (r3.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }
}
