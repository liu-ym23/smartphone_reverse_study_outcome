package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class Protobuf {
    private static final Protobuf INSTANCE = null;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache;
    private final SchemaFactory schemaFactory;

    static {
        INSTANCE = new Protobuf();
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public <T> void writeTo(T message, Writer writer) throws IOException {
        schemaFor(message).writeTo(message, writer);
    }

    public <T> void mergeFrom(T message, Reader reader) throws IOException {
        mergeFrom(message, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T> void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        schemaFor(message).mergeFrom(message, reader, extensionRegistry);
    }

    public <T> void makeImmutable(T message) {
        schemaFor(message).makeImmutable(message);
    }

    <T> boolean isInitialized(T message) {
        return schemaFor(message).isInitialized(message);
    }

    public <T> Schema<T> schemaFor(Class<T> r3) {
        Internal.checkNotNull(r3, "messageType");
        Schema<T> r0 = (Schema) this.schemaCache.get(r3);
        if (r0 != null) goto L8;
        Schema<T> r1 = this.schemaFactory.createSchema(r3);
        Schema<T> r2 = (Schema<T>) registerSchema(r3, r1);
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r2;
    L8:
        return r0;
    }

    public <T> Schema<T> schemaFor(T message) {
        return schemaFor(message.getClass());
    }

    public Schema<?> registerSchema(Class<?> messageType, Schema<?> schema) {
        Internal.checkNotNull(messageType, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(messageType, schema);
    }

    public Schema<?> registerSchemaOverride(Class<?> messageType, Schema<?> schema) {
        Internal.checkNotNull(messageType, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(messageType, schema);
    }

    private Protobuf() {
        this.schemaCache = new ConcurrentHashMap();
        this.schemaFactory = new ManifestSchemaFactory();
    }

    int getTotalSchemaSize() {
        int result = 0;
        Iterator<Schema<?>> r1 = this.schemaCache.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Schema<?> schema = r1.next();
        if ((schema instanceof MessageSchema) == false) goto L4;
        result = result + ((MessageSchema) schema).getSchemaSize();
        goto L4
    L9:
        return result;
    }
}
