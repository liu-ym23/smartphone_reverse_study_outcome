package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
class SpscArrayQueueCold<T> extends AtomicReferenceArray<T> {
    private static final long serialVersionUID = 8491797459632447132L;
    final int mask;

    public SpscArrayQueueCold(int i10) {
        super(i10);
        this.mask = i10 - 1;
    }
}
