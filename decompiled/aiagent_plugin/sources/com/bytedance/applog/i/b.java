package com.bytedance.applog.i;

import org.json.JSONObject;

/* JADX INFO: compiled from: DataIsolateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(a r1, JSONObject r2, String r3) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        if (r1 != a.f5646a) goto L9;
        return r2.optString("user_id", "0");
    L9:
        return r3;
    }

    public static String a(a r1, com.bytedance.applog.store.a r2, String r3) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        if (r1 != a.f5646a) goto L9;
        return String.valueOf(r2.f5995e);
    L9:
        return r3;
    }
}
