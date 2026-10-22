package com.bytedance.applog.engine;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.applog.k;
import com.bytedance.applog.log.f;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.g;
import com.bytedance.applog.util.m;
import com.bytedance.applog.util.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: Sender.java */
/* JADX INFO: loaded from: classes.dex */
class d extends a {
    private static final String TAG = "Sender";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f5612d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f5613e;
    private final ConcurrentHashMap<String, com.bytedance.applog.m.b> f;
    private final com.bytedance.applog.priority.b g;
    private final String h;
    private long i;
    private int j;

    static {
        f5612d = Collections.singletonList(TAG);
    }

    d(Engine r4) {
        super(r4);
        this.f5613e = new long[]{10000};
        this.f = new ConcurrentHashMap();
        this.i = 0;
        this.j = 0;
        this.g = null;
        this.h = TAG;
    }

    d(Engine r6, com.bytedance.applog.priority.b r7) {
        super(r6);
        long[] r8 = {10000};
        this.f5613e = r8;
        this.f = new ConcurrentHashMap();
        this.i = 0;
        this.j = 0;
        this.g = r7;
        this.h = "Sender_p_" + r7.a();
        long r3 = r7.c();
        if (r3 >= 10000) goto L6;
        r8[0] = r3;
        return;
    }

    public void a(long r1) {
        this.i = r1;
    }

    @Override // com.bytedance.applog.engine.a
    public boolean c() {
        return !this.f5602b;
    }

    @Override // com.bytedance.applog.engine.a
    public long d() {
        if (this.g == null) goto L14;
        com.bytedance.applog.priority.a r0 = this.f5601a.getConfig().x();
        if (r0 == null) goto L12;
        if (r0.f() == false) goto L12;
        long r1 = this.f5601a.getConfig().s();
        if (r1 > this.g.c()) goto L12;
        return r1;
    L12:
        return this.g.c();
    L14:
        return this.f5601a.getConfig().s();
    }

    @Override // com.bytedance.applog.engine.a
    public long[] e() {
        return this.f5613e;
    }

