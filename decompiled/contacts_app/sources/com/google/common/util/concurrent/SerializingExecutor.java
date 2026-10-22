package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
final class SerializingExecutor implements Executor {
    private static final Logger log = null;
    private final Executor executor;
    private final Object internalLock;
    private boolean isThreadScheduled;
    private final TaskRunner taskRunner;
    private final Queue<Runnable> waitQueue;

    private class TaskRunner implements Runnable {
        final /* synthetic */ SerializingExecutor this$0;

        private TaskRunner(SerializingExecutor r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TaskRunner(SerializingExecutor r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            boolean r1 = true;
            Preconditions.checkState(SerializingExecutor.access$100(this.this$0));     // Catch: Throwable -> L26
            Object r2 = SerializingExecutor.access$200(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r2);     // Catch: Throwable -> L26
            Runnable r3 = (Runnable) SerializingExecutor.access$300(this.this$0).poll();     // Catch: Throwable -> L18
            if (r3 == null) goto L7;
            monitor-exit(r2);     // Catch: Throwable -> L18
            r3.run();     // Catch: RuntimeException -> L15 Throwable -> L26
        L15:
            e = move-exception;
            SerializingExecutor.access$400().log(Level.SEVERE, "Exception while executing runnable " + r3, e);     // Catch: Throwable -> L26
            goto L2
        L7:
            SerializingExecutor.access$102(this.this$0, false);     // Catch: Throwable -> L18
            monitor-exit(r2);     // Catch: Throwable -> L10
            return;
        L10:
            Throwable th = th;
            boolean r4 = false;
        L39:
            monitor-exit(r2);     // Catch: Throwable -> L24
            throw th;     // Catch: Throwable -> L22
        L22:
            th = th;
            r1 = r4;
        L27:
            if (r1 == false) goto L36;
            Object r5 = SerializingExecutor.access$200(this.this$0);
            monitor-enter(r5);
            SerializingExecutor.access$102(this.this$0, false);     // Catch: Throwable -> L33
            monitor-exit(r5);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L36:
            throw th;
        L24:
            th = th;
        L18:
            th = move-exception;
            r4 = true;
            th = th;
        L26:
            th = th;
            goto L27
        }
    }

    static /* synthetic */ boolean access$100(SerializingExecutor r0) {
        return r0.isThreadScheduled;
    }

    static /* synthetic */ boolean access$102(SerializingExecutor r0, boolean r1) {
        r0.isThreadScheduled = r1;
        return r1;
    }

    static /* synthetic */ Object access$200(SerializingExecutor r0) {
        return r0.internalLock;
    }

    static /* synthetic */ Queue access$300(SerializingExecutor r0) {
        return r0.waitQueue;
    }

    static /* synthetic */ Logger access$400() {
        return log;
    }

    static {
        log = Logger.getLogger(SerializingExecutor.class.getName());
    }

    public SerializingExecutor(Executor r3) {
        this.waitQueue = new ArrayDeque();
        this.isThreadScheduled = false;
        this.taskRunner = new TaskRunner(this, null);
        this.internalLock = new AnonymousClass1(this);
        Preconditions.checkNotNull(r3, "'executor' must not be null.");
        this.executor = r3;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        Preconditions.checkNotNull(r3, "'r' must not be null.");
        Object r0 = this.internalLock;
        monitor-enter(r0);
        this.waitQueue.add(r3);     // Catch: Throwable -> L22
        if (this.isThreadScheduled == true) goto L7;
        boolean r4 = true;
        this.isThreadScheduled = true;     // Catch: Throwable -> L22
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L22
        if (r4 == true) goto L25;
        return;
    L25:
        this.executor.execute(this.taskRunner);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        monitor-enter(this.internalLock);
        this.isThreadScheduled = false;     // Catch: Throwable -> L18
        throw th;
    L18:
        th = move-exception;
        throw th;
    L7:
        r4 = false;
    L22:
        th = move-exception;
        throw th;
    }
}
