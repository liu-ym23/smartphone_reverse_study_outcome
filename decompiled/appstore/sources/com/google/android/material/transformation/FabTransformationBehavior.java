package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public static class FabTransformationSpec {
        public Positioning positioning;

        @Nullable
        public MotionSpec timings;

        public FabTransformationSpec() {
        }
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    @Nullable
    private ViewGroup calculateChildContentContainer(@NonNull View r10) {
        View r11 = r10.findViewById(R.id.mtrl_child_content_container);
        if (r11 == null) goto L7;
        return toViewGroupOrNull(r11);
    L7:
        if ((r10 instanceof TransformationChildLayout) == true) goto L14;
        if ((r10 instanceof TransformationChildCard) == true) goto L14;
        return toViewGroupOrNull(r10);
    L14:
        return toViewGroupOrNull(((ViewGroup) r10).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@NonNull View r10, @NonNull FabTransformationSpec r11, @NonNull MotionTiming r12, @NonNull MotionTiming r13, float r14, float r15, float r16, float r17, @NonNull RectF r18) {
        float r19 = calculateValueOfAnimationAtEndOfExpansion(r11, r12, r14, r16);
        float r20 = calculateValueOfAnimationAtEndOfExpansion(r11, r13, r15, r17);
        Rect r21 = this.tmpRect;
        r10.getWindowVisibleDisplayFrame(r21);
        RectF r22 = this.tmpRectF1;
        r22.set(r21);
        RectF r23 = this.tmpRectF2;
        calculateWindowBounds(r10, r23);
        r23.offset(r19, r20);
        r23.intersect(r22);
        r18.set(r23);
    }

    private void calculateDependencyWindowBounds(@NonNull View r10, @NonNull RectF r11) {
        calculateWindowBounds(r10, r11);
        r11.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float r10, float r11, boolean r12, @NonNull FabTransformationSpec r13) {
        if (r10 != 0.0f) goto L5;
    L14:
        MotionTiming r14 = r13.timings.getTiming("translationXLinear");
        MotionTiming r15 = r13.timings.getTiming("translationYLinear");
    L16:
        return new Pair(r14, r15);
    L5:
        if (r11 == 0.0f) goto L14;
        if (r12 == true) goto L9;
    L10:
        if (r12 == true) goto L13;
        if (r11 <= 0.0f) goto L13;
    L12:
        r14 = r13.timings.getTiming("translationXCurveUpwards");
        r15 = r13.timings.getTiming("translationYCurveUpwards");
    L13:
        r14 = r13.timings.getTiming("translationXCurveDownwards");
        r15 = r13.timings.getTiming("translationYCurveDownwards");
        goto L16
    L9:
        if (r11 < 0.0f) goto L12;
        goto L10
    }

    private float calculateRevealCenterX(@NonNull View r10, @NonNull View r11, @NonNull Positioning r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        r14.offset(-calculateTranslationX(r10, r11, r12), 0.0f);
        return r13.centerX() - r14.left;
    }

    private float calculateRevealCenterY(@NonNull View r10, @NonNull View r11, @NonNull Positioning r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        r14.offset(0.0f, -calculateTranslationY(r10, r11, r12));
        return r13.centerY() - r14.top;
    }

    private float calculateTranslationX(@NonNull View r10, @NonNull View r11, @NonNull Positioning r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        int r15 = r12.gravity & 7;
        if (r15 != 1) goto L5;
        float r16 = r14.centerX();
        float r17 = r13.centerX();
    L10:
        float r18 = r16 - r17;
    L14:
        return r18 + r12.xAdjustment;
    L5:
        if (r15 != 3) goto L7;
        r16 = r14.left;
        r17 = r13.left;
        goto L10
    L7:
        if (r15 == 5) goto L9;
        r18 = 0.0f;
        goto L14
    L9:
        r16 = r14.right;
        r17 = r13.right;
        goto L10
    }

    private float calculateTranslationY(@NonNull View r10, @NonNull View r11, @NonNull Positioning r12) {
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        calculateDependencyWindowBounds(r10, r13);
        calculateWindowBounds(r11, r14);
        int r15 = r12.gravity & 112;
        if (r15 != 16) goto L5;
        float r16 = r14.centerY();
        float r17 = r13.centerY();
    L10:
        float r18 = r16 - r17;
    L14:
        return r18 + r12.yAdjustment;
    L5:
        if (r15 != 48) goto L7;
        r16 = r14.top;
        r17 = r13.top;
        goto L10
    L7:
        if (r15 == 80) goto L9;
        r18 = 0.0f;
        goto L14
    L9:
        r16 = r14.bottom;
        r17 = r13.bottom;
        goto L10
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@NonNull FabTransformationSpec r10, @NonNull MotionTiming r11, float r12, float r13) {
        long r14 = r11.getDelay();
        long r15 = r11.getDuration();
        MotionTiming r16 = r10.timings.getTiming("expansion");
        return AnimationUtils.lerp(r12, r13, r11.getInterpolator().getInterpolation((((r16.getDelay() + r16.getDuration()) + 17) - r14) / r15));
    }

    private void calculateWindowBounds(@NonNull View r10, RectF r11) {
        r11.set(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        int[] r12 = this.tmpArray;
        r10.getLocationInWindow(r12);
        r11.offsetTo(r12[0], r12[1]);
        r11.offset((int) (-r10.getTranslationX()), (int) (-r10.getTranslationY()));
    }

    private void createChildrenFadeAnimation(View r10, View r11, boolean r12, boolean r13, @NonNull FabTransformationSpec r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof ViewGroup) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof CircularRevealWidget) == true) goto L8;
    L10:
        ViewGroup r17 = calculateChildContentContainer(r11);
        if (r17 != null) goto L14;
        return;
    L14:
        if (r12 == false) goto L18;
        if (r13 == true) goto L17;
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(r17, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r17, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
    L19:
        r14.timings.getTiming("contentFade").apply(r18);
        r15.add(r18);
        return;
    L18:
        r18 = ObjectAnimator.ofFloat(r17, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
        goto L19
    L8:
        if (CircularRevealHelper.STRATEGY != 0) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(@NonNull View r10, View r11, boolean r12, boolean r13, @NonNull FabTransformationSpec r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        CircularRevealWidget r17 = (CircularRevealWidget) r11;
        int r18 = getBackgroundTint(r10);
        int r19 = 16777215 & r18;
        if (r12 == false) goto L10;
        if (r13 == true) goto L9;
        r17.setCircularRevealScrimColor(r18);
    L9:
        ObjectAnimator r20 = ObjectAnimator.ofInt(r17, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r19});
    L11:
        r20.setEvaluator(ArgbEvaluatorCompat.getInstance());
        r14.timings.getTiming("color").apply(r20);
        r15.add(r20);
        return;
    L10:
        r20 = ObjectAnimator.ofInt(r17, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r18});
        goto L11
    }

    private void createDependencyTranslationAnimation(@NonNull View r10, @NonNull View r11, boolean r12, @NonNull FabTransformationSpec r13, @NonNull List<Animator> r14) {
        float r15 = calculateTranslationX(r10, r11, r13.positioning);
        float r16 = calculateTranslationY(r10, r11, r13.positioning);
        Pair<MotionTiming, MotionTiming> r17 = calculateMotionTiming(r15, r16, r12, r13);
        MotionTiming r18 = (MotionTiming) r17.first;
        MotionTiming r19 = (MotionTiming) r17.second;
        Property r20 = View.TRANSLATION_X;
        if (r12 == true) goto L6;
        r15 = this.dependencyOriginalTranslationX;
    L6:
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r10, r20, new float[]{r15});
        Property r22 = View.TRANSLATION_Y;
        if (r12 == true) goto L10;
        r16 = this.dependencyOriginalTranslationY;
    L10:
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r10, r22, new float[]{r16});
        r18.apply(r21);
        r19.apply(r23);
        r14.add(r21);
        r14.add(r23);
    }

    @TargetApi(21)
    private void createElevationAnimation(View r10, @NonNull View r11, boolean r12, boolean r13, @NonNull FabTransformationSpec r14, @NonNull List<Animator> r15, List<Animator.AnimatorListener> r16) {
        float r17 = ViewCompat.v(r11) - ViewCompat.v(r10);
        if (r12 == false) goto L7;
        if (r13 == true) goto L6;
        r11.setTranslationZ(-r17);
    L6:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r11, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r14.timings.getTiming("elevation").apply(r18);
        r15.add(r18);
        return;
    L7:
        r18 = ObjectAnimator.ofFloat(r11, View.TRANSLATION_Z, new float[]{-r17});
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(@NonNull View r18, View r19, boolean r20, boolean r21, @NonNull FabTransformationSpec r22, float r23, float r24, @NonNull List<Animator> r25, @NonNull List<Animator.AnimatorListener> r26) {
        if ((r19 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        final CircularRevealWidget r12 = (CircularRevealWidget) r19;
        float r10 = calculateRevealCenterX(r18, r19, r22.positioning);
        float r11 = calculateRevealCenterY(r18, r19, r22.positioning);
        ((FloatingActionButton) r18).getContentRect(this.tmpRect);
        float r13 = this.tmpRect.width() / 2.0f;
        MotionTiming r14 = r22.timings.getTiming("expansion");
        if (r20 == false) goto L12;
        if (r21 == true) goto L9;
        r12.setRevealInfo(new CircularRevealWidget.RevealInfo(r10, r11, r13));
    L9:
        if (r21 == false) goto L11;
        r13 = r12.getRevealInfo().radius;
    L11:
        Animator r15 = CircularRevealCompat.createCircularReveal(r12, r10, r11, MathUtils.distanceToFurthestCorner(r10, r11, 0.0f, 0.0f, r23, r24));
        r15.addListener(new AnonymousClass4(this, r12));
        createPreFillRadialExpansion(r19, r14.getDelay(), (int) r10, (int) r11, r13, r25);
    L13:
        r14.apply(r15);
        r25.add(r15);
        r26.add(CircularRevealCompat.createCircularRevealListener(r12));
        return;
    L12:
        float r16 = r12.getRevealInfo().radius;
        Animator r17 = CircularRevealCompat.createCircularReveal(r12, r10, r11, r13);
        int r27 = (int) r10;
        int r110 = (int) r11;
        createPreFillRadialExpansion(r19, r14.getDelay(), r27, r110, r16, r25);
        createPostFillRadialExpansion(r19, r14.getDelay(), r14.getDuration(), r22.timings.getTotalDuration(), r27, r110, r13, r25);
        r15 = r17;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(View r10, final View r11, boolean r12, boolean r13, @NonNull FabTransformationSpec r14, @NonNull List<Animator> r15, @NonNull List<Animator.AnimatorListener> r16) {
        if ((r11 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof ImageView) == false) goto L19;
        final CircularRevealWidget r17 = (CircularRevealWidget) r11;
        final Drawable r18 = ((ImageView) r10).getDrawable();
        if (r18 != null) goto L10;
        return;
    L10:
        r18.mutate();
        if (r12 == false) goto L15;
        if (r13 == true) goto L14;
        r18.setAlpha(PrivateKeyType.INVALID);
    L14:
        ObjectAnimator r19 = ObjectAnimator.ofInt(r18, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
    L16:
        r19.addUpdateListener(new AnonymousClass2(this, r11));
        r14.timings.getTiming("iconFade").apply(r19);
        r15.add(r19);
        r16.add(new AnonymousClass3(this, r17, r18));
        return;
    L15:
        r19 = ObjectAnimator.ofInt(r18, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{PrivateKeyType.INVALID});
        goto L16
    }

    private void createPostFillRadialExpansion(View r10, long r11, long r12, long r13, int r14, int r15, float r16, @NonNull List<Animator> r17) {
        long r18 = r11 + r12;
        if (r18 >= r13) goto L6;
        Animator r19 = ViewAnimationUtils.createCircularReveal(r10, r14, r15, r16, r16);
        r19.setStartDelay(r18);
        r19.setDuration(r13 - r18);
        r17.add(r19);
        return;
    }

    private void createPreFillRadialExpansion(View r10, long r11, int r12, int r13, float r14, @NonNull List<Animator> r15) {
        if (r11 <= 0) goto L6;
        Animator r16 = ViewAnimationUtils.createCircularReveal(r10, r12, r13, r14, r14);
        r16.setStartDelay(0);
        r16.setDuration(r11);
        r15.add(r16);
        return;
    }

    private void createTranslationAnimation(@NonNull View r16, @NonNull View r17, boolean r18, boolean r19, @NonNull FabTransformationSpec r20, @NonNull List<Animator> r21, List<Animator.AnimatorListener> r22, @NonNull RectF r23) {
        float r10 = calculateTranslationX(r16, r17, r20.positioning);
        float r11 = calculateTranslationY(r16, r17, r20.positioning);
        Pair<MotionTiming, MotionTiming> r12 = calculateMotionTiming(r10, r11, r18, r20);
        MotionTiming r13 = (MotionTiming) r12.first;
        MotionTiming r14 = (MotionTiming) r12.second;
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r10);
        r17.setTranslationY(-r11);
    L6:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r17, r20, r13, r14, -r10, -r11, 0.0f, 0.0f, r23);
    L8:
        r13.apply(r15);
        r14.apply(r110);
        r21.add(r15);
        r21.add(r110);
        return;
    L7:
        r15 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r10});
        r110 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r11});
        goto L8
    }

    private int getBackgroundTint(@NonNull View r10) {
        ColorStateList r11 = ViewCompat.r(r10);
        if (r11 != null) goto L5;
        return 0;
    L5:
        return r11.getColorForState(r10.getDrawableState(), r11.getDefaultColor());
    }

    @Nullable
    private ViewGroup toViewGroupOrNull(View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r10;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull View r12) {
        if (r11.getVisibility() == 8) goto L13;
        if ((r12 instanceof FloatingActionButton) == false) goto L14;
        int r13 = ((FloatingActionButton) r12).getExpandedComponentIdHint();
        if (r13 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r13 == r11.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.c r10) {
        if (r10.f2414h != 0) goto L6;
        r10.f2414h = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull final View r16, @NonNull final View r17, final boolean r18, boolean r19) {
        FabTransformationSpec r12 = onCreateMotionSpec(r17.getContext(), r18);
        if (r18 == false) goto L5;
        this.dependencyOriginalTranslationX = r16.getTranslationX();
        this.dependencyOriginalTranslationY = r16.getTranslationY();
    L5:
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        createElevationAnimation(r16, r17, r18, r19, r12, r13, r14);
        RectF r10 = this.tmpRectF1;
        createTranslationAnimation(r16, r17, r18, r19, r12, r13, r14, r10);
        float r11 = r10.width();
        float r15 = r10.height();
        createDependencyTranslationAnimation(r16, r17, r18, r12, r13);
        createIconFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        createExpansionAnimation(r16, r17, r18, r19, r12, r11, r15, r13, r14);
        createColorAnimation(r16, r17, r18, r19, r12, r13, r14);
        createChildrenFadeAnimation(r16, r17, r18, r19, r12, r13, r14);
        AnimatorSet r20 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r20, r13);
        r20.addListener(new AnonymousClass1(this, r18, r17, r16));
        int r21 = r14.size();
        int r22 = 0;
    L6:
        if (r22 >= r21) goto L8;
        r20.addListener(r14.get(r22));
        r22 = r22 + 1;
        goto L6
    L8:
        return r20;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context r10, boolean r11);

    public FabTransformationBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
