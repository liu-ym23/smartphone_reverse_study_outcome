package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class AsyncSettableFuture<V> extends ForwardingListenableFuture<V> {
    private final ListenableFuture<V> dereferenced;
    private final NestedFuture<V> nested;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AsyncSettableFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class NestedFuture<V> extends AbstractFuture<ListenableFuture<? extends V>> {
        private NestedFuture() {
        }

        /* synthetic */ NestedFuture(AnonymousClass1 r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean setFuture(ListenableFuture<? extends V> r3) {
            boolean r0 = set(r3);
            if (isCancelled() == false) goto L5;
            r3.cancel(wasInterrupted());
        L5:
            return r0;
        }
    }

    @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Future delegate() {
        return delegate();
    }

    public static <V> AsyncSettableFuture<V> create() {
        return new AsyncSettableFuture();
    }

    private AsyncSettableFuture() {
        NestedFuture<V> r0 = new NestedFuture(null);
        this.nested = r0;
        this.dereferenced = Futures.dereference(r0);
    }

    @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    protected ListenableFuture<V> delegate() {
        return this.dereferenced;
    }

    public boolean setFuture(ListenableFuture<? extends V> r1) {
        return this.nested.setFuture((ListenableFuture) Preconditions.checkNotNull(r1));
    }

    public boolean setValue(@Nullable V r1) {
        return setFuture(Futures.immediateFuture(r1));
    }

    public boolean setException(Throwable r1) {
        return setFuture(Futures.immediateFailedFuture(r1));
    }

    public boolean isSet() {
        return this.nested.isDone();
    }
}
