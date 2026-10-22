package l4;

import com.google.protobuf.b3;
import com.google.protobuf.f2;
import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends i2 implements AuthBindReqOrBuilder {
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CHANNEL_FIELD_NUMBER = 8;
    private static final c DEFAULT_INSTANCE;
    public static final int DEVICE_FIELD_NUMBER = 6;
    public static final int DID_FIELD_NUMBER = 9;
    private static volatile p3 PARSER = null;
    public static final int PLATFORM_FIELD_NUMBER = 5;
    public static final int PRODUCT_FIELD_NUMBER = 1;
    public static final int RESERVED_FIELD_NUMBER = 10;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int TOKEN_TYPE_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 2;
    private int platform_;
    private b3 reserved_ = b3.f2320g;
    private String product_ = "";
    private String uid_ = "";
    private String token_ = "";
    private String tokenType_ = "";
    private String device_ = "";
    private String appVersion_ = "";
    private String channel_ = "";
    private String did_ = "";

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        i2.n(c.class, cVar);
    }

    public static b3 p(c cVar) {
        b3 b3Var = cVar.reserved_;
        if (!b3Var.f2321f) {
            cVar.reserved_ = b3Var.c();
        }
        return cVar.reserved_;
    }

    public static void q(c cVar, String str) {
        cVar.getClass();
        cVar.appVersion_ = str;
    }

    public static void r(c cVar, String str) {
        cVar.getClass();
        cVar.device_ = str;
    }

    public static void s(c cVar, int i2) {
        cVar.platform_ = i2;
    }

    public static void t(c cVar, String str) {
        cVar.getClass();
        cVar.product_ = str;
    }

    public static void u(c cVar, String str) {
        cVar.getClass();
        cVar.token_ = str;
    }

    public static void v(c cVar) {
        cVar.getClass();
        cVar.uid_ = "";
    }

    public static a w() {
        return (a) ((f2) DEFAULT_INSTANCE.d(5, null));
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final boolean containsReserved(String str) {
        str.getClass();
        return this.reserved_.containsKey(str);
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
                return new s3(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u000b\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n2", new Object[]{"product_", "uid_", "token_", "tokenType_", "platform_", "device_", "appVersion_", "channel_", "did_", "reserved_", b.f5843a});
            case 3:
                return new c();
            case 4:
                return new a(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (c.class) {
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

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getAppVersion() {
        return this.appVersion_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getAppVersionBytes() {
        return l.i(this.appVersion_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getChannel() {
        return this.channel_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getChannelBytes() {
        return l.i(this.channel_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getDevice() {
        return this.device_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getDeviceBytes() {
        return l.i(this.device_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getDid() {
        return this.did_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getDidBytes() {
        return l.i(this.did_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final int getPlatform() {
        return this.platform_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getProduct() {
        return this.product_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getProductBytes() {
        return l.i(this.product_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final Map getReserved() {
        return Collections.unmodifiableMap(this.reserved_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final int getReservedCount() {
        return this.reserved_.size();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final Map getReservedMap() {
        return Collections.unmodifiableMap(this.reserved_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getReservedOrDefault(String str, String str2) {
        str.getClass();
        b3 b3Var = this.reserved_;
        return b3Var.containsKey(str) ? (String) b3Var.get(str) : str2;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getReservedOrThrow(String str) {
        str.getClass();
        b3 b3Var = this.reserved_;
        if (b3Var.containsKey(str)) {
            return (String) b3Var.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getToken() {
        return this.token_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getTokenBytes() {
        return l.i(this.token_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getTokenType() {
        return this.tokenType_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getTokenTypeBytes() {
        return l.i(this.tokenType_);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getUid() {
        return this.uid_;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getUidBytes() {
        return l.i(this.uid_);
    }
}
