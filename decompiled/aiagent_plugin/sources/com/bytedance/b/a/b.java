package com.bytedance.b.a;

import com.bytedance.apm.battery.dao.DBHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogData.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f6063c;

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put(DBHelper.COL_TIME, this.f6061a);     // Catch: JSONException -> L8
        r0.put("message", this.f6062b);     // Catch: JSONException -> L8
        Map<String, String> r1 = this.f6063c;     // Catch: JSONException -> L8
        if (r1 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r1.size() <= 0) goto L7;
        r0.put("fields", new JSONObject(this.f6063c));     // Catch: JSONException -> L8
    L8:
        return null;
    }
}
