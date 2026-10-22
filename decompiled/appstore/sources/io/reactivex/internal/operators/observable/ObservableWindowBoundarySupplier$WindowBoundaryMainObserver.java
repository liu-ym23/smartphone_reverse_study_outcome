package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableWindowBoundarySupplier$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
    static final l BOUNDARY_DISPOSED = null;
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<l> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final Observer<? super mf.e> downstream;
    final AtomicThrowable errors;
    final Callable<? extends ObservableSource<B>> other;
    final MpscLinkedQueue queue;
    final AtomicBoolean stopWindows;
    Disposable upstream;
    UnicastSubject window;
    final AtomicInteger windows;

    static {
        BOUNDARY_DISPOSED = new l(null);
        NEXT_WINDOW = new Object();
    }

    public ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(Observer<? super mf.e> r10, int r11, Callable<? extends ObservableSource<B>> r12) {
        this.downstream = r10;
        this.capacityHint = r11;
        this.boundaryObserver = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.other = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        disposeBoundary();
        if (this.windows.decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    L9:
        return;
    }

    public void disposeBoundary() {
        AtomicReference<l> r10 = this.boundaryObserver;
        l r11 = BOUNDARY_DISPOSED;
        l r12 = r10.getAndSet(r11);
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        r12.dispose();
        return;
    L8:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super mf.e> r10 = this.downstream;
        MpscLinkedQueue r11 = this.queue;
        AtomicThrowable r12 = this.errors;
        int r13 = 1;
    L7:
        if (this.windows.get() == 0) goto L8;
        UnicastSubject r14 = this.window;
        boolean r15 = this.done;
        if (r15 == true) goto L13;
    L19:
        Object r16 = r11.poll();
        if (r16 != null) goto L22;
        boolean r17 = true;
    L23:
        if (r15 == false) goto L34;
        if (r17 == false) goto L34;
        Throwable r18 = r12.terminate();
        if (r18 != null) goto L30;
        if (r14 == null) goto L29;
        this.window = null;
        r14.onComplete();
    L29:
        r10.onComplete();
        return;
    L30:
        if (r14 == null) goto L32;
        this.window = null;
        r14.onError(r18);
    L32:
        r10.onError(r18);
        return;
    L34:
        if (r17 == true) goto L35;
        if (r16 != NEXT_WINDOW) goto L40;
        if (r14 == null) goto L44;
        this.window = null;
        r14.onComplete();
    L44:
        if (this.stopWindows.get() == true) goto L7;
        UnicastSubject r19 = UnicastSubject.d(this.capacityHint, this);
        this.window = r19;
        this.windows.getAndIncrement();
        ObservableSource r20 = (ObservableSource) io.reactivex.internal.functions.a.b(this.other.call(), "The other Callable returned a null ObservableSource");     // Catch: Throwable -> L50
        l r21 = new l(this);
        if (p.a(this.boundaryObserver, null, r21) == false) goto L7;
        r20.subscribe(r21);
        r10.onNext(r19);
    L50:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r12.addThrowable(th);
        this.done = true;
        goto L7
    L40:
        r14.onNext(r16);
        goto L7
    L35:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L22:
        r17 = false;
        goto L23
    L13:
        if (r12.get() == null) goto L19;
        r11.clear();
        Throwable r22 = r12.terminate();
        if (r14 == null) goto L17;
        this.window = null;
        r14.onError(r22);
    L17:
        r10.onError(r22);
        return;
    L8:
        r11.clear();
        this.window = null;
    }

    public void innerComplete() {
        this.upstream.dispose();
        this.done = true;
        drain();
    }

    public void innerError(Throwable r10) {
        this.upstream.dispose();
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    public void innerNext(l r10) {
        p.a(this.boundaryObserver, r10, null);
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        disposeBoundary();
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        disposeBoundary();
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        this.queue.offer(NEXT_WINDOW);
        drain();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        this.upstream.dispose();
        return;
    }
}
