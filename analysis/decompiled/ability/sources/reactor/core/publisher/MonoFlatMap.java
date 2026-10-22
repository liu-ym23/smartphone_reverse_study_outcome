package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoFlatMap<T, R> extends InternalMonoOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends Mono<? extends R>> mapper;

    public static final class FlatMapInner<R> implements InnerConsumer<R> {
        static final FlatMapInner<?> CANCELLED = new FlatMapInner<>(null);
        boolean done;
        final FlatMapMain<?, R> parent;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5850s;

        public FlatMapInner(FlatMapMain<?, R> flatMapMain) {
            this.parent = flatMapMain;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.secondComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.secondError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            if (this.done) {
                Operators.onNextDropped(r5, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.secondComplete(r5);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5850s, eVar)) {
                this.f5850s = eVar;
                if (this.parent.setSecond(this)) {
                    eVar.request(Long.MAX_VALUE);
                } else {
                    eVar.cancel();
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5850s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5850s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public MonoFlatMap(Mono<? extends T> mono, Function<? super T, ? extends Mono<? extends R>> function) {
        super(mono);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, true, false)) {
            return null;
        }
        return new FlatMapMain(coreSubscriber, this.mapper);
    }

    public static final class FlatMapMain<T, R> implements InnerOperator<T, R>, Fuseable, Fuseable.QueueSubscription<R> {
        static final AtomicReferenceFieldUpdater<FlatMapMain, FlatMapInner> SECOND = AtomicReferenceFieldUpdater.newUpdater(FlatMapMain.class, FlatMapInner.class, "second");
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends Mono<? extends R>> mapper;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5851s;
        volatile FlatMapInner<R> second;

        public FlatMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Mono<? extends R>> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5851s.cancel();
            FlatMapInner<R> flatMapInner = this.second;
            FlatMapInner<?> flatMapInner2 = FlatMapInner.CANCELLED;
            if (flatMapInner == flatMapInner2 || !SECOND.compareAndSet(this, flatMapInner, flatMapInner2) || flatMapInner == null) {
                return;
            }
            flatMapInner.f5850s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(this.second);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            this.done = true;
            try {
                CorePublisher corePublisher = (Mono<? extends R>) this.mapper.apply(t9);
                Objects.requireNonNull(corePublisher, "The mapper returned a null Mono");
                CorePublisher corePublisher2 = (Mono) corePublisher;
                if (!(corePublisher2 instanceof Callable)) {
                    try {
                        Mono.fromDirect(corePublisher2).subscribe((CoreSubscriber) new FlatMapInner(this));
                        return;
                    } catch (Throwable th) {
                        CoreSubscriber<? super R> coreSubscriber = this.actual;
                        coreSubscriber.onError(Operators.onOperatorError(this, th, t9, coreSubscriber.currentContext()));
                        return;
                    }
                }
                try {
                    Object objCall = ((Callable) corePublisher2).call();
                    if (objCall == null) {
                        this.actual.onComplete();
                    } else {
                        this.actual.onNext(objCall);
                        this.actual.onComplete();
                    }
                } catch (Throwable th2) {
                    this.actual.onError(Operators.onOperatorError(this.f5851s, th2, t9, this.actual.currentContext()));
                }
            } catch (Throwable th3) {
                CoreSubscriber<? super R> coreSubscriber2 = this.actual;
                coreSubscriber2.onError(Operators.onOperatorError(this.f5851s, th3, t9, coreSubscriber2.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5851s, eVar)) {
                this.f5851s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public R poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5851s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5851s;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.second == FlatMapInner.CANCELLED);
            }
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void secondComplete(R r5) {
            this.actual.onNext(r5);
            this.actual.onComplete();
        }

        public void secondError(Throwable th) {
            this.actual.onError(th);
        }

        public boolean setSecond(FlatMapInner<R> flatMapInner) {
            return this.second == null && SECOND.compareAndSet(this, null, flatMapInner);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        public void secondComplete() {
            this.actual.onComplete();
        }
    }
}
