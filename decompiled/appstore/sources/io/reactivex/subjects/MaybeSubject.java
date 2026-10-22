package io.reactivex.subjects;

import androidx.appcompat.widget.p;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import mf.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MaybeSubject extends c implements MaybeObserver {

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final MaybeObserver<? super T> downstream;

        public MaybeDisposable(MaybeObserver<? super T> r10, MaybeSubject r11) {
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
