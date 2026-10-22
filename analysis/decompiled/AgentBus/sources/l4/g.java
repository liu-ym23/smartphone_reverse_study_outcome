package l4;

import com.google.protobuf.b3;
import com.google.protobuf.f2;
import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.agentbus.agents.bff.proto.HeadOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class g extends i2 implements HeadOrBuilder {
    public static final int COMMAND_FIELD_NUMBER = 5;
    private static final g DEFAULT_INSTANCE;
    public static final int FRAME_TYPE_FIELD_NUMBER = 1;
    public static final int META_FIELD_NUMBER = 6;
    public static final int MODULE_FIELD_NUMBER = 4;
    public static final int MSG_ID_FIELD_NUMBER = 3;
    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    private static volatile p3 PARSER;
    private int frameType_;
    private int msgType_;
    private b3 meta_ = b3.f2320g;
    private String msgId_ = "";
    private String module_ = "";
    private String command_ = "";

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        i2.n(g.class, gVar);
    }

    public static void p(g gVar, String str) {
        gVar.getClass();
        gVar.command_ = str;
    }

    public static void q(g gVar) {
        gVar.frameType_ = 1;
    }

    public static void r(g gVar) {
        gVar.getClass();
        gVar.module_ = "Stream";
    }

    public static void s(g gVar, String str) {
        gVar.getClass();
        gVar.msgId_ = str;
    }

    public static void t(g gVar) {
        gVar.msgType_ = 0;
    }

    public static g u() {
        return DEFAULT_INSTANCE;
    }

    public static e v() {
        return (e) ((f2) DEFAULT_INSTANCE.d(5, null));
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final boolean containsMeta(String str) {
        str.getClass();
        return this.meta_.containsKey(str);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001\u000b\u0002\u000b\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"frameType_", "msgType_", "msgId_", "module_", "command_", "meta_", f.f5844a});
            case 3:
                return new g();
            case 4:
                return new e(DEFAULT_INSTANCE);
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

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getCommand() {
        return this.command_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getCommandBytes() {
        return l.i(this.command_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getFrameType() {
        return this.frameType_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final Map getMeta() {
        return Collections.unmodifiableMap(this.meta_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getMetaCount() {
        return this.meta_.size();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final Map getMetaMap() {
        return Collections.unmodifiableMap(this.meta_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMetaOrDefault(String str, String str2) {
        str.getClass();
        b3 b3Var = this.meta_;
        return b3Var.containsKey(str) ? (String) b3Var.get(str) : str2;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMetaOrThrow(String str) {
        str.getClass();
        b3 b3Var = this.meta_;
        if (b3Var.containsKey(str)) {
            return (String) b3Var.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getModule() {
        return this.module_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getModuleBytes() {
        return l.i(this.module_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMsgId() {
        return this.msgId_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getMsgIdBytes() {
        return l.i(this.msgId_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getMsgType() {
        return this.msgType_;
    }
}
