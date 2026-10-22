package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo r1) {
        return super.getValue(r1);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* bridge */ /* synthetic */ Float interpolateValue(Float r1, Float r2, float r3) {
        return interpolateValue2(r1, r2, r3);
    }

    public LottieInterpolatedFloatValue(Float r1, Float r2) {
        super(r1, r2);
    }

    public LottieInterpolatedFloatValue(Float r1, Float r2, Interpolator r3) {
        super(r1, r2, r3);
    }

    /* JADX INFO: renamed from: interpolateValue, reason: avoid collision after fix types in other method */
    Float interpolateValue2(Float r1, Float r2, float r3) {
        return Float.valueOf(MiscUtils.lerp(r1.floatValue(), r2.floatValue(), r3));
    }
}
