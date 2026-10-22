package com.google.common.eventbus;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public class EventBus {
    private static final Logger logger = null;
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    public static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler INSTANCE = null;

        static {
            INSTANCE = new LoggingHandler();
        }

        public LoggingHandler() {
        }

        private static Logger logger(SubscriberExceptionContext r10) {
            return Logger.getLogger(EventBus.class.getName() + LibrarianImpl.Constants.DOT + r10.getEventBus().identifier());
        }

        private static String message(SubscriberExceptionContext r10) {
            Method r11 = r10.getSubscriberMethod();
            return "Exception thrown by subscriber method " + r11.getName() + '(' + r11.getParameterTypes()[0].getName() + ") on subscriber " + r10.getSubscriber() + " when dispatching event: " + r10.getEvent();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable r10, SubscriberExceptionContext r11) {
            Logger r12 = logger(r11);
            Level r13 = Level.SEVERE;
            if (r12.isLoggable(r13) == false) goto L6;
            r12.log(r13, message(r11), r10);
            return;
        }
    }

    static {
        logger = Logger.getLogger(EventBus.class.getName());
    }

    public EventBus() {
        this("default");
    }

    public final Executor executor() {
        return this.executor;
    }

    public void handleSubscriberException(Throwable r10, SubscriberExceptionContext r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        this.exceptionHandler.handleException(r10, r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th, r10}), th);
    }

    public final String identifier() {
        return this.identifier;
    }

    public void post(Object r10) {
        Iterator<Subscriber> r11 = this.subscribers.getSubscribers(r10);
        if (r11.hasNext() == false) goto L6;
        this.dispatcher.dispatch(r10, r11);
        return;
    L6:
        if ((r10 instanceof DeadEvent) == true) goto L10;
        post(new DeadEvent(this, r10));
        return;
    }

    public void register(Object r10) {
        this.subscribers.register(r10);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
    }

    public void unregister(Object r10) {
        this.subscribers.unregister(r10);
    }

    public EventBus(String r10) {
        this(r10, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
    }

    public EventBus(SubscriberExceptionHandler r10) {
        this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), r10);
    }

    public EventBus(String r10, Executor r11, Dispatcher r12, SubscriberExceptionHandler r13) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.checkNotNull(r10);
        this.executor = (Executor) Preconditions.checkNotNull(r11);
        this.dispatcher = (Dispatcher) Preconditions.checkNotNull(r12);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(r13);
    }
}
