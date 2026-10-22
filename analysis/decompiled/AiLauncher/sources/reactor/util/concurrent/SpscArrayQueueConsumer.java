package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
class SpscArrayQueueConsumer<T> extends SpscArrayQueueP2<T> {
    static final AtomicLongFieldUpdater<SpscArrayQueueConsumer> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscArrayQueueConsumer.class, "consumerIndex");
    private static final long serialVersionUID = 4075549732218321659L;
    volatile long consumerIndex;

    public SpscArrayQueueConsumer(int i10) {
        super(i10);
    }
}
