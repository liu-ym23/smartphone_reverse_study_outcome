package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point;
    private final PointF pointWithCallbackValues;
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    protected LottieValueCallback<Float> xValueCallback;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;
    protected LottieValueCallback<Float> yValueCallback;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ PointF getValue() {
        return getValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ PointF getValue(Keyframe<PointF> r1, float r2) {
        return getValue(r1, r2);
    }

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> r2, BaseKeyframeAnimation<Float, Float> r3) {
        super(Collections.emptyList());
        this.point = new PointF();
        this.pointWithCallbackValues = new PointF();
        this.xAnimation = r2;
        this.yAnimation = r3;
        setProgress(getProgress());
    }

    public void setXValueCallback(LottieValueCallback<Float> r3) {
        LottieValueCallback<Float> r0 = this.xValueCallback;
        if (r0 == null) goto L5;
        r0.setAnimation(null);
    L5:
        this.xValueCallback = r3;
        if (r3 == null) goto L9;
        r3.setAnimation(this);
        return;
    }

    public void setYValueCallback(LottieValueCallback<Float> r3) {
        LottieValueCallback<Float> r0 = this.yValueCallback;
        if (r0 == null) goto L5;
        r0.setAnimation(null);
    L5:
        this.yValueCallback = r3;
        if (r3 == null) goto L9;
        r3.setAnimation(this);
        return;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float r3) {
        this.xAnimation.setProgress(r3);
        this.yAnimation.setProgress(r3);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        int r4 = 0;
    L4:
        if (r4 >= this.listeners.size()) goto L6;
        this.listeners.get(r4).onValueChanged();
        r4 = r4 + 1;
        goto L4
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        return getValue(null, 0.0f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    PointF getValue(Keyframe<PointF> r11, float r12) {
        Float r0 = null;
        if (this.xValueCallback == null) goto L11;
        Keyframe<Float> r13 = this.xAnimation.getCurrentKeyframe();
        if (r13 == null) goto L11;
        float r9 = this.xAnimation.getInterpolatedCurrentKeyframeProgress();
        Float r1 = r13.endFrame;
        LottieValueCallback<Float> r2 = this.xValueCallback;
        float r3 = r13.startFrame;
        if (r1 != null) goto L9;
        float r4 = r13.startFrame;
    L10:
        Float r14 = r2.getValueInternal(r3, r4, r13.startValue, r13.endValue, r12, r12, r9);
    L13:
        if (this.yValueCallback == null) goto L22;
        Keyframe<Float> r5 = this.yAnimation.getCurrentKeyframe();
        if (r5 == null) goto L22;
        float r10 = this.yAnimation.getInterpolatedCurrentKeyframeProgress();
        Float r6 = r5.endFrame;
        LottieValueCallback<Float> r7 = this.yValueCallback;
        float r8 = r5.startFrame;
        if (r6 != null) goto L19;
        float r15 = r5.startFrame;
    L20:
        r0 = r7.getValueInternal(r8, r15, r5.startValue, r5.endValue, r12, r12, r10);
        goto L22
    L19:
        r15 = r6.floatValue();
    L22:
        if (r14 != null) goto L24;
        this.pointWithCallbackValues.set(this.point.x, 0.0f);
    L25:
        if (r0 != null) goto L27;
        PointF r16 = this.pointWithCallbackValues;
        r16.set(r16.x, this.point.y);
    L29:
        return this.pointWithCallbackValues;
    L27:
        PointF r17 = this.pointWithCallbackValues;
        r17.set(r17.x, r0.floatValue());
        goto L29
    L24:
        this.pointWithCallbackValues.set(r14.floatValue(), 0.0f);
        goto L25
    L9:
        r4 = r1.floatValue();
    L11:
        r14 = null;
        goto L13
    }
}
