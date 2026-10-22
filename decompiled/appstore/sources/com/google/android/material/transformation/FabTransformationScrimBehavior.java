package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    private void createScrimAnimation(@NonNull View r10, boolean r11, boolean r12, @NonNull List<Animator> r13, List<Animator.AnimatorListener> r14) {
        if (r11 == false) goto L5;
        MotionTiming r15 = this.expandTiming;
    L7:
        if (r11 == false) goto L11;
        if (r12 == true) goto L10;
        r10.setAlpha(0.0f);
    L10:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{1.0f});
    L12:
        r15.apply(r16);
        r13.add(r16);
        return;
    L11:
        r16 = ObjectAnimator.ofFloat(r10, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r15 = this.collapseTiming;
        goto L7
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
        return r12 instanceof FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View r10, @NonNull final View r11, final boolean r12, boolean r13) {
        ArrayList r14 = new ArrayList();
        createScrimAnimation(r11, r12, r13, r14, new ArrayList());
        AnimatorSet r15 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r15, r14);
        r15.addListener(new AnonymousClass1(this, r12, r11));
        return r15;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
        return super.onTouchEvent(r10, r11, r12);
    }

    public FabTransformationScrimBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }
}
