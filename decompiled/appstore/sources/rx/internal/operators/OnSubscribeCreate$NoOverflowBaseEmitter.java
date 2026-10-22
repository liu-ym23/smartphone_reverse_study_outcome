package rx.internal.operators;

import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
abstract class OnSubscribeCreate$NoOverflowBaseEmitter<T> extends OnSubscribeCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    public OnSubscribeCreate$NoOverflowBaseEmitter(Subscriber r10) {
        super(r10);
    }

    public void onNext(T r10) {
        if (this.actual.isUnsubscribed() == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
        this.actual.onNext(r10);
        a.c(this, 1);
        return;
    L8:
        onOverflow();
    }

    public abstract void onOverflow();
}
