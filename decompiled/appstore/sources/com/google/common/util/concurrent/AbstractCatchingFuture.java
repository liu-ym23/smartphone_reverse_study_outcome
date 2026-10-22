package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    @NullableDecl
    Class<X> exceptionType;

    @NullableDecl
    F fallback;

    @NullableDecl
    ListenableFuture<? extends V> inputFuture;

    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public AsyncCatchingFuture(ListenableFuture<? extends V> r10, Class<X> r11, AsyncFunction<? super X, ? extends V> r12) {
            super(r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ Object doFallback(Object r10, Throwable r11) throws Exception {
            return doFallback((AsyncFunction) r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ void setResult(Object r10) {
            setResult((ListenableFuture) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> r10, X r11) throws Exception {
            ListenableFuture<? extends V> r12 = r10.apply(r11);
            Preconditions.checkNotNull(r12, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", r10);
            return r12;
        }

        public void setResult(ListenableFuture<? extends V> r10) {
            setFuture(r10);
        }
    }

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        public CatchingFuture(ListenableFuture<? extends V> r10, Class<X> r11, Function<? super X, ? extends V> r12) {
            super(r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @NullableDecl
        public /* bridge */ /* synthetic */ Object doFallback(Object r10, Throwable r11) throws Exception {
            return doFallback((Function) r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(@NullableDecl V r10) {
            set(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public V doFallback(Function<? super X, ? extends V> r10, X r11) throws Exception {
            return r10.apply(r11);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> r10, Class<X> r11, F r12) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(r10);
        this.exceptionType = (Class) Preconditions.checkNotNull(r11);
        this.fallback = (F) Preconditions.checkNotNull(r12);
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> r10, Class<X> r11, Function<? super X, ? extends V> r12, Executor r13) {
        CatchingFuture r14 = new CatchingFuture(r10, r11, r12);
        r10.addListener(r14, MoreExecutors.rejectionPropagatingExecutor(r13, r14));
        return r14;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @NullableDecl
    @ForOverride
    public abstract T doFallback(F r10, X r11) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<? extends V> r10 = this.inputFuture;
        Class<X> r11 = this.exceptionType;
        F r12 = this.fallback;
        String r13 = super.pendingToString();
        if (r10 == null) goto L5;
        String r14 = "inputFuture=[" + r10 + "], ";
    L6:
        if (r11 == null) goto L10;
        if (r12 == null) goto L10;
        return r14 + "exceptionType=[" + r11 + "], fallback=[" + r12 + "]";
    L10:
        if (r13 != null) goto L12;
        return null;
    L12:
        return r14 + r13;
    L5:
        r14 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends V> r10 = this.inputFuture;
        Class<X> r11 = this.exceptionType;
        F r12 = this.fallback;
        boolean r13 = false;
        if (r10 != null) goto L5;
        boolean r14 = true;
    L6:
        if (r11 != null) goto L8;
        boolean r15 = true;
    L9:
        boolean r16 = r14 | r15;
        if (r12 != null) goto L13;
        r13 = true;
    L13:
        if (((r13 | r16) | isCancelled()) == false) goto L15;
        return;
    L15:
        this.inputFuture = null;
        Object r17 = Futures.getDone(r10);     // Catch: Throwable -> L18 ExecutionException -> L20
        th = null;
    L22:
        if (th != null) goto L26;
        set(r17);
        return;
    L26:
        if (Platform.isInstanceOfThrowableClass(th, r11) == true) goto L39;
        setFuture(r10);
        return;
    L39:
        Object r18 = doFallback(r12, th);     // Catch: Throwable -> L32
        this.exceptionType = null;
        this.fallback = null;
        setResult(r18);
        return;
    L32:
        th = move-exception;
        setException(th);     // Catch: Throwable -> L36
        this.exceptionType = null;
        this.fallback = null;
        return;
    L36:
        th = move-exception;
        this.exceptionType = null;
        this.fallback = null;
        throw th;
    L20:
        e = move-exception;
        th = (Throwable) Preconditions.checkNotNull(e.getCause());
    L19:
        r17 = null;
    L18:
        th = th;
        goto L19
    L8:
        r15 = false;
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    @ForOverride
    public abstract void setResult(@NullableDecl T r10);

    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> r10, Class<X> r11, AsyncFunction<? super X, ? extends V> r12, Executor r13) {
        AsyncCatchingFuture r14 = new AsyncCatchingFuture(r10, r11, r12);
        r10.addListener(r14, MoreExecutors.rejectionPropagatingExecutor(r13, r14));
        return r14;
    }
}
