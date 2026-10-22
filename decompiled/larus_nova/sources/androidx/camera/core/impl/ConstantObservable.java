package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = null;
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    public static /* synthetic */ void a(ConstantObservable r100, Observable.Observer r101) {
        r100.lambda$addObserver$0(r101);
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r100) {
    }

    static {
        NULL_OBSERVABLE = new ConstantObservable(null);
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    private ConstantObservable(T r100) {
        this.mValueFuture = Futures.immediateFuture(r100);
    }

    private /* synthetic */ void lambda$addObserver$0(Observable.Observer r100) {
        r100.onNewData(this.mValueFuture.get());     // Catch: InterruptedException -> L4 Throwable -> L6
        return;
    L6:
        e = move-exception;
        r100.onError(e);
    }

    public static <U> Observable<U> withValue(U r100) {
        if (r100 != null) goto L6;
        return NULL_OBSERVABLE;
    L6:
        return new ConstantObservable(r100);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r100, final Observable.Observer<? super T> r101) {
        this.mValueFuture.addListener(new i(this, r101), r100);
    }
}
