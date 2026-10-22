package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.Error$Builder;
import com.zyql.protobuf.agent.ExecuteToolTask$Builder;
import com.zyql.protobuf.agent.GetAgentInfoRequest$Builder;
import com.zyql.protobuf.agent.GetStoreResponse$Builder;
import com.zyql.protobuf.agent.InvokeHookTask$Builder;
import com.zyql.protobuf.agent.RuntimeMessage$Builder;
import com.zyql.protobuf.agent.RuntimeMessage$RequestCase;
import com.zyql.protobuf.agent.RuntimeMessage$ResponseCase;

/* loaded from: classes2.dex */
public final class w extends GeneratedMessageLite implements Y1 {
    private static final w DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 60;
    public static final int EXECUTE_TOOL_TASK_FIELD_NUMBER = 20;
    public static final int GET_AGENT_INFO_REQUEST_FIELD_NUMBER = 10;
    public static final int GET_STORE_RESPONSE_FIELD_NUMBER = 50;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INVOKE_HOOK_TASK_FIELD_NUMBER = 21;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private Object request_;
    private Object response_;
    private long timestamp_;
    private int requestCase_ = 0;
    private int responseCase_ = 0;
    private String id_ = "";

    static {
        w wVar = new w();
        DEFAULT_INSTANCE = wVar;
        GeneratedMessageLite.C(w.class, wVar);
    }

    public static void D(w wVar) {
        if (wVar.responseCase_ == 60) {
            wVar.responseCase_ = 0;
            wVar.response_ = null;
        }
    }

    public static void E(w wVar) {
        if (wVar.requestCase_ == 20) {
            wVar.requestCase_ = 0;
            wVar.request_ = null;
        }
    }

    public static void F(w wVar) {
        if (wVar.requestCase_ == 10) {
            wVar.requestCase_ = 0;
            wVar.request_ = null;
        }
    }

    public static void G(w wVar) {
        if (wVar.responseCase_ == 50) {
            wVar.responseCase_ = 0;
            wVar.response_ = null;
        }
    }

