package o7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.TokenUsage$Builder;

/* loaded from: classes2.dex */
public final class y extends GeneratedMessageLite implements Y1 {
    public static final int COMPLETION_TOKENS_FIELD_NUMBER = 2;
    private static final y DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PROMPT_TOKENS_FIELD_NUMBER = 1;
    public static final int TOTAL_TOKENS_FIELD_NUMBER = 3;
    private int completionTokens_;
    private int promptTokens_;
    private int totalTokens_;

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        GeneratedMessageLite.C(y.class, yVar);
    }

    public static void D(y yVar) {
        yVar.completionTokens_ = 0;
    }

    public static void E(y yVar) {
        yVar.promptTokens_ = 0;
    }

    public static void F(y yVar) {
        yVar.totalTokens_ = 0;
    }

    public static void G(y yVar, int i) {
        yVar.completionTokens_ = i;
    }

    public static void H(y yVar, int i) {
        yVar.promptTokens_ = i;
    }

    public static void I(y yVar, int i) {
        yVar.totalTokens_ = i;
    }

    public static y L() {
        return DEFAULT_INSTANCE;
    }

    public static TokenUsage$Builder O(y yVar) {
        return (TokenUsage$Builder) DEFAULT_INSTANCE.q(yVar);
    }

    public final int K() {
        return this.completionTokens_;
    }

    public final int M() {
        return this.promptTokens_;
    }

    public final int N() {
        return this.totalTokens_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"promptTokens_", "completionTokens_", "totalTokens_"});
            case 3:
                return new y();
            case 4:
                return new TokenUsage$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (y.class) {
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
