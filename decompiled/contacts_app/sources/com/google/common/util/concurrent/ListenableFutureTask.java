package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    public static <V> ListenableFutureTask<V> create(Callable<V> r1) {
        return new ListenableFutureTask(r1);
    }

    public static <V> ListenableFutureTask<V> create(Runnable r1, @Nullable V r2) {
        return new ListenableFutureTask(r1, r2);
    }

    ListenableFutureTask(Callable<V> r1) {
        super(r1);
        this.executionList = new ExecutionList();
    }

    ListenableFutureTask(Runnable r1, @Nullable V r2) {
        super(r1, r2);
        this.executionList = new ExecutionList();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r1, Executor r2) {
        this.executionList.add(r1, r2);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.execute();
    }
}
