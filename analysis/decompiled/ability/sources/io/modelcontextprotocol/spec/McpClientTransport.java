package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public interface McpClientTransport extends McpTransport {
    Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function);

    default void setExceptionHandler(Consumer<Throwable> consumer) {
    }
}
