package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.SinkManyBestEffort;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
public final class DirectProcessor<T> extends FluxProcessor<T, T> implements DirectInnerContainer<T> {
    private static final AtomicReferenceFieldUpdater<DirectProcessor, SinkManyBestEffort.DirectInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(DirectProcessor.class, SinkManyBestEffort.DirectInner[].class, "subscribers");
    Throwable error;
    private volatile SinkManyBestEffort.DirectInner<T>[] subscribers = SinkManyBestEffort.EMPTY;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: reactor.core.publisher.DirectProcessor$1, reason: invalid class name */
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
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.OK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Deprecated
    public static <E> DirectProcessor<E> create() {
        return new DirectProcessor<>();
    }

    private void emitComplete() {
        tryEmitComplete();
    }

    private void emitError(Throwable th) {
        if (tryEmitError(th) == Sinks.EmitResult.FAIL_TERMINATED) {
            Operators.onErrorDroppedMulticast(th, this.subscribers);
        }
    }

    private void emitNext(T t10) {
        int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[tryEmitNext(t10).ordinal()];
        if (i != 1) {
            if (i == 2) {
                Operators.onDiscard(t10, currentContext());
                emitError(Exceptions.failWithOverflow("Backpressure overflow during Sinks.Many#emitNext"));
            } else if (i == 3) {
                Operators.onDiscard(t10, currentContext());
            } else if (i == 4) {
                Operators.onNextDroppedMulticast(t10, this.subscribers);
            } else {
                if (i == 5) {
                    return;
                }
                od.f.e("unexpected return code");
            }
        }
    }

    private Sinks.EmitResult tryEmitComplete() {
        AtomicReferenceFieldUpdater<DirectProcessor, SinkManyBestEffort.DirectInner[]> atomicReferenceFieldUpdater = SUBSCRIBERS;
        SinkManyBestEffort.DirectInner[] directInnerArr = SinkManyBestEffort.TERMINATED;
        SinkManyBestEffort.DirectInner[] andSet = atomicReferenceFieldUpdater.getAndSet(this, directInnerArr);
        if (andSet == directInnerArr) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        for (SinkManyBestEffort.DirectInner directInner : andSet) {
            directInner.emitComplete();
        }
        return Sinks.EmitResult.OK;
    }

    private Sinks.EmitResult tryEmitError(Throwable th) {
        Objects.requireNonNull(th, "t");
        AtomicReferenceFieldUpdater<DirectProcessor, SinkManyBestEffort.DirectInner[]> atomicReferenceFieldUpdater = SUBSCRIBERS;
        SinkManyBestEffort.DirectInner[] directInnerArr = SinkManyBestEffort.TERMINATED;
        SinkManyBestEffort.DirectInner[] andSet = atomicReferenceFieldUpdater.getAndSet(this, directInnerArr);
        if (andSet == directInnerArr) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.error = th;
        for (SinkManyBestEffort.DirectInner directInner : andSet) {
            directInner.emitError(th);
        }
        return Sinks.EmitResult.OK;
    }

    private Sinks.EmitResult tryEmitNext(T t10) {
        Objects.requireNonNull(t10, "t");
        SinkManyBestEffort.DirectInner<T>[] directInnerArr = this.subscribers;
        if (directInnerArr == SinkManyBestEffort.TERMINATED) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (directInnerArr == SinkManyBestEffort.EMPTY) {
            return Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
        }
        for (SinkManyBestEffort.DirectInner<T> directInner : directInnerArr) {
            directInner.directEmitNext(t10);
        }
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.DirectInnerContainer
    public boolean add(SinkManyBestEffort.DirectInner<T> directInner) {
        SinkManyBestEffort.DirectInner<T>[] directInnerArr = this.subscribers;
        SinkManyBestEffort.DirectInner<T>[] directInnerArr2 = SinkManyBestEffort.TERMINATED;
        if (directInnerArr == directInnerArr2) {
            return false;
        }
        synchronized (this) {
            try {
                SinkManyBestEffort.DirectInner<T>[] directInnerArr3 = this.subscribers;
                if (directInnerArr3 == directInnerArr2) {
                    return false;
                }
                int length = directInnerArr3.length;
                SinkManyBestEffort.DirectInner<T>[] directInnerArr4 = new SinkManyBestEffort.DirectInner[length + 1];
                System.arraycopy(directInnerArr3, 0, directInnerArr4, 0, length);
                directInnerArr4[length] = directInner;
                this.subscribers = directInnerArr4;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        return Operators.multiSubscribersContext(this.subscribers);
    }

    @Override // reactor.core.publisher.FluxProcessor
    public long downstreamCount() {
        return this.subscribers.length;
    }

    @Override // reactor.core.publisher.FluxProcessor
    @Nullable
    public Throwable getError() {
        if (this.subscribers == SinkManyBestEffort.TERMINATED) {
            return this.error;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean hasDownstreams() {
        SinkManyBestEffort.DirectInner<T>[] directInnerArr = this.subscribers;
        return (directInnerArr == SinkManyBestEffort.EMPTY || directInnerArr == SinkManyBestEffort.TERMINATED) ? false : true;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.of((Object[]) this.subscribers);
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isIdentityProcessor() {
        return true;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return SinkManyBestEffort.TERMINATED == this.subscribers;
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onComplete() {
        tryEmitComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onError(Throwable th) {
        emitError(th);
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onNext(T t10) {
        emitNext(t10);
    }

    @Override // qd.d
    public void onSubscribe(qd.e eVar) {
        Objects.requireNonNull(eVar, "s");
        if (this.subscribers != SinkManyBestEffort.TERMINATED) {
            eVar.request(Long.MAX_VALUE);
        } else {
            eVar.cancel();
        }
    }

    @Override // reactor.core.publisher.DirectInnerContainer
    public void remove(SinkManyBestEffort.DirectInner<T> directInner) {
        SinkManyBestEffort.DirectInner<T>[] directInnerArr;
        SinkManyBestEffort.DirectInner<T>[] directInnerArr2 = this.subscribers;
        SinkManyBestEffort.DirectInner<T>[] directInnerArr3 = SinkManyBestEffort.TERMINATED;
        if (directInnerArr2 == directInnerArr3 || directInnerArr2 == (directInnerArr = SinkManyBestEffort.EMPTY)) {
            return;
        }
        synchronized (this) {
            try {
                SinkManyBestEffort.DirectInner<T>[] directInnerArr4 = this.subscribers;
                if (directInnerArr4 != directInnerArr3 && directInnerArr4 != directInnerArr) {
                    int length = directInnerArr4.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (directInnerArr4[i] != directInner) {
                            i++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.subscribers = SinkManyBestEffort.EMPTY;
                        return;
                    }
                    SinkManyBestEffort.DirectInner<T>[] directInnerArr5 = new SinkManyBestEffort.DirectInner[length - 1];
                    System.arraycopy(directInnerArr4, 0, directInnerArr5, 0, i);
                    System.arraycopy(directInnerArr4, i + 1, directInnerArr5, i, (length - i) - 1);
                    this.subscribers = directInnerArr5;
                }
            } finally {
            }
        }
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        SinkManyBestEffort.DirectInner<T> directInner = new SinkManyBestEffort.DirectInner<>(coreSubscriber, this);
        coreSubscriber.onSubscribe(directInner);
        if (add(directInner)) {
            if (directInner.isCancelled()) {
                remove(directInner);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
        }
    }
}
