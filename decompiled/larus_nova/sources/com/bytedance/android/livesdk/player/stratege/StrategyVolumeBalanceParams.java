package com.bytedance.android.livesdk.player.stratege;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/StrategyVolumeBalanceParams;", "", "()V", "enbaleVolumeBalance", "", "getEnbaleVolumeBalance", "()Ljava/lang/Boolean;", "setEnbaleVolumeBalance", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "predelay", "", "getPredelay", "()Ljava/lang/Float;", "setPredelay", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "pregain", "getPregain", "setPregain", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio", "setRatio", "targetLufs", "getTargetLufs", "setTargetLufs", "threshold", "getThreshold", "setThreshold", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyVolumeBalanceParams {

    @SerializedName("enbaleVolumeBalance")
    private Boolean enbaleVolumeBalance;

    @SerializedName("predelay")
    private Float predelay;

    @SerializedName("pregain")
    private Float pregain;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private Float ratio;

    @SerializedName("targetLufs")
    private Float targetLufs;

    @SerializedName("threshold")
    private Float threshold;

    public StrategyVolumeBalanceParams() {
    }

    public final Boolean getEnbaleVolumeBalance() {
        return this.enbaleVolumeBalance;
    }

    public final Float getPredelay() {
        return this.predelay;
    }

    public final Float getPregain() {
        return this.pregain;
    }

    public final Float getRatio() {
        return this.ratio;
    }

    public final Float getTargetLufs() {
        return this.targetLufs;
    }

    public final Float getThreshold() {
        return this.threshold;
    }

    public final void setEnbaleVolumeBalance(Boolean r100) {
        this.enbaleVolumeBalance = r100;
    }

    public final void setPredelay(Float r100) {
        this.predelay = r100;
    }

    public final void setPregain(Float r100) {
        this.pregain = r100;
    }

    public final void setRatio(Float r100) {
        this.ratio = r100;
    }

    public final void setTargetLufs(Float r100) {
        this.targetLufs = r100;
    }

    public final void setThreshold(Float r100) {
        this.threshold = r100;
    }
}
