package b7;

import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.protobuf.connection.ToolCallOrBuilder;

/* loaded from: classes.dex */
public final class g extends i2 implements ToolCallOrBuilder {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final g DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile p3 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 4;
    public static final int TOOL_FIELD_NUMBER = 2;
    private int bitField0_;
    private String callId_ = "";
    private h params_;
    private i result_;
    private f tool_;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        i2.n(g.class, gVar);
    }

    public static g p(l lVar) {
        return (g) i2.l(DEFAULT_INSTANCE, lVar);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "callId_", "tool_", "params_", "result_"});
            case 3:
                return new g();
            case 4:
                return new a(3, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (g.class) {
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

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final String getCallId() {
        return this.callId_;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final l getCallIdBytes() {
        return l.i(this.callId_);
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final h getParams() {
        h hVar = this.params_;
        return hVar == null ? h.p() : hVar;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final i getResult() {
        i iVar = this.result_;
        return iVar == null ? i.p() : iVar;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final f getTool() {
        f fVar = this.tool_;
        return fVar == null ? f.p() : fVar;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final boolean hasParams() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final boolean hasResult() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.stepos.protobuf.connection.ToolCallOrBuilder
    public final boolean hasTool() {
        return (this.bitField0_ & 1) != 0;
    }
}
