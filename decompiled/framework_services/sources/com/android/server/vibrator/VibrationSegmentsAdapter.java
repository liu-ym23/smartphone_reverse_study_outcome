package com.android.server.vibrator;

import android.os.VibratorInfo;
import android.os.vibrator.VibrationEffectSegment;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
interface VibrationSegmentsAdapter {
    int adaptToVibrator(VibratorInfo r1, List<VibrationEffectSegment> r2, int r3);
}
