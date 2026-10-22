package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.ModelCallPostHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class D extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 9;
    private static final D DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 7;
    public static final int INPUT_TOKENS_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int MODEL_NAME_FIELD_NUMBER = 1;
    public static final int OUTPUT_TOKENS_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 2;
    public static final int RESPONSE_TEXT_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 8;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    private long durationMs_;
    private int inputTokens_;
    private int outputTokens_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String modelName_ = "";
    private String provider_ = "";
    private String responseText_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";

    static {
        D d = new D();
        DEFAULT_INSTANCE = d;
        GeneratedMessageLite.C(D.class, d);
    }

    public static void D(D d) {
        d.getClass();
        d.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(D d) {
        d.durationMs_ = 0L;
    }

    public static void F(D d) {
        d.inputTokens_ = 0;
    }

    public static void G(D d) {
        d.getClass();
        d.modelName_ = DEFAULT_INSTANCE.modelName_;
    }

    public static void H(D d) {
        d.outputTokens_ = 0;
    }

    public static void I(D d) {
        d.getClass();
        d.provider_ = DEFAULT_INSTANCE.provider_;
    }

    public static void J(D d) {
        d.getClass();
        d.responseText_ = DEFAULT_INSTANCE.responseText_;
    }

    public static void K(D d) {
        d.getClass();
        d.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void L(D d) {
        d.success_ = false;
    }

    public static MapFieldLite M(D d) {
        MapFieldLite<String, String> mapFieldLite = d.metadata_;
        if (!mapFieldLite.f2856a) {
            d.metadata_ = mapFieldLite.h();
        }
        return d.metadata_;
    }

    public static void N(D d, String str) {
        d.getClass();
        str.getClass();
        d.agentId_ = str;
    }

    public static void O(D d, ByteString byteString) {
        d.getClass();
        AbstractC0932e.g(byteString);
        d.agentId_ = byteString.q();
    }

    public static void P(D d, long j5) {
        d.durationMs_ = j5;
    }

    public static void Q(D d, int i) {
        d.inputTokens_ = i;
    }

    public static void R(D d, String str) {
        d.getClass();
        str.getClass();
        d.modelName_ = str;
    }

    public static void S(D d, ByteString byteString) {
        d.getClass();
        AbstractC0932e.g(byteString);
        d.modelName_ = byteString.q();
    }

    public static void T(D d, int i) {
        d.outputTokens_ = i;
    }

    public static void U(D d, String str) {
        d.getClass();
        str.getClass();
        d.provider_ = str;
    }

    public static void V(D d, ByteString byteString) {
        d.getClass();
        AbstractC0932e.g(byteString);
        d.provider_ = byteString.q();
    }

    public static void W(D d, String str) {
        d.getClass();
        str.getClass();
        d.responseText_ = str;
    }

    public static void X(D d, ByteString byteString) {
        d.getClass();
        AbstractC0932e.g(byteString);
        d.responseText_ = byteString.q();
    }

    public static void Y(D d, String str) {
        d.getClass();
        str.getClass();
        d.sessionId_ = str;
    }

    public static void Z(D d, ByteString byteString) {
        d.getClass();
        AbstractC0932e.g(byteString);
        d.sessionId_ = byteString.q();
    }

    public static void a0(D d, boolean z10) {
        d.success_ = z10;
    }

    public static D e0() {
        return DEFAULT_INSTANCE;
    }

    public static ModelCallPostHookData$Builder s0(D d) {
        return (ModelCallPostHookData$Builder) DEFAULT_INSTANCE.q(d);
    }

    public final String c0() {
        return this.agentId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.agentId_);
    }

    public final long f0() {
        return this.durationMs_;
    }

    public final int g0() {
        return this.inputTokens_;
    }

    public final Map h0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String i0() {
        return this.modelName_;
    }

    public final ByteString j0() {
        return ByteString.f(this.modelName_);
    }

    public final int k0() {
        return this.outputTokens_;
    }

    public final String l0() {
        return this.provider_;
    }

    public final ByteString m0() {
        return ByteString.f(this.provider_);
    }

    public final String n0() {
        return this.responseText_;
    }

    public final ByteString o0() {
        return ByteString.f(this.responseText_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0004\u0006\u0004\u0007\u0002\bȈ\tȈ\n2", new Object[]{"modelName_", "provider_", "success_", "responseText_", "inputTokens_", "outputTokens_", "durationMs_", "sessionId_", "agentId_", "metadata_", C.f5582a});
            case 3:
                return new D();
            case 4:
                return new ModelCallPostHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (D.class) {
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
}
