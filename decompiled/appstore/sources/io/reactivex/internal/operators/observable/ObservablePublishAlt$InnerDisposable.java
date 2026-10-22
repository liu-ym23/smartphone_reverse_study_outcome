package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservablePublishAlt$InnerDisposable<T> extends AtomicReference<ObservablePublishAlt$PublishConnection<T>> implements Disposable {
    private static final long serialVersionUID = 7463222674719692880L;
    final Observer<? super T> downstream;

    public ObservablePublishAlt$InnerDisposable(Observer<? super T> r10, ObservablePublishAlt$PublishConnection<T> r11) {
        this.downstream = r10;
        lazySet(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        ObservablePublishAlt$PublishConnection<T> r10 = getAndSet(null);
        if (r10 == null) goto L6;
        r10.remove(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
