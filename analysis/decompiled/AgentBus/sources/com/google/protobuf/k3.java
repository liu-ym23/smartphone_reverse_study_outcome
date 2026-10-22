package com.google.protobuf;

/* loaded from: classes.dex */
public final class k3 extends i2 implements MixinOrBuilder {
    private static final k3 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile p3 PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    private String name_ = "";
    private String root_ = "";

    static {
        k3 k3Var = new k3();
        DEFAULT_INSTANCE = k3Var;
        i2.n(k3.class, k3Var);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "root_"});
            case 3:
                return new k3();
            case 4:
                return new j3(0, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (k3.class) {
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

    @Override // com.google.protobuf.MixinOrBuilder, com.google.protobuf.OptionOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.MixinOrBuilder, com.google.protobuf.OptionOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public final String getRoot() {
        return this.root_;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public final l getRootBytes() {
        return l.i(this.root_);
    }
}