    public static void H(w wVar) {
        wVar.getClass();
        wVar.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void I(w wVar) {
        if (wVar.requestCase_ == 21) {
            wVar.requestCase_ = 0;
            wVar.request_ = null;
        }
    }

    public static void J(w wVar) {
        wVar.requestCase_ = 0;
        wVar.request_ = null;
    }

    public static void K(w wVar) {
        wVar.responseCase_ = 0;
        wVar.response_ = null;
    }

    public static void L(w wVar) {
        wVar.timestamp_ = 0L;
    }

    public static void M(w wVar, C1773i c1773i) {
        wVar.getClass();
        c1773i.getClass();
        if (wVar.responseCase_ != 60 || wVar.response_ == C1773i.N()) {
            wVar.response_ = c1773i;
        } else {
            wVar.response_ = ((Error$Builder) C1773i.R((C1773i) wVar.response_).mergeFrom((GeneratedMessageLite) c1773i)).m();
        }
        wVar.responseCase_ = 60;
    }

    public static void N(w wVar, C1774j c1774j) {
        wVar.getClass();
        c1774j.getClass();
        if (wVar.requestCase_ != 20 || wVar.request_ == C1774j.U()) {
            wVar.request_ = c1774j;
        } else {
            wVar.request_ = ((ExecuteToolTask$Builder) C1774j.c0((C1774j) wVar.request_).mergeFrom((GeneratedMessageLite) c1774j)).m();
        }
        wVar.requestCase_ = 20;
    }

    public static void O(w wVar, l lVar) {
        wVar.getClass();
        lVar.getClass();
        if (wVar.requestCase_ != 10 || wVar.request_ == l.J()) {
            wVar.request_ = lVar;
        } else {
            wVar.request_ = ((GetAgentInfoRequest$Builder) l.K((l) wVar.request_).mergeFrom((GeneratedMessageLite) lVar)).m();
        }
        wVar.requestCase_ = 10;
    }

    public static void P(w wVar, o oVar) {
        wVar.getClass();
        oVar.getClass();
        if (wVar.responseCase_ != 50 || wVar.response_ == o.R()) {
            wVar.response_ = oVar;
        } else {
            wVar.response_ = ((GetStoreResponse$Builder) o.a0((o) wVar.response_).mergeFrom((GeneratedMessageLite) oVar)).m();
        }
        wVar.responseCase_ = 50;
    }

    public static void Q(w wVar, s sVar) {
        wVar.getClass();
        sVar.getClass();
        if (wVar.requestCase_ != 21 || wVar.request_ == s.x0()) {
            wVar.request_ = sVar;
        } else {
            wVar.request_ = ((InvokeHookTask$Builder) s.Z0((s) wVar.request_).mergeFrom((GeneratedMessageLite) sVar)).m();
        }
        wVar.requestCase_ = 21;
    }

    public static void R(w wVar, C1773i c1773i) {
        wVar.getClass();
        c1773i.getClass();
        wVar.response_ = c1773i;
        wVar.responseCase_ = 60;
    }

    public static void S(w wVar, C1774j c1774j) {
        wVar.getClass();
        c1774j.getClass();
        wVar.request_ = c1774j;
        wVar.requestCase_ = 20;
    }

    public static void T(w wVar, l lVar) {
        wVar.getClass();
        lVar.getClass();
        wVar.request_ = lVar;
        wVar.requestCase_ = 10;
    }

    public static void U(w wVar, o oVar) {
        wVar.getClass();
        oVar.getClass();
        wVar.response_ = oVar;
        wVar.responseCase_ = 50;
    }

    public static void V(w wVar, String str) {
        wVar.getClass();
        str.getClass();
        wVar.id_ = str;
    }

    public static void W(w wVar, ByteString byteString) {
        wVar.getClass();
        AbstractC0932e.g(byteString);
        wVar.id_ = byteString.q();
    }

    public static void X(w wVar, s sVar) {
        wVar.getClass();
        sVar.getClass();
        wVar.request_ = sVar;
        wVar.requestCase_ = 21;
    }

    public static void Y(w wVar, long j5) {
        wVar.timestamp_ = j5;
    }

    public final C1773i a0() {
        return this.responseCase_ == 60 ? (C1773i) this.response_ : C1773i.N();
    }

    public final C1774j b0() {
        return this.requestCase_ == 20 ? (C1774j) this.request_ : C1774j.U();
    }

    public final l c0() {
        return this.requestCase_ == 10 ? (l) this.request_ : l.J();
    }

    public final o d0() {
        return this.responseCase_ == 50 ? (o) this.response_ : o.R();
    }

    public final String e0() {
        return this.id_;
    }

    public final ByteString f0() {
        return ByteString.f(this.id_);
    }

    public final s g0() {
        return this.requestCase_ == 21 ? (s) this.request_ : s.x0();
    }

    public final RuntimeMessage$RequestCase h0() {
        int i = this.requestCase_;
        if (i == 0) {
            return RuntimeMessage$RequestCase.d;
        }
        if (i == 10) {
            return RuntimeMessage$RequestCase.f4253a;
        }
        if (i == 20) {
            return RuntimeMessage$RequestCase.b;
        }
        if (i != 21) {
            return null;
        }
        return RuntimeMessage$RequestCase.c;
    }

    public final RuntimeMessage$ResponseCase i0() {
        int i = this.responseCase_;
        if (i == 0) {
            return RuntimeMessage$ResponseCase.c;
        }
        if (i == 50) {
            return RuntimeMessage$ResponseCase.f4254a;
        }
        if (i != 60) {
            return null;
        }
        return RuntimeMessage$ResponseCase.b;
    }

    public final long j0() {
        return this.timestamp_;
    }

    public final boolean k0() {
        return this.responseCase_ == 60;
    }

    public final boolean l0() {
        return this.requestCase_ == 20;
    }

    public final boolean m0() {
        return this.requestCase_ == 10;
    }

    public final boolean n0() {
        return this.responseCase_ == 50;
    }

    public final boolean o0() {
        return this.requestCase_ == 21;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0001<\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\n<\u0000\u0014<\u0000\u0015<\u00002<\u0001<<\u0001", new Object[]{"request_", "requestCase_", "response_", "responseCase_", "id_", "timestamp_", l.class, C1774j.class, s.class, o.class, C1773i.class});
            case 3:
                return new w();
            case 4:
                return new RuntimeMessage$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (w.class) {
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
