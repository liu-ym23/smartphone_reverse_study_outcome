package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import android.os.vibrator.VibrationEffectSegment;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class DeviceAdapter implements CombinedVibration.VibratorAdapter {
    private static final String TAG = "DeviceAdapter";
    private final int[] mAvailableVibratorIds;
    private final SparseArray<VibratorController> mAvailableVibrators;
    private final List<VibrationSegmentsAdapter> mSegmentAdapters;
    private final List<VibrationSegmentsValidator> mSegmentsValidators;

    DeviceAdapter(VibrationSettings settings, SparseArray<VibratorController> vibrators) {
        this.mSegmentAdapters = Arrays.asList(new VibrationSegmentsAdapter[]{new PrimitiveDelayAdapter(), new RampToStepAdapter(settings.getRampStepDuration()), new StepToRampAdapter(), new RampDownAdapter(settings.getRampDownDuration(), settings.getRampStepDuration()), new SplitSegmentsAdapter(), new ClippingAmplitudeAndFrequencyAdapter(), new BasicToPwleSegmentAdapter(), new SplitPwleSegmentsAdapter()});
        this.mSegmentsValidators = List.of(new PwleSegmentsValidator(), new PrimitiveSegmentsValidator());
        this.mAvailableVibrators = vibrators;
        this.mAvailableVibratorIds = new int[vibrators.size()];
        int i = 0;
    L4:
        if (i >= vibrators.size()) goto L7;
        this.mAvailableVibratorIds[i] = vibrators.keyAt(i);
        i = i + 1;
        goto L4
    }

    SparseArray<VibratorController> getAvailableVibrators() {
        return this.mAvailableVibrators;
    }

    public int[] getAvailableVibratorIds() {
        return this.mAvailableVibratorIds;
    }

    public VibrationEffect adaptToVibrator(int vibratorId, VibrationEffect effect) {
        if ((effect instanceof VibrationEffect.Composed) == false) goto L20;
        VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
        VibratorController controller = this.mAvailableVibrators.get(vibratorId);
        if (controller != null) goto L7;
        return effect;
    L7:
        VibratorInfo info = controller.getVibratorInfo();
        List<VibrationEffectSegment> newSegments = new ArrayList(composed.getSegments());
        int newRepeatIndex = composed.getRepeatIndex();
        int adapterCount = this.mSegmentAdapters.size();
        int i = 0;
    L8:
        if (i >= adapterCount) goto L10;
        newRepeatIndex = this.mSegmentAdapters.get(i).adaptToVibrator(info, newSegments, newRepeatIndex);
        i = i + 1;
        goto L8
    L10:
        int i2 = 0;
    L12:
        if (i2 >= this.mSegmentsValidators.size()) goto L19;
        if (this.mSegmentsValidators.get(i2).hasValidSegments(info, newSegments) == false) goto L15;
        i2 = i2 + 1;
        goto L12
    L15:
        return null;
    L19:
        return new VibrationEffect.Composed(newSegments, newRepeatIndex);
    L20:
        return effect;
    }
}
