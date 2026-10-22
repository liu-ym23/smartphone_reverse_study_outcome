package io.modelcontextprotocol.spec;

import java.util.List;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpServerTransportProviderBase {
    default void close() {
        closeGracefully().subscribe();
    }

    Mono<Void> closeGracefully();

    Mono<Void> notifyClients(String str, Object obj);

    default List<String> protocolVersions() {
        return List.of("2024-11-05");
    }
}
