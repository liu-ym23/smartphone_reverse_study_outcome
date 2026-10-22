package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSampleWithObservable$SampleMainEmitLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip;

    public ObservableSampleWithObservable$SampleMainEmitLast(Observer<? super T> r10, ObservableSource<?> r11) {
        super(r10, r11);
        this.wip = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void completion() {
        this.done = true;
        if (this.wip.getAndIncrement() != 0) goto L6;
        emit();
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void run() {
        if (this.wip.getAndIncrement() != 0) goto L10;
    L4:
        boolean r10 = this.done;
        emit();
        if (r10 == true) goto L6;
        if (this.wip.decrementAndGet() != 0) goto L4;
        return;
    L6:
        this.downstream.onComplete();
        return;
    }
}
