package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object r10) {
            if (this.eventBus != null) goto L6;
            this.eventBus = EventBus.getDefault();
        L6:
            if (this.threadPool != null) goto L9;
            this.threadPool = Executors.newCachedThreadPool();
        L9:
            if (this.failureEventType != null) goto L12;
            this.failureEventType = ThrowableFailureEvent.class;
        L12:
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, r10, null);
        }

        public Builder eventBus(EventBus r10) {
            this.eventBus = r10;
            return this;
        }

        public Builder failureEventType(Class<?> r10) {
            this.failureEventType = r10;
            return this;
        }

        public Builder threadPool(Executor r10) {
            this.threadPool = r10;
            return this;
        }

        private Builder() {
        }
    }

    public interface RunnableEx {
        void run() throws Exception;
    }

    public /* synthetic */ AsyncExecutor(Executor r10, EventBus r11, Class r12, Object r13, AnonymousClass1 r14) {
        this(r10, r11, r12, r13);
    }

    public static /* synthetic */ Constructor access$200(AsyncExecutor r10) {
        return r10.failureEventConstructor;
    }

    public static /* synthetic */ EventBus access$300(AsyncExecutor r10) {
        return r10.eventBus;
    }

    public static /* synthetic */ Object access$400(AsyncExecutor r10) {
        return r10.scope;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AsyncExecutor create() {
        return new Builder(null).build();
    }

    public void execute(final RunnableEx r10) {
        this.threadPool.execute(new AnonymousClass1(this, r10));
    }

    private AsyncExecutor(Executor r10, EventBus r11, Class<?> r12, Object r13) {
        this.threadPool = r10;
        this.eventBus = r11;
        this.scope = r13;
        this.failureEventConstructor = r12.getConstructor(new Class[]{Throwable.class});     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
    }
}
