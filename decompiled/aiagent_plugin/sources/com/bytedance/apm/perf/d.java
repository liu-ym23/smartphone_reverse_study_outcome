package com.bytedance.apm.perf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfDataCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f4796a;

    private d() {
    }

    public static d a() {
        if (f4796a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4796a != null) goto L9;
        f4796a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f4796a;
    }

    public JSONObject b() {
        JSONObject r4 = new JSONObject();
        com.bytedance.apm6.service.e.a r0 = (com.bytedance.apm6.service.e.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.e.a.class), com.bytedance.apm6.service.e.a.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L5
        r4.put("process_usage", r0.b());     // Catch: JSONException -> L5
        r4.put("stat_speed", r0.c());     // Catch: JSONException -> L5
        return r4;
    L6:
        return new JSONObject();
    }
}
