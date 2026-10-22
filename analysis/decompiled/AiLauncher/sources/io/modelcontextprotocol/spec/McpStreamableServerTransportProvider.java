package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpStreamableServerTransportProvider extends McpServerTransportProviderBase {
    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    default void close() {
        closeGracefully().subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    Mono<Void> closeGracefully();

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    Mono<Void> notifyClients(String str, Object obj);

    void setSessionFactory(McpStreamableServerSession.Factory factory);
}
