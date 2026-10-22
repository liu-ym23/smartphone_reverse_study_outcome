package com.stepos.launcher.assistant.slidepanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.FloatProperty;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class SlidingPanelLayoutInterpolator extends AnimatorListenerAdapter implements Interpolator {
    private static final float APPROACH_VELOCITY_FRACTION = 0.85f;
    public static final float WORKSPACE_SCROLL_SPRING_IN_PAGE_DAMPING_RATIO = 0.99f;
    public static final float WORKSPACE_SCROLL_SPRING_IN_PAGE_STIFFNESS = 350.0f;
    private Animator mAnimator;
    protected int mFinalX;
    private int mGeneration;
    private boolean mHoldAtTarget;
    private final FloatProperty<SlidingPanelLayout> mPanelXProperty = new AnonymousClass1("panel_x");
    private boolean mSettleIncreases;
    private final SlidingPanelLayout mSlidingPanelLayout;

    /* renamed from: com.stepos.launcher.assistant.slidepanel.SlidingPanelLayoutInterpolator$1, reason: invalid class name */
    public class AnonymousClass1 extends FloatProperty<SlidingPanelLayout> {
        public AnonymousClass1(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setValue$0(int i10) {
            SlidingPanelLayoutInterpolator.this.finishHeldSettle(i10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Float f10) {
            super.set((AnonymousClass1) obj, f10);
        }

        @Override // android.util.Property
        public Float get(SlidingPanelLayout slidingPanelLayout) {
            return Float.valueOf(slidingPanelLayout.getPanelXFloat());
        }

        @Override // android.util.FloatProperty
        public void setValue(SlidingPanelLayout slidingPanelLayout, float f10) {
            if (SlidingPanelLayoutInterpolator.this.mHoldAtTarget) {
                slidingPanelLayout.setPanelX(SlidingPanelLayoutInterpolator.this.mFinalX);
                return;
            }
            if (!SlidingPanelLayoutInterpolator.this.hasPassedTarget(f10)) {
                slidingPanelLayout.setPanelX(f10);
                return;
            }
            SlidingPanelLayoutInterpolator.this.mHoldAtTarget = true;
            slidingPanelLayout.setPanelX(SlidingPanelLayoutInterpolator.this.mFinalX);
            final int i10 = SlidingPanelLayoutInterpolator.this.mGeneration;
            slidingPanelLayout.post(new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30127a.lambda$setValue$0(i10);
                }
            });
        }
    }

    public SlidingPanelLayoutInterpolator(SlidingPanelLayout slidingPanelLayout) {
        this.mSlidingPanelLayout = slidingPanelLayout;
    }

    private static float clampApproachVelocity(float f10, float f11, float f12) {
        float f13 = f12 - f11;
        if (f13 == 0.0f || f10 == 0.0f || Math.signum(f10) != Math.signum(f13)) {
            return 0.0f;
        }
        return Math.signum(f10) * Math.min(Math.abs(f10), Math.abs(f13) * ((float) Math.sqrt(350.0d)) * 0.85f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishHeldSettle(int i10) {
        Animator animator;
        if (i10 != this.mGeneration || (animator = this.mAnimator) == null) {
            return;
        }
        animator.end();
    }

    private Context getContext() {
        return this.mSlidingPanelLayout.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPassedTarget(float f10) {
        boolean z10 = this.mSettleIncreases;
        float f11 = this.mFinalX;
        return z10 ? f10 > f11 : f10 < f11;
    }

    public void animateToX(int i10, float f10) {
        cancelAll();
        this.mGeneration++;
        this.mFinalX = i10;
        float fFloatValue = ((Float) this.mPanelXProperty.get(this.mSlidingPanelLayout)).floatValue();
        this.mSettleIncreases = ((float) this.mFinalX) > fFloatValue;
        ValueAnimator valueAnimatorC = new o7.e(getContext()).u(350.0f).o(0.99f).s(fFloatValue).p(this.mFinalX).t(clampApproachVelocity(f10, fFloatValue, this.mFinalX)).r(1.0f).q(true).c(this.mSlidingPanelLayout, this.mPanelXProperty);
        valueAnimatorC.addListener(this);
        valueAnimatorC.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.SlidingPanelLayoutInterpolator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingPanelLayoutInterpolator.this.mSlidingPanelLayout.setAllowOverScroll(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlidingPanelLayoutInterpolator.this.mSlidingPanelLayout.setAllowOverScroll(false);
            }
        });
        valueAnimatorC.start();
        this.mAnimator = valueAnimatorC;
    }

    public void animatorToX(int i10, int i11) {
        cancelAll();
        this.mGeneration++;
        this.mFinalX = i10;
        float f10 = i10;
        this.mSettleIncreases = f10 > ((Float) this.mPanelXProperty.get(this.mSlidingPanelLayout)).floatValue();
        if (i11 <= 0) {
            onAnimationEnd(null);
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mSlidingPanelLayout, this.mPanelXProperty, f10).setDuration(i11);
        duration.setInterpolator(this);
        duration.addListener(this);
        duration.start();
        this.mAnimator = duration;
    }

    public void cancelAll() {
        Animator animator = this.mAnimator;
        boolean z10 = animator != null && animator.isRunning();
        Animator animator2 = this.mAnimator;
        if (animator2 != null) {
            animator2.removeAllListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        this.mHoldAtTarget = false;
        if (z10) {
            this.mSlidingPanelLayout.scheduleSnapToTerminalIfIdle();
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float f11 = f10 - 1.0f;
        return (f11 * f11 * f11 * f11 * f11) + 1.0f;
    }

    public boolean isFinished() {
        Animator animator = this.mAnimator;
        return animator == null || !animator.isRunning();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        cancelAll();
        this.mSlidingPanelLayout.setPanelX(this.mFinalX);
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout.mSettling) {
            slidingPanelLayout.mSettling = false;
            int i10 = slidingPanelLayout.mPanelX;
            if (i10 == 0) {
                slidingPanelLayout.onPanelClosed();
            } else if (i10 == slidingPanelLayout.getMeasuredWidth()) {
                this.mSlidingPanelLayout.onPanelOpened();
            } else {
                this.mSlidingPanelLayout.snapToTerminalIfIdle();
            }
        }
    }
}
