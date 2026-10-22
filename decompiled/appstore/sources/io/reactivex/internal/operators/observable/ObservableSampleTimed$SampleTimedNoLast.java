package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableSampleTimed$SampleTimedNoLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    public ObservableSampleTimed$SampleTimedNoLast(Observer<? super T> r10, long r11, TimeUnit r12, mf.f r13) {
        super(r10, r11, r12, r13);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
    public void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
