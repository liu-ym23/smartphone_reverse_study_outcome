package org.reactivestreams;

/* JADX INFO: loaded from: classes4.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable r10);

    void onNext(T r10);

    void onSubscribe(Subscription r10);
}
