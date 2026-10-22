package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class d1 extends h2 implements DescriptorProtos$MessageOptionsOrBuilder {
    private static final d1 DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 11;
    public static final int FEATURES_FIELD_NUMBER = 12;
    public static final int MAP_ENTRY_FIELD_NUMBER = 7;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    private static volatile p3 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecatedLegacyJsonFieldConflicts_;
    private boolean deprecated_;
    private m0 features_;
    private boolean mapEntry_;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private byte memoizedIsInitialized = 2;
    private o2 uninterpretedOption_ = r3.f2514j;

    static {
        d1 d1Var = new d1();
        DEFAULT_INSTANCE = d1Var;
        i2.n(d1.class, d1Var);
    }

    public static d1 q() {
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\u000bဇ\u0004\fᐉ\u0005ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", o1.class});
            case 3:
                return new d1();
            case 4:
                return new z(6, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (d1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean getDeprecatedLegacyJsonFieldConflicts() {
        return this.deprecatedLegacyJsonFieldConflicts_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final m0 getFeatures() {
        m0 m0Var = this.features_;
        return m0Var == null ? m0.q() : m0Var;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean getMapEntry() {
        return this.mapEntry_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final o1 getUninterpretedOption(int i2) {
        return (o1) this.uninterpretedOption_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasDeprecated() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasDeprecatedLegacyJsonFieldConflicts() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasFeatures() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasMapEntry() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasMessageSetWireFormat() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder
    public final boolean hasNoStandardDescriptorAccessor() {
        return (this.bitField0_ & 2) != 0;
    }
}
