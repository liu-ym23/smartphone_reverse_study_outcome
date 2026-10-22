package com.bytedance.crash.dumper;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SdkInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    public static void a(File r9) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.crash.dumper.a.f r1 = new com.bytedance.crash.dumper.a.f(r9.getAbsolutePath() + "/sdk_info.json");
        r1.a();
        ConcurrentHashMap<Integer, String> r10 = r0.n().g();
        boolean r5 = true;
        if (r10 != null) goto L8;
    L18:
        boolean r6 = true;
    L19:
        JSONObject r11 = r0.n().h();
        if (r11.length() <= 0) goto L34;
        if (r6 == true) goto L23;
        r1.e();
    L23:
        r1.a("inner_sdk");
        r1.a();
        Iterator<String> r2 = r11.keys();
    L25:
        if (r2.hasNext() == false) goto L33;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        String r7 = r11.getString(r3);     // Catch: JSONException -> L36
        if (r5 == false) goto L30;
        r5 = false;
    L31:
        r1.a(r3).b(r7);     // Catch: JSONException -> L36
        goto L25
    L30:
        r1.e();     // Catch: JSONException -> L36
        goto L31
    L33:
        r1.b();
    L34:
        r1.b();
        r1.f();
        return;
    L8:
        if (r10.size() <= 0) goto L18;
        r1.a("sdk_info");
        r1.a();
        Iterator<Integer> r4 = r10.keySet().iterator();
        r6 = true;
    L11:
        if (r4.hasNext() == false) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L15;
        r6 = false;
    L16:
        r1.a(String.valueOf(r8)).b(String.valueOf(r10.get(r8)));
        goto L11
    L15:
        r1.e();
        goto L16
    L17:
        r1.b();
        goto L19
    }

    public static void a(JSONObject r2, File r3) {
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "sdk_info.json"));
        if (r4 == null) goto L11;
        com.bytedance.crash.o.l.b(r2, new JSONObject(r4));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.o.r.b(e);
        return;
    }

    public static void a(JSONObject r7) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, String> r1 = r0.n().g();
        JSONObject r2 = new JSONObject();
        if (r1 != null) goto L26;
    L14:
        JSONObject r3 = r0.n().h();
        if (com.bytedance.crash.o.l.a(r2) == true) goto L19;
        r7.put("sdk_info", r2);     // Catch: Throwable -> L23
    L19:
        if (com.bytedance.crash.o.l.a(r3) == true) goto L30;
        r7.put("inner_sdk", r3);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L31:
        return;
    L26:
        if (r1.size() <= 0) goto L14;
        Iterator<Integer> r4 = r1.keySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r4.hasNext() == false) goto L14;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        r2.put(String.valueOf(r5), r1.get(r5));     // Catch: Throwable -> L22
        goto L11
    }
}
