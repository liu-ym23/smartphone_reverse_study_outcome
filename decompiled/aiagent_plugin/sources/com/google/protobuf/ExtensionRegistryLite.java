package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static volatile boolean eagerlyParseMessageSets = false;
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
            return ZeusTransformUtils.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME, "com.obric.aiagent.plugin");
        L4:
            return null;
        }
    }

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object r1, int r2) {
            this.object = r1;
            this.number = r2;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ObjectIntPair.class) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r5 = (ObjectIntPair) ZeusTransformUtils.preCheckCast(r4, ObjectIntPair.class, "com.obric.aiagent.plugin");
            if (this.object == r5.object) goto L8;
            return false;
        L8:
            if (this.number != r5.number) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean r0) {
        eagerlyParseMessageSets = r0;
    }

    public static ExtensionRegistryLite newInstance() {
        if (Protobuf.assumeLiteRuntime == false) goto L6;
        return new ExtensionRegistryLite();
    L6:
        return ExtensionRegistryFactory.create();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (Protobuf.assumeLiteRuntime == true) goto L5;
        ExtensionRegistryLite r0 = emptyRegistry;
        if (r0 == null) goto L9;
    L18:
        return r0;
    L9:
        monitor-enter(ExtensionRegistryLite.class);
        r0 = emptyRegistry;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        r0 = ExtensionRegistryFactory.createEmpty();     // Catch: Throwable -> L15
        emptyRegistry = r0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(ExtensionRegistryLite.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L5:
        return EMPTY_REGISTRY_LITE;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r3, int r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.aiagent.plugin");
        return (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(this.extensionsByNumber.get(new ObjectIntPair(r5, r4)), GeneratedMessageLite.GeneratedExtension.class, "com.obric.aiagent.plugin");
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r4) {
        this.extensionsByNumber.put(new ObjectIntPair(r4.getContainingTypeDefaultInstance(), r4.getNumber()), r4);
    }

    public final void add(ExtensionLite<?, ?> r7) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(r7.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r7, GeneratedMessageLite.GeneratedExtension.class, "com.obric.aiagent.plugin"));
    L6:
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return;
    L8:
        if (ExtensionRegistryFactory.isFullRegistry(this) == true) goto L16;
        return;
    L16:
        getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{r7});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{r7}), e);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    static {
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    ExtensionRegistryLite(ExtensionRegistryLite r2) {
        if (r2 != EMPTY_REGISTRY_LITE) goto L5;
        this.extensionsByNumber = Collections.emptyMap();
        return;
    L5:
        this.extensionsByNumber = Collections.unmodifiableMap(r2.extensionsByNumber);
    }

    ExtensionRegistryLite(boolean r1) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
