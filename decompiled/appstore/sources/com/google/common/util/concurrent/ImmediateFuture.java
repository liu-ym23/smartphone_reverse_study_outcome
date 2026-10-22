package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final Logger log = null;

    public static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        public ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    public static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        public ImmediateFailedFuture(Throwable r10) {
            setException(r10);
        }
    }

    public static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> NULL = null;

        @NullableDecl
        private final V value;

        static {
            NULL = new ImmediateSuccessfulFuture(null);
        }

        public ImmediateSuccessfulFuture(@NullableDecl V r10) {
            this.value = r10;
        }

        @Override // com.google.common.util.concurrent.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.value;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.value + "]]";
        }
    }

    static {
        log = Logger.getLogger(ImmediateFuture.class.getName());
    }

    public ImmediateFuture() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r10, Executor r11) {
        Preconditions.checkNotNull(r10, "Runnable was null.");
        Preconditions.checkNotNull(r11, "Executor was null.");
        r11.execute(r10);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r11, e);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long r10, TimeUnit r11) throws ExecutionException {
        Preconditions.checkNotNull(r11);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
