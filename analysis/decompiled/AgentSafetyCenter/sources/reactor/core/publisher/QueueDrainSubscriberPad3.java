package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    static final AtomicLongFieldUpdater<QueueDrainSubscriberPad3> REQUESTED = AtomicLongFieldUpdater.newUpdater(QueueDrainSubscriberPad3.class, "requested");
    volatile long requested;
}
