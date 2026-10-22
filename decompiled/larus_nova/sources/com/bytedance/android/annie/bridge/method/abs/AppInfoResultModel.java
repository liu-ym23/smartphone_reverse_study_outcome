package com.bytedance.android.annie.bridge.method.abs;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0004\n\u0002\b\"\u0018\u00002\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bG\u0010HR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR$\u0010D\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010*\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.¨\u0006J"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel;", "Le7/k0;", "", "containerVersion", "Ljava/lang/String;", "getContainerVersion", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel$Code;", "c", "(Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel$Code;)V", "aid", "getAid", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "appName", "getAppName", "setAppName", "appVersion", "getAppVersion", "b", "device_id", "getDevice_id", "setDevice_id", OnekeyLoginConstants.NET_TYPE, "getNetType", "e", "user_id", "getUser_id", "setUser_id", "sec_user_id", "getSec_user_id", "setSec_user_id", "orientation", "getOrientation", "setOrientation", "", "screenHeight", "Ljava/lang/Number;", "getScreenHeight", "()Ljava/lang/Number;", "f", "(Ljava/lang/Number;)V", "screenWidth", "getScreenWidth", ce.f26391f, TTVideoEngineInterface.PLAY_API_KEY_AC, "getAc", "setAc", "version_code", "getVersion_code", RXScreenCaptureService.KEY_INDEX, RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "h", "idfa", "getIdfa", "setIdfa", "updateVersionCode", "getUpdateVersionCode", "setUpdateVersionCode", "webcast_sdk_version", "getWebcast_sdk_version", ce.f26395j, ILoadStallMonitor.START_TIME, "getStart_time", "setStart_time", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class AppInfoResultModel implements k0 {

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_AC)
    private String f38504ac;

    @SerializedName("aid")
    private String aid;

    @SerializedName("appName")
    private String appName;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("code")
    private Code code;

    @SerializedName("container_version")
    private String containerVersion;

    @SerializedName("device_id")
    private String device_id;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName(OnekeyLoginConstants.NET_TYPE)
    private String netType;

    @SerializedName("orientation")
    private String orientation;

    @SerializedName("screenHeight")
    private Number screenHeight;

    @SerializedName("screenWidth")
    private Number screenWidth;

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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/AppInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38505a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38505a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f38505a = new Code[]{r100, r101};
        }

        @Override // e7.j0
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
    }

    public final void a(String r100) {
        this.aid = r100;
    }

    public final void b(String r100) {
        this.appVersion = r100;
    }

    public final void c(Code r100) {
        this.code = r100;
    }

    public final void d(String r100) {
        this.containerVersion = r100;
    }

    public final void e(String r100) {
        this.netType = r100;
    }

    public final void f(Number r100) {
        this.screenHeight = r100;
    }

    public final void g(Number r100) {
        this.screenWidth = r100;
    }

    public final void h(String r100) {
        this.versionCode = r100;
    }

    public final void i(String r100) {
        this.version_code = r100;
    }

    public final void j(String r100) {
        this.webcast_sdk_version = r100;
    }
}
