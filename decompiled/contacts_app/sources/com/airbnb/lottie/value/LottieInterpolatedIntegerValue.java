package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo r1) {
        return super.getValue(r1);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* bridge */ /* synthetic */ Integer interpolateValue(Integer r1, Integer r2, float r3) {
        return interpolateValue2(r1, r2, r3);
    }

    public LottieInterpolatedIntegerValue(Integer r1, Integer r2) {
        super(r1, r2);
    }

    public LottieInterpolatedIntegerValue(Integer r1, Integer r2, Interpolator r3) {
        super(r1, r2, r3);
    }

    /* JADX INFO: renamed from: interpolateValue, reason: avoid collision after fix types in other method */
    Integer interpolateValue2(Integer r1, Integer r2, float r3) {
        return Integer.valueOf(MiscUtils.lerp(r1.intValue(), r2.intValue(), r3));
    }
}
