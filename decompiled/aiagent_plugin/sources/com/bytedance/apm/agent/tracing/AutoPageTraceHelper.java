package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import com.bytedance.apm.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AutoPageTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f4127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<b> f4128c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f4129d;

    public AutoPageTraceHelper() {
    }

    static /* synthetic */ void a() {
        b();
    }

    static {
        f4127b = new HashSet(32);
        f4128c = new ConcurrentLinkedQueue();
        f4129d = 20000;
    }

    public static void a(long r0) {
        f4129d = r0;
    }

    public static void onTrace(String r4, String r5, boolean r6) {
        if (TextUtils.equals("onCreate", r5) == false) goto L19;
        if (r6 == false) goto L13;
        if (f4126a == true) goto L8;
        a.a(r4);
    L8:
        ConcurrentLinkedQueue<b> r7 = f4128c;
        if (r7.size() <= 50) goto L11;
        r7.poll();
    L11:
        r7.add(new b(r4, System.currentTimeMillis()));
        return;
    L13:
        if (f4126a == true) goto L15;
        a.a();
    L15:
        b r8 = (b) ZeusTransformUtils.preCheckCast(f4128c.peek(), b.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L57;
        r8.f4137c = System.currentTimeMillis();
        return;
    L57:
        return;
    L19:
        if (TextUtils.equals("onResume", r5) == false) goto L34;
        if (r6 == false) goto L28;
        if (f4126a == true) goto L24;
        a.d(r4);
    L24:
        b r9 = (b) ZeusTransformUtils.preCheckCast(f4128c.peek(), b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L59;
        r9.f4138d = System.currentTimeMillis();
        return;
    L59:
        return;
    L28:
        if (f4126a == true) goto L30;
        a.b();
    L30:
        b r10 = (b) ZeusTransformUtils.preCheckCast(f4128c.peek(), b.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L61;
        r10.f4139e = System.currentTimeMillis();
        return;
    L61:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r5) == false) goto L47;
        if (r6 == true) goto L37;
        return;
    L37:
        if (f4126a == true) goto L39;
        a.e(r4);
        f4126a = true;
    L39:
        b r11 = (b) ZeusTransformUtils.preCheckCast(f4128c.peek(), b.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L42;
        return;
    L42:
        if (r11.f != 0) goto L65;
        r11.f = System.currentTimeMillis();
        if (com.bytedance.apm.trace.b.a.a(r4) != null) goto L66;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1());
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if (TextUtils.equals("onStart", r5) == false) goto L68;
        if (r6 == false) goto L53;
        if (f4126a == true) goto L69;
        a.b(r4);
        return;
    L69:
        return;
    L53:
        if (f4126a == true) goto L71;
        a.c(r4);
        return;
    L71:
        return;
    }

    public static void a(long r3, String r5) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(f4128c.peek(), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r5, r0.f4135a) == false) goto L10;
        r0.g = r3;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2());
        return;
    }

    private static void b() {
        int r4 = f4128c.size();     // Catch: Exception -> L39
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L58;
        ConcurrentLinkedQueue<b> r6 = f4128c;     // Catch: Exception -> L39
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6.peek(), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L39
        if (r7 == null) goto L59;
        if (r7.f == 0) goto L10;
    L12:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r6.poll(), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L39
        if (r8.a() == false) goto L56;
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L39
        r9.put("name", "onCreate");     // Catch: Exception -> L39
        r9.put("start", r8.f4136b);     // Catch: Exception -> L39
        r9.put("end", r8.f4137c);     // Catch: Exception -> L39
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L39
        r10.put("name", "onResume");     // Catch: Exception -> L39
        r10.put("start", r8.f4138d);     // Catch: Exception -> L39
        r10.put("end", r8.f4139e);     // Catch: Exception -> L39
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L39
        r11.put("name", "onWindowFocusChanged");     // Catch: Exception -> L39
        r11.put("start", r8.f);     // Catch: Exception -> L39
        JSONArray r12 = new JSONArray();     // Catch: Exception -> L39
        r12.put(r9);     // Catch: Exception -> L39
        r12.put(r10);     // Catch: Exception -> L39
        r12.put(r11);     // Catch: Exception -> L39
        if (r8.g <= 0) goto L18;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L39
        r13.put("name", "viewShow");     // Catch: Exception -> L39
        r13.put("start", r8.g);     // Catch: Exception -> L39
        r12.put(r13);     // Catch: Exception -> L39
    L18:
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L39
        r14.put("name", "page_load_stats");     // Catch: Exception -> L39
        r14.put("page_type", "activity");     // Catch: Exception -> L39
        r14.put("start", r8.f4136b);     // Catch: Exception -> L39
        if (r8.g <= 0) goto L25;
        r14.put("end", r8.g);     // Catch: Exception -> L39
        if ((r8.g - r8.f4136b) < 0) goto L38;
        if ((r8.g - r8.f4136b) > f4129d) goto L38;
    L30:
        r14.put("spans", r12);     // Catch: Exception -> L39
        HashSet<String> r15 = f4127b;     // Catch: Exception -> L39
        if (r15.contains(r8.f4135a) == false) goto L33;
        int r16 = 2;
    L34:
        r15.add(r8.f4135a);     // Catch: Exception -> L39
        r14.put("launch_mode", r16);     // Catch: Exception -> L39
        r14.put("collect_from", 1);     // Catch: Exception -> L39
        r14.put("page_name", r8.f4135a);     // Catch: Exception -> L39
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L39
        r17.put("trace", r14);     // Catch: Exception -> L39
        if (com.bytedance.apm.h.a.a() == false) goto L37;
        com.bytedance.apm.h.a.c("PageLoadTrace", r14.toString());     // Catch: Exception -> L39
    L37:
        com.bytedance.apm.agent.b.a.a("page_load_trace", null, null, r17);     // Catch: Exception -> L39
        goto L38
    L33:
        r16 = 1;
    L38:
        r5 = r5 + 1;
        goto L4
    L25:
        r14.put("end", r8.f);     // Catch: Exception -> L39
        if ((r8.f - r8.f4136b) < 0) goto L38;
        if ((r8.f - r8.f4136b) <= f4129d) goto L30;
    L56:
        return;
    L10:
        if (r7.g != 0) goto L12;
        return;
    L59:
        return;
    L58:
        return;
    L39:
        e = move-exception;
        if (c.i() == false) goto L57;
        e.printStackTrace();
        return;
    }
}
