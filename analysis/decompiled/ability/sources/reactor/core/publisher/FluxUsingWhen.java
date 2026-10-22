package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxUsingWhen<T, S> extends Flux<T> implements SourceProducer<T> {

    @Nullable
    final Function<? super S, ? extends Z9.c> asyncCancel;
    final Function<? super S, ? extends Z9.c> asyncComplete;
    final BiFunction<? super S, ? super Throwable, ? extends Z9.c> asyncError;
    final Function<? super S, ? extends Z9.c> resourceClosure;
    final Z9.c resourceSupplier;

    public static final class CancelInner implements InnerConsumer<Object> {
        final UsingWhenParent parent;

        public CancelInner(UsingWhenParent usingWhenParent) {
            this.parent = usingWhenParent;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Loggers.getLogger((Class<?>) FluxUsingWhen.class).warn("Async resource cleanup failed after cancel", th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            Objects.requireNonNull(eVar, "Subscription cannot be null");
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent.actual();
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class CommitInner implements InnerConsumer<Object> {
        boolean done;
        final UsingWhenParent parent;

        public CommitInner(UsingWhenParent usingWhenParent) {
            this.parent = usingWhenParent;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            this.parent.deferredComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.done = true;
            this.parent.deferredError(new RuntimeException("Async resource cleanup failed after onComplete", Operators.onOperatorError(th, this.parent.currentContext())));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            Objects.requireNonNull(eVar, "Subscription cannot be null");
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent.actual();
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static class ResourceSubscriber<S, T> extends Operators.DeferredSubscription implements InnerConsumer<S> {
        final CoreSubscriber<? super T> actual;

        @Nullable
        final Function<? super S, ? extends Z9.c> asyncCancel;
        final Function<? super S, ? extends Z9.c> asyncComplete;
        final BiFunction<? super S, ? super Throwable, ? extends Z9.c> asyncError;
        final boolean isMonoSource;
        final Function<? super S, ? extends Z9.c> resourceClosure;
        boolean resourceProvided;
        Z9.e resourceSubscription;

        public ResourceSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super S, ? extends Z9.c> function, Function<? super S, ? extends Z9.c> function2, BiFunction<? super S, ? super Throwable, ? extends Z9.c> biFunction, @Nullable Function<? super S, ? extends Z9.c> function3, boolean z10) {
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

        @Override // reactor.core.publisher.Operators.DeferredSubscription, Z9.e
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.resourceProvided) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.resourceProvided) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(S s5) {
            if (this.resourceProvided) {
                Operators.onNextDropped(s5, this.actual.currentContext());
                return;
            }
            this.resourceProvided = true;
            Operators.toFluxOrMono(FluxUsingWhen.deriveFluxFromResource(s5, this.resourceClosure)).subscribe((Z9.d) FluxUsingWhen.prepareSubscriberForResource(s5, this.actual, this.asyncComplete, this.asyncError, this.asyncCancel, this));
            if (this.isMonoSource) {
                return;
            }
            this.resourceSubscription.cancel();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.resourceSubscription, eVar)) {
                this.resourceSubscription = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
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

    public static final class RollbackInner implements InnerConsumer<Object> {
        boolean done;
        final UsingWhenParent parent;
        final Throwable rollbackCause;

        public RollbackInner(UsingWhenParent usingWhenParent, Throwable th) {
            this.parent = usingWhenParent;
            this.rollbackCause = th;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            this.parent.deferredError(this.rollbackCause);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.done = true;
            this.parent.deferredError(Exceptions.addSuppressed(new RuntimeException("Async resource cleanup failed after onError", th), this.rollbackCause));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(Object obj) {
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            Objects.requireNonNull(eVar, "Subscription cannot be null");
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent.actual();
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.rollbackCause;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class UsingWhenConditionalSubscriber<T, S> extends UsingWhenSubscriber<T, S> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;

        public UsingWhenConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, S s5, Function<? super S, ? extends Z9.c> function, BiFunction<? super S, ? super Throwable, ? extends Z9.c> biFunction, @Nullable Function<? super S, ? extends Z9.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
            super(conditionalSubscriber, s5, function, biFunction, function2, deferredSubscription);
            this.actual = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            return this.actual.tryOnNext(t9);
        }
    }

    public interface UsingWhenParent<T> extends InnerOperator<T, T> {
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        /* synthetic */ void cancel();

        void deferredComplete();

        void deferredError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        /* synthetic */ void request(long j5);
    }

    public static class UsingWhenSubscriber<T, S> implements UsingWhenParent<T> {
        static final AtomicIntegerFieldUpdater<UsingWhenSubscriber> CALLBACK_APPLIED = AtomicIntegerFieldUpdater.newUpdater(UsingWhenSubscriber.class, "callbackApplied");
        final CoreSubscriber<? super T> actual;

        @Nullable
        final Operators.DeferredSubscription arbiter;

        @Nullable
        final Function<? super S, ? extends Z9.c> asyncCancel;
        final Function<? super S, ? extends Z9.c> asyncComplete;
        final BiFunction<? super S, ? super Throwable, ? extends Z9.c> asyncError;
        volatile int callbackApplied;
        Throwable error;
        final S resource;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5819s;

        public UsingWhenSubscriber(CoreSubscriber<? super T> coreSubscriber, S s5, Function<? super S, ? extends Z9.c> function, BiFunction<? super S, ? super Throwable, ? extends Z9.c> biFunction, @Nullable Function<? super S, ? extends Z9.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
            this.actual = coreSubscriber;
            this.resource = s5;
            this.asyncComplete = function;
            this.asyncError = biFunction;
            this.asyncCancel = function2;
            this.arbiter = deferredSubscription;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 3)) {
                this.f5819s.cancel();
                try {
                    Function<? super S, ? extends Z9.c> function = this.asyncCancel;
                    if (function != null) {
                        Flux.from(function.apply(this.resource)).subscribe((CoreSubscriber) new CancelInner(this));
                    } else {
                        Flux.from(this.asyncComplete.apply(this.resource)).subscribe((CoreSubscriber) new CancelInner(this));
                    }
                } catch (Throwable th) {
                    Loggers.getLogger((Class<?>) FluxUsingWhen.class).warn("Error generating async resource cleanup during onCancel", th);
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent
        public void deferredComplete() {
            this.error = Exceptions.TERMINATED;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent
        public void deferredError(Throwable th) {
            this.error = th;
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 1)) {
                try {
                    Z9.c cVarApply = this.asyncComplete.apply(this.resource);
                    Objects.requireNonNull(cVarApply, "The asyncComplete returned a null Publisher");
                    Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) new CommitInner(this));
                } catch (Throwable th) {
                    deferredError(Operators.onOperatorError(th, this.actual.currentContext()));
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 2)) {
                try {
                    Z9.c cVarApply = this.asyncError.apply(this.resource, th);
                    Objects.requireNonNull(cVarApply, "The asyncError returned a null Publisher");
                    Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) new RollbackInner(this, th));
                } catch (Throwable th2) {
                    this.actual.onError(Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th));
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5819s, eVar)) {
                this.f5819s = eVar;
                Operators.DeferredSubscription deferredSubscription = this.arbiter;
                if (deferredSubscription == null) {
                    this.actual.onSubscribe(this);
                } else {
                    deferredSubscription.set(this);
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                this.f5819s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.error != null);
            }
            if (attr != Scannable.Attr.ERROR) {
                if (attr == Scannable.Attr.CANCELLED) {
                    return Boolean.valueOf(this.callbackApplied == 3);
                }
                return attr == Scannable.Attr.PARENT ? this.f5819s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Throwable th = this.error;
            if (th == Exceptions.TERMINATED) {
                return null;
            }
            return th;
        }
    }

    public FluxUsingWhen(Z9.c cVar, Function<? super S, ? extends Z9.c> function, Function<? super S, ? extends Z9.c> function2, BiFunction<? super S, ? super Throwable, ? extends Z9.c> biFunction, @Nullable Function<? super S, ? extends Z9.c> function3) {
        Objects.requireNonNull(cVar, "resourceSupplier");
        this.resourceSupplier = cVar;
        Objects.requireNonNull(function, "resourceClosure");
        this.resourceClosure = function;
        Objects.requireNonNull(function2, "asyncComplete");
        this.asyncComplete = function2;
        Objects.requireNonNull(biFunction, "asyncError");
        this.asyncError = biFunction;
        this.asyncCancel = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <RESOURCE, T> Z9.c deriveFluxFromResource(RESOURCE resource, Function<? super RESOURCE, ? extends Z9.c> function) {
        try {
            Z9.c cVarApply = function.apply(resource);
            Objects.requireNonNull(cVarApply, "The resourceClosure function returned a null value");
            return cVarApply;
        } catch (Throwable th) {
            return Flux.error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <RESOURCE, T> UsingWhenSubscriber<? super T, RESOURCE> prepareSubscriberForResource(RESOURCE resource, CoreSubscriber<? super T> coreSubscriber, Function<? super RESOURCE, ? extends Z9.c> function, BiFunction<? super RESOURCE, ? super Throwable, ? extends Z9.c> biFunction, @Nullable Function<? super RESOURCE, ? extends Z9.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new UsingWhenConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, resource, function, biFunction, function2, deferredSubscription) : new UsingWhenSubscriber<>(coreSubscriber, resource, function, biFunction, function2, deferredSubscription);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CoreSubscriber<? super T> coreSubscriber2;
        Throwable th;
        Z9.c cVar = this.resourceSupplier;
        if (!(cVar instanceof Callable)) {
            Operators.toFluxOrMono(cVar).subscribe((Z9.d) new ResourceSubscriber(coreSubscriber, this.resourceClosure, this.asyncComplete, this.asyncError, this.asyncCancel, this.resourceSupplier instanceof Mono));
            return;
        }
        try {
            Object objCall = ((Callable) cVar).call();
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
            Z9.c cVarDeriveFluxFromResource = deriveFluxFromResource(objCall, this.resourceClosure);
            coreSubscriber2 = coreSubscriber;
            try {
                Operators.toFluxOrMono(cVarDeriveFluxFromResource).subscribe((Z9.d) prepareSubscriberForResource(objCall, coreSubscriber2, this.asyncComplete, this.asyncError, this.asyncCancel, null));
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
