package com.google.common.eventbus;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public class DeadEvent {
    private final Object event;
    private final Object source;

    public DeadEvent(Object r1, Object r2) {
        this.source = Preconditions.checkNotNull(r1);
        this.event = Preconditions.checkNotNull(r2);
    }

    public Object getSource() {
        return this.source;
    }

    public Object getEvent() {
        return this.event;
    }
}
