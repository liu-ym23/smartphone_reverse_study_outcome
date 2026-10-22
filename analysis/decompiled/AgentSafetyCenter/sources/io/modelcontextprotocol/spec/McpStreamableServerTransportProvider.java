package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
