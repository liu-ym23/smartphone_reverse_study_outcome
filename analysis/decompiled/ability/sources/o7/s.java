package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.InvokeHookTask$Builder;
import com.zyql.protobuf.agent.InvokeHookTask$HookDataCase;
import com.zyql.protobuf.common.AgentCompleteHookData$Builder;
import com.zyql.protobuf.common.AgentStartHookData$Builder;
import com.zyql.protobuf.common.HandoffPostHookData$Builder;
import com.zyql.protobuf.common.HandoffPreHookData$Builder;
import com.zyql.protobuf.common.MessagePostHookData$Builder;
import com.zyql.protobuf.common.MessagePreHookData$Builder;
import com.zyql.protobuf.common.ModelCallPostHookData$Builder;
import com.zyql.protobuf.common.ModelCallPreHookData$Builder;
import com.zyql.protobuf.common.SessionEndHookData$Builder;
import com.zyql.protobuf.common.SessionStartHookData$Builder;
import com.zyql.protobuf.common.ToolCallErrorHookData$Builder;
import com.zyql.protobuf.common.ToolCallPostHookData$Builder;
import com.zyql.protobuf.common.ToolCallPreHookData$Builder;
import q7.C1804b;
import q7.C1806d;
import q7.C1813k;
import q7.C1815m;
import q7.C1827z;
import q7.D;
import q7.F;
import q7.K;
import q7.M;
import q7.a0;
import q7.c0;
import q7.e0;

