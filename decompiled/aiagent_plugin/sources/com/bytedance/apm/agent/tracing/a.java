package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.c;
import com.bytedance.apm.d.b.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoLaunchTraceHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4131b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4132c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f4133d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4134e = 0;
    private static long f = 0;
    private static long g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static long k = 0;
    private static long l = 0;
    private static long m = 0;
    private static long n = 0;
    private static boolean o = false;
    private static long p = 15000;

    static {
    }

    public static void a(long r4, long r6, long r8, long r10, long r12, long r14) {
        com.bytedance.apm.f.a.a().b("assignAppTime: " + g);
        f4131b = r4;
        f4132c = r6;
        f4133d = r8;
        f4134e = r10;
        f = r12;
        g = r14;
        c.l(r4);
    }

    public static void a(String r11) {
        com.bytedance.apm.f.a r0 = com.bytedance.apm.f.a.a();
        StringBuilder r1 = new StringBuilder().append(r11).append(" onCreateStart ").append(h).append(" ");
        boolean r5 = false;
        if ((h - g) >= 800) goto L5;
        boolean r4 = true;
    L6:
        r0.b(r1.append(r4).toString());
        if (h != 0) goto L15;
        h = System.currentTimeMillis();
        com.bytedance.apm.f.a r2 = com.bytedance.apm.f.a.a();
        StringBuilder r3 = new StringBuilder().append(r11).append(" onCreateStart ").append(h).append("  ").append(g).append(" ");
        if ((h - g) >= 800) goto L11;
        r5 = true;
    L11:
        r2.b(r3.append(r5).toString());
        if ((h - g) >= 800) goto L16;
        o = true;
        f4130a = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void a() {
        com.bytedance.apm.f.a.a().b("onCreateEnd " + h + " " + i);
        if (i == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        i = System.currentTimeMillis();
        return;
    }

    public static void b(String r4) {
        com.bytedance.apm.f.a.a().b(r4 + " onStart " + j);
        if (j == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        j = System.currentTimeMillis();
        return;
    }

    public static void c(String r4) {
        com.bytedance.apm.f.a.a().b("onStartEnd " + j + " " + k);
        if (k == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        k = System.currentTimeMillis();
        return;
    }

    public static void d(String r4) {
        com.bytedance.apm.f.a.a().b(r4 + " onResume " + l);
        if (l == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        l = System.currentTimeMillis();
        return;
    }

    public static void b() {
        com.bytedance.apm.f.a.a().b("onResumeEnd " + l + " " + m);
        if (m == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        m = System.currentTimeMillis();
        return;
    }

    public static void e(String r5) {
        com.bytedance.apm.f.a.a().b("OnWindowFocusChanged " + r5 + " " + n + " " + f + " " + o);
        if (n == 0) goto L5;
    L9:
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1());
        return;
    L5:
        if (f <= 0) goto L9;
        if (o == false) goto L9;
        n = System.currentTimeMillis();
        f4130a = r5;
        o = false;
        goto L9
    }

    public static JSONArray c() {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("module_name", "base");
        r1.put("span_name", "app_constructor");
        r1.put("start", f4131b);
        r1.put("end", f4132c);
        JSONObject r5 = new JSONObject();
        r5.put("module_name", "base");
        r5.put("span_name", "app_attachBaseContext");
        r5.put("start", f4133d);
        r5.put("end", f4134e);
        JSONObject r6 = new JSONObject();
        r6.put("module_name", "base");
        r6.put("span_name", "app_onCreate");
        r6.put("start", f);
        r6.put("end", g);
        JSONObject r9 = new JSONObject();
        r9.put("module_name", "base");
        r9.put("span_name", "activity_onCreate");
        r9.put("start", h);
        r9.put("end", i);
        JSONObject r10 = new JSONObject();
        r10.put("module_name", "base");
        r10.put("span_name", "activity_onResume");
        r10.put("start", l);
        r10.put("end", m);
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "activity_onStart");
        r11.put("start", j);
        r11.put("end", k);
        if (n <= 0) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put("module_name", "base");
        r8.put("span_name", "activity_onWindowFocusChanged");
        r8.put("start", n);
        r0.put(r8);
    L5:
        r0.put(r1);
        r0.put(r5);
        r0.put(r6);
        r0.put(r9);
        r0.put(r10);
        r0.put(r11);
        return r0;
    }

    public static void a(long r0) {
        p = r0;
    }

    public static void d() {
        if (c.h() != (-1)) goto L6;
        com.bytedance.apm.f.a.a().b("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r0 = n - f4131b;     // Catch: JSONException -> L16
        if (r0 > 0) goto L9;
        return;
    L9:
        if (r0 > p) goto L19;
        JSONArray r1 = c();     // Catch: JSONException -> L16
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L16
        r2.put("name", "launch_stats");     // Catch: JSONException -> L16
        r2.put("start", f4131b);     // Catch: JSONException -> L16
        r2.put("end", n);     // Catch: JSONException -> L16
        r2.put("spans", r1);     // Catch: JSONException -> L16
        r2.put("collect_from", 1);     // Catch: JSONException -> L16
        r2.put("page_name", f4130a);     // Catch: JSONException -> L16
        r2.put("launch_mode", c.h());     // Catch: JSONException -> L16
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L16
        r8.put("trace", r2);     // Catch: JSONException -> L16
        if (c.i() == false) goto L14;
        com.bytedance.apm.f.a.a().b("auto span: " + r2);     // Catch: JSONException -> L16
    L14:
        com.bytedance.apm.d.a.a.c().a(new e("start_trace", "", null, null, r8));     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }
}
