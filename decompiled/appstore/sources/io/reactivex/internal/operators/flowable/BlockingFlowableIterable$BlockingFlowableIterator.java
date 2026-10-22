package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    volatile Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int r10) {
        this.queue = new SpscArrayQueue(r10);
        this.batchSize = r10;
        this.limit = r10 - (r10 >> 2);
        ReentrantLock r11 = new ReentrantLock();
        this.lock = r11;
        this.condition = r11.newCondition();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
    L3:
        if (isDisposed() == true) goto L4;
        boolean r10 = this.done;
        boolean r11 = this.queue.isEmpty();
        if (r10 == false) goto L17;
        Throwable r12 = this.error;
        if (r12 != null) goto L16;
        if (r11 == false) goto L17;
        return false;
    L16:
        throw ExceptionHelper.d(r12);
    L17:
        if (r11 == false) goto L36;
        io.reactivex.internal.util.b.a();
        this.lock.lock();
    L38:
    L27:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L29:
        e = move-exception;
        run();     // Catch: Throwable -> L27
        throw ExceptionHelper.d(e);     // Catch: Throwable -> L27
    L20:
        if (this.done == true) goto L31;
        if (this.queue.isEmpty() == false) goto L31;
        if (isDisposed() == true) goto L31;
        this.condition.await();     // Catch: Throwable -> L27 InterruptedException -> L29
    L31:
        this.lock.unlock();
        goto L3
    L36:
        return true;
    L4:
        Throwable r13 = this.error;
        if (r13 != null) goto L8;
        return false;
    L8:
        throw ExceptionHelper.d(r13);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L10;
        T r10 = this.queue.poll();
        long r11 = this.produced + 1;
        if (r11 != this.limit) goto L7;
        this.produced = 0;
        get().request(r11);
    L8:
        return r10;
    L7:
        this.produced = r11;
        goto L8
    L10:
        throw new NoSuchElementException();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        signalConsumer();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L5;
        SubscriptionHelper.cancel(this);
        onError(new MissingBackpressureException("Queue full?!"));
        return;
    L5:
        signalConsumer();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, this.batchSize);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public void signalConsumer() {
        this.lock.lock();
        this.condition.signalAll();     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }
}
