package io.modelcontextprotocol.json;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpJsonMapper {
    static McpJsonMapper createDefault() {
        return McpJsonInternal.createDefaultMapper();
    }

    static McpJsonMapper getDefault() {
        return McpJsonInternal.getDefaultMapper();
    }

    <T> T convertValue(Object obj, TypeRef<T> typeRef);

    <T> T convertValue(Object obj, Class<T> cls);

    <T> T readValue(String str, TypeRef<T> typeRef);

    <T> T readValue(String str, Class<T> cls);

    <T> T readValue(byte[] bArr, TypeRef<T> typeRef);

    <T> T readValue(byte[] bArr, Class<T> cls);

    byte[] writeValueAsBytes(Object obj);

    String writeValueAsString(Object obj);
}
