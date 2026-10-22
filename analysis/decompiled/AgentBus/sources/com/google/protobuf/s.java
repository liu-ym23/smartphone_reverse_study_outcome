package com.google.protobuf;

/* loaded from: classes.dex */
public final class s extends i2 implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
    private static final s DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile p3 PARSER = null;
    public static final int START_FIELD_NUMBER = 1;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized = 2;
    private f0 options_;
    private int start_;

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        i2.n(s.class, sVar);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
            case 3:
                return new s();
            case 4:
                return new b7.a(8, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (s.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final int getEnd() {
        return this.end_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder
    /* renamed from: getOptions */
    public final f0 mo3getOptions() {
        f0 f0Var = this.options_;
        return f0Var == null ? f0.q() : f0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public final int getStart() {
        return this.start_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasEnd() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder
    public final boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public final boolean hasStart() {
        return (this.bitField0_ & 1) != 0;
    }
}
