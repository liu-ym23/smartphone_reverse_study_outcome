package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {
    final AtomicInteger clients;
    final Consumer<? super Disposable> connection;
    final int numberOfObservers;
    final ConnectableObservable<? extends T> source;

    public ObservableAutoConnect(ConnectableObservable<? extends T> r1, int r2, Consumer<? super Disposable> r3) {
        this.source = r1;
        this.numberOfObservers = r2;
        this.connection = r3;
        this.clients = new AtomicInteger();
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r2) {
        this.source.subscribe(r2);
        if (this.clients.incrementAndGet() != this.numberOfObservers) goto L6;
        this.source.connect(this.connection);
        return;
    }
}
