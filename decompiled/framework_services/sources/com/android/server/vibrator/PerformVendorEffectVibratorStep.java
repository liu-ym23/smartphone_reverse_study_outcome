package com.android.server.vibrator;

import android.os.Trace;
import android.os.VibrationEffect;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class PerformVendorEffectVibratorStep extends AbstractVibratorStep {
    static final long VENDOR_EFFECT_MAX_DURATION_MS = 60000;
    public final VibrationEffect.VendorEffect effect;

    PerformVendorEffectVibratorStep(VibrationStepConductor conductor, long startTime, VibratorController controller, VibrationEffect.VendorEffect effect, long pendingVibratorOffDeadline) {
        super(conductor, Math.max(startTime, pendingVibratorOffDeadline), controller, pendingVibratorOffDeadline);
        this.effect = effect;
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "PerformVendorEffectVibratorStep");
        int stepId = this.conductor.nextVibratorCallbackStepId(getVibratorId());     // Catch: Throwable -> L6
        long vibratorOnResult = Math.min(this.controller.on(this.effect, getVibration().id, stepId), 60000);     // Catch: Throwable -> L6
        handleVibratorOnResult(vibratorOnResult);     // Catch: Throwable -> L6
        getVibration().stats.reportPerformVendorEffect(vibratorOnResult);     // Catch: Throwable -> L6
        List<Step> r3 = List.of(new CompleteEffectVibratorStep(this.conductor, this.startTime, false, this.controller, this.mPendingVibratorOffDeadline));     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return r3;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }
}
