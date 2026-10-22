package io.modelcontextprotocol.spec;

import java.util.Optional;

/* loaded from: classes3.dex */
public interface McpTransportSession<CONNECTION> {
    void addConnection(CONNECTION connection);

    void close();

    Z9.c closeGracefully();

    boolean markInitialized(String str);

    void removeConnection(CONNECTION connection);

    Optional<String> sessionId();
}
