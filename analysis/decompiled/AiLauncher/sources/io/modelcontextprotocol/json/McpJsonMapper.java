package io.modelcontextprotocol.json;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface McpJsonMapper {
    static McpJsonMapper createDefault() {
        return McpJsonInternal.createDefaultMapper();
    }

    static McpJsonMapper getDefault() {
        return McpJsonInternal.getDefaultMapper();
    }

    <T> T convertValue(Object obj, TypeRef<T> typeRef);

    <T> T convertValue(Object obj, Class<T> cls);

    <T> T readValue(String str, TypeRef<T> typeRef) throws IOException;

    <T> T readValue(String str, Class<T> cls) throws IOException;

    <T> T readValue(byte[] bArr, TypeRef<T> typeRef) throws IOException;

    <T> T readValue(byte[] bArr, Class<T> cls) throws IOException;

    byte[] writeValueAsBytes(Object obj) throws IOException;

    String writeValueAsString(Object obj) throws IOException;
}