    @Override // com.bytedance.applog.engine.a
    public synchronized boolean b(int r12) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L48
        e r2 = this.f5601a.getSession();     // Catch: Throwable -> L48
        f r3 = b().Z();     // Catch: Throwable -> L48
        List<String> r4 = f5612d;     // Catch: Throwable -> L48
        Object[] r6 = new Object[4];     // Catch: Throwable -> L48
        boolean r8 = false;
        r6[0] = this.h;     // Catch: Throwable -> L48
        r6[1] = Long.valueOf(r0);     // Catch: Throwable -> L48
        if (r2 == null) goto L6;
        String r10 = r2.b();     // Catch: Throwable -> L48
    L7:
        r6[2] = r10;     // Catch: Throwable -> L48
        r6[3] = Integer.valueOf(r12);     // Catch: Throwable -> L48
        r3.b(r4, "{} start doWork curTs={}, curSid={}, requestFrom={}", r6);     // Catch: Throwable -> L48
        if (b().x() == false) goto L15;
        if (b().y() == true) goto L15;
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.a.d.f5742d);     // Catch: Throwable -> L48
        b().Z().c(r4, "{} not send events in tourist mode", new Object[]{this.h});     // Catch: Throwable -> L48
        monitor-exit(this);
        return true;
    L15:
        if (r2 != null) goto L17;
    L20:
        DbStore r5 = this.f5601a.getDbStore();     // Catch: Throwable -> L48
        com.bytedance.applog.j.c r7 = this.f5601a.getDm();     // Catch: Throwable -> L48
        if (r7.e() == false) goto L45;
        JSONObject r9 = m.a(r7.a());     // Catch: Throwable -> L48
        k r11 = b().s();     // Catch: Throwable -> L48
        if (r11 != null) goto L51;
    L28:
        com.bytedance.applog.priority.b r13 = this.g;     // Catch: Throwable -> L48
        if (r13 != null) goto L31;
    L34:
        r5.a(r9, this.g, r12, b().ak());     // Catch: Throwable -> L48
    L36:
        if (b(r0) == false) goto L38;
        b().Z().b(f5612d, "{} work is timeout, will not do send.", new Object[]{this.h});     // Catch: Throwable -> L48
    L44:
        r8 = true;
    L46:
        monitor-exit(this);
        return r8;
    L38:
        if (com.bytedance.applog.a.b.f == true) goto L40;
        a(r12, r0);     // Catch: Throwable -> L48
    L40:
        if (a(r12, r0) == true) goto L40;
    L31:
        if (r13.e() == true) goto L34;
        r5.a(r9, this.g, r12);     // Catch: Throwable -> L48
        goto L36
    L51:
        r11.a(r9);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        b().N().increaseStats(j.f5823J);     // Catch: Throwable -> L48
        b().Z().a(f5612d, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L48
        this.f5601a.getAppLog().N().sendError("Sender IHeaderCustomTimelyCallback updateHeader failed", th);     // Catch: Throwable -> L48
        goto L28
    L45:
        this.f5601a.getAppLog().N().sendError("Sender failed due to invalid did", null);     // Catch: Throwable -> L48
        com.bytedance.applog.monitor.a.b.a().b(com.bytedance.applog.monitor.a.d.f5742d);     // Catch: Throwable -> L48
        goto L46
    L17:
        Bundle r14 = r2.a(r0, 50000);     // Catch: Throwable -> L48
        if (r14 == null) goto L20;
        b().a("play_session", r14);     // Catch: Throwable -> L48
        this.f5601a.process(null, false);     // Catch: Throwable -> L48
        goto L20
    L6:
        r10 = "null";
    L48:
        th = move-exception;
        throw th;
    }

    private boolean a(int r13, long r14) {
        DbStore r0 = this.f5601a.getDbStore();
        int r1 = b().ad();
        if (r13 != 4) goto L5;
        r1 = 8;
    L9:
        List<g> r5 = a(r0, r1);
        if (r5.size() < r1) goto L12;
        boolean r2 = true;
    L14:
        if (r5.isEmpty() == true) goto L30;
        com.bytedance.applog.j.b r3 = this.f5601a.getConfig();
        String[] r4 = b().U().a(this.f5601a, false, this.g);
        if (b().F() == false) goto L23;
        com.bytedance.applog.i.c r6 = b().H();
        HashMap r7 = new HashMap();
        if (r6 == null) goto L22;
        Map<String, String> r8 = r6.c();
        if (r8 == null) goto L22;
        r7.putAll(r8);
    L22:
        Engine.b r12 = a(r3, r4, r5, r13, r7, r14);
    L24:
        if (r2 == false) goto L29;
        if (r12.f5599c == true) goto L29;
        return true;
    L29:
        return false;
    L23:
        r12 = a(r3, r4, r5, r13, null, r14);
        goto L24
    L30:
        return r2;
    L12:
        r2 = false;
        goto L14
    L5:
        if (r13 != 12) goto L9;
        r1 = 16;
        goto L9
    }

    private Engine.b a(com.bytedance.applog.j.b r27, String[] r28, List<g> r29, int r30, Map<String, String> r31, long r32) {
        String[] r1 = r28;
        String r3 = "com.obric.aiagent.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        Engine.b r5 = new Engine.b();
        Iterator r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L70;
        g r7 = (g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, r3);
        f r8 = b().Z();
        List<String> r9 = f5612d;
        r8.b(r9, "{} work start send pack...", new Object[]{this.h});
        if (b(r32) == true) goto L7;
        HashMap r10 = new HashMap();
        if (r4 != null) goto L11;
    L13:
        Map<String, String> r13 = this.f5601a.getUriConfig().g();
        if (r13 == null) goto L19;
        if (r13.isEmpty() == true) goto L19;
        r10.putAll(r13);
    L19:
        if (r7.u == null) goto L68;
        if (r7.u.length == 0) goto L68;
        com.bytedance.applog.m.a r14 = a(r27);
        if (r14 == null) goto L29;
        if (r14.a(r30) == false) goto L29;
        b().N().increaseStats(j.D);
        b().Z().c(r9, "{} backoff request as ratio not allowed to send: {}", new Object[]{this.h, r7});
    L29:
        if (b().z() == false) goto L33;
        if (r7.a(this.f5601a.getSession()) == false) goto L33;
        b().N().increaseStats(j.E);
        b().Z().c(r9, "{} adjust terminate not allowed to send: {}", new Object[]{this.h, r7});
    L33:
        b().Z().b(r9, "{} send pack start: {}", new Object[]{this.h, r7});
        if (b().N().isStageEnabled() == false) goto L39;
        Iterator<h> r11 = r7.u().iterator();
    L37:
        if (r11.hasNext() == false) goto L39;
        com.bytedance.applog.monitor.c.a(b().N(), com.bytedance.applog.monitor.v3.a.G, (h) ZeusTransformUtils.preCheckCast(r11.next(), h.class, r3));
    L39:
        int r12 = r1.length;
        int r15 = 0;
        int r16 = 0;
        boolean r17 = false;
    L40:
        if (r15 >= r12) goto L55;
        String r18 = r1[r15];
        if (com.bytedance.applog.a.b.f5495a == false) goto L44;
        boolean r19 = a(r18, r7);
    L45:
        boolean r22 = r19;
        if (r22 == true) goto L48;
        b().N().increaseStats(j.C);
        Iterator r23 = r6;
        String r24 = r3;
        b().Z().c(f5612d, "{} CongestionController not allowed uri:{} to send pack: {}", new Object[]{this.h, r18, r7});
        Map<? extends String, ? extends String> r33 = r4;
        int r25 = r12;
    L54:
        r15 = r15 + 1;
        r1 = r28;
        r4 = r33;
        r17 = r22;
        r6 = r23;
        r3 = r24;
        r12 = r25;
        goto L40
    L48:
        r23 = r6;
        r24 = r3;
        b().Z().b(f5612d, "{} send pack:{} to uri: {}", new Object[]{this.h, r7, r18});
        r33 = r4;
        r25 = r12;
        char r110 = 2;
        r16 = b().V().a(new String[]{r18}, r7.u, this.f5601a, r7.s(), r7.G, r7.H, r10, true);
        if (com.bytedance.applog.k.a.a(r16) == false) goto L52;
        c(r18).c();
        goto L54
    L52:
        if (r16 != 200) goto L54;
        c(r18).d();
        r17 = r22;
    L56:
        r7.w = r16;
        f r20 = b().Z();
        List<String> r21 = f5612d;
        Object[] r26 = new Object[3];
        r26[0] = this.h;
        r26[1] = r7;
        r26[r110] = Integer.valueOf(r16);
        r20.b(r21, "{} send pack end: {}, resp code: {}", r26);
        if (com.bytedance.applog.k.a.a(r16) == true) goto L58;
        if (r16 != 200) goto L62;
        a(r7, true);
        a(b(), r7, true);
        this.j++;
    L69:
        r1 = r28;
        r4 = r33;
        r6 = r23;
        r3 = r24;
        goto L4
    L62:
        a(r7, false);
        a(b(), r7, false);
        com.bytedance.applog.priority.b r34 = this.g;
        if (r34 == null) goto L65;
        r34.a(r16);
    L65:
        b().N().increaseStats(j.w);
        if (r17 == true) goto L69;
        r5.f5599c = true;
        goto L69
    L58:
        a(r7, false);
        a(b(), r7, false);
        b().N().increaseStats(j.w);
        goto L70
    L44:
        r19 = a(r18);
        goto L45
    L55:
        r23 = r6;
        r24 = r3;
        r33 = r4;
        r110 = 2;
    L68:
        r23 = r6;
        r24 = r3;
        r33 = r4;
        r5.f5597a.add(r7);
        b().Z().c(r9, "{} send empty pack: {}", new Object[]{this.h, r7});
        goto L69
    L11:
        if (r4.isEmpty() == true) goto L13;
        r10.putAll(r4);
        goto L13
    L7:
        b().Z().b(r9, "{} work is timeout, break send pack", new Object[]{this.h});
    L70:
        return r5;
    }

    private void a(g r3, boolean r4) {
        DbStore r2 = this.f5601a.getDbStore();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (r4 == false) goto L5;
        r0.add(r3);
    L6:
        r2.setResult(r0, r1);
        return;
    L5:
        r1.add(r3);
        goto L6
    }

    public static void a(com.bytedance.applog.c r4, g r5, boolean r6) {
        if (r4.N().isStageEnabled() == false) goto L12;
        Iterator<h> r0 = r5.u().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.aiagent.plugin");
        MonitorV3Helper r2 = r4.N();
        if (r6 == false) goto L10;
        com.bytedance.applog.monitor.v3.a r3 = com.bytedance.applog.monitor.v3.a.I;
    L11:
        com.bytedance.applog.monitor.c.a(r2, r3, r1);
        goto L6
    L10:
        r3 = com.bytedance.applog.monitor.v3.a.H;
    L12:
        r5.a(r4.N(), r6);
        if (l.a() == true) goto L19;
        a(r4.b(), r5.t(), r6);
        return;
    }

    private boolean a(String r2) {
        if (p.b(r2) == false) goto L7;
        return false;
    L7:
        return c(r2).b();
    }

    private boolean a(String r2, g r3) {
        if (p.b(r2) == false) goto L7;
        return false;
    L7:
        return c(r2).a(r3);
    }

    private String b(String r1) {
        if (p.b(r1) == true) goto L9;
        return Uri.parse(r1).getHost();
    L10:
        return r1;
    L9:
        return r1;
    }

    private com.bytedance.applog.m.b c(String r6) {
        String r7 = b(r6);
        if (this.f.containsKey(r7) == true) goto L5;
        this.f.put(r7, new com.bytedance.applog.m.b(this.h + ":" + r7, this.f5601a.getConfig(), this.g));
    L5:
        com.bytedance.applog.m.b r0 = (com.bytedance.applog.m.b) ZeusTransformUtils.preCheckCast(this.f.get(r7), com.bytedance.applog.m.b.class, "com.obric.aiagent.plugin");
        b().Z().a(f5612d, "{} congestion for host:{} is {}", new Object[]{this.h, r7, r0});
        return r0;
    }

    private List<g> a(DbStore r11, int r12) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList<g> r13 = r11.a(r12, this.g);
        com.bytedance.applog.i.c r14 = b().H();
        if (b().G() == null) goto L6;
        if (r14 == null) goto L6;
        r14.a();
    L6:
        Iterator<g> r15 = r13.iterator();
    L7:
        int r4 = 1;
        if (r15.hasNext() == false) goto L25;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r15.next(), g.class, "com.obric.aiagent.plugin");
        if (b().G() == null) goto L18;
        if (r14 == null) goto L18;
        com.bytedance.applog.i.a r6 = r3.y();
        if (r6 == null) goto L18;
        if (r14.a(r6, r3.z()) == true) goto L18;
        b().Z().b(f5612d, "Pack:{} is not allowed send by isolate rule [{}, {}]", new Object[]{r3, r6, r3.z()});
    L18:
        if (r3.v() == true) goto L19;
        if (r3.w() == true) goto L22;
        r0.add(r3);
        goto L7
    L22:
        r2.add(r3);
        goto L7
    L19:
        r1.add(r3);
        goto L7
    L25:
        if (b().G() == null) goto L29;
        if (r14 == null) goto L29;
        r14.b();
    L29:
        if (r2.isEmpty() == true) goto L32;
        r1.addAll(r2);
    L32:
        if (r1.isEmpty() == false) goto L34;
    L39:
        return r0;
    L34:
        if (this.j <= 0) goto L36;
    L37:
        r4 = 0;
    L38:
        r0.addAll(r4, r1);
        goto L39
    L36:
        if (r0.isEmpty() == false) goto L38;
        goto L37
    }

    @Override // com.bytedance.applog.engine.a
    public String f() {
        return this.h;
    }

    private boolean b(long r5) {
        if (this.i > 0) goto L6;
        return false;
    L6:
        if ((System.currentTimeMillis() - r5) < this.i) goto L9;
        return true;
    L9:
        return false;
    }

    void a(com.bytedance.applog.priority.b r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3 != this.g) goto L11;
        Iterator<com.bytedance.applog.m.b> r2 = this.f.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        ((com.bytedance.applog.m.b) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.m.b.class, "com.obric.aiagent.plugin")).a(r4);
        goto L7
    L12:
        return;
    }

    private com.bytedance.applog.m.a a(com.bytedance.applog.j.b r1) {
        com.bytedance.applog.priority.b r0 = this.g;
        if (r0 == null) goto L7;
        return r0.d();
    L7:
        return r1.y();
    }

    public static void a(final String r2, Set<Long> r3, final boolean r4) {
        final Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return;
    L8:
        if (l.a() == false) goto L10;
        return;
    L10:
        l.a("event_upload_eid", new AnonymousClass1(r2, r5, r4));
    }
}
