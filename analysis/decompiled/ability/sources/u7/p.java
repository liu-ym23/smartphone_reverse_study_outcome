package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.StartAgentAck$Builder;

/* loaded from: classes2.dex */
public final class p extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_DESCRIPTION_FIELD_NUMBER = 4;
    public static final int AGENT_NAME_FIELD_NUMBER = 3;
    private static final p DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int TASK_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long taskId_;
    private String sessionId_ = "";
    private String agentName_ = "";
    private String agentDescription_ = "";

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        GeneratedMessageLite.C(p.class, pVar);
    }

    public static void D(p pVar) {
        pVar.bitField0_ &= -5;
        pVar.agentDescription_ = DEFAULT_INSTANCE.agentDescription_;
    }

    public static void E(p pVar) {
        pVar.bitField0_ &= -3;
        pVar.agentName_ = DEFAULT_INSTANCE.agentName_;
    }

    public static void F(p pVar) {
        pVar.getClass();
        pVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(p pVar) {
        pVar.bitField0_ &= -2;
        pVar.taskId_ = 0L;
    }

    public static void H(p pVar, String str) {
        pVar.getClass();
        str.getClass();
        pVar.bitField0_ |= 4;
        pVar.agentDescription_ = str;
    }

    public static void I(p pVar, ByteString byteString) {
        pVar.getClass();
        AbstractC0932e.g(byteString);
        pVar.agentDescription_ = byteString.q();
        pVar.bitField0_ |= 4;
    }

    public static void J(p pVar, String str) {
        pVar.getClass();
        str.getClass();
        pVar.bitField0_ |= 2;
        pVar.agentName_ = str;
    }

    public static void K(p pVar, ByteString byteString) {
        pVar.getClass();
        AbstractC0932e.g(byteString);
        pVar.agentName_ = byteString.q();
        pVar.bitField0_ |= 2;
    }

    public static void L(p pVar, String str) {
        pVar.getClass();
        str.getClass();
        pVar.sessionId_ = str;
    }

    public static void M(p pVar, ByteString byteString) {
        pVar.getClass();
        AbstractC0932e.g(byteString);
        pVar.sessionId_ = byteString.q();
    }

    public static void N(p pVar, long j5) {
        pVar.bitField0_ |= 1;
        pVar.taskId_ = j5;
    }

    public static p T() {
        return DEFAULT_INSTANCE;
    }

    public static StartAgentAck$Builder a0(p pVar) {
        return (StartAgentAck$Builder) DEFAULT_INSTANCE.q(pVar);
    }

    public final String P() {
        return this.agentDescription_;
    }

    public final ByteString Q() {
        return ByteString.f(this.agentDescription_);
    }

    public final String R() {
        return this.agentName_;
    }

    public final ByteString S() {
        return ByteString.f(this.agentName_);
    }

    public final String U() {
        return this.sessionId_;
    }

    public final ByteString V() {
        return ByteString.f(this.sessionId_);
    }

    public final long W() {
        return this.taskId_;
    }

    public final boolean X() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean Y() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean Z() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဃ\u0000\u0003ለ\u0001\u0004ለ\u0002", new Object[]{"bitField0_", "sessionId_", "taskId_", "agentName_", "agentDescription_"});
            case 3:
                return new p();
            case 4:
                return new StartAgentAck$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (p.class) {
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
