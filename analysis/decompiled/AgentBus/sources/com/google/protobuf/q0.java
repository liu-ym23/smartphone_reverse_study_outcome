package com.google.protobuf;

import fi.iki.elonen.NanoHTTPD;

/* loaded from: classes.dex */
public final class q0 extends i2 implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
    private static final q0 DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private static volatile p3 PARSER = null;
    public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private int bitField0_;
    private int number_;
    private int oneofIndex_;
    private x0 options_;
    private boolean proto3Optional_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private int label_ = 1;
    private int type_ = 1;
    private String typeName_ = "";
    private String extendee_ = "";
    private String defaultValue_ = "";
    private String jsonName_ = "";

    static {
        q0 q0Var = new q0();
        DEFAULT_INSTANCE = q0Var;
        i2.n(q0.class, q0Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004᠌\u0002\u0005᠌\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", v.f2572j, "type_", v.f2573k, "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
            case 3:
                return new q0();
            case 4:
                return new b7.a(15, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (q0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public final String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public final l getDefaultValueBytes() {
        return l.i(this.defaultValue_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final String getExtendee() {
        return this.extendee_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final l getExtendeeBytes() {
        return l.i(this.extendee_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public final String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public final l getJsonNameBytes() {
        return l.i(this.jsonName_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final o0 getLabel() {
        o0 o0VarA = o0.a(this.label_);
        return o0VarA == null ? o0.LABEL_OPTIONAL : o0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.FieldOrBuilder
    public final int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    /* renamed from: getOptions */
    public final x0 mo7getOptions() {
        x0 x0Var = this.options_;
        return x0Var == null ? x0.q() : x0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean getProto3Optional() {
        return this.proto3Optional_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final p0 getType() {
        p0 p0VarA = p0.a(this.type_);
        return p0VarA == null ? p0.TYPE_DOUBLE : p0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final String getTypeName() {
        return this.typeName_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final l getTypeNameBytes() {
        return l.i(this.typeName_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasDefaultValue() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasExtendee() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasJsonName() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasLabel() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasOneofIndex() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasProto3Optional() {
        return (this.bitField0_ & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasType() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder
    public final boolean hasTypeName() {
        return (this.bitField0_ & 16) != 0;
    }
}
