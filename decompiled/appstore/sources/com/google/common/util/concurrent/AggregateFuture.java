package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final Logger logger = null;

    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState runningState;

    public abstract class RunningState extends AggregateFutureState implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
        final /* synthetic */ AggregateFuture this$0;

        public RunningState(AggregateFuture r10, ImmutableCollection<? extends ListenableFuture<? extends InputT>> r11, boolean r12, boolean r13) {
            this.this$0 = r10;
            super(r11.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(r11);
            this.allMustSucceed = r12;
            this.collectsValues = r13;
        }

        public static /* synthetic */ ImmutableCollection access$000(RunningState r10) {
            return r10.futures;
        }

        public static /* synthetic */ void access$100(RunningState r10) {
            r10.init();
        }

        public static /* synthetic */ void access$200(RunningState r10, int r11, Future r12) {
            r10.handleOneInputDone(r11, r12);
        }

        public static /* synthetic */ void access$300(RunningState r10) {
            r10.decrementCountAndMaybeComplete();
        }

        private void decrementCountAndMaybeComplete() {
            int r10 = decrementRemainingAndGet();
            if (r10 < 0) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11, "Less than 0 remaining futures");
            if (r10 != 0) goto L10;
            processCompleted();
            return;
        L10:
            return;
        L5:
            r11 = false;
            goto L6
        }

        private void handleException(Throwable r10) {
            Preconditions.checkNotNull(r10);
            if (this.allMustSucceed == false) goto L9;
            boolean r11 = this.this$0.setException(r10);
            if (r11 == false) goto L8;
            releaseResourcesAfterFailure();
        L7:
            boolean r12 = true;
        L10:
            boolean r13 = r10 instanceof Error;
            if ((((this.allMustSucceed & (!r11)) & r12) | r13) == false) goto L17;
            if (r13 == false) goto L14;
            String r14 = "Input Future failed with Error";
        L15:
            AggregateFuture.access$500().log(Level.SEVERE, r14, r10);
            return;
        L14:
            r14 = "Got more than one input Future failure. Logging failures after the first";
            goto L15
        L17:
            return;
        L8:
            r12 = AggregateFuture.access$400(getOrInitSeenExceptions(), r10);
            goto L10
        L9:
            r11 = false;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void handleOneInputDone(int r10, Future<? extends InputT> r11) {
            if (this.allMustSucceed == false) goto L5;
        L10:
            boolean r12 = true;
        L11:
            Preconditions.checkState(r12, "Future was done before all dependencies completed");
            Preconditions.checkState(r11.isDone(), "Tried to set value from future which is not done");     // Catch: Throwable -> L17 ExecutionException -> L19
            if (this.allMustSucceed == false) goto L25;
            if (r11.isCancelled() == false) goto L21;
            AggregateFuture.access$602(this.this$0, null);     // Catch: Throwable -> L17 ExecutionException -> L19
            this.this$0.cancel(false);     // Catch: Throwable -> L17 ExecutionException -> L19
        L33:
            return;
        L21:
            Object r13 = Futures.getDone(r11);     // Catch: Throwable -> L17 ExecutionException -> L19
            if (this.collectsValues == false) goto L33;
            collectOneValue(this.allMustSucceed, r10, r13);     // Catch: Throwable -> L17 ExecutionException -> L19
            goto L33
        L25:
            if (this.collectsValues == false) goto L33;
            if (r11.isCancelled() == true) goto L33;
            collectOneValue(this.allMustSucceed, r10, Futures.getDone(r11));     // Catch: Throwable -> L17 ExecutionException -> L19
        L19:
            e = move-exception;
            handleException(e.getCause());
            return;
        L17:
            th = move-exception;
            handleException(th);
            return;
        L5:
            if (this.this$0.isDone() == false) goto L10;
            if (this.this$0.isCancelled() == true) goto L10;
            r12 = false;
            goto L11
        }

        private void init() {
            if (this.futures.isEmpty() == false) goto L7;
            handleAllCompleted();
            return;
        L7:
            if (this.allMustSucceed == false) goto L12;
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r10 = this.futures.iterator();
            final int r11 = 0;
        L10:
            if (r10.hasNext() == false) goto L16;
            final ListenableFuture<? extends InputT> r12 = r10.next();
            int r13 = r11 + 1;
            r12.addListener(new AnonymousClass1(this, r11, r12), MoreExecutors.directExecutor());
            r11 = r13;
            goto L10
        L16:
            return;
        L12:
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r14 = this.futures.iterator();
        L14:
            if (r14.hasNext() == false) goto L19;
            r14.next().addListener(this, MoreExecutors.directExecutor());
            goto L14
        }

        private void processCompleted() {
            if ((this.collectsValues & (!this.allMustSucceed)) == false) goto L8;
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> r10 = this.futures.iterator();
            int r11 = 0;
        L6:
            if (r10.hasNext() == false) goto L8;
            handleOneInputDone(r11, r10.next());
            r11 = r11 + 1;
        L8:
            handleAllCompleted();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        public final void addInitialException(Set<Throwable> r10) {
            if (this.this$0.isCancelled() == true) goto L6;
            AggregateFuture.access$400(r10, this.this$0.tryInternalFastPathGetFailure());
            return;
        }

        public abstract void collectOneValue(boolean r10, int r11, @NullableDecl InputT r12);

        public abstract void handleAllCompleted();

        public void interruptTask() {
        }

        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }
    }

    static {
        logger = Logger.getLogger(AggregateFuture.class.getName());
    }

    public AggregateFuture() {
    }

    public static /* synthetic */ boolean access$400(Set r10, Throwable r11) {
        return addCausalChain(r10, r11);
    }

    public static /* synthetic */ Logger access$500() {
        return logger;
    }

    public static /* synthetic */ RunningState access$602(AggregateFuture r10, RunningState r11) {
        r10.runningState = r11;
        return r11;
    }

    private static boolean addCausalChain(Set<Throwable> r10, Throwable r11) {
    L2:
        if (r11 == null) goto L8;
        if (r10.add(r11) == false) goto L5;
        r11 = r11.getCause();
        goto L2
    L5:
        return false;
    L8:
        return true;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        AggregateFuture<InputT, OutputT>.RunningState r10 = this.runningState;
        if (r10 == null) goto L17;
        this.runningState = null;
        ImmutableCollection r11 = RunningState.access$000(r10);
        boolean r12 = wasInterrupted();
        if (r12 == false) goto L7;
        r10.interruptTask();
    L7:
        boolean r13 = isCancelled();
        if (r11 == null) goto L10;
        boolean r14 = true;
    L12:
        if ((r13 & r14) == false) goto L19;
        UnmodifiableIterator r15 = r11.iterator();
    L15:
        if (r15.hasNext() == false) goto L20;
        ((ListenableFuture) r15.next()).cancel(r12);
        goto L15
    L20:
        return;
    L19:
        return;
    L10:
        r14 = false;
        goto L12
    }

    public final void init(AggregateFuture<InputT, OutputT>.RunningState r10) {
        this.runningState = r10;
        RunningState.access$100(r10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        AggregateFuture<InputT, OutputT>.RunningState r10 = this.runningState;
        if (r10 != null) goto L5;
        return null;
    L5:
        ImmutableCollection r11 = RunningState.access$000(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        return "futures=[" + r11 + "]";
    }
}
