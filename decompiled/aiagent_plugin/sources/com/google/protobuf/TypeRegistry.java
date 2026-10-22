package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class TypeRegistry {
    private static final Logger logger = null;
    private final Map<String, Descriptors.Descriptor> types;

    /* JADX INFO: renamed from: com.google.protobuf.TypeRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        public Builder add(Descriptors.Descriptor r2) {
            if (this.types == null) goto L7;
            addFile(r2.getFile());
            return this;
        L7:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public Builder add(Iterable<Descriptors.Descriptor> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
            if (this.types == null) goto L10;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            addFile(((Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r6.next(), Descriptors.Descriptor.class, "com.obric.aiagent.plugin")).getFile());
            goto L6
        L8:
            return this;
        L10:
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry r0 = new TypeRegistry(this.types);
            this.types = null;
            return r0;
        }

        private void addFile(Descriptors.FileDescriptor r5) {
            if (this.files.add(r5.getFullName()) == true) goto L5;
            return;
        L5:
            Iterator<Descriptors.FileDescriptor> r0 = r5.getDependencies().iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            addFile((Descriptors.FileDescriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.FileDescriptor.class, "com.obric.aiagent.plugin"));
            goto L7
        L9:
            Iterator<Descriptors.Descriptor> r6 = r5.getMessageTypes().iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            addMessage((Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r6.next(), Descriptors.Descriptor.class, "com.obric.aiagent.plugin"));
            goto L11
        }

        private void addMessage(Descriptors.Descriptor r5) {
            Iterator<Descriptors.Descriptor> r0 = r5.getNestedTypes().iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            addMessage((Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r0.next(), Descriptors.Descriptor.class, "com.obric.aiagent.plugin"));
            goto L4
        L7:
            if (this.types.containsKey(r5.getFullName()) == false) goto L10;
            TypeRegistry.access$200().warning("Type " + r5.getFullName() + " is added multiple times.");
            return;
        L10:
            this.types.put(r5.getFullName(), r5);
        }
    }

    private static class EmptyTypeRegistryHolder {
        private static final TypeRegistry EMPTY = null;

        private EmptyTypeRegistryHolder() {
        }

        static /* synthetic */ TypeRegistry access$000() {
            return EMPTY;
        }

        static {
            EMPTY = new TypeRegistry(Collections.emptyMap());
        }
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    static {
        logger = Logger.getLogger(TypeRegistry.class.getName());
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.access$000();
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public Descriptors.Descriptor find(String r2) {
        return (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(this.types.get(r2), Descriptors.Descriptor.class, "com.obric.aiagent.plugin");
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String r1) {
        return find(getTypeName(r1));
    }

    TypeRegistry(Map<String, Descriptors.Descriptor> r3) {
        this.types = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    private static String getTypeName(String r3) {
        String[] r0 = r3.split("/");
        if (r0.length <= 1) goto L7;
        return r0[r0.length - 1];
    L7:
        throw new InvalidProtocolBufferException("Invalid type url found: " + r3);
    }
}