/* loaded from: classes2.dex */
public final class s extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_COMPLETE_FIELD_NUMBER = 41;
    public static final int AGENT_START_FIELD_NUMBER = 40;
    private static final s DEFAULT_INSTANCE;
    public static final int HANDOFF_POST_FIELD_NUMBER = 51;
    public static final int HANDOFF_PRE_FIELD_NUMBER = 50;
    public static final int MESSAGE_POST_FIELD_NUMBER = 61;
    public static final int MESSAGE_PRE_FIELD_NUMBER = 60;
    public static final int MODEL_CALL_POST_FIELD_NUMBER = 31;
    public static final int MODEL_CALL_PRE_FIELD_NUMBER = 30;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_END_FIELD_NUMBER = 11;
    public static final int SESSION_START_FIELD_NUMBER = 10;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TOOL_CALL_ERROR_FIELD_NUMBER = 22;
    public static final int TOOL_CALL_POST_FIELD_NUMBER = 21;
    public static final int TOOL_CALL_PRE_FIELD_NUMBER = 20;
    private Object hookData_;
    private int hookDataCase_ = 0;
    private String taskId_ = "";

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        GeneratedMessageLite.C(s.class, sVar);
    }

    public static void D(s sVar) {
        if (sVar.hookDataCase_ == 41) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void E(s sVar) {
        if (sVar.hookDataCase_ == 40) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void F(s sVar) {
        if (sVar.hookDataCase_ == 51) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void G(s sVar) {
        if (sVar.hookDataCase_ == 50) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void H(s sVar) {
        sVar.hookDataCase_ = 0;
        sVar.hookData_ = null;
    }

    public static void I(s sVar) {
        if (sVar.hookDataCase_ == 61) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void J(s sVar) {
        if (sVar.hookDataCase_ == 60) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void K(s sVar) {
        if (sVar.hookDataCase_ == 31) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void L(s sVar) {
        if (sVar.hookDataCase_ == 30) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void M(s sVar) {
        if (sVar.hookDataCase_ == 11) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void N(s sVar) {
        if (sVar.hookDataCase_ == 10) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void O(s sVar) {
        sVar.getClass();
        sVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void P(s sVar) {
        if (sVar.hookDataCase_ == 22) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void Q(s sVar) {
        if (sVar.hookDataCase_ == 21) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void R(s sVar) {
        if (sVar.hookDataCase_ == 20) {
            sVar.hookDataCase_ = 0;
            sVar.hookData_ = null;
        }
    }

    public static void S(s sVar, C1804b c1804b) {
        sVar.getClass();
        c1804b.getClass();
        if (sVar.hookDataCase_ != 41 || sVar.hookData_ == C1804b.c0()) {
            sVar.hookData_ = c1804b;
        } else {
            sVar.hookData_ = ((AgentCompleteHookData$Builder) C1804b.m0((C1804b) sVar.hookData_).mergeFrom((GeneratedMessageLite) c1804b)).m();
        }
        sVar.hookDataCase_ = 41;
    }

    public static void T(s sVar, C1806d c1806d) {
        sVar.getClass();
        c1806d.getClass();
        if (sVar.hookDataCase_ != 40 || sVar.hookData_ == C1806d.Z()) {
            sVar.hookData_ = c1806d;
        } else {
            sVar.hookData_ = ((AgentStartHookData$Builder) C1806d.g0((C1806d) sVar.hookData_).mergeFrom((GeneratedMessageLite) c1806d)).m();
        }
        sVar.hookDataCase_ = 40;
    }

    public static void U(s sVar, C1813k c1813k) {
        sVar.getClass();
        c1813k.getClass();
        if (sVar.hookDataCase_ != 51 || sVar.hookData_ == C1813k.S()) {
            sVar.hookData_ = c1813k;
        } else {
            sVar.hookData_ = ((HandoffPostHookData$Builder) C1813k.c0((C1813k) sVar.hookData_).mergeFrom((GeneratedMessageLite) c1813k)).m();
        }
        sVar.hookDataCase_ = 51;
    }

    public static void V(s sVar, C1815m c1815m) {
        sVar.getClass();
        c1815m.getClass();
        if (sVar.hookDataCase_ != 50 || sVar.hookData_ == C1815m.S()) {
            sVar.hookData_ = c1815m;
        } else {
            sVar.hookData_ = ((HandoffPreHookData$Builder) C1815m.b0((C1815m) sVar.hookData_).mergeFrom((GeneratedMessageLite) c1815m)).m();
        }
        sVar.hookDataCase_ = 50;
    }

    public static void W(s sVar, C1827z c1827z) {
        sVar.getClass();
        c1827z.getClass();
        if (sVar.hookDataCase_ != 61 || sVar.hookData_ == C1827z.Z()) {
            sVar.hookData_ = c1827z;
        } else {
            sVar.hookData_ = ((MessagePostHookData$Builder) C1827z.h0((C1827z) sVar.hookData_).mergeFrom((GeneratedMessageLite) c1827z)).m();
        }
        sVar.hookDataCase_ = 61;
    }

    public static void X(s sVar, q7.B b) {
        sVar.getClass();
        b.getClass();
        if (sVar.hookDataCase_ != 60 || sVar.hookData_ == q7.B.V()) {
            sVar.hookData_ = b;
        } else {
            sVar.hookData_ = ((MessagePreHookData$Builder) q7.B.b0((q7.B) sVar.hookData_).mergeFrom((GeneratedMessageLite) b)).m();
        }
        sVar.hookDataCase_ = 60;
    }

    public static void Y(s sVar, D d) {
        sVar.getClass();
        d.getClass();
        if (sVar.hookDataCase_ != 31 || sVar.hookData_ == D.e0()) {
            sVar.hookData_ = d;
        } else {
            sVar.hookData_ = ((ModelCallPostHookData$Builder) D.s0((D) sVar.hookData_).mergeFrom((GeneratedMessageLite) d)).m();
        }
        sVar.hookDataCase_ = 31;
    }

    public static void Z(s sVar, F f) {
        sVar.getClass();
        f.getClass();
        if (sVar.hookDataCase_ != 30 || sVar.hookData_ == F.a0()) {
            sVar.hookData_ = f;
        } else {
            sVar.hookData_ = ((ModelCallPreHookData$Builder) F.l0((F) sVar.hookData_).mergeFrom((GeneratedMessageLite) f)).m();
        }
        sVar.hookDataCase_ = 30;
    }

    public static InvokeHookTask$Builder Z0(s sVar) {
        return (InvokeHookTask$Builder) DEFAULT_INSTANCE.q(sVar);
    }

    public static void a0(s sVar, K k) {
        sVar.getClass();
        k.getClass();
        if (sVar.hookDataCase_ != 11 || sVar.hookData_ == K.P()) {
            sVar.hookData_ = k;
        } else {
            sVar.hookData_ = ((SessionEndHookData$Builder) K.X((K) sVar.hookData_).mergeFrom((GeneratedMessageLite) k)).m();
        }
        sVar.hookDataCase_ = 11;
    }

    public static void b0(s sVar, M m) {
        sVar.getClass();
        m.getClass();
        if (sVar.hookDataCase_ != 10 || sVar.hookData_ == M.Y()) {
            sVar.hookData_ = m;
        } else {
            sVar.hookData_ = ((SessionStartHookData$Builder) M.e0((M) sVar.hookData_).mergeFrom((GeneratedMessageLite) m)).m();
        }
        sVar.hookDataCase_ = 10;
    }

    public static void c0(s sVar, a0 a0Var) {
        sVar.getClass();
        a0Var.getClass();
        if (sVar.hookDataCase_ != 22 || sVar.hookData_ == a0.h0()) {
            sVar.hookData_ = a0Var;
        } else {
            sVar.hookData_ = ((ToolCallErrorHookData$Builder) a0.t0((a0) sVar.hookData_).mergeFrom((GeneratedMessageLite) a0Var)).m();
        }
        sVar.hookDataCase_ = 22;
    }

    public static void d0(s sVar, c0 c0Var) {
        sVar.getClass();
        c0Var.getClass();
        if (sVar.hookDataCase_ != 21 || sVar.hookData_ == c0.l0()) {
            sVar.hookData_ = c0Var;
        } else {
            sVar.hookData_ = ((ToolCallPostHookData$Builder) c0.w0((c0) sVar.hookData_).mergeFrom((GeneratedMessageLite) c0Var)).m();
        }
        sVar.hookDataCase_ = 21;
    }

    public static void e0(s sVar, e0 e0Var) {
        sVar.getClass();
        e0Var.getClass();
        if (sVar.hookDataCase_ != 20 || sVar.hookData_ == e0.Z()) {
            sVar.hookData_ = e0Var;
        } else {
            sVar.hookData_ = ((ToolCallPreHookData$Builder) e0.g0((e0) sVar.hookData_).mergeFrom((GeneratedMessageLite) e0Var)).m();
        }
        sVar.hookDataCase_ = 20;
    }

    public static void f0(s sVar, C1804b c1804b) {
        sVar.getClass();
        c1804b.getClass();
        sVar.hookData_ = c1804b;
        sVar.hookDataCase_ = 41;
    }

    public static void g0(s sVar, C1806d c1806d) {
        sVar.getClass();
        c1806d.getClass();
        sVar.hookData_ = c1806d;
        sVar.hookDataCase_ = 40;
    }

    public static void h0(s sVar, C1813k c1813k) {
        sVar.getClass();
        c1813k.getClass();
        sVar.hookData_ = c1813k;
        sVar.hookDataCase_ = 51;
    }

    public static void i0(s sVar, C1815m c1815m) {
        sVar.getClass();
        c1815m.getClass();
        sVar.hookData_ = c1815m;
        sVar.hookDataCase_ = 50;
    }

    public static void j0(s sVar, C1827z c1827z) {
        sVar.getClass();
        c1827z.getClass();
        sVar.hookData_ = c1827z;
        sVar.hookDataCase_ = 61;
    }

    public static void k0(s sVar, q7.B b) {
        sVar.getClass();
        b.getClass();
        sVar.hookData_ = b;
        sVar.hookDataCase_ = 60;
    }

    public static void l0(s sVar, D d) {
        sVar.getClass();
        d.getClass();
        sVar.hookData_ = d;
        sVar.hookDataCase_ = 31;
    }

    public static void m0(s sVar, F f) {
        sVar.getClass();
        f.getClass();
        sVar.hookData_ = f;
        sVar.hookDataCase_ = 30;
    }

    public static void n0(s sVar, K k) {
        sVar.getClass();
        k.getClass();
        sVar.hookData_ = k;
        sVar.hookDataCase_ = 11;
    }

    public static void o0(s sVar, M m) {
        sVar.getClass();
        m.getClass();
        sVar.hookData_ = m;
        sVar.hookDataCase_ = 10;
    }

    public static void p0(s sVar, String str) {
        sVar.getClass();
        str.getClass();
        sVar.taskId_ = str;
    }

    public static void q0(s sVar, ByteString byteString) {
        sVar.getClass();
        AbstractC0932e.g(byteString);
        sVar.taskId_ = byteString.q();
    }

    public static void r0(s sVar, a0 a0Var) {
        sVar.getClass();
        a0Var.getClass();
        sVar.hookData_ = a0Var;
        sVar.hookDataCase_ = 22;
    }

    public static void s0(s sVar, c0 c0Var) {
        sVar.getClass();
        c0Var.getClass();
        sVar.hookData_ = c0Var;
        sVar.hookDataCase_ = 21;
    }

    public static void t0(s sVar, e0 e0Var) {
        sVar.getClass();
        e0Var.getClass();
        sVar.hookData_ = e0Var;
        sVar.hookDataCase_ = 20;
    }

    public static s x0() {
        return DEFAULT_INSTANCE;
    }

    public final InvokeHookTask$HookDataCase A0() {
        int i = this.hookDataCase_;
        if (i == 0) {
            return InvokeHookTask$HookDataCase.n;
        }
        if (i == 10) {
            return InvokeHookTask$HookDataCase.f4251a;
        }
        if (i == 11) {
            return InvokeHookTask$HookDataCase.b;
        }
        if (i == 30) {
            return InvokeHookTask$HookDataCase.f;
        }
        if (i == 31) {
            return InvokeHookTask$HookDataCase.g;
        }
        if (i == 40) {
            return InvokeHookTask$HookDataCase.h;
        }
        if (i == 41) {
            return InvokeHookTask$HookDataCase.i;
        }
        if (i == 50) {
            return InvokeHookTask$HookDataCase.f4252j;
        }
        if (i == 51) {
            return InvokeHookTask$HookDataCase.k;
        }
        if (i == 60) {
            return InvokeHookTask$HookDataCase.l;
        }
        if (i == 61) {
            return InvokeHookTask$HookDataCase.m;
        }
        switch (i) {
            case 20:
                return InvokeHookTask$HookDataCase.c;
            case 21:
                return InvokeHookTask$HookDataCase.d;
            case 22:
                return InvokeHookTask$HookDataCase.e;
            default:
                return null;
        }
    }

    public final C1827z B0() {
        return this.hookDataCase_ == 61 ? (C1827z) this.hookData_ : C1827z.Z();
    }

    public final q7.B C0() {
        return this.hookDataCase_ == 60 ? (q7.B) this.hookData_ : q7.B.V();
    }

    public final D D0() {
        return this.hookDataCase_ == 31 ? (D) this.hookData_ : D.e0();
    }

    public final F E0() {
        return this.hookDataCase_ == 30 ? (F) this.hookData_ : F.a0();
    }

    public final K F0() {
        return this.hookDataCase_ == 11 ? (K) this.hookData_ : K.P();
    }

    public final M G0() {
        return this.hookDataCase_ == 10 ? (M) this.hookData_ : M.Y();
    }

    public final String H0() {
        return this.taskId_;
    }

    public final ByteString I0() {
        return ByteString.f(this.taskId_);
    }

    public final a0 J0() {
        return this.hookDataCase_ == 22 ? (a0) this.hookData_ : a0.h0();
    }

    public final c0 K0() {
        return this.hookDataCase_ == 21 ? (c0) this.hookData_ : c0.l0();
    }

    public final e0 L0() {
        return this.hookDataCase_ == 20 ? (e0) this.hookData_ : e0.Z();
    }

    public final boolean M0() {
        return this.hookDataCase_ == 41;
    }

    public final boolean N0() {
        return this.hookDataCase_ == 40;
    }

    public final boolean O0() {
        return this.hookDataCase_ == 51;
    }

    public final boolean P0() {
        return this.hookDataCase_ == 50;
    }

    public final boolean Q0() {
        return this.hookDataCase_ == 61;
    }

    public final boolean R0() {
        return this.hookDataCase_ == 60;
    }

    public final boolean S0() {
        return this.hookDataCase_ == 31;
    }

    public final boolean T0() {
        return this.hookDataCase_ == 30;
    }

    public final boolean U0() {
        return this.hookDataCase_ == 11;
    }

    public final boolean V0() {
        return this.hookDataCase_ == 10;
    }

    public final boolean W0() {
        return this.hookDataCase_ == 22;
    }

    public final boolean X0() {
        return this.hookDataCase_ == 21;
    }

    public final boolean Y0() {
        return this.hookDataCase_ == 20;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u000e\u0001\u0000\u0001=\u000e\u0000\u0000\u0000\u0001Ȉ\n<\u0000\u000b<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u001e<\u0000\u001f<\u0000(<\u0000)<\u00002<\u00003<\u0000<<\u0000=<\u0000", new Object[]{"hookData_", "hookDataCase_", "taskId_", M.class, K.class, e0.class, c0.class, a0.class, F.class, D.class, C1806d.class, C1804b.class, C1815m.class, C1813k.class, q7.B.class, C1827z.class});
            case 3:
                return new s();
            case 4:
                return new InvokeHookTask$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (s.class) {
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

    public final C1804b v0() {
        return this.hookDataCase_ == 41 ? (C1804b) this.hookData_ : C1804b.c0();
    }

    public final C1806d w0() {
        return this.hookDataCase_ == 40 ? (C1806d) this.hookData_ : C1806d.Z();
    }

    public final C1813k y0() {
        return this.hookDataCase_ == 51 ? (C1813k) this.hookData_ : C1813k.S();
    }

    public final C1815m z0() {
        return this.hookDataCase_ == 50 ? (C1815m) this.hookData_ : C1815m.S();
    }
}
