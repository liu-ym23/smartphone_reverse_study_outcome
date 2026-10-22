package com.byted.cast.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class PreferenceUtils {
    private static final String BDLINK = "BDLink";
    private static final String BYTECAST = "ByteCast";
    private static final String KEY_BDCLOUD_DOMAIN = "bdcloud_domain";
    private static final String KEY_BDLINK_HTTP_SERVER_PORT = "http_server_port";
    private static final String KEY_BDLINK_SERVICE_INFO = "bdlink_service_info";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_DEVICE_ID_GENERATED_BY_RANDOM_UUID = "npush_id_generated_by_random_uuid";
    private static final String KEY_DEVICE_IP_SOURCE = "device_ip_source";
    private static final String KEY_DLNA_DEVICE_IP_SOURCE = "dlna_device_ip_source";
    private static final String KEY_GRAY_DOMAIN = "gray_domain";
    private static final String KEY_LICENSE_DOMAIN = "license_domain";
    private static final String KEY_SWITCH_BOE_CODE = "switch_boe_code";
    private static final String KEY_TO_B_FAKE_DID = "tob_fake_did";
    private static final String KEY_TO_B_USER = "to_b_user";
    public static final String NAME_SETTING = "cast_setting";
    private static final String NEW_KEY_BDLINK_SERVICE_INFO = "new_bdlink_service_info";
    private static final String TAG = null;

    public PreferenceUtils() {
    }

    public static boolean isByteUserToB() {
        return false;
    }

    static {
        TAG = "PreferenceUtils";
    }

    public static int getByteLicenseDomainType(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getSharedPreferences(NAME_SETTING, 0).getInt(KEY_LICENSE_DOMAIN, 0);
    }

    public static String getDeviceID(Context r100) {
        return getValue(r100, "device_id", null);
    }

    public static HashMap<String, String> getDlnaDevicesIp(Context r100) {
        return getHashMapValue(r100, KEY_DEVICE_IP_SOURCE, KEY_DLNA_DEVICE_IP_SOURCE);
    }

    public static boolean isBoeCode(Context r100) {
        return getValue(r100, KEY_SWITCH_BOE_CODE, false);
    }

    public static boolean isDeviceIdGeneratedByRandomUUID(Context r100) {
        return getValue(r100, KEY_DEVICE_ID_GENERATED_BY_RANDOM_UUID, false);
    }

    public static void enableBoeCode(Context r100, boolean r101) {
        setValue(r100, KEY_SWITCH_BOE_CODE, r101);
    }

    public static String getBDCloudDomain(Context r100, String r101) {
        if (r100 != null) goto L5;
        return r101;
    L5:
        return r100.getSharedPreferences(NAME_SETTING, 0).getString(KEY_BDCLOUD_DOMAIN, r101);
    }

    public static String getBDLinkServiceInfo(Context r100, String r101) {
        return getValue(r100, prefixSPKey(r101, NEW_KEY_BDLINK_SERVICE_INFO), null);
    }

    public static String getByteGrayDomain(Context r100, String r101) {
        Context r102 = Constants.sAppContext;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getSharedPreferences(NAME_SETTING, 0).getString(KEY_GRAY_DOMAIN, r101);
    }

    public static String getToBCastDid(String r100, ContextManager.CastContext r101) {
        Context r102 = Constants.sAppContext;
        if (r102 != null) goto L5;
        return r100;
    L5:
        SharedPreferences r103 = r102.getSharedPreferences(NAME_SETTING, 0);
        String r104 = r103.getString(KEY_TO_B_FAKE_DID, "");
        if (TextUtils.isEmpty(r104) == false) goto L12;
        String r105 = Utils.tryGetDidFromAppLog(r101);
        if (TextUtils.isEmpty(r105) == false) goto L10;
        r105 = Utils.generateCastDid();
    L10:
        String r106 = r105;
        SharedPreferences.Editor r107 = r103.edit();
        r107.putString(KEY_TO_B_FAKE_DID, r106);
        r107.apply();
        return r106;
    L12:
        return r104;
    }

    public static String prefixSPKey(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "";
    L5:
        r102.append(r100);
        return r102.toString();
    }

    public static void setDeviceID(Context r100, String r101) {
        setValue(r100, "device_id", r101);
    }

    public static void setDeviceIdGeneratedByRandomUUID(Context r100, boolean r101) {
        setValue(r100, KEY_DEVICE_ID_GENERATED_BY_RANDOM_UUID, r101);
    }

    public static int getBDLinkValue(Context r100, String r101, int r102) {
        return r100.getSharedPreferences("BDLink", 0).getInt(r101, r102);
    }

    public static HashMap<String, String> getHashMapValue(Context r100, String r101, String r102) {
        HashMap<String, String> r103 = new HashMap();
        Context r104 = Constants.sAppContext;
        if (r104 != null) goto L20;
        return r103;
    L20:
        JSONArray r105 = new JSONArray(r104.getSharedPreferences(r101, 0).getString(r102, ""));     // Catch: JSONException -> L17
        int r106 = 0;
    L8:
        if (r106 >= r105.length()) goto L19;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r105, r106);     // Catch: JSONException -> L17
        JSONArray r108 = r107.names();     // Catch: JSONException -> L17
        if (r108 == null) goto L16;
        int r109 = 0;
    L13:
        if (r109 >= r108.length()) goto L16;
        String r110 = JSONArrayProtectorUtils.getString(r108, r109);     // Catch: JSONException -> L17
        r103.put(r110, JSONObjectProtectorUtils.getString(r107, r110));     // Catch: JSONException -> L17
        r109 = r109 + 1;
    L16:
        r106 = r106 + 1;
    L19:
        return r103;
    L17:
        e = move-exception;
        Logger.d(TAG, e.getMessage());
        goto L19
    }

    public static String getValue(Context r100, String r101, String r102) {
        Context r103 = Constants.sAppContext;
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.getSharedPreferences("ByteCast", 0).getString(r101, r102);
    }

    public static void saveDlnaDevicesIp(Context r100, String r101, String r102) {
        HashMap<String, String> r103 = getDlnaDevicesIp(r100);
        r103.put(r101, r102);
        setValue(r100, KEY_DEVICE_IP_SOURCE, KEY_DLNA_DEVICE_IP_SOURCE, r103);
    }

    public static void setBDLinkServiceInfo(Context r100, String r101, String r102) {
        setValue(r100, prefixSPKey(r101, NEW_KEY_BDLINK_SERVICE_INFO), r102);
    }

    public static void setBDLinkValue(Context r100, String r101, int r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences("BDLink", 0).edit();
        r103.putInt(r101, r102);
        r103.apply();
    }

    public static void setValue(Context r100, String r101, String r102) {
        Context r103 = Constants.sAppContext;
        if (r103 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r104 = r103.getSharedPreferences("ByteCast", 0).edit();
        r104.putString(r101, r102);
        r104.apply();
    }

    public static boolean getValue(Context r100, String r101, boolean r102) {
        Context r103 = Constants.sAppContext;
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103.getSharedPreferences("ByteCast", 0).getBoolean(r101, r102);
    }

    public static void setValue(Context r100, String r101, boolean r102) {
        Context r103 = Constants.sAppContext;
        if (r103 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r104 = r103.getSharedPreferences("ByteCast", 0).edit();
        r104.putBoolean(r101, r102);
        r104.apply();
    }

    public static String getValue(Context r100, String r101, String r102, String r103) {
        Context r104 = Constants.sAppContext;
        if (r104 != null) goto L6;
        return r103;
    L6:
        return r104.getSharedPreferences("ByteCast", 0).getString(prefixSPKey(r101, r102), r103);
    }

    public static void setValue(Context r100, String r101, String r102, HashMap<String, String> r103) {
        if (Constants.sAppContext != null) goto L5;
        return;
    L5:
        JSONArray r104 = new JSONArray();
        Iterator<Map.Entry<String, String>> r105 = r103.entrySet().iterator();
        JSONObject r106 = new JSONObject();
    L7:
        if (r105.hasNext() == false) goto L13;
        Map.Entry<String, String> r107 = r105.next();
        r106.put(r107.getKey(), r107.getValue());     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        Logger.d(TAG, e.getMessage());
        goto L7
    L13:
        r104.put(r106);
        SharedPreferences.Editor r108 = Constants.sAppContext.getSharedPreferences(r101, 0).edit();
        r108.putString(r102, r104.toString());
        r108.apply();
    }

    public static int getValue(Context r100, String r101, String r102, int r103) {
        Context r104 = Constants.sAppContext;
        if (r104 != null) goto L6;
        return r103;
    L6:
        return r104.getSharedPreferences(r101, 0).getInt(r102, r103);
    }

    public static void setValue(Context r100, String r101, String r102, String r103) {
        Context r104 = Constants.sAppContext;
        if (r104 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r105 = r104.getSharedPreferences("ByteCast", 0).edit();
        r105.putString(prefixSPKey(r101, r102), r103);
        r105.apply();
    }

    public static void setValue(Context r100, String r101, String r102, int r103) {
        Context r104 = Constants.sAppContext;
        if (r104 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r105 = r104.getSharedPreferences(r101, 0).edit();
        r105.putInt(r102, r103);
        r105.apply();
    }

    public static int getValue(Context r100, String r101, String r102, String r103, int r104) {
        Context r105 = Constants.sAppContext;
        if (r105 != null) goto L6;
        return r104;
    L6:
        return r105.getSharedPreferences(r101, 0).getInt(prefixSPKey(r102, r103), r104);
    }

    public static void setValue(Context r100, String r101, String r102, String r103, int r104) {
        Context r105 = Constants.sAppContext;
        if (r105 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r106 = r105.getSharedPreferences(r101, 0).edit();
        r106.putInt(prefixSPKey(r102, r103), r104);
        r106.apply();
    }
}
