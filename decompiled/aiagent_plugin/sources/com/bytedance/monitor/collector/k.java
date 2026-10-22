package com.bytedance.monitor.collector;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfMonitorManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile boolean f9012a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f9013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile k f9014d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ThreadWithHandler f9015b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<b> f9016e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private boolean m;
    private boolean n;
    private BinderMonitor o;
    private l p;
    private c q;
    private g r;
    private d s;
    private e t;
    private j u;

    /* JADX INFO: compiled from: PerfMonitorManager.java */
    public interface a {
        void a(String r1);
    }

    static {
    }

    public void a(boolean r1) {
        this.n = r1;
    }

    public static k a() {
        if (f9014d != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9014d != null) goto L9;
        f9014d = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f9014d;
    }

    public static boolean b() {
        return f9012a;
    }

    public static synchronized boolean a(Context r3) {
        monitor-enter(k.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (f9012a == true) goto L11;
        a r1 = f9013c;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.a("monitorcollector-lib");     // Catch: Throwable -> L14
        f9012a = true;     // Catch: Throwable -> L14
    L10:
        ByteHook.init();     // Catch: Throwable -> L14
        goto L11
    L9:
        f9012a = com.bytedance.monitor.a.a.b.a(r4, "monitorcollector-lib");     // Catch: Throwable -> L14
    L11:
        boolean r5 = f9012a;     // Catch: Throwable -> L14
        monitor-exit(k.class);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean c() {
        return this.f;
    }

    public synchronized void a(Context r3, j r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (this.f == false) goto L12;
        if (com.bytedance.apm.c.i() == false) goto L8;
        a("PerfMonitorManager", "PerfMonitorManager init twice? " + r4, new Throwable());     // Catch: Throwable -> L16
    L8:
        a(r4);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L12:
        if (a(r5) == false) goto L14;
        l.d();     // Catch: Throwable -> L16
        a(r4);     // Catch: Throwable -> L16
        this.f = true;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(j r6) {
        monitor-enter(this);
        this.u = r6;     // Catch: Throwable -> L42
        if (com.bytedance.apm.c.i() == false) goto L8;
        a("PerfMonitorManager", "PerfMonitorManager update config:\n " + r6);     // Catch: Throwable -> L42
        c(true);     // Catch: Throwable -> L42
    L8:
        if (b() == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        this.k = r6.d();     // Catch: Throwable -> L42
        e r0 = this.t;     // Catch: Throwable -> L42
        if (r0 == null) goto L21;
        if (this.j == false) goto L16;
    L18:
        boolean r3 = false;
    L19:
        r0.a(r3);     // Catch: Throwable -> L42
        goto L21
    L16:
        if (this.k == false) goto L18;
        r3 = true;
    L21:
        if (this.p != null) goto L24;
        this.p = new l(r6.f());     // Catch: Throwable -> L42
    L24:
        if (r6.b() == false) goto L30;
        if (this.o != null) goto L28;
        this.o = new BinderMonitor(r6.f());     // Catch: Throwable -> L42
    L28:
        this.o.d();     // Catch: Throwable -> L42
    L30:
        if (r6.a() == false) goto L36;
        if (this.q != null) goto L34;
        this.q = new c(r6.f());     // Catch: Throwable -> L42
    L34:
        this.q.a(r6.e());     // Catch: Throwable -> L42
    L36:
        if (r6.c() == true) goto L38;
    L40:
        monitor-exit(this);
        return true;
    L38:
        if (this.r != null) goto L40;
        this.r = new g(r6.f(), false);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public void a(int r4) {
        if (this.i == false) goto L10;
        Iterator<b> r3 = this.f9016e.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.a(r4);
        goto L6
    L16:
        return;
    }

    public void d() {
        this.i = true;
    }

    private k() {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.f9016e = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1(this));
    }

    public void a(b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.f9016e.contains(r2) == true) goto L10;
        this.f9016e.add(r2);
        if (this.g == false) goto L11;
        r2.a();
        return;
    L11:
        return;
    }

    public d.a e() {
        d r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public void f() {
        if (this.t != null) goto L5;
        return;
    L5:
        if (this.k == false) goto L9;
        this.t.a();
        return;
    }

    public void g() {
        if (this.t != null) goto L5;
        return;
    L5:
        if (this.k == false) goto L9;
        this.t.b();
        return;
    }

    public void b(boolean r1) {
        this.j = r1;
    }

    public void h() {
        int r0 = 0;
    L4:
        if (r0 >= this.f9016e.size()) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(this.f9016e.get(r0), b.class, "com.obric.aiagent.plugin")).a();
        r0 = r0 + 1;
        goto L4
    L6:
        this.g = true;
    }

    void c(boolean r1) {
        if (f9012a == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r1);     // Catch: Throwable -> L7
        return;
    }

    public ThreadWithHandler i() {
        return this.f9015b;
    }

    public synchronized void a(long r2, boolean r4) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (f9012a == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r2, r4);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void j() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (f9012a == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public List<BinderMonitor.a> k() {
        BinderMonitor r0 = this.o;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.e();
    }

    public JSONObject l() {
        JSONObject r1 = new JSONObject();
        int r2 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r1;
    L4:
        if (r2 >= this.f9016e.size()) goto L9;
        Pair<String, ?> r3 = ((b) ZeusTransformUtils.preCheckCast(this.f9016e.get(r2), b.class, "com.obric.aiagent.plugin")).c();     // Catch: Exception -> L7
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.aiagent.plugin"), r3.second);     // Catch: Exception -> L7
        r2 = r2 + 1;
        goto L10
    }

    public JSONObject a(long r7, long r9, boolean r11) {
        JSONObject r1 = new JSONObject();
        int r2 = 0;
    L4:
        if (r2 >= this.f9016e.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f9016e.get(r2), b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        if (r11 == true) goto L8;
    L10:
        Pair<String, ?> r4 = r3.a(r7, r9);     // Catch: Exception -> L13
        r1.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin"), r4.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L10;
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        return r1;
    }

    public JSONObject a(long r7, long r9) {
        return a(r7, r9, false);
    }

    public long b(int r3) {
        if (this.n == true) goto L7;
        return com.bytedance.apm.util.b.a();
    L7:
        if (b() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r3);
    L11:
        return 0;
    }

    public long m() {
        if (this.n == true) goto L7;
        return com.bytedance.apm.util.b.c();
    L7:
        if (b() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    public ThreadStatInfo a(int r1, int r2) {
        return MonitorJni.getThreadStatInfo(r1, r2);
    }

    public int c(int r1) {
        return MonitorJni.getProcCGroup(r1);
    }

    public String b(long r2, long r4) {
        if (this.t != null) goto L5;
        return null;
    L5:
        if (this.j == false) goto L8;
        return null;
    L8:
        return this.t.a(r2, r4);
    }

    public String d(int r1) {
        return MonitorJni.doDumpNativeStack(r1);
    }

    public g.c n() {
        g r0 = this.r;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.f;
    }

    public g.e o() {
        g r0 = this.r;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
