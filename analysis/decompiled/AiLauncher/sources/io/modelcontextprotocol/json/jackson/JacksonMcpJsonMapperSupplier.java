package io.modelcontextprotocol.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.McpJsonMapperSupplier;

/* loaded from: classes4.dex */
public class JacksonMcpJsonMapperSupplier implements McpJsonMapperSupplier {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public McpJsonMapper get() {
        return new JacksonMcpJsonMapper(new ObjectMapper());
    }
}
