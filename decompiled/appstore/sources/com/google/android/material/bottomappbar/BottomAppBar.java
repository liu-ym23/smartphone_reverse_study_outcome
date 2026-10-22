package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = 0;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @NonNull
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private boolean menuAnimatingWithFabAlignmentMode;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;

    @MenuRes
    private int pendingMenuResId;
    private int rightInset;

    public interface AnimationListener {
        void onAnimationEnd(BottomAppBar r10);

        void onAnimationStart(BottomAppBar r10);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public static /* synthetic */ WeakReference access$2400(Behavior r10) {
            return r10.viewRef;
        }

        public static /* synthetic */ Rect access$2500(Behavior r10) {
            return r10.fabContentRect;
        }

        public static /* synthetic */ int access$2600(Behavior r10) {
            return r10.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
            return onLayoutChild(r10, (BottomAppBar) r11, r12);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            return onStartNestedScroll(r10, (BottomAppBar) r11, r12, r13, r14, r15);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull BottomAppBar r11, int r12) {
            this.viewRef = new WeakReference(r11);
            View r13 = BottomAppBar.access$3100(r11);
            if (r13 != null) goto L5;
        L10:
            r10.onLayoutChild(r11, r12);
            return super.onLayoutChild(r10, r11, r12);
        L5:
            if (ViewCompat.T(r13) == true) goto L10;
            CoordinatorLayout.c r14 = (CoordinatorLayout.c) r13.getLayoutParams();
            r14.f2410d = 49;
            this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) r14).bottomMargin;
            if ((r13 instanceof FloatingActionButton) == false) goto L9;
            FloatingActionButton r15 = (FloatingActionButton) r13;
            r15.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$3200(r11, r15);
        L9:
            BottomAppBar.access$1300(r11);
            goto L10
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull BottomAppBar r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r11.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r10, r11, r12, r13, r14, r15) == false) goto L7;
            return true;
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.fabAlignmentMode);
            r10.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.fabAlignmentMode = r10.readInt();
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.fabAttached = r12;
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    }

    public BottomAppBar(@NonNull Context r10) {
        this(r10, null, 0);
    }

    public static /* synthetic */ boolean access$000(BottomAppBar r10) {
        return r10.menuAnimatingWithFabAlignmentMode;
    }

    public static /* synthetic */ boolean access$002(BottomAppBar r10, boolean r11) {
        r10.menuAnimatingWithFabAlignmentMode = r11;
        return r11;
    }

    public static /* synthetic */ int access$100(BottomAppBar r10) {
        return r10.fabAlignmentMode;
    }

    public static /* synthetic */ boolean access$1000(BottomAppBar r10) {
        return r10.paddingRightSystemWindowInsets;
    }

    public static /* synthetic */ int access$1100(BottomAppBar r10) {
        return r10.rightInset;
    }

    public static /* synthetic */ int access$1102(BottomAppBar r10, int r11) {
        r10.rightInset = r11;
        return r11;
    }

    public static /* synthetic */ void access$1200(BottomAppBar r10) {
        r10.cancelAnimations();
    }

    public static /* synthetic */ void access$1300(BottomAppBar r10) {
        r10.setCutoutState();
    }

    public static /* synthetic */ void access$1400(BottomAppBar r10) {
        r10.setActionMenuViewPosition();
    }

    public static /* synthetic */ void access$1500(BottomAppBar r10) {
        r10.dispatchAnimationStart();
    }

    public static /* synthetic */ void access$1600(BottomAppBar r10) {
        r10.dispatchAnimationEnd();
    }

    public static /* synthetic */ Animator access$1702(BottomAppBar r10, Animator r11) {
        r10.modeAnimator = r11;
        return r11;
    }

    public static /* synthetic */ float access$1800(BottomAppBar r10, int r11) {
        return r10.getFabTranslationX(r11);
    }

    public static /* synthetic */ Animator access$1902(BottomAppBar r10, Animator r11) {
        r10.menuAnimator = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$200(BottomAppBar r10) {
        return r10.fabAttached;
    }

    public static /* synthetic */ int access$2000(BottomAppBar r10) {
        return r10.pendingMenuResId;
    }

    public static /* synthetic */ void access$2100(BottomAppBar r10, ActionMenuView r11, int r12, boolean r13, boolean r14) {
        r10.translateActionMenuView(r11, r12, r13, r14);
    }

    public static /* synthetic */ FloatingActionButton access$2200(BottomAppBar r10) {
        return r10.findDependentFab();
    }

    public static /* synthetic */ float access$2300(BottomAppBar r10) {
        return r10.getFabTranslationX();
    }

    public static /* synthetic */ int access$2700(BottomAppBar r10) {
        return r10.getBottomInset();
    }

    public static /* synthetic */ int access$2800(BottomAppBar r10) {
        return r10.getLeftInset();
    }

    public static /* synthetic */ int access$2900(BottomAppBar r10) {
        return r10.getRightInset();
    }

    public static /* synthetic */ void access$300(BottomAppBar r10, int r11, boolean r12) {
        r10.maybeAnimateMenuView(r11, r12);
    }

    public static /* synthetic */ int access$3000(BottomAppBar r10) {
        return r10.fabOffsetEndMode;
    }

    public static /* synthetic */ View access$3100(BottomAppBar r10) {
        return r10.findDependentView();
    }

    public static /* synthetic */ void access$3200(BottomAppBar r10, FloatingActionButton r11) {
        r10.addFabAnimationListeners(r11);
    }

    public static /* synthetic */ MaterialShapeDrawable access$400(BottomAppBar r10) {
        return r10.materialShapeDrawable;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$500(BottomAppBar r10) {
        return r10.getTopEdgeTreatment();
    }

    public static /* synthetic */ boolean access$600(BottomAppBar r10) {
        return r10.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$702(BottomAppBar r10, int r11) {
        r10.bottomInset = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$800(BottomAppBar r10) {
        return r10.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ int access$900(BottomAppBar r10) {
        return r10.leftInset;
    }

    public static /* synthetic */ int access$902(BottomAppBar r10, int r11) {
        r10.leftInset = r11;
        return r11;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton r10) {
        r10.addOnHideAnimationListener(this.fabAnimationListener);
        r10.addOnShowAnimationListener(new AnonymousClass9(this));
        r10.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator r10 = this.menuAnimator;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Animator r11 = this.modeAnimator;
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    }

    private void createFabTranslationXAnimation(int r10, @NonNull List<Animator> r11) {
        ObjectAnimator r12 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r10)});
        r12.setDuration(300);
        r11.add(r12);
    }

    private void createMenuViewTranslationAnimation(final int r10, final boolean r11, @NonNull List<Animator> r12) {
        final ActionMenuView r13 = getActionMenuView();
        if (r13 != null) goto L5;
        return;
    L5:
        Animator r14 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{1.0f});
        if (Math.abs(r13.getTranslationX() - getActionMenuViewTranslationX(r13, r10, r11)) <= 1.0f) goto L9;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{0.0f});
        r15.addListener(new AnonymousClass7(this, r13, r10, r11));
        AnimatorSet r16 = new AnimatorSet();
        r16.setDuration(150);
        r16.playSequentially(new Animator[]{r15, r14});
        r12.add(r16);
        return;
    L9:
        if (r13.getAlpha() >= 1.0f) goto L13;
        r12.add(r14);
        return;
    }

    private void dispatchAnimationEnd() {
        int r10 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r10;
        if (r10 != 0) goto L10;
        ArrayList<AnimationListener> r11 = this.animationListeners;
        if (r11 == null) goto L12;
        Iterator<AnimationListener> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        r12.next().onAnimationEnd(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationStart() {
        int r10 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r10 + 1;
        if (r10 != 0) goto L10;
        ArrayList<AnimationListener> r11 = this.animationListeners;
        if (r11 == null) goto L12;
        Iterator<AnimationListener> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        r12.next().onAnimationStart(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View r10 = findDependentView();
        if ((r10 instanceof FloatingActionButton) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) r10;
    }

    @Nullable
    private View findDependentView() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        Iterator<View> r10 = ((CoordinatorLayout) getParent()).getDependents(this).iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        View r11 = r10.next();
        if ((r11 instanceof FloatingActionButton) == true) goto L12;
        if ((r11 instanceof ExtendedFloatingActionButton) == false) goto L7;
    L12:
        return r11;
    L13:
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L10;
        View r11 = getChildAt(r10);
        if ((r11 instanceof ActionMenuView) == true) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return (ActionMenuView) r11;
    L10:
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX(int r10) {
        boolean r11 = ViewUtils.isLayoutRtl(this);
        int r12 = 1;
        if (r10 != 1) goto L12;
        if (r11 == false) goto L6;
        int r13 = this.leftInset;
    L7:
        int r14 = (getMeasuredWidth() / 2) - (this.fabOffsetEndMode + r13);
        if (r11 == false) goto L11;
        r12 = -1;
    L11:
        return r14 * r12;
    L6:
        r13 = this.rightInset;
        goto L7
    L12:
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r10 = findDependentFab();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOrWillBeShown() == false) goto L7;
        return true;
    }

    private void maybeAnimateMenuView(int r10, boolean r11) {
        if (ViewCompat.T(this) == true) goto L6;
        this.menuAnimatingWithFabAlignmentMode = false;
        replaceMenu(this.pendingMenuResId);
        return;
    L6:
        Animator r12 = this.menuAnimator;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        ArrayList r13 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L12;
        r10 = 0;
        r11 = false;
    L12:
        createMenuViewTranslationAnimation(r10, r11, r13);
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(r13);
        this.menuAnimator = r14;
        r14.addListener(new AnonymousClass6(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int r10) {
        if (this.fabAlignmentMode != r10) goto L5;
        return;
    L5:
        if (ViewCompat.T(this) == false) goto L17;
        Animator r11 = this.modeAnimator;
        if (r11 == null) goto L10;
        r11.cancel();
    L10:
        ArrayList r12 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r10, r12);
    L14:
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(r12);
        this.modeAnimator = r13;
        r13.addListener(new AnonymousClass4(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r10, r12);
        goto L14
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r10 = getActionMenuView();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.menuAnimator != null) goto L12;
        r10.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L9;
        translateActionMenuView(r10, 0, false);
        return;
    L9:
        translateActionMenuView(r10, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        View r10 = findDependentView();
        MaterialShapeDrawable r11 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L7:
        float r12 = 0.0f;
    L8:
        r11.setInterpolation(r12);
        if (r10 == null) goto L12;
        r10.setTranslationY(getFabTranslationY());
        r10.setTranslationX(getFabTranslationX());
        return;
    L12:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L7;
        r12 = 1.0f;
        goto L8
    }

    private void translateActionMenuView(@NonNull ActionMenuView r10, int r11, boolean r12) {
        translateActionMenuView(r10, r11, r12, false);
    }

    public void addAnimationListener(@NonNull AnimationListener r10) {
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r10);
    }

    public void createFabDefaultXAnimation(final int r10, List<Animator> r11) {
        FloatingActionButton r12 = findDependentFab();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r12.hide(new AnonymousClass5(this, r10));
        return;
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView r10, int r11, boolean r12) {
        int r13 = 0;
        if (r11 != 1) goto L28;
        if (r12 == false) goto L28;
        boolean r14 = ViewUtils.isLayoutRtl(this);
        if (r14 == false) goto L9;
        int r15 = getMeasuredWidth();
    L11:
        if (r13 >= getChildCount()) goto L20;
        View r16 = getChildAt(r13);
        if ((r16.getLayoutParams() instanceof Toolbar.LayoutParams) == false) goto L19;
        if ((((Toolbar.LayoutParams) r16.getLayoutParams()).f211a & 8388615) != 8388611) goto L19;
        if (r14 == false) goto L18;
        r15 = Math.min(r15, r16.getLeft());
        goto L19
    L18:
        r15 = Math.max(r15, r16.getRight());
    L19:
        r13 = r13 + 1;
        goto L11
    L20:
        if (r14 == false) goto L22;
        int r17 = r10.getRight();
    L23:
        if (r14 == false) goto L25;
        int r18 = this.rightInset;
    L27:
        return r15 - (r17 + r18);
    L25:
        r18 = -this.leftInset;
        goto L27
    L22:
        r17 = r10.getLeft();
        goto L23
    L9:
        r15 = 0;
    L28:
        return 0;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (r10 == false) goto L5;
        cancelAnimations();
        setCutoutState();
    L5:
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.fabAlignmentMode = r11.fabAlignmentMode;
        this.fabAttached = r11.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.fabAlignmentMode = this.fabAlignmentMode;
        r10.fabAttached = this.fabAttached;
        return r10;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@NonNull AnimationListener r10) {
        ArrayList<AnimationListener> r11 = this.animationListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void replaceMenu(@MenuRes int r10) {
        if (r10 == 0) goto L5;
        this.pendingMenuResId = 0;
        getMenu().clear();
        inflateMenu(r10);
        return;
    }

    public void setBackgroundTint(@Nullable ColorStateList r10) {
        a.i(this.materialShapeDrawable, r10);
    }

    public void setCradleVerticalOffset(@Dimension float r10) {
        if (r10 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().setCradleVerticalOffset(r10);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutState();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        this.materialShapeDrawable.setElevation(r10);
        int r11 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r11);
    }

    public void setFabAlignmentMode(int r10) {
        setFabAlignmentModeAndReplaceMenu(r10, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int r10, @MenuRes int r11) {
        this.pendingMenuResId = r11;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(r10, this.fabAttached);
        maybeAnimateModeChange(r10);
        this.fabAlignmentMode = r10;
    }

    public void setFabAnimationMode(int r10) {
        this.fabAnimationMode = r10;
    }

    public void setFabCornerSize(@Dimension float r10) {
        if (r10 == getTopEdgeTreatment().getFabCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCornerSize(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleMargin(@Dimension float r10) {
        if (r10 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().setFabCradleMargin(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float r10) {
        if (r10 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCradleRoundedCornerRadius(r10);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public boolean setFabDiameter(@Px int r10) {
        float r11 = r10;
        if (r11 == getTopEdgeTreatment().getFabDiameter()) goto L6;
        getTopEdgeTreatment().setFabDiameter(r11);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    public void setHideOnScroll(boolean r10) {
        this.hideOnScroll = r10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r10) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r10) {
    }

    public BottomAppBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.bottomAppBarStyle);
    }

    private void translateActionMenuView(@NonNull final ActionMenuView r10, final int r11, final boolean r12, boolean r13) {
        Runnable r14 = new AnonymousClass8(this, r10, r11, r12);
        if (r13 == false) goto L5;
        r10.post(r14);
        return;
    L5:
        r14.run();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    public BottomAppBar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r10), r12, r13);
        MaterialShapeDrawable r14 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r14;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1(this);
        this.fabTransformationCallback = new AnonymousClass2(this);
        Context r15 = getContext();
        TypedArray r16 = ThemeEnforcement.obtainStyledAttributes(r15, r12, R.styleable.BottomAppBar, r13, r10, new int[0]);
        ColorStateList r17 = MaterialResources.getColorStateList(r15, r16, R.styleable.BottomAppBar_backgroundTint);
        int r18 = r16.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float r19 = r16.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float r20 = r16.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float r21 = r16.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = r16.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = r16.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = r16.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = r16.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r16.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r16.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        r16.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        r14.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(r19, r20, r21)).build());
        r14.setShadowCompatibilityMode(2);
        r14.setPaintStyle(Paint.Style.FILL);
        r14.initializeElevationOverlay(r15);
        setElevation(r18);
        a.i(r14, r17);
        ViewCompat.t0(this, r14);
        ViewUtils.doOnApplyWindowInsets(this, r12, r13, r10, new AnonymousClass3(this));
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
