package com.bytedance.android.livesdk.player.newstrategy;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f155940a = null;

    static {
        f155940a = new LinkedHashMap();
    }

    public static void a(JSONObject r100, Map r101, String r102) {
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        Object r105 = r100.opt(r104);
        if ((r105 instanceof JSONObject) == true) goto L4;
        if ((r105 instanceof JSONArray) == true) goto L4;
        if (r105 == null) goto L4;
        Map r106 = (Map) ((LinkedHashMap) f155940a).get(r102);
        if (r106 != null) goto L13;
        r106 = new LinkedHashMap();
    L13:
        String r107 = (String) r106.get(r104);
        if (r107 != null) goto L16;
        r107 = r104 + r102;
        r106.put(r104, r107);
    L16:
        r101.put(r107, r105.toString());
        goto L4
    }
}
