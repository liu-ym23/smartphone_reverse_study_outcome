package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleCreate<T> extends Single<T> {
    final SingleOnSubscribe<T> source;

    static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final SingleObserver<? super T> downstream;

        Emitter(SingleObserver<? super T> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.SingleEmitter
        public void onSuccess(T r3) {
            if (get() == DisposableHelper.DISPOSED) goto L15;
            Disposable r0 = getAndSet(DisposableHelper.DISPOSED);
            if (r0 == DisposableHelper.DISPOSED) goto L18;
            if (r3 != null) goto L8;
            this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L11
        L9:
            if (r0 == null) goto L19;
            r0.dispose();
            return;
        L19:
            return;
        L8:
            this.downstream.onSuccess(r3);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (r0 == null) goto L14;
            r0.dispose();
        L14:
            throw th;
        L18:
            return;
        }

        @Override // io.reactivex.SingleEmitter
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.SingleEmitter
        public boolean tryOnError(Throwable r3) {
            if (r3 != null) goto L5;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L5:
            if (get() == DisposableHelper.DISPOSED) goto L17;
            Disposable r0 = getAndSet(DisposableHelper.DISPOSED);
            if (r0 == DisposableHelper.DISPOSED) goto L22;
            this.downstream.onError(r3);     // Catch: Throwable -> L13
            if (r0 == null) goto L21;
            r0.dispose();
            return true;
        L21:
            return true;
        L13:
            th = move-exception;
            if (r0 == null) goto L16;
            r0.dispose();
        L16:
            throw th;
        L22:
            return false;
        L17:
            return false;
        }

        @Override // io.reactivex.SingleEmitter
        public void setDisposable(Disposable r1) {
            DisposableHelper.set(this, r1);
        }

        @Override // io.reactivex.SingleEmitter
        public void setCancellable(Cancellable r2) {
            setDisposable(new CancellableDisposable(r2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    public SingleCreate(SingleOnSubscribe<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r2) {
        Emitter r0 = new Emitter(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.onError(th);
    }
}
