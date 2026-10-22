package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements TypeEvaluator<Float> {
    public h() {
    }

    @Override // android.animation.TypeEvaluator
    public final Float evaluate(float r100, Float r101, Float r102) {
        float r103 = r101.floatValue();
        return Float.valueOf(r103 + ((r102.floatValue() - r103) * r100));
    }
}
