package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {
    private final Action onDispose;
    private final Consumer<? super Disposable> onSubscribe;

    public ObservableDoOnLifecycle(Observable<T> r1, Consumer<? super Disposable> r2, Action r3) {
        super(r1);
        this.onSubscribe = r2;
        this.onDispose = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        this.source.subscribe(new DisposableLambdaObserver(r4, this.onSubscribe, this.onDispose));
    }
}
