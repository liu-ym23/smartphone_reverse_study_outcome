package com.bytedance.crash.dumper;

import com.bytedance.crash.ag;
import com.bytedance.crash.jni.NativeBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static void a(File r6) {
        com.bytedance.crash.monitor.a r1 = com.bytedance.crash.monitor.h.a();
        if (r1 != null) goto L5;
        return;
    L5:
        Map<String, JSONArray> r2 = r1.n().a();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isEmpty() == true) goto L21;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, JSONArray>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L16
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        r3.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), r5.getValue());     // Catch: Throwable -> L16
        goto L12
    L14:
        com.bytedance.crash.o.j.a(new File(r6.getAbsolutePath() + "/custom_crash_reason.json"), r3, false);     // Catch: Throwable -> L16
        return;
    L22:
        return;
    }

    public static void b(File r6) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (new File(r6.getAbsolutePath() + "/tags.txt").exists() == false) goto L9;
        return;
    L9:
        if (r0.n().b() == false) goto L13;
        NativeBridge.t(new File(r6.getAbsolutePath() + "/tags.txt").getAbsolutePath());
        return;
    L13:
        if (ag.b() == null) goto L15;
        return;
    L15:
        Map<String, String> r1 = r0.n().d();
        if (r1.size() == 0) goto L30;
        com.bytedance.crash.dumper.a.f r2 = new com.bytedance.crash.dumper.a.f(r6.getAbsolutePath() + "/filters.json");
        r2.a();
        r2.a("filters");
        boolean r7 = true;
        r2.a();
        Iterator<Map.Entry<String, String>> r3 = r1.entrySet().iterator();
    L19:
        if (r3.hasNext() == false) goto L25;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L23;
        r7 = false;
    L24:
        r2.a((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")).b((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L19
    L23:
        r2.e();
        goto L24
    L25:
        r2.b();
        r2.b();
        r2.f();
        return;
    }

    public static void a(JSONObject r2, File r3) {
        r2.put("custom_crash_reason", new JSONObject(com.bytedance.crash.o.i.d(new File(r3, "custom_crash_reason.json"))));     // Catch: Throwable -> L5
        return;
    }

    public static void b(JSONObject r2, File r3) {
        File r0 = new File(r3, "tags.txt");
        if (r0.exists() == false) goto L5;
        c(r2, r0);
        return;
    L5:
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "filters.json"));
        if (r4 != null) goto L13;
    L11:
        ag.a(r2);
        return;
    L13:
        com.bytedance.crash.o.l.b(r2, new JSONObject(r4));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.o.r.b(e);
        goto L11
    }

    public static void c(JSONObject r4, File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == false) goto L29;
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L20
        int r6 = 0;
        String r2 = "";
    L21:
        String r3 = r1.readLine();     // Catch: Throwable -> L17
        if (r3 == null) goto L30;
        if ((r6 & 1) != 0) goto L15;
        r2 = r3;
    L16:
        r6 = r6 + 1;
        goto L21
    L15:
        com.bytedance.crash.entity.a.a(r4, "filters", r2, r3);     // Catch: Throwable -> L17
        goto L16
    L30:
        return;
    L17:
        r0 = r1;
    L18:
        com.bytedance.crash.o.k.a(r0);
        return;
    }
}
