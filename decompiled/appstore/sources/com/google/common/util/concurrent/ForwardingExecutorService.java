package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@GwtIncompatible
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
    public ForwardingExecutorService() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
        return delegate().awaitTermination(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract ExecutorService delegate();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        delegate().execute(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r10) throws InterruptedException {
        return delegate().invokeAll(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r10) throws InterruptedException, ExecutionException {
        return (T) delegate().invokeAny(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return delegate().isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return delegate().isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        delegate().shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return delegate().shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r10) {
        return delegate().submit(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r10, long r11, TimeUnit r12) throws InterruptedException {
        return delegate().invokeAll(r10, r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r10, long r11, TimeUnit r12) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) delegate().invokeAny(r10, r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r10) {
        return delegate().submit(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r10, T r11) {
        return delegate().submit(r10, r11);
    }
}
