package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/StrategyAudioChannelExpandParams;", "", "()V", "audioPosition", "", "getAudioPosition", "()Ljava/lang/Integer;", "setAudioPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "calculateTime", "", "getCalculateTime", "()Ljava/lang/Float;", "setCalculateTime", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "enableAudioExpand", "", "getEnableAudioExpand", "()Ljava/lang/Boolean;", "setEnableAudioExpand", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isLeftRmsBigger", "setLeftRmsBigger", "mixRatio", "getMixRatio", "setMixRatio", "openAnalyzeAudioFrame", "getOpenAnalyzeAudioFrame", "setOpenAnalyzeAudioFrame", "processType", "getProcessType", "setProcessType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyAudioChannelExpandParams {

    @SerializedName("audioPosition")
    private Integer audioPosition;

    @SerializedName("calculateTime")
    private Float calculateTime;

    @SerializedName("enableAudioExpand")
    private Boolean enableAudioExpand;

    @SerializedName("isLeftRmsBigger")
    private Integer isLeftRmsBigger;

    @SerializedName("mixRatio")
    private Float mixRatio;

    @SerializedName("openAnalyzeAudioFrame")
    private Integer openAnalyzeAudioFrame;

    @SerializedName("processType")
    private Integer processType;

    public StrategyAudioChannelExpandParams() {
        this.enableAudioExpand = Boolean.FALSE;
        this.audioPosition = 0;
        this.processType = 0;
        this.openAnalyzeAudioFrame = 0;
    }

    public final Integer getAudioPosition() {
        return this.audioPosition;
    }

    public final Float getCalculateTime() {
        return this.calculateTime;
    }

    public final Boolean getEnableAudioExpand() {
        return this.enableAudioExpand;
    }

    public final Float getMixRatio() {
        return this.mixRatio;
    }

    public final Integer getOpenAnalyzeAudioFrame() {
        return this.openAnalyzeAudioFrame;
    }

    public final Integer getProcessType() {
        return this.processType;
    }

    public final Integer isLeftRmsBigger() {
        return this.isLeftRmsBigger;
    }

    public final void setAudioPosition(Integer r100) {
        this.audioPosition = r100;
    }

    public final void setCalculateTime(Float r100) {
        this.calculateTime = r100;
    }

    public final void setEnableAudioExpand(Boolean r100) {
        this.enableAudioExpand = r100;
    }

    public final void setLeftRmsBigger(Integer r100) {
        this.isLeftRmsBigger = r100;
    }

    public final void setMixRatio(Float r100) {
        this.mixRatio = r100;
    }

    public final void setOpenAnalyzeAudioFrame(Integer r100) {
        this.openAnalyzeAudioFrame = r100;
    }

    public final void setProcessType(Integer r100) {
        this.processType = r100;
    }
}
