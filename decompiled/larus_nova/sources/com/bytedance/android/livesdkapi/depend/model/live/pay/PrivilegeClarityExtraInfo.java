package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeClarityExtraInfo;", "", "()V", "definition", "", "getDefinition", "()Ljava/lang/String;", "setDefinition", "(Ljava/lang/String;)V", "priorTime", "", "getPriorTime", "()Ljava/lang/Integer;", "setPriorTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sdkKey", "getSdkKey", "setSdkKey", "tipShowTime", "getTipShowTime", "setTipShowTime", "tipTimeAfterTrail", "getTipTimeAfterTrail", "setTipTimeAfterTrail", "trialTime", "getTrialTime", "setTrialTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeClarityExtraInfo {

    @SerializedName("definition")
    private String definition;

    @SerializedName("prior_to_show_time_interval")
    private Integer priorTime;

    @SerializedName("sdk_key")
    private String sdkKey;

    @SerializedName("toast_shown_time_interval")
    private Integer tipShowTime;

    @SerializedName("toast_shown_time_interval_for_free_trial")
    private Integer tipTimeAfterTrail;

    @SerializedName("free_trial_time_interval")
    private Integer trialTime;

    public PrivilegeClarityExtraInfo() {
        this.sdkKey = PlayerResolution.SDKKEY.UHD;
        this.definition = PlayerResolution.SDKKEY.UHD;
        this.priorTime = 10;
        this.tipShowTime = 20;
        this.trialTime = 15;
        this.tipTimeAfterTrail = 10;
    }

    public final String getDefinition() {
        return this.definition;
    }

    public final Integer getPriorTime() {
        return this.priorTime;
    }

    public final String getSdkKey() {
        return this.sdkKey;
    }

    public final Integer getTipShowTime() {
        return this.tipShowTime;
    }

    public final Integer getTipTimeAfterTrail() {
        return this.tipTimeAfterTrail;
    }

    public final Integer getTrialTime() {
        return this.trialTime;
    }

    public final void setDefinition(String r100) {
        this.definition = r100;
    }

    public final void setPriorTime(Integer r100) {
        this.priorTime = r100;
    }

    public final void setSdkKey(String r100) {
        this.sdkKey = r100;
    }

    public final void setTipShowTime(Integer r100) {
        this.tipShowTime = r100;
    }

    public final void setTipTimeAfterTrail(Integer r100) {
        this.tipTimeAfterTrail = r100;
    }

    public final void setTrialTime(Integer r100) {
        this.trialTime = r100;
    }
}
