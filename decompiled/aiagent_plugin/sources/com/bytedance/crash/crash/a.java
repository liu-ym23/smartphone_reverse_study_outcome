package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.i;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.dumper.l;
import com.bytedance.crash.dumper.p;
import com.bytedance.crash.dumper.q;
import com.bytedance.crash.dumper.s;
import com.bytedance.crash.h;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f7304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CrashType f7306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f7308e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
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

    a(File r5) {
        this.f7308e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
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
        this.f7304a = r5;
        this.f7305b = 0;
        this.f7306c = CrashType.UNKNOWN;
        this.f7307d = 0;
    }

    private void a(int r1) {
        this.f7307d = r1;
    }

    private void a(CrashType r5, long r6) {
        if (r6 == 0) goto L10;
        long r2 = this.f7305b;
        if (r2 != 0) goto L7;
    L8:
        this.f7305b = r6;
        this.f7306c = r5;
        return;
    L7:
        if (r2 > r6) goto L8;
        return;
    }

    File a() {
        return this.f7304a;
    }

    void a(long r2, boolean r4, boolean r5, boolean r6, int r7) {
        a(CrashType.NATIVE, r2);
        a(r7);
        a(r4, r5, r6);
    }

    private long a(long r1) {
        return NativeBridge.a(r1);
    }

    void b() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("NPTH_DUMP", th);
        return;
    L3:
        if (this.f7308e.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.a.a(this.f7304a);     // Catch: Throwable -> L6
        return;
    }

    void c() {
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpCommonParams", th);
        return;
    L3:
        if (this.f.compareAndSet(false, true) == false) goto L11;
        com.bytedance.crash.dumper.d.a(this.f7304a);     // Catch: Throwable -> L6
        return;
    }

    private void a(boolean r1, boolean r2, boolean r3) {
        c();
        f();
        g();
        h();
        i();
        if (r3 == false) goto L5;
        d();
    L5:
        j();
        k();
        if (r1 == false) goto L8;
        l();
    L8:
        m();
        if (r2 == false) goto L11;
        o();
    L11:
        r();
        e();
        p();
        q();
        n();
    }

    void a(CrashType r8, long r9, boolean r11, boolean r12) {
        a(r8, r9);     // Catch: Throwable -> L4
        a(a(r9), true, r11, r12, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.bytedance.crash.c.b.c("NPTH_DUMP", th);
    }

    static void a(JSONObject r0, JSONObject r1, File r2) {
        MemoryInfo.a(r0, r2);
        com.bytedance.crash.g.d.a(r0, r2);
        com.bytedance.crash.i.a.a(r0, r2);
        q.a(r0, r2);
        l.a(r0, r2);
        ActivityLifecycle.a(r0, r2);
        k.b(r0, r2);
        Scraps.pushTo(r0, r2);
        b(r0, r1, r2);
        com.bytedance.crash.dumper.e.a(r0, r2);
    }

    private void f() {
        if (this.g.compareAndSet(false, true) == false) goto L6;
        LocaleInfo.dump(this.f7304a);
        return;
    }

    private void g() {
        if (this.h.compareAndSet(false, true) == false) goto L6;
        com.bytedance.crash.dumper.g.b(this.f7304a);
        com.bytedance.crash.dumper.g.a(this.f7304a);
        return;
    }

    private void h() {
        if (this.i.compareAndSet(false, true) == false) goto L6;
        MemoryInfo.a(this.f7304a);
        return;
    }

    private void i() {
        if (this.j.compareAndSet(false, true) == false) goto L6;
        Scraps.dump(this.f7304a);
        return;
    }

    void d() {
        if (this.k.compareAndSet(false, true) == false) goto L9;
        com.bytedance.crash.g.d.a().a(this.f7304a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private void j() {
        if (this.l.compareAndSet(false, true) == false) goto L6;
        q.a(this.f7304a);
        return;
    }

    private void k() {
        if (this.m.compareAndSet(false, true) == false) goto L6;
        ActivityLifecycle.a(this.f7304a);
        return;
    }

    private void l() {
        if (this.n.compareAndSet(false, true) == false) goto L6;
        k.c(this.f7304a);
        return;
    }

    private void m() {
        if (this.o.compareAndSet(false, true) == false) goto L6;
        i.a(this.f7304a);
        return;
    }

    private void n() {
        if (this.p.compareAndSet(false, true) == false) goto L6;
        p.a(this.f7304a);
        return;
    }

    private void o() {
        if (this.q.compareAndSet(false, true) == false) goto L6;
        s.a(this.f7304a);
        return;
    }

    void e() {
        if (this.r.compareAndSet(false, true) == false) goto L6;
        com.bytedance.crash.dumper.e.a(this.f7304a, this.f7306c, this.f7307d);
        return;
    }

    private void p() {
        if (this.s.compareAndSet(false, true) == false) goto L6;
        com.bytedance.crash.dumper.f.a(this.f7304a, this.f7306c);
        return;
    }

    private void q() {
        if (this.t.compareAndSet(false, true) == false) goto L6;
        h.a(this.f7304a);
        return;
    }

    private void r() {
        if (com.bytedance.crash.monitor.h.a() != null) goto L5;
        return;
    L5:
        com.bytedance.crash.l.a r0 = com.bytedance.crash.monitor.h.a().p();
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.u.compareAndSet(false, true) == false) goto L12;
        r0.a(this.f7304a);
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
}
