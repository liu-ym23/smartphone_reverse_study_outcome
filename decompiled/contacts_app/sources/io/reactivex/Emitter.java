package io.reactivex;

/* JADX INFO: loaded from: classes4.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable r1);

    void onNext(T r1);
}
