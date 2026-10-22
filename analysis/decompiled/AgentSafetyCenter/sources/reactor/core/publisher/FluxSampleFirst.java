package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSampleFirst<T, U> extends InternalFluxOperator<T, T> {
    final Function<? super T, ? extends qd.c> throttler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SampleFirstMain<T, U> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile Throwable error;
        volatile boolean gate;
        volatile qd.e other;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10667s;
        final Function<? super T, ? extends qd.c> throttler;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<SampleFirstMain, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, qd.e.class, "s");
        static final AtomicReferenceFieldUpdater<SampleFirstMain, qd.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, qd.e.class, "other");
        static final AtomicLongFieldUpdater<SampleFirstMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(SampleFirstMain.class, "requested");
        static final AtomicIntegerFieldUpdater<SampleFirstMain> WIP = AtomicIntegerFieldUpdater.newUpdater(SampleFirstMain.class, "wip");
        static final AtomicReferenceFieldUpdater<SampleFirstMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(SampleFirstMain.class, Throwable.class, "error");

        public SampleFirstMain(CoreSubscriber<? super T> coreSubscriber, Function<? super T, ? extends qd.c> function) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.throttler = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            Operators.terminate(S, this);
            Operators.terminate(OTHER, this);
        }

        public void error(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
            } else if (WIP.getAndIncrement(this) == 0) {
                handleTermination();
            }
        }

        public void handleTermination() {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate == null || thTerminate == Exceptions.TERMINATED) {
                this.actual.onComplete();
            } else {
                this.actual.onError(thTerminate);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            Operators.terminate(OTHER, this);
            if (WIP.getAndIncrement(this) == 0) {
                handleTermination();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            Operators.terminate(OTHER, this);
            error(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.gate) {
                Operators.onDiscard(t10, this.ctx);
                return;
            }
            this.gate = true;
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<SampleFirstMain> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    this.actual.onNext(t10);
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        handleTermination();
                        return;
                    }
                    try {
                        qd.c cVarApply = this.throttler.apply(t10);
                        Objects.requireNonNull(cVarApply, "The throttler returned a null publisher");
                        qd.c cVar = cVarApply;
                        SampleFirstOther sampleFirstOther = new SampleFirstOther(this);
                        if (Operators.replace(OTHER, this, sampleFirstOther)) {
                            Operators.toFluxOrMono(cVar).subscribe((qd.d) sampleFirstOther);
                        }
                    } catch (Throwable th) {
                        Operators.terminate(S, this);
                        error(Operators.onOperatorError(null, th, t10, this.ctx));
                    }
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void otherError(Throwable th) {
            Operators.terminate(S, this);
            error(th);
        }

        public void otherNext() {
            this.gate = false;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10667s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.f10667s : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SampleFirstOther<U> extends Operators.DeferredSubscription implements InnerConsumer<U> {
        final SampleFirstMain<?, U> main;

        public SampleFirstOther(SampleFirstMain<?, U> sampleFirstMain) {
            this.main = sampleFirstMain;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.main.otherNext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(U u10) {
            cancel();
            this.main.otherNext();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (set(eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSampleFirst(Flux<? extends T> flux, Function<? super T, ? extends qd.c> function) {
        super(flux);
        Objects.requireNonNull(function, "throttler");
        this.throttler = function;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        SampleFirstMain sampleFirstMain = new SampleFirstMain(coreSubscriber, this.throttler);
        coreSubscriber.onSubscribe(sampleFirstMain);
        return sampleFirstMain;
    }
}
