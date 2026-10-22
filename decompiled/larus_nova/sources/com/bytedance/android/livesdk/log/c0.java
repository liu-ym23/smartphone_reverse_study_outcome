package com.bytedance.android.livesdk.log;

import android.util.LruCache;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<Long, Long> f153281a = null;

    static {
        f153281a = new LruCache(10);
    }

    public static String a() {
        JSONArray r100 = new JSONArray();
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<Long, Long>> r102 = f153281a.snapshot().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<Long, Long> r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.put("gid", String.valueOf(r103.getKey().longValue()));
        r104.put("duration", r103.getValue().longValue());
        r100.put(r104);
        goto L4
    L6:
        r101.put("recent_live_info", r100);
        String r105 = r101.toString();
        if (r105.length() <= 600) goto L11;
        return "";
    L11:
        return r105;
    }
}
