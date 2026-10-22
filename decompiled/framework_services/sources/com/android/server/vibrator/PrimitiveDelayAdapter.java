package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.VibrationEffectSegment;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class PrimitiveDelayAdapter implements VibrationSegmentsAdapter {
    PrimitiveDelayAdapter() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsAdapter
    public int adaptToVibrator(VibratorInfo info, List<VibrationEffectSegment> segments, int repeatIndex) {
        int previousStartOffset = 0;
        int segmentCount = segments.size();
        int i = 0;
    L3:
        if (i >= segmentCount) goto L22;
        PrimitiveSegment r3 = (VibrationEffectSegment) segments.get(i);
        if (i != repeatIndex) goto L8;
        previousStartOffset = 0;
    L8:
        if ((r3 instanceof PrimitiveSegment) == false) goto L19;
        PrimitiveSegment primitive = r3;
        if (primitive.getDelayType() == 0) goto L19;
        int pause = calculatePause(primitive, previousStartOffset);
        if (pause < 0) goto L15;
        segments.set(i, toPrimitiveWithPause(primitive, pause));
        previousStartOffset = -calculateEffectDuration(info, primitive);
    L20:
        i = i + 1;
        goto L3
    L15:
        segments.remove(i);
        if (repeatIndex <= i) goto L18;
        repeatIndex = repeatIndex - 1;
    L18:
        segmentCount = segmentCount - 1;
        i = i - 1;
        previousStartOffset = pause;
    L19:
        previousStartOffset = -calculateEffectDuration(info, r3);
        goto L20
    L22:
        return repeatIndex;
    }

    private static int calculatePause(PrimitiveSegment primitive, int previousStartOffset) {
        if (primitive.getDelayType() != 1) goto L7;
        return primitive.getDelay() + previousStartOffset;
    L7:
        return primitive.getDelay();
    }

    private static int calculateEffectDuration(VibratorInfo info, VibrationEffectSegment segment) {
        long segmentDuration = segment.getDuration(info);
        if (segmentDuration >= 0) goto L6;
        return 0;
    L6:
        int effectDuration = (int) segmentDuration;
        if ((segment instanceof PrimitiveSegment) == false) goto L10;
        PrimitiveSegment primitive = (PrimitiveSegment) segment;
        return effectDuration - primitive.getDelay();
    L10:
        return effectDuration;
    }

    private static PrimitiveSegment toPrimitiveWithPause(PrimitiveSegment primitive, int pause) {
        return new PrimitiveSegment(primitive.getPrimitiveId(), primitive.getScale(), pause, 0);
    }
}
