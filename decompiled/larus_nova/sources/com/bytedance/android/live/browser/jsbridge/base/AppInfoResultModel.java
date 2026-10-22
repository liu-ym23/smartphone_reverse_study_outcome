package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.dtf.face.config.IConstValues;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.connect.common.Constants;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0004\n\u0002\b4\u0018\u00002\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\bV\u0010WR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR$\u0010A\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010'\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR\"\u0010J\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000b\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR\"\u0010M\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR\"\u0010P\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR\"\u0010S\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000f¨\u0006Y"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "e", "(Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;)V", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "appName", "getAppName", "c", "appVersion", "getAppVersion", "d", "device_id", "getDevice_id", RXScreenCaptureService.KEY_INDEX, OnekeyLoginConstants.NET_TYPE, "getNetType", ce.f26395j, "user_id", "getUser_id", "t", "sec_user_id", "getSec_user_id", "q", "orientation", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "l", "", "screenHeight", "Ljava/lang/Number;", "getScreenHeight", "()Ljava/lang/Number;", OfficeSDKRequestTag.KEY_NEW_USER, "(Ljava/lang/Number;)V", "screenWidth", "getScreenWidth", "o", TTVideoEngineInterface.PLAY_API_KEY_AC, "getAc", "setAc", "version_code", "getVersion_code", BaseSwitches.V, RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "u", "idfa", "getIdfa", "setIdfa", "updateVersionCode", "getUpdateVersionCode", "s", "webcast_sdk_version", "getWebcast_sdk_version", "w", ILoadStallMonitor.START_TIME, "getStart_time", "r", "openId", "getOpenId", ce.f26396k, "devicePlatform", "getDevicePlatform", ce.f26391f, "osVersion", "getOsVersion", "m", IConstValues.DEVICE_TYPE, "getDeviceType", "h", "deviceBrand", "getDeviceBrand", "f", b.C, "getSdkVersion", "p", "<init>", "()V", "Code", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppInfoResultModel implements aa {

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_AC)
    private String f62957ac;

    @SerializedName("aid")
    private String aid;

    @SerializedName("appName")
    private String appName;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("code")
    private Code code;

    @SerializedName("device_brand")
    private String deviceBrand;

    @SerializedName("device_platform")
    private String devicePlatform;

    @SerializedName("device_type")
    private String deviceType;

    @SerializedName("device_id")
    private String device_id;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName(OnekeyLoginConstants.NET_TYPE)
    private String netType;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private String openId;

    @SerializedName("orientation")
    private String orientation;

    @SerializedName("os_version")
    private String osVersion;

    @SerializedName("screenHeight")
    private Number screenHeight;

    @SerializedName("screenWidth")
    private Number screenWidth;

    @SerializedName("SDKVersion")
    private String sdkVersion;

    @SerializedName("sec_user_id")
    private String sec_user_id;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private Number start_time;

    @SerializedName("updateVersionCode")
    private String updateVersionCode;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName(RuleConditionBean.VERSION_CODE_KEY)
    private String versionCode;

    @SerializedName("version_code")
    private String version_code;

    @SerializedName("webcast_sdk_version")
    private String webcast_sdk_version;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/AppInfoResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f62958a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f62958a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f62958a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public AppInfoResultModel() {
        this.openId = "";
        this.devicePlatform = "";
        this.osVersion = "";
        this.deviceType = "";
        this.deviceBrand = "";
        this.sdkVersion = "";
    }

    public final String a() {
        return this.orientation;
    }

    public final void b(String r100) {
        this.aid = r100;
    }

    public final void c(String r100) {
        this.appName = r100;
    }

    public final void d(String r100) {
        this.appVersion = r100;
    }

    public final void e(Code r100) {
        this.code = r100;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceBrand = r100;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.devicePlatform = r100;
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceType = r100;
    }

    public final void i(String r100) {
        this.device_id = r100;
    }

    public final void j(String r100) {
        this.netType = r100;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openId = r100;
    }

    public final void l(String r100) {
        this.orientation = r100;
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.osVersion = r100;
    }

    public final void n(Number r100) {
        this.screenHeight = r100;
    }

    public final void o(Number r100) {
        this.screenWidth = r100;
    }

    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sdkVersion = r100;
    }

    public final void q(String r100) {
        this.sec_user_id = r100;
    }

    public final void r(Number r100) {
        this.start_time = r100;
    }

    public final void s(String r100) {
        this.updateVersionCode = r100;
    }

    public final void t(String r100) {
        this.user_id = r100;
    }

    public final void u(String r100) {
        this.versionCode = r100;
    }

    public final void v(String r100) {
        this.version_code = r100;
    }

    public final void w(String r100) {
        this.webcast_sdk_version = r100;
    }
}
