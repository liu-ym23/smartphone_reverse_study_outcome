package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame;
    private float frameRaw;
    private long lastFrameTimeNs;
    private float maxFrame;
    private float minFrame;
    private int repeatCount;
    protected boolean running;
    private float speed;
    private boolean speedReversedForRepeatMode;
    private boolean useCompositionFrameRate;

    public LottieValueAnimator() {
        this.speed = 1.0f;
        this.speedReversedForRepeatMode = false;
        this.lastFrameTimeNs = 0;
        this.frameRaw = 0.0f;
        this.frame = 0.0f;
        this.repeatCount = 0;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
        this.running = false;
        this.useCompositionFrameRate = false;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return (this.frame - r0.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        if (this.composition != null) goto L7;
        return 0.0f;
    L7:
        if (isReversed() == false) goto L11;
        float r0 = getMaxFrame() - this.frame;
        float r1 = getMaxFrame();
        float r2 = getMinFrame();
    L10:
        return r0 / (r1 - r2);
    L11:
        r0 = this.frame - getMinFrame();
        r1 = getMaxFrame();
        r2 = getMinFrame();
        goto L10
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return (long) r2.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    public void setUseCompositionFrameRate(boolean r1) {
        this.useCompositionFrameRate = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r7) {
        postFrameCallback();
        if (this.composition != null) goto L5;
        return;
    L5:
        if (isRunning() == false) goto L44;
        L.beginSection("LottieValueAnimator#doFrame");
        long r1 = this.lastFrameTimeNs;
        long r3 = 0;
        if (r1 == 0) goto L11;
        r3 = r7 - r1;
    L11:
        float r2 = r3 / getFrameDurationNs();
        float r4 = this.frameRaw;
        if (isReversed() == false) goto L14;
        r2 = -r2;
    L14:
        float r5 = r4 + r2;
        boolean r6 = !MiscUtils.contains(r5, getMinFrame(), getMaxFrame());
        float r8 = this.frameRaw;
        float r9 = MiscUtils.clamp(r5, getMinFrame(), getMaxFrame());
        this.frameRaw = r9;
        if (this.useCompositionFrameRate == false) goto L17;
        r9 = (float) Math.floor(r9);
    L17:
        this.frame = r9;
        this.lastFrameTimeNs = r7;
        if (this.useCompositionFrameRate == true) goto L20;
    L21:
        notifyUpdate();
    L22:
        if (r6 == true) goto L24;
    L41:
        verifyFrame();
        L.endSection("LottieValueAnimator#doFrame");
        return;
    L24:
        if (getRepeatCount() != (-1)) goto L26;
    L32:
        notifyRepeat();
        this.repeatCount++;
        if (getRepeatMode() != 2) goto L36;
        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
        reverseAnimationSpeed();
    L40:
        this.lastFrameTimeNs = r7;
        goto L41
    L36:
        if (isReversed() == false) goto L38;
        float r10 = getMaxFrame();
    L39:
        this.frameRaw = r10;
        this.frame = r10;
        goto L40
    L38:
        r10 = getMinFrame();
        goto L39
    L26:
        if (this.repeatCount < getRepeatCount()) goto L32;
        if (this.speed >= 0.0f) goto L30;
        float r11 = getMinFrame();
    L31:
        this.frameRaw = r11;
        this.frame = r11;
        removeFrameCallback();
        notifyEnd(isReversed());
        goto L41
    L30:
        r11 = getMaxFrame();
        goto L31
    L20:
        if (this.frameRaw == r8) goto L22;
    }

    private float getFrameDurationNs() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return Float.MAX_VALUE;
    L7:
        return (1.0E9f / r0.getFrameRate()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
    }

    public void setComposition(LottieComposition r3) {
        if (this.composition != null) goto L5;
        boolean r0 = true;
    L6:
        this.composition = r3;
        if (r0 == false) goto L9;
        setMinAndMaxFrames(Math.max(this.minFrame, r3.getStartFrame()), Math.min(this.maxFrame, r3.getEndFrame()));
    L10:
        float r4 = this.frame;
        this.frame = 0.0f;
        this.frameRaw = 0.0f;
        setFrame((int) r4);
        notifyUpdate();
        return;
    L9:
        setMinAndMaxFrames((int) r3.getStartFrame(), (int) r3.getEndFrame());
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setFrame(float r3) {
        if (this.frameRaw != r3) goto L5;
        return;
    L5:
        float r4 = MiscUtils.clamp(r3, getMinFrame(), getMaxFrame());
        this.frameRaw = r4;
        if (this.useCompositionFrameRate == false) goto L8;
        r4 = (float) Math.floor(r4);
    L8:
        this.frame = r4;
        this.lastFrameTimeNs = 0;
        notifyUpdate();
    }

    public void setMinFrame(int r2) {
        setMinAndMaxFrames(r2, (int) this.maxFrame);
    }

    public void setMaxFrame(float r2) {
        setMinAndMaxFrames(this.minFrame, r2);
    }

    public void setMinAndMaxFrames(float r3, float r4) {
        if (r3 > r4) goto L19;
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        float r1 = -3.4028235E38f;
    L8:
        LottieComposition r2 = this.composition;
        if (r2 != null) goto L11;
        float r5 = Float.MAX_VALUE;
    L12:
        float r6 = MiscUtils.clamp(r3, r1, r5);
        float r7 = MiscUtils.clamp(r4, r1, r5);
        if (r6 == this.minFrame) goto L15;
    L16:
        this.minFrame = r6;
        this.maxFrame = r7;
        setFrame((int) MiscUtils.clamp(this.frame, r6, r7));
        return;
    L15:
        if (r7 != this.maxFrame) goto L16;
        return;
    L11:
        r5 = r2.getEndFrame();
        goto L12
    L7:
        r1 = r0.getStartFrame();
        goto L8
    L19:
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(r3), Float.valueOf(r4)}));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float r1) {
        this.speed = r1;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int r2) {
        super.setRepeatMode(r2);
        if (r2 != 2) goto L5;
        return;
    L5:
        if (this.speedReversedForRepeatMode == false) goto L9;
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
        return;
    }

    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        if (isReversed() == false) goto L5;
        float r0 = getMaxFrame();
    L6:
        setFrame((int) r0);
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        postFrameCallback();
        return;
    L5:
        r0 = getMinFrame();
        goto L6
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    public void pauseAnimation() {
        removeFrameCallback();
        notifyPause();
    }

    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0;
        if (isReversed() == false) goto L8;
        if (getFrame() != getMinFrame()) goto L8;
        setFrame(getMaxFrame());
    L12:
        notifyResume();
        return;
    L8:
        if (isReversed() == true) goto L12;
        if (getFrame() != getMaxFrame()) goto L12;
        setFrame(getMinFrame());
        goto L12
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    private boolean isReversed() {
        if (getSpeed() >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public float getMinFrame() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        float r2 = this.minFrame;
        if (r2 == (-2.1474836E9f)) goto L9;
        return r2;
    L9:
        return r0.getStartFrame();
    }

    public float getMaxFrame() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        float r2 = this.maxFrame;
        if (r2 == 2.1474836E9f) goto L9;
        return r2;
    L9:
        return r0.getEndFrame();
    }

    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    void notifyCancel() {
        super.notifyCancel();
        notifyEnd(isReversed());
    }

    protected void postFrameCallback() {
        if (isRunning() == false) goto L6;
        removeFrameCallback(false);
        Choreographer.getInstance().postFrameCallback(this);
        return;
    }

    protected void removeFrameCallback() {
        removeFrameCallback(true);
    }

    protected void removeFrameCallback(boolean r2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (r2 == false) goto L6;
        this.running = false;
        return;
    }

    private void verifyFrame() {
        if (this.composition != null) goto L5;
        return;
    L5:
        float r0 = this.frame;
        if (r0 < this.minFrame) goto L11;
        if (r0 > this.maxFrame) goto L11;
        return;
    L11:
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)}));
    }
}
