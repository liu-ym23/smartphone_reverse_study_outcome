package com.bytedance.android.live.core.privacy.av.api;

import com.bytedance.android.live.core.setting.q;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class PrivacyConfig {

    @SerializedName("default_check_time")
    private int defaultCheckTime;

    @SerializedName("delay_upload_alog_time")
    private int delayUploadAlogTime;

    @SerializedName("disable_checker_biz")
    private List<String> disableCheckerBiz;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("support_upload_alog_when_error")
    private boolean supportUploadAlogWhenError;

    @SerializedName("support_upload_monitor")
    private boolean supportUploadToMonitor;

    @SerializedName("support_upload_trace")
    private boolean supportUploadToTrace;

    @SerializedName("supported_upload_to_trace_event_type")
    private List<String> supportedUploadToTraceEventType;

    public final boolean e() {
        if (this.enable == false) goto L5;
    L8:
        return true;
    L5:
        if (q.f65387a.getValue().booleanValue() == true) goto L8;
        return false;
    }

    public PrivacyConfig() {
        this.enable = false;
        this.supportUploadAlogWhenError = false;
        this.supportUploadToMonitor = true;
        this.supportUploadToTrace = false;
        this.delayUploadAlogTime = 30000;
        this.defaultCheckTime = 4000;
        this.disableCheckerBiz = new AnonymousClass1(this);
        this.supportedUploadToTraceEventType = new AnonymousClass2(this);
    }

    public final int a() {
        return this.defaultCheckTime;
    }

    public final int b() {
        return this.delayUploadAlogTime;
    }

    public final List<String> c() {
        return this.disableCheckerBiz;
    }

    public final List<String> d() {
        return this.supportedUploadToTraceEventType;
    }

    public final boolean f() {
        return this.supportUploadAlogWhenError;
    }

    public final boolean g() {
        return this.supportUploadToMonitor;
    }

    public final boolean h() {
        return this.supportUploadToTrace;
    }
}
