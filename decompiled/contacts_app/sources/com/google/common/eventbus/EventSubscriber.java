package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class EventSubscriber {
    private final Method method;
    private final Object target;

    EventSubscriber(Object r2, Method r3) {
        Preconditions.checkNotNull(r2, "EventSubscriber target cannot be null.");
        Preconditions.checkNotNull(r3, "EventSubscriber method cannot be null.");
        this.target = r2;
        this.method = r3;
        r3.setAccessible(true);
    }

    public void handleEvent(Object r4) throws InvocationTargetException {
        Preconditions.checkNotNull(r4);
        this.method.invoke(this.target, new Object[]{r4});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L11 IllegalArgumentException -> L14
        return;
    L11:
        e = move-exception;
        throw new Error("Method became inaccessible: " + r4, e);
    L14:
        e = move-exception;
        throw new Error("Method rejected target/argument: " + r4, e);
    L5:
        e = move-exception;
        if ((e.getCause() instanceof Error) == true) goto L9;
        throw e;
    L9:
        throw ((Error) e.getCause());
    }

    public String toString() {
        return "[wrapper " + this.method + "]";
    }

    public int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public boolean equals(@Nullable Object r4) {
        if ((r4 instanceof EventSubscriber) == false) goto L10;
        EventSubscriber r5 = (EventSubscriber) r4;
        if (this.target == r5.target) goto L7;
        return false;
    L7:
        if (this.method.equals(r5.method) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Object getSubscriber() {
        return this.target;
    }

    public Method getMethod() {
        return this.method;
    }
}
