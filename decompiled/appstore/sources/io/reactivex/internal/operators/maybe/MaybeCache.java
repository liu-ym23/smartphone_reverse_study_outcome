package io.reactivex.internal.operators.maybe;

import androidx.appcompat.widget.p;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MaybeCache extends mf.c implements MaybeObserver {

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> downstream;

        public CacheDisposable(MaybeObserver<? super T> r10, MaybeCache r11) {
            super(r11);
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            p.a(getAndSet(null));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }
    }
}
