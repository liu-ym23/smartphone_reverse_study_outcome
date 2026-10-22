package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    final Observer<? super of.a> downstream;
    final Map<Object, d> groups;
    final Function<? super T, ? extends K> keySelector;
    Disposable upstream;
    final Function<? super T, ? extends V> valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public ObservableGroupBy$GroupByObserver(Observer<? super of.a> r10, Function<? super T, ? extends K> r11, Function<? super T, ? extends V> r12, int r13, boolean r14) {
        this.cancelled = new AtomicBoolean();
        this.downstream = r10;
        this.keySelector = r11;
        this.valueSelector = r12;
        this.bufferSize = r13;
        this.delayError = r14;
        this.groups = new ConcurrentHashMap();
        lazySet(1);
    }

    public void cancel(K r10) {
        if (r10 != null) goto L5;
        r10 = (K) NULL_KEY;
    L5:
        this.groups.remove(r10);
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        ArrayList r10 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).onComplete();
        goto L4
    L6:
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        ArrayList r11 = new ArrayList(this.groups.values());
        this.groups.clear();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((d) r12.next()).onError(r10);
        goto L4
    L6:
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        K r11 = this.keySelector.apply(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L5;
        Object r12 = r11;
    L6:
        d r13 = this.groups.get(r12);
        if (r13 == null) goto L9;
    L23:
        r13.onNext(io.reactivex.internal.functions.a.b(this.valueSelector.apply(r10), "The value supplied is null"));
        return;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
        return;
    L9:
        if (this.cancelled.get() == false) goto L11;
        return;
    L11:
        r13 = d.c(r11, this.bufferSize, this, this.delayError);
        this.groups.put(r12, r13);
        getAndIncrement();
        this.downstream.onNext(r13);
        goto L23
    L5:
        r12 = NULL_KEY;
    L18:
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
