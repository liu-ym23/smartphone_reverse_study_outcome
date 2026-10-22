package com.bytedance.frameworks.baselib.network.sampling;

import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SlaSamplingSettingCreator {
    private static final Set<String> EVENT_LOG_TYPES = null;
    private static final String KEY_API_ALLOW_LIST = "api_allow_list";
    private static final String KEY_API_ALLOW_LIST_HOST_PATTERN = "api_allow_list_host_pattern";
    private static final String KEY_API_ALLOW_LIST_PATH_CONTAIN = "api_allow_list_path_contain";
    private static final String KEY_API_ALLOW_LIST_PATH_EQUAL = "api_allow_list_path_equal";
    private static final String KEY_API_ALLOW_LIST_PATH_PREFIX = "api_allow_list_path_prefix";
    private static final String KEY_API_ALLOW_LIST_PATH_REGEX = "api_allow_list_path_regexp";
    private static final String KEY_API_ALLOW_LIST_URL_REGEX = "api_allow_list_url_regexp";
    private static final String KEY_API_BLOCK_LIST = "api_block_list";
    private static final String KEY_ENABLE_API_ALL_UPLOAD = "enable_api_all_upload";
    private static final String KEY_ENABLE_BASE_API_ALL = "enable_base_api_all";
    private static final String KEY_EVENT_ALLOW_LOG_TYPE = "allow_log_type";
    private static final String TAG = "SlaSamplingSCreator";
    private static SamplingSettingProvider.SlaSamplingSetting sOriginSetting;
    private static double sTolerance;

    public SlaSamplingSettingCreator() {
    }

    static {
        HashSet r0 = new HashSet();
        EVENT_LOG_TYPES = r0;
        sTolerance = 1.0E-9d;
        r0.add("ttnet_high_lvl_conn");
        r0.add("multinetwork");
        r0.add("mpa_client");
        r0.add("ttnet_feedback_detect");
        r0.add("ttnet_exception_detect");
        r0.add("ttnet_stress_detect");
        r0.add("ttnet_polling_detect");
        r0.add("long_cost_net_task");
        r0.add("ws_all");
        r0.add("frontier_all");
        r0.add("frontier_msg");
        r0.add("user_msg");
        r0.add(CronetDataStorageAccess.STORE_IDC);
        r0.add("ttnet_route_select");
        r0.add("ws_ping");
        r0.add("frontier_online");
        r0.add("ttnet_all_log");
        r0.add("cookie_mismatch");
        r0.add("cronet_native_requestlog");
        r0.add("ttnet_debug_trace_info");
        r0.add("ttnet_http_dns_fail");
        r0.add("ttnet_tnc_update_result");
        r0.add("cronet_native_requestlog_empty");
        r0.add("frontier_qos");
        r0.add("ttnet_net_exp");
        r0.add("bad_request_diagnosis");
        r0.add("ttnet_raw_detect");
        r0.add("gna_raw_detect");
        r0.add("ttnet_network_environment");
        r0.add("game_network");
        r0.add("ttnet_zstd_stream");
        r0.add("ttnet_zstd_dict_error");
        r0.add("ttnet_load");
        r0.add("ttnet_insec_rect");
        r0.add("ttquiche_native_request_log");
    }

    private static boolean parseJSONObjectList(JSONObject r1, String r2, List<String> r3) {
        return parseJSONObjectListWithFilter(r1, r2, r3, null);
    }

    private static boolean parseJSONObjectListWithFilter(JSONObject r2, String r3, List<String> r4, Set<String> r5) {
        if (r2 != null) goto L5;
    L24:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (r4 == null) goto L24;
        JSONObject r6 = r2.optJSONObject(r3);
        if (r6 != null) goto L11;
        return false;
    L11:
        Iterator<String> r7 = r6.keys();
    L13:
        if (r7.hasNext() == false) goto L23;
        String r8 = r7.next();
        if (TextUtils.isEmpty(r8) == true) goto L13;
        if (r5 == null) goto L21;
        if (r5.isEmpty() == true) goto L13;
        if (r5.contains(r8) == false) goto L13;
    L21:
        r4.add(r8);
        goto L13
    L23:
        return !r4.isEmpty();
    }

    private static void parseJSONArrayList(JSONObject r2, String r3, List<String> r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L21;
        if (r4 == null) goto L22;
        JSONArray r5 = r2.optJSONArray(r3);
        if (r5 != null) goto L10;
        return;
    L10:
        int r6 = 0;
    L12:
        if (r6 >= r5.length()) goto L23;
        String r0 = r5.optString(r6);
        if (TextUtils.isEmpty(r0) == true) goto L16;
        r4.add(r0);
    L16:
        r6 = r6 + 1;
        goto L12
    L23:
        return;
    L22:
        return;
    }

    public static SamplingSettingProvider.SlaSamplingSetting create(JSONObject r24, int r25) {
        if (r25 <= 0) goto L56;
        if (r24 == null) goto L56;
        JSONObject r3 = r24.optJSONObject(SlardarSettingsConsts.SETTING_NETWORK_IMAGE_MODULES);     // Catch: Exception -> L54
        JSONObject r0 = r24.optJSONObject("custom_event_settings");     // Catch: Exception -> L54
        if (r3 == null) goto L9;
        r3 = r3.optJSONObject("network");     // Catch: Exception -> L54
    L9:
        if (r3 != null) goto L11;
    L12:
        if (r0 != null) goto L14;
    L53:
        return null;
    L14:
        if (r0.length() <= 0) goto L53;
    L17:
        if (r3 == null) goto L37;
        JSONObject r5 = r3.optJSONObject("api_allow_list");     // Catch: Exception -> L54
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L54
        boolean r8 = parseJSONObjectList(r3, KEY_API_ALLOW_LIST_PATH_EQUAL, r7) | false;     // Catch: Exception -> L54
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L54
        boolean r10 = r8 | parseJSONObjectList(r3, KEY_API_ALLOW_LIST_PATH_PREFIX, r9);     // Catch: Exception -> L54
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L54
        boolean r12 = r10 | parseJSONObjectList(r3, KEY_API_ALLOW_LIST_PATH_CONTAIN, r11);     // Catch: Exception -> L54
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L54
        boolean r14 = r12 | parseJSONObjectList(r3, KEY_API_ALLOW_LIST_PATH_REGEX, r13);     // Catch: Exception -> L54
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L54
        boolean r16 = r14 | parseJSONObjectList(r3, KEY_API_ALLOW_LIST_HOST_PATTERN, r15);     // Catch: Exception -> L54
        ArrayList r17 = new ArrayList();     // Catch: Exception -> L54
        boolean r18 = r16 | parseJSONObjectList(r3, KEY_API_ALLOW_LIST_URL_REGEX, r17);     // Catch: Exception -> L54
        if (r6 == true) goto L28;
        if (r18 == false) goto L37;
    L28:
        ArrayList r19 = new ArrayList();     // Catch: Exception -> L54
        parseJSONArrayList(r3, "api_block_list", r19);     // Catch: Exception -> L54
        if (Math.abs(r3.optDouble("enable_base_api_all")) <= sTolerance) goto L31;
        boolean r110 = true;
    L33:
        if (r3.optInt("enable_api_all_upload") != 1) goto L35;
        boolean r111 = true;
    L36:
        SamplingSettingProvider.SlaSamplingRule r20 = new SamplingSettingProvider.SlaSamplingRule(r110, r111, (String[]) r19.toArray(new String[0]), (String[]) r7.toArray(new String[0]), (String[]) r11.toArray(new String[0]), (String[]) r9.toArray(new String[0]), (String[]) r13.toArray(new String[0]), (String[]) r17.toArray(new String[0]), (String[]) r15.toArray(new String[0]));     // Catch: Exception -> L54
    L38:
        if (r0 == null) goto L42;
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L54
        if (parseJSONObjectListWithFilter(r0, "allow_log_type", r4, EVENT_LOG_TYPES) == false) goto L42;
        SamplingSettingProvider.SlaEventLogSamplingRule r1 = new SamplingSettingProvider.SlaEventLogSamplingRule((String[]) r4.toArray(new String[0]));     // Catch: Exception -> L54
    L43:
        if (r20 != null) goto L46;
        if (r1 != null) goto L46;
        return null;
    L46:
        SamplingSettingProvider.SlaSamplingSetting r21 = new SamplingSettingProvider.SlaSamplingSetting(r25, r20, r1);     // Catch: Exception -> L54
        SamplingSettingProvider.SlaSamplingSetting r2 = sOriginSetting;     // Catch: Exception -> L54
        if (r2 != null) goto L49;
    L51:
        sOriginSetting = r21;     // Catch: Exception -> L54
        return r21;
    L49:
        if (r2.equals(r21) == false) goto L51;
        return null;
    L42:
        r1 = null;
        goto L43
    L35:
        r111 = false;
        goto L36
    L31:
        r110 = false;
        goto L33
    L21:
        if (r5.length() == 0) goto L24;
        r6 = false;
    L37:
        r20 = null;
        goto L38
    L11:
        if (r3.length() > 0) goto L17;
    L54:
        e = move-exception;
        e.printStackTrace();
    L56:
        return null;
    }
}
