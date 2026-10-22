package com.google.protobuf;

/* loaded from: classes.dex */
public final class s0 extends i2 implements DescriptorProtos$FieldOptions$EditionDefaultOrBuilder {
    private static final s0 DEFAULT_INSTANCE;
    public static final int EDITION_FIELD_NUMBER = 3;
    private static volatile p3 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int edition_;
    private String value_ = "";

    static {
        s0 s0Var = new s0();
        DEFAULT_INSTANCE = s0Var;
        i2.n(s0.class, s0Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဈ\u0001\u0003᠌\u0000", new Object[]{"bitField0_", "value_", "edition_", v.f2564b});
            case 3:
                return new s0();
            case 4:
                return new b7.a(16, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (s0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final w getEdition() {
        w wVarA = w.a(this.edition_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    /* renamed from: getValue */
    public final String mo13getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    public final l getValueBytes() {
        return l.i(this.value_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasEdition() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder
    public final boolean hasValue() {
        return (this.bitField0_ & 2) != 0;
    }
}
