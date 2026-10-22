package com.bytedance.location.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.bytedance.location.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck;
    private static volatile boolean eagerlyParseMessageSets;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static class ExtensionClassHolder {
        static final Class<?> INSTANCE = null;

        private ExtensionClassHolder() {
        }

        static {
            INSTANCE = resolveExtensionClass();
        }

        static Class<?> resolveExtensionClass() {
            return Class.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME);
        L5:
            return null;
        }
    }

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object object, int number) {
            this.object = object;
            this.number = number;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair other = (ObjectIntPair) obj;
            if (this.object == other.object) goto L8;
            return false;
        L8:
            if (this.number != other.number) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        eagerlyParseMessageSets = false;
        doFullRuntimeInheritanceCheck = true;
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean isEagerlyParse) {
        eagerlyParseMessageSets = isEagerlyParse;
    }

    public static ExtensionRegistryLite newInstance() {
        if (doFullRuntimeInheritanceCheck == false) goto L6;
        return ExtensionRegistryFactory.create();
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite result = emptyRegistry;
        if (result == null) goto L5;
    L19:
        return result;
    L5:
        monitor-enter(ExtensionRegistryLite.class);
        result = emptyRegistry;     // Catch: Throwable -> L11
        if (result == null) goto L9;
    L15:
        monitor-exit(ExtensionRegistryLite.class);     // Catch: Throwable -> L11
        goto L19
    L9:
        if (doFullRuntimeInheritanceCheck == false) goto L13;
        ExtensionRegistryLite r2 = ExtensionRegistryFactory.createEmpty();     // Catch: Throwable -> L11
    L14:
        emptyRegistry = r2;     // Catch: Throwable -> L11
        result = r2;
        goto L15
    L13:
        r2 = EMPTY_REGISTRY_LITE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingTypeDefaultInstance, int fieldNumber) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(containingTypeDefaultInstance, fieldNumber));
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> extension) {
        this.extensionsByNumber.put(new ObjectIntPair(extension.getContainingTypeDefaultInstance(), extension.getNumber()), extension);
    }

    public final void add(ExtensionLite<?, ?> extension) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extension.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) extension);
    L6:
        if (doFullRuntimeInheritanceCheck == true) goto L8;
        return;
    L8:
        if (ExtensionRegistryFactory.isFullRegistry(this) == false) goto L17;
        getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{extension});     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{extension}), e);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite other) {
        if (other != EMPTY_REGISTRY_LITE) goto L5;
        this.extensionsByNumber = Collections.emptyMap();
        return;
    L5:
        this.extensionsByNumber = Collections.unmodifiableMap(other.extensionsByNumber);
    }

    ExtensionRegistryLite(boolean empty) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
