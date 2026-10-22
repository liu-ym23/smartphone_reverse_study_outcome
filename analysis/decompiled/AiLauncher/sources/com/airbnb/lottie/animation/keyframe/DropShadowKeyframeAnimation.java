package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Matrix;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {
    private static final float AFTER_EFFECT_SOFTNESS_SCALE_FACTOR = 0.33f;
    private static final float DEG_TO_RAD = 0.017453292f;
    private final BaseKeyframeAnimation<Integer, Integer> color;
    private final FloatKeyframeAnimation direction;
    private final FloatKeyframeAnimation distance;
    private final BaseLayer layer;
    private Matrix layerInvMatrix;
    private final BaseKeyframeAnimation.AnimationListener listener;
    private final FloatKeyframeAnimation opacity;
    private final FloatKeyframeAnimation radius;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.listener = animationListener;
        this.layer = baseLayer;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation = dropShadowEffect.getColor().createAnimation();
        this.color = baseKeyframeAnimationCreateAnimation;
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = dropShadowEffect.getOpacity().createAnimation();
        this.opacity = floatKeyframeAnimationCreateAnimation;
        floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = dropShadowEffect.getDirection().createAnimation();
        this.direction = floatKeyframeAnimationCreateAnimation2;
        floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation2);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation3 = dropShadowEffect.getDistance().createAnimation();
        this.distance = floatKeyframeAnimationCreateAnimation3;
        floatKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation3);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation4 = dropShadowEffect.getRadius().createAnimation();
        this.radius = floatKeyframeAnimationCreateAnimation4;
        floatKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation4);
    }

    public DropShadow evaluate(Matrix matrix, int i10) {
        float floatValue = this.direction.getFloatValue() * DEG_TO_RAD;
        float fFloatValue = this.distance.getValue().floatValue();
        double d10 = floatValue;
        float fSin = ((float) Math.sin(d10)) * fFloatValue;
        float fCos = ((float) Math.cos(d10 + 3.141592653589793d)) * fFloatValue;
        float fFloatValue2 = this.radius.getValue().floatValue();
        int iIntValue = this.color.getValue().intValue();
        DropShadow dropShadow = new DropShadow(fFloatValue2 * AFTER_EFFECT_SOFTNESS_SCALE_FACTOR, fSin, fCos, Color.argb(Math.round((this.opacity.getValue().floatValue() * i10) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        dropShadow.transformBy(matrix);
        if (this.layerInvMatrix == null) {
            this.layerInvMatrix = new Matrix();
        }
        this.layer.transform.getMatrix().invert(this.layerInvMatrix);
        dropShadow.transformBy(this.layerInvMatrix);
        return dropShadow;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.listener.onValueChanged();
    }

    public void setColorCallback(LottieValueCallback<Integer> lottieValueCallback) {
        this.color.setValueCallback(lottieValueCallback);
    }

    public void setDirectionCallback(LottieValueCallback<Float> lottieValueCallback) {
        this.direction.setValueCallback(lottieValueCallback);
    }

    public void setDistanceCallback(LottieValueCallback<Float> lottieValueCallback) {
        this.distance.setValueCallback(lottieValueCallback);
    }

    public void setOpacityCallback(final LottieValueCallback<Float> lottieValueCallback) {
        if (lottieValueCallback == null) {
            this.opacity.setValueCallback(null);
        } else {
            this.opacity.setValueCallback(new LottieValueCallback<Float>() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.airbnb.lottie.value.LottieValueCallback
                public Float getValue(LottieFrameInfo<Float> lottieFrameInfo) {
                    Float f10 = (Float) lottieValueCallback.getValue(lottieFrameInfo);
                    if (f10 == null) {
                        return null;
                    }
                    return Float.valueOf(f10.floatValue() * 2.55f);
                }
            });
        }
    }

    public void setRadiusCallback(LottieValueCallback<Float> lottieValueCallback) {
        this.radius.setValueCallback(lottieValueCallback);
    }
}
