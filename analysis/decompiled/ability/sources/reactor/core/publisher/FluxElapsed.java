package reactor.core.publisher;

import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* loaded from: classes4.dex */
final class FluxElapsed<T> extends InternalFluxOperator<T, Tuple2<Long, T>> implements Fuseable {
    final Scheduler scheduler;

    public static final class ElapsedSubscriber<T> implements InnerOperator<T, Tuple2<Long, T>>, Fuseable.QueueSubscription<Tuple2<Long, T>> {
        final CoreSubscriber<? super Tuple2<Long, T>> actual;
        long lastTime;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5733s;
        final Scheduler scheduler;

        public ElapsedSubscriber(CoreSubscriber<? super Tuple2<Long, T>> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.scheduler = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Tuple2<Long, T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5733s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (t9 == null) {
                this.actual.onNext(null);
            } else {
                this.actual.onNext(snapshot(t9));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5733s, eVar)) {
                this.lastTime = this.scheduler.now(TimeUnit.MILLISECONDS);
                this.f5733s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5733s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscriptionAs = Operators.as(this.f5733s);
            if (queueSubscriptionAs == null) {
                return 0;
            }
            this.qs = queueSubscriptionAs;
            return queueSubscriptionAs.requestFusion(i);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5733s : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }

        public Tuple2<Long, T> snapshot(T t9) {
            long jNow = this.scheduler.now(TimeUnit.MILLISECONDS);
            long j5 = this.lastTime;
            this.lastTime = jNow;
            return Tuples.of(Long.valueOf(jNow - j5), t9);
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
