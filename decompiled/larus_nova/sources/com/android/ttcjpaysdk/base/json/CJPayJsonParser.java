package com.android.ttcjpaysdk.base.json;

import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.caijing.sdk.infra.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayJsonParser {
    public static final String ORIGINAL_JSON_KEY = "originalJson";

    public CJPayJsonParser() {
    }

    private static <T extends CJPayObject> T createObject(Class<T> r100) {
        return r100.newInstance();
    L4:
        return null;
    }

    private static <T extends CJPayObject> Field[] getDeclaredFields(Class<T> r100) {
        return r100.getDeclaredFields();
    L4:
        return null;
    }

    private static <T extends CJPayObject> Field[] getFields(Class<T> r100) {
        return r100.getFields();
    L4:
        return null;
    }

    private static String getUrlForJson(JSONObject r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        String r101 = r100.optString("cj_pay_network_api_to_json_url");     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        Uri r102 = UriProtector.parse(r101);     // Catch: Throwable -> L9
        return r102.getScheme() + "://" + r102.getHost() + r102.getPath();
    L12:
        return "";
    L13:
        return "";
    }

    private static <T extends CJPayObject> JSONObject internalToJsonObject(T r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        JSONObject r100 = new JSONObject();
        Field[] r101 = getDeclaredFields(r110.getClass());
        if (r101 != null) goto L8;
    L74:
        return null;
    L8:
        if (r101.length == 0) goto L74;
        int r102 = r101.length;     // Catch: Exception -> L75
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L73;
        Field r104 = r101[r103];     // Catch: Exception -> L75
        r104.setAccessible(true);     // Catch: Exception -> L75
        if (r104.getAnnotation(CJPayIgnore.class) != null) goto L72;
        Class<?> r105 = r104.getType();     // Catch: Exception -> L75
        Object r106 = r104.get(r110);     // Catch: Exception -> L75
        if (r106 == null) goto L72;
        String r107 = r104.getName();     // Catch: Exception -> L75
        if (r105.isPrimitive() == false) goto L21;
    L71:
        r100.put(r107, r106);     // Catch: Exception -> L75
        goto L72
    L21:
        if (r105.equals(String.class) == true) goto L71;
        if (List.class.isAssignableFrom(r105) == false) goto L44;
        Class r108 = (Class) ((ParameterizedType) r104.getGenericType()).getActualTypeArguments()[0];     // Catch: Exception -> L75
        if (CJPayObject.class.isAssignableFrom(r108) == false) goto L33;
        JSONArray r109 = new JSONArray();     // Catch: Exception -> L75
        Iterator r111 = ((List) r106).iterator();     // Catch: Exception -> L75
    L29:
        if (r111.hasNext() == false) goto L31;
        r109.put(internalToJsonObject((CJPayObject) r111.next()));     // Catch: Exception -> L75
        goto L29
    L31:
        r100.put(r107, r109);     // Catch: Exception -> L75
        goto L72
    L33:
        if (r108.isPrimitive() == false) goto L35;
    L38:
        JSONArray r112 = new JSONArray();     // Catch: Exception -> L75
        Iterator r113 = ((List) r106).iterator();     // Catch: Exception -> L75
    L40:
        if (r113.hasNext() == false) goto L42;
        r112.put(r113.next());     // Catch: Exception -> L75
        goto L40
    L42:
        r100.put(r107, r112);     // Catch: Exception -> L75
        goto L72
    L35:
        if (r108.equals(String.class) == true) goto L38;
        if (r108.equals(Integer.class) == false) goto L72;
    L44:
        if (Map.class.isAssignableFrom(r105) == false) goto L66;
        Type[] r114 = ((ParameterizedType) r104.getGenericType()).getActualTypeArguments();     // Catch: Exception -> L75
        if (r114[0].equals(String.class) == false) goto L57;
        if (r114[1].equals(String.class) == false) goto L57;
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L75
        Iterator r116 = ((Map) r106).entrySet().iterator();     // Catch: Exception -> L75
    L51:
        if (r116.hasNext() == false) goto L54;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Exception -> L75
        r115.put((String) r117.getKey(), r117.getValue());     // Catch: Exception -> L75
        goto L51
    L54:
        if (r115.keys().hasNext() == false) goto L72;
        r100.put(r107, r115);     // Catch: Exception -> L75
    L57:
        if (r114[0].equals(String.class) == false) goto L72;
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L75
        Iterator r119 = ((Map) r106).entrySet().iterator();     // Catch: Exception -> L75
    L60:
        if (r119.hasNext() == false) goto L63;
        Map.Entry r120 = (Map.Entry) r119.next();     // Catch: Exception -> L75
        r118.put((String) r120.getKey(), internalToJsonObject((CJPayObject) r120.getValue()));     // Catch: Exception -> L75
        goto L60
    L63:
        if (r118.keys().hasNext() == false) goto L72;
        r100.put(r107, r118);     // Catch: Exception -> L75
        goto L72
    L66:
        if (CJPayObject.class.isAssignableFrom(r105) == false) goto L69;
        r100.put(r107, internalToJsonObject((CJPayObject) r106));     // Catch: Exception -> L75
        goto L72
    L69:
        if (JSONObject.class.isAssignableFrom(r105) == false) goto L72;
        r100.put(r107, r106);     // Catch: Exception -> L75
    L72:
        r103 = r103 + 1;
    L73:
        return r100;
    }

    private static JSONObject toJSONObject(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r100;
    L7:
        if ((r100 instanceof String) == true) goto L12;
    L10:
        return null;
    L12:
        return new JSONObject((String) r100);
    }

    public static <T extends CJPayObject> JSONArray toJsonArray(ArrayList<T> r100) {
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.iterator();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        r101.put(toJsonObject(r102.next()));     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        CJLogger.b("CJPayJsonParser", e.toString());
        goto L10
    }

    public static <T extends CJPayObject> JSONObject toJsonObject(T r100) {
        return internalToJsonObject(r100);
    }

    private static String toString(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return String.valueOf(r100);
    L5:
        return (String) r100;
    }

    private static boolean willSend(JSONObject r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.has("cj_pay_network_api_to_json_url") == false) goto L6;
        return true;
    }

    public static <T extends CJPayObject> T fromJson(JSONObject r110, Class<T> r111) {
        long r100 = System.currentTimeMillis();
        T r101 = (T) internalFromJson(r110, r111);
        if (willSend(r110) == false) goto L5;
        sendMonitor("json2obj", r111, System.currentTimeMillis() - r100, r110.length(), r110);
    L5:
        return r101;
    }

    private static boolean hasValue(JSONObject r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        return !r100.isNull(r101);
    L7:
        return false;
    }

    private static <T extends CJPayObject> T internalFromJson(JSONObject r110, Class<T> r111) {
        T r100 = (T) createObject(r111);
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r110 != null) goto L7;
        return r100;
    L7:
        Field[] r101 = getFields(r111);
        if (r101 != null) goto L10;
    L117:
        return r100;
    L10:
        if (r101.length <= 0) goto L117;
        int r102 = r101.length;
        char r103 = 0;
        int r104 = 0;
    L13:
        if (r104 >= r102) goto L117;
        Field r105 = r101[r104];
        if (Modifier.isFinal(r105.getModifiers()) == true) goto L116;
        r105.setAccessible(true);     // Catch: Exception -> L87
        Class<?> r106 = r105.getType();     // Catch: Exception -> L87
        if (TextUtils.equals(r105.getName(), ORIGINAL_JSON_KEY) == false) goto L25;
        if (hasValue(r110, r105.getName()) == false) goto L23;
        r105.set(r100, r110.opt(r105.getName()));     // Catch: Exception -> L87
        goto L116
    L23:
        r105.set(r100, r110);     // Catch: Exception -> L87
        goto L116
    L25:
        if (r106.isPrimitive() == false) goto L34;
        if (hasValue(r110, r105.getName()) == false) goto L116;
        Object r112 = r110.opt(r105.getName());     // Catch: Exception -> L87
        r105.set(r100, r112);     // Catch: Exception -> L31
    L31:
        e = e;
    L115:
        String r107 = "fieldName:" + r105.getName() + ",fieldType:" + r105.getType().getSimpleName() + ",setValue:" + g.a(r112);
        CJReporter r108 = CJReporter.f202294a;
        CJReporter.l(null, "jsonParseFail", 1, r107, e);
        goto L116
    L34:
        if (List.class.isAssignableFrom(r106) == false) goto L54;
        ArrayList r109 = new ArrayList();     // Catch: Exception -> L87
        Class r113 = (Class) ((ParameterizedType) r105.getGenericType()).getActualTypeArguments()[r103];     // Catch: Exception -> L87
        JSONArray r114 = r110.optJSONArray(r105.getName());     // Catch: Exception -> L87
        if (r114 == null) goto L116;
        int r115 = 0;
    L39:
        if (r115 >= r114.length()) goto L51;
        JSONArray r116 = r110.optJSONArray(r105.getName());     // Catch: Exception -> L87
        if (r116 == null) goto L50;
        JSONObject r117 = r116.optJSONObject(r115);     // Catch: Exception -> L87
        if (r117 == null) goto L48;
        CJPayObject r118 = internalFromJson(r117, r113);     // Catch: Exception -> L87
        if (r118 == null) goto L50;
        r109.add(r118);     // Catch: Exception -> L87
        goto L50
    L48:
        if (hasValue(r116, r115) == false) goto L50;
        r109.add(r116.opt(r115));     // Catch: Exception -> L87
    L50:
        r115 = r115 + 1;     // Catch: Exception -> L87
        goto L39
    L51:
        r105.set(r100, r109);     // Catch: Exception -> L87
        goto L116
    L54:
        if (Map.class.isAssignableFrom(r106) == false) goto L73;
        HashMap r119 = new HashMap();     // Catch: Exception -> L87
        JSONObject r120 = r110.optJSONObject(r105.getName());     // Catch: Exception -> L87
        Class r121 = (Class) ((ParameterizedType) r105.getGenericType()).getActualTypeArguments()[1];     // Catch: Exception -> L87
        if (r120 == null) goto L116;
        Iterator<String> r122 = r120.keys();     // Catch: Exception -> L87
    L59:
        if (r122.hasNext() == false) goto L71;
        String r123 = r122.next();     // Catch: Exception -> L87
        JSONObject r124 = r120.optJSONObject(r123);     // Catch: Exception -> L65
        if (r124 == null) goto L66;
        CJPayObject r125 = internalFromJson(r124, r121);     // Catch: Exception -> L65
    L67:
        if (r125 == null) goto L69;
        r119.put(r123, r125);     // Catch: Exception -> L87
        goto L59
    L69:
        r119.put(r123, r120.optString(r123));     // Catch: Exception -> L87
        goto L59
    L66:
        r125 = null;
    L65:
        CJReporter r126 = CJReporter.f202294a;     // Catch: Exception -> L87
        CJReporter.k(null, "json_parser_exception", 2, "map解析异常 obj=" + r100 + "  field=" + r105.getName() + " fieldType:" + r105.getType());     // Catch: Exception -> L87
        goto L66
    L71:
        r105.set(r100, r119);     // Catch: Exception -> L87
        goto L116
    L73:
        if (String.class.isAssignableFrom(r106) == false) goto L81;
        if (hasValue(r110, r105.getName()) == false) goto L116;
        Object r127 = r110.opt(r105.getName());     // Catch: Exception -> L87
        if ((r127 instanceof String) == true) goto L79;
        CJReporter r128 = CJReporter.f202294a;     // Catch: Exception -> L87
        CJReporter.k(null, "json_parser_exception", 2, "bean is String, data is not String obj=" + r100 + "  field=" + r105.getName() + " value:" + r127 + " fieldType:" + r105.getType());     // Catch: Exception -> L87
    L79:
        r105.set(r100, toString(r127));     // Catch: Exception -> L87
        goto L116
    L81:
        if (JSONObject.class.isAssignableFrom(r106) == false) goto L91;
        if (hasValue(r110, r105.getName()) == false) goto L116;
        Object r129 = r110.opt(r105.getName());     // Catch: Exception -> L87
        if ((r129 instanceof JSONObject) == true) goto L89;
        CJReporter r130 = CJReporter.f202294a;     // Catch: Exception -> L87
        CJReporter.k(null, "json_parser_exception", 2, "bean is JSONObject, data is not JSONObject obj=" + r100 + "  field=" + r105.getName());     // Catch: Exception -> L87
    L89:
        r105.set(r100, toJSONObject(r129));     // Catch: Exception -> L87
        goto L116
    L91:
        if (CJPayObject.class.isAssignableFrom(r106) == false) goto L105;
        if (hasValue(r110, r105.getName()) == false) goto L116;
        Object r131 = r110.opt(r105.getName());     // Catch: Exception -> L87
        if ((r131 instanceof JSONObject) == false) goto L100;
        CJPayObject r132 = internalFromJson((JSONObject) r131, r106);     // Catch: Exception -> L87
        if (r132 == null) goto L116;
        r105.set(r100, r132);     // Catch: Exception -> L87
        goto L116
    L100:
        if ((r131 instanceof String) == false) goto L116;
        CJPayObject r133 = internalFromJson((String) r131, r106);     // Catch: Exception -> L87
        if (r133 == null) goto L116;
        r105.set(r100, r133);     // Catch: Exception -> L87
        goto L116
    L105:
        if (Integer.class.isAssignableFrom(r106) == false) goto L116;
        if (hasValue(r110, r105.getName()) == false) goto L116;
        Object r134 = r110.opt(r105.getName());     // Catch: Exception -> L87
        if (r134 == null) goto L116;
        if ((r134 instanceof Integer) == false) goto L116;
        r105.set(r100, r134);     // Catch: Exception -> L31
    L87:
        e = e;
        r112 = null;
    L116:
        r104 = r104 + 1;
        r103 = 0;
        goto L13
    }

    public static void setMapData(Map<String, String> r100, JSONObject r101) {
        if (r101 == null) goto L10;
        if (r100 == null) goto L16;
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L11
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L11
        r100.put(r103, r101.optString(r103));     // Catch: Exception -> L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static <T extends CJPayObject> T fromJson(final String r100, final Class<T> r101) {
        long r102 = System.currentTimeMillis();
        T r103 = (T) internalFromJson(r100, r101);
        final long r104 = System.currentTimeMillis() - r102;
        b.a(new AnonymousClass1(r101, r104, r100), 0);
        return r103;
    }

    private static boolean hasValue(JSONArray r100, int r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return !r100.isNull(r101);
    }

    private static <T extends CJPayObject> T internalFromJson(String r100, Class<T> r101) {
        if (r100 == null) goto L11;
        if (r100.isEmpty() == true) goto L11;
        return (T) internalFromJson(new JSONObject(r100), r101);
    L9:
        return (T) createObject(r101);
    L11:
        return (T) createObject(r101);
    }

    public static /* synthetic */ void access$000(String r100, Class r101, long r102, long r103, JSONObject r104) {
        sendMonitor(r100, r101, r102, r103, r104);
    }

    private static void sendMonitor(String r100, Class r101, long r102, long r103, JSONObject r104) {
        JSONObject r105 = CJPayParamsUtils.getCommonLogParams("", "");     // Catch: Throwable -> L5
        r105.put("type", r100);     // Catch: Throwable -> L5
        r105.put(PushClientConstants.TAG_CLASS_NAME, r101.getName());     // Catch: Throwable -> L5
        r105.put("time", r102);     // Catch: Throwable -> L5
        r105.put("size", r103);     // Catch: Throwable -> L5
        r105.put("url", getUrlForJson(r104));     // Catch: Throwable -> L5
        r105.put("server_type", CJPayHostInfo.serverType);     // Catch: Throwable -> L5
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_json_parser_info", new JSONObject[]{r105});     // Catch: Throwable -> L5
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_json_parser_info", r105);     // Catch: Throwable -> L5
        return;
    }
}
