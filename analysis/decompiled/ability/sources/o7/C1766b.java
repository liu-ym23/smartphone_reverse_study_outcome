package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.AgentMessage$Builder;
import com.zyql.protobuf.agent.AgentMessage$RequestCase;
import com.zyql.protobuf.agent.AgentMessage$ResponseCase;
import com.zyql.protobuf.agent.Error$Builder;
import com.zyql.protobuf.agent.GetAgentInfoResponse$Builder;
import com.zyql.protobuf.agent.GetStoreRequest$Builder;
import com.zyql.protobuf.agent.HookExecutionResult$Builder;
import com.zyql.protobuf.agent.ToolExecutionResult$Builder;

/* renamed from: o7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1766b extends GeneratedMessageLite implements Y1 {
    private static final C1766b DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 60;
    public static final int GET_AGENT_INFO_RESPONSE_FIELD_NUMBER = 10;
    public static final int GET_STORE_REQUEST_FIELD_NUMBER = 50;
    public static final int HOOK_EXECUTION_RESULT_FIELD_NUMBER = 31;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TOOL_EXECUTION_RESULT_FIELD_NUMBER = 30;
    private Object request_;
    private Object response_;
    private long timestamp_;
    private int responseCase_ = 0;
    private int requestCase_ = 0;
    private String id_ = "";

    static {
        C1766b c1766b = new C1766b();
        DEFAULT_INSTANCE = c1766b;
        GeneratedMessageLite.C(C1766b.class, c1766b);
    }

    public static void D(C1766b c1766b) {
        if (c1766b.responseCase_ == 60) {
            c1766b.responseCase_ = 0;
            c1766b.response_ = null;
        }
    }

    public static void E(C1766b c1766b) {
        if (c1766b.responseCase_ == 10) {
            c1766b.responseCase_ = 0;
            c1766b.response_ = null;
        }
    }

    public static void F(C1766b c1766b) {
        if (c1766b.requestCase_ == 50) {
            c1766b.requestCase_ = 0;
            c1766b.request_ = null;
        }
    }

    public static void G(C1766b c1766b) {
        if (c1766b.responseCase_ == 31) {
            c1766b.responseCase_ = 0;
            c1766b.response_ = null;
        }
    }

    public static void H(C1766b c1766b) {
        c1766b.getClass();
        c1766b.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void I(C1766b c1766b) {
        c1766b.requestCase_ = 0;
        c1766b.request_ = null;
    }

    public static void J(C1766b c1766b) {
        c1766b.responseCase_ = 0;
        c1766b.response_ = null;
    }

    public static void K(C1766b c1766b) {
        c1766b.timestamp_ = 0L;
    }

    public static void L(C1766b c1766b) {
        if (c1766b.responseCase_ == 30) {
            c1766b.responseCase_ = 0;
            c1766b.response_ = null;
        }
    }

    public static void M(C1766b c1766b, C1773i c1773i) {
        c1766b.getClass();
        c1773i.getClass();
        if (c1766b.responseCase_ != 60 || c1766b.response_ == C1773i.N()) {
            c1766b.response_ = c1773i;
        } else {
            c1766b.response_ = ((Error$Builder) C1773i.R((C1773i) c1766b.response_).mergeFrom((GeneratedMessageLite) c1773i)).m();
        }
        c1766b.responseCase_ = 60;
    }

    public static void N(C1766b c1766b, m mVar) {
        c1766b.getClass();
        mVar.getClass();
        if (c1766b.responseCase_ != 10 || c1766b.response_ == m.N()) {
            c1766b.response_ = mVar;
        } else {
            c1766b.response_ = ((GetAgentInfoResponse$Builder) m.S((m) c1766b.response_).mergeFrom((GeneratedMessageLite) mVar)).m();
        }
        c1766b.responseCase_ = 10;
    }

    public static void O(C1766b c1766b, n nVar) {
        c1766b.getClass();
        nVar.getClass();
        if (c1766b.requestCase_ != 50 || c1766b.request_ == n.K()) {
            c1766b.request_ = nVar;
        } else {
            c1766b.request_ = ((GetStoreRequest$Builder) n.P((n) c1766b.request_).mergeFrom((GeneratedMessageLite) nVar)).m();
        }
        c1766b.requestCase_ = 50;
    }

    public static void P(C1766b c1766b, q qVar) {
        c1766b.getClass();
        qVar.getClass();
        if (c1766b.responseCase_ != 31 || c1766b.response_ == q.W()) {
            c1766b.response_ = qVar;
        } else {
            c1766b.response_ = ((HookExecutionResult$Builder) q.g0((q) c1766b.response_).mergeFrom((GeneratedMessageLite) qVar)).m();
        }
        c1766b.responseCase_ = 31;
    }

    public static void Q(C1766b c1766b, C1763B c1763b) {
        c1766b.getClass();
        c1763b.getClass();
        if (c1766b.responseCase_ != 30 || c1766b.response_ == C1763B.Y()) {
            c1766b.response_ = c1763b;
        } else {
            c1766b.response_ = ((ToolExecutionResult$Builder) C1763B.j0((C1763B) c1766b.response_).mergeFrom((GeneratedMessageLite) c1763b)).m();
        }
        c1766b.responseCase_ = 30;
    }

    public static void R(C1766b c1766b, C1773i c1773i) {
        c1766b.getClass();
        c1773i.getClass();
        c1766b.response_ = c1773i;
        c1766b.responseCase_ = 60;
    }

    public static void S(C1766b c1766b, m mVar) {
        c1766b.getClass();
        mVar.getClass();
        c1766b.response_ = mVar;
        c1766b.responseCase_ = 10;
    }

    public static void T(C1766b c1766b, n nVar) {
        c1766b.getClass();
        nVar.getClass();
        c1766b.request_ = nVar;
        c1766b.requestCase_ = 50;
    }

    public static void U(C1766b c1766b, q qVar) {
        c1766b.getClass();
        qVar.getClass();
        c1766b.response_ = qVar;
        c1766b.responseCase_ = 31;
    }

    public static void V(C1766b c1766b, String str) {
        c1766b.getClass();
        str.getClass();
        c1766b.id_ = str;
    }

    public static void W(C1766b c1766b, ByteString byteString) {
        c1766b.getClass();
        AbstractC0932e.g(byteString);
        c1766b.id_ = byteString.q();
    }

    public static void X(C1766b c1766b, long j5) {
        c1766b.timestamp_ = j5;
    }

    public static void Y(C1766b c1766b, C1763B c1763b) {
        c1766b.getClass();
        c1763b.getClass();
        c1766b.response_ = c1763b;
        c1766b.responseCase_ = 30;
    }

    public final C1773i a0() {
        return this.responseCase_ == 60 ? (C1773i) this.response_ : C1773i.N();
    }

    public final m b0() {
        return this.responseCase_ == 10 ? (m) this.response_ : m.N();
    }

    public final n c0() {
        return this.requestCase_ == 50 ? (n) this.request_ : n.K();
    }

    public final q d0() {
        return this.responseCase_ == 31 ? (q) this.response_ : q.W();
    }

    public final String e0() {
        return this.id_;
    }

    public final ByteString f0() {
        return ByteString.f(this.id_);
    }

    public final AgentMessage$RequestCase g0() {
        int i = this.requestCase_;
        if (i == 0) {
            return AgentMessage$RequestCase.b;
        }
        if (i != 50) {
            return null;
        }
        return AgentMessage$RequestCase.f4247a;
    }

    public final AgentMessage$ResponseCase h0() {
        int i = this.responseCase_;
        if (i == 0) {
            return AgentMessage$ResponseCase.e;
        }
        if (i == 10) {
            return AgentMessage$ResponseCase.f4248a;
        }
        if (i == 60) {
            return AgentMessage$ResponseCase.d;
        }
        if (i == 30) {
            return AgentMessage$ResponseCase.b;
        }
        if (i != 31) {
            return null;
        }
        return AgentMessage$ResponseCase.c;
    }

    public final long i0() {
        return this.timestamp_;
    }

    public final C1763B j0() {
        return this.responseCase_ == 30 ? (C1763B) this.response_ : C1763B.Y();
    }

    public final boolean k0() {
        return this.responseCase_ == 60;
    }

    public final boolean l0() {
        return this.responseCase_ == 10;
    }

    public final boolean m0() {
        return this.requestCase_ == 50;
    }

    public final boolean n0() {
        return this.responseCase_ == 31;
    }

    public final boolean o0() {
        return this.responseCase_ == 30;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0001<\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\n<\u0000\u001e<\u0000\u001f<\u00002<\u0001<<\u0000", new Object[]{"response_", "responseCase_", "request_", "requestCase_", "id_", "timestamp_", m.class, C1763B.class, q.class, n.class, C1773i.class});
            case 3:
                return new C1766b();
            case 4:
                return new AgentMessage$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1766b.class) {
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
