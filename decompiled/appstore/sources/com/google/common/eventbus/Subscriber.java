package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
class Subscriber {

    @Weak
    private EventBus bus;
    private final Executor executor;
    private final Method method;

    @VisibleForTesting
    final Object target;

    @VisibleForTesting
    public static final class SynchronizedSubscriber extends Subscriber {
        public /* synthetic */ SynchronizedSubscriber(EventBus r10, Object r11, Method r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        @Override // com.google.common.eventbus.Subscriber
        public void invokeSubscriberMethod(Object r10) throws InvocationTargetException {
            monitor-enter(this);
            super.invokeSubscriberMethod(r10);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private SynchronizedSubscriber(EventBus r10, Object r11, Method r12) {
            super(r10, r11, r12, null);
        }
    }

    public /* synthetic */ Subscriber(EventBus r10, Object r11, Method r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    public static /* synthetic */ SubscriberExceptionContext access$100(Subscriber r10, Object r11) {
        return r10.context(r11);
    }

    public static /* synthetic */ EventBus access$200(Subscriber r10) {
        return r10.bus;
    }

    private SubscriberExceptionContext context(Object r10) {
        return new SubscriberExceptionContext(this.bus, r10, this.target, this.method);
    }

    public static Subscriber create(EventBus r10, Object r11, Method r12) {
        if (isDeclaredThreadSafe(r12) == false) goto L6;
        return new Subscriber(r10, r11, r12);
    L6:
        return new SynchronizedSubscriber(r10, r11, r12, null);
    }

    private static boolean isDeclaredThreadSafe(Method r10) {
        if (r10.getAnnotation(AllowConcurrentEvents.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void dispatchEvent(final Object r10) {
        this.executor.execute(new AnonymousClass1(this, r10));
    }

    public final boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Subscriber) == false) goto L10;
        Subscriber r11 = (Subscriber) r10;
        if (this.target == r11.target) goto L7;
        return false;
    L7:
        if (this.method.equals(r11.method) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    @VisibleForTesting
    public void invokeSubscriberMethod(Object r10) throws InvocationTargetException {
        this.method.invoke(this.target, new Object[]{Preconditions.checkNotNull(r10)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 IllegalArgumentException -> L8
        return;
    L6:
        e = move-exception;
        throw new Error("Method became inaccessible: " + r10, e);
    L8:
        e = move-exception;
        throw new Error("Method rejected target/argument: " + r10, e);
    L4:
        e = move-exception;
        if ((e.getCause() instanceof Error) == true) goto L13;
        throw e;
    L13:
        throw ((Error) e.getCause());
    }

    private Subscriber(EventBus r10, Object r11, Method r12) {
        this.bus = r10;
        this.target = Preconditions.checkNotNull(r11);
        this.method = r12;
        r12.setAccessible(true);
        this.executor = r10.executor();
    }
}
