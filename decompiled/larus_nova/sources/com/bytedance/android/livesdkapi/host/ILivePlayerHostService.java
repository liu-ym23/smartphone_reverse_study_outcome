package com.bytedance.android.livesdkapi.host;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.model.LivePlayerHostFlavor;
import com.bytedance.android.livesdkapi.model.PlayerTraceLogData;
import com.bytedance.android.livesdkapi.model.SettingsExtraInfo;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerBusiness;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;
import xu1.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&J%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001e\u001a\u00020\u0019H&J\b\u0010\u001f\u001a\u00020\u0004H&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\b\u0010\"\u001a\u00020\u0019H&J\b\u0010$\u001a\u00020#H&J\b\u0010%\u001a\u00020\u0004H&J\b\u0010&\u001a\u00020\u0019H&J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH&J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0004H&J\b\u0010+\u001a\u00020#H&J\b\u0010,\u001a\u00020\u0004H&J\n\u0010.\u001a\u0004\u0018\u00010-H&J\b\u0010/\u001a\u00020\u0004H&J\b\u00100\u001a\u00020\u0004H&J\b\u00102\u001a\u000201H&J\u0010\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0006H&J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0001H&J+\u00109\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00012\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u0000H&¢\u0006\u0004\b9\u0010:J3\u00109\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00012\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010<\u001a\u00020;H&¢\u0006\u0004\b9\u0010=J+\u0010>\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00012\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u0000H&¢\u0006\u0004\b>\u0010:J\b\u0010@\u001a\u00020?H&J\u0010\u0010B\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0004H&J:\u0010F\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u00028\u00000Dj\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u00028\u0000`E\"\b\b\u0000\u0010\u0011*\u00020CH&J\b\u0010G\u001a\u00020#H&J(\u0010J\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020)\u0018\u00010\u000b2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H&J(\u0010M\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020L\u0018\u00010\u000b2\u0006\u0010K\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u0019H&J\u0010\u0010N\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010O\u001a\u00020\u0019H&J\b\u0010P\u001a\u00020\u0004H&J\b\u0010Q\u001a\u00020\u0004H&J\b\u0010R\u001a\u00020\u0004H&J\u0010\u0010T\u001a\u00020\u00012\u0006\u00107\u001a\u00020SH&J\u001a\u0010W\u001a\u00020\b2\u0006\u0010U\u001a\u00020#2\b\u0010V\u001a\u0004\u0018\u00010\u0004H&J\u0018\u0010Y\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004H&J\u0018\u0010Z\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H&J\u001a\u0010]\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010^\u001a\u0004\u0018\u00010\u00062\u0006\u0010[\u001a\u00020\u0004H&J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u0004H&J\u001a\u0010c\u001a\u0004\u0018\u00010\u00062\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u0004H&J(\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0006\u0010d\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u0004H&J\u0012\u0010g\u001a\u0004\u0018\u00010\u00042\u0006\u0010f\u001a\u00020\u0004H&J\b\u0010h\u001a\u00020\bH&J\b\u0010i\u001a\u00020\bH&J\u0012\u0010k\u001a\u00020\b2\b\b\u0002\u0010j\u001a\u00020)H&¨\u0006l"}, d2 = {"Lcom/bytedance/android/livesdkapi/host/ILivePlayerHostService;", "", "Lcom/bytedance/android/livesdkapi/host/ILivePlayerALogger;", CloudControlInf.ALOG, "", "tag", "Lorg/json/JSONObject;", "info", "", "slardarLog", "eventName", "", "params", "teaLog", "Lcom/bytedance/android/livesdkapi/model/PlayerTraceLogData;", "traceLogData", "traceLog", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "getConfig", "(Ljava/lang/Class;)Ljava/lang/Object;", "onGetConfig", "(Ljava/lang/Object;)Ljava/lang/Object;", "updateSetting", "", "shouldResetVrEnable", "isLocalTest", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "isPad", "getGeckoRootDirPath", "Lxu1/a;", "getColorWeakModelEffectInfo", "isFreeFlow", "", "appId", "appLogServerDeviceID", "enableLiveIO", "nqeParams", "apiName", "", "dnsDelayLoadTime", "updateVersionCode", "versionName", "Lcom/bytedance/android/livesdkapi/host/ILivePlayerNetwork;", "livePlayerNetwork", "channel", "currentUserId", "Lcom/bytedance/android/livesdkapi/model/LivePlayerHostFlavor;", "hostFlavor", "data", "reportDataToDiagnoseDataManager", "any", "postRxBusEvent", "key", "defaultValue", "getSettingsValueForKey", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/bytedance/android/livesdkapi/model/SettingsExtraInfo;", "settingsExtraInfo", "(Ljava/lang/String;Ljava/lang/Object;Lcom/bytedance/android/livesdkapi/model/SettingsExtraInfo;)Ljava/lang/Object;", "getStrategyServiceFactor", "", "deviceScore", "shortName", "loadLibrary", "Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusiness;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBusiness", "audienceCount", "isFirst", "isImmediately", "getPssInfo", "appContext", "", "getCpuRateAndSpeed", "getDalvikPss", "isFoldScreen", "tobLicenseDir", "appName", "appRegion", "Lcom/bytedance/android/livesdkapi/host/HostDataKey;", "getHostData", "behavior", "detail", "onNetworkQualityChanged", "value", "writeSharedPreferences", "readSharedPreferences", "seiJsonString", "seiJSONObject", "writeToSeiJsonCache", "readSeiJsonCache", "streamData", "getStreamDataJsonObject", "streamDataString", "sdkKey", "getResolutionSdkParamsObj", LocationMonitorConst.IDENTIFIER, "getQualityBySdkKey", "modelName", "getEffectModelFilePath", "doJatoBigCore", "doJatoRestCore", "time", "doJatoBoostCpu", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerHostService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void doJatoBoostCpu$default(ILivePlayerHostService r100, long r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = 1000;
        L6:
            r100.doJatoBoostCpu(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJatoBoostCpu");
        }
    }

    ILivePlayerALogger alog();

    int appId();

    String appLogServerDeviceID();

    String appName();

    String appRegion();

    int audienceCount();

    String channel();

    Context context();

    String currentUserId();

    float deviceScore();

    long dnsDelayLoadTime(String r100);

    void doJatoBigCore();

    void doJatoBoostCpu(long r100);

    void doJatoRestCore();

    boolean enableLiveIO();

    <T extends IPlayerBusiness> HashMap<Class<T>, T> getBusiness();

    a getColorWeakModelEffectInfo();

    @Deprecated(message = "tmp save for saas")
    <T> T getConfig(Class<T> r100);

    Map<String, Double> getCpuRateAndSpeed(Context r100, boolean r101);

    int getDalvikPss(Context r100);

    String getEffectModelFilePath(String r100);

    String getGeckoRootDirPath();

    Object getHostData(HostDataKey r100);

    Map<String, Long> getPssInfo(boolean r100, boolean r101);

    Map<String, Object> getQualityBySdkKey(String r100, String r101);

    JSONObject getResolutionSdkParamsObj(String r100, String r101);

    <T> T getSettingsValueForKey(String r100, T r101);

    <T> T getSettingsValueForKey(String r100, T r101, SettingsExtraInfo r102);

    <T> T getStrategyServiceFactor(String r100, T r101);

    JSONObject getStreamDataJsonObject(String r100);

    LivePlayerHostFlavor hostFlavor();

    boolean isFoldScreen();

    boolean isFreeFlow();

    boolean isLocalTest();

    boolean isPad();

    ILivePlayerNetwork livePlayerNetwork();

    int loadLibrary(String r100);

    Map<String, String> nqeParams();

    <T> T onGetConfig(T r100);

    void onNetworkQualityChanged(int r100, String r101);

    void postRxBusEvent(Object r100);

    JSONObject readSeiJsonCache(String r100);

    String readSharedPreferences(String r100, String r101);

    void reportDataToDiagnoseDataManager(JSONObject r100);

    boolean shouldResetVrEnable();

    void slardarLog(String r100, JSONObject r101);

    void teaLog(String r100, Map<String, String> r101);

    String tobLicenseDir();

    void traceLog(PlayerTraceLogData r100);

    void updateSetting();

    int updateVersionCode();

    String versionName();

    void writeSharedPreferences(String r100, String r101);

    void writeToSeiJsonCache(String r100, JSONObject r101);
}
