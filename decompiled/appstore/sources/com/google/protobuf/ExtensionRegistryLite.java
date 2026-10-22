package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static volatile boolean eagerlyParseMessageSets = false;
    private static final Class<?> extensionClass = null;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public ObjectIntPair(Object r10, int r11) {
            this.object = r10;
            this.number = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r11 = (ObjectIntPair) r10;
            if (this.object == r11.object) goto L8;
            return false;
        L8:
            if (this.number != r11.number) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }
    }

    static {
        extensionClass = resolveExtensionClass();
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return ExtensionRegistryFactory.createEmpty();
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static ExtensionRegistryLite newInstance() {
        return ExtensionRegistryFactory.create();
    }

    public static Class<?> resolveExtensionClass() {
        return Extension.class;
    }

    public static void setEagerlyParseMessageSets(boolean r10) {
        eagerlyParseMessageSets = r10;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r10) {
        this.extensionsByNumber.put(new ObjectIntPair(r10.getContainingTypeDefaultInstance(), r10.getNumber()), r10);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r10, int r11) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r10, r11));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite r10) {
        if (r10 != EMPTY_REGISTRY_LITE) goto L5;
        this.extensionsByNumber = Collections.emptyMap();
        return;
    L5:
        this.extensionsByNumber = Collections.unmodifiableMap(r10.extensionsByNumber);
    }

    public final void add(ExtensionLite<?, ?> r10) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(r10.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) r10);
    L6:
        if (ExtensionRegistryFactory.isFullRegistry(this) == true) goto L13;
        return;
    L13:
        getClass().getMethod("add", new Class[]{extensionClass}).invoke(this, new Object[]{r10});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{r10}), e);
    }

    public ExtensionRegistryLite(boolean r10) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
