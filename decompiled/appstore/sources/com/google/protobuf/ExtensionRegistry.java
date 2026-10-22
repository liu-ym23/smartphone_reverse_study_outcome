package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistry extends ExtensionRegistryLite {
    static final ExtensionRegistry EMPTY_REGISTRY = null;
    private final Map<String, ExtensionInfo> immutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    private final Map<String, ExtensionInfo> mutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = null;

        static {
            int[] r10 = new int[Extension.ExtensionType.values().length];
            $SwitchMap$com$google$protobuf$Extension$ExtensionType = r10;
            r10[Extension.ExtensionType.IMMUTABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.MUTABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class DescriptorIntPair {
        private final Descriptors.Descriptor descriptor;
        private final int number;

        public DescriptorIntPair(Descriptors.Descriptor r10, int r11) {
            this.descriptor = r10;
            this.number = r11;
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(DescriptorIntPair r10) {
            return r10.descriptor;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof DescriptorIntPair) == true) goto L5;
            return false;
        L5:
            DescriptorIntPair r11 = (DescriptorIntPair) r10;
            if (this.descriptor == r11.descriptor) goto L8;
            return false;
        L8:
            if (this.number != r11.number) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.descriptor.hashCode() * SupportMenu.USER_MASK) + this.number;
        }
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        public /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor r10, Message r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r10) {
            this.descriptor = r10;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r10, Message r11) {
            this.descriptor = r10;
            this.defaultInstance = r11;
        }
    }

    static {
        EMPTY_REGISTRY = new ExtensionRegistry(true);
    }

    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ExtensionInfo newExtensionInfo(Extension<?, ?> r10) {
        AnonymousClass1 r11 = null;
        Object[] r12 = 0;
        Object[] r13 = 0;
        if (r10.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        if (r10.getMessageDefaultInstance() == null) goto L9;
        return new ExtensionInfo(r10.getDescriptor(), (Message) r10.getMessageDefaultInstance(), r11);
    L9:
        throw new IllegalStateException("Registered message-type extension had null default instance: " + r10.getDescriptor().getFullName());
    L11:
        return new ExtensionInfo(r10.getDescriptor(), r13 == true ? 1 : 0, r12 == true ? 1 : 0);
    }

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public void add(Extension<?, ?> r10) {
        if (r10.getExtensionType() != Extension.ExtensionType.IMMUTABLE) goto L5;
    L7:
        add(newExtensionInfo(r10), r10.getExtensionType());
        return;
    L5:
        if (r10.getExtensionType() == Extension.ExtensionType.MUTABLE) goto L7;
    }

    public ExtensionInfo findExtensionByName(String r10) {
        return findImmutableExtensionByName(r10);
    }

    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor r10, int r11) {
        return findImmutableExtensionByNumber(r10, r11);
    }

    public ExtensionInfo findImmutableExtensionByName(String r10) {
        return this.immutableExtensionsByName.get(r10);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor r10, int r11) {
        return this.immutableExtensionsByNumber.get(new DescriptorIntPair(r10, r11));
    }

    public ExtensionInfo findMutableExtensionByName(String r10) {
        return this.mutableExtensionsByName.get(r10);
    }

    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor r10, int r11) {
        return this.mutableExtensionsByNumber.get(new DescriptorIntPair(r10, r11));
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String r10) {
        HashSet r11 = new HashSet();
        Iterator<DescriptorIntPair> r12 = this.immutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        DescriptorIntPair r13 = r12.next();
        if (DescriptorIntPair.access$000(r13).getFullName().equals(r10) == false) goto L4;
        r11.add(this.immutableExtensionsByNumber.get(r13));
        goto L4
    L8:
        return r11;
    }

    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String r10) {
        HashSet r11 = new HashSet();
        Iterator<DescriptorIntPair> r12 = this.mutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        DescriptorIntPair r13 = r12.next();
        if (DescriptorIntPair.access$000(r13).getFullName().equals(r10) == false) goto L4;
        r11.add(this.mutableExtensionsByNumber.get(r13));
        goto L4
    L8:
        return r11;
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public /* bridge */ /* synthetic */ ExtensionRegistryLite getUnmodifiable() {
        return getUnmodifiable();
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> r10) {
        add(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(Descriptors.FieldDescriptor r10) {
        if (r10.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        ExtensionInfo r11 = new ExtensionInfo(r10, null, 0 == true ? 1 : 0);
        add(r11, Extension.ExtensionType.IMMUTABLE);
        add(r11, Extension.ExtensionType.MUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    private ExtensionRegistry(ExtensionRegistry r10) {
        super(r10);
        this.immutableExtensionsByName = Collections.unmodifiableMap(r10.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(r10.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(r10.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(r10.mutableExtensionsByNumber);
    }

    public void add(Descriptors.FieldDescriptor r10, Message r11) {
        if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        add(new ExtensionInfo(r10, r11, null), Extension.ExtensionType.IMMUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }

    private void add(ExtensionInfo r10, Extension.ExtensionType r11) {
        if (r10.descriptor.isExtension() == false) goto L22;
        int r12 = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[r11.ordinal()];
        if (r12 != 1) goto L7;
        Map<String, ExtensionInfo> r13 = this.immutableExtensionsByName;
        Map<DescriptorIntPair, ExtensionInfo> r14 = this.immutableExtensionsByNumber;
    L11:
        r13.put(r10.descriptor.getFullName(), r10);
        r14.put(new DescriptorIntPair(r10.descriptor.getContainingType(), r10.descriptor.getNumber()), r10);
        Descriptors.FieldDescriptor r15 = r10.descriptor;
        if (r15.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L14;
        return;
    L14:
        if (r15.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) goto L16;
        return;
    L16:
        if (r15.isOptional() == true) goto L18;
        return;
    L18:
        if (r15.getExtensionScope() != r15.getMessageType()) goto L26;
        r13.put(r15.getMessageType().getFullName(), r10);
        return;
    L26:
        return;
    L7:
        if (r12 == 2) goto L9;
        return;
    L9:
        r13 = this.mutableExtensionsByName;
        r14 = this.mutableExtensionsByNumber;
        goto L11
    L22:
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }

    public ExtensionRegistry(boolean r10) {
        super(ExtensionRegistryLite.EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }
}
