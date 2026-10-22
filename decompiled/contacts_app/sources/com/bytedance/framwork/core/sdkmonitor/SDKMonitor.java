package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import com.bytedance.framwork.core.sdklib.LogReportManager;
import com.bytedance.framwork.core.sdklib.MonitorManager;
import com.bytedance.framwork.core.sdklib.config.IMonitorConfigure;
import com.bytedance.framwork.core.sdklib.config.MonitorConfigure;
import com.bytedance.framwork.core.sdklib.net.ISendLog;
import com.bytedance.framwork.core.sdklib.net.MonitorLogSender;
import com.bytedance.framwork.core.sdklib.net.NetResponse;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.DecodeUtils;
import com.bytedance.framwork.core.sdklib.util.NetUtils;
import com.bytedance.framwork.core.sdklog.LogLib;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SDKMonitor implements IMonitorConfigure, ISendLog, IMonitorTimeTask {
    private static final int BIT_API_ALL_SAMPLE = 1;
    private static final int SDK_VERSION = 400;
    private String mAid;
    private volatile JSONObject mAllowLogType;
    private volatile List<String> mAllowReportList;
    private volatile List<Pattern> mAllowReportPatterns;
    private volatile JSONObject mAllowService;
    private volatile List<String> mBlockReportList;
    private volatile List<Pattern> mBlockReportPatterns;
    private CacheData mCacheData;
    private Map<String, String> mCommonParams;
    private volatile boolean mConfigExit;
    private List<String> mConfigUrls;
    private Context mContext;
    private volatile int mDisableReportApiError;
    private volatile long mFetchSettingInterval;
    private volatile boolean mHasInit;
    private JSONObject mHeaderInfo;
    private volatile IHttpService mHttpService;
    private IGetExtendParams mIGetExtendParams;
    private volatile boolean mIsEncrypt;
    private volatile long mLastFetchSettingTime;
    private volatile boolean mLogRemoveNet;
    private volatile boolean mLogRemoveSwitch;
    private LogReportManager mLogReportManager;
    private volatile int mLogSendSwitch;
    private MonitorManager mMonitorManager;
    private volatile long mMonitorMaxRowCount;
    private boolean mOversea;
    private volatile int mReportCount;
    private volatile int mReportFailBaseTime;
    private volatile int mReportFailRepeatCount;
    private volatile int mReportInterval;
    private volatile int mReportSLA;
    private List<String> mReportUrlList;
    private volatile long mStopMoreChannelInterval;

    public interface ICallback {
        void callback(boolean r1);
    }

    public interface IGetCommonParams {
        String getSessionId();
    }

    public interface IGetExtendParams {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    static /* synthetic */ void access$000(SDKMonitor r0, Context r1, JSONObject r2, IGetExtendParams r3) {
        r0.initMonitor(r1, r2, r3);
    }

    static /* synthetic */ boolean access$100(SDKMonitor r0) {
        return r0.mConfigExit;
    }

    static /* synthetic */ LogReportManager access$1000(SDKMonitor r0) {
        return r0.mLogReportManager;
    }

    static /* synthetic */ boolean access$102(SDKMonitor r0, boolean r1) {
        r0.mConfigExit = r1;
        return r1;
    }

    static /* synthetic */ CacheData access$200(SDKMonitor r0) {
        return r0.mCacheData;
    }

    static /* synthetic */ Map access$300(SDKMonitor r0) {
        return r0.mCommonParams;
    }

    static /* synthetic */ List access$400(SDKMonitor r0) {
        return r0.mConfigUrls;
    }

    static /* synthetic */ StringBuilder access$500(SDKMonitor r0, String r1) {
        return r0.addParamsToURL(r1);
    }

    static /* synthetic */ IHttpService access$600(SDKMonitor r0) {
        return r0.getHttpService();
    }

    static /* synthetic */ boolean access$700(SDKMonitor r0) {
        return r0.mIsEncrypt;
    }

    static /* synthetic */ void access$800(SDKMonitor r0, JSONObject r1) {
        r0.updateToSP(r1);
    }

    static /* synthetic */ MonitorManager access$900(SDKMonitor r0) {
        return r0.mMonitorManager;
    }

    protected SDKMonitor(String r3) {
        this.mLastFetchSettingTime = 0;
        this.mLogSendSwitch = 1;
        this.mConfigUrls = new LinkedList();
        this.mIsEncrypt = true;
        this.mReportUrlList = new LinkedList();
        this.mAid = r3;
        this.mConfigExit = false;
        this.mCacheData = new CacheData();
    }

    public boolean init(Context r2, JSONObject r3, final IGetCommonParams r4) {
        if (r4 != null) goto L6;
        return init(r2, r3, new AnonymousClass1(this));
    L6:
        return init(r2, r3, new AnonymousClass2(this, r4));
    }

    public boolean init(final Context r4, final JSONObject r5, final IGetExtendParams r6) {
        this.mHasInit = true;
        AsyncEventManager.getInstance().postDelay(new AnonymousClass3(this, r4, r5, r6), 5000);
        return true;
    }

    protected boolean isHasInit() {
        return this.mHasInit;
    }

    private void initMonitor(Context r18, JSONObject r19, IGetExtendParams r20) {
        if (r18 == null) goto L30;
        if (r19 == null) goto L31;
        this.mHasInit = true;
        this.mContext = r18.getApplicationContext();
        this.mHeaderInfo = r19;
        r19.put("aid", this.mAid);     // Catch: Exception -> L27
        this.mHeaderInfo.put("os", "Android");     // Catch: Exception -> L27
        this.mHeaderInfo.put("device_platform", "android");     // Catch: Exception -> L27
        this.mHeaderInfo.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L27
        this.mHeaderInfo.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L27
        this.mHeaderInfo.put("device_model", Build.MODEL);     // Catch: Exception -> L27
        this.mHeaderInfo.put("device_brand", Build.BRAND);     // Catch: Exception -> L27
        this.mHeaderInfo.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L27
        this.mHeaderInfo.put(MonitorConstants.KEY_MONITOR_VERSION, BuildConfig.VERSION_NAME);     // Catch: Exception -> L27
        this.mHeaderInfo.put(MonitorConstants.KEY_MONITOR_FROM, MonitorConstants.MONITOR_FROM_SDK);     // Catch: Exception -> L27
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("package_name")) == false) goto L11;
        this.mHeaderInfo.put("package_name", r18.getPackageName());     // Catch: Exception -> L27
    L11:
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_name")) == false) goto L13;
        PackageInfo r1 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L27
        this.mHeaderInfo.put("version_name", r1.versionName);     // Catch: Exception -> L27
    L15:
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_code")) == false) goto L19;
        if (r1 != null) goto L18;
        r1 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L27
    L18:
        this.mHeaderInfo.put("version_code", r1.versionCode);     // Catch: Exception -> L27
    L19:
        this.mIGetExtendParams = r20;     // Catch: Exception -> L27
        if (r20 != null) goto L22;
        this.mIGetExtendParams = new AnonymousClass4(this);     // Catch: Exception -> L27
    L22:
        Map<String, String> r2 = this.mIGetExtendParams.getCommonParams();     // Catch: Exception -> L27
        this.mCommonParams = r2;     // Catch: Exception -> L27
        if (r2 != null) goto L25;
        this.mCommonParams = new HashMap();     // Catch: Exception -> L27
    L25:
        this.mOversea = TextUtils.equals(this.mCommonParams.get("oversea"), "1");     // Catch: Exception -> L27
        this.mCommonParams.put("aid", this.mAid);     // Catch: Exception -> L27
        this.mCommonParams.put("device_id", this.mHeaderInfo.optString("device_id"));     // Catch: Exception -> L27
        this.mCommonParams.put("device_platform", "android");     // Catch: Exception -> L27
        this.mCommonParams.put("package_name", this.mHeaderInfo.optString("package_name"));     // Catch: Exception -> L27
        this.mCommonParams.put("channel", this.mHeaderInfo.optString("channel"));     // Catch: Exception -> L27
        this.mCommonParams.put("app_version", this.mHeaderInfo.optString("app_version"));     // Catch: Exception -> L27
        this.mCommonParams.put(MonitorConstants.KEY_MONITOR_VERSION, BuildConfig.VERSION_NAME);     // Catch: Exception -> L27
        this.mCommonParams.put("minor_version", "1");     // Catch: Exception -> L27
        MonitorConfigure.setCommonConfig(this.mAid, this);     // Catch: Exception -> L27
        MonitorLogSender.setISendLog(this.mAid, this);     // Catch: Exception -> L27
        initLogLib();     // Catch: Exception -> L27
        MonitorManager r3 = new MonitorManager(this.mContext, this.mAid);     // Catch: Exception -> L27
        this.mMonitorManager = r3;     // Catch: Exception -> L27
        r3.init();     // Catch: Exception -> L27
        this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L27
        initConfig();     // Catch: Exception -> L27
        return;
    L13:
        r1 = null;
    L32:
        return;
    L31:
        return;
    }

    private IHttpService getHttpService() {
        if (this.mHttpService != null) goto L6;
        this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
    L6:
        return this.mHttpService;
    }

    void resetConfigUrls(List<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (ListUtils.isEmpty(r2) == true) goto L8;
        this.mConfigUrls.clear();
        this.mConfigUrls.addAll(r2);
        return;
    }

    void resetReportUrls(List<String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (ListUtils.isEmpty(r2) == true) goto L8;
        this.mReportUrlList.clear();
        this.mReportUrlList.addAll(r2);
        return;
    }

    private void initConfig() {
        SharedPreferences r0 = getSp();
        String r1 = r0.getString("monitor_net_config", null);
        this.mLastFetchSettingTime = r0.getLong("monitor_configure_refresh_time", 0);
        if (r0.getInt(MonitorConstants.MONITOR_CONFIG_UPDATE, 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        AsyncEventManager.getInstance().addTimeTask(this);
        if (TextUtils.isEmpty(r1) == false) goto L16;
    L14:
        updateConfigFromNet(false);
        return;
    L16:
        this.mConfigExit = true;     // Catch: Exception -> L13
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L13
        if (r2 == true) goto L11;
        r3.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        updateConfig(r3);     // Catch: Exception -> L13
    L13:
        Log.e("monitor_config", "config error");
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    private SharedPreferences getSp() {
        return this.mContext.getSharedPreferences("monitor_config" + this.mAid + MonitorHelper.getShortProcessName(this.mContext), 0);
    }

    void updateConfigFromNet(boolean r5) {
        if (this.mFetchSettingInterval >= 600) goto L5;
        this.mFetchSettingInterval = 600;
    L5:
        if (r5 == true) goto L9;
        if (needUpdateConfigFromNet() == true) goto L9;
        return;
    L9:
        if (MonitorNetUtil.isNetworkAvailable(this.mContext) == true) goto L11;
        return;
    L11:
        monitor-enter(SDKMonitor.class);
        this.mLastFetchSettingTime = System.currentTimeMillis();     // Catch: Throwable -> L16
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L16
        AsyncEventManager.getInstance().post(new AnonymousClass5(this));     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean needUpdateConfigFromNet() {
        if (((System.currentTimeMillis() - this.mLastFetchSettingTime) / 1000) <= this.mFetchSettingInterval) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateToSP(JSONObject r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length() <= 0) goto L14;
        updateConfig(r6.getJSONObject(SlardarConfigConsts.CONFIG_RET));     // Catch: Throwable -> L10
        SharedPreferences.Editor r1 = getSp().edit();     // Catch: Throwable -> L10
        r1.putLong("monitor_configure_refresh_time", System.currentTimeMillis());     // Catch: Throwable -> L10
        r1.putInt(MonitorConstants.MONITOR_CONFIG_UPDATE, 1);     // Catch: Throwable -> L10
        r1.putString("monitor_net_config", r6.getJSONObject(SlardarConfigConsts.CONFIG_RET).toString());     // Catch: Throwable -> L10
        r1.apply();     // Catch: Throwable -> L10
        if (this.mConfigExit == true) goto L15;
        this.mConfigExit = true;     // Catch: Throwable -> L10
        this.mCacheData.handleCacheData(this);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L16:
        return;
    }

    synchronized void updateConfig(JSONObject r9) {
        monitor-enter(this);
        if (r9 != null) goto L75;
        monitor-exit(this);
        return;
    L75:
        JSONObject r0 = JsonUtils.optJSONObject(r9, MonitorConstants.SETTING_GENERAL, MonitorConstants.SETTING_GENERAL_API);     // Catch: Throwable -> L69
        if (r0 == null) goto L53;
        JSONObject r2 = r0.optJSONObject(MonitorConstants.SETTING_GENERAL_API_FETCH);     // Catch: Throwable -> L69
        if (r2 == null) goto L12;
        this.mFetchSettingInterval = r2.optLong(MonitorConstants.SETTING_GENERAL_API_FETCH_INTERVAL, 1200);     // Catch: Throwable -> L69
    L12:
        if (this.mFetchSettingInterval >= 600) goto L15;
        this.mFetchSettingInterval = 600;     // Catch: Throwable -> L69
    L15:
        if (needUpdateConfigFromNet() == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        JSONObject r1 = r0.optJSONObject(MonitorConstants.SETTING_GENERAL_API_REPORT);     // Catch: Throwable -> L69
        if (r1 == null) goto L53;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L69
        JSONArray r4 = r1.optJSONArray(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);     // Catch: Exception -> L72 Throwable -> L69
        if (r4 == null) goto L41;
        if (r4.length() <= 0) goto L41;
        int r5 = r4.length();     // Catch: Exception -> L72 Throwable -> L69
        int r6 = 0;
    L26:
        if (r6 >= r5) goto L41;
        String r7 = r4.getString(r6);     // Catch: Exception -> L72 Throwable -> L69
        if (this.mOversea == false) goto L35;
        if (r7.contains(".snssdk.") == true) goto L33;
        if (r7.contains(".toutiao.") == false) goto L35;
    L33:
        r3.clear();     // Catch: Exception -> L72 Throwable -> L69
    L35:
        if (TextUtils.isEmpty(r7) == true) goto L39;
        if (r7.indexOf(46) <= 0) goto L39;
        r3.add(r7);     // Catch: Exception -> L72 Throwable -> L69
    L39:
        r6 = r6 + 1;
    L41:
        if (r3.isEmpty() == true) goto L43;
        this.mReportUrlList = SDKMonitorUtils.convertReportUrl(r3);     // Catch: Throwable -> L69
    L43:
        int r8 = 120;
        this.mReportInterval = r1.optInt(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_UOLOADING_INTERVAL, 120);     // Catch: Throwable -> L69
        if (this.mReportInterval < 0) goto L47;
        r8 = this.mReportInterval;     // Catch: Throwable -> L69
    L47:
        this.mReportInterval = r8;     // Catch: Throwable -> L69
        int r10 = 100;
        this.mReportCount = r1.optInt(SlardarSettingsConsts.BASE_KEY_ONCE_MAX_COUNT, 100);     // Catch: Throwable -> L69
        if (this.mReportCount < 0) goto L51;
        r10 = this.mReportCount;     // Catch: Throwable -> L69
    L51:
        this.mReportCount = r10;     // Catch: Throwable -> L69
        this.mReportFailRepeatCount = r1.optInt(SlardarSettingsConsts.BASE_KEY_MAX_RETRY_COUNT, 4);     // Catch: Throwable -> L69
        this.mReportFailBaseTime = r1.optInt("report_fail_base_interval", 15);     // Catch: Throwable -> L69
        this.mLogSendSwitch = r1.optInt(SlardarSettingsConsts.BASE_KEY_LOG_SEND_SWITCH, 1);     // Catch: Throwable -> L69
        this.mStopMoreChannelInterval = r1.optLong(SlardarSettingsConsts.BASE_KEY_MORE_CHANNEL_STOP_INTERVAL, MonitorConstants.STOP_MORE_CHANNEL_INTERVAL);     // Catch: Throwable -> L69
        this.mIsEncrypt = r1.optBoolean(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_ENCRYPT, true);     // Catch: Throwable -> L69
        this.mMonitorMaxRowCount = r1.optLong(SlardarSettingsConsts.BASE_MEMORY_STORE_CACHE_MAX_COUNT, 2000);     // Catch: Throwable -> L69
        this.mLogRemoveSwitch = r1.optBoolean(SlardarSettingsConsts.BASE_KEY_LOG_REMOVE_SWITCH, false);     // Catch: Throwable -> L69
    L53:
        if (r9.length() > 0) goto L57;
        this.mReportUrlList = null;     // Catch: Throwable -> L69
        monitor-exit(this);
        return;
    L57:
        JSONObject r11 = r9.optJSONObject(MonitorConstants.SETTING_CUSTOM_EVENT);     // Catch: Throwable -> L69
        if (r11 == null) goto L60;
        this.mAllowService = r11.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);     // Catch: Throwable -> L69
        this.mAllowLogType = r11.optJSONObject("allow_log_type");     // Catch: Throwable -> L69
    L60:
        JSONObject r12 = JsonUtils.optJSONObject(r9, MonitorConstants.SETTING_NETWORK_IMAGE_MODULES, MonitorConstants.SETTING_NETWORK);     // Catch: Throwable -> L69
        if (r12 == null) goto L64;
        this.mDisableReportApiError = r12.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ERROR_UPLOAD, 0);     // Catch: Throwable -> L69
        this.mReportSLA = r12.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ALL_UPLOAD, 0);     // Catch: Throwable -> L69
        this.mBlockReportList = ListUtils.parseList(r12, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);     // Catch: Throwable -> L69
        this.mBlockReportPatterns = ListUtils.parsePatterns(r12, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);     // Catch: Throwable -> L69
        this.mAllowReportList = ListUtils.parseList(r12, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);     // Catch: Throwable -> L69
        this.mAllowReportPatterns = ListUtils.parsePatterns(r12, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);     // Catch: Throwable -> L69
    L64:
        if (this.mLogReportManager != null) goto L66;
        LogReportManager r13 = new LogReportManager(this.mContext, this.mAid);     // Catch: Throwable -> L69
        this.mLogReportManager = r13;     // Catch: Throwable -> L69
        r13.init();     // Catch: Throwable -> L69
    L66:
        this.mLogReportManager.updateConfig();     // Catch: Throwable -> L69
        monitor-exit(this);
        return;
    L69:
        th = move-exception;
        throw th;
    }

    public boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean getLogTypeSwitch(String r3) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    boolean getLogSendSwitch() {
        if (this.mLogSendSwitch == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getNetWorkType() {
        return NetUtils.getNetworkType(this.mContext).getValue();
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r3) {
        if (this.mFetchSettingInterval > 0) goto L5;
        return;
    L5:
        updateConfigFromNet(false);
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean isLogSendSwitch() {
        if (this.mLogSendSwitch == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportInterval() {
        if (this.mReportInterval > 0) goto L7;
        return 120;
    L7:
        return this.mReportInterval;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportCount() {
        if (this.mReportCount > 0) goto L7;
        return 100;
    L7:
        return this.mReportCount;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public List<String> reportUrl(String r1) {
        return this.mReportUrlList;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long getMonitorLogMaxSaveCount() {
        return getMonitorLogMaxSaveCount();
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public JSONObject reportJsonHeaderInfo() {
        return this.mHeaderInfo;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatCount() {
        if (this.mReportFailRepeatCount > 0) goto L7;
        return 4;
    L7:
        return this.mReportFailRepeatCount;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public int reportFailRepeatBaseTime() {
        if (this.mReportFailBaseTime > 0) goto L7;
        return 15;
    L7:
        return this.mReportFailBaseTime;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public long stopMoreChannelInterval() {
        if (this.mStopMoreChannelInterval != 0) goto L7;
        return 1800000;
    L7:
        return this.mStopMoreChannelInterval * 1000;
    }

    @Override // com.bytedance.framwork.core.sdklib.config.IMonitorConfigure
    public boolean getRemoveSwitch() {
        if (this.mLogRemoveNet == false) goto L6;
        return this.mLogRemoveNet;
    L6:
        return this.mLogRemoveSwitch;
    }

    @Override // com.bytedance.framwork.core.sdklib.net.ISendLog
    public NetResponse sendLog(String r5, byte[] r6) {
        NetResponse r0 = new NetResponse();
        String r7 = addParamsToURL(r5).toString();     // Catch: Throwable -> L31
        new HashMap();     // Catch: Throwable -> L31
        if (getHttpService() == null) goto L12;
        HashMap r1 = new HashMap();     // Catch: Throwable -> L31
        byte[] r8 = MonitorNetUtil.compress(r6, r1);     // Catch: Throwable -> L31
        if (this.mIsEncrypt == false) goto L11;
        byte[] r9 = TTEncryptUtils.encrypt(r8, r8.length);     // Catch: Throwable -> L31
        if (r9 == null) goto L10;
        r7 = r7 + "&tt_data=a";     // Catch: Throwable -> L31
        r1.put("Content-Type", "application/octet-stream;tt-data=a");     // Catch: Throwable -> L31
    L10:
        HttpResponse r4 = getHttpService().doPost(r7, r9, r1);     // Catch: Throwable -> L31
        byte[] r10 = r4.getResponseBytes();     // Catch: Throwable -> L31
        Map<String, String> r11 = r4.getHeaders();     // Catch: Throwable -> L31
    L13:
        if (r11 != null) goto L15;
    L17:
        String r12 = null;
    L18:
        r0.stateCode = 200;     // Catch: Throwable -> L31
        JSONObject r13 = new JSONObject(new String(r10));     // Catch: Throwable -> L31
        String r14 = r13.optString("data");     // Catch: Throwable -> L27
        if (r14.isEmpty() == true) goto L25;
        String r15 = DecodeUtils.decodeData(r14.getBytes(), r12);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r15) == true) goto L24;
        r13 = new JSONObject(r15);     // Catch: Throwable -> L27
        goto L25
    L24:
        r13.put("message", "success");     // Catch: Throwable -> L27
    L25:
        r0.responseMsg = r13;     // Catch: Throwable -> L27
    L29:
        r0.responseMsg = r13;     // Catch: Throwable -> L31
        return r0;
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
        goto L29
    L15:
        if (r11.isEmpty() == true) goto L17;
        r12 = r11.get("ran");     // Catch: Throwable -> L31
        goto L18
    L11:
        HttpResponse r16 = getHttpService().doPost(r7, r8, r1);     // Catch: Throwable -> L31
        r10 = r16.getResponseBytes();     // Catch: Throwable -> L31
        r11 = r16.getHeaders();     // Catch: Throwable -> L31
        goto L13
    L12:
        HttpResponse r17 = MonitorNetUtil.excutePost(r7, r6, MonitorNetUtil.CompressType.GZIP, "application/json; charset=utf-8", this.mIsEncrypt);     // Catch: Throwable -> L31
        r10 = r17.getResponseBytes();     // Catch: Throwable -> L31
        r11 = r17.getHeaders();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L35;
        r0.stateCode = th.getStatusCode();
    L36:
        return r0;
    L35:
        r0.stateCode = -1;
        goto L36
    }

    public void setCollectDelay(long r1) {
        this.mLogReportManager.setCollectDelay(r1);
    }

    public void restoreCollectDelay() {
        this.mLogReportManager.restoreCollectDelay();
    }

    public void dropAllData() {
        this.mLogReportManager.dropAllData();
        this.mLogRemoveNet = true;
    }

    public void setStopCollect(boolean r1) {
        this.mMonitorManager.setStopCollect(r1);
    }

    public void deleteAllLogs() {
        this.mMonitorManager.clearBufferQueue();     // Catch: Throwable -> L4
        this.mLogReportManager.deleteAllLogs();     // Catch: Throwable -> L4
        return;
    }

    private StringBuilder addParamsToURL(String r4) {
        StringBuilder r0 = new StringBuilder(r4);
        if (TextUtils.isDigitsOnly(r4) == false) goto L5;
    L20:
        return r0;
    L5:
        if (this.mCommonParams == null) goto L20;
        if (r4.contains("?") == true) goto L10;
        r0.append("?");
    L10:
        appendUrlParam(r0, WsConstants.KEY_SDK_VERSION, String.valueOf(400));
        Map<String, String> r5 = this.mCommonParams;
        if (r5 == null) goto L20;
        if (r5.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, String> r1 = r6.next();
        if (r1.getKey() == null) goto L16;
        appendUrlParam(r0, String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
        goto L16
    }

    private StringBuilder appendUrlParam(StringBuilder r2, String r3, String r4) {
        if (r2.charAt(r2.length() - 1) == '?') goto L5;
        r2.append("&");
    L5:
        r2.append(encode(r3, "UTF-8")).append('=').append(encode(r4, "UTF-8"));
        return r2;
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private void initLogLib() {
        LogLib.init(new AnonymousClass6(this));
    }

    private String getSessionId() {
        IGetExtendParams r0 = this.mIGetExtendParams;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getSessionId();
    }

    public void monitorStatusAndDuration(String r12, int r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(r12, r13, r14, null, null, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, r13, r14, null, null, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorStatusRate(String r2, int r3, JSONObject r4) {
        monitorStatusAndDuration(r2, r3, null, r4);
    }

    public void monitorDuration(String r2, JSONObject r3, JSONObject r4) {
        monitorStatusAndDuration(r2, 0, r3, r4);
    }

    public void monitorEvent(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorStatusAndEvent(String r12, int r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.insertServiceMonitorData(new ServiceMonitorData(r12, r13, null, r14, r15, r16, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r12, r13, null, r14, r15, r16, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void monitorSLA(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.insertApiData(new ApiData("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        AsyncEventManager.getInstance().post(new AnonymousClass7(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void monitorApiError(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.insertApiData(new ApiData("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        AsyncEventManager.getInstance().post(new AnonymousClass8(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void monitorServiceAsync(final String r13, final int r14, final JSONObject r15, final JSONObject r16, final JSONObject r17, final JSONObject r18, final long r19) {
        AsyncEventManager.getInstance().post(new AnonymousClass9(this, r13, r14, r15, r16, r17, r18, r19));
    }

    void monitorService(String r4, int r5, JSONObject r6, JSONObject r7, JSONObject r8, JSONObject r9, long r10) {
        if (r9 == null) goto L23;
    L5:
        r9.put("log_type", "service_monitor");     // Catch: Throwable -> L22
        r9.put("service", r4);     // Catch: Throwable -> L22
        r9.put("status", r5);     // Catch: Throwable -> L22
        r9.put("network_type", getNetWorkType());     // Catch: Throwable -> L22
        r9.put("value", r6);     // Catch: Throwable -> L22
        if (r7 == null) goto L8;
        r9.put("category", r7);     // Catch: Throwable -> L22
    L8:
        if (r8 == null) goto L11;
        r9.put(CommonKey.KEY_METRIC, r8);     // Catch: Throwable -> L22
    L11:
        if (r9.isNull("timestamp") == false) goto L14;
        r9.put("timestamp", r10);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(getSessionId()) == true) goto L17;
        r9.put("session_id", getSessionId());     // Catch: Throwable -> L22
    L17:
        if (this.mMonitorManager != null) goto L19;
        return;
    L19:
        if (getServiceSwitch(r4) == false) goto L26;
        this.mMonitorManager.logSend("service_monitor", "service_monitor", r9);     // Catch: Throwable -> L22
        return;
    L27:
        return;
    L26:
        return;
    L23:
        r9 = new JSONObject();     // Catch: Throwable -> L22
        goto L5
    }

    public void monitorCommonLog(String r4, JSONObject r5) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.insertCommonLogData(new CommonLogData(r4, r5, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorCommonLogAsync(r4, r5, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void flushBuffer() {
        AsyncEventManager.getInstance().post(new AnonymousClass10(this));
    }

    public void flushBuffer(final ICallback r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass11(this, r3));
    }

    public void flushReport() {
        AsyncEventManager.getInstance().post(new AnonymousClass12(this));
    }

    public void flushReport(final ICallback r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass13(this, r3));
    }

    void monitorCommonLogAsync(final String r9, final JSONObject r10, final long r11) {
        AsyncEventManager.getInstance().post(new AnonymousClass14(this, r9, r10, r11));
    }

    void monitorCommonLogInternal(String r5, JSONObject r6, long r7) {
        r6.put("log_type", r5);     // Catch: Throwable -> L15
        r6.put("network_type", getNetWorkType());     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(getSessionId()) == true) goto L7;
        r6.put("session_id", getSessionId());     // Catch: Throwable -> L15
    L7:
        if (r6.isNull("timestamp") == false) goto L10;
        r6.put("timestamp", r7);     // Catch: Throwable -> L15
    L10:
        if (this.mMonitorManager != null) goto L12;
        return;
    L12:
        if (getLogTypeSwitch(r5) == false) goto L19;
        this.mMonitorManager.logSend("common_log", "common_log", r6);     // Catch: Throwable -> L15
        return;
    L19:
        return;
    }

    void handleNetSLA(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (isMatchBlackURI(r18) == false) goto L5;
        return;
    L5:
        if (MonitorNetUtil.isNetworkAvailable(this.mContext) == false) goto L20;
        JSONObject r0 = packLog("api_all", r14, r16, r18, r19, r20, r21);
        combineJson(r0, r22);
        if (r0 == null) goto L12;
        if (isMatchAllowURI(r18) == false) goto L12;
    L16:
        r0.put("hit_rules", 1);     // Catch: JSONException -> L15
        this.mMonitorManager.logSend("api_all", "api_all", r0);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.mReportSLA != 0) goto L16;
        return;
    }

    void handleApiError(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.mDisableReportApiError != 1) goto L5;
        return;
    L5:
        if (isMatchBlackURI(r16) == true) goto L19;
        JSONObject r0 = packLog("api_error", r12, r14, r16, r17, r18, r19);
        combineJson(r0, r20);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length() <= 0) goto L17;
        MonitorManager r1 = this.mMonitorManager;
        if (r1 == null) goto L18;
        r1.logSend("api_error", "api_error", r0);
        return;
    L18:
        return;
    L17:
        return;
    }

    private boolean isMatchAllowURI(String r3) {
        return isMatch(r3, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String r3) {
        return isMatch(r3, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean isMatch(String r3, List<String> r4, List<Pattern> r5) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (ListUtils.isEmpty(r4) == true) goto L23;
        Iterator<String> r2 = r4.iterator();
    L9:
        if (r2.hasNext() == false) goto L23;
        if (r3.contains(r2.next()) == false) goto L9;
        return true;
    L23:
        String r6 = new URI(r3).getPath();     // Catch: Throwable -> L22
        if (ListUtils.isEmpty(r5) == true) goto L21;
        Iterator<Pattern> r7 = r5.iterator();     // Catch: Throwable -> L22
    L17:
        if (r7.hasNext() == false) goto L21;
        if (r7.next().matcher(r6).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    private void combineJson(JSONObject r3, JSONObject r4) {
        if (r3 == null) goto L19;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() <= 0) goto L21;
        Iterator<String> r2 = r4.keys();     // Catch: JSONException -> L12
    L9:
        if (r2.hasNext() == false) goto L22;
        String r0 = r2.next();     // Catch: JSONException -> L12
        r3.put(r0, r4.get(r0));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    private JSONObject packLog(String r4, long r5, long r7, String r9, String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r4) == false) goto L22;
        return null;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put("log_type", r4);     // Catch: Exception -> L21
        r0.put("duration", r5);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r9) == true) goto L9;
        r0.put("uri", Uri.parse(r9));     // Catch: Exception -> L21
    L9:
        if (r7 <= 0) goto L11;
        r0.put("timestamp", r7);     // Catch: Exception -> L21
    L11:
        r0.put("status", r12);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put("ip", r10);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        r0.put("trace_code", r11);     // Catch: Exception -> L21
    L19:
        r0.put("network_type", MonitorNetUtil.getNetworkType(this.mContext).getValue());     // Catch: Exception -> L21
        return r0;
    L18:
        r0.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }
}
