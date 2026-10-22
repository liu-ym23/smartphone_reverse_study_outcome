package u7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.CancelRequest$Builder;
import com.zyql.protobuf.runtime.ChatRequest$Builder;
import com.zyql.protobuf.runtime.ChatRequest$PayloadCase;
import com.zyql.protobuf.runtime.SendInputRequest$Builder;
import com.zyql.protobuf.runtime.StartAgentRequest$Builder;

/* loaded from: classes2.dex */
public final class d extends GeneratedMessageLite implements Y1 {
    public static final int CANCEL_REQUEST_FIELD_NUMBER = 4;
    private static final d DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SEND_INPUT_REQUEST_FIELD_NUMBER = 3;
    public static final int START_AGENT_REQUEST_FIELD_NUMBER = 2;
    private long id_;
    private int payloadCase_ = 0;
    private Object payload_;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.C(d.class, dVar);
    }

    public static void D(d dVar) {
        if (dVar.payloadCase_ == 4) {
            dVar.payloadCase_ = 0;
            dVar.payload_ = null;
        }
    }

    public static void E(d dVar) {
        dVar.id_ = 0L;
    }

    public static void F(d dVar) {
        dVar.payloadCase_ = 0;
        dVar.payload_ = null;
    }

    public static void G(d dVar) {
        if (dVar.payloadCase_ == 3) {
            dVar.payloadCase_ = 0;
            dVar.payload_ = null;
        }
    }

    public static void H(d dVar) {
        if (dVar.payloadCase_ == 2) {
            dVar.payloadCase_ = 0;
            dVar.payload_ = null;
        }
    }

    public static void I(d dVar, c cVar) {
        dVar.getClass();
        cVar.getClass();
        if (dVar.payloadCase_ != 4 || dVar.payload_ == c.K()) {
            dVar.payload_ = cVar;
        } else {
            dVar.payload_ = ((CancelRequest$Builder) c.P((c) dVar.payload_).mergeFrom((GeneratedMessageLite) cVar)).m();
        }
        dVar.payloadCase_ = 4;
    }

    public static void J(d dVar, o oVar) {
        dVar.getClass();
        oVar.getClass();
        if (dVar.payloadCase_ != 3 || dVar.payload_ == o.Q()) {
            dVar.payload_ = oVar;
        } else {
            dVar.payload_ = ((SendInputRequest$Builder) o.a0((o) dVar.payload_).mergeFrom((GeneratedMessageLite) oVar)).m();
        }
        dVar.payloadCase_ = 3;
    }

    public static void K(d dVar, q qVar) {
        dVar.getClass();
        qVar.getClass();
        if (dVar.payloadCase_ != 2 || dVar.payload_ == q.b0()) {
            dVar.payload_ = qVar;
        } else {
            dVar.payload_ = ((StartAgentRequest$Builder) q.q0((q) dVar.payload_).mergeFrom((GeneratedMessageLite) qVar)).m();
        }
        dVar.payloadCase_ = 2;
    }

    public static void L(d dVar, c cVar) {
        dVar.getClass();
        cVar.getClass();
        dVar.payload_ = cVar;
        dVar.payloadCase_ = 4;
    }

    public static void M(d dVar, long j5) {
        dVar.id_ = j5;
    }

    public static void N(d dVar, o oVar) {
        dVar.getClass();
        oVar.getClass();
        dVar.payload_ = oVar;
        dVar.payloadCase_ = 3;
    }

    public static void O(d dVar, q qVar) {
        dVar.getClass();
        qVar.getClass();
        dVar.payload_ = qVar;
        dVar.payloadCase_ = 2;
    }

    public static ChatRequest$Builder Y() {
        return (ChatRequest$Builder) DEFAULT_INSTANCE.p();
    }

    public final c Q() {
        return this.payloadCase_ == 4 ? (c) this.payload_ : c.K();
    }

    public final long R() {
        return this.id_;
    }

    public final ChatRequest$PayloadCase S() {
        int i = this.payloadCase_;
        if (i == 0) {
            return ChatRequest$PayloadCase.d;
        }
        if (i == 2) {
            return ChatRequest$PayloadCase.f4274a;
        }
        if (i == 3) {
            return ChatRequest$PayloadCase.b;
        }
        if (i != 4) {
            return null;
        }
        return ChatRequest$PayloadCase.c;
    }

    public final o T() {
        return this.payloadCase_ == 3 ? (o) this.payload_ : o.Q();
    }

    public final q U() {
        return this.payloadCase_ == 2 ? (q) this.payload_ : q.b0();
    }

    public final boolean V() {
        return this.payloadCase_ == 4;
    }

    public final boolean W() {
        return this.payloadCase_ == 3;
    }

    public final boolean X() {
        return this.payloadCase_ == 2;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"payload_", "payloadCase_", "id_", q.class, o.class, c.class});
            case 3:
                return new d();
            case 4:
                return new ChatRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (d.class) {
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
