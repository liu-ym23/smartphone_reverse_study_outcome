package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible(emulated = true)
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    public static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        public TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r10, Executor r11) {
            super.addListener(r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean r10) {
            return super.cancel(r10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long r10, TimeUnit r11) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r10, r11);
        }
    }

    public FluentFuture() {
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> r10) {
        if ((r10 instanceof FluentFuture) == false) goto L6;
        return (FluentFuture) r10;
    L6:
        return new ForwardingFluentFuture(r10);
    }

    public final void addCallback(FutureCallback<? super V> r10, Executor r11) {
        Futures.addCallback(this, r10, r11);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> FluentFuture<V> catching(Class<X> r10, Function<? super X, ? extends V> r11, Executor r12) {
        return (FluentFuture) Futures.catching(this, r10, r11, r12);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> r10, AsyncFunction<? super X, ? extends V> r11, Executor r12) {
        return (FluentFuture) Futures.catchingAsync(this, r10, r11, r12);
    }

    public final <T> FluentFuture<T> transform(Function<? super V, T> r10, Executor r11) {
        return (FluentFuture) Futures.transform(this, r10, r11);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> r10, Executor r11) {
        return (FluentFuture) Futures.transformAsync(this, r10, r11);
    }

    @GwtIncompatible
    public final FluentFuture<V> withTimeout(long r10, TimeUnit r11, ScheduledExecutorService r12) {
        return (FluentFuture) Futures.withTimeout(this, r10, r11, r12);
    }

    @Deprecated
    public static <V> FluentFuture<V> from(FluentFuture<V> r10) {
        return (FluentFuture) Preconditions.checkNotNull(r10);
    }
}
