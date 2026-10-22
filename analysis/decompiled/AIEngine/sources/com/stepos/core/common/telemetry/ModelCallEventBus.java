package com.stepos.core.common.telemetry;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallEventBus {
    private static final int CAPACITY = 256;
    private static l<? super ModelCallRecord, n> consumer;
    public static final ModelCallEventBus INSTANCE = new ModelCallEventBus();
    private static final ArrayBlockingQueue<ModelCallRecord> queue = new ArrayBlockingQueue<>(256);
    private static final AtomicLong droppedCount = new AtomicLong(0);

    private ModelCallEventBus() {
    }

    public final void clear() {
        queue.clear();
        droppedCount.set(0L);
    }

    public final long droppedCount() {
        return droppedCount.get();
    }

    public final ModelCallRecord last() {
        return (ModelCallRecord) kotlin.collections.a.B0(kotlin.collections.a.O0(queue));
    }

    public final void post(ModelCallRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        l<? super ModelCallRecord, n> lVar = consumer;
        if (lVar != null) {
            try {
                lVar.invoke(record);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
        ArrayBlockingQueue<ModelCallRecord> arrayBlockingQueue = queue;
        if (arrayBlockingQueue.offer(record)) {
            return;
        }
        arrayBlockingQueue.poll();
        arrayBlockingQueue.offer(record);
        droppedCount.incrementAndGet();
    }

    public final void registerConsumer(l<? super ModelCallRecord, n> c9) {
        kotlin.jvm.internal.g.f(c9, "c");
        consumer = c9;
    }

    public final int size() {
        return queue.size();
    }

    public final List<ModelCallRecord> snapshot() {
        return kotlin.collections.a.O0(queue);
    }
}
