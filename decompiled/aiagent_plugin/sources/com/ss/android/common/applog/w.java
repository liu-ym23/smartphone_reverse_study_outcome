package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogReaper.java */
/* JADX INFO: loaded from: classes4.dex */
class w extends Thread {
    private static final String TAG = "AppLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f37241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<t> f37242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f37243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f37244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f37245e;
    private final List<a.j> f;
    private long g;
    private long h;
    private x i;
    private volatile long j;
    private long k;
    private AtomicLong l;
    private volatile long m;
    private int n;
    private volatile JSONObject o;
    private volatile long p;
    private final ConcurrentHashMap<String, String> q;
    private final ConcurrentHashMap<String, String> r;
    private final f s;

    static /* synthetic */ JSONObject a(w r0) {
        return r0.f37244d;
    }

    w(Context r5, JSONObject r6, LinkedList<t> r7, AtomicBoolean r8, List<a.j> r9, x r10, ConcurrentHashMap r11, ConcurrentHashMap r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List<a.j> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        super("LogReaper");
        this.f37241a = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.g = 0;
        this.h = 0;
        this.k = 0;
        this.l = new AtomicLong();
        this.m = 60000;
        this.n = 1;
        this.o = null;
        this.p = 120000;
        Context r15 = ZeusTransformUtils.wrapperContext(r13, "com.obric.aiagent.plugin");
        this.f37243c = r15;
        this.f37244d = r6;
        this.f37242b = r7;
        this.f37245e = r8;
        this.f = r14;
        a(r10);
        this.q = r11;
        this.r = r12;
        this.s = new f(r15);
        String[] r16 = a.e();
        int r17 = r16.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L6;
        String r19 = r16[r18];
        this.s.a(r19);
        r18 = r18 + 1;
        goto L3
    L6:
        if (com.bytedance.applog.log.l.a() == true) goto L10;
        com.bytedance.applog.log.l.a("set_header", new AnonymousClass1(this));
        return;
    }

    void a(long r1) {
        this.m = r1;
        this.l.set(r1);
    }

    void a(int r1) {
        this.n = r1;
    }

    void a(final JSONObject r2) {
        this.o = r2;
        if (com.bytedance.applog.log.l.a() == true) goto L6;
        com.bytedance.applog.log.l.a("server_time_sync", new AnonymousClass2(this, r2));
        return;
    }

    synchronized void b(JSONObject r7) {
        monitor-enter(this);
        String[] r0 = d.f37164b;     // Catch: Throwable -> L10 Exception -> L12
        int r1 = r0.length;     // Catch: Throwable -> L10 Exception -> L12
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        String r3 = r0[r2];     // Catch: Throwable -> L10 Exception -> L12
        this.f37244d.put(r3, r7.opt(r3));     // Catch: Throwable -> L10 Exception -> L12
        r2 = r2 + 1;     // Catch: Throwable -> L10 Exception -> L12
        goto L4
    L7:
        if (com.bytedance.applog.log.l.a() == true) goto L14;
        com.bytedance.applog.log.l.a("set_header", new AnonymousClass3(this));     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        com.ss.android.common.util.e.e("AppLog updateHeader exception: ", e);     // Catch: Throwable -> L10
        goto L14
    }

