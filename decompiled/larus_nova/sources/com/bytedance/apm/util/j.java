package com.bytedance.apm.util;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static JSONObject a(JSONObject r100) {
        LinkedList r101 = new LinkedList();
        Iterator<String> r102 = r100.keys();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.hasNext() == false) goto L14;
        r101.add(r102.next());
        goto L7
    L14:
        return new JSONObject(r100, (String[]) r101.toArray(new String[0]));
    L11:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static boolean c(JSONObject r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static JSONArray f(JSONArray r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length();
        if (r101 != 0) goto L20;
        return r100;
    L20:
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L19
        int r103 = 0;
    L9:
        if (r103 >= r101) goto L18;
        Object r104 = r100.get(r103);     // Catch: Throwable -> L19
        if ((r104 instanceof JSONObject) == false) goto L14;
        r102.put(g((JSONObject) r104));     // Catch: Throwable -> L19
    L17:
        r103 = r103 + 1;
        goto L9
    L14:
        if ((r104 instanceof JSONArray) == false) goto L16;
        r102.put(f((JSONArray) r104));     // Catch: Throwable -> L19
        goto L17
    L16:
        r102.put(r104);     // Catch: Throwable -> L19
    L18:
        return r100;
    }

    public static JSONObject g(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<String> r101 = r100.keys();
        if (r101 != null) goto L21;
        return r100;
    L21:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L20
    L9:
        if (r101.hasNext() == false) goto L19;
        String r103 = r101.next();     // Catch: Throwable -> L20
        Object r104 = r100.opt(r103);     // Catch: Throwable -> L20
        if ((r104 instanceof JSONObject) == true) goto L13;
        if ((r104 instanceof JSONArray) == true) goto L16;
        r102.put(r103, r104);     // Catch: Throwable -> L20
        goto L9
    L16:
        r102.put(r103, f((JSONArray) r104));     // Catch: Throwable -> L20
        goto L9
    L13:
        r102.put(r103, g((JSONObject) r104));     // Catch: Throwable -> L20
        goto L9
    L19:
        return r102;
    L20:
        return r100;
    }

    public static void b(JSONObject r100, JSONObject r101) throws JSONException {
        if (r100 == null) goto L13;
        if (r101 == null) goto L19;
        Iterator<String> r102 = r101.keys();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hasNext() == false) goto L20;
        String r103 = r102.next();
        if (r101.isNull(r103) == true) goto L9;
        r100.put(r103, r101.opt(r103));
        goto L9
    L20:
        return;
    L19:
        return;
    }

    public static int d(JSONObject r100, String r101, String r102) {
        JSONObject r103 = e(r100, "performance_modules", r101);
        if (r103 != null) goto L6;
        return 0;
    L6:
        return r103.optInt(r102, 0);
    }

    public static JSONObject e(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r103 = r100.optJSONObject(r101);
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.optJSONObject(r102);
    }
}
