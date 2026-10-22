package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public class DeadEvent {
    private final Object event;
    private final Object source;

    public DeadEvent(Object r10, Object r11) {
        this.source = Preconditions.checkNotNull(r10);
        this.event = Preconditions.checkNotNull(r11);
    }

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("source", this.source).add("event", this.event).toString();
    }
}
