package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.bytedance.location.protobuf.ExtensionRegistry";

    ExtensionRegistryFactory() {
    }

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    static Class<?> reflectExtensionRegistry() {
        return Class.forName(FULL_REGISTRY_CLASS_NAME);
    L5:
        return null;
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite result = invokeSubclassFactory("newInstance");
        if (result == null) goto L6;
        return result;
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite result = invokeSubclassFactory("getEmptyRegistry");
        if (result == null) goto L6;
        return result;
    L6:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    static boolean isFullRegistry(ExtensionRegistryLite registry) {
        if (EXTENSION_REGISTRY_CLASS != null) goto L5;
    L7:
        return false;
    L5:
        if (EXTENSION_REGISTRY_CLASS.isAssignableFrom(registry.getClass()) == false) goto L7;
        return true;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String methodName) {
        if (EXTENSION_REGISTRY_CLASS != null) goto L9;
        return null;
    L9:
        return (ExtensionRegistryLite) EXTENSION_REGISTRY_CLASS.getDeclaredMethod(methodName, new Class[0]).invoke(null, new Object[0]);
    L8:
        return null;
    }
}
