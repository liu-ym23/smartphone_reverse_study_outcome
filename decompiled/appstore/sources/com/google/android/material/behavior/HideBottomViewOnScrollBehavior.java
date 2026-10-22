package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;

    @Nullable
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int height;

    public HideBottomViewOnScrollBehavior() {
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior r10, ViewPropertyAnimator r11) {
        r10.currentAnimator = r11;
        return r11;
    }

    private void animateChildTo(@NonNull V r10, int r11, long r12, TimeInterpolator r13) {
        this.currentAnimator = r10.animate().translationY(r11).setInterpolator(r13).setDuration(r12).setListener(new AnonymousClass1(this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        this.height = r11.getMeasuredHeight() + r13.bottomMargin;
        return super.onLayoutChild(r10, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17, @NonNull int[] r18) {
        if (r14 <= 0) goto L4;
        slideDown(r11);
        return;
    L4:
        if (r14 >= 0) goto L8;
        slideUp(r11);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
        if (r14 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAdditionalHiddenOffsetY(@NonNull V r10, @Dimension int r11) {
        this.additionalHiddenOffsetY = r11;
        if (this.currentState != 1) goto L6;
        r10.setTranslationY(this.height + r11);
        return;
    }

    public void slideDown(@NonNull V r10) {
        if (this.currentState != 1) goto L5;
        return;
    L5:
        ViewPropertyAnimator r11 = this.currentAnimator;
        if (r11 == null) goto L8;
        r11.cancel();
        r10.clearAnimation();
    L8:
        this.currentState = 1;
        animateChildTo(r10, this.height + this.additionalHiddenOffsetY, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }

    public void slideUp(@NonNull V r10) {
        if (this.currentState != 2) goto L5;
        return;
    L5:
        ViewPropertyAnimator r11 = this.currentAnimator;
        if (r11 == null) goto L8;
        r11.cancel();
        r10.clearAnimation();
    L8:
        this.currentState = 2;
        animateChildTo(r10, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    public HideBottomViewOnScrollBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }
}
