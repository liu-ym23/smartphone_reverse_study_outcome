package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
    private static final long serialVersionUID = 4262875056400218316L;
    private Action1<? super Resource> dispose;
    private Resource resource;

    public OnSubscribeUsing$DisposeAction(Action1<? super Resource> r10, Resource r11) {
        this.dispose = r10;
        this.resource = r11;
        lazySet(false);
    }

    @Override // rx.functions.Action0
    public void call() {
        if (compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        this.dispose.call(this.resource);     // Catch: Throwable -> L7
        this.resource = null;
        this.dispose = null;
        return;
    L7:
        th = move-exception;
        this.resource = null;
        this.dispose = null;
        throw th;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        call();
    }
}
