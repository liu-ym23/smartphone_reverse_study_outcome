package com.bytedance.apm6.frequency;

import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrequencyMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "APM-HighFrequency";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, HashMap<String, a>> f5344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, HashMap<String, a>> f5345e;
    private final HashMap<String, HashMap<String, a>> f;
    private final HashMap<String, HashMap<String, a>> g;
    private long h;
    private long i;
    private HashMap<String, HashMap<String, a>> j;
    private HashMap<String, HashMap<String, a>> k;
    private long l;
    private long m;
    private BlockingQueue<e> n;
    private c o;
    private int p;
    private com.bytedance.apm6.util.e.a q;
    private com.bytedance.apm6.util.e.a r;
    private com.bytedance.apm6.util.e.a s;
    private com.bytedance.apm6.service.d.b t;
    private volatile boolean u;

    static /* synthetic */ void a(b r0) {
        r0.f();
    }

    static /* synthetic */ void a(b r0, boolean r1) {
        r0.b(r1);
    }

    static /* synthetic */ void b(b r0) {
        r0.g();
    }

    static /* synthetic */ void c(b r0) {
        r0.e();
    }

    static /* synthetic */ void d(b r0) {
        r0.i();
    }

    static /* synthetic */ int e(b r2) {
        int r0 = r2.p;
        r2.p = r0 + 1;
        return r0;
    }

    static /* synthetic */ int f(b r0) {
        return r0.p;
    }

    private b() {
        this.f5342b = false;
        this.f5343c = false;
        this.f5344d = new HashMap();
        this.f5345e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = 0;
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.p = 0;
        this.u = true;
    }

    public static b a() {
        if (f5341a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5341a != null) goto L9;
        f5341a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f5341a;
    }

    public void b() {
        com.bytedance.apm6.service.c.a(d.class);
    }

    public void a(c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.o == r2) goto L9;
        c();
        b(r2);
        return;
    }

    public synchronized void c() {
        monitor-enter(this);
        this.f5343c = false;     // Catch: Throwable -> L23
        if (this.q == null) goto L8;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).b(this.q);     // Catch: Throwable -> L23
    L8:
        if (this.s == null) goto L11;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).b(this.s);     // Catch: Throwable -> L23
    L11:
        if (this.r == null) goto L13;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).b(this.r);     // Catch: Throwable -> L23
    L13:
        com.bytedance.apm6.service.d.a r0 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r0 == null) goto L18;
        com.bytedance.apm6.service.d.b r1 = this.t;     // Catch: Throwable -> L23
        if (r1 == null) goto L18;
        r0.unregister(r1);     // Catch: Throwable -> L23
    L18:
        BlockingQueue<e> r2 = this.n;     // Catch: Throwable -> L23
        if (r2 == null) goto L21;
        r2.clear();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private synchronized void b(c r4) {
        monitor-enter(this);
        if (r4 != null) goto L47;
    L45:
        monitor-exit(this);
        return;
    L47:
    L42:
        th = move-exception;
        throw th;
    L5:
        if (r4.a() == true) goto L9;
        if (r4.a() == false) goto L45;
    L9:
        if (this.f5343c == true) goto L45;
        if (com.bytedance.apm.c.i() == false) goto L14;
        a(TAG, "init:" + r4);     // Catch: Throwable -> L42
    L14:
        this.o = r4;     // Catch: Throwable -> L42
        if (Build.VERSION.SDK_INT < 21) goto L17;
        this.n = new LinkedTransferQueue();     // Catch: Throwable -> L42
    L19:
        if (r4.a() == false) goto L21;
        d();     // Catch: Throwable -> L42
    L21:
        this.l = System.currentTimeMillis();     // Catch: Throwable -> L42
        com.bytedance.apm6.service.d.a r0 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        if (r0 == null) goto L38;
        boolean r1 = r0.isForeground();     // Catch: Throwable -> L42
        if (r1 == false) goto L26;
        HashMap<String, HashMap<String, a>> r2 = this.f;     // Catch: Throwable -> L42
    L27:
        this.j = r2;     // Catch: Throwable -> L42
        if (r1 == false) goto L30;
        HashMap<String, HashMap<String, a>> r3 = this.f5344d;     // Catch: Throwable -> L42
    L31:
        this.k = r3;     // Catch: Throwable -> L42
        com.bytedance.apm6.service.d.b r5 = new AnonymousClass1(this);     // Catch: Throwable -> L42
        this.t = r5;     // Catch: Throwable -> L42
        r0.register(r5);     // Catch: Throwable -> L42
        if (r4.b() == false) goto L34;
        a(r1);     // Catch: Throwable -> L42
    L34:
        this.f5343c = true;     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L30:
        r3 = this.f5345e;     // Catch: Throwable -> L42
        goto L31
    L26:
        r2 = this.g;     // Catch: Throwable -> L42
        goto L27
    L38:
        if (com.bytedance.apm.c.i() == false) goto L40;
        a(TAG, "init error");     // Catch: Throwable -> L42
    L40:
        monitor-exit(this);
        return;
    L17:
        this.n = new LinkedBlockingQueue();     // Catch: Throwable -> L42
        goto L19
    }

    private void d() {
        if (this.q != null) goto L5;
        final long r3 = this.o.d();
        final long r5 = this.o.d();
        this.q = new AnonymousClass2(this, r3, r5);
    L5:
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.q);
    }

    private void a(boolean r15) {
        if (this.r != null) goto L5;
    L12:
        final long r4 = this.o.a(false);
        final long r6 = this.o.a(false);
        this.r = new AnonymousClass3(this, r4, r6);
        final long r10 = this.o.a(true);
        final long r12 = this.o.a(true);
        this.s = new AnonymousClass4(this, r10, r12);
    L13:
        this.m = System.currentTimeMillis();
        com.bytedance.apm6.util.e.b r0 = com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b);
        if (r15 == false) goto L16;
        com.bytedance.apm6.util.e.a r14 = this.s;
    L17:
        r0.a(r14);
        return;
    L16:
        r14 = this.r;
        goto L17
    L5:
        if (this.s == null) goto L12;
        com.bytedance.apm6.util.e.b r1 = com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b);
        if (r15 == false) goto L10;
        com.bytedance.apm6.util.e.a r2 = this.r;
    L11:
        r1.b(r2);
        goto L13
    L10:
        r2 = this.s;
        goto L11
    }

    private void b(boolean r5) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.m;
        this.m = r0;
        if (r5 == false) goto L5;
        String r6 = "command_check_front_exception";
    L6:
        a(new e(r6, r2));
        return;
    L5:
        r6 = "command_check_background_exception";
        goto L6
    }

    private void e() {
        long r0 = System.currentTimeMillis();
        a(new e("command_report_data", r0 - this.l));
        this.l = r0;
    }

    private void f() {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.l;
        this.l = r0;
        if (this.o.b() == false) goto L5;
        a(true);
    L5:
        a(new e("command_change_to_front", r2));
    }

    private void g() {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.l;
        this.l = r0;
        if (this.o.b() == false) goto L5;
        a(false);
    L5:
        a(new e("command_change_to_background", r2));
    }

    private void a(e r3) {
        if (this.n.offer(r3) == true) goto L8;
        if (com.bytedance.apm.c.i() == false) goto L8;
        a(TAG, "enqueue error,data:" + r3 + " size:" + this.n.size());
    L8:
        if (this.f5342b == true) goto L11;
        h();
        return;
    }

    private synchronized void h() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f5342b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f5342b = true;     // Catch: Throwable -> L11
        new Thread(new AnonymousClass5(this), "APM-FrequencyMonitor").start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private void i() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.n.take(), e.class, "com.obric.aiagent.plugin");
        if (r0.a() == null) goto L19;
        long r3 = r0.b();
        if (r0.a().startsWith("command_change_to_front") == false) goto L8;
        a(true, r3);
    L20:
        r0.a(false);
        return;
    L8:
        if (r0.a().startsWith("command_change_to_background") == false) goto L11;
        a(false, r3);
        goto L20
    L11:
        if (r0.a().startsWith("command_check_front_exception") == false) goto L14;
        b(true, r3);
        goto L20
    L14:
        if (r0.a().startsWith("command_check_background_exception") == false) goto L17;
        b(false, r3);
        goto L20
    L17:
        if (r0.a().startsWith("command_report_data") == false) goto L20;
        a(r3);
        goto L20
    L19:
        b(r0.c(), r0.d());
        goto L20
    }

    private void b(String r6, String r7) {
        if (this.o.a() == false) goto L12;
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(this.j.get(r6), HashMap.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        HashMap<String, a> r1 = new HashMap();
        this.j.put(r6, r1);
        r1.put(r7, new a(1));
        goto L12
    L7:
        a r3 = (a) ZeusTransformUtils.preCheckCast(r0.get(r7), a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
        r0.put(r7, new a(1));
        goto L12
    L10:
        r3.a(1);
    L12:
        if (this.o.b() == false) goto L21;
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.k.get(r6), HashMap.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L16;
        HashMap<String, a> r4 = new HashMap();
        this.k.put(r6, r4);
        r4.put(r7, new a(1));
        return;
    L16:
        a r5 = (a) ZeusTransformUtils.preCheckCast(r2.get(r7), a.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L19;
        r2.put(r7, new a(1));
        return;
    L19:
        r5.a(1);
        return;
    }

    private void a(boolean r3, long r4) {
        this.f5344d.clear();
        this.f5345e.clear();
        if (r3 == false) goto L5;
        this.i += r4;
        this.j = this.f;
        this.k = this.f5344d;
        return;
    L5:
        this.h += r4;
        this.j = this.g;
        this.k = this.f5345e;
    }

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
    private void b(boolean r20, long r21) {
        boolean r1 = r20 ? 1 : 0;
        if (r1 == false) goto L5;
        HashMap<String, HashMap<String, a>> r2 = this.f5344d;
    L7:
        if (r2.isEmpty() == false) goto L9;
        return;
    L9:
        int r3 = this.o.c();
        if (r3 > 0) goto L12;
        return;
    L12:
        HashMap r4 = new HashMap();
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, HashMap<String, a>>> r6 = r2.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(r5.get(r9), List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L18;
        r10 = new ArrayList();
        r5.put(r9, r10);
    L18:
        Iterator r8 = ((HashMap) ZeusTransformUtils.preCheckCast(r7.getValue(), HashMap.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin");
        int r13 = ((a) ZeusTransformUtils.preCheckCast(r11.getValue(), a.class, "com.obric.aiagent.plugin")).a();
        r10.add(new Pair(r12, Integer.valueOf(r13)));
        a r14 = (a) ZeusTransformUtils.preCheckCast(r4.get(r9), a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L23;
        r14.a(r13);
        goto L20
    L23:
        r4.put(r9, new a(r13));
        goto L20
    L25:
        Iterator r15 = r4.entrySet().iterator();
    L27:
        if (r15.hasNext() == false) goto L43;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        float r17 = ((a) ZeusTransformUtils.preCheckCast(r16.getValue(), a.class, "com.obric.aiagent.plugin")).a() / (r21 * 1.6666667E-5f);
        float r18 = (10000.0f * r17) / this.o.e();
        if (r18 <= this.o.a((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.aiagent.plugin"), r1)) goto L41;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r5.get(r16.getKey()), List.class, "com.obric.aiagent.plugin");
        Collections.sort(r19, new AnonymousClass6(this));
        final JSONObject r110 = new JSONObject();
        JSONArray r111 = new JSONArray();
        int r112 = 0;
    L32:
        if (r112 >= Math.min(r3, r19.size())) goto L38;
        JSONObject r22 = new JSONObject();
        int r113 = r3;
        Iterator r114 = r15;
        Pair r23 = (Pair) ZeusTransformUtils.preCheckCast(r19.get(r112), Pair.class, "com.obric.aiagent.plugin");
        if (r112 != 0) goto L37;
        r110.putOpt("exception_reason", r23.first);
    L37:
        r22.putOpt("key", r23.first);
        r22.putOpt("count", r23.second);
        r111.put(r22);
        r112 = r112 + 1;
        r3 = r113;
        r15 = r114;
        r5 = r5;
        goto L32
    L38:
        int r115 = r3;
        Iterator r116 = r15;
        HashMap r117 = r5;
        r110.putOpt("is_front", Integer.valueOf(r20 ? 1 : 0));
        r110.putOpt("category", r16.getKey());
        r110.putOpt("total_count", Integer.valueOf(((a) ZeusTransformUtils.preCheckCast(r16.getValue(), a.class, "com.obric.aiagent.plugin")).a()));
        r110.putOpt("duration", Long.valueOf(r21));
        r110.putOpt("frequency_per_min", Float.valueOf(Math.round(r17 * 100.0f) / 100.0f));
        r110.putOpt("frequency_reduction", Float.valueOf(Math.round(r18 * 100.0f) / 100.0f));
        r110.putOpt("sampling_rate", Integer.valueOf(this.o.e()));
        r110.putOpt("top_data", r111);
        r110.putOpt(DBHelper.COL_TIME, Long.valueOf(System.currentTimeMillis()));
        com.bytedance.apm.thread.b.a().a(new AnonymousClass7(this, r110));
        if (com.bytedance.apm.c.i() == false) goto L42;
        a(TAG, "Report Exception:" + r110);
    L42:
        r1 = r20 ? 1 : 0;
        r3 = r115;
        r15 = r116;
        r5 = r117;
        goto L27
    L41:
        r115 = r3;
        r116 = r15;
        r117 = r5;
        goto L42
    L43:
        r2.clear();
        return;
    L5:
        r2 = this.f5345e;
        goto L7
    }

    private void a(long r10) {
        HashMap<String, HashMap<String, a>> r0 = this.j;
        HashMap<String, HashMap<String, a>> r1 = this.f;
        if (r0 != r1) goto L5;
        this.h += r10;
    L7:
        if (r1.isEmpty() == true) goto L9;
    L11:
        final JSONObject r11 = new JSONObject();
        boolean r12 = false;
        boolean r2 = true;
        if (this.f.isEmpty() == true) goto L17;
        JSONObject r3 = new JSONObject();
        if (a(this.f, this.h, r3, true) == false) goto L17;
        r3.putOpt("duration", Long.valueOf(this.h));
        r11.putOpt(DBHelper.COL_FRONT, r3);
        r12 = true;
    L17:
        if (this.g.isEmpty() == true) goto L21;
        JSONObject r4 = new JSONObject();
        if (a(this.g, this.i, r4, false) == false) goto L21;
        r4.putOpt("duration", Long.valueOf(this.i));
        r11.putOpt("background", r4);
    L22:
        if (r2 == false) goto L26;
        r11.putOpt("sampling_rate", Integer.valueOf(this.o.e()));
        r11.putOpt(DBHelper.COL_TIME, Long.valueOf(System.currentTimeMillis()));
        com.bytedance.apm.thread.b.a().a(new AnonymousClass8(this, r11));
        if (com.bytedance.apm.c.i() == false) goto L26;
        a(TAG, "Report Data:" + r11);
    L26:
        this.f.clear();
        this.g.clear();
        this.h = 0;
        this.i = 0;
        return;
    L21:
        r2 = r12;
        goto L22
    L9:
        if (this.g.isEmpty() == false) goto L11;
        return;
    L5:
        this.i += r10;
        goto L7
    }

    private boolean a(HashMap<String, HashMap<String, a>> r11, long r12, JSONObject r14, boolean r15) {
        JSONArray r0 = new JSONArray();
        Iterator<Map.Entry<String, HashMap<String, a>>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        Iterator r3 = ((HashMap) ZeusTransformUtils.preCheckCast(r1.getValue(), HashMap.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        int r6 = ((a) ZeusTransformUtils.preCheckCast(r4.getValue(), a.class, "com.obric.aiagent.plugin")).a();
        float r7 = r6 / (r12 * 1.6666667E-5f);
        float r8 = (10000.0f * r7) / this.o.e();
        if (r8 <= this.o.b(r2, r15)) goto L7;
        JSONObject r9 = new JSONObject();
        r9.putOpt("category", r2);
        r9.putOpt("key", r5);
        r9.putOpt("count", Integer.valueOf(r6));
        r9.putOpt("frequency_per_min", Float.valueOf(Math.round(r7 * 100.0f) / 100.0f));
        r9.putOpt("frequency_reduction", Float.valueOf(Math.round(r8 * 100.0f) / 100.0f));
        r0.put(r9);
        goto L7
    L11:
        r14.putOpt("details", r0);
        if (r0.length() <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
