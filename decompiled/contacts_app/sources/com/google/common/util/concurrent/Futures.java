package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Futures {
    private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = null;
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = null;

    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private volatile ListenableFuture<? extends O> outputFuture;

        /* synthetic */ ChainingListenableFuture(AsyncFunction r1, ListenableFuture r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ ListenableFuture access$302(ChainingListenableFuture r0, ListenableFuture r1) {
            r0.outputFuture = r1;
            return r1;
        }

        private ChainingListenableFuture(AsyncFunction<? super I, ? extends O> r1, ListenableFuture<? extends I> r2) {
            this.function = (AsyncFunction) Preconditions.checkNotNull(r1);
            this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean r2) {
            if (super.cancel(r2) == false) goto L6;
            cancel(this.inputFuture, r2);
            cancel(this.outputFuture, r2);
            return true;
        L6:
            return false;
        }

        private void cancel(@Nullable Future<?> r1, boolean r2) {
            if (r1 == null) goto L5;
            r1.cancel(r2);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r1 = Uninterruptibles.getUninterruptibly(this.inputFuture);     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12 ExecutionException -> L14 CancellationException -> L16
            final ListenableFuture<? extends O> r2 = (ListenableFuture) Preconditions.checkNotNull(this.function.apply(r1), "AsyncFunction may not return null.");     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
            this.outputFuture = r2;     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
            if (isCancelled() == false) goto L9;
            r2.cancel(wasInterrupted());     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
            this.outputFuture = null;     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
        L7:
            this.function = null;
            this.inputFuture = null;
            return;
        L9:
            r2.addListener(new AnonymousClass1(this, r2), MoreExecutors.directExecutor());     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
        L19:
            this.function = null;
            this.inputFuture = null;
            return;
        L23:
            th = move-exception;
            this.function = null;
            this.inputFuture = null;
            throw th;
        L16:
            cancel(false);     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
        L14:
            e = move-exception;
            setException(e.getCause());     // Catch: Throwable -> L10 UndeclaredThrowableException -> L12
        L12:
            e = move-exception;
            setException(e.getCause());     // Catch: Throwable -> L23
        L26:
        L10:
            th = move-exception;
            setException(th);     // Catch: Throwable -> L23
            goto L26
        }
    }

    private static class CombinedFuture<V, C> extends AbstractFuture<C> {
        private static final Logger logger = null;
        final boolean allMustSucceed;
        FutureCombiner<V, C> combiner;
        ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
        final AtomicInteger remaining;
        Set<Throwable> seenExceptions;
        final Object seenExceptionsLock;
        List<Optional<V>> values;

        static /* synthetic */ void access$400(CombinedFuture r0, int r1, Future r2) {
            r0.setOneValue(r1, r2);
        }

        static {
            logger = Logger.getLogger(CombinedFuture.class.getName());
        }

        CombinedFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r2, boolean r3, Executor r4, FutureCombiner<V, C> r5) {
            this.seenExceptionsLock = new Object();
            this.futures = r2;
            this.allMustSucceed = r3;
            this.remaining = new AtomicInteger(r2.size());
            this.combiner = r5;
            this.values = Lists.newArrayListWithCapacity(r2.size());
            init(r4);
        }

        protected void init(Executor r6) {
            addListener(new AnonymousClass1(this), MoreExecutors.directExecutor());
            if (this.futures.isEmpty() == false) goto L6;
            set(this.combiner.combine(ImmutableList.of()));
            return;
        L6:
            final int r0 = 0;
            int r1 = 0;
        L8:
            if (r1 >= this.futures.size()) goto L10;
            this.values.add(null);
            r1 = r1 + 1;
            goto L8
        L10:
            UnmodifiableIterator<? extends ListenableFuture<? extends V>> r2 = this.futures.iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            final ListenableFuture<? extends V> r3 = r2.next();
            r3.addListener(new AnonymousClass2(this, r0, r3), r6);
            r0 = r0 + 1;
            goto L12
        }

        private void setExceptionAndMaybeLog(Throwable r4) {
            if (this.allMustSucceed == false) goto L15;
            boolean r0 = super.setException(r4);
            Object r1 = this.seenExceptionsLock;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (this.seenExceptions != null) goto L9;
            this.seenExceptions = Sets.newHashSet();     // Catch: Throwable -> L12
        L9:
            boolean r2 = this.seenExceptions.add(r4);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
        L17:
            if ((r4 instanceof Error) == false) goto L19;
        L22:
            logger.log(Level.SEVERE, "input future failed.", r4);
            return;
        L19:
            if (this.allMustSucceed == false) goto L26;
            if (r0 == true) goto L27;
            if (r2 == true) goto L22;
            return;
        L27:
            return;
        L26:
            return;
        L15:
            r0 = false;
            r2 = true;
            goto L17
        }

        private void setOneValue(int r7, Future<? extends V> r8) {
            List<Optional<V>> r1 = this.values;
            boolean r3 = true;
            if (isDone() == true) goto L6;
            if (r1 == null) goto L6;
        L78:
            Preconditions.checkState(r8.isDone(), "Tried to set value from future which is not done");     // Catch: Throwable -> L27 ExecutionException -> L39 CancellationException -> L51
            Object r9 = Uninterruptibles.getUninterruptibly(r8);     // Catch: Throwable -> L27 ExecutionException -> L39 CancellationException -> L51
            if (r1 == null) goto L16;
            r1.set(r7, Optional.fromNullable(r9));     // Catch: Throwable -> L27 ExecutionException -> L39 CancellationException -> L51
        L16:
            int r10 = this.remaining.decrementAndGet();
            if (r10 >= 0) goto L20;
            r3 = false;
        L20:
            Preconditions.checkState(r3, "Less than 0 remaining futures");
            if (r10 != 0) goto L64;
            FutureCombiner<V, C> r11 = this.combiner;
            if (r11 == null) goto L26;
            if (r1 == null) goto L26;
        L25:
            set(r11.combine(r1));
            return;
        L26:
            Preconditions.checkState(isDone());
            return;
        L64:
            return;
        L65:
            th = move-exception;
            int r12 = this.remaining.decrementAndGet();
            if (r12 >= 0) goto L70;
            r3 = false;
        L70:
            Preconditions.checkState(r3, "Less than 0 remaining futures");
            if (r12 != 0) goto L77;
            FutureCombiner<V, C> r13 = this.combiner;
            if (r13 == null) goto L76;
            if (r1 == null) goto L76;
            set(r13.combine(r1));
        L76:
            Preconditions.checkState(isDone());
        L77:
            throw th;
        L39:
            e = move-exception;
            setExceptionAndMaybeLog(e.getCause());     // Catch: Throwable -> L65
            int r14 = this.remaining.decrementAndGet();
            if (r14 >= 0) goto L45;
            r3 = false;
        L45:
            Preconditions.checkState(r3, "Less than 0 remaining futures");
            if (r14 != 0) goto L83;
            r11 = this.combiner;
            if (r11 == null) goto L26;
            if (r1 == null) goto L26;
        L83:
            return;
        L27:
            th = move-exception;
            setExceptionAndMaybeLog(th);     // Catch: Throwable -> L65
            int r15 = this.remaining.decrementAndGet();
            if (r15 >= 0) goto L33;
            r3 = false;
        L33:
            Preconditions.checkState(r3, "Less than 0 remaining futures");
            if (r15 != 0) goto L82;
            r11 = this.combiner;
            if (r11 == null) goto L26;
            if (r1 == null) goto L26;
        L82:
            return;
        L52:
            if (this.allMustSucceed == false) goto L54;
            cancel(false);     // Catch: Throwable -> L65
        L54:
            int r16 = this.remaining.decrementAndGet();
            if (r16 >= 0) goto L58;
            r3 = false;
        L58:
            Preconditions.checkState(r3, "Less than 0 remaining futures");
            if (r16 != 0) goto L84;
            r11 = this.combiner;
            if (r11 == null) goto L26;
            if (r1 == null) goto L26;
        L84:
            return;
        L6:
            if (this.allMustSucceed == false) goto L8;
        L11:
            boolean r2 = true;
        L12:
            Preconditions.checkState(r2, "Future was done before all dependencies completed");
            goto L78
        L8:
            if (isCancelled() == true) goto L11;
            r2 = false;
            goto L12
        }
    }

    private static final class CombinerFuture<V> extends ListenableFutureTask<V> {
        ImmutableList<ListenableFuture<?>> futures;

        CombinerFuture(Callable<V> r1, ImmutableList<ListenableFuture<?>> r2) {
            super(r1);
            this.futures = r2;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public boolean cancel(boolean r2) {
            ImmutableList<ListenableFuture<?>> r0 = this.futures;
            if (super.cancel(r2) == false) goto L10;
            UnmodifiableIterator<ListenableFuture<?>> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            r1.next().cancel(r2);
            goto L6
        L8:
            return true;
        L10:
            return false;
        }

        @Override // com.google.common.util.concurrent.ListenableFutureTask, java.util.concurrent.FutureTask
        protected void done() {
            super.done();
            this.futures = null;
        }

        @Override // java.util.concurrent.FutureTask
        protected void setException(Throwable r1) {
            super.setException(r1);
        }
    }

    private static class FallbackFuture<V> extends AbstractFuture<V> {
        private volatile ListenableFuture<? extends V> running;

        static /* synthetic */ ListenableFuture access$100(FallbackFuture r0) {
            return r0.running;
        }

        static /* synthetic */ ListenableFuture access$102(FallbackFuture r0, ListenableFuture r1) {
            r0.running = r1;
            return r1;
        }

        FallbackFuture(ListenableFuture<? extends V> r2, final FutureFallback<? extends V> r3, Executor r4) {
            this.running = r2;
            Futures.addCallback(this.running, new AnonymousClass1(this, r3), r4);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean r2) {
            if (super.cancel(r2) == false) goto L6;
            this.running.cancel(r2);
            return true;
        L6:
            return false;
        }
    }

    private interface FutureCombiner<V, C> {
        C combine(List<Optional<V>> r1);
    }

    private static class ImmediateCancelledFuture<V> extends ImmediateFuture<V> {
        private final CancellationException thrown;

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        ImmediateCancelledFuture() {
            super(null);
            this.thrown = new CancellationException("Immediate cancelled future.");
        }

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
        }
    }

    private static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final X thrown;

        ImmediateFailedCheckedFuture(X r2) {
            super(null);
            this.thrown = r2;
        }

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet() throws Exception {
            throw this.thrown;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet(long r1, TimeUnit r3) throws Exception {
            Preconditions.checkNotNull(r3);
            throw this.thrown;
        }
    }

    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable thrown;

        ImmediateFailedFuture(Throwable r2) {
            super(null);
            this.thrown = r2;
        }

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }

    private static abstract class ImmediateFuture<V> implements ListenableFuture<V> {
        private static final Logger log = null;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r1) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public abstract V get() throws ExecutionException;

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        private ImmediateFuture() {
        }

        /* synthetic */ ImmediateFuture(AnonymousClass1 r1) {
            this();
        }

        static {
            log = Logger.getLogger(ImmediateFuture.class.getName());
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable r5, Executor r6) {
            Preconditions.checkNotNull(r5, "Runnable was null.");
            Preconditions.checkNotNull(r6, "Executor was null.");
            r6.execute(r5);     // Catch: RuntimeException -> L5
            return;
        L5:
            e = move-exception;
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + r5 + " with executor " + r6, e);
        }

        @Override // java.util.concurrent.Future
        public V get(long r1, TimeUnit r3) throws ExecutionException {
            Preconditions.checkNotNull(r3);
            return get();
        }
    }

    private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {

        @Nullable
        private final V value;

        ImmediateSuccessfulCheckedFuture(@Nullable V r2) {
            super(null);
            this.value = r2;
        }

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.value;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet() {
            return this.value;
        }

        @Override // com.google.common.util.concurrent.CheckedFuture
        public V checkedGet(long r1, TimeUnit r3) {
            Preconditions.checkNotNull(r3);
            return this.value;
        }
    }

    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {

        @Nullable
        private final V value;

        ImmediateSuccessfulFuture(@Nullable V r2) {
            super(null);
            this.value = r2;
        }

        @Override // com.google.common.util.concurrent.Futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.value;
        }
    }

    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<? super Exception, X> mapper;

        MappingCheckedFuture(ListenableFuture<V> r1, Function<? super Exception, X> r2) {
            super(r1);
            this.mapper = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.util.concurrent.AbstractCheckedFuture
        protected X mapException(Exception r1) {
            return this.mapper.apply(r1);
        }
    }

    private static class NonCancellationPropagatingFuture<V> extends AbstractFuture<V> {
        NonCancellationPropagatingFuture(final ListenableFuture<V> r2) {
            Preconditions.checkNotNull(r2);
            Futures.addCallback(r2, new AnonymousClass1(this, r2), MoreExecutors.directExecutor());
        }
    }

    private static final class WrappedCombiner<T> implements Callable<T> {
        final Callable<T> delegate;
        CombinerFuture<T> outputFuture;

        WrappedCombiner(Callable<T> r1) {
            this.delegate = (Callable) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            return this.delegate.call();
        L4:
            this.outputFuture.cancel(false);
            return null;
        L5:
            e = move-exception;
            this.outputFuture.setException(e.getCause());
            return null;
        }
    }

    private Futures() {
    }

    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> r1, Function<? super Exception, X> r2) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(r1), r2);
    }

    public static <V> ListenableFuture<V> immediateFuture(@Nullable V r1) {
        return new ImmediateSuccessfulFuture(r1);
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V r1) {
        return new ImmediateSuccessfulCheckedFuture(r1);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r1) {
        Preconditions.checkNotNull(r1);
        return new ImmediateFailedFuture(r1);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateCancelledFuture();
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X r1) {
        Preconditions.checkNotNull(r1);
        return new ImmediateFailedCheckedFuture(r1);
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> r1, FutureFallback<? extends V> r2) {
        return withFallback(r1, r2, MoreExecutors.directExecutor());
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> r1, FutureFallback<? extends V> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        return new FallbackFuture(r1, r2, r3);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r2, AsyncFunction<? super I, ? extends O> r3) {
        ChainingListenableFuture r0 = new ChainingListenableFuture(r3, r2, null);
        r2.addListener(r0, MoreExecutors.directExecutor());
        return r0;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r2, AsyncFunction<? super I, ? extends O> r3, Executor r4) {
        Preconditions.checkNotNull(r4);
        ChainingListenableFuture r0 = new ChainingListenableFuture(r3, r2, null);
        r2.addListener(rejectionPropagatingRunnable(r0, r0, r4), MoreExecutors.directExecutor());
        return r0;
    }

    private static Runnable rejectionPropagatingRunnable(final AbstractFuture<?> r1, final Runnable r2, final Executor r3) {
        return new AnonymousClass1(r3, r2, r1);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r2, Function<? super I, ? extends O> r3) {
        Preconditions.checkNotNull(r3);
        ChainingListenableFuture r0 = new ChainingListenableFuture(asAsyncFunction(r3), r2, null);
        r2.addListener(r0, MoreExecutors.directExecutor());
        return r0;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r0, Function<? super I, ? extends O> r1, Executor r2) {
        Preconditions.checkNotNull(r1);
        return transform(r0, asAsyncFunction(r1), r2);
    }

    private static <I, O> AsyncFunction<I, O> asAsyncFunction(final Function<? super I, ? extends O> r1) {
        return new AnonymousClass2(r1);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> r1, final Function<? super I, ? extends O> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass3(r1, r2);
    }

    public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> r1) {
        return transform(r1, DEREFERENCER);
    }

    static {
        DEREFERENCER = new AnonymousClass4();
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new AnonymousClass7()).reverse();
    }

    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... r2) {
        return listFuture(ImmutableList.copyOf(r2), true, MoreExecutors.directExecutor());
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> r2) {
        return listFuture(ImmutableList.copyOf(r2), true, MoreExecutors.directExecutor());
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> r1) {
        return new NonCancellationPropagatingFuture(r1);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... r2) {
        return listFuture(ImmutableList.copyOf(r2), false, MoreExecutors.directExecutor());
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> r2) {
        return listFuture(ImmutableList.copyOf(r2), false, MoreExecutors.directExecutor());
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> r6) {
        final ConcurrentLinkedQueue r0 = Queues.newConcurrentLinkedQueue();
        ImmutableList.Builder r1 = ImmutableList.builder();
        SerializingExecutor r2 = new SerializingExecutor(MoreExecutors.directExecutor());
        Iterator<? extends ListenableFuture<? extends T>> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        final ListenableFuture<? extends T> r3 = r7.next();
        AsyncSettableFuture r4 = AsyncSettableFuture.create();
        r0.add(r4);
        r3.addListener(new AnonymousClass5(r0, r3), r2);
        r1.add(r4);
        goto L4
    L7:
        return r1.build();
    }

    public static <V> void addCallback(ListenableFuture<V> r1, FutureCallback<? super V> r2) {
        addCallback(r1, r2, MoreExecutors.directExecutor());
    }

    public static <V> void addCallback(final ListenableFuture<V> r1, final FutureCallback<? super V> r2, Executor r3) {
        Preconditions.checkNotNull(r2);
        r1.addListener(new AnonymousClass6(r1, r2), r3);
    }

    public static <V, X extends Exception> V get(Future<V> r3, Class<X> r4) throws Exception {
        Preconditions.checkNotNull(r3);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(r4), "Futures.get exception type (%s) must not be a RuntimeException", new Object[]{r4});
        return r3.get();
    L8:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r4, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r4);
        throw new AssertionError();
    }

    public static <V, X extends Exception> V get(Future<V> r3, long r4, TimeUnit r6, Class<X> r7) throws Exception {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r6);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(r7), "Futures.get exception type (%s) must not be a RuntimeException", new Object[]{r7});
        return r3.get(r4, r6);
    L11:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r7, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r7);
        throw new AssertionError();
    L8:
        e = move-exception;
        throw newWithCause(r7, e);
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable r1, Class<X> r2) throws Exception {
        if ((r1 instanceof Error) == true) goto L11;
        if ((r1 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r1);
    L9:
        throw newWithCause(r2, r1);
    L11:
        throw new ExecutionError((Error) r1);
    }

    public static <V> V getUnchecked(Future<V> r0) {
        Preconditions.checkNotNull(r0);
        return (V) Uninterruptibles.getUninterruptibly(r0);
    L5:
        e = move-exception;
        wrapAndThrowUnchecked(e.getCause());
        throw new AssertionError();
    }

    private static void wrapAndThrowUnchecked(Throwable r1) {
        if ((r1 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r1);
    L7:
        throw new UncheckedExecutionException(r1);
    }

    private static <X extends Exception> X newWithCause(Class<X> r3, Throwable r4) {
        Iterator r0 = preferringStrings(Arrays.asList(r3.getConstructors())).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        X r1 = (X) newFromConstructor((Constructor) r0.next(), r4);
        if (r1 == null) goto L4;
        if (r1.getCause() != null) goto L10;
        r1.initCause(r4);
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + r3 + " in response to chained exception", r4);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> r1) {
        return (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(r1);
    }

    @Nullable
    private static <X> X newFromConstructor(Constructor<X> r6, Throwable r7) {
        Class<?>[] r0 = r6.getParameterTypes();
        Object[] r1 = new Object[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L16;
        Class<?> r3 = r0[r2];
        if (r3.equals(String.class) == false) goto L9;
        r1[r2] = r7.toString();
    L11:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r3.equals(Throwable.class) == false) goto L12;
        r1[r2] = r7;
        goto L11
    L12:
        return null;
    L16:
        return r6.newInstance(r1);
    L15:
        return null;
    }

    private static <V> ListenableFuture<List<V>> listFuture(ImmutableList<ListenableFuture<? extends V>> r2, boolean r3, Executor r4) {
        return new CombinedFuture(r2, r3, r4, new AnonymousClass8());
    }
}
