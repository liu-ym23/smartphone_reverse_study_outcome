package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableResumeNext$ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    private static final long serialVersionUID = 5018523762564524046L;
    final CompletableObserver downstream;
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    boolean once;

    public CompletableResumeNext$ResumeNextObserver(CompletableObserver r10, Function<? super Throwable, ? extends CompletableSource> r11) {
        this.downstream = r10;
        this.errorMapper = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.CompletableObserver
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r10) {
        if (this.once == false) goto L6;
        this.downstream.onError(r10);
        return;
    L6:
        this.once = true;
        ((CompletableSource) io.reactivex.internal.functions.a.b(this.errorMapper.apply(r10), "The errorMapper returned a null CompletableSource")).subscribe(this);
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this, r10);
    }
}
