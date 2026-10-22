package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogNotification$Builder;
import com.zyql.protobuf.runtime.AgentTaskStateNotification$Builder;
import com.zyql.protobuf.runtime.InputMessageStateNotification$Builder;
import com.zyql.protobuf.runtime.LLMResponse$Builder;
import com.zyql.protobuf.runtime.Task$Builder;
import com.zyql.protobuf.runtime.Task$OutputCase;
import com.zyql.protobuf.runtime.TaskError$Builder;
import q7.C1825x;

/* loaded from: classes2.dex */
public final class r extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_TASK_STATE_FIELD_NUMBER = 6;
    private static final r DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INPUT_MESSAGE_STATE_FIELD_NUMBER = 7;
    public static final int LLM_RESPONSE_FIELD_NUMBER = 5;
    public static final int LOG_NOTIFICATION_FIELD_NUMBER = 9;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_ERROR_FIELD_NUMBER = 8;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private Object output_;
    private long timestamp_;
    private int outputCase_ = 0;
    private String id_ = "";

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        GeneratedMessageLite.C(r.class, rVar);
    }

    public static void D(r rVar) {
        if (rVar.outputCase_ == 6) {
            rVar.outputCase_ = 0;
            rVar.output_ = null;
        }
    }

    public static void E(r rVar) {
        rVar.getClass();
        rVar.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void F(r rVar) {
        if (rVar.outputCase_ == 7) {
            rVar.outputCase_ = 0;
            rVar.output_ = null;
        }
    }

    public static void G(r rVar) {
        if (rVar.outputCase_ == 5) {
            rVar.outputCase_ = 0;
            rVar.output_ = null;
        }
    }

    public static void H(r rVar) {
        if (rVar.outputCase_ == 9) {
            rVar.outputCase_ = 0;
            rVar.output_ = null;
        }
    }

    public static void I(r rVar) {
        rVar.outputCase_ = 0;
        rVar.output_ = null;
    }

    public static void J(r rVar) {
        if (rVar.outputCase_ == 8) {
            rVar.outputCase_ = 0;
            rVar.output_ = null;
        }
    }

    public static void K(r rVar) {
        rVar.timestamp_ = 0L;
    }

    public static void L(r rVar, C2042a c2042a) {
        rVar.getClass();
        c2042a.getClass();
        if (rVar.outputCase_ != 6 || rVar.output_ == C2042a.K()) {
            rVar.output_ = c2042a;
        } else {
            rVar.output_ = ((AgentTaskStateNotification$Builder) C2042a.Q((C2042a) rVar.output_).mergeFrom((GeneratedMessageLite) c2042a)).m();
        }
        rVar.outputCase_ = 6;
    }

    public static void M(r rVar, i iVar) {
        rVar.getClass();
        iVar.getClass();
        if (rVar.outputCase_ != 7 || rVar.output_ == i.K()) {
            rVar.output_ = iVar;
        } else {
            rVar.output_ = ((InputMessageStateNotification$Builder) i.Q((i) rVar.output_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        rVar.outputCase_ = 7;
    }

    public static void N(r rVar, j jVar) {
        rVar.getClass();
        jVar.getClass();
        if (rVar.outputCase_ != 5 || rVar.output_ == j.T()) {
            rVar.output_ = jVar;
        } else {
            rVar.output_ = ((LLMResponse$Builder) j.f0((j) rVar.output_).mergeFrom((GeneratedMessageLite) jVar)).m();
        }
        rVar.outputCase_ = 5;
    }

    public static void O(r rVar, C1825x c1825x) {
        rVar.getClass();
        c1825x.getClass();
        if (rVar.outputCase_ != 9 || rVar.output_ == C1825x.K()) {
            rVar.output_ = c1825x;
        } else {
            rVar.output_ = ((LogNotification$Builder) C1825x.P((C1825x) rVar.output_).mergeFrom((GeneratedMessageLite) c1825x)).m();
        }
        rVar.outputCase_ = 9;
    }

    public static void P(r rVar, s sVar) {
        rVar.getClass();
        sVar.getClass();
        if (rVar.outputCase_ != 8 || rVar.output_ == s.K()) {
            rVar.output_ = sVar;
        } else {
            rVar.output_ = ((TaskError$Builder) s.N((s) rVar.output_).mergeFrom((GeneratedMessageLite) sVar)).m();
        }
        rVar.outputCase_ = 8;
    }

    public static void Q(r rVar, C2042a c2042a) {
        rVar.getClass();
        c2042a.getClass();
        rVar.output_ = c2042a;
        rVar.outputCase_ = 6;
    }

    public static void R(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.id_ = str;
    }

    public static void S(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.id_ = byteString.q();
    }

    public static void T(r rVar, i iVar) {
        rVar.getClass();
        iVar.getClass();
        rVar.output_ = iVar;
        rVar.outputCase_ = 7;
    }

    public static void U(r rVar, j jVar) {
        rVar.getClass();
        jVar.getClass();
        rVar.output_ = jVar;
        rVar.outputCase_ = 5;
    }

    public static void V(r rVar, C1825x c1825x) {
        rVar.getClass();
        c1825x.getClass();
        rVar.output_ = c1825x;
        rVar.outputCase_ = 9;
    }

    public static void W(r rVar, s sVar) {
        rVar.getClass();
        sVar.getClass();
        rVar.output_ = sVar;
        rVar.outputCase_ = 8;
    }

    public static void X(r rVar, long j5) {
        rVar.timestamp_ = j5;
    }

    public static r a0() {
        return DEFAULT_INSTANCE;
    }

    public static Task$Builder o0(r rVar) {
        return (Task$Builder) DEFAULT_INSTANCE.q(rVar);
    }

    public final C2042a Z() {
        return this.outputCase_ == 6 ? (C2042a) this.output_ : C2042a.K();
    }

    public final String b0() {
        return this.id_;
    }

    public final ByteString c0() {
        return ByteString.f(this.id_);
    }

    public final i d0() {
        return this.outputCase_ == 7 ? (i) this.output_ : i.K();
    }

    public final j e0() {
        return this.outputCase_ == 5 ? (j) this.output_ : j.T();
    }

    public final C1825x f0() {
        return this.outputCase_ == 9 ? (C1825x) this.output_ : C1825x.K();
    }

    public final Task$OutputCase g0() {
        int i = this.outputCase_;
        if (i == 0) {
            return Task$OutputCase.f;
        }
        switch (i) {
            case 5:
                return Task$OutputCase.f4278a;
            case 6:
                return Task$OutputCase.b;
            case 7:
                return Task$OutputCase.c;
            case 8:
                return Task$OutputCase.d;
            case 9:
                return Task$OutputCase.e;
            default:
                return null;
        }
    }

    public final s h0() {
        return this.outputCase_ == 8 ? (s) this.output_ : s.K();
    }

    public final long i0() {
        return this.timestamp_;
    }

    public final boolean j0() {
        return this.outputCase_ == 6;
    }

    public final boolean k0() {
        return this.outputCase_ == 7;
    }

    public final boolean l0() {
        return this.outputCase_ == 5;
    }

    public final boolean m0() {
        return this.outputCase_ == 9;
    }

    public final boolean n0() {
        return this.outputCase_ == 8;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\t\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0003\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000", new Object[]{"output_", "outputCase_", "id_", "timestamp_", j.class, C2042a.class, i.class, s.class, C1825x.class});
            case 3:
                return new r();
            case 4:
                return new Task$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (r.class) {
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
