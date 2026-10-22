package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = null;
    private static final NewInstanceSchema LITE_SCHEMA = null;

    NewInstanceSchemas() {
    }

    static {
        FULL_SCHEMA = loadSchemaForFullRuntime();
        LITE_SCHEMA = new NewInstanceSchemaLite();
    }

    static NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    static NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    private static NewInstanceSchema loadSchemaForFullRuntime() {
        Class<?> clazz = Class.forName("com.bytedance.location.protobuf.NewInstanceSchemaFull");     // Catch: Exception -> L4
        return (NewInstanceSchema) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        return null;
    }
}
