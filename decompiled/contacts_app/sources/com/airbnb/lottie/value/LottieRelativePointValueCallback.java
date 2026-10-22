package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {
    private final PointF point;

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ PointF getValue(LottieFrameInfo<PointF> r1) {
        return getValue(r1);
    }

    public LottieRelativePointValueCallback() {
        this.point = new PointF();
    }

    public LottieRelativePointValueCallback(PointF r1) {
        super(r1);
        this.point = new PointF();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final PointF getValue(LottieFrameInfo<PointF> r6) {
        this.point.set(MiscUtils.lerp(r6.getStartValue().x, r6.getEndValue().x, r6.getInterpolatedKeyframeProgress()), MiscUtils.lerp(r6.getStartValue().y, r6.getEndValue().y, r6.getInterpolatedKeyframeProgress()));
        PointF r7 = getOffset(r6);
        this.point.offset(r7.x, r7.y);
        return this.point;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF getOffset(LottieFrameInfo<PointF> r1) {
        if (this.value == 0) goto L7;
        return (PointF) this.value;
    L7:
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
