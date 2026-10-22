package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
abstract class Dispatcher {

    /* JADX INFO: renamed from: com.google.common.eventbus.Dispatcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = null;

        static {
            INSTANCE = new ImmediateDispatcher();
        }

        private ImmediateDispatcher() {
        }

        public static /* synthetic */ ImmediateDispatcher access$200() {
            return INSTANCE;
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void dispatch(Object r10, Iterator<Subscriber> r11) {
            Preconditions.checkNotNull(r10);
        L4:
            if (r11.hasNext() == false) goto L6;
            r11.next().dispatchEvent(r10);
            goto L4
        }
    }

    public static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        public static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            public /* synthetic */ EventWithSubscriber(Object r10, Subscriber r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            public static /* synthetic */ Object access$700(EventWithSubscriber r10) {
                return r10.event;
            }

            public static /* synthetic */ Subscriber access$800(EventWithSubscriber r10) {
                return r10.subscriber;
            }

            private EventWithSubscriber(Object r10, Subscriber r11) {
                this.event = r10;
                this.subscriber = r11;
            }
        }

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void dispatch(Object r10, Iterator<Subscriber> r11) {
            Preconditions.checkNotNull(r10);
        L4:
            if (r11.hasNext() == false) goto L6;
            this.queue.add(new EventWithSubscriber(r10, r11.next(), null));
        L6:
            EventWithSubscriber r12 = this.queue.poll();
            if (r12 == null) goto L9;
            EventWithSubscriber.access$800(r12).dispatchEvent(EventWithSubscriber.access$700(r12));
            goto L6
        }

        public /* synthetic */ LegacyAsyncDispatcher(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        public static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            public /* synthetic */ Event(Object r10, Iterator r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            public static /* synthetic */ Iterator access$400(Event r10) {
                return r10.subscribers;
            }

            public static /* synthetic */ Object access$500(Event r10) {
                return r10.event;
            }

            private Event(Object r10, Iterator<Subscriber> r11) {
                this.event = r10;
                this.subscribers = r11;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.queue = new AnonymousClass1(this);
            this.dispatching = new AnonymousClass2(this);
        }

        @Override // com.google.common.eventbus.Dispatcher
        public void dispatch(Object r10, Iterator<Subscriber> r11) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            Queue<Event> r12 = this.queue.get();
            r12.offer(new Event(r10, r11, null));
            if (this.dispatching.get().booleanValue() == true) goto L16;
            this.dispatching.set(Boolean.TRUE);
        L17:
            Event r13 = r12.poll();     // Catch: Throwable -> L11
            if (r13 == null) goto L13;
        L8:
            if (Event.access$400(r13).hasNext() == false) goto L17;
            ((Subscriber) Event.access$400(r13).next()).dispatchEvent(Event.access$500(r13));     // Catch: Throwable -> L11
            goto L8
        L13:
            this.dispatching.remove();
            this.queue.remove();
            return;
        L11:
            th = move-exception;
            this.dispatching.remove();
            this.queue.remove();
            throw th;
        }

        public /* synthetic */ PerThreadQueuedDispatcher(AnonymousClass1 r10) {
            this();
        }
    }

    public Dispatcher() {
    }

    public static Dispatcher immediate() {
        return ImmediateDispatcher.access$200();
    }

    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher(null);
    }

    public static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher(null);
    }

    public abstract void dispatch(Object r10, Iterator<Subscriber> r11);
}
