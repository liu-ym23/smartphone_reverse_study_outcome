package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import mf.g;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SingleCache extends g implements SingleObserver {

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> downstream;
        final SingleCache parent;

        public CacheDisposable(SingleObserver<? super T> r10, SingleCache r11) {
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
    }
}
