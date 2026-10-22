package com.bytedance.crash.anr;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.j;
import com.bytedance.crash.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: AnrManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f7209b = null;
    private static long h = 0;
    private static boolean i = true;
    private static boolean j = false;
    private static volatile boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final File f7210a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f7211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f7212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnrInfoMonitor f7213e;
    private final f f;
    private boolean g;
    private long l;

    static {
    }

    /* synthetic */ e(Context r2, File r3, AnonymousClass1 r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ e a(e r0) {
        f7209b = r0;
        return r0;
    }

    static /* synthetic */ void a(e r0, h r1, com.bytedance.crash.monitor.a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void b(e r0) {
        r0.h();
    }

    static /* synthetic */ AnrInfoMonitor c(e r0) {
        return r0.f7213e;
    }

    static /* synthetic */ e f() {
        return f7209b;
    }

    private File[] g() {
        return this.f7210a.listFiles(new AnonymousClass1(this));
    }

    private File[] a(File r2) {
        return r2.listFiles(new AnonymousClass2(this));
    }

    public static void a(boolean r0) {
        k = r0;
    }

    private void h() {
        if (this.g == true) goto L8;
        this.g = true;
        this.f7212d.a();
        this.f7213e.a();
        this.f.a();
        if (j.c() == false) goto L9;
        com.bytedance.crash.g.d.a().b();
        return;
    L9:
        return;
    }

    private void i() {
        if (this.g == false) goto L6;
        this.g = false;
        this.f7212d.b();
        this.f7213e.b();
        this.f.c();
        com.bytedance.crash.g.d.a().c();
        return;
    }

    public static void a(File r1, long r2) {
        if (d() == false) goto L8;
        f r0 = f7209b.f;
        if (r0 == null) goto L9;
        r0.a(r1, r2);
        return;
    L9:
        return;
    }

    public static void b(boolean r0) {
        i = !r0;
    }

    public static void c(boolean r0) {
        j = r0;
    }

    public static boolean a() {
        return i;
    }

    public static boolean b() {
        if (j == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.crash.i.b() == true) goto L8;
        return false;
    }

    private e(Context r3, File r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.g = false;
        this.l = 0;
        this.f7212d = new g();
        File r6 = com.bytedance.crash.o.i.a(r4, "anr");
        this.f7210a = r6;
        this.f7213e = new AnrInfoMonitor(r5, r6);
        this.f = new f();
    }

    public static synchronized void a(Context r3, final File r4) {
        monitor-enter(e.class);
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        DefaultWorkThread.post(new AnonymousClass3(r5, r4));     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        e r0 = f7209b;
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    public static boolean d() {
        e r0 = f7209b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.g == false) goto L7;
        return true;
    }

    public static void a(final String r2, r r3) {
        final r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        DefaultWorkThread.post(new AnonymousClass4(r2, r4));
    }

    public static void a(int r8, int r9) {
        if (d() == false) goto L19;
        e();
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (j.b() == false) goto L8;
        f7209b.a(r2, r8, r9);     // Catch: Throwable -> L12
    L15:
        return;
    L8:
        e r1 = f7209b;     // Catch: Throwable -> L12
        if ((r2 - r1.l) < 5000) goto L15;
        r1.l = r2;     // Catch: Throwable -> L12
        r1.a(r2, true, null, r8, r9);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        a.a(th);
        return;
    }

    public static void a(long r8, File r10) {
        if (d() == false) goto L11;
        f7209b.a(r8, false, r10, 0, 1000);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a.a(th);
        return;
    }

    private void a(long r8, boolean r10, File r11, int r12, int r13) {
        c r0 = a(r8, r10);
        if (r0 == null) goto L6;
        r0.a(r8, r10, r11, r12, r13);
        return;
    }

    private synchronized c a(long r3, boolean r5) {
        monitor-enter(this);
        c r0 = this.f7211c;     // Catch: Throwable -> L14
        if (r0 != null) goto L7;
        this.f7211c = c.a(this.f7213e, this.f7210a, r3, r5);     // Catch: Throwable -> L14
    L11:
        c r4 = this.f7211c;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L7:
        if (r0.a(r5) == false) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void b(c r3) {
        monitor-enter(this);
        e r0 = f7209b;     // Catch: Throwable -> L8
        if (r0.f7211c != r3) goto L6;
        r0.f7211c = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static void a(c r1) {
        e r0 = f7209b;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    private void a(File[] r9, com.bytedance.crash.monitor.a r10) {
        int r0 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        File r2 = r9[r1];
        h r3 = h.a(r2);
        if (r3 != null) goto L7;
        com.bytedance.crash.o.i.c(r2);
        a.a(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        com.bytedance.crash.n.d.a(CrashType.ANR, r3.getProcessName(), r3.getPid(), r3.getCrashTime());
        a(r3, r10);
        goto L8
    }

    private void a(File[] r10, final com.bytedance.crash.monitor.a r11, long r12) {
        final ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        File r3 = r10[r2];
        h r4 = h.a(r3);
        if (r4 != null) goto L7;
        com.bytedance.crash.o.i.c(r3);
        a.a(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L11:
        r2 = r2 + 1;
        goto L3
    L7:
        com.bytedance.crash.n.d.a(CrashType.ANR, r4.getProcessName(), r4.getPid(), r4.getCrashTime());
        if ((r4.getCrashTime() - r4.getStartTime()) > com.bytedance.crash.config.h.b()) goto L10;
        a(r4, r11);
        goto L11
    L10:
        r0.add(r4);
        goto L11
    L13:
        if (r0.isEmpty() == true) goto L20;
        DefaultWorkThread.postDelayed(new AnonymousClass5(this, r0, r11), r12);
        return;
    }

    private void a(h r1, com.bytedance.crash.monitor.a r2) {
        r1.upload(r2, null);
    }

    private void b(com.bytedance.crash.monitor.a r19, long r20) {
        this.f7213e.a(this.f7210a);     // Catch: Exception -> L5
    L7:
        File[] r0 = g();
        int r5 = r0.length;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L32;
        File r8 = r0[r7];
        String[] r11 = r8.getName().split("-");     // Catch: Throwable -> L17
        if (r11.length != 2) goto L16;
        long r12 = Long.parseLong(r11[0]);     // Catch: Throwable -> L17
        long r14 = Integer.parseInt(r11[1]);     // Catch: Throwable -> L33
    L20:
        if (r12 == com.bytedance.crash.i.f()) goto L22;
    L24:
        File[] r13 = a(r8);
        if (r20 <= 0) goto L27;
        a(r13, r19, r20);
    L29:
        if (a(r8).length != 0) goto L31;
        com.bytedance.crash.o.i.c(r8);
    L31:
        r7 = r7 + 1;
        goto L8
    L27:
        a(r13, r19);
        goto L29
    L22:
        if (r14 != Process.myPid()) goto L24;
    L18:
        r14 = 0;
        goto L20
    L16:
        r12 = 0;
        r14 = 0;
    L17:
        r12 = 0;
        goto L18
    L32:
        return;
    L5:
        e = move-exception;
        a.a(e);
        goto L7
    }

    public static void a(com.bytedance.crash.monitor.a r1, long r2) {
        e r0 = f7209b;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.b(r1, r2);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR_upload", e);
    }

    public static void e() {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        Iterator<s> r1 = r0.n().m().iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L21;
        ((s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11
        goto L6
    L21:
        return;
    L10:
        return;
    }

    private void a(long r8, int r10, int r11) {
        if (j.a() == true) goto L9;
        if ((r8 - this.l) >= 5000) goto L7;
        return;
    L7:
        this.l = r8;
    L9:
        if (k == true) goto L13;
        if (r10 <= 200) goto L13;
        return;
    L13:
        if (Math.abs(h - r8) >= 120000) goto L15;
        return;
    L15:
        if (a.a() == false) goto L20;
        h = r8;
        f7209b.f7213e.a(r8);
        f7209b.a(r8, true, null, r10, r11);
        return;
    }
}
