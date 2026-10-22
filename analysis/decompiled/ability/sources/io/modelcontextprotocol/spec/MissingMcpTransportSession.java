package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public class MissingMcpTransportSession implements McpLoggableSession {
    private volatile McpSchema.LoggingLevel minLoggingLevel = McpSchema.LoggingLevel.INFO;
    private final String sessionId;

    public MissingMcpTransportSession(String str) {
        this.sessionId = str;
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public void close() {
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
        return Mono.error(new IllegalStateException(B7.a.k("Stream unavailable for session ", this.sessionId)));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
        return Mono.error(new IllegalStateException(B7.a.k("Stream unavailable for session ", this.sessionId)));
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
        this.minLoggingLevel = loggingLevel;
    }
}
