package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
    static final ReplaySubject$ReplayProducer[] EMPTY = null;
    static final ReplaySubject$ReplayProducer[] TERMINATED = null;
    private static final long serialVersionUID = 5952362471246910544L;
    final ReplaySubject$ReplayBuffer<T> buffer;

    static {
        EMPTY = new ReplaySubject$ReplayProducer[0];
        TERMINATED = new ReplaySubject$ReplayProducer[0];
    }

    public ReplaySubject$ReplayState(ReplaySubject$ReplayBuffer<T> r10) {
        this.buffer = r10;
        lazySet(EMPTY);
    }

    public boolean add(ReplaySubject$ReplayProducer<T> r10) {
    L2:
        ReplaySubject$ReplayProducer<T>[] r11 = get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        ReplaySubject$ReplayProducer[] r13 = new ReplaySubject$ReplayProducer[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    public boolean isTerminated() {
        if (get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rx.Observer
    public void onCompleted() {
        ReplaySubject$ReplayBuffer<T> r10 = this.buffer;
        r10.complete();
        ReplaySubject$ReplayProducer<T>[] r11 = getAndSet(TERMINATED);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.drain(r11[r13]);
        r13 = r13 + 1;
        goto L3
    }

    @Override // rx.Observer
    public void onError(Throwable r10) {
        ReplaySubject$ReplayBuffer<T> r11 = this.buffer;
        r11.error(r10);
        ReplaySubject$ReplayProducer<T>[] r12 = getAndSet(TERMINATED);
        int r13 = r12.length;
        ArrayList r14 = null;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L12;
        r11.drain(r12[r15]);     // Catch: Throwable -> L7
    L11:
        r15 = r15 + 1;
    L7:
        th = move-exception;
        if (r14 != null) goto L10;
        r14 = new ArrayList();
    L10:
        r14.add(th);
        goto L11
    L12:
        rx.exceptions.a.d(r14);
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        ReplaySubject$ReplayBuffer<T> r11 = this.buffer;
        r11.next(r10);
        ReplaySubject$ReplayProducer<T>[] r12 = get();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.drain(r12[r14]);
        r14 = r14 + 1;
        goto L3
    }

    public void remove(ReplaySubject$ReplayProducer<T> r10) {
    L2:
        ReplaySubject$ReplayProducer<T>[] r11 = get();
        if (r11 == TERMINATED) goto L22;
        if (r11 == EMPTY) goto L30;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (r11[r13] == r10) goto L14;
        r13 = r13 + 1;
    L14:
        if (r13 < 0) goto L15;
        if (r12 != 1) goto L19;
        ReplaySubject$ReplayProducer[] r14 = EMPTY;
    L21:
        if (compareAndSet(r11, r14) == false) goto L2;
        return;
    L19:
        ReplaySubject$ReplayProducer[] r15 = new ReplaySubject$ReplayProducer[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L21
    L15:
        return;
    L13:
        r13 = -1;
        goto L14
    L30:
        return;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        ReplaySubject$ReplayProducer<T> r11 = new ReplaySubject$ReplayProducer(r10, this);
        r10.add(r11);
        r10.setProducer(r11);
        if (add(r11) == true) goto L5;
    L8:
        this.buffer.drain(r11);
        return;
    L5:
        if (r11.isUnsubscribed() == false) goto L8;
        remove(r11);
    }
}
