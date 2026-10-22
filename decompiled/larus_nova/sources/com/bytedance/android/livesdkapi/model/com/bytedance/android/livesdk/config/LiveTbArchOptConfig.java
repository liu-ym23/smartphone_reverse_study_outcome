package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveTbArchOptConfig;", "", "()V", "bizCheckInterceptCount", "", "getBizCheckInterceptCount", "()I", "setBizCheckInterceptCount", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableAlog", "getEnableAlog", "setEnableAlog", "enableCollectTraceInfo", "getEnableCollectTraceInfo", "setEnableCollectTraceInfo", "enableTrace", "getEnableTrace", "setEnableTrace", "enableTraceSample", "getEnableTraceSample", "setEnableTraceSample", "prefOpt", "getPrefOpt", "setPrefOpt", "traceSample", "", "getTraceSample", "()D", "setTraceSample", "(D)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTbArchOptConfig {

    @SerializedName("biz_check_intercept_count")
    private int bizCheckInterceptCount;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_alog")
    private boolean enableAlog;

    @SerializedName("enable_collect_trace_info")
    private boolean enableCollectTraceInfo;

    @SerializedName("enable_trace")
    private boolean enableTrace;

    @SerializedName("enable_trace_sample")
    private boolean enableTraceSample;

    @SerializedName("pref_opt")
    private boolean prefOpt;

    @SerializedName("trace_sample")
    private double traceSample;

    public LiveTbArchOptConfig() {
        this.enableTraceSample = true;
        this.traceSample = 0.001d;
        this.enableAlog = true;
        this.enableCollectTraceInfo = true;
        this.bizCheckInterceptCount = 100;
    }

    public final int getBizCheckInterceptCount() {
        return this.bizCheckInterceptCount;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableAlog() {
        return this.enableAlog;
    }

    public final boolean getEnableCollectTraceInfo() {
        return this.enableCollectTraceInfo;
    }

    public final boolean getEnableTrace() {
        return this.enableTrace;
    }

    public final boolean getEnableTraceSample() {
        return this.enableTraceSample;
    }

    public final boolean getPrefOpt() {
        return this.prefOpt;
    }

    public final double getTraceSample() {
        return this.traceSample;
    }

    public final void setBizCheckInterceptCount(int r100) {
        this.bizCheckInterceptCount = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableAlog(boolean r100) {
        this.enableAlog = r100;
    }

    public final void setEnableCollectTraceInfo(boolean r100) {
        this.enableCollectTraceInfo = r100;
    }

    public final void setEnableTrace(boolean r100) {
        this.enableTrace = r100;
    }

    public final void setEnableTraceSample(boolean r100) {
        this.enableTraceSample = r100;
    }

    public final void setPrefOpt(boolean r100) {
        this.prefOpt = r100;
    }

    public final void setTraceSample(double r100) {
        this.traceSample = r100;
    }
}
