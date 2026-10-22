package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    volatile Throwable error;
    final Lock lock;
    final io.reactivex.internal.queue.a queue;

    public BlockingObservableIterable$BlockingObservableIterator(int r10) {
        this.queue = new io.reactivex.internal.queue.a(r10);
        ReentrantLock r11 = new ReentrantLock();
        this.lock = r11;
        this.condition = r11.newCondition();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
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
        io.reactivex.internal.util.b.a();     // Catch: InterruptedException -> L30
        this.lock.lock();     // Catch: InterruptedException -> L30
    L40:
    L27:
        th = move-exception;
        this.lock.unlock();     // Catch: InterruptedException -> L30
        throw th;     // Catch: InterruptedException -> L30
    L20:
        if (this.done == true) goto L29;
        if (this.queue.isEmpty() == false) goto L29;
        if (isDisposed() == true) goto L29;
        this.condition.await();     // Catch: Throwable -> L27
    L29:
        this.lock.unlock();     // Catch: InterruptedException -> L30
    L30:
        e = move-exception;
        DisposableHelper.dispose(this);
        signalConsumer();
        throw ExceptionHelper.d(e);
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
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        return (T) this.queue.poll();
    L7:
        throw new NoSuchElementException();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        signalConsumer();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.queue.offer(r10);
        signalConsumer();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
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
