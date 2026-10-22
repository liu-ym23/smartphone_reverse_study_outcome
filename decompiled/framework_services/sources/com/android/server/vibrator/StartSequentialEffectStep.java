package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.SystemClock;
import android.os.Trace;
import android.os.VibrationEffect;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.Slog;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class StartSequentialEffectStep extends Step {
    public final int currentIndex;
    private long mVibratorsOnMaxDuration;
    public final CombinedVibration.Sequential sequentialEffect;

    final class DeviceEffectMap {
        private final long mRequiredSyncCapabilities;
        private final SparseArray<VibrationEffect> mVibratorEffects;
        private final int[] mVibratorIds;

        DeviceEffectMap(StartSequentialEffectStep this$0, CombinedVibration.Mono mono) {
            SparseArray<VibratorController> vibrators = this$0.conductor.getVibrators();
            VibrationEffect effect = mono.getEffect();
            this.mVibratorEffects = new SparseArray(vibrators.size());
            this.mVibratorIds = new int[vibrators.size()];
            int i = 0;
        L4:
            if (i >= vibrators.size()) goto L6;
            int vibratorId = vibrators.keyAt(i);
            this.mVibratorEffects.put(vibratorId, effect);
            this.mVibratorIds[i] = vibratorId;
            i = i + 1;
            goto L4
        L6:
            this.mRequiredSyncCapabilities = calculateRequiredSyncCapabilities(this.mVibratorEffects);
        }

        DeviceEffectMap(StartSequentialEffectStep this$0, CombinedVibration.Stereo stereo) {
            SparseArray<VibratorController> vibrators = this$0.conductor.getVibrators();
            SparseArray<VibrationEffect> stereoEffects = stereo.getEffects();
            this.mVibratorEffects = new SparseArray();
            int i = 0;
        L4:
            if (i >= stereoEffects.size()) goto L9;
            int vibratorId = stereoEffects.keyAt(i);
            if (vibrators.contains(vibratorId) == false) goto L8;
            this.mVibratorEffects.put(vibratorId, stereoEffects.valueAt(i));
        L8:
            i = i + 1;
            goto L4
        L9:
            this.mVibratorIds = new int[this.mVibratorEffects.size()];
            int i2 = 0;
        L11:
            if (i2 >= this.mVibratorEffects.size()) goto L13;
            this.mVibratorIds[i2] = this.mVibratorEffects.keyAt(i2);
            i2 = i2 + 1;
            goto L11
        L13:
            this.mRequiredSyncCapabilities = calculateRequiredSyncCapabilities(this.mVibratorEffects);
        }

        public int size() {
            return this.mVibratorIds.length;
        }

        public long getRequiredSyncCapabilities() {
            return this.mRequiredSyncCapabilities;
        }

        public int[] getVibratorIds() {
            return this.mVibratorIds;
        }

        public int vibratorIdAt(int index) {
            return this.mVibratorEffects.keyAt(index);
        }

        public VibrationEffect effectAt(int index) {
            return this.mVibratorEffects.valueAt(index);
        }

        private long calculateRequiredSyncCapabilities(SparseArray<VibrationEffect> effects) {
            long prepareCap = 0;
            int i = 0;
        L4:
            if (i >= effects.size()) goto L22;
            VibrationEffect.Composed r3 = (VibrationEffect) effects.valueAt(i);
            if ((r3 instanceof VibrationEffect.VendorEffect) == false) goto L9;
            prepareCap = prepareCap | 4;
        L21:
            i = i + 1;
            goto L4
        L9:
            if ((r3 instanceof VibrationEffect.Composed) == false) goto L20;
            VibrationEffect.Composed composed = r3;
            VibrationEffectSegment firstSegment = (VibrationEffectSegment) composed.getSegments().get(0);
            if ((firstSegment instanceof StepSegment) == false) goto L14;
            prepareCap = prepareCap | 2;
            goto L21
        L14:
            if ((firstSegment instanceof PrebakedSegment) == false) goto L17;
            prepareCap = prepareCap | 4;
            goto L21
        L17:
            if ((firstSegment instanceof PrimitiveSegment) == false) goto L21;
            prepareCap = prepareCap | 8;
            goto L21
        L20:
            Slog.wtf("VibrationThread", "Unable to check sync capabilities to unexpected effect: " + r3);
            goto L21
        L22:
            int triggerCap = 0;
            if (requireMixedTriggerCapability(prepareCap, 2) == false) goto L26;
            triggerCap = 0 | 16;
        L26:
            if (requireMixedTriggerCapability(prepareCap, 4) == false) goto L29;
            triggerCap = triggerCap | 32;
        L29:
            if (requireMixedTriggerCapability(prepareCap, 8) == false) goto L32;
            triggerCap = triggerCap | 64;
        L32:
            return (1 | prepareCap) | ((long) triggerCap);
        }

        private boolean requireMixedTriggerCapability(long prepareCapabilities, long capability) {
            if ((prepareCapabilities & capability) != 0) goto L5;
        L7:
            return false;
        L5:
            if (((~capability) & prepareCapabilities) == 0) goto L7;
            return true;
        }
    }

    StartSequentialEffectStep(VibrationStepConductor conductor, CombinedVibration.Sequential effect) {
        this(conductor, SystemClock.uptimeMillis() + ((long) ((Integer) effect.getDelays().get(0)).intValue()), effect, 0);
    }

    private StartSequentialEffectStep(VibrationStepConductor conductor, long startTime, CombinedVibration.Sequential effect, int index) {
        super(conductor, startTime);
        this.sequentialEffect = effect;
        this.currentIndex = index;
    }

    @Override // com.android.server.vibrator.Step
    public long getVibratorOnDuration() {
        return this.mVibratorsOnMaxDuration;
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> play() {
        Trace.traceBegin(8388608, "StartSequentialEffectStep");
        List<Step> nextSteps = new ArrayList();
        this.mVibratorsOnMaxDuration = -1;
    L6:
        th = move-exception;
        if (this.mVibratorsOnMaxDuration >= 0) goto L36;
    L42:
        Trace.traceEnd(8388608);
        throw th;
    L36:
        if (this.mVibratorsOnMaxDuration <= 0) goto L38;
        Step nextStep = new FinishSequentialEffectStep(this);
    L40:
        if (nextStep == null) goto L42;
        nextSteps.add(nextStep);
        goto L42
    L38:
        nextStep = nextStep();
        goto L40
    L4:
        if (VibrationThread.DEBUG == false) goto L8;
        Slog.d("VibrationThread", "StartSequentialEffectStep for effect #" + this.currentIndex);     // Catch: Throwable -> L6
    L8:
        CombinedVibration effect = (CombinedVibration) this.sequentialEffect.getEffects().get(this.currentIndex);     // Catch: Throwable -> L6
        DeviceEffectMap effectMapping = createEffectToVibratorMapping(effect);     // Catch: Throwable -> L6
        if (effectMapping == null) goto L11;
        this.mVibratorsOnMaxDuration = startVibrating(effectMapping, nextSteps);     // Catch: Throwable -> L6
        this.conductor.vibratorManagerHooks.noteVibratorOn(this.conductor.getVibration().callerInfo.uid, this.mVibratorsOnMaxDuration);     // Catch: Throwable -> L6
        if (this.mVibratorsOnMaxDuration >= 0) goto L25;
    L31:
        Trace.traceEnd(8388608);
        return nextSteps;
    L25:
        if (this.mVibratorsOnMaxDuration <= 0) goto L27;
        Step nextStep2 = new FinishSequentialEffectStep(this);
    L29:
        if (nextStep2 == null) goto L31;
        nextSteps.add(nextStep2);
        goto L31
    L27:
        nextStep2 = nextStep();
        goto L29
    L11:
        if (this.mVibratorsOnMaxDuration >= 0) goto L13;
    L19:
        Trace.traceEnd(8388608);
        return nextSteps;
    L13:
        if (this.mVibratorsOnMaxDuration <= 0) goto L15;
        Step nextStep3 = new FinishSequentialEffectStep(this);
    L17:
        if (nextStep3 == null) goto L19;
        nextSteps.add(nextStep3);
        goto L19
    L15:
        nextStep3 = nextStep();
        goto L17
    }

    @Override // com.android.server.vibrator.Step
    public List<Step> cancel() {
        return VibrationStepConductor.EMPTY_STEP_LIST;
    }

    @Override // com.android.server.vibrator.Step
    public void cancelImmediately() {
    }

    Step nextStep() {
        int nextIndex = this.currentIndex + 1;
        if (nextIndex < this.sequentialEffect.getEffects().size()) goto L6;
        return null;
    L6:
        long nextEffectDelay = ((Integer) this.sequentialEffect.getDelays().get(nextIndex)).intValue();
        long nextStartTime = SystemClock.uptimeMillis() + nextEffectDelay;
        return new StartSequentialEffectStep(this.conductor, nextStartTime, this.sequentialEffect, nextIndex);
    }

    private DeviceEffectMap createEffectToVibratorMapping(CombinedVibration effect) {
        if ((effect instanceof CombinedVibration.Mono) == false) goto L7;
        return new DeviceEffectMap(this, (CombinedVibration.Mono) effect);
    L7:
        if ((effect instanceof CombinedVibration.Stereo) == true) goto L9;
        return null;
    L9:
        return new DeviceEffectMap(this, (CombinedVibration.Stereo) effect);
    }

    private long startVibrating(DeviceEffectMap effectMapping, List<Step> nextSteps) {
        int vibratorCount = effectMapping.size();
        if (vibratorCount != 0) goto L5;
        return 0;
    L5:
        AbstractVibratorStep[] steps = new AbstractVibratorStep[vibratorCount];
        long vibrationStartTime = SystemClock.uptimeMillis();
        int i = 0;
    L6:
        if (i >= vibratorCount) goto L8;
        steps[i] = this.conductor.nextVibrateStep(vibrationStartTime, this.conductor.getVibrators().get(effectMapping.vibratorIdAt(i)), effectMapping.effectAt(i));
        i = i + 1;
        goto L6
    L8:
        int i2 = steps.length;
        if (i2 == 1) goto L11;
        boolean hasTriggered = false;
        boolean hasFailed = false;
        long maxDuration = 0;
        boolean hasPrepared = this.conductor.vibratorManagerHooks.prepareSyncedVibration(effectMapping.getRequiredSyncCapabilities(), effectMapping.getVibratorIds());
        int i3 = 0;
    L13:
        if (i3 >= vibratorCount) goto L18;
        long duration = startVibrating(steps[i3], effectMapping.effectAt(i3), nextSteps);
        if (duration < 0) goto L16;
        maxDuration = Math.max(maxDuration, duration);
        i3 = i3 + 1;
        goto L13
    L16:
        hasFailed = true;
    L18:
        if (hasPrepared == false) goto L23;
        if (hasFailed == true) goto L23;
        if (maxDuration <= 0) goto L23;
        hasTriggered = this.conductor.vibratorManagerHooks.triggerSyncedVibration(getVibration().id);
        hasFailed = hasFailed & hasTriggered;
    L23:
        if (hasFailed == false) goto L27;
        int i4 = nextSteps.size() - 1;
    L25:
        if (i4 < 0) goto L27;
        nextSteps.remove(i4).cancelImmediately();
        i4 = i4 - 1;
    L27:
        if (hasPrepared == false) goto L30;
        if (hasTriggered == true) goto L30;
        this.conductor.vibratorManagerHooks.cancelSyncedVibration();
    L30:
        if (hasFailed == false) goto L33;
        return -1;
    L33:
        return maxDuration;
    L11:
        return startVibrating(steps[0], effectMapping.effectAt(0), nextSteps);
    }

    private long startVibrating(AbstractVibratorStep step, VibrationEffect effect, List<Step> nextSteps) {
        if (step != null) goto L5;
        return -1;
    L5:
        nextSteps.addAll(step.play());
        long stepDuration = step.getVibratorOnDuration();
        if (stepDuration >= 0) goto L9;
        return stepDuration;
    L9:
        return Math.max(stepDuration, effect.getDuration());
    }
}
