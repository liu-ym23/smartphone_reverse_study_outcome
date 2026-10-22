package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    ExtensionRegistryFactory() {
    }

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    static Class<?> reflectExtensionRegistry() {
        return ZeusTransformUtils.forName(FULL_REGISTRY_CLASS_NAME, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite r0 = invokeSubclassFactory("newInstance");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite r0 = invokeSubclassFactory("getEmptyRegistry");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    static boolean isFullRegistry(ExtensionRegistryLite r1) {
        if (Protobuf.assumeLiteRuntime == true) goto L9;
        Class<?> r0 = EXTENSION_REGISTRY_CLASS;
        if (r0 == null) goto L9;
        if (r0.isAssignableFrom(r1.getClass()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String r4) {
        Class<?> r0 = EXTENSION_REGISTRY_CLASS;
        if (r0 != null) goto L9;
        return null;
    L9:
        return (ExtensionRegistryLite) ZeusTransformUtils.preCheckCast(r0.getDeclaredMethod(r4, new Class[0]).invoke(null, new Object[0]), ExtensionRegistryLite.class, "com.obric.aiagent.plugin");
    L8:
        return null;
    }
}
