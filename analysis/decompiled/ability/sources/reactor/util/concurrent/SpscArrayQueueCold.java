package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
class SpscArrayQueueCold<T> extends AtomicReferenceArray<T> {
    private static final long serialVersionUID = 8491797459632447132L;
    final int mask;

    public SpscArrayQueueCold(int i) {
        super(i);
        this.mask = i - 1;
    }
}
