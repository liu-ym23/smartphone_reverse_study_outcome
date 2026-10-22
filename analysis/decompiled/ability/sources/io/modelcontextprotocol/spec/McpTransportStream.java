package io.modelcontextprotocol.spec;

import java.util.Optional;

/* loaded from: classes3.dex */
public interface McpTransportStream<CONNECTION> {
    Z9.c consumeSseStream(Z9.c cVar);

    Optional<String> lastId();

    long streamId();
}
