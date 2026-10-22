package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/StrategyAudioTTAPParams;", "", "()V", "effectType", "", "getEffectType", "()Ljava/lang/Integer;", "setEffectType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enableTTAP", "", "getEnableTTAP", "()Ljava/lang/Boolean;", "setEnableTTAP", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableVolumeGain", "getEnableVolumeGain", "setEnableVolumeGain", "volumeLGain", "", "getVolumeLGain", "()Ljava/lang/Float;", "setVolumeLGain", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "volumeRGain", "getVolumeRGain", "setVolumeRGain", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyAudioTTAPParams {

    @SerializedName("effectType")
    private Integer effectType;

    @SerializedName("enableTTAP")
    private Boolean enableTTAP;

    @SerializedName("enableVolumeGain")
    private Boolean enableVolumeGain;

    @SerializedName("volumeLGain")
    private Float volumeLGain;

    @SerializedName("volumeRGain")
    private Float volumeRGain;

    public StrategyAudioTTAPParams() {
        Boolean r100 = Boolean.FALSE;
        this.enableTTAP = r100;
        this.enableVolumeGain = r100;
        this.effectType = 0;
    }

    public final Integer getEffectType() {
        return this.effectType;
    }

    public final Boolean getEnableTTAP() {
        return this.enableTTAP;
    }

    public final Boolean getEnableVolumeGain() {
        return this.enableVolumeGain;
    }

    public final Float getVolumeLGain() {
        return this.volumeLGain;
    }

    public final Float getVolumeRGain() {
        return this.volumeRGain;
    }

    public final void setEffectType(Integer r100) {
        this.effectType = r100;
    }

    public final void setEnableTTAP(Boolean r100) {
        this.enableTTAP = r100;
    }

    public final void setEnableVolumeGain(Boolean r100) {
        this.enableVolumeGain = r100;
    }

    public final void setVolumeLGain(Float r100) {
        this.volumeLGain = r100;
    }

    public final void setVolumeRGain(Float r100) {
        this.volumeRGain = r100;
    }
}
