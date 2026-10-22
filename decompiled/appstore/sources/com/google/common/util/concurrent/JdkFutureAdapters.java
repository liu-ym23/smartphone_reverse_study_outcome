package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class JdkFutureAdapters {

    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final Executor defaultAdapterExecutor = null;
        private static final ThreadFactory threadFactory = null;
        private final Executor adapterExecutor;
        private final Future<V> delegate;
        private final ExecutionList executionList;
        private final AtomicBoolean hasListeners;

        static {
            ThreadFactory r10 = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            threadFactory = r10;
            defaultAdapterExecutor = Executors.newCachedThreadPool(r10);
        }

        public ListenableFutureAdapter(Future<V> r10) {
            this(r10, defaultAdapterExecutor);
        }

        public static /* synthetic */ Future access$000(ListenableFutureAdapter r10) {
            return r10.delegate;
        }

        public static /* synthetic */ ExecutionList access$100(ListenableFutureAdapter r10) {
            return r10.executionList;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable r10, Executor r11) {
            this.executionList.add(r10, r11);
            if (this.hasListeners.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.delegate.isDone() == false) goto L8;
            this.executionList.execute();
            return;
        L8:
            this.adapterExecutor.execute(new AnonymousClass1(this));
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public ListenableFutureAdapter(Future<V> r10, Executor r11) {
            this.executionList = new ExecutionList();
            this.hasListeners = new AtomicBoolean(false);
            this.delegate = (Future) Preconditions.checkNotNull(r10);
            this.adapterExecutor = (Executor) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public Future<V> delegate() {
            return this.delegate;
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r10) {
        if ((r10 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r10;
    L7:
        return new ListenableFutureAdapter(r10);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r10, Executor r11) {
        Preconditions.checkNotNull(r11);
        if ((r10 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r10;
    L7:
        return new ListenableFutureAdapter(r10, r11);
    }
}
