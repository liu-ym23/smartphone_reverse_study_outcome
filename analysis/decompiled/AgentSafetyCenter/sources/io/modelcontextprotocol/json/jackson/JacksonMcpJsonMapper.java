package io.modelcontextprotocol.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import g5.f;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JacksonMcpJsonMapper implements McpJsonMapper {
    private final ObjectMapper objectMapper;

    public JacksonMcpJsonMapper(ObjectMapper objectMapper) {
        if (objectMapper != null) {
            this.objectMapper = objectMapper;
        } else {
            f.s("ObjectMapper must not be null");
            throw null;
        }
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T convertValue(Object obj, TypeRef<T> typeRef) {
        return (T) this.objectMapper.convertValue(obj, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(String str, TypeRef<T> typeRef) {
        return (T) this.objectMapper.readValue(str, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public byte[] writeValueAsBytes(Object obj) {
        return this.objectMapper.writeValueAsBytes(obj);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public String writeValueAsString(Object obj) {
        return this.objectMapper.writeValueAsString(obj);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T convertValue(Object obj, Class<T> cls) {
        return (T) this.objectMapper.convertValue(obj, cls);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(byte[] bArr, Class<T> cls) {
        return (T) this.objectMapper.readValue(bArr, cls);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(String str, Class<T> cls) {
        return (T) this.objectMapper.readValue(str, cls);
    }

    @Override // io.modelcontextprotocol.json.McpJsonMapper
    public <T> T readValue(byte[] bArr, TypeRef<T> typeRef) {
        return (T) this.objectMapper.readValue(bArr, this.objectMapper.getTypeFactory().constructType(typeRef.getType()));
    }
}
