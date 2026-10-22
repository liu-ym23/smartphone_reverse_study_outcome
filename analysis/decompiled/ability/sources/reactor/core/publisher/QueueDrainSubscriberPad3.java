package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes4.dex */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    static final AtomicLongFieldUpdater<QueueDrainSubscriberPad3> REQUESTED = AtomicLongFieldUpdater.newUpdater(QueueDrainSubscriberPad3.class, "requested");
    volatile long requested;
}
