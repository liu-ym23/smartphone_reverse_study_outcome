package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class o1 extends i2 implements DescriptorProtos$UninterpretedOptionOrBuilder {
    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private static final o1 DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    private static volatile p3 PARSER = null;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private int bitField0_;
    private double doubleValue_;
    private long negativeIntValue_;
    private long positiveIntValue_;
    private byte memoizedIsInitialized = 2;
    private o2 name_ = r3.f2514j;
    private String identifierValue_ = "";
    private l stringValue_ = l.f2424g;
    private String aggregateValue_ = "";

    static {
        o1 o1Var = new o1();
        DEFAULT_INSTANCE = o1Var;
        i2.n(o1.class, o1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", n1.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
            case 3:
                return new o1();
            case 4:
                return new b7.a(24, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (o1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final String getAggregateValue() {
        return this.aggregateValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final l getAggregateValueBytes() {
        return l.i(this.aggregateValue_);
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final double getDoubleValue() {
        return this.doubleValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final String getIdentifierValue() {
        return this.identifierValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final l getIdentifierValueBytes() {
        return l.i(this.identifierValue_);
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final n1 getName(int i2) {
        return (n1) this.name_.get(i2);
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final int getNameCount() {
        return this.name_.size();
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final List getNameList() {
        return this.name_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final l getStringValue() {
        return this.stringValue_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasAggregateValue() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasDoubleValue() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasIdentifierValue() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasNegativeIntValue() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasPositiveIntValue() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder
    public final boolean hasStringValue() {
        return (this.bitField0_ & 16) != 0;
    }
}
