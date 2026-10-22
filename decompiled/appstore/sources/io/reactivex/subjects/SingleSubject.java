package io.reactivex.subjects;

import androidx.appcompat.widget.p;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import mf.g;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SingleSubject extends g implements SingleObserver {

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        public SingleDisposable(SingleObserver<? super T> r10, SingleSubject r11) {
            this.downstream = r10;
            lazySet(r11);
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
