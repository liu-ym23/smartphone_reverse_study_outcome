package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;

/* JADX INFO: loaded from: classes4.dex */
public class n implements Observable.Operator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f24241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action0 f24242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BackpressureOverflow.Strategy f24243c;

    public static final class a extends Subscriber implements BackpressureDrainManager.BackpressureQueueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue f24244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicLong f24245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Subscriber f24246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f24247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final BackpressureDrainManager f24248e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Action0 f24249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final BackpressureOverflow.Strategy f24250g;

        public a(Subscriber r10, Long r11, Action0 r12, BackpressureOverflow.Strategy r13) {
            this.f24244a = new ConcurrentLinkedQueue();
            this.f24247d = new AtomicBoolean(false);
            this.f24246c = r10;
            if (r11 == null) goto L5;
            AtomicLong r14 = new AtomicLong(r11.longValue());
        L6:
            this.f24245b = r14;
            this.f24249f = r12;
            this.f24248e = new BackpressureDrainManager(this);
            this.f24250g = r13;
            return;
        L5:
            r14 = null;
            goto L6
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public boolean accept(Object r10) {
            return NotificationLite.a(this.f24246c, r10);
        }

        public final boolean b() {
            if (this.f24245b != null) goto L5;
            return true;
        L5:
            long r10 = this.f24245b.get();
            if (r10 > 0) goto L28;
        L13:
            e = move-exception;
            if (this.f24247d.compareAndSet(false, true) == false) goto L17;
            unsubscribe();
            this.f24246c.onError(e);
        L17:
            boolean r11 = false;
        L18:
            Action0 r12 = this.f24249f;
            if (r12 != null) goto L32;
        L25:
            if (r11 == true) goto L28;
            return false;
        L32:
            r12.call();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            rx.exceptions.a.e(th);
            this.f24248e.terminateAndDrain(th);
            return false;
        L9:
            if (this.f24250g.mayAttemptDrop() == false) goto L17;
            if (poll() == null) goto L17;
            r11 = true;
        L28:
            if (this.f24245b.compareAndSet(r10, r10 - 1) == false) goto L5;
            return true;
        }

        public Producer c() {
            return this.f24248e;
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public void complete(Throwable r10) {
            if (r10 == null) goto L4;
            this.f24246c.onError(r10);
            return;
        L4:
            this.f24246c.onCompleted();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.f24247d.get() == true) goto L6;
            this.f24248e.terminateAndDrain();
            return;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.f24247d.get() == true) goto L6;
            this.f24248e.terminateAndDrain(r10);
            return;
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            if (b() == true) goto L5;
            return;
        L5:
            this.f24244a.offer(NotificationLite.g(r10));
            this.f24248e.drain();
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object peek() {
            return this.f24244a.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object poll() {
            Object r10 = this.f24244a.poll();
            AtomicLong r11 = this.f24245b;
            if (r11 == null) goto L6;
            if (r10 == null) goto L6;
            r11.incrementAndGet();
        L6:
            return r10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f24251a = null;

        static {
            f24251a = new n();
        }
    }

    public n() {
        this.f24241a = null;
        this.f24242b = null;
        this.f24243c = BackpressureOverflow.f24126b;
    }

    public static n b() {
        return b.f24251a;
    }

    public Subscriber a(Subscriber r10) {
        a r11 = new a(r10, this.f24241a, this.f24242b, this.f24243c);
        r10.add(r11);
        r10.setProducer(r11.c());
        return r11;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return a(r10);
    }
}
