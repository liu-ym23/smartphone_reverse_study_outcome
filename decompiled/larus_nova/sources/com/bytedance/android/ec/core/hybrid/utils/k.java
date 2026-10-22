package com.bytedance.android.ec.core.hybrid.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44314a = 0;

    static {
    }

    public static JSONArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L43;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L7;
        if ((r103 instanceof Long) == true) goto L10;
        if ((r103 instanceof Integer) == true) goto L13;
        if ((r103 instanceof Double) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L22;
        if ((r103 instanceof Map) == true) goto L25;
        if ((r103 instanceof List) == false) goto L4;
        if (r103 == null) goto L38;
        r101.put(a((List) r103));     // Catch: ClassCastException -> L39 JSONException -> L41
    L39:
        e = move-exception;
        e.getMessage();
    L41:
        e = move-exception;
        e.getMessage();
        goto L4
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");     // Catch: ClassCastException -> L39 JSONException -> L41
    L25:
        if (r103 == null) goto L28;
        r101.put(b((Map) r103));     // Catch: ClassCastException -> L29 JSONException -> L31
    L29:
        e = move-exception;
        e.getMessage();
    L31:
        e = move-exception;
        e.getMessage();
        goto L4
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");     // Catch: ClassCastException -> L29 JSONException -> L31
    L22:
        r101.put(((Boolean) r103).booleanValue());
        goto L4
    L19:
        r101.put(r103);
        goto L4
    L16:
        r101.put(((Number) r103).doubleValue());
        goto L4
    L13:
        r101.put(((Number) r103).intValue());
        goto L4
    L10:
        r101.put(((Number) r103).longValue());
        goto L4
    L7:
        r101.put(((Number) r103).floatValue());
        goto L4
    L43:
        return r101;
    }

    public static JSONObject b(Map r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L42;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L10;
        if ((r105 instanceof Float) == true) goto L13;
        if ((r105 instanceof Integer) == true) goto L16;
        if ((r105 instanceof Double) == true) goto L19;
        if ((r105 instanceof String) == true) goto L22;
        if ((r105 instanceof Boolean) == true) goto L25;
        if ((r105 instanceof Map) == false) goto L35;
        r101.put(r104, b((Map) r105));     // Catch: ClassCastException -> L30 JSONException -> L32
    L30:
        e = move-exception;
        e.getMessage();
    L32:
        e = move-exception;
        e.getMessage();
        goto L7
    L35:
        if ((r105 instanceof List) == false) goto L7;
        r101.put(r104, a((List) r105));     // Catch: ClassCastException -> L38 JSONException -> L40
    L38:
        e = move-exception;
        e.getMessage();
    L40:
        e = move-exception;
        e.getMessage();
        goto L7
    L25:
        r101.put(r104, ((Boolean) r105).booleanValue());
        goto L7
    L22:
        r101.put(r104, r105);
        goto L7
    L19:
        r101.put(r104, ((Number) r105).doubleValue());
        goto L7
    L16:
        r101.put(r104, ((Number) r105).intValue());
        goto L7
    L13:
        r101.put(r104, ((Number) r105).floatValue());
        goto L7
    L10:
        r101.put(r104, ((Number) r105).longValue());
        goto L7
    L42:
        return r101;
    }
}
