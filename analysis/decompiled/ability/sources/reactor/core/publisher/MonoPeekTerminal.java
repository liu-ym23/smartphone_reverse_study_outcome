package reactor.core.publisher;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoPeekTerminal<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final BiConsumer<? super T, Throwable> onAfterTerminateCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super T> onSuccessCall;

    public MonoPeekTerminal(Mono<? extends T> mono, @Nullable Consumer<? super T> consumer, @Nullable Consumer<? super Throwable> consumer2, @Nullable BiConsumer<? super T, Throwable> biConsumer) {
        super(mono);
        this.onAfterTerminateCall = biConsumer;
        this.onSuccessCall = consumer;
        this.onErrorCall = consumer2;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new MonoTerminalPeekSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, (MonoPeekTerminal) this) : new MonoTerminalPeekSubscriber(coreSubscriber, this);
    }

    public static final class MonoTerminalPeekSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final CoreSubscriber<? super T> actual;
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;
        volatile boolean done;
        final MonoPeekTerminal<T> parent;

        @Nullable
        Fuseable.QueueSubscription<T> queueSubscription;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5856s;
        int sourceMode;
        boolean valued;

        public MonoTerminalPeekSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, MonoPeekTerminal<T> monoPeekTerminal) {
            this.actualConditional = conditionalSubscriber;
            this.actual = conditionalSubscriber;
            this.parent = monoPeekTerminal;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5856s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.queueSubscription.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.queueSubscription;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            BiConsumer<? super T, Throwable> biConsumer;
            Consumer<? super T> consumer;
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0 && !this.valued && (consumer = this.parent.onSuccessCall) != null) {
                try {
                    consumer.accept(null);
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5856s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.done = true;
            this.actual.onComplete();
            if (this.sourceMode != 0 || this.valued || (biConsumer = this.parent.onAfterTerminateCall) == null) {
                return;
            }
            try {
                biConsumer.accept(null, null);
            } catch (Throwable th2) {
                Operators.onErrorDropped(Operators.onOperatorError(th2, this.actual.currentContext()), this.actual.currentContext());
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            BiConsumer<? super T, Throwable> biConsumer;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Consumer<? super Throwable> consumer = this.parent.onErrorCall;
            if (!this.valued && consumer != null) {
                try {
                    consumer.accept(th);
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.actual.currentContext());
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e) {
                if (consumer == null || (!Exceptions.isErrorCallbackNotImplemented(e) && e.getCause() != th)) {
                    throw e;
                }
            }
            if (this.valued || (biConsumer = this.parent.onAfterTerminateCall) == null) {
                return;
            }
            try {
                biConsumer.accept(null, th);
            } catch (Throwable th3) {
                Operators.onErrorDropped(Operators.onOperatorError(th3, this.actual.currentContext()), this.actual.currentContext());
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
            this.valued = true;
            Consumer<? super T> consumer = this.parent.onSuccessCall;
            if (consumer != null) {
                try {
                    consumer.accept(t9);
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5856s, th, t9, this.actual.currentContext()));
                    return;
                }
            }
            this.actual.onNext(t9);
            BiConsumer<? super T, Throwable> biConsumer = this.parent.onAfterTerminateCall;
            if (biConsumer != null) {
                try {
                    biConsumer.accept(t9, null);
                } catch (Throwable th2) {
                    Operators.onErrorDropped(Operators.onOperatorError(this.f5856s, th2, t9, this.actual.currentContext()), this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            this.f5856s = eVar;
            this.queueSubscription = Operators.as(eVar);
            this.actual.onSubscribe(this);
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            boolean z10 = this.done;
            try {
                T tPoll = this.queueSubscription.poll();
                if (!this.valued && (tPoll != null || z10 || this.sourceMode == 1)) {
                    this.valued = true;
                    Consumer<? super T> consumer = this.parent.onSuccessCall;
                    if (consumer != null) {
                        try {
                            consumer.accept(tPoll);
                            return tPoll;
                        } catch (Throwable th) {
                            throw Exceptions.propagate(Operators.onOperatorError(this.f5856s, th, tPoll, this.actual.currentContext()));
                        }
                    }
                }
                return tPoll;
            } catch (Throwable th2) {
                Consumer<? super Throwable> consumer2 = this.parent.onErrorCall;
                if (consumer2 != null) {
                    try {
                        consumer2.accept(th2);
                    } catch (Throwable th3) {
                        throw Exceptions.propagate(Operators.onOperatorError(null, th2, th3, this.actual.currentContext()));
                    }
                }
                throw th2;
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5856s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.queueSubscription;
            int iRequestFusion = 0;
            if (queueSubscription != null && this.parent.onAfterTerminateCall == null && (i & 4) == 0) {
                iRequestFusion = queueSubscription.requestFusion(i);
            }
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.PARENT ? this.f5856s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            Fuseable.QueueSubscription<T> queueSubscription = this.queueSubscription;
            if (queueSubscription == null) {
                return 0;
            }
            return queueSubscription.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return false;
            }
            if (this.actualConditional == null) {
                onNext(t9);
                return false;
            }
            this.valued = true;
            Consumer<? super T> consumer = this.parent.onSuccessCall;
            if (consumer != null) {
                try {
                    consumer.accept(t9);
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f5856s, th, t9, this.actual.currentContext()));
                    return false;
                }
            }
            boolean zTryOnNext = this.actualConditional.tryOnNext(t9);
            BiConsumer<? super T, Throwable> biConsumer = this.parent.onAfterTerminateCall;
            if (biConsumer != null) {
                try {
                    biConsumer.accept(t9, null);
                    return zTryOnNext;
                } catch (Throwable th2) {
                    Operators.onErrorDropped(Operators.onOperatorError(this.f5856s, th2, t9, this.actual.currentContext()), this.actual.currentContext());
                }
            }
            return zTryOnNext;
        }

        public MonoTerminalPeekSubscriber(CoreSubscriber<? super T> coreSubscriber, MonoPeekTerminal<T> monoPeekTerminal) {
            this.actual = coreSubscriber;
            this.actualConditional = null;
            this.parent = monoPeekTerminal;
        }
    }
}
