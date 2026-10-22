package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class MonoFilterWhen<T> extends InternalMonoOperator<T, T> {
    final Function<? super T, ? extends qd.c> asyncPredicate;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FilterWhenInner<T> implements InnerConsumer<Boolean> {
        final boolean cancelOnNext;
        boolean done;
        final MonoFilterWhenMain<T> parent;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10723s;
        final T value;

        public FilterWhenInner(MonoFilterWhenMain<T> monoFilterWhenMain, boolean z10, T t10) {
            this.parent = monoFilterWhenMain;
            this.cancelOnNext = z10;
            this.value = t10;
        }

        public void cancel() {
            this.f10723s.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerResult(false, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.innerError(th, this);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Boolean bool) {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.cancelOnNext) {
                this.f10723s.cancel();
            }
            this.parent.innerResult(bool.booleanValue(), this);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10723s, eVar)) {
                this.f10723s = eVar;
                if (this.parent.trySetInner(this)) {
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
                return this.f10723s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.done ? 0L : 1L);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public MonoFilterWhen(Mono<T> mono, Function<? super T, ? extends qd.c> function) {
        super(mono);
        this.asyncPredicate = function;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new MonoFilterWhenMain(coreSubscriber, this.asyncPredicate);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MonoFilterWhenMain<T> implements InnerOperator<T, T>, Fuseable, Fuseable.QueueSubscription<T> {
        static final AtomicReferenceFieldUpdater<MonoFilterWhenMain, FilterWhenInner> ASYNC_FILTER = AtomicReferenceFieldUpdater.newUpdater(MonoFilterWhenMain.class, FilterWhenInner.class, "asyncFilter");
        static final FilterWhenInner INNER_CANCELLED = new FilterWhenInner(null, false, null);
        static final FilterWhenInner INNER_TERMINATED = new FilterWhenInner(null, false, null);
        final CoreSubscriber<? super T> actual;
        volatile FilterWhenInner<T> asyncFilter;
        final Function<? super T, ? extends qd.c> asyncPredicate;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10724s;

        public MonoFilterWhenMain(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qd.c> function) {
            this.actual = coreSubscriber;
            this.asyncPredicate = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10724s.cancel();
            FilterWhenInner<T> filterWhenInner = this.asyncFilter;
            FilterWhenInner<T> filterWhenInner2 = INNER_CANCELLED;
            if (filterWhenInner == filterWhenInner2 || filterWhenInner == INNER_TERMINATED || !ASYNC_FILTER.compareAndSet(this, filterWhenInner, filterWhenInner2) || filterWhenInner == null) {
                return;
            }
            filterWhenInner.cancel();
        }

        public void innerError(Throwable th, FilterWhenInner<T> filterWhenInner) {
            if (this.asyncFilter == filterWhenInner && ASYNC_FILTER.compareAndSet(this, filterWhenInner, INNER_TERMINATED)) {
                Operators.onDiscard(filterWhenInner.value, currentContext());
                this.actual.onError(th);
            }
            Operators.onErrorDropped(th, currentContext());
        }

        public void innerResult(boolean z10, FilterWhenInner<T> filterWhenInner) {
            if (this.asyncFilter == filterWhenInner && ASYNC_FILTER.compareAndSet(this, filterWhenInner, INNER_TERMINATED)) {
                if (z10) {
                    this.actual.onNext(filterWhenInner.value);
                    this.actual.onComplete();
                } else {
                    Operators.onDiscard(filterWhenInner.value, currentContext());
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            FilterWhenInner<T> filterWhenInner = this.asyncFilter;
            return (filterWhenInner == null || filterWhenInner == INNER_CANCELLED || filterWhenInner == INNER_TERMINATED) ? Stream.empty() : Stream.of(filterWhenInner);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
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
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.done = true;
            try {
                qd.c cVarApply = this.asyncPredicate.apply(t10);
                Objects.requireNonNull(cVarApply, "The asyncPredicate returned a null value");
                qd.c cVar = cVarApply;
                if (!(cVar instanceof Callable)) {
                    Operators.toFluxOrMono(cVar).subscribe((qd.d) new FilterWhenInner(this, true ^ (cVar instanceof Mono), t10));
                    return;
                }
                try {
                    Boolean bool = (Boolean) ((Callable) cVar).call();
                    if (bool == null || !bool.booleanValue()) {
                        Operators.onDiscard(t10, this.actual.currentContext());
                        this.actual.onComplete();
                    } else {
                        this.actual.onNext(t10);
                        this.actual.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    Operators.onDiscard(t10, this.actual.currentContext());
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                Operators.onDiscard(t10, this.actual.currentContext());
                this.actual.onError(th2);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10724s, eVar)) {
                this.f10724s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10724s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10724s;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 0;
            }
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.CANCELLED) {
                    return Boolean.valueOf(this.asyncFilter == INNER_CANCELLED);
                }
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            FilterWhenInner<T> filterWhenInner = this.asyncFilter;
            if (this.done && (filterWhenInner == null || filterWhenInner == INNER_TERMINATED)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        public boolean trySetInner(FilterWhenInner<T> filterWhenInner) {
            if (this.asyncFilter == null && ASYNC_FILTER.compareAndSet(this, null, filterWhenInner)) {
                return true;
            }
            Operators.onDiscard(filterWhenInner.value, currentContext());
            return false;
        }

        @Override // java.util.Collection
        public void clear() {
        }
    }
}
