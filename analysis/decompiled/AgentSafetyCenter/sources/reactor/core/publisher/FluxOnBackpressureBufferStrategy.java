package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnBackpressureBufferStrategy<O> extends InternalFluxOperator<O, O> {
    final BufferOverflowStrategy bufferOverflowStrategy;
    final int bufferSize;
    final boolean delayError;
    final Consumer<? super O> onBufferOverflow;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: reactor.core.publisher.FluxOnBackpressureBufferStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$BufferOverflowStrategy;

        static {
            int[] iArr = new int[BufferOverflowStrategy.values().length];
            $SwitchMap$reactor$core$publisher$BufferOverflowStrategy = iArr;
            try {
                iArr[BufferOverflowStrategy.DROP_OLDEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$BufferOverflowStrategy[BufferOverflowStrategy.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$BufferOverflowStrategy[BufferOverflowStrategy.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BackpressureBufferDropOldestSubscriber<T> extends ArrayDeque<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final Context ctx;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Consumer<? super T> onOverflow;
        final BufferOverflowStrategy overflowStrategy;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10647s;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<BackpressureBufferDropOldestSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(BackpressureBufferDropOldestSubscriber.class, "wip");
        static final AtomicLongFieldUpdater<BackpressureBufferDropOldestSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BackpressureBufferDropOldestSubscriber.class, "requested");

        public BackpressureBufferDropOldestSubscriber(CoreSubscriber<? super T> coreSubscriber, int i, boolean z10, @Nullable Consumer<? super T> consumer, BufferOverflowStrategy bufferOverflowStrategy) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.delayError = z10;
            this.onOverflow = consumer;
            this.overflowStrategy = bufferOverflowStrategy;
            this.bufferSize = i;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f10647s.cancel();
            if (WIP.getAndIncrement(this) == 0) {
                synchronized (this) {
                    clear();
                }
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qd.d dVar) {
            if (this.cancelled) {
                this.f10647s.cancel();
                synchronized (this) {
                    clear();
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    dVar.onError(th);
                } else {
                    dVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                synchronized (this) {
                    clear();
                }
                dVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Operators.onDiscardMultiple(this, this.ctx);
            super.clear();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                if (coreSubscriber != null) {
                    innerDrain(coreSubscriber);
                    return;
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void innerDrain(qd.d dVar) {
            boolean zIsEmpty;
            T tPoll;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (j10 != j11) {
                    boolean z10 = this.done;
                    synchronized (this) {
                        tPoll = poll();
                    }
                    boolean z11 = tPoll == null;
                    if (checkTerminated(z10, z11, dVar)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(tPoll);
                    j11++;
                }
                if (j10 == j11) {
                    synchronized (this) {
                        zIsEmpty = isEmpty();
                    }
                    if (checkTerminated(this.done, zIsEmpty, dVar)) {
                        return;
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    Operators.produced(REQUESTED, this, j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            boolean z10;
            boolean z11;
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            synchronized (this) {
                try {
                    z10 = false;
                    if (size() == this.bufferSize) {
                        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$BufferOverflowStrategy[this.overflowStrategy.ordinal()];
                        z11 = true;
                        if (i == 1) {
                            T tPollFirst = pollFirst();
                            offer(t10);
                            z10 = true;
                            z11 = false;
                            t10 = tPollFirst;
                        } else if (i != 2) {
                            z10 = true;
                        } else {
                            z10 = true;
                            z11 = false;
                        }
                    } else {
                        offer(t10);
                        z11 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z10) {
                Consumer<? super T> consumer = this.onOverflow;
                if (consumer != null) {
                    try {
                        consumer.accept(t10);
                    } catch (Throwable th2) {
                        try {
                            onError(Operators.onOperatorError(this.f10647s, th2, t10, this.ctx));
                            return;
                        } finally {
                            Operators.onDiscard(t10, this.ctx);
                        }
                    }
                }
            }
            if (z11) {
                onError(Operators.onOperatorError(this.f10647s, Exceptions.failWithOverflow(), t10, this.ctx));
            }
            if (z11 || z10) {
                return;
            }
            drain();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10647s, eVar)) {
                this.f10647s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10647s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done && isEmpty());
            }
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.DELAY_ERROR ? Boolean.valueOf(this.delayError) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnBackpressureBufferStrategy(Flux<? extends O> flux, int i, @Nullable Consumer<? super O> consumer, BufferOverflowStrategy bufferOverflowStrategy) {
        super(flux);
        boolean z10 = true;
        if (i < 1) {
            g5.f.s("Buffer Size must be strictly positive");
            throw null;
        }
        this.bufferSize = i;
        this.onBufferOverflow = consumer;
        this.bufferOverflowStrategy = bufferOverflowStrategy;
        if (consumer == null && bufferOverflowStrategy != BufferOverflowStrategy.ERROR) {
            z10 = false;
        }
        this.delayError = z10;
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
    public CoreSubscriber<? super O> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        return new BackpressureBufferDropOldestSubscriber(coreSubscriber, this.bufferSize, this.delayError, this.onBufferOverflow, this.bufferOverflowStrategy);
    }
}
