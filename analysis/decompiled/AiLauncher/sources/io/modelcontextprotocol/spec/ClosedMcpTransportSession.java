package io.modelcontextprotocol.spec;

import java.util.Optional;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
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
    public void close() {
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public qc.b<Void> closeGracefully() {
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
}
