package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncSubject extends a {

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject parent;

        public AsyncDisposable(Observer<? super T> r10, AsyncSubject r11) {
            super(r10);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose() == true) goto L6;
            return;
        L6:
            throw null;
        }

        public void onComplete() {
            if (isDisposed() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            if (isDisposed() == false) goto L5;
            qf.a.e(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }
    }
}
