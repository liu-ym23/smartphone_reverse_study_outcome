package rx;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableSubscriber {
    void onCompleted();

    void onError(Throwable r10);

    void onSubscribe(Subscription r10);
}
