package com.google.protobuf;

/* loaded from: classes.dex */
public final class t extends i2 implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
    private static final t DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 2;
    private static volatile p3 PARSER = null;
    public static final int START_FIELD_NUMBER = 1;
    private int bitField0_;
    private int end_;
    private int start_;

    static {
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        i2.n(t.class, tVar);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
            case 3:
                return new t();
            case 4:
                return new b7.a(9, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (t.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final int getEnd() {
        return this.end_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public final int getStart() {
        return this.start_;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder
    public final boolean hasEnd() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder
    public final boolean hasStart() {
        return (this.bitField0_ & 1) != 0;
    }
}
