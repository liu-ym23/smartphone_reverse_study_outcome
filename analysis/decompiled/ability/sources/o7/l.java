package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.GetAgentInfoRequest$Builder;

/* loaded from: classes2.dex */
public final class l extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    private static final l DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER;
    private String agentId_ = "";

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        GeneratedMessageLite.C(l.class, lVar);
    }

    public static void D(l lVar) {
        lVar.getClass();
        lVar.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.agentId_ = str;
    }

    public static void F(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.agentId_ = byteString.q();
    }

    public static l J() {
        return DEFAULT_INSTANCE;
    }

    public static GetAgentInfoRequest$Builder K(l lVar) {
        return (GetAgentInfoRequest$Builder) DEFAULT_INSTANCE.q(lVar);
    }

    public final String H() {
        return this.agentId_;
    }

    public final ByteString I() {
        return ByteString.f(this.agentId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"agentId_"});
            case 3:
                return new l();
            case 4:
                return new GetAgentInfoRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (l.class) {
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
