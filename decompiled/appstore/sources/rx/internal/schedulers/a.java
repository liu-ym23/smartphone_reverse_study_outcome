package rx.internal.schedulers;

import androidx.lifecycle.p;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends jg.a implements SchedulerLifecycle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f24301c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeUnit f24302d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f24303e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0367a f24304f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f24305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f24306b;

    /* JADX INFO: renamed from: rx.internal.schedulers.a$a, reason: collision with other inner class name */
    public static final class C0367a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f24307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f24308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConcurrentLinkedQueue f24309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final rx.subscriptions.b f24310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f24311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Future f24312f;

        /* JADX INFO: renamed from: rx.internal.schedulers.a$a$a, reason: collision with other inner class name */
        public class ThreadFactoryC0368a implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadFactory f24313a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0367a f24314b;

            public ThreadFactoryC0368a(C0367a r10, ThreadFactory r11) {
                this.f24314b = r10;
                this.f24313a = r11;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r10) {
                Thread r11 = this.f24313a.newThread(r10);
                r11.setName(r11.getName() + " (Evictor)");
                return r11;
            }
        }

        /* JADX INFO: renamed from: rx.internal.schedulers.a$a$b */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0367a f24315a;

            public b(C0367a r10) {
                this.f24315a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f24315a.a();
            }
        }

        public C0367a(ThreadFactory r10, long r11, TimeUnit r12) {
            this.f24307a = r10;
            if (r12 == null) goto L6;
            long r13 = r12.toNanos(r11);
        L5:
            long r14 = r13;
            this.f24308b = r14;
            this.f24309c = new ConcurrentLinkedQueue();
            this.f24310d = new rx.subscriptions.b();
            if (r12 == null) goto L10;
            ScheduledExecutorService r15 = Executors.newScheduledThreadPool(1, new ThreadFactoryC0368a(this, r10));
            d.j(r15);
            ScheduledFuture<?> r16 = r15.scheduleWithFixedDelay(new b(this), r14, r14, TimeUnit.NANOSECONDS);
        L11:
            this.f24311e = r15;
            this.f24312f = r16;
            return;
        L10:
            r15 = null;
            r16 = null;
            goto L11
        L6:
            r13 = 0;
            goto L5
        }

        public void a() {
            if (this.f24309c.isEmpty() == true) goto L12;
            long r10 = c();
            Iterator r11 = this.f24309c.iterator();
        L6:
            if (r11.hasNext() == false) goto L19;
            c r12 = (c) r11.next();
            if (r12.k() > r10) goto L20;
            if (this.f24309c.remove(r12) == false) goto L6;
            this.f24310d.b(r12);
            goto L6
        L20:
            return;
        L19:
            return;
        }

        public c b() {
            if (this.f24310d.isUnsubscribed() == false) goto L7;
            return a.f24303e;
        L7:
            if (this.f24309c.isEmpty() == true) goto L11;
            c r10 = (c) this.f24309c.poll();
            if (r10 == null) goto L7;
            return r10;
        L11:
            c r11 = new c(this.f24307a);
            this.f24310d.a(r11);
            return r11;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(c r10) {
            r10.l(c() + this.f24308b);
            this.f24309c.offer(r10);
        }

        public void e() {
            Future r10 = this.f24312f;     // Catch: Throwable -> L5
            if (r10 == null) goto L7;
            r10.cancel(true);     // Catch: Throwable -> L5
        L7:
            ScheduledExecutorService r11 = this.f24311e;     // Catch: Throwable -> L5
            if (r11 == null) goto L10;
            r11.shutdownNow();     // Catch: Throwable -> L5
        L10:
            this.f24310d.unsubscribe();
            return;
        L5:
            th = move-exception;
            this.f24310d.unsubscribe();
            throw th;
        }
    }

    public static final class b extends jg.a.AbstractC0284a implements Action0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rx.subscriptions.b f24316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0367a f24317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f24318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f24319d;

        /* JADX INFO: renamed from: rx.internal.schedulers.a$b$a, reason: collision with other inner class name */
        public class C0369a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Action0 f24320a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f24321b;

            public C0369a(b r10, Action0 r11) {
                this.f24321b = r10;
                this.f24320a = r11;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.f24321b.isUnsubscribed() == false) goto L5;
                return;
            L5:
                this.f24320a.call();
            }
        }

        public b(C0367a r10) {
            this.f24316a = new rx.subscriptions.b();
            this.f24317b = r10;
            this.f24319d = new AtomicBoolean();
            this.f24318c = r10.b();
        }

        @Override // jg.a.AbstractC0284a
        public Subscription a(Action0 r10) {
            return b(r10, 0, null);
        }

        @Override // jg.a.AbstractC0284a
        public Subscription b(Action0 r10, long r11, TimeUnit r12) {
            if (this.f24316a.isUnsubscribed() == true) goto L5;
            ScheduledAction r13 = this.f24318c.g(new C0369a(this, r10), r11, r12);
            this.f24316a.a(r13);
            r13.addParent(this.f24316a);
            return r13;
        L5:
            return e.b();
        }

        @Override // rx.functions.Action0
        public void call() {
            this.f24317b.d(this.f24318c);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24316a.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.f24319d.compareAndSet(false, true) == false) goto L5;
            this.f24318c.a(this);
        L5:
            this.f24316a.unsubscribe();
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f24322i;

        public c(ThreadFactory r10) {
            super(r10);
            this.f24322i = 0;
        }

        public long k() {
            return this.f24322i;
        }

        public void l(long r10) {
            this.f24322i = r10;
        }
    }

    static {
        f24302d = TimeUnit.SECONDS;
        c r10 = new c(RxThreadFactory.NONE);
        f24303e = r10;
        r10.unsubscribe();
        C0367a r11 = new C0367a(null, 0, null);
        f24304f = r11;
        r11.e();
        f24301c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory r10) {
        this.f24305a = r10;
        this.f24306b = new AtomicReference(f24304f);
        start();
    }

    @Override // jg.a
    public jg.a.AbstractC0284a createWorker() {
        return new b((C0367a) this.f24306b.get());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
    L2:
        C0367a r10 = (C0367a) this.f24306b.get();
        C0367a r11 = f24304f;
        if (r10 == r11) goto L4;
        if (p.a(this.f24306b, r10, r11) == false) goto L2;
        r10.e();
        return;
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        C0367a r10 = new C0367a(this.f24305a, f24301c, f24302d);
        if (p.a(this.f24306b, f24304f, r10) == true) goto L6;
        r10.e();
        return;
    }
}
