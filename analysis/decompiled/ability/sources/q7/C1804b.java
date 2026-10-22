package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.AgentCompleteHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1804b extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    private static final C1804b DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int OUTPUT_TEXT_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int TURNS_TAKEN_FIELD_NUMBER = 6;
    private long durationMs_;
    private int turnsTaken_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String agentId_ = "";
    private String agentName_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String outputText_ = "";

    static {
        C1804b c1804b = new C1804b();
        DEFAULT_INSTANCE = c1804b;
        GeneratedMessageLite.C(C1804b.class, c1804b);
    }

    public static void D(C1804b c1804b) {
        c1804b.getClass();
        c1804b.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(C1804b c1804b) {
        c1804b.getClass();
        c1804b.agentName_ = DEFAULT_INSTANCE.agentName_;
    }

    public static void F(C1804b c1804b) {
        c1804b.durationMs_ = 0L;
    }

    public static void G(C1804b c1804b) {
        c1804b.getClass();
        c1804b.outputText_ = DEFAULT_INSTANCE.outputText_;
    }

    public static void H(C1804b c1804b) {
        c1804b.getClass();
        c1804b.runId_ = DEFAULT_INSTANCE.runId_;
    }

    public static void I(C1804b c1804b) {
        c1804b.getClass();
        c1804b.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(C1804b c1804b) {
        c1804b.turnsTaken_ = 0;
    }

    public static MapFieldLite K(C1804b c1804b) {
        MapFieldLite<String, String> mapFieldLite = c1804b.metadata_;
        if (!mapFieldLite.f2856a) {
            c1804b.metadata_ = mapFieldLite.h();
        }
        return c1804b.metadata_;
    }

    public static void L(C1804b c1804b, String str) {
        c1804b.getClass();
        str.getClass();
        c1804b.agentId_ = str;
    }

    public static void M(C1804b c1804b, ByteString byteString) {
        c1804b.getClass();
        AbstractC0932e.g(byteString);
        c1804b.agentId_ = byteString.q();
    }

    public static void N(C1804b c1804b, String str) {
        c1804b.getClass();
        str.getClass();
        c1804b.agentName_ = str;
    }

    public static void O(C1804b c1804b, ByteString byteString) {
        c1804b.getClass();
        AbstractC0932e.g(byteString);
        c1804b.agentName_ = byteString.q();
    }

    public static void P(C1804b c1804b, long j5) {
        c1804b.durationMs_ = j5;
    }

    public static void Q(C1804b c1804b, String str) {
        c1804b.getClass();
        str.getClass();
        c1804b.outputText_ = str;
    }

    public static void R(C1804b c1804b, ByteString byteString) {
        c1804b.getClass();
        AbstractC0932e.g(byteString);
        c1804b.outputText_ = byteString.q();
    }

    public static void S(C1804b c1804b, String str) {
        c1804b.getClass();
        str.getClass();
        c1804b.runId_ = str;
    }

    public static void T(C1804b c1804b, ByteString byteString) {
        c1804b.getClass();
        AbstractC0932e.g(byteString);
        c1804b.runId_ = byteString.q();
    }

    public static void U(C1804b c1804b, String str) {
        c1804b.getClass();
        str.getClass();
        c1804b.sessionId_ = str;
    }

    public static void V(C1804b c1804b, ByteString byteString) {
        c1804b.getClass();
        AbstractC0932e.g(byteString);
        c1804b.sessionId_ = byteString.q();
    }

    public static void W(C1804b c1804b, int i) {
        c1804b.turnsTaken_ = i;
    }

    public static C1804b c0() {
        return DEFAULT_INSTANCE;
    }

    public static AgentCompleteHookData$Builder m0(C1804b c1804b) {
        return (AgentCompleteHookData$Builder) DEFAULT_INSTANCE.q(c1804b);
    }

    public final String Y() {
        return this.agentId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.agentId_);
    }

    public final String a0() {
        return this.agentName_;
    }

    public final ByteString b0() {
        return ByteString.f(this.agentName_);
    }

    public final long d0() {
        return this.durationMs_;
    }

    public final Map e0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String f0() {
        return this.outputText_;
    }

    public final ByteString g0() {
        return ByteString.f(this.outputText_);
    }

    public final String h0() {
        return this.runId_;
    }

    public final ByteString i0() {
        return ByteString.f(this.runId_);
    }

    public final String j0() {
        return this.sessionId_;
    }

    public final ByteString k0() {
        return ByteString.f(this.sessionId_);
    }

    public final int l0() {
        return this.turnsTaken_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0002\b2", new Object[]{"agentId_", "agentName_", "sessionId_", "runId_", "outputText_", "turnsTaken_", "durationMs_", "metadata_", AbstractC1803a.f5587a});
            case 3:
                return new C1804b();
            case 4:
                return new AgentCompleteHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1804b.class) {
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
