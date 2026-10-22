package com.bytedance.apm.block.trace;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;

/* JADX INFO: compiled from: MethodCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "MethodCollector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f4439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f4440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f4441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f4442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long[] f4443e;
    private static int f;
    private static int g;
    private static boolean h;
    private static volatile long i;
    private static volatile long j;
    private static Thread k;
    private static volatile Runnable l;
    private static HandlerThread m;
    private static Handler n;
    private static Object o;
    private static boolean p;
    private static Runnable q;
    private static com.bytedance.monitor.collector.a r;
    private static Runnable s;
    private static a t;
    private static a u;

    /* JADX INFO: compiled from: MethodCollector.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a f4448e;
        private a f;
        private long g;

        static /* synthetic */ long a(a r0, long r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ a a(a r0) {
            return r0.f;
        }

        static /* synthetic */ a a(a r0, a r1) {
            r0.f4448e = r1;
            return r1;
        }

        static /* synthetic */ a b(a r0) {
            return r0.f4448e;
        }

        static /* synthetic */ a b(a r0, a r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ long c(a r2) {
            return r2.g;
        }

        public a(int r2) {
            this.f4446c = true;
            this.f4444a = r2;
        }

        public String toString() {
            return "index:" + this.f4444a + ",\tisValid:" + this.f4446c + " source:" + this.f4447d;
        }
    }

    public g() {
    }

    static /* synthetic */ int a(int r0) {
        f4440b = r0;
        return r0;
    }

    static /* synthetic */ long a(long r0) {
        i = r0;
        return r0;
    }

    static /* synthetic */ Runnable a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        l = r3;
        return r3;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f4441c = r0;
        return r0;
    }

    static /* synthetic */ long[] a(long[] r0) {
        f4443e = r0;
        return r0;
    }

    static /* synthetic */ Runnable g() {
        return l;
    }

    static /* synthetic */ int h() {
        return f4440b;
    }

    static /* synthetic */ void i() {
        y();
    }

    static /* synthetic */ void j() {
        z();
    }

    static /* synthetic */ boolean k() {
        return p;
    }

    static /* synthetic */ long l() {
        return w();
    }

    static /* synthetic */ long m() {
        return j;
    }

    static /* synthetic */ long n() {
        return i;
    }

    static /* synthetic */ Object o() {
        return o;
    }

    static /* synthetic */ void p() {
        v();
    }

    static /* synthetic */ Handler q() {
        return n;
    }

    static /* synthetic */ com.bytedance.monitor.collector.a r() {
        return r;
    }

    static /* synthetic */ HandlerThread s() {
        return m;
    }

    static /* synthetic */ Object t() {
        return f4442d;
    }

    static {
        f4439a = new g();
        f4440b = Integer.MAX_VALUE;
        f4441c = false;
        Object r2 = new Object();
        f4442d = r2;
        f4443e = null;
        f = 0;
        g = -1;
        h = false;
        i = w();
        j = i;
        k = Looper.getMainLooper().getThread();
        l = null;
        m = u();
        n = new Handler(m.getLooper());
        o = new Object();
        p = false;
        q = null;
        r = new AnonymousClass1();
        s = new AnonymousClass2();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        f4440b = -4;
        f4441c = true;
    L17:
        n.postDelayed(new AnonymousClass3(), 15000);
        return;
    L5:
        f4443e = new long[600000];
        if (f4440b != Integer.MAX_VALUE) goto L16;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f4440b != Integer.MAX_VALUE) goto L11;
        x();     // Catch: Throwable -> L13
        f4440b = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L16:
        a(1048574, 0);
        a("EvilMethodTracer#message_0", com.bytedance.monitor.collector.a.f8947b);
        goto L17
    }

    private static HandlerThread u() {
        HandlerThread r0 = new HandlerThread("trace_time_update_thread");
        r0.start();
        return r0;
    }

    public static g a() {
        return f4439a;
    }

    public void b() {
        Object r3 = f4442d;
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f4440b < 2) goto L7;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L7:
        if (f4440b < (-2)) goto L13;
        n.removeCallbacks(q);     // Catch: Throwable -> L15
        if (f4443e == null) goto L12;
        f4440b = 2;     // Catch: Throwable -> L15
        f4441c = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void c() {
        Object r2 = f4442d;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f4440b != 2) goto L7;
        f4440b = -1;     // Catch: Throwable -> L9
        f4441c = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L9
    }

    public boolean d() {
        if (f4440b < 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static void v() {
        Object r0 = f4442d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f4440b != Integer.MAX_VALUE) goto L7;
    L8:
        f4440b = -3;     // Catch: Throwable -> L11
        f4441c = true;     // Catch: Throwable -> L11
        l = new AnonymousClass4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (f4440b != (-4)) goto L9;
        goto L8
    }

    private static long w() {
        return SystemClock.uptimeMillis();
    }

    private static void x() {
        i = w() - j;
        n.removeCallbacksAndMessages(null);
        n.postDelayed(s, 5);
        Handler r0 = n;
        Runnable r1 = new AnonymousClass5();
        q = r1;
        r0.postDelayed(r1, 15000);
        com.bytedance.monitor.collector.h.b(r);
    }

    private static void y() {
        i = com.bytedance.monitor.collector.a.f8947b - j;
        p = false;
        Object r0 = o;
        monitor-enter(r0);
        o.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void z() {
        p = true;
    }

    public static void a(int r3, long r4) {
        if (f4441c == false) goto L6;
        return;
    L6:
        if (r3 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == k) goto L11;
        return;
    L11:
        if (h == false) goto L13;
        return;
    L13:
        h = true;
        if (r4 == 0) goto L16;
        i = r4 - j;
        i &= 8796093022207L;
    L16:
        long r5 = ((((long) r3) << 43) | Long.MIN_VALUE) | i;
        long[] r6 = f4443e;
        int r1 = f;
        r6[r1] = r5;
        int r2 = r1 + 1;
        f = r2;
        if (r2 != 600000) goto L19;
        f = 0;
    L19:
        h = false;
        a r7 = u;
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.f4444a != f) goto L30;
        a r8 = a.a(u);
        u = r8;
        if (r8 == null) goto L27;
        a.a(r8, null);
        return;
    L27:
        t = null;
        return;
    }

    public static void b(int r4, long r5) {
        if (f4441c == false) goto L6;
        return;
    L6:
        if (r4 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == k) goto L11;
        return;
    L11:
        if (r5 == 0) goto L13;
        i = r5 - j;
        i &= 8796093022207L;
    L13:
        long r6 = ((((long) r4) << 43) | 0) | i;
        long[] r7 = f4443e;
        int r0 = f;
        r7[r0] = r6;
        int r1 = r0 + 1;
        f = r1;
        if (r1 != 600000) goto L16;
        f = 0;
    L16:
        a r8 = u;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.f4444a != f) goto L27;
        a r9 = a.a(u);
        u = r9;
        if (r9 == null) goto L23;
        a.a(r9, null);
        return;
    L23:
        t = null;
        return;
    }

    public static a a(String r4, long r5) {
        if (t != null) goto L9;
        a r0 = new a(f);
        t = r0;
        if (r5 > 0) goto L7;
        r5 = SystemClock.uptimeMillis();
    L7:
        a.a(r0, r5);
        t.f4447d = r4;
        a r6 = t;
        u = r6;
        return r6;
    L9:
        a r1 = new a(f);
        if (r5 > 0) goto L12;
        r5 = SystemClock.uptimeMillis();
    L12:
        a.a(r1, r5);
        r1.f4447d = r4;
        a.a(r1, t);
        t.f4445b = r1.f4444a - 1;
        a.b(t, r1);
        t = r1;
        return r1;
    }

    public long[] a(a r3) {
        return a(r3, new a(f - 1));
    }

    public long[] a(a r3, a r4) {
        if (f4440b != (-3)) goto L6;
        return null;
    L6:
        long[] r0 = new long[0];
        if (r3.f4446c == false) goto L13;
        if (r4.f4446c == false) goto L13;
        return a(r3.f4444a - 1, r4.f4444a);
    L13:
        return r0;
    }

    public long[] e() {
        a r1 = t;     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        a r2 = u;     // Catch: Throwable -> L16
        if (r2 == null) goto L15;
        if (r1 == r2) goto L15;
        if (r1.f4445b != 0) goto L12;
        int r3 = f - 1;     // Catch: Throwable -> L16
    L13:
        return a(u.f4444a, r3);
    L12:
        r3 = t.f4445b;     // Catch: Throwable -> L16
    L15:
        return null;
    }

    private long[] b(long r5, long r7) {
        a r0 = t;
        if (r0 == null) goto L20;
        a r1 = u;
        if (r1 == null) goto L29;
    L7:
        if (r0 == r1) goto L15;
        if (a.c(a.b(r0)) > r7) goto L10;
        if (a.c(a.a(r1)) >= r5) goto L15;
        r1 = a.a(r1);
        goto L7
    L10:
        r0 = a.b(r0);
    L15:
        if (r0.f4445b != 0) goto L17;
        int r6 = f - 1;
    L19:
        return a(r1.f4444a, r6);
    L17:
        r6 = r0.f4445b;
        goto L19
    L29:
        return null;
    L20:
        return null;
    }

    public long[] a(int r4, int r5) {
        long[] r0 = new long[0];
        int r6 = Math.max(0, r4);
        int r7 = Math.max(0, r5);
        if (r7 <= r6) goto L5;
        int r8 = (r7 - r6) + 1;
        long[] r1 = new long[r8];
        System.arraycopy(f4443e, r6, r1, 0, r8);
        return r1;
    L5:
        if (r7 >= r6) goto L9;
        int r9 = r7 + 1;
        long[] r2 = f4443e;
        long[] r3 = new long[(r2.length - r6) + r9];
        System.arraycopy(r2, r6, r3, 0, r2.length - r6);
        long[] r10 = f4443e;
        System.arraycopy(r10, 0, r3, r10.length - r6, r9);
        return r3;
    L9:
        return r0;
    }

    public static long f() {
        return j;
    }

    public String a(long r3, long r5) {
        long r0 = SystemClock.uptimeMillis();
        return a(b(r3, r5), r0);
    }

    public String a(long[] r2, long r3) {
        if (r2 != null) goto L5;
        return "";
    L5:
        LinkedList r1 = new LinkedList();
        com.bytedance.perf.a.a.a(r2, r1, true, r3);
        com.bytedance.perf.a.a.a(r1, 1);
        StringBuilder r4 = new StringBuilder();
        com.bytedance.perf.a.a.a(r1, r4);
        return r4.toString();
    }
}
