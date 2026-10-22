package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class SubscriberExceptionContext {
    private final Object event;
    private final EventBus eventBus;
    private final Object subscriber;
    private final Method subscriberMethod;

    public SubscriberExceptionContext(EventBus r10, Object r11, Object r12, Method r13) {
        this.eventBus = (EventBus) Preconditions.checkNotNull(r10);
        this.event = Preconditions.checkNotNull(r11);
        this.subscriber = Preconditions.checkNotNull(r12);
        this.subscriberMethod = (Method) Preconditions.checkNotNull(r13);
    }

    public Object getEvent() {
        return this.event;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public Object getSubscriber() {
        return this.subscriber;
    }

    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }
}
