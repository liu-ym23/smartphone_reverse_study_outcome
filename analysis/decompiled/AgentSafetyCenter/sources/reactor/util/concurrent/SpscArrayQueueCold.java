package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class SpscArrayQueueCold<T> extends AtomicReferenceArray<T> {
    private static final long serialVersionUID = 8491797459632447132L;
    final int mask;

    public SpscArrayQueueCold(int i) {
        super(i);
        this.mask = i - 1;
    }
}
