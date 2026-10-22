package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxSwitchOnFirst<T, R> extends InternalFluxOperator<T, R> {
    static final int HAS_FIRST_VALUE_RECEIVED_FLAG = 1;
    static final int HAS_FIRST_VALUE_SENT_FLAG = 16;
    static final int HAS_INBOUND_CANCELLED_FLAG = 32;
    static final int HAS_INBOUND_CLOSED_PREMATURELY_FLAG = 64;
    static final int HAS_INBOUND_REQUESTED_ONCE_FLAG = 8;
    static final int HAS_INBOUND_SUBSCRIBED_ONCE_FLAG = 2;
    static final int HAS_INBOUND_SUBSCRIBER_SET_FLAG = 4;
    static final int HAS_INBOUND_TERMINATED_FLAG = 128;
    static final int HAS_OUTBOUND_CANCELLED_FLAG = 512;
    static final int HAS_OUTBOUND_SUBSCRIBED_FLAG = 256;
    static final int HAS_OUTBOUND_TERMINATED_FLAG = 1024;
    final boolean cancelSourceOnComplete;
    final BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> transformer;

    public static abstract class AbstractSwitchOnFirstMain<T, R> extends Flux<T> implements InnerOperator<T, R> {
        static final AtomicIntegerFieldUpdater<AbstractSwitchOnFirstMain> STATE = AtomicIntegerFieldUpdater.newUpdater(AbstractSwitchOnFirstMain.class, VoiceWakeupReceiver.EXTRA_STATE);
        boolean done;
        T firstValue;
        CoreSubscriber<? super T> inboundSubscriber;
        boolean isFirstOnNextReceivedOnce;
        boolean isInboundRequestedOnce;

        @Nullable
        final StateLogger logger;
        final SwitchOnFirstControlSubscriber<? super R> outboundSubscriber;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39578s;
        volatile int state;
        Throwable throwable;
        final BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> transformer;

        public AbstractSwitchOnFirstMain(CoreSubscriber<? super R> coreSubscriber, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10, @Nullable StateLogger stateLogger) {
            this.outboundSubscriber = coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new SwitchOnFirstConditionalControlSubscriber<>(this, (Fuseable.ConditionalSubscriber) coreSubscriber, z10) : new SwitchOnFirstControlSubscriber<>(this, coreSubscriber, z10);
            this.transformer = biFunction;
            this.logger = stateLogger;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.outboundSubscriber;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public final void cancel() {
            long jMarkInboundCancelled = FluxSwitchOnFirst.markInboundCancelled(this);
            if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundCancelled) || FluxSwitchOnFirst.hasInboundTerminated(jMarkInboundCancelled) || FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundCancelled)) {
                return;
            }
            this.f39578s.cancel();
            if (!FluxSwitchOnFirst.hasFirstValueReceived(jMarkInboundCancelled) || FluxSwitchOnFirst.hasInboundRequestedOnce(jMarkInboundCancelled)) {
                return;
            }
            T t10 = this.firstValue;
            this.firstValue = null;
            Operators.onDiscard(t10, currentContext());
        }

        public final void cancelAndError() {
            long jMarkInboundClosedPrematurely = FluxSwitchOnFirst.markInboundClosedPrematurely(this);
            if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundClosedPrematurely) || FluxSwitchOnFirst.hasInboundTerminated(jMarkInboundClosedPrematurely)) {
                return;
            }
            this.f39578s.cancel();
            if (!FluxSwitchOnFirst.hasFirstValueReceived(jMarkInboundClosedPrematurely) || FluxSwitchOnFirst.hasFirstValueSent(jMarkInboundClosedPrematurely)) {
                if (FluxSwitchOnFirst.hasInboundSubscriberSet(jMarkInboundClosedPrematurely)) {
                    synchronized (this) {
                        this.inboundSubscriber.onError(new CancellationException("FluxSwitchOnFirst has already been cancelled"));
                    }
                    return;
                }
                return;
            }
            if (FluxSwitchOnFirst.hasInboundRequestedOnce(jMarkInboundClosedPrematurely)) {
                return;
            }
            T t10 = this.firstValue;
            this.firstValue = null;
            Operators.onDiscard(t10, currentContext());
            if (FluxSwitchOnFirst.hasInboundSubscriberSet(jMarkInboundClosedPrematurely)) {
                this.inboundSubscriber.onError(new CancellationException("FluxSwitchOnFirst has already been cancelled"));
            }
        }

        public abstract CoreSubscriber<? super T> convert(CoreSubscriber<? super T> coreSubscriber);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long jMarkInboundTerminated = FluxSwitchOnFirst.markInboundTerminated(this);
            if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundTerminated) || FluxSwitchOnFirst.hasInboundTerminated(jMarkInboundTerminated) || FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundTerminated)) {
                return;
            }
            if (FluxSwitchOnFirst.hasFirstValueSent(jMarkInboundTerminated)) {
                synchronized (this) {
                    this.inboundSubscriber.onComplete();
                }
            } else {
                if (FluxSwitchOnFirst.hasFirstValueReceived(jMarkInboundTerminated)) {
                    return;
                }
                SwitchOnFirstControlSubscriber<? super R> switchOnFirstControlSubscriber = this.outboundSubscriber;
                try {
                    qc.b<? extends R> bVarApply = this.transformer.apply(Signal.complete(switchOnFirstControlSubscriber.currentContext()), this);
                    Objects.requireNonNull(bVarApply, "The transformer returned a null value");
                    Operators.toFluxOrMono(bVarApply).subscribe((qc.c) switchOnFirstControlSubscriber);
                } catch (Throwable th) {
                    switchOnFirstControlSubscriber.onError(th);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.outboundSubscriber.currentContext());
                return;
            }
            this.done = true;
            this.throwable = th;
            long jMarkInboundTerminated = FluxSwitchOnFirst.markInboundTerminated(this);
            if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundTerminated) || FluxSwitchOnFirst.hasInboundTerminated(jMarkInboundTerminated) || FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundTerminated)) {
                Operators.onErrorDropped(th, this.outboundSubscriber.currentContext());
                return;
            }
            if (FluxSwitchOnFirst.hasFirstValueSent(jMarkInboundTerminated)) {
                synchronized (this) {
                    this.inboundSubscriber.onError(th);
                }
            } else {
                if (FluxSwitchOnFirst.hasFirstValueReceived(jMarkInboundTerminated)) {
                    return;
                }
                SwitchOnFirstControlSubscriber<? super R> switchOnFirstControlSubscriber = this.outboundSubscriber;
                try {
                    qc.b<? extends R> bVarApply = this.transformer.apply(Signal.error(th, switchOnFirstControlSubscriber.currentContext()), this);
                    Objects.requireNonNull(bVarApply, "The transformer returned a null value");
                    Operators.toFluxOrMono(bVarApply).subscribe((qc.c) switchOnFirstControlSubscriber);
                } catch (Throwable th2) {
                    switchOnFirstControlSubscriber.onError(Exceptions.addSuppressed(th, th2));
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            if (this.isFirstOnNextReceivedOnce) {
                synchronized (this) {
                    this.inboundSubscriber.onNext(t10);
                }
                return;
            }
            this.isFirstOnNextReceivedOnce = true;
            this.firstValue = t10;
            long jMarkFirstValueReceived = FluxSwitchOnFirst.markFirstValueReceived(this);
            if (FluxSwitchOnFirst.hasInboundCancelled(jMarkFirstValueReceived) || FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkFirstValueReceived)) {
                this.firstValue = null;
                Operators.onDiscard(t10, this.outboundSubscriber.currentContext());
                return;
            }
            SwitchOnFirstControlSubscriber<? super R> switchOnFirstControlSubscriber = this.outboundSubscriber;
            try {
                qc.b<? extends R> bVarApply = this.transformer.apply(Signal.next(t10, switchOnFirstControlSubscriber.currentContext()), this);
                Objects.requireNonNull(bVarApply, "The transformer returned a null value");
                Operators.toFluxOrMono(bVarApply).subscribe((qc.c) switchOnFirstControlSubscriber);
            } catch (Throwable th) {
                this.done = true;
                long jMarkInboundCancelledAndOutboundTerminated = FluxSwitchOnFirst.markInboundCancelledAndOutboundTerminated(this);
                if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundCancelledAndOutboundTerminated) || FluxSwitchOnFirst.hasOutboundCancelled(jMarkInboundCancelledAndOutboundTerminated)) {
                    Operators.onErrorDropped(th, switchOnFirstControlSubscriber.currentContext());
                    return;
                }
                this.firstValue = null;
                Operators.onDiscard(t10, switchOnFirstControlSubscriber.currentContext());
                switchOnFirstControlSubscriber.errorDirectly(Operators.onOperatorError(this.f39578s, th, t10, switchOnFirstControlSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public final void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39578s, dVar)) {
                this.f39578s = dVar;
                this.outboundSubscriber.sendSubscription();
                if (FluxSwitchOnFirst.hasInboundCancelled(this.state)) {
                    return;
                }
                dVar.request(1L);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public final void request(long j10) {
            if (Operators.validate(j10)) {
                if (!this.isInboundRequestedOnce) {
                    this.isInboundRequestedOnce = true;
                    if (this.isFirstOnNextReceivedOnce) {
                        long jMarkInboundRequestedOnce = FluxSwitchOnFirst.markInboundRequestedOnce(this);
                        if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundRequestedOnce) || FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundRequestedOnce)) {
                            return;
                        }
                        T t10 = this.firstValue;
                        this.firstValue = null;
                        if (sendFirst(t10) && j10 != Long.MAX_VALUE) {
                            long j11 = j10 - 1;
                            if (j11 > 0) {
                                this.f39578s.request(j11);
                                return;
                            }
                            return;
                        }
                    }
                }
                this.f39578s.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public final Object scanUnsafe(Scannable.Attr attr) {
            boolean z10 = true;
            if (attr == Scannable.Attr.CANCELLED) {
                if (!FluxSwitchOnFirst.hasInboundCancelled(this.state) && !FluxSwitchOnFirst.hasInboundClosedPrematurely(this.state)) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
            if (attr != Scannable.Attr.TERMINATED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (!FluxSwitchOnFirst.hasInboundTerminated(this.state) && !FluxSwitchOnFirst.hasInboundClosedPrematurely(this.state)) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }

        public final boolean sendFirst(T t10) {
            CoreSubscriber<? super T> coreSubscriber = this.inboundSubscriber;
            boolean zTryDirectSend = tryDirectSend(coreSubscriber, t10);
            long jMarkFirstValueSent = FluxSwitchOnFirst.markFirstValueSent(this);
            if (!FluxSwitchOnFirst.hasInboundCancelled(jMarkFirstValueSent)) {
                if (FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkFirstValueSent)) {
                    coreSubscriber.onError(new CancellationException("FluxSwitchOnFirst has already been cancelled"));
                    return zTryDirectSend;
                }
                if (FluxSwitchOnFirst.hasInboundTerminated(jMarkFirstValueSent)) {
                    Throwable th = this.throwable;
                    if (th != null) {
                        coreSubscriber.onError(th);
                        return zTryDirectSend;
                    }
                    coreSubscriber.onComplete();
                }
            }
            return zTryDirectSend;
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public final void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            long jMarkInboundSubscribedOnce = FluxSwitchOnFirst.markInboundSubscribedOnce(this);
            if (FluxSwitchOnFirst.hasInboundSubscribedOnce(jMarkInboundSubscribedOnce)) {
                Operators.error(coreSubscriber, new IllegalStateException("FluxSwitchOnFirst allows only one Subscriber"));
                return;
            }
            if (FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundSubscribedOnce)) {
                Operators.error(coreSubscriber, new CancellationException("FluxSwitchOnFirst has already been cancelled"));
                return;
            }
            if (!FluxSwitchOnFirst.hasFirstValueReceived(jMarkInboundSubscribedOnce)) {
                Throwable th = this.throwable;
                if (th != null) {
                    Operators.error(coreSubscriber, th);
                    return;
                } else {
                    Operators.complete(coreSubscriber);
                    return;
                }
            }
            this.inboundSubscriber = convert(coreSubscriber);
            coreSubscriber.onSubscribe(this);
            long jMarkInboundSubscriberSet = FluxSwitchOnFirst.markInboundSubscriberSet(this);
            if (FluxSwitchOnFirst.hasInboundClosedPrematurely(jMarkInboundSubscriberSet)) {
                if ((!FluxSwitchOnFirst.hasInboundRequestedOnce(jMarkInboundSubscriberSet) || FluxSwitchOnFirst.hasFirstValueSent(jMarkInboundSubscriberSet)) && !FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundSubscriberSet)) {
                    coreSubscriber.onError(new CancellationException("FluxSwitchOnFirst has already been cancelled"));
                }
            }
        }

        public abstract boolean tryDirectSend(CoreSubscriber<? super T> coreSubscriber, T t10);
    }

    public static final class SwitchOnFirstConditionalControlSubscriber<T> extends SwitchOnFirstControlSubscriber<T> implements InnerOperator<T, T>, Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> delegate;

        public SwitchOnFirstConditionalControlSubscriber(AbstractSwitchOnFirstMain<?, T> abstractSwitchOnFirstMain, Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, boolean z10) {
            super(abstractSwitchOnFirstMain, conditionalSubscriber, z10);
            this.delegate = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (!this.done) {
                return this.delegate.tryOnNext(t10);
            }
            Operators.onNextDropped(t10, currentContext());
            return true;
        }
    }

    public static final class SwitchOnFirstConditionalMain<T, R> extends AbstractSwitchOnFirstMain<T, R> implements Fuseable.ConditionalSubscriber<T> {
        public SwitchOnFirstConditionalMain(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10) {
            super(conditionalSubscriber, biFunction, z10, null);
        }

        @Override // reactor.core.publisher.FluxSwitchOnFirst.AbstractSwitchOnFirstMain
        public CoreSubscriber<? super T> convert(CoreSubscriber<? super T> coreSubscriber) {
            return Operators.toConditionalSubscriber(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxSwitchOnFirst.AbstractSwitchOnFirstMain
        public boolean tryDirectSend(CoreSubscriber<? super T> coreSubscriber, T t10) {
            return ((Fuseable.ConditionalSubscriber) coreSubscriber).tryOnNext(t10);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            boolean zTryOnNext;
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
                return false;
            }
            if (this.isFirstOnNextReceivedOnce) {
                synchronized (this) {
                    zTryOnNext = ((Fuseable.ConditionalSubscriber) this.inboundSubscriber).tryOnNext(t10);
                }
                return zTryOnNext;
            }
            this.isFirstOnNextReceivedOnce = true;
            this.firstValue = t10;
            if (FluxSwitchOnFirst.hasInboundCancelled(FluxSwitchOnFirst.markFirstValueReceived(this))) {
                this.firstValue = null;
                Operators.onDiscard(t10, this.outboundSubscriber.currentContext());
                return true;
            }
            SwitchOnFirstControlSubscriber<? super R> switchOnFirstControlSubscriber = this.outboundSubscriber;
            try {
                qc.b<? extends R> bVarApply = this.transformer.apply(Signal.next(t10, switchOnFirstControlSubscriber.currentContext()), this);
                Objects.requireNonNull(bVarApply, "The transformer returned a null value");
                Operators.toFluxOrMono(bVarApply).subscribe((qc.c) switchOnFirstControlSubscriber);
                return true;
            } catch (Throwable th) {
                this.done = true;
                long jMarkInboundCancelledAndOutboundTerminated = FluxSwitchOnFirst.markInboundCancelledAndOutboundTerminated(this);
                if (FluxSwitchOnFirst.hasInboundCancelled(jMarkInboundCancelledAndOutboundTerminated) || FluxSwitchOnFirst.hasOutboundCancelled(jMarkInboundCancelledAndOutboundTerminated)) {
                    Operators.onErrorDropped(th, switchOnFirstControlSubscriber.currentContext());
                    return true;
                }
                this.firstValue = null;
                Operators.onDiscard(t10, switchOnFirstControlSubscriber.currentContext());
                switchOnFirstControlSubscriber.errorDirectly(Operators.onOperatorError(this.f39578s, th, t10, switchOnFirstControlSubscriber.currentContext()));
                return true;
            }
        }

        public SwitchOnFirstConditionalMain(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10, @Nullable StateLogger stateLogger) {
            super(conditionalSubscriber, biFunction, z10, stateLogger);
        }
    }

    public static class SwitchOnFirstControlSubscriber<T> extends Operators.DeferredSubscription implements InnerOperator<T, T>, CoreSubscriber<T> {
        final boolean cancelSourceOnComplete;
        final CoreSubscriber<? super T> delegate;
        boolean done;
        final AbstractSwitchOnFirstMain<?, T> parent;

        public SwitchOnFirstControlSubscriber(AbstractSwitchOnFirstMain<?, T> abstractSwitchOnFirstMain, CoreSubscriber<? super T> coreSubscriber, boolean z10) {
            this.parent = abstractSwitchOnFirstMain;
            this.delegate = coreSubscriber;
            this.cancelSourceOnComplete = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.delegate;
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, qc.d
        public final void cancel() {
            Operators.DeferredSubscription.REQUESTED.lazySet(this, -2L);
            long jMarkOutboundCancelled = FluxSwitchOnFirst.markOutboundCancelled(this.parent);
            if (FluxSwitchOnFirst.hasOutboundCancelled(jMarkOutboundCancelled) || FluxSwitchOnFirst.hasOutboundTerminated(jMarkOutboundCancelled)) {
                return;
            }
            boolean z10 = (FluxSwitchOnFirst.hasInboundTerminated(jMarkOutboundCancelled) || FluxSwitchOnFirst.hasInboundCancelled(jMarkOutboundCancelled)) ? false : true;
            if (!FluxSwitchOnFirst.hasOutboundSubscribed(jMarkOutboundCancelled)) {
                if (z10) {
                    this.parent.cancel();
                }
            } else {
                this.f39688s.cancel();
                if (z10) {
                    this.parent.cancelAndError();
                }
            }
        }

        public final void errorDirectly(Throwable th) {
            this.done = true;
            this.delegate.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            AbstractSwitchOnFirstMain<?, T> abstractSwitchOnFirstMain = this.parent;
            long jMarkOutboundTerminated = FluxSwitchOnFirst.markOutboundTerminated(abstractSwitchOnFirstMain);
            if (this.cancelSourceOnComplete && !FluxSwitchOnFirst.hasInboundCancelled(jMarkOutboundTerminated) && !FluxSwitchOnFirst.hasInboundTerminated(jMarkOutboundTerminated)) {
                abstractSwitchOnFirstMain.cancelAndError();
            }
            this.delegate.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.done = true;
            AbstractSwitchOnFirstMain<?, T> abstractSwitchOnFirstMain = this.parent;
            long jMarkOutboundTerminated = FluxSwitchOnFirst.markOutboundTerminated(abstractSwitchOnFirstMain);
            if (FluxSwitchOnFirst.hasOutboundCancelled(jMarkOutboundTerminated) || FluxSwitchOnFirst.hasOutboundTerminated(jMarkOutboundTerminated)) {
                Operators.onErrorDropped(th, this.delegate.currentContext());
                return;
            }
            if (!FluxSwitchOnFirst.hasInboundCancelled(jMarkOutboundTerminated) && !FluxSwitchOnFirst.hasInboundTerminated(jMarkOutboundTerminated)) {
                abstractSwitchOnFirstMain.cancelAndError();
            }
            this.delegate.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public final void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
            } else {
                this.delegate.onNext(t10);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public final void onSubscribe(qc.d dVar) {
            if (set(dVar) && FluxSwitchOnFirst.hasOutboundCancelled(FluxSwitchOnFirst.markOutboundSubscribed(this.parent))) {
                dVar.cancel();
            }
        }

        @Override // reactor.core.publisher.Operators.DeferredSubscription, reactor.core.Scannable
        public final Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.ACTUAL ? this.delegate : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(FluxSwitchOnFirst.hasOutboundCancelled(this.parent.state)) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(FluxSwitchOnFirst.hasOutboundTerminated(this.parent.state)) : super.scanUnsafe(attr);
        }

        public final void sendSubscription() {
            this.delegate.onSubscribe(this);
        }
    }

    public static final class SwitchOnFirstMain<T, R> extends AbstractSwitchOnFirstMain<T, R> {
        public SwitchOnFirstMain(CoreSubscriber<? super R> coreSubscriber, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10) {
            super(coreSubscriber, biFunction, z10, null);
        }

        @Override // reactor.core.publisher.FluxSwitchOnFirst.AbstractSwitchOnFirstMain
        public CoreSubscriber<? super T> convert(CoreSubscriber<? super T> coreSubscriber) {
            return coreSubscriber;
        }

        @Override // reactor.core.publisher.FluxSwitchOnFirst.AbstractSwitchOnFirstMain
        public boolean tryDirectSend(CoreSubscriber<? super T> coreSubscriber, T t10) {
            coreSubscriber.onNext(t10);
            return true;
        }

        public SwitchOnFirstMain(CoreSubscriber<? super R> coreSubscriber, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10, @Nullable StateLogger stateLogger) {
            super(coreSubscriber, biFunction, z10, stateLogger);
        }
    }

    public FluxSwitchOnFirst(Flux<? extends T> flux, BiFunction<Signal<? extends T>, Flux<T>, qc.b<? extends R>> biFunction, boolean z10) {
        super(flux);
        Objects.requireNonNull(biFunction, "transformer");
        this.transformer = biFunction;
        this.cancelSourceOnComplete = z10;
    }

    public static boolean hasFirstValueReceived(long j10) {
        return (j10 & 1) == 1;
    }

    public static boolean hasFirstValueSent(long j10) {
        return (j10 & 16) == 16;
    }

    public static boolean hasInboundCancelled(long j10) {
        return (j10 & 32) == 32;
    }

    public static boolean hasInboundClosedPrematurely(long j10) {
        return (j10 & 64) == 64;
    }

    public static boolean hasInboundRequestedOnce(long j10) {
        return (j10 & 8) == 8;
    }

    public static boolean hasInboundSubscribedOnce(long j10) {
        return (j10 & 2) == 2;
    }

    public static boolean hasInboundSubscriberSet(long j10) {
        return (j10 & 4) == 4;
    }

    public static boolean hasInboundTerminated(long j10) {
        return (j10 & 128) == 128;
    }

    public static boolean hasOutboundCancelled(long j10) {
        return (j10 & 512) == 512;
    }

    public static boolean hasOutboundSubscribed(long j10) {
        return (j10 & 256) == 256;
    }

    public static boolean hasOutboundTerminated(long j10) {
        return (j10 & 1024) == 1024;
    }

    public static <T, R> long markFirstValueReceived(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasInboundClosedPrematurely(j10)) {
                break;
            }
            int i11 = i10 | 1;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "mfvr", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markFirstValueSent(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasInboundClosedPrematurely(j10)) {
                break;
            }
            int i11 = i10 | 16;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "mfvs", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundCancelled(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10)) {
                break;
            }
            int i11 = i10 | 32;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "micd", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundCancelledAndOutboundTerminated(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasOutboundCancelled(j10)) {
                break;
            }
            int i11 = i10 | 1056;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "icot", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundClosedPrematurely(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundTerminated(j10) || hasInboundCancelled(j10)) {
                break;
            }
            int i11 = i10 | 64;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "micp", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundRequestedOnce(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasInboundClosedPrematurely(j10)) {
                break;
            }
            int i11 = i10 | 8;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "miro", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundSubscribedOnce(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundSubscribedOnce(j10)) {
                break;
            }
            int i11 = i10 | 2;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "miso", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundSubscriberSet(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasInboundClosedPrematurely(j10)) {
                break;
            }
            int i11 = i10 | 4;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "miss", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markInboundTerminated(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasInboundCancelled(j10) || hasInboundClosedPrematurely(j10)) {
                break;
            }
            int i11 = i10 | 128;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "mitd", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markOutboundCancelled(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasOutboundTerminated(j10) || hasOutboundCancelled(j10)) {
                break;
            }
            int i11 = i10 | 512;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "mocd", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markOutboundSubscribed(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasOutboundCancelled(j10)) {
                break;
            }
            int i11 = i10 | 256;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "mosd", i10, i11);
                }
            }
        }
        return j10;
    }

    public static <T, R> long markOutboundTerminated(AbstractSwitchOnFirstMain<T, R> abstractSwitchOnFirstMain) {
        long j10;
        while (true) {
            int i10 = abstractSwitchOnFirstMain.state;
            j10 = i10;
            if (hasOutboundCancelled(j10) || hasOutboundTerminated(j10)) {
                break;
            }
            int i11 = i10 | HAS_OUTBOUND_TERMINATED_FLAG;
            if (AbstractSwitchOnFirstMain.STATE.compareAndSet(abstractSwitchOnFirstMain, i10, i11)) {
                StateLogger stateLogger = abstractSwitchOnFirstMain.logger;
                if (stateLogger != null) {
                    stateLogger.log(abstractSwitchOnFirstMain.toString(), "motd", i10, i11);
                }
            }
        }
        return j10;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return 1;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new SwitchOnFirstConditionalMain((Fuseable.ConditionalSubscriber) coreSubscriber, this.transformer, this.cancelSourceOnComplete, null) : new SwitchOnFirstMain(coreSubscriber, this.transformer, this.cancelSourceOnComplete);
    }
}
