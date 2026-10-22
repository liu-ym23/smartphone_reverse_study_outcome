package com.c.a.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String a(HashMap<String, String> r5) {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L12;
        Iterator<String> r1 = r5.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L9
        r0.put(r2, r5.get(r2));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r0.toString();
    }

    public static JSONObject a(Map<String, List<String>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        if (r5 != null) goto L15;
    L14:
        return r0;
    L15:
        Iterator r6 = r5.entrySet().iterator();     // Catch: JSONException -> L12
    L5:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L12
        if (r2.getKey() == null) goto L9;
        r0.put(r2.getKey().toString(), r2.getValue());     // Catch: JSONException -> L12
        goto L5
    L9:
        r0.put("Response", r2.getValue());     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
