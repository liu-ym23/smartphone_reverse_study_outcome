package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class MissingMcpTransportSession implements McpLoggableSession {
    private volatile McpSchema.LoggingLevel minLoggingLevel = McpSchema.LoggingLevel.INFO;
    private final String sessionId;

    public MissingMcpTransportSession(String str) {
        this.sessionId = str;
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> closeGracefully() {
        return Mono.empty();
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public boolean isNotificationForLevelAllowed(McpSchema.LoggingLevel loggingLevel) {
        return loggingLevel.level() >= this.minLoggingLevel.level();
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> sendNotification(String str, Object obj) {
        return Mono.error(new IllegalStateException(w2.c.b("Stream unavailable for session ", this.sessionId)));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
        return Mono.error(new IllegalStateException(w2.c.b("Stream unavailable for session ", this.sessionId)));
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
        this.minLoggingLevel = loggingLevel;
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public void close() {
    }
}
