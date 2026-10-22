package com.monitor.cloudmessage.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static JSONObject a(Map r10) {
        JSONObject r11 = new JSONObject();
        if (r10 != null) goto L16;
    L15:
        return r11;
    L16:
        Iterator r12 = r10.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L10
        if (r13.getKey() == null) goto L9;
        r11.put(r13.getKey().toString(), r13.getValue());     // Catch: JSONException -> L10
        goto L5
    L9:
        r11.put("Response", r13.getValue());     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String b(HashMap r10) {
        JSONObject r11 = new JSONObject();
        if (r10 == null) goto L12;
        Iterator r12 = r10.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r12.hasNext() == false) goto L12;
        String r13 = (String) r12.next();     // Catch: JSONException -> L9
        r11.put(r13, r10.get(r13));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r11.toString();
    }
}
