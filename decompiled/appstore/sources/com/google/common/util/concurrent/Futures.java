package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Futures extends GwtFuturesCatchingSpecialization {

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        public CallbackListener(Future<V> r10, FutureCallback<? super V> r11) {
            this.future = r10;
            this.callback = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = Futures.getDone(this.future);     // Catch: Throwable -> L5 ExecutionException -> L7
            this.callback.onSuccess(r10);
            return;
        L5:
            e = move-exception;
            this.callback.onFailure(e);
            return;
        L7:
            e = move-exception;
            this.callback.onFailure(e.getCause());
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        public /* synthetic */ FutureCombiner(boolean r10, ImmutableList r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> r10, Executor r11) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r11, r10);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> r10, Executor r11) {
            return new CombinedFuture(this.futures, this.allMustSucceed, r11, r10);
        }

        public ListenableFuture<?> run(final Runnable r10, Executor r11) {
            return call(new AnonymousClass1(this, r10), r11);
        }

        private FutureCombiner(boolean r10, ImmutableList<ListenableFuture<? extends V>> r11) {
            this.allMustSucceed = r10;
            this.futures = r11;
        }
    }

    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        private InCompletionOrderState<T> state;

        public /* synthetic */ InCompletionOrderFuture(InCompletionOrderState r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.state = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean r10) {
            InCompletionOrderState<T> r11 = this.state;
            if (super.cancel(r10) == false) goto L6;
            InCompletionOrderState.access$400(r11, r10);
            return true;
        L6:
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            InCompletionOrderState<T> r10 = this.state;
            if (r10 != null) goto L5;
            return null;
        L5:
            return "inputCount=[" + InCompletionOrderState.access$500(r10).length + "], remaining=[" + InCompletionOrderState.access$600(r10).get() + "]";
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> r10) {
            this.state = r10;
        }
    }

    public static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        public /* synthetic */ InCompletionOrderState(ListenableFuture[] r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ void access$300(InCompletionOrderState r10, ImmutableList r11, int r12) {
            r10.recordInputCompletion(r11, r12);
        }

        public static /* synthetic */ void access$400(InCompletionOrderState r10, boolean r11) {
            r10.recordOutputCancellation(r11);
        }

        public static /* synthetic */ ListenableFuture[] access$500(InCompletionOrderState r10) {
            return r10.inputFutures;
        }

        public static /* synthetic */ AtomicInteger access$600(InCompletionOrderState r10) {
            return r10.incompleteOutputCount;
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.wasCancelled == false) goto L16;
            ListenableFuture<? extends T>[] r10 = this.inputFutures;
            int r11 = r10.length;
            int r12 = 0;
        L7:
            if (r12 >= r11) goto L17;
            ListenableFuture<? extends T> r13 = r10[r12];
            if (r13 == null) goto L11;
            r13.cancel(this.shouldInterrupt);
        L11:
            r12 = r12 + 1;
            goto L7
        L17:
            return;
        }

        private void recordInputCompletion(ImmutableList<AbstractFuture<T>> r10, int r11) {
            ListenableFuture<? extends T>[] r12 = this.inputFutures;
            ListenableFuture<? extends T> r13 = r12[r11];
            r12[r11] = null;
            int r14 = this.delegateIndex;
        L4:
            if (r14 >= r10.size()) goto L10;
            if (r10.get(r14).setFuture(r13) == true) goto L7;
            r14 = r14 + 1;
            goto L4
        L7:
            recordCompletion();
            this.delegateIndex = r14 + 1;
            return;
        L10:
            this.delegateIndex = r10.size();
        }

        private void recordOutputCancellation(boolean r10) {
            this.wasCancelled = true;
            if (r10 == true) goto L5;
            this.shouldInterrupt = false;
        L5:
            recordCompletion();
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] r10) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = r10;
            this.incompleteOutputCount = new AtomicInteger(r10.length);
        }
    }

    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        private ListenableFuture<V> delegate;

        public NonCancellationPropagatingFuture(ListenableFuture<V> r10) {
            this.delegate = r10;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            ListenableFuture<V> r10 = this.delegate;
            if (r10 != null) goto L5;
            return null;
        L5:
            return "delegate=[" + r10 + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> r10 = this.delegate;
            if (r10 == null) goto L6;
            setFuture(r10);
            return;
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> r10, FutureCallback<? super V> r11, Executor r12) {
        Preconditions.checkNotNull(r11);
        r10.addListener(new CallbackListener(r10, r11), r12);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... r10) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r10), true);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> r10, Class<X> r11, Function<? super X, ? extends V> r12, Executor r13) {
        return AbstractCatchingFuture.create(r10, r11, r12, r13);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> r10, Class<X> r11, AsyncFunction<? super X, ? extends V> r12, Executor r13) {
        return AbstractCatchingFuture.create(r10, r11, r12, r13);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> r10, Class<X> r11) throws Exception {
        return (V) FuturesGetChecked.getChecked(r10, r11);
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> r10) throws ExecutionException {
        Preconditions.checkState(r10.isDone(), "Future was expected to be done: %s", r10);
        return (V) Uninterruptibles.getUninterruptibly(r10);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> r10) {
        Preconditions.checkNotNull(r10);
        return (V) Uninterruptibles.getUninterruptibly(r10);
    L5:
        e = move-exception;
        wrapAndThrowUnchecked(e.getCause());
        throw new AssertionError();
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r10) {
        Preconditions.checkNotNull(r10);
        return new ImmediateFuture.ImmediateFailedFuture(r10);
    }

    public static <V> ListenableFuture<V> immediateFuture(@NullableDecl V r10) {
        if (r10 != null) goto L6;
        return ImmediateFuture.ImmediateSuccessfulFuture.NULL;
    L6:
        return new ImmediateFuture.ImmediateSuccessfulFuture(r10);
    }

    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r10;
    L6:
        ListenableFuture[] r12 = (ListenableFuture[]) r11.toArray(new ListenableFuture[r11.size()]);
        AnonymousClass1 r13 = null;
        final InCompletionOrderState r14 = new InCompletionOrderState(r12, r13);
        ImmutableList.Builder r15 = ImmutableList.builder();
        final int r16 = 0;
        int r17 = 0;
    L8:
        if (r17 >= r12.length) goto L10;
        r15.add(new InCompletionOrderFuture(r14, r13));
        r17 = r17 + 1;
        goto L8
    L10:
        final ImmutableList<ListenableFuture<T>> r18 = r15.build();
    L12:
        if (r16 >= r12.length) goto L14;
        r12[r16].addListener(new AnonymousClass3(r14, r18, r16), MoreExecutors.directExecutor());
        r16 = r16 + 1;
        goto L12
    L14:
        return r18;
    L5:
        r11 = ImmutableList.copyOf(r10);
        goto L6
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(final Future<I> r10, final Function<? super I, ? extends O> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass2(r10, r11);
    }

    @Beta
    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> r10) {
        if (r10.isDone() == false) goto L5;
        return r10;
    L5:
        NonCancellationPropagatingFuture r11 = new NonCancellationPropagatingFuture(r10);
        r10.addListener(r11, MoreExecutors.directExecutor());
        return r11;
    }

    @Beta
    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> r10, long r11, TimeUnit r12, ScheduledExecutorService r13) {
        TrustedListenableFutureTask r14 = TrustedListenableFutureTask.create(r10);
        final ScheduledFuture<?> r15 = r13.schedule(r14, r11, r12);
        r14.addListener(new AnonymousClass1(r15), MoreExecutors.directExecutor());
        return r14;
    }

    @Beta
    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> r10, Executor r11) {
        TrustedListenableFutureTask r12 = TrustedListenableFutureTask.create(r10);
        r11.execute(r12);
        return r12;
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... r10) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r10), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r10, Function<? super I, ? extends O> r11, Executor r12) {
        return AbstractTransformFuture.create(r10, r11, r12);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> r10, AsyncFunction<? super I, ? extends O> r11, Executor r12) {
        return AbstractTransformFuture.create(r10, r11, r12);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... r10) {
        boolean r11 = false;
        return new FutureCombiner(r11, ImmutableList.copyOf(r10), null);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... r10) {
        boolean r11 = true;
        return new FutureCombiner(r11, ImmutableList.copyOf(r10), null);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> r10, long r11, TimeUnit r12, ScheduledExecutorService r13) {
        if (r10.isDone() == false) goto L6;
        return r10;
    L6:
        return TimeoutFuture.create(r10, r11, r12, r13);
    }

    private static void wrapAndThrowUnchecked(Throwable r10) {
        if ((r10 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r10);
    L7:
        throw new UncheckedExecutionException(r10);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> r10) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r10), true);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> r10, Class<X> r11, long r12, TimeUnit r13) throws Exception {
        return (V) FuturesGetChecked.getChecked(r10, r11, r12, r13);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> r10) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(r10), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> r10) {
        boolean r11 = false;
        return new FutureCombiner(r11, ImmutableList.copyOf(r10), null);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> r10) {
        boolean r11 = true;
        return new FutureCombiner(r11, ImmutableList.copyOf(r10), null);
    }
}
