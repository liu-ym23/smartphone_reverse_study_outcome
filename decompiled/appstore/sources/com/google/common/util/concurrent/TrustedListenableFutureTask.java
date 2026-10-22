package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        public TrustedFutureInterruptibleAsyncTask(TrustedListenableFutureTask r10, AsyncCallable<V> r11) {
            this.this$0 = r10;
            this.callable = (AsyncCallable) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ void afterRanInterruptibly(Object r10, Throwable r11) {
            afterRanInterruptibly((ListenableFuture) r10, r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ Object runInterruptibly() throws Exception {
            return runInterruptibly();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        public void afterRanInterruptibly(ListenableFuture<V> r10, Throwable r11) {
            if (r11 != null) goto L4;
            this.this$0.setFuture(r10);
            return;
        L4:
            this.this$0.setException(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        public TrustedFutureInterruptibleTask(TrustedListenableFutureTask r10, Callable<V> r11) {
            this.this$0 = r10;
            this.callable = (Callable) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V r10, Throwable r11) {
            if (r11 != null) goto L4;
            this.this$0.set(r10);
            return;
        L4:
            this.this$0.setException(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(Callable<V> r10) {
        this.task = new TrustedFutureInterruptibleTask(this, r10);
    }

    public static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> r10) {
        return new TrustedListenableFutureTask(r10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        super.afterDone();
        if (wasInterrupted() == false) goto L7;
        InterruptibleTask<?> r10 = this.task;
        if (r10 == null) goto L7;
        r10.interruptTask();
    L7:
        this.task = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        InterruptibleTask<?> r10 = this.task;
        if (r10 == null) goto L7;
        return "task=[" + r10 + "]";
    L7:
        return super.pendingToString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> r10 = this.task;
        if (r10 == null) goto L5;
        r10.run();
    L5:
        this.task = null;
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> r10) {
        return new TrustedListenableFutureTask(r10);
    }

    public TrustedListenableFutureTask(AsyncCallable<V> r10) {
        this.task = new TrustedFutureInterruptibleAsyncTask(this, r10);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable r10, @NullableDecl V r11) {
        return new TrustedListenableFutureTask(Executors.callable(r10, r11));
    }
}
