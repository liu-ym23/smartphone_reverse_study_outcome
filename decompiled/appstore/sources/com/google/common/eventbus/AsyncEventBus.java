package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String r10, Executor r11) {
        super(r10, r11, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor r10, SubscriberExceptionHandler r11) {
        super("default", r10, Dispatcher.legacyAsync(), r11);
    }

    public AsyncEventBus(Executor r10) {
        super("default", r10, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }
}
