package com.bytedance.applog.engine;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.store.f;
import com.bytedance.applog.store.h;
import com.bytedance.applog.store.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: Session.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f5617e = null;
    private static a u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f5618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f5619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f5620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f5621d;
    private volatile long f;
    private final Engine g;
    private h h;
    private h i;
    private String j;
    private final AtomicLong k;
    private volatile long l;
    private int m;
    private long n;
    private volatile boolean o;
    private long p;
    private int q;
    private String r;
    private volatile String s;
    private volatile long t;

    /* JADX INFO: compiled from: Session.java */
    static class a extends i {
        a() {
        }
    }

    static {
        f5617e = Collections.singletonList("Session");
    }

    e(Engine r4) {
        this.f5618a = 0;
        this.f5619b = 0;
        this.f5620c = 0;
        this.f5621d = 0;
        this.k = new AtomicLong(1000);
        this.n = -1;
        this.g = r4;
        this.t = r4.getConfig().w();
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.s;
    }

    public long d() {
        return this.f;
    }

    public void a(long r1) {
        this.f = r1;
    }

    synchronized Bundle a(long r6, long r8) {
        monitor-enter(this);
        Bundle r0 = null;
        long r1 = this.l;     // Catch: Throwable -> L15
        if (this.g.getConfig().g() == true) goto L7;
    L13:
        monitor-exit(this);
        return r0;
    L7:
        if (f() == false) goto L13;
        if (r1 <= 0) goto L13;
        long r2 = r6 - r1;     // Catch: Throwable -> L15
        if (r2 <= r8) goto L13;
        r0 = new Bundle();     // Catch: Throwable -> L15
        r0.putInt("session_no", this.q);     // Catch: Throwable -> L15
        int r9 = this.m + 1;     // Catch: Throwable -> L15
        this.m = r9;     // Catch: Throwable -> L15
        r0.putInt("send_times", r9);     // Catch: Throwable -> L15
        r0.putLong("current_duration", r2 / 1000);     // Catch: Throwable -> L15
        r0.putString("session_start_time", com.bytedance.applog.store.a.b(this.n));     // Catch: Throwable -> L15
        this.l = r6;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public boolean e() {
        return this.o;
    }

    boolean f() {
        if (e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.p != 0) goto L7;
        return true;
    }

    synchronized f a(com.bytedance.applog.store.a r10, ArrayList<com.bytedance.applog.store.a> r11, boolean r12) {
        monitor-enter(this);
        if (r10 != null) goto L56;
        long r4 = 0;
    L10:
        this.j = a();     // Catch: Throwable -> L53
        if (r12 == false) goto L17;
        this.t = r4;     // Catch: Throwable -> L53
        this.g.getConfig().a(this.t);     // Catch: Throwable -> L53
        if (this.g.mUuidChanged == true) goto L17;
        if (TextUtils.isEmpty(this.s) == false) goto L17;
        this.s = this.j;     // Catch: Throwable -> L53
    L17:
        this.k.set(10000);     // Catch: Throwable -> L53
        this.n = r4;     // Catch: Throwable -> L53
        this.o = r12;     // Catch: Throwable -> L53
        this.p = 0;     // Catch: Throwable -> L53
        this.l = 0;     // Catch: Throwable -> L53
        boolean r3 = true;
        if (r12 == false) goto L27;
        Calendar r13 = Calendar.getInstance();     // Catch: Throwable -> L53
        String r14 = "" + r13.get(1) + r13.get(2) + r13.get(5);     // Catch: Throwable -> L53
        com.bytedance.applog.j.b r6 = this.g.getConfig();     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(this.r) == false) goto L23;
        this.r = r6.d();     // Catch: Throwable -> L53
        this.q = r6.e();     // Catch: Throwable -> L53
    L23:
        if (r14.equals(this.r) == true) goto L25;
        this.r = r14;     // Catch: Throwable -> L53
        this.q = 1;     // Catch: Throwable -> L53
    L26:
        r6.a(r14, this.q);     // Catch: Throwable -> L53
        this.m = 0;     // Catch: Throwable -> L53
        this.l = r4;     // Catch: Throwable -> L53
        goto L27
    L25:
        this.q++;     // Catch: Throwable -> L53
    L27:
        f r15 = null;
        if (r4 == (-1)) goto L44;
        r15 = new f();     // Catch: Throwable -> L53
        r15.a(this.g.getAppLog().b());     // Catch: Throwable -> L53
        r15.f5994d = this.j;     // Catch: Throwable -> L53
        if (this.o == false) goto L33;
        r3 = false;
    L33:
        r15.w = r3;     // Catch: Throwable -> L53
        r15.f5993c = g();     // Catch: Throwable -> L53
        r15.a(this.n);     // Catch: Throwable -> L53
        r15.v = this.g.getDm().c();     // Catch: Throwable -> L53
        r15.u = this.g.getDm().b();     // Catch: Throwable -> L53
        a(r15, d());     // Catch: Throwable -> L53
        r15.g = this.g.getAppLog().o();     // Catch: Throwable -> L53
        r15.s = com.bytedance.applog.monitor.c.c(this.g.getAppLog().N(), r15);     // Catch: Throwable -> L53
        if (ZeusTransformUtils.instanceOf(r10, h.class) == false) goto L36;
        r15.y = ((h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin")).z;     // Catch: Throwable -> L53
    L36:
        r11.add(r15);     // Catch: Throwable -> L53
        if (r15.s <= 0) goto L39;
        com.bytedance.applog.monitor.c.a(this.g.getAppLog().N(), com.bytedance.applog.monitor.v3.a.f5768b, r15);     // Catch: Throwable -> L53
    L39:
        this.g.getAppLog().N().increaseStats(j.f5825b);     // Catch: Throwable -> L53
        if (this.o == false) goto L42;
        this.g.getAppLog().N().increaseStats(j.f5826c);     // Catch: Throwable -> L53
    L42:
        this.g.getAppLog().T().a(r15.f5994d, r15.f5992b, r15.w);     // Catch: Throwable -> L53
    L44:
        if (this.g.getAppLog().C() > 0) goto L46;
        this.g.getAppLog().a(6);     // Catch: Throwable -> L53
    L46:
        com.bytedance.applog.log.f r16 = this.g.getAppLog().Z();     // Catch: Throwable -> L53
        List<String> r17 = f5617e;     // Catch: Throwable -> L53
        StringBuilder r0 = new StringBuilder().append("startSession, ");     // Catch: Throwable -> L53
        if (this.o == false) goto L49;
        String r1 = "fg";
    L50:
        r16.a(r17, r0.append(r1).append(", ").append(this.j).append(", ").append(r4).toString(), new Object[0]);     // Catch: Throwable -> L53
        monitor-exit(this);
        return r15;
    L53:
        th = move-exception;
        throw th;
    L49:
        r1 = "bg";
        goto L50
    L56:
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L8;
        r4 = -1;
        goto L10
    L8:
        r4 = r10.f5992b;     // Catch: Throwable -> L53
        goto L10
    }

    static boolean a(com.bytedance.applog.store.a r2) {
        if (ZeusTransformUtils.instanceOf(r2, h.class) == true) goto L5;
        return false;
    L5:
        return ((h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin")).r();
    }

    public boolean a(com.bytedance.applog.store.a r14, ArrayList<com.bytedance.applog.store.a> r15) {
        boolean r0 = ZeusTransformUtils.instanceOf(r14, h.class);
        boolean r1 = a(r14);
        boolean r5 = false;
        if (this.n != (-1)) goto L6;
        this.g.getAppLog().Z().b(f5617e, "session process start session 1, data={}, isResume=" + r1, new Object[]{r14});
        a(r14, r15, a(r14));
    L17:
        r5 = true;
    L18:
        if (r0 == false) goto L42;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r14, h.class, "com.obric.aiagent.plugin");
        if (r2.r() == false) goto L33;
        this.p = 0;
        r15.add(r14);
        if (TextUtils.isEmpty(r2.v) == true) goto L24;
    L44:
        b(r14);
        return r5;
    L24:
        if (this.i == null) goto L29;
        if (((r2.f5992b - this.i.f5992b) - this.i.u) >= 500) goto L29;
        r2.v = this.i.w;
    L29:
        if (this.h == null) goto L44;
        if (((r2.f5992b - this.h.f5992b) - this.h.u) >= 500) goto L44;
        r2.v = this.h.w;
        goto L44
    L33:
        Bundle r3 = a(r14.f5992b, 0);
        if (this.g.getAppLog() == null) goto L37;
        if (r3 == null) goto L37;
        this.g.getAppLog().a("play_session", r3);
    L37:
        this.p = r2.f5992b;
        r15.add(r14);
        if (r2.s() == false) goto L40;
        this.h = r2;
        goto L44
    L40:
        this.i = r2;
        this.h = null;
        goto L44
    L42:
        if (ZeusTransformUtils.instanceOf(r14, a.class) == true) goto L44;
        r15.add(r14);
        goto L44
    L6:
        if (this.o == true) goto L10;
        if (r1 == false) goto L10;
        this.g.getAppLog().Z().b(f5617e, "session process start session 2, data={}", new Object[]{r14});
        a(r14, r15, true);
    L10:
        if (this.p == 0) goto L15;
        if (r14.f5992b <= (this.p + this.g.getBackgroundSessionKeepMills())) goto L15;
        this.g.getAppLog().Z().b(f5617e, "session process start session 3, data={}, isResume=" + r1, new Object[]{r14});
        a(r14, r15, r1);
    L15:
        if (this.n <= (r14.f5992b + 7200000)) goto L18;
        this.g.getAppLog().Z().b(f5617e, "session process start session 4, data={}, isResume=" + r1, new Object[]{r14});
        a(r14, r15, r1);
        goto L17
    }

    public void b(com.bytedance.applog.store.a r3) {
        if (r3 == null) goto L5;
        a(r3, d());
        r3.a(this.g.getAppLog().b());
        r3.g = this.g.getAppLog().o();
        r3.f5994d = this.j;
        r3.f5993c = g();
        r3.i = com.bytedance.common.utility.i.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.g.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a();
        return;
    }

    public long g() {
        return this.k.incrementAndGet();
    }

    public void a(com.bytedance.applog.store.a r7, long r8) {
        IBDAccountCallback r0 = this.g.getAppLog().w();
        if (this.g.getAppLog().v() == false) goto L11;
        if (r0 == null) goto L11;
        Pair<Integer, Long> r9 = r0.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L9;
        r7.f5995e = ((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.aiagent.plugin")).longValue();
        r7.k = 1;
        r7.l = 1;
        r7.j = ((Integer) ZeusTransformUtils.preCheckCast(r9.first, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r7.f = ((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.aiagent.plugin")).longValue();
    L12:
        r7.h = this.g.getAppLog().a(String.valueOf(r7.f5995e));
        return;
    L9:
        if (this.f5620c != 0) goto L12;
        r7.f = this.f5618a;
        r7.j = this.f5619b;
        r7.k = this.f5620c;
        r7.l = this.f5621d;
    L11:
        r7.f5995e = r8;
        goto L12
    }

    public long h() {
        return this.t;
    }

    static a i() {
        if (u != null) goto L5;
        u = new a();
    L5:
        u.a(0);
        return u;
    }
}
