package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
    @Override // java.util.concurrent.AbstractExecutorService
    protected /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Runnable r1, Object r2) {
        return newTaskFor(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Callable r1) {
        return newTaskFor(r1);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r1) {
        return submit(r1);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r1, @Nullable Object r2) {
        return submit(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Callable r1) {
        return submit(r1);
    }

    public AbstractListeningExecutorService() {
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> ListenableFutureTask<T> newTaskFor(Runnable r1, T r2) {
        return ListenableFutureTask.create(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> ListenableFutureTask<T> newTaskFor(Callable<T> r1) {
        return ListenableFutureTask.create(r1);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public ListenableFuture<?> submit(Runnable r1) {
        return (ListenableFuture) super.submit(r1);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> ListenableFuture<T> submit(Runnable r1, @Nullable T r2) {
        return (ListenableFuture) super.submit(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    public <T> ListenableFuture<T> submit(Callable<T> r1) {
        return (ListenableFuture) super.submit(r1);
    }
}
