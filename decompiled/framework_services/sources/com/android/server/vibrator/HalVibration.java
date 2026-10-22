package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.TikTapVibrationEffect;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes3.dex */
final class HalVibration extends Vibration {
    private float mAdaptiveScale;
    private final CountDownLatch mCompletionLatch;
    private volatile CombinedVibration mEffectToPlay;
    public final SparseArray<VibrationEffect> mFallbacks;
    private final CombinedVibration mOriginalEffect;
    private int mScaleLevel;

    HalVibration(VibrationSession.CallerInfo callerInfo, CombinedVibration effect) {
        super(callerInfo);
        this.mFallbacks = new SparseArray();
        this.mCompletionLatch = new CountDownLatch(1);
        this.mOriginalEffect = effect;
        this.mEffectToPlay = effect;
        this.mScaleLevel = 0;
        this.mAdaptiveScale = 1.0f;
    }

    @Override // com.android.server.vibrator.Vibration
    public void end(Vibration.EndInfo endInfo) {
        super.end(endInfo);
        this.mCompletionLatch.countDown();
    }

    public void waitForEnd() throws InterruptedException {
        this.mCompletionLatch.await();
    }

    public VibrationEffect getFallback(int effectId) {
        return this.mFallbacks.get(effectId);
    }

    public void fillFallbacks(IntFunction<VibrationEffect> fallbackProvider) {
        fillFallbacksForEffect(this.mEffectToPlay, fallbackProvider);
    }

    public void scaleEffects(final VibrationScaler scaler) {
        int vibrationUsage = this.callerInfo.attrs.getUsage();
        this.mScaleLevel = scaler.getScaleLevel(vibrationUsage);
        this.mAdaptiveScale = scaler.getAdaptiveHapticsScale(vibrationUsage);
        this.stats.reportAdaptiveScale(this.mAdaptiveScale);
        CombinedVibration r1 = this.mEffectToPlay;
        scaler.getClass();
        CombinedVibration newEffect = r1.transform(new HalVibration$$ExternalSyntheticLambda0(scaler), Integer.valueOf(vibrationUsage));
        if (Objects.equals(this.mEffectToPlay, newEffect) == true) goto L5;
        this.mEffectToPlay = newEffect;
    L5:
        int i = 0;
    L7:
        if (i >= this.mFallbacks.size()) goto L10;
        this.mFallbacks.setValueAt(i, scaler.scale(this.mFallbacks.valueAt(i), vibrationUsage));
        i = i + 1;
        goto L7
    }

    public boolean adaptToDevice(CombinedVibration.VibratorAdapter deviceAdapter) {
        CombinedVibration adaptedEffect = this.mEffectToPlay.adapt(deviceAdapter);
        if (adaptedEffect != null) goto L7;
        return false;
    L7:
        if (this.mEffectToPlay.equals(adaptedEffect) == true) goto L11;
        this.mEffectToPlay = adaptedEffect;
        return true;
    L11:
        return true;
    }

    public CombinedVibration getEffectToPlay() {
        return this.mEffectToPlay;
    }

    @Override // com.android.server.vibrator.Vibration, com.android.server.vibrator.VibrationSession
    public VibrationSession.DebugInfo getDebugInfo() {
        if (Objects.equals(this.mOriginalEffect, this.mEffectToPlay) == false) goto L5;
        CombinedVibration r0 = null;
    L6:
        CombinedVibration originalEffect = r0;
        return new Vibration.DebugInfoImpl(getStatus(), this.callerInfo, VibrationStats.StatsInfo.findVibrationType(this.mEffectToPlay), this.stats, this.mEffectToPlay, originalEffect, this.mScaleLevel, this.mAdaptiveScale);
    L5:
        r0 = this.mOriginalEffect;
        goto L6
    }

    public boolean canPipelineWith(HalVibration vib, SparseArray<VibratorInfo> vibratorInfos, int durationThresholdMs) {
        long effectDuration = this.mEffectToPlay.getDuration();
        if (effectDuration != Long.MAX_VALUE) goto L6;
        return false;
    L6:
        if (this.callerInfo.uid == vib.callerInfo.uid) goto L8;
        return false;
    L8:
        if (this.callerInfo.attrs.isFlagSet(8) == true) goto L10;
        return false;
    L10:
        if (vib.callerInfo.attrs.isFlagSet(8) == false) goto L16;
        return true;
    L16:
        return false;
    }

    private void fillFallbacksForEffect(CombinedVibration effect, IntFunction<VibrationEffect> fallbackProvider) {
        if ((effect instanceof CombinedVibration.Mono) == false) goto L6;
        fillFallbacksForEffect(((CombinedVibration.Mono) effect).getEffect(), fallbackProvider);
        return;
    L6:
        if ((effect instanceof CombinedVibration.Stereo) == false) goto L14;
        SparseArray<VibrationEffect> effects = ((CombinedVibration.Stereo) effect).getEffects();
        int i = 0;
    L9:
        if (i >= effects.size()) goto L23;
        fillFallbacksForEffect(effects.valueAt(i), fallbackProvider);
        i = i + 1;
        goto L9
    L23:
        return;
    L14:
        if ((effect instanceof CombinedVibration.Sequential) == false) goto L22;
        List<CombinedVibration> effects2 = ((CombinedVibration.Sequential) effect).getEffects();
        int i2 = 0;
    L17:
        if (i2 >= effects2.size()) goto L24;
        fillFallbacksForEffect(effects2.get(i2), fallbackProvider);
        i2 = i2 + 1;
        goto L17
    L24:
        return;
    }

    private void fillFallbacksForEffect(VibrationEffect effect, IntFunction<VibrationEffect> fallbackProvider) {
        if ((effect instanceof TikTapVibrationEffect.ExtPrebaked) == false) goto L5;
        return;
    L5:
        if ((effect instanceof TikTapVibrationEffect.Envelope) == false) goto L7;
        return;
    L7:
        if ((effect instanceof TikTapVibrationEffect.PatternHe) == false) goto L10;
        return;
    L10:
        if ((effect instanceof VibrationEffect.Composed) == false) goto L23;
        VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
        int segmentCount = composed.getSegments().size();
        int i = 0;
    L12:
        if (i >= segmentCount) goto L22;
        PrebakedSegment r3 = (VibrationEffectSegment) composed.getSegments().get(i);
        if ((r3 instanceof PrebakedSegment) == false) goto L20;
        PrebakedSegment prebaked = r3;
        if (prebaked.shouldFallback() == false) goto L20;
        VibrationEffect fallback = fallbackProvider.apply(prebaked.getEffectId());
        if (fallback == null) goto L20;
        this.mFallbacks.put(prebaked.getEffectId(), fallback);
    L20:
        i = i + 1;
        goto L12
    L22:
        return;
    }
}
