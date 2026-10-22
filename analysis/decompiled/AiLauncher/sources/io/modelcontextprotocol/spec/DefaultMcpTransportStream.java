package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;

/* loaded from: classes4.dex */
public class DefaultMcpTransportStream<CONNECTION> implements McpTransportStream<CONNECTION> {
    private final Function<McpTransportStream<CONNECTION>, qc.b<CONNECTION>> reconnect;
    private final boolean resumable;
    private static final vc.c logger = vc.e.l(DefaultMcpTransportStream.class);
    private static final AtomicLong counter = new AtomicLong();
    private final AtomicReference<String> lastId = new AtomicReference<>();
    private final long streamId = counter.getAndIncrement();

    public DefaultMcpTransportStream(boolean z10, Function<McpTransportStream<CONNECTION>, qc.b<CONNECTION>> function) {
        this.reconnect = function;
        this.resumable = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$0(String str) {
        logger.debug("Updating last id {} -> {} for stream {}", this.lastId.getAndSet(str), str, Long.valueOf(this.streamId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$1(Tuple2 tuple2) {
        ((Optional) tuple2.getT1()).ifPresent(new Consumer() { // from class: io.modelcontextprotocol.spec.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34150a.lambda$consumeSseStream$0((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$consumeSseStream$2(ContextView contextView, Throwable th) {
        if (!this.resumable || (th instanceof McpTransportSessionNotFoundException)) {
            return;
        }
        Mono.from(this.reconnect.apply(this)).contextWrite(contextView).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$consumeSseStream$3(qc.b bVar, final ContextView contextView) {
        return Flux.from(bVar).doOnNext(new Consumer() { // from class: io.modelcontextprotocol.spec.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34154a.lambda$consumeSseStream$1((Tuple2) obj);
            }
        }).doOnError(new Consumer() { // from class: io.modelcontextprotocol.spec.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34157a.lambda$consumeSseStream$2(contextView, (Throwable) obj);
            }
        }).flatMapIterable(new Function() { // from class: io.modelcontextprotocol.spec.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Iterable) ((Tuple2) obj).getT2();
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpTransportStream
    public qc.b<McpSchema.JSONRPCMessage> consumeSseStream(final qc.b<Tuple2<Optional<String>, Iterable<McpSchema.JSONRPCMessage>>> bVar) {
        return Flux.deferContextual(new Function() { // from class: io.modelcontextprotocol.spec.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f34148a.lambda$consumeSseStream$3(bVar, (ContextView) obj);
            }
        });
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
