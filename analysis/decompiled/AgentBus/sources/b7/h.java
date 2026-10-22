package b7;

import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.protobuf.connection.ToolCallParamsOrBuilder;

/* loaded from: classes.dex */
public final class h extends i2 implements ToolCallParamsOrBuilder {
    private static final h DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile p3 PARSER;
    private String params_ = "";

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        i2.n(h.class, hVar);
    }

    public static h p() {
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"params_"});
            case 3:
                return new h();
            case 4:
                return new a(4, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (h.class) {
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

    @Override // com.stepos.protobuf.connection.ToolCallParamsOrBuilder
    /* renamed from: getParams */
    public final String mo8getParams() {
        return this.params_;
    }

    @Override // com.stepos.protobuf.connection.ToolCallParamsOrBuilder
    public final l getParamsBytes() {
        return l.i(this.params_);
    }
}
