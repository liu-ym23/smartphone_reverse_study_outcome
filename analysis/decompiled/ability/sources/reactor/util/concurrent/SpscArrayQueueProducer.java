package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes4.dex */
class SpscArrayQueueProducer<T> extends SpscArrayQueueP1<T> {
    static final AtomicLongFieldUpdater<SpscArrayQueueProducer> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscArrayQueueProducer.class, "producerIndex");
    private static final long serialVersionUID = 1657408315616277653L;
    volatile long producerIndex;

    public SpscArrayQueueProducer(int i) {
        super(i);
    }
}
