package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
class OperatorElementAt$InnerProducer extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = 1;
    final Producer actual;

    public OperatorElementAt$InnerProducer(Producer r10) {
        this.actual = r10;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L10;
        if (r10 > 0) goto L6;
        return;
    L6:
        if (compareAndSet(false, true) == false) goto L12;
        this.actual.request(Long.MAX_VALUE);
        return;
    L12:
        return;
    L10:
        throw new IllegalArgumentException("n >= 0 required");
    }
}
