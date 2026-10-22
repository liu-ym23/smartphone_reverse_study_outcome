package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0019\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\b¨\u0006+"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/x;", "", "", "enable", "Ljava/lang/Integer;", "getEnable", "()Ljava/lang/Integer;", "setEnable", "(Ljava/lang/Integer;)V", "startDelayMin", "getStartDelayMin", "setStartDelayMin", "showTimesInPeriod", "getShowTimesInPeriod", "setShowTimesInPeriod", "periodSeconds", "getPeriodSeconds", "setPeriodSeconds", "", "stutterThreshold", "Ljava/lang/Float;", "getStutterThreshold", "()Ljava/lang/Float;", "setStutterThreshold", "(Ljava/lang/Float;)V", "bitrateThreshold", "getBitrateThreshold", "setBitrateThreshold", "bitrateDetectPeriod", "getBitrateDetectPeriod", "setBitrateDetectPeriod", "noOperationDuration", "getNoOperationDuration", "setNoOperationDuration", "noOperationInterval", "getNoOperationInterval", "setNoOperationInterval", "performanceDataPeriod", "getPerformanceDataPeriod", "setPerformanceDataPeriod", "performanceDataTimes", "getPerformanceDataTimes", "setPerformanceDataTimes", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("bitrate_detect_period")
    private Integer bitrateDetectPeriod;

    @SerializedName("bitrate_kbps_threshold")
    private Integer bitrateThreshold;

    @SerializedName("enable")
    private Integer enable;

    @SerializedName("no_operation_duration_ms")
    private Integer noOperationDuration;

    @SerializedName("no_operation_interval_ms")
    private Integer noOperationInterval;

    @SerializedName("performance_data_cal_period")
    private Integer performanceDataPeriod;

    @SerializedName("performance_data_cal_times")
    private Integer performanceDataTimes;

    @SerializedName("show_times_period_seconds")
    private Integer periodSeconds;

    @SerializedName("show_times_in_period")
    private Integer showTimesInPeriod;

    @SerializedName("start_delay_min")
    private Integer startDelayMin;

    @SerializedName("block_threshold")
    private Float stutterThreshold;

    public x() {
        Float r100 = Float.valueOf(0.25f);
        this.enable = 0;
        this.startDelayMin = 3;
        this.showTimesInPeriod = 1;
        this.periodSeconds = 604800;
        this.stutterThreshold = r100;
        this.bitrateThreshold = 1000;
        this.bitrateDetectPeriod = 30;
        this.noOperationDuration = 2000;
        this.noOperationInterval = 100;
        this.performanceDataPeriod = 4;
        this.performanceDataTimes = 5;
    }
}
