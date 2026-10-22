package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;
    private final Sync<V> sync;

    static final class Sync<V> extends AbstractQueuedSynchronizer {
        static final int CANCELLED = 4;
        static final int COMPLETED = 2;
        static final int COMPLETING = 1;
        static final int INTERRUPTED = 8;
        static final int RUNNING = 0;
        private static final long serialVersionUID = 0;
        private Throwable exception;
        private V value;

        Sync() {
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int r1) {
            if (isDone() == false) goto L6;
            return 1;
        L6:
            return -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryReleaseShared(int r1) {
            setState(r1);
            return true;
        }

        V get(long r2) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (tryAcquireSharedNanos(-1, r2) == false) goto L7;
            return getValue();
        L7:
            throw new TimeoutException("Timeout waiting for task.");
        }

        V get() throws CancellationException, ExecutionException, InterruptedException {
            acquireSharedInterruptibly(-1);
            return getValue();
        }

        private V getValue() throws CancellationException, ExecutionException {
            int r0 = getState();
            if (r0 == 2) goto L13;
            if (r0 == 4) goto L11;
            if (r0 == 8) goto L11;
            throw new IllegalStateException("Error, synchronizer in invalid state: " + r0);
        L11:
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.exception);
        L13:
            if (this.exception != null) goto L17;
            return this.value;
        L17:
            throw new ExecutionException(this.exception);
        }

        boolean isDone() {
            if ((getState() & 14) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isCancelled() {
            if ((getState() & 12) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean wasInterrupted() {
            if (getState() != 8) goto L5;
            return true;
        L5:
            return false;
        }

        boolean set(@Nullable V r3) {
            return complete(r3, null, 2);
        }

        boolean setException(Throwable r3) {
            return complete(null, r3, 2);
        }

        boolean cancel(boolean r2) {
            if (r2 == false) goto L4;
            int r3 = 8;
        L6:
            return complete(null, null, r3);
        L4:
            r3 = 4;
            goto L6
        }

        private boolean complete(@Nullable V r3, @Nullable Throwable r4, int r5) {
            boolean r0 = compareAndSetState(0, 1);
            if (r0 == false) goto L9;
            this.value = r3;
            if ((r5 & 12) == 0) goto L7;
            r4 = new CancellationException("Future.cancel() was called.");
        L7:
            this.exception = r4;
            releaseShared(r5);
        L11:
            return r0;
        L9:
            if (getState() != 1) goto L11;
            acquireShared(-1);
            goto L11
        }
    }

    protected void interruptTask() {
    }

    protected AbstractFuture() {
        this.sync = new Sync();
        this.executionList = new ExecutionList();
    }

    @Override // java.util.concurrent.Future
    public V get(long r1, TimeUnit r3) throws InterruptedException, TimeoutException, ExecutionException {
        return this.sync.get(r3.toNanos(r1));
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.sync.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.sync.isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.sync.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r2) {
        if (this.sync.cancel(r2) == true) goto L6;
        return false;
    L6:
        this.executionList.execute();
        if (r2 == false) goto L11;
        interruptTask();
        return true;
    L11:
        return true;
    }

    protected final boolean wasInterrupted() {
        return this.sync.wasInterrupted();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r1, Executor r2) {
        this.executionList.add(r1, r2);
    }

    protected boolean set(@Nullable V r2) {
        boolean r3 = this.sync.set(r2);
        if (r3 == false) goto L5;
        this.executionList.execute();
    L5:
        return r3;
    }

    protected boolean setException(Throwable r2) {
        boolean r3 = this.sync.setException((Throwable) Preconditions.checkNotNull(r2));
        if (r3 == false) goto L5;
        this.executionList.execute();
    L5:
        return r3;
    }

    static final CancellationException cancellationExceptionWithCause(@Nullable String r1, @Nullable Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }
}
