package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableNever extends Observable<Object> {
    public static final Observable<Object> INSTANCE = null;

    static {
        INSTANCE = new ObservableNever();
    }

    private ObservableNever() {
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> r1) {
        r1.onSubscribe(EmptyDisposable.NEVER);
    }
}
