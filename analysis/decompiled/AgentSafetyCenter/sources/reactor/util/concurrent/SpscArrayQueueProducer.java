package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class SpscArrayQueueProducer<T> extends SpscArrayQueueP1<T> {
    static final AtomicLongFieldUpdater<SpscArrayQueueProducer> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscArrayQueueProducer.class, "producerIndex");
    private static final long serialVersionUID = 1657408315616277653L;
    volatile long producerIndex;

    public SpscArrayQueueProducer(int i) {
        super(i);
    }
}
