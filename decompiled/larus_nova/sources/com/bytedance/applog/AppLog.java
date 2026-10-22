package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.y;
import com.larus.network.NetQualityManager;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AppLog {
    private static final g gAppLogInstance = null;
    private static volatile boolean gAppLogInstanceInitialized;

    public AppLog() {
    }

    public static void onEventV3(String r100, Bundle r101) {
        com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(r100, r101);
    }

    public static void onEventV3(String r100, JSONObject r101) {
        com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(r100, r101);
    }

    public static void clearAndSetEnv() {
        gAppLogInstance.B1();
    }

    public static void disableInsertCache() {
        gAppLogInstance.w1();
    }

    public static void flush() {
        gAppLogInstance.flush();
    }

    public static void flushAsync() {
        gAppLogInstance.N();
    }

    public static String getAbSdkVersion() {
        return gAppLogInstance.getAbSdkVersion();
    }

    public static boolean getAdjustTerminate() {
        return gAppLogInstance.q1();
    }

    public static String getAid() {
        return gAppLogInstance.getAid();
    }

    public static String getAppId() {
        return gAppLogInstance.getAppId();
    }

    public static IBDAccountCallback getBDAccountCallback() {
        return gAppLogInstance.v();
    }

    public static y getBDInstallApi() {
        return gAppLogInstance.V();
    }

    public static mw3.b getBatchReportSettings() {
        return gAppLogInstance.R();
    }

    public static String getClientUdid() {
        return gAppLogInstance.e0();
    }

    public static com.bytedance.applog.params.b getCommonParams() {
        return gAppLogInstance.getCommonParams();
    }

    public static Context getContext() {
        return gAppLogInstance.getContext();
    }

    public static String getDid() {
        return gAppLogInstance.getDid();
    }

    public static Integer getDisablePersonalization() {
        return gAppLogInstance.Q0();
    }

    public static boolean getEnableEventUserId() {
        return gAppLogInstance.C0();
    }

    public static boolean getEncryptAndCompress() {
        return gAppLogInstance.getEncryptAndCompress();
    }

    public static uw3.a getEventFilterByClient() {
        return gAppLogInstance.Y();
    }

    public static JSONObject getHeader() {
        return gAppLogInstance.getHeader();
    }

    public static k getHeaderCustomCallback() {
        return gAppLogInstance.u();
    }

    public static int getHttpMonitorPort() {
        return gAppLogInstance.g1();
    }

    public static String getIid() {
        return gAppLogInstance.getIid();
    }

    public static q getInitConfig() {
        return gAppLogInstance.getInitConfig();
    }

    public static m getLogCompressor() {
        return gAppLogInstance.h();
    }

    public static o getLogSettingsCallback() {
        gAppLogInstance.e1();
        return null;
    }

    public static g0 getNetClient() {
        return gAppLogInstance.getNetClient();
    }

    public static String getOpenUdid() {
        return gAppLogInstance.getOpenUdid();
    }

    public static tw3.b getParamsExtractApi() {
        return gAppLogInstance.l0();
    }

    public static Map<String, String> getRequestHeader() {
        return gAppLogInstance.d();
    }

    public static uw3.i getSamplingFilter() {
        return gAppLogInstance.C();
    }

    public static String getSessionId() {
        return gAppLogInstance.getSessionId();
    }

    public static String getSsid() {
        return gAppLogInstance.getSsid();
    }

    public static String getUserID() {
        return gAppLogInstance.getUserID();
    }

    public static String getUserUniqueID() {
        return gAppLogInstance.getUserUniqueID();
    }

    public static boolean hasStarted() {
        return gAppLogInstance.i();
    }

    public static void initGroupPriority() {
        gAppLogInstance.Z0();
    }

    public static boolean isEnableBgSessionTask() {
        return gAppLogInstance.c0();
    }

    public static boolean isEnableEventInTouristMode() {
        return gAppLogInstance.Y0();
    }

    public static boolean isEnableEventPriority() {
        return gAppLogInstance.z1();
    }

    public static boolean isEventMapEnabled() {
        return gAppLogInstance.q0();
    }

    public static boolean isEventParamsExtractEnabled() {
        return gAppLogInstance.U0();
    }

    public static boolean isGroupPriorityEnabled() {
        return gAppLogInstance.P0();
    }

    public static boolean isNewUser() {
        return gAppLogInstance.isNewUser();
    }

    public static boolean isNewUserModeAvailable() {
        return gAppLogInstance.J();
    }

    public static boolean isTouristMode() {
        return gAppLogInstance.e();
    }

    public static boolean manualActivate() {
        return gAppLogInstance.k0();
    }

    public static g newInstance() {
        return new b();
    }

    public static void onActivityPause() {
        gAppLogInstance.onActivityPause();
    }

    public static void onBgSessionTaskPause() {
        gAppLogInstance.g();
    }

    public static void onBgSessionTaskResume() {
        gAppLogInstance.l();
    }

    public static void removeAllDataObserver() {
        gAppLogInstance.G0();
    }

    public static void start() {
        gAppLogInstance.start();
    }

    public static void stop() {
        gAppLogInstance.stop();
    }

    static {
        gAppLogInstance = newInstance();
        gAppLogInstanceInitialized = false;
    }

    public static g getInstance() {
        return gAppLogInstance;
    }

    public static void addDataObserver(h r100) {
        gAppLogInstance.E0(r100);
    }

    public static void addEventObserver(i r100) {
        gAppLogInstance.l1(r100);
    }

    public static void addEventObserverV2(j r100) {
        gAppLogInstance.x0(r100);
    }

    public static void addLaunchObserver(l r100) {
        gAppLogInstance.n1(r100);
    }

    public static void addLogReportMonitor(n r100) {
        gAppLogInstance.L(r100);
    }

    public static void addSessionHook(p r100) {
        gAppLogInstance.z0(r100);
    }

    public static void allowHeaderKey(String r100) {
        gAppLogInstance.x1(r100);
    }

    public static void blockHeaderKey(String r100) {
        gAppLogInstance.b0(r100);
    }

    public static void clearWhenSwitchChildMode(boolean r100) {
        gAppLogInstance.k(r100);
    }

    public static void forceTimeoutReportSync(long r100) {
        gAppLogInstance.t(r100);
    }

    public static void getSsidGroup(Map<String, String> r100) {
        gAppLogInstance.getSsidGroup(r100);
    }

    public static boolean isEventHitSamplingDrop(String r100) {
        return gAppLogInstance.s(r100);
    }

    public static boolean isEventHitStickySamplingDrop(String r100) {
        return gAppLogInstance.s(r100);
    }

    public static boolean isNewUserMode(Context r100) {
        return gAppLogInstance.c();
    }

    public static g84.d newUserMode(Context r100) {
        gAppLogInstance.r1();
        return null;
    }

    public static void onEvent(String r100) {
        gAppLogInstance.onEvent(r100);
    }

    public static void onEventV3(String r100) {
        gAppLogInstance.onEventV3(r100);
    }

    public static void onPause(Context r100) {
        gAppLogInstance.onPause(r100);
    }

    public static void onResume(Context r100) {
        gAppLogInstance.onResume(r100);
    }

    public static void registerAbSdkVersionCallback(f r100) {
        gAppLogInstance.U(r100);
    }

    public static void registerBgSessionTaskCallback(lx3.a r100) {
        gAppLogInstance.y();
    }

    public static void registerHeaderCustomCallback(k r100) {
        gAppLogInstance.Z(r100);
    }

    public static void removeDataObserver(h r100) {
        gAppLogInstance.k1(r100);
    }

    public static void removeEventObserver(i r100) {
        gAppLogInstance.y1(r100);
    }

    public static void removeEventObserverV2(j r100) {
        gAppLogInstance.a0(r100);
    }

    public static void removeHeaderInfo(String r100) {
        gAppLogInstance.H1(r100);
    }

    public static void removeLaunchObserver(l r100) {
        gAppLogInstance.P(r100);
    }

    public static void removeSessionHook(p r100) {
        gAppLogInstance.K0(r100);
    }

    public static void setAccount(Account r100) {
        gAppLogInstance.b(r100);
    }

    public static void setAdjustTerminate(boolean r100) {
        gAppLogInstance.N0(r100);
    }

    public static void setAppTrack(JSONObject r100) {
        gAppLogInstance.r(r100);
    }

    public static void setAutoStartGroupPriority(boolean r100) {
        gAppLogInstance.M0(r100);
    }

    public static void setBDAccountCallback(IBDAccountCallback r100) {
        gAppLogInstance.v1(r100);
    }

    public static void setBDInstallEventTrackEnabled(boolean r100) {
        gAppLogInstance.f0(r100);
    }

    public static void setBatchProcessEventCount(int r100) {
        gAppLogInstance.r0(r100);
    }

    public static void setBatchProcessInterval(int r100) {
        gAppLogInstance.h1(r100);
    }

    public static void setBgSessionReportOnPause(boolean r100) {
        gAppLogInstance.u1(r100);
    }

    public static void setBgSessionTaskEnabled(boolean r100) {
        gAppLogInstance.B0(r100);
    }

    public static void setBgSessionTaskNavigatorCallback(ow3.b r100) {
        gAppLogInstance.K(r100);
    }

    public static void setCommonParamsEnabled(boolean r100) {
        gAppLogInstance.I(r100);
    }

    public static void setCustomHeaderControlEnabled(boolean r100) {
        gAppLogInstance.S(r100);
    }

    public static void setDataIsolateCallback(yw3.b r100) {
        gAppLogInstance.D1();
    }

    public static void setDataIsolateEnabled(boolean r100) {
        gAppLogInstance.A1(r100);
    }

    public static void setDataIsolateKey(DataIsolateKey r100) {
        gAppLogInstance.c1(r100);
    }

    public static void setDefaultHttpClientProxy(Proxy r100) {
        gAppLogInstance.q(r100);
    }

    public static void setDevToolsEnable(boolean r100) {
        com.bytedance.applog.log.m.f192479a = Boolean.valueOf(r100);
    }

    public static void setDisablePersonalization(int r100) {
        gAppLogInstance.F0(r100);
    }

    public static void setEnableEventInTouristMode(boolean r100) {
        gAppLogInstance.F(r100);
    }

    public static void setEnableEventPriority(boolean r100) {
        gAppLogInstance.g0(r100);
    }

    public static void setEnableEventUserId(boolean r100) {
        gAppLogInstance.w0(r100);
    }

    public static void setEncryptAndCompress(boolean r100) {
        gAppLogInstance.t1(r100);
    }

    public static void setEventForwardEnabled(boolean r100) {
        gAppLogInstance.m1(r100);
    }

    public static void setEventHandler(ww3.a r100) {
        gAppLogInstance.T();
    }

    public static void setEventMapEnabled(boolean r100) {
        gAppLogInstance.G(r100);
    }

    public static void setEventParamControlEnabled(boolean r100) {
        gAppLogInstance.L0(r100);
    }

    public static void setEventParamsExtractEnabled(boolean r100) {
        gAppLogInstance.p0(r100);
    }

    public static void setEventSamplingEnable(boolean r100) {
        gAppLogInstance.j(r100);
    }

    public static void setExternalAbVersion(String r100) {
        gAppLogInstance.E(r100);
    }

    public static void setExtraParams(d0 r100) {
        gAppLogInstance.H0(r100);
    }

    public static void setFetchConfigFirstDelayMills(long r100) {
        gAppLogInstance.f1(r100);
    }

    public static void setFlushAsyncDefault(boolean r100) {
        gAppLogInstance.I0(r100);
    }

    public static void setFlushThresholdEnable(boolean r100) {
        gAppLogInstance.A0(r100);
    }

    public static void setGroupPriorityEnable(boolean r100) {
        gAppLogInstance.o(r100);
    }

    public static void setHeaderInfo(HashMap<String, Object> r100) {
        gAppLogInstance.setHeaderInfo(r100);
    }

    public static void setHttpMonitorPort(int r100) {
        gAppLogInstance.i1(r100);
    }

    public static void setInsertByTransactionEnabled(boolean r100) {
        gAppLogInstance.B(r100);
    }

    public static void setInsertEventOptEnabled(boolean r100) {
        gAppLogInstance.W(r100);
    }

    public static void setLogCompressor(m r100) {
        gAppLogInstance.T0(r100);
    }

    public static void setLogSettingsCallback(o r100) {
        gAppLogInstance.n0();
    }

    public static void setLogger(f0 r100) {
        gAppLogInstance.J1(r100);
    }

    public static void setMaxCacheEventNum(int r100) {
        gAppLogInstance.M(r100);
    }

    public static void setMaxRequestOnceReport(int r100) {
        gAppLogInstance.F1(r100);
    }

    public static void setMigrateOldAppLogDataEnabled(boolean r100) {
        gAppLogInstance.O0(r100);
    }

    public static void setNavigatorCallback(ow3.b r100) {
        gAppLogInstance.A(r100);
    }

    public static void setNewMonitorEnabled(boolean r100) {
        gAppLogInstance.f(r100);
    }

    public static void setNewMonitorInDebugMode(boolean r100) {
        gAppLogInstance.C1(r100);
    }

    public static void setPackLaunchByDesc(boolean r100) {
        gAppLogInstance.o0(r100);
    }

    public static void setPageId(String r100) {
        gAppLogInstance.D(r100);
    }

    public static void setPageInfoEnabled(boolean r100) {
        gAppLogInstance.J0(r100);
    }

    public static void setPageName(String r100) {
        gAppLogInstance.setPageName(r100);
    }

    public static void setReportDropStrategy(kx3.b r100) {
        gAppLogInstance.M1(r100);
    }

    public static void setServerFilterByNative(boolean r100) {
        gAppLogInstance.j0(r100);
    }

    public static void setServerFilterSaveToKeva(boolean r100) {
        gAppLogInstance.d0(r100);
    }

    public static void setTeaEventSamplingEnable(boolean r100) {
        gAppLogInstance.i0(r100);
    }

    public static void setTerminateImmediately(boolean r100) {
        gAppLogInstance.z(r100);
    }

    public static void setTouchPoint(String r100) {
        gAppLogInstance.n(r100);
    }

    public static void setTouristMode(boolean r100) {
        gAppLogInstance.j1(r100);
    }

    public static void setTrackResumeEvent(boolean r100) {
        gAppLogInstance.b1(r100);
    }

    public static void setUriRuntime(r r100) {
        gAppLogInstance.R0(r100);
    }

    public static void setUserAgent(String r100) {
        gAppLogInstance.h0(r100);
    }

    public static void setUserID(long r100) {
        gAppLogInstance.D0(r100);
    }

    public static void setUserUniqueID(String r100) {
        gAppLogInstance.setUserUniqueID(r100);
    }

    public static void addEventObserver(int r100, i r101) {
        gAppLogInstance.K1(r100, r101);
    }

    public static void addEventObserverV2(int r100, j r101) {
        gAppLogInstance.a1(r100, r101);
    }

    public static void addRegisterCustomHeader(Context r100, JSONObject r101) {
        gAppLogInstance.u0(r100, r101);
    }

    public static void com_bytedance_applog_AppLog__onEventV3$___twin___(String r100, Bundle r101) {
        gAppLogInstance.onEventV3(r100, r101);
    }

    public static void com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(String r100, Bundle r101) {
        if (r101 != null) goto L7;
    L4:
        com_bytedance_applog_AppLog__onEventV3$___twin___(r100, r101);
        return;
    L7:
        NetQualityManager.NetworkStatus r102 = NetQualityManager.f360092a;     // Catch: Exception -> L6
        r101.putInt("network_quality", NetQualityManager.f360092a.getValue());     // Catch: Exception -> L6
        goto L4
    }

    public static void init(Context r100, q r101) {
        monitor-enter(AppLog.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (gAppLogInstanceInitialized == false) goto L8;
        monitor-exit(AppLog.class);     // Catch: Throwable -> L16
        return;
    L8:
        gAppLogInstanceInitialized = true;     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r101.f192834z) == true) goto L11;
    L13:
        gAppLogInstance.O(r100, r101);     // Catch: Throwable -> L16
        monitor-exit(AppLog.class);     // Catch: Throwable -> L16
        return;
    L11:
        if (TextUtils.isEmpty("applog_stats") == true) goto L13;
        r101.f192834z = "applog_stats";     // Catch: Throwable -> L16
        goto L13
    }

    public static boolean isEventHitSamplingDrop(String r100, JSONObject r101) {
        return gAppLogInstance.X0(r100, r101);
    }

    public static boolean isEventHitStickySamplingDrop(String r100, JSONObject r101) {
        return gAppLogInstance.X0(r100, r101);
    }

    public static void monitorCount(String r100, int r101) {
        gAppLogInstance.t0(r100, r101);
    }

    public static void monitorError(String r100, Throwable r101) {
        gAppLogInstance.d1(r100, r101);
    }

    public static void onActivityResumed(Activity r100, int r101) {
        gAppLogInstance.onActivityResumed(r100);
    }

    public static void onEvent(String r100, String r101) {
        gAppLogInstance.onEvent(r100, r101);
    }

    public static void onMiscEvent(String r100, JSONObject r101) {
        gAppLogInstance.onMiscEvent(r100, r101);
    }

    public static void resetAndReInstall(long r100, t0 r101) {
        gAppLogInstance.E1(r100, r101);
    }

    public static void setAppLanguageAndRegion(String r100, String r101) {
        gAppLogInstance.setAppLanguageAndRegion(r100, r101);
    }

    public static void setEventFilterByClient(List<String> r100, boolean r101) {
        gAppLogInstance.v0(r100, r101);
    }

    public static void setEventForwardHttpHeader(String r100, String r101) {
        gAppLogInstance.o1(r100, r101);
    }

    public static void setEventSenderEnable(boolean r100, String r101) {
        gAppLogInstance.s0(r100, r101);
    }

    public static void setHeaderInfo(String r100, Object r101) {
        gAppLogInstance.a(r100, r101);
    }

    public static void setNewUserMode(Context r100, boolean r101) {
        gAppLogInstance.x(r101);
    }

    public static void com_bytedance_applog_AppLog__onEventV3$___twin___(String r100, JSONObject r101) {
        gAppLogInstance.onEventV3(r100, r101);
    }

    public static void com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(String r100, JSONObject r101) {
        if (r101 != null) goto L7;
    L4:
        com_bytedance_applog_AppLog__onEventV3$___twin___(r100, r101);
        return;
    L7:
        NetQualityManager.NetworkStatus r102 = NetQualityManager.f360092a;     // Catch: JSONException -> L6
        r101.put("network_quality", NetQualityManager.f360092a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void onActivityResumed(String r100, int r101) {
        gAppLogInstance.p(r100, r101);
    }

    public static void enableInsertCache(HashSet<String> r100, int r101, int r102) {
        gAppLogInstance.s1(r100, r101, r102);
    }

    public static <T> T getHeaderValue(String r100, T r101, Class<T> r102) {
        return (T) gAppLogInstance.G1(r100, r101, r102);
    }

    public static void setExpectedBatchInterval(String r100, String r101, int r102) {
        gAppLogInstance.S0(r100, r101, r102);
    }

    public static String addNetCommonParams(Context r100, String r101, boolean r102, Level r103) {
        return gAppLogInstance.w(r100, r101, r102, r103);
    }

    public static void onEventV3WithView(View r100, String r101, String r102, JSONObject r103) {
        gAppLogInstance.H(r100, r101, r102, r103);
    }

    public static void putCommonParams(Context r100, Map<String, String> r101, boolean r102, Level r103) {
        gAppLogInstance.m0(r100, r101, r102, r103);
    }

    public static void resetDidWhenSwitchChildMode(Context r100, boolean r101, long r102, t0 r103) {
        gAppLogInstance.p1(r101, r102, r103);
    }

    public static String addNetCommonParams(Context r100, StringBuilder r101, boolean r102, Level r103) {
        return gAppLogInstance.I1(r100, r101, r102, r103);
    }

    public static void onEvent(String r100, String r101, String r110, long r111, long r112) {
        gAppLogInstance.V0(r100, r101, r110, r111, r112);
    }

    public static void onInternalEventV3(String r100, Bundle r101, String r102, String r103, String r110) {
        gAppLogInstance.W0(r100, r101, r102, r103, r110);
    }

    public static void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r110) {
        gAppLogInstance.onInternalEventV3(r100, r101, r102, r103, r110);
    }

    public static void onEvent(String r100, String r110, String r111, long r112, long r113, JSONObject r114) {
        gAppLogInstance.Q(r100, r110, r111, r112, r113, r114);
    }
}
