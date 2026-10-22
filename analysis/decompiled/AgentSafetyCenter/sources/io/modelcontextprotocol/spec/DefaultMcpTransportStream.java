package io.modelcontextprotocol.spec;

import java.lang.invoke.VarHandle;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultMcpTransportStream<CONNECTION> implements McpTransportStream<CONNECTION> {
    private final Function<McpTransportStream<CONNECTION>, qd.c> reconnect;
    private final boolean resumable;
    private static final rd.b logger = rd.d.b(DefaultMcpTransportStream.class);
    private static final AtomicLong counter = new AtomicLong();
    private final AtomicReference<String> lastId = new AtomicReference<>();
    private final long streamId = counter.getAndIncrement();

    public DefaultMcpTransportStream(boolean z10, Function<McpTransportStream<CONNECTION>, qd.c> function) {
        this.reconnect = function;
        this.resumable = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$0(String str) {
        logger.debug("Updating last id {} -> {} for stream {}", this.lastId.getAndSet(str), str, Long.valueOf(this.streamId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$1(Tuple2 tuple2) {
        Optional optional = (Optional) tuple2.getT1();
        a aVar = new a(0);
        aVar.f6346f = this;
        VarHandle.storeStoreFence();
        optional.ifPresent(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$2(ContextView contextView, Throwable th) {
        if (!this.resumable || (th instanceof McpTransportSessionNotFoundException)) {
            return;
        }
        Mono.from(this.reconnect.apply(this)).contextWrite(contextView).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$consumeSseStream$3(qd.c cVar, ContextView contextView) {
        Flux fluxFrom = Flux.from(cVar);
        int i = 1;
        a aVar = new a(i);
        aVar.f6346f = this;
        VarHandle.storeStoreFence();
        Flux fluxDoOnNext = fluxFrom.doOnNext(aVar);
        g8.g gVar = new g8.g(i);
        gVar.f4383f = this;
        gVar.f4384g = contextView;
        VarHandle.storeStoreFence();
        return fluxDoOnNext.doOnError(gVar).flatMapIterable(new a8.b(20));
    }

    @Override // io.modelcontextprotocol.spec.McpTransportStream
    public qd.c consumeSseStream(qd.c cVar) {
        io.modelcontextprotocol.server.e eVar = new io.modelcontextprotocol.server.e(2);
        eVar.f6261b = this;
        eVar.f6262c = cVar;
        VarHandle.storeStoreFence();
        return Flux.deferContextual(eVar);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportStream
    public Optional<String> lastId() {
        return Optional.ofNullable(this.lastId.get());
    }

    @Override // io.modelcontextprotocol.spec.McpTransportStream
    public long streamId() {
        return this.streamId;
    }
}
