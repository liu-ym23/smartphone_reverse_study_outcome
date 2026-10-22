package com.bytedance.crash.d;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventReportData.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f7385e;
    private JSONObject f;

    public i(String r1, long r2, String r4, int r5, JSONObject r6, JSONObject r7) {
        this.f7381a = r1;
        this.f7382b = r2;
        this.f7383c = r4;
        this.f7384d = r5;
        this.f7385e = r6;
        this.f = r7;
    }

    public String a() {
        return this.f7383c;
    }

    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L5
        r0.put("event_type", "exception");     // Catch: Exception -> L5
        r0.put(WsConstants.KEY_SERVICE, this.f7383c);     // Catch: Exception -> L5
        r0.put("status", this.f7384d);     // Catch: Exception -> L5
        r0.put("category", this.f7385e);     // Catch: Exception -> L5
        r0.put("metric", this.f);     // Catch: Exception -> L5
        r0.put("sid", com.bytedance.crash.i.f());     // Catch: Exception -> L5
        r0.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Exception -> L5
        r0.put("crash_time", this.f7382b);     // Catch: Exception -> L5
        r0.put("process_name", com.bytedance.crash.o.b.a());     // Catch: Exception -> L5
        r0.put("crash_thread_name", this.f7381a);     // Catch: Exception -> L5
    L4:
        return r0;
    }
}
