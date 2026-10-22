package io.reactivex.subjects;

import androidx.appcompat.widget.p;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CompletableSubject extends mf.a implements CompletableObserver {

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver downstream;

        public CompletableDisposable(CompletableObserver r10, CompletableSubject r11) {
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
