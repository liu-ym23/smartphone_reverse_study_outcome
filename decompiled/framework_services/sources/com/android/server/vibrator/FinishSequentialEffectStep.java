package com.android.server.vibrator;

import android.os.Trace;
import android.util.Slog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class FinishSequentialEffectStep extends Step {
    public final StartSequentialEffectStep startedStep;

    FinishSequentialEffectStep(StartSequentialEffectStep startedStep) {
        super(startedStep.conductor, Long.MAX_VALUE);
        this.startedStep = startedStep;
    }

    @Override // com.android.server.vibrator.Step
    public boolean isCleanUp() {
        return true;
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "FinishSequentialEffectStep");
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L4:
        if (VibrationThread.DEBUG == false) goto L8;
        Slog.d("VibrationThread", "FinishSequentialEffectStep for effect #" + this.startedStep.currentIndex);     // Catch: Throwable -> L6
    L8:
        this.conductor.vibratorManagerHooks.noteVibratorOff(this.conductor.getVibration().callerInfo.uid);     // Catch: Throwable -> L6
        Step nextStep = this.startedStep.nextStep();     // Catch: Throwable -> L6
        if (nextStep != null) goto L11;
        List<Step> r3 = VibrationStepConductor.EMPTY_STEP_LIST;     // Catch: Throwable -> L6
    L12:
        Trace.traceEnd(8388608);
        return r3;
    L11:
        r3 = Arrays.asList(new Step[]{nextStep});     // Catch: Throwable -> L6
        goto L12
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> cancel() {
        cancelImmediately();
        return VibrationStepConductor.EMPTY_STEP_LIST;
    }

    @Override // com.android.server.vibrator.Step
    public void cancelImmediately() {
        this.conductor.vibratorManagerHooks.noteVibratorOff(this.conductor.getVibration().callerInfo.uid);
    }
}
