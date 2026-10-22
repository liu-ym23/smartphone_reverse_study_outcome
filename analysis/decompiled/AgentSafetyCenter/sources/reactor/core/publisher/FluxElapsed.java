package reactor.core.publisher;

import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxElapsed<T> extends InternalFluxOperator<T, Tuple2<Long, T>> implements Fuseable {
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ElapsedSubscriber<T> implements InnerOperator<T, Tuple2<Long, T>>, Fuseable.QueueSubscription<Tuple2<Long, T>> {
        final CoreSubscriber<? super Tuple2<Long, T>> actual;
        long lastTime;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10615s;
        final Scheduler scheduler;

        public ElapsedSubscriber(CoreSubscriber<? super Tuple2<Long, T>> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.scheduler = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Tuple2<Long, T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10615s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            CoreSubscriber<? super Tuple2<Long, T>> coreSubscriber = this.actual;
            if (t10 == null) {
                coreSubscriber.onNext(null);
            } else {
                coreSubscriber.onNext(snapshot(t10));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10615s, eVar)) {
                this.lastTime = this.scheduler.now(TimeUnit.MILLISECONDS);
                this.f10615s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public Tuple2<Long, T> poll() {
            T tPoll = this.qs.poll();
            if (tPoll != null) {
                return snapshot(tPoll);
            }
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10615s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscriptionAs = Operators.as(this.f10615s);
            if (queueSubscriptionAs == null) {
                return 0;
            }
            this.qs = queueSubscriptionAs;
            return queueSubscriptionAs.requestFusion(i);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10615s : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }

        public Tuple2<Long, T> snapshot(T t10) {
            long jNow = this.scheduler.now(TimeUnit.MILLISECONDS);
            long j10 = this.lastTime;
            this.lastTime = jNow;
            return Tuples.of(Long.valueOf(jNow - j10), t10);
        }
    }

    public FluxElapsed(Flux<T> flux, Scheduler scheduler) {
        super(flux);
        this.scheduler = scheduler;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Tuple2<Long, T>> coreSubscriber) {
        return new ElapsedSubscriber(coreSubscriber, this.scheduler);
    }
}
