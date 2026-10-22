package com.byted.cast.proxy;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.byted.cast.common.Constants;
import com.byted.cast.proxy.impl.Utils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.facebook.keyframes.model.KFImage;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CastProxyMonitor {
    private static final String AID = "8188";
    private static volatile Boolean isMonitorExist;
    private String appName;
    private String appVersionName;
    private String deviceId;
    private String hostAid;
    private IMonitor monitor;
    private String packageName;
    private IServerListener serverListener;

    public static class CastProxyMonitorHolder {
        private static final CastProxyMonitor instance = null;

        private CastProxyMonitorHolder() {
        }

        static {
            instance = new CastProxyMonitor(null);
        }

        public static /* synthetic */ CastProxyMonitor access$100() {
            return instance;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private List<String> getDefaultMonitorConfigUrl() {
        return Arrays.asList(new String[]{"https://mon.snssdk.com/monitor/appmonitor/v2/settings", "https://monsetting.toutiao.com/monitor/appmonitor/v2/settings"});
    }

    private List<String> getDefaultMonitorReportUrl() {
        return Arrays.asList(new String[]{ReportConstant.DEFAULT_URL_REPORT});
    }

    public static boolean isMonitorUtilsExist() {
        if (isMonitorExist != null) goto L17;
        monitor-enter(CastProxyMonitor.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (isMonitorExist == null) goto L21;
    L11:
        monitor-exit(CastProxyMonitor.class);     // Catch: Throwable -> L13
        goto L17
    L21:
        INVOKESTATIC_com_byted_cast_proxy_CastProxyMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils");     // Catch: Throwable -> L10
        isMonitorExist = Boolean.TRUE;     // Catch: Throwable -> L10
    L10:
        isMonitorExist = Boolean.FALSE;     // Catch: Throwable -> L13
    L17:
        if (isMonitorExist != Boolean.TRUE) goto L19;
        return true;
    L19:
        return false;
    }

    private CastProxyMonitor() {
        this.hostAid = Constants.DEMO_HOST_AID;
    }

    public static CastProxyMonitor getInstance() {
        return CastProxyMonitorHolder.access$100();
    }

    public /* synthetic */ CastProxyMonitor(AnonymousClass1 r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_proxy_CastProxyMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ String access$200(CastProxyMonitor r100) {
        return r100.hostAid;
    }

    private void addCommonData(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put("request_id", Utils.requestId);
        r100.put("output_resolution", Utils.outputResolution);
        r100.put("appId", this.hostAid);
        r100.put("timestamp", String.valueOf(System.currentTimeMillis()));
        r100.put("packageName", this.packageName);
        r100.put("cast_protocol", "castproxy");
        r100.put("cast_proxy_version", BuildConfig.VERSION_NAME);
        r100.put("params_for_bytecast", "bytecastsdk");
    }

    private String getAppName(Context r100) {
        if (r100 != null) goto L5;
        return "Unknown";
    L5:
        PackageManager r101 = r100.getPackageManager();
        return r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0)).toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    }

    private String getAppVersionName(Context r100) {
        if (r100 != null) goto L5;
        return "Unknown";
    L5:
        PackageManager r101 = r100.getPackageManager();
        return r101.getPackageInfo(r100.getPackageName(), 0).versionName;
    L8:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    }

    private void initSdkMonitor(Context r100) {
        if (isMonitorUtilsExist() == false) goto L8;
        if (r100 == null) goto L9;
        JSONObject r101 = new JSONObject();
        addParametersToJSON(r101, "device_id", this.deviceId);
        addParametersToJSON(r101, "host_aid", this.hostAid);
        addParametersToJSON(r101, "sdk_version", BuildConfig.VERSION_NAME);
        addParametersToJSON(r101, "channel", this.appName);
        addParametersToJSON(r101, "app_version", this.appVersionName);
        addParametersToJSON(r101, "time_stamp", String.valueOf(System.currentTimeMillis()));
        SDKMonitorUtils.setConfigUrl(AID, getDefaultMonitorConfigUrl());
        SDKMonitorUtils.setDefaultReportUrl(AID, getDefaultMonitorReportUrl());
        SDKMonitorUtils.initMonitor(r100.getApplicationContext(), AID, r101, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public void notifyResizeFpsEvent(ArrayList<Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L23;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r103 >= r102) goto L17;
        int r107 = ((Integer) ListProtector.get(r100, r103)).intValue();
        r104 = r104 + r107;
        if (r103 != 0) goto L11;
        r101.append(r107);
        r105 = r107;
        r106 = r105;
    L16:
        r103 = r103 + 1;
        goto L7
    L11:
        if (r107 >= r106) goto L13;
        r106 = r107;
    L13:
        if (r107 <= r105) goto L15;
        r105 = r107;
    L15:
        r101.append(",");
        r101.append(r107);
        goto L16
    L17:
        HashMap r108 = new HashMap();
        r108.put("fps_max", String.valueOf(r105));
        r108.put("fps_min", String.valueOf(r106));
        r108.put("fps_avg", String.valueOf(r104 / r102));
        r108.put("fps_array", r101.toString());
        notifyEvent(Event.BYTECASTSDK_INDICATOR_RESIZE_FPS, r108);
        return;
    }

    private void monitorSlardarEvent(String r100, Map<String, String> r101) {
        if (isMonitorUtilsExist() == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r103.next();
        addParametersToJSON(r102, r104.getKey(), r104.getValue());
    L11:
        SDKMonitorUtils.getInstance(AID).monitorEvent(r100, r102, null, null);
    }

    public void init(Context r100, Config r101) {
        if (r100 == null) goto L4;
        this.packageName = r100.getPackageName();
        this.appName = getAppName(r100);
        this.appVersionName = getAppVersionName(r100);
    L4:
        if (r101 == null) goto L6;
        this.hostAid = r101.getAppId();
        this.deviceId = r101.getDeviceId();
        this.monitor = r101.getMonitor();
        this.serverListener = r101.getServerListener();
    L6:
        initSdkMonitor(r100);
    }

    public void notifyError(int r100, String r101) {
        notifyError(r100, r101, "");
    }

    public void notifyEvent(String r100, Map<String, String> r101) {
        addCommonData(r101);
        IMonitor r102 = this.monitor;
        if (r102 == null) goto L5;
        r102.onEvent(r100, r101);
    L5:
        monitorSlardarEvent(r100, r101);
    }

    public void notifyMediaCodecEncodeError(int r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("error_code", String.valueOf(r100));
        r102.put("error_msg", r101);
        notifyEvent(Event.BYTECASTSDK_INDICATOR_MEDIACODEC_ENCODE_ERROR, r102);
    }

    private void addParametersToJSON(JSONObject r100, String r101, String r102) {
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100.put(r101, r102);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void notifyError(int r100, String r101, String r102) {
        IServerListener r103 = this.serverListener;
        if (r103 == null) goto L5;
        r103.onError(r100, r101);
    L5:
        HashMap r104 = new HashMap();
        r104.put("error_code", String.valueOf(r100));
        r104.put("error_msg", r101);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r104.put("extra", r102);
    L8:
        notifyEvent(Event.BYTECAST_INDICATOR_CASTPROXY_ERROR, r104);
    }

    public void notifyInitMediaCodecEvent(int r100, int r101, int r102, boolean r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("width", String.valueOf(r100));
        r105.put("height", String.valueOf(r101));
        r105.put(KFImage.FRAME_RATE_JSON_FIELD, String.valueOf(r102));
        r105.put("success", String.valueOf(r103));
        r105.put("error_msg", r104);
        notifyEvent(Event.BYTECASTSDK_INDICATOR_RESIZE_INIT_MEDIACODEC, r105);
    }
}
