package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxUsingWhen<T, S> extends Flux<T> implements SourceProducer<T> {

    @Nullable
    final Function<? super S, ? extends qd.c> asyncCancel;
    final Function<? super S, ? extends qd.c> asyncComplete;
    final BiFunction<? super S, ? super Throwable, ? extends qd.c> asyncError;
    final Function<? super S, ? extends qd.c> resourceClosure;
    final qd.c resourceSupplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ResourceSubscriber<S, T> extends Operators.DeferredSubscription implements InnerConsumer<S> {
        final CoreSubscriber<? super T> actual;

        @Nullable
        final Function<? super S, ? extends qd.c> asyncCancel;
        final Function<? super S, ? extends qd.c> asyncComplete;
        final BiFunction<? super S, ? super Throwable, ? extends qd.c> asyncError;
        final boolean isMonoSource;
        final Function<? super S, ? extends qd.c> resourceClosure;
        boolean resourceProvided;
        qd.e resourceSubscription;

        public ResourceSubscriber(CoreSubscriber<? super T> coreSubscriber, Function<? super S, ? extends qd.c> function, Function<? super S, ? extends qd.c> function2, BiFunction<? super S, ? super Throwable, ? extends qd.c> biFunction, @Nullable Function<? super S, ? extends qd.c> function3, boolean z10) {
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

        @Override // reactor.core.publisher.Operators.DeferredSubscription, qd.e
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.resourceProvided) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            boolean z10 = this.resourceProvided;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (z10) {
                Operators.onErrorDropped(th, coreSubscriber.currentContext());
            } else {
                coreSubscriber.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(S s6) {
            if (this.resourceProvided) {
                Operators.onNextDropped(s6, this.actual.currentContext());
                return;
            }
            this.resourceProvided = true;
            Operators.toFluxOrMono(FluxUsingWhen.deriveFluxFromResource(s6, this.resourceClosure)).subscribe((qd.d) FluxUsingWhen.prepareSubscriberForResource(s6, this.actual, this.asyncComplete, this.asyncError, this.asyncCancel, this));
            if (this.isMonoSource) {
                return;
            }
            this.resourceSubscription.cancel();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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
                return Integer.valueOf(Reader.READ_DONE);
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class UsingWhenConditionalSubscriber<T, S> extends UsingWhenSubscriber<T, S> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;

        public UsingWhenConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, S s6, Function<? super S, ? extends qd.c> function, BiFunction<? super S, ? super Throwable, ? extends qd.c> biFunction, @Nullable Function<? super S, ? extends qd.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
            super(conditionalSubscriber, s6, function, biFunction, function2, deferredSubscription);
            this.actual = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            return this.actual.tryOnNext(t10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface UsingWhenParent<T> extends InnerOperator<T, T> {
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        /* synthetic */ void cancel();

        void deferredComplete();

        void deferredError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        /* synthetic */ void request(long j10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class UsingWhenSubscriber<T, S> implements UsingWhenParent<T> {
        static final AtomicIntegerFieldUpdater<UsingWhenSubscriber> CALLBACK_APPLIED = AtomicIntegerFieldUpdater.newUpdater(UsingWhenSubscriber.class, "callbackApplied");
        final CoreSubscriber<? super T> actual;

        @Nullable
        final Operators.DeferredSubscription arbiter;

        @Nullable
        final Function<? super S, ? extends qd.c> asyncCancel;
        final Function<? super S, ? extends qd.c> asyncComplete;
        final BiFunction<? super S, ? super Throwable, ? extends qd.c> asyncError;
        volatile int callbackApplied;
        Throwable error;
        final S resource;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10705s;

        public UsingWhenSubscriber(CoreSubscriber<? super T> coreSubscriber, S s6, Function<? super S, ? extends qd.c> function, BiFunction<? super S, ? super Throwable, ? extends qd.c> biFunction, @Nullable Function<? super S, ? extends qd.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
            this.actual = coreSubscriber;
            this.resource = s6;
            this.asyncComplete = function;
            this.asyncError = biFunction;
            this.asyncCancel = function2;
            this.arbiter = deferredSubscription;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 3)) {
                this.f10705s.cancel();
                try {
                    Function<? super S, ? extends qd.c> function = this.asyncCancel;
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

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 1)) {
                try {
                    qd.c cVarApply = this.asyncComplete.apply(this.resource);
                    Objects.requireNonNull(cVarApply, "The asyncComplete returned a null Publisher");
                    Operators.toFluxOrMono(cVarApply).subscribe((qd.d) new CommitInner(this));
                } catch (Throwable th) {
                    deferredError(Operators.onOperatorError(th, this.actual.currentContext()));
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (CALLBACK_APPLIED.compareAndSet(this, 0, 2)) {
                try {
                    qd.c cVarApply = this.asyncError.apply(this.resource, th);
                    Objects.requireNonNull(cVarApply, "The asyncError returned a null Publisher");
                    Operators.toFluxOrMono(cVarApply).subscribe((qd.d) new RollbackInner(this, th));
                } catch (Throwable th2) {
                    this.actual.onError(Exceptions.addSuppressed(Operators.onOperatorError(th2, this.actual.currentContext()), th));
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10705s, eVar)) {
                this.f10705s = eVar;
                Operators.DeferredSubscription deferredSubscription = this.arbiter;
                if (deferredSubscription == null) {
                    this.actual.onSubscribe(this);
                } else {
                    deferredSubscription.set(this);
                }
            }
        }

        @Override // reactor.core.publisher.FluxUsingWhen.UsingWhenParent, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.f10705s.request(j10);
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
                return attr == Scannable.Attr.PARENT ? this.f10705s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Throwable th = this.error;
            if (th == Exceptions.TERMINATED) {
                return null;
            }
            return th;
        }
    }

    public FluxUsingWhen(qd.c cVar, Function<? super S, ? extends qd.c> function, Function<? super S, ? extends qd.c> function2, BiFunction<? super S, ? super Throwable, ? extends qd.c> biFunction, @Nullable Function<? super S, ? extends qd.c> function3) {
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
    public static <RESOURCE, T> qd.c deriveFluxFromResource(RESOURCE resource, Function<? super RESOURCE, ? extends qd.c> function) {
        try {
            qd.c cVarApply = function.apply(resource);
            Objects.requireNonNull(cVarApply, "The resourceClosure function returned a null value");
            return cVarApply;
        } catch (Throwable th) {
            return Flux.error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <RESOURCE, T> UsingWhenSubscriber<? super T, RESOURCE> prepareSubscriberForResource(RESOURCE resource, CoreSubscriber<? super T> coreSubscriber, Function<? super RESOURCE, ? extends qd.c> function, BiFunction<? super RESOURCE, ? super Throwable, ? extends qd.c> biFunction, @Nullable Function<? super RESOURCE, ? extends qd.c> function2, @Nullable Operators.DeferredSubscription deferredSubscription) {
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
        qd.c cVar = this.resourceSupplier;
        if (!(cVar instanceof Callable)) {
            Operators.toFluxOrMono(cVar).subscribe((qd.d) new ResourceSubscriber(coreSubscriber, this.resourceClosure, this.asyncComplete, this.asyncError, this.asyncCancel, this.resourceSupplier instanceof Mono));
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
            qd.c cVarDeriveFluxFromResource = deriveFluxFromResource(objCall, this.resourceClosure);
            coreSubscriber2 = coreSubscriber;
            try {
                Operators.toFluxOrMono(cVarDeriveFluxFromResource).subscribe((qd.d) prepareSubscriberForResource(objCall, coreSubscriber2, this.asyncComplete, this.asyncError, this.asyncCancel, null));
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CancelInner implements InnerConsumer<Object> {
        final UsingWhenParent parent;

        public CancelInner(UsingWhenParent usingWhenParent) {
            this.parent = usingWhenParent;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            Loggers.getLogger((Class<?>) FluxUsingWhen.class).warn("Async resource cleanup failed after cancel", th);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            this.parent.deferredComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.done = true;
            this.parent.deferredError(new RuntimeException("Async resource cleanup failed after onComplete", Operators.onOperatorError(th, this.parent.currentContext())));
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            this.parent.deferredError(this.rollbackCause);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.done = true;
            this.parent.deferredError(Exceptions.addSuppressed(new RuntimeException("Async resource cleanup failed after onError", th), this.rollbackCause));
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(Object obj) {
        }
    }
}
