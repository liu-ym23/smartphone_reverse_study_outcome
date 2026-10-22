package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public BlockingFirstSubscriber() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r2) {
        if (this.value != null) goto L6;
        this.value = r2;
        this.upstream.cancel();
        countDown();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r2) {
        if (this.value != null) goto L5;
        this.error = r2;
    L6:
        countDown();
        return;
    L5:
        RxJavaPlugins.onError(r2);
        goto L6
    }
}
