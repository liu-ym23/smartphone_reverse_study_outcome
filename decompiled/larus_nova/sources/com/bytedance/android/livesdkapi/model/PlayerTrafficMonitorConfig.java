package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerTrafficMonitorConfig;", "", "enableAppLogKeepAlive", "", "appLogKeepAliveInterval", "", "maxTrafficBeforeNotify", "(ZJJ)V", "getAppLogKeepAliveInterval", "()J", "getEnableAppLogKeepAlive", "()Z", "getMaxTrafficBeforeNotify", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerTrafficMonitorConfig {

    @SerializedName("log_keep_alive_interval")
    private final long appLogKeepAliveInterval;

    @SerializedName("enable_app_log_keep_alive")
    private final boolean enableAppLogKeepAlive;

    @SerializedName("max_traffic_before_notify_mb")
    private final long maxTrafficBeforeNotify;

    public PlayerTrafficMonitorConfig() {
        this(false, 0, 0, 7, null);
    }

    public final long getAppLogKeepAliveInterval() {
        return this.appLogKeepAliveInterval;
    }

    public final boolean getEnableAppLogKeepAlive() {
        return this.enableAppLogKeepAlive;
    }

    public final long getMaxTrafficBeforeNotify() {
        return this.maxTrafficBeforeNotify;
    }

    public PlayerTrafficMonitorConfig(boolean r100, long r101, long r102) {
        this.enableAppLogKeepAlive = r100;
        this.appLogKeepAliveInterval = r101;
        this.maxTrafficBeforeNotify = r102;
    }

    public /* synthetic */ PlayerTrafficMonitorConfig(boolean r100, long r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 600;
    L8:
        long r105 = r101;
        if ((r103 & 4) == 0) goto L11;
        r102 = 500;
    L11:
        boolean r106 = r100;
        this(r106, r105, r102);
    }
}
