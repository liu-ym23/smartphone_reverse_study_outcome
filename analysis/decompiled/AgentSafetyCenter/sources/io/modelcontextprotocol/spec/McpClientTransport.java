package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpClientTransport extends McpTransport {
    Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function);

    default void setExceptionHandler(Consumer<Throwable> consumer) {
    }
}
