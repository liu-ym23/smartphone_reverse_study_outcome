package com.bytedance.crash.d;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.q;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.o.x;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.o;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BizExceptionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7342a = "BizExceptionManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f7343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f7344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedList<a> f7346e;
    private LinkedList<a> f;
    private ConcurrentHashMap<String, Integer> g;

    /* JADX INFO: compiled from: BizExceptionManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Throwable f7350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, String> f7352e;
        private long f;
        private Map<String, String> g;

        static /* synthetic */ String a(a r0) {
            return r0.f7348a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f7351d;
        }

        public a(String r3, Throwable r4, String r5, String r6, Map<String, String> r7, Map<String, String> r8) {
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            this.f7348a = r3;
            this.f7350c = r4;
            this.f7351d = r5;
            this.f7352e = r9;
            this.f7349b = r6;
            this.f = System.currentTimeMillis();
            this.g = r10;
        }

        JSONObject a(Header r9) {
            JSONObject r3 = new JSONObject();
            String r4 = x.a(this.f7350c);
            r3.put("event_type", "biz_exception");     // Catch: Exception -> L41
            r3.put("crash_time", this.f);     // Catch: Exception -> L41
            r3.put("biz_exception_type", this.f7348a);     // Catch: Exception -> L41
            r3.put("app_start_time", com.bytedance.crash.i.f());     // Catch: Exception -> L41
            r3.put(DBHelper.COL_TIME, this.f);     // Catch: Exception -> L41
            r3.put("crash_md5", com.bytedance.crash.o.e.a(r4));     // Catch: Exception -> L41
            r3.put("message", this.f7351d);     // Catch: Exception -> L41
            r3.put("crash_thread_name", this.f7349b);     // Catch: Exception -> L41
            r3.put("process_name", com.bytedance.crash.o.b.c());     // Catch: Exception -> L41
            r3.put("exception_type", 1);     // Catch: Exception -> L41
            r3.put("process_name", com.bytedance.crash.o.b.a());     // Catch: Exception -> L41
            r3.put("app_start_time", com.bytedance.crash.i.f());     // Catch: Exception -> L41
            r3.put("pid", Process.myPid());     // Catch: Exception -> L41
            StackTraceElement r1 = this.f7350c.getStackTrace()[0];     // Catch: Exception -> L41
            r3.put("class_ref", r1.getClassName());     // Catch: Exception -> L41
            r3.put("method", r1.getMethodName());     // Catch: Exception -> L41
            r3.put("line_num", r1.getLineNumber());     // Catch: Exception -> L41
            r3.put("stack", r4);     // Catch: Exception -> L41
            ActivityLifecycle.a(r3);     // Catch: Exception -> L41
            ActivityLifecycle.b(r3);     // Catch: Exception -> L41
            r3.put("is_background", ActivityLifecycle.h());     // Catch: Exception -> L41
            q.a(r3);     // Catch: Exception -> L41
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L41
            r3.put("filters", r2);     // Catch: Exception -> L41
            Iterator<Map.Entry<String, String>> r5 = this.f7352e.entrySet().iterator();     // Catch: Exception -> L41
        L6:
            if (r5.hasNext() == false) goto L13;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41
            if (r6.getKey() == null) goto L6;
            if (r6.getValue() == null) goto L6;
            r2.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), r6.getValue());     // Catch: Exception -> L41
            goto L6
        L13:
            if (NativeBridge.g() == false) goto L15;
            String r7 = "true";
        L16:
            l.a(r2, "is_64_runtime", r7);     // Catch: Exception -> L41
            String r10 = r9.b().optString(HardwareInfo.KEY_HW_CPU_ABI);     // Catch: Exception -> L41
            if (TextUtils.isEmpty(r10) == true) goto L19;
            boolean r8 = r10.contains("64");     // Catch: Exception -> L41
            l.a(r2, "is_x86_devices", Boolean.valueOf(r10.contains("86")));     // Catch: Exception -> L41
            l.a(r2, "is_64_devices", Boolean.valueOf(r8));     // Catch: Exception -> L41
        L19:
            JSONObject r11 = r3.optJSONObject(MonitorConstants.CUSTOM);     // Catch: Exception -> L41
            if (r11 != null) goto L22;
            r11 = new JSONObject();     // Catch: Exception -> L41
            r3.put(MonitorConstants.CUSTOM, r11);     // Catch: Exception -> L41
        L22:
            Map<String, String> r12 = this.g;     // Catch: Exception -> L41
            if (r12 == null) goto L33;
            Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();     // Catch: Exception -> L41
        L26:
            if (r13.hasNext() == false) goto L33;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41
            if (r0.getKey() == null) goto L26;
            if (r0.getValue() == null) goto L26;
            r11.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), r0.getValue());     // Catch: Exception -> L41
        L33:
            if (com.bytedance.crash.monitor.h.a() == null) goto L43;
            Map<String, String> r14 = com.bytedance.crash.monitor.h.a().n().b(CrashType.ENSURE);     // Catch: Exception -> L41
            if (r14 == null) goto L43;
            Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();     // Catch: Exception -> L41
        L37:
            if (r15.hasNext() == false) goto L43;
            Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L41
            r11.put((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.aiagent.plugin"), r16.getValue());     // Catch: Exception -> L41
        L43:
            return r3;
        L15:
            r7 = "false";
        L41:
            e = move-exception;
            r.c(c.d(), e);
            goto L43
        }
    }

    public c() {
        this.f7346e = new LinkedList();
        this.f = new LinkedList();
        this.g = new ConcurrentHashMap();
    }

    static /* synthetic */ String d() {
        return f7342a;
    }

    static {
        f7343b = new c();
    }

    public static c a() {
        return f7343b;
    }

    public static boolean a(String r2) {
        b r0 = f7343b.f7344c;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.a() == false) goto L11;
        if (f7343b.f7344c.a(r2) == false) goto L11;
        return true;
    }

    public static boolean b() {
        if (f7343b.f7344c != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void a(b r4) {
        if (com.bytedance.crash.config.h.d() == false) goto L5;
        r.b(f7342a, "setConfig:" + r4);
    L5:
        if (r4 != null) goto L14;
        LinkedList<a> r0 = this.f7346e;
        monitor-enter(r0);
        this.f7346e.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        this.f7345d = System.currentTimeMillis();
        f7343b.f7344c = r4;
        if (this.f7344c.a() == true) goto L32;
        LinkedList<a> r5 = this.f7346e;
        monitor-enter(r5);
        this.f7346e.clear();     // Catch: Throwable -> L29
        monitor-exit(r5);     // Catch: Throwable -> L29
        LinkedList<a> r1 = this.f;
        monitor-enter(r1);
        this.f.clear();     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        DefaultWorkThread.removeCallbacks(this);
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    L32:
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
        e();
        c();
    }

    public void a(String r8, Throwable r9, String r10, Map<String, String> r11, Map<String, String> r12, boolean r13) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (r13 == true) goto L11;
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(r8), Integer.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L8;
        this.g.put(r8, 1);
        goto L11
    L8:
        if (r14.intValue() <= 10) goto L10;
        return;
    L10:
        this.g.put(r8, Integer.valueOf(r14.intValue() + 1));
    L11:
        b r15 = this.f7344c;
        if (r15 != null) goto L28;
        LinkedList<a> r16 = this.f7346e;
        monitor-enter(r16);
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.f7346e.size() < 90) goto L18;
        this.f7346e.removeFirst();     // Catch: Throwable -> L24
    L18:
        this.f7346e.add(new a(r8, r9, r10, Thread.currentThread().getName(), r5, r6));     // Catch: Throwable -> L24
        monitor-exit(r16);     // Catch: Throwable -> L24
        if (com.bytedance.crash.config.h.d() == false) goto L65;
        r.a(f7342a, "config is not fetch:logType:" + r8 + " message:" + r10);
        return;
    L65:
        return;
    L28:
        if (r15.a() == true) goto L34;
        if (com.bytedance.crash.config.h.d() == false) goto L66;
        r.a(f7342a, "enable_upload is not enable:" + r8 + " message:" + r10);
        return;
    L66:
        return;
    L34:
        if (this.f7344c.a(r8) == true) goto L40;
        if (com.bytedance.crash.config.h.d() == false) goto L67;
        r.a(f7342a, r8 + " message:" + r10 + " is not sample");
        return;
    L67:
        return;
    L40:
        if (com.bytedance.crash.config.h.d() == false) goto L42;
        r.a(f7342a, r8 + " message:" + r10 + " is sample");
    L42:
        e();
        LinkedList<a> r17 = this.f;
        monitor-enter(r17);
        this.f.add(new a(r8, r9, r10, Thread.currentThread().getName(), r5, r6));     // Catch: Throwable -> L56
        monitor-exit(r17);     // Catch: Throwable -> L56
        LinkedList<a> r18 = this.f;
        monitor-enter(r18);
    L53:
        th = move-exception;
        throw th;
    L49:
        if (this.f.size() < 30) goto L51;
        DefaultWorkThread.post(new AnonymousClass1(this));     // Catch: Throwable -> L53
    L51:
        monitor-exit(r18);     // Catch: Throwable -> L53
        return;
    L56:
        th = move-exception;
        throw th;
    }

    private void e() {
        if (this.f7344c.a() == true) goto L19;
        LinkedList<a> r0 = this.f7346e;
        monitor-enter(r0);
        this.f7346e.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        LinkedList<a> r1 = this.f;
        monitor-enter(r1);
        this.f.clear();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        ArrayList r2 = null;
        LinkedList<a> r3 = this.f7346e;
        monitor-enter(r3);
    L50:
        th = move-exception;
        throw th;
    L22:
        if (this.f7346e.size() <= 0) goto L36;
        r2 = new ArrayList();     // Catch: Throwable -> L50
        Iterator<a> r4 = this.f7346e.iterator();     // Catch: Throwable -> L50
    L25:
        if (r4.hasNext() == false) goto L35;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        if (this.f7344c.a(a.a(r5)) == true) goto L29;
        if (com.bytedance.crash.config.h.d() == false) goto L25;
        r.a(f7342a, a.a(r5) + " message:" + a.b(r5) + " is not sample");     // Catch: Throwable -> L50
        goto L25
    L29:
        if (com.bytedance.crash.config.h.d() == false) goto L31;
        r.a(f7342a, a.a(r5) + " message:" + a.b(r5) + " is sample");     // Catch: Throwable -> L50
    L31:
        r2.add(r5);     // Catch: Throwable -> L50
        goto L25
    L35:
        this.f7346e.clear();     // Catch: Throwable -> L50
    L36:
        monitor-exit(r3);     // Catch: Throwable -> L50
        if (r2 == null) goto L47;
        LinkedList<a> r6 = this.f;
        monitor-enter(r6);
        this.f.addAll(r2);     // Catch: Throwable -> L43
        monitor-exit(r6);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L47:
        if (com.bytedance.crash.config.h.d() == false) goto L69;
        r.a(f7342a, "report exception size:" + this.f.size());
        return;
    }

    public void c() {
        if (com.bytedance.crash.config.h.d() == false) goto L5;
        r.a(f7342a, "upload");
    L5:
        LinkedList<a> r0 = this.f;
        monitor-enter(r0);
    L40:
        th = move-exception;
        throw th;
    L8:
        if (this.f.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L40
        int r3 = 0;
    L13:
        if (this.f.isEmpty() == true) goto L18;
        if (r3 > 30) goto L18;
        r3 = r3 + 1;     // Catch: Throwable -> L40
        r1.add(this.f.remove(0));     // Catch: Throwable -> L40
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L40
        if (r1.size() != 0) goto L22;
        return;
    L22:
        int r6 = Process.myPid();
        Header r7 = Header.a(com.bytedance.crash.monitor.h.a(), System.currentTimeMillis(), CrashType.ENSURE, r6);
        HashSet r2 = null;
        if (com.bytedance.crash.config.h.d() == false) goto L26;
        r2 = new HashSet();     // Catch: Throwable -> L43
    L26:
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L43
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L43
    L28:
        if (r5.hasNext() == false) goto L33;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        JSONObject r9 = r8.a(r7);     // Catch: Throwable -> L43
        if (r2 == null) goto L32;
        r2.add(a.a(r8));     // Catch: Throwable -> L43
    L32:
        r4.put(r9);     // Catch: Throwable -> L43
        goto L28
    L33:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L43
        r10.put("data", r4);     // Catch: Throwable -> L43
        JSONObject r11 = r7.b();     // Catch: Throwable -> L43
        r10.put("header", r11);     // Catch: Throwable -> L43
        if (com.bytedance.crash.config.h.d() == false) goto L36;
        r.a(f7342a, "start upload:" + r2);     // Catch: Throwable -> L43
    L36:
        String r12 = o.a(com.bytedance.crash.config.f.g(), r11);     // Catch: Throwable -> L43
        boolean r13 = com.bytedance.crash.upload.b.a(r12, r10);     // Catch: Throwable -> L43
        if (com.bytedance.crash.config.h.d() == false) goto L52;
        r.a(f7342a, "end upload:" + r12 + " " + r13);     // Catch: Throwable -> L43
        return;
    L52:
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
        c();
        DefaultWorkThread.postDelayed(this, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }
}
