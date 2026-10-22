package io.modelcontextprotocol.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class JacksonMcpJsonMapper implements McpJsonMapper {
    private final ObjectMapper objectMapper;

    public JacksonMcpJsonMapper(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            throw new IllegalArgumentException("ObjectMapper must not be null");
        }
        this.objectMapper = objectMapper;
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T convertValue(Object obj, Class<T> cls) {
        return (T) this.objectMapper.convertValue(obj, cls);
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(String str, Class<T> cls) throws IOException {
        return (T) this.objectMapper.readValue(str, cls);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public byte[] writeValueAsBytes(Object obj) throws IOException {
        return this.objectMapper.writeValueAsBytes(obj);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public String writeValueAsString(Object obj) throws IOException {
        return this.objectMapper.writeValueAsString(obj);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T convertValue(Object obj, TypeRef<T> typeRef) {
        return (T) this.objectMapper.convertValue(obj, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(byte[] bArr, Class<T> cls) throws IOException {
        return (T) this.objectMapper.readValue(bArr, cls);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(String str, TypeRef<T> typeRef) throws IOException {
        return (T) this.objectMapper.readValue(str, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(byte[] bArr, TypeRef<T> typeRef) throws IOException {
        return (T) this.objectMapper.readValue(bArr, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }
}
