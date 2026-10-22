package l4;

import com.google.protobuf.f2;
import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder;

/* loaded from: classes.dex */
public final class k extends i2 implements StreamMsgOrBuilder {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final k DEFAULT_INSTANCE;
    public static final int HEAD_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private int bitField0_;
    private l body_ = l.f2424g;
    private g head_;

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        i2.n(k.class, kVar);
    }

    public static void p(k kVar, com.google.protobuf.k kVar2) {
        kVar.getClass();
        kVar.body_ = kVar2;
    }

    public static void q(k kVar, g gVar) {
        kVar.getClass();
        kVar.head_ = gVar;
        kVar.bitField0_ |= 1;
    }

    public static j r() {
        return (j) ((f2) DEFAULT_INSTANCE.d(5, null));
    }

    public static k s(byte[] bArr) {
        return (k) i2.m(DEFAULT_INSTANCE, bArr);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n", new Object[]{"bitField0_", "head_", "body_"});
            case 3:
                return new k();
            case 4:
                return new j(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (k.class) {
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

    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final l getBody() {
        return this.body_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final g getHead() {
        g gVar = this.head_;
        return gVar == null ? g.u() : gVar;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final boolean hasHead() {
        return (this.bitField0_ & 1) != 0;
    }
}
