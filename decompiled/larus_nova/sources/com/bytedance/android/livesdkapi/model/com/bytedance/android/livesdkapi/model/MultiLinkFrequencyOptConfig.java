package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0016\u0010\u001a\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u001e\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdkapi/model/MultiLinkFrequencyOptConfig;", "", "()V", "backupSeiCdnPtsInternalMaxMS", "", "getBackupSeiCdnPtsInternalMaxMS", "()I", "setBackupSeiCdnPtsInternalMaxMS", "(I)V", "enableBackupSeiCdnPtsInvalidOpt", "", "getEnableBackupSeiCdnPtsInvalidOpt", "()Z", "setEnableBackupSeiCdnPtsInvalidOpt", "(Z)V", "enableSeiHandlerSampling", "getEnableSeiHandlerSampling", "enableWRDSMethodSampling", "getEnableWRDSMethodSampling", "enableWRDSMethodSamplingKey", "", "", "getEnableWRDSMethodSamplingKey", "()Ljava/util/List;", "freqFuncOpt", "getFreqFuncOpt", "lynxSeatLastVersionFuncOpt", "getLynxSeatLastVersionFuncOpt", "seiHandlerSamplingIntervalMs", "", "getSeiHandlerSamplingIntervalMs", "()J", "setSeiHandlerSamplingIntervalMs", "(J)V", "tryPrefetchGeckoResOpt", "getTryPrefetchGeckoResOpt", "wrdsMethodSamplingIntervalMs", "getWrdsMethodSamplingIntervalMs", "setWrdsMethodSamplingIntervalMs", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkFrequencyOptConfig {

    @SerializedName("backup_sei_cdn_pts_internal_max_ms")
    private int backupSeiCdnPtsInternalMaxMS;

    @SerializedName("enable_backup_sei_cdn_pts_invalid_opt")
    private boolean enableBackupSeiCdnPtsInvalidOpt;

    @SerializedName("enable_sei_handler_sampling")
    private final boolean enableSeiHandlerSampling;

    @SerializedName("enable_wrds_method_sampling")
    private final boolean enableWRDSMethodSampling;

    @SerializedName("enable_wrds_method_sampling_key")
    private final List<String> enableWRDSMethodSamplingKey;

    @SerializedName("freq_func_opt")
    private final boolean freqFuncOpt;

    @SerializedName("lynx_seat_get_last_version_func_opt")
    private final boolean lynxSeatLastVersionFuncOpt;

    @SerializedName("sei_handler_sampling_interval_ms")
    private long seiHandlerSamplingIntervalMs;

    @SerializedName("try_prefetch_gecko_res_opt")
    private final boolean tryPrefetchGeckoResOpt;

    @SerializedName("wrds_method_sampling_interval_ms")
    private long wrdsMethodSamplingIntervalMs;

    public MultiLinkFrequencyOptConfig() {
        this.enableWRDSMethodSampling = true;
        this.enableWRDSMethodSamplingKey = CollectionsKt.mutableListOf(new String[]{RoomLinkMicSyncData.SYNC_KEY});
        this.wrdsMethodSamplingIntervalMs = 500;
        this.enableSeiHandlerSampling = true;
        this.seiHandlerSamplingIntervalMs = 500;
        this.enableBackupSeiCdnPtsInvalidOpt = true;
        this.backupSeiCdnPtsInternalMaxMS = 15000;
        this.freqFuncOpt = true;
        this.lynxSeatLastVersionFuncOpt = true;
        this.tryPrefetchGeckoResOpt = true;
    }

    public final int getBackupSeiCdnPtsInternalMaxMS() {
        return this.backupSeiCdnPtsInternalMaxMS;
    }

    public final boolean getEnableBackupSeiCdnPtsInvalidOpt() {
        return this.enableBackupSeiCdnPtsInvalidOpt;
    }

    public final boolean getEnableSeiHandlerSampling() {
        return this.enableSeiHandlerSampling;
    }

    public final boolean getEnableWRDSMethodSampling() {
        return this.enableWRDSMethodSampling;
    }

    public final List<String> getEnableWRDSMethodSamplingKey() {
        return this.enableWRDSMethodSamplingKey;
    }

    public final boolean getFreqFuncOpt() {
        return this.freqFuncOpt;
    }

    public final boolean getLynxSeatLastVersionFuncOpt() {
        return this.lynxSeatLastVersionFuncOpt;
    }

    public final long getSeiHandlerSamplingIntervalMs() {
        return this.seiHandlerSamplingIntervalMs;
    }

    public final boolean getTryPrefetchGeckoResOpt() {
        return this.tryPrefetchGeckoResOpt;
    }

    public final long getWrdsMethodSamplingIntervalMs() {
        return this.wrdsMethodSamplingIntervalMs;
    }

    public final void setBackupSeiCdnPtsInternalMaxMS(int r100) {
        this.backupSeiCdnPtsInternalMaxMS = r100;
    }

    public final void setEnableBackupSeiCdnPtsInvalidOpt(boolean r100) {
        this.enableBackupSeiCdnPtsInvalidOpt = r100;
    }

    public final void setSeiHandlerSamplingIntervalMs(long r100) {
        this.seiHandlerSamplingIntervalMs = r100;
    }

    public final void setWrdsMethodSamplingIntervalMs(long r100) {
        this.wrdsMethodSamplingIntervalMs = r100;
    }
}
