package com.bytedance.crash.anr;

import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.dumper.n;
import com.bytedance.crash.dumper.p;
import com.bytedance.crash.dumper.q;
import com.bytedance.crash.dumper.s;
import com.bytedance.crash.j;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.t;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnrDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7176a;
    private static volatile boolean g;
    private final AtomicBoolean A;
    private final AtomicBoolean B;
    private final AtomicBoolean C;
    private boolean D;
    private final AtomicBoolean E;
    private final AtomicBoolean F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f7177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f7180e;
    private JSONArray f;
    private final AtomicBoolean h;
    private final AtomicBoolean i;
    private final AtomicBoolean j;
    private final AtomicBoolean k;
    private final AtomicBoolean l;
    private final AtomicBoolean m;
    private final AtomicBoolean n;
    private final AtomicBoolean o;
    private final AtomicBoolean p;
    private final AtomicBoolean q;
    private final AtomicBoolean r;
    private final AtomicBoolean s;
    private final AtomicBoolean t;
    private final AtomicBoolean u;
    private final AtomicBoolean v;
    private final AtomicBoolean w;
    private final AtomicBoolean x;
    private final AtomicBoolean y;
    private final AtomicBoolean z;

    /* JADX INFO: compiled from: AnrDumper.java */
    public static class a {
        public static void a(File r3, int r4) {
            com.bytedance.crash.dumper.a.f r0 = new com.bytedance.crash.dumper.a.f(r3.getAbsolutePath() + "/anr_config.txt");
            r0.a();
            r0.a("oom_adj");
            r0.a(r4);
            r0.e();
            r0.a("enable_upload_bg_anr");
            r0.a(b.b());
            r0.e();
            r0.a("enable_new_anr");
            r0.a(j.b());
            if (Build.VERSION.SDK_INT < 24) goto L5;
            long r5 = com.bytedance.crash.i.g() - Process.getStartElapsedRealtime();
            r0.e();
            r0.a("init_sub_launch_time");
            r0.a(r5);
        L5:
            r0.b();
            r0.f();
        }

        public static void a(File r7, JSONObject r8) {
            String r1 = com.bytedance.crash.o.i.d(new File(r7, "anr_config.txt"));
            if (r1 == null) goto L39;
            JSONObject r2 = null;
            r2 = new JSONObject(r1);     // Catch: Throwable -> L31
        L7:
            if (r2 != null) goto L37;
            return;
        L37:
            int r3 = r2.optInt("oom_adj", -1);     // Catch: Throwable -> L32
            if (r3 < 200) goto L12;
        L14:
            boolean r9 = false;
        L15:
            if (r3 < 0) goto L33;
            r8.put("is_background_v1", String.valueOf(r9));     // Catch: Throwable -> L32
            goto L33
        L12:
            if (new File(r7, "background_v2").exists() == false) goto L14;
            r9 = true;
        L33:
        L26:
            e = move-exception;
            r.b(e);
        L28:
            if (r2 == null) goto L40;
            l.b(r8, r2);
            return;
        L40:
            return;
        L18:
            if (r2.has("init_sub_launch_time") == false) goto L28;
            long r4 = r2.getLong("init_sub_launch_time") / 1000;     // Catch: Exception -> L26
            if (r4 <= 0) goto L23;
            r8.put("npth_init_sub_launch_range", r4 + "~" + (r4 + 1));     // Catch: Exception -> L26
        L24:
            r2.remove("init_sub_launch_time");     // Catch: Exception -> L26
            goto L28
        L23:
            r8.put("npth_init_sub_launch_range", "<1");     // Catch: Exception -> L26
            goto L24
        }
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.o;
    }

    static /* synthetic */ File b(b r0) {
        return r0.f7177b;
    }

    static /* synthetic */ boolean b() {
        return g;
    }

    private b(File r3, long r4, boolean r6) {
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        this.z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = new AtomicBoolean(false);
        this.C = new AtomicBoolean(false);
        this.D = false;
        this.E = new AtomicBoolean(false);
        this.F = new AtomicBoolean(false);
        this.f7177b = r3;
        this.f7178c = r4;
        this.f7179d = r6;
        this.f7180e = NativeBridge.a(r3.getAbsolutePath());
    }

    public static void a(boolean r0) {
        f7176a = r0;
    }

    public void finalize() {
        NativeBridge.c(this.f7180e);
    }

    public static b a(File r1, long r2, boolean r4) {
        return new b(r1, r2, r4);
    }

    private void a(int r4) {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpSummary", th);
        return;
    L3:
        if (this.h.compareAndSet(false, true) == false) goto L11;
        h.a(this.f7177b, this.f7178c, this.f7179d, r4);     // Catch: Throwable -> L6
        return;
    }

    private void b(int r4) {
    L8:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpAdj", th);
        return;
    L3:
        if (this.i.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r4 == Integer.MAX_VALUE) goto L14;
        a.a(this.f7177b, r4);     // Catch: Throwable -> L8
        return;
    }

    private void c() {
    L8:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpMainStack", th);
        return;
    L3:
        if (e.a() == true) goto L5;
        return;
    L5:
        if (this.j.compareAndSet(false, true) == false) goto L14;
        k.a r0 = k.a(this.f7177b);     // Catch: Throwable -> L8
        this.f = com.bytedance.crash.h.a.a(CrashType.ANR, r0.a(), this.f7177b);     // Catch: Throwable -> L8
        return;
    }

    private void d() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpAppVersion", th);
        return;
    L3:
        if (this.k.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.a.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void e() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCommonParams", th);
        return;
    L3:
        if (this.l.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.d.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void f() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpProfileInfo", th);
        return;
    L3:
        if (this.m.compareAndSet(false, true) == false) goto L11;
        e.a(this.f7177b, this.f7180e);     // Catch: Throwable -> L6
        return;
    }

    private void g() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpProfileInfo", th);
        return;
    L3:
        if (this.n.compareAndSet(false, true) == false) goto L11;
        n.a().a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void b(boolean r3) {
        if (r3 == false) goto L11;
        DefaultWorkThread.post(new AnonymousClass1(this));
        return;
    L11:
    L8:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpLooperMessages", th);
        return;
    L5:
        if (this.o.compareAndSet(false, true) == false) goto L14;
        com.bytedance.crash.g.d.a().a(this.f7177b);     // Catch: Throwable -> L8
        return;
    }

    private void h() {
        if (e.a() == false) goto L15;
    L10:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpAnrTrace", th);
        return;
    L5:
        if (this.p.compareAndSet(false, true) == true) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L17;
        NativeBridge.k(i.a(this.f7177b).getAbsolutePath());     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    private void i() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpLocaleInfo", th);
        return;
    L3:
        if (this.q.compareAndSet(false, true) == false) goto L11;
        LocaleInfo.dump(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void j() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCustomFilter", th);
        return;
    L3:
        if (this.r.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.g.b(this.f7177b);     // Catch: Throwable -> L6
        com.bytedance.crash.dumper.g.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void k() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpMemoryInfo", th);
        return;
    L3:
        if (this.s.compareAndSet(false, true) == false) goto L11;
        MemoryInfo.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void l() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpScraps", th);
        return;
    L3:
        if (this.t.compareAndSet(false, true) == false) goto L11;
        Scraps.dump(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void m() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpSdkInfo", th);
        return;
    L3:
        if (this.u.compareAndSet(false, true) == false) goto L11;
        q.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void n() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpActivityLifecycle", th);
        return;
    L3:
        if (this.v.compareAndSet(false, true) == false) goto L11;
        ActivityLifecycle.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void o() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpGfxInfo", th);
        return;
    L3:
        if (this.w.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.i.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void p() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpRepairInfo", th);
        return;
    L3:
        if (this.x.compareAndSet(false, true) == false) goto L11;
        p.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void q() {
        if (f7176a == false) goto L13;
    L8:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpViewTree", th);
        return;
    L5:
        if (this.y.compareAndSet(false, true) == false) goto L14;
        s.a(this.f7177b);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    private void r() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCustomData", th);
        return;
    L3:
        if (this.z.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.e.a(this.f7177b, CrashType.ANR, 0);     // Catch: Throwable -> L6
        return;
    }

    private void s() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCustomFile", th);
        return;
    L3:
        if (this.A.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.f.a(this.f7177b, CrashType.ANR);     // Catch: Throwable -> L6
        return;
    }

    private void t() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCustomFile", th);
        return;
    L3:
        if (this.B.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.h.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    }

    private void u() {
        if (this.C.compareAndSet(false, true) == false) goto L9;
        com.bytedance.crash.h.a(this.f7177b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private void v() {
        if (this.D == true) goto L6;
        NativeBridge.b(this.f7180e);
        this.D = true;
        return;
    }

    private void w() {
        if (com.bytedance.crash.monitor.h.a() != null) goto L5;
        return;
    L5:
        com.bytedance.crash.l.a r0 = com.bytedance.crash.monitor.h.a().p();     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.E.compareAndSet(false, true) == false) goto L15;
        r0.a(this.f7177b);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    private static void b(JSONObject r1, JSONObject r2, File r3) {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.crash.l.a r4 = r0.p();
        if (r4 == null) goto L9;
        r4.a(r1, r2, r3);
        return;
    }

    JSONArray a(int r2, int r3) {
        if (e.b() == false) goto L6;
        return null;
    L6:
        c(r3);
        a();
        x();
        d(r2);
        return this.f;
    }

    private void c(int r1) {
        a(r1);
        d();
        f();
        g();
        b(true);
    }

    private void x() {
        c();
        h();
    }

    public void a() {
        if (this.F.compareAndSet(false, true) == false) goto L13;
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();     // Catch: Throwable -> L15
        if (r0 != null) goto L7;
        return;
    L7:
        Iterator<t> r1 = r0.n().e(CrashType.ANR).iterator();     // Catch: Throwable -> L15
    L9:
        if (r1.hasNext() == false) goto L24;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r2.a(CrashType.ANR, this.f7178c);     // Catch: Throwable -> L14
        goto L9
    L24:
        return;
    L13:
        return;
    }

    private void d(int r2) {
        if (e.a() == true) goto L5;
        return;
    L5:
        b(r2);
        t();
        b(false);
        v();
        e();
        k();
        i();
        j();
        l();
        m();
        n();
        o();
        q();
        w();
        u();
        r();
        s();
        p();
    }

    static void a(JSONObject r1, JSONObject r2, File r3) {
        MemoryInfo.a(r1, r3);
        com.bytedance.crash.g.d.a(r1, r3);
        if (r3 == null) goto L5;
        com.bytedance.crash.i.a.a(r1, r3.getParentFile());
    L5:
        q.a(r1, r3);
        com.bytedance.crash.dumper.l.a(r1, r3);
        ActivityLifecycle.a(r1, r3);
        Scraps.pushTo(r1, r3);
        com.bytedance.crash.dumper.e.a(r1, r3);
        b(r1, r2, r3);
    }
}
