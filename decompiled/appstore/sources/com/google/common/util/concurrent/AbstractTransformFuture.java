package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    @NullableDecl
    F function;

    @NullableDecl
    ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> r10, AsyncFunction<? super I, ? extends O> r11) {
            super(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ Object doTransform(Object r10, @NullableDecl Object r11) throws Exception {
            return doTransform((AsyncFunction) r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ void setResult(Object r10) {
            setResult((ListenableFuture) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> r10, @NullableDecl I r11) throws Exception {
            ListenableFuture<? extends O> r12 = r10.apply(r11);
            Preconditions.checkNotNull(r12, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", r10);
            return r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setResult(ListenableFuture<? extends O> r10) {
            setFuture(r10);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public TransformFuture(ListenableFuture<? extends I> r10, Function<? super I, ? extends O> r11) {
            super(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @NullableDecl
        public /* bridge */ /* synthetic */ Object doTransform(Object r10, @NullableDecl Object r11) throws Exception {
            return doTransform((Function) r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(@NullableDecl O r10) {
            set(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        public O doTransform(Function<? super I, ? extends O> r10, @NullableDecl I r11) {
            return r10.apply(r11);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> r10, F r11) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(r10);
        this.function = (F) Preconditions.checkNotNull(r11);
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> r10, AsyncFunction<? super I, ? extends O> r11, Executor r12) {
        Preconditions.checkNotNull(r12);
        AsyncTransformFuture r13 = new AsyncTransformFuture(r10, r11);
        r10.addListener(r13, MoreExecutors.rejectionPropagatingExecutor(r12, r13));
        return r13;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @NullableDecl
    @ForOverride
    public abstract T doTransform(F r10, @NullableDecl I r11) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<? extends I> r10 = this.inputFuture;
        F r11 = this.function;
        String r12 = super.pendingToString();
        if (r10 == null) goto L5;
        String r13 = "inputFuture=[" + r10 + "], ";
    L6:
        if (r11 != null) goto L8;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r13 + r12;
    L8:
        return r13 + "function=[" + r11 + "]";
    L5:
        r13 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> r10 = this.inputFuture;
        F r11 = this.function;
        boolean r12 = isCancelled();
        boolean r13 = true;
        if (r10 != null) goto L5;
        boolean r14 = true;
    L6:
        boolean r15 = r12 | r14;
        if (r11 == null) goto L11;
        r13 = false;
    L11:
        if ((r15 | r13) == false) goto L13;
        return;
    L13:
        this.inputFuture = null;
        if (r10.isCancelled() == false) goto L43;
        setFuture(r10);
        return;
    L43:
        Object r16 = doTransform(r11, Futures.getDone(r10));     // Catch: Throwable -> L21
        this.function = null;
        setResult(r16);
        return;
    L21:
        th = move-exception;
        setException(th);     // Catch: Throwable -> L25
        this.function = null;
        return;
    L25:
        th = move-exception;
        this.function = null;
        throw th;
    L28:
        e = move-exception;
        setException(e);
        return;
    L37:
        cancel(false);
        return;
    L31:
        e = move-exception;
        setException(e);
        return;
    L34:
        e = move-exception;
        setException(e.getCause());
        return;
    L5:
        r14 = false;
        goto L6
    }

    @ForOverride
    public abstract void setResult(@NullableDecl T r10);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> r10, Function<? super I, ? extends O> r11, Executor r12) {
        Preconditions.checkNotNull(r11);
        TransformFuture r13 = new TransformFuture(r10, r11);
        r10.addListener(r13, MoreExecutors.rejectionPropagatingExecutor(r12, r13));
        return r13;
    }
}
