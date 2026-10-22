package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(Subscription r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(@NonNull Subscription r10) {
        onDisposed2(r10);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(@NonNull Subscription r10) {
        r10.cancel();
    }
}
