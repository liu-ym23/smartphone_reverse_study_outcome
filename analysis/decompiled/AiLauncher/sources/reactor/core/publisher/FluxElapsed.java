package reactor.core.publisher;

import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* loaded from: classes5.dex */
final class FluxElapsed<T> extends InternalFluxOperator<T, Tuple2<Long, T>> implements Fuseable {
    final Scheduler scheduler;

    public static final class ElapsedSubscriber<T> implements InnerOperator<T, Tuple2<Long, T>>, Fuseable.QueueSubscription<Tuple2<Long, T>> {
        final CoreSubscriber<? super Tuple2<Long, T>> actual;
        long lastTime;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39503s;
        final Scheduler scheduler;

        public ElapsedSubscriber(CoreSubscriber<? super Tuple2<Long, T>> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.scheduler = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Tuple2<Long, T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39503s.cancel();
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (t10 == null) {
                this.actual.onNext(null);
            } else {
                this.actual.onNext(snapshot(t10));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39503s, dVar)) {
                this.lastTime = this.scheduler.now(TimeUnit.MILLISECONDS);
                this.f39503s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39503s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            Fuseable.QueueSubscription<T> queueSubscriptionAs = Operators.as(this.f39503s);
            if (queueSubscriptionAs == null) {
                return 0;
            }
            this.qs = queueSubscriptionAs;
            return queueSubscriptionAs.requestFusion(i10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39503s : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
