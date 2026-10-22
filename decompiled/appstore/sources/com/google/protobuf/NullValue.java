package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final enum NullValue extends java.lang.Enum<NullValue> implements ProtocolMessageEnum {
    private static final /* synthetic */ NullValue[] $VALUES = null;
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;
    private static final NullValue[] VALUES = null;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    static {
        NullValue r10 = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = r10;
        NullValue r11 = new NullValue("UNRECOGNIZED", 1, -1);
        UNRECOGNIZED = r11;
        $VALUES = new NullValue[]{r10, r11};
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private NullValue(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static NullValue forNumber(int r10) {
        if (r10 == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return StructProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static NullValue valueOf(String r10) {
        return (NullValue) java.lang.Enum.valueOf(NullValue.class, r10);
    }

    public static NullValue[] values() {
        return (NullValue[]) $VALUES.clone();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    @Deprecated
    public static NullValue valueOf(int r10) {
        return forNumber(r10);
    }

    public static NullValue valueOf(Descriptors.EnumValueDescriptor r10) {
        if (r10.getType() != getDescriptor()) goto L11;
        if (r10.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r10.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
