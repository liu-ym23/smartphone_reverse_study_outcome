package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    private static final int ENTER_ANIM_DURATION_ATTR = 0;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = 0;
    private static final int EXIT_ANIM_DURATION_ATTR = 0;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height;
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners;

    public interface OnScrollStateChangedListener {
        void onStateChanged(View r1, int r2);
    }

    public @interface ScrollState {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        if (r5 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior r0, ViewPropertyAnimator r1) {
        r0.currentAnimator = r1;
        return r1;
    }

    static {
        ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
        EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
        ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    }

    public HideBottomViewOnScrollBehavior() {
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public HideBottomViewOnScrollBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r4, V r5, int r6) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        this.height = r5.getMeasuredHeight() + r0.bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        Context r1 = r5.getContext();
        int r2 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(r1, r2, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), r2, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(r4, r5, r6);
    }

    public void setAdditionalHiddenOffsetY(V r3, int r4) {
        this.additionalHiddenOffsetY = r4;
        if (this.currentState != 1) goto L6;
        r3.setTranslationY(this.height + r4);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
        if (r5 <= 0) goto L4;
        slideDown(r2);
        return;
    L4:
        if (r5 >= 0) goto L8;
        slideUp(r2);
        return;
    }

    public boolean isScrolledUp() {
        if (this.currentState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void slideUp(V r2) {
        slideUp(r2, true);
    }

    public void slideUp(V r7, boolean r8) {
        if (isScrolledUp() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.currentAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
        r7.clearAnimation();
    L8:
        updateCurrentState(r7, 2);
        if (r8 == false) goto L11;
        animateChildTo(r7, 0, this.enterAnimDuration, this.enterAnimInterpolator);
        return;
    L11:
        r7.setTranslationY(0);
    }

    public boolean isScrolledDown() {
        if (this.currentState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void slideDown(V r2) {
        slideDown(r2, true);
    }

    public void slideDown(V r9, boolean r10) {
        if (isScrolledDown() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.currentAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
        r9.clearAnimation();
    L8:
        updateCurrentState(r9, 1);
        int r4 = this.height + this.additionalHiddenOffsetY;
        if (r10 == false) goto L11;
        animateChildTo(r9, r4, this.exitAnimDuration, this.exitAnimInterpolator);
        return;
    L11:
        r9.setTranslationY(r4);
    }

    private void updateCurrentState(V r3, int r4) {
        this.currentState = r4;
        Iterator<OnScrollStateChangedListener> r5 = this.onScrollStateChangedListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onStateChanged(r3, this.currentState);
        goto L4
    }

    private void animateChildTo(V r1, int r2, long r3, TimeInterpolator r5) {
        this.currentAnimator = r1.animate().translationY(r2).setInterpolator(r5).setDuration(r3).setListener(new AnonymousClass1(this));
    }

    public void addOnScrollStateChangedListener(OnScrollStateChangedListener r1) {
        this.onScrollStateChangedListeners.add(r1);
    }

    public void removeOnScrollStateChangedListener(OnScrollStateChangedListener r1) {
        this.onScrollStateChangedListeners.remove(r1);
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }
}
