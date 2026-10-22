package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/config/jg1;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "traceEnable", com.amap.api.col.s.ce.f26391f, "setTraceEnable", "reportEnable", "d", "setReportEnable", "", "traceSample", "D", "h", "()D", "setTraceSample", "(D)V", "reportSample", "e", "setReportSample", "", "", "userList", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "", "interactionDelayCheckTime", "J", "b", "()J", "setInteractionDelayCheckTime", "(J)V", "orientationDelayCheckTime", "c", "setOrientationDelayCheckTime", "", "stackInfoLength", "I", "f", "()I", "setStackInfoLength", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jg1 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("interaction_delay_check_time")
    private long interactionDelayCheckTime;

    @SerializedName("orientation_delay_check_time")
    private long orientationDelayCheckTime;

    @SerializedName("report_enable")
    private boolean reportEnable;

    @SerializedName("report_sample")
    private double reportSample;

    @SerializedName("stack_info_length")
    private int stackInfoLength;

    @SerializedName("trace_enable")
    private boolean traceEnable;

    @SerializedName("trace_sample")
    private double traceSample;

    @SerializedName("user_list")
    private List<String> userList;

    public jg1() {
        this.enable = true;
        this.traceEnable = true;
        this.reportEnable = true;
        this.traceSample = 0.6d;
        this.reportSample = 0.6d;
        this.userList = CollectionsKt.emptyList();
        this.interactionDelayCheckTime = 4;
        this.orientationDelayCheckTime = 3;
        this.stackInfoLength = 2048;
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.interactionDelayCheckTime;
    }

    public final long c() {
        return this.orientationDelayCheckTime;
    }

    public final boolean d() {
        return this.reportEnable;
    }

    public final double e() {
        return this.reportSample;
    }

    public final int f() {
        return this.stackInfoLength;
    }

    public final boolean g() {
        return this.traceEnable;
    }

    public final double h() {
        return this.traceSample;
    }

    public final List<String> i() {
        return this.userList;
    }
}
