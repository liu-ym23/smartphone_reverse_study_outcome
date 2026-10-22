package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static final LiveRequest.Builder a(LiveRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$addAdaptiveGradingParam");
        AdaptiveGradingConfig r101 = t9.f121279a.getValue();
        return r100.gradingBrightness(r101.getTargetBrightness()).gradingContrast(r101.getTargetContrast()).gradingSaturation(r101.getTargetSaturation()).thresholdBrightness(new float[]{r101.getThresholdStartBrightness(), r101.getThresholdEndBrightness()}).thresholdContrast(new float[]{r101.getThresholdStartContrast(), r101.getThresholdEndContrast()}).thresholdSaturation(new float[]{r101.getThresholdStartSaturation(), r101.getThresholdEndSaturation()}).gradingGopTime(r101.getGopTime());
    }
}
