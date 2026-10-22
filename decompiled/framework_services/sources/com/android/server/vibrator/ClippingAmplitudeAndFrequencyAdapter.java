package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.RampSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.MathUtils;
import android.util.Range;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ClippingAmplitudeAndFrequencyAdapter implements VibrationSegmentsAdapter {
    ClippingAmplitudeAndFrequencyAdapter() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        int segmentCount = segments.size();
        int i = 0;
    L3:
        if (i >= segmentCount) goto L9;
        VibrationEffectSegment segment = segments.get(i);
        if ((segment instanceof RampSegment) == false) goto L7;
        segments.set(i, adaptToVibrator(info, (RampSegment) segment));
    L7:
        i = i + 1;
        goto L3
    L9:
        return repeatIndex;
    }

    private RampSegment adaptToVibrator(VibratorInfo info, RampSegment segment) {
        float clampedStartFrequency = clampFrequency(info, segment.getStartFrequencyHz());
        float clampedEndFrequency = clampFrequency(info, segment.getEndFrequencyHz());
        return new RampSegment(clampAmplitude(info, clampedStartFrequency, segment.getStartAmplitude()), clampAmplitude(info, clampedEndFrequency, segment.getEndAmplitude()), clampedStartFrequency, clampedEndFrequency, (int) segment.getDuration());
    }

    private float clampFrequency(VibratorInfo info, float frequencyHz) {
        Range<Float> frequencyRangeHz = info.getFrequencyProfileLegacy().getFrequencyRangeHz();
        if (frequencyHz == 0.0f) goto L9;
        if (frequencyRangeHz == null) goto L9;
        return ((Float) frequencyRangeHz.clamp(Float.valueOf(frequencyHz))).floatValue();
    L9:
        if (Float.isNaN(info.getResonantFrequencyHz()) == false) goto L12;
        return 0.0f;
    L12:
        return info.getResonantFrequencyHz();
    }

    private float clampAmplitude(VibratorInfo info, float frequencyHz, float amplitude) {
        VibratorInfo.FrequencyProfileLegacy mapping = info.getFrequencyProfileLegacy();
        if (mapping.isEmpty() == false) goto L6;
        return amplitude;
    L6:
        return MathUtils.min(amplitude, mapping.getMaxAmplitude(frequencyHz));
    }
}
