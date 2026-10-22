package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final enum Syntax extends java.lang.Enum<Syntax> implements ProtocolMessageEnum {
    private static final /* synthetic */ Syntax[] $VALUES = null;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;
    private static final Syntax[] VALUES = null;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    static {
        Syntax r10 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = r10;
        Syntax r11 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_PROTO3 = r11;
        Syntax r12 = new Syntax("UNRECOGNIZED", 2, -1);
        UNRECOGNIZED = r12;
        $VALUES = new Syntax[]{r10, r11, r12};
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    private Syntax(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static Syntax forNumber(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return null;
    L8:
        return SYNTAX_PROTO3;
    L10:
        return SYNTAX_PROTO2;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Syntax valueOf(String r10) {
        return (Syntax) java.lang.Enum.valueOf(Syntax.class, r10);
    }

    public static Syntax[] values() {
        return (Syntax[]) $VALUES.clone();
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
    public static Syntax valueOf(int r10) {
        return forNumber(r10);
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor r10) {
        if (r10.getType() != getDescriptor()) goto L11;
        if (r10.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r10.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
