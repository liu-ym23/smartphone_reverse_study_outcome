package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    public ListenableFutureTask(Callable<V> r10) {
        super(r10);
        this.executionList = new ExecutionList();
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> r10) {
        return new ListenableFutureTask(r10);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r10, Executor r11) {
        this.executionList.add(r10, r11);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.executionList.execute();
    }

    public static <V> ListenableFutureTask<V> create(Runnable r10, @NullableDecl V r11) {
        return new ListenableFutureTask(r10, r11);
    }

    public ListenableFutureTask(Runnable r10, @NullableDecl V r11) {
        super(r10, r11);
        this.executionList = new ExecutionList();
    }
}
