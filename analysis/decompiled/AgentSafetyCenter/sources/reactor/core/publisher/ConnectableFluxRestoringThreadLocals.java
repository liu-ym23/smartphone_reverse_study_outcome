package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class ConnectableFluxRestoringThreadLocals<T> extends ConnectableFlux<T> {
    private final ConnectableFlux<T> source;

    public ConnectableFluxRestoringThreadLocals(ConnectableFlux<T> connectableFlux) {
        Objects.requireNonNull(connectableFlux, "source");
        this.source = connectableFlux;
    }

    @Override // reactor.core.publisher.ConnectableFlux
    public void connect(Consumer<? super Disposable> consumer) {
        this.source.connect(consumer);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        ConnectableFlux<T> connectableFlux = this.source;
        connectableFlux.subscribe((CoreSubscriber) Operators.restoreContextOnSubscriber(connectableFlux, coreSubscriber));
    }
}
