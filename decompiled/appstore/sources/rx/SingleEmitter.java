package rx;

import rx.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleEmitter<T> {
    void onError(Throwable r10);

    void onSuccess(T r10);

    void setCancellation(Cancellable r10);

    void setSubscription(Subscription r10);
}
