package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpTransport {
    /* renamed from: close */
    default void lambda$closeGracefully$1() {
        closeGracefully().subscribe();
    }

    Mono<Void> closeGracefully();

    default List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }

    Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage);

    <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef);
}
