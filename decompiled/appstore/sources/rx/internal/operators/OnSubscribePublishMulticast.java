package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.unsafe.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = null;
    static final PublishProducer<?>[] TERMINATED = null;
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber actual;
        final AtomicBoolean once;
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber r10, OnSubscribePublishMulticast<T> r11) {
            this.actual = r10;
            this.parent = r11;
            this.once = new AtomicBoolean();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 < 0) goto L8;
            if (r10 == 0) goto L9;
            rx.internal.operators.a.b(this, r10);
            this.parent.drain();
            return;
        L9:
            return;
        L8:
            throw new IllegalArgumentException("n >= 0 required but it was " + r10);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.parent.remove(this);
            return;
        }
    }

    public static final class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OnSubscribePublishMulticast f24166a;

        public a(OnSubscribePublishMulticast r10) {
            this.f24166a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24166a.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24166a.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            this.f24166a.onNext(r10);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer r10) {
            this.f24166a.setProducer(r10);
        }
    }

    static {
        EMPTY = new PublishProducer[0];
        TERMINATED = new PublishProducer[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int r10, boolean r11) {
        if (r10 <= 0) goto L11;
        this.prefetch = r10;
        this.delayError = r11;
        if (e0.b() == false) goto L7;
        this.queue = new rx.internal.util.unsafe.q(r10);
    L8:
        this.subscribers = (PublishProducer<T>[]) EMPTY;
        this.parent = new a(this);
        return;
    L7:
        this.queue = new rx.internal.util.atomic.c(r10);
        goto L8
    L11:
        throw new IllegalArgumentException("prefetch > 0 required but it was " + r10);
    }

    public boolean add(PublishProducer<T> r10) {
        PublishProducer<T>[] r11 = this.subscribers;
        PublishProducer<?>[] r12 = TERMINATED;
        if (r11 != r12) goto L5;
        return false;
    L5:
        monitor-enter(this);
        PublishProducer<T>[] r13 = this.subscribers;     // Catch: Throwable -> L10
        if (r13 != r12) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L12:
        int r14 = r13.length;     // Catch: Throwable -> L10
        PublishProducer<T>[] r15 = new PublishProducer[r14 + 1];     // Catch: Throwable -> L10
        System.arraycopy(r13, 0, r15, 0, r14);     // Catch: Throwable -> L10
        r15[r14] = r10;     // Catch: Throwable -> L10
        this.subscribers = r15;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    public boolean checkTerminated(boolean r10, boolean r11) {
        int r12 = 0;
        if (r10 == true) goto L5;
    L27:
        return false;
    L5:
        if (this.delayError == false) goto L16;
        if (r11 == false) goto L27;
        PublishProducer<T>[] r13 = terminate();
        Throwable r14 = this.error;
        if (r14 == null) goto L12;
        int r15 = r13.length;
    L10:
        if (r12 >= r15) goto L15;
        r13[r12].actual.onError(r14);
        r12 = r12 + 1;
    L15:
        return true;
    L12:
        int r16 = r13.length;
    L13:
        if (r12 >= r16) goto L15;
        r13[r12].actual.onCompleted();
        r12 = r12 + 1;
        goto L13
    L16:
        Throwable r17 = this.error;
        if (r17 == null) goto L22;
        this.queue.clear();
        PublishProducer<T>[] r18 = terminate();
        int r19 = r18.length;
    L19:
        if (r12 >= r19) goto L21;
        r18[r12].actual.onError(r17);
        r12 = r12 + 1;
        goto L19
    L21:
        return true;
    L22:
        if (r11 == false) goto L27;
        PublishProducer<T>[] r20 = terminate();
        int r21 = r20.length;
    L24:
        if (r12 >= r21) goto L26;
        r20[r12].actual.onCompleted();
        r12 = r12 + 1;
        goto L24
    L26:
        return true;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Queue<T> r10 = this.queue;
        int r11 = 0;
    L6:
        PublishProducer<T>[] r12 = this.subscribers;
        int r13 = r12.length;
        int r14 = r12.length;
        long r15 = Long.MAX_VALUE;
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r15 = Math.min(r15, r12[r16].get());
        r16 = r16 + 1;
        goto L7
    L9:
        if (r13 == 0) goto L38;
        long r17 = 0;
    L12:
        if (r17 == r15) goto L26;
        boolean r18 = this.done;
        T r19 = r10.poll();
        if (r19 != null) goto L16;
        boolean r110 = true;
    L18:
        if (checkTerminated(r18, r110) == true) goto L19;
        if (r110 == true) goto L26;
        int r111 = r12.length;
        int r112 = 0;
    L23:
        if (r112 >= r111) goto L25;
        r12[r112].actual.onNext(r19);
        r112 = r112 + 1;
        goto L23
    L25:
        r17 = r17 + 1;
        goto L12
    L19:
        return;
    L16:
        r110 = false;
    L26:
        if (r17 != r15) goto L31;
        if (checkTerminated(this.done, r10.isEmpty()) == false) goto L31;
        return;
    L31:
        if (r17 == 0) goto L38;
        Producer r20 = this.producer;
        if (r20 == null) goto L35;
        r20.request(r17);
    L35:
        int r21 = r12.length;
        int r22 = 0;
    L36:
        if (r22 >= r21) goto L38;
        rx.internal.operators.a.c(r12[r22], r17);
        r22 = r22 + 1;
    L38:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L6;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L5;
        this.parent.unsubscribe();
        this.error = new MissingBackpressureException("Queue full?!");
        this.done = true;
    L5:
        drain();
    }

    public void remove(PublishProducer<T> r10) {
        PublishProducer<T>[] r11 = this.subscribers;
        PublishProducer<?>[] r12 = TERMINATED;
        if (r11 == r12) goto L35;
        PublishProducer<?>[] r13 = EMPTY;
        if (r11 == r13) goto L39;
        monitor-enter(this);
        PublishProducer<T>[] r14 = this.subscribers;     // Catch: Throwable -> L18
        if (r14 == r12) goto L31;
        if (r14 == r13) goto L31;
        int r15 = r14.length;     // Catch: Throwable -> L18
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L20;
        if (r14[r16] == r10) goto L21;
        r16 = r16 + 1;     // Catch: Throwable -> L18
    L21:
        if (r16 >= 0) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L25:
        if (r15 != 1) goto L27;
        PublishProducer[] r17 = EMPTY;     // Catch: Throwable -> L18
    L28:
        this.subscribers = r17;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L27:
        PublishProducer[] r18 = new PublishProducer[r15 - 1];     // Catch: Throwable -> L18
        System.arraycopy(r14, 0, r18, 0, r16);     // Catch: Throwable -> L18
        System.arraycopy(r14, r16 + 1, r18, r16, (r15 - r16) - 1);     // Catch: Throwable -> L18
        r17 = r18;
        goto L28
    L20:
        r16 = -1;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L39:
        return;
    }

    public void setProducer(Producer r10) {
        this.producer = r10;
        r10.request(this.prefetch);
    }

    public Subscriber subscriber() {
        return this.parent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublishProducer<T>[] terminate() {
        PublishProducer<T>[] r10 = this.subscribers;
        PublishProducer<T>[] r11 = (PublishProducer<T>[]) TERMINATED;
        if (r10 == r11) goto L14;
        monitor-enter(this);
        r10 = this.subscribers;     // Catch: Throwable -> L8
        if (r10 == r11) goto L10;
        this.subscribers = r11;     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L14:
        return r10;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        PublishProducer<T> r11 = new PublishProducer(r10, this);
        r10.add(r11);
        r10.setProducer(r11);
        if (add(r11) == true) goto L5;
        Throwable r12 = this.error;
        if (r12 == null) goto L11;
        r10.onError(r12);
        return;
    L11:
        r10.onCompleted();
        return;
    L5:
        if (r11.isUnsubscribed() == false) goto L7;
        remove(r11);
        return;
    L7:
        drain();
    }
}
