package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class FluxGenerate<T, S> extends Flux<T> implements Fuseable, SourceProducer<T> {
    static final Callable EMPTY_CALLABLE = new Callable() { // from class: reactor.core.publisher.F0
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return FluxGenerate.h0();
        }
    };
    final BiFunction<S, SynchronousSink<T>, S> generator;
    final Consumer<? super S> stateConsumer;
    final Callable<S> stateSupplier;

    public static final class GenerateSubscription<T, S> implements Fuseable.QueueSubscription<T>, InnerProducer<T>, SynchronousSink<T> {
        static final AtomicLongFieldUpdater<GenerateSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(GenerateSubscription.class, "requested");
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        Throwable generatedError;
        T generatedValue;
        final BiFunction<S, SynchronousSink<T>, S> generator;
        boolean hasValue;
        boolean outputFused;
        volatile long requested;
        S state;
        final Consumer<? super S> stateConsumer;
        boolean terminate;

        public GenerateSubscription(CoreSubscriber<? super T> coreSubscriber, S s10, BiFunction<S, SynchronousSink<T>, S> biFunction, Consumer<? super S> consumer) {
            this.actual = coreSubscriber;
            this.state = s10;
            this.generator = biFunction;
            this.stateConsumer = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (REQUESTED.getAndIncrement(this) == 0) {
                cleanup(this.state);
            }
        }

        public void cleanup(S s10) {
            try {
                this.state = null;
                this.stateConsumer.accept(s10);
            } catch (Throwable th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // java.util.Collection
        public void clear() {
            this.generatedError = null;
            this.generatedValue = null;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void complete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            if (this.outputFused) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public ContextView contextView() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.SynchronousSink
        @Deprecated
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void error(Throwable th) {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            if (this.outputFused) {
                this.generatedError = th;
            } else {
                this.actual.onError(th);
            }
        }

        public void fastPath() {
            S sApply = this.state;
            BiFunction<S, SynchronousSink<T>, S> biFunction = this.generator;
            while (!this.cancelled) {
                try {
                    sApply = biFunction.apply(sApply, this);
                    if (this.terminate || this.cancelled) {
                        cleanup(sApply);
                        return;
                    } else {
                        if (!this.hasValue) {
                            cleanup(sApply);
                            this.actual.onError(new IllegalStateException("The generator didn't call any of the SynchronousSink method"));
                            return;
                        }
                        this.hasValue = false;
                    }
                } catch (Throwable th) {
                    cleanup(sApply);
                    this.actual.onError(Operators.onOperatorError(th, this.actual.currentContext()));
                    return;
                }
            }
            cleanup(sApply);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.terminate;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void next(T t10) {
            if (this.terminate) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            if (this.hasValue) {
                error(new IllegalStateException("More than one call to onNext"));
                return;
            }
            if (t10 == null) {
                error(new NullPointerException("The generator produced a null value"));
                return;
            }
            this.hasValue = true;
            if (this.outputFused) {
                this.generatedValue = t10;
            } else {
                this.actual.onNext(t10);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            S s10 = this.state;
            if (this.terminate) {
                cleanup(s10);
                Throwable th = this.generatedError;
                if (th == null) {
                    return null;
                }
                this.generatedError = null;
                throw Exceptions.propagate(th);
            }
            try {
                S sApply = this.generator.apply(s10, this);
                if (this.hasValue) {
                    T t10 = this.generatedValue;
                    this.generatedValue = null;
                    this.hasValue = false;
                    this.state = sApply;
                    return t10;
                }
                cleanup(sApply);
                if (!this.terminate) {
                    throw new IllegalStateException("The generator didn't call any of the SynchronousSink method");
                }
                Throwable th2 = this.generatedError;
                if (th2 == null) {
                    return null;
                }
                this.generatedError = null;
                throw Exceptions.propagate(th2);
            } catch (Throwable th3) {
                cleanup(s10);
                throw th3;
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            if (Operators.validate(j10) && Operators.addCap(REQUESTED, this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j10);
                }
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0 || (i10 & 4) != 0) {
                return 0;
            }
            this.outputFused = true;
            return 1;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.terminate) : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.ERROR ? this.generatedError : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return isEmpty() ? 0 : -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        
            cleanup(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
        
            r8.state = r0;
            r9 = reactor.core.publisher.FluxGenerate.GenerateSubscription.REQUESTED.addAndGet(r8, -r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void slowPath(long r9) {
            /*
                r8 = this;
                S r0 = r8.state
                java.util.function.BiFunction<S, reactor.core.publisher.SynchronousSink<T>, S> r1 = r8.generator
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L49
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L13
                r8.cleanup(r0)
                return
            L13:
                java.lang.Object r0 = r1.apply(r0, r8)     // Catch: java.lang.Throwable -> L3f
                boolean r6 = r8.terminate
                if (r6 != 0) goto L3b
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L20
                goto L3b
            L20:
                boolean r6 = r8.hasValue
                if (r6 != 0) goto L34
                r8.cleanup(r0)
                reactor.core.CoreSubscriber<? super T> r8 = r8.actual
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "The generator didn't call any of the SynchronousSink method"
                r9.<init>(r10)
                r8.onError(r9)
                return
            L34:
                r6 = 1
                long r4 = r4 + r6
                r6 = 0
                r8.hasValue = r6
                goto L7
            L3b:
                r8.cleanup(r0)
                return
            L3f:
                r9 = move-exception
                r8.cleanup(r0)
                reactor.core.CoreSubscriber<? super T> r8 = r8.actual
                r8.onError(r9)
                return
            L49:
                long r9 = r8.requested
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L7
                r8.state = r0
                java.util.concurrent.atomic.AtomicLongFieldUpdater<reactor.core.publisher.FluxGenerate$GenerateSubscription> r9 = reactor.core.publisher.FluxGenerate.GenerateSubscription.REQUESTED
                long r4 = -r4
                long r9 = r9.addAndGet(r8, r4)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxGenerate.GenerateSubscription.slowPath(long):void");
        }
    }

    public FluxGenerate(final Consumer<SynchronousSink<T>> consumer) {
        this(EMPTY_CALLABLE, new BiFunction() { // from class: reactor.core.publisher.H0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FluxGenerate.i0(consumer, obj, (SynchronousSink) obj2);
            }
        });
    }

    public static /* synthetic */ Object h0() {
        return null;
    }

    public static /* synthetic */ Object i0(Consumer consumer, Object obj, SynchronousSink synchronousSink) {
        consumer.accept(synchronousSink);
        return null;
    }

    public static /* synthetic */ void j0(Object obj) {
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            coreSubscriber.onSubscribe(new GenerateSubscription(coreSubscriber, this.stateSupplier.call(), this.generator, this.stateConsumer));
        } catch (Throwable th) {
            Operators.error(coreSubscriber, Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }

    public FluxGenerate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction) {
        this(callable, biFunction, new Consumer() { // from class: reactor.core.publisher.G0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FluxGenerate.j0(obj);
            }
        });
    }

    public FluxGenerate(Callable<S> callable, BiFunction<S, SynchronousSink<T>, S> biFunction, Consumer<? super S> consumer) {
        Objects.requireNonNull(callable, "stateSupplier");
        this.stateSupplier = callable;
        Objects.requireNonNull(biFunction, "generator");
        this.generator = biFunction;
        Objects.requireNonNull(consumer, "stateConsumer");
        this.stateConsumer = consumer;
    }
}
