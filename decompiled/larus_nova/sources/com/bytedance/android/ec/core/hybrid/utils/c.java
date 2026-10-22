package com.bytedance.android.ec.core.hybrid.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, JSONObject> f44300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f44301b = null;

    static {
        f44300a = new LinkedHashMap();
        f44301b = new LinkedHashMap();
    }

    public static com.bytedance.android.ec.core.imagex.r a(String r100, String r101, Map r102) {
        com.bytedance.android.ec.core.imagex.r r103 = new com.bytedance.android.ec.core.imagex.r(r100, r101);
        if (r102 == null) goto L12;
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Set r105 = r104.keySet();
        if (r105 == null) goto L12;
        Iterator r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        String r107 = (String) r106.next();
        Object r108 = r104.get(r107);
        if (r108 == null) goto L8;
        r103.g(r107, r108);
    L12:
        return r103;
    }

    public static void b(JSONObject r110, JSONObject r111, List r112, Map r113) {
        Iterator<String> r100 = r110.keys();
    L4:
        if (r100.hasNext() == false) goto L117;
        String r101 = r100.next();
        Object r102 = r110.opt(r101);
        if (r102 == null) goto L4;
        if (Intrinsics.areEqual(r101, "__*_common_*__") == true) goto L11;
    L19:
        Object r103 = r111.opt(r101);
        if (r103 == null) goto L4;
        if ((r102 instanceof JSONObject) == true) goto L25;
        int r104 = 0;
        if ((r102 instanceof String) == true) goto L29;
        if ((r102 instanceof JSONArray) == false) goto L4;
        JSONArray r105 = (JSONArray) r102;
        if (r105.length() == 0) goto L4;
        if ((r105.get(0) instanceof JSONObject) == false) goto L4;
        if ((r103 instanceof JSONArray) == false) goto L4;
        JSONArray r106 = (JSONArray) r103;
        if (r106.length() < r105.length()) goto L4;
        Object r107 = r105.get(0);
        if (r107 == null) goto L116;
        JSONObject r108 = (JSONObject) r107;
        int r109 = Math.min(r106.length(), r108.optInt("iterator_limit", 2147483637));
        Object r114 = r108.opt("iterator_rules");
        if (r114 == null) goto L4;
        if ((r114 instanceof JSONObject) == false) goto L4;
        int r115 = r108.optInt("immediate_limit", Integer.MAX_VALUE);
        long r116 = r108.optLong("wait_time", -1);
        if (r115 >= r109) goto L102;
        if (r116 <= 0) goto L102;
    L78:
        if (r104 >= r115) goto L88;
        if ((r106.get(r104) instanceof JSONObject) == false) goto L85;
        JSONObject r117 = (JSONObject) r114;
        Object r118 = r106.get(r104);
        if (r118 == null) goto L87;
        b(r117, (JSONObject) r118, r112, r113);
        goto L85
    L87:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L85:
        r104 = r104 + 1;
        goto L78
    L88:
        List r119 = (List) ((LinkedHashMap) r113).get(Long.valueOf(r116));
        if (r119 != null) goto L92;
        r119 = new ArrayList();
        r113.put(Long.valueOf(r116), r119);
    L92:
        if (r115 >= r109) goto L4;
        if ((r106.get(r115) instanceof JSONObject) == false) goto L99;
        JSONObject r120 = (JSONObject) r114;
        Object r121 = r106.get(r115);
        if (r121 == null) goto L101;
        b(r120, (JSONObject) r121, r119, r113);
        goto L99
    L101:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L99:
        r115 = r115 + 1;
    L102:
        if (r104 >= r109) goto L4;
        if ((r106.get(r104) instanceof JSONObject) == false) goto L110;
        JSONObject r122 = (JSONObject) r114;
        Object r123 = r106.get(r104);
        if (r123 == null) goto L114;
        b(r122, (JSONObject) r123, r112, r113);     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        throw th;
    L114:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L110:
        r104 = r104 + 1;
        goto L102
    L116:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L29:
        String r124 = (String) r102;
        int r125 = r124.hashCode();
        if (r125 != (-1324034071)) goto L32;
        if (r124.equals("__preload_first_image_in_this_array__") == false) goto L4;
        Object r126 = null;
        if ((r103 instanceof JSONArray) == true) goto L44;
        r103 = null;
    L44:
        JSONArray r127 = (JSONArray) r103;
        if (r127 == null) goto L4;
        if (r127.length() <= 0) goto L4;
        Object r128 = r127.get(0);
        if ((r128 instanceof String) == false) goto L52;
        r126 = r128;
    L52:
        String r129 = (String) r126;
        if (r129 == null) goto L4;
        r112.add(r129);
        goto L4
    L32:
        if (r125 != 1905217760) goto L4;
        if (r124.equals("__preload_this_image_url__") == false) goto L4;
        if ((r103 instanceof String) == false) goto L4;
        r112.add(r103);
        goto L4
    L25:
        if ((r103 instanceof JSONObject) == false) goto L4;
        b((JSONObject) r102, (JSONObject) r103, r112, r113);
        goto L4
    L11:
        if ((r102 instanceof JSONObject) == false) goto L19;
        JSONObject r130 = (JSONObject) r102;
        Iterator<String> r131 = r111.keys();
    L14:
        if (r131.hasNext() == false) goto L18;
        Object r132 = r111.opt(r131.next());
        if ((r132 instanceof JSONObject) == false) goto L14;
        b(r130, (JSONObject) r132, r112, r113);
        goto L14
    L18:
        return;
    }
}
