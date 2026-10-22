package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxDistinct<T, K, C> extends InternalFluxOperator<T, T> {
    final Consumer<C> cleanupCallback;
    final Supplier<C> collectionSupplier;
    final BiPredicate<C, K> distinctPredicate;
    final Function<? super T, ? extends K> keyExtractor;

    public static final class DistinctConditionalSubscriber<T, K, C> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final Consumer<C> cleanupCallback;
        final C collection;
        final Context ctx;
        final BiPredicate<C, K> distinctPredicate;
        boolean done;
        final Function<? super T, ? extends K> keyExtractor;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39496s;

        public DistinctConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, C c10, Function<? super T, ? extends K> function, BiPredicate<C, K> biPredicate, Consumer<C> consumer) {
            this.actual = conditionalSubscriber;
            this.ctx = conditionalSubscriber.currentContext();
            this.collection = c10;
            this.keyExtractor = function;
            this.distinctPredicate = biPredicate;
            this.cleanupCallback = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39496s.cancel();
            C c10 = this.collection;
            if (c10 != null) {
                this.cleanupCallback.accept(c10);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            try {
                K kApply = this.keyExtractor.apply(t10);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                try {
                    if (this.distinctPredicate.test(this.collection, kApply)) {
                        this.actual.onNext(t10);
                    } else {
                        Operators.onDiscard(t10, this.ctx);
                        this.f39496s.request(1L);
                    }
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39496s, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f39496s, th2, t10, this.ctx));
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39496s, dVar)) {
                this.f39496s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39496s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39496s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return true;
            }
            try {
                K kApply = this.keyExtractor.apply(t10);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                try {
                    if (this.distinctPredicate.test(this.collection, kApply)) {
                        return this.actual.tryOnNext(t10);
                    }
                    Operators.onDiscard(t10, this.ctx);
                    return false;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39496s, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                    return true;
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f39496s, th2, t10, this.ctx));
                Operators.onDiscard(t10, this.ctx);
                return true;
            }
        }
    }

    public static final class DistinctFuseableSubscriber<T, K, C> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final Consumer<C> cleanupCallback;
        final C collection;
        final Context ctx;
        final BiPredicate<C, K> distinctPredicate;
        boolean done;
        final Function<? super T, ? extends K> keyExtractor;
        Fuseable.QueueSubscription<T> qs;
        int sourceMode;

        public DistinctFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, C c10, Function<? super T, ? extends K> function, BiPredicate<C, K> biPredicate, Consumer<C> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.collection = c10;
            this.keyExtractor = function;
            this.distinctPredicate = biPredicate;
            this.cleanupCallback = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.qs.cancel();
            C c10 = this.collection;
            if (c10 != null) {
                this.cleanupCallback.accept(c10);
            }
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
            this.cleanupCallback.accept(this.collection);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (tryOnNext(t10)) {
                return;
            }
            this.qs.request(1L);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.qs, dVar)) {
                this.qs = (Fuseable.QueueSubscription) dVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        
            if (r4 == 0) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        
            request(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        
            return r6;
         */
        @Override // java.util.Queue
        @reactor.util.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T poll() {
            /*
                r10 = this;
                int r0 = r10.sourceMode
                r1 = 2
                java.lang.String r2 = "The keyExtractor returned a null collection"
                r3 = 0
                if (r0 != r1) goto L41
                r0 = 0
                r4 = r0
            Lb:
                reactor.core.Fuseable$QueueSubscription<T> r6 = r10.qs
                java.lang.Object r6 = r6.poll()
                if (r6 != 0) goto L14
                return r3
            L14:
                java.util.function.Function<? super T, ? extends K> r7 = r10.keyExtractor     // Catch: java.lang.Throwable -> L2f
                java.lang.Object r7 = r7.apply(r6)     // Catch: java.lang.Throwable -> L2f
                java.util.Objects.requireNonNull(r7, r2)     // Catch: java.lang.Throwable -> L2f
                java.util.function.BiPredicate<C, K> r8 = r10.distinctPredicate     // Catch: java.lang.Throwable -> L2f
                C r9 = r10.collection     // Catch: java.lang.Throwable -> L2f
                boolean r7 = r8.test(r9, r7)     // Catch: java.lang.Throwable -> L2f
                if (r7 == 0) goto L32
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 == 0) goto L31
                r10.request(r4)     // Catch: java.lang.Throwable -> L2f
                return r6
            L2f:
                r0 = move-exception
                goto L3b
            L31:
                return r6
            L32:
                reactor.util.context.Context r7 = r10.ctx     // Catch: java.lang.Throwable -> L2f
                reactor.core.publisher.Operators.onDiscard(r6, r7)     // Catch: java.lang.Throwable -> L2f
                r6 = 1
                long r4 = r4 + r6
                goto Lb
            L3b:
                reactor.util.context.Context r10 = r10.ctx
                reactor.core.publisher.Operators.onDiscard(r6, r10)
                throw r0
            L41:
                reactor.core.Fuseable$QueueSubscription<T> r0 = r10.qs
                java.lang.Object r0 = r0.poll()
                if (r0 != 0) goto L4a
                return r3
            L4a:
                java.util.function.Function<? super T, ? extends K> r1 = r10.keyExtractor     // Catch: java.lang.Throwable -> L64
                java.lang.Object r1 = r1.apply(r0)     // Catch: java.lang.Throwable -> L64
                java.util.Objects.requireNonNull(r1, r2)     // Catch: java.lang.Throwable -> L64
                java.util.function.BiPredicate<C, K> r4 = r10.distinctPredicate     // Catch: java.lang.Throwable -> L64
                C r5 = r10.collection     // Catch: java.lang.Throwable -> L64
                boolean r1 = r4.test(r5, r1)     // Catch: java.lang.Throwable -> L64
                if (r1 == 0) goto L5e
                return r0
            L5e:
                reactor.util.context.Context r1 = r10.ctx     // Catch: java.lang.Throwable -> L64
                reactor.core.publisher.Operators.onDiscard(r0, r1)     // Catch: java.lang.Throwable -> L64
                goto L41
            L64:
                r1 = move-exception
                reactor.util.context.Context r10 = r10.ctx
                reactor.core.publisher.Operators.onDiscard(r0, r10)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxDistinct.DistinctFuseableSubscriber.poll():java.lang.Object");
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.qs.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            int iRequestFusion = this.qs.requestFusion(i10);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.qs : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return true;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return true;
            }
            try {
                K kApply = this.keyExtractor.apply(t10);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                try {
                    if (this.distinctPredicate.test(this.collection, kApply)) {
                        this.actual.onNext(t10);
                        return true;
                    }
                    Operators.onDiscard(t10, this.ctx);
                    return false;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.qs, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                    return true;
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.qs, th2, t10, this.ctx));
                Operators.onDiscard(t10, this.ctx);
                return true;
            }
        }
    }

    public static final class DistinctSubscriber<T, K, C> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Consumer<C> cleanupCallback;
        final C collection;
        final Context ctx;
        final BiPredicate<C, K> distinctPredicate;
        boolean done;
        final Function<? super T, ? extends K> keyExtractor;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39497s;

        public DistinctSubscriber(CoreSubscriber<? super T> coreSubscriber, C c10, Function<? super T, ? extends K> function, BiPredicate<C, K> biPredicate, Consumer<C> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.collection = c10;
            this.keyExtractor = function;
            this.distinctPredicate = biPredicate;
            this.cleanupCallback = consumer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39497s.cancel();
            C c10 = this.collection;
            if (c10 != null) {
                this.cleanupCallback.accept(c10);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.done = true;
            this.cleanupCallback.accept(this.collection);
            this.actual.onError(th);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (tryOnNext(t10)) {
                return;
            }
            this.f39497s.request(1L);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39497s, dVar)) {
                this.f39497s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39497s.request(j10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39497s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return true;
            }
            try {
                K kApply = this.keyExtractor.apply(t10);
                Objects.requireNonNull(kApply, "The distinct extractor returned a null value.");
                try {
                    if (this.distinctPredicate.test(this.collection, kApply)) {
                        this.actual.onNext(t10);
                        return true;
                    }
                    Operators.onDiscard(t10, this.ctx);
                    return false;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39497s, th, t10, this.ctx));
                    Operators.onDiscard(t10, this.ctx);
                    return true;
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f39497s, th2, t10, this.ctx));
                Operators.onDiscard(t10, this.ctx);
                return true;
            }
        }
    }

    public FluxDistinct(Flux<? extends T> flux, Function<? super T, ? extends K> function, Supplier<C> supplier, BiPredicate<C, K> biPredicate, Consumer<C> consumer) {
        super(flux);
        Objects.requireNonNull(function, "keyExtractor");
        this.keyExtractor = function;
        Objects.requireNonNull(supplier, "collectionSupplier");
        this.collectionSupplier = supplier;
        Objects.requireNonNull(biPredicate, "distinctPredicate");
        this.distinctPredicate = biPredicate;
        Objects.requireNonNull(consumer, "cleanupCallback");
        this.cleanupCallback = consumer;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        C c10 = this.collectionSupplier.get();
        Objects.requireNonNull(c10, "The collectionSupplier returned a null collection");
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new DistinctConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, c10, this.keyExtractor, this.distinctPredicate, this.cleanupCallback) : new DistinctSubscriber(coreSubscriber, c10, this.keyExtractor, this.distinctPredicate, this.cleanupCallback);
    }
}
