package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
    @Override // com.google.common.collect.ForwardingObject
    protected abstract ExecutorService delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingExecutorService() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        return delegate().awaitTermination(r1, r3);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r1) throws InterruptedException {
        return delegate().invokeAll(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r1, long r2, TimeUnit r4) throws InterruptedException {
        return delegate().invokeAll(r1, r2, r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r1) throws InterruptedException, ExecutionException {
        return (T) delegate().invokeAny(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r1, long r2, TimeUnit r4) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) delegate().invokeAny(r1, r2, r4);
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

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        delegate().execute(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r1) {
        return delegate().submit(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r1) {
        return delegate().submit(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r1, T r2) {
        return delegate().submit(r1, r2);
    }
}
