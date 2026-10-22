package reactor.core.publisher;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoPublishOn<T> extends InternalMonoOperator<T, T> {
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PublishOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        static final AtomicReferenceFieldUpdater<PublishOnSubscriber, Disposable> FUTURE = AtomicReferenceFieldUpdater.newUpdater(PublishOnSubscriber.class, Disposable.class, "future");
        static final AtomicReferenceFieldUpdater<PublishOnSubscriber, Object> VALUE = AtomicReferenceFieldUpdater.newUpdater(PublishOnSubscriber.class, Object.class, "value");
        final CoreSubscriber<? super T> actual;
        volatile Throwable error;
        volatile Disposable future;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10733s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
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
            this.f10733s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.value == null) {
                trySchedule(null, null, null);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.error = th;
            trySchedule(null, th, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.value = t10;
            trySchedule(this, null, t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10733s, eVar)) {
                this.f10733s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10733s.request(j10);
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
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.future == OperatorDisposables.DISPOSED);
            }
            return attr == Scannable.Attr.PARENT ? this.f10733s : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void trySchedule(@Nullable qd.e eVar, @Nullable Throwable th, @Nullable Object obj) {
            if (this.future != null) {
                return;
            }
            try {
                this.future = this.scheduler.schedule(this);
            } catch (RejectedExecutionException e10) {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e10, eVar, th, obj, coreSubscriber.currentContext()));
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
