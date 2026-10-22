package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public AsyncCallableInterruptibleTask(CombinedFuture r10, AsyncCallable<V> r11, Executor r12) {
            this.this$0 = r10;
            super(r10, r12);
            this.callable = (AsyncCallable) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ Object runInterruptibly() throws Exception {
            return runInterruptibly();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object r10) {
            setValue((ListenableFuture) r10);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        public void setValue(ListenableFuture<V> r10) {
            this.this$0.setFuture(r10);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public CallableInterruptibleTask(CombinedFuture r10, Callable<V> r11, Executor r12) {
            this.this$0 = r10;
            super(r10, r12);
            this.callable = (Callable) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V r10) {
            this.this$0.set(r10);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;
        boolean thrownByExecute;

        public CombinedFutureInterruptibleTask(CombinedFuture r10, Executor r11) {
            this.this$0 = r10;
            this.thrownByExecute = true;
            this.listenerExecutor = (Executor) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T r10, Throwable r11) {
            if (r11 != null) goto L4;
            setValue(r10);
            return;
        L4:
            if ((r11 instanceof ExecutionException) == false) goto L7;
            this.this$0.setException(r11.getCause());
            return;
        L7:
            if ((r11 instanceof CancellationException) == false) goto L9;
            this.this$0.cancel(false);
            return;
        L9:
            this.this$0.setException(r11);
        }

        public final void execute() {
            this.listenerExecutor.execute(this);     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            if (this.thrownByExecute == false) goto L11;
            this.this$0.setException(e);
            return;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return this.this$0.isDone();
        }

        public abstract void setValue(T r10);
    }

    public final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask task;
        final /* synthetic */ CombinedFuture this$0;

        public CombinedFutureRunningState(CombinedFuture r10, ImmutableCollection<? extends ListenableFuture<?>> r11, boolean r12, CombinedFutureInterruptibleTask r13) {
            this.this$0 = r10;
            super(r10, r11, r12, false);
            this.task = r13;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void collectOneValue(boolean r10, int r11, @NullableDecl Object r12) {
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void handleAllCompleted() {
            CombinedFutureInterruptibleTask r10 = this.task;
            if (r10 == null) goto L5;
            r10.execute();
            return;
        L5:
            Preconditions.checkState(this.this$0.isDone());
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void interruptTask() {
            CombinedFutureInterruptibleTask r10 = this.task;
            if (r10 == null) goto L6;
            r10.interruptTask();
            return;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.task = null;
        }
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> r10, boolean r11, Executor r12, AsyncCallable<V> r13) {
        init(new CombinedFutureRunningState(this, r10, r11, new AsyncCallableInterruptibleTask(this, r13, r12)));
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> r10, boolean r11, Executor r12, Callable<V> r13) {
        init(new CombinedFutureRunningState(this, r10, r11, new CallableInterruptibleTask(this, r13, r12)));
    }
}
