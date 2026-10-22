package com.bytedance.crash.o;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static boolean a(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean a(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static void a(JSONObject r3, Object... r4) {
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        if ((r4.length % 2) != 0) goto L14;
        if (r4.length == 0) goto L14;
        int r0 = 0;
    L11:
        if (r0 >= r4.length) goto L13;
        a(r3, String.valueOf(r4[r0]), r4[r0 + 1]);
        r0 = r0 + 2;
        goto L11
    L13:
        return;
    L14:
        r.c("JSONUtils", "Err use of addKVs!!!!!");
    }

    public static void a(JSONObject r4, JSONObject r5) {
        Iterator<String> r0 = r5.keys();
    L11:
        if (r0.hasNext() == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r4.has(r1) == true) goto L11;
        r4.put(r1, r5.opt(r1));     // Catch: Throwable -> L10
    L18:
        return;
    }

    public static JSONArray a(JSONObject r1, String... r2) {
        JSONObject r3 = c(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.optJSONArray(r2[r2.length - 1]);
    }

    public static String b(JSONObject r1, String... r2) {
        JSONObject r3 = c(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.optString(r2[r2.length - 1]);
    }

    public static JSONObject c(JSONObject r3, String... r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= (r4.length - 1)) goto L13;
        r3 = r3.optJSONObject(r4[r1]);
        if (r3 == null) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        r.b("JSONUtil", "err get json: not found node:" + r4[r1]);
        return null;
    L13:
        return r3;
    }

    public static HashMap<String, Object> b(JSONObject r5) {
        HashMap<String, Object> r0 = new HashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        r0.put(r2, r5.opt(r2));
        goto L7
    L9:
        return r0;
    }

    public static JSONObject a(JSONObject r1, String r2, Object r3) {
        if (r1 == null) goto L8;
        if (r3 == null) goto L8;
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1.put(r2, r3);     // Catch: JSONException -> L9
    L8:
        return r1;
    }

    public static void a(JSONObject r4, Map<? extends String, ?> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        if (r6 == null) goto L17;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r4.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), r0.getValue());     // Catch: Throwable -> L12
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static JSONObject a(JSONObject r1, String r2) {
        if (r1 != null) goto L4;
    L11:
        return r1;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        JSONObject r0 = r1.optJSONObject(r2);
        if (r0 != null) goto L10;
        r0 = new JSONObject();
        r1.put(r2, r0);     // Catch: JSONException -> L12
    L10:
        return r0;
    }

    public static void b(JSONObject r7, JSONObject r8) {
        if (r7 == null) goto L33;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.length() <= 0) goto L58;
        Iterator<String> r1 = r8.keys();     // Catch: JSONException -> L34
    L9:
        if (r1.hasNext() == false) goto L60;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L34
        Object r3 = r7.opt(r2);     // Catch: JSONException -> L34
        if (r3 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L19;
        r7.put(r2, r8.opt(r2));     // Catch: JSONException -> L34
        goto L9
    L19:
        JSONArray r4 = r8.optJSONArray(r2);     // Catch: JSONException -> L34
        if (r4 == null) goto L9;
        JSONArray r5 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L34
        int r6 = 0;
        if (r5.length() != 1) goto L29;
        if (ZeusTransformUtils.instanceOf(r5.opt(0), JSONObject.class) == false) goto L29;
        if (ZeusTransformUtils.instanceOf(r4.opt(0), JSONObject.class) == false) goto L29;
        b(r5.getJSONObject(0), r4.getJSONObject(0));     // Catch: JSONException -> L34
    L29:
        if (r6 >= r4.length()) goto L9;
        r5.put(r4.get(r6));     // Catch: JSONException -> L34
        r6 = r6 + 1;     // Catch: JSONException -> L34
        goto L29
    L16:
        b(r7.getJSONObject(r2), r8.getJSONObject(r2));     // Catch: JSONException -> L34
        goto L9
    L13:
        r7.put(r2, r8.opt(r2));     // Catch: JSONException -> L34
        goto L9
    L60:
        return;
    L59:
        return;
    L58:
        return;
    }

    public static void b(JSONObject r4, Map<String, ? extends Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        if (r6 == null) goto L17;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r4.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), r0.getValue());     // Catch: Throwable -> L12
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static JSONObject a(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static void b(JSONObject r0, String r1, String r2) {
        if (r2 == null) goto L8;
        r0.put(r1, r2);     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void b(JSONObject r0, String r1, Object r2) {
        if (r2 == null) goto L8;
        r0.put(r1, String.valueOf(r2));     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void a(JSONObject r0, String r1, long r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    }
}
