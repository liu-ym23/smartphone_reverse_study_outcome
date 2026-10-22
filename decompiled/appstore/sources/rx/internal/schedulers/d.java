package rx.internal.schedulers;

import androidx.lifecycle.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.internal.util.e;

/* JADX INFO: loaded from: classes4.dex */
public class d extends jg.a.AbstractC0284a implements Subscription {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f24340c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24341d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f24342e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReference f24343f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Object f24344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f24345h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f24346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f24347b;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.e();
        }
    }

    static {
        f24345h = new Object();
        f24342e = new ConcurrentHashMap();
        f24343f = new AtomicReference();
        f24341d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
        boolean r10 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int r11 = e.a();
        if (r10 == true) goto L8;
        if (r11 != 0) goto L6;
    L7:
        boolean r12 = true;
    L9:
        f24340c = r12;
        return;
    L6:
        if (r11 >= 21) goto L7;
    L8:
        r12 = false;
        goto L9
    }

    public d(ThreadFactory r10) {
        ScheduledExecutorService r11 = Executors.newScheduledThreadPool(1, r10);
        if (j(r11) == false) goto L5;
    L7:
        this.f24346a = r11;
        return;
    L5:
        if ((r11 instanceof ScheduledThreadPoolExecutor) == false) goto L7;
        f((ScheduledThreadPoolExecutor) r11);
        goto L7
    }

    public static void c(ScheduledExecutorService r10) {
        f24342e.remove(r10);
    }

    public static Method d(ScheduledExecutorService r10) {
        Method[] r11 = r10.getClass().getMethods();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        Method r14 = r11[r13];
        if (r14.getName().equals("setRemoveOnCancelPolicy") == false) goto L11;
        Class<?>[] r15 = r14.getParameterTypes();
        if (r15.length != 1) goto L11;
        if (r15[0] != Boolean.TYPE) goto L11;
        return r14;
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return null;
    }

    public static void e() {
        Iterator r10 = f24342e.keySet().iterator();     // Catch: Throwable -> L8
    L3:
        if (r10.hasNext() == false) goto L22;
        ScheduledThreadPoolExecutor r11 = (ScheduledThreadPoolExecutor) r10.next();     // Catch: Throwable -> L8
        if (r11.isShutdown() == false) goto L7;
        r10.remove();     // Catch: Throwable -> L8
        goto L3
    L7:
        r11.purge();     // Catch: Throwable -> L8
        goto L3
    L22:
        return;
    L8:
        th = move-exception;
        rx.exceptions.a.e(th);
        og.c.j(th);
    }

    public static void f(ScheduledThreadPoolExecutor r10) {
    L2:
        AtomicReference r11 = f24343f;
        if (((ScheduledExecutorService) r11.get()) != null) goto L8;
        ScheduledExecutorService r12 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
        if (p.a(r11, null, r12) == true) goto L7;
        r12.shutdownNow();
        goto L2
    L7:
        a r13 = new a();
        int r14 = f24341d;
        r12.scheduleAtFixedRate(r13, r14, r14, TimeUnit.MILLISECONDS);
    L8:
        f24342e.putIfAbsent(r10, r10);
    }

    public static boolean j(ScheduledExecutorService r10) {
        if (f24340c == true) goto L5;
    L29:
        return false;
    L5:
        if ((r10 instanceof ScheduledThreadPoolExecutor) == false) goto L15;
        Object r11 = f24344g;
        Object r12 = f24345h;
        if (r11 != r12) goto L9;
        return false;
    L9:
        if (r11 != null) goto L14;
        Method r13 = d(r10);
        if (r13 == null) goto L13;
        r12 = r13;
    L13:
        f24344g = r12;
    L16:
        if (r13 == null) goto L29;
        r13.invoke(r10, new Object[]{Boolean.TRUE});     // Catch: IllegalArgumentException -> L20 IllegalAccessException -> L22 InvocationTargetException -> L24
        return true;
    L22:
        e = move-exception;
        og.c.j(e);
    L20:
        e = move-exception;
        og.c.j(e);
    L24:
        e = move-exception;
        og.c.j(e);
        goto L29
    L14:
        r13 = (Method) r11;
        goto L16
    L15:
        r13 = d(r10);
        goto L16
    }

    @Override // jg.a.AbstractC0284a
    public Subscription a(Action0 r10) {
        return b(r10, 0, null);
    }

    @Override // jg.a.AbstractC0284a
    public Subscription b(Action0 r10, long r11, TimeUnit r12) {
        if (this.f24347b == false) goto L7;
        return rx.subscriptions.e.b();
    L7:
        return g(r10, r11, r12);
    }

    public ScheduledAction g(Action0 r10, long r11, TimeUnit r12) {
        ScheduledAction r13 = new ScheduledAction(og.c.p(r10));
        if (r11 > 0) goto L5;
        Future<?> r14 = this.f24346a.submit(r13);
    L6:
        r13.add(r14);
        return r13;
    L5:
        r14 = this.f24346a.schedule(r13, r11, r12);
        goto L6
    }

    public ScheduledAction h(Action0 r10, long r11, TimeUnit r12, SubscriptionList r13) {
        ScheduledAction r14 = new ScheduledAction(og.c.p(r10), r13);
        r13.a(r14);
        if (r11 > 0) goto L5;
        Future<?> r15 = this.f24346a.submit(r14);
    L6:
        r14.add(r15);
        return r14;
    L5:
        r15 = this.f24346a.schedule(r14, r11, r12);
        goto L6
    }

    public ScheduledAction i(Action0 r10, long r11, TimeUnit r12, rx.subscriptions.b r13) {
        ScheduledAction r14 = new ScheduledAction(og.c.p(r10), r13);
        r13.a(r14);
        if (r11 > 0) goto L5;
        Future<?> r15 = this.f24346a.submit(r14);
    L6:
        r14.add(r15);
        return r14;
    L5:
        r15 = this.f24346a.schedule(r14, r11, r12);
        goto L6
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f24347b;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.f24347b = true;
        this.f24346a.shutdownNow();
        c(this.f24346a);
    }
}
