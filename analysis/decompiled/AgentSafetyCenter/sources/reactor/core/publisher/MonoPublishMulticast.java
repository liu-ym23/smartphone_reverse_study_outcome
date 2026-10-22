package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPublishMulticast;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoPublishMulticast<T, R> extends InternalMonoOperator<T, R> implements Fuseable {
    final Function<? super Mono<T>, ? extends Mono<? extends R>> transform;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MonoPublishMulticaster<T> extends Mono<T> implements InnerConsumer<T>, FluxPublishMulticast.PublishMulticasterParent {
        volatile boolean connected;
        final Context context;
        volatile boolean done;
        Throwable error;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10732s;
        volatile PublishMulticastInner<T>[] subscribers;

        @Nullable
        T value;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<MonoPublishMulticaster, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(MonoPublishMulticaster.class, qd.e.class, "s");
        static final AtomicIntegerFieldUpdater<MonoPublishMulticaster> WIP = AtomicIntegerFieldUpdater.newUpdater(MonoPublishMulticaster.class, "wip");
        static final AtomicReferenceFieldUpdater<MonoPublishMulticaster, PublishMulticastInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(MonoPublishMulticaster.class, PublishMulticastInner[].class, "subscribers");
        static final PublishMulticastInner[] EMPTY = new PublishMulticastInner[0];
        static final PublishMulticastInner[] TERMINATED = new PublishMulticastInner[0];

        public MonoPublishMulticaster(Context context) {
            SUBSCRIBERS.lazySet(this, EMPTY);
            this.context = context;
        }

        public boolean add(PublishMulticastInner<T> publishMulticastInner) {
            PublishMulticastInner<T>[] publishMulticastInnerArr;
            PublishMulticastInner[] publishMulticastInnerArr2;
            do {
                publishMulticastInnerArr = this.subscribers;
                if (publishMulticastInnerArr == TERMINATED) {
                    return false;
                }
                int length = publishMulticastInnerArr.length;
                publishMulticastInnerArr2 = new PublishMulticastInner[length + 1];
                System.arraycopy(publishMulticastInnerArr, 0, publishMulticastInnerArr2, 0, length);
                publishMulticastInnerArr2[length] = publishMulticastInner;
            } while (!SUBSCRIBERS.compareAndSet(this, publishMulticastInnerArr, publishMulticastInnerArr2));
            return true;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                if (this.connected) {
                    if (this.f10732s == Operators.cancelledSubscription()) {
                        this.value = null;
                        return;
                    }
                    T t10 = this.value;
                    if (this.subscribers.length != 0) {
                        if (this.f10732s == Operators.cancelledSubscription()) {
                            this.value = null;
                            return;
                        }
                        PublishMulticastInner[] andSet = SUBSCRIBERS.getAndSet(this, TERMINATED);
                        int length = andSet.length;
                        Throwable th = this.error;
                        int i = 0;
                        if (th != null) {
                            while (i < length) {
                                andSet[i].actual.onError(th);
                                i++;
                            }
                            return;
                        } else if (t10 == null) {
                            while (i < length) {
                                andSet[i].actual.onComplete();
                                i++;
                            }
                            return;
                        } else {
                            while (i < length) {
                                andSet[i].actual.onNext(t10);
                                andSet[i].actual.onComplete();
                                i++;
                            }
                            this.value = null;
                            return;
                        }
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.context);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.context);
                return;
            }
            this.value = t10;
            this.done = true;
            drain();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                this.connected = true;
                eVar.request(Long.MAX_VALUE);
            }
        }

        public void remove(PublishMulticastInner<T> publishMulticastInner) {
            PublishMulticastInner<T>[] publishMulticastInnerArr;
            PublishMulticastInner[] publishMulticastInnerArr2;
            do {
                publishMulticastInnerArr = this.subscribers;
                if (publishMulticastInnerArr == TERMINATED || publishMulticastInnerArr == EMPTY) {
                    return;
                }
                int length = publishMulticastInnerArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (publishMulticastInnerArr[i] == publishMulticastInner) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    publishMulticastInnerArr2 = EMPTY;
                } else {
                    PublishMulticastInner[] publishMulticastInnerArr3 = new PublishMulticastInner[length - 1];
                    System.arraycopy(publishMulticastInnerArr, 0, publishMulticastInnerArr3, 0, i);
                    System.arraycopy(publishMulticastInnerArr, i + 1, publishMulticastInnerArr3, i, (length - i) - 1);
                    publishMulticastInnerArr2 = publishMulticastInnerArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, publishMulticastInnerArr, publishMulticastInnerArr2));
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10732s;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10732s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return 1;
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.value != null ? 1 : 0);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            PublishMulticastInner<T> publishMulticastInner = new PublishMulticastInner<>(this, coreSubscriber);
            coreSubscriber.onSubscribe(publishMulticastInner);
            if (add(publishMulticastInner)) {
                if (publishMulticastInner.cancelled == 1) {
                    remove(publishMulticastInner);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            Throwable th = this.error;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.publisher.FluxPublishMulticast.PublishMulticasterParent
        public void terminate() {
            Operators.terminate(S, this);
            if (WIP.getAndIncrement(this) == 0 && this.connected) {
                this.value = null;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PublishMulticastInner<T> implements InnerProducer<T> {
        static final AtomicIntegerFieldUpdater<PublishMulticastInner> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(PublishMulticastInner.class, "cancelled");
        final CoreSubscriber<? super T> actual;
        volatile int cancelled;
        final MonoPublishMulticaster<T> parent;

        public PublishMulticastInner(MonoPublishMulticaster<T> monoPublishMulticaster, CoreSubscriber<? super T> coreSubscriber) {
            this.parent = monoPublishMulticaster;
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.parent.drain();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoPublishMulticast(Mono<? extends T> mono, Function<? super Mono<T>, ? extends Mono<? extends R>> function) {
        super(mono);
        Objects.requireNonNull(function, "transform");
        this.transform = function;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        MonoPublishMulticaster monoPublishMulticaster = new MonoPublishMulticaster(coreSubscriber.currentContext());
        Mono<? extends R> monoApply = this.transform.apply(Mono.fromDirect(monoPublishMulticaster));
        Objects.requireNonNull(monoApply, "The transform returned a null Mono");
        Mono monoFromDirect = Mono.fromDirect(monoApply);
        if (monoFromDirect instanceof Fuseable) {
            monoFromDirect.subscribe((CoreSubscriber) new FluxPublishMulticast.CancelFuseableMulticaster(coreSubscriber, monoPublishMulticaster));
            return monoPublishMulticaster;
        }
        monoFromDirect.subscribe((CoreSubscriber) new FluxPublishMulticast.CancelMulticaster(coreSubscriber, monoPublishMulticaster));
        return monoPublishMulticaster;
    }
}
