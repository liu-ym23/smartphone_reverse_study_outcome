package com.google.protobuf;

/* loaded from: classes.dex */
public final class t0 extends i2 implements DescriptorProtos$FieldOptions$FeatureSupportOrBuilder {
    private static final t0 DEFAULT_INSTANCE;
    public static final int DEPRECATION_WARNING_FIELD_NUMBER = 3;
    public static final int EDITION_DEPRECATED_FIELD_NUMBER = 2;
    public static final int EDITION_INTRODUCED_FIELD_NUMBER = 1;
    public static final int EDITION_REMOVED_FIELD_NUMBER = 4;
    private static volatile p3 PARSER;
    private int bitField0_;
    private String deprecationWarning_ = "";
    private int editionDeprecated_;
    private int editionIntroduced_;
    private int editionRemoved_;

    static {
        t0 t0Var = new t0();
        DEFAULT_INSTANCE = t0Var;
        i2.n(t0.class, t0Var);
    }

    public static t0 p() {
        return DEFAULT_INSTANCE;
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
                v vVar = v.f2564b;
                return new s3(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"bitField0_", "editionIntroduced_", vVar, "editionDeprecated_", vVar, "deprecationWarning_", "editionRemoved_", vVar});
            case 3:
                return new t0();
            case 4:
                return new b7.a(17, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (t0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final String getDeprecationWarning() {
        return this.deprecationWarning_;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final l getDeprecationWarningBytes() {
        return l.i(this.deprecationWarning_);
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final w getEditionDeprecated() {
        w wVarA = w.a(this.editionDeprecated_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final w getEditionIntroduced() {
        w wVarA = w.a(this.editionIntroduced_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final w getEditionRemoved() {
        w wVarA = w.a(this.editionRemoved_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final boolean hasDeprecationWarning() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final boolean hasEditionDeprecated() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final boolean hasEditionIntroduced() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FieldOptions$FeatureSupportOrBuilder
    public final boolean hasEditionRemoved() {
        return (this.bitField0_ & 8) != 0;
    }
}
