package com.tmall.wireless.tangram.eventbus;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class EventHandlerWrapper {
    protected final String action;
    protected final Method handlerMethod;
    protected final String producer;

    @NonNull
    protected final Object subscriber;

    @NonNull
    protected final String type;

    public EventHandlerWrapper(@NonNull String r10, String r11, @NonNull Object r12, String r13) {
        this.type = r10;
        this.producer = r11;
        this.subscriber = r12;
        this.action = r13;
        this.handlerMethod = ReflectedActionFinder.findMethodByName(r13, r12);
    }

    public final void handleEvent(@NonNull Event r10) {
        Method r11 = this.handlerMethod;
        if (r11 == null) goto L15;
        r11.invoke(this.subscriber, new Object[]{r10});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8
    L17:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
