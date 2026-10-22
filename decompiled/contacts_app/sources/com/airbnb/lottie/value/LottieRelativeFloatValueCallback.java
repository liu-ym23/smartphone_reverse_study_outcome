package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Float getValue(LottieFrameInfo<Float> r1) {
        return getValue(r1);
    }

    public LottieRelativeFloatValueCallback() {
    }

    public LottieRelativeFloatValueCallback(Float r1) {
        super(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Float getValue(LottieFrameInfo<Float> r4) {
        return Float.valueOf(MiscUtils.lerp(r4.getStartValue().floatValue(), r4.getEndValue().floatValue(), r4.getInterpolatedKeyframeProgress()) + getOffset(r4).floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float getOffset(LottieFrameInfo<Float> r1) {
        if (this.value == 0) goto L7;
        return (Float) this.value;
    L7:
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
