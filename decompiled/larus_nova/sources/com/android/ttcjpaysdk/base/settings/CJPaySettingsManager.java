package com.android.ttcjpaysdk.base.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.CJPayPerformance;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFaceCheckService;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.service.bean.ALogReportConfig;
import com.android.ttcjpaysdk.base.service.bean.ReuseHostDomain;
import com.android.ttcjpaysdk.base.service.bean.WebViewCommonConfig;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.settings.bean.AnnieXCommonConfig;
import com.android.ttcjpaysdk.base.settings.bean.BindCardConfig;
import com.android.ttcjpaysdk.base.settings.bean.BindCardUIConfig;
import com.android.ttcjpaysdk.base.settings.bean.BrandPromotion;
import com.android.ttcjpaysdk.base.settings.bean.CJIDaaSConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPayBalanceRechargeOrWithdrawConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPayEventUploadRules;
import com.android.ttcjpaysdk.base.settings.bean.CJPayFaceVerifyConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPayJhInfoBean;
import com.android.ttcjpaysdk.base.settings.bean.CJPayLoadingConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPayMigrateToLynxSchemas;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.settings.bean.CJPayPerformanceOptConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPaySecurityLoadingConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPaySecurityRiskControl;
import com.android.ttcjpaysdk.base.settings.bean.CJPaySignBizConfig;
import com.android.ttcjpaysdk.base.settings.bean.CJPayXTtTokenInitOptimize;
import com.android.ttcjpaysdk.base.settings.bean.CJPushBean;
import com.android.ttcjpaysdk.base.settings.bean.CJPushDeployInfo;
import com.android.ttcjpaysdk.base.settings.bean.CJPushPayLoad;
import com.android.ttcjpaysdk.base.settings.bean.CJTrackConfig;
import com.android.ttcjpaysdk.base.settings.bean.HalfPageHybridConfig;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.android.ttcjpaysdk.base.settings.bean.JSBConfig;
import com.android.ttcjpaysdk.base.settings.bean.LynxSchemaBean;
import com.android.ttcjpaysdk.base.settings.bean.LynxSchemaParamsConfig;
import com.android.ttcjpaysdk.base.settings.bean.NewContainerConfig;
import com.android.ttcjpaysdk.base.settings.bean.ReportConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJLocalTestService;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJPayDebugSwitchOverrideService;
import com.bytedance.caijing.sdk.infra.base.api.push.CJHostPushService;
import com.bytedance.caijing.sdk.infra.base.api.settings.ISLSettings;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.event.CJServerApiMonitor;
import com.bytedance.caijing.sdk.infra.base.kvstore.CJKvStore;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
public class CJPaySettingsManager {
    private static final String FETCH_TRIGGER_FORM_BYTE_SYNC = "byte_sync";
    private static final String FETCH_TRIGGER_FORM_BYTE_SYNC_UPDATE = "byte_sync_update";
    private static final String FETCH_TRIGGER_FORM_INIT = "init";
    private static final String FILE = "cj_pay_new_settings";
    private static final String LYNX_BINDCARD_URL = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fcj_lynx_cardbind%2Frouter%2Ftemplate.js&hide_loading=1&show_error=1&trans_status_bar=1&type=popup&hide_nav_bar=1&web_bg_color=transparent&width_percent=100&height_percent=100&open_animate=0&mask_alpha=0.1&gravity=center&mask_click_disable=0&top_level=1&host=aweme&engine_type=new&page_name=member_biz&caijing_disable_router_match=1";
    private static final String MOCK_SETTINGS_FILE = "cj_pay_mock_settings";
    private static final String MONITOR_EVENT_SETTINGS_FETCH = "wallet_rd_settings_fetch_result";
    private static final String MONITOR_KEY_ERROR_MSG = "err_msg";
    private static final String MONITOR_KEY_IS_RTS = "is_rts";
    private static final String MONITOR_KEY_SUCCESS = "success";
    private static final String MONITOR_VALUE_FAILURE = "0";
    private static final String MONITOR_VALUE_SUCCESS = "1";
    private static final String SETTINGS_APP_VERSION_NAME = "settings_app_version_name";
    private static final String SETTINGS_FLAG = "settings_flag";
    private static final String SETTINGS_FLAG_VALUE = "true";
    private static final String SETTINGS_LAST_FETCH_SUCCESS = "settings_last_fetch_success";
    private static final String SETTINGS_LAST_VISIT_TIME = "settings_last_visit_time";
    private static final String TAG = "CJPaySettingsManager";
    private static ALogReportConfig aLogReportConfig;
    private static BrandPromotion brandPromotion;
    private static CJIDaaSConfig cjIDaaSConfig;
    private static CJPayBalanceRechargeOrWithdrawConfig cjPayBalanceConfig;
    private static CJPayEventUploadRules cjPayEventUploadRules;
    private static CJPayFaceVerifyConfig cjPayFaceVerifyConfig;
    private static CJPayLoadingConfig cjPayLoadingConfig;
    private static CJPaySecurityLoadingConfig cjPaySecurityLoadingConfig;
    private static CJPayJhInfoBean jhInfo;
    private static CJPayMigrateToLynxSchemas migrateToLynxSchemas;
    private static SharedPreferences mockSettingsRepo;
    private static ReuseHostDomain reuseHostDomain;
    private static CJPayOptimizeSwitch sCJPayOptimizeSwitch;
    private static volatile CJPaySettingsManager sInstance;
    private static CJPayPerformanceOptConfig sPerformanceOptConfig;
    private static SharedPreferences sSharedPreferences;
    private static CJPaySignBizConfig sSignBizConfig;
    private static CJPayXTtTokenInitOptimize sXTtTokenInitOptimize;
    private static CJPaySecurityRiskControl securityRiskControl;
    private static volatile boolean usingRtsSettings;
    private static volatile boolean usingRtsSettingsInit;
    private static WebViewCommonConfig webViewCommonConfig;
    private final AtomicInteger pullRetryCount;
    private final Map<String, String> settingsMap;

    public static class SettingsUpdateMessageEvent extends BaseEvent {
        public JSONObject settings;

        public SettingsUpdateMessageEvent(JSONObject r100) {
            this.settings = r100;
        }
    }

    public JSONObject getAllSettings() {
        String r100 = getInstance().getSettingsInfo("all_settings");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return new JSONObject(r100);
    L7:
        return null;
    }

    public int getFastPayQueryMaxTimes() {
        return new JSONObject(getFastPaySettings()).optInt("query_max_times", 2);
    L5:
        e = move-exception;
        CJLogger.b(TAG, "getFastPayQueryMaxTimes" + e.getMessage());
        return 2;
    }

    public int getFastPayTimeout() {
        return new JSONObject(getFastPaySettings()).optInt("time_out", -1);
    L5:
        e = move-exception;
        CJLogger.b(TAG, e.getMessage());
        return -1;
    }

    public boolean getIsVip() {
        return new JSONObject(getSettingsInfo("vip_tag")).optBoolean("is_vip", false);
    L8:
        return false;
    }

    public JSONArray getJsTrackEventWhiteList() {
        String r100 = getInstance().getSettingsInfo("cj_js_track_event_white_list");     // Catch: JSONException -> L8
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return new JSONArray(r100);
    L8:
        return null;
    }

    public JSONArray getRouteOutWhiteList() {
        String r100 = getInstance().getSettingsInfo("cj_route_out_monitor_white_list");     // Catch: JSONException -> L8
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return new JSONArray(r100);
    L8:
        return null;
    }

