package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observers.SerializedObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(Observable<T> r1) {
        super(r1);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r2) {
        this.source.subscribe(new SerializedObserver(r2));
    }
}
