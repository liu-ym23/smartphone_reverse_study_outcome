package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class ExecutionList {
    private static final Logger log = null;

    @GuardedBy("this")
    private boolean executed;

    @NullableDecl
    @GuardedBy("this")
    private RunnableExecutorPair runnables;

    public static final class RunnableExecutorPair {
        final Executor executor;

        @NullableDecl
        RunnableExecutorPair next;
        final Runnable runnable;

        public RunnableExecutorPair(Runnable r10, Executor r11, RunnableExecutorPair r12) {
            this.runnable = r10;
            this.executor = r11;
            this.next = r12;
        }
    }

    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }

    public ExecutionList() {
    }

    private static void executeListener(Runnable r10, Executor r11) {
        r11.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r11, e);
    }

    public void add(Runnable r10, Executor r11) {
        Preconditions.checkNotNull(r10, "Runnable was null.");
        Preconditions.checkNotNull(r11, "Executor was null.");
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.executed == true) goto L11;
        this.runnables = new RunnableExecutorPair(r10, r11, this.runnables);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        executeListener(r10, r11);
    }

    public void execute() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.executed = true;     // Catch: Throwable -> L7
        RunnableExecutorPair r10 = this.runnables;     // Catch: Throwable -> L7
        RunnableExecutorPair r11 = null;
        this.runnables = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L11:
        if (r10 == null) goto L13;
        RunnableExecutorPair r12 = r10.next;
        r10.next = r11;
        r11 = r10;
        r10 = r12;
    L13:
        if (r11 == null) goto L15;
        executeListener(r11.runnable, r11.executor);
        r11 = r11.next;
        goto L13
    }
}
