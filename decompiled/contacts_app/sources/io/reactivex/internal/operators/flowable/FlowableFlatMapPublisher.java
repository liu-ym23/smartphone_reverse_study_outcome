package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;
    final Publisher<T> source;

    public FlowableFlatMapPublisher(Publisher<T> r1, Function<? super T, ? extends Publisher<? extends U>> r2, boolean r3, int r4, int r5) {
        this.source = r1;
        this.mapper = r2;
        this.delayErrors = r3;
        this.maxConcurrency = r4;
        this.bufferSize = r5;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r5) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, r5, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(FlowableFlatMap.subscribe(r5, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
