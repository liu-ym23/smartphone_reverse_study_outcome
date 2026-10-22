package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpTransport {
    default void close() {
        closeGracefully().subscribe();
    }

    Mono<Void> closeGracefully();

    default List<String> protocolVersions() {
        return List.of("2024-11-05");
    }

    Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage);

    <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef);
}
