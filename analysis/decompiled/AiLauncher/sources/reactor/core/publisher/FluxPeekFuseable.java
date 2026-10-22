package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxPeekFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable, SignalPeek<T> {
    final Runnable onAfterTerminateCall;
    final Runnable onCancelCall;
    final Runnable onCompleteCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super T> onNextCall;
    final LongConsumer onRequestCall;
    final Consumer<? super qc.d> onSubscribeCall;

    public static final class PeekConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39543s;

        public PeekConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalPeek<T> signalPeek) {
            this.actual = conditionalSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39543s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f39543s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            Context contextCurrentContext = this.actual.currentContext();
            if (!contextCurrentContext.isEmpty() && this.parent.onCurrentContextCall() != null) {
                this.parent.onCurrentContextCall().accept(contextCurrentContext);
            }
            return contextCurrentContext;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
            if (runnableOnCompleteCall != null) {
                try {
                    runnableOnCompleteCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39543s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.done = true;
            this.actual.onComplete();
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th2) {
                    FluxPeek.afterCompleteWithFailure(this.parent, th2, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
            if (consumerOnErrorCall != null) {
                Exceptions.throwIfFatal(th);
                try {
                    consumerOnErrorCall.accept(th);
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.actual.currentContext());
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e10) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e10) && e10.getCause() != th)) {
                    throw e10;
                }
            }
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th3) {
                    FluxPeek.afterErrorWithFailure(this.parent, th3, th, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39543s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39543s, dVar)) {
                Consumer<? super qc.d> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(dVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(dVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f39543s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j10);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f39543s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39543s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return false;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39543s);
                    if (thOnNextError == null) {
                        return false;
                    }
                    onError(thOnNextError);
                    return true;
                }
            }
            return this.actual.tryOnNext(t10);
        }
    }

    public static final class PeekFuseableConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        volatile boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f39544s;
        int sourceMode;

        public PeekFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalPeek<T> signalPeek) {
            this.actual = conditionalSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39544s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f39544s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f39544s.clear();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            Context contextCurrentContext = this.actual.currentContext();
            Consumer<? super Context> consumerOnCurrentContextCall = this.parent.onCurrentContextCall();
            if (!contextCurrentContext.isEmpty() && consumerOnCurrentContextCall != null) {
                consumerOnCurrentContextCall.accept(contextCurrentContext);
            }
            return contextCurrentContext;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f39544s.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                this.done = true;
                this.actual.onComplete();
                return;
            }
            Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
            if (runnableOnCompleteCall != null) {
                try {
                    runnableOnCompleteCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39544s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.done = true;
            this.actual.onComplete();
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th2) {
                    FluxPeek.afterCompleteWithFailure(this.parent, th2, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
            if (consumerOnErrorCall != null) {
                Exceptions.throwIfFatal(th);
                try {
                    consumerOnErrorCall.accept(th);
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.actual.currentContext());
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e10) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e10) && e10.getCause() != th)) {
                    throw e10;
                }
            }
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th3) {
                    FluxPeek.afterErrorWithFailure(this.parent, th3, th, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39544s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39544s, dVar)) {
                Consumer<? super qc.d> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(dVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(dVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f39544s = (Fuseable.QueueSubscription) dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            RuntimeException runtimeExceptionPropagate;
            boolean z10 = this.done;
            try {
                T tPoll = this.f39544s.poll();
                Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
                if (tPoll != null && consumerOnNextCall != null) {
                    try {
                        consumerOnNextCall.accept(tPoll);
                    } catch (Throwable th) {
                        Throwable thOnNextError = Operators.onNextError(tPoll, th, this.actual.currentContext(), this.f39544s);
                        if (thOnNextError == null) {
                            return poll();
                        }
                        throw Exceptions.propagate(thOnNextError);
                    }
                }
                if (tPoll == null && (z10 || this.sourceMode == 1)) {
                    Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
                    if (runnableOnCompleteCall != null) {
                        runnableOnCompleteCall.run();
                    }
                    Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
                    if (runnableOnAfterTerminateCall != null) {
                        runnableOnAfterTerminateCall.run();
                    }
                }
                return tPoll;
            } catch (Throwable th2) {
                Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
                if (consumerOnErrorCall != null) {
                    try {
                        consumerOnErrorCall.accept(th2);
                    } finally {
                    }
                }
                Runnable runnableOnAfterTerminateCall2 = this.parent.onAfterTerminateCall();
                if (runnableOnAfterTerminateCall2 != null) {
                    try {
                        runnableOnAfterTerminateCall2.run();
                    } finally {
                    }
                }
                throw Exceptions.propagate(Operators.onOperatorError(this.f39544s, th2, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j10);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f39544s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f39544s.requestFusion(i10);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39544s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f39544s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return false;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39544s);
                    if (thOnNextError == null) {
                        return false;
                    }
                    onError(thOnNextError);
                    return true;
                }
            }
            return this.actual.tryOnNext(t10);
        }
    }

    public static final class PeekFuseableSubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f39545s;
        int sourceMode;

        public PeekFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalPeek<T> signalPeek) {
            this.actual = coreSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39545s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f39545s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f39545s.clear();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            Context contextCurrentContext = this.actual.currentContext();
            Consumer<? super Context> consumerOnCurrentContextCall = this.parent.onCurrentContextCall();
            if (!contextCurrentContext.isEmpty() && consumerOnCurrentContextCall != null) {
                consumerOnCurrentContextCall.accept(contextCurrentContext);
            }
            return contextCurrentContext;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f39545s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                this.done = true;
                this.actual.onComplete();
                return;
            }
            Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
            if (runnableOnCompleteCall != null) {
                try {
                    runnableOnCompleteCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39545s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.done = true;
            this.actual.onComplete();
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th2) {
                    FluxPeek.afterCompleteWithFailure(this.parent, th2, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
            if (consumerOnErrorCall != null) {
                Exceptions.throwIfFatal(th);
                try {
                    consumerOnErrorCall.accept(th);
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.actual.currentContext());
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e10) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e10) && e10.getCause() != th)) {
                    throw e10;
                }
            }
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th3) {
                    FluxPeek.afterErrorWithFailure(this.parent, th3, th, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39545s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39545s, dVar)) {
                Consumer<? super qc.d> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(dVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(dVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f39545s = (Fuseable.QueueSubscription) dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            RuntimeException runtimeExceptionPropagate;
            boolean z10 = this.done;
            try {
                T tPoll = this.f39545s.poll();
                Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
                if (tPoll != null && consumerOnNextCall != null) {
                    try {
                        consumerOnNextCall.accept(tPoll);
                    } catch (Throwable th) {
                        Throwable thOnNextError = Operators.onNextError(tPoll, th, this.actual.currentContext(), this.f39545s);
                        if (thOnNextError == null) {
                            return poll();
                        }
                        throw Exceptions.propagate(thOnNextError);
                    }
                }
                if (tPoll == null && (z10 || this.sourceMode == 1)) {
                    Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
                    if (runnableOnCompleteCall != null) {
                        runnableOnCompleteCall.run();
                    }
                    Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
                    if (runnableOnAfterTerminateCall != null) {
                        runnableOnAfterTerminateCall.run();
                    }
                }
                return tPoll;
            } catch (Throwable th2) {
                Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
                if (consumerOnErrorCall != null) {
                    try {
                        consumerOnErrorCall.accept(th2);
                    } finally {
                    }
                }
                Runnable runnableOnAfterTerminateCall2 = this.parent.onAfterTerminateCall();
                if (runnableOnAfterTerminateCall2 != null) {
                    try {
                        runnableOnAfterTerminateCall2.run();
                    } finally {
                    }
                }
                throw Exceptions.propagate(Operators.onOperatorError(this.f39545s, th2, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j10);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f39545s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f39545s.requestFusion(i10);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39545s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f39545s.size();
        }
    }

    public FluxPeekFuseable(Flux<? extends T> flux, @Nullable Consumer<? super qc.d> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        super(flux);
        this.onSubscribeCall = consumer;
        this.onNextCall = consumer2;
        this.onErrorCall = consumer3;
        this.onCompleteCall = runnable;
        this.onAfterTerminateCall = runnable2;
        this.onRequestCall = longConsumer;
        this.onCancelCall = runnable3;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onAfterTerminateCall() {
        return this.onAfterTerminateCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        return this.onCancelCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        return this.onCompleteCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        return this.onErrorCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super T> onNextCall() {
        return this.onNextCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        return this.onRequestCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qc.d> onSubscribeCall() {
        return this.onSubscribeCall;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new PeekFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this) : new PeekFuseableSubscriber(coreSubscriber, this);
    }
}
