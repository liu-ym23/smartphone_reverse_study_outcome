package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/o;", "", "", "enable", "I", "getEnable", "()I", "loadingSlowTime", "getLoadingSlowTime", "perfsReportSample", "getPerfsReportSample", "checkInterval", "getCheckInterval", "fpsThreshold", "getFpsThreshold", "tipCountMax", "getTipCountMax", "pauseOnBlock", "getPauseOnBlock", "reportSlardar", "getReportSlardar", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("check_interval")
    private final int checkInterval;

    @SerializedName("enable")
    private final int enable;

    @SerializedName("fps_threshold")
    private final int fpsThreshold;

    @SerializedName("loading_slow_time")
    private final int loadingSlowTime;

    @SerializedName("pause_on_block")
    private final int pauseOnBlock;

    @SerializedName("perfs_report_sample")
    private final int perfsReportSample;

    @SerializedName("report_slardar")
    private final int reportSlardar;

    @SerializedName("tip_count_max")
    private final int tipCountMax;

    public o() {
        this.enable = 1;
        this.loadingSlowTime = 10000;
        this.perfsReportSample = 1;
        this.checkInterval = 2;
        this.tipCountMax = 3;
    }
}
