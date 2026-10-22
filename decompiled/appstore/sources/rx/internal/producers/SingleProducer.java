package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.a;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    final Subscriber child;
    final T value;

    public SingleProducer(Subscriber r10, T r11) {
        this.child = r10;
        this.value = r11;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L21;
        if (r10 != 0) goto L7;
        return;
    L7:
        if (compareAndSet(false, true) == false) goto L24;
        Subscriber r11 = this.child;
        if (r11.isUnsubscribed() == false) goto L11;
        return;
    L11:
        T r12 = this.value;
        r11.onNext(r12);     // Catch: Throwable -> L17
        if (r11.isUnsubscribed() == false) goto L16;
        return;
    L16:
        r11.onCompleted();
        return;
    L17:
        th = move-exception;
        a.g(th, r11, r12);
        return;
    L24:
        return;
    L21:
        throw new IllegalArgumentException("n >= 0 required");
    }
}
