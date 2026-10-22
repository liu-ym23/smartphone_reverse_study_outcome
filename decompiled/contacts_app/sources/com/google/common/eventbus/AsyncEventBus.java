package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncEventBus extends EventBus {
    private final ConcurrentLinkedQueue<EventBus.EventWithSubscriber> eventsToDispatch;
    private final Executor executor;

    static /* synthetic */ void access$001(AsyncEventBus r0, Object r1, EventSubscriber r2) {
        super.dispatch(r1, r2);
    }

    public AsyncEventBus(String r1, Executor r2) {
        super(r1);
        this.eventsToDispatch = new ConcurrentLinkedQueue();
        this.executor = (Executor) Preconditions.checkNotNull(r2);
    }

    public AsyncEventBus(Executor r1, SubscriberExceptionHandler r2) {
        super(r2);
        this.eventsToDispatch = new ConcurrentLinkedQueue();
        this.executor = (Executor) Preconditions.checkNotNull(r1);
    }

    public AsyncEventBus(Executor r2) {
        super("default");
        this.eventsToDispatch = new ConcurrentLinkedQueue();
        this.executor = (Executor) Preconditions.checkNotNull(r2);
    }

    @Override // com.google.common.eventbus.EventBus
    void enqueueEvent(Object r2, EventSubscriber r3) {
        this.eventsToDispatch.offer(new EventBus.EventWithSubscriber(r2, r3));
    }

    @Override // com.google.common.eventbus.EventBus
    protected void dispatchQueuedEvents() {
    L2:
        EventBus.EventWithSubscriber r0 = this.eventsToDispatch.poll();
        if (r0 == null) goto L4;
        dispatch(r0.event, r0.subscriber);
        goto L2
    }

    @Override // com.google.common.eventbus.EventBus
    void dispatch(final Object r3, final EventSubscriber r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        this.executor.execute(new AnonymousClass1(this, r3, r4));
    }
}
