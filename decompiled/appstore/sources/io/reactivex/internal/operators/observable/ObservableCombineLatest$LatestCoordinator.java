package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    volatile boolean cancelled;
    final Function<? super Object[], ? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    Object[] latest;
    final ObservableCombineLatest$CombinerObserver<T, R>[] observers;
    final io.reactivex.internal.queue.a queue;

    public ObservableCombineLatest$LatestCoordinator(Observer<? super R> r10, Function<? super Object[], ? extends R> r11, int r12, int r13, boolean r14) {
        this.errors = new AtomicThrowable();
        this.downstream = r10;
        this.combiner = r11;
        this.delayError = r14;
        this.latest = new Object[r12];
        ObservableCombineLatest$CombinerObserver<T, R>[] r15 = new ObservableCombineLatest$CombinerObserver[r12];
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r15[r16] = new ObservableCombineLatest$CombinerObserver(this, r16);
        r16 = r16 + 1;
        goto L3
    L5:
        this.observers = r15;
        this.queue = new io.reactivex.internal.queue.a(r13);
    }

    public void cancelSources() {
        ObservableCombineLatest$CombinerObserver<T, R>[] r10 = this.observers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].dispose();
        r12 = r12 + 1;
        goto L3
    }

    public void clear(io.reactivex.internal.queue.a r10) {
        monitor-enter(this);
        this.latest = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r10.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() != 0) goto L9;
        clear(this.queue);
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a r10 = this.queue;
        Observer<? super R> r11 = this.downstream;
        boolean r12 = this.delayError;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r12 == false) goto L12;
    L15:
        boolean r14 = this.done;
        Object[] r15 = (Object[]) r10.poll();
        if (r15 != null) goto L18;
        boolean r16 = true;
    L19:
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        clear(r10);
        Throwable r17 = this.errors.terminate();
        if (r17 != null) goto L24;
        r11.onComplete();
        return;
    L24:
        r11.onError(r17);
        return;
    L26:
        if (r16 == true) goto L27;
        r11.onNext((Object) io.reactivex.internal.functions.a.b(this.combiner.apply(r15), "The combiner returned a null value"));
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        cancelSources();
        clear(r10);
        r11.onError(this.errors.terminate());
        return;
    L27:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L18:
        r16 = false;
        goto L19
    L12:
        if (this.errors.get() == null) goto L15;
        cancelSources();
        clear(r10);
        r11.onError(this.errors.terminate());
        return;
    L8:
        clear(r10);
    }

    public void innerComplete(int r10) {
        monitor-enter(this);
        Object[] r11 = this.latest;     // Catch: Throwable -> L7
        if (r11 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (r11[r10] != null) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == true) goto L16;
        int r13 = this.complete + 1;     // Catch: Throwable -> L7
        this.complete = r13;     // Catch: Throwable -> L7
        if (r13 == r11.length) goto L16;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r12 == false) goto L20;
        cancelSources();
    L20:
        drain();
        return;
    L16:
        this.done = true;     // Catch: Throwable -> L7
        goto L17
    L12:
        r12 = false;
    L7:
        th = move-exception;
        throw th;
    }

    public void innerError(int r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L28;
        boolean r12 = true;
        if (this.delayError == false) goto L25;
        monitor-enter(this);
        Object[] r13 = this.latest;     // Catch: Throwable -> L11
        if (r13 != null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L14:
        if (r13[r10] != null) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == true) goto L20;
        int r15 = this.complete + 1;     // Catch: Throwable -> L11
        this.complete = r15;     // Catch: Throwable -> L11
        if (r15 == r13.length) goto L20;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L11
        r12 = r14;
    L20:
        this.done = true;     // Catch: Throwable -> L11
        goto L21
    L16:
        r14 = false;
    L11:
        th = move-exception;
        throw th;
    L25:
        if (r12 == false) goto L27;
        cancelSources();
    L27:
        drain();
        return;
    L28:
        qf.a.e(r11);
    }

    public void innerNext(int r10, T r11) {
        monitor-enter(this);
        Object[] r12 = this.latest;     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Object r13 = r12[r10];     // Catch: Throwable -> L7
        int r14 = this.active;     // Catch: Throwable -> L7
        if (r13 != null) goto L12;
        r14 = r14 + 1;     // Catch: Throwable -> L7
        this.active = r14;     // Catch: Throwable -> L7
    L12:
        r12[r10] = r11;     // Catch: Throwable -> L7
        if (r14 != r12.length) goto L15;
        this.queue.offer(r12.clone());     // Catch: Throwable -> L7
        boolean r15 = true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r15 == false) goto L23;
        drain();
        return;
    L23:
        return;
    L15:
        r15 = false;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(ObservableSource<? extends T>[] r10) {
        ObservableCombineLatest$CombinerObserver<T, R>[] r11 = this.observers;
        int r12 = r11.length;
        this.downstream.onSubscribe(this);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        if (this.done == true) goto L14;
        if (this.cancelled == true) goto L15;
        r10[r13].subscribe(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }
}
