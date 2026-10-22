package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableSubscriber actual;
    int index;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    final rx.subscriptions.d f24151sd;
    final Completable[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(CompletableSubscriber r10, Completable[] r11) {
        this.actual = r10;
        this.sources = r11;
        this.f24151sd = new rx.subscriptions.d();
    }

    public void next() {
        if (this.f24151sd.isUnsubscribed() == false) goto L6;
        return;
    L6:
        if (getAndIncrement() == 0) goto L8;
        return;
    L8:
        Completable[] r10 = this.sources;
    L10:
        if (this.f24151sd.isUnsubscribed() == true) goto L11;
        int r11 = this.index;
        this.index = r11 + 1;
        if (r11 == r10.length) goto L14;
        r10[r11].g(this);
        if (decrementAndGet() != 0) goto L10;
        return;
    L14:
        this.actual.onCompleted();
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
        this.f24151sd.a(r10);
    }
}
