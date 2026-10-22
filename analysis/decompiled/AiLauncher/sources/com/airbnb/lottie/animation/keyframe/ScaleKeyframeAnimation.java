package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.scaleXY = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f10) {
        return getValue((Keyframe<ScaleXY>) keyframe, f10);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f10) {
        ScaleXY scaleXY;
        float f11;
        ScaleXY scaleXY2 = keyframe.startValue;
        if (scaleXY2 == null || (scaleXY = keyframe.endValue) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY3 = scaleXY2;
        ScaleXY scaleXY4 = scaleXY;
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != 0) {
            f11 = f10;
            ScaleXY scaleXY5 = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY3, scaleXY4, f11, getLinearCurrentKeyframeProgress(), getProgress());
            if (scaleXY5 != null) {
                return scaleXY5;
            }
        } else {
            f11 = f10;
        }
        this.scaleXY.set(MiscUtils.lerp(scaleXY3.getScaleX(), scaleXY4.getScaleX(), f11), MiscUtils.lerp(scaleXY3.getScaleY(), scaleXY4.getScaleY(), f11));
        return this.scaleXY;
    }
}
