package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ResourceObserver<T> implements Observer<T>, Disposable {
    private final ListCompositeDisposable resources;
    private final AtomicReference<Disposable> upstream;

    protected void onStart() {
    }

    public ResourceObserver() {
        this.upstream = new AtomicReference();
        this.resources = new ListCompositeDisposable();
    }

    public final void add(Disposable r2) {
        ObjectHelper.requireNonNull(r2, "resource is null");
        this.resources.add(r2);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r3) {
        if (EndConsumerHelper.setOnce(this.upstream, r3, getClass()) == false) goto L6;
        onStart();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.dispose(this.upstream) == false) goto L6;
        this.resources.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }
}
