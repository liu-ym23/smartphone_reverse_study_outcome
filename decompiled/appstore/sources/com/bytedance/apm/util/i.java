package com.bytedance.apm.util;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L19;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L21;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L12
    L9:
        if (r12.hasNext() == false) goto L22;
        String r13 = r12.next();     // Catch: JSONException -> L12
        r10.put(r13, r11.get(r13));     // Catch: JSONException -> L12
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

    public static JSONObject b(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.keys();
        if (r12 != null) goto L9;
        return null;
    L9:
        if (r12.hasNext() == false) goto L16;
        r11.add(r12.next());
        goto L9
    L16:
        return new JSONObject(r10, (String[]) r11.toArray(new String[0]));
    L13:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static JSONObject c(JSONObject r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r10.toString());
    L7:
        return r10;
    }

    public static boolean d(JSONObject r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static boolean e(JSONObject r10, String r11, String r12, boolean r13) {
        if (r10 != null) goto L4;
        return r13;
    L4:
        JSONObject r14 = r10.optJSONObject(r11);
        if (r14 != null) goto L8;
        return r13;
    L8:
        return r14.optBoolean(r12, r13);
    }

    public static int f(JSONObject r10, String r11, String r12, String r13) {
        JSONObject r14 = g(r10, r11, r12);
        if (r14 != null) goto L6;
        return 0;
    L6:
        return r14.optInt(r13, 0);
    }

    public static JSONObject g(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.optJSONObject(r12);
    }

    public static JSONObject h(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r11 = r10.keys();
        if (r11 != null) goto L15;
        return null;
    L15:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r11.hasNext() == false) goto L13;
        String r13 = r11.next();     // Catch: Exception -> L14
        r12.put(r13, r10.opt(r13));     // Catch: Exception -> L14
        goto L10
    L13:
        return r12;
    L14:
        return r10;
    }

    public static JSONArray i(JSONArray r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = r10.length();
        if (r11 != 0) goto L20;
        return r10;
    L20:
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L19
        int r13 = 0;
    L9:
        if (r13 >= r11) goto L18;
        Object r14 = r10.get(r13);     // Catch: Throwable -> L19
        if ((r14 instanceof JSONObject) == false) goto L14;
        r12.put(j((JSONObject) r14));     // Catch: Throwable -> L19
    L17:
        r13 = r13 + 1;
        goto L9
    L14:
        if ((r14 instanceof JSONArray) == false) goto L16;
        r12.put(i((JSONArray) r14));     // Catch: Throwable -> L19
        goto L17
    L16:
        r12.put(r14);     // Catch: Throwable -> L19
    L18:
        return r10;
    }

    public static JSONObject j(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r11 = r10.keys();
        if (r11 != null) goto L21;
        return r10;
    L21:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L20
    L9:
        if (r11.hasNext() == false) goto L19;
        String r13 = r11.next();     // Catch: Throwable -> L20
        Object r14 = r10.opt(r13);     // Catch: Throwable -> L20
        if ((r14 instanceof JSONObject) == true) goto L13;
        if ((r14 instanceof JSONArray) == true) goto L16;
        r12.put(r13, r14);     // Catch: Throwable -> L20
        goto L9
    L16:
        r12.put(r13, i((JSONArray) r14));     // Catch: Throwable -> L20
        goto L9
    L13:
        r12.put(r13, j((JSONObject) r14));     // Catch: Throwable -> L20
        goto L9
    L19:
        return r12;
    L20:
        return r10;
    }
}
