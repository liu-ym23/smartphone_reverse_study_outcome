package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo<T> set(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        this.startFrame = f10;
        this.endFrame = f11;
        this.startValue = t10;
        this.endValue = t11;
        this.linearKeyframeProgress = f12;
        this.interpolatedKeyframeProgress = f13;
        this.overallProgress = f14;
        return this;
    }
}
