package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.ToolCallPostHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c0 extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 9;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int CONTEXT_FIELD_NUMBER = 10;
    private static final c0 DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int OUTPUT_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 8;
    public static final int SUCCESS_FIELD_NUMBER = 4;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private long durationMs_;
    private boolean success_;
    private MapFieldLite<String, String> context_ = MapFieldLite.b;
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String output_ = "";
    private String contentType_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    static {
        c0 c0Var = new c0();
        DEFAULT_INSTANCE = c0Var;
        GeneratedMessageLite.C(c0.class, c0Var);
    }

    public static void D(c0 c0Var) {
        c0Var.getClass();
        c0Var.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(c0 c0Var) {
        c0Var.getClass();
        c0Var.argumentsJson_ = DEFAULT_INSTANCE.argumentsJson_;
    }

    public static void F(c0 c0Var) {
        c0Var.getClass();
        c0Var.contentType_ = DEFAULT_INSTANCE.contentType_;
    }

    public static void G(c0 c0Var) {
        c0Var.durationMs_ = 0L;
    }

    public static void H(c0 c0Var) {
        c0Var.getClass();
        c0Var.output_ = DEFAULT_INSTANCE.output_;
    }

    public static void I(c0 c0Var) {
        c0Var.getClass();
        c0Var.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(c0 c0Var) {
        c0Var.success_ = false;
    }

    public static void K(c0 c0Var) {
        c0Var.getClass();
        c0Var.toolCallId_ = DEFAULT_INSTANCE.toolCallId_;
    }

    public static void L(c0 c0Var) {
        c0Var.getClass();
        c0Var.toolName_ = DEFAULT_INSTANCE.toolName_;
    }

    public static MapFieldLite M(c0 c0Var) {
        MapFieldLite<String, String> mapFieldLite = c0Var.context_;
        if (!mapFieldLite.f2856a) {
            c0Var.context_ = mapFieldLite.h();
        }
        return c0Var.context_;
    }

    public static void N(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.agentId_ = str;
    }

    public static void O(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.agentId_ = byteString.q();
    }

    public static void P(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.argumentsJson_ = str;
    }

    public static void Q(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.argumentsJson_ = byteString.q();
    }

    public static void R(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.contentType_ = str;
    }

    public static void S(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.contentType_ = byteString.q();
    }

    public static void T(c0 c0Var, long j5) {
        c0Var.durationMs_ = j5;
    }

    public static void U(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.output_ = str;
    }

    public static void V(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.output_ = byteString.q();
    }

    public static void W(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.sessionId_ = str;
    }

    public static void X(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.sessionId_ = byteString.q();
    }

    public static void Y(c0 c0Var, boolean z10) {
        c0Var.success_ = z10;
    }

    public static void Z(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.toolCallId_ = str;
    }

    public static void a0(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.toolCallId_ = byteString.q();
    }

    public static void b0(c0 c0Var, String str) {
        c0Var.getClass();
        str.getClass();
        c0Var.toolName_ = str;
    }

    public static void c0(c0 c0Var, ByteString byteString) {
        c0Var.getClass();
        AbstractC0932e.g(byteString);
        c0Var.toolName_ = byteString.q();
    }

    public static c0 l0() {
        return DEFAULT_INSTANCE;
    }

    public static ToolCallPostHookData$Builder w0(c0 c0Var) {
        return (ToolCallPostHookData$Builder) DEFAULT_INSTANCE.q(c0Var);
    }

    public final String e0() {
        return this.agentId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.agentId_);
    }

    public final String g0() {
        return this.argumentsJson_;
    }

    public final ByteString h0() {
        return ByteString.f(this.argumentsJson_);
    }

    public final String i0() {
        return this.contentType_;
    }

    public final ByteString j0() {
        return ByteString.f(this.contentType_);
    }

    public final Map k0() {
        return Collections.unmodifiableMap(this.context_);
    }

    public final long m0() {
        return this.durationMs_;
    }

    public final String n0() {
        return this.output_;
    }

    public final ByteString o0() {
        return ByteString.f(this.output_);
    }

    public final String p0() {
        return this.sessionId_;
    }

    public final ByteString q0() {
        return ByteString.f(this.sessionId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007\u0002\bȈ\tȈ\n2", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "success_", "output_", "contentType_", "durationMs_", "sessionId_", "agentId_", "context_", b0.f5588a});
            case 3:
                return new c0();
            case 4:
                return new ToolCallPostHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (c0.class) {
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

    public final boolean r0() {
        return this.success_;
    }

    public final String s0() {
        return this.toolCallId_;
    }

    public final ByteString t0() {
        return ByteString.f(this.toolCallId_);
    }

    public final String u0() {
        return this.toolName_;
    }

    public final ByteString v0() {
        return ByteString.f(this.toolName_);
    }
}
