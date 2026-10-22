package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemStatsReportConfig;", "", "()V", "isEnableDetail", "", "()Z", "setEnableDetail", "(Z)V", "isOpen", "setOpen", "reportDelay", "", "getReportDelay", "()J", "setReportDelay", "(J)V", "stayLiveDurationFilter", "getStayLiveDurationFilter", "setStayLiveDurationFilter", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMemStatsReportConfig {

    @SerializedName("enable_detail")
    private boolean isEnableDetail;

    @SerializedName("open")
    private boolean isOpen;

    @SerializedName("report_delay")
    private long reportDelay;

    @SerializedName("stay_live_duration_filter")
    private long stayLiveDurationFilter;

    public LiveMemStatsReportConfig() {
        this.reportDelay = 2000;
        this.stayLiveDurationFilter = 10000;
    }

    public final long getReportDelay() {
        return this.reportDelay;
    }

    public final long getStayLiveDurationFilter() {
        return this.stayLiveDurationFilter;
    }

    public final boolean isEnableDetail() {
        return this.isEnableDetail;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setEnableDetail(boolean r100) {
        this.isEnableDetail = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }

    public final void setReportDelay(long r100) {
        this.reportDelay = r100;
    }

    public final void setStayLiveDurationFilter(long r100) {
        this.stayLiveDurationFilter = r100;
    }
}
