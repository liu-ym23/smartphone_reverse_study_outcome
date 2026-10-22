package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus r10, Throwable r11, Object r12, Object r13) {
        this.eventBus = r10;
        this.throwable = r11;
        this.causingEvent = r12;
        this.causingSubscriber = r13;
    }
}
