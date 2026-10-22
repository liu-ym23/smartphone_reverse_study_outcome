package com.bytedance.apm.agent.monitor;

import com.bytedance.apm.thread.AsyncEventManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorTool {
    public MonitorTool() {
    }

    public static void monitorPerformance(final String r10, final JSONObject r11, final JSONObject r12, final JSONObject r13) {
        AsyncEventManager.e().h(new AnonymousClass2(r10, r11, r12, r13));
    }

    public static void monitorSLA(final long r12, final long r14, final String r16, final String r17, final String r18, final int r19, final JSONObject r20) {
        AsyncEventManager.e().h(new AnonymousClass6(r12, r14, r16, r17, r18, r19, r20));
    }

    public static void monitorStart(final JSONObject r10, long r11, long r12) {
        final JSONObject r13 = new JSONObject();     // Catch: Exception -> L4
        r13.put("begin_time", r11);     // Catch: Exception -> L4
        r13.put("end_time", r12);     // Catch: Exception -> L4
        r13.put("from", "monitor-plugin");     // Catch: Exception -> L4
        AsyncEventManager.e().h(new AnonymousClass3(r10, r13));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void monitorUIAction(final String r10, final String r11, final JSONObject r12) {
        AsyncEventManager.e().h(new AnonymousClass1(r10, r11, r12));
    }

    public static void reportTraceTime(final String r10, final String r11, final long r12) {
        AsyncEventManager.e().h(new AnonymousClass5(r11, r12, r10));
    }

    public static void monitorStart(String r10, long r11, long r12) {
        if (r12 <= r11) goto L11;
        final JSONObject r13 = new JSONObject();     // Catch: Exception -> L6
        r13.put(r10, r12 - r11);     // Catch: Exception -> L6
        final JSONObject r14 = new JSONObject();     // Catch: Exception -> L6
        r14.put("begin_time", r11);     // Catch: Exception -> L6
        r14.put("end_time", r12);     // Catch: Exception -> L6
        AsyncEventManager.e().h(new AnonymousClass4(r13, r14));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
