package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
    static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED = null;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    volatile long unique;
    Disposable upstream;

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r10 = new ObservableSwitchMap$SwitchMapInnerObserver(null, -1, 1);
        CANCELLED = r10;
        r10.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(Observer<? super R> r10, Function<? super T, ? extends ObservableSource<? extends R>> r11, int r12, boolean r13) {
        this.active = new AtomicReference();
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.delayErrors = r13;
        this.errors = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
        return;
    }

    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r10 = this.active.get();
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r11 = CANCELLED;
        if (r10 == r11) goto L9;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r12 = this.active.getAndSet((ObservableSwitchMap$SwitchMapInnerObserver<T, R>) r11);
        if (r12 == r11) goto L10;
        if (r12 == null) goto L11;
        r12.cancel();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super R> r10 = this.downstream;
        AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r11 = this.active;
        boolean r12 = this.delayErrors;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.done == true) goto L12;
    L29:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r14 = r11.get();
        if (r14 == null) goto L76;
        SimpleQueue<R> r15 = r14.queue;
        if (r15 == null) goto L76;
        if (r14.done == false) goto L45;
        boolean r16 = r15.isEmpty();
        if (r12 == true) goto L37;
        if (this.errors.get() != null) goto L41;
        if (r16 == false) goto L45;
        p.a(r11, r14, null);
        goto L7
    L41:
        r10.onError(this.errors.terminate());
        return;
    L37:
        if (r16 == false) goto L45;
        p.a(r11, r14, null);
    L45:
        boolean r17 = false;
    L47:
        if (this.cancelled == true) goto L48;
        if (r14 != r11.get()) goto L51;
        if (r12 == false) goto L54;
    L57:
        boolean r18 = r14.done;
        a3.a r19 = r15.poll();     // Catch: Throwable -> L60
    L66:
        if (r19 != null) goto L68;
        boolean r110 = true;
    L69:
        if (r18 == false) goto L72;
        if (r110 == false) goto L72;
        p.a(r11, r14, null);
    L72:
        if (r110 == true) goto L73;
        r10.onNext(r19);
    L73:
        if (r17 == false) goto L76;
    L68:
        r110 = false;
    L60:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        p.a(r11, r14, null);
        if (r12 == true) goto L64;
        disposeInner();
        this.upstream.dispose();
        this.done = true;
    L65:
        r17 = true;
        r19 = null;
        goto L66
    L64:
        r14.cancel();
        goto L65
    L54:
        if (this.errors.get() == null) goto L57;
        r10.onError(this.errors.terminate());
        return;
    L51:
        r17 = true;
        goto L73
    L48:
        return;
    L76:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L12:
        if (r11.get() != null) goto L14;
        boolean r20 = true;
    L15:
        if (r12 == false) goto L23;
        if (r20 == false) goto L29;
        Throwable r111 = this.errors.get();
        if (r111 == null) goto L20;
        r10.onError(r111);
        return;
    L20:
        r10.onComplete();
        return;
    L23:
        if (this.errors.get() != null) goto L24;
        if (r20 == false) goto L29;
        r10.onComplete();
        return;
    L24:
        r10.onError(this.errors.terminate());
        return;
    L14:
        r20 = false;
        goto L15
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> r10, Throwable r11) {
        if (r10.index == this.unique) goto L5;
    L10:
        qf.a.e(r11);
        return;
    L5:
        if (this.errors.addThrowable(r11) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        this.upstream.dispose();
        this.done = true;
    L9:
        r10.done = true;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        drain();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L5;
    L10:
        qf.a.e(r10);
        return;
    L5:
        if (this.errors.addThrowable(r10) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        disposeInner();
    L9:
        this.done = true;
        drain();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        long r11 = this.unique + 1;
        this.unique = r11;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r12 = this.active.get();
        if (r12 == null) goto L17;
        r12.cancel();
    L17:
        ObservableSource r13 = (ObservableSource) io.reactivex.internal.functions.a.b(this.mapper.apply(r10), "The ObservableSource returned is null");     // Catch: Throwable -> L14
        ObservableSwitchMap$SwitchMapInnerObserver r14 = new ObservableSwitchMap$SwitchMapInnerObserver(this, r11, this.bufferSize);
    L7:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r15 = this.active.get();
        if (r15 == CANCELLED) goto L22;
        if (p.a(this.active, r15, r14) == false) goto L7;
        r13.subscribe(r14);
        return;
    L22:
        return;
    L14:
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
}
