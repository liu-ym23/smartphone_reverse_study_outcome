package reactor.core.publisher;

import java.util.Objects;
import java.util.stream.Stream;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SinksSpecs;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class SinkManySerialized<T> extends SinksSpecs.AbstractSerializedSink implements InternalManySink<T>, Scannable {
    final ContextHolder contextHolder;
    final Sinks.Many<T> sink;

    public SinkManySerialized(Sinks.Many<T> many, ContextHolder contextHolder) {
        this.sink = many;
        this.contextHolder = contextHolder;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this.sink.asFlux();
    }

    @Override // reactor.core.publisher.ContextHolder
    public Context currentContext() {
        return this.contextHolder.currentContext();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.sink.currentSubscriberCount();
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Scannable.from(this.sink).inners();
    }

    public boolean isCancelled() {
        return ((Boolean) Scannable.from(this.sink).scanOrDefault(Scannable.Attr.CANCELLED, Boolean.FALSE)).booleanValue();
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return this.sink.scanUnsafe(attr);
    }

    public String toString() {
        return this.sink.toString();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitComplete() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!tryAcquire(threadCurrentThread)) {
            return Sinks.EmitResult.FAIL_NON_SERIALIZED;
        }
        try {
            return this.sink.tryEmitComplete();
        } finally {
            if (SinksSpecs.AbstractSerializedSink.WIP.decrementAndGet(this) == 0) {
                SinksSpecs.AbstractSerializedSink.LOCKED_AT.compareAndSet(this, threadCurrentThread, null);
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitError(Throwable th) {
        Objects.requireNonNull(th, "t is null in sink.error(t)");
        Thread threadCurrentThread = Thread.currentThread();
        if (!tryAcquire(threadCurrentThread)) {
            return Sinks.EmitResult.FAIL_NON_SERIALIZED;
        }
        try {
            return this.sink.tryEmitError(th);
        } finally {
            if (SinksSpecs.AbstractSerializedSink.WIP.decrementAndGet(this) == 0) {
                SinksSpecs.AbstractSerializedSink.LOCKED_AT.compareAndSet(this, threadCurrentThread, null);
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitNext(T t9) {
        Objects.requireNonNull(t9, "t is null in sink.next(t)");
        Thread threadCurrentThread = Thread.currentThread();
        if (!tryAcquire(threadCurrentThread)) {
            return Sinks.EmitResult.FAIL_NON_SERIALIZED;
        }
        try {
            return this.sink.tryEmitNext(t9);
        } finally {
            if (SinksSpecs.AbstractSerializedSink.WIP.decrementAndGet(this) == 0) {
                SinksSpecs.AbstractSerializedSink.LOCKED_AT.compareAndSet(this, threadCurrentThread, null);
            }
        }
    }
}
