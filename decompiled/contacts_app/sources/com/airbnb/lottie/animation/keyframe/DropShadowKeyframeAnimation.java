package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private final BaseKeyframeAnimation<Integer, Integer> color;
    private final BaseKeyframeAnimation<Float, Float> direction;
    private final BaseKeyframeAnimation<Float, Float> distance;
    private boolean isDirty;
    private final BaseKeyframeAnimation.AnimationListener listener;
    private final BaseKeyframeAnimation<Float, Float> opacity;
    private final BaseKeyframeAnimation<Float, Float> radius;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener r2, BaseLayer r3, DropShadowEffect r4) {
        this.isDirty = true;
        this.listener = r2;
        BaseKeyframeAnimation<Integer, Integer> r5 = r4.getColor().createAnimation();
        this.color = r5;
        r5.addUpdateListener(this);
        r3.addAnimation(r5);
        BaseKeyframeAnimation<Float, Float> r6 = r4.getOpacity().createAnimation();
        this.opacity = r6;
        r6.addUpdateListener(this);
        r3.addAnimation(r6);
        BaseKeyframeAnimation<Float, Float> r7 = r4.getDirection().createAnimation();
        this.direction = r7;
        r7.addUpdateListener(this);
        r3.addAnimation(r7);
        BaseKeyframeAnimation<Float, Float> r8 = r4.getDistance().createAnimation();
        this.distance = r8;
        r8.addUpdateListener(this);
        r3.addAnimation(r8);
        BaseKeyframeAnimation<Float, Float> r9 = r4.getRadius().createAnimation();
        this.radius = r9;
        r9.addUpdateListener(this);
        r3.addAnimation(r9);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.isDirty = true;
        this.listener.onValueChanged();
    }

    public void applyTo(Paint r7) {
        if (this.isDirty == true) goto L5;
        return;
    L5:
        this.isDirty = false;
        double r0 = ((double) this.direction.getValue().floatValue()) * DEG_TO_RAD;
        float r2 = this.distance.getValue().floatValue();
        float r3 = ((float) Math.sin(r0)) * r2;
        float r1 = ((float) Math.cos(r0 + 3.141592653589793d)) * r2;
        int r4 = this.color.getValue().intValue();
        int r5 = Color.argb(Math.round(this.opacity.getValue().floatValue()), Color.red(r4), Color.green(r4), Color.blue(r4));
        r7.setShadowLayer(this.radius.getValue().floatValue(), r3, r1, r5);
    }

    public void setColorCallback(LottieValueCallback<Integer> r1) {
        this.color.setValueCallback(r1);
    }

    public void setOpacityCallback(final LottieValueCallback<Float> r3) {
        if (r3 != null) goto L5;
        this.opacity.setValueCallback(null);
        return;
    L5:
        this.opacity.setValueCallback(new AnonymousClass1(this, r3));
    }

    public void setDirectionCallback(LottieValueCallback<Float> r1) {
        this.direction.setValueCallback(r1);
    }

    public void setDistanceCallback(LottieValueCallback<Float> r1) {
        this.distance.setValueCallback(r1);
    }

    public void setRadiusCallback(LottieValueCallback<Float> r1) {
        this.radius.setValueCallback(r1);
    }
}
