package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\bX\u0010YR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010A\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR$\u0010G\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bK\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR$\u0010S\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010L\u001a\u0004\bS\u0010M\"\u0004\bT\u0010OR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000f¨\u0006["}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel;", "Le7/k0;", "", "code", "Ljava/lang/Number;", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "", b.f276371u, "Ljava/lang/String;", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "appVersion", "getAppVersion", "setAppVersion", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "networkType", BpeaManager.getNetworkType, "setNetworkType", "deviceID", "getDeviceID", "setDeviceID", "screenOrientation", "getScreenOrientation", "setScreenOrientation", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "idfa", "getIdfa", "setIdfa", "Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "safeArea", "Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "getSafeArea", "()Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "setSafeArea", "(Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;)V", "channel", "getChannel", "setChannel", "language", "getLanguage", "setLanguage", "appTheme", "getAppTheme", "setAppTheme", "osVersion", "getOsVersion", "setOsVersion", "statusBarHeight", "getStatusBarHeight", "setStatusBarHeight", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "deviceModel", "getDeviceModel", "setDeviceModel", Constants.OperatorKey.KEY_CARRIER, "getCarrier", "setCarrier", "", "is32Bit", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "set32Bit", "(Ljava/lang/Boolean;)V", "installID", "getInstallID", "setInstallID", "isTeenMode", "setTeenMode", "msg", "getMsg", "setMsg", "<init>", "()V", "GetAppInfoSafeArea", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class GetAppInfoResultModel implements k0 {

    @SerializedName(b.f276371u)
    private String appID;

    @SerializedName("appName")
    private String appName;

    @SerializedName("appTheme")
    private String appTheme;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName(Constants.OperatorKey.KEY_CARRIER)
    private String carrier;

    @SerializedName("channel")
    private String channel;

    @SerializedName("code")
    private Number code;

    @SerializedName("deviceID")
    private String deviceID;

    @SerializedName("deviceModel")
    private String deviceModel;

    @SerializedName("devicePlatform")
    private String devicePlatform;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName("installID")
    private String installID;

    @SerializedName("is32Bit")
    private Boolean is32Bit;

    @SerializedName("isTeenMode")
    private Boolean isTeenMode;

    @SerializedName("language")
    private String language;

    @SerializedName("msg")
    private String msg;

    @SerializedName("networkType")
    private String networkType;

    @SerializedName("osVersion")
    private String osVersion;

    @SerializedName("safeArea")
    private GetAppInfoSafeArea safeArea;

    @SerializedName("screenHeight")
    private Number screenHeight;

    @SerializedName("screenOrientation")
    private String screenOrientation;

    @SerializedName("screenWidth")
    private Number screenWidth;

    @SerializedName("statusBarHeight")
    private Number statusBarHeight;

    @SerializedName("updateVersionCode")
    private String updateVersionCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "", "()V", "marginBottom", "", "getMarginBottom", "()Ljava/lang/Number;", "setMarginBottom", "(Ljava/lang/Number;)V", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class GetAppInfoSafeArea {

        @SerializedName("marginBottom")
        private Number marginBottom;

        @SerializedName("marginLeft")
        private Number marginLeft;

        @SerializedName("marginRight")
        private Number marginRight;

        @SerializedName("marginTop")
        private Number marginTop;

        public GetAppInfoSafeArea() {
        }

        public final Number getMarginBottom() {
            return this.marginBottom;
        }

        public final Number getMarginLeft() {
            return this.marginLeft;
        }

        public final Number getMarginRight() {
            return this.marginRight;
        }

        public final Number getMarginTop() {
            return this.marginTop;
        }

        public final void setMarginBottom(Number r100) {
            this.marginBottom = r100;
        }

        public final void setMarginLeft(Number r100) {
            this.marginLeft = r100;
        }

        public final void setMarginRight(Number r100) {
            this.marginRight = r100;
        }

        public final void setMarginTop(Number r100) {
            this.marginTop = r100;
        }
    }

    public String empty() {
        return "";
    }

    public GetAppInfoResultModel() {
    }

    public final String getAppID() {
        return this.appID;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppTheme() {
        return this.appTheme;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final Number getCode() {
        return this.code;
    }

    public final String getDeviceID() {
        return this.deviceID;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getIdfa() {
        return this.idfa;
    }

    public final String getInstallID() {
        return this.installID;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final GetAppInfoSafeArea getSafeArea() {
        return this.safeArea;
    }

    public final Number getScreenHeight() {
        return this.screenHeight;
    }

    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    public final Number getScreenWidth() {
        return this.screenWidth;
    }

    public final Number getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public final Boolean is32Bit() {
        return this.is32Bit;
    }

    public final Boolean isTeenMode() {
        return this.isTeenMode;
    }

    public final void set32Bit(Boolean r100) {
        this.is32Bit = r100;
    }

    public final void setAppID(String r100) {
        this.appID = r100;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setAppTheme(String r100) {
        this.appTheme = r100;
    }

    public final void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public final void setCarrier(String r100) {
        this.carrier = r100;
    }

    public final void setChannel(String r100) {
        this.channel = r100;
    }

    public final void setCode(Number r100) {
        this.code = r100;
    }

    public final void setDeviceID(String r100) {
        this.deviceID = r100;
    }

    public final void setDeviceModel(String r100) {
        this.deviceModel = r100;
    }

    public final void setDevicePlatform(String r100) {
        this.devicePlatform = r100;
    }

    public final void setIdfa(String r100) {
        this.idfa = r100;
    }

    public final void setInstallID(String r100) {
        this.installID = r100;
    }

    public final void setLanguage(String r100) {
        this.language = r100;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }

    public final void setNetworkType(String r100) {
        this.networkType = r100;
    }

    public final void setOsVersion(String r100) {
        this.osVersion = r100;
    }

    public final void setSafeArea(GetAppInfoSafeArea r100) {
        this.safeArea = r100;
    }

    public final void setScreenHeight(Number r100) {
        this.screenHeight = r100;
    }

    public final void setScreenOrientation(String r100) {
        this.screenOrientation = r100;
    }

    public final void setScreenWidth(Number r100) {
        this.screenWidth = r100;
    }

    public final void setStatusBarHeight(Number r100) {
        this.statusBarHeight = r100;
    }

    public final void setTeenMode(Boolean r100) {
        this.isTeenMode = r100;
    }

    public final void setUpdateVersionCode(String r100) {
        this.updateVersionCode = r100;
    }
}
