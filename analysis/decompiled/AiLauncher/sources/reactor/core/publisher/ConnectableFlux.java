package reactor.core.publisher;

import java.time.Duration;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes5.dex */
public abstract class ConnectableFlux<T> extends Flux<T> {
    static final Consumer<Disposable> NOOP_DISCONNECT = new Consumer() { // from class: reactor.core.publisher.d
        @Override // java.util.function.Consumer
        public final void accept(Object obj) {
            ConnectableFlux.h0((Disposable) obj);
        }
    };

    public static <T> ConnectableFlux<T> from(ConnectableFlux<T> connectableFlux) {
        return ContextPropagationSupport.shouldWrapPublisher(connectableFlux) ? new ConnectableFluxRestoringThreadLocals(connectableFlux) : connectableFlux;
    }

    public static /* synthetic */ void h0(Disposable disposable) {
    }

    public static /* synthetic */ void i0(Disposable[] disposableArr, Disposable disposable) {
        disposableArr[0] = disposable;
    }

    public final Flux<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        final Disposable[] disposableArr = {null};
        connect(new Consumer() { // from class: reactor.core.publisher.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ConnectableFlux.i0(disposableArr, (Disposable) obj);
            }
        });
        return disposableArr[0];
    }

    public abstract void connect(Consumer<? super Disposable> consumer);

    public final Flux<T> refCount() {
        return refCount(1);
    }

    public final Flux<T> autoConnect(int i10) {
        return autoConnect(i10, NOOP_DISCONNECT);
    }

    @Override // reactor.core.publisher.Flux
    public final ConnectableFlux<T> hide() {
        return new ConnectableFluxHide(this);
    }

    public final Flux<T> refCount(int i10) {
        return Flux.onAssembly(new FluxRefCount(this, i10));
    }

    public final Flux<T> autoConnect(int i10, Consumer<? super Disposable> consumer) {
        if (i10 == 0) {
            connect(consumer);
            return this;
        }
        if (this instanceof Fuseable) {
            return Flux.onAssembly(new FluxAutoConnectFuseable(this, i10, consumer));
        }
        return Flux.onAssembly(new FluxAutoConnect(this, i10, consumer));
    }

    public final Flux<T> refCount(int i10, Duration duration) {
        return refCount(i10, duration, Schedulers.parallel());
    }

    public final Flux<T> refCount(int i10, Duration duration, Scheduler scheduler) {
        return Flux.onAssembly(new FluxRefCountGrace(this, i10, duration, scheduler));
    }
}
