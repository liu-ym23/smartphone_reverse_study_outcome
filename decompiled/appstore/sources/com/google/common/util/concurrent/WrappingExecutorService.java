package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
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

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@GwtIncompatible
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    public WrappingExecutorService(ExecutorService r10) {
        this.delegate = (ExecutorService) Preconditions.checkNotNull(r10);
    }

    private <T> ImmutableList<Callable<T>> wrapTasks(Collection<? extends Callable<T>> r10) {
        ImmutableList.Builder r11 = ImmutableList.builder();
        Iterator<? extends Callable<T>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.add(wrapTask(r12.next()));
        goto L4
    L7:
        return r11.build();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
        return this.delegate.awaitTermination(r10, r11);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r10) {
        this.delegate.execute(wrapTask(r10));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r10) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r10));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r10) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(wrapTasks(r10));
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
    public final void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r10) {
        return this.delegate.submit(wrapTask((Callable) Preconditions.checkNotNull(r10)));
    }

    public Runnable wrapTask(Runnable r10) {
        final Callable r11 = wrapTask(Executors.callable(r10, null));
        return new AnonymousClass1(this, r11);
    }

    public abstract <T> Callable<T> wrapTask(Callable<T> r10);

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r10, long r11, TimeUnit r12) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(r10), r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> r10, long r11, TimeUnit r12) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(wrapTasks(r10), r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r10) {
        return this.delegate.submit(wrapTask(r10));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r10, T r11) {
        return this.delegate.submit(wrapTask(r10), r11);
    }
}
