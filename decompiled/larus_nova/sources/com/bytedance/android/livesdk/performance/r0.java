package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class r0 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("enable_report_memory_when_enter_live_page")
    public boolean enableReportMemoryWhenEnterLivePage;

    @SerializedName("enable_report_v1")
    public boolean enableReportV1;

    @SerializedName("enable_report_v2")
    public boolean enableReportV2;

    @SerializedName("fps_duration")
    public long fpsDuration;

    @SerializedName("fps_duration_anchor")
    public long fpsDurationAnchor;

    @SerializedName("min_monitor_interval")
    public long minMonitorInterval;

    @SerializedName("min_monitor_interval_anchor")
    public long minMonitorIntervalAnchor;

    @SerializedName("monitor_delay")
    public long monitorDelay;

    @SerializedName("resident_interval")
    public long residentInterval;

    @SerializedName("resident_interval_anchor")
    public long residentIntervalAnchor;

    @SerializedName("sample_count_audience")
    public long sampleCountAudience;

    public r0() {
        this.enableReportV1 = true;
    }
}
