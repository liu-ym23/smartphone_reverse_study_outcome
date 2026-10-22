package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method r10, Class<?> r11, ThreadMode r12, int r13, boolean r14) {
        this.method = r10;
        this.threadMode = r12;
        this.eventType = r11;
        this.priority = r13;
        this.sticky = r14;
    }

    private synchronized void checkMethodString() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.methodString != null) goto L9;
        StringBuilder r10 = new StringBuilder(64);     // Catch: Throwable -> L7
        r10.append(this.method.getDeclaringClass().getName());     // Catch: Throwable -> L7
        r10.append('#');     // Catch: Throwable -> L7
        r10.append(this.method.getName());     // Catch: Throwable -> L7
        r10.append('(');     // Catch: Throwable -> L7
        r10.append(this.eventType.getName());     // Catch: Throwable -> L7
        this.methodString = r10.toString();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscriberMethod) == false) goto L9;
        checkMethodString();
        SubscriberMethod r11 = (SubscriberMethod) r10;
        r11.checkMethodString();
        return this.methodString.equals(r11.methodString);
    L9:
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
