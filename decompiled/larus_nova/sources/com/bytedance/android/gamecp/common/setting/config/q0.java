package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/q0;", "", "", "errorCode", "I", "e", "()I", "", "osVerson", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "minOSVersion", ce.f26391f, "hmOSVersion", "f", "romName", RXScreenCaptureService.KEY_INDEX, "romVersion", ce.f26395j, "brandName", "b", "deviceModel", "d", BdpAppEventConstant.PARAMS_STRATEGY_NAME, ce.f26396k, "count", "c", "timeWindow", "l", "bizScene", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tipInfo", "m", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
    private final int bizScene;

    @SerializedName("brand")
    private final String brandName;

    @SerializedName("count")
    private final int count;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("hm_os_version")
    private final String hmOSVersion;

    @SerializedName("min_os_version")
    private final String minOSVersion;

    @SerializedName("os_version")
    private final String osVerson;

    @SerializedName("rom_name")
    private final String romName;

    @SerializedName("rom_version")
    private final String romVersion;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final int strategy;

    @SerializedName("time_window")
    private final int timeWindow;

    @SerializedName("tip_info")
    private final String tipInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q0) == false) goto L32;
        q0 r101 = (q0) r100;
        if (this.errorCode == r101.errorCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.osVerson, r101.osVerson) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.minOSVersion, r101.minOSVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hmOSVersion, r101.hmOSVersion) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.romName, r101.romName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.romVersion, r101.romVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.brandName, r101.brandName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.deviceModel, r101.deviceModel) == true) goto L22;
        return false;
    L22:
        if (this.strategy == r101.strategy) goto L24;
        return false;
    L24:
        if (this.count == r101.count) goto L26;
        return false;
    L26:
        if (this.timeWindow == r101.timeWindow) goto L28;
        return false;
    L28:
        if (this.bizScene == r101.bizScene) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tipInfo, r101.tipInfo) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        int r100 = this.errorCode * 31;
        String r101 = this.osVerson;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.minOSVersion;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.hmOSVersion;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.romName;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.romVersion;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.brandName;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.deviceModel;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (((((((((r119 + r121) * 31) + this.strategy) * 31) + this.count) * 31) + this.timeWindow) * 31) + this.bizScene) * 31;
        String r123 = this.tipInfo;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return r122 + r102;
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DisasterRecoveryConfig(errorCode=" + this.errorCode + ", osVerson=" + this.osVerson + ", minOSVersion=" + this.minOSVersion + ", hmOSVersion=" + this.hmOSVersion + ", romName=" + this.romName + ", romVersion=" + this.romVersion + ", brandName=" + this.brandName + ", deviceModel=" + this.deviceModel + ", strategy=" + this.strategy + ", count=" + this.count + ", timeWindow=" + this.timeWindow + ", bizScene=" + this.bizScene + ", tipInfo=" + this.tipInfo + ")";
    }

    public q0() {
        this.errorCode = 0;
        this.osVerson = "";
        this.minOSVersion = "";
        this.hmOSVersion = "";
        this.romName = "";
        this.romVersion = "";
        this.brandName = "";
        this.deviceModel = "";
        this.strategy = 0;
        this.count = 0;
        this.timeWindow = 0;
        this.bizScene = 0;
        this.tipInfo = null;
    }

    public final int a() {
        return this.bizScene;
    }

    public final String b() {
        return this.brandName;
    }

    public final int c() {
        return this.count;
    }

    public final String d() {
        return this.deviceModel;
    }

    public final int e() {
        return this.errorCode;
    }

    public final String f() {
        return this.hmOSVersion;
    }

    public final String g() {
        return this.minOSVersion;
    }

    public final String h() {
        return this.osVerson;
    }

    public final String i() {
        return this.romName;
    }

    public final String j() {
        return this.romVersion;
    }

    public final int k() {
        return this.strategy;
    }

    public final int l() {
        return this.timeWindow;
    }

    public final String m() {
        return this.tipInfo;
    }
}
