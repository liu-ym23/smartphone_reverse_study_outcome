package com.bytedance.crash.dumper;

import android.os.SystemClock;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.x;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomData.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static boolean a(com.bytedance.crash.dumper.a.f r5, Map<? extends String, ? extends String> r6, String r7, long r8, boolean r10) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
    L16:
        return r10;
    L5:
        if (r9.size() == 0) goto L16;
        StringBuilder r0 = new StringBuilder();
        r0.append("zz_cost_").append(r7);
        Iterator r11 = r9.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r10 == false) goto L13;
        r10 = false;
    L14:
        r5.a((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin")).b((String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.aiagent.plugin"));
        r0.append("_").append((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin"));
        goto L9
    L13:
        r5.e();
        goto L14
    L15:
        r5.e().a(r0.toString()).a(SystemClock.uptimeMillis() - r8);
        goto L16
    }

    public static void a(com.bytedance.crash.dumper.a.f r12, CrashType r13, int r14) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        List<AttachUserData> r1 = r0.n().a(r13);
        int r3 = 0;
        boolean r4 = true;
        if (r1 == null) goto L13;
        int r11 = 0;
    L9:
        if (r11 >= r1.size()) goto L13;
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.preCheckCast(r1.get(r11), AttachUserData.class, "com.obric.aiagent.plugin");
        r4 = a(r12, r5.getUserData(r13), r5.getClass().getName(), SystemClock.uptimeMillis(), r4);     // Catch: Throwable -> L22
    L12:
        r11 = r11 + 1;
    L13:
        List<x> r2 = r0.n().f(r13);
        if (r2 == null) goto L21;
        JSONObject r6 = new JSONObject();
        com.bytedance.crash.o.l.a(r6, "tid", Integer.valueOf(r14));
        boolean r15 = r4;
    L17:
        if (r3 >= r2.size()) goto L32;
        x r7 = (x) ZeusTransformUtils.preCheckCast(r2.get(r3), x.class, "com.obric.aiagent.plugin");
        r15 = a(r12, r7.a(r13, r6), r7.getClass().getName(), SystemClock.uptimeMillis(), r15);     // Catch: Throwable -> L23
    L20:
        r3 = r3 + 1;
        goto L17
    L32:
        return;
    }

    public static void a(File r3, CrashType r4, int r5) {
        if (com.bytedance.crash.monitor.b.g() == true) goto L5;
        return;
    L5:
        com.bytedance.crash.dumper.a.f r0 = new com.bytedance.crash.dumper.a.f(r3.getAbsolutePath() + "/" + MonitorConstants.CUSTOM + ".json");
        r0.a();
        r0.a(MonitorConstants.CUSTOM);
        r0.a();
        a(r0, r4, r5);
        r0.b();
        r0.b();
        r0.f();
    }

    public static void a(JSONObject r2, File r3) {
        if (com.bytedance.crash.monitor.b.g() == true) goto L5;
        return;
    L5:
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "custom.json"));
        if (r4 == null) goto L12;
        com.bytedance.crash.o.l.b(r2, new JSONObject(r4));     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }
}
