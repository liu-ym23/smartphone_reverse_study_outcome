package io.modelcontextprotocol.spec;

import java.util.Optional;

/* loaded from: classes4.dex */
public interface McpTransportSession<CONNECTION> {
    void addConnection(CONNECTION connection);

    void close();

    qc.b<Void> closeGracefully();

    boolean markInitialized(String str);

    void removeConnection(CONNECTION connection);

    Optional<String> sessionId();
}
