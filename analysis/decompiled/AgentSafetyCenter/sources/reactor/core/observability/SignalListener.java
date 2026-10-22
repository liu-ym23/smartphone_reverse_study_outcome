package reactor.core.observability;

import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface SignalListener<T> {
    void doAfterComplete();

    void doAfterError(Throwable th);

    void doFinally(SignalType signalType);

    void doFirst();

    void doOnCancel();

    void doOnComplete();

    void doOnError(Throwable th);

    void doOnFusion(int i);

    void doOnMalformedOnComplete();

    void doOnMalformedOnError(Throwable th);

    void doOnMalformedOnNext(T t10);

    void doOnNext(T t10);

    void doOnRequest(long j10);

    void doOnSubscription();

    void handleListenerError(Throwable th);

    default Context addToContext(Context context) {
        return context;
    }
}
