package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    public static final Observable<Object> INSTANCE = null;

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    static {
        INSTANCE = new ObservableEmpty();
    }

    private ObservableEmpty() {
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> r1) {
        EmptyDisposable.complete(r1);
    }
}
