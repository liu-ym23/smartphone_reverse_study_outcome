package rx;

/* JADX INFO: loaded from: classes4.dex */
public interface Observer<T> {
    void onCompleted();

    void onError(Throwable r10);

    void onNext(T r10);
}
