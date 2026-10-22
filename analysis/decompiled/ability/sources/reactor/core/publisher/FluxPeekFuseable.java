package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxPeekFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable, SignalPeek<T> {
    final Runnable onAfterTerminateCall;
    final Runnable onCancelCall;
    final Runnable onCompleteCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super T> onNextCall;
    final LongConsumer onRequestCall;
    final Consumer<? super Z9.e> onSubscribeCall;

    public static final class PeekConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5773s;

        public PeekConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalPeek<T> signalPeek) {
            this.actual = conditionalSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5773s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f5773s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            Context contextCurrentContext = this.actual.currentContext();
            if (!contextCurrentContext.isEmpty() && this.parent.onCurrentContextCall() != null) {
                this.parent.onCurrentContextCall().accept(contextCurrentContext);
            }
            return contextCurrentContext;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
            if (runnableOnCompleteCall != null) {
                try {
                    runnableOnCompleteCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5773s, th, this.actual.currentContext()));
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
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
            } catch (UnsupportedOperationException e) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e) && e.getCause() != th)) {
                    throw e;
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t9);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t9, th, this.actual.currentContext(), this.f5773s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5773s, eVar)) {
                Consumer<? super Z9.e> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(eVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(eVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f5773s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j5);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f5773s.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5773s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return false;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t9);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t9, th, this.actual.currentContext(), this.f5773s);
                    if (thOnNextError == null) {
                        return false;
                    }
                    onError(thOnNextError);
                    return true;
                }
            }
            return this.actual.tryOnNext(t9);
        }
    }

    public static final class PeekFuseableConditionalSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        volatile boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5774s;
        int sourceMode;

        public PeekFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalPeek<T> signalPeek) {
            this.actual = conditionalSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5774s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f5774s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f5774s.clear();
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
            return this.f5774s.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
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
                    onError(Operators.onOperatorError(this.f5774s, th, this.actual.currentContext()));
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
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
            } catch (UnsupportedOperationException e) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e) && e.getCause() != th)) {
                    throw e;
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t9);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t9, th, this.actual.currentContext(), this.f5774s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5774s, eVar)) {
                Consumer<? super Z9.e> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(eVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(eVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f5774s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            RuntimeException runtimeExceptionPropagate;
            boolean z10 = this.done;
            try {
                T tPoll = this.f5774s.poll();
                Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
                if (tPoll != null && consumerOnNextCall != null) {
                    try {
                        consumerOnNextCall.accept(tPoll);
                    } catch (Throwable th) {
                        Throwable thOnNextError = Operators.onNextError(tPoll, th, this.actual.currentContext(), this.f5774s);
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
                throw Exceptions.propagate(Operators.onOperatorError(this.f5774s, th2, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j5);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f5774s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f5774s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5774s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5774s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return false;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t9);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t9, th, this.actual.currentContext(), this.f5774s);
                    if (thOnNextError == null) {
                        return false;
                    }
                    onError(thOnNextError);
                    return true;
                }
            }
            return this.actual.tryOnNext(t9);
        }
    }

    public static final class PeekFuseableSubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5775s;
        int sourceMode;

        public PeekFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalPeek<T> signalPeek) {
            this.actual = coreSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5775s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f5775s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f5775s.clear();
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
            return this.f5775s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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
                    onError(Operators.onOperatorError(this.f5775s, th, this.actual.currentContext()));
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
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
            } catch (UnsupportedOperationException e) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e) && e.getCause() != th)) {
                    throw e;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t9);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t9, th, this.actual.currentContext(), this.f5775s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5775s, eVar)) {
                Consumer<? super Z9.e> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(eVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(eVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f5775s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            RuntimeException runtimeExceptionPropagate;
            boolean z10 = this.done;
            try {
                T tPoll = this.f5775s.poll();
                Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
                if (tPoll != null && consumerOnNextCall != null) {
                    try {
                        consumerOnNextCall.accept(tPoll);
                    } catch (Throwable th) {
                        Throwable thOnNextError = Operators.onNextError(tPoll, th, this.actual.currentContext(), this.f5775s);
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
                throw Exceptions.propagate(Operators.onOperatorError(this.f5775s, th2, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j5);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f5775s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f5775s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5775s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5775s.size();
        }
    }

    public FluxPeekFuseable(Flux<? extends T> flux, @Nullable Consumer<? super Z9.e> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
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
    public Consumer<? super Z9.e> onSubscribeCall() {
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