    synchronized void a() {
        monitor-enter(this);
        com.ss.android.deviceregister.base.v.a(this.f37244d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void a(t r10) {
        monitor-enter(this);
        if (r10 != null) goto L35;
        monitor-exit(this);
        return;
    L35:
    L32:
        th = move-exception;
        throw th;
    L7:
        if (a.J() == false) goto L13;
        if (a.K() == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r10, v.class) == false) goto L19;
        v r11 = (v) ZeusTransformUtils.preCheckCast(r10, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r11.f37240e == false) goto L17;
        a(r11.f37236a, null, true, r11.f37239d, false, true);     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);
        return;
    L17:
        a(r11.f37236a, r11.f37237b, r11.f37238c, r11.f37239d);     // Catch: Throwable -> L32
        a(r11.f37237b);     // Catch: Throwable -> L32
        this.k = System.currentTimeMillis();     // Catch: Throwable -> L32
        goto L30
    L19:
        if (ZeusTransformUtils.instanceOf(r10, s.class) == false) goto L22;
        b(((s) ZeusTransformUtils.preCheckCast(r10, s.class, "com.obric.aiagent.plugin")).f37210a);     // Catch: Throwable -> L32
        goto L30
    L22:
        if (ZeusTransformUtils.instanceOf(r10, u.class) == false) goto L30;
        com.ss.android.common.applog.task.d r12 = ((u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.aiagent.plugin")).f37235a;     // Catch: Throwable -> L32
        if (r12 == null) goto L30;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L32
        com.ss.android.deviceregister.base.v.a(this.f37244d, r0);     // Catch: Throwable -> L32
        Pair<Long, String> r13 = ab.a(this.f37243c).a(r12, r0);     // Catch: Throwable -> L32
        if (r13 == null) goto L30;
        long r1 = ((Long) ZeusTransformUtils.preCheckCast(r13.first, Long.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L32
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.second, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r1 <= 0) goto L30;
        a(r14, r1);     // Catch: Throwable -> L32
        goto L30
    }

    private void a(String r5, long r6) {
        DBHelper r0 = DBHelper.a(this.f37243c);
        if (com.bytedance.common.utility.i.b(this.f37243c) == false) goto L22;
        boolean r1 = false;
        com.ss.android.common.util.e.b("AppLog begin to send  logs");     // Catch: Throwable -> L12
        int r4 = a(a.e(), r5, true);     // Catch: Throwable -> L12
        if (r4 != (-1)) goto L10;
        return;
    L10:
        if (r4 != 200) goto L14;
        r1 = true;
    L14:
        JSONObject r7 = null;
        r7 = new JSONObject(r5);     // Catch: Throwable -> L17
    L18:
        a(r7, r1);
        com.ss.android.common.util.a.a(r7, r1);
        boolean r8 = r0.a(r6, r1);
        if (r1 == true) goto L28;
        if (r8 == false) goto L29;
        DBHelper.a(r7);
        return;
    L29:
        return;
    L28:
        return;
    L17:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);
    L12:
        th = move-exception;
        com.ss.android.common.util.e.e("AppLog send session exception: ", th);
        goto L14
    L22:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);
    }

    private void b(long r8) {
        if (r8 > 0) goto L5;
        return;
    L5:
        com.ss.android.common.util.e.b("AppLog try to batch session  id < " + r8);
        x r9 = DBHelper.a(this.f37243c).c(r8);
        if (r9 == null) goto L15;
        a(r9, null, false, 0);
        s r10 = new s();
        r10.f37210a = r9.f37250a;
        LinkedList<t> r11 = this.f37242b;
        monitor-enter(r11);
        this.f37242b.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void a(x r9, x r10, boolean r11, long r12) {
        a(r9, r10, r11, r12, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.ss.android.common.applog.DBHelper] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    private void a(x r23, x r24, boolean r25, long r26, boolean r28, boolean r29) {
        if (a.J() == true) goto L5;
    L7:
        long r2 = a.b();
        if (r2 == (-1)) goto L22;
        com.ss.android.deviceregister.a.e.a(this.f37243c, r2);
        if (b() == true) goto L22;
        String r3 = com.ss.android.deviceregister.g.i();
        if (y.a(r3) == true) goto L22;
        monitor-enter(this);
        this.f37244d.put("device_id", r3);     // Catch: Throwable -> L16 Exception -> L147
    L16:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
    L22:
        ?? r15 = DBHelper.a(this.f37243c);
        if (r23 != null) goto L27;
        if (r24 != null) goto L27;
        return;
    L27:
        if (r23 == null) goto L106;
        long[] r9 = new long[1];
        if (r25 == false) goto L31;
        r9[0] = r26;
    L32:
        List<a.j> r8 = this.f;
        String[] r7 = new String[1];
        JSONObject r5 = new JSONObject();
        monitor-enter(this);
        com.ss.android.deviceregister.base.v.a(this.f37244d, r5);     // Catch: Throwable -> L102
        monitor-exit(this);     // Catch: Throwable -> L102
        com.service.middleware.applog.a r4 = a.C();
        if (r4 == null) goto L39;
        r4.a(r5);
    L39:
        long r6 = r15.a(r23, r24, r5, r25, r9, r7, r8, r28, this.o, r29);
        if (r6 > 0) goto L42;
        return;
    L42:
        if (r15.a(r6) == false) goto L165;
        String r10 = r7[0];
        if (r9[0] <= r26) goto L55;
        if (r28 == true) goto L47;
        if (r29 == false) goto L55;
    L47:
        v r11 = new v();
        r11.f37236a = r23;
        x r12 = r24;
        int r13 = 0;
        r11.f37237b = r12;
        ?? r14 = 1;
        r11.f37238c = true;
        r11.f37239d = r9[0];
        r11.f37240e = r29;
        LinkedList<t> r16 = this.f37242b;
        monitor-enter(r16);
        this.f37242b.add(r11);     // Catch: Throwable -> L52
        monitor-exit(r16);     // Catch: Throwable -> L52
    L57:
        if (a.I() == false) goto L64;
        q r17 = new q();
        r17.f37202a = r6;
        r17.f37203b = r10;
        r17.f = r13;
        boolean r18 = a(r17);
        String r19 = r17.f37203b;
        if (r18 == true) goto L62;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.E);
        return;
    L62:
        r10 = r19;
    L64:
        if (com.bytedance.common.utility.i.b(this.f37243c) == true) goto L157;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);
        return;
    L157:
        com.ss.android.common.util.e.b("begin to send batch logs: " + r6);     // Catch: Throwable -> L86
        int r20 = a(a.e(), r10, r14);     // Catch: Throwable -> L86
        if (r20 != (-1)) goto L70;
        return;
    L70:
        if (r20 != 200) goto L72;
        ?? r110 = r14;
    L73:
        if (r110 != 0) goto L152;
    L89:
        JSONObject r0 = null;
        r0 = new JSONObject(r10);     // Catch: Throwable -> L92
    L93:
        a(r0, r110);
        com.ss.android.common.util.a.a(r0, r110);
        boolean r21 = r15.a(r6, r110);
        if (r110 != 0) goto L97;
        if (r21 == false) goto L97;
        Object[] r22 = new Object[r14];
        r22[r13] = c(r0);
        LogTrace.a(3, r13, r22);
        Object[] r27 = new Object[r14];
        r27[r13] = d(r0);
        LogTrace.a(4, r13, r27);
        DBHelper.a(r0);
    L97:
        if (r110 == 0) goto L99;
        return;
    L99:
        if (this.g >= 0) goto L167;
        this.g = r6;
        return;
    L167:
        return;
    L92:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);
        goto L93
    L152:
    L84:
        th = th;
    L88:
        com.ss.android.common.util.e.e("send session exception: ", th);
        goto L89
    L75:
        if (b() == false) goto L89;
        if (r12 == null) goto L79;
        r12.j = r14;     // Catch: Throwable -> L84
        r15.d(r12.f37250a);     // Catch: Throwable -> L84
    L79:
        if (r15.i.contains(Long.valueOf(r23.f37250a)) == false) goto L89;
        if (r15.j.contains(Long.valueOf(r23.f37250a)) == true) goto L89;
        r15.j.add(Long.valueOf(r23.f37250a));     // Catch: Throwable -> L84
        goto L89
    L72:
        r110 = r13;
    L86:
        th = th;
        r110 = r13;
    L52:
        th = move-exception;
        throw th;
    L55:
        r12 = r24;
        r13 = 0;
        r14 = 1;
        goto L57
    L165:
        return;
    L102:
        th = move-exception;
        throw th;
    L31:
        r9[0] = 0;
        goto L32
    L106:
        if (r24 == null) goto L144;
        if (com.bytedance.common.utility.i.b(this.f37243c) == false) goto L144;
        if (this.n <= 0) goto L144;
        if (r24.i == true) goto L144;
    L141:
        th = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5823J);
        com.ss.android.common.util.e.e("AppLog send launch exception: ", th);
        return;
    L114:
        if (b() == true) goto L116;
        return;
    L116:
        ?? r1 = new JSONObject();     // Catch: Throwable -> L141
        r1.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L141
        JSONObject r30 = new JSONObject();     // Catch: Throwable -> L141
        monitor-enter(this);     // Catch: Throwable -> L141
        com.ss.android.deviceregister.base.v.a(this.f37244d, r30);     // Catch: Throwable -> L138
        monitor-exit(this);     // Catch: Throwable -> L138
        d.a(this.f37243c, r30);     // Catch: Throwable -> L141
        com.service.middleware.applog.a r31 = a.C();     // Catch: Throwable -> L141
        if (r31 == null) goto L123;
        r31.a(r30);     // Catch: Throwable -> L141
    L123:
        r1.put("header", r30);     // Catch: Throwable -> L141
        JSONArray r32 = new JSONArray();     // Catch: Throwable -> L141
        JSONObject r33 = new JSONObject();     // Catch: Throwable -> L141
        r33.put("datetime", a.a(r24.f37252c));     // Catch: Throwable -> L141
        r33.put("session_id", r24.f37251b);     // Catch: Throwable -> L141
        r33.put("local_time_ms", r24.f37252c);     // Catch: Throwable -> L141
        r33.put("tea_event_index", r24.f37253d);     // Catch: Throwable -> L141
        r33.put("event_id", a.h.incrementAndGet());     // Catch: Throwable -> L141
        if (r24.i == false) goto L126;
        r33.put("is_background", true);     // Catch: Throwable -> L141
    L127:
        String r34 = a.B();     // Catch: Throwable -> L141
        com.ss.android.common.util.e.c("send first launch, uid: " + a.l() + ", abSdkVersion: " + r34);     // Catch: Throwable -> L141
        if (TextUtils.isEmpty(r34) == true) goto L130;
        r33.put("ab_sdk_version", r34);     // Catch: Throwable -> L141
    L130:
        r32.put(r33);     // Catch: Throwable -> L141
        com.ss.android.common.util.a.b(r33);     // Catch: Throwable -> L141
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5825b);     // Catch: Throwable -> L141
        r1.put("launch", r32);     // Catch: Throwable -> L141
        a.b(r1, true);     // Catch: Throwable -> L141
        if (200 != a(a.e(), r1.toString(), true)) goto L133;
        r24.j = true;     // Catch: Throwable -> L141
        r15.d(r24.f37250a);     // Catch: Throwable -> L141
        r15.j.add(Long.valueOf(r24.f37250a));     // Catch: Throwable -> L141
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.h);     // Catch: Throwable -> L141
        com.ss.android.common.util.a.a(r1, true);     // Catch: Throwable -> L141
    L134:
        r15.i.add(Long.valueOf(r24.f37250a));     // Catch: Throwable -> L141
        if (g.a().b() == false) goto L170;
        g.a().a("launch", r32);     // Catch: Throwable -> L141
        return;
    L170:
        return;
    L133:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.i);     // Catch: Throwable -> L141
        com.ss.android.common.util.a.a(r1, false);     // Catch: Throwable -> L141
        goto L134
    L126:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5826c);     // Catch: Throwable -> L141
        goto L127
    L138:
        th = move-exception;
        throw th;     // Catch: Throwable -> L141
    L144:
        if (com.bytedance.common.utility.i.b(this.f37243c) == true) goto L172;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);
        return;
    L172:
        return;
    L5:
        if (a.K() == true) goto L7;
    }

    private boolean b() {
        return !com.bytedance.common.utility.j.a(this.f37244d.optString("device_id", ""));
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.common.applog.f] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int a(int r31, String[] r32, String r33, boolean r34) {
        String r0 = "time_sync";
        String r9 = r32[r31];
    L231:
        th = th;
        ?? r5 = r32;
        w this = this;
        ?? r1 = r31;
    L233:
        com.ss.android.common.util.e.e("Send log failed", th);
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.w);
        if (a.p() == false) goto L238;
        ?? r2 = this.s;
        if (r2 == 0) goto L238;
        r2.a(r1, r5, th);
    L238:
        throw th;
    L4:
        if (a.p() == false) goto L14;
        f r10 = this.s;     // Catch: Throwable -> L231
        if (r10 == null) goto L14;
        if (r10.b(r9) == true) goto L14;
        if (a.t == null) goto L12;
        a.t.a("service_monitor", "applog_send_tuibi", 0, null, null);     // Catch: Throwable -> L231
    L12:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.C);     // Catch: Throwable -> L231
        return -1;
    L14:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.v);     // Catch: Throwable -> L231
        HashMap r11 = new HashMap();     // Catch: Throwable -> L231
        if (a.f == true) goto L251;
    L106:
        this = this;
        String r18 = "server_time";
        String r17 = "blocklist";
        r9 = r9;
    L107:
        String r3 = r33;
    L108:
        aa r4 = a.E;     // Catch: Throwable -> L229
        if (r4 == null) goto L115;
        JSONObject r6 = new JSONObject(r3);     // Catch: Throwable -> L229
        boolean r7 = r4.a(r6);     // Catch: Throwable -> L229
        com.ss.android.common.util.e.b("AppLog sendLogCallback.onBeforeSendLog allowToSend: " + r7);     // Catch: Throwable -> L229
        if (r7 == true) goto L114;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.C);     // Catch: Throwable -> L229
        return 200;
    L114:
        r3 = r6.toString();     // Catch: Throwable -> L229
    L115:
        String r8 = r3;
        if (Logger.debug() == false) goto L118;
        com.ss.android.common.util.e.b("AppLog app_log: " + r8);     // Catch: Throwable -> L229
    L118:
        boolean r12 = true;
        r5 = z.a(y.a(r9, true), z.f37260c);     // Catch: Throwable -> L229
        byte[] r13 = r8.getBytes("UTF-8");     // Catch: Throwable -> L229
        byte[] r22 = (byte[]) ZeusTransformUtils.preCheckCast(r13.clone(), byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L229
        Map<String, String> r14 = a.G();     // Catch: Throwable -> L229
        if (com.bytedance.common.utility.j.a(r5) == true) goto L139;
        if (r34 == false) goto L139;
        if (this.f37243c == null) goto L139;
        if (a.n() == false) goto L139;
        JSONObject r15 = new JSONObject(r8);     // Catch: Throwable -> L131
        String[] r16 = {r15.optString("key"), r15.optString("iv")};     // Catch: Throwable -> L131
        if (com.ss.android.deviceregister.a.a.a.c.a(r16) == true) goto L249;
        r16 = null;
    L249:
        String r19 = y.a(a.N(), r5, r22, this.f37243c, false, r16, r14, r8, false, true);     // Catch: RuntimeException -> L137 Throwable -> L229
        r1 = r8;
    L245:
        if (r19 != null) goto L142;
    L225:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L227
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.w);     // Catch: Throwable -> L227
        com.ss.android.common.util.e.e("app_log response empty");     // Catch: Throwable -> L227
        return 0;
    L142:
        if (r19.length() == 0) goto L225;
        if (Logger.debug() == false) goto L147;
        com.ss.android.common.util.e.b("app_log response: " + r19);     // Catch: Throwable -> L229
    L147:
        JSONObject r20 = new JSONObject(r19);     // Catch: Throwable -> L229
        if ("ss_app_log".equals(r20.optString("magic_tag")) == true) goto L150;
    L152:
        r12 = false;
    L154:
        if (r12 == true) goto L156;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.w);     // Catch: Throwable -> L229
        com.ss.android.common.util.e.e("app_log response is failed: " + r19);     // Catch: Throwable -> L229
    L166:
        if (a.H() == false) goto L168;
        a.m = r20.optLong("uid");     // Catch: Throwable -> L229
        a.n = r20.optInt("user_type");     // Catch: Throwable -> L229
        a.o = r20.optInt("user_is_login");     // Catch: Throwable -> L229
        a.p = r20.optInt("user_is_auth");     // Catch: Throwable -> L229
    L168:
        long r21 = r20.optLong("batch_event_interval", 0) * 1000;     // Catch: Throwable -> L229
        if (a.c(r21) == false) goto L172;
        this.l.set(r21);     // Catch: Throwable -> L229
    L174:
        f r23 = this.s;     // Catch: Throwable -> L229
        if (r23 == null) goto L253;
        r23.a(r20);     // Catch: Throwable -> L229
    L253:
    L214:
        th = move-exception;
        com.ss.android.common.util.e.e("Parse log res failed", th);     // Catch: Throwable -> L229
    L217:
        if (a.p() == false) goto L222;
        f r24 = this.s;     // Catch: Throwable -> L229
        if (r24 == null) goto L222;
        r24.a(r31, r32);     // Catch: Throwable -> L227
    L222:
        if (r12 == true) goto L224;
        return 0;
    L224:
        return 200;
    L178:
        if (a.p() == false) goto L209;
        String r25 = r17;
        if (r20.optJSONObject(r25) == null) goto L202;
        com.ss.android.common.util.e.b("AppLog block list keys: " + r20.optJSONObject(r25));     // Catch: Throwable -> L214
        JSONArray r26 = r20.optJSONObject(r25).optJSONArray("v1");     // Catch: Throwable -> L214
        if (r26 != null) goto L185;
    L192:
        JSONArray r27 = r20.optJSONObject(r25).optJSONArray("v3");     // Catch: Throwable -> L214
        if (r27 == null) goto L209;
        if (r27.length() <= 0) goto L209;
        int r28 = r27.length();     // Catch: Throwable -> L214
        int r29 = 0;
    L197:
        if (r29 >= r28) goto L209;
        String r30 = r27.getString(r29);     // Catch: Throwable -> L214
        if (com.bytedance.common.utility.j.a(r30) == true) goto L201;
        this.r.put(r30, "block");     // Catch: Throwable -> L214
    L201:
        r29 = r29 + 1;     // Catch: Throwable -> L214
        goto L197
    L185:
        if (r26.length() <= 0) goto L192;
        int r35 = r26.length();     // Catch: Throwable -> L214
        int r36 = 0;
    L187:
        if (r36 >= r35) goto L192;
        String r110 = r26.getString(r36);     // Catch: Throwable -> L214
        if (com.bytedance.common.utility.j.a(r110) == true) goto L191;
        this.q.put(r110, "block");     // Catch: Throwable -> L214
    L191:
        r36 = r36 + 1;     // Catch: Throwable -> L214
        goto L187
    L202:
        com.ss.android.common.util.e.b("AppLog block list is empty");     // Catch: Throwable -> L214
        if (this.q.isEmpty() == true) goto L206;
        this.q.clear();     // Catch: Throwable -> L214
    L206:
        if (this.r.isEmpty() == true) goto L209;
        this.r.clear();     // Catch: Throwable -> L214
    L209:
        if (a.F() <= 0) goto L217;
        JSONObject r37 = r20.optJSONObject("sampling_list");     // Catch: Throwable -> L214
        if (r37 == null) goto L217;
        a.f37113c = com.bytedance.applog.sampling.d.a(this.f37243c, null, r37, a.f37113c);     // Catch: Throwable -> L214
    L172:
        if (this.m == this.l.get()) goto L174;
        this.l.set(this.m);     // Catch: Throwable -> L229
        goto L174
    L156:
        if (Logger.debug() == false) goto L158;
        com.ss.android.common.util.e.b("app_log upload success");     // Catch: Throwable -> L229
    L158:
        String r38 = r18;
        long r39 = r20.optLong(r38);     // Catch: Exception -> L163 Throwable -> L229
        if (r39 <= 0) goto L166;
        JSONObject r40 = new JSONObject();     // Catch: Exception -> L163 Throwable -> L229
        r40.put(r38, r39);     // Catch: Exception -> L163 Throwable -> L229
        r40.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L163 Throwable -> L229
        this.a(r40);     // Catch: Exception -> L163 Throwable -> L229
    L163:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Throwable -> L229
        goto L166
    L150:
        if ("success".equals(r20.optString("message")) == false) goto L152;
    L227:
        th = th;
        goto L233
    L137:
        e = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L229
        com.ss.android.common.util.e.e("Send encrypt log failed", e);     // Catch: Throwable -> L229
        r19 = y.a(a.N(), r5, r13, true, "application/octet-stream;tt-data=b", false, r14, false, true);     // Catch: Throwable -> L229
        r1 = "Send encrypt log failed";
    L229:
        th = th;
    L230:
        r1 = r31;
        r5 = r32;
    L129:
        th = th;
    L133:
        com.ss.android.common.util.e.e("key iv failed", th);     // Catch: Throwable -> L229
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Throwable -> L229
    L131:
        th = th;
        r16 = null;
    L139:
        r19 = y.a(a.N(), r5, r13, true, "application/octet-stream;tt-data=b", false, r14, false, true);     // Catch: Throwable -> L229
        r1 = r8;
        goto L245
    L251:
    L104:
        th = th;
        this = this;
        goto L230
    L18:
        if (a.g == null) goto L106;
        JSONObject r111 = new JSONObject(r33);     // Catch: Throwable -> L104
        JSONObject r41 = r111.optJSONObject("header");     // Catch: Throwable -> L104
        JSONObject r42 = r111.optJSONObject("time_sync");     // Catch: Throwable -> L104
        JSONArray r112 = r111.optJSONArray("event");     // Catch: Throwable -> L104
        r17 = "blocklist";
        r18 = "server_time";
        String r43 = "user_id";
        if (r112 != null) goto L241;
    L53:
        JSONObject r210 = r42;
        JSONObject r44 = r111;
        JSONObject r113 = r41;
        long r211 = 0;
    L54:
        JSONArray r45 = r44.optJSONArray("event_v3");     // Catch: Throwable -> L51
        if (r45 == null) goto L86;
        if (r45.length() <= 0) goto L86;
        JSONArray r46 = new JSONArray();     // Catch: Throwable -> L51
        int r47 = 0;
    L60:
        if (r47 >= r45.length()) goto L84;
        JSONObject r48 = r45.getJSONObject(r47);     // Catch: Throwable -> L51
        JSONObject r212 = r113;
        long r213 = r48.optLong(r43, 0);     // Catch: Throwable -> L51
        if (r213 > 0) goto L64;
    L66:
        if (r213 > 0) goto L68;
    L82:
        JSONObject r49 = r212;
        JSONObject r114 = r210;
        r46.put(r48);     // Catch: Throwable -> L51
    L83:
        r47 = r47 + 1;     // Catch: Throwable -> L51
        r210 = r114;
        r43 = r43;
        r45 = r45;
        r113 = r49;
        r0 = r0;
        goto L60
    L68:
        if (r213 == r211) goto L82;
        if (r11.containsKey(Long.valueOf(r213)) == false) goto L78;
        JSONObject r115 = (JSONObject) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r213)), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r115 == null) goto L77;
        JSONArray r116 = r115.optJSONArray("event_v3");     // Catch: Throwable -> L51
        if (r116 != null) goto L76;
        r116 = new JSONArray();     // Catch: Throwable -> L51
    L76:
        r116.put(r48);     // Catch: Throwable -> L51
        r115.put("event_v3", r116);     // Catch: Throwable -> L51
    L77:
        r11.put(Long.valueOf(r213), r115);     // Catch: Throwable -> L51
        r49 = r212;
        r114 = r210;
        goto L83
    L78:
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L51
        r117.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L51
        r114 = r210;
        if (r210 == null) goto L81;
        r117.put(r0, r114);     // Catch: Throwable -> L51
    L81:
        r49 = r212;
        r117.put("header", r49);     // Catch: Throwable -> L51
        r117.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L51
        JSONArray r50 = new JSONArray();     // Catch: Throwable -> L51
        r50.put(r48);     // Catch: Throwable -> L51
        r117.put("event_v3", r50);     // Catch: Throwable -> L51
        r11.put(Long.valueOf(r213), r117);     // Catch: Throwable -> L51
        goto L83
    L64:
        if (r211 > 0) goto L66;
        r211 = r213;
        goto L66
    L84:
        r44.put("event_v3", r46);     // Catch: Throwable -> L51
    L86:
        if (r211 > 0) goto L88;
        this = this;
        goto L107
    L88:
        if (r11.isEmpty() == true) goto L98;
        Iterator r51 = r11.keySet().iterator();     // Catch: Throwable -> L51
    L90:
        if (r51.hasNext() == false) goto L97;
        JSONObject r52 = (JSONObject) ZeusTransformUtils.preCheckCast(r11.get((Long) ZeusTransformUtils.preCheckCast(r51.next(), Long.class, "com.obric.aiagent.plugin")), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r52 == null) goto L90;
        this = this;
        DBHelper.a(this.f37243c).a(r52.toString());     // Catch: Throwable -> L229
        goto L90
    L97:
        r3 = r44.toString();     // Catch: Throwable -> L229
    L100:
        if (a.g.a(String.valueOf(r211)) == true) goto L108;
        return -1;
    L51:
        th = th;
        this = this;
        goto L230
    L98:
        r3 = r33;
        goto L100
    L241:
        if (r112.length() <= 0) goto L53;
        JSONArray r53 = new JSONArray();     // Catch: Throwable -> L51
        int r54 = 0;
        r211 = 0;
    L26:
        if (r54 >= r112.length()) goto L50;
        JSONObject r55 = r112.getJSONObject(r54);     // Catch: Throwable -> L51
        JSONArray r214 = r112;
        JSONObject r215 = r111;
        long r216 = r55.optLong("user_id", 0);     // Catch: Throwable -> L51
        if (r216 > 0) goto L30;
    L32:
        if (r216 > 0) goto L34;
    L48:
        r53.put(r55);     // Catch: Throwable -> L51
    L49:
        r54 = r54 + 1;     // Catch: Throwable -> L51
        r41 = r41;
        r111 = r215;
        r112 = r214;
        r42 = r42;
        goto L26
    L34:
        if (r216 == r211) goto L48;
        if (r11.containsKey(Long.valueOf(r216)) == false) goto L44;
        JSONObject r118 = (JSONObject) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r216)), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r118 == null) goto L43;
        JSONArray r119 = r118.optJSONArray("event");     // Catch: Throwable -> L51
        if (r119 != null) goto L42;
        r119 = new JSONArray();     // Catch: Throwable -> L51
    L42:
        r119.put(r55);     // Catch: Throwable -> L51
        r118.put("event", r119);     // Catch: Throwable -> L51
    L43:
        r11.put(Long.valueOf(r216), r118);     // Catch: Throwable -> L51
        goto L49
    L44:
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L51
        r120.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L51
        if (r42 == null) goto L47;
        r120.put("time_sync", r42);     // Catch: Throwable -> L51
    L47:
        r120.put("header", r41);     // Catch: Throwable -> L51
        r120.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L51
        JSONArray r56 = new JSONArray();     // Catch: Throwable -> L51
        r56.put(r55);     // Catch: Throwable -> L51
        r120.put("event", r56);     // Catch: Throwable -> L51
        r11.put(Long.valueOf(r216), r120);     // Catch: Throwable -> L51
        goto L49
    L30:
        if (r211 > 0) goto L32;
        r211 = r216;
        goto L32
    L50:
        r210 = r42;
        JSONObject r217 = r111;
        r113 = r41;
        r44 = r217;
        r44.put("event", r53);     // Catch: Throwable -> L51
        goto L54
    }

    static List<Long> c(JSONObject r10) {
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L18;
    L16:
        return r0;
    L18:
        JSONArray r1 = r10.optJSONArray("event_v3");     // Catch: Throwable -> L17
        int r5 = 0;
        if (r1 == null) goto L10;
        int r6 = r1.length();     // Catch: Throwable -> L17
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        r0.add(Long.valueOf(r1.getJSONObject(r7).optLong("tea_event_index", 0)));     // Catch: Throwable -> L17
        r7 = r7 + 1;     // Catch: Throwable -> L17
    L10:
        JSONArray r11 = r10.optJSONArray("event");     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        int r2 = r11.length();     // Catch: Throwable -> L17
    L13:
        if (r5 >= r2) goto L16;
        r0.add(Long.valueOf(r11.getJSONObject(r5).optLong("tea_event_index", 0)));     // Catch: Throwable -> L17
        r5 = r5 + 1;
        goto L13
    }

    static List<String> d(JSONObject r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L15;
    L14:
        return r0;
    L15:
        JSONArray r7 = r6.optJSONArray("terminate");     // Catch: Throwable -> L12
        if (r7 == null) goto L14;
        int r1 = r7.length();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        String r3 = r7.getJSONObject(r2).optString("session_id", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L12
    L11:
        r2 = r2 + 1;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    private void c() {
        DBHelper.a(this.f37243c).a();
    }

    private boolean d() {
        if (a.J() == false) goto L8;
        if (a.K() == true) goto L8;
        return false;
    L8:
        if (com.bytedance.common.utility.i.b(this.f37243c) == true) goto L11;
        return false;
    L11:
        if (this.g >= 0) goto L16;
        if ((System.currentTimeMillis() - this.h) <= this.p) goto L16;
        this.g = 0;
        c();
        this.h = System.currentTimeMillis();
    L16:
        if (this.g >= 0) goto L18;
        return false;
    L18:
        DBHelper r0 = DBHelper.a(this.f37243c);
        q r2 = r0.b(this.g);
        if (r2 != null) goto L23;
        this.g = -1;
        return false;
    L23:
        if (this.g >= r2.f37202a) goto L25;
        this.g = r2.f37202a;
    L27:
        if (r2.f37203b != null) goto L29;
    L83:
        return true;
    L29:
        if (r2.f37203b.length() == 0) goto L83;
        if (a.I() == false) goto L38;
        if (a(r2) == true) goto L38;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.E);
        return true;
    L38:
        if (a.b() != (-1)) goto L91;
    L85:
    L68:
        th = move-exception;
        com.ss.android.common.util.e.e("AppLog send session exception: ", th);
        int r9 = 0;
        boolean r3 = false;
    L71:
        if (r9 != (-1)) goto L73;
        return true;
    L73:
        JSONObject r4 = null;
        r4 = new JSONObject(r2.f37203b);     // Catch: Throwable -> L76
    L77:
        a(r4, r3);
        com.ss.android.common.util.a.a(r4, r3);
        boolean r10 = r0.a(r2.f37202a, r3);
        if (r3 == true) goto L83;
        if (r10 == false) goto L83;
        if (r2.f != 0) goto L83;
        LogTrace.a(3, 0, new Object[]{c(r4)});
        LogTrace.a(4, 0, new Object[]{d(r4)});
        DBHelper.a(r4);
    L76:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);
        goto L77
    L61:
        if (r2.f != 0) goto L64;
        r9 = a(a.e(), r2.f37203b, true);     // Catch: Throwable -> L68
    L65:
        if (r9 != 200) goto L67;
        r3 = true;
        goto L71
    L67:
        r3 = false;
        goto L71
    L64:
        r9 = 200;
        goto L65
    L91:
        JSONObject r5 = new JSONObject(r2.f37203b);     // Catch: Throwable -> L84
        JSONObject r6 = r5.optJSONObject("header");     // Catch: Throwable -> L84
        String r7 = this.f37244d.optString("device_id");     // Catch: Throwable -> L84
        if (r6 != null) goto L54;
        if (y.a(r7) == true) goto L52;
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L84
        monitor-enter(this);     // Catch: Throwable -> L84
        com.ss.android.deviceregister.base.v.a(this.f37244d, r8);     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        r5.put("header", r8);     // Catch: Throwable -> L84
        r2.f37203b = r5.toString();     // Catch: Throwable -> L84
        goto L85
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L84
    L52:
        return false;
    L54:
        if (y.a(r6.optString("device_id")) == false) goto L85;
        if (y.a(r7) == true) goto L59;
        r6.put("device_id", r7);     // Catch: Throwable -> L84
        r5.put("header", r6);     // Catch: Throwable -> L84
        r2.f37203b = r5.toString();     // Catch: Throwable -> L84
        goto L85
    L59:
        return false;
    L25:
        this.g++;
        goto L27
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.ss.android.common.util.e.b("AppLog LogReaper start");
        c();
        this.h = System.currentTimeMillis();
        this.k = System.currentTimeMillis();
        int r11 = 0;
    L3:
        t r1 = null;
    L4:
        if (r1 != null) goto L19;
        LinkedList<t> r2 = this.f37242b;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.f37245e.get() == true) goto L9;
        if (this.f37242b.isEmpty() == true) goto L14;
        r1 = (t) ZeusTransformUtils.preCheckCast(this.f37242b.poll(), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
        goto L19
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L81:
        com.ss.android.common.util.e.b("AppLog LogReaper quit");
        return;
    L19:
        t r12 = r1;
        if (r12 != null) goto L21;
        long r3 = this.l.get();
        if (r3 < 10000) goto L25;
        long r7 = r3;
    L29:
        x r4 = this.i;
        if (r4 != null) goto L32;
    L34:
        long r5 = 0;
    L35:
        long r6 = System.currentTimeMillis();
        if (r7 > 0) goto L38;
    L48:
        long r8 = 0;
    L50:
        if (d() == false) goto L58;
        if (a.p() == false) goto L57;
        r11 = r11 + 1;
        if (r11 <= 4) goto L57;
        this.g = -1;
    L57:
        r1 = r12;
    L58:
        LinkedList<t> r9 = this.f37242b;
        monitor-enter(r9);
    L87:
        th = move-exception;
        throw th;
    L61:
        if (this.f37242b.isEmpty() == true) goto L63;
        t r10 = (t) ZeusTransformUtils.preCheckCast(this.f37242b.poll(), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L87
    L85:
        monitor-exit(r9);     // Catch: Throwable -> L87
        r1 = r10;
        r11 = 0;
        goto L4
    L63:
        if (r8 > 0) goto L95;
        this.f37242b.wait();     // Catch: InterruptedException -> L90 Throwable -> L87
    L79:
        if (this.f37245e.get() == true) goto L80;
        r10 = r12;
        goto L85
    L80:
        monitor-exit(r9);     // Catch: Throwable -> L87
        goto L81
    L95:
        long r13 = System.currentTimeMillis();     // Catch: InterruptedException -> L90 Throwable -> L87
        long r14 = this.k;     // Catch: InterruptedException -> L90 Throwable -> L87
        long r15 = r13 - r14;     // Catch: InterruptedException -> L90 Throwable -> L87
        if (r14 != 0) goto L68;
    L74:
        com.ss.android.common.util.e.b("AppLog wait for batch event " + r8);     // Catch: InterruptedException -> L90 Throwable -> L87
        if (r8 == 0) goto L79;
        this.f37242b.wait(r8);     // Catch: InterruptedException -> L90 Throwable -> L87
        goto L79
    L68:
        if (r15 < r8) goto L70;
        r8 = 0;
        goto L74
    L70:
        if (r15 < 0) goto L74;
        r8 = r8 - r15;     // Catch: InterruptedException -> L90 Throwable -> L87
        goto L74
    L38:
        if (r5 <= 0) goto L48;
        if ((r6 - this.k) <= r7) goto L47;
        if (com.bytedance.common.utility.i.b(this.f37243c) == false) goto L45;
        this.k = r6;
        com.ss.android.common.util.e.b("AppLog batch event " + r7);
        a(r4, null, true, 0, false, false);
        goto L47
    L45:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.K);
    L47:
        r8 = r7;
        goto L50
    L32:
        if (r4.i == true) goto L34;
        r5 = r4.f37250a;
        goto L35
    L25:
        if (r3 > 0) goto L27;
        r7 = 0;
        goto L29
    L27:
        r7 = 10000;
        goto L29
    L21:
        a(r12);
        goto L3
    }

    private int a(String[] r6, String r7, boolean r8) {
        int r1 = 0;
        if (a.D == false) goto L5;
        int r0 = -1;
    L9:
        if ((-1) != r0) goto L12;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.D);
        return -1;
    L12:
        if (r6 != null) goto L14;
    L21:
        return r0;
    L14:
        if (r6.length <= 0) goto L21;
    L16:
        if (r1 >= r6.length) goto L21;
        r0 = a(r1, r6, r7, r8);
        if (r0 == 200) goto L21;
        r1 = r1 + 1;
        goto L16
    L5:
        f r2 = this.s;
        if (r2 == null) goto L8;
        r0 = r2.a(this.l.get());
        goto L9
    L8:
        r0 = 0;
        goto L9
    }

    private void a(x r5) {
        if (a.c() == false) goto L6;
        if (r5 != null) goto L6;
        return;
    L6:
        this.i = r5;
        SharedPreferences r0 = this.f37243c.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);
        this.j = r0.getLong("latest_forground_session_time", 0);
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.i == true) goto L13;
        this.j = r5.f37252c;
        r0.edit().putLong("latest_forground_session_time", this.j).apply();
        return;
    }

    private boolean a(q r19) {
        String r5 = a.i().format(new Date(System.currentTimeMillis()));
        if (r5.equals(a.i().format(Long.valueOf(this.j))) == false) goto L5;
        return true;
    L5:
        JSONObject r6 = null;
        r6 = new JSONObject(r19.f37203b);     // Catch: JSONException -> L55
    L8:
        if (r6 != null) goto L10;
    L54:
        return true;
    L10:
        if (r6.isNull("terminate") == true) goto L54;
        JSONArray r9 = r6.optJSONArray("terminate");
        if (r9 == null) goto L54;
        if (r9.length() <= 0) goto L54;
        JSONObject r11 = r9.optJSONObject(0);
        if (r11 != null) goto L20;
        return true;
    L20:
        String r12 = r11.optString("datetime");
        if (TextUtils.isEmpty(r12) == false) goto L23;
        return true;
    L23:
        int r13 = r11.optInt("duration");
        Date r14 = a.B.parse(r12);     // Catch: Throwable -> L52
        if (r14 != null) goto L28;
        return true;
    L28:
        if (r5.equals(a.i().format(r14)) == false) goto L30;
        return true;
    L30:
        long r15 = r14.getTime() + (((long) r13) * 1000);     // Catch: Throwable -> L52
        if (r5.equals(a.i().format(new Date(r15))) == false) goto L34;
        return true;
    L34:
        if (r6.isNull("event") == true) goto L36;
    L56:
        DBHelper r0 = DBHelper.a(this.f37243c);     // Catch: Throwable -> L49
        r6.remove("terminate");     // Catch: Throwable -> L49
        String r7 = r6.toString();     // Catch: Throwable -> L49
        r19.f37203b = r7;     // Catch: Throwable -> L49
        r0.a(r19.f37202a, r7);     // Catch: Throwable -> L49
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L49
        r1.put("terminate", r9);     // Catch: Throwable -> L49
        r1.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L49
        if (r6.isNull("time_sync") == true) goto L47;
        r1.put("time_sync", r6.optJSONObject("time_sync"));     // Catch: Throwable -> L49
    L47:
        r1.put("header", r6.optJSONObject("header"));     // Catch: Throwable -> L49
        r1.put("_gen_time", r6.optLong("_gen_time"));     // Catch: Throwable -> L49
        r0.a(r1.toString(), 0);     // Catch: Throwable -> L49
    L51:
        return true;
    L49:
        th = move-exception;
        com.ss.android.common.util.e.e("AppLog checkHistoryTerminate", th);
        goto L51
    L36:
        if (r6.isNull("event_v3") == false) goto L56;
        if (r6.isNull("log_data") == false) goto L56;
        if (r6.isNull("item_impression") == false) goto L56;
        if (r6.isNull("launch") == false) goto L56;
        return false;
    L52:
        th = move-exception;
        com.ss.android.common.util.e.e("AppLog checkHistoryTerminate error", th);
        goto L54
    }

    public static void a(JSONObject r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (c.a().isEnabled() == false) goto L39;
        JSONArray r0 = r6.optJSONArray("event_v3");
        JSONArray r1 = r6.optJSONArray("event");
        JSONArray r2 = r6.optJSONArray("log_data");
        JSONArray r3 = r6.optJSONArray("launch");
        JSONArray r8 = r6.optJSONArray("terminate");
        if (r3 != null) goto L9;
    L15:
        if (r8 != null) goto L17;
    L23:
        int r9 = 0;
        if (r0 == null) goto L26;
        r9 = 0 + r0.length();
    L26:
        if (r1 == null) goto L28;
        r9 = r9 + r1.length();
    L28:
        if (r2 == null) goto L30;
        r9 = r9 + r2.length();
    L30:
        if (r9 <= 0) goto L38;
        MonitorV3Helper r4 = c.a();
        if (r7 == false) goto L34;
        com.bytedance.applog.monitor.v3.j r10 = com.bytedance.applog.monitor.v3.j.f;
    L35:
        r4.increaseStats(r10, r9);
        return;
    L34:
        r10 = com.bytedance.applog.monitor.v3.j.g;
        goto L35
    L38:
        return;
    L17:
        if (r8.length() <= 0) goto L23;
        MonitorV3Helper r5 = c.a();
        if (r7 == false) goto L21;
        com.bytedance.applog.monitor.v3.j r11 = com.bytedance.applog.monitor.v3.j.j;
    L22:
        r5.increaseStats(r11, r8.length());
        goto L23
    L21:
        r11 = com.bytedance.applog.monitor.v3.j.k;
        goto L22
    L9:
        if (r3.length() <= 0) goto L15;
        MonitorV3Helper r12 = c.a();
        if (r7 == false) goto L13;
        com.bytedance.applog.monitor.v3.j r13 = com.bytedance.applog.monitor.v3.j.h;
    L14:
        r12.increaseStats(r13, r3.length());
        goto L15
    L13:
        r13 = com.bytedance.applog.monitor.v3.j.i;
        goto L14
    }
}
