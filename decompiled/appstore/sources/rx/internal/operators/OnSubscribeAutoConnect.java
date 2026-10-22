package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements Observable.OnSubscribe<T> {
    final Action1<? super Subscription> connection;
    final int numberOfSubscribers;
    final rx.observables.a source;

    public OnSubscribeAutoConnect(rx.observables.a r10, int r11, Action1<? super Subscription> r12) {
        if (r11 <= 0) goto L7;
        this.source = r10;
        this.numberOfSubscribers = r11;
        this.connection = r12;
        return;
    L7:
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        call2(r10);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(Subscriber r10) {
        this.source.z(ng.c.a(r10));
        if (incrementAndGet() != this.numberOfSubscribers) goto L6;
        this.source.B(this.connection);
        return;
    }
}
