package io.modelcontextprotocol.spec;

import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public class McpTransportSessionClosedException extends RuntimeException {
    public McpTransportSessionClosedException(@Nullable String str) {
        super(str != null ? "MCP session with ID %s has been closed".formatted(str) : "MCP session has been closed");
    }
}
