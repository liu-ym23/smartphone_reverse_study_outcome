package com.google.common.util.concurrent;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class ListenerCallQueue<L> implements Runnable {
    private static final Logger logger = null;
    private final Executor executor;
    private boolean isThreadScheduled;
    private final L listener;
    private final Queue<Callback<L>> waitQueue;

    static abstract class Callback<L> {
        private final String methodCall;

        abstract void call(L r1);

        static /* synthetic */ String access$000(Callback r0) {
            return r0.methodCall;
        }

        Callback(String r1) {
            this.methodCall = r1;
        }

        void enqueueOn(Iterable<ListenerCallQueue<L>> r2) {
            Iterator<ListenerCallQueue<L>> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().add(this);
            goto L4
        }
    }

    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }

    ListenerCallQueue(L r2, Executor r3) {
        this.waitQueue = Queues.newArrayDeque();
        this.listener = (L) Preconditions.checkNotNull(r2);
        this.executor = (Executor) Preconditions.checkNotNull(r3);
    }

    synchronized void add(Callback<L> r2) {
        monitor-enter(this);
        this.waitQueue.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void execute() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.isThreadScheduled == true) goto L6;
        boolean r0 = true;
        this.isThreadScheduled = true;     // Catch: Throwable -> L21
    L7:
        monitor-exit(this);     // Catch: Throwable -> L21
        if (r0 == true) goto L26;
        return;
    L26:
        this.executor.execute(this);     // Catch: RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        monitor-enter(this);
        this.isThreadScheduled = false;     // Catch: Throwable -> L17
        logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, e);
        throw e;
    L17:
        th = move-exception;
        throw th;
    L6:
        r0 = false;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
    L2:
        boolean r1 = true;
        monitor-enter(this);     // Catch: Throwable -> L25
        Preconditions.checkState(this.isThreadScheduled);     // Catch: Throwable -> L17
        Callback<L> r2 = this.waitQueue.poll();     // Catch: Throwable -> L17
        if (r2 == null) goto L6;
        monitor-exit(this);     // Catch: Throwable -> L17
        r2.call(this.listener);     // Catch: RuntimeException -> L14 Throwable -> L25
    L14:
        e = move-exception;
        logger.log(Level.SEVERE, "Exception while executing callback: " + this.listener + LibrarianImpl.Constants.DOT + Callback.access$000(r2), e);     // Catch: Throwable -> L25
        goto L2
    L6:
        this.isThreadScheduled = false;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        Throwable th = th;
        boolean r3 = false;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        boolean r8 = r3;
        th = th;
        r1 = r8;
    L26:
        if (r1 == false) goto L34;
        monitor-enter(this);
        this.isThreadScheduled = false;     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L34:
        throw th;
    L23:
        th = th;
    L17:
        th = move-exception;
        r3 = true;
        th = th;
    L25:
        th = th;
        goto L26
    }
}
