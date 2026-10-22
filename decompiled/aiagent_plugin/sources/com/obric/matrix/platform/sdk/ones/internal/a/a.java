package com.obric.matrix.platform.sdk.ones.internal.a;

import android.util.Log;
import com.obric.matrix.a.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportMonitorHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33679a = null;

    static {
        f33679a = new a();
    }

    private a() {
    }

    public final void a(int r10, int r11, String r12, ad r13, JSONObject r14) {
        o.e(r13, "response");
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L22
        r2.put("status", "status_receiver_result");     // Catch: Exception -> L22
        r2.put("cmd", r10);     // Catch: Exception -> L22
        r2.put("way", r11);     // Catch: Exception -> L22
        r2.put("package_name", r12);     // Catch: Exception -> L22
        Integer r15 = r13.f33290e;     // Catch: Exception -> L22
        o.c(r15, "response.statusCode");     // Catch: Exception -> L22
        r2.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Exception -> L22
        r2.put("error_message", r13.f);     // Catch: Exception -> L22
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L22
        if (r14 == null) goto L20;
        String r17 = r14.optString("start_callback_time");     // Catch: Exception -> L22
        o.c(r17, "startCallbackTime");     // Catch: Exception -> L22
        boolean r18 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r19 = true;
    L9:
        long r4 = 0;
        if (r19 == false) goto L12;
        long r6 = System.currentTimeMillis() - Long.parseLong(r17);     // Catch: Exception -> L22
    L13:
        String r110 = r14.optString("start_intent_use_time");     // Catch: Exception -> L22
        String r111 = r14.optString("start_time");     // Catch: Exception -> L22
        o.c(r111, "realStartTime");     // Catch: Exception -> L22
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L17;
        r18 = false;
    L17:
        if (r18 == false) goto L19;
        r4 = System.currentTimeMillis() - Long.parseLong(r111);     // Catch: Exception -> L22
    L19:
        String r112 = r14.optString("process_time");     // Catch: Exception -> L22
        r16.put("cost_time", r4);     // Catch: Exception -> L22
        r16.put("start_intent_use_time", r110);     // Catch: Exception -> L22
        r16.put("process_time", r112);     // Catch: Exception -> L22
        r16.put("callback_use_time", r6);     // Catch: Exception -> L22
        goto L20
    L12:
        r6 = 0;
        goto L13
    L8:
        r19 = false;
    L20:
        b.f33680a.a("event_send_cmd_result", r2, r16, new JSONObject());     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("ReportMonitorHelper", "report exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), null, 4, null);
    }

    public final void a(Boolean r3) {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        if (o.a(r3, true) == false) goto L5;
        String r4 = "1";
    L6:
        r2.put("result", r4);     // Catch: Exception -> L8
        b.f33680a.a("event_bind_result", r2);     // Catch: Exception -> L8
        return;
    L5:
        r4 = "0";
    L8:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("ReportMonitorHelper", "report exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), null, 4, null);
    }
}
