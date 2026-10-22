package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class JdkFutureAdapters {

    private static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final Executor defaultAdapterExecutor = null;
        private static final ThreadFactory threadFactory = null;
        private final Executor adapterExecutor;
        private final Future<V> delegate;
        private final ExecutionList executionList;
        private final AtomicBoolean hasListeners;

        static /* synthetic */ Future access$000(ListenableFutureAdapter r0) {
            return r0.delegate;
        }

        static /* synthetic */ ExecutionList access$100(ListenableFutureAdapter r0) {
            return r0.executionList;
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        static {
            ThreadFactory r0 = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            threadFactory = r0;
            defaultAdapterExecutor = Executors.newCachedThreadPool(r0);
        }

        ListenableFutureAdapter(Future<V> r2) {
            this(r2, defaultAdapterExecutor);
        }

        ListenableFutureAdapter(Future<V> r3, Executor r4) {
            this.executionList = new ExecutionList();
            this.hasListeners = new AtomicBoolean(false);
            this.delegate = (Future) Preconditions.checkNotNull(r3);
            this.adapterExecutor = (Executor) Preconditions.checkNotNull(r4);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        protected Future<V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable r2, Executor r3) {
            this.executionList.add(r2, r3);
            if (this.hasListeners.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.delegate.isDone() == false) goto L8;
            this.executionList.execute();
            return;
        L8:
            this.adapterExecutor.execute(new AnonymousClass1(this));
        }
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r1) {
        if ((r1 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r1;
    L7:
        return new ListenableFutureAdapter(r1);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r1, Executor r2) {
        Preconditions.checkNotNull(r2);
        if ((r1 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r1;
    L7:
        return new ListenableFutureAdapter(r1, r2);
    }

    private JdkFutureAdapters() {
    }
}
