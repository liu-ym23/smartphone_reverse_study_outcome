package l4;

import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.j3;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder;

/* loaded from: classes.dex */
public final class d extends i2 implements AuthBindRespOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int CONN_FIELD_NUMBER = 4;
    private static final d DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int LOGINED_FIELD_NUMBER = 6;
    public static final int NEW_FIELD_NUMBER = 7;
    private static volatile p3 PARSER = null;
    public static final int UID_FIELD_NUMBER = 5;
    private int code_;
    private int logined_;
    private boolean new_;
    private String error_ = "";
    private String conn_ = "";
    private String uid_ = "";

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        i2.n(d.class, dVar);
    }

    public static d p(l lVar) {
        return (d) i2.l(DEFAULT_INSTANCE, lVar);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0007", new Object[]{"code_", "error_", "conn_", "uid_", "logined_", "new_"});
            case 3:
                return new d();
            case 4:
                return new j3(5, DEFAULT_INSTANCE);
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

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final int getCode() {
        return this.code_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final String getConn() {
        return this.conn_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final l getConnBytes() {
        return l.i(this.conn_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final String getError() {
        return this.error_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final l getErrorBytes() {
        return l.i(this.error_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final int getLogined() {
        return this.logined_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final boolean getNew() {
        return this.new_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final String getUid() {
        return this.uid_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindRespOrBuilder
    public final l getUidBytes() {
        return l.i(this.uid_);
    }
}
