package reactor.adapter;

import java.util.concurrent.Flow;
import qd.c;
import qd.d;
import qd.e;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Flux;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JdkFlowAdapter {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class FlowPublisherAsFlux<T> extends Flux<T> implements Scannable {
        private final Flow.Publisher<T> pub;

        private FlowPublisherAsFlux(Flow.Publisher<T> publisher) {
            this.pub = publisher;
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return null;
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            this.pub.subscribe(new SubscriberToRS(coreSubscriber));
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.subscriber.onComplete();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.subscriber.onError(th);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.subscriber.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(e eVar) {
            this.subscription = eVar;
            this.subscriber.onSubscribe(this);
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j10) {
            this.subscription.request(j10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class PublisherAsFlowPublisher<T> implements Flow.Publisher<T> {
        private final c pub;

        private PublisherAsFlowPublisher(c cVar) {
            this.pub = cVar;
        }

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.pub.subscribe(new FlowSubscriber(subscriber));
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SubscriberToRS<T> implements Flow.Subscriber<T>, e {

        /* renamed from: s, reason: collision with root package name */
        private final d f10579s;
        Flow.Subscription subscription;

        public SubscriberToRS(d dVar) {
            this.f10579s = dVar;
        }

        @Override // qd.e
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f10579s.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th) {
            this.f10579s.onError(th);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t10) {
            this.f10579s.onNext(t10);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.f10579s.onSubscribe(this);
        }

        @Override // qd.e
        public void request(long j10) {
            this.subscription.request(j10);
        }
    }

    public static <T> Flux<T> flowPublisherToFlux(Flow.Publisher<T> publisher) {
        return new FlowPublisherAsFlux(publisher);
    }

    public static <T> Flow.Publisher<T> publisherToFlowPublisher(c cVar) {
        return new PublisherAsFlowPublisher(cVar);
    }
}
