package com.bytedance.android.livesdkapi.init;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020!8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveInitLoggerConfig;", "", "()V", "enableErrorReport", "", "getEnableErrorReport", "()Z", "setEnableErrorReport", "(Z)V", "enableReport", "getEnableReport", "enableWaitTaskReport", "getEnableWaitTaskReport", "setEnableWaitTaskReport", "errorReportToSlardar", "getErrorReportToSlardar", "setErrorReportToSlardar", "errorReportToTea", "getErrorReportToTea", "setErrorReportToTea", "errorSampleRate", "", "getErrorSampleRate", "()I", "setErrorSampleRate", "(I)V", "npeServiceWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getNpeServiceWhiteList", "()Ljava/util/ArrayList;", "reportDelayTime", "", "getReportDelayTime", "()J", "stackMaxLength", "getStackMaxLength", "setStackMaxLength", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitLoggerConfig {

    @SerializedName("enable_error_report")
    private boolean enableErrorReport;

    @SerializedName("enable_report")
    private final boolean enableReport;

    @SerializedName("enable_wait_task_report")
    private boolean enableWaitTaskReport;

    @SerializedName("error_report_to_slardar")
    private boolean errorReportToSlardar;

    @SerializedName("error_report_to_tea")
    private boolean errorReportToTea;

    @SerializedName("error_sample_rate")
    private int errorSampleRate;

    @SerializedName("npe_service_white_list")
    private final ArrayList<String> npeServiceWhiteList;

    @SerializedName("report_delay_time")
    private final long reportDelayTime;

    @SerializedName("stack_max_length")
    private int stackMaxLength;

    public LiveInitLoggerConfig() {
        this.npeServiceWhiteList = new ArrayList();
        this.reportDelayTime = 3000;
        this.errorSampleRate = 10;
        this.stackMaxLength = 1500;
    }

    public final boolean getEnableErrorReport() {
        return this.enableErrorReport;
    }

    public final boolean getEnableReport() {
        return this.enableReport;
    }

    public final boolean getEnableWaitTaskReport() {
        return this.enableWaitTaskReport;
    }

    public final boolean getErrorReportToSlardar() {
        return this.errorReportToSlardar;
    }

    public final boolean getErrorReportToTea() {
        return this.errorReportToTea;
    }

    public final int getErrorSampleRate() {
        return this.errorSampleRate;
    }

    public final ArrayList<String> getNpeServiceWhiteList() {
        return this.npeServiceWhiteList;
    }

    public final long getReportDelayTime() {
        return this.reportDelayTime;
    }

    public final int getStackMaxLength() {
        return this.stackMaxLength;
    }

    public final void setEnableErrorReport(boolean r100) {
        this.enableErrorReport = r100;
    }

    public final void setEnableWaitTaskReport(boolean r100) {
        this.enableWaitTaskReport = r100;
    }

    public final void setErrorReportToSlardar(boolean r100) {
        this.errorReportToSlardar = r100;
    }

    public final void setErrorReportToTea(boolean r100) {
        this.errorReportToTea = r100;
    }

    public final void setErrorSampleRate(int r100) {
        this.errorSampleRate = r100;
    }

    public final void setStackMaxLength(int r100) {
        this.stackMaxLength = r100;
    }
}
