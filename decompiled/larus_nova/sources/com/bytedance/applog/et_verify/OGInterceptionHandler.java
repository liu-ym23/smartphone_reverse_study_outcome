package com.bytedance.applog.et_verify;

import android.text.TextUtils;
import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class OGInterceptionHandler {
    private static final Pattern EVENT_INDEX_PATTERN = null;
    private static final List<String> EVENT_TYPE_LIST = null;
    private static final String OG_ERROR_KEYWORD = "Operations Gateway";
    private static final String OG_REJECTED_FIELDS_MARKER = "__og_rejected_fields";
    private static final String OG_REJECTED_MARKER = "__og_rejected";
    private static final List<String> PRE_REJECTED_FIELDS = null;
    private static final String REJECTED_FIELDS_KEY = "rejected_fields";
    private static final String TAG = "OGInterceptionHandler";
    private final Map<String, Set<String>> preRejectedFields;

    static {
        EVENT_INDEX_PATTERN = PatternProtector.compile("<#>(\\d+)");
        PRE_REJECTED_FIELDS = Collections.singletonList("user_id");
        EVENT_TYPE_LIST = Arrays.asList(new String[]{"event_v3", "event", com.ss.android.common.applog.EventVerify.TYPE_LAUNCH, com.ss.android.common.applog.EventVerify.TYPE_TERMINATE, "log_data"});
    }

    public OGInterceptionHandler() {
        this.preRejectedFields = new HashMap();
    }

    private static i getLogger() {
        return n.w();
    }

    public static List<String> getPreRejectedFields() {
        return PRE_REJECTED_FIELDS;
    }

    private int parseEventIndex(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        Matcher r101 = EVENT_INDEX_PATTERN.matcher(r100);
        if (r101.find() == true) goto L12;
    L11:
        return -1;
    L12:
        return CastIntegerProtector.parseInt(r101.group(1));
    L10:
        getLogger().m(6, "Failed to parse event index: {}", new Object[]{r100});
        goto L11
    }

    public boolean isOGRejection(JSONObject r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.optString("error").contains(OG_ERROR_KEYWORD);
    }

    public List<String> parseRejectedFields(JSONObject r100) {
        if (r100 != null) goto L22;
        return null;
    L22:
        JSONArray r101 = r100.optJSONArray(REJECTED_FIELDS_KEY);     // Catch: Throwable -> L19
        if (r101 != null) goto L10;
        getLogger().m(6, "No rejected_fields found in error response", new Object[0]);     // Catch: Throwable -> L19
        return null;
    L10:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L19
        int r103 = 0;
    L12:
        if (r103 >= r101.length()) goto L17;
        String r104 = r101.optString(r103);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r102.add(r104);     // Catch: Throwable -> L19
    L16:
        r103 = r103 + 1;     // Catch: Throwable -> L19
        goto L12
    L17:
        getLogger().b(6, "Parsed rejected fields: {}", new Object[]{r102});     // Catch: Throwable -> L19
        return r102;
    L19:
        th = move-exception;
        getLogger().o(6, "Failed to parse rejected fields from error response", th, new Object[0]);
        return null;
    }

    public boolean preHandleOGRejection(JSONObject r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<String> r102 = this.preRejectedFields.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();
        Set<String> r104 = this.preRejectedFields.get(r103);
        if (r104 == null) goto L7;
        if (r104.isEmpty() == true) goto L7;
        if (preHandleHeader(r100, r103, r104) == false) goto L16;
        r101 = true;
    L16:
        if (preHandleEvents(r100, r103, r104) == false) goto L7;
        r101 = true;
        goto L7
    L18:
        return r101;
    }

    private void addOGRejectionMarker(JSONObject r100, String r101) {
        r100.put(OG_REJECTED_MARKER, 1);     // Catch: JSONException -> L8
        JSONArray r102 = r100.optJSONArray(OG_REJECTED_FIELDS_MARKER);     // Catch: JSONException -> L8
        if (r102 != null) goto L6;
        r102 = new JSONArray();     // Catch: JSONException -> L8
        r100.put(OG_REJECTED_FIELDS_MARKER, r102);     // Catch: JSONException -> L8
    L6:
        r102.put(r101);     // Catch: JSONException -> L8
        getLogger().b(6, "Added OG rejection marker for field: {}", new Object[]{r101});     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        getLogger().o(6, "Failed to add OG rejection marker", e, new Object[0]);
    }

    public static String concatWithStringJoin(String[] r100, int r101) {
        if (r100 == null) goto L15;
        if (r101 >= 0) goto L5;
        return null;
    L5:
        if (r101 >= r100.length) goto L19;
        String[] r102 = (String[]) Arrays.copyOfRange(r100, r101, r100.length);
        StringBuilder r103 = new StringBuilder();
        if (r102.length <= 0) goto L14;
        r103.append(r102[0]);
        int r104 = 1;
    L11:
        if (r104 >= r102.length) goto L14;
        r103.append(".");
        r103.append(r102[r104]);
        r104 = r104 + 1;
    L14:
        return r103.toString();
    L19:
        return null;
    L15:
        return null;
    }

    public JSONObject cleanSensitiveFields(JSONObject r100, List<String> r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r101.isEmpty() == true) goto L18;
        JSONObject r102 = new JSONObject(r100.toString());     // Catch: JSONException -> L16
        Iterator<String> r103 = r101.iterator();     // Catch: JSONException -> L16
    L10:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();     // Catch: JSONException -> L16
        if (r104.startsWith("ReqBody.") == false) goto L10;
        cleanFieldByPath(r102, r104.substring(8), r104);     // Catch: JSONException -> L16
        goto L10
    L14:
        getLogger().b(6, "Cleaned sensitive fields, rejected count: {}", new Object[]{Integer.valueOf(r101.size())});     // Catch: JSONException -> L16
        return r102;
    L16:
        e = move-exception;
        getLogger().o(6, "Failed to clean sensitive fields", e, new Object[0]);
    L18:
        return r100;
    }

    public JSONObject handleOGRejection(JSONObject r100, JSONObject r101) {
        if (r100 != null) goto L6;
        getLogger().m(6, "No error response body found for OG rejection", new Object[0]);     // Catch: Exception -> L18
        return null;
    L6:
        List<String> r102 = parseRejectedFields(r100);     // Catch: Exception -> L18
        if (r102 != null) goto L9;
    L16:
        getLogger().m(6, "No rejected fields found in OG rejection response", new Object[0]);     // Catch: Exception -> L18
        return null;
    L9:
        if (r102.isEmpty() == true) goto L16;
        JSONObject r103 = cleanSensitiveFields(r101, r102);     // Catch: Exception -> L18
        if (r103 != null) goto L15;
        getLogger().d(new Object[0]);     // Catch: Exception -> L18
        return null;
    L15:
        return r103;
    L18:
        e = move-exception;
        getLogger().o(6, "Failed to handle OG rejection and retry", e, new Object[0]);
        return null;
    }

    private void cleanDirectField(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L21;
        return;
    L21:
    L18:
        e = move-exception;
        getLogger().o(6, "Failed to clean direct field: " + r101, e, new Object[0]);
        return;
    L5:
        if (r100.has(r101) == true) goto L7;
        return;
    L7:
        if (PRE_REJECTED_FIELDS.contains(r101) == false) goto L16;
        Set<String> r103 = this.preRejectedFields.get(r101);     // Catch: JSONException -> L18
        if (r103 != null) goto L11;
        r103 = new HashSet();     // Catch: JSONException -> L18
        this.preRejectedFields.put(r101, r103);     // Catch: JSONException -> L18
    L11:
        Object r104 = r100.opt(r101);     // Catch: JSONException -> L18
        if (r104 == null) goto L16;
        if (JSONObject.NULL == r104) goto L16;
        r103.add(String.valueOf(r104));     // Catch: JSONException -> L18
    L16:
        r100.put(r101, JSONObject.NULL);     // Catch: JSONException -> L18
        getLogger().b(6, "Cleaned direct field: {}", new Object[]{r101});     // Catch: JSONException -> L18
    }

    private void cleanFieldByPath(JSONObject r100, String r101, String r102) {
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length >= 2) goto L6;
        getLogger().m(6, "Invalid field path: {}", new Object[]{r101});
        return;
    L6:
        String r104 = r103[0];
        if (EVENT_TYPE_LIST.contains(r104) == false) goto L10;
        cleanEventArrayFieldByPath(r100, r102, r103, r104);
        return;
    L10:
        if ("header".equals(r104) == false) goto L14;
        cleanHeaderFieldByPath(r100, r102, r103);
        return;
    }

    private void cleanHeaderFieldByPath(JSONObject r100, String r101, String[] r110) {
        JSONObject r102 = r100.optJSONObject("header");
        if (r102 != null) goto L6;
        getLogger().m(6, "Header object not found", new Object[0]);
        return;
    L6:
        JSONObject r103 = r102.optJSONObject("custom");
        if (r110.length < 2) goto L14;
        String r104 = r110[1];
        if ("custom".equals(r104) == true) goto L11;
    L13:
        cleanDirectField(r102, r104, r101);
        goto L14
    L11:
        if (r110.length < 3) goto L13;
        cleanDirectField(r103, r110[2], r101);
    L14:
        if (r103 == null) goto L20;
        addOGRejectionMarker(r103, concatWithStringJoin(r110, 1));
        return;
    L20:
        r102.put("custom", new JSONObject());     // Catch: JSONException -> L19
        return;
    }

    private boolean preHandleBlockList(String r100, JSONObject r101, Set<String> r102) {
        Object r103 = r101.opt(r100);
        if (r103 != null) goto L5;
        return false;
    L5:
        if (r102.contains(String.valueOf(r103)) == false) goto L15;
        r101.put(r100, JSONObject.NULL);     // Catch: JSONException -> L11
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    private boolean preHandleEvents(JSONObject r110, String r111, Set<String> r112) {
        Iterator<String> r100 = EVENT_TYPE_LIST.iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L31;
        String r102 = r100.next();
        JSONArray r103 = r110.optJSONArray(r102);
        if (r103 == null) goto L4;
        int r104 = 0;
    L9:
        if (r104 >= r103.length()) goto L4;
        JSONObject r105 = r103.optJSONObject(r104);
        if (r105 == null) goto L30;
        if ("event_v3".equals(r102) == false) goto L27;
        JSONObject r106 = r105.optJSONObject("params");
        if (r106 == null) goto L20;
        if (preHandleBlockList(r111, r106, r112) == false) goto L20;
        addOGRejectionMarker(r106, "params." + r111);
        r101 = true;
    L20:
        if (preHandleBlockList(r111, r105, r112) == false) goto L30;
        if (r106 == null) goto L36;
    L25:
        addOGRejectionMarker(r106, r111);
    L29:
        r101 = true;
        goto L30
    L36:
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L33
        r105.put("params", r107);     // Catch: JSONException -> L32
    L24:
        r106 = r107;
        goto L25
    L27:
        if (preHandleBlockList(r111, r105, r112) == false) goto L30;
        addOGRejectionMarker(r105, r111);
    L30:
        r104 = r104 + 1;
        goto L9
    L31:
        return r101;
    }

    private boolean preHandleHeader(JSONObject r100, String r101, Set<String> r102) {
        JSONObject r103 = r100.optJSONObject("header");
        boolean r104 = false;
        if (r103 == null) goto L19;
        JSONObject r105 = r103.optJSONObject("custom");
        if (r105 == null) goto L10;
        if (preHandleBlockList(r101, r105, r102) == false) goto L10;
        addOGRejectionMarker(r105, "custom." + r101);
        r104 = true;
    L10:
        if (preHandleBlockList(r101, r103, r102) == false) goto L20;
        if (r105 != null) goto L14;
        r105 = new JSONObject();
        r103.put("custom", r105);     // Catch: JSONException -> L16
    L14:
        addOGRejectionMarker(r105, r101);
        return true;
    L20:
        return r104;
    L19:
        return false;
    }

    private void cleanEventArrayFieldByPath(JSONObject r100, String r101, String[] r110, String r111) {
        String r102 = r110[1];
        JSONArray r103 = r100.optJSONArray(r111);
        if (r103 != null) goto L6;
        getLogger().m(6, "Event array not found for type: {}", new Object[]{r111});
        return;
    L6:
        int r104 = parseEventIndex(r102);
        if (r104 >= 0) goto L9;
    L32:
        getLogger().m(6, "Invalid event index: {} for array size: {}", new Object[]{Integer.valueOf(r104), Integer.valueOf(r103.length())});
        return;
    L9:
        if (r104 >= r103.length()) goto L32;
        JSONObject r105 = r103.optJSONObject(r104);
        if (r105 != null) goto L15;
        getLogger().m(6, "Event object not found at index: {}", new Object[]{Integer.valueOf(r104)});
        return;
    L15:
        JSONObject r106 = r105.optJSONObject("params");
        if (r110.length < 3) goto L24;
        String r107 = r110[2];
        if ("params".equals(r107) == true) goto L20;
    L22:
        cleanDirectField(r105, r107, r101);
        goto L24
    L20:
        if (r110.length < 4) goto L22;
        cleanDirectField(r106, r110[3], r101);
    L24:
        if ("event_v3".equals(r111) == false) goto L30;
        if (r106 == null) goto L38;
    L29:
        addOGRejectionMarker(r106, concatWithStringJoin(r110, 2));
        return;
    L38:
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L35
        r105.put("params", r108);     // Catch: JSONException -> L34
    L28:
        r106 = r108;
        goto L29
    L30:
        addOGRejectionMarker(r105, concatWithStringJoin(r110, 2));
    }
}
