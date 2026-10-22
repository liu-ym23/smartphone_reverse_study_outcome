package rx.internal.schedulers;

import androidx.lifecycle.p;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends jg.a implements SchedulerLifecycle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24323c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f24324d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0372b f24325e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f24326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f24327b;

    public static final class a extends jg.a.AbstractC0284a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubscriptionList f24328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rx.subscriptions.b f24329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SubscriptionList f24330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f24331d;

        /* JADX INFO: renamed from: rx.internal.schedulers.b$a$a, reason: collision with other inner class name */
        public class C0370a implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Action0 f24332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f24333b;

            public C0370a(a r10, Action0 r11) {
                this.f24333b = r10;
                this.f24332a = r11;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.f24333b.isUnsubscribed() == false) goto L5;
                return;
            L5:
                this.f24332a.call();
            }
        }

        /* JADX INFO: renamed from: rx.internal.schedulers.b$a$b, reason: collision with other inner class name */
        public class C0371b implements Action0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Action0 f24334a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f24335b;

            public C0371b(a r10, Action0 r11) {
                this.f24335b = r10;
                this.f24334a = r11;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.f24335b.isUnsubscribed() == false) goto L5;
                return;
            L5:
                this.f24334a.call();
            }
        }

        public a(c r10) {
            SubscriptionList r11 = new SubscriptionList();
            this.f24328a = r11;
            rx.subscriptions.b r12 = new rx.subscriptions.b();
            this.f24329b = r12;
            this.f24330c = new SubscriptionList(new Subscription[]{r11, r12});
            this.f24331d = r10;
        }

        @Override // jg.a.AbstractC0284a
        public Subscription a(Action0 r10) {
            if (isUnsubscribed() == false) goto L7;
            return e.b();
        L7:
            return this.f24331d.h(new C0370a(this, r10), 0, null, this.f24328a);
        }

        @Override // jg.a.AbstractC0284a
        public Subscription b(Action0 r10, long r11, TimeUnit r12) {
            if (isUnsubscribed() == false) goto L7;
            return e.b();
        L7:
            return this.f24331d.i(new C0371b(this, r10), r11, r12, this.f24329b);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f24330c.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f24330c.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: rx.internal.schedulers.b$b, reason: collision with other inner class name */
    public static final class C0372b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f24337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f24338c;

        public C0372b(ThreadFactory r10, int r11) {
            this.f24336a = r11;
            this.f24337b = new c[r11];
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            this.f24337b[r12] = new c(r10);
            r12 = r12 + 1;
            goto L3
        }

        public c a() {
            int r10 = this.f24336a;
            if (r10 == 0) goto L5;
            c[] r11 = this.f24337b;
            long r12 = this.f24338c;
            this.f24338c = 1 + r12;
            return r11[(int) (r12 % ((long) r10))];
        L5:
            return b.f24324d;
        }

        public void b() {
            c[] r10 = this.f24337b;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r10[r12].unsubscribe();
            r12 = r12 + 1;
            goto L3
        }
    }

    public static final class c extends d {
        public c(ThreadFactory r10) {
            super(r10);
        }
    }

    static {
        int r10 = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int r11 = Runtime.getRuntime().availableProcessors();
        if (r10 <= 0) goto L5;
        if (r10 > r11) goto L5;
    L6:
        f24323c = r10;
        c r12 = new c(RxThreadFactory.NONE);
        f24324d = r12;
        r12.unsubscribe();
        f24325e = new C0372b(null, 0);
        return;
    L5:
        r10 = r11;
        goto L6
    }

    public b(ThreadFactory r10) {
        this.f24326a = r10;
        this.f24327b = new AtomicReference(f24325e);
        start();
    }

    public Subscription a(Action0 r10) {
        return ((C0372b) this.f24327b.get()).a().g(r10, -1, TimeUnit.NANOSECONDS);
    }

    @Override // jg.a
    public jg.a.AbstractC0284a createWorker() {
        return new a(((C0372b) this.f24327b.get()).a());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
    L2:
        C0372b r10 = (C0372b) this.f24327b.get();
        C0372b r11 = f24325e;
        if (r10 == r11) goto L4;
        if (p.a(this.f24327b, r10, r11) == false) goto L2;
        r10.b();
        return;
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        C0372b r10 = new C0372b(this.f24326a, f24323c);
        if (p.a(this.f24327b, f24325e, r10) == true) goto L6;
        r10.b();
        return;
    }
}
