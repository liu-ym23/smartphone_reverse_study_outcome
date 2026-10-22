package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.BasicPwleSegment;
import android.os.vibrator.PwleSegment;
import android.os.vibrator.VibrationEffectSegment;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class PwleSegmentsValidator implements VibrationSegmentsValidator {
    PwleSegmentsValidator() {
    }

    @Override // com.android.server.vibrator.VibrationSegmentsValidator
    public boolean hasValidSegments(VibratorInfo info, List<VibrationEffectSegment> segments) {
        boolean hasPwleCapability = info.hasCapability(4096);
        float minFrequency = info.getFrequencyProfile().getMinFrequencyHz();
        float maxFrequency = info.getFrequencyProfile().getMaxFrequencyHz();
        Iterator<VibrationEffectSegment> r3 = segments.iterator();
    L4:
        if (r3.hasNext() == false) goto L23;
        PwleSegment r4 = (VibrationEffectSegment) r3.next();
        if ((r4 instanceof BasicPwleSegment) == false) goto L10;
        if (hasPwleCapability == true) goto L10;
        return false;
    L10:
        if ((r4 instanceof PwleSegment) == false) goto L4;
        PwleSegment pwleSegment = r4;
        if (hasPwleCapability == false) goto L21;
        if (pwleSegment.getStartFrequencyHz() < minFrequency) goto L21;
        if (pwleSegment.getStartFrequencyHz() > maxFrequency) goto L21;
        if (pwleSegment.getEndFrequencyHz() < minFrequency) goto L21;
        if (pwleSegment.getEndFrequencyHz() <= maxFrequency) goto L4;
    L21:
        return false;
    L23:
        return true;
    }
}
