package qc;

import java.util.Objects;
import java.util.concurrent.Flow;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: qc.a$a, reason: collision with other inner class name */
    public static final class FlowSubscriberC0506a<T> implements Flow.Subscriber<T> {

        /* renamed from: a, reason: collision with root package name */
        public final qc.c<? super T> f38682a;

        public FlowSubscriberC0506a(qc.c<? super T> cVar) {
            this.f38682a = cVar;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f38682a.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th) {
            this.f38682a.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t10) {
            this.f38682a.onNext(t10);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.f38682a.onSubscribe(subscription == null ? null : new d(subscription));
        }
    }

    public static final class b implements Flow.Subscription {

        /* renamed from: a, reason: collision with root package name */
        public final qc.d f38683a;

        public b(qc.d dVar) {
            this.f38683a = dVar;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void cancel() {
            this.f38683a.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j10) {
            this.f38683a.request(j10);
        }
    }

    public static final class c<T> implements qc.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Flow.Subscriber<? super T> f38684a;

        @Override // qc.c
        public void onComplete() {
            this.f38684a.onComplete();
        }

        @Override // qc.c
        public void onError(Throwable th) {
            this.f38684a.onError(th);
        }

        @Override // qc.c
        public void onNext(T t10) {
            this.f38684a.onNext(t10);
        }

        @Override // qc.c
        public void onSubscribe(qc.d dVar) {
            this.f38684a.onSubscribe(dVar == null ? null : new b(dVar));
        }
    }

    public static final class d implements qc.d {

        /* renamed from: a, reason: collision with root package name */
        public final Flow.Subscription f38685a;

        public d(Flow.Subscription subscription) {
            this.f38685a = subscription;
        }

        @Override // qc.d
        public void cancel() {
            this.f38685a.cancel();
        }

        @Override // qc.d
        public void request(long j10) {
            this.f38685a.request(j10);
        }
    }

    public static <T> Flow.Subscriber<T> a(qc.c<T> cVar) {
        Objects.requireNonNull(cVar, "reactiveStreamsSubscriber");
        return cVar instanceof c ? ((c) cVar).f38684a : cVar instanceof Flow.Subscriber ? (Flow.Subscriber) cVar : new FlowSubscriberC0506a(cVar);
    }
}
