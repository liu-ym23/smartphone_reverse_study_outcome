package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.block.trace.g;
import com.bytedance.apm.util.k;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TraceStats.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String TAG = "AppStartStats";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4911a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.bytedance.apm.e.b> f4914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4915e;
    private final String f;

    static {
    }

    static /* synthetic */ void a(e r0, int r1, String r2, String r3, long r4, com.bytedance.apm.f.e.a r6) {
        r0.a(r1, r2, r3, r4, r6);
    }

    static /* synthetic */ boolean a(e r0) {
        return r0.d();
    }

    static /* synthetic */ long b(e r2) {
        return r2.f4913c;
    }

    public e(String r3, String r4) {
        this.f4914d = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.f4915e = r3;
        this.f = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    private boolean d() {
        return "start_trace".equals(this.f4915e);
    }

    public long a() {
        return this.f4912b;
    }

    public void b() {
        this.f4912b = System.currentTimeMillis();
    }

    public void a(String r2, String r3) {
        a(r2, r3, false);
    }

    public void a(String r5, String r6, boolean r7) {
        if (((com.bytedance.apm.e.b) ZeusTransformUtils.preCheckCast(this.f4914d.get(r5 + "#" + r6), com.bytedance.apm.e.b.class, "com.obric.aiagent.plugin")) == null) goto L5;
        if (r7 == true) goto L5;
        return;
    L5:
        this.f4914d.put(r5 + "#" + r6, new com.bytedance.apm.e.b(System.currentTimeMillis()));
    }

    public void b(String r6, String r7) {
        com.bytedance.apm.e.b r0 = (com.bytedance.apm.e.b) ZeusTransformUtils.preCheckCast(this.f4914d.get(r6 + "#" + r7), com.bytedance.apm.e.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(System.currentTimeMillis(), Thread.currentThread().getName());
        this.f4914d.put(r6 + "#" + r7, r0);
    }

    public void a(int r9, String r10, long r11, long r13) {
        a(r9, "", r10, r11, r13);
    }

    private void a(final int r12, final String r13, final String r14, long r15, long r17) {
        if (r12 == (-1)) goto L5;
    L11:
        this.f4913c = System.currentTimeMillis();
        if (r17 <= 0) goto L14;
        this.f4913c = this.f4912b + r17;
    L14:
        long r2 = this.f4913c - this.f4912b;
        if (r15 > 0) goto L17;
    L19:
        com.bytedance.apm.f.e.a r0 = null;
        if (d() == false) goto L22;
        r0 = com.bytedance.apm.f.b.a(r2);
    L22:
        final com.bytedance.apm.f.e.a r10 = r0;
        if (d() == false) goto L30;
        if (com.bytedance.perf.monitor.a.f9045b == false) goto L30;
        if (f4911a == false) goto L30;
        f4911a = false;
        b(r12, r13, this.f4912b, this.f4913c);
    L30:
        if (d() == true) goto L32;
    L41:
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r10, r12, r13, r14));
        if (d() == false) goto L47;
        com.bytedance.apm.f.a.c.a();
        return;
    L47:
        return;
    L32:
        if (com.bytedance.apm.f.a.a().c().a() == false) goto L41;
        if (com.bytedance.apm.internal.a.b(8) == false) goto L41;
        JSONObject r1 = new JSONObject();
        r1.put("is_launch_lock", true);     // Catch: JSONException -> L38
    L40:
        LockMonitorManager.endLockDetect(r1);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L17:
        if (r2 <= r15) goto L19;
        return;
    L5:
        if (r13.isEmpty() == false) goto L11;
        if (com.bytedance.apm.c.i() == false) goto L11;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    public void c() {
        this.f4914d.clear();
    }

    private void a(int r19, String r20, String r21, long r22, com.bytedance.apm.f.e.a r24) {
        String r0 = "com.obric.aiagent.plugin";
        JSONArray r8 = new JSONArray();
        int r9 = 2;
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        ConcurrentHashMap<String, com.bytedance.apm.e.b> r1 = this.f4914d;
        if (r1 == null) goto L33;
        r1.clear();
    L33:
        JSONObject r2 = new JSONObject();
        r2.put("name", this.f);     // Catch: JSONException -> L60
        r2.put("page_type", this.f);     // Catch: JSONException -> L60
        r2.put("start", this.f4912b);     // Catch: JSONException -> L60
        r2.put("end", r22);     // Catch: JSONException -> L60
        r2.put("spans", r8);     // Catch: JSONException -> L60
        r2.put("collect_from", 2);     // Catch: JSONException -> L60
        r2.put("page_name", r21);     // Catch: JSONException -> L60
        if (r19 == (-1)) goto L38;
        r2.put("launch_mode", r19);     // Catch: JSONException -> L60
    L38:
        if (r20.isEmpty() == true) goto L41;
        r2.put("custom_launch_mode", r20);     // Catch: JSONException -> L60
    L41:
        if (com.bytedance.apm.h.a.a() == false) goto L44;
        com.bytedance.apm.h.a.c(TAG, r2.toString());     // Catch: JSONException -> L60
    L44:
        if (d() == true) goto L46;
    L49:
        JSONObject r3 = new JSONObject();
        r3.put("trace", r2);     // Catch: JSONException -> L62
        if (r24 == null) goto L55;
        JSONObject r4 = com.bytedance.apm.f.b.a(r24);     // Catch: JSONException -> L62
        if (r4 == null) goto L55;
        r3.put("perf_data", r4);     // Catch: JSONException -> L62
    L55:
        com.bytedance.apm.d.b.e r5 = new com.bytedance.apm.d.b.e(this.f4915e, "", null, null, r3);
        com.bytedance.apm6.perf.base.b.a(r5, false);
        if (com.bytedance.apm.c.i() == false) goto L58;
        k.a(TAG, "reportAsync: " + r3);
    L58:
        com.bytedance.apm.d.a.a.c().a(r5);
        return;
    L46:
        if (com.bytedance.apm.f.a.a().b().c() == false) goto L49;
        JSONObject r6 = new JSONObject();
        com.bytedance.apm.util.d.a().a(r6, true);
        com.bytedance.apm.util.d.a().b(r6, true);
        r2.put("device_info_data", r6);     // Catch: Throwable -> L61
        goto L49
    L4:
        if (TextUtils.equals(r21, com.bytedance.apm.agent.tracing.a.f4130a) == false) goto L6;
        r8 = com.bytedance.apm.agent.tracing.a.c();     // Catch: JSONException -> L28
    L6:
        ConcurrentHashMap<String, com.bytedance.apm.e.b> r12 = this.f4914d;     // Catch: JSONException -> L28
        if (r12 == null) goto L30;
        if (r12.isEmpty() == true) goto L30;
        Iterator<Map.Entry<String, com.bytedance.apm.e.b>> r13 = this.f4914d.entrySet().iterator();     // Catch: JSONException -> L28
    L11:
        if (r13.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, r0);     // Catch: JSONException -> L28
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, r0);     // Catch: JSONException -> L28
        com.bytedance.apm.e.b r16 = (com.bytedance.apm.e.b) ZeusTransformUtils.preCheckCast(r14.getValue(), com.bytedance.apm.e.b.class, r0);     // Catch: JSONException -> L28
        if (r16.f4588b == 0) goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L28
        String[] r11 = r15.split("#");     // Catch: JSONException -> L28
        if (r11.length == r9) goto L20;
        String r17 = r0;
        if (r11.length != 1) goto L26;
        r10.put("span_name", r11[0]);     // Catch: JSONException -> L28
    L26:
        r10.put("start", r16.f4587a);     // Catch: JSONException -> L28
        r10.put("end", r16.f4588b);     // Catch: JSONException -> L28
        r10.put("thread", r16.f4589c);     // Catch: JSONException -> L28
        r8.put(r10);     // Catch: JSONException -> L28
        r0 = r17;
        r9 = 2;
        goto L11
    L20:
        if ("page_load_trace".equals(this.f4915e) == false) goto L22;
        r10.put("name", r11[1]);     // Catch: JSONException -> L28
        r17 = r0;
        goto L26
    L22:
        r17 = r0;
        r10.put("module_name", r11[0]);     // Catch: JSONException -> L28
        r10.put("span_name", r11[1]);     // Catch: JSONException -> L28
        goto L26
    }

    private void b(final int r14, final String r15, final long r16, final long r18) {
        final long[] r3 = g.a().e();
        final long r4 = SystemClock.uptimeMillis();
        if (r3 == null) goto L6;
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2(this, r3, r4, r18, r16, r14, r15));
        return;
    }
}
