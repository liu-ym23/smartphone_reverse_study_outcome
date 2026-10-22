package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.ToolCallErrorHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a0 extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 8;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTEXT_FIELD_NUMBER = 9;
    private static final a0 DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 6;
    public static final int ERROR_CODE_FIELD_NUMBER = 5;
    public static final int ERROR_FIELD_NUMBER = 4;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 7;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private long durationMs_;
    private MapFieldLite<String, String> context_ = MapFieldLite.b;
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String error_ = "";
    private String errorCode_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    static {
        a0 a0Var = new a0();
        DEFAULT_INSTANCE = a0Var;
        GeneratedMessageLite.C(a0.class, a0Var);
    }

    public static void D(a0 a0Var) {
        a0Var.getClass();
        a0Var.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(a0 a0Var) {
        a0Var.getClass();
        a0Var.argumentsJson_ = DEFAULT_INSTANCE.argumentsJson_;
    }

    public static void F(a0 a0Var) {
        a0Var.durationMs_ = 0L;
    }

    public static void G(a0 a0Var) {
        a0Var.getClass();
        a0Var.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void H(a0 a0Var) {
        a0Var.getClass();
        a0Var.errorCode_ = DEFAULT_INSTANCE.errorCode_;
    }

    public static void I(a0 a0Var) {
        a0Var.getClass();
        a0Var.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(a0 a0Var) {
        a0Var.getClass();
        a0Var.toolCallId_ = DEFAULT_INSTANCE.toolCallId_;
    }

    public static void K(a0 a0Var) {
        a0Var.getClass();
        a0Var.toolName_ = DEFAULT_INSTANCE.toolName_;
    }

    public static MapFieldLite L(a0 a0Var) {
        MapFieldLite<String, String> mapFieldLite = a0Var.context_;
        if (!mapFieldLite.f2856a) {
            a0Var.context_ = mapFieldLite.h();
        }
        return a0Var.context_;
    }

    public static void M(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.agentId_ = str;
    }

    public static void N(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.agentId_ = byteString.q();
    }

    public static void O(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.argumentsJson_ = str;
    }

    public static void P(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.argumentsJson_ = byteString.q();
    }

    public static void Q(a0 a0Var, long j5) {
        a0Var.durationMs_ = j5;
    }

    public static void R(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.error_ = str;
    }

    public static void S(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.error_ = byteString.q();
    }

    public static void T(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.errorCode_ = str;
    }

    public static void U(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.errorCode_ = byteString.q();
    }

    public static void V(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.sessionId_ = str;
    }

    public static void W(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.sessionId_ = byteString.q();
    }

    public static void X(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.toolCallId_ = str;
    }

    public static void Y(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.toolCallId_ = byteString.q();
    }

    public static void Z(a0 a0Var, String str) {
        a0Var.getClass();
        str.getClass();
        a0Var.toolName_ = str;
    }

    public static void a0(a0 a0Var, ByteString byteString) {
        a0Var.getClass();
        AbstractC0932e.g(byteString);
        a0Var.toolName_ = byteString.q();
    }

    public static a0 h0() {
        return DEFAULT_INSTANCE;
    }

    public static ToolCallErrorHookData$Builder t0(a0 a0Var) {
        return (ToolCallErrorHookData$Builder) DEFAULT_INSTANCE.q(a0Var);
    }

    public final String c0() {
        return this.agentId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.agentId_);
    }

    public final String e0() {
        return this.argumentsJson_;
    }

    public final ByteString f0() {
        return ByteString.f(this.argumentsJson_);
    }

    public final Map g0() {
        return Collections.unmodifiableMap(this.context_);
    }

    public final long i0() {
        return this.durationMs_;
    }

    public final String j0() {
        return this.error_;
    }

    public final ByteString k0() {
        return ByteString.f(this.error_);
    }

    public final String l0() {
        return this.errorCode_;
    }

    public final ByteString m0() {
        return ByteString.f(this.errorCode_);
    }

    public final String n0() {
        return this.sessionId_;
    }

    public final ByteString o0() {
        return ByteString.f(this.sessionId_);
    }

    public final String p0() {
        return this.toolCallId_;
    }

    public final ByteString q0() {
        return ByteString.f(this.toolCallId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0002\u0007Ȉ\bȈ\t2", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "error_", "errorCode_", "durationMs_", "sessionId_", "agentId_", "context_", Z.f5586a});
            case 3:
                return new a0();
            case 4:
                return new ToolCallErrorHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (a0.class) {
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

    public final String r0() {
        return this.toolName_;
    }

    public final ByteString s0() {
        return ByteString.f(this.toolName_);
    }
}
