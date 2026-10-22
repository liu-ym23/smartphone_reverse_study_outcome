package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCreate$ErrorEmitter<T> extends OnSubscribeCreate$NoOverflowBaseEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;
    private boolean done;

    public OnSubscribeCreate$ErrorEmitter(Subscriber r10) {
        super(r10);
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter, rx.Observer
    public void onCompleted() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        super.onCompleted();
    }

    @Override // rx.internal.operators.OnSubscribeCreate$BaseEmitter, rx.Observer
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        og.c.j(r10);
        return;
    L6:
        this.done = true;
        super.onError(r10);
    }

    @Override // rx.internal.operators.OnSubscribeCreate$NoOverflowBaseEmitter, rx.Observer
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        super.onNext(r10);
    }

    @Override // rx.internal.operators.OnSubscribeCreate$NoOverflowBaseEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
