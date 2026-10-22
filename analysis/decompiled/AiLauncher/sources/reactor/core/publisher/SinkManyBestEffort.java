package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class SinkManyBestEffort<T> extends Flux<T> implements InternalManySink<T>, Scannable, DirectInnerContainer<T> {
    final boolean allOrNothing;
    Throwable error;
    volatile DirectInner<T>[] subscribers;
    static final DirectInner[] EMPTY = new DirectInner[0];
    static final DirectInner[] TERMINATED = new DirectInner[0];
    static final AtomicReferenceFieldUpdater<SinkManyBestEffort, DirectInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(SinkManyBestEffort.class, DirectInner[].class, "subscribers");

    public static class DirectInner<T> extends AtomicBoolean implements InnerProducer<T> {
        static final AtomicLongFieldUpdater<DirectInner> REQUESTED = AtomicLongFieldUpdater.newUpdater(DirectInner.class, "requested");
        final CoreSubscriber<? super T> actual;
        final DirectInnerContainer<T> parent;
        volatile long requested;

        public DirectInner(CoreSubscriber<? super T> coreSubscriber, DirectInnerContainer<T> directInnerContainer) {
            this.actual = coreSubscriber;
            this.parent = directInnerContainer;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        public void directEmitNext(T t10) {
            if (this.requested == 0) {
                this.parent.remove(this);
                this.actual.onError(Exceptions.failWithOverflow("Can't deliver value due to lack of requests"));
            } else {
                this.actual.onNext(t10);
                if (this.requested != Long.MAX_VALUE) {
                    REQUESTED.decrementAndGet(this);
                }
            }
        }

        public void emitComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        public void emitError(Throwable th) {
            if (isCancelled()) {
                return;
            }
            this.actual.onError(th);
        }

        public boolean isCancelled() {
            return get();
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : super.scanUnsafe(attr);
        }

        public boolean tryEmitNext(T t10) {
            if (this.requested == 0 || isCancelled()) {
                return false;
            }
            this.actual.onNext(t10);
            if (this.requested == Long.MAX_VALUE) {
                return true;
            }
            REQUESTED.decrementAndGet(this);
            return true;
        }
    }

    public SinkManyBestEffort(boolean z10) {
        this.allOrNothing = z10;
        SUBSCRIBERS.lazySet(this, EMPTY);
    }

    public static final <T> SinkManyBestEffort<T> createAllOrNothing() {
        return new SinkManyBestEffort<>(true);
    }

    public static final <T> SinkManyBestEffort<T> createBestEffort() {
        return new SinkManyBestEffort<>(false);
    }

    @Override // reactor.core.publisher.DirectInnerContainer
    public boolean add(DirectInner<T> directInner) {
        DirectInner<T>[] directInnerArr;
        DirectInner[] directInnerArr2;
        if (this.subscribers == TERMINATED) {
            return false;
        }
        do {
            directInnerArr = this.subscribers;
            if (directInnerArr == TERMINATED) {
                return false;
            }
            int length = directInnerArr.length;
            directInnerArr2 = new DirectInner[length + 1];
            System.arraycopy(directInnerArr, 0, directInnerArr2, 0, length);
            directInnerArr2[length] = directInner;
        } while (!SUBSCRIBERS.compareAndSet(this, directInnerArr, directInnerArr2));
        return true;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }

    @Override // reactor.core.publisher.ContextHolder
    public Context currentContext() {
        return Operators.multiSubscribersContext(this.subscribers);
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.subscribers.length;
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.of((Object[]) this.subscribers);
    }

    @Override // reactor.core.publisher.DirectInnerContainer
    public void remove(DirectInner<T> directInner) {
        DirectInner<T>[] directInnerArr;
        DirectInner[] directInnerArr2;
        DirectInner<T>[] directInnerArr3 = this.subscribers;
        if (directInnerArr3 == TERMINATED || directInnerArr3 == EMPTY) {
            return;
        }
        do {
            directInnerArr = this.subscribers;
            if (directInnerArr == TERMINATED || directInnerArr == EMPTY) {
                return;
            }
            int length = directInnerArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (directInnerArr[i10] == directInner) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                directInnerArr2 = EMPTY;
            } else {
                DirectInner[] directInnerArr4 = new DirectInner[length - 1];
                System.arraycopy(directInnerArr, 0, directInnerArr4, 0, i10);
                System.arraycopy(directInnerArr, i10 + 1, directInnerArr4, i10, (length - i10) - 1);
                directInnerArr2 = directInnerArr4;
            }
        } while (!SUBSCRIBERS.compareAndSet(this, directInnerArr, directInnerArr2));
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED) {
            return Boolean.valueOf(this.subscribers == TERMINATED);
        }
        if (attr == Scannable.Attr.ERROR) {
            return this.error;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe(null) is forbidden");
        CoreSubscriber coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        DirectInner<T> directInner = new DirectInner<>(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, this);
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(directInner);
        if (directInner.isCancelled()) {
            return;
        }
        if (add(directInner)) {
            if (directInner.isCancelled()) {
                remove(directInner);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onError(th);
            } else {
                coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onComplete();
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitComplete() {
        AtomicReferenceFieldUpdater<SinkManyBestEffort, DirectInner[]> atomicReferenceFieldUpdater = SUBSCRIBERS;
        DirectInner[] directInnerArr = TERMINATED;
        DirectInner[] andSet = atomicReferenceFieldUpdater.getAndSet(this, directInnerArr);
        if (andSet == directInnerArr) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        for (DirectInner directInner : andSet) {
            directInner.emitComplete();
        }
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitError(Throwable th) {
        Objects.requireNonNull(th, "tryEmitError(null) is forbidden");
        AtomicReferenceFieldUpdater<SinkManyBestEffort, DirectInner[]> atomicReferenceFieldUpdater = SUBSCRIBERS;
        DirectInner[] directInnerArr = TERMINATED;
        DirectInner[] andSet = atomicReferenceFieldUpdater.getAndSet(this, directInnerArr);
        if (andSet == directInnerArr) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.error = th;
        for (DirectInner directInner : andSet) {
            directInner.emitError(th);
        }
        return Sinks.EmitResult.OK;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    @Override // reactor.core.publisher.Sinks.Many
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public reactor.core.publisher.Sinks.EmitResult tryEmitNext(T r12) {
        /*
            r11 = this;
            java.lang.String r0 = "tryEmitNext(null) is forbidden"
            java.util.Objects.requireNonNull(r12, r0)
            reactor.core.publisher.SinkManyBestEffort$DirectInner<T>[] r0 = r11.subscribers
            reactor.core.publisher.SinkManyBestEffort$DirectInner[] r1 = reactor.core.publisher.SinkManyBestEffort.EMPTY
            if (r0 != r1) goto Le
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER
            return r11
        Le:
            reactor.core.publisher.SinkManyBestEffort$DirectInner[] r1 = reactor.core.publisher.SinkManyBestEffort.TERMINATED
            if (r0 != r1) goto L15
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_TERMINATED
            return r11
        L15:
            int r1 = r0.length
            boolean r2 = r11.allOrNothing
            r3 = 0
            if (r2 == 0) goto L48
            int r2 = r0.length
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r3
            r7 = r6
        L23:
            if (r6 >= r2) goto L3a
            r8 = r0[r6]
            long r9 = r8.requested
            boolean r8 = r8.isCancelled()
            if (r8 == 0) goto L32
            int r7 = r7 + 1
            goto L37
        L32:
            int r8 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r8 >= 0) goto L37
            r4 = r9
        L37:
            int r6 = r6 + 1
            goto L23
        L3a:
            r8 = 0
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L43
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_OVERFLOW
            return r11
        L43:
            if (r7 != r1) goto L48
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER
            return r11
        L48:
            int r2 = r0.length
            r4 = r3
            r5 = r4
        L4b:
            if (r3 >= r2) goto L6b
            r6 = r0[r3]
            boolean r7 = r6.isCancelled()
            if (r7 == 0) goto L58
        L55:
            int r4 = r4 + 1
            goto L68
        L58:
            boolean r7 = r6.tryEmitNext(r12)
            if (r7 == 0) goto L61
            int r5 = r5 + 1
            goto L68
        L61:
            boolean r6 = r6.isCancelled()
            if (r6 == 0) goto L68
            goto L55
        L68:
            int r3 = r3 + 1
            goto L4b
        L6b:
            if (r4 != r1) goto L70
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER
            return r11
        L70:
            int r4 = r4 + r5
            if (r4 != r1) goto L76
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.OK
            return r11
        L76:
            if (r5 <= 0) goto L7f
            boolean r11 = r11.allOrNothing
            if (r11 != 0) goto L7f
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.OK
            return r11
        L7f:
            reactor.core.publisher.Sinks$EmitResult r11 = reactor.core.publisher.Sinks.EmitResult.FAIL_OVERFLOW
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.SinkManyBestEffort.tryEmitNext(java.lang.Object):reactor.core.publisher.Sinks$EmitResult");
    }
}
