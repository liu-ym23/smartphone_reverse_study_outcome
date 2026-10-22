package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class u extends i2 implements DescriptorProtos$DescriptorProtoOrBuilder {
    private static final u DEFAULT_INSTANCE;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private static volatile p3 PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    private int bitField0_;
    private o2 enumType_;
    private o2 extensionRange_;
    private o2 extension_;
    private o2 field_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private o2 nestedType_;
    private o2 oneofDecl_;
    private d1 options_;
    private o2 reservedName_;
    private o2 reservedRange_;

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        i2.n(u.class, uVar);
    }

    public u() {
        r3 r3Var = r3.f2514j;
        this.field_ = r3Var;
        this.extension_ = r3Var;
        this.nestedType_ = r3Var;
        this.enumType_ = r3Var;
        this.extensionRange_ = r3Var;
        this.oneofDecl_ = r3Var;
        this.reservedRange_ = r3Var;
        this.reservedName_ = r3Var;
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 1:
                this.memoizedIsInitialized = (byte) (i2Var == null ? 0 : 1);
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", q0.class, "nestedType_", u.class, "enumType_", y.class, "extensionRange_", s.class, "extension_", q0.class, "options_", "oneofDecl_", h1.class, "reservedRange_", t.class, "reservedName_"});
            case 3:
                return new u();
            case 4:
                return new b7.a(7, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (u.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final y getEnumType(int i2) {
        return (y) this.enumType_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getEnumTypeCount() {
        return this.enumType_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getEnumTypeList() {
        return this.enumType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final q0 getExtension(int i2) {
        return (q0) this.extension_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final int getExtensionCount() {
        return this.extension_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final List getExtensionList() {
        return this.extension_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final s getExtensionRange(int i2) {
        return (s) this.extensionRange_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final List getExtensionRangeList() {
        return this.extensionRange_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final q0 getField(int i2) {
        return (q0) this.field_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final int getFieldCount() {
        return this.field_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final List getFieldList() {
        return this.field_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final u getNestedType(int i2) {
        return (u) this.nestedType_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final int getNestedTypeCount() {
        return this.nestedType_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final List getNestedTypeList() {
        return this.nestedType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final h1 getOneofDecl(int i2) {
        return (h1) this.oneofDecl_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final List getOneofDeclList() {
        return this.oneofDecl_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    /* renamed from: getOptions */
    public final d1 mo2getOptions() {
        d1 d1Var = this.options_;
        return d1Var == null ? d1.q() : d1Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final String getReservedName(int i2) {
        return (String) this.reservedName_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final l getReservedNameBytes(int i2) {
        return l.i((String) this.reservedName_.get(i2));
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final int getReservedNameCount() {
        return this.reservedName_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final List getReservedNameList() {
        return this.reservedName_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder
    public final t getReservedRange(int i2) {
        return (t) this.reservedRange_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final List getReservedRangeList() {
        return this.reservedRange_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }
}
