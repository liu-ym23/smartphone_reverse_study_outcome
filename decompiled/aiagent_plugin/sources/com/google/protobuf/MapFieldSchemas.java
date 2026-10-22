package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class MapFieldSchemas {
    private static final MapFieldSchema FULL_SCHEMA = null;
    private static final MapFieldSchema LITE_SCHEMA = null;

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
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        return (MapFieldSchema) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.protobuf.MapFieldSchemaFull", "com.obric.aiagent.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), MapFieldSchema.class, "com.obric.aiagent.plugin");
    L7:
        return null;
    }

    private MapFieldSchemas() {
    }
}
