package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ObservableSwitchMapCompletable$SwitchMapCompletableObserver implements Observer, Disposable {

    public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = -8003404460084760287L;
        final ObservableSwitchMapCompletable$SwitchMapCompletableObserver parent;

        public SwitchMapInnerObserver(ObservableSwitchMapCompletable$SwitchMapCompletableObserver r10) {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            throw null;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            throw null;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }
}
