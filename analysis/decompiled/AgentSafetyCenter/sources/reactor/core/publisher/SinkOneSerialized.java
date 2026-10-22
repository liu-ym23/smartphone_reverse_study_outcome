package reactor.core.publisher;

import java.util.stream.Stream;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SinksSpecs;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class SinkOneSerialized<T> extends SinkEmptySerialized<T> implements InternalOneSink<T>, ContextHolder {
    final Sinks.One<T> sinkOne;

    public SinkOneSerialized(Sinks.One<T> one, ContextHolder contextHolder) {
        super(one, contextHolder);
        this.sinkOne = one;
    }

    @Override // reactor.core.publisher.SinkEmptySerialized, reactor.core.publisher.Sinks.Empty
    public /* bridge */ /* synthetic */ Mono asMono() {
        return super.asMono();
    }

    @Override // reactor.core.publisher.SinkEmptySerialized, reactor.core.publisher.ContextHolder
    public /* bridge */ /* synthetic */ Context currentContext() {
        return super.currentContext();
    }

    @Override // reactor.core.publisher.SinkEmptySerialized, reactor.core.publisher.Sinks.Empty
    public /* bridge */ /* synthetic */ int currentSubscriberCount() {
        return super.currentSubscriberCount();
    }

    @Override // reactor.core.publisher.SinkEmptySerialized, reactor.core.Scannable
    public /* bridge */ /* synthetic */ Stream inners() {
        return super.inners();
    }

    @Override // reactor.core.publisher.SinkEmptySerialized, reactor.core.Scannable
    public /* bridge */ /* synthetic */ Object scanUnsafe(Scannable.Attr attr) {
        return super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Sinks.One
    public Sinks.EmitResult tryEmitValue(T t10) {
        Thread threadCurrentThread = Thread.currentThread();
        if (!tryAcquire(threadCurrentThread)) {
            return Sinks.EmitResult.FAIL_NON_SERIALIZED;
        }
        try {
            return this.sinkOne.tryEmitValue(t10);
        } finally {
            if (SinksSpecs.AbstractSerializedSink.WIP.decrementAndGet(this) == 0) {
                SinksSpecs.AbstractSerializedSink.LOCKED_AT.compareAndSet(this, threadCurrentThread, null);
            }
        }
    }
}
