package com.bytedance.monitor.collector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import g5.b;
import g5.d;
import g5.e;
import g5.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class PerfMonitorManager {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static ISoLoader f7819s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile boolean f7820t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile PerfMonitorManager f7821u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f7824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f7825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f7826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f7827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f7828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f7829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BinderMonitor f7832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f7833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f7834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LooperDispatchMonitor f7835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IHyperMonitor f7836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IProfilerMonitor f7837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f7838q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d2.d f7839r;

    public interface ISoLoader {
        void loadLibrary(String r10);
    }

    public class a implements IActivityLifeObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PerfMonitorManager f7840a;

        public a(PerfMonitorManager r10) {
            this.f7840a = r10;
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r10) {
            this.f7840a.E();
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r10) {
            this.f7840a.C();
        }
    }

    static {
    }

    public PerfMonitorManager() {
        this.f7823b = false;
        this.f7824c = false;
        this.f7825d = false;
        this.f7826e = false;
        this.f7827f = false;
        this.f7828g = false;
        this.f7829h = false;
        this.f7830i = false;
        this.f7822a = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new a(this));
    }

    public static PerfMonitorManager o() {
        if (f7821u != null) goto L16;
        monitor-enter(PerfMonitorManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7821u != null) goto L11;
        f7821u = new PerfMonitorManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PerfMonitorManager.class);     // Catch: Throwable -> L9
    L16:
        return f7821u;
    }

    public static boolean u() {
        return f7820t;
    }

    public static synchronized boolean v(Context r10) {
        monitor-enter(PerfMonitorManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f7820t == true) goto L13;
        ISoLoader r11 = f7819s;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.loadLibrary("monitorcollector-lib");     // Catch: Throwable -> L9
        f7820t = true;     // Catch: Throwable -> L9
    L12:
        ByteHook.init();     // Catch: Throwable -> L9
        goto L13
    L11:
        f7820t = j5.b.c(r10, "monitorcollector-lib");     // Catch: Throwable -> L9
    L13:
        boolean r12 = f7820t;     // Catch: Throwable -> L9
        monitor-exit(PerfMonitorManager.class);
        return r12;
    }

    public void A() {
        int r10 = 0;
    L4:
        if (r10 >= this.f7822a.size()) goto L6;
        ((AbsMonitor) this.f7822a.get(r10)).d();
        r10 = r10 + 1;
        goto L4
    L6:
        this.f7824c = true;
    }

    public synchronized void B(long r10, boolean r11) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (f7820t == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r10, r11);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public void C() {
        if (this.f7837p != null) goto L5;
        return;
    L5:
        if (this.f7828g == false) goto L9;
        this.f7837p.start();
        return;
    }

    public void D() {
        int r10 = 0;
    L4:
        if (r10 >= this.f7822a.size()) goto L6;
        ((AbsMonitor) this.f7822a.get(r10)).e();
        r10 = r10 + 1;
        goto L4
    L6:
        this.f7824c = false;
    }

    public void E() {
        if (this.f7837p != null) goto L5;
        return;
    L5:
        if (this.f7828g == false) goto L9;
        this.f7837p.stop();
        return;
    }

    public synchronized boolean F(d r10) {
        monitor-enter(this);
        this.f7838q = r10;     // Catch: Throwable -> L6
        if (c.B() == false) goto L10;
        Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + r10);     // Catch: Throwable -> L6
        b(true);     // Catch: Throwable -> L6
    L10:
        if (u() == true) goto L13;
        monitor-exit(this);
        return false;
    L13:
        this.f7828g = r10.f();     // Catch: Throwable -> L6
        IProfilerMonitor r11 = this.f7837p;     // Catch: Throwable -> L6
        if (r11 == null) goto L23;
        if (this.f7827f == false) goto L18;
    L20:
        boolean r12 = false;
    L21:
        r11.enableEvilMethodCollect(r12);     // Catch: Throwable -> L6
        goto L23
    L18:
        if (this.f7828g == false) goto L20;
        r12 = true;
    L23:
        if (this.f7833l != null) goto L26;
        this.f7833l = new e(r10.b());     // Catch: Throwable -> L6
    L26:
        if (r10.d() == false) goto L32;
        if (this.f7832k != null) goto L30;
        this.f7832k = new BinderMonitor(r10.b());     // Catch: Throwable -> L6
    L30:
        this.f7832k.j();     // Catch: Throwable -> L6
    L32:
        if (r10.c() == false) goto L38;
        if (this.f7834m != null) goto L36;
        this.f7834m = new b(r10.b());     // Catch: Throwable -> L6
    L36:
        this.f7834m.i(r10.a());     // Catch: Throwable -> L6
    L38:
        if (r10.e() == true) goto L40;
    L42:
        monitor-exit(this);
        return true;
    L40:
        if (this.f7835n != null) goto L42;
        this.f7835n = new LooperDispatchMonitor(r10.b(), false);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void a(AbsMonitor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f7822a.contains(r10) == true) goto L10;
        this.f7822a.add(r10);
        if (this.f7824c == false) goto L11;
        r10.d();
        return;
    L11:
        return;
    }

    public void b(boolean r10) {
        if (f7820t == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r10);     // Catch: Throwable -> L7
        return;
    }

    public long c() {
        if (this.f7831j == true) goto L7;
        return com.bytedance.apm.util.b.a();
    L7:
        if (u() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    public List d() {
        BinderMonitor r10 = this.f7832k;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.k();
    }

    public JSONObject e() {
        JSONObject r10 = new JSONObject();
        int r11 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r10;
    L4:
        if (r11 >= this.f7822a.size()) goto L9;
        Pair r12 = ((AbsMonitor) this.f7822a.get(r11)).a();     // Catch: Exception -> L7
        r10.put((String) r12.first, r12.second);     // Catch: Exception -> L7
        r11 = r11 + 1;
        goto L10
    }

    public JSONObject f(long r10, long r11) {
        return g(r10, r11, false);
    }

    public JSONObject g(long r10, long r11, boolean r12) {
        JSONObject r13 = new JSONObject();
        int r14 = 0;
    L4:
        if (r14 >= this.f7822a.size()) goto L12;
        AbsMonitor r15 = (AbsMonitor) this.f7822a.get(r14);     // Catch: Exception -> L13
        if (r12 == true) goto L8;
    L10:
        Pair r16 = r15.b(r10, r11);     // Catch: Exception -> L13
        r13.put((String) r16.first, r16.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r15 instanceof LooperDispatchMonitor) == false) goto L10;
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        return r13;
    }

    public String h(int r10) {
        return MonitorJni.doDumpNativeStack(r10);
    }

    public String i(long r10, long r11) {
        if (this.f7837p != null) goto L5;
        return null;
    L5:
        if (this.f7827f == false) goto L8;
        return null;
    L8:
        return f.b(this.f7837p.dumpStack(r10, r11));
    }

    public String j(long r10, long r11) {
        if (this.f7837p != null) goto L5;
        return null;
    L5:
        if (this.f7827f == false) goto L8;
        return null;
    L8:
        return this.f7837p.dumpStack(r10, r11);
    }

    public ThreadStatInfo k(int r10, int r11) {
        return MonitorJni.getThreadStatInfo(r10, r11);
    }

    public long l(int r10) {
        if (this.f7831j == true) goto L7;
        return com.bytedance.apm.util.b.i();
    L7:
        if (u() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r10);
    L11:
        return 0;
    }

    public synchronized void m() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (f7820t == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public LooperDispatchMonitor.FrameCallback n() {
        LooperDispatchMonitor r10 = this.f7835n;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.f7738f;
    }

    public LooperDispatchMonitor.h p() {
        LooperDispatchMonitor r10 = this.f7835n;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.E();
    }

    public IHyperMonitor.ILogInstance q() {
        IHyperMonitor r10 = this.f7836o;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getLogInstance();
    }

    public int r(int r10) {
        return MonitorJni.getProcCGroup(r10);
    }

    public d2.d s() {
        return this.f7839r;
    }

    public synchronized void t(Context r10, d r11) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f7823b == false) goto L14;
        if (c.B() == false) goto L10;
        Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + r11, new Throwable());     // Catch: Throwable -> L8
    L10:
        F(r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        if (v(r10) == false) goto L16;
        e.i();     // Catch: Throwable -> L8
        F(r11);     // Catch: Throwable -> L8
        this.f7823b = true;     // Catch: Throwable -> L8
    L16:
        monitor-exit(this);
    }

    public void w() {
        this.f7826e = true;
    }

    public void x(int r10) {
        if (this.f7826e == false) goto L10;
        Iterator r11 = this.f7822a.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        AbsMonitor r12 = (AbsMonitor) r11.next();
        if (r12 == null) goto L6;
        r12.c(r10);
        goto L6
    L16:
        return;
    }

    public void y(boolean r10) {
        this.f7831j = r10;
    }

    public void z(boolean r10) {
        this.f7827f = r10;
    }
}
