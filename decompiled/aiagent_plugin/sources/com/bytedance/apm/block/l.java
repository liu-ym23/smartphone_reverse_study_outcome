package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.common.utility.Logger;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StackThread.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final String TAG = "StackThread";
    private static long f = 1000;
    private static boolean g = false;
    private static boolean h = false;
    private static volatile l u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadWithHandler f4372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f4374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4376e;
    private boolean i;
    private boolean j;
    private final String k;
    private final StringBuilder l;
    private final StringBuilder m;
    private final StringBuilder n;
    private d o;
    private d p;
    private volatile boolean q;
    private volatile boolean r;
    private boolean s;
    private boolean t;
    private LinkedList<com.bytedance.apm.d.b.d> v;
    private boolean w;
    private com.bytedance.apm.g.c x;
    private final Runnable y;
    private final Runnable z;

    static {
    }

    static /* synthetic */ long a(l r2) {
        return r2.f4375d;
    }

    static /* synthetic */ void a(l r0, d r1, String r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(l r0, d r1, String r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(l r0, boolean r1, d r2, String r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ d b(l r0) {
        return r0.o;
    }

    static /* synthetic */ boolean c(l r0) {
        return r0.w;
    }

    static /* synthetic */ String d(l r0) {
        return r0.k;
    }

    static /* synthetic */ StringBuilder e(l r0) {
        return r0.l;
    }

    static /* synthetic */ StringBuilder f(l r0) {
        return r0.m;
    }

    static /* synthetic */ JSONObject g(l r0) {
        return r0.c();
    }

    static /* synthetic */ long h(l r2) {
        return r2.f4376e;
    }

    static /* synthetic */ boolean i(l r0) {
        return r0.f4374c;
    }

    static /* synthetic */ boolean j(l r0) {
        return r0.j;
    }

    static /* synthetic */ boolean k(l r0) {
        return r0.f4373b;
    }

    private l() {
        this.f4373b = false;
        this.f4374c = false;
        this.f4375d = EntityContentProvider.g;
        this.f4376e = 5000;
        this.i = false;
        this.j = true;
        this.l = new StringBuilder(BizStatus.StatusChangedReason.PAUSED__ENTERED_CALL_USER);
        this.m = new StringBuilder(BizStatus.StatusChangedReason.PAUSED__ENTERED_CALL_USER);
        this.n = new StringBuilder(BizStatus.StatusChangedReason.PAUSED__ENTERED_CALL_USER);
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.v = new LinkedList();
        this.w = false;
        this.x = null;
        this.y = new AnonymousClass1(this);
        this.z = new AnonymousClass2(this);
        this.k = l.class.getName();
    }

    static l a() {
        if (u != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (u != null) goto L9;
        u = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return u;
    }

    public void b() {
        ThreadWithHandler r0 = new ThreadWithHandler(TAG);
        this.f4372a = r0;
        r0.a();
    }

    public void a(boolean r1) {
        this.w = r1;
    }

    public static void a(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        f = r2;
    }

    public void b(boolean r1) {
        this.r = r1;
    }

    private JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        ActivityManager r4 = (ActivityManager) ZeusTransformUtils.preCheckCast(r1.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L8
        r4.getMemoryInfo(r2);     // Catch: Exception -> L8
        r0.put("availMem", r2.availMem);     // Catch: Exception -> L8
        r0.put("lowMemory", r2.lowMemory);     // Catch: Exception -> L8
        r0.put("threshold", r2.threshold);     // Catch: Exception -> L8
        r0.put("totalMem", com.bytedance.common.a.a.a(r2));     // Catch: Exception -> L8
    L6:
        Runtime r5 = Runtime.getRuntime();     // Catch: Exception -> L8
        r0.put("max_memory", r5.maxMemory());     // Catch: Exception -> L8
        r0.put("free_memory", r5.freeMemory());     // Catch: Exception -> L8
        r0.put("total_memory", r5.totalMemory());     // Catch: Exception -> L8
        return r0;
    L8:
        return null;
    }

    public void a(String r7) {
        if (this.f4372a.b() == true) goto L5;
        return;
    L5:
        if (h == false) goto L12;
        if (this.i == false) goto L12;
        d r0 = this.o;     // Catch: Exception -> L28
        r0.h = com.bytedance.monitor.collector.a.f8947b;     // Catch: Exception -> L28
        if ((this.o.h - this.o.g) <= this.f4375d) goto L12;
        this.o.k = true;     // Catch: Exception -> L28
        this.o.f4358d = false;     // Catch: Exception -> L28
        d r1 = this.o;     // Catch: Exception -> L28
        r1.f4357c = this.q;     // Catch: Exception -> L28
        a(this.o.a());     // Catch: Exception -> L28
    L12:
        if (this.p != null) goto L14;
    L16:
        d r2 = this.o;     // Catch: Exception -> L28
        if (r2 != null) goto L19;
        this.o = new d(com.bytedance.monitor.collector.a.f8947b, r7);     // Catch: Exception -> L28
    L21:
        if (this.j == false) goto L32;
        this.f4372a.a(this.y, this.f4375d);     // Catch: Exception -> L28
        if (this.f4373b == true) goto L25;
        return;
    L25:
        if (this.t == false) goto L34;
        this.f4372a.a(this.z, this.f4376e);     // Catch: Exception -> L28
        return;
    L34:
        return;
    L32:
        return;
    L19:
        r2.a(com.bytedance.monitor.collector.a.f8947b, r7);     // Catch: Exception -> L28
        goto L21
    L14:
        if (com.bytedance.apm.block.trace.f.a().f4428a.b() == false) goto L16;
        this.p.f4359e = true;     // Catch: Exception -> L28
    }

    public void c(boolean r10) {
        if (this.f4372a.b() == false) goto L55;
        d r0 = this.p;     // Catch: Exception -> L52
        if (r0 == null) goto L9;
        if (r10 == false) goto L8;
        r0.f = true;     // Catch: Exception -> L52
    L8:
        b(this.p);     // Catch: Exception -> L52
        this.p = null;     // Catch: Exception -> L52
    L9:
        d r1 = this.o;     // Catch: Exception -> L52
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.g >= 0) goto L14;
        return;
    L14:
        if (this.o.h != (-1)) goto L58;
        d r2 = this.o;     // Catch: Exception -> L52
        r2.h = com.bytedance.monitor.collector.a.f8947b;     // Catch: Exception -> L52
        if (this.j == false) goto L20;
        this.f4372a.c(this.y);     // Catch: Exception -> L52
        this.f4372a.c(this.z);     // Catch: Exception -> L52
    L20:
        if ((this.o.h - this.o.g) <= this.f4375d) goto L31;
        d(this.o);     // Catch: Exception -> L52
        d r3 = this.o;     // Catch: Exception -> L52
        r3.i = System.currentTimeMillis();     // Catch: Exception -> L52
        if (this.j == true) goto L24;
        this.o.m = true;     // Catch: Exception -> L52
    L24:
        this.o.f4358d = r10;     // Catch: Exception -> L52
        d r4 = this.o;     // Catch: Exception -> L52
        r4.f4357c = this.q;     // Catch: Exception -> L52
        a(this.o.a());     // Catch: Exception -> L52
        if ((this.o.h - this.o.g) <= this.f4376e) goto L31;
        if (r10 == false) goto L31;
        if (this.r == false) goto L31;
        i.a();     // Catch: Exception -> L52
    L31:
        if (g == false) goto L42;
        if ((this.o.h - this.o.g) <= f) goto L42;
        if (TextUtils.isEmpty(this.o.t) == false) goto L38;
        d(this.o);     // Catch: Exception -> L52
    L38:
        if (this.o.i != 0) goto L40;
        d r5 = this.o;     // Catch: Exception -> L52
        r5.i = System.currentTimeMillis();     // Catch: Exception -> L52
    L40:
        a(r10, this.o.a());     // Catch: Exception -> L52
    L42:
        if (h == false) goto L59;
        Message r11 = com.bytedance.monitor.collector.i.a(com.bytedance.monitor.collector.i.a());     // Catch: Exception -> L52
        if (r11 != null) goto L46;
        return;
    L46:
        long r6 = SystemClock.uptimeMillis();     // Catch: Exception -> L52
        if (r11.getTarget() != null) goto L49;
        return;
    L49:
        if (r11.getWhen() >= r6) goto L61;
        this.i = true;     // Catch: Exception -> L52
        this.o.a(r6, null);     // Catch: Exception -> L52
        this.f4372a.a(this.y, this.f4375d);     // Catch: Exception -> L52
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L55:
        return;
    }

    public void d(boolean r1) {
        this.s = r1;
    }

    public void e(boolean r1) {
        this.t = r1;
    }

    public void b(long r3) {
        if (r3 >= 70) goto L5;
        r3 = EntityContentProvider.g;
    L5:
        this.f4375d = r3;
        d();
    }

    public void c(long r3) {
        if (r3 >= this.f4375d) goto L5;
        r3 = 5000;
    L5:
        this.f4376e = r3;
        d();
    }

    public void f(boolean r1) {
        this.j = r1;
    }

    private void d() {
        long r0 = this.f4376e;
        long r2 = this.f4375d;
        if (r0 >= r2) goto L6;
        this.f4376e = r2 + 50;
        return;
    }

    public void g(boolean r1) {
        this.f4373b = r1;
    }

    public void h(boolean r1) {
        this.f4374c = r1;
    }

    public void a(com.bytedance.apm.g.c r3) {
        this.x = (com.bytedance.apm.g.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.g.c.class, "com.obric.aiagent.plugin");
    }

    private StackTraceElement[] a(StackTraceElement[] r6) {
        if (r6 == null) goto L5;
        return r6;
    L5:
        return new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};
    }

    private void a(d r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.f4355a == true) goto L8;
        r6.b();
    L8:
        if ((r6.h - r6.g) < this.f4376e) goto L10;
        boolean r0 = true;
    L11:
        r6.j = r0;
        com.bytedance.monitor.collector.g.e r1 = com.bytedance.monitor.collector.k.a().o();
        if (r1 == null) goto L19;
        StackTraceElement[] r2 = a(r6.p);
        if (r6.j == false) goto L16;
        StackTraceElement[] r3 = a(r6.q);
    L17:
        r1.a("uuid", r2, r3, null);
        goto L19
    L16:
        r3 = null;
    L19:
        if (r6.k == false) goto L21;
        b(r6);
        return;
    L21:
        this.p = r6;
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void b(final d r3) {
        com.bytedance.apm.thread.b.a().a(new AnonymousClass3(this, r3));
    }

    private void a(boolean r7, d r8, String r9) {
        if (this.s == true) goto L5;
        return;
    L5:
        JSONObject r0 = c(r8);
        r0.put("stack", r8.r);
        r0.put("message", r9);
        r0.put("ignore_stack", this.o.m);
        r0.put("event_type", "lag");
        r0.put("filters", b(r7, r8, r9));
        r0.put(MonitorConstants.CUSTOM, e());
        com.bytedance.apm.d.b.d r10 = new com.bytedance.apm.d.b.d("block_monitor", r0, r8.g);
        a(r10);
        com.bytedance.apm.d.a.a.c().a(r10);
        com.bytedance.apm.g.c r1 = this.x;
        if (r1 == null) goto L9;
        r1.a(r8.f4356b, r8.h - r8.g, r8.t, r8.r);
        return;
    }

    private void a(com.bytedance.apm.d.b.d r6) {
    L3:
        if (this.v.size() == 0) goto L13;
        if ((r6.f() - ((com.bytedance.apm.d.b.d) ZeusTransformUtils.preCheckCast(this.v.getFirst(), com.bytedance.apm.d.b.d.class, "com.obric.aiagent.plugin")).f()) < 0) goto L12;
        if ((r6.f() - ((com.bytedance.apm.d.b.d) ZeusTransformUtils.preCheckCast(this.v.getFirst(), com.bytedance.apm.d.b.d.class, "com.obric.aiagent.plugin")).f()) > 60000) goto L12;
        if (this.v.size() <= 60) goto L13;
        this.v.removeFirst();
    L12:
        this.v.removeFirst();
    L13:
        this.v.addLast(r6);
    }

    private void a(d r18, String r19, boolean r20) {
        if (this.t == true) goto L5;
        return;
    L5:
        Logger.e(TAG, "reportSeriousBlock :" + r18.r);
        JSONObject r3 = b(r18.f4358d, r18, r19);
        r3.put("sbuuid", "empty");
        JSONObject r5 = c(r18);
        r5.put("message", r19);
        if (r18.p == null) goto L43;
        if (r18.q == null) goto L43;
        int r2 = r18.p.length;
        int r7 = r18.q.length;
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r9 >= Math.min(r2, r7)) goto L19;
        int r12 = (r2 - r9) - 1;
        int r14 = (r7 - r9) - 1;
        if (r18.p[r12].equals(r18.q[r14]) == false) goto L15;
        r10 = r10 + 1;
        r9 = r9 + 1;
        goto L11
    L15:
        if (a(r18.p[r12], r18.q[r14]) == false) goto L19;
        r10 = r10 + 1;
    L19:
        if (r10 != 0) goto L22;
        r3.put("serious_stack_coincide", OProtocolTextEffectTextView.EffectNameNone);
    L21:
        JSONObject r16 = r3;
    L34:
        this.n.setLength(0);
    L35:
        if (r10 <= 0) goto L38;
        int r8 = r2 - r10;
        this.n.append("\tat ").append(r18.p[r8].getClassName()).append(".").append(r18.p[r8].getMethodName()).append("(").append(r18.p[r8].getFileName()).append(":").append(r18.p[r8].getLineNumber()).append(")\n");
        r10 = r10 - 1;
        goto L35
    L38:
        if (this.n.length() != 0) goto L40;
        String r4 = r18.r;
    L41:
        r5.put("stack", r4);
        r3 = r16;
        r3.put("sbuuid", r18.s);
        goto L43
    L40:
        r4 = this.n.toString();
        goto L41
    L22:
        if (r10 != r2) goto L25;
        if (r10 != r7) goto L25;
        r3.put("serious_stack_coincide", "full");
    L25:
        r3.put("serious_stack_coincide", "part");
        this.n.setLength(0);
        int r11 = 0;
    L27:
        if (r11 > (r2 - r10)) goto L29;
        this.n.append("\tat ").append(r18.p[r11].getClassName()).append(".").append(r18.p[r11].getMethodName()).append("(").append(r18.p[r11].getFileName()).append(":").append(r18.p[r11].getLineNumber()).append(")\n");
        r11 = r11 + 1;
        r3 = r3;
        goto L27
    L29:
        r16 = r3;
        r5.put("stack1", this.n.toString());
        this.n.setLength(0);
        int r15 = 0;
    L31:
        if (r15 > (r7 - r10)) goto L33;
        this.n.append("\tat ").append(r18.q[r15].getClassName()).append(".").append(r18.q[r15].getMethodName()).append("(").append(r18.q[r15].getFileName()).append(":").append(r18.q[r15].getLineNumber()).append(")\n");
        r15 = r15 + 1;
        goto L31
    L33:
        r5.put("stack2", this.n.toString());
    L43:
        if (this.w == false) goto L45;
        r5.put("stack", r18.r);
        r3.put("sbuuid", r18.s);
    L45:
        r5.put("stack_cost", r18.o - r18.n);
        r5.put("filters", r3);
        r5.put("event_type", "serious_lag");
        r5.put("block_looper_info", r18.u);
        r5.put("block_cpu_info", r18.v);
        r5.put("block_memory_info", r18.w);
        r5.put(MonitorConstants.CUSTOM, r18.x);
        r5.put("block_error_info", r20);
        com.bytedance.apm.d.b.d r6 = new com.bytedance.apm.d.b.d("serious_block_monitor", r5, r18.g);
        a(r6);
        com.bytedance.apm.d.a.a.c().a(r6);
        com.bytedance.apm.g.c r13 = this.x;
        if (r13 == null) goto L54;
        r13.b(r18.f4356b, r18.h - r18.g, r18.t, r18.r);
        return;
    }

    private void a(final boolean r3, final d r4) {
        com.bytedance.apm.thread.b.a().a(new AnonymousClass4(this, r4, r3));
    }

    private void a(d r4, String r5) {
        if (PerfConfig.a() == false) goto L6;
        JSONObject r3 = c(r4);
        JSONObject r0 = com.bytedance.apm6.perf.base.c.a().a(true);
        r0.put("crash_section", com.bytedance.apm.c.h(r4.i));
        r0.put("belong_frame", String.valueOf(r4.f4358d));
        r0.put("belong_dump", String.valueOf(r4.f4357c));
        r0.put("block_stack_type", "messageKey");
        r3.put("filters", r0);
        r3.put("event_type", "lag");
        r3.put("stack", "at " + r5 + ".*(a.java:-1)");
        com.bytedance.apm.d.b.d r6 = new com.bytedance.apm.d.b.d("block_monitor", r3);
        r6.e();
        com.bytedance.apm.d.a.a.c().a(r6);
        return;
    }

    private JSONObject b(boolean r3, d r4, String r5) {
        JSONObject r2 = com.bytedance.apm6.perf.base.c.a().a(true);
        r2.put("crash_section", com.bytedance.apm.c.h(r4.i));
        r2.put("belong_frame", String.valueOf(r3));
        r2.put("belong_dump", String.valueOf(r4.f4357c));
        r2.put("block_input", String.valueOf(r4.f4359e));
        r2.put("block_frame", String.valueOf(r4.f));
        r2.put("block_message", r5);
        r2.put("block_stack_type", "stack");
        r2.put("buuid", r4.s);
        r2.put("belong_poll_once", String.valueOf(r4.k));
        Map<String, String> r6 = c.a();
        if (r6 != null) goto L5;
    L10:
        return r2;
    L5:
        if (r6.isEmpty() == true) goto L10;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r2.put((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), r8.getValue());
        goto L8
    }

    private JSONObject e() {
        JSONObject r0 = new JSONObject();
        Map<String, String> r1 = c.a();     // Catch: JSONException -> L13
        if (r1 == null) goto L12;
        if (r1.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();     // Catch: JSONException -> L13
    L9:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L13
        r0.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), r3.getValue());     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    private JSONObject c(d r6) {
        long r0 = r6.h - r6.g;
        JSONObject r5 = new JSONObject();
        r5.put(DBHelper.COL_TIME, r6.i);     // Catch: JSONException -> L5
        r5.put("crash_time", r6.i);     // Catch: JSONException -> L5
        r5.put("is_main_process", com.bytedance.apm.c.d());     // Catch: JSONException -> L5
        r5.put("process_name", com.bytedance.apm.c.c());     // Catch: JSONException -> L5
        r5.put("block_duration", r0);     // Catch: JSONException -> L5
        r5.put("last_scene", r6.t);     // Catch: JSONException -> L5
    L7:
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void d(d r2) {
        String r1 = FpsTracer.d();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r2.t = ActivityLifeObserver.getInstance().getTopActivityClassName();
        return;
    L5:
        r2.t = r1 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    static boolean a(StackTraceElement r4, StackTraceElement r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.getClassName().equals(r5.getClassName()) == false) goto L17;
        if (a(r4.getMethodName(), r5.getMethodName()) == false) goto L17;
        if (a(r4.getFileName(), r5.getFileName()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }
}
