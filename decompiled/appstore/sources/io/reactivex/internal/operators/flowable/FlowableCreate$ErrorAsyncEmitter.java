package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(Subscriber<? super T> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
