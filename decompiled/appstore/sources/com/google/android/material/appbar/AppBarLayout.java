package com.google.android.material.appbar;

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
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.b;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p.a;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;

    @Nullable
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private int offsetToChildIndexOnLayout;
        private boolean offsetToChildIndexOnLayoutIsMinHeight;
        private float offsetToChildIndexOnLayoutPerc;
        private BaseDragCallback onDragCallback;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public BaseDragCallback() {
            }

            public abstract boolean canDrag(@NonNull T r10);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState(@NonNull Parcel r10, ClassLoader r11) {
                super(r10, r11);
                this.firstVisibleChildIndex = r10.readInt();
                this.firstVisibleChildPercentageShown = r10.readFloat();
                if (r10.readByte() == 0) goto L5;
                boolean r12 = true;
            L6:
                this.firstVisibleChildAtMinimumHeight = r12;
                return;
            L5:
                r12 = false;
                goto L6
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel r10, int r11) {
                super.writeToParcel(r10, r11);
                r10.writeInt(this.firstVisibleChildIndex);
                r10.writeFloat(this.firstVisibleChildPercentageShown);
                r10.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }

            public SavedState(Parcelable r10) {
                super(r10);
            }
        }

        public BaseBehavior() {
            this.offsetToChildIndexOnLayout = -1;
        }

        public static /* synthetic */ int access$000(BaseBehavior r10) {
            return r10.offsetDelta;
        }

        private void addAccessibilityScrollActions(final CoordinatorLayout r10, @NonNull final T r11, @NonNull final View r12) {
            if (getTopBottomOffsetForScrollingSibling() == (-r11.getTotalScrollRange())) goto L8;
            if (r12.canScrollVertically(1) == false) goto L8;
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.a.f2750q, false);
        L8:
            if (getTopBottomOffsetForScrollingSibling() != 0) goto L10;
            return;
        L10:
            if (r12.canScrollVertically(-1) == false) goto L14;
            final int r13 = -r11.getDownNestedPreScrollRange();
            if (r13 == 0) goto L17;
            ViewCompat.l0(r10, AccessibilityNodeInfoCompat.a.f2751r, null, new AnonymousClass2(this, r10, r11, r12, r13));
            return;
        L17:
            return;
        L14:
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.a.f2751r, true);
        }

        private void addActionToExpand(CoordinatorLayout r10, @NonNull final T r11, @NonNull AccessibilityNodeInfoCompat.a r12, final boolean r13) {
            ViewCompat.l0(r10, r12, null, new AnonymousClass3(this, r11, r13));
        }

        private void animateOffsetTo(CoordinatorLayout r10, @NonNull T r11, int r12, float r13) {
            int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
            float r15 = Math.abs(r13);
            if (r15 <= 0.0f) goto L5;
            int r16 = Math.round((r14 / r15) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r10, r11, r12, r16);
            return;
        L5:
            r16 = (int) (((r14 / r11.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(final CoordinatorLayout r10, final T r11, int r12, int r13) {
            int r14 = getTopBottomOffsetForScrollingSibling();
            if (r14 != r12) goto L10;
            ValueAnimator r15 = this.offsetAnimator;
            if (r15 != null) goto L7;
            return;
        L7:
            if (r15.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r16 = this.offsetAnimator;
            if (r16 != null) goto L13;
            ValueAnimator r17 = new ValueAnimator();
            this.offsetAnimator = r17;
            r17.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r10, r11));
        L14:
            this.offsetAnimator.setDuration(Math.min(r13, 600));
            this.offsetAnimator.setIntValues(new int[]{r14, r12});
            this.offsetAnimator.start();
            return;
        L13:
            r16.cancel();
            goto L14
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12) {
            if (r11.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L7;
            return true;
        }

        private static boolean checkFlag(int r10, int r11) {
            if ((r10 & r11) != r11) goto L5;
            return true;
        L5:
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout r10) {
            int r11 = r10.getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L13;
            View r13 = r10.getChildAt(r12);
            if ((r13 instanceof NestedScrollingChild) == true) goto L12;
            if ((r13 instanceof ListView) == true) goto L12;
            if ((r13 instanceof ScrollView) == true) goto L12;
            r12 = r12 + 1;
        L12:
            return r13;
        L13:
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout r10, int r11) {
            int r12 = Math.abs(r11);
            int r13 = r10.getChildCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L10;
            View r15 = r10.getChildAt(r14);
            if (r12 < r15.getTop()) goto L9;
            if (r12 > r15.getBottom()) goto L9;
            return r15;
        L9:
            r14 = r14 + 1;
            goto L3
        L10:
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T r10, int r11) {
            int r12 = r10.getChildCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L12;
            View r14 = r10.getChildAt(r13);
            int r15 = r14.getTop();
            int r16 = r14.getBottom();
            LayoutParams r17 = (LayoutParams) r14.getLayoutParams();
            if (checkFlag(r17.getScrollFlags(), 32) == false) goto L7;
            r15 = r15 - ((LinearLayout.LayoutParams) r17).topMargin;
            r16 = r16 + ((LinearLayout.LayoutParams) r17).bottomMargin;
        L7:
            int r18 = -r11;
            if (r15 > r18) goto L11;
            if (r16 < r18) goto L11;
            return r13;
        L11:
            r13 = r13 + 1;
            goto L3
        L12:
            return -1;
        }

        private int interpolateOffset(@NonNull T r10, int r11) {
            int r12 = Math.abs(r11);
            int r13 = r10.getChildCount();
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L21;
            View r16 = r10.getChildAt(r15);
            LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
            Interpolator r18 = r17.getScrollInterpolator();
            if (r12 < r16.getTop()) goto L20;
            if (r12 > r16.getBottom()) goto L20;
            if (r18 == null) goto L21;
            int r19 = r17.getScrollFlags();
            if ((r19 & 1) == 0) goto L15;
            r14 = (r16.getHeight() + ((LinearLayout.LayoutParams) r17).topMargin) + ((LinearLayout.LayoutParams) r17).bottomMargin;
            if ((r19 & 2) == 0) goto L15;
            r14 = r14 - ViewCompat.B(r16);
        L15:
            if (ViewCompat.x(r16) == false) goto L17;
            r14 = r14 - r10.getTopInset();
        L17:
            if (r14 <= 0) goto L21;
            float r20 = r14;
            return Integer.signum(r11) * (r16.getTop() + Math.round(r20 * r18.getInterpolation((r12 - r16.getTop()) / r20)));
        L20:
            r15 = r15 + 1;
        L21:
            return r11;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            List<View> r12 = r10.getDependents(r11);
            int r13 = r12.size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L11;
            CoordinatorLayout.Behavior r15 = ((CoordinatorLayout.c) r12.get(r14).getLayoutParams()).f();
            if ((r15 instanceof ScrollingViewBehavior) == true) goto L7;
            r14 = r14 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) r15).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r10, @NonNull T r11) {
            int r12 = getTopBottomOffsetForScrollingSibling();
            int r13 = getChildIndexOnOffset(r11, r12);
            if (r13 < 0) goto L26;
            View r14 = r11.getChildAt(r13);
            LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
            int r16 = r15.getScrollFlags();
            if ((r16 & 17) != 17) goto L27;
            int r17 = -r14.getTop();
            int r18 = -r14.getBottom();
            if (r13 != (r11.getChildCount() - 1)) goto L10;
            r18 = r18 + r11.getTopInset();
        L10:
            if (checkFlag(r16, 2) == false) goto L13;
            r18 = r18 + ViewCompat.B(r14);
        L19:
            if (checkFlag(r16, 32) == false) goto L22;
            r17 = r17 + ((LinearLayout.LayoutParams) r15).topMargin;
            r18 = r18 - ((LinearLayout.LayoutParams) r15).bottomMargin;
        L22:
            if (r12 >= ((r18 + r17) / 2)) goto L24;
            r17 = r18;
        L24:
            animateOffsetTo(r10, r11, a.b(r17, -r11.getTotalScrollRange(), 0), 0.0f);
            return;
        L13:
            if (checkFlag(r16, 5) == false) goto L19;
            int r19 = ViewCompat.B(r14) + r18;
            if (r12 >= r19) goto L17;
            r17 = r19;
            goto L19
        L17:
            r18 = r19;
            goto L19
        L27:
            return;
        }

        private void updateAccessibilityActions(CoordinatorLayout r10, @NonNull T r11) {
            ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2750q.b());
            ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2751r.b());
            View r12 = findFirstScrollingChild(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11.getTotalScrollRange() != 0) goto L8;
            return;
        L8:
            if ((((CoordinatorLayout.c) r12.getLayoutParams()).f() instanceof ScrollingViewBehavior) == true) goto L10;
            return;
        L10:
            addAccessibilityScrollActions(r10, r11, r12);
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, boolean r14) {
            View r15 = getAppBarChildOnOffset(r11, r12);
            if (r15 == null) goto L28;
            int r16 = ((LayoutParams) r15.getLayoutParams()).getScrollFlags();
            boolean r17 = false;
            if ((r16 & 1) == 0) goto L19;
            int r18 = ViewCompat.B(r15);
            if (r13 <= 0) goto L14;
            if ((r16 & 12) == 0) goto L14;
            if ((-r12) < ((r15.getBottom() - r18) - r11.getTopInset())) goto L19;
        L12:
            r17 = true;
        L14:
            if ((r16 & 2) == 0) goto L19;
            if ((-r12) >= ((r15.getBottom() - r18) - r11.getTopInset())) goto L12;
        L19:
            if (r11.isLiftOnScroll() == false) goto L21;
            r17 = r11.shouldLift(findFirstScrollingChild(r10));
        L21:
            boolean r19 = r11.setLiftedState(r17);
            if (r14 == true) goto L26;
            if (r19 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r10, r11) == true) goto L26;
            return;
        L26:
            r11.jumpDrawablesToCurrentState();
            return;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return canDragView((AppBarLayout) r10);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r10) {
            return getMaxDragOffset((AppBarLayout) r10);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r10) {
            return getScrollRangeForDragFling((AppBarLayout) r10);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator r10 = this.offsetAnimator;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isRunning() == false) goto L7;
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            onFlingFinished(r10, (AppBarLayout) r11);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (AppBarLayout) r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
            return onMeasureChild(r10, (AppBarLayout) r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int[] r15, int r16) {
            onNestedPreScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15, r16);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            onNestedScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11, Parcelable r12) {
            onRestoreInstanceState(r10, (AppBarLayout) r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull View r11) {
            return onSaveInstanceState(r10, (AppBarLayout) r11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, View r13, int r14, int r15) {
            return onStartNestedScroll(r10, (AppBarLayout) r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull View r11, View r12, int r13) {
            onStopNestedScroll(r10, (AppBarLayout) r11, r12, r13);
        }

        public void setDragCallback(@Nullable BaseDragCallback r10) {
            this.onDragCallback = r10;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14) {
            return setHeaderTopBottomOffset(r10, (AppBarLayout) r11, r12, r13, r14);
        }

        public boolean canDragView(T r10) {
            BaseDragCallback r11 = this.onDragCallback;
            if (r11 != null) goto L5;
            WeakReference<View> r12 = this.lastNestedScrollingChildRef;
            if (r12 == null) goto L17;
            View r13 = r12.get();
            if (r13 != null) goto L11;
        L15:
            return false;
        L11:
            if (r13.isShown() == false) goto L15;
            if (r13.canScrollVertically(-1) == true) goto L15;
            return true;
        L17:
            return true;
        L5:
            return r11.canDrag(r10);
        }

        public int getMaxDragOffset(@NonNull T r10) {
            return -r10.getDownNestedScrollRange();
        }

        public int getScrollRangeForDragFling(@NonNull T r10) {
            return r10.getTotalScrollRange();
        }

        public void onFlingFinished(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            snapToChildIfNeeded(r10, r11);
            if (r11.isLiftOnScroll() == false) goto L6;
            r11.setLiftedState(r11.shouldLift(findFirstScrollingChild(r10)));
            return;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12) {
            boolean r13 = super.onLayoutChild(r10, r11, r12);
            int r14 = r11.getPendingAction();
            int r15 = this.offsetToChildIndexOnLayout;
            if (r15 >= 0) goto L5;
        L12:
            if (r14 != 0) goto L14;
        L28:
            r11.resetPendingAction();
            this.offsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(a.b(getTopAndBottomOffset(), -r11.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r10, r11, getTopAndBottomOffset(), 0, true);
            r11.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(r10, r11);
            return r13;
        L14:
            if ((r14 & 4) == 0) goto L16;
            boolean r16 = true;
        L18:
            if ((r14 & 2) == 0) goto L24;
            int r17 = -r11.getUpNestedPreScrollRange();
            if (r16 == false) goto L22;
            animateOffsetTo(r10, r11, r17, 0.0f);
            goto L28
        L22:
            setHeaderTopBottomOffset(r10, r11, r17);
            goto L28
        L24:
            if ((r14 & 1) == 0) goto L28;
            if (r16 == false) goto L27;
            animateOffsetTo(r10, r11, 0, 0.0f);
            goto L28
        L27:
            setHeaderTopBottomOffset(r10, r11, 0);
            goto L28
        L16:
            r16 = false;
            goto L18
        L5:
            if ((r14 & 8) != 0) goto L12;
            View r18 = r11.getChildAt(r15);
            int r19 = -r18.getBottom();
            if (this.offsetToChildIndexOnLayoutIsMinHeight == false) goto L10;
            int r20 = ViewCompat.B(r18) + r11.getTopInset();
        L11:
            setHeaderTopBottomOffset(r10, r11, r19 + r20);
            goto L28
        L10:
            r20 = Math.round(r18.getHeight() * this.offsetToChildIndexOnLayoutPerc);
            goto L11
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14, int r15) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.c) r11.getLayoutParams())).height != (-2)) goto L7;
            r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
            return true;
        L7:
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        public void onNestedPreScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int[] r15, int r16) {
            if (r14 == 0) goto L10;
            if (r14 >= 0) goto L6;
            int r17 = -r11.getTotalScrollRange();
            int r18 = r11.getDownNestedPreScrollRange() + r17;
        L5:
            int r19 = r17;
            int r20 = r18;
            if (r19 == r20) goto L10;
            r15[1] = scroll(r10, r11, r14, r19, r20);
            goto L10
        L6:
            r17 = -r11.getUpNestedPreScrollRange();
            r18 = 0;
        L10:
            if (r11.isLiftOnScroll() == false) goto L13;
            r11.setLiftedState(r11.shouldLift(r12));
            return;
        }

        public void onNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            if (r16 >= 0) goto L4;
            r18[1] = scroll(r10, r11, r16, -r11.getDownNestedScrollRange(), 0);
        L4:
            if (r16 != 0) goto L7;
            updateAccessibilityActions(r10, r11);
            return;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11, Parcelable r12) {
            if ((r12 instanceof SavedState) == false) goto L5;
            SavedState r13 = (SavedState) r12;
            super.onRestoreInstanceState(r10, r11, r13.getSuperState());
            this.offsetToChildIndexOnLayout = r13.firstVisibleChildIndex;
            this.offsetToChildIndexOnLayoutPerc = r13.firstVisibleChildPercentageShown;
            this.offsetToChildIndexOnLayoutIsMinHeight = r13.firstVisibleChildAtMinimumHeight;
            return;
        L5:
            super.onRestoreInstanceState(r10, r11, r12);
            this.offsetToChildIndexOnLayout = -1;
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull T r11) {
            Parcelable r12 = super.onSaveInstanceState(r10, r11);
            int r13 = getTopAndBottomOffset();
            int r14 = r11.getChildCount();
            boolean r15 = false;
            int r16 = 0;
        L3:
            if (r16 >= r14) goto L13;
            View r17 = r11.getChildAt(r16);
            int r18 = r17.getBottom() + r13;
            if ((r17.getTop() + r13) > 0) goto L12;
            if (r18 < 0) goto L12;
            SavedState r19 = new SavedState(r12);
            r19.firstVisibleChildIndex = r16;
            if (r18 != (ViewCompat.B(r17) + r11.getTopInset())) goto L10;
            r15 = true;
        L10:
            r19.firstVisibleChildAtMinimumHeight = r15;
            r19.firstVisibleChildPercentageShown = r18 / r17.getHeight();
            return r19;
        L12:
            r16 = r16 + 1;
            goto L3
        L13:
            return r12;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull T r11, @NonNull View r12, View r13, int r14, int r15) {
            if ((r14 & 2) != 0) goto L5;
        L9:
            boolean r16 = false;
        L10:
            if (r16 == false) goto L14;
            ValueAnimator r17 = this.offsetAnimator;
            if (r17 == null) goto L14;
            r17.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r15;
            return r16;
        L5:
            if (r11.isLiftOnScroll() == false) goto L7;
        L8:
            r16 = true;
            goto L10
        L7:
            if (canScrollChildren(r10, r11, r12) == false) goto L9;
            goto L8
        }

        public void onStopNestedScroll(CoordinatorLayout r10, @NonNull T r11, View r12, int r13) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r10, r11);
            if (r11.isLiftOnScroll() == false) goto L9;
            r11.setLiftedState(r11.shouldLift(r12));
        L9:
            this.lastNestedScrollingChildRef = new WeakReference(r12);
            return;
        L5:
            if (r13 != 1) goto L9;
            goto L6
        }

        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r10, @NonNull T r11, int r12, int r13, int r14) {
            int r15 = getTopBottomOffsetForScrollingSibling();
            int r16 = 0;
            if (r13 == 0) goto L23;
            if (r15 < r13) goto L23;
            if (r15 > r14) goto L23;
            int r17 = a.b(r12, r13, r14);
            if (r15 != r17) goto L9;
        L24:
            updateAccessibilityActions(r10, r11);
            return r16;
        L9:
            if (r11.hasChildWithInterpolator() == false) goto L11;
            int r18 = interpolateOffset(r11, r17);
        L12:
            boolean r19 = setTopAndBottomOffset(r18);
            r16 = r15 - r17;
            this.offsetDelta = r17 - r18;
            if (r19 == false) goto L15;
        L17:
            r11.onOffsetChanged(getTopAndBottomOffset());
            if (r17 >= r15) goto L21;
            int r110 = -1;
        L22:
            updateAppBarLayoutDrawableState(r10, r11, r17, r110, false);
            goto L24
        L21:
            r110 = 1;
            goto L22
        L15:
            if (r11.hasChildWithInterpolator() == false) goto L17;
            r10.dispatchDependentViewsChanged(r11);
            goto L17
        L11:
            r18 = r17;
        L23:
            this.offsetDelta = 0;
            goto L24
        }

        public BaseBehavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.offsetToChildIndexOnLayout = -1;
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T r10, int r11);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public DragCallback() {
            }
        }

        public Behavior() {
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

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, int r12) {
            return super.onLayoutChild(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, int r12, int r13, int r14, int r15) {
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13, int r14, int[] r15, int r16) {
            super.onNestedPreScroll(r10, r11, r12, r13, r14, r15, r16);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13, int r14, int r15, int r16, int r17, int[] r18) {
            super.onNestedScroll(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, Parcelable r12) {
            super.onRestoreInstanceState(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11) {
            return super.onSaveInstanceState(r10, r11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull AppBarLayout r11, @NonNull View r12, View r13, int r14, int r15) {
            return super.onStartNestedScroll(r10, r11, r12, r13, r14, r15);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, @NonNull AppBarLayout r11, View r12, int r13) {
            super.onStopNestedScroll(r10, r11, r12, r13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback r10) {
            super.setDragCallback(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r10) {
            super.setHorizontalOffsetEnabled(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r10) {
            return super.setLeftAndRightOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
            return super.setTopAndBottomOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r10) {
            super.setVerticalOffsetEnabled(r10);
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.scrollFlags = 1;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r12.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            int r13 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r12.hasValue(r13) == false) goto L5;
            this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(r10, r12.getResourceId(r13, 0));
        L5:
            r12.recycle();
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        public boolean isCollapsible() {
            int r10 = this.scrollFlags;
            if ((r10 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r10 & 10) == 0) goto L7;
            return true;
        }

        public void setScrollFlags(int r10) {
            this.scrollFlags = r10;
        }

        public void setScrollInterpolator(Interpolator r10) {
            this.scrollInterpolator = r10;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.scrollFlags = 1;
        }

        public LayoutParams(int r10, int r11, float r12) {
            super(r10, r11, r12);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams r10) {
            super(r10);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams r10) {
            super(r10);
            this.scrollFlags = 1;
            this.scrollFlags = r10.scrollFlags;
            this.scrollInterpolator = r10.scrollInterpolator;
        }
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout r10, int r11);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout r10) {
            CoordinatorLayout.Behavior r11 = ((CoordinatorLayout.c) r10.getLayoutParams()).f();
            if ((r11 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r11).getTopBottomOffsetForScrollingSibling();
        }

        private void offsetChildAsNeeded(@NonNull View r10, @NonNull View r11) {
            CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.c) r11.getLayoutParams()).f();
            if ((r12 instanceof BaseBehavior) == false) goto L6;
            ViewCompat.a0(r10, (((r11.getBottom() - r10.getTop()) + BaseBehavior.access$000((BaseBehavior) r12)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r11));
            return;
        }

        private void updateLiftedStateIfNeeded(View r10, View r11) {
            if ((r11 instanceof AppBarLayout) == false) goto L8;
            AppBarLayout r12 = (AppBarLayout) r11;
            if (r12.isLiftOnScroll() == false) goto L9;
            r12.setLiftedState(r12.shouldLift(r10));
            return;
        L9:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List r10) {
            return findFirstDependency(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View r10) {
            if ((r10 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r11 = (AppBarLayout) r10;
            int r12 = r11.getTotalScrollRange();
            int r13 = r11.getDownNestedPreScrollRange();
            int r14 = getAppBarLayoutOffset(r11);
            if (r13 != 0) goto L7;
        L9:
            int r15 = r12 - r13;
            if (r15 == 0) goto L13;
            return (r14 / r15) + 1.0f;
        L7:
            if ((r12 + r14) > r13) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int getScrollRange(View r10) {
            if ((r10 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r10).getTotalScrollRange();
        L7:
            return super.getScrollRange(r10);
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

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
            return r12 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
            offsetChildAsNeeded(r11, r12);
            updateLiftedStateIfNeeded(r11, r12);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
            if ((r12 instanceof AppBarLayout) == false) goto L6;
            ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2750q.b());
            ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2751r.b());
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return super.onLayoutChild(r10, r11, r12);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
            return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull Rect r12, boolean r13) {
            AppBarLayout r14 = findFirstDependency(r10.getDependencies(r11));
            if (r14 == null) goto L8;
            r12.offset(r11.getLeft(), r11.getTop());
            Rect r15 = this.tempRect1;
            r15.set(0, 0, r10.getWidth(), r10.getHeight());
            if (r15.contains(r12) == true) goto L8;
            r14.setExpanded(false, !r13);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r10) {
            super.setHorizontalOffsetEnabled(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r10) {
            return super.setLeftAndRightOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
            return super.setTopAndBottomOffset(r10);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r10) {
            super.setVerticalOffsetEnabled(r10);
        }

        public ScrollingViewBehavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(r12.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            r12.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> r10) {
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            View r13 = r10.get(r12);
            if ((r13 instanceof AppBarLayout) == true) goto L7;
            r12 = r12 + 1;
            goto L3
        L7:
            return (AppBarLayout) r13;
        L9:
            return null;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(@NonNull Context r10) {
        this(r10, null);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r10 = this.liftOnScrollTargetView;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View r10) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r11 = this.liftOnScrollTargetViewId;
        if (r11 == (-1)) goto L15;
        if (r10 == null) goto L8;
        View r12 = r10.findViewById(r11);
    L9:
        if (r12 == null) goto L11;
    L13:
        if (r12 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r12);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r12 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r12 = null;
    L15:
        WeakReference<View> r13 = this.liftOnScrollTargetView;
        if (r13 != null) goto L18;
        return null;
    L18:
        return r13.get();
    }

    private boolean hasCollapsibleChild() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((LayoutParams) getChildAt(r11).getLayoutParams()).isCollapsible() == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    private boolean setLiftableState(boolean r10) {
        if (this.liftable == r10) goto L6;
        this.liftable = r10;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    private boolean shouldDrawStatusBarForeground() {
        if (this.statusBarForeground != null) goto L5;
    L7:
        return false;
    L5:
        if (getTopInset() <= 0) goto L7;
        return true;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) goto L10;
        View r10 = getChildAt(0);
        if (r10.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.x(r10) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void startLiftOnScrollElevationOverlayAnimation(@NonNull final MaterialShapeDrawable r10, boolean r11) {
        float r12 = getResources().getDimension(R.dimen.design_appbar_elevation);
        if (r11 == false) goto L5;
        float r13 = 0.0f;
    L6:
        if (r11 == true) goto L9;
        r12 = 0.0f;
    L9:
        ValueAnimator r14 = this.elevationOverlayAnimator;
        if (r14 == null) goto L12;
        r14.cancel();
    L12:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r13, r12});
        this.elevationOverlayAnimator = r15;
        r15.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new AnonymousClass2(this, r10));
        this.elevationOverlayAnimator.start();
        return;
    L5:
        r13 = r12;
        goto L6
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r10) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r10) == true) goto L11;
        this.listeners.add(r10);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r11 = r10.save();
        r10.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r10);
        r10.restoreToCount(r11);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.statusBarForeground;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isStateful() == true) goto L7;
        return;
    L7:
        if (r11.setState(r10) == false) goto L12;
        invalidateDrawable(r11);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int r10 = this.downPreScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount() - 1;
        int r12 = 0;
    L6:
        if (r11 < 0) goto L25;
        View r13 = getChildAt(r11);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r15 = r13.getMeasuredHeight();
        int r16 = r14.scrollFlags;
        if ((r16 & 5) != 5) goto L22;
        int r17 = ((LinearLayout.LayoutParams) r14).topMargin + ((LinearLayout.LayoutParams) r14).bottomMargin;
        if ((r16 & 8) == 0) goto L14;
        int r18 = ViewCompat.B(r13);
    L12:
        int r19 = r17 + r18;
    L17:
        if (r11 == 0) goto L19;
    L21:
        r12 = r12 + r19;
    L24:
        r11 = r11 - 1;
        goto L6
    L19:
        if (ViewCompat.x(r13) == false) goto L21;
        r19 = Math.min(r19, r15 - getTopInset());
        goto L21
    L14:
        if ((r16 & 2) == 0) goto L16;
        r18 = r15 - ViewCompat.B(r13);
        goto L12
    L16:
        r19 = r17 + r15;
        goto L17
    L22:
        if (r12 <= 0) goto L24;
    L25:
        int r20 = Math.max(0, r12);
        this.downPreScrollRange = r20;
        return r20;
    }

    public int getDownNestedScrollRange() {
        int r10 = this.downScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L13;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        int r16 = r14.getMeasuredHeight() + (((LinearLayout.LayoutParams) r15).topMargin + ((LinearLayout.LayoutParams) r15).bottomMargin);
        int r17 = r15.scrollFlags;
        if ((r17 & 1) == 0) goto L13;
        r13 = r13 + r16;
        if ((r17 & 2) != 0) goto L11;
        r12 = r12 + 1;
        goto L6
    L11:
        r13 = r13 - ViewCompat.B(r14);
    L13:
        int r18 = Math.max(0, r13);
        this.downScrollRange = r18;
        return r18;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r10 = getTopInset();
        int r11 = ViewCompat.B(this);
        if (r11 != 0) goto L5;
        int r12 = getChildCount();
        if (r12 < 1) goto L9;
        r11 = ViewCompat.B(getChildAt(r12 - 1));
    L10:
        if (r11 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r11 = 0;
    L5:
        return (r11 * 2) + r10;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat r10 = this.lastInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.m();
    }

    public final int getTotalScrollRange() {
        int r10 = this.totalScrollRange;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = getChildCount();
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L18;
        View r14 = getChildAt(r12);
        LayoutParams r15 = (LayoutParams) r14.getLayoutParams();
        int r16 = r14.getMeasuredHeight();
        int r17 = r15.scrollFlags;
        if ((r17 & 1) == 0) goto L18;
        r13 = r13 + ((r16 + ((LinearLayout.LayoutParams) r15).topMargin) + ((LinearLayout.LayoutParams) r15).bottomMargin);
        if (r12 != 0) goto L15;
        if (ViewCompat.x(r14) == false) goto L15;
        r13 = r13 - getTopInset();
    L15:
        if ((r17 & 2) != 0) goto L16;
        r12 = r12 + 1;
        goto L6
    L16:
        r13 = r13 - ViewCompat.B(r14);
    L18:
        int r18 = Math.max(0, r13);
        this.totalScrollRange = r18;
        return r18;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r10) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r11 = this.tmpStatesArray;
        int[] r12 = super.onCreateDrawableState(r10 + r11.length);
        boolean r13 = this.liftable;
        int r14 = R.attr.state_liftable;
        if (r13 == true) goto L9;
        r14 = -r14;
    L9:
        r11[0] = r14;
        if (r13 == true) goto L12;
    L14:
        int r15 = -R.attr.state_lifted;
    L15:
        r11[1] = r15;
        int r16 = R.attr.state_collapsible;
        if (r13 == true) goto L19;
        r16 = -r16;
    L19:
        r11[2] = r16;
        if (r13 == true) goto L22;
    L24:
        int r17 = -R.attr.state_collapsed;
    L25:
        r11[3] = r17;
        return LinearLayout.mergeDrawableStates(r12, r11);
    L22:
        if (this.lifted == false) goto L24;
        r17 = R.attr.state_collapsed;
        goto L25
    L12:
        if (this.lifted == false) goto L14;
        r15 = R.attr.state_lifted;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        boolean r15 = true;
        if (ViewCompat.x(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r16 = getChildCount();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L15;
        if (((LayoutParams) getChildAt(r17).getLayoutParams()).getScrollInterpolator() != null) goto L13;
        r17 = r17 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r18 = this.statusBarForeground;
        if (r18 == null) goto L19;
        r18.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r15);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r15 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r19 = getTopInset();
        int r20 = getChildCount() - 1;
    L7:
        if (r20 < 0) goto L9;
        ViewCompat.a0(getChildAt(r20), r19);
        r20 = r20 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        if (r12 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.x(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r13 = getMeasuredHeight();
        if (r12 == Integer.MIN_VALUE) goto L13;
        if (r12 != 0) goto L14;
        r13 = r13 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r13);
        goto L15
    L13:
        r13 = a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(r11));
        goto L14
    }

    public void onOffsetChanged(int r10) {
        this.currentOffset = r10;
        if (willNotDraw() == true) goto L5;
        ViewCompat.g0(this);
    L5:
        List<BaseOnOffsetChangedListener> r11 = this.listeners;
        if (r11 == null) goto L13;
        int r12 = r11.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L17;
        BaseOnOffsetChangedListener r14 = this.listeners.get(r13);
        if (r14 == null) goto L12;
        r14.onOffsetChanged(this, r10);
    L12:
        r13 = r13 + 1;
        goto L8
    L17:
        return;
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r10) {
        if (ViewCompat.x(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (b.a(this.lastInsets, r11) == true) goto L9;
        this.lastInsets = r11;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r10) {
        List<BaseOnOffsetChangedListener> r11 = this.listeners;
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.remove(r10);
        return;
    L8:
        return;
    }

    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        MaterialShapeUtils.setElevation(this, r10);
    }

    public void setExpanded(boolean r10) {
        setExpanded(r10, ViewCompat.T(this));
    }

    public void setLiftOnScroll(boolean r10) {
        this.liftOnScroll = r10;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int r10) {
        this.liftOnScrollTargetViewId = r10;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean r10) {
        this.liftableOverride = true;
        return setLiftableState(r10);
    }

    public boolean setLifted(boolean r10) {
        return setLiftedState(r10);
    }

    public boolean setLiftedState(boolean r10) {
        if (this.lifted == r10) goto L11;
        this.lifted = r10;
        refreshDrawableState();
        if (this.liftOnScroll == true) goto L7;
        return true;
    L7:
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L14;
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), r10);
        return true;
    L14:
        return true;
    L11:
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r10) {
        if (r10 != 1) goto L7;
        super.setOrientation(r10);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable r10) {
        Drawable r11 = this.statusBarForeground;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.statusBarForeground = r12;
        if (r12 != null) goto L12;
    L19:
        updateWillNotDraw();
        ViewCompat.g0(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.statusBarForeground.setState(getDrawableState());
    L14:
        o.a.g(this.statusBarForeground, ViewCompat.A(this));
        Drawable r13 = this.statusBarForeground;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.statusBarForeground.setCallback(this);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarForegroundColor(@ColorInt int r10) {
        setStatusBarForeground(new ColorDrawable(r10));
    }

    public void setStatusBarForegroundResource(@DrawableRes int r10) {
        setStatusBarForeground(c.a.b(getContext(), r10));
    }

    @Deprecated
    public void setTargetElevation(float r10) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r10);
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.statusBarForeground;
        if (r12 == null) goto L10;
        r12.setVisible(r11, false);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public boolean shouldLift(@Nullable View r10) {
        View r11 = findLiftOnScrollTargetView(r10);
        if (r11 == null) goto L6;
        r10 = r11;
    L6:
        if (r10 != null) goto L8;
    L12:
        return false;
    L8:
        if (r10.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r10.getScrollY() <= 0) goto L12;
        goto L11
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.statusBarForeground) goto L8;
        return false;
    }

    public AppBarLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.appBarLayoutStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    public void setExpanded(boolean r10, boolean r11) {
        setExpanded(r10, r11, true);
    }

    public AppBarLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        Context r14 = getContext();
        setOrientation(1);
        ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, r11, r12, r13);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r14, r11, R.styleable.AppBarLayout, r12, r13, new int[0]);
        ViewCompat.t0(this, r15.getDrawable(R.styleable.AppBarLayout_android_background));
        if ((getBackground() instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r16 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r17 = new MaterialShapeDrawable();
        r17.setFillColor(ColorStateList.valueOf(r16.getColor()));
        r17.initializeElevationOverlay(r14);
        ViewCompat.t0(this, r17);
    L5:
        int r18 = R.styleable.AppBarLayout_expanded;
        if (r15.hasValue(r18) == false) goto L8;
        setExpanded(r15.getBoolean(r18, false), false, false);
    L8:
        int r19 = R.styleable.AppBarLayout_elevation;
        if (r15.hasValue(r19) == false) goto L11;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r15.getDimensionPixelSize(r19, 0));
    L11:
        int r110 = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
        if (r15.hasValue(r110) == false) goto L14;
        setKeyboardNavigationCluster(r15.getBoolean(r110, false));
    L14:
        int r111 = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
        if (r15.hasValue(r111) == false) goto L17;
        setTouchscreenBlocksFocus(r15.getBoolean(r111, false));
    L17:
        this.liftOnScroll = r15.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = r15.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(r15.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        r15.recycle();
        ViewCompat.C0(this, new AnonymousClass1(this));
    }

    private void setExpanded(boolean r10, boolean r11, boolean r12) {
        if (r10 == false) goto L4;
        int r13 = 1;
    L5:
        int r14 = 0;
        if (r11 == false) goto L8;
        int r15 = 4;
    L9:
        int r16 = r13 | r15;
        if (r12 == false) goto L12;
        r14 = 8;
    L12:
        this.pendingAction = r16 | r14;
        requestLayout();
        return;
    L8:
        r15 = 0;
        goto L9
    L4:
        r13 = 2;
        goto L5
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener r10) {
        removeOnOffsetChangedListener(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener r10) {
        addOnOffsetChangedListener(r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return new LayoutParams((LinearLayout.LayoutParams) r10);
    L7:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L11:
        return new LayoutParams(r10);
    }
}
