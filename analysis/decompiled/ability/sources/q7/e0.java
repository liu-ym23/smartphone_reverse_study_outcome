package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.ToolCallPreHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e0 extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 5;
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 3;
    public static final int CONTEXT_FIELD_NUMBER = 6;
    private static final e0 DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 1;
    public static final int TOOL_NAME_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> context_ = MapFieldLite.b;
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        GeneratedMessageLite.C(e0.class, e0Var);
    }

    public static void D(e0 e0Var) {
        e0Var.getClass();
        e0Var.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(e0 e0Var) {
        e0Var.getClass();
        e0Var.argumentsJson_ = DEFAULT_INSTANCE.argumentsJson_;
    }

    public static void F(e0 e0Var) {
        e0Var.getClass();
        e0Var.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(e0 e0Var) {
        e0Var.getClass();
        e0Var.toolCallId_ = DEFAULT_INSTANCE.toolCallId_;
    }

    public static void H(e0 e0Var) {
        e0Var.getClass();
        e0Var.toolName_ = DEFAULT_INSTANCE.toolName_;
    }

    public static MapFieldLite I(e0 e0Var) {
        MapFieldLite<String, String> mapFieldLite = e0Var.context_;
        if (!mapFieldLite.f2856a) {
            e0Var.context_ = mapFieldLite.h();
        }
        return e0Var.context_;
    }

    public static void J(e0 e0Var, String str) {
        e0Var.getClass();
        str.getClass();
        e0Var.agentId_ = str;
    }

    public static void K(e0 e0Var, ByteString byteString) {
        e0Var.getClass();
        AbstractC0932e.g(byteString);
        e0Var.agentId_ = byteString.q();
    }

    public static void L(e0 e0Var, String str) {
        e0Var.getClass();
        str.getClass();
        e0Var.argumentsJson_ = str;
    }

    public static void M(e0 e0Var, ByteString byteString) {
        e0Var.getClass();
        AbstractC0932e.g(byteString);
        e0Var.argumentsJson_ = byteString.q();
    }

    public static void N(e0 e0Var, String str) {
        e0Var.getClass();
        str.getClass();
        e0Var.sessionId_ = str;
    }

    public static void O(e0 e0Var, ByteString byteString) {
        e0Var.getClass();
        AbstractC0932e.g(byteString);
        e0Var.sessionId_ = byteString.q();
    }

    public static void P(e0 e0Var, String str) {
        e0Var.getClass();
        str.getClass();
        e0Var.toolCallId_ = str;
    }

    public static void Q(e0 e0Var, ByteString byteString) {
        e0Var.getClass();
        AbstractC0932e.g(byteString);
        e0Var.toolCallId_ = byteString.q();
    }

    public static void R(e0 e0Var, String str) {
        e0Var.getClass();
        str.getClass();
        e0Var.toolName_ = str;
    }

    public static void S(e0 e0Var, ByteString byteString) {
        e0Var.getClass();
        AbstractC0932e.g(byteString);
        e0Var.toolName_ = byteString.q();
    }

    public static e0 Z() {
        return DEFAULT_INSTANCE;
    }

    public static ToolCallPreHookData$Builder g0(e0 e0Var) {
        return (ToolCallPreHookData$Builder) DEFAULT_INSTANCE.q(e0Var);
    }

    public final String U() {
        return this.agentId_;
    }

    public final ByteString V() {
        return ByteString.f(this.agentId_);
    }

    public final String W() {
        return this.argumentsJson_;
    }

    public final ByteString X() {
        return ByteString.f(this.argumentsJson_);
    }

    public final Map Y() {
        return Collections.unmodifiableMap(this.context_);
    }

    public final String a0() {
        return this.sessionId_;
    }

    public final ByteString b0() {
        return ByteString.f(this.sessionId_);
    }

    public final String c0() {
        return this.toolCallId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.toolCallId_);
    }

    public final String e0() {
        return this.toolName_;
    }

    public final ByteString f0() {
        return ByteString.f(this.toolName_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"toolCallId_", "toolName_", "argumentsJson_", "sessionId_", "agentId_", "context_", d0.f5590a});
            case 3:
                return new e0();
            case 4:
                return new ToolCallPreHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (e0.class) {
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
