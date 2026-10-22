package com.google.protobuf;

/* loaded from: classes.dex */
public final class d0 extends i2 implements DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder {
    private static final d0 DEFAULT_INSTANCE;
    public static final int FULL_NAME_FIELD_NUMBER = 2;
    public static final int NUMBER_FIELD_NUMBER = 1;
    private static volatile p3 PARSER = null;
    public static final int REPEATED_FIELD_NUMBER = 6;
    public static final int RESERVED_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 3;
    private int bitField0_;
    private int number_;
    private boolean repeated_;
    private boolean reserved_;
    private String fullName_ = "";
    private String type_ = "";

    static {
        d0 d0Var = new d0();
        DEFAULT_INSTANCE = d0Var;
        i2.n(d0.class, d0Var);
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"bitField0_", "number_", "fullName_", "type_", "reserved_", "repeated_"});
            case 3:
                return new d0();
            case 4:
                return new b7.a(13, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (d0.class) {
                    try {
                        g2Var = PARSER;
                        if (g2Var == null) {
                            g2Var = new g2();
                            PARSER = g2Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g2Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final String getFullName() {
        return this.fullName_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final l getFullNameBytes() {
        return l.i(this.fullName_);
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final boolean getRepeated() {
        return this.repeated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final boolean getReserved() {
        return this.reserved_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    /* renamed from: getType */
    public final String mo12getType() {
        return this.type_;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final l getTypeBytes() {
        return l.i(this.type_);
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final boolean hasFullName() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final boolean hasRepeated() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder
    public final boolean hasReserved() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$ExtensionRangeOptions$DeclarationOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasType() {
        return (this.bitField0_ & 4) != 0;
    }
}
