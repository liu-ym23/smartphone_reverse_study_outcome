package reactor.core.publisher;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoPublishOn<T> extends InternalMonoOperator<T, T> {
    final Scheduler scheduler;

    public static final class PublishOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        static final AtomicReferenceFieldUpdater<PublishOnSubscriber, Disposable> FUTURE = AtomicReferenceFieldUpdater.newUpdater(PublishOnSubscriber.class, Disposable.class, "future");
        static final AtomicReferenceFieldUpdater<PublishOnSubscriber, Object> VALUE = AtomicReferenceFieldUpdater.newUpdater(PublishOnSubscriber.class, Object.class, "value");
        final CoreSubscriber<? super T> actual;
        volatile Throwable error;
        volatile Disposable future;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5859s;
        final Scheduler scheduler;
        volatile T value;

        public PublishOnSubscriber(CoreSubscriber<? super T> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.scheduler = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Disposable disposable = this.future;
            Disposable disposable2 = OperatorDisposables.DISPOSED;
            if (disposable != disposable2) {
                Disposable andSet = FUTURE.getAndSet(this, disposable2);
                if (andSet != null && !OperatorDisposables.isDisposed(andSet)) {
                    andSet.dispose();
                }
                this.value = null;
            }
            this.f5859s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.value == null) {
                trySchedule(null, null, null);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.error = th;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.value = t9;
            trySchedule(this, null, t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5859s, eVar)) {
                this.f5859s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5859s.request(j5);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OperatorDisposables.isDisposed(this.future)) {
                return;
            }
            Object andSet = VALUE.getAndSet(this, null);
            if (andSet != null) {
                this.actual.onNext(andSet);
                this.actual.onComplete();
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.future == OperatorDisposables.DISPOSED);
            }
            return attr == Scannable.Attr.PARENT ? this.f5859s : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void trySchedule(@Nullable Z9.e eVar, @Nullable Throwable th, @Nullable Object obj) {
            if (this.future != null) {
                return;
            }
            try {
                this.future = this.scheduler.schedule(this);
            } catch (RejectedExecutionException e) {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e, eVar, th, obj, coreSubscriber.currentContext()));
            }
        }
    }

    public MonoPublishOn(Mono<? extends T> mono, Scheduler scheduler) {
        super(mono);
        this.scheduler = scheduler;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new PublishOnSubscriber(coreSubscriber, this.scheduler);
    }
}
