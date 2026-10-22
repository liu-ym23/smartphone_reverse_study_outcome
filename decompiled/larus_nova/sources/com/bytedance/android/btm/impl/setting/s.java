package com.bytedance.android.btm.impl.setting;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/btm/impl/setting/s;", "", "", "switch", "I", "f", "()I", "setSwitch", "(I)V", "enableUpdateBtmPage", "d", "setEnableUpdateBtmPage", "callV2Api", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCallV2Api", "enableJsbCreateToken", "c", "setEnableJsbCreateToken", "useOnAttachViewCb", ce.f26391f, "setUseOnAttachViewCb", "callV2ApiMall", "b", "setCallV2ApiMall", "reportProcedureToAppLog", "getReportProcedureToAppLog", "setReportProcedureToAppLog", "reportRouterAppLog", "e", "setReportRouterAppLog", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class s {

    @SerializedName("call_v2_api")
    private int callV2Api;

    @SerializedName("call_v2_api_mall")
    private int callV2ApiMall;

    @SerializedName("enable_jsb_create_source_btm_token")
    private int enableJsbCreateToken;

    @SerializedName("update_btm_page_enabled")
    private int enableUpdateBtmPage;

    @SerializedName("report_procedure_to_app_log")
    private int reportProcedureToAppLog;

    @SerializedName("report_router_app_log")
    private int reportRouterAppLog;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private int f64switch;

    @SerializedName("use_on_attach_view_cb")
    private int useOnAttachViewCb;

    public s() {
        this.f64switch = 1;
        this.enableUpdateBtmPage = 1;
        this.callV2Api = 1;
        this.enableJsbCreateToken = 1;
        this.useOnAttachViewCb = 1;
        this.callV2ApiMall = 1;
    }

    public final int a() {
        return this.callV2Api;
    }

    public final int b() {
        return this.callV2ApiMall;
    }

    public final int c() {
        return this.enableJsbCreateToken;
    }

    public final int d() {
        return this.enableUpdateBtmPage;
    }

    public final int e() {
        return this.reportRouterAppLog;
    }

    public final int f() {
        return this.f64switch;
    }

    public final int g() {
        return this.useOnAttachViewCb;
    }
}
