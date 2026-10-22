package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    private static final /* synthetic */ EmptyComponent[] $VALUES = null;
    public static final EmptyComponent INSTANCE = null;

    static {
        EmptyComponent r10 = new EmptyComponent("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new EmptyComponent[]{r10};
    }

    private EmptyComponent(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String r10) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, r10);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) $VALUES.clone();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        r10.dispose();
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object r10) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        r10.cancel();
    }
}
