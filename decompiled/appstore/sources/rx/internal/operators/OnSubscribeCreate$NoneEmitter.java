package rx.internal.operators;

import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCreate$NoneEmitter<T> extends OnSubscribeCreate$BaseEmitter<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    public OnSubscribeCreate$NoneEmitter(Subscriber r10) {
        super(r10);
    }

    @Override // rx.Observer
    public void onNext(T r10) {
        if (this.actual.isUnsubscribed() == false) goto L5;
        return;
    L5:
        this.actual.onNext(r10);
    L6:
        long r11 = get();
        if (r11 == 0) goto L10;
        if (compareAndSet(r11, r11 - 1) == false) goto L6;
        return;
    }
}
