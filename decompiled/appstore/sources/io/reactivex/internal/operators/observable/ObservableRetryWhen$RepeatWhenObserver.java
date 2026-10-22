package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableRetryWhen$RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = 802743776666017014L;
    volatile boolean active;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final ObservableRetryWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner;
    final io.reactivex.subjects.a signaller;
    final ObservableSource<T> source;
    final AtomicReference<Disposable> upstream;
    final AtomicInteger wip;

    public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3254781284376480842L;
        final /* synthetic */ ObservableRetryWhen$RepeatWhenObserver this$0;

        public InnerRepeatObserver(ObservableRetryWhen$RepeatWhenObserver r10) {
            this.this$0 = r10;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.this$0.innerComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r10) {
            this.this$0.innerError(r10);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r10) {
            this.this$0.innerNext();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    public ObservableRetryWhen$RepeatWhenObserver(Observer<? super T> r10, io.reactivex.subjects.a r11, ObservableSource<T> r12) {
        this.downstream = r10;
        this.signaller = r11;
        this.source = r12;
        this.wip = new AtomicInteger();
        this.error = new AtomicThrowable();
        this.inner = new InnerRepeatObserver(this);
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
    }

    public void innerError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.d.c(this.downstream, r10, this, this.error);
    }

    public void innerNext() {
        subscribeNext();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        DisposableHelper.dispose(this.inner);
        io.reactivex.internal.util.d.a(this.downstream, this, this.error);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        DisposableHelper.replace(this.upstream, null);
        this.active = false;
        this.signaller.onNext(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        io.reactivex.internal.util.d.e(this.downstream, r10, this, this.error);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        DisposableHelper.replace(this.upstream, r10);
    }

    public void subscribeNext() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (isDisposed() == true) goto L6;
        if (this.active == true) goto L11;
        this.active = true;
        this.source.subscribe(this);
    L11:
        if (this.wip.decrementAndGet() != 0) goto L5;
        return;
    }
}
