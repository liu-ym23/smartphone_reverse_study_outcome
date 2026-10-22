package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b!\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\"\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/StrategyVolumeBalanceParams3;", "", "()V", "audio_balance_target_luft", "", "getAudio_balance_target_luft", "()Ljava/lang/Float;", "setAudio_balance_target_luft", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "audio_drc_compressor_ratio", "getAudio_drc_compressor_ratio", "setAudio_drc_compressor_ratio", "audio_drc_compressor_threshold", "", "getAudio_drc_compressor_threshold", "()Ljava/lang/Integer;", "setAudio_drc_compressor_threshold", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "audio_gain_smoothingInSeconds", "getAudio_gain_smoothingInSeconds", "setAudio_gain_smoothingInSeconds", "audio_isFixed_drc_compressor_ratio", "getAudio_isFixed_drc_compressor_ratio", "setAudio_isFixed_drc_compressor_ratio", "audio_limiter_makeup_gain", "getAudio_limiter_makeup_gain", "setAudio_limiter_makeup_gain", "audio_lookahead_window", "getAudio_lookahead_window", "setAudio_lookahead_window", "audio_lower_limit_level", "getAudio_lower_limit_level", "setAudio_lower_limit_level", "audio_max_gain", "getAudio_max_gain", "setAudio_max_gain", "audio_meta_smoothing_count", "getAudio_meta_smoothing_count", "setAudio_meta_smoothing_count", "audio_noise_gate_compress_ratio", "getAudio_noise_gate_compress_ratio", "setAudio_noise_gate_compress_ratio", "enable", "getEnable", "setEnable", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyVolumeBalanceParams3 {

    @SerializedName("AudioBalanceTargetLuft")
    private Float audio_balance_target_luft;

    @SerializedName("AudioLoudnessStrategy3DrcCompressorRatio")
    private Float audio_drc_compressor_ratio;

    @SerializedName("AudioLoudnessStrategy3DrcCompressorThreshold")
    private Integer audio_drc_compressor_threshold;

    @SerializedName("AudioLoudnessStrategy3GainSmoothingInSeconds")
    private Float audio_gain_smoothingInSeconds;

    @SerializedName("AudioLoudnessStrategy3IsFixedDrcCompressorRatio")
    private Integer audio_isFixed_drc_compressor_ratio;

    @SerializedName("AudioLoudnessStrategy3LimiterMakeupGain")
    private Float audio_limiter_makeup_gain;

    @SerializedName("AudioLoudnessStrategy3LoudnessLookaheadWindow")
    private Float audio_lookahead_window;

    @SerializedName("AudioLoudnessStrategy3LowerLimitLevel")
    private Float audio_lower_limit_level;

    @SerializedName("AudioLoudnessStrategy3MaxGain")
    private Float audio_max_gain;

    @SerializedName("AudioLoudnessStrategy3MetaSmoothingCount")
    private Integer audio_meta_smoothing_count;

    @SerializedName("AudioLoudnessStrategy3NoiseGateCompressRatio")
    private Float audio_noise_gate_compress_ratio;

    @SerializedName("AudioLoudnessStrategy3ExternalEnable")
    private Integer enable;

    public StrategyVolumeBalanceParams3() {
    }

    public final Float getAudio_balance_target_luft() {
        return this.audio_balance_target_luft;
    }

    public final Float getAudio_drc_compressor_ratio() {
        return this.audio_drc_compressor_ratio;
    }

    public final Integer getAudio_drc_compressor_threshold() {
        return this.audio_drc_compressor_threshold;
    }

    public final Float getAudio_gain_smoothingInSeconds() {
        return this.audio_gain_smoothingInSeconds;
    }

    public final Integer getAudio_isFixed_drc_compressor_ratio() {
        return this.audio_isFixed_drc_compressor_ratio;
    }

    public final Float getAudio_limiter_makeup_gain() {
        return this.audio_limiter_makeup_gain;
    }

    public final Float getAudio_lookahead_window() {
        return this.audio_lookahead_window;
    }

    public final Float getAudio_lower_limit_level() {
        return this.audio_lower_limit_level;
    }

    public final Float getAudio_max_gain() {
        return this.audio_max_gain;
    }

    public final Integer getAudio_meta_smoothing_count() {
        return this.audio_meta_smoothing_count;
    }

    public final Float getAudio_noise_gate_compress_ratio() {
        return this.audio_noise_gate_compress_ratio;
    }

    public final Integer getEnable() {
        return this.enable;
    }

    public final void setAudio_balance_target_luft(Float r100) {
        this.audio_balance_target_luft = r100;
    }

    public final void setAudio_drc_compressor_ratio(Float r100) {
        this.audio_drc_compressor_ratio = r100;
    }

    public final void setAudio_drc_compressor_threshold(Integer r100) {
        this.audio_drc_compressor_threshold = r100;
    }

    public final void setAudio_gain_smoothingInSeconds(Float r100) {
        this.audio_gain_smoothingInSeconds = r100;
    }

    public final void setAudio_isFixed_drc_compressor_ratio(Integer r100) {
        this.audio_isFixed_drc_compressor_ratio = r100;
    }

    public final void setAudio_limiter_makeup_gain(Float r100) {
        this.audio_limiter_makeup_gain = r100;
    }

    public final void setAudio_lookahead_window(Float r100) {
        this.audio_lookahead_window = r100;
    }

    public final void setAudio_lower_limit_level(Float r100) {
        this.audio_lower_limit_level = r100;
    }

    public final void setAudio_max_gain(Float r100) {
        this.audio_max_gain = r100;
    }

    public final void setAudio_meta_smoothing_count(Integer r100) {
        this.audio_meta_smoothing_count = r100;
    }

    public final void setAudio_noise_gate_compress_ratio(Float r100) {
        this.audio_noise_gate_compress_ratio = r100;
    }

    public final void setEnable(Integer r100) {
        this.enable = r100;
    }
}
