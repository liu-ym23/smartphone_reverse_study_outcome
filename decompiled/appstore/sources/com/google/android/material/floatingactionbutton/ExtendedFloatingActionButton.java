package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = 0;
    static final Property<View, Float> HEIGHT = null;
    static final Property<View, Float> PADDING_END = null;
    static final Property<View, Float> PADDING_START = null;
    static final Property<View, Float> WIDTH = null;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @NonNull
    protected ColorStateList originalTextCsl;
    private final MotionStrategy showStrategy;

    @NonNull
    private final MotionStrategy shrinkStrategy;

    public class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ChangeSizeStrategy(ExtendedFloatingActionButton r10, AnimatorTracker r11, Size r12, boolean r13) {
            this.this$0 = r10;
            super(r10, r11);
            this.size = r12;
            this.extending = r13;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet createAnimator() {
            MotionSpec r10 = getCurrentMotionSpec();
            if (r10.hasPropertyValues(Style.KEY_WIDTH) == false) goto L6;
            PropertyValuesHolder[] r11 = r10.getPropertyValues(Style.KEY_WIDTH);
            r11[0].setFloatValues(new float[]{this.this$0.getWidth(), this.size.getWidth()});
            r10.setPropertyValues(Style.KEY_WIDTH, r11);
        L6:
            if (r10.hasPropertyValues(Style.KEY_HEIGHT) == false) goto L9;
            PropertyValuesHolder[] r12 = r10.getPropertyValues(Style.KEY_HEIGHT);
            r12[0].setFloatValues(new float[]{this.this$0.getHeight(), this.size.getHeight()});
            r10.setPropertyValues(Style.KEY_HEIGHT, r12);
        L9:
            if (r10.hasPropertyValues("paddingStart") == false) goto L12;
            PropertyValuesHolder[] r13 = r10.getPropertyValues("paddingStart");
            r13[0].setFloatValues(new float[]{ViewCompat.F(this.this$0), this.size.getPaddingStart()});
            r10.setPropertyValues("paddingStart", r13);
        L12:
            if (r10.hasPropertyValues("paddingEnd") == false) goto L15;
            PropertyValuesHolder[] r14 = r10.getPropertyValues("paddingEnd");
            r14[0].setFloatValues(new float[]{ViewCompat.E(this.this$0), this.size.getPaddingEnd()});
            r10.setPropertyValues("paddingEnd", r14);
        L15:
            if (r10.hasPropertyValues("labelOpacity") == false) goto L25;
            PropertyValuesHolder[] r15 = r10.getPropertyValues("labelOpacity");
            boolean r16 = this.extending;
            float r17 = 1.0f;
            if (r16 == false) goto L19;
            float r18 = 0.0f;
        L20:
            if (r16 == true) goto L23;
            r17 = 0.0f;
        L23:
            r15[0].setFloatValues(new float[]{r18, r17});
            r10.setPropertyValues("labelOpacity", r15);
            goto L25
        L19:
            r18 = 1.0f;
        L25:
            return super.createAnimator(r10);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            if (this.extending == false) goto L6;
            return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
        L6:
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$802(this.this$0, false);
            this.this$0.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams r10 = this.this$0.getLayoutParams();
            if (r10 != null) goto L5;
            return;
        L5:
            r10.width = this.size.getLayoutParams().width;
            r10.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            ExtendedFloatingActionButton.access$702(this.this$0, this.extending);
            ExtendedFloatingActionButton.access$802(this.this$0, true);
            this.this$0.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.extending == false) goto L7;
            r10.onExtended(this.this$0);
            return;
        L7:
            r10.onShrunken(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.access$702(this.this$0, this.extending);
            ViewGroup.LayoutParams r10 = this.this$0.getLayoutParams();
            if (r10 != null) goto L5;
            return;
        L5:
            r10.width = this.size.getLayoutParams().width;
            r10.height = this.size.getLayoutParams().height;
            ViewCompat.D0(this.this$0, this.size.getPaddingStart(), this.this$0.getPaddingTop(), this.size.getPaddingEnd(), this.this$0.getPaddingBottom());
            this.this$0.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            if (this.extending != ExtendedFloatingActionButton.access$700(this.this$0)) goto L5;
        L10:
            return true;
        L5:
            if (this.this$0.getIcon() == null) goto L10;
            if (TextUtils.isEmpty(this.this$0.getText()) == true) goto L10;
            return false;
        }
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @Nullable
        private OnChangedCallback internalAutoHideCallback;

        @Nullable
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        private static boolean isBottomSheet(@NonNull View r10) {
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if ((r11 instanceof CoordinatorLayout.c) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.c) r11).f() instanceof BottomSheetBehavior;
        }

        private boolean shouldUpdateVisibility(@NonNull View r10, @NonNull ExtendedFloatingActionButton r11) {
            CoordinatorLayout.c r12 = (CoordinatorLayout.c) r11.getLayoutParams();
            if (this.autoHideEnabled == true) goto L8;
            if (this.autoShrinkEnabled == true) goto L8;
            return false;
        L8:
            if (r12.e() == r10.getId()) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r10, @NonNull AppBarLayout r11, @NonNull ExtendedFloatingActionButton r12) {
            if (shouldUpdateVisibility(r11, r12) == true) goto L7;
            return false;
        L7:
            if (this.tmpRect != null) goto L9;
            this.tmpRect = new Rect();
        L9:
            Rect r13 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(r10, r11, r13);
            if (r13.bottom > r11.getMinimumHeightForVisibleOverlappingContent()) goto L12;
            shrinkOrHide(r12);
            return true;
        L12:
            extendOrShow(r12);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r10, @NonNull ExtendedFloatingActionButton r11) {
            if (shouldUpdateVisibility(r10, r11) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.c r12 = (CoordinatorLayout.c) r11.getLayoutParams();
            if (r10.getTop() >= ((r11.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r12).topMargin)) goto L9;
            shrinkOrHide(r11);
            return true;
        L9:
            extendOrShow(r11);
            return true;
        }

        public void extendOrShow(@NonNull ExtendedFloatingActionButton r10) {
            boolean r11 = this.autoShrinkEnabled;
            if (r11 == false) goto L5;
            OnChangedCallback r12 = this.internalAutoShrinkCallback;
        L6:
            if (r11 == false) goto L8;
            MotionStrategy r13 = ExtendedFloatingActionButton.access$500(r10);
        L9:
            ExtendedFloatingActionButton.access$400(r10, r13, r12);
            return;
        L8:
            r13 = ExtendedFloatingActionButton.access$600(r10);
            goto L9
        L5:
            r12 = this.internalAutoHideCallback;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull Rect r12) {
            return getInsetDodgeRect(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.c r10) {
            if (r10.f2414h != 0) goto L6;
            r10.f2414h = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull View r11, View r12) {
            return onDependentViewChanged(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (ExtendedFloatingActionButton) r11, r12);
        }

        public void setAutoHideEnabled(boolean r10) {
            this.autoHideEnabled = r10;
        }

        public void setAutoShrinkEnabled(boolean r10) {
            this.autoShrinkEnabled = r10;
        }

        @VisibleForTesting
        public void setInternalAutoHideCallback(@Nullable OnChangedCallback r10) {
            this.internalAutoHideCallback = r10;
        }

        @VisibleForTesting
        public void setInternalAutoShrinkCallback(@Nullable OnChangedCallback r10) {
            this.internalAutoShrinkCallback = r10;
        }

        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton r10) {
            boolean r11 = this.autoShrinkEnabled;
            if (r11 == false) goto L5;
            OnChangedCallback r12 = this.internalAutoShrinkCallback;
        L6:
            if (r11 == false) goto L8;
            MotionStrategy r13 = ExtendedFloatingActionButton.access$200(r10);
        L9:
            ExtendedFloatingActionButton.access$400(r10, r13, r12);
            return;
        L8:
            r13 = ExtendedFloatingActionButton.access$300(r10);
            goto L9
        L5:
            r12 = this.internalAutoHideCallback;
            goto L6
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, @NonNull Rect r12) {
            return super.getInsetDodgeRect(r10, r11, r12);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, View r12) {
            if ((r12 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r12, r11);
            return false;
        L6:
            if (isBottomSheet(r12) == false) goto L11;
            updateFabVisibilityForBottomSheet(r12, r11);
            return false;
        L11:
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull ExtendedFloatingActionButton r11, int r12) {
            List<View> r13 = r10.getDependencies(r11);
            int r14 = r13.size();
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L15;
            View r16 = r13.get(r15);
            if ((r16 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r10, (AppBarLayout) r16, r11) == true) goto L15;
        L14:
            r15 = r15 + 1;
            goto L3
        L10:
            if (isBottomSheet(r16) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r16, r11) == false) goto L14;
        L15:
            r10.onLayoutChild(r11, r12);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context r10, @Nullable AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r12.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = r12.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            r12.recycle();
        }
    }

    public class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public HideStrategy(ExtendedFloatingActionButton r10, AnimatorTracker r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$902(this.this$0, 0);
            if (this.isCancelled == true) goto L6;
            this.this$0.setVisibility(8);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            this.isCancelled = false;
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 1);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r10) {
            if (r10 == null) goto L5;
            r10.onHidden(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1100(this.this$0);
        }
    }

    public static abstract class OnChangedCallback {
        public OnChangedCallback() {
        }

        public void onExtended(ExtendedFloatingActionButton r10) {
        }

        public void onHidden(ExtendedFloatingActionButton r10) {
        }

        public void onShown(ExtendedFloatingActionButton r10) {
        }

        public void onShrunken(ExtendedFloatingActionButton r10) {
        }
    }

    public class ShowStrategy extends BaseMotionStrategy {
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ShowStrategy(ExtendedFloatingActionButton r10, AnimatorTracker r11) {
            this.this$0 = r10;
            super(r10, r11);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$902(this.this$0, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r10) {
            if (r10 == null) goto L5;
            r10.onShown(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(0);
            this.this$0.setAlpha(1.0f);
            this.this$0.setScaleY(1.0f);
            this.this$0.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1000(this.this$0);
        }
    }

    public interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        final String r10 = Style.KEY_WIDTH;
        final Class<Float> r11 = Float.class;
        WIDTH = new AnonymousClass4(r11, r10);
        final String r12 = Style.KEY_HEIGHT;
        HEIGHT = new AnonymousClass5(r11, r12);
        final String r13 = "paddingStart";
        PADDING_START = new AnonymousClass6(r11, r13);
        final String r14 = "paddingEnd";
        PADDING_END = new AnonymousClass7(r11, r14);
    }

    public ExtendedFloatingActionButton(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int access$000(ExtendedFloatingActionButton r10) {
        return r10.extendedPaddingStart;
    }

    public static /* synthetic */ int access$100(ExtendedFloatingActionButton r10) {
        return r10.extendedPaddingEnd;
    }

    public static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton r10) {
        return r10.isOrWillBeShown();
    }

    public static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton r10) {
        return r10.isOrWillBeHidden();
    }

    public static /* synthetic */ MotionStrategy access$200(ExtendedFloatingActionButton r10) {
        return r10.shrinkStrategy;
    }

    public static /* synthetic */ MotionStrategy access$300(ExtendedFloatingActionButton r10) {
        return r10.hideStrategy;
    }

    public static /* synthetic */ void access$400(ExtendedFloatingActionButton r10, MotionStrategy r11, OnChangedCallback r12) {
        r10.performMotion(r11, r12);
    }

    public static /* synthetic */ MotionStrategy access$500(ExtendedFloatingActionButton r10) {
        return r10.extendStrategy;
    }

    public static /* synthetic */ MotionStrategy access$600(ExtendedFloatingActionButton r10) {
        return r10.showStrategy;
    }

    public static /* synthetic */ boolean access$700(ExtendedFloatingActionButton r10) {
        return r10.isExtended;
    }

    public static /* synthetic */ boolean access$702(ExtendedFloatingActionButton r10, boolean r11) {
        r10.isExtended = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$802(ExtendedFloatingActionButton r10, boolean r11) {
        r10.isTransforming = r11;
        return r11;
    }

    public static /* synthetic */ int access$902(ExtendedFloatingActionButton r10, int r11) {
        r10.animState = r11;
        return r11;
    }

    private boolean isOrWillBeHidden() {
        if (getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean isOrWillBeShown() {
        if (getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    private void performMotion(@NonNull final MotionStrategy r10, @Nullable final OnChangedCallback r11) {
        if (r10.shouldCancel() == false) goto L6;
        return;
    L6:
        if (shouldAnimateVisibilityChange() == true) goto L9;
        r10.performNow();
        r10.onChange(r11);
        return;
    L9:
        measure(0, 0);
        AnimatorSet r12 = r10.createAnimator();
        r12.addListener(new AnonymousClass3(this, r10, r11));
        Iterator<Animator.AnimatorListener> r13 = r10.getListeners().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        r12.addListener(r13.next());
        goto L11
    L13:
        r12.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.T(this) == true) goto L9;
        if (isOrWillBeShown() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.animateShowBeforeLayout == false) goto L11;
    L9:
        if (isInEditMode() == true) goto L11;
        return true;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.extendStrategy.addAnimationListener(r10);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.hideStrategy.addAnimationListener(r10);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.showStrategy.addAnimationListener(r10);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.shrinkStrategy.addAnimationListener(r10);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int r10 = this.collapsedSize;
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return (Math.min(ViewCompat.F(this), ViewCompat.E(this)) * 2) + getIconSize();
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == true) goto L7;
        return;
    L7:
        if (getIcon() == null) goto L12;
        this.isExtended = false;
        this.shrinkStrategy.performNow();
        return;
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.extendStrategy.removeAnimationListener(r10);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.hideStrategy.removeAnimationListener(r10);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.showStrategy.removeAnimationListener(r10);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.shrinkStrategy.removeAnimationListener(r10);
    }

    public void setAnimateShowBeforeLayout(boolean r10) {
        this.animateShowBeforeLayout = r10;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec r10) {
        this.extendStrategy.setMotionSpec(r10);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int r10) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), r10));
    }

    public void setExtended(boolean r10) {
        if (this.isExtended != r10) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        MotionStrategy r11 = this.extendStrategy;
    L9:
        if (r11.shouldCancel() == false) goto L11;
        return;
    L11:
        r11.performNow();
        return;
    L7:
        r11 = this.shrinkStrategy;
        goto L9
    }

    public void setHideMotionSpec(@Nullable MotionSpec r10) {
        this.hideStrategy.setMotionSpec(r10);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r10) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = ViewCompat.F(this);
        this.extendedPaddingEnd = ViewCompat.E(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int r10, int r11, int r12, int r13) {
        super.setPaddingRelative(r10, r11, r12, r13);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = r10;
        this.extendedPaddingEnd = r12;
        return;
    }

    public void setShowMotionSpec(@Nullable MotionSpec r10) {
        this.showStrategy.setMotionSpec(r10);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r10) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r10));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec r10) {
        this.shrinkStrategy.setMotionSpec(r10);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int r10) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), r10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r10) {
        super.setTextColor(r10);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void silentlyUpdateTextColor(@NonNull ColorStateList r10) {
        super.setTextColor(r10);
    }

    public ExtendedFloatingActionButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback r10) {
        performMotion(this.extendStrategy, r10);
    }

    public void hide(@NonNull OnChangedCallback r10) {
        performMotion(this.hideStrategy, r10);
    }

    public void show(@NonNull OnChangedCallback r10) {
        performMotion(this.showStrategy, r10);
    }

    public void shrink(@NonNull OnChangedCallback r10) {
        performMotion(this.shrinkStrategy, r10);
    }

    public ExtendedFloatingActionButton(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r10), r18, r19);
        this.animState = 0;
        AnimatorTracker r11 = new AnimatorTracker();
        this.changeVisibilityTracker = r11;
        ShowStrategy r12 = new ShowStrategy(this, r11);
        this.showStrategy = r12;
        HideStrategy r13 = new HideStrategy(this, r11);
        this.hideStrategy = r13;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context r14 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(r14, r18);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r14, r18, R.styleable.ExtendedFloatingActionButton, r19, r10, new int[0]);
        MotionSpec r16 = MotionSpec.createFromAttribute(r14, r15, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec r20 = MotionSpec.createFromAttribute(r14, r15, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec r21 = MotionSpec.createFromAttribute(r14, r15, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec r22 = MotionSpec.createFromAttribute(r14, r15, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = r15.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.F(this);
        this.extendedPaddingEnd = ViewCompat.E(this);
        AnimatorTracker r23 = new AnimatorTracker();
        ChangeSizeStrategy r110 = new ChangeSizeStrategy(this, r23, new AnonymousClass1(this), true);
        this.extendStrategy = r110;
        ChangeSizeStrategy r111 = new ChangeSizeStrategy(this, r23, new AnonymousClass2(this), false);
        this.shrinkStrategy = r111;
        r12.setMotionSpec(r16);
        r13.setMotionSpec(r20);
        r110.setMotionSpec(r21);
        r111.setMotionSpec(r22);
        r15.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(r14, r18, r19, r10, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList r10) {
        super.setTextColor(r10);
        saveOriginalTextCsl();
    }
}
