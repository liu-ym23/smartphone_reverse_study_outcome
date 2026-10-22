package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.server.McpStatelessServerHandler;
import java.util.List;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
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
