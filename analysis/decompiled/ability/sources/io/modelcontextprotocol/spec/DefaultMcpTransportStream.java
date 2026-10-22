package io.modelcontextprotocol.spec;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.server.C1588f;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;

/* loaded from: classes3.dex */
public class DefaultMcpTransportStream<CONNECTION> implements McpTransportStream<CONNECTION> {
    private final Function<McpTransportStream<CONNECTION>, Z9.c> reconnect;
    private final boolean resumable;
    private static final InterfaceC0315b logger = AbstractC0317d.b(DefaultMcpTransportStream.class);
    private static final AtomicLong counter = new AtomicLong();
    private final AtomicReference<String> lastId = new AtomicReference<>();
    private final long streamId = counter.getAndIncrement();

    public DefaultMcpTransportStream(boolean z10, Function<McpTransportStream<CONNECTION>, Z9.c> function) {
        this.reconnect = function;
        this.resumable = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$0(String str) {
        logger.debug("Updating last id {} -> {} for stream {}", this.lastId.getAndSet(str), str, Long.valueOf(this.streamId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$1(Tuple2 tuple2) {
        ((Optional) tuple2.getT1()).ifPresent(new a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$2(ContextView contextView, Throwable th) {
        if (!this.resumable || (th instanceof McpTransportSessionNotFoundException)) {
            return;
        }
        Mono.from(this.reconnect.apply(this)).contextWrite(contextView).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$consumeSseStream$3(Z9.c cVar, ContextView contextView) {
        int i = 1;
        return Flux.from(cVar).doOnNext(new a(this, i)).doOnError(new E3.h(i, this, contextView)).flatMapIterable(new E3.d(19));
    }

    @Override // io.modelcontextprotocol.spec.McpTransportStream
    public Z9.c consumeSseStream(Z9.c cVar) {
        return Flux.deferContextual(new C1588f(2, this, cVar));
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
