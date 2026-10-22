package reactor.adapter;

import java.util.concurrent.Flow;
import qc.b;
import qc.c;
import qc.d;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Flux;

/* loaded from: classes5.dex */
public abstract class JdkFlowAdapter {

    public static class FlowPublisherAsFlux<T> extends Flux<T> implements Scannable {
        private final Flow.Publisher<T> pub;

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return null;
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            this.pub.subscribe(new SubscriberToRS(coreSubscriber));
        }

        private FlowPublisherAsFlux(Flow.Publisher<T> publisher) {
            this.pub = publisher;
        }
    }

    public static class FlowSubscriber<T> implements CoreSubscriber<T>, Flow.Subscription {
        private final Flow.Subscriber<? super T> subscriber;
        d subscription;

        public FlowSubscriber(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.subscriber.onComplete();
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.subscriber.onError(th);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.subscriber.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(d dVar) {
            this.subscription = dVar;
            this.subscriber.onSubscribe(this);
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j10) {
            this.subscription.request(j10);
        }
    }

    public static class PublisherAsFlowPublisher<T> implements Flow.Publisher<T> {
        private final b<T> pub;

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.pub.subscribe(new FlowSubscriber(subscriber));
        }

        private PublisherAsFlowPublisher(b<T> bVar) {
            this.pub = bVar;
        }
    }

    public static class SubscriberToRS<T> implements Flow.Subscriber<T>, d {

        /* renamed from: s, reason: collision with root package name */
        private final c<? super T> f39440s;
        Flow.Subscription subscription;

        public SubscriberToRS(c<? super T> cVar) {
            this.f39440s = cVar;
        }

        @Override // qc.d
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f39440s.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th) {
            this.f39440s.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t10) {
            this.f39440s.onNext(t10);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.f39440s.onSubscribe(this);
        }

        @Override // qc.d
        public void request(long j10) {
            this.subscription.request(j10);
        }
    }

    public static <T> Flux<T> flowPublisherToFlux(Flow.Publisher<T> publisher) {
        return new FlowPublisherAsFlux(publisher);
    }

    public static <T> Flow.Publisher<T> publisherToFlowPublisher(b<T> bVar) {
        return new PublisherAsFlowPublisher(bVar);
    }
}
