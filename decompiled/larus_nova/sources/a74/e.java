package a74;

import android.content.Context;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f1991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1992b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f1993c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f1994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f1995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f1996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f1997g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayDeque f1998h = null;

    static {
        f1992b = new Object();
        f1993c = new AtomicBoolean(false);
        f1994d = false;
        f1995e = 0;
        f1996f = false;
        f1997g = new ArrayDeque();
        f1998h = new ArrayDeque();
    }

    public static void c() {
        Object r100 = f1992b;
        monitor-enter(r100);
        f1994d = false;     // Catch: Throwable -> L8
        f1991a = 0;     // Catch: Throwable -> L8
        f1997g.clear();     // Catch: Throwable -> L8
        f1998h.clear();     // Catch: Throwable -> L8
        f1995e = 0;     // Catch: Throwable -> L8
        f1996f = false;     // Catch: Throwable -> L8
        com.bytedance.badger.e.g("event_behavior# ", "stop: sensor window stopped and clear!");     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Object r100 = f1992b;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (f1994d == true) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L8:
        long r101 = f1995e;     // Catch: Throwable -> L20
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L20
        com.bytedance.badger.v.k r102 = com.bytedance.badger.v.d.f199314b0;     // Catch: Throwable -> L20
        KProperty[] r103 = com.bytedance.badger.v.d.f199311a;     // Catch: Throwable -> L20
        KProperty r104 = r103[54];     // Catch: Throwable -> L20
        if (r101 < ((Number) r102.a()).longValue()) goto L13;
        com.bytedance.badger.e.g("event_behavior# ", "batch > max count return");     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L20
        if (f1993c.compareAndSet(false, true) == true) goto L18;
        com.bytedance.badger.e.g("event_behavior# ", "isCollecting return..." + ThreadMethodProxy.currentThread().getName());
        return;
    L18:
        com.bytedance.badger.e.f("event_behavior# ", "scheduleNext..." + ThreadMethodProxy.currentThread().getName());
        com.bytedance.badger.v.h r105 = com.bytedance.badger.v.d.O;
        KProperty r106 = r103[41];
        int r107 = ((Number) r105.a()).intValue();
        com.bytedance.badger.v.h r108 = com.bytedance.badger.v.d.P;
        KProperty r109 = r103[42];
        p.a(r107, ((Number) r108.a()).intValue(), new d());
    }

    public static void a(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        p.b(r100.getApplicationContext());
        long r101 = SystemClock.uptimeMillis();
        Object r102 = f1992b;
        monitor-enter(r102);
        long r103 = r101 - f1991a;     // Catch: Throwable -> L23
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L23
        com.bytedance.badger.v.k r104 = com.bytedance.badger.v.d.X;     // Catch: Throwable -> L23
        KProperty r105 = com.bytedance.badger.v.d.f199311a[50];     // Catch: Throwable -> L23
        if (r103 >= ((Number) r104.a()).longValue()) goto L12;
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L12:
        if (f1996f == true) goto L14;
    L19:
        f1991a = r101;     // Catch: Throwable -> L23
        f1994d = true;     // Catch: Throwable -> L23
        f1995e = 0;     // Catch: Throwable -> L23
        f1996f = true;     // Catch: Throwable -> L23
        f1997g.clear();     // Catch: Throwable -> L23
        f1998h.clear();     // Catch: Throwable -> L23
        com.bytedance.badger.e.f("event_behavior# ", "start: begin sensor window collection");     // Catch: Throwable -> L23
        monitor-exit(r102);     // Catch: Throwable -> L23
        b();
        return;
    L14:
        if (f1995e <= 0) goto L19;
        com.bytedance.badger.e.g("event_behavior# ", "start skipped: previous data not consumed, batchCount=" + f1995e);     // Catch: Throwable -> L23
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
