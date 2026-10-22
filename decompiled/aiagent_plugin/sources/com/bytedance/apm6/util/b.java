package com.bytedance.apm6.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatchLogWrapUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static JSONObject a(String r2, JSONArray r3) {
        JSONObject r4 = new JSONObject().put("wrapper_array_data", r3);     // Catch: Exception -> L4
        r4.put("log_type", r2);     // Catch: Exception -> L4
        r4.put("wrapper_type_description", 1);     // Catch: Exception -> L4
        return r4;
    L4:
        return null;
    }

    public static List<Object> a(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        if (r4.optInt("wrapper_type_description", -1) == 1) goto L9;
        r1.add(r4);
        return r1;
    L9:
        JSONArray r5 = r4.optJSONArray("wrapper_array_data");
        if (r5 != null) goto L12;
        return null;
    L12:
        int r0 = 0;
    L14:
        if (r0 >= r5.length()) goto L17;
        r1.add(r5.get(r0));     // Catch: Exception -> L18
    L16:
        r0 = r0 + 1;
        goto L14
    L17:
        return r1;
    }
}
