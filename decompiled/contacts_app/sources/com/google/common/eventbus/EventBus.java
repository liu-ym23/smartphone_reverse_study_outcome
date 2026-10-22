package com.google.common.eventbus;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class EventBus {
    private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = null;
    private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch;
    private final SubscriberFindingStrategy finder;
    private final ThreadLocal<Boolean> isDispatching;
    private SubscriberExceptionHandler subscriberExceptionHandler;
    private final SetMultimap<Class<?>, EventSubscriber> subscribersByType;
    private final ReadWriteLock subscribersByTypeLock;

    static class EventWithSubscriber {
        final Object event;
        final EventSubscriber subscriber;

        public EventWithSubscriber(Object r1, EventSubscriber r2) {
            this.event = Preconditions.checkNotNull(r1);
            this.subscriber = (EventSubscriber) Preconditions.checkNotNull(r2);
        }
    }

    private static final class LoggingSubscriberExceptionHandler implements SubscriberExceptionHandler {
        private final Logger logger;

        public LoggingSubscriberExceptionHandler(String r3) {
            this.logger = Logger.getLogger(EventBus.class.getName() + LibrarianImpl.Constants.DOT + ((String) Preconditions.checkNotNull(r3)));
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable r4, SubscriberExceptionContext r5) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + r5.getSubscriber() + " to " + r5.getSubscriberMethod(), r4.getCause());
        }
    }

    static {
        flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass1());
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String r2) {
        this(new LoggingSubscriberExceptionHandler(r2));
    }

    public EventBus(SubscriberExceptionHandler r2) {
        this.subscribersByType = HashMultimap.create();
        this.subscribersByTypeLock = new ReentrantReadWriteLock();
        this.finder = new AnnotatedSubscriberFinder();
        this.eventsToDispatch = new AnonymousClass2(this);
        this.isDispatching = new AnonymousClass3(this);
        this.subscriberExceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(r2);
    }

    public void register(Object r2) {
        Multimap<Class<?>, EventSubscriber> r3 = this.finder.findAllSubscribers(r2);
        this.subscribersByTypeLock.writeLock().lock();
        this.subscribersByType.putAll(r3);     // Catch: Throwable -> L6
        this.subscribersByTypeLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.subscribersByTypeLock.writeLock().unlock();
        throw th;
    }

    public void unregister(Object r5) {
        Iterator<Map.Entry<Class<?>, Collection<EventSubscriber>>> r0 = this.finder.findAllSubscribers(r5).asMap().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Map.Entry<Class<?>, Collection<EventSubscriber>> r1 = r0.next();
        Class<?> r2 = r1.getKey();
        Collection<EventSubscriber> r3 = r1.getValue();
        this.subscribersByTypeLock.writeLock().lock();
        Set<EventSubscriber> r4 = this.subscribersByType.get(r2);     // Catch: Throwable -> L12
        if (r4.containsAll(r3) == false) goto L11;
        r4.removeAll(r3);     // Catch: Throwable -> L12
        this.subscribersByTypeLock.writeLock().unlock();
        goto L4
    L11:
        throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + r5 + " registered?");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.subscribersByTypeLock.writeLock().unlock();
        throw th;
    }

    public void post(Object r5) {
        Iterator<Class<?>> r0 = flattenHierarchy(r5.getClass()).iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L18;
        Class<?> r2 = r0.next();
        this.subscribersByTypeLock.readLock().lock();
        Set<EventSubscriber> r3 = this.subscribersByType.get(r2);     // Catch: Throwable -> L15
        if (r3.isEmpty() == true) goto L14;
        Iterator<EventSubscriber> r4 = r3.iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L13;
        enqueueEvent(r5, r4.next());     // Catch: Throwable -> L15
        goto L10
    L13:
        r1 = true;
    L14:
        this.subscribersByTypeLock.readLock().unlock();
    L15:
        th = move-exception;
        this.subscribersByTypeLock.readLock().unlock();
        throw th;
    L18:
        if (r1 == false) goto L20;
    L22:
        dispatchQueuedEvents();
        return;
    L20:
        if ((r5 instanceof DeadEvent) == true) goto L22;
        post(new DeadEvent(this, r5));
        goto L22
    }

    void enqueueEvent(Object r2, EventSubscriber r3) {
        this.eventsToDispatch.get().offer(new EventWithSubscriber(r2, r3));
    }

    void dispatchQueuedEvents() {
        if (this.isDispatching.get().booleanValue() == false) goto L5;
        return;
    L5:
        this.isDispatching.set(true);
        Queue<EventWithSubscriber> r0 = this.eventsToDispatch.get();     // Catch: Throwable -> L13
    L7:
        EventWithSubscriber r1 = r0.poll();     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        dispatch(r1.event, r1.subscriber);     // Catch: Throwable -> L13
        goto L7
    L11:
        this.isDispatching.remove();
        this.eventsToDispatch.remove();
        return;
    L13:
        th = move-exception;
        this.isDispatching.remove();
        this.eventsToDispatch.remove();
        throw th;
    }

    void dispatch(Object r6, EventSubscriber r7) {
        r7.handleEvent(r6);     // Catch: InvocationTargetException -> L4
        return;
    L4:
        e = move-exception;
        this.subscriberExceptionHandler.handleException(e.getCause(), new SubscriberExceptionContext(this, r6, r7.getSubscriber(), r7.getMethod()));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", new Object[]{th, e.getCause()}), th);
    }

    Set<Class<?>> flattenHierarchy(Class<?> r1) {
        return flattenHierarchyCache.getUnchecked(r1);
    L4:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    }
}
