package com.bytedance.android.ec.core.hybrid.prefetch;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/q;", "", "", "netStartTime", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", ce.f26391f, "(Ljava/lang/Long;)V", "netEndTime", "b", "f", "configReadStartTime", "getConfigReadStartTime", "setConfigReadStartTime", "configReadEndTime", "getConfigReadEndTime", "setConfigReadEndTime", "jsbStartTime", "getJsbStartTime", "e", "jsbEndTime", "getJsbEndTime", "d", "prefetchStartProcess", "getPrefetchStartProcess", "h", "prefetchStartRequest", "getPrefetchStartRequest", RXScreenCaptureService.KEY_INDEX, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient JSONObject f44255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Integer f44256b;

    @SerializedName("native_config_read_end_time")
    private Long configReadEndTime;

    @SerializedName("native_config_read_start_time")
    private Long configReadStartTime;

    @SerializedName("native_jsb_end_time")
    private Long jsbEndTime;

    @SerializedName("native_jsb_start_time")
    private Long jsbStartTime;

    @SerializedName("native_net_end_time")
    private Long netEndTime;

    @SerializedName("native_net_start_time")
    private Long netStartTime;

    @SerializedName("na_prefetch_start_process")
    private Long prefetchStartProcess;

    @SerializedName("na_prefetch_start_request")
    private Long prefetchStartRequest;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L26;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.netStartTime, r101.netStartTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.netEndTime, r101.netEndTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.configReadStartTime, r101.configReadStartTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configReadEndTime, r101.configReadEndTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jsbStartTime, r101.jsbStartTime) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jsbEndTime, r101.jsbEndTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prefetchStartProcess, r101.prefetchStartProcess) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.prefetchStartRequest, r101.prefetchStartRequest) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f44255a, r101.f44255a) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f44256b, r101.f44256b) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.netStartTime;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.netEndTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.configReadStartTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.configReadEndTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.jsbStartTime;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.jsbEndTime;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.prefetchStartProcess;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.prefetchStartRequest;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        JSONObject r125 = this.f44255a;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f44256b;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePrefetchTimeData(netStartTime=" + this.netStartTime + ", netEndTime=" + this.netEndTime + ", configReadStartTime=" + this.configReadStartTime + ", configReadEndTime=" + this.configReadEndTime + ", jsbStartTime=" + this.jsbStartTime + ", jsbEndTime=" + this.jsbEndTime + ", prefetchStartProcess=" + this.prefetchStartProcess + ", prefetchStartRequest=" + this.prefetchStartRequest + ", netDetail=" + this.f44255a + ", configFrom=" + this.f44256b + ")";
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("native_net_start_time", this.netStartTime);
        r100.putOpt("native_net_end_time", this.netEndTime);
        r100.putOpt("native_jsb_start_time", this.jsbStartTime);
        r100.putOpt("native_jsb_end_time", this.jsbEndTime);
        r100.putOpt("na_prefetch_start_process", this.prefetchStartProcess);
        r100.putOpt("na_prefetch_start_request", this.prefetchStartRequest);
        return r100;
    }

    public final Long b() {
        return this.netEndTime;
    }

    public final Long c() {
        return this.netStartTime;
    }

    public q(int r100) {
        this.netStartTime = null;
        this.netEndTime = null;
        this.configReadStartTime = null;
        this.configReadEndTime = null;
        this.jsbStartTime = null;
        this.jsbEndTime = null;
        this.prefetchStartProcess = null;
        this.prefetchStartRequest = null;
        this.f44255a = null;
        this.f44256b = null;
    }

    public final void d(Long r100) {
        this.jsbEndTime = r100;
    }

    public final void e(Long r100) {
        this.jsbStartTime = r100;
    }

    public final void f(Long r100) {
        this.netEndTime = r100;
    }

    public final void g(Long r100) {
        this.netStartTime = r100;
    }

    public final void h(Long r100) {
        this.prefetchStartProcess = r100;
    }

    public final void i(Long r100) {
        this.prefetchStartRequest = r100;
    }
}
