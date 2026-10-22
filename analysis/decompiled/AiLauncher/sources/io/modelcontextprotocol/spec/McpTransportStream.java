package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.Optional;
import reactor.util.function.Tuple2;

/* loaded from: classes4.dex */
public interface McpTransportStream<CONNECTION> {
    qc.b<McpSchema.JSONRPCMessage> consumeSseStream(qc.b<Tuple2<Optional<String>, Iterable<McpSchema.JSONRPCMessage>>> bVar);

    Optional<String> lastId();

    long streamId();
}
