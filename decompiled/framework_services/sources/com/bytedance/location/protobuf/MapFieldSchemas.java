package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MapFieldSchemas {
    private static final MapFieldSchema FULL_SCHEMA = null;
    private static final MapFieldSchema LITE_SCHEMA = null;

    MapFieldSchemas() {
    }

    static {
        FULL_SCHEMA = loadSchemaForFullRuntime();
        LITE_SCHEMA = new MapFieldSchemaLite();
    }

    static MapFieldSchema full() {
        return FULL_SCHEMA;
    }

    static MapFieldSchema lite() {
        return LITE_SCHEMA;
    }

    private static MapFieldSchema loadSchemaForFullRuntime() {
        Class<?> clazz = Class.forName("com.bytedance.location.protobuf.MapFieldSchemaFull");     // Catch: Exception -> L4
        return (MapFieldSchema) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        return null;
    }
}
