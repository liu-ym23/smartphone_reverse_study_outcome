package com.bytedance.apm.agent.monitor;

import bt3.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class MonitorTool {
    public MonitorTool() {
    }

    public static void monitorStart(String r100, long r101, long r102) {
        if (r102 <= r101) goto L11;
        final JSONObject r103 = new JSONObject();     // Catch: Exception -> L6
        r103.put(r100, r102 - r101);     // Catch: Exception -> L6
        final JSONObject r104 = new JSONObject();     // Catch: Exception -> L6
        r104.put("begin_time", r101);     // Catch: Exception -> L6
        r104.put("end_time", r102);     // Catch: Exception -> L6
        b.d.f20539a.e(new AnonymousClass4(r103, r104));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void monitorUIAction(final String r100, final String r101, final JSONObject r102) {
        b.d.f20539a.e(new AnonymousClass1(r100, r101, r102));
    }

    public static void reportTraceTime(final String r100, final String r101, final long r102) {
        b.d.f20539a.e(new AnonymousClass5(r101, r102, r100));
    }

    public static void monitorStart(final JSONObject r100, long r101, long r102) {
        final JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("begin_time", r101);     // Catch: Exception -> L4
        r103.put("end_time", r102);     // Catch: Exception -> L4
        r103.put("from", "monitor-plugin");     // Catch: Exception -> L4
        b.d.f20539a.e(new AnonymousClass3(r100, r103));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void monitorPerformance(final String r100, final JSONObject r101, final JSONObject r102, final JSONObject r103) {
        b.d.f20539a.e(new AnonymousClass2(r100, r101, r102, r103));
    }

    public static void monitorSLA(final long r110, final long r111, final String r112, final String r113, final String r114, final int r115, final JSONObject r210) {
        b.d.f20539a.e(new AnonymousClass6(r110, r111, r112, r113, r114, r115, r210));
    }
}
