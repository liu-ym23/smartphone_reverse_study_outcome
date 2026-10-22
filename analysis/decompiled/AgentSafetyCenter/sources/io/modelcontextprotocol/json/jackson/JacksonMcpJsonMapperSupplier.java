package io.modelcontextprotocol.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.McpJsonMapperSupplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JacksonMcpJsonMapperSupplier implements McpJsonMapperSupplier {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public McpJsonMapper get() {
        return new JacksonMcpJsonMapper(new ObjectMapper());
    }
}
