package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.AgentStartHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1806d extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    public static final int CONTEXT_FIELD_NUMBER = 6;
    private static final C1806d DEFAULT_INSTANCE;
    public static final int INPUT_TEXT_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> context_ = MapFieldLite.b;
    private String agentId_ = "";
    private String agentName_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String inputText_ = "";

    static {
        C1806d c1806d = new C1806d();
        DEFAULT_INSTANCE = c1806d;
        GeneratedMessageLite.C(C1806d.class, c1806d);
    }

    public static void D(C1806d c1806d) {
        c1806d.getClass();
        c1806d.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(C1806d c1806d) {
        c1806d.getClass();
        c1806d.agentName_ = DEFAULT_INSTANCE.agentName_;
    }

    public static void F(C1806d c1806d) {
        c1806d.getClass();
        c1806d.inputText_ = DEFAULT_INSTANCE.inputText_;
    }

    public static void G(C1806d c1806d) {
        c1806d.getClass();
        c1806d.runId_ = DEFAULT_INSTANCE.runId_;
    }

    public static void H(C1806d c1806d) {
        c1806d.getClass();
        c1806d.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static MapFieldLite I(C1806d c1806d) {
        MapFieldLite<String, String> mapFieldLite = c1806d.context_;
        if (!mapFieldLite.f2856a) {
            c1806d.context_ = mapFieldLite.h();
        }
        return c1806d.context_;
    }

    public static void J(C1806d c1806d, String str) {
        c1806d.getClass();
        str.getClass();
        c1806d.agentId_ = str;
    }

    public static void K(C1806d c1806d, ByteString byteString) {
        c1806d.getClass();
        AbstractC0932e.g(byteString);
        c1806d.agentId_ = byteString.q();
    }

    public static void L(C1806d c1806d, String str) {
        c1806d.getClass();
        str.getClass();
        c1806d.agentName_ = str;
    }

    public static void M(C1806d c1806d, ByteString byteString) {
        c1806d.getClass();
        AbstractC0932e.g(byteString);
        c1806d.agentName_ = byteString.q();
    }

    public static void N(C1806d c1806d, String str) {
        c1806d.getClass();
        str.getClass();
        c1806d.inputText_ = str;
    }

    public static void O(C1806d c1806d, ByteString byteString) {
        c1806d.getClass();
        AbstractC0932e.g(byteString);
        c1806d.inputText_ = byteString.q();
    }

    public static void P(C1806d c1806d, String str) {
        c1806d.getClass();
        str.getClass();
        c1806d.runId_ = str;
    }

    public static void Q(C1806d c1806d, ByteString byteString) {
        c1806d.getClass();
        AbstractC0932e.g(byteString);
        c1806d.runId_ = byteString.q();
    }

    public static void R(C1806d c1806d, String str) {
        c1806d.getClass();
        str.getClass();
        c1806d.sessionId_ = str;
    }

    public static void S(C1806d c1806d, ByteString byteString) {
        c1806d.getClass();
        AbstractC0932e.g(byteString);
        c1806d.sessionId_ = byteString.q();
    }

    public static C1806d Z() {
        return DEFAULT_INSTANCE;
    }

    public static AgentStartHookData$Builder g0(C1806d c1806d) {
        return (AgentStartHookData$Builder) DEFAULT_INSTANCE.q(c1806d);
    }

    public final String U() {
        return this.agentId_;
    }

    public final ByteString V() {
        return ByteString.f(this.agentId_);
    }

    public final String W() {
        return this.agentName_;
    }

    public final ByteString X() {
        return ByteString.f(this.agentName_);
    }

    public final Map Y() {
        return Collections.unmodifiableMap(this.context_);
    }

    public final String a0() {
        return this.inputText_;
    }

    public final ByteString b0() {
        return ByteString.f(this.inputText_);
    }

    public final String c0() {
        return this.runId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.runId_);
    }

    public final String e0() {
        return this.sessionId_;
    }

    public final ByteString f0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"agentId_", "agentName_", "sessionId_", "runId_", "inputText_", "context_", AbstractC1805c.f5589a});
            case 3:
                return new C1806d();
            case 4:
                return new AgentStartHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1806d.class) {
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
