package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ExtensionRegistry extends ExtensionRegistryLite {
    static final ExtensionRegistry EMPTY_REGISTRY = null;
    private final Map<String, ExtensionInfo> immutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    private final Map<String, ExtensionInfo> mutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = null;

        static {
            int[] r0 = new int[Extension.ExtensionType.values().length];
            $SwitchMap$com$google$protobuf$Extension$ExtensionType = r0;
            r0[Extension.ExtensionType.IMMUTABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.MUTABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final class DescriptorIntPair {
        private final Descriptors.Descriptor descriptor;
        private final int number;

        static /* synthetic */ Descriptors.Descriptor access$000(DescriptorIntPair r0) {
            return r0.descriptor;
        }

        DescriptorIntPair(Descriptors.Descriptor r1, int r2) {
            this.descriptor = r1;
            this.number = r2;
        }

        public int hashCode() {
            return (this.descriptor.hashCode() * SupportMenu.USER_MASK) + this.number;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, DescriptorIntPair.class) == true) goto L5;
            return false;
        L5:
            DescriptorIntPair r5 = (DescriptorIntPair) ZeusTransformUtils.preCheckCast(r4, DescriptorIntPair.class, "com.obric.aiagent.plugin");
            if (this.descriptor == r5.descriptor) goto L8;
            return false;
        L8:
            if (this.number != r5.number) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor r2, Message r3, AnonymousClass1 r4) {
            this(r2, (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin"));
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r1) {
            this.descriptor = r1;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r3, Message r4) {
            Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.aiagent.plugin");
            this.descriptor = r3;
            this.defaultInstance = r5;
        }
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public /* bridge */ /* synthetic */ ExtensionRegistryLite getUnmodifiable() {
        return getUnmodifiable();
    }

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    @Deprecated
    public ExtensionInfo findExtensionByName(String r1) {
        return findImmutableExtensionByName(r1);
    }

    public ExtensionInfo findImmutableExtensionByName(String r2) {
        return (ExtensionInfo) ZeusTransformUtils.preCheckCast(this.immutableExtensionsByName.get(r2), ExtensionInfo.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public ExtensionInfo findMutableExtensionByName(String r2) {
        return (ExtensionInfo) ZeusTransformUtils.preCheckCast(this.mutableExtensionsByName.get(r2), ExtensionInfo.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor r1, int r2) {
        return findImmutableExtensionByNumber(r1, r2);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor r2, int r3) {
        return (ExtensionInfo) ZeusTransformUtils.preCheckCast(this.immutableExtensionsByNumber.get(new DescriptorIntPair(r2, r3)), ExtensionInfo.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor r2, int r3) {
        return (ExtensionInfo) ZeusTransformUtils.preCheckCast(this.mutableExtensionsByNumber.get(new DescriptorIntPair(r2, r3)), ExtensionInfo.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String r6) {
        HashSet r0 = new HashSet();
        Iterator<DescriptorIntPair> r1 = this.mutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        DescriptorIntPair r2 = (DescriptorIntPair) ZeusTransformUtils.preCheckCast(r1.next(), DescriptorIntPair.class, "com.obric.aiagent.plugin");
        if (DescriptorIntPair.access$000(r2).getFullName().equals(r6) == false) goto L4;
        r0.add((ExtensionInfo) ZeusTransformUtils.preCheckCast(this.mutableExtensionsByNumber.get(r2), ExtensionInfo.class, "com.obric.aiagent.plugin"));
        goto L4
    L8:
        return r0;
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String r6) {
        HashSet r0 = new HashSet();
        Iterator<DescriptorIntPair> r1 = this.immutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        DescriptorIntPair r2 = (DescriptorIntPair) ZeusTransformUtils.preCheckCast(r1.next(), DescriptorIntPair.class, "com.obric.aiagent.plugin");
        if (DescriptorIntPair.access$000(r2).getFullName().equals(r6) == false) goto L4;
        r0.add((ExtensionInfo) ZeusTransformUtils.preCheckCast(this.immutableExtensionsByNumber.get(r2), ExtensionInfo.class, "com.obric.aiagent.plugin"));
        goto L4
    L8:
        return r0;
    }

    public void add(Extension<?, ?> r3) {
        if (r3.getExtensionType() != Extension.ExtensionType.IMMUTABLE) goto L5;
    L7:
        add(newExtensionInfo(r3), r3.getExtensionType());
        return;
    L5:
        if (r3.getExtensionType() == Extension.ExtensionType.MUTABLE) goto L7;
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> r1) {
        add(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static ExtensionInfo newExtensionInfo(Extension<?, ?> r3) {
        AnonymousClass1 r2 = null;
        Object[] r4 = 0;
        Object[] r5 = 0;
        if (r3.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        if (r3.getMessageDefaultInstance() == null) goto L9;
        return new ExtensionInfo(r3.getDescriptor(), r3.getMessageDefaultInstance(), r2);
    L9:
        throw new IllegalStateException("Registered message-type extension had null default instance: " + r3.getDescriptor().getFullName());
    L11:
        return new ExtensionInfo(r3.getDescriptor(), r5 == true ? 1 : 0, r4 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(Descriptors.FieldDescriptor r3) {
        if (r3.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        ExtensionInfo r0 = new ExtensionInfo(r3, null, 0 == true ? 1 : 0);
        add(r0, Extension.ExtensionType.IMMUTABLE);
        add(r0, Extension.ExtensionType.MUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    public void add(Descriptors.FieldDescriptor r3, Message r4) {
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.aiagent.plugin");
        if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        add(new ExtensionInfo(r3, r5, null), Extension.ExtensionType.IMMUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }

    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    private ExtensionRegistry(ExtensionRegistry r2) {
        super(r2);
        this.immutableExtensionsByName = Collections.unmodifiableMap(r2.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(r2.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(r2.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(r2.mutableExtensionsByNumber);
    }

    ExtensionRegistry(boolean r1) {
        super(EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    static {
        EMPTY_REGISTRY = new ExtensionRegistry(true);
    }

    private void add(ExtensionInfo r4, Extension.ExtensionType r5) {
        if (r4.descriptor.isExtension() == false) goto L22;
        int r6 = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[r5.ordinal()];
        if (r6 != 1) goto L7;
        Map<String, ExtensionInfo> r7 = this.immutableExtensionsByName;
        Map<DescriptorIntPair, ExtensionInfo> r3 = this.immutableExtensionsByNumber;
    L11:
        r7.put(r4.descriptor.getFullName(), r4);
        r3.put(new DescriptorIntPair(r4.descriptor.getContainingType(), r4.descriptor.getNumber()), r4);
        Descriptors.FieldDescriptor r8 = r4.descriptor;
        if (r8.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L14;
        return;
    L14:
        if (r8.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) goto L16;
        return;
    L16:
        if (r8.isOptional() == true) goto L18;
        return;
    L18:
        if (r8.getExtensionScope() != r8.getMessageType()) goto L26;
        r7.put(r8.getMessageType().getFullName(), r4);
        return;
    L26:
        return;
    L7:
        if (r6 == 2) goto L9;
        return;
    L9:
        r7 = this.mutableExtensionsByName;
        r3 = this.mutableExtensionsByNumber;
        goto L11
    L22:
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }
}
