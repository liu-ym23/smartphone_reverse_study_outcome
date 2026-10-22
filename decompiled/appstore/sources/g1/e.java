package g1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.perf.collector.TraceDataUtils;
import java.util.LinkedList;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f19854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f19855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f19856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f19857d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long[] f19858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f19859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f19860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f19861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f19862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f19863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Thread f19864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile Runnable f19865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static HandlerThread f19866m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Handler f19867n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Object f19868o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f19869p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Runnable f19870q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static g5.a f19871r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Runnable f19872s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static f f19873t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static f f19874u;

    public static class a extends g5.a {
        public a() {
        }

        @Override // g5.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            e.l();
        }

        @Override // g5.a
        public void c(String r10) {
            super.c(r10);
            e.k();
        }

        @Override // g5.a
        public boolean d() {
            if (e.a() == null) goto L6;
            e.a().run();
            e.b(null);
        L6:
            if (e.c() >= 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        L16:
        L15:
            return;
        L3:
            if (e.m() == true) goto L7;
            if (e.c() <= (-1)) goto L7;
            e.o(e.p() - e.q());     // Catch: InterruptedException -> L15
            e.o(e.n() & 8796093022207L);     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r10 = e.r();     // Catch: InterruptedException -> L15
            monitor-enter(r10);     // Catch: InterruptedException -> L15
            e.r().wait();     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    public static class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.s();
        }
    }

    public static class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d().removeCallbacksAndMessages(null);
            LooperMonitor.p(e.f());
            e.g().quit();
            e.h(null);
        }
    }

    /* JADX INFO: renamed from: g1.e$e, reason: collision with other inner class name */
    public static class RunnableC0254e implements Runnable {
        public RunnableC0254e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = e.i();
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (e.c() != Integer.MAX_VALUE) goto L7;
        L11:
            e.e(-2);     // Catch: Throwable -> L9
            e.j(true);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L7:
            if (e.c() != 1) goto L12;
            goto L12
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f19877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f19878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f19880f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f19881g;

        public f(int r10) {
            this.f19879e = true;
            this.f19875a = r10;
        }

        public static /* synthetic */ f a(f r10) {
            return r10.f19878d;
        }

        public static /* synthetic */ f b(f r10, f r11) {
            r10.f19878d = r11;
            return r11;
        }

        public static /* synthetic */ f c(f r10) {
            return r10.f19877c;
        }

        public static /* synthetic */ f d(f r10, f r11) {
            r10.f19877c = r11;
            return r11;
        }

        public static /* synthetic */ long e(f r10) {
            return r10.f19881g;
        }

        public static /* synthetic */ long f(f r10, long r11) {
            r10.f19881g = r11;
            return r11;
        }

        public String toString() {
            return "index:" + this.f19875a + ",\tisValid:" + this.f19879e + " source:" + this.f19880f;
        }
    }

    static {
        f19854a = new e();
        f19855b = Channel.UNLIMITED;
        f19856c = false;
        Object r10 = new Object();
        f19857d = r10;
        f19858e = null;
        f19859f = 0;
        f19860g = -1;
        f19861h = false;
        f19862i = B();
        f19863j = f19862i;
        f19864k = Looper.getMainLooper().getThread();
        f19865l = null;
        f19866m = F();
        f19867n = new Handler(f19866m.getLooper());
        f19868o = new Object();
        f19869p = false;
        f19870q = null;
        f19871r = new a();
        f19872s = new b();
        f19858e = new long[BlockConstants.BUFFER_SIZE];
        if (f19855b != Integer.MAX_VALUE) goto L14;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (f19855b != Integer.MAX_VALUE) goto L10;
        M();     // Catch: Throwable -> L8
        f19855b = 1;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
    L14:
        G(1048574, 0);
        I("EvilMethodTracer#message_0", g5.a.f19916b);
        f19867n.postDelayed(new c(), TraceStatsConsts.APP_START_MAX_LIMIT_MS);
    }

    public e() {
    }

    public static long B() {
        return SystemClock.uptimeMillis();
    }

    public static long C() {
        return f19863j;
    }

    public static e E() {
        return f19854a;
    }

    public static HandlerThread F() {
        HandlerThread r10 = new HandlerThread("trace_time_update_thread");
        r10.start();
        return r10;
    }

    public static void G(int r10, long r11) {
        if (f19856c == false) goto L6;
        return;
    L6:
        if (r10 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f19864k) goto L11;
        return;
    L11:
        if (f19861h == false) goto L13;
        return;
    L13:
        f19861h = true;
        if (r11 == 0) goto L16;
        f19862i = r11 - f19863j;
        f19862i &= 8796093022207L;
    L16:
        long r12 = ((((long) r10) << 43) | Long.MIN_VALUE) | f19862i;
        long[] r13 = f19858e;
        int r14 = f19859f;
        r13[r14] = r12;
        int r15 = r14 + 1;
        f19859f = r15;
        if (r15 != 600000) goto L19;
        f19859f = 0;
    L19:
        f19861h = false;
        f r16 = f19874u;
        if (r16 != null) goto L23;
        return;
    L23:
        if (r16.f19875a != f19859f) goto L30;
        f r17 = f.a(r16);
        f19874u = r17;
        if (r17 == null) goto L27;
        f.d(r17, null);
        return;
    L27:
        f19873t = null;
        return;
    }

    public static f I(String r10, long r11) {
        if (f19873t != null) goto L9;
        f r12 = new f(f19859f);
        f19873t = r12;
        if (r11 > 0) goto L7;
        r11 = SystemClock.uptimeMillis();
    L7:
        f.f(r12, r11);
        f r13 = f19873t;
        r13.f19880f = r10;
        f19874u = r13;
        return r13;
    L9:
        f r14 = new f(f19859f);
        if (r11 > 0) goto L12;
        r11 = SystemClock.uptimeMillis();
    L12:
        f.f(r14, r11);
        r14.f19880f = r10;
        f.d(r14, f19873t);
        f r15 = f19873t;
        r15.f19876b = r14.f19875a - 1;
        f.b(r15, r14);
        f19873t = r14;
        return r14;
    }

    public static void J(int r10, long r11) {
        if (f19856c == false) goto L6;
        return;
    L6:
        if (r10 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f19864k) goto L11;
        return;
    L11:
        if (r11 == 0) goto L13;
        f19862i = r11 - f19863j;
        f19862i &= 8796093022207L;
    L13:
        long r12 = (((long) r10) << 43) | f19862i;
        long[] r13 = f19858e;
        int r14 = f19859f;
        r13[r14] = r12;
        int r15 = r14 + 1;
        f19859f = r15;
        if (r15 != 600000) goto L16;
        f19859f = 0;
    L16:
        f r16 = f19874u;
        if (r16 != null) goto L19;
        return;
    L19:
        if (r16.f19875a != f19859f) goto L27;
        f r17 = f.a(r16);
        f19874u = r17;
        if (r17 == null) goto L23;
        f.d(r17, null);
        return;
    L23:
        f19873t = null;
        return;
    }

    public static void M() {
        f19862i = B() - f19863j;
        f19867n.removeCallbacksAndMessages(null);
        f19867n.postDelayed(f19872s, 5);
        Handler r10 = f19867n;
        RunnableC0254e r11 = new RunnableC0254e();
        f19870q = r11;
        r10.postDelayed(r11, TraceStatsConsts.APP_START_MAX_LIMIT_MS);
        LooperMonitor.k(f19871r);
    }

    public static void N() {
        Object r10 = f19857d;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f19855b != Integer.MAX_VALUE) goto L7;
    L11:
        f19855b = -3;     // Catch: Throwable -> L9
        f19856c = true;     // Catch: Throwable -> L9
        f19865l = new d();     // Catch: Throwable -> L9
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L7:
        if (f19855b != (-4)) goto L12;
        goto L12
    }

    public static /* synthetic */ Runnable a() {
        return f19865l;
    }

    public static /* synthetic */ Runnable b(Runnable r10) {
        f19865l = r10;
        return r10;
    }

    public static /* synthetic */ int c() {
        return f19855b;
    }

    public static /* synthetic */ Handler d() {
        return f19867n;
    }

    public static /* synthetic */ int e(int r10) {
        f19855b = r10;
        return r10;
    }

    public static /* synthetic */ g5.a f() {
        return f19871r;
    }

    public static /* synthetic */ HandlerThread g() {
        return f19866m;
    }

    public static /* synthetic */ long[] h(long[] r10) {
        f19858e = r10;
        return r10;
    }

    public static /* synthetic */ Object i() {
        return f19857d;
    }

    public static /* synthetic */ boolean j(boolean r10) {
        f19856c = r10;
        return r10;
    }

    public static /* synthetic */ void k() {
        y();
    }

    public static /* synthetic */ void l() {
        z();
    }

    public static /* synthetic */ boolean m() {
        return f19869p;
    }

    public static /* synthetic */ long n() {
        return f19862i;
    }

    public static /* synthetic */ long o(long r10) {
        f19862i = r10;
        return r10;
    }

    public static /* synthetic */ long p() {
        return B();
    }

    public static /* synthetic */ long q() {
        return f19863j;
    }

    public static /* synthetic */ Object r() {
        return f19868o;
    }

    public static /* synthetic */ void s() {
        N();
    }

    public static void y() {
        f19862i = g5.a.f19916b - f19863j;
        f19869p = false;
        Object r10 = f19868o;
        monitor-enter(r10);
        f19868o.notify();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void z() {
        f19869p = true;
    }

    public String A(long[] r10, long r11) {
        if (r10 != null) goto L5;
        return "";
    L5:
        LinkedList r12 = new LinkedList();
        TraceDataUtils.j(r10, r12, true, r11);
        TraceDataUtils.l(r12, 1);
        StringBuilder r13 = new StringBuilder();
        TraceDataUtils.g(r12, r13);
        return r13.toString();
    }

    public String D(long r10, long r11) {
        long r12 = SystemClock.uptimeMillis();
        return A(v(r10, r11), r12);
    }

    public boolean H() {
        if (f19855b < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void K() {
        Object r10 = f19857d;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f19855b < 2) goto L7;
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        if (f19855b < (-2)) goto L15;
        f19867n.removeCallbacks(f19870q);     // Catch: Throwable -> L11
        if (f19858e == null) goto L14;
        f19855b = 2;     // Catch: Throwable -> L11
        f19856c = false;     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L11
    }

    public void L() {
        Object r10 = f19857d;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f19855b != 2) goto L9;
        f19855b = -1;     // Catch: Throwable -> L7
        f19856c = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    public long[] t() {
        f r10 = f19873t;     // Catch: Throwable -> L15
        if (r10 == null) goto L14;
        f r11 = f19874u;     // Catch: Throwable -> L15
        if (r11 == null) goto L14;
        if (r10 == r11) goto L14;
        int r12 = r10.f19876b;     // Catch: Throwable -> L15
        if (r12 != 0) goto L12;
        r12 = f19859f - 1;     // Catch: Throwable -> L15
    L12:
        return u(r11.f19875a, r12);
    L14:
        return null;
    }

    public long[] u(int r10, int r11) {
        long[] r12 = new long[0];
        int r13 = Math.max(0, r10);
        int r14 = Math.max(0, r11);
        if (r14 <= r13) goto L5;
        int r15 = (r14 - r13) + 1;
        long[] r16 = new long[r15];
        System.arraycopy(f19858e, r13, r16, 0, r15);
        return r16;
    L5:
        if (r14 >= r13) goto L9;
        int r17 = r14 + 1;
        long[] r18 = f19858e;
        long[] r19 = new long[(r18.length - r13) + r17];
        System.arraycopy(r18, r13, r19, 0, r18.length - r13);
        long[] r20 = f19858e;
        System.arraycopy(r20, 0, r19, r20.length - r13, r17);
        return r19;
    L9:
        return r12;
    }

    public final long[] v(long r10, long r11) {
        f r12 = f19873t;
        if (r12 == null) goto L19;
        f r13 = f19874u;
        if (r13 == null) goto L28;
    L7:
        if (r12 == r13) goto L14;
        if (f.e(f.c(r12)) > r11) goto L10;
        if (f.e(f.a(r13)) >= r10) goto L14;
        r13 = f.a(r13);
        goto L7
    L10:
        r12 = f.c(r12);
    L14:
        int r14 = r12.f19876b;
        if (r14 != 0) goto L18;
        r14 = f19859f - 1;
    L18:
        return u(r13.f19875a, r14);
    L28:
        return null;
    L19:
        return null;
    }

    public long[] w(f r10) {
        return x(r10, new f(f19859f - 1));
    }

    public long[] x(f r10, f r11) {
        if (f19855b != (-3)) goto L6;
        return null;
    L6:
        long[] r12 = new long[0];
        if (r10.f19879e == false) goto L13;
        if (r11.f19879e == false) goto L13;
        return u(r10.f19875a - 1, r11.f19875a);
    L13:
        return r12;
    }
}
