package io.reactivex.internal.subscribers;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
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
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable error;
    final AtomicReference<Subscription> upstream;
    T value;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
    }

    public FutureSubscriber() {
        super(1);
        this.upstream = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r3) {
    L2:
        Subscription r4 = this.upstream.get();
        if (r4 == this) goto L13;
        if (r4 == SubscriptionHelper.CANCELLED) goto L19;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r4, SubscriptionHelper.CANCELLED) == false) goto L2;
        if (r4 == null) goto L11;
        r4.cancel();
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
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
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

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        SubscriptionHelper.setOnce(this.upstream, r3, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r2) {
        if (this.value == null) goto L6;
        this.upstream.get().cancel();
        onError(new IndexOutOfBoundsException("More than one element received"));
        return;
    L6:
        this.value = r2;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r3) {
    L2:
        Subscription r0 = this.upstream.get();
        if (r0 == this) goto L11;
        if (r0 == SubscriptionHelper.CANCELLED) goto L11;
        this.error = r3;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r0, this) == false) goto L2;
        countDown();
        return;
    L11:
        RxJavaPlugins.onError(r3);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.value != null) goto L6;
        onError(new NoSuchElementException("The source is empty"));
        return;
    L6:
        Subscription r0 = this.upstream.get();
        if (r0 == this) goto L19;
        if (r0 == SubscriptionHelper.CANCELLED) goto L20;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.upstream, r0, this) == false) goto L6;
        countDown();
        return;
    L20:
        return;
    }
}
