package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    private static final long serialVersionUID = 2757120512858778108L;
    final Callable<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends R> r11, Function<? super Throwable, ? extends R> r12, Callable<? extends R> r13) {
        super(r10);
        this.onNextMapper = r11;
        this.onErrorMapper = r12;
        this.onCompleteSupplier = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        complete(io.reactivex.internal.functions.a.b(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        complete(io.reactivex.internal.functions.a.b(this.onErrorMapper.apply(r10), "The onError publisher returned is null"));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        Object r11 = io.reactivex.internal.functions.a.b(this.onNextMapper.apply(r10), "The onNext publisher returned is null");     // Catch: Throwable -> L5
        this.produced++;
        this.downstream.onNext(r11);
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
    }
}
