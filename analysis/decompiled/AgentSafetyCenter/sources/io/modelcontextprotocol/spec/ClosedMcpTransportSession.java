package io.modelcontextprotocol.spec;

import java.util.Optional;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ClosedMcpTransportSession<CONNECTION> implements McpTransportSession<CONNECTION> {
    private final String sessionId;

    public ClosedMcpTransportSession(@Nullable String str) {
        this.sessionId = str;
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void addConnection(CONNECTION connection) {
        throw new McpTransportSessionClosedException(this.sessionId);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public qd.c closeGracefully() {
        return Mono.empty();
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public boolean markInitialized(String str) {
        throw new McpTransportSessionClosedException(str);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void removeConnection(CONNECTION connection) {
        throw new McpTransportSessionClosedException(this.sessionId);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public Optional<String> sessionId() {
        throw new McpTransportSessionClosedException(this.sessionId);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void close() {
    }
}
