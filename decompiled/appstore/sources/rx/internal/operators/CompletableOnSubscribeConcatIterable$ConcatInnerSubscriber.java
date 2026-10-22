package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableSubscriber actual;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final rx.subscriptions.d f24152sd;
    final Iterator<? extends Completable> sources;

    public CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber(CompletableSubscriber r10, Iterator<? extends Completable> r11) {
        this.actual = r10;
        this.sources = r11;
        this.f24152sd = new rx.subscriptions.d();
    }

    public void next() {
        if (this.f24152sd.isUnsubscribed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        Iterator<? extends Completable> r10 = this.sources;
    L10:
        if (this.f24152sd.isUnsubscribed() == true) goto L11;
        if (r10.hasNext() == false) goto L14;
        Completable r11 = r10.next();     // Catch: Throwable -> L23
        if (r11 == null) goto L18;
        r11.g(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L18:
        this.actual.onError(new NullPointerException("The completable returned is null"));
        return;
    L23:
        th = move-exception;
        this.actual.onError(th);
        return;
    L14:
        this.actual.onCompleted();
        return;
    L26:
        th = move-exception;
        this.actual.onError(th);
        return;
    }

    @Override // rx.CompletableSubscriber
    public void onCompleted() {
        next();
    }

    @Override // rx.CompletableSubscriber
    public void onError(Throwable r10) {
        this.actual.onError(r10);
    }

    @Override // rx.CompletableSubscriber
    public void onSubscribe(Subscription r10) {
        this.f24152sd.a(r10);
    }
}
