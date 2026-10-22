package g1;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.block.trace.BeatLifecycle;
import com.bytedance.apm.block.trace.JankTracer;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.ILifecycle;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d implements BeatLifecycle, ILifecycle {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f19807w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f19808x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static com.bytedance.apm.block.a f19809y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1.c f19811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f19812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f19813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f19818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object[] f19819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f19820k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Method f19821l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Choreographer f19822m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19823n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d2.c f19824o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f19825p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d2.d f19826q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap f19827r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f19828s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19829t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19830u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19831v;

    public class a extends g5.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f19832d;

        public a(d r10) {
            this.f19832d = r10;
        }

        @Override // g5.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            d.i(this.f19832d);
        }

        @Override // g5.a
        public void c(String r10) {
            super.c(r10);
            d.b(this.f19832d, r10);
        }

        @Override // g5.a
        public boolean d() {
            return d.a(this.f19832d);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19833a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f19834a;

            public a(b r10) {
                this.f19834a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19834a.f19833a.z();     // Catch: Throwable -> L4
                return;
            }
        }

        public b(d r10) {
            this.f19833a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d r10 = this.f19833a;     // Catch: Exception -> L6
            r10.f19825p = new a(this);     // Catch: Exception -> L6
            d r11 = this.f19833a;     // Catch: Exception -> L6
            d.l(r11, d.n(r11, d.m(r11), "mLock"));     // Catch: Exception -> L6
            if (d.k(this.f19833a) != null) goto L8;
            d r12 = this.f19833a;     // Catch: Exception -> L6
            d.l(r12, d.o(r12, d.m(r12), "mLock"));     // Catch: Exception -> L6
        L8:
            d r13 = this.f19833a;     // Catch: Exception -> L6
            d.q(r13, (Object[]) d.n(r13, d.m(r13), "mCallbackQueues"));     // Catch: Exception -> L6
            if (d.p(this.f19833a) != null) goto L11;
            d r14 = this.f19833a;     // Catch: Exception -> L6
            d.q(r14, (Object[]) d.o(r14, d.m(r14), "mCallbackQueues"));     // Catch: Exception -> L6
        L11:
            d r15 = this.f19833a;     // Catch: Exception -> L6
            d.s(r15, (long[]) d.o(r15, d.o(r15, d.m(r15), "mFrameInfo"), "frameInfo"));     // Catch: Exception -> L6
            if (d.r(this.f19833a) != null) goto L15;
            i6.a.a("FrameInfoIsNull");     // Catch: Exception -> L6
        L15:
            if (d.k(this.f19833a) != null) goto L18;
            i6.a.a("CallbackQueueLockIsNull");     // Catch: Exception -> L6
        L18:
            if (d.p(this.f19833a) != null) goto L20;
            i6.a.a("callbackQueuesIsNull");     // Catch: Exception -> L6
        L20:
            d r16 = this.f19833a;     // Catch: Exception -> L6
            d.c(r16, d.d(r16, d.p(r16)[0], "addCallbackLocked", new Class[]{Long.TYPE, Object.class, Object.class}));     // Catch: Exception -> L6
            d r17 = this.f19833a;     // Catch: Exception -> L6
            d.e(r17, r17.f19825p);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            i6.a.d(e, "MainThreadMonitor_fullFps");
        }
    }

    public class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f19835b;

        public c(d r10, Window.Callback r11) {
            this.f19835b = r10;
            super(r11);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (d.f(this.f19835b) == true) goto L6;
            this.f19835b.f19811b.a(r10.getEventTime());
        L6:
            return this.f19887a.dispatchKeyEvent(r10);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r10) {
            if (d.f(this.f19835b) == true) goto L6;
            this.f19835b.f19811b.a(r10.getEventTime());
        L6:
            return this.f19887a.dispatchTouchEvent(r10);
        }
    }

    /* JADX INFO: renamed from: g1.d$d, reason: collision with other inner class name */
    public class WindowOnFrameMetricsAvailableListenerC0253d implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f19837b;

        /* JADX INFO: renamed from: g1.d$d$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f19838a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f19839b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f19840c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0253d f19841d;

            public a(WindowOnFrameMetricsAvailableListenerC0253d r10, long r11, long r12, int r13) {
                this.f19841d = r10;
                this.f19838a = r11;
                this.f19839b = r12;
                this.f19840c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19838a == 0) goto L5;
                return;
            L5:
                if (d.h() != null) goto L7;
            L9:
                Iterator r10 = d.j(this.f19841d.f19837b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).d(this.f19841d.f19836a, this.f19839b, this.f19840c);
                goto L11
            L16:
                return;
            L7:
                if (this.f19841d.f19837b.f19831v == false) goto L9;
                d.h().d(this.f19841d.f19836a, this.f19839b, this.f19840c);
            }
        }

        /* JADX INFO: renamed from: g1.d$d$b */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FrameMetrics f19842a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f19843b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0253d f19844c;

            public b(WindowOnFrameMetricsAvailableListenerC0253d r10, FrameMetrics r11, int r12) {
                this.f19844c = r10;
                this.f19842a = r11;
                this.f19843b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19842a.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (d.h() != null) goto L7;
            L9:
                Iterator r10 = d.j(this.f19844c.f19837b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).e(this.f19844c.f19836a, this.f19842a, this.f19843b);
                goto L11
            L16:
                return;
            L7:
                if (this.f19844c.f19837b.f19831v == false) goto L9;
                d.h().e(this.f19844c.f19836a, this.f19842a, this.f19843b);
            }
        }

        public WindowOnFrameMetricsAvailableListenerC0253d(d r10, String r11) {
            this.f19837b = r10;
            this.f19836a = r11;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r12, FrameMetrics r13, int r14) {
            if (d.g(this.f19837b) == false) goto L5;
            long r10 = (((((r13.getMetric(0) + r13.getMetric(1)) + r13.getMetric(2)) + r13.getMetric(3)) + r13.getMetric(4)) + r13.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
            long r11 = r13.getMetric(9);
            this.f19837b.f19824o.b(new a(this, r11, r10, r14));
            return;
        L5:
            FrameMetrics r15 = new FrameMetrics(r13);
            this.f19837b.f19824o.b(new b(this, r15, r14));
        }
    }

    public class e implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f19846b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f19847a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f19848b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f19849c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e f19850d;

            public a(e r10, long r11, long r12, int r13) {
                this.f19850d = r10;
                this.f19847a = r11;
                this.f19848b = r12;
                this.f19849c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19847a == 0) goto L5;
                return;
            L5:
                if (d.h() != null) goto L7;
            L9:
                Iterator r10 = d.j(this.f19850d.f19846b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).d(this.f19850d.f19845a, this.f19848b, this.f19849c);
                goto L11
            L16:
                return;
            L7:
                if (this.f19850d.f19846b.f19831v == false) goto L9;
                d.h().d(this.f19850d.f19845a, this.f19848b, this.f19849c);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FrameMetrics f19851a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f19852b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f19853c;

            public b(e r10, FrameMetrics r11, int r12) {
                this.f19853c = r10;
                this.f19851a = r11;
                this.f19852b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19851a.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (d.h() != null) goto L7;
            L9:
                Iterator r10 = d.j(this.f19853c.f19846b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).e(this.f19853c.f19845a, this.f19851a, this.f19852b);
                goto L11
            L16:
                return;
            L7:
                if (this.f19853c.f19846b.f19831v == false) goto L9;
                d.h().e(this.f19853c.f19845a, this.f19851a, this.f19852b);
            }
        }

        public e(d r10, String r11) {
            this.f19846b = r10;
            this.f19845a = r11;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r12, FrameMetrics r13, int r14) {
            if (d.g(this.f19846b) == false) goto L5;
            long r10 = (((((r13.getMetric(0) + r13.getMetric(1)) + r13.getMetric(2)) + r13.getMetric(3)) + r13.getMetric(4)) + r13.getMetric(5)) / BatteryFactorConfig.WIFI_BPS;
            long r11 = r13.getMetric(9);
            this.f19846b.f19824o.b(new a(this, r11, r10, r14));
            return;
        L5:
            FrameMetrics r15 = new FrameMetrics(r13);
            this.f19846b.f19824o.b(new b(this, r15, r14));
        }
    }

    static {
        f19807w = new d();
    }

    public d() {
        this.f19811b = new g1.c();
        this.f19812c = new long[4];
        this.f19813d = new CopyOnWriteArrayList();
        this.f19814e = false;
        this.f19815f = false;
        this.f19816g = false;
        this.f19817h = false;
        this.f19823n = false;
        this.f19824o = new d2.c(CommonConsts.APM_INNER_LOOPER_COST);
        this.f19826q = new d2.d(CommonConsts.APM_INNER_LOOPER_COST);
        this.f19827r = new HashMap();
        this.f19828s = -1;
    }

    public static d A() {
        return f19807w;
    }

    public static Method H(Class r10, String r11, Class... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    public static /* synthetic */ boolean a(d r10) {
        return r10.f19810a;
    }

    public static /* synthetic */ void b(d r10, String r11) {
        r10.v(r11);
    }

    public static /* synthetic */ Method c(d r10, Method r11) {
        r10.f19821l = r11;
        return r11;
    }

    public static /* synthetic */ Method d(d r10, Object r11, String r12, Class[] r13) {
        return r10.G(r11, r12, r13);
    }

    public static /* synthetic */ void e(d r10, Runnable r11) {
        r10.t(r11);
    }

    public static /* synthetic */ boolean f(d r10) {
        return r10.f19817h;
    }

    public static /* synthetic */ boolean g(d r10) {
        return r10.f19830u;
    }

    public static /* synthetic */ com.bytedance.apm.block.a h() {
        return f19809y;
    }

    public static /* synthetic */ void i(d r10) {
        r10.w();
    }

    public static /* synthetic */ List j(d r10) {
        return r10.f19813d;
    }

    public static /* synthetic */ Object k(d r10) {
        return r10.f19818i;
    }

    public static /* synthetic */ Object l(d r10, Object r11) {
        r10.f19818i = r11;
        return r11;
    }

    public static /* synthetic */ Choreographer m(d r10) {
        return r10.f19822m;
    }

    public static /* synthetic */ Object n(d r10, Object r11, String r12) {
        return r10.J(r11, r12);
    }

    public static /* synthetic */ Object o(d r10, Object r11, String r12) {
        return r10.I(r11, r12);
    }

    public static /* synthetic */ Object[] p(d r10) {
        return r10.f19819j;
    }

    public static /* synthetic */ Object[] q(d r10, Object[] r11) {
        r10.f19819j = r11;
        return r11;
    }

    public static /* synthetic */ long[] r(d r10) {
        return r10.f19820k;
    }

    public static /* synthetic */ long[] s(d r10, long[] r11) {
        r10.f19820k = r11;
        return r11;
    }

    public int B() {
        int r10 = this.f19813d.size();
        boolean r11 = b2.b.e("block_monitor");
        if (D() == false) goto L7;
        if (r11 == false) goto L6;
        return r10;
    L6:
        return r10 - 1;
    L7:
        return r10;
    }

    public void C() {
        if (this.f19829t == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        LooperMonitor.h();
        LooperMonitor.l(new a(this));
        this.f19829t = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    public boolean D() {
        return f19808x;
    }

    public boolean E() {
        return this.f19831v;
    }

    public final boolean F() {
        return false;
    }

    public final Method G(Object r10, String r11, Class... r12) {
        Method r13 = r10.getClass().getDeclaredMethod(r11, r12);     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    public final Object I(Object r10, String r11) {
        Field r12 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10.getClass(), new Object[]{r11});     // Catch: Exception -> L4
        r12.setAccessible(true);     // Catch: Exception -> L4
        return r12.get(r10);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final Object J(Object r10, String r11) {
        Field r12 = r10.getClass().getDeclaredField(r11);     // Catch: Exception -> L4
        r12.setAccessible(true);     // Catch: Exception -> L4
        return r12.get(r10);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void K(com.bytedance.apm.block.a r10) {
        this.f19813d.remove(r10);
        if (this.f19831v == false) goto L10;
        if (B() == 0) goto L7;
        return;
    L7:
        if (LooperMonitor.g() != 0) goto L14;
        LooperMonitor.a();
        return;
    L14:
        return;
    L10:
        if (this.f19813d.isEmpty() == false) goto L16;
        onStop();
        return;
    }

    public void L() {
        f19808x = true;
    }

    public void M(boolean r10) {
        this.f19830u = r10;
    }

    public void N(boolean r10) {
        this.f19831v = r10;
    }

    public void O(boolean r10) {
        this.f19814e = r10;
    }

    public void P(com.bytedance.apm.block.a r10) {
        f19809y = r10;
    }

    public void Q(boolean r10) {
        this.f19815f = r10;
    }

    public void R() {
        this.f19824o.c();
        this.f19826q.k();
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public boolean isAlive() {
        return this.f19810a;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityCreated(Activity r10, Bundle r11) {
        Window r12 = r10.getWindow();     // Catch: Exception -> L9
        r12.setCallback(new c(this, r12.getCallback()));     // Catch: Exception -> L9
        String r13 = r10.getClass().getName();     // Catch: Exception -> L9
        String r14 = r10.toString();     // Catch: Exception -> L9
        LooperMonitor.c();     // Catch: Exception -> L9
        if (this.f19814e == false) goto L6;
        return;
    L6:
        if (this.f19826q.e() == false) goto L12;
        WindowOnFrameMetricsAvailableListenerC0253d r15 = new WindowOnFrameMetricsAvailableListenerC0253d(this, r13);     // Catch: Exception -> L9
        this.f19827r.put(r14, r15);     // Catch: Exception -> L9
        r12.addOnFrameMetricsAvailableListener(r15, this.f19826q.f19037d);     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityDestroyed(Activity r10) {
        Window.OnFrameMetricsAvailableListener r11 = (Window.OnFrameMetricsAvailableListener) this.f19827r.remove(r10.toString());     // Catch: Exception -> L6
        if (r11 == null) goto L9;
        r10.getWindow().removeOnFrameMetricsAvailableListener(r11);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityResumed(Activity r10) {
        if (this.f19814e == true) goto L15;
        return;
    L15:
        Window r11 = r10.getWindow();     // Catch: Exception -> L14
        String r12 = r10.getClass().getName();     // Catch: Exception -> L14
        String r13 = r10.toString();     // Catch: Exception -> L14
        HashMap r14 = this.f19827r;     // Catch: Exception -> L14
        if (r14 == null) goto L11;
        if (r14.containsKey(r13) == false) goto L11;
        return;
    L11:
        if (this.f19826q.e() == false) goto L17;
        e r15 = new e(this, r12);     // Catch: Exception -> L14
        this.f19827r.put(r13, r15);     // Catch: Exception -> L14
        r11.addOnFrameMetricsAvailableListener(r15, this.f19826q.f19037d);     // Catch: Exception -> L14
        return;
    L17:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onBackground(Activity r10) {
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onFront(Activity r10) {
        if (this.f19822m == null) goto L6;
        return;
    L6:
        if (F() == false) goto L13;
        this.f19822m = Choreographer.getInstance();     // Catch: Exception -> L10
    L8:
        AsyncEventManager.e().h(new b(this));
        return;
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStart() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (w0.c.G() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f19829t == false) goto L20;
        if (this.f19810a == true) goto L15;
        this.f19810a = true;     // Catch: Throwable -> L12
    L15:
        if (F() == false) goto L17;
        t(this.f19825p);     // Catch: Throwable -> L12
    L17:
        monitor-exit(this);
        return;
    L20:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L12
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStop() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (w0.c.F() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f19829t == false) goto L18;
        if (this.f19810a == false) goto L15;
        this.f19810a = false;     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L18:
        throw new RuntimeException("MainThreadMonitor is never init!");     // Catch: Throwable -> L13
    }

    public final synchronized void t(Runnable r10) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f19810a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f19823n == false) goto L33;
        monitor-exit(this);
        return;
    L33:
        Object r11 = this.f19818i;     // Catch: Throwable -> L22 Exception -> L28
        monitor-enter(r11);     // Catch: Throwable -> L22 Exception -> L28
        Method r12 = this.f19821l;     // Catch: Throwable -> L16
        if (r12 == null) goto L18;
        r12.invoke(this.f19819j[0], new Object[]{-1L, r10, null});     // Catch: Throwable -> L16
        this.f19823n = true;     // Catch: Throwable -> L16
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22 Exception -> L28
    L24:
        monitor-exit(this);
    }

    public void u(com.bytedance.apm.block.a r10) {
        if (this.f19810a == true) goto L6;
        onStart();
    L6:
        if (this.f19813d.contains(r10) == true) goto L11;
        this.f19813d.add(r10);
        if (this.f19831v == false) goto L12;
        LooperMonitor.n();
        return;
    L12:
        return;
    }

    public final void v(String r10) {
        this.f19817h = true;
        long[] r11 = this.f19812c;
        int r12 = 0;
        r11[0] = g5.a.f19916b;
        r11[2] = g5.a.f19917c;
        List r13 = this.f19813d;
        int r14 = r13.size();
    L3:
        if (r12 >= r14) goto L8;
        com.bytedance.apm.block.a r15 = (com.bytedance.apm.block.a) r13.get(r12);
        if (r15.c() == true) goto L7;
        r15.a(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        boolean r11 = this.f19816g;
        if (F() == true) goto L5;
    L12:
        long[] r10 = this.f19812c;
        char r12 = 1;
        r10[1] = g5.a.f19916b;
        r10[3] = g5.a.f19917c;
        List r14 = this.f19813d;
        int r15 = r14.size();
        char r13 = 0;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L19;
        com.bytedance.apm.block.a r17 = (com.bytedance.apm.block.a) r14.get(r16);
        if (r17.c() == false) goto L18;
        long[] r18 = this.f19812c;
        r17.b(r18[r13], r18[2], r18[r12], r18[3], r11);
    L18:
        r16 = r16 + 1;
        r13 = r13;
        r12 = 1;
        goto L13
    L19:
        this.f19811b.c();
        this.f19817h = r13;
        return;
    L5:
        if (this.f19816g == false) goto L12;
        y();
        long r19 = g5.a.f19916b;
        if (this.f19820k == null) goto L12;
        if (PerfMonitorManager.o().n() == null) goto L11;
        PerfMonitorManager.o().n().doFrame(this.f19820k);
    L11:
        JankTracer.c().b(this.f19820k, r19);
        goto L12
    }

    public final void x() {
        this.f19816g = true;
    }

    public final void y() {
        t(this.f19825p);
        this.f19816g = false;
    }

    public void z() {
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L6
        long[] r11 = this.f19820k;     // Catch: Throwable -> L6
        if (r11 != null) goto L9;
        this.f19828s = g5.a.f19916b;     // Catch: Throwable -> L6
    L12:
        x();     // Catch: Throwable -> L6
        this.f19823n = false;
        return;
    L9:
        if (r10 < 31) goto L11;
        this.f19828s = r11[2] / BatteryFactorConfig.WIFI_BPS;     // Catch: Throwable -> L6
        goto L12
    L11:
        this.f19828s = r11[1] / BatteryFactorConfig.WIFI_BPS;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        this.f19823n = false;
        throw th;
    }
}
