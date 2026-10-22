package com.google.protobuf;

/* loaded from: classes.dex */
public final class m0 extends h2 implements DescriptorProtos$FeatureSetOrBuilder {
    private static final m0 DEFAULT_INSTANCE;
    public static final int ENUM_TYPE_FIELD_NUMBER = 2;
    public static final int FIELD_PRESENCE_FIELD_NUMBER = 1;
    public static final int JSON_FORMAT_FIELD_NUMBER = 6;
    public static final int MESSAGE_ENCODING_FIELD_NUMBER = 5;
    private static volatile p3 PARSER = null;
    public static final int REPEATED_FIELD_ENCODING_FIELD_NUMBER = 3;
    public static final int UTF8_VALIDATION_FIELD_NUMBER = 4;
    private int bitField0_;
    private int enumType_;
    private int fieldPresence_;
    private int jsonFormat_;
    private byte memoizedIsInitialized = 2;
    private int messageEncoding_;
    private int repeatedFieldEncoding_;
    private int utf8Validation_;

    static {
        m0 m0Var = new m0();
        DEFAULT_INSTANCE = m0Var;
        i2.n(m0.class, m0Var);
    }

    public static m0 q() {
        return DEFAULT_INSTANCE;
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"bitField0_", "fieldPresence_", v.f2567e, "enumType_", v.f2566d, "repeatedFieldEncoding_", v.f2570h, "utf8Validation_", v.f2571i, "messageEncoding_", v.f2569g, "jsonFormat_", v.f2568f});
            case 3:
                return new m0();
            case 4:
                return new z(3, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (m0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final g0 getEnumType() {
        g0 g0VarA = g0.a(this.enumType_);
        return g0VarA == null ? g0.ENUM_TYPE_UNKNOWN : g0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final h0 getFieldPresence() {
        h0 h0VarA = h0.a(this.fieldPresence_);
        return h0VarA == null ? h0.FIELD_PRESENCE_UNKNOWN : h0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final i0 getJsonFormat() {
        i0 i0VarA = i0.a(this.jsonFormat_);
        return i0VarA == null ? i0.JSON_FORMAT_UNKNOWN : i0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final j0 getMessageEncoding() {
        j0 j0VarA = j0.a(this.messageEncoding_);
        return j0VarA == null ? j0.MESSAGE_ENCODING_UNKNOWN : j0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final k0 getRepeatedFieldEncoding() {
        k0 k0VarA = k0.a(this.repeatedFieldEncoding_);
        return k0VarA == null ? k0.REPEATED_FIELD_ENCODING_UNKNOWN : k0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final l0 getUtf8Validation() {
        l0 l0VarA = l0.a(this.utf8Validation_);
        return l0VarA == null ? l0.UTF8_VALIDATION_UNKNOWN : l0VarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasEnumType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasFieldPresence() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasJsonFormat() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasMessageEncoding() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasRepeatedFieldEncoding() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetOrBuilder
    public final boolean hasUtf8Validation() {
        return (this.bitField0_ & 8) != 0;
    }
}
