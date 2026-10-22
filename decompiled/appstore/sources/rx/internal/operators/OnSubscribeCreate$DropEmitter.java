package rx.internal.operators;

import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeCreate$DropEmitter<T> extends OnSubscribeCreate$NoOverflowBaseEmitter<T> {
    private static final long serialVersionUID = 8360058422307496563L;

    public OnSubscribeCreate$DropEmitter(Subscriber r10) {
        super(r10);
    }

    @Override // rx.internal.operators.OnSubscribeCreate$NoOverflowBaseEmitter
    public void onOverflow() {
    }
}
