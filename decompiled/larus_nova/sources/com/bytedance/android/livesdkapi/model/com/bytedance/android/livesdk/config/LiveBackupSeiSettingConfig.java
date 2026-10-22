package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveBackupSeiSettingConfig;", "", "()V", "backupSeiBehindRangeMS", "", "getBackupSeiBehindRangeMS", "()J", "setBackupSeiBehindRangeMS", "(J)V", "cdnSeiInvalidIntervalMS", "getCdnSeiInvalidIntervalMS", "setCdnSeiInvalidIntervalMS", "enableTestLogAndInfo", "", "getEnableTestLogAndInfo", "()Z", "setEnableTestLogAndInfo", "(Z)V", "forceDispatchBackupSei", "getForceDispatchBackupSei", "setForceDispatchBackupSei", "guestVersionEnable", "getGuestVersionEnable", "setGuestVersionEnable", "receiveBackupSeiThreshold", "getReceiveBackupSeiThreshold", "setReceiveBackupSeiThreshold", "sendIntervalMS", "getSendIntervalMS", "setSendIntervalMS", "serverMixStreamIsSupported", "getServerMixStreamIsSupported", "setServerMixStreamIsSupported", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBackupSeiSettingConfig {

    @SerializedName("backup_sei_behind_range_ms")
    private long backupSeiBehindRangeMS;

    @SerializedName("cdn_sei_invalid_interval_ms")
    private long cdnSeiInvalidIntervalMS;

    @SerializedName("enable_test_log_and_info")
    private boolean enableTestLogAndInfo;

    @SerializedName("force_dispatch_backup_sei")
    private boolean forceDispatchBackupSei;

    @SerializedName("backup_sei_guest_version_enable")
    private boolean guestVersionEnable;

    @SerializedName("receive_backup_sei_count_threshold")
    private long receiveBackupSeiThreshold;

    @SerializedName("send_backup_sei_interval_ms")
    private long sendIntervalMS;

    @SerializedName("server_mix_stream_is_supported")
    private boolean serverMixStreamIsSupported;

    public LiveBackupSeiSettingConfig() {
        this.sendIntervalMS = 1000;
        this.serverMixStreamIsSupported = true;
        this.cdnSeiInvalidIntervalMS = 10000;
        this.receiveBackupSeiThreshold = 3;
        this.backupSeiBehindRangeMS = 500;
        this.guestVersionEnable = true;
    }

    public final long getBackupSeiBehindRangeMS() {
        return this.backupSeiBehindRangeMS;
    }

    public final long getCdnSeiInvalidIntervalMS() {
        return this.cdnSeiInvalidIntervalMS;
    }

    public final boolean getEnableTestLogAndInfo() {
        return this.enableTestLogAndInfo;
    }

    public final boolean getForceDispatchBackupSei() {
        return this.forceDispatchBackupSei;
    }

    public final boolean getGuestVersionEnable() {
        return this.guestVersionEnable;
    }

    public final long getReceiveBackupSeiThreshold() {
        return this.receiveBackupSeiThreshold;
    }

    public final long getSendIntervalMS() {
        return this.sendIntervalMS;
    }

    public final boolean getServerMixStreamIsSupported() {
        return this.serverMixStreamIsSupported;
    }

    public final void setBackupSeiBehindRangeMS(long r100) {
        this.backupSeiBehindRangeMS = r100;
    }

    public final void setCdnSeiInvalidIntervalMS(long r100) {
        this.cdnSeiInvalidIntervalMS = r100;
    }

    public final void setEnableTestLogAndInfo(boolean r100) {
        this.enableTestLogAndInfo = r100;
    }

    public final void setForceDispatchBackupSei(boolean r100) {
        this.forceDispatchBackupSei = r100;
    }

    public final void setGuestVersionEnable(boolean r100) {
        this.guestVersionEnable = r100;
    }

    public final void setReceiveBackupSeiThreshold(long r100) {
        this.receiveBackupSeiThreshold = r100;
    }

    public final void setSendIntervalMS(long r100) {
        this.sendIntervalMS = r100;
    }

    public final void setServerMixStreamIsSupported(boolean r100) {
        this.serverMixStreamIsSupported = r100;
    }
}
