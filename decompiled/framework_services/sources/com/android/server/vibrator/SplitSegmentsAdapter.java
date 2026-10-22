package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.RampSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.MathUtils;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SplitSegmentsAdapter implements VibrationSegmentsAdapter {
    SplitSegmentsAdapter() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        if (info.hasCapability(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == true) goto L5;
        return repeatIndex;
    L5:
        int maxRampDuration = info.getPwlePrimitiveDurationMax();
        if (maxRampDuration > 0) goto L8;
        return repeatIndex;
    L8:
        int segmentCount = segments.size();
        int i = 0;
    L9:
        if (i >= segmentCount) goto L22;
        if ((segments.get(i) instanceof RampSegment) == false) goto L20;
        RampSegment ramp = segments.get(i);
        int splits = ((((int) ramp.getDuration()) + maxRampDuration) - 1) / maxRampDuration;
        if (splits <= 1) goto L20;
        segments.remove(i);
        segments.addAll(i, splitRampSegment(info, ramp, splits));
        int addedSegments = splits - 1;
        if (repeatIndex <= i) goto L19;
        repeatIndex = repeatIndex + addedSegments;
    L19:
        i = i + addedSegments;
        segmentCount = segmentCount + addedSegments;
    L20:
        i = i + 1;
        goto L9
    L22:
        return repeatIndex;
    }

    private static List<RampSegment> splitRampSegment(VibratorInfo info, RampSegment ramp, int splits) {
        int r1 = splits;
        List<RampSegment> ramps = new ArrayList(r1);
        float startFrequencyHz = fillEmptyFrequency(info, ramp.getStartFrequencyHz());
        float endFrequencyHz = fillEmptyFrequency(info, ramp.getEndFrequencyHz());
        long splitDuration = ramp.getDuration() / ((long) r1);
        float previousAmplitude = ramp.getStartAmplitude();
        int i = 1;
        float previousAmplitude2 = previousAmplitude;
        float previousFrequencyHz = startFrequencyHz;
        long accumulatedDuration = 0;
    L3:
        if (i >= r1) goto L5;
        long accumulatedDuration2 = accumulatedDuration + splitDuration;
        float durationRatio = accumulatedDuration2 / ramp.getDuration();
        float interpolatedFrequency = MathUtils.lerp(startFrequencyHz, endFrequencyHz, durationRatio);
        float interpolatedAmplitude = MathUtils.lerp(ramp.getStartAmplitude(), ramp.getEndAmplitude(), durationRatio);
        RampSegment rampSplit = new RampSegment(previousAmplitude2, interpolatedAmplitude, previousFrequencyHz, interpolatedFrequency, (int) splitDuration);
        ramps.add(rampSplit);
        previousAmplitude2 = rampSplit.getEndAmplitude();
        previousFrequencyHz = rampSplit.getEndFrequencyHz();
        i = i + 1;
        r1 = splits;
        accumulatedDuration = accumulatedDuration2;
        goto L3
    L5:
        ramps.add(new RampSegment(previousAmplitude2, ramp.getEndAmplitude(), previousFrequencyHz, endFrequencyHz, (int) (ramp.getDuration() - accumulatedDuration)));
        return ramps;
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
