package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class y extends i2 implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
    private static final y DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile p3 PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 5;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private a0 options_;
    private o2 reservedName_;
    private o2 reservedRange_;
    private o2 value_;

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        i2.n(y.class, yVar);
    }

    public y() {
        r3 r3Var = r3.f2514j;
        this.value_ = r3Var;
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", b0.class, "options_", "reservedRange_", x.class, "reservedName_"});
            case 3:
                return new y();
            case 4:
                return new b7.a(10, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (y.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final a0 getOptions() {
        a0 a0Var = this.options_;
        return a0Var == null ? a0.q() : a0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final String getReservedName(int i2) {
        return (String) this.reservedName_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final l getReservedNameBytes(int i2) {
        return l.i((String) this.reservedName_.get(i2));
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final int getReservedNameCount() {
        return this.reservedName_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final List getReservedNameList() {
        return this.reservedName_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    /* renamed from: getReservedRange */
    public final x mo9getReservedRange(int i2) {
        return (x) this.reservedRange_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final List getReservedRangeList() {
        return this.reservedRange_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final b0 getValue(int i2) {
        return (b0) this.value_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final int getValueCount() {
        return this.value_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder
    public final List getValueList() {
        return this.value_;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }
}
