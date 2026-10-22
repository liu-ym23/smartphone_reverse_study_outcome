package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;
    private long lastFrameTimeNs = 0;
    private float frameRaw = 0.0f;
    private float frame = 0.0f;
    private int repeatCount = 0;
    private float minFrame = -2.1474836E9f;
    private float maxFrame = 2.1474836E9f;
    protected boolean running = false;
    private boolean useCompositionFrameRate = false;

    private void checkNotifyUpdate(float f10) {
        if (this.useCompositionFrameRate && this.frameRaw == f10) {
            return;
        }
        notifyUpdate();
    }

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f10 = this.frame;
        if (f10 < this.minFrame || f10 > this.maxFrame) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.1474836E9f;
        this.maxFrame = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        postFrameCallback();
        if (this.composition == null || !isRunning()) {
            return;
        }
        if (L.isTraceEnabled()) {
            L.beginSection("LottieValueAnimator#doFrame");
        }
        float frameDurationNs = (this.lastFrameTimeNs != 0 ? j10 - r2 : 0L) / getFrameDurationNs();
        float f10 = this.frameRaw;
        if (isReversed()) {
            frameDurationNs = -frameDurationNs;
        }
        float f11 = f10 + frameDurationNs;
        boolean zContains = MiscUtils.contains(f11, getMinFrame(), getMaxFrame());
        float f12 = this.frameRaw;
        float fClamp = MiscUtils.clamp(f11, getMinFrame(), getMaxFrame());
        this.frameRaw = fClamp;
        if (this.useCompositionFrameRate) {
            fClamp = (float) Math.floor(fClamp);
        }
        this.frame = fClamp;
        this.lastFrameTimeNs = j10;
        if (zContains) {
            checkNotifyUpdate(f12);
        } else if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
            if (getRepeatMode() == 2) {
                this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                reverseAnimationSpeed();
            } else {
                float maxFrame = isReversed() ? getMaxFrame() : getMinFrame();
                this.frameRaw = maxFrame;
                this.frame = maxFrame;
            }
            this.lastFrameTimeNs = j10;
            checkNotifyUpdate(f12);
            notifyRepeat();
            this.repeatCount++;
        } else {
            float minFrame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
            this.frameRaw = minFrame;
            this.frame = minFrame;
            removeFrameCallback();
            checkNotifyUpdate(f12);
            notifyEnd(isReversed());
        }
        verifyFrame();
        if (L.isTraceEnabled()) {
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame = getMaxFrame() - this.frame;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.frame - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.maxFrame;
        return f10 == 2.1474836E9f ? lottieComposition.getEndFrame() : f10;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.minFrame;
        return f10 == -2.1474836E9f ? lottieComposition.getStartFrame() : f10;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public void notifyCancel() {
        super.notifyCancel();
        notifyEnd(isReversed());
    }

    public void pauseAnimation() {
        removeFrameCallback();
        notifyPause();
    }

    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0L;
        if (isReversed() && getFrame() == getMinFrame()) {
            setFrame(getMaxFrame());
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            setFrame(getMinFrame());
        }
        notifyResume();
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z10 = this.composition == null;
        this.composition = lottieComposition;
        if (z10) {
            setMinAndMaxFrames(Math.max(this.minFrame, lottieComposition.getStartFrame()), Math.min(this.maxFrame, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        float f10 = this.frame;
        this.frame = 0.0f;
        this.frameRaw = 0.0f;
        setFrame((int) f10);
        notifyUpdate();
    }

    public void setFrame(float f10) {
        if (this.frameRaw == f10) {
            return;
        }
        float fClamp = MiscUtils.clamp(f10, getMinFrame(), getMaxFrame());
        this.frameRaw = fClamp;
        if (this.useCompositionFrameRate) {
            fClamp = (float) Math.floor(fClamp);
        }
        this.frame = fClamp;
        this.lastFrameTimeNs = 0L;
        notifyUpdate();
    }

    public void setMaxFrame(float f10) {
        setMinAndMaxFrames(this.minFrame, f10);
    }

    public void setMinAndMaxFrames(float f10, float f11) {
        if (f10 > f11) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
        }
        LottieComposition lottieComposition = this.composition;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.composition;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        float fClamp = MiscUtils.clamp(f10, startFrame, endFrame);
        float fClamp2 = MiscUtils.clamp(f11, startFrame, endFrame);
        if (fClamp == this.minFrame && fClamp2 == this.maxFrame) {
            return;
        }
        this.minFrame = fClamp;
        this.maxFrame = fClamp2;
        setFrame((int) MiscUtils.clamp(this.frame, fClamp, fClamp2));
    }

    public void setMinFrame(int i10) {
        setMinAndMaxFrames(i10, (int) this.maxFrame);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 == 2 || !this.speedReversedForRepeatMode) {
            return;
        }
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f10) {
        this.speed = f10;
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.useCompositionFrameRate = z10;
    }

    public void removeFrameCallback(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.running = false;
        }
    }
}
