package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.AgentInfo$Builder;
import com.zyql.protobuf.agent.GetAgentInfoResponse$Builder;

/* loaded from: classes2.dex */
public final class m extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_INFO_FIELD_NUMBER = 2;
    private static final m DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private C1765a agentInfo_;
    private int bitField0_;
    private String error_ = "";
    private boolean success_;

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        GeneratedMessageLite.C(m.class, mVar);
    }

    public static void D(m mVar) {
        mVar.agentInfo_ = null;
        mVar.bitField0_ &= -2;
    }

    public static void E(m mVar) {
        mVar.getClass();
        mVar.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void F(m mVar) {
        mVar.success_ = false;
    }

    public static void G(m mVar, C1765a c1765a) {
        mVar.getClass();
        c1765a.getClass();
        C1765a c1765a2 = mVar.agentInfo_;
        if (c1765a2 == null || c1765a2 == C1765a.A0()) {
            mVar.agentInfo_ = c1765a;
        } else {
            mVar.agentInfo_ = (C1765a) ((AgentInfo$Builder) C1765a.X0(mVar.agentInfo_).mergeFrom((GeneratedMessageLite) c1765a)).m();
        }
        mVar.bitField0_ |= 1;
    }

    public static void H(m mVar, C1765a c1765a) {
        mVar.getClass();
        c1765a.getClass();
        mVar.agentInfo_ = c1765a;
        mVar.bitField0_ |= 1;
    }

    public static void I(m mVar, String str) {
        mVar.getClass();
        str.getClass();
        mVar.error_ = str;
    }

    public static void J(m mVar, ByteString byteString) {
        mVar.getClass();
        AbstractC0932e.g(byteString);
        mVar.error_ = byteString.q();
    }

    public static void K(m mVar, boolean z10) {
        mVar.success_ = z10;
    }

    public static m N() {
        return DEFAULT_INSTANCE;
    }

    public static GetAgentInfoResponse$Builder S(m mVar) {
        return (GetAgentInfoResponse$Builder) DEFAULT_INSTANCE.q(mVar);
    }

    public final C1765a M() {
        C1765a c1765a = this.agentInfo_;
        return c1765a == null ? C1765a.A0() : c1765a;
    }

    public final String O() {
        return this.error_;
    }

    public final ByteString P() {
        return ByteString.f(this.error_);
    }

    public final boolean Q() {
        return this.success_;
    }

    public final boolean R() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object r(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        InterfaceC0955j2 c0922b1;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000\u0003Ȉ", new Object[]{"bitField0_", "success_", "agentInfo_", "error_"});
            case 3:
                return new m();
            case 4:
                return new GetAgentInfoResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (m.class) {
                    try {
                        c0922b1 = PARSER;
                        if (c0922b1 == null) {
                            c0922b1 = new C0922b1(DEFAULT_INSTANCE);
                            PARSER = c0922b1;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0922b1;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
