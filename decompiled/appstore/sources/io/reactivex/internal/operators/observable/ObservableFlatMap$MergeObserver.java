package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
    static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = null;
    static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = null;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super U> downstream;
    final AtomicThrowable errors;
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    volatile SimplePlainQueue<U> queue;
    Queue<ObservableSource<? extends U>> sources;
    long uniqueId;
    Disposable upstream;
    int wip;

    static {
        EMPTY = new ObservableFlatMap$InnerObserver[0];
        CANCELLED = new ObservableFlatMap$InnerObserver[0];
    }

    public ObservableFlatMap$MergeObserver(Observer<? super U> r10, Function<? super T, ? extends ObservableSource<? extends U>> r11, boolean r12, int r13, int r14) {
        this.errors = new AtomicThrowable();
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.maxConcurrency = r13;
        this.bufferSize = r14;
        if (r13 == Integer.MAX_VALUE) goto L5;
        this.sources = new ArrayDeque(r13);
    L5:
        this.observers = new AtomicReference(EMPTY);
    }

    public boolean addInner(ObservableFlatMap$InnerObserver<T, U> r10) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = this.observers.get();
        if (r11 == CANCELLED) goto L4;
        int r12 = r11.length;
        ObservableFlatMap$InnerObserver[] r13 = new ObservableFlatMap$InnerObserver[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.observers, r11, r13) == false) goto L2;
        return true;
    L4:
        r10.dispose();
        return false;
    }

    public boolean checkTerminate() {
        if (this.cancelled == false) goto L5;
        return true;
    L5:
        Throwable r10 = this.errors.get();
        if (this.delayErrors == true) goto L12;
        if (r10 == null) goto L14;
        disposeAll();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f20726a) goto L11;
        this.downstream.onError(r11);
    L11:
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L12;
        this.cancelled = true;
        if (disposeAll() == false) goto L13;
        Throwable r10 = this.errors.terminate();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10 == ExceptionHelper.f20726a) goto L15;
        qf.a.e(r10);
        return;
    L15:
        return;
    L13:
        return;
    }

    public boolean disposeAll() {
        this.upstream.dispose();
        ObservableFlatMap$InnerObserver<?, ?>[] r10 = this.observers.get();
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = CANCELLED;
        int r12 = 0;
        if (r10 == r11) goto L11;
        ObservableFlatMap$InnerObserver<?, ?>[] r13 = this.observers.getAndSet(r11);
        if (r13 == r11) goto L11;
        int r14 = r13.length;
    L7:
        if (r12 >= r14) goto L9;
        r13[r12].dispose();
        r12 = r12 + 1;
        goto L7
    L9:
        return true;
    L11:
        return false;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainLoop() {
        Observer<? super U> r10 = this.downstream;
        int r11 = 1;
    L4:
        if (checkTerminate() == true) goto L5;
        SimplePlainQueue<U> r12 = this.queue;
        if (r12 != null) goto L9;
    L15:
        boolean r13 = this.done;
        SimplePlainQueue<U> r14 = this.queue;
        ObservableFlatMap$InnerObserver<?, ?>[] r15 = this.observers.get();
        int r16 = r15.length;
        int r17 = 0;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
        monitor-enter(this);
        int r18 = this.sources.size();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
    L25:
        if (r13 == false) goto L37;
        if (r14 != null) goto L28;
    L29:
        if (r16 != 0) goto L37;
        if (r18 != 0) goto L37;
        Throwable r19 = this.errors.terminate();
        if (r19 == ExceptionHelper.f20726a) goto L143;
        if (r19 != null) goto L35;
        r10.onComplete();
        return;
    L35:
        r10.onError(r19);
        return;
    L143:
        return;
    L28:
        if (r14.isEmpty() == true) goto L29;
    L37:
        if (r16 == 0) goto L88;
        long r20 = this.lastId;
        int r21 = this.lastIndex;
        if (r16 > r21) goto L41;
    L42:
        if (r16 > r21) goto L44;
        r21 = 0;
    L44:
        int r110 = 0;
    L45:
        if (r110 >= r16) goto L53;
        if (r15[r21].f20665id == r20) goto L53;
        r21 = r21 + 1;
        if (r21 != r16) goto L52;
        r21 = 0;
    L52:
        r110 = r110 + 1;
    L53:
        this.lastIndex = r21;
        this.lastId = r15[r21].f20665id;
    L54:
        int r22 = 0;
        int r23 = 0;
    L55:
        if (r22 >= r16) goto L87;
        if (checkTerminate() == true) goto L58;
        ObservableFlatMap$InnerObserver<T, U> r111 = r15[r21];
        SimpleQueue<U> r112 = r111.queue;
        if (r112 != null) goto L109;
    L74:
        boolean r113 = r111.done;
        SimpleQueue<U> r114 = r111.queue;
        if (r113 == false) goto L83;
        if (r114 != null) goto L78;
    L79:
        removeInner(r111);
        if (checkTerminate() == true) goto L81;
        r23 = r23 + 1;
        goto L83
    L81:
        return;
    L78:
        if (r114.isEmpty() == true) goto L79;
    L83:
        r21 = r21 + 1;
        if (r21 != r16) goto L86;
    L85:
        r21 = 0;
    L86:
        r22 = r22 + 1;
    L109:
        U r115 = r112.poll();     // Catch: Throwable -> L67
        if (r115 == null) goto L74;
        r10.onNext(r115);
        if (checkTerminate() == false) goto L109;
        return;
    L67:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r111.dispose();
        this.errors.addThrowable(th);
        if (checkTerminate() == true) goto L70;
        removeInner(r111);
        r23 = r23 + 1;
        r21 = r21 + 1;
        if (r21 != r16) goto L86;
    L70:
        return;
    L58:
        return;
    L87:
        this.lastIndex = r21;
        this.lastId = r15[r21].f20665id;
        r17 = r23;
        goto L88
    L41:
        if (r15[r21].f20665id == r20) goto L54;
    L88:
        if (r17 != 0) goto L90;
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L90:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
    L91:
        int r24 = r17 - 1;
        if (r17 == 0) goto L4;
        monitor-enter(this);
        ObservableSource<? extends U> r25 = this.sources.poll();     // Catch: Throwable -> L99
        if (r25 != null) goto L101;
        this.wip--;     // Catch: Throwable -> L99
        monitor-exit(this);     // Catch: Throwable -> L99
    L103:
        r17 = r24;
        goto L91
    L101:
        monitor-exit(this);     // Catch: Throwable -> L99
        subscribeInner(r25);
    L99:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    L24:
        r18 = 0;
    L9:
        if (checkTerminate() == true) goto L10;
        U r26 = r12.poll();
        if (r26 == null) goto L15;
        r10.onNext(r26);
        goto L9
    L10:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L7;
        qf.a.e(r10);
        return;
    L7:
        if (this.errors.addThrowable(r10) == false) goto L9;
        this.done = true;
        drain();
        return;
    L9:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L26;
        return;
    L26:
        ObservableSource<? extends U> r11 = (ObservableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L23
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L21;
        monitor-enter(this);
        int r12 = this.wip;     // Catch: Throwable -> L14
        if (r12 != this.maxConcurrency) goto L16;
        this.sources.offer(r11);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L16:
        this.wip = r12 + 1;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L21:
        subscribeInner(r11);
        return;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeInner(ObservableFlatMap$InnerObserver<T, U> r10) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = this.observers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13] == r10) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        ObservableFlatMap$InnerObserver<?, ?>[] r14 = EMPTY;
    L19:
        if (p.a(this.observers, r11, r14) == false) goto L2;
        return;
    L17:
        ObservableFlatMap$InnerObserver<?, ?>[] r15 = new ObservableFlatMap$InnerObserver[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L19
    L13:
        return;
    L11:
        r13 = -1;
        goto L12
    }

    public void subscribeInner(ObservableSource<? extends U> r10) {
    L3:
        if ((r10 instanceof Callable) == false) goto L20;
        if (tryEmitScalar((Callable) r10) == false) goto L33;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L34;
        monitor-enter(this);
        r10 = this.sources.poll();     // Catch: Throwable -> L12
        if (r10 != null) goto L14;
        boolean r11 = true;
        this.wip--;     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r11 == false) goto L3;
        drain();
        return;
    L14:
        r11 = false;
    L12:
        th = move-exception;
        throw th;
    L34:
        return;
    L33:
        return;
    L20:
        long r12 = this.uniqueId;
        this.uniqueId = 1 + r12;
        ObservableFlatMap$InnerObserver<T, U> r13 = new ObservableFlatMap$InnerObserver(this, r12);
        if (addInner(r13) == false) goto L32;
        r10.subscribe(r13);
        return;
    }

    public void tryEmit(U r10, ObservableFlatMap$InnerObserver<T, U> r11) {
        if (get() == 0) goto L5;
    L9:
        SimpleQueue r12 = r11.queue;
        if (r12 != null) goto L12;
        r12 = new io.reactivex.internal.queue.a(this.bufferSize);
        r11.queue = r12;
    L12:
        r12.offer(r10);
        if (getAndIncrement() == 0) goto L15;
        return;
    L15:
        drainLoop();
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L9;
        this.downstream.onNext(r10);
        if (decrementAndGet() != 0) goto L15;
    }

    public boolean tryEmitScalar(Callable<? extends U> r10) {
        U r11 = r10.call();     // Catch: Throwable -> L29
        if (r11 != null) goto L7;
        return true;
    L7:
        if (get() == 0) goto L9;
    L13:
        SimplePlainQueue<U> r12 = this.queue;
        if (r12 != null) goto L21;
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
        r12 = new io.reactivex.internal.queue.a(this.bufferSize);
    L19:
        this.queue = r12;
        goto L21
    L18:
        r12 = new SpscArrayQueue(this.maxConcurrency);
    L21:
        if (r12.offer(r11) == true) goto L25;
        onError(new IllegalStateException("Scalar queue full?!"));
        return true;
    L25:
        if (getAndIncrement() == 0) goto L27;
        return false;
    L27:
        drainLoop();
        return true;
    L9:
        if (compareAndSet(0, 1) == false) goto L13;
        this.downstream.onNext(r11);
        if (decrementAndGet() != 0) goto L27;
        return true;
    L29:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        drain();
        return true;
    }
}
