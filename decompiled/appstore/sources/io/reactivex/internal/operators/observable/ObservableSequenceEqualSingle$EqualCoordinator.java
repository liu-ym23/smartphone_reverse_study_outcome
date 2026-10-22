package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable {
    private static final long serialVersionUID = -6178010334400373240L;
    volatile boolean cancelled;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final ObservableSource<? extends T> first;
    final h[] observers;
    final ArrayCompositeDisposable resources;
    final ObservableSource<? extends T> second;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    T f20669v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f20670v2;

    public ObservableSequenceEqualSingle$EqualCoordinator(SingleObserver<? super Boolean> r10, int r11, ObservableSource<? extends T> r12, ObservableSource<? extends T> r13, BiPredicate<? super T, ? super T> r14) {
        this.downstream = r10;
        this.first = r12;
        this.second = r13;
        this.comparer = r14;
        this.observers = new h[]{new h(this, 0, r11), new h(this, 1, r11)};
        this.resources = new ArrayCompositeDisposable(2);
    }

    public void cancel(io.reactivex.internal.queue.a r10, io.reactivex.internal.queue.a r11) {
        this.cancelled = true;
        r10.clear();
        r11.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() != 0) goto L9;
        h[] r10 = this.observers;
        r10[0].f20680b.clear();
        r10[1].f20680b.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        h[] r10 = this.observers;
        h r11 = r10[0];
        io.reactivex.internal.queue.a r12 = r11.f20680b;
        h r13 = r10[1];
        io.reactivex.internal.queue.a r14 = r13.f20680b;
        int r15 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r16 = r11.f20682d;
        if (r16 == false) goto L16;
        Throwable r17 = r11.f20683e;
        if (r17 == null) goto L16;
        cancel(r12, r14);
        this.downstream.onError(r17);
        return;
    L16:
        boolean r18 = r13.f20682d;
        if (r18 == false) goto L23;
        Throwable r19 = r13.f20683e;
        if (r19 == null) goto L23;
        cancel(r12, r14);
        this.downstream.onError(r19);
        return;
    L23:
        if (this.f20669v1 != null) goto L26;
        this.f20669v1 = (T) r12.poll();
    L26:
        if (this.f20669v1 != null) goto L28;
        boolean r20 = true;
    L30:
        if (this.f20670v2 != null) goto L32;
        this.f20670v2 = (T) r14.poll();
    L32:
        T r110 = this.f20670v2;
        if (r110 != null) goto L35;
        boolean r111 = true;
    L36:
        if (r16 == false) goto L42;
        if (r18 == false) goto L42;
        if (r20 == false) goto L42;
        if (r111 == false) goto L42;
        this.downstream.onSuccess(Boolean.TRUE);
        return;
    L42:
        if (r16 == false) goto L47;
        if (r18 == false) goto L47;
        if (r20 == r111) goto L47;
        cancel(r12, r14);
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L47:
        if (r20 == true) goto L57;
        if (r111 == true) goto L57;
        if (this.comparer.test(this.f20669v1, r110) == false) goto L51;
        this.f20669v1 = null;
        this.f20670v2 = null;
        goto L57
    L51:
        cancel(r12, r14);
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L54:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel(r12, r14);
        this.downstream.onError(th);
        return;
    L57:
        if (r20 == true) goto L59;
        if (r111 == false) goto L7;
    L59:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L35:
        r111 = false;
        goto L36
    L28:
        r20 = false;
        goto L30
    L8:
        r12.clear();
        r14.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(Disposable r10, int r11) {
        return this.resources.setResource(r11, r10);
    }

    public void subscribe() {
        h[] r10 = this.observers;
        this.first.subscribe(r10[0]);
        this.second.subscribe(r10[1]);
    }
}
