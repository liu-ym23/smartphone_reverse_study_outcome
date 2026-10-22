package com.stepos.core.common.telemetry;

import androidx.room.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiPowerEventBus {
    private static final int CAPACITY = 512;
    private static l<? super AiPowerPerfRecord, n> consumer;
    public static final AiPowerEventBus INSTANCE = new AiPowerEventBus();
    private static final ArrayBlockingQueue<AiPowerPerfRecord> queue = new ArrayBlockingQueue<>(512);
    private static final AtomicLong droppedCount = new AtomicLong(0);
    private static final AtomicLong dispatchDroppedCount = new AtomicLong(0);
    private static final RejectedExecutionHandler rejectHandler = new a();
    private static final lb.d dispatcher$delegate = kotlin.b.b(new a9.a(13));

    private AiPowerEventBus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPoolExecutor dispatcher_delegate$lambda$3() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(512), new a6.d(1), rejectHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread dispatcher_delegate$lambda$3$lambda$2(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "aiengine-exp-io", true);
    }

    private final ThreadPoolExecutor getDispatcher() {
        return (ThreadPoolExecutor) dispatcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void post$lambda$5(l lVar, AiPowerPerfRecord aiPowerPerfRecord) {
        try {
            lVar.invoke(aiPowerPerfRecord);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rejectHandler$lambda$0(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor.getQueue().poll() != null) {
            dispatchDroppedCount.incrementAndGet();
        }
        if (threadPoolExecutor.getQueue().offer(runnable)) {
            return;
        }
        dispatchDroppedCount.incrementAndGet();
    }

    public final void clear() {
        queue.clear();
        droppedCount.set(0L);
        dispatchDroppedCount.set(0L);
    }

    public final long dispatchDroppedCount() {
        return dispatchDroppedCount.get();
    }

    public final long droppedCount() {
        return droppedCount.get();
    }

    public final AiPowerPerfRecord last() {
        return (AiPowerPerfRecord) kotlin.collections.a.B0(kotlin.collections.a.O0(queue));
    }

    public final int pendingDispatchCount() {
        return getDispatcher().getQueue().size();
    }

    public final void post(AiPowerPerfRecord record) {
        kotlin.jvm.internal.g.f(record, "record");
        ArrayBlockingQueue<AiPowerPerfRecord> arrayBlockingQueue = queue;
        if (!arrayBlockingQueue.offer(record)) {
            arrayBlockingQueue.poll();
            arrayBlockingQueue.offer(record);
            droppedCount.incrementAndGet();
        }
        l<? super AiPowerPerfRecord, n> lVar = consumer;
        if (lVar == null) {
            return;
        }
        getDispatcher().execute(new o(7, lVar, record));
    }

    public final void registerConsumer(l<? super AiPowerPerfRecord, n> c9) {
        kotlin.jvm.internal.g.f(c9, "c");
        consumer = c9;
    }

    public final List<AiPowerPerfRecord> since(long j10) {
        ArrayBlockingQueue<AiPowerPerfRecord> arrayBlockingQueue = queue;
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayBlockingQueue) {
            if (((AiPowerPerfRecord) obj).getStartWallMs() >= j10) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final int size() {
        return queue.size();
    }

    public final List<AiPowerPerfRecord> snapshot() {
        return kotlin.collections.a.O0(queue);
    }
}
