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
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_ATTR = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_DEFAULT = 300;
    private static final int FAB_ALIGNMENT_ANIM_EASING_ATTR = 0;
    private static final float FAB_ALIGNMENT_ANIM_EASING_MIDPOINT = 0.2f;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;
    private static final int NO_FAB_END_MARGIN = -1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    private int fabAlignmentModeEndMargin;
    private int fabAnchorMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private int menuAlignmentMode;
    private boolean menuAnimatingWithFabAlignmentMode;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int pendingMenuResId;
    private final boolean removeEmbeddedFabElevation;
    private int rightInset;

    interface AnimationListener {
        void onAnimationEnd(BottomAppBar r1);

        void onAnimationStart(BottomAppBar r1);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        static /* synthetic */ WeakReference access$2500(Behavior r0) {
            return r0.viewRef;
        }

        static /* synthetic */ Rect access$2600(Behavior r0) {
            return r0.fabContentRect;
        }

        static /* synthetic */ int access$2700(Behavior r0) {
            return r0.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return onLayoutChild(r1, (BottomAppBar) r2, r3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
            return onStartNestedScroll(r1, (BottomAppBar) r2, r3, r4, r5, r6);
        }

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public boolean onLayoutChild(CoordinatorLayout r4, BottomAppBar r5, int r6) {
            this.viewRef = new WeakReference(r5);
            View r0 = BottomAppBar.access$3200(r5);
            if (r0 != null) goto L5;
        L21:
            r4.onLayoutChild(r5, r6);
            return super.onLayoutChild(r4, r5, r6);
        L5:
            if (ViewCompat.isLaidOut(r0) == true) goto L21;
            BottomAppBar.access$3300(r5, r0);
            this.originalBottomMargin = ((CoordinatorLayout.LayoutParams) r0.getLayoutParams()).bottomMargin;
            if ((r0 instanceof FloatingActionButton) == false) goto L20;
            FloatingActionButton r1 = (FloatingActionButton) r0;
            if (BottomAppBar.access$400(r5) != 0) goto L14;
            if (BottomAppBar.access$3400(r5) == false) goto L14;
            ViewCompat.setElevation(r1, 0.0f);
            r1.setCompatElevation(0.0f);
        L14:
            if (r1.getShowMotionSpec() != null) goto L17;
            r1.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
        L17:
            if (r1.getHideMotionSpec() != null) goto L19;
            r1.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
        L19:
            BottomAppBar.access$3500(r5, r1);
        L20:
            r0.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$1400(r5);
            goto L21
        }

        public boolean onStartNestedScroll(CoordinatorLayout r2, BottomAppBar r3, View r4, View r5, int r6, int r7) {
            if (r3.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r2, r3, r4, r5, r6, r7) == false) goto L7;
            return true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuAlignmentMode {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.fabAlignmentMode = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.fabAttached = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.fabAlignmentMode);
            r1.writeInt(this.fabAttached ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r1) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r1) {
    }

    static /* synthetic */ boolean access$000(BottomAppBar r0) {
        return r0.menuAnimatingWithFabAlignmentMode;
    }

    static /* synthetic */ boolean access$002(BottomAppBar r0, boolean r1) {
        r0.menuAnimatingWithFabAlignmentMode = r1;
        return r1;
    }

    static /* synthetic */ int access$100(BottomAppBar r0) {
        return r0.fabAlignmentMode;
    }

    static /* synthetic */ int access$1000(BottomAppBar r0) {
        return r0.leftInset;
    }

    static /* synthetic */ int access$1002(BottomAppBar r0, int r1) {
        r0.leftInset = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(BottomAppBar r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ int access$1200(BottomAppBar r0) {
        return r0.rightInset;
    }

    static /* synthetic */ int access$1202(BottomAppBar r0, int r1) {
        r0.rightInset = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(BottomAppBar r0) {
        r0.cancelAnimations();
    }

    static /* synthetic */ void access$1400(BottomAppBar r0) {
        r0.setCutoutStateAndTranslateFab();
    }

    static /* synthetic */ void access$1500(BottomAppBar r0) {
        r0.setActionMenuViewPosition();
    }

    static /* synthetic */ void access$1600(BottomAppBar r0) {
        r0.dispatchAnimationStart();
    }

    static /* synthetic */ void access$1700(BottomAppBar r0) {
        r0.dispatchAnimationEnd();
    }

    static /* synthetic */ Animator access$1802(BottomAppBar r0, Animator r1) {
        r0.modeAnimator = r1;
        return r1;
    }

    static /* synthetic */ float access$1900(BottomAppBar r0, int r1) {
        return r0.getFabTranslationX(r1);
    }

    static /* synthetic */ boolean access$200(BottomAppBar r0) {
        return r0.fabAttached;
    }

    static /* synthetic */ Animator access$2002(BottomAppBar r0, Animator r1) {
        r0.menuAnimator = r1;
        return r1;
    }

    static /* synthetic */ int access$2100(BottomAppBar r0) {
        return r0.pendingMenuResId;
    }

    static /* synthetic */ void access$2200(BottomAppBar r0, ActionMenuView r1, int r2, boolean r3, boolean r4) {
        r0.translateActionMenuView(r1, r2, r3, r4);
    }

    static /* synthetic */ FloatingActionButton access$2300(BottomAppBar r0) {
        return r0.findDependentFab();
    }

    static /* synthetic */ float access$2400(BottomAppBar r0) {
        return r0.getFabTranslationX();
    }

    static /* synthetic */ int access$2800(BottomAppBar r0) {
        return r0.getBottomInset();
    }

    static /* synthetic */ int access$2900(BottomAppBar r0) {
        return r0.getLeftInset();
    }

    static /* synthetic */ void access$300(BottomAppBar r0, int r1, boolean r2) {
        r0.maybeAnimateMenuView(r1, r2);
    }

    static /* synthetic */ int access$3000(BottomAppBar r0) {
        return r0.getRightInset();
    }

    static /* synthetic */ int access$3100(BottomAppBar r0) {
        return r0.fabOffsetEndMode;
    }

    static /* synthetic */ View access$3200(BottomAppBar r0) {
        return r0.findDependentView();
    }

    static /* synthetic */ void access$3300(BottomAppBar r0, View r1) {
        updateFabAnchorGravity(r0, r1);
    }

    static /* synthetic */ boolean access$3400(BottomAppBar r0) {
        return r0.removeEmbeddedFabElevation;
    }

    static /* synthetic */ void access$3500(BottomAppBar r0, FloatingActionButton r1) {
        r0.addFabAnimationListeners(r1);
    }

    static /* synthetic */ int access$400(BottomAppBar r0) {
        return r0.fabAnchorMode;
    }

    static /* synthetic */ MaterialShapeDrawable access$500(BottomAppBar r0) {
        return r0.materialShapeDrawable;
    }

    static /* synthetic */ BottomAppBarTopEdgeTreatment access$600(BottomAppBar r0) {
        return r0.getTopEdgeTreatment();
    }

    static /* synthetic */ boolean access$700(BottomAppBar r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$802(BottomAppBar r0, int r1) {
        r0.bottomInset = r1;
        return r1;
    }

    static /* synthetic */ boolean access$900(BottomAppBar r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
        FAB_ALIGNMENT_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
        FAB_ALIGNMENT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    }

    public BottomAppBar(Context r2) {
        this(r2, null);
    }

    public BottomAppBar(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context r13, AttributeSet r14, int r15) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r13, r14, r15, r6), r14, r15);
        MaterialShapeDrawable r16 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r16;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1(this);
        this.fabTransformationCallback = new AnonymousClass2(this);
        Context r9 = getContext();
        TypedArray r0 = ThemeEnforcement.obtainStyledAttributes(r9, r14, R.styleable.BottomAppBar, r15, r6, new int[0]);
        ColorStateList r1 = MaterialResources.getColorStateList(r9, r0, R.styleable.BottomAppBar_backgroundTint);
        if (r0.hasValue(R.styleable.BottomAppBar_navigationIconTint) == false) goto L5;
        setNavigationIconTint(r0.getColor(R.styleable.BottomAppBar_navigationIconTint, -1));
    L5:
        int r2 = r0.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float r4 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float r5 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float r10 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = r0.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = r0.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.fabAnchorMode = r0.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.removeEmbeddedFabElevation = r0.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.menuAlignmentMode = r0.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.hideOnScroll = r0.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.fabAlignmentModeEndMargin = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean r3 = r0.getBoolean(R.styleable.BottomAppBar_addElevationShadow, true);
        r0.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        r16.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(r4, r5, r10)).build());
        if (r3 == false) goto L8;
        r16.setShadowCompatibilityMode(2);
    L9:
        r16.setPaintStyle(Paint.Style.FILL);
        r16.initializeElevationOverlay(r9);
        setElevation(r2);
        DrawableCompat.setTintList(r16, r1);
        ViewCompat.setBackground(this, r16);
        ViewUtils.doOnApplyWindowInsets(this, r14, r15, r6, new AnonymousClass3(this));
        return;
    L8:
        r16.setShadowCompatibilityMode(1);
        setOutlineAmbientShadowColor(0);
        setOutlineSpotShadowColor(0);
        goto L9
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable r2 = getNavigationIcon();
        if (r2 == null) goto L6;
        setNavigationIcon(r2);
        return;
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public void setFabAlignmentMode(int r2) {
        setFabAlignmentModeAndReplaceMenu(r2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int r1, int r2) {
        this.pendingMenuResId = r2;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(r1, this.fabAttached);
        maybeAnimateModeChange(r1);
        this.fabAlignmentMode = r1;
    }

    public int getFabAnchorMode() {
        return this.fabAnchorMode;
    }

    public void setFabAnchorMode(int r1) {
        this.fabAnchorMode = r1;
        setCutoutStateAndTranslateFab();
        View r2 = findDependentView();
        if (r2 == null) goto L6;
        updateFabAnchorGravity(this, r2);
        r2.requestLayout();
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    private static void updateFabAnchorGravity(BottomAppBar r2, View r3) {
        CoordinatorLayout.LayoutParams r4 = (CoordinatorLayout.LayoutParams) r3.getLayoutParams();
        r4.anchorGravity = 17;
        if (r2.fabAnchorMode != 1) goto L6;
        r4.anchorGravity |= 48;
    L6:
        if (r2.fabAnchorMode != 0) goto L9;
        r4.anchorGravity |= 80;
        return;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public void setFabAnimationMode(int r1) {
        this.fabAnimationMode = r1;
    }

    public void setMenuAlignmentMode(int r3) {
        if (this.menuAlignmentMode == r3) goto L8;
        this.menuAlignmentMode = r3;
        ActionMenuView r4 = getActionMenuView();
        if (r4 == null) goto L9;
        translateActionMenuView(r4, this.fabAlignmentMode, isFabVisibleOrWillBeShown());
        return;
    L9:
        return;
    }

    public int getMenuAlignmentMode() {
        return this.menuAlignmentMode;
    }

    public void setBackgroundTint(ColorStateList r1) {
        DrawableCompat.setTintList(this.materialShapeDrawable, r1);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    public void setFabCradleMargin(float r2) {
        if (r2 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().setFabCradleMargin(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public void setFabCradleRoundedCornerRadius(float r2) {
        if (r2 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCradleRoundedCornerRadius(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public void setCradleVerticalOffset(float r2) {
        if (r2 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().setCradleVerticalOffset(r2);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutStateAndTranslateFab();
        return;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.fabAlignmentModeEndMargin;
    }

    public void setFabAlignmentModeEndMargin(int r2) {
        if (this.fabAlignmentModeEndMargin == r2) goto L6;
        this.fabAlignmentModeEndMargin = r2;
        setCutoutStateAndTranslateFab();
        return;
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public void setHideOnScroll(boolean r1) {
        this.hideOnScroll = r1;
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean r2) {
        getBehavior().slideDown(this, r2);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean r2) {
        getBehavior().slideUp(this, r2);
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    public void addOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.OnScrollStateChangedListener r1) {
        getBehavior().addOnScrollStateChangedListener(r1);
    }

    public void removeOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.OnScrollStateChangedListener r1) {
        getBehavior().removeOnScrollStateChangedListener(r1);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().clearOnScrollStateChangedListeners();
    }

    @Override // android.view.View
    public void setElevation(float r2) {
        this.materialShapeDrawable.setElevation(r2);
        int r3 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r3);
    }

    public void replaceMenu(int r2) {
        if (r2 == 0) goto L5;
        this.pendingMenuResId = 0;
        getMenu().clear();
        inflateMenu(r2);
        return;
    }

    void addAnimationListener(AnimationListener r2) {
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r2);
    }

    void removeAnimationListener(AnimationListener r1) {
        ArrayList<AnimationListener> r0 = this.animationListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    private void dispatchAnimationStart() {
        int r0 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r0 + 1;
        if (r0 != 0) goto L10;
        ArrayList<AnimationListener> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<AnimationListener> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r2.next().onAnimationStart(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationEnd() {
        int r0 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r0;
        if (r0 != 0) goto L10;
        ArrayList<AnimationListener> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<AnimationListener> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r2.next().onAnimationEnd(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    boolean setFabDiameter(int r2) {
        float r3 = r2;
        if (r3 == getTopEdgeTreatment().getFabDiameter()) goto L6;
        getTopEdgeTreatment().setFabDiameter(r3);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    void setFabCornerSize(float r2) {
        if (r2 == getTopEdgeTreatment().getFabCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCornerSize(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    private void maybeAnimateModeChange(int r4) {
        if (this.fabAlignmentMode != r4) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        Animator r0 = this.modeAnimator;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ArrayList r1 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r4, r1);
    L14:
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(r1);
        r5.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), FAB_ALIGNMENT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_INTERPOLATOR));
        this.modeAnimator = r5;
        r5.addListener(new AnonymousClass4(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r4, r1);
        goto L14
    }

    private FloatingActionButton findDependentFab() {
        View r1 = findDependentView();
        if ((r1 instanceof FloatingActionButton) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) r1;
    }

    private View findDependentView() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        Iterator<View> r3 = ((CoordinatorLayout) getParent()).getDependents(this).iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        View r0 = r3.next();
        if ((r0 instanceof FloatingActionButton) == true) goto L12;
        if ((r0 instanceof ExtendedFloatingActionButton) == false) goto L7;
    L12:
        return r0;
    L13:
        return null;
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r0 = findDependentFab();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOrWillBeShown() == false) goto L7;
        return true;
    }

    protected void createFabDefaultXAnimation(final int r2, List<Animator> r3) {
        FloatingActionButton r4 = findDependentFab();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r4.hide(new AnonymousClass5(this, r2));
        return;
    }

    private void createFabTranslationXAnimation(int r4, List<Animator> r5) {
        ObjectAnimator r6 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r4)});
        r6.setDuration(getFabAlignmentAnimationDuration());
        r5.add(r6);
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.resolveThemeDuration(getContext(), FAB_ALIGNMENT_ANIM_DURATION_ATTR, 300);
    }

    private Drawable maybeTintNavigationIcon(Drawable r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r3 = DrawableCompat.wrap(r2.mutate());
        DrawableCompat.setTint(r3, this.navigationIconTint.intValue());
        return r3;
    L8:
        return r2;
    }

    private void maybeAnimateMenuView(int r4, boolean r5) {
        if (ViewCompat.isLaidOut(this) == true) goto L6;
        this.menuAnimatingWithFabAlignmentMode = false;
        replaceMenu(this.pendingMenuResId);
        return;
    L6:
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        ArrayList r1 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L12;
        r4 = 0;
        r5 = false;
    L12:
        createMenuViewTranslationAnimation(r4, r5, r1);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(r1);
        this.menuAnimator = r6;
        r6.addListener(new AnonymousClass6(this));
        this.menuAnimator.start();
    }

    private void createMenuViewTranslationAnimation(final int r10, final boolean r11, List<Animator> r12) {
        final ActionMenuView r0 = getActionMenuView();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = getFabAlignmentAnimationDuration();
        Animator r3 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f});
        r3.setDuration((long) (0.8f * r1));
        if (Math.abs(r0.getTranslationX() - getActionMenuViewTranslationX(r0, r10, r11)) <= 1.0f) goto L9;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{0.0f});
        r5.setDuration((long) (r1 * 0.2f));
        r5.addListener(new AnonymousClass7(this, r0, r10, r11));
        AnimatorSet r9 = new AnimatorSet();
        r9.playSequentially(new Animator[]{r5, r3});
        r12.add(r9);
        return;
    L9:
        if (r0.getAlpha() >= 1.0f) goto L13;
        r12.add(r3);
        return;
    }

    private float getFabTranslationY() {
        if (this.fabAnchorMode == 1) goto L5;
        View r0 = findDependentView();
        if (r0 == null) goto L9;
        int r2 = (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2;
    L11:
        return r2;
    L9:
        r2 = 0;
        goto L11
    L5:
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private float getFabTranslationX(int r6) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r1 = 1;
        if (r6 != 1) goto L18;
        View r7 = findDependentView();
        if (r0 == false) goto L7;
        int r2 = this.leftInset;
    L9:
        if (this.fabAlignmentModeEndMargin == (-1)) goto L12;
        if (r7 == null) goto L12;
        int r8 = (r7.getMeasuredWidth() / 2) + this.fabAlignmentModeEndMargin;
    L13:
        int r5 = (getMeasuredWidth() / 2) - (r2 + r8);
        if (r0 == false) goto L17;
        r1 = -1;
    L17:
        return r5 * r1;
    L12:
        r8 = this.fabOffsetEndMode;
        goto L13
    L7:
        r2 = this.rightInset;
        goto L9
    L18:
        return 0.0f;
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private ActionMenuView getActionMenuView() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L10;
        View r1 = getChildAt(r0);
        if ((r1 instanceof ActionMenuView) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return (ActionMenuView) r1;
    L10:
        return null;
    }

    private void translateActionMenuView(ActionMenuView r2, int r3, boolean r4) {
        translateActionMenuView(r2, r3, r4, false);
    }

    private void translateActionMenuView(final ActionMenuView r2, final int r3, final boolean r4, boolean r5) {
        Runnable r0 = new AnonymousClass8(this, r2, r3, r4);
        if (r5 == false) goto L5;
        r2.post(r0);
        return;
    L5:
        r0.run();
    }

    protected int getActionMenuViewTranslationX(ActionMenuView r7, int r8, boolean r9) {
        int r1 = 0;
        if (this.menuAlignmentMode == 1) goto L7;
        if (r8 != 1) goto L6;
        if (r9 == true) goto L7;
    L6:
        return 0;
    L7:
        boolean r10 = ViewUtils.isLayoutRtl(this);
        if (r10 == false) goto L10;
        int r11 = getMeasuredWidth();
    L11:
        int r0 = 0;
    L13:
        if (r0 >= getChildCount()) goto L25;
        View r3 = getChildAt(r0);
        if ((r3.getLayoutParams() instanceof Toolbar.LayoutParams) == true) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L24;
        if (r10 == false) goto L23;
        r11 = Math.min(r11, r3.getLeft());
        goto L24
    L23:
        r11 = Math.max(r11, r3.getRight());
    L24:
        r0 = r0 + 1;
        goto L13
    L17:
        if ((((Toolbar.LayoutParams) r3.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 8388611) goto L19;
        r4 = true;
        goto L20
    L25:
        if (r10 == false) goto L27;
        int r12 = r7.getRight();
    L28:
        if (r10 == false) goto L30;
        int r2 = this.rightInset;
    L32:
        if (getNavigationIcon() != null) goto L39;
        int r6 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
        if (r10 == true) goto L37;
        r6 = -r6;
    L37:
        r1 = r6;
    L39:
        return r11 - ((r12 + r2) + r1);
    L30:
        r2 = -this.leftInset;
        goto L32
    L27:
        r12 = r7.getLeft();
        goto L28
    L10:
        r11 = 0;
        goto L11
    }

    private void cancelAnimations() {
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.modeAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L9;
        cancelAnimations();
        setCutoutStateAndTranslateFab();
        final View r6 = findDependentView();
        if (r6 == null) goto L9;
        if (ViewCompat.isLaidOut(r6) == false) goto L9;
        r6.post(new BottomAppBar$$ExternalSyntheticLambda0(r6));
    L9:
        setActionMenuViewPosition();
    }

    static /* synthetic */ void lambda$onLayout$0(View r0) {
        r0.requestLayout();
    }

    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private void setCutoutStateAndTranslateFab() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        MaterialShapeDrawable r0 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L9:
        float r1 = 0.0f;
    L10:
        r0.setInterpolation(r1);
        View r2 = findDependentView();
        if (r2 == null) goto L14;
        r2.setTranslationY(getFabTranslationY());
        r2.setTranslationX(getFabTranslationX());
        return;
    L14:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L9;
        if (this.fabAnchorMode != 1) goto L9;
        r1 = 1.0f;
        goto L10
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r0 = getActionMenuView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.menuAnimator != null) goto L12;
        r0.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L9;
        translateActionMenuView(r0, 0, false);
        return;
    L9:
        translateActionMenuView(r0, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void addFabAnimationListeners(FloatingActionButton r2) {
        r2.addOnHideAnimationListener(this.fabAnimationListener);
        r2.addOnShowAnimationListener(new AnonymousClass9(this));
        r2.addTransformationCallback(this.fabTransformationCallback);
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.fabAlignmentMode = this.fabAlignmentMode;
        r1.fabAttached = this.fabAttached;
        return r1;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.fabAlignmentMode = r3.fabAlignmentMode;
        this.fabAttached = r3.fabAttached;
    }
}
