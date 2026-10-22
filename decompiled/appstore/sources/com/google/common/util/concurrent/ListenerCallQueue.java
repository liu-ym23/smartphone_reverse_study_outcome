package com.google.common.util.concurrent;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class ListenerCallQueue<L> {
    private static final Logger logger = null;
    private final List<PerListenerQueue<L>> listeners;

    public interface Event<L> {
        void call(L r10);
    }

    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;

        @GuardedBy("this")
        boolean isThreadScheduled;

        @GuardedBy("this")
        final Queue<Object> labelQueue;
        final L listener;

        @GuardedBy("this")
        final Queue<Event<L>> waitQueue;

        public PerListenerQueue(L r10, Executor r11) {
            this.waitQueue = Queues.newArrayDeque();
            this.labelQueue = Queues.newArrayDeque();
            this.listener = (L) Preconditions.checkNotNull(r10);
            this.executor = (Executor) Preconditions.checkNotNull(r11);
        }

        public synchronized void add(Event<L> r10, Object r11) {
            monitor-enter(this);
            this.waitQueue.add(r10);     // Catch: Throwable -> L6
            this.labelQueue.add(r11);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void dispatch() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.isThreadScheduled == true) goto L8;
            boolean r10 = true;
            this.isThreadScheduled = true;     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);     // Catch: Throwable -> L6
            if (r10 == true) goto L25;
            return;
        L25:
            this.executor.execute(this);     // Catch: RuntimeException -> L13
            return;
        L13:
            e = move-exception;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L19
            ListenerCallQueue.access$000().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, e);
            throw e;
        L19:
            th = move-exception;
            throw th;
        L8:
            r10 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            boolean r10 = true;
            monitor-enter(this);     // Catch: Throwable -> L16
            Preconditions.checkState(this.isThreadScheduled);     // Catch: Throwable -> L11
            Event<L> r11 = this.waitQueue.poll();     // Catch: Throwable -> L11
            Object r12 = this.labelQueue.poll();     // Catch: Throwable -> L11
            if (r11 == null) goto L6;
            monitor-exit(this);     // Catch: Throwable -> L11
            r11.call(this.listener);     // Catch: Throwable -> L16 RuntimeException -> L18
        L18:
            e = move-exception;
            ListenerCallQueue.access$000().log(Level.SEVERE, "Exception while executing callback: " + this.listener + " " + r12, e);     // Catch: Throwable -> L16
            goto L2
        L6:
            this.isThreadScheduled = false;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            Throwable th = th;
            boolean r13 = false;
        L42:
            monitor-exit(this);     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            boolean r14 = r13;
            th = th;
            r10 = r14;
        L27:
            if (r10 == false) goto L35;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L32
            monitor-exit(this);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        L35:
            throw th;
        L25:
            th = th;
        L11:
            th = move-exception;
            r13 = true;
            th = th;
        L16:
            th = th;
            goto L27
        }
    }

    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }

    public ListenerCallQueue() {
        this.listeners = Collections.synchronizedList(new ArrayList());
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    private void enqueueHelper(Event<L> r10, Object r11) {
        Preconditions.checkNotNull(r10, "event");
        Preconditions.checkNotNull(r11, ServerElements.LABEL);
        List<PerListenerQueue<L>> r12 = this.listeners;
        monitor-enter(r12);
        Iterator<PerListenerQueue<L>> r13 = this.listeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r13.hasNext() == false) goto L10;
        r13.next().add(r10, r11);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addListener(L r10, Executor r11) {
        Preconditions.checkNotNull(r10, "listener");
        Preconditions.checkNotNull(r11, "executor");
        this.listeners.add(new PerListenerQueue(r10, r11));
    }

    public void dispatch() {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).dispatch();
        r10 = r10 + 1;
        goto L4
    }

    public void enqueue(Event<L> r10) {
        enqueueHelper(r10, r10);
    }

    public void enqueue(Event<L> r10, String r11) {
        enqueueHelper(r10, r11);
    }
}
