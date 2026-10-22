package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveRoomCreateConfig;", "", "()V", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "linkMicInitV2Enable", "getLinkMicInitV2Enable", "setLinkMicInitV2Enable", "p0LoadDelayTime", "", "getP0LoadDelayTime", "()Ljava/lang/Long;", "setP0LoadDelayTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "pOtherLoadDelayTime", "getPOtherLoadDelayTime", "setPOtherLoadDelayTime", "publicScreenPriorityAdjust", "getPublicScreenPriorityAdjust", "setPublicScreenPriorityAdjust", "roomCreateApiToPb", "getRoomCreateApiToPb", "setRoomCreateApiToPb", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomCreateConfig {

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("link_mic_initV2_enable")
    private Boolean linkMicInitV2Enable;

    @SerializedName("p0_load_delay_time")
    private Long p0LoadDelayTime;

    @SerializedName("pOther_load_delay_time")
    private Long pOtherLoadDelayTime;

    @SerializedName("public_screen_priority_adjust")
    private Boolean publicScreenPriorityAdjust;

    @SerializedName("api_to_pb")
    private Boolean roomCreateApiToPb;

    public LiveRoomCreateConfig() {
        Boolean r100 = Boolean.FALSE;
        this.enable = r100;
        this.publicScreenPriorityAdjust = r100;
        this.linkMicInitV2Enable = r100;
        this.p0LoadDelayTime = 300L;
        this.pOtherLoadDelayTime = 500L;
        this.roomCreateApiToPb = r100;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Boolean getLinkMicInitV2Enable() {
        return this.linkMicInitV2Enable;
    }

    public final Long getP0LoadDelayTime() {
        return this.p0LoadDelayTime;
    }

    public final Long getPOtherLoadDelayTime() {
        return this.pOtherLoadDelayTime;
    }

    public final Boolean getPublicScreenPriorityAdjust() {
        return this.publicScreenPriorityAdjust;
    }

    public final Boolean getRoomCreateApiToPb() {
        return this.roomCreateApiToPb;
    }

    public final void setEnable(Boolean r100) {
        this.enable = r100;
    }

    public final void setLinkMicInitV2Enable(Boolean r100) {
        this.linkMicInitV2Enable = r100;
    }

    public final void setP0LoadDelayTime(Long r100) {
        this.p0LoadDelayTime = r100;
    }

    public final void setPOtherLoadDelayTime(Long r100) {
        this.pOtherLoadDelayTime = r100;
    }

    public final void setPublicScreenPriorityAdjust(Boolean r100) {
        this.publicScreenPriorityAdjust = r100;
    }

    public final void setRoomCreateApiToPb(Boolean r100) {
        this.roomCreateApiToPb = r100;
    }
}
