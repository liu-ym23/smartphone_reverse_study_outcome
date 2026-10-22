package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpSession {
    void close();

    Mono<Void> closeGracefully();

    default Mono<Void> sendNotification(String str) {
        return sendNotification(str, null);
    }

    Mono<Void> sendNotification(String str, Object obj);

    <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef);
}
