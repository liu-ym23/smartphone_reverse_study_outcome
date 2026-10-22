package com.android.server.display;

import android.animation.ValueAnimator;
import android.pico.utils.ExtImplFactory;
import android.util.FloatProperty;
import android.view.Choreographer;
import com.android.server.power.PowerManagerServiceSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public final class RampAnimator<T> {
    protected float mAnimatedValue;
    protected boolean mAnimating;
    private float mAnimationDecreaseMaxTimeSecs;
    private float mAnimationIncreaseMaxTimeSecs;
    private final Clock mClock;
    private float mCurrentValue;
    private IExtRampAnimator<T> mExt;
    protected boolean mFirstTime;
    protected boolean mHdrRamp;
    private long mLastFrameTimeNanos;
    private final T mObject;
    private final FloatProperty<T> mProperty;
    protected float mRate;
    private RampAnimatorSmtEx<T> mSmtEx;
    private float mTargetHlgValue;
    private float mTargetLinearValue;

    interface Clock {
        long nanoTime();
    }

    static class DualRampAnimator<T> {
        protected final Runnable mAnimationCallback;
        private boolean mAwaitingCallback;
        protected final Choreographer mChoreographer;
        private IExtRampAnimator.IExtDualRampAnimator<T> mExt;
        protected final RampAnimator<T> mFirst;
        private Listener mListener;
        protected final RampAnimator<T> mSecond;

        /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
        static /* bridge */ /* synthetic */ IExtRampAnimator.IExtDualRampAnimator m3880$$Nest$fgetmExt(DualRampAnimator r0) {
            return r0.mExt;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ Listener m3881$$Nest$fgetmListener(DualRampAnimator r0) {
            return r0.mListener;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAwaitingCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3882$$Nest$fputmAwaitingCallback(DualRampAnimator r0, boolean r1) {
            r0.mAwaitingCallback = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mpostAnimationCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3883$$Nest$mpostAnimationCallback(DualRampAnimator r0) {
            r0.postAnimationCallback();
        }

        DualRampAnimator(T object, FloatProperty<T> firstProperty, FloatProperty<T> secondProperty) {
            this.mAnimationCallback = new AnonymousClass1(this);
            this.mExt = (IExtRampAnimator.IExtDualRampAnimator) ExtImplFactory.getImpl(IExtRampAnimator.IExtDualRampAnimator.class, new Object[]{this});
            this.mChoreographer = Choreographer.getInstance();
            this.mFirst = new RampAnimator(object, firstProperty, true);
            this.mSecond = new RampAnimator(object, secondProperty, false);
        }

        public void setAnimationTimeLimits(long animationRampIncreaseMaxTimeMillis, long animationRampDecreaseMaxTimeMillis) {
            this.mFirst.setAnimationTimeLimits(animationRampIncreaseMaxTimeMillis, animationRampDecreaseMaxTimeMillis);
            this.mSecond.setAnimationTimeLimits(animationRampIncreaseMaxTimeMillis, animationRampDecreaseMaxTimeMillis);
        }

        public boolean animateTo(float linearFirstTarget, float linearSecondTarget, float rate, boolean ignoreAnimationLimits) {
            boolean animationTargetChanged = this.mFirst.setAnimationTarget(linearFirstTarget, rate, ignoreAnimationLimits);
            boolean animationTargetChanged2 = animationTargetChanged | this.mSecond.setAnimationTarget(linearSecondTarget, rate, ignoreAnimationLimits);
            boolean shouldBeAnimating = isAnimating();
            if (shouldBeAnimating != this.mAwaitingCallback) goto L5;
        L10:
            this.mExt.animateTo(linearFirstTarget, linearSecondTarget, rate, ignoreAnimationLimits);
            if (this.mListener == null) goto L14;
            if (shouldBeAnimating == true) goto L14;
            this.mListener.onAnimationEnd();
            this.mExt.onDualAnimationEnd();
        L14:
            return animationTargetChanged2;
        L5:
            if (shouldBeAnimating == false) goto L8;
            this.mExt.onDualAnimationStart();
            this.mAwaitingCallback = true;
            postAnimationCallback();
            goto L10
        L8:
            if (this.mAwaitingCallback == false) goto L10;
            this.mChoreographer.removeCallbacks(1, this.mAnimationCallback, null);
            this.mAwaitingCallback = false;
            goto L10
        }

        public void setListener(Listener listener) {
            this.mListener = listener;
        }

        public boolean isAnimating() {
            if (this.mFirst.isAnimating() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mSecond.isAnimating() == true) goto L8;
            return false;
        }

        private void postAnimationCallback() {
            this.mChoreographer.postCallback(1, this.mAnimationCallback, null);
        }

        public IExtRampAnimator.IExtDualRampAnimator<T> getExt() {
            return this.mExt;
        }
    }

    public interface Listener {
        void onAnimationEnd();
    }

    public RampAnimator(T object, FloatProperty<T> property, boolean hdrRamp) {
        this(object, property, new RampAnimator$$ExternalSyntheticLambda0());
        this.mHdrRamp = hdrRamp;
        this.mExt.init();
    }

    RampAnimator(T object, FloatProperty<T> property, Clock clock) {
        this.mFirstTime = true;
        this.mHdrRamp = false;
        this.mExt = (IExtRampAnimator) ExtImplFactory.getImpl(IExtRampAnimator.class, new Object[]{this});
        this.mObject = object;
        this.mProperty = property;
        this.mClock = clock;
        if (PowerManagerServiceSmtEx.BRIGHTNESS.equals(property) == false) goto L6;
        this.mSmtEx = new RampAnimatorSmtEx(object, property, this);
        return;
    }

    void setAnimationTimeLimits(long animationRampIncreaseMaxTimeMillis, long animationRampDecreaseMaxTimeMillis) {
        float r3 = 0.0f;
        if (animationRampIncreaseMaxTimeMillis <= 0) goto L5;
        float r2 = animationRampIncreaseMaxTimeMillis / 1000.0f;
    L6:
        this.mAnimationIncreaseMaxTimeSecs = r2;
        if (animationRampDecreaseMaxTimeMillis <= 0) goto L10;
        r3 = animationRampDecreaseMaxTimeMillis / 1000.0f;
    L10:
        this.mAnimationDecreaseMaxTimeSecs = r3;
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    boolean setAnimationTarget(float targetLinear, float rate, boolean ignoreAnimationLimits) {
        float maxDecreaseTimeSecs = 0.0f;
        if (ignoreAnimationLimits == false) goto L5;
        float maxIncreaseTimeSecs = 0.0f;
    L6:
        if (ignoreAnimationLimits == true) goto L10;
        maxDecreaseTimeSecs = this.mAnimationDecreaseMaxTimeSecs;
    L10:
        return setAnimationTarget(targetLinear, rate, maxIncreaseTimeSecs, maxDecreaseTimeSecs);
    L5:
        maxIncreaseTimeSecs = this.mAnimationIncreaseMaxTimeSecs;
        goto L6
    }

    private boolean setAnimationTarget(float targetLinear, float rate, float maxIncreaseTimeSecs, float maxDecreaseTimeSecs) {
        boolean changed = false;
        if (this.mFirstTime == true) goto L49;
        if (rate <= 0.0f) goto L49;
        if (targetLinear <= this.mCurrentValue) goto L15;
        if (maxIncreaseTimeSecs <= 0.0f) goto L15;
        if (((targetLinear - this.mCurrentValue) / rate) <= maxIncreaseTimeSecs) goto L15;
        rate = (targetLinear - this.mCurrentValue) / maxIncreaseTimeSecs;
    L22:
        if (this.mAnimating == true) goto L24;
    L33:
        this.mRate = rate;
    L35:
        if (this.mAnimating == false) goto L40;
        if (targetLinear == this.mTargetLinearValue) goto L40;
        this.mExt.onAnimatingStart(this.mTargetLinearValue, targetLinear);
    L40:
        if (this.mTargetHlgValue == targetLinear) goto L42;
        changed = true;
    L42:
        this.mTargetHlgValue = targetLinear;
        this.mTargetLinearValue = targetLinear;
        if (this.mAnimating == false) goto L45;
    L47:
        return changed;
    L45:
        if (targetLinear == this.mCurrentValue) goto L47;
        this.mExt.onAnimationStart(this.mCurrentValue, targetLinear);
        this.mAnimating = true;
        this.mAnimatedValue = this.mCurrentValue;
        this.mLastFrameTimeNanos = this.mClock.nanoTime();
        goto L47
    L24:
        if (rate > this.mRate) goto L33;
        if (targetLinear > this.mCurrentValue) goto L30;
        if (this.mCurrentValue <= this.mTargetHlgValue) goto L33;
    L30:
        if (this.mTargetHlgValue > this.mCurrentValue) goto L35;
        if (this.mCurrentValue > targetLinear) goto L35;
    L15:
        if (targetLinear >= this.mCurrentValue) goto L22;
        if (maxDecreaseTimeSecs <= 0.0f) goto L22;
        if (((this.mCurrentValue - targetLinear) / rate) <= maxDecreaseTimeSecs) goto L22;
        rate = (this.mCurrentValue - targetLinear) / maxDecreaseTimeSecs;
    L49:
        if (this.mFirstTime == false) goto L51;
    L54:
        this.mFirstTime = false;
        this.mRate = 0.0f;
        this.mTargetHlgValue = targetLinear;
        this.mTargetLinearValue = targetLinear;
        this.mCurrentValue = targetLinear;
        float current = this.mAnimatedValue;
        this.mAnimatedValue = targetLinear;
        this.mExt.onAnimationEnd(true, current, targetLinear);
        setPropertyValue(targetLinear);
        this.mAnimating = false;
        return true;
    L51:
        if (targetLinear != this.mCurrentValue) goto L54;
        return false;
    }

    boolean isAnimating() {
        return this.mAnimating;
    }

    private void setPropertyValue(float val) {
        if (val != this.mTargetHlgValue) goto L5;
        float linearVal = this.mTargetLinearValue;
    L6:
        this.mExt.setPropertyValue(val, linearVal);
        this.mProperty.setValue(this.mObject, linearVal);
        return;
    L5:
        linearVal = val;
        goto L6
    }

    void performNextAnimationStep(long frameTimeNanos) {
        float timeDelta = (frameTimeNanos - this.mLastFrameTimeNanos) * 1.0E-9f;
        this.mLastFrameTimeNanos = frameTimeNanos;
        float scale = ValueAnimator.getDurationScale();
        if (scale != 0.0f) goto L5;
        this.mAnimatedValue = this.mTargetHlgValue;
    L9:
        float amount = this.mCurrentValue;
        this.mCurrentValue = this.mAnimatedValue;
        if (amount == this.mCurrentValue) goto L13;
        setPropertyValue(this.mCurrentValue);
    L13:
        if (this.mTargetHlgValue != this.mCurrentValue) goto L16;
        this.mAnimating = false;
        this.mExt.onAnimationEnd(false, this.mCurrentValue, this.mTargetHlgValue);
        return;
    L16:
        return;
    L5:
        float amount2 = this.mExt.recalculateAmount(timeDelta, (this.mRate * timeDelta) / scale);
        if (this.mTargetHlgValue <= this.mCurrentValue) goto L8;
        this.mAnimatedValue = Math.min(this.mAnimatedValue + amount2, this.mTargetHlgValue);
        goto L9
    L8:
        this.mAnimatedValue = Math.max(this.mAnimatedValue - amount2, this.mTargetHlgValue);
        goto L9
    }

    public RampAnimatorSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IExtRampAnimator<T> getExt() {
        return this.mExt;
    }
}
