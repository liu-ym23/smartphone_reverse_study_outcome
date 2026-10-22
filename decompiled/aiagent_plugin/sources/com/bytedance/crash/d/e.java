package com.bytedance.crash.d;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ag;
import com.bytedance.crash.ah;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.upload.o;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnsureDeliverer.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {
    private static final String TAG = "CustomException";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7358a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7359b = 30;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7360c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CopyOnWriteArrayList<e> f7362e;
    private static HashSet<String> j;
    private d f;
    private final ConcurrentLinkedQueue<f> g;
    private final ConcurrentLinkedQueue<f> h;
    private com.bytedance.crash.monitor.f i;

    static /* synthetic */ void a(e r0) {
        r0.d();
    }

    static /* synthetic */ ConcurrentLinkedQueue b(e r0) {
        return r0.h;
    }

    static {
        f7362e = new CopyOnWriteArrayList();
        j = new HashSet();
    }

    public e(com.bytedance.crash.monitor.f r2) {
        this.h = new ConcurrentLinkedQueue();
        this.g = new ConcurrentLinkedQueue();
        this.i = r2;
        f7362e.add(this);
    }

    public static void a() {
        Iterator<e> r0 = f7362e.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L13;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        r1.h.clear();     // Catch: Throwable -> L8
        r1.g.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    public static void a(int r0) {
        if (r0 <= 0) goto L5;
        f7358a = r0;
        return;
    }

    public static void b(int r0) {
        if (r0 > 0) goto L4;
        f7360c = true;
        return;
    L4:
        f7359b = r0;
    }

    public static void a(String r1) {
        j.add(r1);
    }

    public void a(com.bytedance.crash.monitor.f r1) {
        this.i = r1;
    }

    public boolean b() {
        d r0 = this.f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public void c(int r14) {
        if (a("core_exception_monitor", null) == false) goto L5;
        return;
    L5:
        Thread r0 = Thread.currentThread();
        b(new f(null, r0.getStackTrace(), r14, null, true, null, r0.getName(), "EnsureNotReachHere", "core_exception_monitor", "exception"));
    }

    public void a(String r14, int r15) {
        if (a("core_exception_monitor", r14) == false) goto L6;
        r.b(TAG, "reportMessage：isDrop:" + r14);
        return;
    L6:
        Thread r0 = Thread.currentThread();
        b(new f(null, r0.getStackTrace(), r15, r14, true, null, r0.getName(), "EnsureNotReachHere", "core_exception_monitor", "exception"));
    }

    public void a(String r13, Map<String, String> r14, int r15) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if (a("core_exception_monitor", r13) == false) goto L6;
        r.b(TAG, "reportMessage：isDrop:" + r13);
        return;
    L6:
        Thread r16 = Thread.currentThread();
        b(new f(null, r16.getStackTrace(), r15, r13, true, r6, r16.getName(), "EnsureNotReachHere", "core_exception_monitor", "exception"));
    }

    public void a(Throwable r4) {
        if (a("core_exception_monitor", null) == false) goto L6;
        r.b(TAG, "reportThrowable：isDrop:");
        return;
    L6:
        a(null, null, r4, "core_exception_monitor");
    }

    public void a(Throwable r3, String r4) {
        a(r4, null, r3, "core_exception_monitor");
    }

    public void a(Throwable r3, String r4, Map<String, String> r5) {
        a(r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), r3, "core_exception_monitor");
    }

    public void a(String r10, Map<String, String> r11, Throwable r12, String r13) {
        a(r12, null, r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"), Thread.currentThread().getName(), "EnsureNotReachHere", r13, true);
    }

    public void a(Throwable r14, StackTraceElement[] r15, String r16, Map<String, String> r17, String r18, String r19, String r20, boolean r21) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r20) == false) goto L5;
        String r10 = "core_exception_monitor";
    L6:
        r.a(TAG, "reportJavaEnsure:message:" + r16 + " " + com.bytedance.crash.o.b.a());
        if (a(r10, r16) == false) goto L10;
        r.b(TAG, "reportJavaEnsure：isDrop:" + r10 + " " + r16);
        return;
    L10:
        b(new f(r14, r15, 0, r16, r21, r7, r18, r19, r10, "exception"));
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public void a(String r10, String r11, String r12, String r13, Map<String, String> r14, String r15) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r15) == false) goto L5;
        r15 = "core_exception_monitor";
    L5:
        String r6 = r15;
        if (a(r6, r13) == false) goto L9;
        r.b(TAG, "reportNativeEnsure：isDrop:" + r6 + " " + r13);
        return;
    L9:
        b(new f(r11, r10, r13, r4, r12, r6, "native_exception", Process.myPid()));
    }

    public void a(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r.b(TAG, "updateConfig :" + this.i.e() + " :" + r3);
        this.f = r3;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass1(this));
        DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }

    public boolean a(f r8) {
        if (this.f != null) goto L7;
        r.b(TAG, "isCanReport:config = null and event type" + r8.a());
        return false;
    L7:
        if (b(r8.a()) == false) goto L11;
        r.b(TAG, "the log_type = " + r8.a() + " and message = " + r8.b() + "is discard because the stop upload");
        return false;
    L11:
        if (this.f.a(r8.a(), r8.b()) == true) goto L15;
        r.b(TAG, "the log_type = " + r8.a() + " and message = " + r8.b() + "is discard because the config" + this.f.b(r8.a()) + " " + this.f.a(r8.b()));
        return false;
    L15:
        if (TextUtils.isEmpty(r8.b()) == false) goto L17;
        String r7 = null;
    L18:
        String r0 = r8.c();
        boolean r3 = n.a().a(r7, r0);
        r.b(TAG, "the message " + r8.b() + "  is exceed limit:" + r3);
        if (r3 == true) goto L22;
        n.a().b(r0, r7);
        return true;
    L22:
        return false;
    L17:
        r7 = com.bytedance.crash.o.e.a(r8.b());
        goto L18
    }

    private void b(final f r3) {
        if (this.f == null) goto L5;
        DefaultWorkThread.post(new AnonymousClass2(this, r3));
        return;
    L5:
        if (this.g.size() < f7358a) goto L7;
        return;
    L7:
        r.c(TAG, "cache:" + r3);
        this.g.add(r3);
    }

    private void c() {
    L3:
        if (this.g.isEmpty() == true) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.g.poll(), f.class, "com.obric.aiagent.plugin");
        if (a(r0) == false) goto L3;
        this.h.add(r0);
        goto L3
    }

    private void d() {
        c();
        if (this.h.size() < f7359b) goto L6;
        e();
        return;
    }

    private void e() {
        if (this.h.isEmpty() == false) goto L22;
        return;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L21
        int r2 = 0;
        Map<String, String> r3 = null;
        if (ah.i() == true) goto L12;
        r3 = this.i.n().c();     // Catch: Exception -> L21
        Map<String, String> r4 = ag.c();     // Catch: Exception -> L21
        if (r4 == null) goto L12;
        HashMap r5 = new HashMap();     // Catch: Exception -> L21
        r5.putAll(r3);     // Catch: Exception -> L21
        r5.putAll(r4);     // Catch: Exception -> L21
        r3 = r5;
    L12:
        if (this.h.isEmpty() == true) goto L16;
        if (r2 > f7359b) goto L16;
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.h.poll(), f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L21
        r.b(TAG, "upload:message:" + r6.b() + " log_type:" + r6.a());     // Catch: Exception -> L21
        r1.put(r6.a(this.i, r3));     // Catch: Exception -> L21
        r2 = r2 + 1;     // Catch: Exception -> L21
    L16:
        r0.put("data", r1);     // Catch: Exception -> L21
        int r7 = Process.myPid();     // Catch: Exception -> L21
        JSONObject r8 = Header.a(this.i, System.currentTimeMillis(), CrashType.ENSURE, r7).b();     // Catch: Exception -> L21
        r0.put("header", r8);     // Catch: Exception -> L21
        if (f7361d == false) goto L19;
        return;
    L19:
        String r9 = o.a(com.bytedance.crash.config.f.f(), r8);     // Catch: Exception -> L21
        r.b(TAG, "isSuccess:" + com.bytedance.crash.upload.b.a(r9, r0) + "  upload:" + r9);     // Catch: Exception -> L21
        n.a().c();     // Catch: Exception -> L21
        return;
    }

    public static void a(boolean r0) {
        f7361d = r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        r.a(TAG, "run:" + com.bytedance.crash.o.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " " + this.i.e());
        c();
        e();
        DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }

    private boolean a(String r7, String r8) {
        if (b(r7) == false) goto L7;
        r.b(TAG, "isStopUpload：the logType = " + r7 + " message:" + r8);
        return true;
    L7:
        if (this.f != null) goto L13;
        if (this.g.size() < f7358a) goto L13;
        r.b(TAG, "the logType = " + r7 + "is discarded the cache exceed 100");
        return true;
    L13:
        if (f7359b > 0) goto L16;
        return true;
    L16:
        if (n.b() == false) goto L22;
        if (n.a().d() == false) goto L22;
        r.b(TAG, "the logType = " + r7 + "is discarded beacuse the report is exceed 100");
        return true;
    L22:
        if (this.f != null) goto L28;
        if (this.g.size() < f7358a) goto L28;
        r.b(TAG, "the logType = " + r7 + "is discarded the cache exceed 100");
        return true;
    L28:
        if (this.f != null) goto L31;
        return false;
    L31:
        r.b(TAG, "the logType = " + r7 + "message = " + r8 + " isSample = " + this.f.a(r7, r8));
        return !this.f.a(r7, r8);
    }

    public static boolean b(String r1) {
        if (f7360c == true) goto L5;
        return false;
    L5:
        return !j.contains(r1);
    }
}
