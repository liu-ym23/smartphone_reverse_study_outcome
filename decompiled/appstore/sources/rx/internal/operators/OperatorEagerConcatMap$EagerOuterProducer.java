package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements Producer {
    private static final long serialVersionUID = -657299606803478389L;
    final j parent;

    public OperatorEagerConcatMap$EagerOuterProducer(j r10) {
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (r10 < 0) goto L9;
        if (r10 > 0) goto L6;
        return;
    L6:
        a.b(this, r10);
        throw null;
    L9:
        throw new IllegalStateException("n >= 0 required but it was " + r10);
    }
}
