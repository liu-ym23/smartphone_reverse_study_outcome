package o7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.AgentTool$Builder;
import com.zyql.protobuf.agent.McpTool$Builder;
import com.zyql.protobuf.agent.ToolDefinition$Builder;
import com.zyql.protobuf.agent.ToolDefinition$ToolCase;
import com.zyql.protobuf.agent.ToolProvider$Builder;

/* loaded from: classes2.dex */
public final class z extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_TOOL_FIELD_NUMBER = 1;
    private static final z DEFAULT_INSTANCE;
    public static final int MCP_TOOL_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TOOL_PROVIDER_FIELD_NUMBER = 2;
    private int toolCase_ = 0;
    private Object tool_;

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        GeneratedMessageLite.C(z.class, zVar);
    }

    public static void D(z zVar) {
        if (zVar.toolCase_ == 1) {
            zVar.toolCase_ = 0;
            zVar.tool_ = null;
        }
    }

    public static void E(z zVar) {
        if (zVar.toolCase_ == 3) {
            zVar.toolCase_ = 0;
            zVar.tool_ = null;
        }
    }

    public static void F(z zVar) {
        zVar.toolCase_ = 0;
        zVar.tool_ = null;
    }

    public static void G(z zVar) {
        if (zVar.toolCase_ == 2) {
            zVar.toolCase_ = 0;
            zVar.tool_ = null;
        }
    }

    public static void H(z zVar, C1767c c1767c) {
        zVar.getClass();
        c1767c.getClass();
        if (zVar.toolCase_ != 1 || zVar.tool_ == C1767c.N()) {
            zVar.tool_ = c1767c;
        } else {
            zVar.tool_ = ((AgentTool$Builder) C1767c.U((C1767c) zVar.tool_).mergeFrom((GeneratedMessageLite) c1767c)).m();
        }
        zVar.toolCase_ = 1;
    }

    public static void I(z zVar, t tVar) {
        zVar.getClass();
        tVar.getClass();
        if (zVar.toolCase_ != 3 || zVar.tool_ == t.E()) {
            zVar.tool_ = tVar;
        } else {
            zVar.tool_ = ((McpTool$Builder) t.F((t) zVar.tool_).mergeFrom((GeneratedMessageLite) tVar)).m();
        }
        zVar.toolCase_ = 3;
    }

    public static void J(z zVar, C1764C c1764c) {
        zVar.getClass();
        c1764c.getClass();
        if (zVar.toolCase_ != 2 || zVar.tool_ == C1764C.S()) {
            zVar.tool_ = c1764c;
        } else {
            zVar.tool_ = ((ToolProvider$Builder) C1764C.h0((C1764C) zVar.tool_).mergeFrom((GeneratedMessageLite) c1764c)).m();
        }
        zVar.toolCase_ = 2;
    }

    public static void K(z zVar, C1767c c1767c) {
        zVar.getClass();
        c1767c.getClass();
        zVar.tool_ = c1767c;
        zVar.toolCase_ = 1;
    }

    public static void L(z zVar, t tVar) {
        zVar.getClass();
        tVar.getClass();
        zVar.tool_ = tVar;
        zVar.toolCase_ = 3;
    }

    public static void M(z zVar, C1764C c1764c) {
        zVar.getClass();
        c1764c.getClass();
        zVar.tool_ = c1764c;
        zVar.toolCase_ = 2;
    }

    public final C1767c O() {
        return this.toolCase_ == 1 ? (C1767c) this.tool_ : C1767c.N();
    }

    public final t P() {
        return this.toolCase_ == 3 ? (t) this.tool_ : t.E();
    }

    public final ToolDefinition$ToolCase Q() {
        int i = this.toolCase_;
        if (i == 0) {
            return ToolDefinition$ToolCase.d;
        }
        if (i == 1) {
            return ToolDefinition$ToolCase.f4256a;
        }
        if (i == 2) {
            return ToolDefinition$ToolCase.b;
        }
        if (i != 3) {
            return null;
        }
        return ToolDefinition$ToolCase.c;
    }

    public final C1764C R() {
        return this.toolCase_ == 2 ? (C1764C) this.tool_ : C1764C.S();
    }

    public final boolean S() {
        return this.toolCase_ == 1;
    }

    public final boolean T() {
        return this.toolCase_ == 3;
    }

    public final boolean U() {
        return this.toolCase_ == 2;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"tool_", "toolCase_", C1767c.class, C1764C.class, t.class});
            case 3:
                return new z();
            case 4:
                return new ToolDefinition$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (z.class) {
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
