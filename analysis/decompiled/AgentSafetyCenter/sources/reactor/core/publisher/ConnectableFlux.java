package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class ConnectableFlux<T> extends Flux<T> {
    static final Consumer<Disposable> NOOP_DISCONNECT = new o0(2);

    public static <T> ConnectableFlux<T> from(ConnectableFlux<T> connectableFlux) {
        return ContextPropagationSupport.shouldWrapPublisher(connectableFlux) ? new ConnectableFluxRestoringThreadLocals(connectableFlux) : connectableFlux;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connect$0(Disposable[] disposableArr, Disposable disposable) {
        disposableArr[0] = disposable;
    }

    public final Flux<T> autoConnect(int i, Consumer<? super Disposable> consumer) {
        if (i != 0) {
            return this instanceof Fuseable ? Flux.onAssembly(new FluxAutoConnectFuseable(this, i, consumer)) : Flux.onAssembly(new FluxAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return this;
    }

    public final Disposable connect() {
        Disposable[] disposableArr = {null};
        c cVar = new c(0);
        cVar.f10767f = disposableArr;
        VarHandle.storeStoreFence();
        connect(cVar);
        return disposableArr[0];
    }

    public abstract void connect(Consumer<? super Disposable> consumer);

    @Override // reactor.core.publisher.Flux
    public final ConnectableFlux<T> hide() {
        return new ConnectableFluxHide(this);
    }

    public final Flux<T> refCount(int i) {
        return Flux.onAssembly(new FluxRefCount(this, i));
    }

    public final Flux<T> refCount() {
        return refCount(1);
    }

    public final Flux<T> refCount(int i, Duration duration) {
        return refCount(i, duration, Schedulers.parallel());
    }

    public final Flux<T> refCount(int i, Duration duration, Scheduler scheduler) {
        return Flux.onAssembly(new FluxRefCountGrace(this, i, duration, scheduler));
    }

    public final Flux<T> autoConnect(int i) {
        return autoConnect(i, NOOP_DISCONNECT);
    }

    public final Flux<T> autoConnect() {
        return autoConnect(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Disposable disposable) {
    }
}
