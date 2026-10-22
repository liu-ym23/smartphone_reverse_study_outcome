package com.bytedance.android.livesdkapi.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\bH\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010p\u001a\u00020qH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001e\u00104\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u00107\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001e\u0010:\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001e\u0010@\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001a\u0010I\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001e\u0010L\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"R\u001a\u0010O\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001e\u0010R\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001a\u0010U\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001e\u0010X\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\bY\u0010*\"\u0004\bZ\u0010,R\u001a\u0010[\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001e\u0010^\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b_\u0010 \"\u0004\b`\u0010\"R\u001a\u0010a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\u001e\u0010d\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\be\u0010 \"\u0004\bf\u0010\"R\u001a\u0010g\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR\u001a\u0010j\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\bR\u001a\u0010m\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\f\"\u0004\bo\u0010\u000e¨\u0006r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VolumeBalanceParams;", "", "()V", "enableVolumeBalance", "", "getEnableVolumeBalance", "()Z", "setEnableVolumeBalance", "(Z)V", "predelay", "", "getPredelay", "()F", "setPredelay", "(F)V", "predelayEnable", "getPredelayEnable", "setPredelayEnable", "pregain", "getPregain", "setPregain", "pregainEnable", "getPregainEnable", "setPregainEnable", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio", "setRatio", "ratioEnable", "getRatioEnable", "setRatioEnable", "strategy3DrcCompressorRatio", "getStrategy3DrcCompressorRatio", "()Ljava/lang/Float;", "setStrategy3DrcCompressorRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "strategy3DrcCompressorRatioEnable", "getStrategy3DrcCompressorRatioEnable", "setStrategy3DrcCompressorRatioEnable", "strategy3DrcCompressorThreshold", "", "getStrategy3DrcCompressorThreshold", "()Ljava/lang/Integer;", "setStrategy3DrcCompressorThreshold", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "strategy3DrcCompressorThresholdEnable", "getStrategy3DrcCompressorThresholdEnable", "setStrategy3DrcCompressorThresholdEnable", "strategy3Enable", "getStrategy3Enable", "setStrategy3Enable", "strategy3GainSmoothingInSeconds", "getStrategy3GainSmoothingInSeconds", "setStrategy3GainSmoothingInSeconds", "strategy3GainSmoothingInSecondsEnable", "getStrategy3GainSmoothingInSecondsEnable", "setStrategy3GainSmoothingInSecondsEnable", "strategy3IsFixedDrcCompressorRatio", "getStrategy3IsFixedDrcCompressorRatio", "setStrategy3IsFixedDrcCompressorRatio", "strategy3IsFixedDrcCompressorRatioEnable", "getStrategy3IsFixedDrcCompressorRatioEnable", "setStrategy3IsFixedDrcCompressorRatioEnable", "strategy3LimiterMakeupGain", "getStrategy3LimiterMakeupGain", "setStrategy3LimiterMakeupGain", "strategy3LimiterMakeupGainEnable", "getStrategy3LimiterMakeupGainEnable", "setStrategy3LimiterMakeupGainEnable", "strategy3LookaheadWindow", "getStrategy3LookaheadWindow", "setStrategy3LookaheadWindow", "strategy3LookaheadWindowEnable", "getStrategy3LookaheadWindowEnable", "setStrategy3LookaheadWindowEnable", "strategy3LowerLimitLevel", "getStrategy3LowerLimitLevel", "setStrategy3LowerLimitLevel", "strategy3LowerLimitLevelEnable", "getStrategy3LowerLimitLevelEnable", "setStrategy3LowerLimitLevelEnable", "strategy3MaxGain", "getStrategy3MaxGain", "setStrategy3MaxGain", "strategy3MaxGainEnable", "getStrategy3MaxGainEnable", "setStrategy3MaxGainEnable", "strategy3MetaSmoothingCount", "getStrategy3MetaSmoothingCount", "setStrategy3MetaSmoothingCount", "strategy3MetaSmoothingCountEnable", "getStrategy3MetaSmoothingCountEnable", "setStrategy3MetaSmoothingCountEnable", "strategy3NoiseGateCompressRatio", "getStrategy3NoiseGateCompressRatio", "setStrategy3NoiseGateCompressRatio", "strategy3NoiseGateCompressRatioEnable", "getStrategy3NoiseGateCompressRatioEnable", "setStrategy3NoiseGateCompressRatioEnable", "strategy3TargetLuft", "getStrategy3TargetLuft", "setStrategy3TargetLuft", "thresold", "getThresold", "setThresold", "thresoldEnable", "getThresoldEnable", "setThresoldEnable", "volumeTargetLuft", "getVolumeTargetLuft", "setVolumeTargetLuft", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VolumeBalanceParams {
    private boolean enableVolumeBalance;
    private float predelay;
    private boolean predelayEnable;
    private float pregain;
    private boolean pregainEnable;
    private float ratio;
    private boolean ratioEnable;
    private Float strategy3DrcCompressorRatio;
    private boolean strategy3DrcCompressorRatioEnable;
    private Integer strategy3DrcCompressorThreshold;
    private boolean strategy3DrcCompressorThresholdEnable;
    private boolean strategy3Enable;
    private Float strategy3GainSmoothingInSeconds;
    private boolean strategy3GainSmoothingInSecondsEnable;
    private Integer strategy3IsFixedDrcCompressorRatio;
    private boolean strategy3IsFixedDrcCompressorRatioEnable;
    private Float strategy3LimiterMakeupGain;
    private boolean strategy3LimiterMakeupGainEnable;
    private Float strategy3LookaheadWindow;
    private boolean strategy3LookaheadWindowEnable;
    private Float strategy3LowerLimitLevel;
    private boolean strategy3LowerLimitLevelEnable;
    private Float strategy3MaxGain;
    private boolean strategy3MaxGainEnable;
    private Integer strategy3MetaSmoothingCount;
    private boolean strategy3MetaSmoothingCountEnable;
    private Float strategy3NoiseGateCompressRatio;
    private boolean strategy3NoiseGateCompressRatioEnable;
    private Float strategy3TargetLuft;
    private float thresold;
    private boolean thresoldEnable;
    private float volumeTargetLuft;

    public String toString() {
        return "VolumeBalanceParams(pregain=" + this.pregain + ", pregainEnable=" + this.pregainEnable + ", thresold=" + this.thresold + ", thresoldEnable=" + this.thresoldEnable + ", ratio=" + this.ratio + ", ratioEnable=" + this.ratioEnable + ", predelay=" + this.predelay + ", predelayEnable=" + this.predelayEnable + ", enableVolumeBalance=" + this.enableVolumeBalance + ", volumeTargetLuft=" + this.volumeTargetLuft + ", strategy3Enable=" + this.strategy3Enable + ", strategy3TargetLuft=" + this.strategy3TargetLuft + ", strategy3DrcCompressorRatioEnable=" + this.strategy3DrcCompressorRatioEnable + ", strategy3DrcCompressorRatio=" + this.strategy3DrcCompressorRatio + ", strategy3GainSmoothingInSecondsEnable=" + this.strategy3GainSmoothingInSecondsEnable + ", strategy3GainSmoothingInSeconds=" + this.strategy3GainSmoothingInSeconds + ", strategy3IsFixedDrcCompressorRatioEnable=" + this.strategy3IsFixedDrcCompressorRatioEnable + ", strategy3IsFixedDrcCompressorRatio=" + this.strategy3IsFixedDrcCompressorRatio + ", strategy3LimiterMakeupGainEnable=" + this.strategy3LimiterMakeupGainEnable + ", strategy3LimiterMakeupGain=" + this.strategy3LimiterMakeupGain + ", strategy3LowerLimitLevelEnable=" + this.strategy3LowerLimitLevelEnable + ", strategy3LowerLimitLevel=" + this.strategy3LowerLimitLevel + ", strategy3LookaheadWindowEnable=" + this.strategy3LookaheadWindowEnable + ", strategy3LookaheadWindow=" + this.strategy3LookaheadWindow + ", strategy3NoiseGateCompressRatioEnable=" + this.strategy3NoiseGateCompressRatioEnable + ", strategy3NoiseGateCompressRatio=" + this.strategy3NoiseGateCompressRatio + ", strategy3MetaSmoothingCountEnable=" + this.strategy3MetaSmoothingCountEnable + ", strategy3MetaSmoothingCount=" + this.strategy3MetaSmoothingCount + ", strategy3DrcCompressorThresholdEnable=" + this.strategy3DrcCompressorThresholdEnable + ", strategy3DrcCompressorThreshold=" + this.strategy3DrcCompressorThreshold + ", strategy3MaxGainEnable=" + this.strategy3MaxGainEnable + ", strategy3MaxGain=" + this.strategy3MaxGain + ')';
    }

    public VolumeBalanceParams() {
        this.pregain = -100.0f;
        this.thresold = -100.0f;
        this.ratio = -100.0f;
        this.predelay = -100.0f;
        this.enableVolumeBalance = true;
        this.volumeTargetLuft = -100.0f;
    }

    public final boolean getEnableVolumeBalance() {
        return this.enableVolumeBalance;
    }

    public final float getPredelay() {
        return this.predelay;
    }

    public final boolean getPredelayEnable() {
        return this.predelayEnable;
    }

    public final float getPregain() {
        return this.pregain;
    }

    public final boolean getPregainEnable() {
        return this.pregainEnable;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final boolean getRatioEnable() {
        return this.ratioEnable;
    }

    public final Float getStrategy3DrcCompressorRatio() {
        return this.strategy3DrcCompressorRatio;
    }

    public final boolean getStrategy3DrcCompressorRatioEnable() {
        return this.strategy3DrcCompressorRatioEnable;
    }

    public final Integer getStrategy3DrcCompressorThreshold() {
        return this.strategy3DrcCompressorThreshold;
    }

    public final boolean getStrategy3DrcCompressorThresholdEnable() {
        return this.strategy3DrcCompressorThresholdEnable;
    }

    public final boolean getStrategy3Enable() {
        return this.strategy3Enable;
    }

    public final Float getStrategy3GainSmoothingInSeconds() {
        return this.strategy3GainSmoothingInSeconds;
    }

    public final boolean getStrategy3GainSmoothingInSecondsEnable() {
        return this.strategy3GainSmoothingInSecondsEnable;
    }

    public final Integer getStrategy3IsFixedDrcCompressorRatio() {
        return this.strategy3IsFixedDrcCompressorRatio;
    }

    public final boolean getStrategy3IsFixedDrcCompressorRatioEnable() {
        return this.strategy3IsFixedDrcCompressorRatioEnable;
    }

    public final Float getStrategy3LimiterMakeupGain() {
        return this.strategy3LimiterMakeupGain;
    }

    public final boolean getStrategy3LimiterMakeupGainEnable() {
        return this.strategy3LimiterMakeupGainEnable;
    }

    public final Float getStrategy3LookaheadWindow() {
        return this.strategy3LookaheadWindow;
    }

    public final boolean getStrategy3LookaheadWindowEnable() {
        return this.strategy3LookaheadWindowEnable;
    }

    public final Float getStrategy3LowerLimitLevel() {
        return this.strategy3LowerLimitLevel;
    }

    public final boolean getStrategy3LowerLimitLevelEnable() {
        return this.strategy3LowerLimitLevelEnable;
    }

    public final Float getStrategy3MaxGain() {
        return this.strategy3MaxGain;
    }

    public final boolean getStrategy3MaxGainEnable() {
        return this.strategy3MaxGainEnable;
    }

    public final Integer getStrategy3MetaSmoothingCount() {
        return this.strategy3MetaSmoothingCount;
    }

    public final boolean getStrategy3MetaSmoothingCountEnable() {
        return this.strategy3MetaSmoothingCountEnable;
    }

    public final Float getStrategy3NoiseGateCompressRatio() {
        return this.strategy3NoiseGateCompressRatio;
    }

    public final boolean getStrategy3NoiseGateCompressRatioEnable() {
        return this.strategy3NoiseGateCompressRatioEnable;
    }

    public final Float getStrategy3TargetLuft() {
        return this.strategy3TargetLuft;
    }

    public final float getThresold() {
        return this.thresold;
    }

    public final boolean getThresoldEnable() {
        return this.thresoldEnable;
    }

    public final float getVolumeTargetLuft() {
        return this.volumeTargetLuft;
    }

    public final void setEnableVolumeBalance(boolean r100) {
        this.enableVolumeBalance = r100;
    }

    public final void setPredelay(float r100) {
        this.predelay = r100;
    }

    public final void setPredelayEnable(boolean r100) {
        this.predelayEnable = r100;
    }

    public final void setPregain(float r100) {
        this.pregain = r100;
    }

    public final void setPregainEnable(boolean r100) {
        this.pregainEnable = r100;
    }

    public final void setRatio(float r100) {
        this.ratio = r100;
    }

    public final void setRatioEnable(boolean r100) {
        this.ratioEnable = r100;
    }

    public final void setStrategy3DrcCompressorRatio(Float r100) {
        this.strategy3DrcCompressorRatio = r100;
    }

    public final void setStrategy3DrcCompressorRatioEnable(boolean r100) {
        this.strategy3DrcCompressorRatioEnable = r100;
    }

    public final void setStrategy3DrcCompressorThreshold(Integer r100) {
        this.strategy3DrcCompressorThreshold = r100;
    }

    public final void setStrategy3DrcCompressorThresholdEnable(boolean r100) {
        this.strategy3DrcCompressorThresholdEnable = r100;
    }

    public final void setStrategy3Enable(boolean r100) {
        this.strategy3Enable = r100;
    }

    public final void setStrategy3GainSmoothingInSeconds(Float r100) {
        this.strategy3GainSmoothingInSeconds = r100;
    }

    public final void setStrategy3GainSmoothingInSecondsEnable(boolean r100) {
        this.strategy3GainSmoothingInSecondsEnable = r100;
    }

    public final void setStrategy3IsFixedDrcCompressorRatio(Integer r100) {
        this.strategy3IsFixedDrcCompressorRatio = r100;
    }

    public final void setStrategy3IsFixedDrcCompressorRatioEnable(boolean r100) {
        this.strategy3IsFixedDrcCompressorRatioEnable = r100;
    }

    public final void setStrategy3LimiterMakeupGain(Float r100) {
        this.strategy3LimiterMakeupGain = r100;
    }

    public final void setStrategy3LimiterMakeupGainEnable(boolean r100) {
        this.strategy3LimiterMakeupGainEnable = r100;
    }

    public final void setStrategy3LookaheadWindow(Float r100) {
        this.strategy3LookaheadWindow = r100;
    }

    public final void setStrategy3LookaheadWindowEnable(boolean r100) {
        this.strategy3LookaheadWindowEnable = r100;
    }

    public final void setStrategy3LowerLimitLevel(Float r100) {
        this.strategy3LowerLimitLevel = r100;
    }

    public final void setStrategy3LowerLimitLevelEnable(boolean r100) {
        this.strategy3LowerLimitLevelEnable = r100;
    }

    public final void setStrategy3MaxGain(Float r100) {
        this.strategy3MaxGain = r100;
    }

    public final void setStrategy3MaxGainEnable(boolean r100) {
        this.strategy3MaxGainEnable = r100;
    }

    public final void setStrategy3MetaSmoothingCount(Integer r100) {
        this.strategy3MetaSmoothingCount = r100;
    }

    public final void setStrategy3MetaSmoothingCountEnable(boolean r100) {
        this.strategy3MetaSmoothingCountEnable = r100;
    }

    public final void setStrategy3NoiseGateCompressRatio(Float r100) {
        this.strategy3NoiseGateCompressRatio = r100;
    }

    public final void setStrategy3NoiseGateCompressRatioEnable(boolean r100) {
        this.strategy3NoiseGateCompressRatioEnable = r100;
    }

    public final void setStrategy3TargetLuft(Float r100) {
        this.strategy3TargetLuft = r100;
    }

    public final void setThresold(float r100) {
        this.thresold = r100;
    }

    public final void setThresoldEnable(boolean r100) {
        this.thresoldEnable = r100;
    }

    public final void setVolumeTargetLuft(float r100) {
        this.volumeTargetLuft = r100;
    }
}
