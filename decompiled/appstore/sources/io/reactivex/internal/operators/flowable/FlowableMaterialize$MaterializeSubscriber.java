package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, mf.d> {
    private static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(Subscriber<? super mf.d> r10) {
        super(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        complete(mf.d.a());
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
    public /* bridge */ /* synthetic */ void onDrop(mf.d r10) {
        onDrop2(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        complete(mf.d.b(r10));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(mf.d.c(r10));
    }

    /* JADX INFO: renamed from: onDrop, reason: avoid collision after fix types in other method */
    public void onDrop2(mf.d r10) {
        if (r10.e() == false) goto L6;
        qf.a.e(r10.d());
        return;
    }
}
