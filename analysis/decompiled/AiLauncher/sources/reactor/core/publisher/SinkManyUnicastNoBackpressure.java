package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class SinkManyUnicastNoBackpressure<T> extends Flux<T> implements InternalManySink<T>, qc.d, ContextHolder {
    private volatile CoreSubscriber<? super T> actual = null;
    volatile long requested;
    volatile State state;
    private static final AtomicReferenceFieldUpdater<SinkManyUnicastNoBackpressure, State> STATE = AtomicReferenceFieldUpdater.newUpdater(SinkManyUnicastNoBackpressure.class, State.class, VoiceWakeupReceiver.EXTRA_STATE);
    static final AtomicLongFieldUpdater<SinkManyUnicastNoBackpressure> REQUESTED = AtomicLongFieldUpdater.newUpdater(SinkManyUnicastNoBackpressure.class, "requested");

    /* renamed from: reactor.core.publisher.SinkManyUnicastNoBackpressure$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State = iArr;
            try {
                iArr[State.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[State.SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[State.TERMINATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[State.CANCELLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        INITIAL,
        SUBSCRIBED,
        TERMINATED,
        CANCELLED
    }

    public SinkManyUnicastNoBackpressure() {
        STATE.lazySet(this, State.INITIAL);
    }

    public static <E> SinkManyUnicastNoBackpressure<E> create() {
        return new SinkManyUnicastNoBackpressure<>();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }

    @Override // qc.d
    public void cancel() {
        if (STATE.getAndSet(this, State.CANCELLED) == State.SUBSCRIBED) {
            this.actual = null;
        }
    }

    @Override // reactor.core.publisher.ContextHolder
    public Context currentContext() {
        CoreSubscriber<? super T> coreSubscriber = this.actual;
        return coreSubscriber != null ? coreSubscriber.currentContext() : Context.empty();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.state == State.SUBSCRIBED ? 1 : 0;
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        CoreSubscriber<? super T> coreSubscriber = this.actual;
        return coreSubscriber == null ? Stream.empty() : Stream.of(Scannable.from(coreSubscriber));
    }

    @Override // qc.d
    public void request(long j10) {
        if (Operators.validate(j10)) {
            Operators.addCap(REQUESTED, this, j10);
        }
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.ACTUAL) {
            return this.actual;
        }
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(this.state == State.TERMINATED);
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(this.state == State.CANCELLED);
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        CoreSubscriber<? super T> coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        if (!STATE.compareAndSet(this, State.INITIAL, State.SUBSCRIBED)) {
            Operators.reportThrowInSubscribe(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, new IllegalStateException("Unicast Sinks.Many allows only a single Subscriber"));
        } else {
            this.actual = coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled;
            coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(this);
        }
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitComplete() {
        State state;
        do {
            state = this.state;
            int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[state.ordinal()];
            if (i10 == 1) {
                return Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
            }
            if (i10 != 2) {
                if (i10 == 3) {
                    return Sinks.EmitResult.FAIL_TERMINATED;
                }
                if (i10 == 4) {
                    return Sinks.EmitResult.FAIL_CANCELLED;
                }
                throw new IllegalStateException();
            }
        } while (!STATE.compareAndSet(this, state, State.TERMINATED));
        this.actual.onComplete();
        this.actual = null;
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitError(Throwable th) {
        State state;
        Objects.requireNonNull(th, "t");
        do {
            state = this.state;
            int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[state.ordinal()];
            if (i10 == 1) {
                return Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
            }
            if (i10 != 2) {
                if (i10 == 3) {
                    return Sinks.EmitResult.FAIL_TERMINATED;
                }
                if (i10 == 4) {
                    return Sinks.EmitResult.FAIL_CANCELLED;
                }
                throw new IllegalStateException();
            }
        } while (!STATE.compareAndSet(this, state, State.TERMINATED));
        this.actual.onError(th);
        this.actual = null;
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitNext(T t10) {
        Objects.requireNonNull(t10, "t");
        int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$SinkManyUnicastNoBackpressure$State[this.state.ordinal()];
        if (i10 == 1) {
            return Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return Sinks.EmitResult.FAIL_TERMINATED;
            }
            if (i10 == 4) {
                return Sinks.EmitResult.FAIL_CANCELLED;
            }
            throw new IllegalStateException();
        }
        if (this.requested == 0) {
            return Sinks.EmitResult.FAIL_OVERFLOW;
        }
        this.actual.onNext(t10);
        Operators.produced(REQUESTED, this, 1L);
        return Sinks.EmitResult.OK;
    }
}
