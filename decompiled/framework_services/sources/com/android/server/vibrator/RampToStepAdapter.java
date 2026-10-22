package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.RampSegment;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.MathUtils;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class RampToStepAdapter implements VibrationSegmentsAdapter {
    private final int mStepDuration;

    RampToStepAdapter(int stepDuration) {
        this.mStepDuration = stepDuration;
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (info.hasCapability(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == false) goto L5;
        return repeatIndex;
    L5:
        int segmentCount = segments.size();
        int i = 0;
    L6:
        if (i >= segmentCount) goto L16;
        VibrationEffectSegment segment = segments.get(i);
        if ((segment instanceof RampSegment) == false) goto L14;
        List<StepSegment> steps = convertRampToSteps(info, (RampSegment) segment);
        segments.remove(i);
        segments.addAll(i, steps);
        int addedSegments = steps.size() - 1;
        if (repeatIndex <= i) goto L13;
        repeatIndex = repeatIndex + addedSegments;
    L13:
        i = i + addedSegments;
        segmentCount = segmentCount + addedSegments;
    L14:
        i = i + 1;
        goto L6
    L16:
        return repeatIndex;
    }

    private List<StepSegment> convertRampToSteps(VibratorInfo info, RampSegment ramp) {
        if (Float.compare(ramp.getStartAmplitude(), ramp.getEndAmplitude()) == 0) goto L5;
        List<StepSegment> steps = new ArrayList();
        int stepCount = ((int) ((ramp.getDuration() + ((long) this.mStepDuration)) - 1)) / this.mStepDuration;
        int i = 0;
    L8:
        if (i >= (stepCount - 1)) goto L10;
        float pos = i / stepCount;
        float startFrequencyHz = fillEmptyFrequency(info, ramp.getStartFrequencyHz());
        float endFrequencyHz = fillEmptyFrequency(info, ramp.getEndFrequencyHz());
        steps.add(new StepSegment(MathUtils.lerp(ramp.getStartAmplitude(), ramp.getEndAmplitude(), pos), MathUtils.lerp(startFrequencyHz, endFrequencyHz, pos), this.mStepDuration));
        i = i + 1;
        goto L8
    L10:
        int duration = ((int) ramp.getDuration()) - (this.mStepDuration * (stepCount - 1));
        float endFrequencyHz2 = fillEmptyFrequency(info, ramp.getEndFrequencyHz());
        steps.add(new StepSegment(ramp.getEndAmplitude(), endFrequencyHz2, duration));
        return steps;
    L5:
        return Arrays.asList(new StepSegment[]{new StepSegment(ramp.getStartAmplitude(), fillEmptyFrequency(info, ramp.getStartFrequencyHz()), (int) ramp.getDuration())});
    }

    private static float fillEmptyFrequency(VibratorInfo info, float frequencyHz) {
        if (Float.isNaN(info.getResonantFrequencyHz()) == false) goto L6;
        return 0.0f;
    L6:
        if (frequencyHz != 0.0f) goto L9;
        return info.getResonantFrequencyHz();
    L9:
        return frequencyHz;
    }
}
