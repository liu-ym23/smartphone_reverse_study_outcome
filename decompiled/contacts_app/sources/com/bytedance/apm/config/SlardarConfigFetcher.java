package com.bytedance.apm.config;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.impl.HttpRequest;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.slardar.config.IConfigListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SlardarConfigFetcher implements AsyncEventManager.IMonitorTimeTask {
    private static final long DEFAULT_FAILED_INTERVAL = 60000;
    private static final String PROCESS_NAME = "PROCESS_NAME";
    private static final String TAG = "SlardarConfigFetcher";
    private static final String UPDATE_SETTING_ACTION = "com.apm.setting.update.action";
    private boolean isMultiProcessUpdateSetting;
    private volatile long lastCalculateTimestamp;
    private volatile long lastFullCalculateTimestamp;
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigListener> mConfigListeners;
    private long mConfigNetFetchTimeTs;
    private long mConfigNetRefreshFailedInterval;
    private volatile boolean mExceptionEnableUpload;
    private volatile long mFetchSettingInterval;
    private volatile boolean mInitRegister;
    private boolean mIsMainProcess;
    private long mLastFetchSettingTime;
    private volatile JSONObject mMetricType;
    private IQueryParams mQueryParams;
    private List<String> mQueryUrls;
    private volatile boolean mReady;
    private volatile SharedPreferences mSharedPreferences;

    static /* synthetic */ boolean access$000(SlardarConfigFetcher r0) {
        return r0.updateFromLocal();
    }

    static /* synthetic */ boolean access$100(SlardarConfigFetcher r0) {
        return r0.mIsMainProcess;
    }

    SlardarConfigFetcher() {
        this.mExceptionEnableUpload = false;
        this.mQueryUrls = ReportUrl.FETCH_SETTING_LIST;
        this.mFetchSettingInterval = 1200;
        this.mLastFetchSettingTime = -1;
        this.mConfigNetRefreshFailedInterval = 60000;
        this.mConfigNetFetchTimeTs = -1;
        this.mInitRegister = false;
    }

    public void initParams(boolean r1, IQueryParams r2, List<String> r3) {
        this.isMultiProcessUpdateSetting = r1;
        this.mIsMainProcess = ApmContext.isMainProcess();
        initSharedPreferences();
        this.mQueryParams = r2;
        if (ListUtils.isEmpty(r3) == true) goto L5;
        this.mQueryUrls = convertHost(r3);
    L5:
        initRegister();
    }

    private List<String> convertHost(List<String> r6) {
        if (ListUtils.isEmpty(r6) == true) goto L14;
        ArrayList r5 = new ArrayList(2);     // Catch: MalformedURLException -> L15
        int r0 = r6.size();     // Catch: MalformedURLException -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = new URL(r6.get(r1)).getHost();     // Catch: MalformedURLException -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.indexOf(46) <= 0) goto L11;
        r5.add("https://" + r2 + ReportConsts.SETTING_PATH);     // Catch: MalformedURLException -> L15
    L11:
        r1 = r1 + 1;
        goto L5
    L12:
        return r5;
    L14:
        return Collections.emptyList();
    }

    public void forceUpdateFromRemote(IQueryParams r1, List<String> r2) {
        updateFromLocal();
        if (r1 == null) goto L6;
        this.mQueryParams = r1;
    L6:
        if (ListUtils.isEmpty(r2) == true) goto L8;
        this.mQueryUrls = new ArrayList(r2);
    L8:
        queryFromNet(true);
    }

    void initConfig() {
        boolean r0 = updateFromLocal();
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        if (this.mLastFetchSettingTime <= System.currentTimeMillis()) goto L7;
        r0 = true;
    L7:
        queryFromNet(r0);
    }

    private void initRegister() {
        if (this.mInitRegister == true) goto L9;
        this.mInitRegister = true;
        if (isCurrentProcessSupportRequestSetting() == false) goto L7;
        AsyncEventManager.getInstance().addTimeTask(this);
    L7:
        registerBroadUpdateSetting();
        return;
    }

    private boolean updateFromLocal() {
        String r2 = queryFromLocal();
        if (ApmAlogHelper.getInnerLogger() == null) goto L6;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L29
        r3.put("updateFromLocal", TextUtils.isEmpty(r2));     // Catch: Exception -> L29
        ApmAlogHelper.getInnerLogger().d(TAG, r3.toString());     // Catch: Exception -> L29
    L6:
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(TAG, "configStr:" + r2);
    L9:
        if (ApmContext.isDebugMode() == false) goto L12;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r2});
    L12:
        if (TextUtils.isEmpty(r2) == false) goto L32;
    L24:
        boolean r13 = true;
    L26:
        if (ApmContext.isDebugMode() == false) goto L28;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r13});
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_LOCAL, "needForceRefreshFromNet:" + r13 + " localConfig:" + r2);
    L28:
        return r13;
    L32:
        JSONObject r4 = new JSONObject(r2);     // Catch: Exception -> L23
        this.mConfigFromLocal = true;     // Catch: Exception -> L23
        int r8 = this.mSharedPreferences.getInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 0);     // Catch: Exception -> L23
        if (ApmContext.isDebugMode() == false) goto L17;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r8});     // Catch: Exception -> L23
    L17:
        if (r8 != 5) goto L24;
        this.mLastFetchSettingTime = queryLastRefreshTime();     // Catch: Exception -> L23
        this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);     // Catch: Exception -> L23
        this.lastFullCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0);     // Catch: Exception -> L23
        if (ApmContext.isDebugMode() == false) goto L21;
        Logger.d(TAG, "lastCalculateTimestamp:" + this.lastCalculateTimestamp);     // Catch: Exception -> L23
    L21:
        ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mLastFetchSettingTime + "");     // Catch: Exception -> L23
        com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mLastFetchSettingTime);     // Catch: Exception -> L23
        updateCurrentConfig(r4);     // Catch: Exception -> L23
        notifyListenerRefresh(r4, true);     // Catch: Exception -> L23
        notifyListenerReady();     // Catch: Exception -> L23
        r13 = false;
    L23:
        com.bytedance.apm.logging.Logger.e(DebugLogger.TAG_SETTING, new String[]{"config read error"});
        goto L24
    }

    private void registerBroadUpdateSetting() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(UPDATE_SETTING_ACTION);
        BroadcastReceiver r1 = new AnonymousClass1(this);
        if (ApmContext.getContext() == null) goto L16;
    L9:
        th = move-exception;
        Logger.e(TAG, "registerBroadUpdateSetting", th);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ApmContext.getContext(), r1, r0, 2);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ApmContext.getContext(), r1, r0);     // Catch: Throwable -> L9
        goto L12
    }

    private void sendBroadUpdateSetting() {
        AsyncEventManager.getInstance().postDelay(new AnonymousClass2(this), 1000);
    }

    public boolean getLogTypeSwitch(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r3, "block_monitor") == false) goto L9;
        r3 = "caton_monitor";
    L9:
        if (TextUtils.equals(r3, SlardarSettingsConsts.TYPE_ENSURE_MONITOR) == false) goto L13;
        return this.mExceptionEnableUpload;
    L13:
        if (this.mAllowLogType != null) goto L16;
        return false;
    L16:
        if (this.mAllowLogType.optInt(r3) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    boolean getMetricTypeSwitch(String r3) {
        if (this.mMetricType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mMetricType.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean getSwitch(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    JSONObject getJson(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L10;
        return r1.optJSONObject(r2);
    L10:
        return new JSONObject();
    }

    int getInt(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.mConfigData;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }

    boolean isReady() {
        return this.mReady;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r1) {
        queryFromNet(false);
    }

    private boolean isNeedRefreshFromNet(long r8) {
        long r0 = this.mConfigNetRefreshFailedInterval;
        if (r0 <= 60000) goto L10;
        if ((r8 - this.mConfigNetFetchTimeTs) <= r0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r8 - this.mLastFetchSettingTime) <= (this.mFetchSettingInterval * 1000)) goto L13;
        return true;
    L13:
        return false;
    }

    private long queryLastRefreshTime() {
        return this.mSharedPreferences.getLong("monitor_configure_refresh_time", 0);
    }

    private void initSharedPreferences() {
        if (this.mSharedPreferences != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mSharedPreferences != null) goto L8;
        this.mSharedPreferences = MonitorSharedPreferences.getSharedPreferences(ApmContext.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private void queryFromNet(boolean r13) {
        if (ApmContext.isDebugMode() == false) goto L6;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.queryFromNet." + isCurrentProcessSupportRequestSetting() + HanziToPinyin.Token.SEPARATOR + isNeedRefreshFromNet(System.currentTimeMillis())});
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET, "queryFromNet:" + r13);
    L6:
        if (isCurrentProcessSupportRequestSetting() == false) goto L11;
        if (r13 == false) goto L9;
    L10:
        boolean r14 = true;
    L12:
        if (r14 == true) goto L15;
        return;
    L15:
        if (NetUtils.isNetworkAvailable(ApmContext.getContext()) == false) goto L17;
        IQueryParams r15 = this.mQueryParams;
        if (r15 == null) goto L59;
        if (r15.getQueryParams() == null) goto L59;
        if (this.mQueryParams.getQueryParams().isEmpty() == true) goto L59;
        if (this.lastCalculateTimestamp != 0) goto L31;
        this.lastCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);
    L31:
        if (this.lastFullCalculateTimestamp != 0) goto L33;
        this.lastFullCalculateTimestamp = this.mSharedPreferences.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0);
    L33:
        this.mConfigNetFetchTimeTs = System.currentTimeMillis();
        Iterator<String> r16 = this.mQueryUrls.iterator();
        boolean r5 = false;
    L35:
        if (r16.hasNext() == false) goto L54;
        String r6 = r16.next();
        JSONObject r7 = retrieveSettingsParams();     // Catch: Throwable -> L50
        String r8 = ApmContext.getHeader().optString("aid");     // Catch: Throwable -> L50
        HashMap r9 = new HashMap();     // Catch: Throwable -> L50
        r9.put("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L50
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r8) == false) goto L40;
    L42:
        HttpRequest r11 = new HttpRequest(r6, r9, compress(r10.toString().getBytes(), r9));     // Catch: Throwable -> L50
        HttpResponse r12 = ApmContext.doPost(r11.url, r11.data, r11.headerMap);     // Catch: Throwable -> L50
        if (ApmContext.isDebugMode() == false) goto L45;
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_REQUEST, r11.url);     // Catch: Throwable -> L50
    L45:
        r5 = handleFetchResult(r12);     // Catch: Throwable -> L50
        if (ApmContext.isDebugMode() == false) goto L48;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r12.getResponseBytes().length + HanziToPinyin.Token.SEPARATOR + r5});     // Catch: Throwable -> L50
    L48:
        if (r5 == false) goto L35;
    L40:
        if (r8.equals("0") == true) goto L42;
        r10.put(r8, r7);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L35;
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "queFromNetError:" + th);
    L54:
        if (r5 == true) goto L56;
        this.mConfigNetRefreshFailedInterval = Math.min(this.mConfigNetRefreshFailedInterval * 2, 600000);
        return;
    L56:
        this.mConfigNetRefreshFailedInterval = 60000;
        return;
    L59:
        if (ApmContext.isDebugMode() == false) goto L74;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "mQueryParams not available");
        return;
    L74:
        return;
    L17:
        if (ApmContext.isDebugMode() == false) goto L72;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, "network not available");
        return;
    L72:
        return;
    L9:
        if (isNeedRefreshFromNet(System.currentTimeMillis()) == true) goto L10;
    L11:
        r14 = false;
        goto L12
    }

    private boolean isCurrentProcessSupportRequestSetting() {
        if (this.mIsMainProcess == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isMultiProcessUpdateSetting == true) goto L8;
        return false;
    }

    public JSONObject getConfigData() {
        return this.mConfigData;
    }

    public JSONObject retrieveSettingsParams() {
        IQueryParams r0 = this.mQueryParams;
        if (r0 != null) goto L5;
    L7:
        Map<String, String> r1 = null;
    L8:
        if (r1 == null) goto L10;
        HashMap r2 = new HashMap(r1);
    L11:
        r2.put("last_calculate_timestamp", String.valueOf(this.lastCalculateTimestamp / 1000));
        r2.put("last_full_calculate_timestamp", String.valueOf(this.lastFullCalculateTimestamp / 1000));
        if ((System.currentTimeMillis() - this.lastCalculateTimestamp) < 345600000) goto L14;
        r2.put("force_refresh", String.valueOf(1));
    L14:
        r2.put("minor_version", "1");
        return new JSONObject(r2);
    L10:
        r2 = new HashMap();
        goto L11
    L5:
        if (r0.getQueryParams() == null) goto L7;
        r1 = this.mQueryParams.getQueryParams();
        goto L8
    }

    public static byte[] compress(byte[] r2, Map<String, String> r3) throws IOException {
        if (r2.length <= 128) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        r1.close();
        byte[] r4 = r0.toByteArray();
        r3.put("Content-Encoding", "gzip");
        return r4;
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L14:
        return r2;
    }

    private boolean handleFetchResult(HttpResponse r5) throws JSONException {
        if (r5 == null) goto L18;
        if (r5.getStatusCode() != 200) goto L18;
        byte[] r6 = r5.getResponseBytes();
        if (r6 != null) goto L9;
        return false;
    L9:
        JSONObject r1 = new JSONObject(new String(r6));
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(TAG, "resultJSON:" + r1);
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_RESULT, r1.toString());
    L12:
        JSONObject r7 = r1.optJSONObject(ApmContext.getHeader().optString("aid"));
        if (r7 != null) goto L16;
        return false;
    L16:
        return updateWithSpecificAidResult(r7);
    L18:
        if (ApmContext.isDebugMode() == false) goto L24;
        DoctorManager r4 = DoctorManager.getInstance();
        StringBuilder r2 = new StringBuilder("statusCode error:");
        if (r5 != null) goto L22;
        Object r8 = "null";
    L23:
        r4.onEvent(DoctorConstants.APM_SETTING_UPDATE_FROM_NET_ERROR, r2.append(r8).toString());
        goto L24
    L22:
        r8 = Integer.valueOf(r5.getStatusCode());
    L24:
        return false;
    }

    public boolean updateWithSpecificAidResult(JSONObject r14) {
        int r0 = r14.optInt("code", -1);
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 != 1) goto L9;
        this.mLastFetchSettingTime = System.currentTimeMillis();
        this.lastCalculateTimestamp = ((long) r14.optInt("last_calculate_timestamp", 0)) * 1000;
        this.lastFullCalculateTimestamp = ((long) r14.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r15 = this.mSharedPreferences.edit();
        r15.putLong("monitor_configure_refresh_time", this.mLastFetchSettingTime);
        r15.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.lastCalculateTimestamp);
        r15.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.lastFullCalculateTimestamp);
        r15.commit();
        return true;
    L9:
        if (r0 != 0) goto L11;
    L14:
        JSONObject r1 = r14.optJSONObject("data");
        if (r1 != null) goto L27;
        String r2 = queryFromLocal();
        if (TextUtils.isEmpty(r2) == false) goto L51;
        r2 = "{}";
    L51:
        r1 = new JSONObject(r2);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (ApmContext.isDebugMode() == false) goto L26;
        Logger.e(TAG, "error parse configStr:" + r2);
    L26:
        r1 = null;
    L27:
        if (r1 != null) goto L49;
        return false;
    L49:
        JSONObject r11 = r14.optJSONObject("data_to_merge");     // Catch: JSONException -> L33
        if (r11 == null) goto L47;
        JsonUtils.mergeNestedData(r1, r11);     // Catch: JSONException -> L33
    L47:
        JSONObject r12 = r14.optJSONObject("data_to_delete");     // Catch: JSONException -> L41
        if (r12 == null) goto L45;
        JsonUtils.deleteNestedData(r1, r12);     // Catch: JSONException -> L41
    L45:
        this.lastCalculateTimestamp = ((long) r14.optInt("last_calculate_timestamp", 0)) * 1000;
        this.lastFullCalculateTimestamp = ((long) r14.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.mLastFetchSettingTime = System.currentTimeMillis();
        this.mConfigFromLocal = false;
        updateCurrentConfig(r1);
        saveLocalSwitch(r1);
        SharedPreferences.Editor r16 = this.mSharedPreferences.edit();
        r16.putString("monitor_net_config", r1.toString());
        r16.putInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 5);
        r16.putLong("monitor_configure_refresh_time", this.mLastFetchSettingTime);
        r16.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.lastCalculateTimestamp);
        r16.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.lastFullCalculateTimestamp);
        r16.commit();
        notifyListenerRefresh(r1, false);
        notifyListenerReady();
        ApmContext.extendHeader(Constants.KEY_CONFIG_TIME, this.mLastFetchSettingTime + "");
        com.bytedance.apm6.foundation.context.ApmContext.setConfigTime(this.mLastFetchSettingTime);
        sendBroadUpdateSetting();
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, DoctorConstants.APM_SETTING_READY);
        return true;
    L41:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (ApmContext.isDebugMode() == false) goto L45;
        Logger.e(TAG, "error nested data: dataToDelete");
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (ApmContext.isDebugMode() == false) goto L47;
        Logger.e(TAG, "error nested data: dataToMerge");
        goto L47
    L11:
        if (r0 == 2) goto L14;
        return false;
    }

    private void updateCurrentConfig(JSONObject r5) {
        if (com.bytedance.apm.util.JsonUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        JSONObject r0 = com.bytedance.apm.util.JsonUtils.optJSONObject(r5, "general", "slardar_api_settings");
        if (r0 == null) goto L13;
        JSONObject r1 = r0.optJSONObject(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH);
        if (r1 == null) goto L11;
        this.mFetchSettingInterval = r1.optLong(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH_INTERVAL, 1200);
    L11:
        if (this.mFetchSettingInterval >= 600) goto L13;
        this.mFetchSettingInterval = 600;
    L13:
        JSONObject r2 = r5.optJSONObject("custom_event_settings");
        if (r2 == null) goto L16;
        this.mAllowLogType = r2.optJSONObject("allow_log_type");
        this.mMetricType = r2.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
        this.mAllowService = r2.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
    L16:
        this.mConfigData = r5;
        JSONObject r6 = getJson(SlardarSettingsConsts.SETTING_EXCEPTION_CUSTOM_EVENT);
        if (r6 == null) goto L26;
        JSONObject r7 = r6.optJSONObject("exception");
        if (r7 == null) goto L26;
        if (r7.optInt("enable_upload") != 1) goto L23;
        boolean r8 = true;
    L24:
        this.mExceptionEnableUpload = r8;
        goto L26
    L23:
        r8 = false;
    L26:
        if (getServiceSwitch("apm_cost") == false) goto L29;
        LooperMonitor.setReporter(new AnonymousClass3(this));
        LooperMonitor.enableLooperCostMonitor(true);
        return;
    }

    private void saveLocalSwitch(JSONObject r7) {
        JSONObject r6 = r7.optJSONObject("general");
        boolean r0 = true;
        if (r6 == null) goto L5;
        FunctionSwitcher.updateSwitch(32, !r6.optBoolean(SlardarSettingsConsts.ENABLE_SALVAGE_LOG, true));
    L5:
        JSONObject r8 = com.bytedance.apm.util.JsonUtils.optJSONObject(r7, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH);
        if (r8 != null) goto L8;
    L20:
        JSONObject r9 = com.bytedance.apm.util.JsonUtils.optJSONObject(r7, "performance_modules", "start_trace");
        if (r9 != null) goto L23;
    L35:
        if (r8 != null) goto L37;
        if (r9 != null) goto L37;
        return;
    L37:
        FunctionSwitcher.saveToSp();
        return;
    L23:
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT, 0) != 1) goto L25;
        boolean r1 = true;
    L26:
        FunctionSwitcher.updateSwitch(4, r1);
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_LOCK_DATA_COLLECT, 0) != 1) goto L29;
        boolean r2 = true;
    L30:
        FunctionSwitcher.updateSwitch(8, r2);
        if (r9.optInt(SlardarSettingsConsts.PERF_KEY_LONG_SLEEP_DATA_COLLECT, 0) == 1) goto L34;
        r0 = false;
    L34:
        FunctionSwitcher.updateSwitch(16, r0);
        goto L35
    L29:
        r2 = false;
        goto L30
    L25:
        r1 = false;
        goto L26
    L8:
        if (r8.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L10;
        boolean r3 = true;
    L11:
        FunctionSwitcher.updateSwitch(1, r3);
        if (r8.optInt(SlardarSettingsConsts.PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r4 = true;
    L15:
        FunctionSwitcher.updateSwitch(2, r4);
        if (r8.optInt(SlardarSettingsConsts.PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L18;
        boolean r5 = true;
    L19:
        FunctionSwitcher.updateSwitch(64, r5);
        FunctionSwitcher.updateAtraceFlags(r8.optLong(SlardarSettingsConsts.PERF_ATRACE_TAG, 0));
        FunctionSwitcher.updateSwitch(SlardarConfigConsts.MONITOR_RUN_MODE_MASK, FluencyMonitor.getMode(r7) << 29);
        goto L20
    L18:
        r5 = false;
        goto L19
    L14:
        r4 = false;
        goto L15
    L10:
        r3 = false;
        goto L11
    }

    String queryFromLocal() {
        initSharedPreferences();
        return this.mSharedPreferences.getString("monitor_net_config", "");
    }

    void addConfigListener(IConfigListener r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mConfigListeners != null) goto L8;
        this.mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (this.mConfigListeners.contains(r4) == true) goto L11;
        this.mConfigListeners.add(r4);
    L11:
        if (ApmContext.isDebugMode() == false) goto L14;
        com.bytedance.apm.logging.Logger.i(SlardarLogConstants.TAG_INIT, new String[]{"addConfigListener, mReady=" + this.mReady});
    L14:
        if (this.mReady == false) goto L17;
        r4.onRefresh(this.mConfigData, this.mConfigFromLocal);
        r4.onReady();
        return;
    }

    void removeConfigListener(IConfigListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IConfigListener> r0 = this.mConfigListeners;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }

    private void notifyListenerRefresh(JSONObject r3, boolean r4) {
        List<IConfigListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L15;
        Iterator<IConfigListener> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L22;
        r5.next().onRefresh(r3, r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L14;
        th.printStackTrace();
    L14:
        EnsureManager.ensureNotReachHere(th);
        goto L6
    L22:
        return;
    }

    private void notifyListenerReady() {
        if (this.mReady == true) goto L17;
        this.mReady = true;
        List<IConfigListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L24;
        Iterator<IConfigListener> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L25;
        r3.next().onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L16;
        th.printStackTrace();
    L16:
        EnsureManager.ensureNotReachHere(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }
}
