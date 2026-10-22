package b7;

import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.protobuf.connection.StreamMsgOrBuilder;

/* loaded from: classes.dex */
public final class d extends i2 implements StreamMsgOrBuilder {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final d DEFAULT_INSTANCE;
    public static final int HEAD_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private int bitField0_;
    private l body_ = l.f2424g;
    private c head_;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        i2.n(d.class, dVar);
    }

    public static d p(byte[] bArr) {
        return (d) i2.m(DEFAULT_INSTANCE, bArr);
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
                return new d();
            case 4:
                return new a(1, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (d.class) {
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

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public final l getBody() {
        return this.body_;
    }

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public final c getHead() {
        c cVar = this.head_;
        return cVar == null ? c.p() : cVar;
    }

    @Override // com.stepos.protobuf.connection.StreamMsgOrBuilder
    public final boolean hasHead() {
        return (this.bitField0_ & 1) != 0;
    }
}
