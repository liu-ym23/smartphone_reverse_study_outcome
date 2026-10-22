package rx;

import rx.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableEmitter {
    void onCompleted();

    void onError(Throwable r10);

    void setCancellation(Cancellable r10);

    void setSubscription(Subscription r10);
}
