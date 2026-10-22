package com.alipay.sdk.m.u;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class d {
    public d() {
    }

    public static JSONObject a(JSONObject r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        int r103 = 0;
        JSONObject[] r104 = {r100, r101};     // Catch: JSONException -> L14
    L4:
        if (r103 >= 2) goto L16;
        JSONObject r105 = r104[r103];     // Catch: JSONException -> L14
        if (r105 == null) goto L13;
        Iterator<String> r106 = r105.keys();     // Catch: JSONException -> L14
    L10:
        if (r106.hasNext() == false) goto L13;
        String r107 = r106.next();     // Catch: JSONException -> L14
        r102.put(r107, r105.get(r107));     // Catch: JSONException -> L14
    L13:
        r103 = r103 + 1;
    L16:
        return r102;
    L14:
        e = move-exception;
        e.a(e);
        goto L16
    }
}
