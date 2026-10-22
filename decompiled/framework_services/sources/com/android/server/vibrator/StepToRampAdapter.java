package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.RampSegment;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class StepToRampAdapter implements VibrationSegmentsAdapter {
    StepToRampAdapter() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (info.hasCapability(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == true) goto L5;
        return repeatIndex;
    L5:
        int segmentCount = segments.size();
        int i = 0;
    L6:
        if (i >= segmentCount) goto L13;
        StepSegment r2 = (VibrationEffectSegment) segments.get(i);
        if (isStep(r2) == false) goto L12;
        if (r2.getFrequencyHz() == 0.0f) goto L12;
        segments.set(i, convertStepToRamp(info, r2));
    L12:
        i = i + 1;
        goto L6
    L13:
        int i2 = 0;
    L14:
        if (i2 >= segmentCount) goto L29;
        if ((segments.get(i2) instanceof RampSegment) == false) goto L27;
        int j = i2 - 1;
    L18:
        if (j < 0) goto L22;
        if (isStep(segments.get(j)) == false) goto L22;
        segments.set(j, convertStepToRamp(info, segments.get(j)));
        j = j - 1;
    L22:
        int j2 = i2 + 1;
    L23:
        if (j2 >= segmentCount) goto L27;
        if (isStep(segments.get(j2)) == false) goto L27;
        segments.set(j2, convertStepToRamp(info, segments.get(j2)));
        j2 = j2 + 1;
    L27:
        i2 = i2 + 1;
        goto L14
    L29:
        return repeatIndex;
    }

    private static RampSegment convertStepToRamp(VibratorInfo info, StepSegment segment) {
        float frequencyHz = fillEmptyFrequency(info, segment.getFrequencyHz());
        return new RampSegment(segment.getAmplitude(), segment.getAmplitude(), frequencyHz, frequencyHz, (int) segment.getDuration());
    }

    private static boolean isStep(VibrationEffectSegment segment) {
        return segment instanceof StepSegment;
    }

    private static float fillEmptyFrequency(VibratorInfo info, float frequencyHz) {
        if (Float.isNaN(info.getResonantFrequencyHz()) == false) goto L6;
        return frequencyHz;
    L6:
        if (frequencyHz != 0.0f) goto L9;
        return info.getResonantFrequencyHz();
    L9:
        return frequencyHz;
    }
}
