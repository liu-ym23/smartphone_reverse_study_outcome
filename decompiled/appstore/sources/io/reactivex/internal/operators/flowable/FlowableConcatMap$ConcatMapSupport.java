package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes4.dex */
interface FlowableConcatMap$ConcatMapSupport<T> {
    void innerComplete();

    void innerError(Throwable r10);

    void innerNext(T r10);
}
