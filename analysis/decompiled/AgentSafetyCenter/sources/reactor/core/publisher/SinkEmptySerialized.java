package reactor.core.publisher;

import java.util.Objects;
import java.util.stream.Stream;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SinksSpecs;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class SinkEmptySerialized<T> extends SinksSpecs.AbstractSerializedSink implements InternalEmptySink<T>, ContextHolder {
    final ContextHolder contextHolder;
    final Sinks.Empty<T> sink;

    public SinkEmptySerialized(Sinks.Empty<T> empty, ContextHolder contextHolder) {
        this.sink = empty;
        this.contextHolder = contextHolder;
    }

    @Override // reactor.core.publisher.Sinks.Empty
    public Mono<T> asMono() {
        return this.sink.asMono();
    }

    @Override // reactor.core.publisher.ContextHolder
    public Context currentContext() {
        return this.contextHolder.currentContext();
    }

    @Override // reactor.core.publisher.Sinks.Empty
    public int currentSubscriberCount() {
        return this.sink.currentSubscriberCount();
    }

    @Override // reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return this.sink.inners();
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return this.sink.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Sinks.Empty
    public final Sinks.EmitResult tryEmitEmpty() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!tryAcquire(threadCurrentThread)) {
            return Sinks.EmitResult.FAIL_NON_SERIALIZED;
        }
        try {
            return this.sink.tryEmitEmpty();
        } finally {
            if (SinksSpecs.AbstractSerializedSink.WIP.decrementAndGet(this) == 0) {
                SinksSpecs.AbstractSerializedSink.LOCKED_AT.compareAndSet(this, threadCurrentThread, null);
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.Empty
    public final Sinks.EmitResult tryEmitError(Throwable th) {
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
}
