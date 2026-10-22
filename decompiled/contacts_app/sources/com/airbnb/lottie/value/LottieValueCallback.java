package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* JADX INFO: loaded from: classes.dex */
public class LottieValueCallback<T> {
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo;
    protected T value;

    public LottieValueCallback() {
        this.frameInfo = new LottieFrameInfo();
        this.value = null;
    }

    public LottieValueCallback(T r2) {
        this.frameInfo = new LottieFrameInfo();
        this.value = r2;
    }

    public T getValue(LottieFrameInfo<T> r1) {
        return this.value;
    }

    public final void setValue(T r1) {
        this.value = r1;
        BaseKeyframeAnimation<?, ?> r0 = this.animation;
        if (r0 == null) goto L6;
        r0.notifyListeners();
        return;
    }

    public final T getValueInternal(float r9, float r10, T r11, T r12, float r13, float r14, float r15) {
        return getValue(this.frameInfo.set(r9, r10, r11, r12, r13, r14, r15));
    }

    public final void setAnimation(BaseKeyframeAnimation<?, ?> r1) {
        this.animation = r1;
    }
}
