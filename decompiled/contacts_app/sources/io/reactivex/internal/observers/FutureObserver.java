package io.reactivex.internal.observers;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    Throwable error;
    final AtomicReference<Disposable> upstream;
    T value;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    public FutureObserver() {
        super(1);
        this.upstream = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r3) {
    L2:
        Disposable r4 = this.upstream.get();
        if (r4 == this) goto L13;
        if (r4 == DisposableHelper.DISPOSED) goto L19;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r4, DisposableHelper.DISPOSED) == false) goto L2;
        if (r4 == null) goto L11;
        r4.dispose();
    L11:
        countDown();
        return true;
    L19:
        return false;
    L13:
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() == 0) goto L6;
        BlockingHelper.verifyNonBlocking();
        await();
    L6:
        if (isCancelled() == true) goto L14;
        Throwable r0 = this.error;
        if (r0 != null) goto L12;
        return this.value;
    L12:
        throw new ExecutionException(r0);
    L14:
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public T get(long r5, TimeUnit r7) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0) goto L10;
        BlockingHelper.verifyNonBlocking();
        if (await(r5, r7) == true) goto L10;
        throw new TimeoutException(ExceptionHelper.timeoutMessage(r5, r7));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r6 = this.error;
        if (r6 != null) goto L16;
        return this.value;
    L16:
        throw new ExecutionException(r6);
    L18:
        throw new CancellationException();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
        DisposableHelper.setOnce(this.upstream, r1);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r2) {
        if (this.value == null) goto L6;
        this.upstream.get().dispose();
        onError(new IndexOutOfBoundsException("More than one element received"));
        return;
    L6:
        this.value = r2;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r3) {
        if (this.error != null) goto L16;
        this.error = r3;
    L5:
        Disposable r0 = this.upstream.get();
        if (r0 == this) goto L14;
        if (r0 == DisposableHelper.DISPOSED) goto L14;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r0, this) == false) goto L5;
        countDown();
        return;
    L14:
        RxJavaPlugins.onError(r3);
        return;
    L16:
        RxJavaPlugins.onError(r3);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.value != null) goto L6;
        onError(new NoSuchElementException("The source is empty"));
        return;
    L6:
        Disposable r0 = this.upstream.get();
        if (r0 == this) goto L19;
        if (r0 == DisposableHelper.DISPOSED) goto L20;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r0, this) == false) goto L6;
        countDown();
        return;
    L20:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }
}
