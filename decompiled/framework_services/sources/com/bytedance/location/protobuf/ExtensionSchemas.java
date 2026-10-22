package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = null;
    private static final ExtensionSchema<?> LITE_SCHEMA = null;

    ExtensionSchemas() {
    }

    static {
        LITE_SCHEMA = new ExtensionSchemaLite();
        FULL_SCHEMA = loadSchemaForFullRuntime();
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        Class<?> clazz = Class.forName("com.bytedance.location.protobuf.ExtensionSchemaFull");     // Catch: Exception -> L4
        return (ExtensionSchema) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        return null;
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    static ExtensionSchema<?> full() {
        if (FULL_SCHEMA == null) goto L7;
        return FULL_SCHEMA;
    L7:
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
