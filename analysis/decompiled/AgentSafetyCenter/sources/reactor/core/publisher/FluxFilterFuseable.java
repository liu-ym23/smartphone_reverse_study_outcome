package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxFilterFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final Predicate<? super T> predicate;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FilterFuseableConditionalSubscriber<T> implements InnerOperator<T, T>, Fuseable.ConditionalSubscriber<T>, Fuseable.QueueSubscription<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10619s;
        int sourceMode;

        public FilterFuseableConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            this.actual = conditionalSubscriber;
            this.ctx = conditionalSubscriber.currentContext();
            this.predicate = predicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10619s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10619s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10619s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.actual.onNext(t10);
                } else {
                    this.f10619s.request(1L);
                    Operators.onDiscard(t10, this.ctx);
                }
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f10619s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f10619s.request(1L);
                }
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10619s, eVar)) {
                this.f10619s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            return r0;
         */
        @Override // java.util.Queue
        @reactor.util.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T poll() {
            /*
                r7 = this;
                int r0 = r7.sourceMode
                r1 = 2
                if (r0 != r1) goto L3c
                r0 = 0
                r2 = r0
            L8:
                reactor.core.Fuseable$QueueSubscription<T> r4 = r7.f10619s
                java.lang.Object r4 = r4.poll()
                if (r4 == 0) goto L24
                java.util.function.Predicate<? super T> r5 = r7.predicate     // Catch: java.lang.Throwable -> L22
                boolean r5 = r5.test(r4)     // Catch: java.lang.Throwable -> L22
                if (r5 == 0) goto L19
                goto L24
            L19:
                reactor.util.context.Context r5 = r7.ctx     // Catch: java.lang.Throwable -> L22
                reactor.core.publisher.Operators.onDiscard(r4, r5)     // Catch: java.lang.Throwable -> L22
                r4 = 1
                long r2 = r2 + r4
                goto L8
            L22:
                r5 = move-exception
                goto L2c
            L24:
                int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r5 == 0) goto L3b
                r7.request(r2)     // Catch: java.lang.Throwable -> L22
                goto L3b
            L2c:
                reactor.util.context.Context r6 = r7.ctx
                java.lang.RuntimeException r5 = reactor.core.publisher.Operators.onNextPollError(r4, r5, r6)
                reactor.util.context.Context r6 = r7.ctx
                reactor.core.publisher.Operators.onDiscard(r4, r6)
                if (r5 != 0) goto L3a
                goto L8
            L3a:
                throw r5
            L3b:
                return r4
            L3c:
                reactor.core.Fuseable$QueueSubscription<T> r0 = r7.f10619s
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L63
                java.util.function.Predicate<? super T> r1 = r7.predicate     // Catch: java.lang.Throwable -> L53
                boolean r1 = r1.test(r0)     // Catch: java.lang.Throwable -> L53
                if (r1 == 0) goto L4d
                goto L63
            L4d:
                reactor.util.context.Context r1 = r7.ctx     // Catch: java.lang.Throwable -> L53
                reactor.core.publisher.Operators.onDiscard(r0, r1)     // Catch: java.lang.Throwable -> L53
                goto L3c
            L53:
                r1 = move-exception
                reactor.util.context.Context r2 = r7.ctx
                java.lang.RuntimeException r1 = reactor.core.publisher.Operators.onNextPollError(r0, r1, r2)
                reactor.util.context.Context r2 = r7.ctx
                reactor.core.publisher.Operators.onDiscard(r0, r2)
                if (r1 != 0) goto L62
                goto L3c
            L62:
                throw r1
            L63:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxFilterFuseable.FilterFuseableConditionalSubscriber.poll():java.lang.Object");
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10619s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10619s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10619s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10619s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return false;
            }
            try {
                if (this.predicate.test(t10)) {
                    return this.actual.tryOnNext(t10);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f10619s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FilterFuseableSubscriber<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T>, Fuseable.ConditionalSubscriber<T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f10620s;
        int sourceMode;

        public FilterFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, Predicate<? super T> predicate) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.predicate = predicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10620s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f10620s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f10620s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.actual.onNext(t10);
                } else {
                    this.f10620s.request(1L);
                    Operators.onDiscard(t10, this.ctx);
                }
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f10620s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f10620s.request(1L);
                }
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10620s, eVar)) {
                this.f10620s = (Fuseable.QueueSubscription) eVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            return r0;
         */
        @Override // java.util.Queue
        @reactor.util.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T poll() {
            /*
                r7 = this;
                int r0 = r7.sourceMode
                r1 = 2
                if (r0 != r1) goto L3e
                r0 = 0
                r2 = r0
            L8:
                reactor.core.Fuseable$QueueSubscription<T> r4 = r7.f10620s
                java.lang.Object r4 = r4.poll()
                if (r4 == 0) goto L24
                java.util.function.Predicate<? super T> r5 = r7.predicate     // Catch: java.lang.Throwable -> L22
                boolean r5 = r5.test(r4)     // Catch: java.lang.Throwable -> L22
                if (r5 == 0) goto L19
                goto L24
            L19:
                reactor.util.context.Context r5 = r7.ctx     // Catch: java.lang.Throwable -> L22
                reactor.core.publisher.Operators.onDiscard(r4, r5)     // Catch: java.lang.Throwable -> L22
                r4 = 1
                long r2 = r2 + r4
                goto L8
            L22:
                r5 = move-exception
                goto L2c
            L24:
                int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r5 == 0) goto L3d
                r7.request(r2)     // Catch: java.lang.Throwable -> L22
                goto L3d
            L2c:
                reactor.util.context.Context r6 = r7.currentContext()
                java.lang.RuntimeException r5 = reactor.core.publisher.Operators.onNextPollError(r4, r5, r6)
                reactor.util.context.Context r6 = r7.ctx
                reactor.core.publisher.Operators.onDiscard(r4, r6)
                if (r5 != 0) goto L3c
                goto L8
            L3c:
                throw r5
            L3d:
                return r4
            L3e:
                reactor.core.Fuseable$QueueSubscription<T> r0 = r7.f10620s
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L67
                java.util.function.Predicate<? super T> r1 = r7.predicate     // Catch: java.lang.Throwable -> L55
                boolean r1 = r1.test(r0)     // Catch: java.lang.Throwable -> L55
                if (r1 == 0) goto L4f
                goto L67
            L4f:
                reactor.util.context.Context r1 = r7.ctx     // Catch: java.lang.Throwable -> L55
                reactor.core.publisher.Operators.onDiscard(r0, r1)     // Catch: java.lang.Throwable -> L55
                goto L3e
            L55:
                r1 = move-exception
                reactor.util.context.Context r2 = r7.currentContext()
                java.lang.RuntimeException r1 = reactor.core.publisher.Operators.onNextPollError(r0, r1, r2)
                reactor.util.context.Context r2 = r7.ctx
                reactor.core.publisher.Operators.onDiscard(r0, r2)
                if (r1 != 0) goto L66
                goto L3e
            L66:
                throw r1
            L67:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxFilterFuseable.FilterFuseableSubscriber.poll():java.lang.Object");
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10620s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = this.f10620s.requestFusion(i);
            this.sourceMode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10620s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f10620s.size();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return false;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.actual.onNext(t10);
                    return true;
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f10620s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            }
        }
    }

    public FluxFilterFuseable(Flux<? extends T> flux, Predicate<? super T> predicate) {
        super(flux);
        Objects.requireNonNull(predicate, "predicate");
        this.predicate = predicate;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        Predicate<? super T> predicate = this.predicate;
        return z10 ? new FilterFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, predicate) : new FilterFuseableSubscriber(coreSubscriber, predicate);
    }
}
