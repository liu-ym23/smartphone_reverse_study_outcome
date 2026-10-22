package io.reactivex.disposables;

import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    @Override // io.reactivex.disposables.ReferenceDisposable
    protected /* bridge */ /* synthetic */ void onDisposed(Subscription r1) {
        onDisposed2(r1);
    }

    SubscriptionDisposable(Subscription r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    protected void onDisposed2(Subscription r1) {
        r1.cancel();
    }
}
