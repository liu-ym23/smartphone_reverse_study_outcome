package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum NullValue extends java.lang.Enum<NullValue> implements ProtocolMessageEnum {
    private static final /* synthetic */ NullValue[] $VALUES = null;
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;
    private static final NullValue[] VALUES = null;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    private static /* synthetic */ NullValue[] $values() {
        return new NullValue[]{NULL_VALUE, UNRECOGNIZED};
    }

    public static NullValue valueOf(String r2) {
        return (NullValue) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(NullValue.class, r2), NullValue.class, "com.obric.aiagent.plugin");
    }

    public static NullValue[] values() {
        return (NullValue[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NullValue[].class, "com.obric.aiagent.plugin");
    }

    static {
        NULL_VALUE = new NullValue("NULL_VALUE", 0, 0);
        UNRECOGNIZED = new NullValue("UNRECOGNIZED", 1, -1);
        $VALUES = $values();
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", NullValue.class.getName());
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int r0) {
        return forNumber(r0);
    }

    public static NullValue forNumber(int r0) {
        if (r0 == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) goto L7;
        return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin");
    L7:
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(StructProto.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.aiagent.plugin");
    }

    public static NullValue valueOf(Descriptors.EnumValueDescriptor r2) {
        if (r2.getType() != getDescriptor()) goto L11;
        if (r2.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r2.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    private NullValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
