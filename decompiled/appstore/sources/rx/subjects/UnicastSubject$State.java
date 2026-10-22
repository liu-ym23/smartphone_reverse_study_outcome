package rx.subjects;

import androidx.lifecycle.p;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.e;
import rx.internal.util.atomic.f;
import rx.internal.util.unsafe.e0;
import rx.internal.util.unsafe.x;
import rx.internal.util.unsafe.y;

/* JADX INFO: loaded from: classes4.dex */
final class UnicastSubject$State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
    private static final long serialVersionUID = -9044104859202255786L;
    volatile boolean caughtUp;
    final boolean delayError;
    volatile boolean done;
    boolean emitting;
    Throwable error;
    boolean missed;
    final Queue<Object> queue;
    final AtomicReference<Subscriber> subscriber;
    final AtomicReference<Action0> terminateOnce;

    public UnicastSubject$State(int r10, boolean r11, Action0 r12) {
        this.subscriber = new AtomicReference();
        if (r12 == null) goto L5;
        AtomicReference<Action0> r13 = new AtomicReference(r12);
    L6:
        this.terminateOnce = r13;
        this.delayError = r11;
        if (r10 <= 1) goto L13;
        if (e0.b() == false) goto L11;
        Queue<Object> r14 = new y(r10);
    L17:
        this.queue = r14;
        return;
    L11:
        r14 = new f(r10);
        goto L17
    L13:
        if (e0.b() == false) goto L16;
        Queue<Object> r15 = new x();
    L15:
        r14 = r15;
        goto L17
    L16:
        r15 = new e();
        goto L15
    L5:
        r13 = null;
        goto L6
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    public boolean checkTerminated(boolean r10, boolean r11, boolean r12, Subscriber r13) {
        if (r13.isUnsubscribed() == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == false) goto L17;
        Throwable r14 = this.error;
        if (r14 == null) goto L12;
        if (r12 == true) goto L12;
        this.queue.clear();
        r13.onError(r14);
        return true;
    L12:
        if (r11 == false) goto L19;
        if (r14 == null) goto L15;
        r13.onError(r14);
    L16:
        return true;
    L15:
        r13.onCompleted();
        goto L16
    L19:
        return false;
    L17:
        return false;
    }

    public void doTerminate() {
        AtomicReference<Action0> r10 = this.terminateOnce;
        if (r10 == null) goto L10;
        Action0 r11 = r10.get();
        if (r11 != null) goto L7;
        return;
    L7:
        if (p.a(r10, r11, null) == false) goto L12;
        r11.call();
        return;
    L12:
        return;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.done;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.done == true) goto L19;
        doTerminate();
        this.done = true;
        if (this.caughtUp == true) goto L15;
        monitor-enter(this);
        boolean r10 = this.caughtUp;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r10 == true) goto L15;
        replay();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        this.subscriber.get().onCompleted();
        return;
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        if (this.done == true) goto L19;
        doTerminate();
        this.error = r10;
        this.done = true;
        if (this.caughtUp == true) goto L15;
        monitor-enter(this);
        boolean r11 = this.caughtUp;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r11 == true) goto L15;
        replay();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        this.subscriber.get().onError(r10);
        return;
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (this.caughtUp == true) goto L19;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.caughtUp == true) goto L12;
        this.queue.offer(NotificationLite.g(r10));     // Catch: Throwable -> L10
        boolean r11 = true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r11 == false) goto L19;
        replay();
        return;
    L12:
        r11 = false;
    L19:
        Subscriber r12 = this.subscriber.get();
        r12.onNext(r10);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        rx.exceptions.a.g(th, r12, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replay() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.emitting == false) goto L10;
        this.missed = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        Queue<Object> r10 = this.queue;
        boolean r11 = this.delayError;
    L13:
        Subscriber r12 = this.subscriber.get();
        if (r12 != 0) goto L16;
        boolean r13 = false;
    L45:
        monitor-enter(this);
    L52:
        th = move-exception;
        throw th;
    L47:
        if (this.missed == false) goto L48;
        this.missed = false;     // Catch: Throwable -> L52
        monitor-exit(this);     // Catch: Throwable -> L52
        goto L13
    L48:
        if (r13 == true) goto L50;
    L54:
        this.emitting = false;     // Catch: Throwable -> L52
        monitor-exit(this);     // Catch: Throwable -> L52
        return;
    L50:
        if (r10.isEmpty() == false) goto L54;
        this.caughtUp = true;     // Catch: Throwable -> L52
        goto L54
    L16:
        if (checkTerminated(this.done, r10.isEmpty(), r11, r12) == true) goto L17;
        long r14 = get();
        if (r14 != Long.MAX_VALUE) goto L21;
        r13 = true;
    L22:
        long r15 = 0;
    L24:
        if (r14 == 0) goto L40;
        boolean r16 = this.done;
        Object r17 = r10.poll();
        if (r17 != null) goto L28;
        boolean r18 = true;
    L30:
        if (checkTerminated(r16, r18, r11, r12) == true) goto L31;
        if (r18 == true) goto L40;
        Object r19 = NotificationLite.d(r17);
        r12.onNext(r19);     // Catch: Throwable -> L37
        r14 = r14 - 1;
        r15 = r15 + 1;
    L37:
        th = move-exception;
        r10.clear();
        rx.exceptions.a.e(th);
        r12.onError(OnErrorThrowable.addValueAsLastCause(th, r19));
        return;
    L31:
        return;
    L28:
        r18 = false;
    L40:
        if (r13 == true) goto L45;
        if (r15 == 0) goto L45;
        addAndGet(-r15);
        goto L45
    L21:
        r13 = false;
        goto L22
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L11;
        if (r10 <= 0) goto L7;
        rx.internal.operators.a.b(this, r10);
        replay();
        return;
    L7:
        if (this.done == false) goto L13;
        replay();
        return;
    L13:
        return;
    L11:
        throw new IllegalArgumentException("n >= 0 required");
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        doTerminate();
        this.done = true;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.emitting == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.queue.clear();
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        if (p.a(this.subscriber, null, r10) == false) goto L5;
        r10.add(this);
        r10.setProducer(this);
        return;
    L5:
        r10.onError(new IllegalStateException("Only a single subscriber is allowed"));
    }
}
