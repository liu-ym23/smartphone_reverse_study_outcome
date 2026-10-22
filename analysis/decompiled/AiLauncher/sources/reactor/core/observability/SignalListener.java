package reactor.core.observability;

import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
public interface SignalListener<T> {
    default Context addToContext(Context context) {
        return context;
    }

    void doAfterComplete() throws Throwable;

    void doAfterError(Throwable th) throws Throwable;

    void doFinally(SignalType signalType) throws Throwable;

    void doFirst() throws Throwable;

    void doOnCancel() throws Throwable;

    void doOnComplete() throws Throwable;

    void doOnError(Throwable th) throws Throwable;

    void doOnFusion(int i10) throws Throwable;

    void doOnMalformedOnComplete() throws Throwable;

    void doOnMalformedOnError(Throwable th) throws Throwable;

    void doOnMalformedOnNext(T t10) throws Throwable;

    void doOnNext(T t10) throws Throwable;

    void doOnRequest(long j10) throws Throwable;

    void doOnSubscription() throws Throwable;

    void handleListenerError(Throwable th);
}
