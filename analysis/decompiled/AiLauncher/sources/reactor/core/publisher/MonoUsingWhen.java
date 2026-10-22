package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.FluxUsingWhen;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class MonoUsingWhen<T, S> extends Mono<T> implements SourceProducer<T> {

    @Nullable
    final Function<? super S, ? extends qc.b<?>> asyncCancel;
    final Function<? super S, ? extends qc.b<?>> asyncComplete;
    final BiFunction<? super S, ? super Throwable, ? extends qc.b<?>> asyncError;
    final Function<? super S, ? extends Mono<? extends T>> resourceClosure;
    final qc.b<S> resourceSupplier;

    public static class MonoUsingWhenSubscriber<T, S> extends FluxUsingWhen.UsingWhenSubscriber<T, S> {
        T value;

        public MonoUsingWhenSubscriber(CoreSubscriber<? super T> coreSubscriber, S s10, Function<? super S, ? extends qc.b<?>> function, BiFunction<? super S, ? super Throwable, ? extends qc.b<?>> biFunction, @Nullable Function<? super S, ? extends qc.b<?>> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
            super(coreSubscriber, s10, function, biFunction, function2, deferredSubscription);
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenSubscriber, reactor.core.publisher.FluxUsingWhen.UsingWhenParent
        public void deferredComplete() {
            this.error = Exceptions.TERMINATED;
            T t10 = this.value;
            if (t10 != null) {
                this.actual.onNext(t10);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenSubscriber, reactor.core.publisher.FluxUsingWhen.UsingWhenParent
        public void deferredError(Throwable th) {
            Operators.onDiscard(this.value, this.actual.currentContext());
            this.error = th;
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenSubscriber, reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.value = t10;
        }
    }

    public static class ResourceSubscriber<S, T> extends Operators.DeferredSubscription implements InnerConsumer<S> {
        final CoreSubscriber<? super T> actual;

        @Nullable
        final Function<? super S, ? extends qc.b<?>> asyncCancel;
        final Function<? super S, ? extends qc.b<?>> asyncComplete;
        final BiFunction<? super S, ? super Throwable, ? extends qc.b<?>> asyncError;
        final boolean isMonoSource;
        final Function<? super S, ? extends Mono<? extends T>> resourceClosure;
        boolean resourceProvided;
        qc.d resourceSubscription;

        public ResourceSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super S, ? extends Mono<? extends T>> function, Function<? super S, ? extends qc.b<?>> function2, BiFunction<? super S, ? super Throwable, ? extends qc.b<?>> biFunction, @Nullable Function<? super S, ? extends qc.b<?>> function3, boolean z10) {
            Objects.requireNonNull(coreSubscriber, "actual");
            this.actual = coreSubscriber;
            Objects.requireNonNull(function, "resourceClosure");
            this.resourceClosure = function;
            Objects.requireNonNull(function2, "asyncComplete");
            this.asyncComplete = function2;
            Objects.requireNonNull(biFunction, "asyncError");
            this.asyncError = biFunction;
            this.asyncCancel = function3;
            this.isMonoSource = z10;
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, qc.d
        public void cancel() {
            if (!this.resourceProvided) {
                this.resourceSubscription.cancel();
            }
            super.cancel();
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.resourceProvided) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.resourceProvided) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(S s10) {
            if (this.resourceProvided) {
                Operators.onNextDropped(s10, this.actual.currentContext());
                return;
            }
            this.resourceProvided = true;
            Mono.fromDirect(MonoUsingWhen.deriveMonoFromResource(s10, this.resourceClosure)).subscribe((CoreSubscriber) MonoUsingWhen.prepareSubscriberForResource(s10, this.actual, this.asyncComplete, this.asyncError, this.asyncCancel, this));
            if (this.isMonoSource) {
                return;
            }
            this.resourceSubscription.cancel();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.resourceSubscription, dVar)) {
                this.resourceSubscription = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.resourceSubscription;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.actual;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.resourceProvided);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public MonoUsingWhen(qc.b<S> bVar, Function<? super S, ? extends Mono<? extends T>> function, Function<? super S, ? extends qc.b<?>> function2, BiFunction<? super S, ? super Throwable, ? extends qc.b<?>> biFunction, @Nullable Function<? super S, ? extends qc.b<?>> function3) {
        Objects.requireNonNull(bVar, "resourceSupplier");
        this.resourceSupplier = bVar;
        Objects.requireNonNull(function, "resourceClosure");
        this.resourceClosure = function;
        Objects.requireNonNull(function2, "asyncComplete");
        this.asyncComplete = function2;
        Objects.requireNonNull(biFunction, "asyncError");
        this.asyncError = biFunction;
        this.asyncCancel = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <RESOURCE, T> Mono<? extends T> deriveMonoFromResource(RESOURCE resource, Function<? super RESOURCE, ? extends Mono<? extends T>> function) {
        try {
            Mono<? extends T> monoApply = function.apply(resource);
            Objects.requireNonNull(monoApply, "The resourceClosure function returned a null value");
            return monoApply;
        } catch (Throwable th) {
            return Mono.error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <RESOURCE, T> MonoUsingWhenSubscriber<? super T, RESOURCE> prepareSubscriberForResource(RESOURCE resource, CoreSubscriber<? super T> coreSubscriber, Function<? super RESOURCE, ? extends qc.b<?>> function, BiFunction<? super RESOURCE, ? super Throwable, ? extends qc.b<?>> biFunction, @Nullable Function<? super RESOURCE, ? extends qc.b<?>> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
        return new MonoUsingWhenSubscriber<>(coreSubscriber, resource, function, biFunction, function2, deferredSubscription);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CoreSubscriber<? super T> coreSubscriber2;
        Throwable th;
        qc.b<S> bVar = this.resourceSupplier;
        if (!(bVar instanceof Callable)) {
            Operators.toFluxOrMono(bVar).subscribe((qc.c) new ResourceSubscriber(coreSubscriber, this.resourceClosure, this.asyncComplete, this.asyncError, this.asyncCancel, this.resourceSupplier instanceof Mono));
            return;
        }
        try {
            Object objCall = ((Callable) bVar).call();
            if (objCall == null) {
                try {
                    Operators.complete(coreSubscriber);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    coreSubscriber2 = coreSubscriber;
                    Operators.error(coreSubscriber2, th);
                }
            }
            Mono monoDeriveMonoFromResource = deriveMonoFromResource(objCall, this.resourceClosure);
            coreSubscriber2 = coreSubscriber;
            try {
                Mono.fromDirect(monoDeriveMonoFromResource).subscribe((CoreSubscriber) prepareSubscriberForResource(objCall, coreSubscriber2, this.asyncComplete, this.asyncError, this.asyncCancel, null));
            } catch (Throwable th3) {
                th = th3;
                th = th;
                Operators.error(coreSubscriber2, th);
            }
        } catch (Throwable th4) {
            th = th4;
            coreSubscriber2 = coreSubscriber;
        }
    }
}