    public boolean notFetchMobileDataSwitch() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "794_not_fetch_mobile_data_switch", false);
    L8:
        return false;
    }

    private String getFastPaySettings() {
        return getLatestSettingsInfo("fast_pay");
    }

    public static CJPaySettingsManager getInstance() {
        if (sInstance != null) goto L26;
        monitor-enter(CJPaySettingsManager.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L20;
        sInstance = new CJPaySettingsManager();     // Catch: Throwable -> L22
        if (CJPayHostInfo.applicationContext == null) goto L20;
        sSharedPreferences = CJKvStore.a(FILE);     // Catch: Exception -> L12 Throwable -> L22
    L15:
        if (sInstance.isDebugOrLocalTestEnv() == false) goto L20;
        mockSettingsRepo = CJKvStore.a(MOCK_SETTINGS_FILE);     // Catch: Exception -> L18 Throwable -> L22
    L18:
        e = move-exception;
        CJLogger.b(TAG, "getMockSp failed" + e.getMessage());     // Catch: Throwable -> L22
    L12:
        e = move-exception;
        CJLogger.b(TAG, "getSp failed" + e.getMessage());     // Catch: Throwable -> L22
    L20:
        monitor-exit(CJPaySettingsManager.class);     // Catch: Throwable -> L22
    L26:
        return sInstance;
    }

    private SharedPreferences getSp() {
        if (sSharedPreferences != null) goto L9;
        SharedPreferences r100 = CJKvStore.a(FILE);     // Catch: Exception -> L6
        sSharedPreferences = r100;     // Catch: Exception -> L6
        return r100;
    L6:
        e = move-exception;
        CJLogger.c(TAG, "getSp error", e);
    L9:
        return sSharedPreferences;
    }

    private boolean isDebugOrLocalTestEnv() {
        a.f554342a.getClass();
        CJLocalTestService r100 = (CJLocalTestService) a.a(CJLocalTestService.class);
        if (r100 == null) goto L7;
        if (r100.isAlogDebugEnv() == false) goto L7;
    L8:
        return true;
    L7:
        if (CJEnv.n() == true) goto L8;
        return false;
    }

    private boolean isHitSettingsOpt() {
        a.f554342a.getClass();
        CJHostService r100 = (CJHostService) a.a(CJHostService.class);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isLocalTestChannel() == false) goto L11;
        if (CJKvStore.a("cj_debug_config").getBoolean("settings_local_test_enable_push_opt", false) == true) goto L11;
        return false;
    L11:
        return r100.isSupportSettingsUpdateOpt();
    }

    private void preLoadTrackEventConfig() {
        CJTrackConfig r100 = (CJTrackConfig) getSettingsConfig("cj_track_config", CJTrackConfig.class);
        if (r100 == null) goto L6;
        r100.transform();
        return;
    }

    private void preload() {
        b.c(new AnonymousClass6(this), 0);
    }

    private void updateVisitTime() {
        a.f554342a.getClass();
        final CJHostPushService r100 = (CJHostPushService) a.a(CJHostPushService.class);
        if (r100 != null) goto L5;
    L11:
        visitTimeUpdateTask(5000);
        CJLogger.a(TAG, "updateVisitTime: independent of connection status or connected");
        return;
    L5:
        if (r100.isConnected() == null) goto L11;
        if (Boolean.TRUE.equals(r100.isConnected()) == true) goto L11;
        CJLogger.d(TAG, "updateVisitTime: unconnected, register ws status listener");
        r100.registerOnWsStatusChangedListener(new AnonymousClass4(this, r100));
    }

    public static boolean usingRtsSettings() {
        if (usingRtsSettingsInit == true) goto L15;
        monitor-enter(CJPaySettingsManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (usingRtsSettingsInit == true) goto L9;
        boolean r100 = "1".equals(CJPayABExperimentKeys.getUseRtsSettings().value(true));     // Catch: Throwable -> L11
        usingRtsSettings = r100;     // Catch: Throwable -> L11
        usingRtsSettingsInit = true;     // Catch: Throwable -> L11
        CJLogger.d(TAG, "Rts Related: 初始化 usingRtsSettings=" + r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPaySettingsManager.class);     // Catch: Throwable -> L11
    L15:
        return usingRtsSettings;
    }

    public String blockCarrierForIDaaSAuthPrefetch() {
        return getInstance().getStringConfig("cjpay_degrade_settings", "805_block_carrier_for_idaas_auth_prefetch", "");
    L8:
        return "";
    }

    public String blockPrefetchForIDaaSAuth() {
        return getInstance().getStringConfig("cjpay_degrade_settings", "799_block_prefetch_for_idaas_auth", "");
    L8:
        return "";
    }

    public CJPaySecurityRiskControl fetchSecurityRiskControl() {
        if (securityRiskControl != null) goto L9;
        securityRiskControl = (CJPaySecurityRiskControl) getInstance().getSettingsInfo("cjpay_security_risk_control", CJPaySecurityRiskControl.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        CJLogger.b(TAG, "fetchSecurityRiskControl" + e.getMessage());
    L9:
        return securityRiskControl;
    }

    public ALogReportConfig getALogReportConfig() {
        if (aLogReportConfig != null) goto L11;
        aLogReportConfig = ALogReportConfig.fromJson(getInstance().getSettingsInfo("alog_report_config"));     // Catch: Exception -> L6
    L8:
        if (aLogReportConfig != null) goto L11;
        aLogReportConfig = new ALogReportConfig();
    L11:
        return aLogReportConfig;
    }

    public AnnieXCommonConfig getAnnieXCommonConfig() {
        return (AnnieXCommonConfig) getSettings(AnnieXCommonConfig.class, "anniex_common_config");
    }

    public BindCardConfig getBindCardConfig() {
        return (BindCardConfig) getSettings(BindCardConfig.class, "native_bind_card_config", new BindCardConfig());
    }

    public BrandPromotion getBrandPromotion() {
        if (brandPromotion != null) goto L11;
        brandPromotion = new BrandPromotion();
        brandPromotion = (BrandPromotion) CJPayJsonParser.fromJson(new JSONObject(getABSettings()).optJSONObject("ab_brand_promotion"), BrandPromotion.class);     // Catch: JSONException -> L7
    L9:
        brandPromotion.show_new_loading = true;
    L7:
        e = move-exception;
        CJLogger.b(TAG, "getBrandPromotion" + e.getMessage());
    L11:
        return brandPromotion;
    }

    public CJIDaaSConfig getCJIDaaSConfig() {
        if (cjIDaaSConfig != null) goto L10;
        cjIDaaSConfig = new CJIDaaSConfig();
        cjIDaaSConfig = (CJIDaaSConfig) getInstance().getSettingsInfo("cj_idaas_config", CJIDaaSConfig.class);     // Catch: Exception -> L7
    L8:
        return new CJIDaaSConfig();
    L10:
        return cjIDaaSConfig;
    }

    public CJPayBalanceRechargeOrWithdrawConfig getCJPayBalanceConfig() {
        if (cjPayBalanceConfig != null) goto L10;
        cjPayBalanceConfig = new CJPayBalanceRechargeOrWithdrawConfig();
        cjPayBalanceConfig = (CJPayBalanceRechargeOrWithdrawConfig) getInstance().getSettingsInfo("cjpay_balance_recharge_or_withdraw_config", CJPayBalanceRechargeOrWithdrawConfig.class);     // Catch: Exception -> L7
    L8:
        return new CJPayBalanceRechargeOrWithdrawConfig();
    L10:
        return cjPayBalanceConfig;
    }

    public CJPayEventUploadRules getCJPayEventUploadRules() {
        if (cjPayEventUploadRules != null) goto L10;
        cjPayEventUploadRules = new CJPayEventUploadRules();
        cjPayEventUploadRules = (CJPayEventUploadRules) getInstance().getSettingsInfo("event_upload_rules", CJPayEventUploadRules.class);     // Catch: Exception -> L7
    L8:
        return new CJPayEventUploadRules();
    L10:
        return cjPayEventUploadRules;
    }

    public CJPayFaceVerifyConfig getCJPayFaceVerifyConfig() {
        if (cjPayFaceVerifyConfig != null) goto L10;
        cjPayFaceVerifyConfig = new CJPayFaceVerifyConfig();
        cjPayFaceVerifyConfig = (CJPayFaceVerifyConfig) getInstance().getSettingsInfo("cjpay_face_verify_config", CJPayFaceVerifyConfig.class);     // Catch: Exception -> L7
    L8:
        return new CJPayFaceVerifyConfig();
    L10:
        return cjPayFaceVerifyConfig;
    }

    public CJPayJhInfoBean getCJPayJhInfo() {
        if (jhInfo != null) goto L11;
        jhInfo = new CJPayJhInfoBean();
        jhInfo = (CJPayJhInfoBean) getInstance().getSettingsInfo("cjpay_bindcard_jh_information", CJPayJhInfoBean.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        CJLogger.b(TAG, e.getMessage());
        return new CJPayJhInfoBean();
    L11:
        return jhInfo;
    }

    public CJPayLoadingConfig getCJPayLoadingConfig() {
        if (cjPayLoadingConfig != null) goto L11;
        cjPayLoadingConfig = new CJPayLoadingConfig();
        cjPayLoadingConfig = (CJPayLoadingConfig) getInstance().getSettingsInfo("cjpay_loading_config", CJPayLoadingConfig.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        CJLogger.b(TAG, "getCJPayLoadingConfig" + e.getMessage());
        return new CJPayLoadingConfig();
    L11:
        return cjPayLoadingConfig;
    }

    public CJPayOptimizeSwitch getCJPayOptimizeSwitch() {
        CJPayOptimizeSwitch r100 = sCJPayOptimizeSwitch;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CJPayOptimizeSwitch r101 = (CJPayOptimizeSwitch) getSettingsConfig("cj_optimize_switch", CJPayOptimizeSwitch.class);
        if (r101 != null) goto L8;
        r101 = new CJPayOptimizeSwitch();
    L8:
        sCJPayOptimizeSwitch = r101;
        return r101;
    }

    public CJPayPerformanceOptConfig getCJPayPerformanceOptConfig() {
        CJPayPerformanceOptConfig r100 = sPerformanceOptConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CJPayPerformanceOptConfig r101 = (CJPayPerformanceOptConfig) getSettingsConfig("cj_performance_opt", CJPayPerformanceOptConfig.class);
        if (r101 != null) goto L8;
        r101 = new CJPayPerformanceOptConfig();
    L8:
        sPerformanceOptConfig = r101;
        return r101;
    }

    public CJPaySecurityLoadingConfig getCJPaySecurityLoadingConfig() {
        if (cjPaySecurityLoadingConfig != null) goto L10;
        cjPaySecurityLoadingConfig = new CJPaySecurityLoadingConfig();
        cjPaySecurityLoadingConfig = (CJPaySecurityLoadingConfig) getInstance().getSettingsInfo("cjpay_security_loading_config", CJPaySecurityLoadingConfig.class);     // Catch: Exception -> L7
    L8:
        return new CJPaySecurityLoadingConfig();
    L10:
        return cjPaySecurityLoadingConfig;
    }

    public String getDeviceGroup() {
        return getLatestSettingsInfo("cjpay_device_group");
    }

    public HalfPageHybridConfig getHalfPageHybridConfig() {
        return (HalfPageHybridConfig) getSettings(HalfPageHybridConfig.class, "cjpay_halfpage_hybrid_config");
    }

    public String getHostDomain() {
        return getLatestSettingsInfo("cjpay_host_domain");
    }

    public ReuseHostDomain getHostDomainInfo() {
        if (reuseHostDomain != null) goto L10;
        reuseHostDomain = new ReuseHostDomain();
        reuseHostDomain = ReuseHostDomain.fromJson(getInstance().getSettingsInfo("new_cjpay_host_domain"));     // Catch: Exception -> L7
    L7:
        e = move-exception;
        CJLogger.b(TAG, "getHostDomainInfo" + e.getMessage());
    L10:
        return reuseHostDomain;
    }

    public InsuranceConfiguration getInsuranceConfig() {
        InsuranceConfiguration r100 = new InsuranceConfiguration();
        return (InsuranceConfiguration) CJPayJsonParser.fromJson(new JSONObject(getABSettings()).optJSONObject("ab_account_insurance"), InsuranceConfiguration.class);
    L5:
        e = move-exception;
        CJLogger.b(TAG, "getInsuranceConfig" + e.getMessage());
        return r100;
    }

    public boolean getIsHideOuterBDPayPageLoading() {
        return CJPayPerformanceOptConfig.Companion.get().hideLoading;
    }

    public boolean getIsNotShowFingerPrintDialog() {
        return "false".equals(getInstance().getSettingsInfo("android_fingerprint_dialog"));
    L4:
        e = move-exception;
        CJLogger.c(TAG, "getIsNotShowFingerPrintDialog error", e);
        return false;
    }

    public JSBConfig getJSBConfig() {
        return (JSBConfig) getSettings(JSBConfig.class, "cjpay_jsb_config");
    }

    public JSONObject getLibraConfigFromSettings() {
        JSONObject r100 = new JSONObject();
        return new JSONObject(getABSettingsLibra());
    L5:
        e = move-exception;
        CJLogger.b(TAG, "getLibraConfigFromSettings" + e.getMessage());
        return r100;
    }

    public String getLynxBindcardUrl() {
        return getLatestSettingsInfo("cjpay_lynx_bindcard_url", LYNX_BINDCARD_URL);
    }

    public LynxSchemaBean getLynxSchemaConfig() {
        return (LynxSchemaBean) getSettings(LynxSchemaBean.class, "lynx_schema_config", new LynxSchemaBean());
    }

    public LynxSchemaParamsConfig getLynxSchemaParamsConfig() {
        return (LynxSchemaParamsConfig) getSettings(LynxSchemaParamsConfig.class, "lynx_schema_params_config");
    }

    public CJPayMigrateToLynxSchemas getMigrateToLynxSchemas() {
        if (migrateToLynxSchemas != null) goto L9;
        migrateToLynxSchemas = (CJPayMigrateToLynxSchemas) getInstance().getSettingsInfo("migrate_h5_page_to_lynx", CJPayMigrateToLynxSchemas.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        CJLogger.b(TAG, "getMigrateToLynxSchemas" + e.getMessage());
    L9:
        return migrateToLynxSchemas;
    }

    public SharedPreferences getMockSp() {
        if (sInstance.isDebugOrLocalTestEnv() == true) goto L5;
        return null;
    L5:
        if (mockSettingsRepo != null) goto L11;
        SharedPreferences r100 = CJKvStore.a(MOCK_SETTINGS_FILE);     // Catch: Exception -> L8
        mockSettingsRepo = r100;     // Catch: Exception -> L8
        return r100;
    L8:
        e = move-exception;
        CJLogger.c(TAG, "getMockSp error", e);
    L11:
        return mockSettingsRepo;
    }

    public String getOcrDegradeKeys() {
        return getInstance().getStringConfig("cjpay_degrade_settings", "807_ocr_degrade_keys", "");
    L8:
        return "";
    }

    public ReportConfig getReportConfig() {
        return (ReportConfig) getSettings(ReportConfig.class, "report_config");
    }

    public String getSuperPaySetting() {
        return getLatestSettingsInfo("cjpay_loading_config");
    }

    public String getUploadMediaConfig() {
        return getLatestSettingsInfo("cjpay_upload_media_config", SliceInitService.DEFAULT_SWITCH);
    }

    public WebViewCommonConfig getWebViewCommonConfig() {
        if (webViewCommonConfig != null) goto L10;
        webViewCommonConfig = new WebViewCommonConfig();
        webViewCommonConfig = WebViewCommonConfig.fromJson(getInstance().getSettingsInfo("webview_common_config"));     // Catch: Exception -> L7
    L7:
        e = move-exception;
        CJLogger.b(TAG, "getWebViewCommonConfig" + e.getMessage());
    L10:
        return webViewCommonConfig;
    }

    public CJPaySignBizConfig getsSignBizConfig() {
        CJPaySignBizConfig r100 = sSignBizConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CJPaySignBizConfig r101 = (CJPaySignBizConfig) getSettingsConfig("sign_biz_config", CJPaySignBizConfig.class);
        if (r101 != null) goto L8;
        r101 = new CJPaySignBizConfig();
    L8:
        sSignBizConfig = r101;
        return r101;
    }

    public CJPayXTtTokenInitOptimize getsXTtTokenInitOptimize() {
        CJPayXTtTokenInitOptimize r100 = sXTtTokenInitOptimize;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CJPayXTtTokenInitOptimize r101 = (CJPayXTtTokenInitOptimize) getSettingsConfig("xTtToken_init_optimize", CJPayXTtTokenInitOptimize.class);
        if (r101 != null) goto L8;
        r101 = new CJPayXTtTokenInitOptimize();
    L8:
        sXTtTokenInitOptimize = r101;
        return r101;
    }

    public boolean isCashierLargeScreenAdaptEnabled() {
    L16:
        e = move-exception;
        CJLogger.c(TAG, "isCashierLargeScreenAdaptEnabled error", e);
        return false;
    L4:
        if (CJEnv.n() == false) goto L15;
        a.f554342a.getClass();     // Catch: Exception -> L16
        CJPayDebugSwitchOverrideService r100 = (CJPayDebugSwitchOverrideService) a.a(CJPayDebugSwitchOverrideService.class);     // Catch: Exception -> L16
        if (r100 == null) goto L15;
        int r101 = r100.getCashierLargeScreenAdaptOverrideState();     // Catch: Exception -> L16
        if (r101 != 1) goto L11;
        CJLogger.d(TAG, "isCashierLargeScreenAdaptEnabled local override true");     // Catch: Exception -> L16
        return true;
    L11:
        if (r101 != 0) goto L15;
        CJLogger.d(TAG, "isCashierLargeScreenAdaptEnabled local override false");     // Catch: Exception -> L16
        return false;
    L15:
        return "1".equals(CJPayABExperimentKeys.getCashierLargeScreenAdapt().value(true));
    }

    public boolean isDegradeConfirmExts() {
        return getBooleanConfig("cjpay_degrade_settings", "771_disable_direct_bank_confirm_pass", false);
    }

    public boolean isDegradeForMultiTradeConfirm() {
        return getBooleanConfig("cjpay_degrade_settings", "775_degrade_multi_trade_confirm", false);
    }

    public boolean isDegreeUnifyPayAnim() {
        return getBooleanConfig("cjpay_degrade_settings", "769_degree_unify_spring_anim_imp", false);
    }

    public boolean isNeedForDupPayOpt() {
        return getBooleanConfig("cjpay_degrade_settings", "757_enable_req_deduplicator", false);
    }

    public boolean isNeedTrackClick() {
        return getBooleanConfig("cjpay_degrade_settings", "enable_click_tracker_780", false);
    }

    public ArrayList<String> whiteSuffixesForFintechDomain() {
        ArrayList<String> r100 = new ArrayList();
        JSONArray r101 = getInstance().getJSONArrayConfig("cjpay_degrade_settings", "808_white_suffixes_for_fintech_domain", null);     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
        return r100;
    L6:
        int r102 = 0;
    L8:
        if (r102 >= r101.length()) goto L13;
        String r103 = r101.optString(r102);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r100.add(r103);     // Catch: Throwable -> L14
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        return r100;
    L15:
        return new ArrayList();
    }

    public CJPaySettingsManager() {
        this.pullRetryCount = new AtomicInteger(0);
        this.settingsMap = new ConcurrentHashMap();
    }

    private void clearLocalFlag() {
        setSettingsInfo(SETTINGS_LAST_FETCH_SUCCESS, "true");
        CJSettingsPushManager.INSTANCE.clearLocalFlag();
    }

    private String getABSettingsLibra() {
        return getInstance().getSettingsInfo("ab_settings_libra");
    }

    private boolean hadAppVersionChange() {
        String r100 = getLatestSettingsInfo(SETTINGS_APP_VERSION_NAME);
        String r101 = CJEnv.i();
        if (r100.isEmpty() == false) goto L5;
    L9:
        setSettingsInfo(SETTINGS_APP_VERSION_NAME, r101);
        return true;
    L5:
        if (r100.equals(r101) == false) goto L9;
        return false;
    }

    public static boolean isDegradeCashierRetainComboFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "795_cashier_retain_combo_fix", false);
    }

    private boolean lastFetchFailed() {
        return "false".equals(getLatestSettingsInfo(SETTINGS_LAST_FETCH_SUCCESS));
    }

    private void preLoadFaceVerifyResource() {
        ICJPayFaceCheckService r100 = (ICJPayFaceCheckService) CJPayServiceManager.getInstance().getIService(ICJPayFaceCheckService.class);
        if (r100 == null) goto L8;
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 == null) goto L9;
        r100.preLoadFaceVerifyResource(r101);
        return;
    L9:
        return;
    }

    private static void preLoadSecurityLoadingGif() {
        ICJPaySecurityLoadingService r100 = (ICJPaySecurityLoadingService) CJPayServiceManager.getInstance().getIService(ICJPaySecurityLoadingService.class);
        if (r100 == null) goto L6;
        r100.preLoad(CJPayHostInfo.applicationContext);
        return;
    }

    private void preLoadServerAPiConfig() {
        String r100 = getInstance().getSettingsInfo("cj_server_api_monitor_config");
        Lazy<CJServerApiMonitor> r101 = CJServerApiMonitor.f202312b;
        Intrinsics.checkNotNullParameter(r100, "config");
        int r102 = 0;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L22;
        JSONArray r104 = new JSONObject(r100).optJSONArray("api_info_list");     // Catch: JSONException -> L15
        if (r104 == null) goto L21;
        ArrayList r105 = new ArrayList();     // Catch: JSONException -> L15
        int r106 = r104.length();     // Catch: JSONException -> L15
    L11:
        if (r102 >= r106) goto L13;
        JSONObject r107 = r104.optJSONObject(r102);     // Catch: JSONException -> L15
        r105.add(new CJServerApiMonitor.a(r107.optString("path"), r107.optString("biz_success_code")));     // Catch: JSONException -> L15
        r102 = r102 + 1;     // Catch: JSONException -> L15
        goto L11
    L13:
        CJServerApiMonitor.f202313c = r105;     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJServerApiMonitor#setConfig", e);
        CJLogger.c("CJServerApiMonitor", "setConfig error", e);
        return;
    L22:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public boolean enableFailPageDialogLoading() {
        if (TextUtils.equals(getInstance().getSettingsInfo("cjpay_enable_fail_page_dialog_loading"), "1") == false) goto L12;
        return true;
    L12:
        return false;
    L6:
        e = move-exception;
        CJLogger.b(TAG, "enableFailPageDialogLoading" + e.getMessage());
        return false;
    }

    public void fetchSettingsFromPush() {
        fetchSettingsOpt("newcjpaysdk", FETCH_TRIGGER_FORM_BYTE_SYNC);
    }

    public boolean forbidLocalDefaultDialog() {
        if (TextUtils.equals(getInstance().getSettingsInfo("cjpay_forbid_local_default_dialog"), "1") == false) goto L12;
        return true;
    L12:
        return false;
    L6:
        e = move-exception;
        CJLogger.b(TAG, "forbidLocalDefaultDialog" + e.getMessage());
        return false;
    }

    public String getABSettings() {
        return getInstance().getSettingsInfo("ab_settings");
    }

    public BindCardUIConfig getBindCardUIConfig() {
        BindCardUIConfig r100 = (BindCardUIConfig) getInstance().getSettingsInfo("bind_card_ui_config", BindCardUIConfig.class);     // Catch: Exception -> L4
    L6:
        if (r100 == null) goto L9;
        return r100;
    L9:
        return new BindCardUIConfig();
    L4:
        e = move-exception;
        CJLogger.b(TAG, "getBindCardUIConfig" + e.getMessage());
        r100 = null;
        goto L6
    }

    public long getCarrierAuthCacheValidDuration() {
        return getInstance().getLongConfig("cjpay_carrier_auth_cache_valid_duration", 604800);
    }

    public long getLoadingManualCloseTime() {
        CJPayLoadingConfig r100 = getCJPayLoadingConfig();
        if (r100 == null) goto L8;
        int r101 = r100.loading_manual_close_time_out;
        if (r101 != 0) goto L7;
        return 60000;
    L7:
        return ((long) r101) * 1000;
    L8:
        return 60000;
    }

    public NewContainerConfig getNewContainerConfig() {
        NewContainerConfig r100 = (NewContainerConfig) getInstance().getSettingsInfo("new_container_config", NewContainerConfig.class);     // Catch: Exception -> L4
    L6:
        if (r100 == null) goto L9;
        return r100;
    L9:
        return new NewContainerConfig();
    L4:
        e = move-exception;
        CJLogger.b(TAG, "getNewContainerConfig" + e.getMessage());
        r100 = null;
        goto L6
    }

    public JSONObject getOcrConfig() {
        String r100 = getInstance().getSettingsInfo("cj_ocr_type_config");     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return new JSONObject(r100);
    L7:
        return new JSONObject();
    }

    public long getPiTimeoutValue() {
        return getInstance().getLongConfig("cjpay_intelligence_config", "invoke_js_timeout_duration", -1L);
    }

    public JSONObject getSignRetainConfig() {
        return new JSONObject(getInstance().getSettingsInfo("cjpay_sign_retain_config"));
    L5:
        return new JSONObject();
    }

    public JSONObject getStdListenerAlignDegradeConfig() {
        String r100 = getInstance().getSettingsInfo("cjpay_std_listener_align_degrade_config");     // Catch: Throwable -> L11
        if (r100 == null) goto L10;
        if (r100.isEmpty() == true) goto L10;
        return new JSONObject(r100);
    L10:
        return new JSONObject();
    L12:
        return new JSONObject();
    }

    public JSONObject getUnifyRetainConfig() {
        return new JSONObject(getInstance().getSettingsInfo("cjpay_unify_retain_config"));
    L5:
        return new JSONObject();
    }

    public boolean isCarrierAuthPassThroughDisabled() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "carrier_auth_pass_through_disabled", false);
    }

    public boolean isCarrierAuthPrefetchEnabled() {
        return getInstance().getBooleanConfig("cjpay_carrier_auth_prefetch_enabled", false);
    }

    public boolean isDegradeAliPayErrorCode() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "ali_pay_error_code", false);
    }

    public boolean isDegradeAmountAnim() {
        return getInstance().getBooleanConfig("cjpay_amount_config", "766_not_amount_anim", false);
    }

    public boolean isDegradeAppendPromotionScene() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "783_cjpay_url_add_promotion_degrade", false);
    }

    public boolean isDegradeAssetMetaListReport() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "787_asset_meta_list_degrade", false);
    }

    public boolean isDegradeBindCardFinishEventAlign() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "811_degrade_bind_card_finish_event_align", false);
    }

    public boolean isDegradeBioInfoUpload() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "776_degrade_bio_info_upload", false);
    }

    public boolean isDegradeCJContextListenerLeakFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "807_degrade_cjcontext_listener_leak_fix", false);
    }

    public boolean isDegradeCounterBusinessDesc() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "813_degrade_counter_business_desc", false);
    }

    public boolean isDegradeDialogStyle() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "787_degrade_dialog_style_for_standard", false);
    }

    public boolean isDegradeDialogToastTextOptimization() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "7850_degrade_dialog_toast_text_optimization", false);
    }

    public boolean isDegradeDyPayCoreConfigurationChanged() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "810_dypay_core_configuration_changed_degrade", false);
    }

    public boolean isDegradeExperimentUpload() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "802_not_upload_experiment", false);
    }

    public boolean isDegradeFingerDialogInflate() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "790_degrade_finger_dialog_inflate", false);
    }

    public boolean isDegradeFingerNewLogic() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "771_finger_new", false);
    }

    public boolean isDegradeFixBankCardPointPromotionScenePollution() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "803_degrade_fix_bank_card_point_promotion_scene_pollution", false);
    }

    public boolean isDegradeForAfterPay() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "observe_after_pay", false);
    }

    public boolean isDegradeForAfterPayResultBackPressed() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_after_pay_result_back_pressed", false);
    }

    public boolean isDegradeForAfterPayResultClearStack() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "812_degrade_after_pay_result_clear_stack", false);
    }

    public boolean isDegradeForAntiDialog() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_anti_dialog", false);
    }

    public boolean isDegradeForClientDecisionRetain() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "732_client_decision_retain_wnd", false);
    }

    public boolean isDegradeForClientJsWorker() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "732_client_decision_worker", false);
    }

    public boolean isDegradeForConfirmDialog() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "791_degrade_confirm_dialog", false);
    }

    public boolean isDegradeForConfirmDialogDimLayer() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "797_degrade_confirm_dialog_dim_layer", false);
    }

    public boolean isDegradeForFaceStandardLoading() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "775_face_standard_loading", true);
    }

    public boolean isDegradeForFaceTradeConfirmBack() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "775_face_trade_confirm_back", false);
    }

    public boolean isDegradeForInitBtmSdk() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_init_btm_sdk", false);
    }

    public boolean isDegradeForLayoutPreloadClear() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "796_degrade_layout_preload_clear", false);
    }

    public boolean isDegradeForPayAgainPreNothing() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "772_not_doublecheck_pre_nothing", false);
    }

    public boolean isDegradeForPayAgainTipText() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "payagain_tip_text", false);
    }

    public boolean isDegradeForPreVerifyTypeStrategy() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "815_pre_verify_type_strategy", false);
    }

    public boolean isDegradeForRecordScreenListen() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "789_degrade_record_screen_listen", false);
    }

    public boolean isDegradeForResultPageClearOrder() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "814_degrade_result_page_clear_order", false);
    }

    public boolean isDegradeForSKDefaultShow() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "783_degrade_sku_default_show", false);
    }

    public boolean isDegradeForTagShow() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "tag_show_logic", false);
    }

    public boolean isDegradeGuideWithNoPwdInFace() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "789_guide_with_nopwd_in_face", false);
    }

    public boolean isDegradeH5PayAntiFraudInterception() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "792_h5_pay_anti_fraud_interception", false);
    }

    public boolean isDegradeHeaderUniqueId() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "793_cjpay_ttpay_add_unique_id_to_header_degrade", false);
    }

    public boolean isDegradeIntegratedCounterConfigurationChanged() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "integrated_counter_configuration_changed_degrade", false);
    }

    public boolean isDegradeIntegratedCounterParallelLaunch() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_integrated_counter_parallel_launch", false);
    }

    public boolean isDegradeIntegratedCounterRebuildSuccessRecovery() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_integrated_counter_rebuild_success_recovery", false);
    }

    public boolean isDegradeJSBAPIProcessingCode() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "802_degrade_jsapi_processing_code", false);
    }

    public boolean isDegradeLoadModel() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "799_degrade_model_load", false);
    }

    public boolean isDegradeNativeFromQrcode() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "784_not_native_from_qrcode", false);
    }

    public boolean isDegradeNewStyleCheckBox() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "780_new_style_checkbox", false);
    }

    public boolean isDegradeNoPwdBackIntercept() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "807_no_pwd_back_intercept", false);
    }

    public boolean isDegradeOuterAutoBack() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "807_degrade_outer_auto_back", false);
    }

    public boolean isDegradeOuterCounterRebuildOpt() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "degrade_outer_counter_rebuild_opt", false);
    }

    public boolean isDegradeOuterSignKmpRoute() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "817_degrade_outer_sign_kmp_route", false);
    }

    public boolean isDegradePayAgainMethodSwitchAnimFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "815_degrade_payagain_method_switch_anim_fix", false);
    }

    public boolean isDegradePayAgainRecPopDialogDismissFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "816_degrade_payagain_rec_pop_dialog_dismiss_fix", false);
    }

    public boolean isDegradePayAgainRecommendPopupGradientBackground() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "816_degrade_payagain_recommend_popup_gradient_background", false);
    }

    public boolean isDegradePayTypeTagConstraint() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "784_pay_type_tag_constraint", false);
    }

    public boolean isDegradeRealDirectBank() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "813_degrade_real_direct_bank", false);
    }

    public boolean isDegradeReportClientDisplayAmount() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "789_degrade_report_client_display_amount_in_exts", false);
    }

    public boolean isDegradeShowDialogToast() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "783_degrade_show_dialog_toast", false);
    }

    public boolean isDegradeShowUnifyOutdateDialog() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "751_not_show_unifypay_outdate_dialog", false);
    }

    public boolean isDegradeShowUnifySetVoucher() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "786_unify_asset_view_set_voucher", false);
    }

    public boolean isDegradeSmsCombine() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "753_sms_combine", false);
    }

    public boolean isDegradeStdBankCardPointComboFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "808_degrade_std_bank_card_point_combo_fix", false);
    }

    public boolean isDegradeStdBeforeResultShowListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("before_result_show_listener_degrade", false);
    }

    public boolean isDegradeStdCardSignListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("card_sign_listener_degrade", false);
    }

    public boolean isDegradeStdCashierOpt() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "720_std_cashier_opt", false);
    }

    public boolean isDegradeStdConfirmTerminateGuard() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "std_confirm_terminate_guard_degrade", false);
    }

    public boolean isDegradeStdCreditPayDoubleConfirmAfterRefresh() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "std_credit_pay_double_confirm_after_refresh_degrade", false);
    }

    public boolean isDegradeStdCreditPayListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("credit_pay_listener_degrade", false);
    }

    public boolean isDegradeStdHomePrerender() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "802_std_home_prerender_degrade", false);
    }

    public boolean isDegradeStdHomeRenderPreVerifyFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "std_home_render_pre_verify_fix_degrade", false);
    }

    public boolean isDegradeStdHomeSwitchAnimFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "811_degrade_std_home_switch_anim_fix", false);
    }

    public boolean isDegradeStdIncomePayListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("income_pay_listener_degrade", false);
    }

    public boolean isDegradeStdJumpLynxListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("jump_lynx_listener_degrade", false);
    }

    public boolean isDegradeStdPayNewCardListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("pay_new_card_listener_degrade", false);
    }

    public boolean isDegradeStdPreProcessTradeConfirmHideAmountAndMarketing() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "807_std_preprocess_trade_confirm_hide_amount_marketing_degrade", false);
    }

    public boolean isDegradeStdPwdPanelHeightRelayout() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "810_degrade_std_pwd_panel_height_relayout", false);
    }

    public boolean isDegradeStdStartPayAgainListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("start_pay_again_listener_degrade", false);
    }

    public boolean isDegradeStdVerifyListenerAlign() {
        return getStdListenerAlignDegradeConfig().optBoolean("verify_listener_degrade", false);
    }

    public boolean isDegradeTodyPaySaas() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "817_tody_pay_saas_degrade", false);
    }

    public boolean isDegradeUidEmptyException() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "778_degrade_uid_empty_exception", false);
    }

    public boolean isDegradeUnifyBankSignDoubleVerify() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "784_unify_bank_sign_double_verify", false);
    }

    public boolean isDegradeUnifyExpOpt() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "782_unify_exp_opt", false);
    }

    public boolean isDegradeUnifyFetchOtp() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "756_unify_not_fetch_otp", false);
    }

    public boolean isDegradeUnifyFingerOpenAndPayDialogLargeScreenWidth() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "815_degrade_unify_finger_open_and_pay_dialog_large_screen_width", false);
    }

    public boolean isDegradeUnifyHalfDialog() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "761_unify_half_dialog", false);
    }

    public boolean isDegradeUnifyPayCardListBottomPadding() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "unify_pay_card_list_bottom_padding", false);
    }

    public boolean isDegradeUnifyPayPasswordLayoutAdapt() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "817_degrade_unify_pay_password_layout_adapt", false);
    }

    public boolean isDegradeUnifyRetainVoucher() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "3450_unify_retain_voucher", false);
    }

    public boolean isDegradeUnifySelectMethodSubAssetChooseSyncFix() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "817_degrade_unify_sub_asset_choose_sync_fix", false);
    }

    public boolean isDegradeVerifyPasswordImp() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "788_verify_password_imp", false);
    }

    public boolean isDegradeWifiProxyInfoUpload() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "789_degrade_wifi_proxy_info_upload", false);
    }

    public boolean isDisableDyPayEnterAnim() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "791_disable_dypay_enter_anim", true);
    }

    public boolean isEnableIntegratedCounterParallelLaunch() {
        return "1".equals(CJPayABExperimentKeys.getIntegratedCounterParallelLaunchOpt().value(true));
    }

    public boolean isEnableLeverTwoEncrypt() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "779_enable_unify_ccit", false);
    }

    public boolean isForbidSaasBranchMerge() {
        return getInstance().getBooleanConfig("cjpay_degrade_settings", "751_disable_699_saas_branch_merge", false);
    }

    public boolean isLifecycleGuardEnabled() {
        return TextUtils.equals(getInstance().getSettingsInfo("cjpay_enable_opt_h5paycallback_mem_leak"), "1");
    L4:
        e = move-exception;
        CJLogger.b(TAG, "isLifecycleGuardEnabled " + e.getMessage());
        return false;
    }

    public boolean isLiveComponentContinuePay() {
        return "1".equals(CJPayABExperimentKeys.getLiveComponentContinue().value(true));
    }

    public boolean isShowFingerDialog() {
        if (getIsNotShowFingerPrintDialog() == true) goto L5;
        return true;
    L5:
        if ("1".equals(CJPayABExperimentKeys.getShowFingerprintDialog().value(true)) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ void access$1200() {
        preLoadSecurityLoadingGif();
    }

    public static /* synthetic */ void access$000(CJPaySettingsManager r100) {
        r100.clearLocalFlag();
    }

    public static /* synthetic */ AtomicInteger access$100(CJPaySettingsManager r100) {
        return r100.pullRetryCount;
    }

    public static /* synthetic */ void access$1300(CJPaySettingsManager r100) {
        r100.preLoadFaceVerifyResource();
    }

    public static /* synthetic */ void access$1400(CJPaySettingsManager r100) {
        r100.preLoadServerAPiConfig();
    }

    public static /* synthetic */ void access$800(CJPaySettingsManager r100) {
        r100.preload();
    }

    public static /* synthetic */ void access$900(CJPaySettingsManager r100) {
        r100.preLoadTrackEventConfig();
    }

    private Map<String, String> buildSettingsParams(String r100) {
        HashMap r101 = new HashMap();
        r101.put(Constant.KEY_CALL_NAME, r100);
        r101.put("device_id", CJEnv.c());
        r101.put("app_id", CJEnv.e());
        r101.put("version_code", String.valueOf(CJPayBasicUtils.getAppVersionCode(CJPayHostInfo.applicationContext)));
        r101.put("device_platform", "android");
        r101.put("sdk_version_code", CJPayBasicUtils.getSettingsVersion());
        r101.put("update_version_code", String.valueOf(CJEnv.g()));
        r101.put("os_version", String.valueOf(Build.VERSION.RELEASE));     // Catch: Exception -> L5
    L21:
        r101.put("os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: Exception -> L8
    L9:
        r101.put("device_model", String.valueOf(Build.MODEL));
        r101.put("device_brand", Build.MANUFACTURER.toLowerCase());
        String r102 = getLatestSettingsInfo("settings_time");
    L17:
        r101.put("settings_time", "0");
    L18:
        return r101;
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L13;
    L15:
        r101.put("settings_time", "0");     // Catch: Exception -> L17
    L23:
        goto L18
    L13:
        if (CastLongProtector.parseLong(r102) <= 0) goto L15;
        r101.put("settings_time", r102);     // Catch: Exception -> L17
    L8:
        r101.put("os_api", "0");
    L5:
        r101.put("os_version", "0");
        goto L21
    }

    private String extractErrorMessage(JSONObject r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        String r101 = r100.optString("error");
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        String r102 = r100.optString("message");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return r102;
    L12:
        return r100.toString();
    }

    private String getMockSettings(String r100) {
        if (getMockSp() != null) goto L5;
        return "";
    L5:
        return getMockSp().getString(r100, "");
    }

    private boolean isNeedFetchSettings(String r100) {
        a.f554342a.getClass();
        CJHostService r101 = (CJHostService) a.a(CJHostService.class);
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.isSupportSettingsUpdateOpt() == true) goto L8;
    L32:
        return true;
    L8:
        if (FETCH_TRIGGER_FORM_BYTE_SYNC.equals(r100) == true) goto L32;
        if (lastFetchFailed() == true) goto L32;
        CJSettingsPushManager r102 = CJSettingsPushManager.INSTANCE;
        if (r102.hasPushMsgLose(r101) == true) goto L32;
        if (r102.hasPushNeedHandle() == true) goto L32;
        if (hadAppVersionChange() == true) goto L32;
        boolean r103 = "true".equals(getLatestSettingsInfo(SETTINGS_FLAG));
        String r104 = getLatestSettingsInfo(SETTINGS_LAST_VISIT_TIME);     // Catch: NumberFormatException -> L23
        if (r104.isEmpty() == true) goto L25;
        long r105 = CastLongProtector.parseLong(r104);     // Catch: NumberFormatException -> L23
    L26:
        long r106 = System.currentTimeMillis() - r105;
        if (r103 == false) goto L32;
        if (r106 >= 604800000) goto L32;
        return false;
    L25:
        r105 = 0;
    L23:
        e = move-exception;
        CJLogger.c(TAG, "isNeedFetchSettings error", e);
        goto L25
    }

    private void logSettingsDiff(ArrayList<String> r100) {
        CJLogger.d("settings_diff_keys_" + String.valueOf(CJPayBasicUtils.getAppVersionCode(CJPayHostInfo.applicationContext)), r100.toString());
    }

    private void logSettingsPullResult(Map<String, Object> r100) {
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.n(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_settings_record", r100, null, -1, true);
    }

    private synchronized void parseSettings(JSONObject r100) {
        monitor-enter(this);
        JSONObject r101 = r100.optJSONObject("data");     // Catch: Throwable -> L23
        if (r101 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        JSONObject r102 = r101.optJSONObject("settings");     // Catch: Throwable -> L23
        if (r102 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        SharedPreferences r103 = getSp();     // Catch: Throwable -> L23
        if (r103 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        SharedPreferences.Editor r104 = r103.edit();     // Catch: Throwable -> L23
        r104.putString("settings_time", r101.optString("settings_time", ""));     // Catch: Throwable -> L23
        r104.putString("all_settings", r101.optString("settings"));     // Catch: Throwable -> L23
        Iterator<String> r105 = r102.keys();     // Catch: Throwable -> L23
    L17:
        if (r105.hasNext() == false) goto L21;
        String r106 = r105.next();     // Catch: Throwable -> L23
        Object r107 = r102.opt(r106);     // Catch: Throwable -> L23
        if (r107 == null) goto L17;
        r104.putString(r106, r107.toString());     // Catch: Throwable -> L23
        goto L17
    L21:
        r104.apply();     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        CJLogger.c(TAG, "parseSettings error", th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private void settingsDiff(JSONObject r100) {
        if ("true".equals(getLatestSettingsInfo(SETTINGS_FLAG)) == true) goto L5;
        return;
    L5:
        ArrayList<String> r101 = new ArrayList();
        JSONObject r102 = r100.optJSONObject("data");     // Catch: Throwable -> L19
        if (r102 != null) goto L9;
        return;
    L9:
        JSONObject r103 = r102.optJSONObject("settings");     // Catch: Throwable -> L19
        if (r103 != null) goto L12;
        return;
    L12:
        Iterator<String> r104 = r103.keys();     // Catch: Throwable -> L19
    L14:
        if (r104.hasNext() == false) goto L21;
        String r105 = r104.next();     // Catch: Throwable -> L19
        Object r106 = r103.opt(r105);     // Catch: Throwable -> L19
        if (getLatestSettingsInfo(r105).equals(r106.toString()) == true) goto L14;
        r101.add(r105);     // Catch: Throwable -> L19
    L21:
        int r107 = r101.size();
        if (r107 <= 0) goto L32;
        Collections.sort(r101);
        monitorSettingsDiff(r101, r107);
        logSettingsDiff(r101);
        return;
    L32:
        return;
    L19:
        th = move-exception;
        CJLogger.c(TAG, "settingsDiff error", th);
        goto L21
    }

    private void visitTimeUpdateTask(long r100) {
        b.e(new AnonymousClass5(this), r100);
    }

    public boolean checkIfMocked(String r100) {
        if (getMockSp() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMockSp().contains(r100) == false) goto L7;
        return true;
    }

    public Boolean checkSettingsKeyExit(String r100) {
        if (getLatestSettingsInfo(r100, null) == null) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    public void clearMockSettingsInfo(String r100) {
        if (getMockSp() == null) goto L6;
        getMockSp().edit().remove(r100).apply();
        return;
    }

    public void fetchNewSettings(String r100) {
        CJPayPerformance.getInstance().initByModule(BuildConfig.LIBRARY_PACKAGE_NAME);
        updateVisitTime();
        if (isHitSettingsOpt() == false) goto L5;
        CJLogger.d(TAG, "命中settings优化");
        fetchSettingsOpt(r100, "init");
        return;
    L5:
        CJLogger.d(TAG, "未命中settings优化");
        fetchSettings(r100, "init", null);
    }

    public String getLatestSettingsInfo(String r100) {
        return getLatestSettingsInfo(r100, "");
    }

    public synchronized String getSettingsInfo(String r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (isDebugOrLocalTestEnv() == false) goto L11;
        if (checkIfMocked(r100) == false) goto L11;
        String r101 = getMockSettings(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r101;
    L11:
        if (this.settingsMap.containsKey(r100) == false) goto L15;
        String r102 = this.settingsMap.get(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r102;
    L15:
        String r103 = getSettingsInfoFromSp(r100, "");     // Catch: Throwable -> L18
        this.settingsMap.put(r100, r103);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r103;
    }

    public boolean isDegreeVibrationCase(String r100) {
        JSONArray r101 = getJSONArrayConfig("cjpay_degrade_settings", "disable_vibration_list", null);
        if (r101 == null) goto L14;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L14;
        String r103 = r101.optString(r102);
        if (r103 == null) goto L13;
        if (r103.equals(r100) == false) goto L13;
        return true;
    L13:
        r102 = r102 + 1;
    L14:
        return false;
    }

    public boolean isLynxActivityPadAdaptPath(String r100) {
        if (isCashierLargeScreenAdaptEnabled() == true) goto L7;
        CJLogger.d(TAG, "isLynxActivityPadAdaptPath experiment disabled");
        return false;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L39;
        CJLogger.d(TAG, "isLynxActivityPadAdaptPath path empty");
        return false;
    L39:
    L36:
        th = move-exception;
        CJLogger.c(TAG, "isLynxActivityPadAdaptPath error", th);
    L38:
        return false;
    L11:
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L13;
        r100 = r100.substring(1);     // Catch: Throwable -> L36
    L13:
        String r101 = getSettingsInfo("lynx_activity_pad_adapt");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r101) == false) goto L17;
        CJLogger.d(TAG, "isLynxActivityPadAdaptPath config empty, path=" + r100);     // Catch: Throwable -> L36
        return false;
    L17:
        JSONArray r102 = new JSONArray(r101);     // Catch: Throwable -> L36
        int r103 = 0;
    L19:
        if (r103 >= r102.length()) goto L34;
        String r104 = r102.optString(r103).trim();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r104) == false) goto L24;
    L31:
        r103 = r103 + 1;     // Catch: Throwable -> L36
        goto L19
    L24:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L27;
        r104 = r104.substring(1);     // Catch: Throwable -> L36
    L27:
        if (r100.equals(r104) == true) goto L32;
        if (r100.endsWith(HTTP.URL_DEFAULT + r104) == false) goto L31;
    L32:
        CJLogger.d(TAG, "isLynxActivityPadAdaptPath hit path=" + r100 + ", configPath=" + r104);     // Catch: Throwable -> L36
        return true;
    L34:
        CJLogger.d(TAG, "isLynxActivityPadAdaptPath miss path=" + r100);     // Catch: Throwable -> L36
        goto L38
    }

    public void updateSettingsFromPush(CJPushBean r100) {
        if (r100 == null) goto L30;
        CJPushPayLoad r101 = r100.payload;
        if (r101 == null) goto L31;
        JSONObject r102 = r101.data;
        if (r102 != null) goto L25;
        return;
    L25:
        HashMap r103 = new HashMap();     // Catch: Throwable -> L22
        r103.put("trigger_from", FETCH_TRIGGER_FORM_BYTE_SYNC_UPDATE);     // Catch: Throwable -> L22
        r103.put("push", 2);     // Catch: Throwable -> L22
        r103.put("item_id", Long.valueOf(r100.payload.item_id));     // Catch: Throwable -> L22
        r103.put("deploy_id", Long.valueOf(r100.payload.deploy_id));     // Catch: Throwable -> L22
        logSettingsPullResult(r103);     // Catch: Throwable -> L22
        SharedPreferences r104 = getSp();     // Catch: Throwable -> L22
        if (r104 != null) goto L13;
        return;
    L13:
        SharedPreferences.Editor r105 = r104.edit();     // Catch: Throwable -> L22
        Iterator<String> r106 = r102.keys();     // Catch: Throwable -> L22
    L15:
        if (r106.hasNext() == false) goto L20;
        String r107 = r106.next();     // Catch: Throwable -> L22
        Object r108 = r102.opt(r107);     // Catch: Throwable -> L22
        if (r108 == null) goto L19;
        r105.putString(r107, r108.toString());     // Catch: Throwable -> L22
    L19:
        CJLogger.d(TAG, "updateFromPush key=" + r107);     // Catch: Throwable -> L22
        goto L15
    L20:
        r105.apply();     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        CJLogger.c(TAG, "updateSettingsFromPush error", th);
        return;
    L31:
        return;
    }

    public static /* synthetic */ void access$1100(CJPaySettingsManager r100, long r101) {
        r100.visitTimeUpdateTask(r101);
    }

    public static /* synthetic */ void access$400(CJPaySettingsManager r100, JSONObject r101) {
        r100.settingsDiff(r101);
    }

    public static /* synthetic */ void access$500(CJPaySettingsManager r100, JSONObject r101) {
        r100.parseSettings(r101);
    }

    private void fetchSettingsOpt(final String r100, final String r101) {
        CJLogger.d(TAG, "触发settings拉取，triggerForm=" + r101);
        if (isNeedFetchSettings(r101) == false) goto L5;
        ICJPayCallback r102 = new AnonymousClass1(this, r100, r101);
        setSettingsInfo(SETTINGS_LAST_FETCH_SUCCESS, "false");
        fetchSettings(r100, r101, r102);
        return;
    L5:
        if ("init".equals(r101) == false) goto L7;
        preload();
    L7:
        CJLogger.d(TAG, "settings不需要更新");
    }

    private <T extends CJPayObject> T getSettingsConfig(String r100, Class<T> r101) {
        String r102 = getInstance().getSettingsInfo(r100);     // Catch: Exception -> L6
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return (T) CJPayJsonParser.fromJson(new JSONObject(r102), r101);
    L12:
        return null;
    L6:
        e = move-exception;
        CJLogger.d(TAG, "get setting config fail: " + Log.getStackTraceString(e));
        return null;
    }

    private synchronized String getSettingsInfoFromSp(String r100, String r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (getSp() == null) goto L6;
        r101 = getSp().getString(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    }

    private void monitorSettingsDiff(ArrayList<String> r100, int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r102.put("newcjpaysdk_settings_diff_keys", r100.toString());     // Catch: Exception -> L4
        r103.put("newcjpaysdk_settings_diff_count", r101);     // Catch: Exception -> L4
        CJPayCallBackCenter.getInstance().onMonitor("settings_diff_monitor", r102, r103, new JSONObject());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CJLogger.c(TAG, "monitorSettingsDiff error", e);
    }

    private void reportSettingsFetchEvent(boolean r100, JSONObject r101) {
        HashMap r102 = new HashMap();     // Catch: Throwable -> L13
        String r103 = "1";
        if (r100 == false) goto L6;
        Object r104 = "1";
    L7:
        r102.put("success", r104);     // Catch: Throwable -> L13
        r102.put("err_msg", extractErrorMessage(r101));     // Catch: Throwable -> L13
        if (usingRtsSettings() == true) goto L11;
        r103 = "0";
    L11:
        r102.put(MONITOR_KEY_IS_RTS, r103);     // Catch: Throwable -> L13
        CJReporter r105 = CJReporter.f202294a;     // Catch: Throwable -> L13
        CJReporter.g(CJPayCallBackCenter.getInstance().getCjContext(), MONITOR_EVENT_SETTINGS_FETCH, r102, null, -1, false);     // Catch: Throwable -> L13
        return;
    L6:
        r104 = "0";
    L13:
        th = move-exception;
        CJLogger.c(TAG, "Failed to report settings fetch event", th);
    }

    private synchronized void setSettingsInfo(String r100, String r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (getSp() == null) goto L6;
        getSp().edit().putString(r100, r101).apply();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private boolean tryFetchSettingsWithRTS(String r100, final ICJPayCallback r101) {
        if (usingRtsSettings() == true) goto L5;
        return false;
    L5:
        a.f554342a.getClass();
        ISLSettings r102 = (ISLSettings) a.a(ISLSettings.class);
        if (r102 != null) goto L9;
        CJLogger.e(TAG, "ISLSettings 服务未找到，降级到原有网络请求");
        return false;
    L9:
        CJLogger.d(TAG, "使用 RTS Settings 获取配置");
        r102.fetchSettingsV2(buildSettingsParams(r100), new AnonymousClass3(this, r101));
        return true;
    }

    public boolean getBooleanConfig(String r100, boolean r101) {
        String r102 = getInstance().getSettingsInfo(r100);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return r101;
    L6:
        if ("1".equals(r102) == false) goto L8;
        return true;
    L8:
        if ("true".equalsIgnoreCase(r102) == false) goto L11;
        return true;
    L11:
        if ("0".equals(r102) == true) goto L14;
        if ("false".equalsIgnoreCase(r102) == false) goto L18;
        return false;
    L14:
        return false;
    L18:
        return r101;
    }

    public String getLatestSettingsInfo(String r100, String r101) {
        if (isDebugOrLocalTestEnv() == false) goto L9;
        if (checkIfMocked(r100) == false) goto L9;
        return getMockSettings(r100);
    L9:
        return getSettingsInfoFromSp(r100, r101);
    }

    public long getLongConfig(String r100, long r101) {
        String r102 = getInstance().getSettingsInfo(r100);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return r101;
    L5:
        return CastLongProtector.parseLong(r102.trim());
    L7:
        return r101;
    }

    public Map<String, String> getMapConfig(String r100, Map<String, String> r101) {
        JSONObject r102 = new JSONObject(getInstance().getSettingsInfo(r100));     // Catch: JSONException -> L12
        HashMap r103 = new HashMap();     // Catch: JSONException -> L12
        Iterator<String> r104 = r102.keys();     // Catch: JSONException -> L12
    L3:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();     // Catch: JSONException -> L12
        Object r106 = r102.opt(r105);     // Catch: JSONException -> L12
        if (r106 != null) goto L8;
        String r107 = "";
    L9:
        r103.put(r105, r107);     // Catch: JSONException -> L12
        goto L3
    L8:
        r107 = r106.toString();     // Catch: JSONException -> L12
        goto L9
    L11:
        return r103;
    L12:
        return r101;
    }

    public <T extends CJPayObject> T getSettings(Class<T> r100, String r101) {
        return (T) getSettings(r100, r101, null);
    }

    public <T extends CJPayObject> T getSettingsInfo(String r100, Class<T> r101) {
        return (T) CJPayJsonParser.fromJson(getInstance().getSettingsInfo(r100), r101);
    }

    public void mockSettingsInfo(String r100, String r101) {
        if (getMockSp() == null) goto L6;
        getMockSp().edit().putString(r100, r101).apply();
        return;
    }

    public static /* synthetic */ void access$200(CJPaySettingsManager r100, String r101, String r102) {
        r100.fetchSettingsOpt(r101, r102);
    }

    public static /* synthetic */ void access$300(CJPaySettingsManager r100, boolean r101, JSONObject r102) {
        r100.reportSettingsFetchEvent(r101, r102);
    }

    public static /* synthetic */ void access$600(CJPaySettingsManager r100, String r101, String r102) {
        r100.setSettingsInfo(r101, r102);
    }

    private void fetchSettings(String r110, final String r111, final ICJPayCallback r112) {
        StringBuffer r100 = new StringBuffer("https://is.snssdk.com/service/settings/v3/?");
        setParameter(r100, Constant.KEY_CALL_NAME, r110);
        setParameter(r100, "device_id", CJEnv.c());
        setParameter(r100, "app_id", CJEnv.e());
        setParameter(r100, "version_code", String.valueOf(CJPayBasicUtils.getAppVersionCode(CJPayHostInfo.applicationContext)));
        setParameter(r100, "device_platform", "android");
        setParameter(r100, "sdk_version_code", CJPayBasicUtils.getSettingsVersion());
        setParameter(r100, "update_version_code", String.valueOf(CJEnv.g()));
        setParameter(r100, "os_version", String.valueOf(Build.VERSION.RELEASE));     // Catch: Exception -> L5
    L30:
        setParameter(r100, "os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: Exception -> L8
    L9:
        setParameter(r100, "device_model", String.valueOf(Build.MODEL));
        setParameter(r100, "device_brand", Build.MANUFACTURER.toLowerCase());
        String r101 = getLatestSettingsInfo("settings_time");
    L17:
        setParameter(r100, "settings_time", "0");
    L18:
        final long r102 = System.currentTimeMillis();
        ICJPayCallback r103 = new AnonymousClass2(this, r112, r111, r102);
        if (tryFetchSettingsWithRTS(r110, r103) == false) goto L21;
        return;
    L21:
        HashMap r104 = new HashMap();
        a.f554342a.getClass();
        CJHostService r105 = (CJHostService) a.a(CJHostService.class);
        if (r105 == null) goto L26;
        Pair<String, String> r106 = r105.getHostSettingsTag();
        if (r106 == null) goto L26;
        r104.put((String) r106.first, (String) r106.second);
    L26:
        CJPayNetworkManager.get(r100.toString(), r104, r103, false);
        return;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
    L15:
        setParameter(r100, "settings_time", "0");     // Catch: Exception -> L17
    L32:
        goto L18
    L13:
        if (CastLongProtector.parseLong(r101) <= 0) goto L15;
        setParameter(r100, "settings_time", r101);     // Catch: Exception -> L17
    L8:
        setParameter(r100, "os_api", "0");
    L5:
        setParameter(r100, "os_version", "0");
        goto L30
    }

    private void handleRTSSettingsResponse(Map<String, Object> r100, String r101, ICJPayCallback r102) {
        if (r101 != null) goto L20;
    L9:
        if (r100 == null) goto L11;
        r102.onResponse(new JSONObject(r100.toString()));     // Catch: Exception -> L7
    L19:
        return;
    L7:
        e = move-exception;
        CJLogger.c(TAG, "RTS Settings 回调处理错误", e);
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L16
        r103.put("error", "RTS Settings callback processing error: " + e.getMessage());     // Catch: Exception -> L16
        r102.onFailure(r103);     // Catch: Exception -> L16
        return;
    L23:
        return;
    L11:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L7
        r104.put("error", "Empty response from RTS Settings");     // Catch: Exception -> L7
        r102.onFailure(r104);     // Catch: Exception -> L7
        goto L19
    L20:
        if (r101.isEmpty() == true) goto L9;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L7
        r105.put("error", r101);     // Catch: Exception -> L7
        r102.onFailure(r105);     // Catch: Exception -> L7
        goto L19
    }

    private void logSettingsPullResult(boolean r100, String r101, long r102) {
        HashMap r103 = new HashMap();     // Catch: Throwable -> L28
        if (r100 == false) goto L6;
        int r104 = 1;
    L7:
        r103.put("success", Integer.valueOf(r104));     // Catch: Throwable -> L28
        r103.put("settings_time", getLatestSettingsInfo("settings_time"));     // Catch: Throwable -> L28
        r103.put("trigger_from", r101);     // Catch: Throwable -> L28
        if (FETCH_TRIGGER_FORM_BYTE_SYNC.equals(r101) == false) goto L11;
        r103.put("push", 1);     // Catch: Throwable -> L28
    L12:
        if (r100 == false) goto L15;
    L18:
        if (r100 == false) goto L26;
        ArrayList<CJPushDeployInfo> r105 = CJSettingsPushManager.INSTANCE.getAndConsumeDeployList(r102);     // Catch: Throwable -> L28
        Iterator<CJPushDeployInfo> r106 = r105.iterator();     // Catch: Throwable -> L28
    L21:
        if (r106.hasNext() == false) goto L24;
        CJPushDeployInfo r107 = r106.next();     // Catch: Throwable -> L28
        r103.put("item_id", Long.valueOf(r107.itemId));     // Catch: Throwable -> L28
        r103.put("deploy_id", Long.valueOf(r107.deployId));     // Catch: Throwable -> L28
        logSettingsPullResult(r103);     // Catch: Throwable -> L28
        goto L21
    L24:
        if (r105.isEmpty() == false) goto L33;
        logSettingsPullResult(r103);     // Catch: Throwable -> L28
        return;
    L33:
        return;
    L26:
        logSettingsPullResult(r103);     // Catch: Throwable -> L28
        return;
    L15:
        if ("true".equals(getLatestSettingsInfo(SETTINGS_FLAG)) == false) goto L17;
        r103.put(LocationMonitorConst.IS_CACHE, "1");     // Catch: Throwable -> L28
        goto L18
    L17:
        r103.put(LocationMonitorConst.IS_CACHE, "0");     // Catch: Throwable -> L28
        goto L18
    L11:
        r103.put("push", 0);     // Catch: Throwable -> L28
        goto L12
    L6:
        r104 = 0;
    L28:
        th = move-exception;
        CJLogger.c(TAG, "logSettingsPullResult error", th);
    }

    private void setParameter(StringBuffer r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.append("&");
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102);
    }

    public boolean getBooleanConfig(String r100, String r101, boolean r102) {
        return new JSONObject(getInstance().getSettingsInfo(r100)).optBoolean(r101, r102);
    L4:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getConfigEnhanced(String r100, T r101, boolean r110) {
        if (r100.contains(".") == false) goto L6;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L158
        String r103 = r102[0];     // Catch: Exception -> L158
        if (r110 == false) goto L78;
        String r111 = getSettingsInfo(r103);     // Catch: Exception -> L158
    L80:
        if (TextUtils.isEmpty(r111) == false) goto L82;
        return r101;
    L82:
        T r104 = (T) new JSONObject(r111);
        int r112 = 1;
    L84:
        if (r112 >= r102.length) goto L89;
        String r105 = r102[r112];     // Catch: Exception -> L158
        if ((r104 instanceof JSONObject) == false) goto L88;
        r104 = (T) ((JSONObject) r104).opt(r105);
        r112 = r112 + 1;     // Catch: Exception -> L158
        goto L84
    L88:
        return r101;
    L89:
        if (r104 == null) goto L156;
        if (JSONObject.NULL.equals(r104) == true) goto L156;
        if ((r101 instanceof String) == false) goto L105;
        if ((r104 instanceof JSONObject) == true) goto L103;
        if ((r104 instanceof JSONArray) == true) goto L103;
        return (T) String.valueOf(r104);
    L103:
        return (T) r104.toString();
    L105:
        if ((r101 instanceof Number) == false) goto L125;
        String r106 = String.valueOf(r104);     // Catch: Exception -> L158
        if ((r101 instanceof Integer) == false) goto L112;
        return (T) Integer.valueOf((int) CastDoubleProtector.parseDouble(r106));
    L112:
        if ((r101 instanceof Long) == false) goto L116;
        return (T) Long.valueOf((long) CastDoubleProtector.parseDouble(r106));
    L116:
        if ((r101 instanceof Double) == false) goto L120;
        return (T) Double.valueOf(CastDoubleProtector.parseDouble(r106));
    L120:
        if ((r101 instanceof Float) == false) goto L123;
        return (T) Float.valueOf(CastFloatProtector.parseFloat(r106));
    L123:
        return r101;
    L125:
        if ((r101 instanceof Boolean) == false) goto L145;
        if ((r104 instanceof Boolean) == false) goto L129;
        return r104;
    L129:
        String r107 = String.valueOf(r104);     // Catch: Exception -> L158
        if ("1".equals(r107) == true) goto L143;
        if ("true".equalsIgnoreCase(r107) == true) goto L143;
        if ("0".equals(r107) == true) goto L141;
        if ("false".equalsIgnoreCase(r107) == true) goto L141;
        return r101;
    L141:
        return (T) Boolean.FALSE;
    L143:
        return (T) Boolean.TRUE;
    L145:
        if ((r101 instanceof JSONObject) == false) goto L150;
        if ((r104 instanceof JSONObject) == false) goto L150;
        return r104;
    L150:
        if ((r101 instanceof CJPayObject) == true) goto L152;
    L155:
        return r104;
    L152:
        if ((r104 instanceof JSONObject) == false) goto L155;
        return (T) CJPayJsonParser.fromJson((JSONObject) r104, ((CJPayObject) r101).getClass());
    L78:
        r111 = getLatestSettingsInfo(r103, "");     // Catch: Exception -> L158
        goto L80
    L6:
        if ((r101 instanceof String) == false) goto L16;
        if (r110 == false) goto L9;
        String r108 = getSettingsInfo(r100);     // Catch: Exception -> L158
    L11:
        if (TextUtils.isEmpty(r108) == false) goto L14;
        return r101;
    L14:
        return (T) r108;
    L9:
        r108 = getLatestSettingsInfo(r100, (String) r101);     // Catch: Exception -> L158
        goto L11
    L16:
        if ((r101 instanceof Number) == false) goto L41;
        if (r110 == false) goto L19;
        String r109 = getSettingsInfo(r100);     // Catch: Exception -> L158
    L21:
        if (TextUtils.isEmpty(r109) == false) goto L161;
        return r101;
    L161:
    L39:
        return r101;
    L24:
        if ((r101 instanceof Integer) == false) goto L28;
        return (T) Integer.valueOf((int) CastDoubleProtector.parseDouble(r109));
    L28:
        if ((r101 instanceof Long) == false) goto L32;
        return (T) Long.valueOf((long) CastDoubleProtector.parseDouble(r109));
    L32:
        if ((r101 instanceof Double) == false) goto L36;
        return (T) Double.valueOf(CastDoubleProtector.parseDouble(r109));
    L36:
        if ((r101 instanceof Float) == true) goto L38;
    L60:
        if (r110 == false) goto L62;
        String r113 = getSettingsInfo(r100);     // Catch: Exception -> L158
    L64:
        if (TextUtils.isEmpty(r113) == false) goto L67;
        return r101;
    L67:
        if ((r101 instanceof JSONObject) == false) goto L71;
        return (T) new JSONObject(r113);
    L71:
        if ((r101 instanceof CJPayObject) == true) goto L73;
        return r101;
    L73:
        return (T) CJPayJsonParser.fromJson(r113, ((CJPayObject) r101).getClass());
    L62:
        r113 = getLatestSettingsInfo(r100, "");     // Catch: Exception -> L158
        goto L64
    L38:
        return (T) Float.valueOf(CastFloatProtector.parseFloat(r109));
    L19:
        r109 = getLatestSettingsInfo(r100, String.valueOf(r101));     // Catch: Exception -> L158
        goto L21
    L41:
        if ((r101 instanceof Boolean) == false) goto L60;
        if (r110 == true) goto L44;
        String r114 = getLatestSettingsInfo(r100, String.valueOf(r101));     // Catch: Exception -> L158
        if ("1".equals(r114) == true) goto L59;
        if ("true".equalsIgnoreCase(r114) == true) goto L59;
        if ("0".equals(r114) == true) goto L57;
        if ("false".equalsIgnoreCase(r114) == true) goto L57;
        return r101;
    L57:
        return (T) Boolean.FALSE;
    L59:
        return (T) Boolean.TRUE;
    L44:
        return (T) Boolean.valueOf(getBooleanConfig(r100, ((Boolean) r101).booleanValue()));
    L156:
        return r101;
    }

    public JSONArray getJSONArrayConfig(String r100, String r101, JSONArray r102) {
        return new JSONObject(getInstance().getSettingsInfo(r100)).optJSONArray(r101);
    L4:
        return r102;
    }

    public long getLongConfig(String r100, String r101, Long r102) {
        return new JSONObject(getInstance().getSettingsInfo(r100)).optLong(r101, r102.longValue());
    L5:
        return r102.longValue();
    }

    public <T extends CJPayObject> T getSettings(Class<T> r100, String r101, T r102) {
        return (T) CJPayJsonParser.fromJson(new JSONObject(getLatestSettingsInfo(r101, SliceInitService.DEFAULT_SWITCH)), r100);
    L4:
        e = move-exception;
        CJLogger.b(TAG, e.getMessage());
        return r102;
    }

    public String getStringConfig(String r100, String r101, String r102) {
        return new JSONObject(getInstance().getSettingsInfo(r100)).optString(r101, r102);
    L4:
        return r102;
    }

    public static /* synthetic */ void access$1000(CJPaySettingsManager r100, Map r101, String r102, ICJPayCallback r103) {
        r100.handleRTSSettingsResponse(r101, r102, r103);
    }

    public static /* synthetic */ void access$700(CJPaySettingsManager r100, boolean r101, String r102, long r103) {
        r100.logSettingsPullResult(r101, r102, r103);
    }
}
