package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int schemaSize = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                schemaSize += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return schemaSize;
    }

    public <T> boolean isInitialized(T t10) {
        return schemaFor((Protobuf) t10).isInitialized(t10);
    }

    public <T> void makeImmutable(T t10) {
        schemaFor((Protobuf) t10).makeImmutable(t10);
    }

    public <T> void mergeFrom(T t10, Reader reader) {
        mergeFrom(t10, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schemaCreateSchema = (Schema) this.schemaCache.get(cls);
        if (schemaCreateSchema == null) {
            schemaCreateSchema = this.schemaFactory.createSchema(cls);
            Schema<T> schema = (Schema<T>) registerSchema(cls, schemaCreateSchema);
            if (schema != null) {
                return schema;
            }
        }
        return schemaCreateSchema;
    }

    public <T> void writeTo(T t10, Writer writer) {
        schemaFor((Protobuf) t10).writeTo(t10, writer);
    }

    public <T> void mergeFrom(T t10, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        schemaFor((Protobuf) t10).mergeFrom(t10, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t10) {
        return schemaFor((Class) t10.getClass());
    }
}
