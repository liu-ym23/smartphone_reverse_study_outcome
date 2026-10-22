package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ObservableCache extends io.reactivex.internal.operators.observable.a implements Observer {

    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        a node;
        int offset;
        final ObservableCache parent;

        public CacheDisposable(Observer<? super T> r10, ObservableCache r11) {
            this.downstream = r10;
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == false) goto L5;
            return;
        L5:
            this.disposed = true;
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class a {
    }
}
