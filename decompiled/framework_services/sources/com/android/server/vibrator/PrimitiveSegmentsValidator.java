package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.VibrationEffectSegment;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class PrimitiveSegmentsValidator implements VibrationSegmentsValidator {
    PrimitiveSegmentsValidator() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsValidator
    public boolean hasValidSegments(VibratorInfo info, List<VibrationEffectSegment> segments) {
        int segmentCount = segments.size();
        int i = 0;
    L3:
        if (i >= segmentCount) goto L11;
        PrimitiveSegment r2 = segments.get(i);
        if ((r2 instanceof PrimitiveSegment) == false) goto L10;
        PrimitiveSegment primitive = r2;
        if (info.isPrimitiveSupported(primitive.getPrimitiveId()) == true) goto L10;
        return false;
    L10:
        i = i + 1;
        goto L3
    L11:
        return true;
    }
}
