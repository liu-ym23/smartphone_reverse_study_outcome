package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorMerge$MergeProducer<T> extends AtomicLong implements Producer {
    private static final long serialVersionUID = -1214379189873595503L;
    final l subscriber;

    public OperatorMerge$MergeProducer(l r10) {
    }

    public long produced(int r10) {
        return addAndGet(-r10);
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 > 0) goto L5;
        if (r10 < 0) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("n >= 0 required");
    L5:
        if (get() != Long.MAX_VALUE) goto L7;
        return;
    L7:
        a.b(this, r10);
        throw null;
    }
}
