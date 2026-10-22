package reactor.core.publisher;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Callable;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSingleCallable<T> extends Mono<T> implements Callable<T>, SourceProducer<T> {
    final Callable<? extends T> callable;

    @Nullable
    final T defaultValue;

    public MonoSingleCallable(Callable<? extends T> callable, T t10) {
        Objects.requireNonNull(callable, "source");
        this.callable = callable;
        Objects.requireNonNull(t10, "defaultValue");
        this.defaultValue = t10;
    }

    @Override // reactor.core.publisher.Mono
    public T block(Duration duration) {
        try {
            T tCall = this.callable.call();
            if (tCall != null || this.defaultValue != null) {
                return tCall == null ? this.defaultValue : tCall;
            }
            g5.f.m("Source was empty");
            return null;
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        T tCall = this.callable.call();
        if (tCall != null || this.defaultValue != null) {
            return tCall == null ? this.defaultValue : tCall;
        }
        g5.f.m("Source was empty");
        return null;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Operators.MonoInnerProducerBase monoInnerProducerBase = new Operators.MonoInnerProducerBase(coreSubscriber);
        coreSubscriber.onSubscribe(monoInnerProducerBase);
        if (monoInnerProducerBase.isCancelled()) {
            return;
        }
        try {
            T tCall = this.callable.call();
            if (tCall == null && this.defaultValue == null) {
                coreSubscriber.onError(new NoSuchElementException("Source was empty"));
            } else if (tCall == null) {
                monoInnerProducerBase.complete(this.defaultValue);
            } else {
                monoInnerProducerBase.complete(tCall);
            }
        } catch (Throwable th) {
            coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
        }
    }

    public MonoSingleCallable(Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "source");
        this.callable = callable;
        this.defaultValue = null;
    }

    @Override // reactor.core.publisher.Mono
    public T block() {
        return block(Duration.ZERO);
    }
}
