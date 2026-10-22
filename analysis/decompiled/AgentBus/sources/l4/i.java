package l4;

import com.google.protobuf.f2;
import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.agentbus.agents.bff.proto.HeartbeatReqOrBuilder;

/* loaded from: classes.dex */
public final class i extends i2 implements HeartbeatReqOrBuilder {
    private static final i DEFAULT_INSTANCE;
    private static volatile p3 PARSER;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        i2.n(i.class, iVar);
    }

    public static h p() {
        return (h) ((f2) DEFAULT_INSTANCE.d(5, null));
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 3:
                return new i();
            case 4:
                return new h(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (i.class) {
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
}
