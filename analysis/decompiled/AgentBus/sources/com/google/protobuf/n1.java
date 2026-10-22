package com.google.protobuf;

/* loaded from: classes.dex */
public final class n1 extends i2 implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
    private static final n1 DEFAULT_INSTANCE;
    public static final int IS_EXTENSION_FIELD_NUMBER = 2;
    public static final int NAME_PART_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private int bitField0_;
    private boolean isExtension_;
    private byte memoizedIsInitialized = 2;
    private String namePart_ = "";

    static {
        n1 n1Var = new n1();
        DEFAULT_INSTANCE = n1Var;
        i2.n(n1.class, n1Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
            case 3:
                return new n1();
            case 4:
                return new b7.a(25, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (n1.class) {
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

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public final boolean getIsExtension() {
        return this.isExtension_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public final String getNamePart() {
        return this.namePart_;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public final l getNamePartBytes() {
        return l.i(this.namePart_);
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public final boolean hasIsExtension() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder
    public final boolean hasNamePart() {
        return (this.bitField0_ & 1) != 0;
    }
}
