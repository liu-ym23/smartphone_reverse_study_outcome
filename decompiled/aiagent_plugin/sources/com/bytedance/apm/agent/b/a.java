package com.bytedance.apm.agent.b;

import com.bytedance.apm.thread.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorTool.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(final String r2, final String r3, final JSONObject r4) {
        b.a().a(new AnonymousClass1(r2, r3, r4));
    }

    public static void a(final String r2, final JSONObject r3, final JSONObject r4, final JSONObject r5) {
        b.a().a(new AnonymousClass2(r2, r3, r4, r5));
    }

    public static void a(final JSONObject r2, long r3, long r5) {
        final JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("begin_time", r3);     // Catch: Exception -> L4
        r0.put("end_time", r5);     // Catch: Exception -> L4
        r0.put("from", "monitor-plugin");     // Catch: Exception -> L4
        b.a().a(new AnonymousClass3(r2, r0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(final String r2, final String r3, final long r4) {
        b.a().a(new AnonymousClass4(r3, r4, r2));
    }
}
