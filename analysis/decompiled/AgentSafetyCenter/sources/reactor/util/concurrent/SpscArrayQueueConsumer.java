package reactor.util.concurrent;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class SpscArrayQueueConsumer<T> extends SpscArrayQueueP2<T> {
    static final AtomicLongFieldUpdater<SpscArrayQueueConsumer> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscArrayQueueConsumer.class, "consumerIndex");
    private static final long serialVersionUID = 4075549732218321659L;
    volatile long consumerIndex;

    public SpscArrayQueueConsumer(int i) {
        super(i);
    }
}
