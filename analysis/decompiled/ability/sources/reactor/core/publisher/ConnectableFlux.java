package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes4.dex */
public abstract class ConnectableFlux<T> extends Flux<T> {
    static final Consumer<Disposable> NOOP_DISCONNECT = new N(2);

    public static <T> ConnectableFlux<T> from(ConnectableFlux<T> connectableFlux) {
        return ContextPropagationSupport.shouldWrapPublisher(connectableFlux) ? new ConnectableFluxRestoringThreadLocals(connectableFlux) : connectableFlux;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connect$0(Disposable[] disposableArr, Disposable disposable) {
        disposableArr[0] = disposable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Disposable disposable) {
    }

    public final Flux<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        Disposable[] disposableArr = {null};
        connect(new C1887c(disposableArr, 0));
        return disposableArr[0];
    }

    public abstract void connect(Consumer<? super Disposable> consumer);

    public final Flux<T> refCount() {
        return refCount(1);
    }

    public final Flux<T> autoConnect(int i) {
        return autoConnect(i, NOOP_DISCONNECT);
    }

    @Override // reactor.core.publisher.Flux
    public final ConnectableFlux<T> hide() {
        return new ConnectableFluxHide(this);
    }

    public final Flux<T> refCount(int i) {
        return Flux.onAssembly(new FluxRefCount(this, i));
    }

    public final Flux<T> autoConnect(int i, Consumer<? super Disposable> consumer) {
        if (i == 0) {
            connect(consumer);
            return this;
        }
        if (this instanceof Fuseable) {
            return Flux.onAssembly(new FluxAutoConnectFuseable(this, i, consumer));
        }
        return Flux.onAssembly(new FluxAutoConnect(this, i, consumer));
    }

    public final Flux<T> refCount(int i, Duration duration) {
        return refCount(i, duration, Schedulers.parallel());
    }

    public final Flux<T> refCount(int i, Duration duration, Scheduler scheduler) {
        return Flux.onAssembly(new FluxRefCountGrace(this, i, duration, scheduler));
    }
}
