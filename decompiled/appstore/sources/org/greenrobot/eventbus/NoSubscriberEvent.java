package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus r10, Object r11) {
        this.eventBus = r10;
        this.originalEvent = r11;
    }
}
