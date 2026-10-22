package com.bytedance.android.btm.impl.event;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42151a = 0;

    static {
    }

    public static boolean a(JSONObject r110, JSONObject r111) {
        ArrayList r100 = new ArrayList();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r110.keys();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L50;
        String r104 = r102.next();
        r103 = r103 + 1;
        if (r111.has(r104) == false) goto L4;
        Object r105 = r111.opt(r104);
        if ((r105 instanceof String) == false) goto L14;
        if (Intrinsics.areEqual(r105, "NULL") == false) goto L14;
        r100.add(r104);
    L14:
        if ((r105 instanceof JSONObject) == false) goto L4;
        Object r106 = r110.opt(r104);
        if ((r106 instanceof JSONObject) == false) goto L22;
        if (a((JSONObject) r106, (JSONObject) r105) == false) goto L22;
        r100.add(r104);
    L22:
        if ((r106 instanceof String) == false) goto L4;
        String r107 = (String) r106;
        String r108 = null;
        JSONObject r112 = new JSONObject(r107);     // Catch: Exception -> L26
    L28:
        if (r112 == null) goto L63;
        Pair r109 = new Pair(0, r112);
    L36:
        if (r109 == null) goto L4;
        if (a((JSONObject) r109.getSecond(), (JSONObject) r105) == true) goto L39;
        int r113 = ((Number) r109.getFirst()).intValue();
        if (r113 != 0) goto L43;
        r101.put(r104, ((JSONObject) r109.getSecond()).toString());
    L43:
        if (r113 != 1) goto L4;
        r108 = URLEncoder.encode(((JSONObject) r109.getSecond()).toString(), "UTF-8");     // Catch: Exception -> L46
    L47:
        if (r108 == null) goto L4;
        r101.put(r104, r108);
        goto L4
    L39:
        r100.add(r104);
        goto L4
    L63:
        JSONObject r114 = new JSONObject(URLDecoder.decode(r107, "UTF-8"));     // Catch: Exception -> L32
    L33:
        if (r114 == null) goto L35;
        r109 = new Pair(1, r114);
        goto L36
    L35:
        r109 = null;
    L32:
        r114 = null;
    L26:
        r112 = null;
        goto L28
    L50:
        if (r103 != r100.size()) goto L52;
        return true;
    L52:
        Iterator r115 = r100.iterator();
    L54:
        if (r115.hasNext() == false) goto L56;
        r110.remove((String) r115.next());
        goto L54
    L56:
        Iterator r116 = r101.entrySet().iterator();
    L58:
        if (r116.hasNext() == false) goto L96;
        Map.Entry r117 = (Map.Entry) r116.next();
        String r118 = (String) r117.getKey();
        String r119 = (String) r117.getValue();
        if (r119 == null) goto L58;
        r110.put(r118, r119);
        goto L58
    L96:
        return false;
    }
}
