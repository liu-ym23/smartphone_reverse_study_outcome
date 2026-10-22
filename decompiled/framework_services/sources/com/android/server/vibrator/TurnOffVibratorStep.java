package com.android.server.vibrator;

import android.os.SystemClock;
import android.os.Trace;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class TurnOffVibratorStep extends AbstractVibratorStep {
    private final boolean mIsCleanUp;

    TurnOffVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, boolean isCleanUp) {
        super(conductor, startTime, controller, startTime);
        this.mIsCleanUp = isCleanUp;
    }

    @Override // com.android.server.vibrator.Step
    public boolean isCleanUp() {
        return this.mIsCleanUp;
    }

    @Override // com.android.server.vibrator.AbstractVibratorStep, com.android.server.vibrator.Step
    public List<Step> cancel() {
        return Arrays.asList(new Step[]{new TurnOffVibratorStep(this.conductor, SystemClock.uptimeMillis(), this.controller, true)});
    }

    @Override // com.android.server.vibrator.AbstractVibratorStep, com.android.server.vibrator.Step
    public void cancelImmediately() {
        stopVibrating();
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "TurnOffVibratorStep");
        stopVibrating();     // Catch: Throwable -> L6
        List<Step> r0 = VibrationStepConductor.EMPTY_STEP_LIST;     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }
}
