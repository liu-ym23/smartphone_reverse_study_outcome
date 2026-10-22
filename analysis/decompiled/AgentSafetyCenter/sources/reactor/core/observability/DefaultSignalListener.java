package reactor.core.observability;

import reactor.core.publisher.SignalType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class DefaultSignalListener<T> implements SignalListener<T> {
    int fusionMode = 0;

    @Override // reactor.core.observability.SignalListener
    public void doOnFusion(int i) {
        this.fusionMode = i;
    }

    public int getFusionMode() {
        return this.fusionMode;
    }

    @Override // reactor.core.observability.SignalListener
    public void doAfterComplete() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doFirst() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnCancel() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnComplete() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnMalformedOnComplete() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnSubscription() {
    }

    @Override // reactor.core.observability.SignalListener
    public void doAfterError(Throwable th) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doFinally(SignalType signalType) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnError(Throwable th) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnMalformedOnError(Throwable th) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnMalformedOnNext(T t10) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnNext(T t10) {
    }

    @Override // reactor.core.observability.SignalListener
    public void doOnRequest(long j10) {
    }

    @Override // reactor.core.observability.SignalListener
    public void handleListenerError(Throwable th) {
    }
}
