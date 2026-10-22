package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSubscribeOnCallable<T> extends Flux<T> implements Fuseable, Scannable {
    final Callable<? extends T> callable;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CallableSubscribeOnSubscription<T> implements Fuseable.QueueSubscription<T>, InnerProducer<T>, Runnable {
        static final int COMPLETE = 3;
        static final int HAS_CANCELLED = 4;
        static final int HAS_REQUEST_HAS_VALUE = 3;
        static final int HAS_REQUEST_NO_VALUE = 2;
        static final int HAS_VALUE = 2;
        static final int NO_REQUEST_HAS_VALUE = 1;
        static final int NO_VALUE = 1;
        final CoreSubscriber<? super T> actual;
        final Callable<? extends T> callable;
        int fusionState;
        volatile Disposable mainFuture;
        volatile Disposable requestFuture;
        final Scheduler scheduler;
        volatile int state;
        T value;
        static final AtomicIntegerFieldUpdater<CallableSubscribeOnSubscription> STATE = AtomicIntegerFieldUpdater.newUpdater(CallableSubscribeOnSubscription.class, "state");
        static final AtomicReferenceFieldUpdater<CallableSubscribeOnSubscription, Disposable> MAIN_FUTURE = AtomicReferenceFieldUpdater.newUpdater(CallableSubscribeOnSubscription.class, Disposable.class, "mainFuture");
        static final AtomicReferenceFieldUpdater<CallableSubscribeOnSubscription, Disposable> REQUEST_FUTURE = AtomicReferenceFieldUpdater.newUpdater(CallableSubscribeOnSubscription.class, Disposable.class, "requestFuture");

        public CallableSubscribeOnSubscription(CoreSubscriber<? super T> coreSubscriber, Callable<? extends T> callable, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.callable = callable;
            this.scheduler = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void cancel() {
            Disposable andSet;
            Disposable andSet2;
            this.state = 4;
            this.fusionState = 3;
            Disposable disposable = this.mainFuture;
            Disposable disposable2 = OperatorDisposables.DISPOSED;
            if (disposable != disposable2 && (andSet2 = MAIN_FUTURE.getAndSet(this, disposable2)) != null && andSet2 != disposable2) {
                andSet2.dispose();
            }
            if (this.requestFuture == disposable2 || (andSet = REQUEST_FUTURE.getAndSet(this, disposable2)) == null || andSet == disposable2) {
                return;
            }
            andSet.dispose();
        }

        @Override // java.util.Collection
        public void clear() {
            this.value = null;
            this.fusionState = 3;
        }

        public void emitValue() {
            if (this.fusionState == 1) {
                this.fusionState = 2;
            }
            T t10 = this.value;
            clear();
            if (t10 != null) {
                this.actual.onNext(t10);
            }
            if (this.state != 4) {
                this.actual.onComplete();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.fusionState == 3;
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            if (this.fusionState != 2) {
                return null;
            }
            this.fusionState = 3;
            return this.value;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            int i;
            if (Operators.validate(j10)) {
                do {
                    i = this.state;
                    if (i == 4 || i == 2 || i == 3) {
                        return;
                    }
                    if (i == 1) {
                        if (STATE.compareAndSet(this, i, 3)) {
                            try {
                                Scheduler scheduler = this.scheduler;
                                h0 h0Var = new h0(2);
                                h0Var.f10799f = this;
                                VarHandle.storeStoreFence();
                                setRequestFuture(scheduler.schedule(h0Var));
                                return;
                            } catch (RejectedExecutionException e10) {
                                CoreSubscriber<? super T> coreSubscriber = this.actual;
                                coreSubscriber.onError(Operators.onRejectedExecution(e10, coreSubscriber.currentContext()));
                                return;
                            }
                        }
                        return;
                    }
                } while (!STATE.compareAndSet(this, i, 2));
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 2) == 0 || (i & 4) != 0) {
                return 0;
            }
            this.fusionState = 1;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            try {
                T tCall = this.callable.call();
                if (tCall == null) {
                    this.fusionState = 3;
                    this.actual.onComplete();
                    return;
                }
                do {
                    i = this.state;
                    if (i == 4 || i == 3 || i == 1) {
                        return;
                    }
                    if (i == 2) {
                        if (this.fusionState == 1) {
                            this.value = tCall;
                            this.fusionState = 2;
                        }
                        this.actual.onNext(tCall);
                        if (this.state != 4) {
                            this.actual.onComplete();
                            return;
                        }
                        return;
                    }
                    this.value = tCall;
                } while (!STATE.compareAndSet(this, i, 1));
            } catch (Throwable th) {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(this, th, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.state == 4);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.value != null ? 1 : 0);
            }
            return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void setMainFuture(Disposable disposable) {
            Disposable disposable2;
            do {
                disposable2 = this.mainFuture;
                if (disposable2 == OperatorDisposables.DISPOSED) {
                    disposable.dispose();
                    return;
                }
            } while (!MAIN_FUTURE.compareAndSet(this, disposable2, disposable));
        }

        public void setRequestFuture(Disposable disposable) {
            Disposable disposable2;
            do {
                disposable2 = this.requestFuture;
                if (disposable2 == OperatorDisposables.DISPOSED) {
                    disposable.dispose();
                    return;
                }
            } while (!REQUEST_FUTURE.compareAndSet(this, disposable2, disposable));
        }

        @Override // java.util.Collection
        public int size() {
            return !isEmpty() ? 1 : 0;
        }
    }

    public FluxSubscribeOnCallable(Callable<? extends T> callable, Scheduler scheduler) {
        Objects.requireNonNull(callable, "callable");
        this.callable = callable;
        Objects.requireNonNull(scheduler, "scheduler");
        this.scheduler = scheduler;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_ON) {
            return this.scheduler;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.ASYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        CallableSubscribeOnSubscription callableSubscribeOnSubscription = new CallableSubscribeOnSubscription(coreSubscriber, this.callable, this.scheduler);
        coreSubscriber.onSubscribe(callableSubscribeOnSubscription);
        try {
            callableSubscribeOnSubscription.setMainFuture(this.scheduler.schedule(callableSubscribeOnSubscription));
        } catch (RejectedExecutionException e10) {
            if (callableSubscribeOnSubscription.state != 4) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, coreSubscriber.currentContext()));
            }
        }
    }
}
