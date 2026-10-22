package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservablePublishAlt$PublishConnection<T> extends AtomicReference<ObservablePublishAlt$InnerDisposable<T>[]> implements Observer<T>, Disposable {
    static final ObservablePublishAlt$InnerDisposable[] EMPTY = null;
    static final ObservablePublishAlt$InnerDisposable[] TERMINATED = null;
    private static final long serialVersionUID = -3251430252873581268L;
    final AtomicBoolean connect;
    final AtomicReference<ObservablePublishAlt$PublishConnection<T>> current;
    Throwable error;
    final AtomicReference<Disposable> upstream;

    static {
        EMPTY = new ObservablePublishAlt$InnerDisposable[0];
        TERMINATED = new ObservablePublishAlt$InnerDisposable[0];
    }

    public ObservablePublishAlt$PublishConnection(AtomicReference<ObservablePublishAlt$PublishConnection<T>> r10) {
        this.connect = new AtomicBoolean();
        this.current = r10;
        this.upstream = new AtomicReference();
        lazySet(EMPTY);
    }

    public boolean add(ObservablePublishAlt$InnerDisposable<T> r10) {
    L2:
        ObservablePublishAlt$InnerDisposable<T>[] r11 = get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        ObservablePublishAlt$InnerDisposable[] r13 = new ObservablePublishAlt$InnerDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        getAndSet(TERMINATED);
        p.a(this.current, this, null);
        DisposableHelper.dispose(this.upstream);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.upstream.lazySet(DisposableHelper.DISPOSED);
        ObservablePublishAlt$InnerDisposable<T>[] r10 = getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].downstream.onComplete();
        r12 = r12 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        this.error = r10;
        this.upstream.lazySet(DisposableHelper.DISPOSED);
        ObservablePublishAlt$InnerDisposable<T>[] r11 = getAndSet(TERMINATED);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].downstream.onError(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        ObservablePublishAlt$InnerDisposable<T>[] r11 = get();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].downstream.onNext(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    public void remove(ObservablePublishAlt$InnerDisposable<T> r10) {
    L2:
        ObservablePublishAlt$InnerDisposable<T>[] r11 = get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13] == r10) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        ObservablePublishAlt$InnerDisposable[] r14 = EMPTY;
        if (r12 == 1) goto L18;
        r14 = new ObservablePublishAlt$InnerDisposable[r12 - 1];
        System.arraycopy(r11, 0, r14, 0, r13);
        System.arraycopy(r11, r13 + 1, r14, r13, (r12 - r13) - 1);
    L18:
        if (compareAndSet(r11, r14) == false) goto L2;
        return;
    L13:
        return;
    L11:
        r13 = -1;
        goto L12
    }
}
