package com.google.protobuf;

/* loaded from: classes.dex */
public final class e1 extends i2 implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private static final e1 DEFAULT_INSTANCE;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private static volatile p3 PARSER = null;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private int bitField0_;
    private boolean clientStreaming_;
    private g1 options_;
    private boolean serverStreaming_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String inputType_ = "";
    private String outputType_ = "";

    static {
        e1 e1Var = new e1();
        DEFAULT_INSTANCE = e1Var;
        i2.n(e1.class, e1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
            case 3:
                return new e1();
            case 4:
                return new b7.a(20, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (e1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final String getInputType() {
        return this.inputType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final l getInputTypeBytes() {
        return l.i(this.inputType_);
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    /* renamed from: getOptions */
    public final g1 mo4getOptions() {
        g1 g1Var = this.options_;
        return g1Var == null ? g1.q() : g1Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final String getOutputType() {
        return this.outputType_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final l getOutputTypeBytes() {
        return l.i(this.outputType_);
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean hasClientStreaming() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean hasInputType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean hasOutputType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder
    public final boolean hasServerStreaming() {
        return (this.bitField0_ & 32) != 0;
    }
}
