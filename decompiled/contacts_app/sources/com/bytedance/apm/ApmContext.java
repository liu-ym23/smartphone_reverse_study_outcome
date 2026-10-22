package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.core.DefaultDynamicParams;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.RomUtils;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.common.utility.date.DateDef;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmContext {
    private static boolean isInitFinish;
    private static CommonParams params;
    private static ApmProgressListener progressListener;
    private static String sAlogFilesDir;
    private static long sAppLaunchStartTimestamp;
    private static boolean sAutomationTest;
    private static Context sContext;
    private static String sCurrentProcessName;
    private static boolean sDebugMode;
    private static boolean sDoctorDebugMode;
    private static IDynamicParams sDynamicParams;
    private static boolean sExceptionTrafficDetect;
    private static JSONObject sHeader;
    private static IHttpService sHttpService;
    private static long sInitCostTime;
    private static long sInitCostTime6;
    static long sInitCostTimeStep2;
    static long sInitCostTimeStep3;
    static long sInitCostTimeStep4;
    static long sInitCostTimeStep5;
    private static long sInitTimeStamp;
    private static MonitorableInterceptor sInterceptor;
    private static boolean sIsApm6Enable;
    private static boolean sIsDeviceInfoOnPerfDataEnabled;
    private static boolean sIsInternalTest;
    private static boolean sIsMainProcess;
    private static volatile int sLaunchMode;
    private static boolean sNeedSalvage;
    private static IQueryParams sQueryParams;
    private static Map<String, String> sQueryParamsMap;
    private static long sReportSeqNo;
    private static List<String> sSlardarConfigUrls;
    private static long sStartCostTime;
    private static long sStartId;
    private static long sStartTimeStamp;
    private static long sStartupTimestamp;
    private static boolean sStopWhenBackground;
    private static boolean sSupportMultiFrameRate;

    public ApmContext() {
    }

    static {
        sHeader = new JSONObject();
        sDynamicParams = new DefaultDynamicParams();
        sQueryParamsMap = Collections.emptyMap();
        sHttpService = new DefaultHttpServiceImpl();
        sStartId = -1;
        sLaunchMode = -1;
        sStopWhenBackground = false;
        sReportSeqNo = 0;
        sNeedSalvage = true;
        sIsApm6Enable = true;
        isInitFinish = false;
        progressListener = null;
        sQueryParams = null;
    }

    public static boolean isInitFinish() {
        return isInitFinish;
    }

    public static void setIsInitFinish(boolean r0) {
        isInitFinish = r0;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        sContext = AppUtils.getApplication(r0);
    }

    public static void setInterceptor(MonitorableInterceptor r0) {
        sInterceptor = r0;
    }

    public static MonitorableInterceptor getInterceptor() {
        return sInterceptor;
    }

    public static void setCurrentProcessName(String r0) {
        sCurrentProcessName = r0;
    }

    public static void setInitCostTime(long r0) {
        sInitCostTime = r0;
    }

    public static void setInitCostTimeStepFinish(long r0) {
        sInitCostTime6 = r0;
    }

    public static void setInitCostTimeStep2(long r0) {
        sInitCostTimeStep2 = r0;
    }

    public static void setInitCostTimeStep3(long r0) {
        sInitCostTimeStep3 = r0;
    }

    public static void setInitCostTimeStep4(long r0) {
        sInitCostTimeStep4 = r0;
    }

    public static void setInitCostTimeStep5(long r0) {
        sInitCostTimeStep5 = r0;
    }

    public static void setStartCostTime(long r0) {
        sStartCostTime = r0;
    }

    public static boolean isNeedSalvage() {
        return sNeedSalvage;
    }

    public static void setNeedSalvage(boolean r0) {
        sNeedSalvage = r0;
    }

    public static ApmProgressListener getProgressListener() {
        return progressListener;
    }

    public static void setProgressListener(ApmProgressListener r0) {
        progressListener = r0;
    }

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L6;
        sCurrentProcessName = AppUtils.getProcessName(Process.myPid());
    L6:
        return sCurrentProcessName;
    }

    public static boolean isMainProcess() {
        boolean r1 = true;
        if (sIsMainProcess == false) goto L6;
        return true;
    L6:
        if (sContext == null) goto L8;
        String r0 = getCurrentProcessName();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        sIsMainProcess = r1;
    L21:
        return sIsMainProcess;
    L16:
        if (r0.equals(sContext.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(SimContactsConstants.ANR_SEP) == false) goto L14;
        sIsMainProcess = false;
        goto L21
    L8:
        return isMainProcessSimple();
    }

    public static boolean isMainProcessSimple() {
        if (sIsMainProcess == false) goto L5;
        return true;
    L5:
        String r0 = getCurrentProcessName();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(SimContactsConstants.ANR_SEP) == false) goto L11;
        return false;
    }

    public static void setStopWhenBackground(boolean r0) {
        sStopWhenBackground = r0;
    }

    public static boolean isStopWhenBackground() {
        return sStopWhenBackground;
    }

    public static String getPackageName() {
        Context r0 = sContext;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getPackageName();
    }

    public static String getTimeRange(long r2) {
        long r3 = r2 - sInitTimeStamp;
        if (r3 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r3 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r3 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r3 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r3 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r3 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r3 >= DateDef.HOUR) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static long getStartId() {
        if (sStartId != (-1)) goto L6;
        sStartId = System.currentTimeMillis();
    L6:
        return sStartId;
    }

    public static int getLaunchMode() {
        return sLaunchMode;
    }

    public static void setLaunchMode(int r0) {
        sLaunchMode = r0;
    }

    public static void setDebugMode(boolean r0) {
        sDebugMode = r0;
        com.bytedance.apm6.foundation.context.ApmContext.setDebugMode(isDebugMode());
    }

    public static void setDoctorDebugMode(boolean r0) {
        sDoctorDebugMode = r0;
        com.bytedance.apm6.foundation.context.ApmContext.setDebugMode(isDebugMode());
    }

    public static void setInternalTest(boolean r0) {
        sIsInternalTest = r0;
    }

    public static boolean isDebugMode() {
        if (sDebugMode == false) goto L5;
    L8:
        return true;
    L5:
        if (sDoctorDebugMode == true) goto L8;
        return false;
    }

    public static boolean isDoctorDebugMode() {
        return sDoctorDebugMode;
    }

    public static void setAutomationTest(boolean r0) {
        sAutomationTest = r0;
    }

    public static boolean isAutomationTest() {
        return sAutomationTest;
    }

    public static boolean isInternalTest() {
        return sIsInternalTest;
    }

    public static synchronized void setHeaderInfo(JSONObject r5) {
        monitor-enter(ApmContext.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (params != null) goto L7;
        params = new CommonParams();     // Catch: Throwable -> L24 Exception -> L72
    L7:
        r5.put("os", "Android");     // Catch: Throwable -> L24 Exception -> L72
        r5.put("device_platform", "android");     // Catch: Throwable -> L24 Exception -> L72
        r5.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("device_model", Build.MODEL);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("device_brand", Build.BRAND);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("process_name", AppUtils.getProcessName(Process.myPid()));     // Catch: Throwable -> L24 Exception -> L72
        r5.put("sid", getStartId());     // Catch: Throwable -> L24 Exception -> L72
        r5.put("phone_startup_time", getInitTimeStamp());     // Catch: Throwable -> L24 Exception -> L72
        r5.put("verify_info", SlardarProperties.getReleaseBuild());     // Catch: Throwable -> L24 Exception -> L72
        r5.put("rom_version", RomUtils.getRomInfo());     // Catch: Throwable -> L24 Exception -> L72
        if (r5.has("version_name") == true) goto L10;
        PackageInfo r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L72
        r5.put("version_name", r1.versionName);     // Catch: Throwable -> L24 Exception -> L72
    L12:
        if (TextUtils.isEmpty(r5.optString("app_version")) == false) goto L15;
        r5.put("app_version", r5.optString("version_name"));     // Catch: Throwable -> L24 Exception -> L72
    L15:
        if (r5.has("version_code") == true) goto L20;
        if (r1 != null) goto L18;
        r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L24 Exception -> L72
    L18:
        r5.put("version_code", r1.versionCode);     // Catch: Throwable -> L24 Exception -> L72
    L20:
        if (TextUtils.isEmpty(r5.optString("package")) == false) goto L22;
        r5.put("package", getContext().getPackageName());     // Catch: Throwable -> L24 Exception -> L72
    L22:
        r5.put("monitor_version", "5.0.21.21");     // Catch: Throwable -> L24 Exception -> L72
        goto L26
    L10:
        r1 = null;
    L26:
        params.setProcessName(r5.optString("process_name"));     // Catch: Throwable -> L24
        params.setDeviceId(r5.optString("device_id"));     // Catch: Throwable -> L24
        params.setAid(r5.optInt("aid"));     // Catch: Throwable -> L24 Exception -> L73
        params.setChannel(r5.optString("channel"));     // Catch: Throwable -> L24 Exception -> L73
        if (r5.has("update_version_code") == false) goto L34;
        if ((r5.get("update_version_code") instanceof String) == false) goto L32;
        params.setUpdateVersionCode(Integer.valueOf(r5.optString("update_version_code")).intValue());     // Catch: Throwable -> L24 Exception -> L73
        goto L34
    L32:
        params.setUpdateVersionCode(r5.optInt("update_version_code"));     // Catch: Throwable -> L24 Exception -> L73
    L34:
        if (r5.has("version_name") == false) goto L37;
        params.setVersionName(r5.optString("version_name"));     // Catch: Throwable -> L24 Exception -> L73
    L37:
        if (r5.has("manifest_version_code") == false) goto L43;
        if ((r5.get("manifest_version_code") instanceof String) == false) goto L41;
        params.setManifestVersionCode(Integer.valueOf(r5.optString("manifest_version_code")).intValue());     // Catch: Throwable -> L24 Exception -> L73
        goto L43
    L41:
        params.setManifestVersionCode(r5.optInt("manifest_version_code"));     // Catch: Throwable -> L24 Exception -> L73
    L43:
        if (r5.has("version_code") == false) goto L49;
        if ((r5.get("version_code") instanceof String) == false) goto L47;
        params.setVersionCode(Integer.valueOf(r5.optString("version_code")).intValue());     // Catch: Throwable -> L24 Exception -> L73
        goto L49
    L47:
        params.setVersionCode(r5.optInt("version_code"));     // Catch: Throwable -> L24 Exception -> L73
    L49:
        if (r5.has("app_version") == false) goto L51;
        params.setAppVersion(r5.optString("app_version"));     // Catch: Throwable -> L24 Exception -> L73
    L51:
        String r2 = SlardarProperties.getReleaseBuild();     // Catch: Throwable -> L24 Exception -> L73
        if (TextUtils.isEmpty(r2) == true) goto L57;
        if (r2.equals("null") == true) goto L57;
        r5.put("release_build", r2);     // Catch: Throwable -> L24 Exception -> L73
        params.setReleaseBuild(r5.optString("release_build"));     // Catch: Throwable -> L24 Exception -> L73
    L57:
        if (SlardarProperties.getReleaseBuild().isEmpty() == true) goto L59;
        params.setReleaseBuild(SlardarProperties.getReleaseBuild());     // Catch: Throwable -> L24 Exception -> L73
    L59:
        params.setStaticHeaderExtras(JsonUtils.deepCopy(r5));     // Catch: Throwable -> L24
        if (sHeader != null) goto L62;
        sHeader = r5;     // Catch: Throwable -> L24
    L68:
        monitor-exit(ApmContext.class);
        return;
    L62:
        Iterator<String> r3 = r5.keys();     // Catch: Throwable -> L24
    L64:
        if (r3.hasNext() == false) goto L68;
        String r4 = r3.next();     // Catch: Throwable -> L24
        sHeader.put(r4, r5.get(r4));     // Catch: Throwable -> L24 JSONException -> L74
        goto L64
    }

    public static void setHttpService(IHttpService r0) {
        if (r0 == null) goto L5;
        sHttpService = r0;
        return;
    }

    public static boolean isLocalChannel() {
        JSONObject r0 = sHeader;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.optString("channel") != null) goto L8;
        return false;
    L8:
        return sHeader.optString("channel").contains("local");
    }

    public static synchronized CommonParams getParams() {
        monitor-enter(ApmContext.class);
        CommonParams r1 = params;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> getParamsExtras() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L25
        if (r1 == null) goto L17;
        Map<String, String> r2 = r1.getQueryParams();     // Catch: Throwable -> L25
        if (r2 == null) goto L17;
        if (r2.size() <= 0) goto L17;
        if (params.getParamExtras() == null) goto L15;
        HashMap r3 = new HashMap(params.getParamExtras());     // Catch: Throwable -> L25
        r3.putAll(r2);     // Catch: Throwable -> L25
        monitor-exit(ApmContext.class);
        return r3;
    L15:
        monitor-exit(ApmContext.class);
        return r2;
    L17:
        CommonParams r4 = params;     // Catch: Throwable -> L25
        if (r4 == null) goto L22;
        Map<String, String> r5 = r4.getParamExtras();     // Catch: Throwable -> L25
        monitor-exit(ApmContext.class);
        return r5;
    L22:
        monitor-exit(ApmContext.class);
        return null;
    L25:
        th = move-exception;
        throw th;
    }

    public static synchronized void setQueryParams(IQueryParams r1) {
        monitor-enter(ApmContext.class);
        sQueryParams = r1;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized IQueryParams getQueryParams() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setDynamicParams(IDynamicParams r4) {
        monitor-enter(ApmContext.class);
        sDynamicParams = r4;     // Catch: Throwable -> L39
        Map<String, String> r5 = r4.getCommonParams();     // Catch: Throwable -> L39
        sQueryParamsMap = r5;     // Catch: Throwable -> L39
        if (r5 != null) goto L8;
        sQueryParamsMap = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (sQueryParamsMap.containsKey("aid") == true) goto L11;
        sQueryParamsMap.put("aid", sHeader.optString("aid"));     // Catch: Throwable -> L39
    L11:
        if (sQueryParamsMap.containsKey("device_id") == true) goto L14;
        sQueryParamsMap.put("device_id", sHeader.optString("device_id"));     // Catch: Throwable -> L39
    L14:
        if (sQueryParamsMap.containsKey("device_platform") == true) goto L16;
        sQueryParamsMap.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        sQueryParamsMap.put("os", "Android");     // Catch: Throwable -> L39
        if (sQueryParamsMap.containsKey("update_version_code") == true) goto L20;
        sQueryParamsMap.put("update_version_code", sHeader.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (sQueryParamsMap.containsKey("version_code") == true) goto L23;
        sQueryParamsMap.put("version_code", sHeader.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (sQueryParamsMap.containsKey("channel") == true) goto L26;
        sQueryParamsMap.put("channel", sHeader.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (sQueryParamsMap.containsKey("os_api") == true) goto L29;
        sQueryParamsMap.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L39
    L29:
        if (isDebugMode() == false) goto L34;
        if (sQueryParamsMap.containsKey("_log_level") == true) goto L34;
        sQueryParamsMap.put("_log_level", "debug");     // Catch: Throwable -> L39
    L34:
        if (params != null) goto L36;
        params = new CommonParams();     // Catch: Throwable -> L39
    L36:
        params.setParamExtras(new HashMap(sQueryParamsMap));     // Catch: Throwable -> L39
        monitor-exit(ApmContext.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> getQueryParamsMap() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        Map<String, String> r2 = r1.getQueryParams();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        HashMap r3 = new HashMap(sQueryParamsMap);     // Catch: Throwable -> L16
        r3.putAll(r2);     // Catch: Throwable -> L16
        monitor-exit(ApmContext.class);
        return r3;
    L13:
        Map<String, String> r4 = sQueryParamsMap;     // Catch: Throwable -> L16
        monitor-exit(ApmContext.class);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    public static void setExceptionTrafficDetect(boolean r0) {
        sExceptionTrafficDetect = r0;
    }

    @Deprecated
    public static JSONObject getHeaderInner() {
        return sHeader;
    }

    public static JSONObject getHeader() {
        return new JSONObject(String.valueOf(sHeader));
    L5:
        return new JSONObject();
    }

    public static boolean extendHeader(String r2, String r3) {
        if (sHeader != null) goto L6;
        return false;
    L6:
        if (r2.equals("release_build") == false) goto L12;
        return false;
    L12:
        sHeader.put(r2, r3);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static IDynamicParams getDynamicParams() {
        return sDynamicParams;
    }

    public static boolean isExceptionTrafficSwitchOn() {
        return sExceptionTrafficDetect;
    }

    public static IHttpService getHttpService() {
        return sHttpService;
    }

    public static HttpResponse doPost(String r1, byte[] r2, Map<String, String> r3) throws Exception {
        return sHttpService.doPost(r1, r2, r3);
    }

    public static HttpResponse doGet(String r1, Map<String, String> r2) throws Exception {
        return sHttpService.doGet(r1, r2);
    }

    public static HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) throws Exception {
        return sHttpService.uploadFiles(r1, r2, r3);
    }

    public static IMultipartUploader buildMultipartUploader(String r1, String r2, boolean r3) throws Exception {
        return sHttpService.buildMultipartUpload(r1, r2, r3);
    }

    public static IMultipartUploader buildMultipartUploader(String r1, String r2, boolean r3, Map<String, String> r4) throws Exception {
        return sHttpService.buildMultipartUpload(r1, r2, r3, r4);
    }

    public static long getInitTimeStamp() {
        if (sInitTimeStamp != 0) goto L6;
        sInitTimeStamp = System.currentTimeMillis();
    L6:
        return sInitTimeStamp;
    }

    public static void setInitTimeStamp(long r0) {
        sInitTimeStamp = r0;
    }

    public static long getInitUpTimestamp() {
        return sStartupTimestamp;
    }

    public static void setInitUpTimestamp(long r0) {
        sStartupTimestamp = r0;
    }

    public static long getDeltaTime() {
        return System.currentTimeMillis() - SystemClock.uptimeMillis();
    }

    public static long getStartTimeStamp() {
        return sStartTimeStamp;
    }

    public static void setStartTimeStamp(long r0) {
        sStartTimeStamp = r0;
    }

    public static void setAppLaunchStartTimestamp(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        long r2 = sAppLaunchStartTimestamp;
        if (r2 != 0) goto L8;
    L9:
        sAppLaunchStartTimestamp = r4;
        return;
    L8:
        if (r4 < r2) goto L9;
    }

    public static long getAppLaunchStartTimestamp() {
        return sAppLaunchStartTimestamp;
    }

    public static boolean supportMultiFrameRate() {
        return sSupportMultiFrameRate;
    }

    public static void setSupportMultiFrameRate(boolean r0) {
        sSupportMultiFrameRate = r0;
    }

    public static long getInitCostTime() {
        return sInitCostTime;
    }

    public static long getInitCostTimeIncludingApm6() {
        return sInitCostTime6;
    }

    public static long getInitCostTimeStep2() {
        return sInitCostTimeStep2;
    }

    public static long getInitCostTimeStep3() {
        return sInitCostTimeStep3;
    }

    public static long getInitCostTimeStep4() {
        return sInitCostTimeStep4;
    }

    public static long getInitCostTimeStep5() {
        return sInitCostTimeStep5;
    }

    public static long getStartCostTime() {
        return sStartCostTime;
    }

    public static void setDeviceInfoOnPerfDataEnabled(boolean r0) {
        sIsDeviceInfoOnPerfDataEnabled = r0;
    }

    public static boolean isDeviceInfoOnPerfDataEnabled() {
        return sIsDeviceInfoOnPerfDataEnabled;
    }

    public static long getReportSeqNo() {
        long r0 = sReportSeqNo;
        sReportSeqNo = 1 + r0;
        return r0;
    }

    public static List<String> getSlardarConfigUrls() {
        return sSlardarConfigUrls;
    }

    public static void setSlardarConfigUrls(List<String> r0) {
        sSlardarConfigUrls = r0;
    }

    public static void setAlogFilesDir(String r0) {
        sAlogFilesDir = r0;
    }

    public static String getAlogFilesDir() {
        return sAlogFilesDir;
    }

    public static String getNetType() {
        String r0 = sHttpService.getClass().getSimpleName();
        if ("DefaultTTNetImpl".equals(r0) == false) goto L6;
        return ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET;
    L6:
        return r0;
    }
}
