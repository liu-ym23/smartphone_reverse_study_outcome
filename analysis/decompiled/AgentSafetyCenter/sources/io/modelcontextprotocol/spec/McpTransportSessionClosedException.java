package io.modelcontextprotocol.spec;

import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class McpTransportSessionClosedException extends RuntimeException {
    public McpTransportSessionClosedException(@Nullable String str) {
        super(str != null ? "MCP session with ID %s has been closed".formatted(str) : "MCP session has been closed");
    }
}
