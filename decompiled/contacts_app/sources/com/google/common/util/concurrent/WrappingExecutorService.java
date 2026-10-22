package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    protected abstract <T> Callable<T> wrapTask(Callable<T> r1);

    protected WrappingExecutorService(ExecutorService r1) {
        this.delegate = (ExecutorService) Preconditions.checkNotNull(r1);
    }

    protected Runnable wrapTask(Runnable r2) {
        final Callable r3 = wrapTask(Executors.callable(r2, null));
        return new AnonymousClass1(this, r3);
    }

    private final <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> r3) {
        ImmutableList.Builder r0 = ImmutableList.builder();
        Iterator<? extends Callable<T>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.add(wrapTask(r4.next()));
        goto L4
    L7:
        return r0.build();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        this.delegate.execute(wrapTask(r2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r2) {
        return this.delegate.submit(wrapTask((Callable) Preconditions.checkNotNull(r2)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r2) {
        return this.delegate.submit(wrapTask(r2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r2, T r3) {
        return this.delegate.submit(wrapTask(r2), r3);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r2) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r2, long r3, TimeUnit r5) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r2), r3, r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r2) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(wrapTasks(r2));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r2, long r3, TimeUnit r5) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(wrapTasks(r2), r3, r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        return this.delegate.awaitTermination(r1, r3);
    }
}
