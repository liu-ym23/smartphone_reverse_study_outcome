package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.FluxCreate;
import reactor.core.publisher.FluxSink;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class FluxCreate<T> extends Flux<T> implements SourceProducer<T> {
    final FluxSink.OverflowStrategy backpressure;
    final CreateMode createMode;
    final Consumer<? super FluxSink<T>> source;

    /* renamed from: reactor.core.publisher.FluxCreate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy;

        static {
            int[] iArr = new int[FluxSink.OverflowStrategy.values().length];
            $SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy = iArr;
            try {
                iArr[FluxSink.OverflowStrategy.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy[FluxSink.OverflowStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy[FluxSink.OverflowStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy[FluxSink.OverflowStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static abstract class BaseSink<T> extends AtomicBoolean implements FluxSink<T>, InnerProducer<T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        volatile Disposable disposable;
        volatile LongConsumer requestConsumer;
        volatile long requested;
        static final Disposable TERMINATED = OperatorDisposables.DISPOSED;
        static final Disposable CANCELLED = Disposables.disposed();
        static final LongConsumer NOOP_CONSUMER = new LongConsumer() { // from class: reactor.core.publisher.C0
            @Override // java.util.function.LongConsumer
            public final void accept(long j10) {
                FluxCreate.BaseSink.a(j10);
            }
        };
        static final AtomicReferenceFieldUpdater<BaseSink, Disposable> DISPOSABLE = AtomicReferenceFieldUpdater.newUpdater(BaseSink.class, Disposable.class, "disposable");
        static final AtomicLongFieldUpdater<BaseSink> REQUESTED = AtomicLongFieldUpdater.newUpdater(BaseSink.class, "requested");
        static final AtomicReferenceFieldUpdater<BaseSink, LongConsumer> REQUEST_CONSUMER = AtomicReferenceFieldUpdater.newUpdater(BaseSink.class, LongConsumer.class, "requestConsumer");

        public BaseSink(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            REQUESTED.lazySet(this, Long.MIN_VALUE);
        }

        public static /* synthetic */ void a(long j10) {
        }

        public static <T> long addCap(BaseSink<T> baseSink, long j10) {
            long j11;
            while (true) {
                j11 = baseSink.requested;
                long j12 = j11 & Long.MAX_VALUE;
                if (j12 == Long.MAX_VALUE) {
                    break;
                }
                BaseSink<T> baseSink2 = baseSink;
                if (REQUESTED.compareAndSet(baseSink2, j11, Operators.addCap(j12, j10) | (Long.MIN_VALUE & j11))) {
                    break;
                }
                baseSink = baseSink2;
            }
            return j11;
        }

        public static boolean hasRequestConsumer(long j10) {
            return (j10 & Long.MIN_VALUE) == 0;
        }

        public static <T> long markRequestConsumerSet(BaseSink<T> baseSink) {
            while (true) {
                long j10 = baseSink.requested;
                if (hasRequestConsumer(j10)) {
                    return j10;
                }
                long j11 = j10 & Long.MAX_VALUE;
                BaseSink<T> baseSink2 = baseSink;
                if (REQUESTED.compareAndSet(baseSink2, j10, j11)) {
                    return j11;
                }
                baseSink = baseSink2;
            }
        }

        public static <T> void produced(BaseSink<T> baseSink, long j10) {
            while (true) {
                long j11 = baseSink.requested;
                long j12 = j11 & Long.MAX_VALUE;
                if (j12 == 0 || j12 == Long.MAX_VALUE) {
                    return;
                }
                BaseSink<T> baseSink2 = baseSink;
                if (REQUESTED.compareAndSet(baseSink2, j11, Operators.subOrZero(j12, j10) | (Long.MIN_VALUE & j11))) {
                    return;
                } else {
                    baseSink = baseSink2;
                }
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public final void cancel() {
            disposeResource(true);
            onCancel();
        }

        @Override // reactor.core.publisher.FluxSink
        public void complete() {
            if (isTerminated()) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                disposeResource(false);
            }
        }

        @Override // reactor.core.publisher.FluxSink
        public ContextView contextView() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.FluxSink
        @Deprecated
        public Context currentContext() {
            return this.actual.currentContext();
        }

        public void disposeResource(boolean z10) {
            Disposable disposable;
            Disposable andSet;
            Disposable disposable2 = z10 ? CANCELLED : TERMINATED;
            Disposable disposable3 = this.disposable;
            Disposable disposable4 = TERMINATED;
            if (disposable3 == disposable4 || disposable3 == (disposable = CANCELLED) || (andSet = DISPOSABLE.getAndSet(this, disposable2)) == null || andSet == disposable4 || andSet == disposable) {
                return;
            }
            if (z10 && (andSet instanceof SinkDisposable)) {
                ((SinkDisposable) andSet).cancel();
            }
            andSet.dispose();
        }

        @Override // reactor.core.publisher.FluxSink
        public void error(Throwable th) {
            if (isTerminated()) {
                Operators.onOperatorError(th, this.ctx);
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                disposeResource(false);
            }
        }

        @Override // reactor.core.publisher.FluxSink
        public final boolean isCancelled() {
            return this.disposable == CANCELLED;
        }

        public final boolean isTerminated() {
            return this.disposable == TERMINATED;
        }

        public void onCancel() {
        }

        @Override // reactor.core.publisher.FluxSink
        public final FluxSink<T> onDispose(Disposable disposable) {
            Objects.requireNonNull(disposable, "onDispose");
            if (!DISPOSABLE.compareAndSet(this, null, new SinkDisposable(disposable, null))) {
                Disposable disposable2 = this.disposable;
                if (disposable2 == TERMINATED || disposable2 == CANCELLED) {
                    disposable.dispose();
                } else if (disposable2 instanceof SinkDisposable) {
                    SinkDisposable sinkDisposable = (SinkDisposable) disposable2;
                    if (sinkDisposable.disposable == null) {
                        sinkDisposable.disposable = disposable;
                        return this;
                    }
                    disposable.dispose();
                    return this;
                }
            }
            return this;
        }

        public void onPushPullRequest(LongConsumer longConsumer) {
            if (!REQUEST_CONSUMER.compareAndSet(this, null, longConsumer)) {
                throw new IllegalStateException("A consumer has already been assigned to consume requests");
            }
            long jMarkRequestConsumerSet = markRequestConsumerSet(this);
            if (jMarkRequestConsumerSet > 0) {
                longConsumer.accept(jMarkRequestConsumerSet);
            }
        }

        public void onPushRequest(LongConsumer longConsumer) {
            if (!REQUEST_CONSUMER.compareAndSet(this, null, NOOP_CONSUMER)) {
                throw new IllegalStateException("A consumer has already been assigned to consume requests");
            }
            longConsumer.accept(Long.MAX_VALUE);
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onRequest(LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer, "onRequest");
            onPushRequest(longConsumer);
            return this;
        }

        public void onRequestedFromDownstream() {
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public final void request(long j10) {
            if (Operators.validate(j10)) {
                if (hasRequestConsumer(addCap(this, j10))) {
                    LongConsumer longConsumer = this.requestConsumer;
                    if (!isCancelled()) {
                        longConsumer.accept(j10);
                    }
                }
                onRequestedFromDownstream();
            }
        }

        @Override // reactor.core.publisher.FluxSink
        public long requestedFromDownstream() {
            return this.requested & Long.MAX_VALUE;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.disposable == TERMINATED);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.disposable == CANCELLED);
            }
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(requestedFromDownstream()) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink";
        }

        @Override // reactor.core.publisher.FluxSink
        public final FluxSink<T> onCancel(Disposable disposable) {
            Objects.requireNonNull(disposable, "onCancel");
            if (!DISPOSABLE.compareAndSet(this, null, new SinkDisposable(null, disposable))) {
                Disposable disposable2 = this.disposable;
                if (disposable2 == CANCELLED) {
                    disposable.dispose();
                    return this;
                }
                if (disposable2 instanceof SinkDisposable) {
                    SinkDisposable sinkDisposable = (SinkDisposable) disposable2;
                    if (sinkDisposable.onCancel == null) {
                        sinkDisposable.onCancel = disposable;
                        return this;
                    }
                    disposable.dispose();
                }
            }
            return this;
        }
    }

    public static final class BufferAsyncSink<T> extends BaseSink<T> {
        static final AtomicIntegerFieldUpdater<BufferAsyncSink> WIP = AtomicIntegerFieldUpdater.newUpdater(BufferAsyncSink.class, "wip");
        volatile boolean done;
        Throwable error;
        final Queue<T> queue;
        volatile int wip;

        public BufferAsyncSink(CoreSubscriber<? super T> coreSubscriber, int i10) {
            super(coreSubscriber);
            this.queue = (Queue) Queues.unbounded(i10).get();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.FluxSink
        public void complete() {
            this.done = true;
            drain();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            Queue<T> queue = this.queue;
            while (true) {
                long jRequestedFromDownstream = requestedFromDownstream();
                long j10 = 0;
                while (j10 != jRequestedFromDownstream) {
                    if (isCancelled()) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, null);
                        if (WIP.decrementAndGet(this) == 0) {
                            return;
                        }
                    } else {
                        boolean z10 = this.done;
                        T tPoll = queue.poll();
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.error(th);
                                return;
                            } else {
                                super.complete();
                                return;
                            }
                        }
                        if (z11) {
                            break;
                        }
                        coreSubscriber.onNext(tPoll);
                        j10++;
                    }
                }
                if (j10 == jRequestedFromDownstream) {
                    if (isCancelled()) {
                        Operators.onDiscardQueueWithClear(queue, this.ctx, null);
                        if (WIP.decrementAndGet(this) == 0) {
                            return;
                        }
                    } else {
                        boolean z12 = this.done;
                        boolean zIsEmpty = queue.isEmpty();
                        if (z12 && zIsEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.error(th2);
                                return;
                            } else {
                                super.complete();
                                return;
                            }
                        }
                    }
                }
                if (j10 != 0) {
                    BaseSink.produced(this, j10);
                }
                if (WIP.decrementAndGet(this) == 0) {
                    return;
                }
            }
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.FluxSink
        public void error(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> next(T t10) {
            this.queue.offer(t10);
            drain();
            return this;
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink
        public void onCancel() {
            drain();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink
        public void onRequestedFromDownstream() {
            drain();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.queue.size()) : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink(" + FluxSink.OverflowStrategy.BUFFER + ")";
        }
    }

    public enum CreateMode {
        PUSH_ONLY,
        PUSH_PULL
    }

    public static final class DropAsyncSink<T> extends NoOverflowBaseAsyncSink<T> {
        public DropAsyncSink(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxCreate.NoOverflowBaseAsyncSink
        public void onOverflow() {
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink(" + FluxSink.OverflowStrategy.DROP + ")";
        }
    }

    public static final class ErrorAsyncSink<T> extends NoOverflowBaseAsyncSink<T> {
        public ErrorAsyncSink(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxCreate.NoOverflowBaseAsyncSink
        public void onOverflow() {
            error(Exceptions.failWithOverflow());
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink(" + FluxSink.OverflowStrategy.ERROR + ")";
        }
    }

    public static final class IgnoreSink<T> extends BaseSink<T> {
        public IgnoreSink(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> next(T t10) {
            if (isTerminated()) {
                Operators.onNextDropped(t10, this.ctx);
                return this;
            }
            if (isCancelled()) {
                Operators.onDiscard(t10, this.ctx);
                return this;
            }
            this.actual.onNext(t10);
            while (true) {
                long j10 = this.requested;
                long j11 = Long.MAX_VALUE & j10;
                if (j11 == 0) {
                    return this;
                }
                IgnoreSink<T> ignoreSink = this;
                if (BaseSink.REQUESTED.compareAndSet(ignoreSink, j10, (j11 - 1) | (Long.MIN_VALUE & j10))) {
                    return ignoreSink;
                }
                this = ignoreSink;
            }
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink(" + FluxSink.OverflowStrategy.IGNORE + ")";
        }
    }

    public static final class LatestAsyncSink<T> extends BaseSink<T> {
        static final AtomicIntegerFieldUpdater<LatestAsyncSink> WIP = AtomicIntegerFieldUpdater.newUpdater(LatestAsyncSink.class, "wip");
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        volatile int wip;

        public LatestAsyncSink(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
            this.queue = new AtomicReference<>();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.FluxSink
        public void complete() {
            this.done = true;
            drain();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            AtomicReference<T> atomicReference = this.queue;
            while (true) {
                long jRequestedFromDownstream = requestedFromDownstream();
                long j10 = 0;
                while (true) {
                    if (j10 == jRequestedFromDownstream) {
                        break;
                    }
                    if (isCancelled()) {
                        Operators.onDiscard(atomicReference.getAndSet(null), this.ctx);
                        if (WIP.decrementAndGet(this) == 0) {
                            return;
                        }
                    } else {
                        boolean z10 = this.done;
                        T andSet = atomicReference.getAndSet(null);
                        boolean z11 = andSet == null;
                        if (z10 && z11) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.error(th);
                                return;
                            } else {
                                super.complete();
                                return;
                            }
                        }
                        if (z11) {
                            break;
                        }
                        coreSubscriber.onNext(andSet);
                        j10++;
                    }
                }
                if (j10 == jRequestedFromDownstream) {
                    if (isCancelled()) {
                        Operators.onDiscard(atomicReference.getAndSet(null), this.ctx);
                        if (WIP.decrementAndGet(this) == 0) {
                            return;
                        }
                    } else {
                        boolean z12 = this.done;
                        boolean z13 = atomicReference.get() == null;
                        if (z12 && z13) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.error(th2);
                                return;
                            } else {
                                super.complete();
                                return;
                            }
                        }
                    }
                }
                if (j10 != 0) {
                    BaseSink.produced(this, j10);
                }
                if (WIP.decrementAndGet(this) == 0) {
                    return;
                }
            }
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.FluxSink
        public void error(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> next(T t10) {
            Operators.onDiscard(this.queue.getAndSet(t10), this.ctx);
            drain();
            return this;
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink
        public void onCancel() {
            drain();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink
        public void onRequestedFromDownstream() {
            drain();
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue.get() == null ? 0 : 1);
            }
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : super.scanUnsafe(attr);
        }

        @Override // reactor.core.publisher.FluxCreate.BaseSink, java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "FluxSink(" + FluxSink.OverflowStrategy.LATEST + ")";
        }
    }

    public static abstract class NoOverflowBaseAsyncSink<T> extends BaseSink<T> {
        public NoOverflowBaseAsyncSink(CoreSubscriber<? super T> coreSubscriber) {
            super(coreSubscriber);
        }

        @Override // reactor.core.publisher.FluxSink
        public final FluxSink<T> next(T t10) {
            if (isTerminated()) {
                Operators.onNextDropped(t10, this.ctx);
                return this;
            }
            if (requestedFromDownstream() != 0) {
                this.actual.onNext(t10);
                BaseSink.produced(this, 1L);
                return this;
            }
            onOverflow();
            Operators.onDiscard(t10, this.ctx);
            return this;
        }

        public abstract void onOverflow();
    }

    public static class SerializeOnRequestSink<T> implements FluxSink<T>, Scannable {
        final BaseSink<T> baseSink;
        SerializedFluxSink<T> serializedSink;
        FluxSink<T> sink;

        public SerializeOnRequestSink(BaseSink<T> baseSink) {
            this.baseSink = baseSink;
            this.sink = baseSink;
        }

        @Override // reactor.core.publisher.FluxSink
        public void complete() {
            this.sink.complete();
        }

        @Override // reactor.core.publisher.FluxSink
        public ContextView contextView() {
            return this.sink.contextView();
        }

        @Override // reactor.core.publisher.FluxSink
        @Deprecated
        public Context currentContext() {
            return this.sink.currentContext();
        }

        @Override // reactor.core.publisher.FluxSink
        public void error(Throwable th) {
            this.sink.error(th);
        }

        @Override // reactor.core.publisher.FluxSink
        public boolean isCancelled() {
            return this.sink.isCancelled();
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> next(T t10) {
            this.sink.next(t10);
            SerializedFluxSink<T> serializedFluxSink = this.serializedSink;
            return serializedFluxSink == null ? this : serializedFluxSink;
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onCancel(Disposable disposable) {
            this.sink.onCancel(disposable);
            return this.sink;
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onDispose(Disposable disposable) {
            this.sink.onDispose(disposable);
            return this;
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onRequest(LongConsumer longConsumer) {
            if (this.serializedSink == null) {
                SerializedFluxSink<T> serializedFluxSink = new SerializedFluxSink<>(this.baseSink);
                this.serializedSink = serializedFluxSink;
                this.sink = serializedFluxSink;
            }
            return this.sink.onRequest(longConsumer);
        }

        @Override // reactor.core.publisher.FluxSink
        public long requestedFromDownstream() {
            return this.sink.requestedFromDownstream();
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            SerializedFluxSink<T> serializedFluxSink = this.serializedSink;
            return serializedFluxSink != null ? serializedFluxSink.scanUnsafe(attr) : this.baseSink.scanUnsafe(attr);
        }

        public String toString() {
            return this.baseSink.toString();
        }
    }

    public static final class SerializedFluxSink<T> implements FluxSink<T>, Scannable {
        static final AtomicReferenceFieldUpdater<SerializedFluxSink, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(SerializedFluxSink.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<SerializedFluxSink> WIP = AtomicIntegerFieldUpdater.newUpdater(SerializedFluxSink.class, "wip");
        volatile boolean done;
        volatile Throwable error;
        final Queue<T> mpscQueue = (Queue) Queues.unboundedMultiproducer().get();
        final BaseSink<T> sink;
        volatile int wip;

        public SerializedFluxSink(BaseSink<T> baseSink) {
            this.sink = baseSink;
        }

        @Override // reactor.core.publisher.FluxSink
        public void complete() {
            if (this.sink.isTerminated() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxSink
        public ContextView contextView() {
            return this.sink.contextView();
        }

        @Override // reactor.core.publisher.FluxSink
        @Deprecated
        public Context currentContext() {
            return this.sink.currentContext();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            Context contextCurrentContext = this.sink.currentContext();
            BaseSink<T> baseSink = this.sink;
            Queue<T> queue = this.mpscQueue;
            while (true) {
                if (baseSink.isCancelled()) {
                    Operators.onDiscardQueueWithClear(queue, contextCurrentContext, null);
                    if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                } else {
                    AtomicReferenceFieldUpdater<SerializedFluxSink, Throwable> atomicReferenceFieldUpdater = ERROR;
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        Operators.onDiscardQueueWithClear(queue, contextCurrentContext, null);
                        baseSink.error(Exceptions.terminate(atomicReferenceFieldUpdater, this));
                        return;
                    }
                    boolean z10 = this.done;
                    T tPoll = queue.poll();
                    boolean z11 = tPoll == null;
                    if (z10 && z11) {
                        baseSink.complete();
                        return;
                    } else if (!z11) {
                        try {
                            baseSink.next(tPoll);
                        } catch (Throwable th) {
                            Operators.onOperatorError(this.sink, th, tPoll, this.sink.currentContext());
                        }
                    } else if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.FluxSink
        public void error(Throwable th) {
            Objects.requireNonNull(th, "t is null in sink.error(t)");
            if (this.sink.isTerminated() || this.done) {
                Operators.onOperatorError(th, this.sink.currentContext());
                return;
            }
            if (Exceptions.addThrowable(ERROR, this, th)) {
                this.done = true;
                drain();
            } else {
                Context contextCurrentContext = this.sink.currentContext();
                Operators.onDiscardQueueWithClear(this.mpscQueue, contextCurrentContext, null);
                Operators.onOperatorError(th, contextCurrentContext);
            }
        }

        @Override // reactor.core.publisher.FluxSink
        public boolean isCancelled() {
            return this.sink.isCancelled();
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        
            if (reactor.core.publisher.FluxCreate.SerializedFluxSink.WIP.decrementAndGet(r3) == 0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        
            if (r0.getAndIncrement(r3) != 0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        
            drainLoop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            return r3;
         */
        @Override // reactor.core.publisher.FluxSink
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public reactor.core.publisher.FluxSink<T> next(T r4) {
            /*
                r3 = this;
                java.lang.String r0 = "t is null in sink.next(t)"
                java.util.Objects.requireNonNull(r4, r0)
                reactor.core.publisher.FluxCreate$BaseSink<T> r0 = r3.sink
                boolean r0 = r0.isTerminated()
                if (r0 != 0) goto L4b
                boolean r0 = r3.done
                if (r0 == 0) goto L12
                goto L4b
            L12:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxCreate$SerializedFluxSink> r0 = reactor.core.publisher.FluxCreate.SerializedFluxSink.WIP
                int r1 = r0.get(r3)
                if (r1 != 0) goto L3b
                r1 = 0
                r2 = 1
                boolean r1 = r0.compareAndSet(r3, r1, r2)
                if (r1 == 0) goto L3b
                reactor.core.publisher.FluxCreate$BaseSink<T> r0 = r3.sink     // Catch: java.lang.Throwable -> L28
                r0.next(r4)     // Catch: java.lang.Throwable -> L28
                goto L32
            L28:
                r0 = move-exception
                reactor.core.publisher.FluxCreate$BaseSink<T> r1 = r3.sink
                reactor.util.context.Context r2 = r1.currentContext()
                reactor.core.publisher.Operators.onOperatorError(r1, r0, r4, r2)
            L32:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater<reactor.core.publisher.FluxCreate$SerializedFluxSink> r4 = reactor.core.publisher.FluxCreate.SerializedFluxSink.WIP
                int r4 = r4.decrementAndGet(r3)
                if (r4 != 0) goto L47
                goto L46
            L3b:
                java.util.Queue<T> r1 = r3.mpscQueue
                r1.offer(r4)
                int r4 = r0.getAndIncrement(r3)
                if (r4 == 0) goto L47
            L46:
                return r3
            L47:
                r3.drainLoop()
                return r3
            L4b:
                reactor.core.publisher.FluxCreate$BaseSink<T> r0 = r3.sink
                reactor.util.context.Context r0 = r0.currentContext()
                reactor.core.publisher.Operators.onNextDropped(r4, r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxCreate.SerializedFluxSink.next(java.lang.Object):reactor.core.publisher.FluxSink");
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onCancel(Disposable disposable) {
            this.sink.onCancel(disposable);
            return this;
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onDispose(Disposable disposable) {
            this.sink.onDispose(disposable);
            return this;
        }

        @Override // reactor.core.publisher.FluxSink
        public FluxSink<T> onRequest(LongConsumer longConsumer) {
            this.sink.onPushPullRequest(longConsumer);
            return this;
        }

        @Override // reactor.core.publisher.FluxSink
        public long requestedFromDownstream() {
            return this.sink.requestedFromDownstream();
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.mpscQueue.size()) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : this.sink.scanUnsafe(attr);
        }

        public String toString() {
            return this.sink.toString();
        }
    }

    public static final class SinkDisposable implements Disposable {
        Disposable disposable;
        Disposable onCancel;

        public SinkDisposable(@Nullable Disposable disposable, @Nullable Disposable disposable2) {
            this.disposable = disposable;
            this.onCancel = disposable2;
        }

        public void cancel() {
            Disposable disposable = this.onCancel;
            if (disposable != null) {
                disposable.dispose();
            }
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Disposable disposable = this.disposable;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public FluxCreate(Consumer<? super FluxSink<T>> consumer, FluxSink.OverflowStrategy overflowStrategy, CreateMode createMode) {
        Objects.requireNonNull(consumer, "source");
        this.source = consumer;
        Objects.requireNonNull(overflowStrategy, "backpressure");
        this.backpressure = overflowStrategy;
        this.createMode = createMode;
    }

    public static <T> BaseSink<T> createSink(CoreSubscriber<? super T> coreSubscriber, FluxSink.OverflowStrategy overflowStrategy) {
        int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxSink$OverflowStrategy[overflowStrategy.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new BufferAsyncSink(coreSubscriber, Queues.SMALL_BUFFER_SIZE) : new LatestAsyncSink(coreSubscriber) : new DropAsyncSink(coreSubscriber) : new ErrorAsyncSink(coreSubscriber) : new IgnoreSink(coreSubscriber);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        BaseSink baseSinkCreateSink = createSink(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, this.backpressure);
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(baseSinkCreateSink);
        try {
            this.source.accept(this.createMode == CreateMode.PUSH_PULL ? new SerializedFluxSink(baseSinkCreateSink) : baseSinkCreateSink);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            baseSinkCreateSink.error(Operators.onOperatorError(th, coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.currentContext()));
        }
    }
}
