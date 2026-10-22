package com.bytedance.frameworks.baselib.network.http.storeregion;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StoreRegionManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String APP_INIT_REGION_HEADER = "x-tt-app-init-region";
    public static final String LOG_ID_HEADER = "x-tt-logid";
    private static final String RECEIVED_REGION_CONFIG = "received_region_config";
    private static final String REGION_LEGACY_USER = "region_legacy_user";
    public static final String REGION_LEGACY_USER_COOKIE = "region_legacy_user=";
    private static final String REGION_SOURCE_LOCAL = "local";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String STORE_COUNTRY_CODE_COOKIE = "store-country-code=";
    public static final String STORE_COUNTRY_CODE_SOURCE_COOKIE = "store-country-code-src=";
    private static final String STORE_REGION = "store_region";
    public static final String STORE_REGION_COOKIE = "store-region=";
    private static final String STORE_REGION_DOMAIN = "add_store_idc_host_list";
    public static final String STORE_REGION_HEADER = "x-tt-store-region";
    private static final String STORE_REGION_PATH = "update_store_idc_path_list";
    public static final String STORE_REGION_SOURCE_COOKIE = "store-region-src=";
    private static final String STORE_REGION_SP_NAME = "ttnet_store_region";
    private static final String STORE_REGION_SRC = "store_region_src";
    public static final String STORE_REGION_SRC_HEADER = "x-tt-store-region-src";
    private static final String STORE_SEC_UID = "store_sec_uid";
    public static final String STORE_SEC_UID_HEADER = "x-tt-store-sec-uid";
    private static final String TAG = "StoreRegionManager";
    public static final String TNC_ATTR_HEADER = "x-tt-tnc-attr";
    public static final String TNC_CONFIG_HEADER = "x-tt-tnc-config";
    public static final String TNC_ETAG_HEADER = "x-ss-etag";
    private static final String UPDATE_REGION_INFO = "update_region_info";
    public static final String WITH_TNC_CONFIG_HEADER = "x-tt-with-tnc";
    private static boolean mUseDomesticStoreRegion;
    private static volatile StoreRegionManager sInstance;
    private Context mContext;
    private String mInitRegion;
    private boolean mReceivedTNCRegionConfig;
    private String mRegionLegacyUser;
    private String mStoreRegion;
    private StoreRegionBridge mStoreRegionBridge;
    private List<String> mStoreRegionHostList;
    private String mStoreRegionLocal;
    private List<String> mStoreRegionPathList;
    private boolean mStoreRegionRuleEnabled;
    private String mStoreRegionSrc;
    private String mStoreSecUid;
    private String mUpdateRegionInfo;

    private class CookieRegionInfo {
        String regionLegacyUser;
        String storeRegion;
        String storeRegionSrc;
        final /* synthetic */ StoreRegionManager this$0;

        CookieRegionInfo(StoreRegionManager r1, String r2, String r3, String r4) {
            this.this$0 = r1;
            this.storeRegion = r2;
            this.storeRegionSrc = r3;
            this.regionLegacyUser = r4;
        }
    }

    public interface StoreRegionCallback {
        void notifyStoreRegionUpdatedForCronet(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11);
    }

    static {
    }

    public static String getStoreRegionSpName() {
        return STORE_REGION_SP_NAME;
    }

    public static StoreRegionManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(StoreRegionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StoreRegionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StoreRegionManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private StoreRegionManager() {
        this.mStoreRegion = "";
        this.mStoreRegionSrc = "";
        this.mRegionLegacyUser = "";
        this.mStoreSecUid = "";
        this.mStoreRegionLocal = "";
        this.mUpdateRegionInfo = "";
        this.mInitRegion = "";
        this.mStoreRegionPathList = new ArrayList();
        this.mStoreRegionHostList = new ArrayList();
    }

    public void setReceivedTNCRegionConfig() {
        if (this.mReceivedTNCRegionConfig == true) goto L6;
        this.mReceivedTNCRegionConfig = true;
        SharedPreferences.Editor r3 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        r3.putBoolean(RECEIVED_REGION_CONFIG, true);
        r3.apply();
        return;
    }

    public boolean isStoreRegionRuleEnabled() {
        return this.mStoreRegionRuleEnabled;
    }

    public String getStoreRegion() {
        return this.mStoreRegion;
    }

    public String getStoreRegionSrc() {
        return this.mStoreRegionSrc;
    }

    public String getRegionLegacyUser() {
        return this.mRegionLegacyUser;
    }

    public void initStoreRegionRuleConfig(String r6, String r7, String r8, Context r9, StoreRegionBridge r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "rule json: " + r7);
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L44;
        if (r9 == null) goto L45;
        if (r10 == null) goto L48;
        JSONObject r0 = new JSONObject(r7);     // Catch: JSONException -> L33
        JSONArray r11 = r0.optJSONArray(STORE_REGION_PATH);     // Catch: JSONException -> L33
        int r1 = 0;
        int r2 = 0;
    L12:
        if (r2 >= r11.length()) goto L17;
        String r3 = r11.getString(r2);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r3) == true) goto L16;
        this.mStoreRegionPathList.add(r3);     // Catch: JSONException -> L33
    L16:
        r2 = r2 + 1;     // Catch: JSONException -> L33
        goto L12
    L17:
        JSONArray r12 = r0.optJSONArray(STORE_REGION_DOMAIN);     // Catch: JSONException -> L33
    L19:
        if (r1 >= r12.length()) goto L24;
        String r4 = r12.getString(r1);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r4) == true) goto L23;
        this.mStoreRegionHostList.add(r4);     // Catch: JSONException -> L33
    L23:
        r1 = r1 + 1;     // Catch: JSONException -> L33
        goto L19
    L24:
        this.mContext = r9;     // Catch: JSONException -> L33
        this.mStoreRegionBridge = r10;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r6) == true) goto L28;
        this.mStoreRegionLocal = r6.toLowerCase();     // Catch: JSONException -> L33
    L28:
        if (this.mStoreRegionHostList.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.mStoreRegionPathList.isEmpty() == true) goto L47;
        this.mStoreRegionRuleEnabled = true;     // Catch: JSONException -> L33
        this.mInitRegion = r8;     // Catch: JSONException -> L33
        loadLocalConfig();     // Catch: JSONException -> L33
        return;
    L47:
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        return;
    L45:
        return;
    }

    private void loadLocalConfig() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0);
        this.mStoreRegion = r0.getString("store_region", "");
        this.mStoreRegionSrc = r0.getString(STORE_REGION_SRC, "");
        this.mRegionLegacyUser = r0.getString("region_legacy_user", "");
        this.mStoreSecUid = r0.getString(STORE_SEC_UID, "");
        this.mUpdateRegionInfo = r0.getString(UPDATE_REGION_INFO, "");
        this.mReceivedTNCRegionConfig = r0.getBoolean(RECEIVED_REGION_CONFIG, false);
        if (TextUtils.isEmpty(this.mStoreRegion) == true) goto L5;
    L7:
        this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mRegionLegacyUser, this.mStoreSecUid, "");
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "Init region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal + " init region:" + this.mInitRegion + " region config:" + this.mReceivedTNCRegionConfig);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.mStoreRegionLocal) == true) goto L7;
        this.mStoreRegion = this.mStoreRegionLocal;
        this.mStoreRegionSrc = REGION_SOURCE_LOCAL;
        goto L7
    }

    private boolean addExtraParamsForDidAndUidPath(Request r5, Request.Builder r6) {
        if (TextUtils.isEmpty(r5.getPath()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r5.getPath()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r4 = this.mStoreRegionPathList.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (UrlUtils.matchPattern(r5.getPath(), r4.next()) == false) goto L10;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        UrlBuilder r8 = new UrlBuilder(r5.getUrl());
        r8.addParam("okhttp_version", "4.2.228.16-pico");
        r8.addParam("use_store_region_cookie", "1");
        r6.url(r8.build());
        return true;
    L14:
        r7 = false;
        goto L15
    }

    public Request addStoreRegionHeaderForOkHttp(Request r7) {
        if (this.mStoreRegionRuleEnabled == true) goto L5;
    L47:
        return null;
    L5:
        if (TextUtils.isEmpty(r7.getHost()) == true) goto L47;
        if (r7.isPureRequest() == false) goto L10;
        return null;
    L10:
        Iterator<String> r0 = this.mStoreRegionHostList.iterator();
    L11:
        boolean r3 = true;
        if (r0.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r7.getHost(), r0.next()) == false) goto L11;
        boolean r1 = true;
    L17:
        ArrayList r2 = new ArrayList();
        if (this.mReceivedTNCRegionConfig == false) goto L20;
    L22:
        r3 = r1;
    L23:
        if (r3 == true) goto L26;
        return null;
    L26:
        if (r7.getHeaders() == null) goto L28;
        r2.addAll(r7.getHeaders());
    L28:
        Request.Builder r4 = r7.newBuilder();
        if (addExtraParamsForDidAndUidPath(r7, r4) == false) goto L33;
        r4.headers(r2);
        return r4.build();
    L33:
        if (this.mStoreRegion.isEmpty() == true) goto L36;
        String r8 = this.mStoreRegion;
    L40:
        if (TextUtils.isEmpty(r8) == true) goto L43;
        r2.add(new Header(STORE_REGION_HEADER, r8));
    L43:
        if (TextUtils.isEmpty(this.mStoreRegionSrc) == true) goto L45;
        r2.add(new Header(STORE_REGION_SRC_HEADER, this.mStoreRegionSrc));
    L45:
        r4.headers(r2);
        return r4.build();
    L36:
        if (this.mStoreRegionLocal.isEmpty() == true) goto L38;
        r8 = this.mStoreRegionLocal;
        goto L40
    L38:
        r8 = "";
        goto L40
    L20:
        if (TextUtils.isEmpty(this.mInitRegion) == true) goto L22;
        r2.add(new Header(APP_INIT_REGION_HEADER, this.mInitRegion));
        goto L23
    L16:
        r1 = false;
        goto L17
    }

    public void addStoreIdcHeaderForGetDomain(Map<String, String> r2) {
        if (this.mStoreRegionRuleEnabled == false) goto L12;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.mReceivedTNCRegionConfig == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mInitRegion) == true) goto L14;
        r2.put(APP_INIT_REGION_HEADER, this.mInitRegion);
        return;
    L14:
        return;
    }

    public void updateStoreRegionForOkHttp(Response r22, String r23, byte[] r24) {
        if (this.mStoreRegionRuleEnabled == true) goto L55;
        return;
    L55:
        URI r3 = UrlUtils.safeCreateUri(r23);     // Catch: Exception -> L54
        String r4 = r3.getHost() + r3.getPath();     // Catch: Exception -> L54
        if (r3 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getPath()) == false) goto L11;
        return;
    L11:
        if (canUpdateStoreRegionFromPath(r3.getPath()) == true) goto L13;
        return;
    L13:
        CookieRegionInfo r5 = extractStoreRegionFromCookieHeaders(r22.headers("Set-Cookie"));
        String r6 = r22.header(TNC_ETAG_HEADER);
        String r7 = r22.header(TNC_ATTR_HEADER);
        String r0 = r22.header(WITH_TNC_CONFIG_HEADER);
        if (TextUtils.isEmpty(r0) == false) goto L16;
    L21:
        JSONObject r1 = null;
    L23:
        if (r5 != null) goto L27;
        if (r1 == null) goto L27;
        this.mStoreRegionBridge.updateTncConfig(r1, r6, r7, false);
        return;
    L27:
        if (r5 != null) goto L30;
        return;
    L30:
        if (Logger.debug() == false) goto L32;
        Logger.d(TAG, "origin region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal);
    L32:
        boolean r9 = !this.mStoreRegion.equals(r5.storeRegion);
        String r14 = r22.header(STORE_SEC_UID_HEADER);
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        SharedPreferences.Editor r13 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        if (this.mStoreRegion.equals(r5.storeRegion) == true) goto L38;
    L43:
        this.mStoreRegion = r5.storeRegion;
        this.mStoreRegionSrc = r5.storeRegionSrc;
        this.mStoreSecUid = r14;
        r13.putString("store_region", this.mStoreRegion);
        r13.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
        r13.putString(STORE_SEC_UID, this.mStoreSecUid);
        boolean r8 = true;
    L45:
        if (this.mRegionLegacyUser.equals(r5.regionLegacyUser) == true) goto L48;
        String r10 = r5.regionLegacyUser;
        this.mRegionLegacyUser = r10;
        r13.putString("region_legacy_user", r10);
        r8 = true;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "update region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " regionLegacyUser:" + this.mRegionLegacyUser + "local:" + this.mStoreRegionLocal);
        Logger.d(TAG, "save config:" + r8 + " update tnc:" + r9);
    L50:
        boolean r2 = this.mStoreRegionBridge.updateTncConfig(r1, r6, r7, r9);
        if (r8 == false) goto L60;
        String r11 = r22.header("x-tt-logid");
        String r12 = r3.getPath() + SimContactsConstants.EMAIL_SEP + r11 + SimContactsConstants.EMAIL_SEP + r5.storeRegion + SimContactsConstants.EMAIL_SEP + r5.storeRegionSrc;
        this.mUpdateRegionInfo = r12;
        r13.putString(UPDATE_REGION_INFO, r12);
        r13.apply();
        this.mStoreRegionBridge.sendFeedbackLog(getStoreRegionChangeLog(r11, r4, r2), CronetDataStorageAccess.STORE_IDC);
        this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mRegionLegacyUser, this.mStoreSecUid, r11);
        return;
    L60:
        return;
    L38:
        if (this.mStoreRegionSrc.equals(r5.storeRegionSrc) == false) goto L43;
        if (r14.equals(this.mStoreSecUid) == false) goto L43;
        r8 = false;
        goto L45
    L16:
        if (r0.equals("1") == false) goto L21;
        r1 = new JSONObject(new String(r24)).getJSONObject("tnc_data");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void saveStoreRegionForCronet(String r1, String r2, String r3, String r4, String r5, String r6) {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mStoreRegionRuleEnabled == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (this.mStoreRegion.equalsIgnoreCase(r2) == true) goto L15;
    L19:
        this.mStoreSecUid = r5;
        this.mStoreRegion = r2;
        this.mStoreRegionSrc = r3;
        this.mRegionLegacyUser = r4;
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "saveStoreRegionForCronet region:" + this.mStoreRegion + " source:" + this.mStoreRegionSrc + " sec uid:" + this.mStoreSecUid);
    L22:
        SharedPreferences.Editor r7 = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        r7.putString("store_region", this.mStoreRegion);
        r7.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
        r7.putString(STORE_SEC_UID, this.mStoreSecUid);
        r7.apply();
        return;
    L15:
        if (this.mStoreRegionSrc.equalsIgnoreCase(r3) == false) goto L19;
        if (this.mStoreSecUid.equalsIgnoreCase(r5) == false) goto L19;
    }

    private String getStoreRegionChangeLog(String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("url", r5);     // Catch: JSONException -> L5
        r1.put("logId", r4);     // Catch: JSONException -> L5
        r0.put("tnc", r6);     // Catch: JSONException -> L5
        r0.put(TraceStatsConsts.STATS_BASE_MODULE, r1);     // Catch: JSONException -> L5
        r0.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r0.put("store_region", this.mStoreRegion);     // Catch: JSONException -> L5
        r0.put("source", this.mStoreRegionSrc);     // Catch: JSONException -> L5
        r0.put("region_legacy_user", this.mRegionLegacyUser);     // Catch: JSONException -> L5
        r0.put(REGION_SOURCE_LOCAL, this.mStoreRegionLocal);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private boolean canUpdateStoreRegionFromPath(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r2 = this.mStoreRegionPathList.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (UrlUtils.matchPattern(r3, r2.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private String extractValueFromSetCookieLine(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String[] r2 = r3.split(";");
        if (r2 != null) goto L8;
    L15:
        return "";
    L8:
        if (r2.length <= 0) goto L15;
        String[] r4 = r2[0].trim().split("=");
        if (r4 == null) goto L15;
        if (r4.length != 2) goto L15;
        return r4[1];
    }

    private CookieRegionInfo extractStoreRegionFromCookieHeaders(List<String> r10) {
        if (r10 != null) goto L5;
    L31:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L31;
        if (mUseDomesticStoreRegion == false) goto L10;
        String r1 = STORE_REGION_COOKIE;
        String r2 = STORE_REGION_SOURCE_COOKIE;
    L11:
        Iterator<String> r11 = r10.iterator();
        String r3 = "";
        String r4 = "";
        String r5 = r4;
    L13:
        if (r11.hasNext() == false) goto L24;
        String r6 = r11.next();
        if (r6.toLowerCase().startsWith(r1) == true) goto L16;
        if (r6.toLowerCase().startsWith(r2) == true) goto L19;
        if (r6.toLowerCase().startsWith(REGION_LEGACY_USER_COOKIE) == false) goto L13;
        r5 = r6;
        goto L13
    L19:
        r4 = r6;
        goto L13
    L16:
        r3 = r6;
        goto L13
    L24:
        if (TextUtils.isEmpty(r3) == false) goto L26;
        return null;
    L26:
        String r12 = extractValueFromSetCookieLine(r3);
        if (r12.isEmpty() == false) goto L30;
        return null;
    L30:
        return new CookieRegionInfo(this, r12, extractValueFromSetCookieLine(r4), extractValueFromSetCookieLine(r5));
    L10:
        r1 = STORE_COUNTRY_CODE_COOKIE;
        r2 = STORE_COUNTRY_CODE_SOURCE_COOKIE;
        goto L11
    }

    public void updateStoreRegionForCronet(HttpURLConnection r20, byte[] r21, StoreRegionCallback r22) {
        if (r20 != null) goto L5;
        return;
    L5:
        if (this.mStoreRegionRuleEnabled == true) goto L8;
        return;
    L8:
        if (canUpdateStoreRegionFromPath(r20.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r2 = r20.getHeaderFields();
        List<String> r4 = r2.get("Set-Cookie");
        if (r4 != null) goto L13;
    L14:
        r4 = r2.get("Set-Cookie".toLowerCase());
    L15:
        CookieRegionInfo r3 = extractStoreRegionFromCookieHeaders(r4);
        String r5 = getHeaderValueIgnoreCase(r2, WITH_TNC_CONFIG_HEADER);
        String r6 = "";
        if (TextUtils.isEmpty(r5) == false) goto L18;
    L23:
        String r15 = "";
    L24:
        if (r3 == null) goto L26;
    L28:
        if (r3 != null) goto L30;
        r3 = new CookieRegionInfo(this, "", "", "");
    L30:
        String r17 = getHeaderValueIgnoreCase(r2, STORE_SEC_UID_HEADER);
        String r1 = getHeaderValueIgnoreCase(r2, "x-tt-logid");
        String r12 = getHeaderValueIgnoreCase(r2, TNC_ATTR_HEADER);
        String r13 = getHeaderValueIgnoreCase(r2, TNC_ETAG_HEADER);
        String r14 = getHeaderValueIgnoreCase(r2, TNC_CONFIG_HEADER);
        JSONObject r7 = new JSONObject();
        r6 = r20.getURL().getPath();     // Catch: JSONException -> L33
        r7.put("url", r20.getURL().getHost() + r6);     // Catch: JSONException -> L33
        r7.put("store_region", r3.storeRegion + SimContactsConstants.EMAIL_SEP + r3.storeRegionSrc);     // Catch: JSONException -> L33
        r7.put("region_legacy_user", r3.regionLegacyUser);     // Catch: JSONException -> L33
        r7.put("logId", r1);     // Catch: JSONException -> L33
    L35:
        r22.notifyStoreRegionUpdatedForCronet(r6, r3.storeRegion, r3.storeRegionSrc, r3.regionLegacyUser, r12, r13, r14, r15, r7.toString(), r17, r1);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r15) == false) goto L28;
        return;
    L18:
        if (r5.equals("1") == false) goto L23;
        r15 = "{\"data\": " + new JSONObject(new String(r21)).getString("tnc_data") + "}";     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r4.isEmpty() == false) goto L15;
        goto L14
    }

    private static String getHeaderValueIgnoreCase(Map<String, List<String>> r4, String r5) {
        if (r4 != null) goto L5;
    L19:
        return "";
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        Iterator<String> r1 = r4.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        if (r5.equalsIgnoreCase(r2) == false) goto L9;
        List<String> r6 = r4.get(r2);
    L14:
        if (r6 == null) goto L19;
        if (r6.size() <= 0) goto L19;
        return r6.get(r6.size() - 1);
    L13:
        r6 = null;
        goto L14
    }

    public JSONObject getStoreIdcInfo() {
        if (this.mStoreRegionRuleEnabled == true) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put(CommonKey.KEY_REGION, this.mStoreRegion);     // Catch: JSONException -> L9
        r0.put("source", this.mStoreRegionSrc);     // Catch: JSONException -> L9
        r0.put("local_region", this.mStoreRegionLocal);     // Catch: JSONException -> L9
        r0.put("update_region", this.mUpdateRegionInfo);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void useDomesticStoreRegion(boolean r0) {
        mUseDomesticStoreRegion = r0;
    }

    public static boolean isDomesticStoreRegion() {
        return mUseDomesticStoreRegion;
    }
}
