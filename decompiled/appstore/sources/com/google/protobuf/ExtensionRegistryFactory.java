package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    public ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite create() {
        if (EXTENSION_REGISTRY_CLASS == null) goto L7;
        return invokeSubclassFactory("newInstance");
    L7:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        if (EXTENSION_REGISTRY_CLASS == null) goto L7;
        return invokeSubclassFactory("getEmptyRegistry");
    L7:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String r10) throws Exception {
        return (ExtensionRegistryLite) EXTENSION_REGISTRY_CLASS.getMethod(r10, null).invoke(null, null);
    }

    public static boolean isFullRegistry(ExtensionRegistryLite r10) {
        Class<?> r11 = EXTENSION_REGISTRY_CLASS;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.isAssignableFrom(r10.getClass()) == false) goto L7;
        return true;
    }

    public static Class<?> reflectExtensionRegistry() {
        ExtensionRegistry r10 = ExtensionRegistry.EMPTY_REGISTRY;     // Catch: ClassNotFoundException -> L4
        return ExtensionRegistry.class;
    L4:
        return null;
    }
}
