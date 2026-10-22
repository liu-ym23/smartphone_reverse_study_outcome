package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final Publisher<T> source;

    public FlowableConcatMapEagerPublisher(Publisher<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, int r4, ErrorMode r5) {
        this.source = r1;
        this.mapper = r2;
        this.maxConcurrency = r3;
        this.prefetch = r4;
        this.errorMode = r5;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r9) {
        this.source.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(r9, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
