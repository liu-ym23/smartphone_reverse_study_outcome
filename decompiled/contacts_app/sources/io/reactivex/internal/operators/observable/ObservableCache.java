package io.reactivex.internal.operators.observable;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] EMPTY = null;
    static final CacheDisposable[] TERMINATED = null;
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once;
    volatile long size;
    Node<T> tail;
    int tailOffset;

    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> r1, ObservableCache<T> r2) {
            this.downstream = r1;
            this.parent = r2;
            this.node = r2.head;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L6;
            this.disposed = true;
            this.parent.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int r1) {
            this.values = (T[]) new Object[r1];
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
    }

    static {
        EMPTY = new CacheDisposable[0];
        TERMINATED = new CacheDisposable[0];
    }

    public ObservableCache(Observable<T> r1, int r2) {
        super(r1);
        this.capacityHint = r2;
        this.once = new AtomicBoolean();
        Node<T> r3 = new Node(r2);
        this.head = r3;
        this.tail = r3;
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        CacheDisposable<T> r0 = new CacheDisposable(r4, this);
        r4.onSubscribe(r0);
        add(r0);
        if (this.once.get() == false) goto L5;
    L7:
        replay(r0);
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.source.subscribe(this);
    }

    boolean isConnected() {
        return this.once.get();
    }

    boolean hasObservers() {
        if (this.observers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    long cachedEventCount() {
        return this.size;
    }

    void add(CacheDisposable<T> r5) {
    L2:
        CacheDisposable<T>[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        CacheDisposable[] r2 = new CacheDisposable[r1 + 1];
        System.arraycopy(r0, 0, r2, 0, r1);
        r2[r1] = r5;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.observers, r0, r2) == false) goto L2;
        return;
    }

    void remove(CacheDisposable<T> r7) {
    L2:
        CacheDisposable<T>[] r0 = this.observers.get();
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0[r3] == r7) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L13;
        if (r1 != 1) goto L17;
        CacheDisposable[] r2 = EMPTY;
    L19:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.observers, r0, r2) == false) goto L2;
        return;
    L17:
        CacheDisposable[] r5 = new CacheDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L19
    L13:
        return;
    L11:
        r3 = -1;
        goto L12
    }

    void replay(CacheDisposable<T> r13) {
        if (r13.getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r0 = r13.index;
        int r2 = r13.offset;
        Node<T> r3 = r13.node;
        Observer<? super T> r4 = r13.downstream;
        int r5 = this.capacityHint;
        int r7 = 1;
    L7:
        if (r13.disposed == true) goto L8;
        boolean r8 = this.done;
        if (this.size != r0) goto L13;
        boolean r10 = true;
    L14:
        if (r8 == false) goto L21;
        if (r10 == false) goto L21;
        r13.node = null;
        Throwable r12 = this.error;
        if (r12 == null) goto L19;
        r4.onError(r12);
        return;
    L19:
        r4.onComplete();
        return;
    L21:
        if (r10 == false) goto L22;
        r13.index = r0;
        r13.offset = r2;
        r13.node = r3;
        r7 = r13.addAndGet(-r7);
        if (r7 != 0) goto L7;
        return;
    L22:
        if (r2 != r5) goto L24;
        r3 = r3.next;
        r2 = 0;
    L24:
        r4.onNext(r3.values[r2]);
        r2 = r2 + 1;
        r0 = r0 + 1;
        goto L7
    L13:
        r10 = false;
        goto L14
    L8:
        r13.node = null;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r6) {
        int r0 = this.tailOffset;
        int r2 = 0;
        if (r0 != this.capacityHint) goto L5;
        Node<T> r1 = new Node(r0);
        r1.values[0] = r6;
        this.tailOffset = 1;
        this.tail.next = r1;
        this.tail = r1;
    L6:
        this.size++;
        CacheDisposable<T>[] r7 = this.observers.get();
        int r3 = r7.length;
    L7:
        if (r2 >= r3) goto L9;
        replay(r7[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L5:
        this.tail.values[r0] = r6;
        this.tailOffset = r0 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r4) {
        this.error = r4;
        this.done = true;
        CacheDisposable<T>[] r5 = this.observers.getAndSet(TERMINATED);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        replay(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.done = true;
        CacheDisposable<T>[] r0 = this.observers.getAndSet(TERMINATED);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        replay(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }
}
