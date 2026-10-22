package com.bytedance.android.gamecp.common.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonParser f57217a = null;

    static {
        f57217a = new JsonParser();
    }

    public static List<Object> b(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L15;
        Object r103 = r100.get(r102);     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        if ((r103 instanceof JSONObject) == false) goto L11;
        r101.add(c((JSONObject) r103));     // Catch: Throwable -> L16
        goto L14
    L11:
        if ((r103 instanceof JSONArray) == false) goto L13;
        r101.add(b((JSONArray) r103));     // Catch: Throwable -> L16
        goto L14
    L13:
        r101.add(r103);     // Catch: Throwable -> L16
    L14:
        r102 = r102 + 1;
        goto L4
    L15:
        return r101;
    }

    public static Map<String, String> c(JSONObject r100) {
        if (r100 == null) goto L4;
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r101.put(r103, r104);
        goto L7
    L11:
        return r101;
    L4:
        return new HashMap();
    }

    public static Map<String, Object> d(JSONObject r100) {
        if (r100 == null) goto L4;
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L20;
        String r103 = r102.next();     // Catch: Throwable -> L19
        Object r104 = r100.get(r103);     // Catch: Throwable -> L19
        if (r104 == null) goto L7;
        if (r103 == null) goto L7;
        if ((r104 instanceof JSONObject) == true) goto L13;
        if ((r104 instanceof JSONArray) == true) goto L16;
        r101.put(r103, r104);     // Catch: Throwable -> L19
        goto L7
    L16:
        r101.put(r103, b((JSONArray) r104));     // Catch: Throwable -> L19
        goto L7
    L13:
        r101.put(r103, d((JSONObject) r104));     // Catch: Throwable -> L19
        goto L7
    L20:
        return r101;
    L4:
        return new HashMap();
    }

    public static String e(Map<String, String> r100) {
        if (r100 != null) goto L8;
        return SliceInitService.DEFAULT_SWITCH;
    L8:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L7
        a(r101, r100);     // Catch: Exception -> L7
        return r101.toString();
    L10:
        return SliceInitService.DEFAULT_SWITCH;
    }

    public static String h(Object r100) throws JsonParseException {
        if (r100 != null) goto L10;
        return "";
    L10:
        return GsonHelper.get().toJson(r100);
    L7:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static void a(JSONObject r100, Map r101) throws JSONException {
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.put((String) r103.getKey(), (String) r103.getValue());
        goto L4
    }

    public static <T> T f(String r100, Type r101) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (T) GsonHelper.get().fromJson(r100, r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T g(String r100, Class<T> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return (T) GsonHelper.get().fromJson(r100, r101);
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
