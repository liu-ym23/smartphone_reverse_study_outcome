package reactor.adapter;

import Z9.c;
import Z9.d;
import Z9.e;
import java.util.concurrent.Flow;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Flux;

/* loaded from: classes4.dex */
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
        e subscription;

        public FlowSubscriber(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.subscriber.onComplete();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.subscriber.onError(th);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.subscriber.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(e eVar) {
            this.subscription = eVar;
            this.subscriber.onSubscribe(this);
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j5) {
            this.subscription.request(j5);
        }
    }

    public static class PublisherAsFlowPublisher<T> implements Flow.Publisher<T> {
        private final c pub;

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.pub.subscribe(new FlowSubscriber(subscriber));
        }

        private PublisherAsFlowPublisher(c cVar) {
            this.pub = cVar;
        }
    }

    public static class SubscriberToRS<T> implements Flow.Subscriber<T>, e {

        /* renamed from: s, reason: collision with root package name */
        private final d f5688s;
        Flow.Subscription subscription;

        public SubscriberToRS(d dVar) {
            this.f5688s = dVar;
        }

        @Override // Z9.e
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f5688s.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th) {
            this.f5688s.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t9) {
            this.f5688s.onNext(t9);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.f5688s.onSubscribe(this);
        }

        @Override // Z9.e
        public void request(long j5) {
            this.subscription.request(j5);
        }
    }

    public static <T> Flux<T> flowPublisherToFlux(Flow.Publisher<T> publisher) {
        return new FlowPublisherAsFlux(publisher);
    }

    public static <T> Flow.Publisher<T> publisherToFlowPublisher(c cVar) {
        return new PublisherAsFlowPublisher(cVar);
    }
}
