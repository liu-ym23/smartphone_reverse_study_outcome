package com.google.protobuf;

/* loaded from: classes.dex */
public final class n0 extends i2 implements DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder {
    private static final n0 DEFAULT_INSTANCE;
    public static final int EDITION_FIELD_NUMBER = 3;
    public static final int FIXED_FEATURES_FIELD_NUMBER = 5;
    public static final int OVERRIDABLE_FEATURES_FIELD_NUMBER = 4;
    private static volatile p3 PARSER;
    private int bitField0_;
    private int edition_;
    private m0 fixedFeatures_;
    private byte memoizedIsInitialized = 2;
    private m0 overridableFeatures_;

    static {
        n0 n0Var = new n0();
        DEFAULT_INSTANCE = n0Var;
        i2.n(n0.class, n0Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0002\u0003᠌\u0000\u0004ᐉ\u0001\u0005ᐉ\u0002", new Object[]{"bitField0_", "edition_", v.f2564b, "overridableFeatures_", "fixedFeatures_"});
            case 3:
                return new n0();
            case 4:
                return new b7.a(14, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (n0.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final w getEdition() {
        w wVarA = w.a(this.edition_);
        return wVarA == null ? w.EDITION_UNKNOWN : wVarA;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public final m0 getFixedFeatures() {
        m0 m0Var = this.fixedFeatures_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public final m0 getOverridableFeatures() {
        m0 m0Var = this.overridableFeatures_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FieldOptions$EditionDefaultOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder
    public final boolean hasEdition() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public final boolean hasFixedFeatures() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefaultOrBuilder
    public final boolean hasOverridableFeatures() {
        return (this.bitField0_ & 2) != 0;
    }
}
