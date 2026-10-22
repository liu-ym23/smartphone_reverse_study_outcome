package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpSession {
    void close();

    Mono<Void> closeGracefully();

    default Mono<Void> sendNotification(String str) {
        return sendNotification(str, null);
    }

    Mono<Void> sendNotification(String str, Object obj);

    <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef);
}
