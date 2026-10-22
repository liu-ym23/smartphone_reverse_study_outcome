package io.reactivex.internal.operators.observable;

import androidx.appcompat.widget.p;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservablePublish$InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
    private static final long serialVersionUID = -1100270633763673112L;
    final Observer<? super T> child;

    public ObservablePublish$InnerDisposable(Observer<? super T> r10) {
        this.child = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object r10 = getAndSet(this);
        if (r10 == null) goto L8;
        if (r10 == this) goto L9;
        p.a(r10);
        throw null;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != this) goto L5;
        return true;
    L5:
        return false;
    }

    public void setParent(e r10) {
        if (compareAndSet(null, r10) == false) goto L5;
        return;
    L5:
        throw null;
    }
}
