package com.bytedance.crash.n;

import android.app.ApplicationExitInfo;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.j;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExitReasonMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7622a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<ApplicationExitInfo> f7623b;

    private static long c() {
        File r0 = new File(g.f7627a, "lastReasonTime");
        if (r0.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return g.a(j.d(r0), -1);
    }

    private static void d() {
        File r0 = new File(g.f7627a, "lastReasonTime");
        j.a(r0, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }

    static {
        f7623b = new ArrayList();
    }

    static List<ApplicationExitInfo> a() {
        if (f7622a == true) goto L5;
        f7622a = true;
        if (c.a() == true) goto L39;
        return null;
    L39:
        List<ApplicationExitInfo> r0 = c.b();     // Catch: Throwable -> L29
        if (r0 != null) goto L13;
        b();
        return null;
    L13:
        long r2 = c();     // Catch: Throwable -> L29
        Iterator<ApplicationExitInfo> r1 = r0.iterator();     // Catch: Throwable -> L29
    L16:
        if (r1.hasNext() == false) goto L22;
        ApplicationExitInfo r4 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r1.next(), ApplicationExitInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r4.getTimestamp() < r2) goto L22;
        f7623b.add(r4);     // Catch: Throwable -> L29
        g.a(r4);     // Catch: Throwable -> L29
    L22:
        if (f7623b.size() != 0) goto L27;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L29
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L29
        IApmAgent r6 = (IApmAgent) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        if (r6 == null) goto L27;
        r3.put("reason", "1");     // Catch: Throwable -> L36
        r5.put("time", r2);     // Catch: Throwable -> L36
        r6.monitorEvent("app_exit", r3, null, null);     // Catch: Throwable -> L36
    L27:
        g.a(f7623b);     // Catch: Throwable -> L29
        d();     // Catch: Throwable -> L29
    L31:
        b();
        return f7623b;
    L29:
        th = move-exception;
        h.b().a(th);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        b();
        throw th;
    L5:
        return f7623b;
    }

    static void b() {
        File r0 = new File(g.f7627a, "exit_info");
        if (r0.exists() == true) goto L5;
        return;
    L5:
        String[] r1 = r0.list();
        if (r1 != null) goto L8;
        return;
    L8:
        int r3 = 50;
        if (r1.length <= 50) goto L14;
        Arrays.sort(r1);
    L12:
        if (r3 >= r1.length) goto L16;
        j.a(new File(r0, r1[r3]));
        r3 = r3 + 1;
        goto L12
    L16:
        return;
    }
}
