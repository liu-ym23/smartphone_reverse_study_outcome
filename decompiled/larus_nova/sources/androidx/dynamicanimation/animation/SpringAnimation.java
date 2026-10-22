package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes17.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float r100) {
    }

    private void sanityCheck() {
        SpringForce r100 = this.mSpring;
        if (r100 == null) goto L14;
        double r101 = r100.getFinalPosition();
        if (r101 > this.mMaxValue) goto L12;
        if (r101 < this.mMinValue) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void cancel() {
        super.cancel();
        float r100 = this.mPendingPosition;
        if (r100 == Float.MAX_VALUE) goto L10;
        SpringForce r101 = this.mSpring;
        if (r101 != null) goto L7;
        this.mSpring = new SpringForce(r100);
    L8:
        this.mPendingPosition = Float.MAX_VALUE;
        return;
    L7:
        r101.setFinalPosition(r100);
        goto L8
    }

    public void skipToEnd() {
        if (canSkipToEnd() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.mRunning == false) goto L14;
        this.mEndRequested = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold(getValueThreshold());
        super.start();
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    public SpringAnimation(FloatValueHolder r100) {
        super(r100);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public void animateToFinalPosition(float r100) {
        if (isRunning() == false) goto L6;
        this.mPendingPosition = r100;
        return;
    L6:
        if (this.mSpring != null) goto L8;
        this.mSpring = new SpringForce(r100);
    L8:
        this.mSpring.setFinalPosition(r100);
        start();
    }

    public SpringAnimation setSpring(SpringForce r100) {
        this.mSpring = r100;
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long r210) {
        if (this.mEndRequested == false) goto L10;
        float r100 = this.mPendingPosition;
        if (r100 == Float.MAX_VALUE) goto L7;
        this.mSpring.setFinalPosition(r100);
        this.mPendingPosition = Float.MAX_VALUE;
    L7:
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        this.mEndRequested = false;
        return true;
    L10:
        if (this.mPendingPosition == Float.MAX_VALUE) goto L12;
        long r110 = r210 / 2;
        DynamicAnimation.MassState r101 = this.mSpring.updateValues(this.mValue, this.mVelocity, r110);
        this.mSpring.setFinalPosition(this.mPendingPosition);
        this.mPendingPosition = Float.MAX_VALUE;
        DynamicAnimation.MassState r102 = this.mSpring.updateValues(r101.mValue, r101.mVelocity, r110);
        this.mValue = r102.mValue;
        this.mVelocity = r102.mVelocity;
    L13:
        float r103 = Math.max(this.mValue, this.mMinValue);
        this.mValue = r103;
        float r104 = Math.min(r103, this.mMaxValue);
        this.mValue = r104;
        if (isAtEquilibrium(r104, this.mVelocity) == false) goto L17;
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    L17:
        return false;
    L12:
        DynamicAnimation.MassState r105 = this.mSpring.updateValues(this.mValue, this.mVelocity, r210);
        this.mValue = r105.mValue;
        this.mVelocity = r105.mVelocity;
        goto L13
    }

    public SpringAnimation(FloatValueHolder r100, float r101) {
        super(r100);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(r101);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float r100, float r101) {
        return this.mSpring.getAcceleration(r100, r101);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float r100, float r101) {
        return this.mSpring.isAtEquilibrium(r100, r101);
    }

    public <K> SpringAnimation(K r100, FloatPropertyCompat<K> r101) {
        super(r100, r101);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r100, FloatPropertyCompat<K> r101, float r102) {
        super(r100, r101);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(r102);
    }
}
