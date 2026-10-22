package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class NextProcessor<O> extends MonoProcessor<O> implements CoreSubscriber<O>, Disposable, Scannable {

    @Nullable
    Throwable error;
    final boolean isRefCounted;

    @Nullable
    CorePublisher<? extends O> source;
    volatile NextInner<O>[] subscribers;
    volatile qd.e subscription;

    @Nullable
    O value;
    static final AtomicReferenceFieldUpdater<NextProcessor, NextInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(NextProcessor.class, NextInner[].class, "subscribers");
    static final NextInner[] EMPTY = new NextInner[0];
    static final NextInner[] TERMINATED = new NextInner[0];
    static final NextInner[] EMPTY_WITH_SOURCE = new NextInner[0];
    static final AtomicReferenceFieldUpdater<NextProcessor, qd.e> UPSTREAM = AtomicReferenceFieldUpdater.newUpdater(NextProcessor.class, qd.e.class, "subscription");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: reactor.core.publisher.NextProcessor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$Sinks$EmitResult;

        static {
            int[] iArr = new int[Sinks.EmitResult.values().length];
            $SwitchMap$reactor$core$publisher$Sinks$EmitResult = iArr;
            try {
                iArr[Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_NON_SERIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class NextInner<T> extends Operators.MonoSubscriber<T, T> {
        final NextProcessor<T> parent;

        public NextInner(CoreSubscriber<? super T> coreSubscriber, NextProcessor<T> nextProcessor) {
            super(coreSubscriber);
            this.parent = nextProcessor;
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (Operators.MonoSubscriber.STATE.getAndSet(this, 4) != 4) {
                this.parent.remove(this);
            }
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (isCancelled()) {
                return;
            }
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public NextProcessor(@Nullable CorePublisher<? extends O> corePublisher, boolean z10) {
        this.source = corePublisher;
        this.isRefCounted = z10;
        SUBSCRIBERS.lazySet(this, corePublisher != null ? EMPTY_WITH_SOURCE : EMPTY);
    }

    public boolean add(NextInner<O> nextInner) {
        NextInner<O>[] nextInnerArr;
        NextInner[] nextInnerArr2;
        do {
            nextInnerArr = this.subscribers;
            if (nextInnerArr == TERMINATED) {
                return false;
            }
            int length = nextInnerArr.length;
            nextInnerArr2 = new NextInner[length + 1];
            System.arraycopy(nextInnerArr, 0, nextInnerArr2, 0, length);
            nextInnerArr2[length] = nextInner;
        } while (!SUBSCRIBERS.compareAndSet(this, nextInnerArr, nextInnerArr2));
        CorePublisher<? extends O> corePublisher = this.source;
        if (corePublisher == null || nextInnerArr != EMPTY_WITH_SOURCE) {
            return true;
        }
        corePublisher.subscribe((qd.d) this);
        return true;
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.publisher.Mono
    @Nullable
    public O block(@Nullable Duration duration) throws InterruptedException {
        try {
            if (isTerminated()) {
                return peek();
            }
            connect();
            long jNanoTime = duration == null ? 0L : System.nanoTime() + duration.toNanos();
            while (!isTerminated()) {
                if (duration != null && jNanoTime < System.nanoTime()) {
                    doCancel();
                    throw new IllegalStateException("Timeout on Mono blocking read");
                }
                Thread.sleep(1L);
            }
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw Exceptions.addSuppressed(Exceptions.propagate(th), (Throwable) new Exception("Mono#block terminated with an error"));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            od.f.e("Thread Interruption on Mono blocking read");
            return null;
        }
    }

    @Override // reactor.core.publisher.MonoProcessor, qd.e
    public void cancel() {
        doCancel();
    }

    public void connect() {
        CorePublisher<? extends O> corePublisher = this.source;
        if (corePublisher == null || !SUBSCRIBERS.compareAndSet(this, EMPTY_WITH_SOURCE, EMPTY)) {
            return;
        }
        corePublisher.subscribe((qd.d) this);
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        return Operators.multiSubscribersContext(this.subscribers);
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.Disposable
    public void dispose() {
        qd.e andSet = UPSTREAM.getAndSet(this, Operators.cancelledSubscription());
        if (andSet == Operators.cancelledSubscription()) {
            return;
        }
        this.source = null;
        if (andSet != null) {
            andSet.cancel();
        }
        AtomicReferenceFieldUpdater<NextProcessor, NextInner[]> atomicReferenceFieldUpdater = SUBSCRIBERS;
        NextInner[] nextInnerArr = TERMINATED;
        NextInner[] andSet2 = atomicReferenceFieldUpdater.getAndSet(this, nextInnerArr);
        if (andSet2 != nextInnerArr) {
            CancellationException cancellationException = new CancellationException("Disposed");
            this.error = cancellationException;
            this.value = null;
            for (NextInner nextInner : andSet2) {
                nextInner.onError(cancellationException);
            }
        }
    }

    public void doCancel() {
        qd.e andSet;
        if (isTerminated() || (andSet = UPSTREAM.getAndSet(this, Operators.cancelledSubscription())) == Operators.cancelledSubscription()) {
            return;
        }
        this.source = null;
        if (andSet != null) {
            andSet.cancel();
        }
    }

    @Override // reactor.core.publisher.MonoProcessor
    public long downstreamCount() {
        return this.subscribers.length;
    }

    public void emitEmpty(Sinks.EmitFailureHandler emitFailureHandler) {
        Sinks.EmitResult emitResultTryEmitValue;
        do {
            emitResultTryEmitValue = tryEmitValue(null);
            if (emitResultTryEmitValue.isSuccess()) {
                return;
            }
        } while (emitFailureHandler.onEmitFailure(SignalType.ON_COMPLETE, emitResultTryEmitValue));
        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[emitResultTryEmitValue.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return;
        }
        if (i == 5) {
            throw new Sinks.EmissionException(emitResultTryEmitValue, "Spec. Rule 1.3 - onSubscribe, onNext, onError and onComplete signaled to a Subscriber MUST be signaled serially.");
        }
        throw new Sinks.EmissionException(emitResultTryEmitValue, "Unknown emitResult value");
    }

    @Override // reactor.core.publisher.MonoProcessor
    @Nullable
    public Throwable getError() {
        return this.error;
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.of((Object[]) this.subscribers);
    }

    @Override // reactor.core.publisher.MonoProcessor
    public boolean isCancelled() {
        return this.subscription == Operators.cancelledSubscription() && !isTerminated();
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.Disposable
    public boolean isDisposed() {
        return isTerminated();
    }

    @Override // reactor.core.publisher.MonoProcessor
    public boolean isTerminated() {
        return this.subscribers == TERMINATED;
    }

    @Override // reactor.core.publisher.MonoProcessor, qd.d
    public final void onComplete() {
        tryEmitValue(null);
    }

    @Override // reactor.core.publisher.MonoProcessor, qd.d
    public final void onError(Throwable th) {
        Sinks.EmitResult emitResultTryEmitError;
        do {
            emitResultTryEmitError = tryEmitError(th);
            if (emitResultTryEmitError.isSuccess()) {
                return;
            }
        } while (Sinks.EmitFailureHandler.FAIL_FAST.onEmitFailure(SignalType.ON_ERROR, emitResultTryEmitError));
        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[emitResultTryEmitError.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        if (i == 4) {
            Operators.onErrorDropped(th, currentContext());
        } else {
            if (i == 5) {
                throw new Sinks.EmissionException(emitResultTryEmitError, "Spec. Rule 1.3 - onSubscribe, onNext, onError and onComplete signaled to a Subscriber MUST be signaled serially.");
            }
            throw new Sinks.EmissionException(emitResultTryEmitError, "Unknown emitResult value");
        }
    }

    @Override // reactor.core.publisher.MonoProcessor, qd.d
    public final void onNext(@Nullable O o10) {
        Sinks.EmitResult emitResultTryEmitValue;
        if (o10 == null) {
            emitEmpty(Sinks.EmitFailureHandler.FAIL_FAST);
            return;
        }
        do {
            emitResultTryEmitValue = tryEmitValue(o10);
            if (emitResultTryEmitValue.isSuccess()) {
                return;
            }
        } while (Sinks.EmitFailureHandler.FAIL_FAST.onEmitFailure(SignalType.ON_NEXT, emitResultTryEmitValue));
        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[emitResultTryEmitValue.ordinal()];
        if (i != 1) {
            if (i == 2) {
                Operators.onDiscard(o10, currentContext());
                onError(Exceptions.failWithOverflow("Backpressure overflow during Sinks.Many#emitNext"));
            } else if (i == 3) {
                Operators.onDiscard(o10, currentContext());
            } else if (i == 4) {
                Operators.onNextDropped(o10, currentContext());
            } else {
                if (i == 5) {
                    throw new Sinks.EmissionException(emitResultTryEmitValue, "Spec. Rule 1.3 - onSubscribe, onNext, onError and onComplete signaled to a Subscriber MUST be signaled serially.");
                }
                throw new Sinks.EmissionException(emitResultTryEmitValue, "Unknown emitResult value");
            }
        }
    }

    @Override // qd.d
    public final void onSubscribe(qd.e eVar) {
        if (Operators.setOnce(UPSTREAM, this, eVar)) {
            eVar.request(Long.MAX_VALUE);
        }
    }

    @Override // reactor.core.publisher.MonoProcessor
    @Nullable
    public O peek() {
        if (!isTerminated()) {
            return null;
        }
        O o10 = this.value;
        if (o10 != null) {
            return o10;
        }
        Throwable th = this.error;
        if (th == null) {
            return null;
        }
        throw Exceptions.addSuppressed(Exceptions.propagate(th), (Throwable) new Exception("Mono#peek terminated with an error"));
    }

    public void remove(NextInner<O> nextInner) {
        NextInner<O>[] nextInnerArr;
        boolean z10;
        NextInner[] nextInnerArr2;
        qd.e andSet;
        do {
            nextInnerArr = this.subscribers;
            int length = nextInnerArr.length;
            if (length == 0) {
                return;
            }
            z10 = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (nextInnerArr[i] == nextInner) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length != 1) {
                NextInner[] nextInnerArr3 = new NextInner[length - 1];
                System.arraycopy(nextInnerArr, 0, nextInnerArr3, 0, i);
                System.arraycopy(nextInnerArr, i + 1, nextInnerArr3, i, (length - i) - 1);
                nextInnerArr2 = nextInnerArr3;
            } else if (!this.isRefCounted || this.source == null) {
                nextInnerArr2 = EMPTY;
            } else {
                nextInnerArr2 = EMPTY_WITH_SOURCE;
                z10 = true;
            }
        } while (!SUBSCRIBERS.compareAndSet(this, nextInnerArr, nextInnerArr2));
        if (!z10 || (andSet = UPSTREAM.getAndSet(this, null)) == null) {
            return;
        }
        andSet.cancel();
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.subscription;
        }
        boolean zIsTerminated = isTerminated();
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(zIsTerminated);
        }
        if (attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(!zIsTerminated && this.subscription == Operators.cancelledSubscription());
        }
        if (attr == Scannable.Attr.ERROR) {
            return getError();
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(Reader.READ_DONE);
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super O> coreSubscriber) {
        NextInner<O> nextInner = new NextInner<>(coreSubscriber, this);
        coreSubscriber.onSubscribe(nextInner);
        if (add(nextInner)) {
            if (nextInner.isCancelled()) {
                remove(nextInner);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            coreSubscriber.onError(th);
            return;
        }
        O o10 = this.value;
        if (o10 != null) {
            nextInner.complete(o10);
        } else {
            nextInner.onComplete();
        }
    }

    public Sinks.EmitResult tryEmitError(Throwable th) {
        Objects.requireNonNull(th, "onError cannot be null");
        if (UPSTREAM.getAndSet(this, Operators.cancelledSubscription()) == Operators.cancelledSubscription()) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.error = th;
        this.value = null;
        this.source = null;
        for (NextInner nextInner : SUBSCRIBERS.getAndSet(this, TERMINATED)) {
            nextInner.onError(th);
        }
        return Sinks.EmitResult.OK;
    }

    public Sinks.EmitResult tryEmitValue(@Nullable O o10) {
        qd.e andSet = UPSTREAM.getAndSet(this, Operators.cancelledSubscription());
        if (andSet == Operators.cancelledSubscription()) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.value = o10;
        CorePublisher<? extends O> corePublisher = this.source;
        this.source = null;
        NextInner[] andSet2 = SUBSCRIBERS.getAndSet(this, TERMINATED);
        int i = 0;
        if (o10 == null) {
            int length = andSet2.length;
            while (i < length) {
                andSet2[i].onComplete();
                i++;
            }
        } else {
            if (andSet != null && !(corePublisher instanceof Mono)) {
                andSet.cancel();
            }
            int length2 = andSet2.length;
            while (i < length2) {
                andSet2[i].complete(o10);
                i++;
            }
        }
        return Sinks.EmitResult.OK;
    }

    public NextProcessor(@Nullable CorePublisher<? extends O> corePublisher) {
        this(corePublisher, false);
    }

    @Override // reactor.core.publisher.MonoProcessor, reactor.core.publisher.Mono
    @Nullable
    public O block() {
        return block(null);
    }
}
