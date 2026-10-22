package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PublishSubject extends a {

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject parent;

        public PublishDisposable(Observer<? super T> r10, PublishSubject r11) {
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            if (get() == false) goto L5;
            qf.a.e(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }

        public void onNext(T r10) {
            if (get() == true) goto L6;
            this.downstream.onNext(r10);
            return;
        }
    }
}
