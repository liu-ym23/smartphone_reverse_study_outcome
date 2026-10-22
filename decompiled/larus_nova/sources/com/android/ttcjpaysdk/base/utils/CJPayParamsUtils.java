package com.android.ttcjpaysdk.base.utils;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.u.i;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.SourceManager;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySettingService;
import com.android.ttcjpaysdk.base.service.bean.ReuseHostDomain;
import com.android.ttcjpaysdk.base.service.bean.WebViewCommonConfig;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.keyframes.model.KFImage;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.ttvideoengine.model.SubInfo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayParamsUtils {
    private static final AtomicLong UNIQUE_ID_COUNTER = null;

    /* JADX INFO: loaded from: classes28.dex */
    public static final enum HostAPI extends Enum<HostAPI> {
        private static final /* synthetic */ HostAPI[] $VALUES = null;
        public static final HostAPI BDPAY = null;
        public static final HostAPI INTEGRATED = null;

        private static /* synthetic */ HostAPI[] $values() {
            return new HostAPI[]{INTEGRATED, BDPAY};
        }

        static {
            INTEGRATED = new HostAPI("INTEGRATED", 0);
            BDPAY = new HostAPI("BDPAY", 1);
            $VALUES = $values();
        }

        public static HostAPI[] values() {
            return (HostAPI[]) $VALUES.clone();
        }

        public static HostAPI valueOf(String r100) {
            return (HostAPI) a.a(HostAPI.class, r100);
        }

        private HostAPI(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CJPayParamsUtils() {
    }

    static {
        UNIQUE_ID_COUNTER = new AtomicLong();
    }

    public static JSONObject buildDevInfoParams() {
        String r100 = "1";
        JSONObject r101 = new JSONObject();
        r101.put("os", "android");     // Catch: JSONException -> L15
        r101.put("is_h5", false);     // Catch: JSONException -> L15
        r101.put("cj_sdk_version", CJPayBasicUtils.getRealVersion());     // Catch: JSONException -> L15
        r101.put("cj_sdk_plugin_version", CJPayBasicUtils.getVersionName());     // Catch: JSONException -> L15
        r101.put("cj_sdk_plugin_version_code", CJPayBasicUtils.getSDKVersionCode());     // Catch: JSONException -> L15
        r101.put("cj_host_plugin_version_code", CJPayBasicUtils.getPluginVerCodeHost());     // Catch: JSONException -> L15
        r101.put("aid", CJEnv.e());     // Catch: JSONException -> L15
        r101.put(BaseHttpRequestInfo.KEY_USER_AGENT, CJPayBasicUtils.getUA(CJPayHostInfo.applicationContext));     // Catch: JSONException -> L15
        if ("cn".equals(CJPayHostInfo.languageTypeStr) == false) goto L6;
        String r102 = "zh-Hans";
    L7:
        r101.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r102);     // Catch: JSONException -> L15
        r101.put("device_id", CJEnv.c());     // Catch: JSONException -> L15
        if (CJPayBasicUtils.isSupportFingerPrint(CJPayHostInfo.applicationContext) == false) goto L10;
        r101.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, 1);     // Catch: JSONException -> L15
    L10:
        r101.put("os_version", Build.VERSION.SDK_INT);     // Catch: JSONException -> L15
        r101.put(Constants.OperatorKey.KEY_VENDOR, Build.MANUFACTURER);     // Catch: JSONException -> L15
        r101.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);     // Catch: JSONException -> L15
        r101.put("net_type", CJPayBasicUtils.getNetworkState(CJPayHostInfo.applicationContext));     // Catch: JSONException -> L15
        r101.put("app_version", CJPayBasicUtils.getAppVersionCode(CJPayHostInfo.applicationContext));     // Catch: JSONException -> L15
        r101.put("app_name", CJPayBasicUtils.getAppName(CJPayHostInfo.applicationContext));     // Catch: JSONException -> L15
        r101.put("app_update_version", String.valueOf(CJEnv.g()));     // Catch: JSONException -> L15
        r101.put("is_sdk_standard", "1");     // Catch: JSONException -> L15
        r101.put("platform_type", "android");     // Catch: JSONException -> L15
        if (CJEnv.q() == false) goto L13;
        r100 = "2";
    L13:
        r101.put("equipment_type", r100);     // Catch: JSONException -> L15
    L17:
        return r101;
    L6:
        r102 = "en";
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#buildDevInfoParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#buildDevInfoParams", e);
        CJReporter r103 = CJReporter.f202294a;
        CJReporter.m(null, "json_parser_exception", 0, e);
        goto L17
    }

    public static String buildSdkInfoHeaderParams() {
        JSONObject r100 = new JSONObject();
        r100.put("version", CJPayBasicUtils.getRealVersion());     // Catch: JSONException -> L9
        r100.put(KFImage.FEATURES_JSON_FIELD, new JSONObject().put("login_sdk", "1"));     // Catch: JSONException -> L9
        return URLEncoder.encode(r100.toString(), "UTF-8");
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#buildSdkInfoHeaderParams", e);     // Catch: JSONException -> L9
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#buildSdkInfoHeaderParams", e);     // Catch: JSONException -> L9
        e.printStackTrace();     // Catch: JSONException -> L9
        return "";
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#buildSdkInfoHeaderParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#buildSdkInfoHeaderParams", e);
        e.printStackTrace();
        return "";
    }

    private static String buildUniqueIdHeaderParams() {
        return SystemClock.elapsedRealtime() + "" + UNIQUE_ID_COUNTER.incrementAndGet();
    }

    public static String getBDServerDomain() {
        if (CJPayHostInfo.serverType == 2) goto L6;
        return "https://cashier.ulpay.com";
    L6:
        if (CJPayHostInfo.isUsingTTNet == true) goto L11;
        return CJPayConstant.TT_CJ_PAY_BD_HOST_BOE;
    L11:
        return "https://cashier.ulpay.com";
    }

    public static String getBDServerDomainAPI() {
        int r100 = CJPayHostInfo.serverType;
        String r101 = CJPayConstant.TT_CJ_PAY_BD_HOST_API_ONLINE;
        if (r100 != 2) goto L10;
        if (CJPayHostInfo.isUsingTTNet == true) goto L10;
        r101 = CJPayConstant.TT_CJ_PAY_BD_HOST_API_BOE;
    L10:
        return reuseHostDomain(HostAPI.BDPAY, r101);
    }

    public static String getDoupayServerDomain() {
        if (CJPayHostInfo.serverType == 2) goto L6;
        return CJPayConstant.TT_CJ_PAY_DOUPAY_HOST_ONLINE;
    L6:
        if (CJPayHostInfo.isUsingTTNet == true) goto L11;
        return CJPayConstant.TT_CJ_PAY_DOUPAY_HOST_BOE;
    L11:
        return CJPayConstant.TT_CJ_PAY_DOUPAY_HOST_ONLINE;
    }

    public static String getHostDomainInfo() {
        JSONObject r100 = new JSONObject();
        r100.put("tppay", getIntegratedServerDomain());     // Catch: JSONException -> L5
        r100.put("ulpay", getBDServerDomain());     // Catch: JSONException -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#getHostDomainInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#getHostDomainInfo", e);
        e.printStackTrace();
        goto L8
    }

    public static String getInternalIntegratedServerDomain() {
        if (CJPayHostInfo.serverType == 2) goto L6;
        return "https://tp-pay.snssdk.com";
    L6:
        if (CJPayHostInfo.isUsingTTNet == true) goto L11;
        return CJPayConstant.TT_CJ_PAY_INTEGRATE_HOST_BOE;
    L11:
        return "https://tp-pay.snssdk.com";
    }

    public static boolean isNeedReplaceIntegratedHostDomain() {
        return !TextUtils.isEmpty(CJPayHostInfo.integratedHostDomain);
    }

    public static String buildCookieStrHeaderParams() {
        Map<String, String> r100 = CJPayHostInfo.getLoginToken();
        String r101 = "";
        if (r100 == null) goto L11;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r102.next();
        r103 = r103 + 1;
        if (r103 == r100.size()) goto L9;
        r101 = r101 + r104.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r104.getValue() + i.f25853b;
        goto L6
    L9:
        r101 = r101 + r104.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r104.getValue();
    L11:
        return r101;
    }

    public static String buildDevInfoHeaderParams() {
        return URLEncoder.encode(buildDevInfoParams().toString(), "UTF-8");
    L5:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#buildDevInfoHeaderParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#buildDevInfoHeaderParams", th);
        CJReporter r100 = CJReporter.f202294a;
        CJReporter.m(null, "encoder_exception", 0, th);
        return "";
    }

    public static String getIntegratedServerDomain() {
        if (isNeedReplaceIntegratedHostDomain() == false) goto L7;
        return CJPayHostInfo.integratedHostDomain;
    L7:
        return getInternalIntegratedServerDomain();
    }

    public static String getIntegratedServerDomainAPI() {
        if (isNeedReplaceIntegratedHostDomain() == false) goto L7;
        return CJPayHostInfo.integratedHostDomain + "/gateway-u";
    L7:
        if (CJPayHostInfo.serverType == 2) goto L10;
        return CJPayConstant.TT_CJ_PAY_INTEGRATE_HOST_API_ONLINE;
    L10:
        if (CJPayHostInfo.isUsingTTNet == true) goto L15;
        return CJPayConstant.TT_CJ_PAY_INTEGRATE_HOST_API_BOE;
    L15:
        return CJPayConstant.TT_CJ_PAY_INTEGRATE_HOST_API_ONLINE;
    }

    public static String getBdCreditSignUrl(String r100) {
        if (CJPayHostInfo.serverType != 2) goto L5;
        String r101 = CJPayConstant.TT_CJ_PAY_BYTEPAY_HOST_BOE;
    L7:
        return getHttpUrl(r100, reuseHostDomain(HostAPI.BDPAY, r101));
    L5:
        r101 = CJPayConstant.TT_CJ_PAY_DOUPAY_HOST_ONLINE;
        goto L7
    }

    private static boolean isUrlInBlockPathList(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        ICJPaySettingService r101 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
        if (r101 == null) goto L16;
        WebViewCommonConfig r102 = r101.getWebViewCommonConfig();
        if (r102 == null) goto L16;
        Iterator<String> r103 = r102.integrated_host_replace_block_list.iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        if (r100.contains(r103.next()) == false) goto L11;
        return true;
    L16:
        return false;
    }

    public static String replaceWebViewUrlDomain(String r100) {
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#replaceWebViewUrlDomain", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#replaceWebViewUrlDomain", e);
    L21:
        return r100;
    L4:
        if (isNeedReplaceIntegratedHostDomain() == false) goto L21;
        if (TextUtils.isEmpty(r100) == true) goto L21;
        if (r100.startsWith("https://tp-pay.snssdk.com") == false) goto L14;
        if (isUrlInBlockPathList(r100) == true) goto L21;
        return r100.replaceFirst("https://tp-pay.snssdk.com", getIntegratedServerDomain());
    L14:
        if (r100.startsWith(CJPayHostInfo.integratedHostDomain) == false) goto L21;
        if (isUrlInBlockPathList(r100) == false) goto L21;
        return r100.replaceFirst(CJPayHostInfo.integratedHostDomain, getInternalIntegratedServerDomain());
    }

    public static JSONObject getCommonLogParams(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("app_id", r101);     // Catch: Exception -> L11
        r102.put("merchant_id", r100);     // Catch: Exception -> L11
        r102.put("sign_merchant_id", r100);     // Catch: Exception -> L11
        r102.put("aid", CJEnv.e());     // Catch: Exception -> L11
        r102.put("os_name", "Android" + Build.VERSION.RELEASE);     // Catch: Exception -> L11
        r102.put("app_platform", "native");     // Catch: Exception -> L11
        r102.put("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);     // Catch: Exception -> L11
        r102.put("is_chaselight", 1);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r101) == true) goto L9;
        String r103 = SourceManager.getSource();     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r103) == false) goto L8;
        r103 = "";
    L8:
        r102.put("caijing_source", r103);     // Catch: Exception -> L11
    L9:
        r102.put("cjpay_sdk_version", CJPayBasicUtils.getRealVersion());     // Catch: Exception -> L11
        r102.put("cjpay_sdk_version_code", CJPayBasicUtils.getSDKVersionCode());     // Catch: Exception -> L11
        r102.put("device_brand", Build.MANUFACTURER.toLowerCase(Locale.getDefault()));     // Catch: Exception -> L11
        ICJPaySettingService r104 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);     // Catch: Exception -> L11
        r102.put("is_sdk_standard", "1");     // Catch: Exception -> L11
    L13:
        return r102;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#getCommonLogParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#getCommonLogParams", e);
        goto L13
    }

    public static String getHttpUrl(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        return r101 + HTTP.URL_DEFAULT + r100.replaceAll(EasyGoConstant.VERSION_SEPARATIVE_SIGN, HTTP.URL_DEFAULT);
    }

    private static String reuseHostDomain(HostAPI r100, String r101) {
        ICJPaySettingService r102 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
        if (r102 == null) goto L13;
        ReuseHostDomain r103 = r102.getHostDomain("new_cjpay_host_domain");
        Uri r104 = UriProtector.parse(r101);
        if (r100 != HostAPI.BDPAY) goto L10;
        if (TextUtils.isEmpty(r103.bd_host_domain) == false) goto L15;
        return r101;
    L15:
        return r101.replaceFirst(r104.getHost(), r103.bd_host_domain);
    L10:
        if (TextUtils.isEmpty(r103.integrated_host_domain) == false) goto L12;
        return r101;
    L12:
        return r101.replaceFirst(r104.getHost(), r103.integrated_host_domain);
    L13:
        return r101;
    }

    public static String getHttpUrl(String r100, HostAPI r101) {
        if (r101 != HostAPI.INTEGRATED) goto L5;
        String r102 = getIntegratedServerDomainAPI();
    L7:
        return getHttpUrl(r100, r102);
    L5:
        r102 = getBDServerDomainAPI();
        goto L7
    }

    public static String appendResignInfo(String r100, String r101, String r102) {
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();     // Catch: Exception -> L10
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r104.put("bind_card_info", r101);     // Catch: Exception -> L10
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r104.put("asset_info_list", r102);     // Catch: Exception -> L10
    L8:
        r103.appendQueryParameter("exts", r104.toString());     // Catch: Exception -> L10
        return r103.build().toString();
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayParamsUtils#appendResignInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayParamsUtils#appendResignInfo", e);
        return r100;
    }

    public static Map<String, String> getNetHeaderData(String r100, String r101, Map<String, String> r102) {
        HashMap r103 = new HashMap();
        r103.put("devinfo", buildDevInfoHeaderParams());
        r103.put("Cookie", buildCookieStrHeaderParams());
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L9:
        if (r102 == null) goto L14;
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<String, String> r105 = r104.next();
        r103.put(r105.getKey(), r105.getValue());
    L14:
        return r103;
    L5:
        if (r101.contains("trade_confirm") == false) goto L9;
        if (CJPaySettingsManager.getInstance().isDegradeHeaderUniqueId() == true) goto L9;
        r103.put("Cj-Pay-Unique-Id", buildUniqueIdHeaderParams());
        goto L9
    }

    public static Map<String, String> getHttpData(String r100, String r101, String r102, String r103) {
        HashMap r104 = new HashMap();
        r104.put(SubInfo.KEY_FORMAT, "JSON");
        r104.put("charset", XML.CHARSET_UTF8);
        r104.put("version", "1.0");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r104.put(e.f25671s, r100);
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r104.put("app_id", r102);
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r104.put(b.C0, r101);
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r104.put("merchant_id", r103);
    L14:
        return r104;
    }

    public static Map<String, String> getHttpData(String r100, String r101, String r102, String r103, String r104, String r105) {
        HashMap r106 = new HashMap();
        r106.put(SubInfo.KEY_FORMAT, "JSON");
        r106.put("charset", XML.CHARSET_UTF8);
        r106.put("version", "1.0");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r106.put(e.f25671s, r100);
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r106.put("app_id", r102);
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r106.put(b.C0, r101);
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r106.put("merchant_id", r103);
    L15:
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r106.put("part_cosign_data", r104);
    L18:
        if (TextUtils.isEmpty(r105) == true) goto L20;
        r106.put("sign_factor_id", r105);
    L20:
        return r106;
    }

    public static Map<String, String> getHttpData(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        HashMap r107 = new HashMap();
        r107.put(SubInfo.KEY_FORMAT, "JSON");
        r107.put("charset", XML.CHARSET_UTF8);
        r107.put("version", "1.0");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r107.put(e.f25671s, r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r107.put("app_id", r101);
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r107.put(b.C0, r103);
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r107.put("merchant_id", r102);
    L15:
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r107.put("timestamp", r104);
    L18:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        r107.put("part_cosign_data", r105);
    L21:
        if (TextUtils.isEmpty(r106) == true) goto L23;
        r107.put("sign_factor_id", r106);
    L23:
        return r107;
    }
}
