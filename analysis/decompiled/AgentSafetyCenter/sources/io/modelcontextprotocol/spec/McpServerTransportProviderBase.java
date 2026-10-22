package io.modelcontextprotocol.spec;

import java.util.List;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpServerTransportProviderBase {
    default void close() {
        closeGracefully().subscribe();
    }

    Mono<Void> closeGracefully();

    Mono<Void> notifyClients(String str, Object obj);

    default List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }
}
