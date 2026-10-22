package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes4.dex */
public interface InnerQueuedSubscriberSupport<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> r10);

    void innerError(InnerQueuedSubscriber<T> r10, Throwable r11);

    void innerNext(InnerQueuedSubscriber<T> r10, T r11);
}
