package com.bytedance.android.sdk.bdticketguard;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/e;", "", "", "requestContent", "Ljava/lang/String;", "getRequestContent", "()Ljava/lang/String;", "", "timestamp", "J", "c", "()J", "tsSign", "d", "h", "(Ljava/lang/String;)V", "tsSignRee", "e", RXScreenCaptureService.KEY_INDEX, "requestSign", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "requestSignRee", "b", ce.f26391f, "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f163644a;

    @SerializedName("req_content")
    private final String requestContent;

    @SerializedName("req_sign")
    private String requestSign;

    @SerializedName("req_sign_ree")
    private String requestSignRee;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("ts_sign")
    private String tsSign;

    @SerializedName("ts_sign_ree")
    private String tsSignRee;

    public final String a() {
        return this.requestSign;
    }

    public final String b() {
        return this.requestSignRee;
    }

    public final long c() {
        return this.timestamp;
    }

    public final String d() {
        return this.tsSign;
    }

    public final String e() {
        return this.tsSignRee;
    }

    public final void f(String r100) {
        this.requestSign = r100;
    }

    public final void g(String r100) {
        this.requestSignRee = r100;
    }

    public final void h(String r100) {
        this.tsSign = r100;
    }

    public final void i(String r100) {
        this.tsSignRee = r100;
    }

    public e(String r100, String r101, long r102) {
        this.requestContent = r100;
        this.f163644a = r101;
        this.timestamp = r102;
        this.tsSign = "";
        this.tsSignRee = "";
        this.requestSign = "";
        this.requestSignRee = "";
    }
}
