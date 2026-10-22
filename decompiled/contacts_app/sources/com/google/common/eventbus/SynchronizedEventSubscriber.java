package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class SynchronizedEventSubscriber extends EventSubscriber {
    public SynchronizedEventSubscriber(Object r1, Method r2) {
        super(r1, r2);
    }

    @Override // com.google.common.eventbus.EventSubscriber
    public void handleEvent(Object r1) throws InvocationTargetException {
        monitor-enter(this);
        super.handleEvent(r1);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
