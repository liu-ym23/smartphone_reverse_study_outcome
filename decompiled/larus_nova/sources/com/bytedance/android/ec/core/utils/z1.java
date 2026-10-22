package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class z1 {
    public static final JSONObject a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$AnyToJSONObject");
        int r101 = t0.f45720a;     // Catch: Exception -> L5
        return new JSONObject(t0.a.f45721a.toJson(r100));
    L6:
        return new JSONObject();
    }

    public static final JSONArray e(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "jsonArray_format_error");
        return null;
    L3:
        if (cg4.a.a(r100) == false) goto L12;
        return new JSONArray(r100);
    L12:
        return null;
    }

    public static final JSONObject f(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L9:
        return new JSONObject();
    L3:
        if (cg4.a.a(r100) == false) goto L9;
        return new JSONObject(r100);
    }

    public static final JSONObject g(String r100) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (cg4.a.a(r100) == false) goto L12;
        return new JSONObject(r100);
    L12:
        return null;
    }

    public static final List<Object> h(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toList");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = cd.a.d((JSONArray) r104);
    L10:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = cd.a.e((JSONObject) r104);
        goto L10
    L11:
        return r101;
    }

    public static final List<Object> i(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toListNullCompat");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        Object r104 = r100.get(r103);     // Catch: Exception -> L13
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = i((JSONArray) r104);     // Catch: Exception -> L13
    L10:
        r101.add(r104);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = l((JSONObject) r104);     // Catch: Exception -> L13
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return r101;
    }

    public static final Map<String, String> j(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();     // Catch: Exception -> L8
        r101.put(r103, r100.optString(r103));     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L10
    }

    public static final Map<String, Object> k(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toObjectMap");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: Exception -> L13
        Object r104 = r100.get(r103);     // Catch: Exception -> L13
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = cd.a.d((JSONArray) r104);     // Catch: Exception -> L13
    L11:
        r101.put(r103, r104);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = k((JSONObject) r104);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L15:
        return r101;
    }

    public static final Map<String, Object> l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toObjectMapNullCompat");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L16
        Object r104 = r100.get(r103);     // Catch: Exception -> L16
        if (r100.isNull(r103) == false) goto L9;
        r104 = null;
    L14:
        r101.put(r103, r104);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r104 instanceof JSONArray) == false) goto L12;
        r104 = i((JSONArray) r104);     // Catch: Exception -> L16
        goto L14
    L12:
        if ((r104 instanceof JSONObject) == false) goto L14;
        r104 = l((JSONObject) r104);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r101;
    }

    public static final void b(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putAll");
        Intrinsics.checkNotNullParameter(r101, "json");
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r100.put(r103, r101.opt(r103));
        goto L4
    }

    public static final void c(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putJSONString");
        if (r101 == null) goto L20;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) == true) goto L7;
    L9:
        r102 = false;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L22;
        JSONObject r103 = g(r101);
        if (r103 == null) goto L23;
        Iterator<String> r104 = r103.keys();
    L18:
        if (r104.hasNext() == false) goto L24;
        String r105 = r104.next();
        r100.put(r105, r103.opt(r105));
        goto L18
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (StringsKt.equals(r101, "null", true) == true) goto L9;
    }

    public static final String d(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "map");
        if (r100 == null) goto L6;
        JSONObject r102 = g(r100);
        if (r102 == null) goto L6;
    L7:
        Iterator<T> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L9
    L12:
        return r102.toString();
    L6:
        r102 = new JSONObject();
        goto L7
    }
}
