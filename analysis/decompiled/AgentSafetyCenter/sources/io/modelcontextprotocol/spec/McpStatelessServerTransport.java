package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.server.McpStatelessServerHandler;
import java.util.List;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpStatelessServerTransport {
    default void close() {
        closeGracefully().subscribe();
    }

    Mono<Void> closeGracefully();

    default List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    void setMcpHandler(McpStatelessServerHandler mcpStatelessServerHandler);
}
