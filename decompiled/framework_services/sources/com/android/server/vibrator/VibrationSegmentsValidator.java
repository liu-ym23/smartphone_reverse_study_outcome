package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.VibrationEffectSegment;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface VibrationSegmentsValidator {
    boolean hasValidSegments(VibratorInfo r1, List<VibrationEffectSegment> r2);
}
