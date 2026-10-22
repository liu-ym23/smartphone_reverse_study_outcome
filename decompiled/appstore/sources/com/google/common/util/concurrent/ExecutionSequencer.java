package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Object>> ref;

    public static final enum RunningState extends Enum<RunningState> {
        private static final /* synthetic */ RunningState[] $VALUES = null;
        public static final RunningState CANCELLED = null;
        public static final RunningState NOT_RUN = null;
        public static final RunningState STARTED = null;

        static {
            RunningState r10 = new RunningState("NOT_RUN", 0);
            NOT_RUN = r10;
            RunningState r11 = new RunningState("CANCELLED", 1);
            CANCELLED = r11;
            RunningState r12 = new RunningState("STARTED", 2);
            STARTED = r12;
            $VALUES = new RunningState[]{r10, r11, r12};
        }

        private RunningState(String r10, int r11) {
            super(r10, r11);
        }

        public static RunningState valueOf(String r10) {
            return (RunningState) Enum.valueOf(RunningState.class, r10);
        }

        public static RunningState[] values() {
            return (RunningState[]) $VALUES.clone();
        }
    }

    private ExecutionSequencer() {
        this.ref = new AtomicReference(Futures.immediateFuture(null));
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> submit(final Callable<T> r10, Executor r11) {
        Preconditions.checkNotNull(r10);
        return submitAsync(new AnonymousClass1(this, r10), r11);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> r10, final Executor r11) {
        Preconditions.checkNotNull(r10);
        final AtomicReference r12 = new AtomicReference(RunningState.NOT_RUN);
        AsyncCallable<T> r13 = new AnonymousClass2(this, r12, r10);
        final SettableFuture r14 = SettableFuture.create();
        final ListenableFuture<Object> r15 = this.ref.getAndSet(r14);
        final ListenableFuture r16 = Futures.submitAsync(r13, new AnonymousClass3(this, r15, r11));
        final ListenableFuture<T> r17 = Futures.nonCancellationPropagating(r16);
        Runnable r18 = new AnonymousClass4(this, r16, r17, r12, r14, r15);
        r17.addListener(r18, MoreExecutors.directExecutor());
        r16.addListener(r18, MoreExecutors.directExecutor());
        return r17;
    }
}
