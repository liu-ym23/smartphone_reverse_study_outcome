package com.bytedance.crash.d;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ag;
import com.bytedance.crash.ah;
import com.bytedance.crash.dumper.q;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.o;
import com.bytedance.crash.o.r;
import com.bytedance.crash.o.x;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnsureReportData.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static int p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Throwable f7366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StackTraceElement[] f7367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7370e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Map<String, String> j;
    private boolean k;
    private int l;
    private long m;
    private JSONObject n;
    private String o;

    static {
        p = Process.myPid();
    }

    public f(Throwable r3, StackTraceElement[] r4, int r5, String r6, boolean r7, Map<String, String> r8, String r9, String r10, String r11, String r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        this.f7366a = r3;
        this.f7367b = r4;
        this.l = r5;
        this.f7368c = r6;
        this.k = r7;
        this.j = r13;
        this.f7369d = r9;
        this.f7370e = r10;
        this.f = r11;
        this.m = System.currentTimeMillis();
        this.o = r12;
    }

    public f(String r3, String r4, String r5, Map<String, String> r6, String r7, String r8, String r9, int r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.g = r3;
        this.h = a(r4, r5);
        this.f7368c = r5;
        this.f7369d = r7;
        this.f = r8;
        this.j = r11;
        this.m = System.currentTimeMillis();
        this.o = r9;
        p = r10;
    }

    public String a() {
        return this.f;
    }

    public String b() {
        return this.f7368c;
    }

    public String c() {
        String r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = this.h;
        if (r1 == null) goto L8;
        this.i = com.bytedance.crash.o.e.a(r1);
    L10:
        return this.i;
    L8:
        this.i = com.bytedance.crash.o.e.a(d());
        goto L10
    }

    public String d() {
        String r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Throwable r1 = this.f7366a;
        if (r1 == null) goto L8;
        String r2 = x.a(r1);
    L9:
        this.g = r2;
        return r2;
    L8:
        r2 = a(this.f7367b, this.l);
        goto L9
    }

    public JSONObject a(com.bytedance.crash.monitor.f r11, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        JSONObject r1 = this.n;
        if (r1 != null) goto L39;
        JSONObject r2 = new JSONObject();
        r2.put("event_type", this.o);     // Catch: Exception -> L35
        r2.put("crash_time", this.m);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.f) == false) goto L13;
        String r4 = "core_exception_monitor";
    L14:
        r2.put("log_type", r4);     // Catch: Exception -> L35
        r2.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Exception -> L35
        r2.put("crash_md5", c());     // Catch: Exception -> L35
        r2.put("message", this.f7368c);     // Catch: Exception -> L35
        r2.put("crash_thread_name", this.f7369d);     // Catch: Exception -> L35
        r2.put("process_name", com.bytedance.crash.o.b.a());     // Catch: Exception -> L35
        r2.put("app_start_time", com.bytedance.crash.i.f());     // Catch: Exception -> L35
        int r3 = 1;
        r2.put("exception_type", 1);     // Catch: Exception -> L35
        r2.put("pid", p);     // Catch: Exception -> L35
        if (this.h == null) goto L20;
        r2.put("class_ref", "Native");     // Catch: Exception -> L35
        r2.put("method", "Native");     // Catch: Exception -> L35
        r2.put("is_core", 1);     // Catch: Exception -> L35
        r2.put("line_num", -1);     // Catch: Exception -> L35
        r2.put("ensure_type", "EnsureNotReachHere");     // Catch: Exception -> L35
        r2.put("crash_lib_uuid", o.a().d(this.h));     // Catch: Exception -> L35
        r2.put("stack", this.h);     // Catch: Exception -> L35
        r2.put("has_dump", "true");     // Catch: Exception -> L35
        String r0 = this.g;     // Catch: Exception -> L35
        if (r0 == null) goto L30;
        r2.put("java_data", r0);     // Catch: Exception -> L35
    L30:
        String r5 = com.bytedance.crash.i.a();     // Catch: Exception -> L35
        if (r5 == null) goto L33;
        r2.put("business", r5);     // Catch: Exception -> L35
    L33:
        b(r2, r11);     // Catch: Exception -> L35
        a(r2, r11, r13);     // Catch: Exception -> L35
        q.a(r2);     // Catch: Exception -> L35
        r2.put("is_background", ActivityLifecycle.h());     // Catch: Exception -> L35
        ActivityLifecycle.a(r2);     // Catch: Exception -> L35
        ActivityLifecycle.b(r2);     // Catch: Exception -> L35
        a(r2, r11);     // Catch: Exception -> L35
    L37:
        return r2;
    L20:
        StackTraceElement[] r6 = this.f7367b;     // Catch: Exception -> L35
        if (r6 != null) goto L23;
        r6 = this.f7366a.getStackTrace();     // Catch: Exception -> L35
    L23:
        StackTraceElement r7 = r6[this.l];     // Catch: Exception -> L35
        r2.put("class_ref", r7.getClassName());     // Catch: Exception -> L35
        r2.put("method", r7.getMethodName());     // Catch: Exception -> L35
        r2.put("line_num", r7.getLineNumber());     // Catch: Exception -> L35
        r2.put("stack", d());     // Catch: Exception -> L35
        if (this.k == true) goto L27;
        r3 = 0;
    L27:
        r2.put("is_core", r3);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.f7370e) == true) goto L30;
        r2.put("ensure_type", this.f7370e);     // Catch: Exception -> L35
        goto L30
    L13:
        r4 = this.f;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        r.c("EnsureReportData", e);
        goto L37
    L39:
        if (r1.has("crash_md5") == true) goto L8;
        this.n.put("crash_md5", c());     // Catch: Throwable -> L38
    L8:
        return this.n;
    }

    public JSONObject a(com.bytedance.crash.monitor.f r4) {
        if (ah.i() == true) goto L5;
        Map<String, String> r0 = r4.n().c();
        Map<String, String> r1 = ag.c();
        if (r1 == null) goto L10;
        HashMap r2 = new HashMap();
        r2.putAll(r0);
        r2.putAll(r1);
        r0 = r2;
    L10:
        return a(r4, r0);
    L5:
        return a(r4, null);
    }

    public void a(JSONObject r5, com.bytedance.crash.monitor.f r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L32
        r0.put("storage_free_range", com.bytedance.crash.dumper.r.d());     // Catch: Throwable -> L32
        r0.put("alog_inited", com.bytedance.crash.alog.a.b());     // Catch: Throwable -> L32
        r5.put("filters", r0);     // Catch: Throwable -> L32
        if (this.h == null) goto L6;
        r0.put("has_dump", "true");     // Catch: Throwable -> L32
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.h == null) goto L20;
        Map<String, String> r4 = this.j;     // Catch: Throwable -> L32
        if (r4 == null) goto L20;
        Iterator<Map.Entry<String, String>> r9 = r4.entrySet().iterator();     // Catch: Throwable -> L32
    L14:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r10.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L14;
        if (r10.getValue() == null) goto L14;
        r0.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin"), r10.getValue());     // Catch: Throwable -> L32
    L20:
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.size() <= 0) goto L52;
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L32
    L24:
        if (r11.hasNext() == false) goto L53;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L24;
        if (r12.getValue() == null) goto L24;
        r0.put((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin"), r12.getValue());     // Catch: Throwable -> L32
        goto L24
    L53:
        return;
    L52:
        return;
    L32:
        th = move-exception;
        r.c("EnsureReportData", th);
    }

    private void a(JSONObject r1, com.bytedance.crash.monitor.f r2) {
        com.bytedance.crash.l.a r0 = r2.p();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        l.b(r1, r0.a(CrashType.ENSURE));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private void b(JSONObject r6, com.bytedance.crash.monitor.f r7) {
        if (com.bytedance.crash.monitor.b.g() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L23
        Map<String, String> r5 = this.j;     // Catch: Throwable -> L23
        if (r5 == null) goto L12;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();     // Catch: Throwable -> L23
    L10:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());     // Catch: Throwable -> L23
    L12:
        if (r7 == null) goto L20;
        Map<String, String> r9 = r7.n().b(CrashType.ENSURE);     // Catch: Throwable -> L23
        if (r9 == null) goto L20;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        r0.put((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin"), r11.getValue());     // Catch: Throwable -> L23
    L20:
        if (l.a(r0) == true) goto L28;
        r6.put(MonitorConstants.CUSTOM, r0);     // Catch: Throwable -> L23
        return;
    L28:
        return;
    }

    private String a(StackTraceElement[] r2, int r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length <= 0) goto L15;
        StringBuilder r1 = new StringBuilder();
    L8:
        if (r3 >= r2.length) goto L11;
        x.a(r2[r3], r1);
        r3 = r3 + 1;
        goto L8
    L11:
        return r1.toString();
    L15:
        return null;
    }

    private static String a(String r3, String r4) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.startsWith("Signal") == true) goto L21;
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L9;
        r0.append("Signal 111(NATIVE_EXCEPTION)\n");     // Catch: Throwable -> L17
    L14:
        r0.append(r3);     // Catch: Throwable -> L17
        goto L16
    L9:
        r0.append("Signal 111(");     // Catch: Throwable -> L17
        if (r4.length() <= 30) goto L12;
        r0.append(r4.substring(0, 30));     // Catch: Throwable -> L17
    L13:
        r0.append(")\n");     // Catch: Throwable -> L17
        goto L14
    L12:
        r0.append(r4);     // Catch: Throwable -> L17
    L16:
        return r0.toString();
    L21:
        return r3;
    }

    public String toString() {
        return "EnsureReportData{throwable=" + this.f7366a + ", traceElements=" + Arrays.toString(this.f7367b) + ", stackDepth=" + this.l + ", message='" + this.f7368c + "', isCore=" + this.k + ", data=" + this.j + ", threadName='" + this.f7369d + "', exceptionType='" + this.f7370e + "', logType='" + this.f + "', javaStack='" + this.g + "', nativeStack='" + this.h + "', eventTime=" + this.m + ", md5='" + this.i + "', totalData=" + this.n + '}';
    }
}
