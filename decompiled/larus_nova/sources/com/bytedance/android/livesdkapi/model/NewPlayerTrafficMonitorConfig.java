package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/NewPlayerTrafficMonitorConfig;", "", "()V", "checkInterval", "", "getCheckInterval", "()J", "clientAlertTraffic", "getClientAlertTraffic", "dayAlertTraffic", "getDayAlertTraffic", "enableAlertLog", "", "getEnableAlertLog", "()Z", "enableTeaLog", "getEnableTeaLog", "enableUseNewMonitor", "getEnableUseNewMonitor", "enableUseOldMonitor", "getEnableUseOldMonitor", "logWhenMobileUse", "getLogWhenMobileUse", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPlayerTrafficMonitorConfig {

    @SerializedName("log_check_interval")
    private final long checkInterval;

    @SerializedName("client_alert_traffic")
    private final long clientAlertTraffic;

    @SerializedName("day_alert_traffic")
    private final long dayAlertTraffic;

    @SerializedName("enable_alert_log")
    private final boolean enableAlertLog;

    @SerializedName("enable_tea_log")
    private final boolean enableTeaLog;

    @SerializedName("enable_use_new_monitor")
    private final boolean enableUseNewMonitor;

    @SerializedName("enable_use_old_monitor")
    private final boolean enableUseOldMonitor;

    @SerializedName("log_when_mobile_use")
    private final boolean logWhenMobileUse;

    public NewPlayerTrafficMonitorConfig() {
        this.enableUseOldMonitor = true;
        this.checkInterval = 300;
        this.enableAlertLog = true;
        this.clientAlertTraffic = 1024;
        this.dayAlertTraffic = 2048;
    }

    public final long getCheckInterval() {
        return this.checkInterval;
    }

    public final long getClientAlertTraffic() {
        return this.clientAlertTraffic;
    }

    public final long getDayAlertTraffic() {
        return this.dayAlertTraffic;
    }

    public final boolean getEnableAlertLog() {
        return this.enableAlertLog;
    }

    public final boolean getEnableTeaLog() {
        return this.enableTeaLog;
    }

    public final boolean getEnableUseNewMonitor() {
        return this.enableUseNewMonitor;
    }

    public final boolean getEnableUseOldMonitor() {
        return this.enableUseOldMonitor;
    }

    public final boolean getLogWhenMobileUse() {
        return this.logWhenMobileUse;
    }
}
