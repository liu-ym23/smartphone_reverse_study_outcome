package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerTraceMonitorConfig;", "", "()V", "enableExceptionEventReport", "", "getEnableExceptionEventReport", "()Z", "enableStartOrEndEventReport", "getEnableStartOrEndEventReport", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerTraceMonitorConfig {

    @SerializedName("enable_exception_event_report")
    private final boolean enableExceptionEventReport;

    @SerializedName("enable_start_or_end_event_report")
    private final boolean enableStartOrEndEventReport;

    public PlayerTraceMonitorConfig() {
    }

    public final boolean getEnableExceptionEventReport() {
        return this.enableExceptionEventReport;
    }

    public final boolean getEnableStartOrEndEventReport() {
        return this.enableStartOrEndEventReport;
    }
}
